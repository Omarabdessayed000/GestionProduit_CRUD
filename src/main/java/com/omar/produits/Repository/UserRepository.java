package com.omar.produits.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.omar.produits.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
