import boto3

sqs = boto3.client('sqs', region_name='ap-northeast-2')

queue_url = 'https://sqs.ap-northeast-2.amazonaws.com/077672914621/go-queue'

while True:
    messages = sqs.receive_message(
        QueueUrl=queue_url,
        MaxNumberOfMessages=10,  # 최대 10개씩
        WaitTimeSeconds=2
    )

    if 'Messages' not in messages:
        print("더 이상 메시지가 없습니다.")
        break

    for message in messages['Messages']:
        print(f"Received: {message['Body']}")

        sqs.delete_message(
            QueueUrl=queue_url,
            ReceiptHandle=message['ReceiptHandle']
        )