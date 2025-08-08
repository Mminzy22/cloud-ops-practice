# Project10 - AWS Kinesis Data Firehose & SQS/Redis 테스트

## 📌 개요

1. AWS 관리 콘솔에서 **Kinesis Data Firehose(커-니시스 데이터 파이어호스)** 와 S3를 미리 구성해두고, 로컬 **Python(파이썬)** 스크립트로 Firehose에 데이터를 전송하는 과정과
2. **Amazon SQS(에스큐에스)** 로 메시지를 송수신하는 **Python(boto3, 보토 쓰리)** / **Java(자바)** 예제를 포함합니다.
3. 추가로 **Redis(레디스)** 연결/자료구조 조작 예제(**Jedis, 제디스**)를 포함합니다.

---

## 🛠 사용 서비스 및 기술

* **AWS Kinesis Data Firehose**
* **Amazon S3**
* **Amazon SQS**
* **Redis (Amazon ElastiCache for Redis)**
* **Python 3.x + boto3**
* **Java 17 + Gradle(그레이들) + AWS SDK for Java + jedis**

---

## 📂 디렉토리 구조

```bash
project10/
├── data-firehose-test.py            # Firehose로 데이터 전송 테스트 스크립트
├── sqs_send.py                      # SQS: 단일 메시지 전송/수신/삭제
├── sqs_send2.py                     # SQS: 다건 전송(루프), 다건 수신(최대 10개)
├── sqs_send3.py                     # SQS: 메시지 없을 때까지 반복 수신/삭제
└── next-sqs-api/                    # Java SQS/Redis 테스트 Gradle 프로젝트
    ├── build.gradle                 # AWS SDK, jedis 의존성 선언
    └── src/main/java/org/example/
        ├── Main.java                # SQS 프로듀서/컨슈머 예제(테스트용)
        ├── Consumer.java            # SQS 컨슈머 예제(있는 경우)
        └── RedisConnector.java      # Redis 연결 및 자료구조 조작 예제
```

> `.venv/` 등 가상환경은 `.gitignore` 처리(커밋 제외).

---

## 📝 사전 준비

### 1) 공통

* **AWS CLI 자격 구성**

  ```bash
  aws configure
  # Access Key, Secret Key, Default region(ap-northeast-2) 입력
  ```
* **IAM 권한**

  * Firehose, S3, SQS에 대해 아래 액션을 포함하도록 구성 (예시)

  ```json
  {
    "Version": "2012-10-17",
    "Statement": [
      { "Effect": "Allow",
        "Action": ["firehose:PutRecord","firehose:PutRecordBatch","firehose:DescribeDeliveryStream","firehose:ListDeliveryStreams"],
        "Resource": "arn:aws:firehose:ap-northeast-2:<ACCOUNT_ID>:deliverystream/<FIREHOSE_NAME>"
      },
      { "Effect": "Allow",
        "Action": ["sqs:SendMessage","sqs:ReceiveMessage","sqs:DeleteMessage","sqs:GetQueueAttributes"],
        "Resource": "arn:aws:sqs:ap-northeast-2:<ACCOUNT_ID>:<QUEUE_NAME>"
      }
    ]
  }
  ```

### 2) Firehose

* 소스(Source): **Direct PUT**
* 대상(Destination): **S3 버킷**
* 버킷 예시: `s3-minji-bucket`

### 3) SQS

* 표준 큐(Standard) 또는 FIFO 중 택1로 큐 생성
* 큐 URL 확인 (예: `https://sqs.ap-northeast-2.amazonaws.com/<ACCOUNT_ID>/<QUEUE_NAME>`)

### 4) Java/Redis

* **JDK 17** 설치
* 프로젝트 루트에 Gradle Wrapper 포함
* **Redis 엔드포인트/포트** 확인 (예: `xxx.cache.amazonaws.com:6379`)

  * VPC 내부 접근, 보안 그룹 인바운드 허용 필요
  * Redis AUTH 옵션을 쓴다면 `AUTH` 처리 코드 추가 필요

---

## 🔶 Firehose 전송 (Python)

### 코드 예시: `data-firehose-test.py`

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
    Record={"Data": (json.dumps(data) + "\n").encode("utf-8")}
)

