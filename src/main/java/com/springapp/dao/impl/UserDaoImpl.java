package com.springapp.dao.impl;

import com.springapp.dao.UserDao;
import com.springapp.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private com.springapp.mapper.UserMapper mUserMapper;

    @Override
    public void saveUser(User user) {
        mUserMapper.saveUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return mUserMapper.getAllUser();
    }

    @Override
    public User getById(Integer id) {
        return mUserMapper.getUserById(id);
    }

    @Override
    public void rename(User user) {
        mUserMapper.renameUser(user);
    }

    @Override
    public void deleteById(Integer id) {
        mUserMapper.deleteUserById(id);
    }
}
