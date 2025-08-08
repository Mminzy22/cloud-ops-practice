package org.example;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import java.util.List;

public class Consumer {

    public static void main(String[] args) {
        System.out.println("Hello minji");

        SqsClient sqsClient = SqsClient.builder()
                .region(Region.AP_NORTHEAST_2)
                .build();

        String queueUrl = "https://sqs.ap-northeast-2.amazonaws.com/077672914621/go-queue";

        try {
            ReceiveMessageRequest receiveMassageRequest = ReceiveMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .maxNumberOfMessages(10)
                    .waitTimeSeconds(20)
                    .build();

            List<Message> messages = sqsClient.receiveMessage(receiveMassageRequest).messages();

            if(messages.isEmpty()) {
                System.out.println("No messages received.");
            } else {
                for (Message message : messages) {
                    System.out.println("Received message: " + message.body());

                    DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                            .queueUrl(queueUrl)
                            .receiptHandle(message.receiptHandle())
                            .build();

                    sqsClient.deleteMessage(deleteMessageRequest);

                    System.out.println("Delete message ID: " + message.body());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqsClient.close();
        }
    }
}
