package com.filipe.projectSpring.repositories;

import com.filipe.projectSpring.model.OrderItem;
import com.filipe.projectSpring.model.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
