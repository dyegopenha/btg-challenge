package com.example.btg_challenge.factory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.math.BigDecimal;
import java.util.List;

import com.example.btg_challenge.entity.OrderEntity;
import com.example.btg_challenge.entity.OrderItem;

public class OrderEntityFactory {

   public static OrderEntity build() {
      var items = new OrderItem("notebook", 1, BigDecimal.valueOf(20.50));

      var entity = new OrderEntity();
      entity.setOrderId(1L);
      entity.setCustomerId(2L);
      entity.setTotal(BigDecimal.valueOf(20.50));
      entity.setItems(List.of(items));

      return entity;
   }

   public static Page<OrderEntity> buildWithPage() {
      return new PageImpl<>(List.of(build()));
   }
}
