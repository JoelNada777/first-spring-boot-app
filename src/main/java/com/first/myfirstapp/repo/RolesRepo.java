package com.first.myfirstapp.repo;

import com.first.myfirstapp.models.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepo extends JpaRepository<Roles,Long> {
    Optional<Roles> findByName(String name);
}
