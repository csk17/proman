package com.upgrad.proman.service.business;

import com.upgrad.proman.service.dao.UserDao;
import com.upgrad.proman.service.entity.UserEntity;
import com.upgrad.proman.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdminBusinessService {
    @Autowired
    private UserDao userDao;

    public UserEntity getUser(String uuid) throws ResourceNotFoundException {
        UserEntity user = userDao.findByuuid(uuid);
        if(user==null){
            throw new ResourceNotFoundException("USR-001","User Not Found");
        }
        else{
            return user;
        }
    }
}