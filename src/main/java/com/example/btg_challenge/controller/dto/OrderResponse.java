package com.example.btg_challenge.controller.dto;

import java.math.BigDecimal;

import com.example.btg_challenge.entity.OrderEntity;

public record OrderResponse(Long orderId,
                            Long customerId,
                            BigDecimal total) {

   public static OrderResponse fromEntity(OrderEntity entity) {
      return new OrderResponse(entity.getOrderId(), entity.getCustomerId(), entity.getTotal());
   }
}
