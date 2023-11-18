package com.fag.thomas.springbalho.thomasUsers.repositories;

import com.fag.thomas.springbalho.thomasUsers.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<User> searchByNameIgnoreCase(@Param("query") String query);
}
