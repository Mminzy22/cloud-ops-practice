import boto3

# SQS 클라이언트 생성
sqs = boto3.client('sqs', region_name='ap-northeast-2')

queue_url = 'https://sqs.ap-northeast-2.amazonaws.com/077672914621/aram-queue'

# 1. 여러 개 메시지 전송
for i in range(100):
    response = sqs.send_message(
        QueueUrl=queue_url,
        MessageBody=f"Hello I'am minji! - {i+1}"
    )
    print(f"Message {i+1} sent! ID: {response['MessageId']}")

# 2. 메시지 수신
messages = sqs.receive_message(
    QueueUrl=queue_url,
    MaxNumberOfMessages=10,  # 최대 10개까지
    WaitTimeSeconds=5
)

for message in messages.get('Messages', []):
    print(f"Received: {message['Body']}")

    # 3. 메시지 삭제
    sqs.delete_message(
        QueueUrl=queue_url,
        ReceiptHandle=message['ReceiptHandle']
    )
