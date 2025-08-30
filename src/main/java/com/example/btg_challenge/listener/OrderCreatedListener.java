package com.example.btg_challenge.listener;

import static com.example.btg_challenge.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.example.btg_challenge.listener.dto.OrderCreatedEvent;
import com.example.btg_challenge.service.OrderService;

@Component
public class OrderCreatedListener {

   private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

   private final OrderService orderService;

   public OrderCreatedListener(OrderService orderService) {
      this.orderService = orderService;
   }

   @RabbitListener(queues = ORDER_CREATED_QUEUE)
   public void listen(Message<OrderCreatedEvent> message){
      logger.info("Message consumed: {}", message);

      orderService.save(message.getPayload());
   }
}
