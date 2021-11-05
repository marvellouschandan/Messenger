package com.epam.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.security.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);
}
