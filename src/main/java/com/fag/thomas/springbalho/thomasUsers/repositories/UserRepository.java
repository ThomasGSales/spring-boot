package com.fag.thomas.springbalho.thomasUsers.repositories;

import com.fag.thomas.springbalho.thomasUsers.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface UserRepository extends JpaRepository<User, Long> {

}
