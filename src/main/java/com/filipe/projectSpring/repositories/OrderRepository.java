package com.filipe.projectSpring.repositories;

import com.filipe.projectSpring.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
