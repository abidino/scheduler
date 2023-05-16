package dev.abidino.scheduler.message.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public record RabbitListenerService() {

    @RabbitListener(queues = "excel-test")
    public void excelListener(String message){
        System.out.println(message);
    }

    @RabbitListener(queues = "csv-test")
    public void csvListener(String message){
        System.out.println(message);
    }
}
