package com.distributedlibrary.central.repository;

import com.distributedlibrary.central.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT u.id FROM users u WHERE u.jmbg = ?1")
    UUID findByJmbg(String jmbg);
}
