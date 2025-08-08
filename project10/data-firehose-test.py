import boto3
import json

firehose = boto3.client('firehose')

data = {
    "event": "user_click",
    "user_id": "minji-123",
    "timestamp": "2025-08-07T12:00:00Z"
}

response = firehose.put_record(
    DeliveryStreamName='PUT-S3-minji',
    Record={'Data': json.dumps(data) + '\n'}
)

print(response)
