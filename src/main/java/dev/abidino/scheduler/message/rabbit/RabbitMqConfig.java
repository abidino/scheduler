package dev.abidino.scheduler.message.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.excel-queue-name}")
    private String excelQueueName;

    @Value("${spring.rabbitmq.excel-routing-keys}")
    private String excelRoutingKeys;

    @Value("${spring.rabbitmq.csv-queue-name}")
    private String csvQueueName;

    @Value("${spring.rabbitmq.csv-routing-keys}")
    private String csvRoutingKeys;

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    @Bean
    public Queue excelQueue() {
        return new Queue(excelQueueName, false);
    }
    @Bean
    public Binding excelBinding(){
        return BindingBuilder
                .bind(excelQueue())
                .to(exchange())
                .with(excelRoutingKeys);
    }

    @Bean
    public Queue csvQueue() {
        return new Queue(csvQueueName, false);
    }
    @Bean
    public Binding csvBinding(){
        return BindingBuilder
                .bind(csvQueue())
                .to(exchange())
                .with(csvRoutingKeys);
    }
}