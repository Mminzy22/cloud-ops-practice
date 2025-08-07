# Project09 - AWS Lambda 기반 웹 크롤링 & S3 저장 실습

## 📌 개요

이 실습은 AWS Lambda를 활용해 `https://land.naver.com/` 페이지의 HTML을 크롤링하고, Amazon S3 버킷에 저장하는 과정을 다룹니다.
추가적으로, Lambda Layer를 이용해 공통 라이브러리를 분리 관리하는 방법도 실습했습니다.

---

## 🛠 사용 서비스 및 기술

* **AWS Lambda** (Python 3.x)
* **Amazon S3**
* **Amazon CloudWatch Logs**
* **AWS Lambda Layer**
* **Python 라이브러리**: `requests`, `boto3`

---

## 📂 디렉토리 구조

```
project09/
└── lambda-crawler/
    ├── lambda_function.py
    ├── requests/                  # pip install -t . 로 복사된 패키지
    └── lambda_function.zip         # Lambda에 업로드할 패키지 파일
```

---

## 📝 실습 내용

### 1. S3 버킷 생성

* 콘솔에서 S3 버킷을 생성 (`예: s3-minji-bucket`)
* 버킷 권한은 기본값(퍼블릭 액세스 차단) 유지

---

### 2. 로컬 환경에서 Lambda 코드 작성 및 패키징

```bash
mkdir lambda-crawler
cd lambda-crawler
touch lambda_function.py
pip install requests -t .
```

`lambda_function.py` 예시:

```python
import boto3
import requests
from datetime import datetime

s3 = boto3.client('s3')

def lambda_handler(event, context):
    try:
        url = "https://land.naver.com/"
        headers = {"User-Agent": "Mozilla/5.0"}
        response = requests.get(url, headers=headers)
        response.raise_for_status()
        html = response.text

        now = datetime.utcnow().strftime('%Y-%m-%dT%H-%M-%S')
        key = f"naver-land/land-{now}.html"
        bucket = "s3-minji-bucket"  # 본인 S3 버킷 이름으로 변경

        s3.put_object(
            Bucket=bucket,
            Key=key,
            Body=html,
            ContentType='text/html'
        )

        return {
            "statusCode": 200,
            "body": f"Saved to s3://{bucket}/{key}"
        }

    except Exception as e:
        return {
            "statusCode": 500,
            "body": str(e)
        }
```

패키징:

```bash
zip -r lambda_function.zip .
```

---

### 3. Lambda 함수 생성

* 런타임: **Python 3.x**
* 배포 패키지: `lambda_function.zip`
* 핸들러: `lambda_function.lambda_handler`

---

### 4. IAM 역할 및 권한 설정

* CloudWatch Logs 권한
* S3 업로드 권한 (실습에서는 전체 권한 부여했지만, 실제 환경에서는 최소 권한 권장)

예시 정책:

```json
{
  "Effect": "Allow",
  "Action": "S3:*",
  "Resource": "*"
}
```

---

### 5. Lambda 대상 추가

* 테스트 이벤트 또는 EventBridge 규칙을 통해 주기 실행 가능

---

### 6. 실행 및 결과 확인

* Lambda 테스트 실행 시 S3 버킷에 `naver-land/land-YYYY-MM-DDTHH-MM-SS.html` 파일 생성
* CloudWatch Logs에서 실행 로그 확인 가능

---

## 📦 Lambda Layer 활용

### 📍 사용 목적

* 여러 Lambda 함수에서 동일한 라이브러리(`requests`, `pandas`, `numpy` 등)를 재사용
* 대용량 라이브러리를 분리해 코드 크기 축소
* 라이브러리 관리 편의성 향상

### 📍 생성 방법 요약

1. 로컬 또는 AWS CloudShell에서 라이브러리 설치

   ```bash
   mkdir python
   pip install requests -t python/
   zip -r requests-layer.zip python
   ```

   > `zip` 루트에 **python/** 폴더가 있어야 함

2. Lambda 콘솔 → **\[레이어] → \[레이어 생성]**

    * 이름: `requests-layer`
    * 업로드: `requests-layer.zip`
    * 런타임: Python 3.x

3. Lambda 함수 → **\[구성] → \[레이어 추가]**

4. 코드에서 그대로 `import requests` 사용 가능

---

## ✅ 정리

* **Lambda 함수**로 HTML 크롤링 및 S3 저장
* **IAM 역할**로 CloudWatch Logs & S3 접근 권한 부여
* **Lambda Layer**로 외부 라이브러리 재사용 구조 구성
