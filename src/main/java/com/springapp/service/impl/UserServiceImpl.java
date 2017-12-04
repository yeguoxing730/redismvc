package com.springapp.service.impl;

import com.springapp.dao.UserDao;
import com.springapp.entity.User;
import com.springapp.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao mUserDao;

    @Override
    @CacheEvict(value = { "saveUser"}, allEntries = true)
    public void saveUser(String name, String sex, Integer age) {
        System.out.println("save a new user....");
        User user = new User(name, sex, age);
        mUserDao.saveUser(user);
    }

    @Override
    @Cacheable("getAllUser")
    public List<User> getAllUser() {
        System.out.println("get all user....");
        return mUserDao.getAllUser();
    }

    @Override
    @Cacheable("getUserById")
    public User getUserById(Integer id) {
        System.out.println("get user by id...."+id);
        return mUserDao.getById(id);
    }

    @Override
    @CacheEvict(value = { "getAllUser", "getUserById" }, allEntries = true)
    public void renameUser(String name, Integer id) {
        System.out.println("rename user name ...."+id+":"+name);
        mUserDao.rename(new User(id, name));
    }

    @Override
    @CacheEvict(value = { "getAllUser", "getUserById" }, allEntries = true)
    public void deleteUserById(Integer id) {
        System.out.println("delete a  user name ...."+id);
        mUserDao.deleteById(id);
    }
}
