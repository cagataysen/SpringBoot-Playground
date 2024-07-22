package com.dopdisc.demo.repositories;

import com.dopdisc.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
