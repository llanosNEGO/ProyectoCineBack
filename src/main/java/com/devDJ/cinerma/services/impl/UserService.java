package com.devDJ.cinerma.services.impl;

import com.devDJ.cinerma.Entities.User;
import com.devDJ.cinerma.Repository.IGenericRepo;
import com.devDJ.cinerma.Repository.IUserRepository;
import com.devDJ.cinerma.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService extends GenericService<User,Integer> implements IUserService {
    private final IUserRepository repo;
    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }
}
