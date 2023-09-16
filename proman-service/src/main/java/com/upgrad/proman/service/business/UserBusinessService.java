package com.upgrad.proman.service.business;

import com.upgrad.proman.service.dao.UserDao;
import com.upgrad.proman.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordCryptographyProvider cryptographyProvider;
    public UserEntity signup(UserEntity user){
       String[] encrypt = cryptographyProvider.encrypt(user.getPassword());
       user.setSalt(encrypt[0]);
       user.setPassword(encrypt[1]);
       return userDao.save(user);
    }
}
