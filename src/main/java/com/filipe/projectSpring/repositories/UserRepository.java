package com.filipe.projectSpring.repositories;

import com.filipe.projectSpring.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
