package com.filipe.projectSpring.repositories;

import com.filipe.projectSpring.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
