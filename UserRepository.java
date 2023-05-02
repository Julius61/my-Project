package com.jully.user_management.repository;

import com.jully.user_management.entity.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Scholarship, Long> {
}
