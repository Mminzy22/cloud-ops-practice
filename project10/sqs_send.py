import boto3

# SQS 클라이언트 생성
sqs = boto3.client('sqs', region_name='ap-northeast-2')

queue_url = 'https://sqs.ap-northeast-2.amazonaws.com/077672914621/aram-queue'

# 1. 메시지 전송
sqs.send_message(
    QueueUrl=queue_url,
    MessageBody="Hello I'am minji!"
)

# 2. 메시지 수신
messages = sqs.receive_message(
    QueueUrl=queue_url,
    MaxNumberOfMessages=1,
    WaitTimeSeconds=5
)

for message in messages.get('Messages', []):
    print(f"Received: {message['Body']}")

    # 3. 메시지 삭제
    sqs.delete_message(
        QueueUrl=queue_url,
        ReceiptHandle=message['ReceiptHandle']
    )
