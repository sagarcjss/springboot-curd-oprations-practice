package com.cjss.repo;

import com.cjss.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, String> {
    public Optional<Users> findByEmail(String email);
    public Optional<Users> findByEmailAndMobileNum(String email, String mobileNum);
}
