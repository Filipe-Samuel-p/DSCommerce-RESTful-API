package com.filipe.projectSpring.repositories;

import com.filipe.projectSpring.Entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
