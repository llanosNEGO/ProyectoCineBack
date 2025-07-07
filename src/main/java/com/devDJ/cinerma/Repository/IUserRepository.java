package com.devDJ.cinerma.Repository;

import com.devDJ.cinerma.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends IGenericRepo<User, Integer> {
    User findOneByUsername(String username);

    boolean existsByEmail(String email);
}
