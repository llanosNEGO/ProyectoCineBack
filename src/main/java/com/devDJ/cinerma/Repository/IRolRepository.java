package com.devDJ.cinerma.Repository;

import com.devDJ.cinerma.Entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByName(String name);
}
