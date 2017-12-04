package com.springapp.dao;

import com.springapp.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 获取所有用户列表
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getById(Integer id);

    /**
     * 更新用户的名称
     * @param user
     */
    void rename(User user);

    /**
     * 根据id删除指定的用户
     * @param id
     */
    void deleteById(Integer id);
}
