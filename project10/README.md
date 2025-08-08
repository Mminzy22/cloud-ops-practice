# Project10 - AWS Kinesis Data Firehose 데이터 전송 테스트

## 📌 개요

이 실습은 AWS 관리 콘솔에서 **Kinesis Data Firehose**와 S3 대상 버킷을 미리 생성해 둔 상태에서,  
로컬 환경의 Python 스크립트를 이용해 Firehose로 데이터를 전송하는 과정을 다룹니다.

---

## 🛠 사용 서비스 및 기술

- **AWS Kinesis Data Firehose**
- **Amazon S3**
- **Python 3.x**
- **boto3** (AWS SDK for Python)

---

## 📂 디렉토리 구조

```

project10/
└── data-firehose-test.py    # Firehose로 데이터 전송 테스트 스크립트

````

---

## 📝 사전 준비

1. **AWS Kinesis Data Firehose 생성**  
   - 소스(Source): Direct PUT
   - 대상(Destination): S3 버킷
   - 버킷명 예시: `s3-minji-bucket`

2. **IAM 권한**  
   로컬에서 사용할 자격(AWS CLI 프로필 또는 환경 변수)에 다음 권한이 있어야 함:
   ```json
   {
     "Effect": "Allow",
     "Action": [
       "firehose:PutRecord",
       "firehose:PutRecordBatch",
       "firehose:DescribeDeliveryStream",
       "firehose:ListDeliveryStreams"
     ],
     "Resource": "arn:aws:firehose:ap-northeast-2:<ACCOUNT_ID>:deliverystream/<Firehose이름>"
   }
   ```

3. **AWS CLI 자격 구성**

   ```bash
   aws configure
   # AWS Access Key, Secret Key, Default region (ap-northeast-2) 입력
   ```

4. **Python 라이브러리 설치**

   ```bash
   pip install boto3
   ```

---

## 📄 코드 예시 (`data-firehose-test.py`)

```python
import json
import boto3

firehose = boto3.client('firehose', region_name='ap-northeast-2')

data = {
    "user_id": "minji-123",
    "action": "view_item",
    "timestamp": "2025-08-08T09:00:00Z"
}

response = firehose.put_record(
    DeliveryStreamName="my-firehose-stream",  # Firehose 이름
    Record={
        "Data": (json.dumps(data) + "\n").encode("utf-8")
    }
)

print("Firehose put_record response:", response)
```

---

## 🚀 실행 방법

```bash
# 스크립트 실행
python data-firehose-test.py
```

---

## ✅ 실행 결과 확인

* **Firehose 콘솔** → 해당 Delivery Stream → 모니터링 탭에서 데이터 전송량 확인
* **S3 버킷** → Firehose가 지정한 경로에 업로드된 파일 확인

---

## 📝 주의사항

* Firehose 소스가 **Direct PUT**이 아니고 Kinesis Data Stream 연동 방식이면, `firehose.put_record()`가 아니라 `kinesis.put_record()`를 사용해야 합니다.
* `DeliveryStreamName`은 Firehose 콘솔에 표시되는 정확한 이름과 일치해야 하며, 리전(`region_name`)도 동일해야 합니다.

