package com.filipe.projectSpring.repositories;

import com.filipe.projectSpring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