print("Firehose put_record response:", response)
```

### 실행

```bash
pip install boto3
python data-firehose-test.py
```

### 결과 확인

* Firehose 콘솔 → Delivery Stream 모니터링
* S3 버킷에 전송 파일 생성 여부 확인

> 주의: Firehose 소스가 **Direct PUT**이 아니고 Kinesis Data Streams 연동이면 `kinesis.put_record()`를 사용해야 합니다.

---

## 🔷 SQS 메시지 송수신 (Python)

### 1) 단건 송수신/삭제: `sqs_send.py`

핵심 포인트

* `send_message()` → `receive_message()` → `delete_message()` 순서
* `WaitTimeSeconds`로 **긴 폴링(Long Polling)** 적용 가능

```python
import boto3

sqs = boto3.client('sqs', region_name='ap-northeast-2')
queue_url = 'https://sqs.ap-northeast-2.amazonaws.com/<ACCOUNT_ID>/aram-queue'

sqs.send_message(QueueUrl=queue_url, MessageBody="Hello I'm minji!")

messages = sqs.receive_message(QueueUrl=queue_url, MaxNumberOfMessages=1, WaitTimeSeconds=5)

for message in messages.get('Messages', []):
    print("Received:", message['Body'])
    sqs.delete_message(QueueUrl=queue_url, ReceiptHandle=message['ReceiptHandle'])
```

### 2) 다건 전송/수신: `sqs_send2.py`

* 루프 전송 / 최대 10개까지 배치 수신

```python
for i in range(100):
    sqs.send_message(QueueUrl=queue_url, MessageBody=f"Hello I'm minji! - {i+1}")
```

### 3) 메시지 없을 때까지 반복 수신: `sqs_send3.py`

* `Messages` 키가 없으면 종료

```python
while True:
    messages = sqs.receive_message(QueueUrl=queue_url, MaxNumberOfMessages=10, WaitTimeSeconds=2)
    if 'Messages' not in messages:
        print("더 이상 메시지가 없습니다.")
        break
    ...
```

---

## 🟩 SQS & Redis (Java, Gradle)

### 의존성 (`next-sqs-api/build.gradle`)

```gradle
dependencies {
    implementation 'software.amazon.awssdk:sqs:2.25.38'   // AWS SDK for Java (SQS)
    implementation 'redis.clients:jedis:5.1.2'            // Redis client (Jedis)
}
```

### 예시 1) Redis 연결/자료구조 조작: `RedisConnector.java`

* Key-Value, Hash, List, Set 사용 예

```java
try (Jedis jedis = new Jedis(redisHost, redisPort)) {
    jedis.set("user:1", "Jaden");
    jedis.hset("user:100", "name", "Alice");
    jedis.lpush("tasks", "task1", "task2");
    jedis.sadd("fruits", "apple", "banana");
    System.out.println(jedis.get("user:1"));
}
```

> 참고: ElastiCache for Redis는 VPC 내부 접근이므로 동일 VPC/보안그룹 설정이 필요합니다. AUTH 사용 시 자격 설정을 추가하십시오.

### 실행

```bash
# 프로젝트 루트에서
./gradlew build
# (필요 시) 애플리케이션 실행 방식은 Main 클래스 구성에 따라 run 설정 추가 또는 IDE 실행
```

---

## 🚀 실행 요약

### Firehose(Python)

```bash
pip install boto3
python data-firehose-test.py
```

### SQS(Python)

```bash
python sqs_send.py      # 단건
python sqs_send2.py     # 다건 전송/수신
python sqs_send3.py     # 반복 수신/삭제
```

### Java

```bash
./gradlew build
# IDE에서 Main/Consumer/RedisConnector 실행 또는 run 설정 추가
```

---

## 🔒 보안/네트워크 주의사항

* **자격 증명**은 프로필/환경변수/자격관리 도구를 사용하고, 코드에 하드코딩하지 않으십시오.
* **Redis(ElastiCache)** 는 퍼블릭 접근이 불가합니다. VPC, 서브넷, 보안그룹, 라우팅을 올바르게 설정해야 합니다.
* **SQS 큐 URL/이름, Firehose 이름**과 **리전**은 코드와 콘솔 설정이 정확히 일치해야 합니다.
