package com.springapp.service;

import com.springapp.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    /**
     * 保存用户
     * @param name
     */
    void saveUser(String name, String sex, Integer age);

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
    User getUserById(Integer id);

    /**
     * 更新用户的名称
     * @param name
     * @param id
     */
    void renameUser(String name, Integer id);

    /**
     * 根据id删除指定的用户
     * @param id
     */
    void deleteUserById(Integer id);
}
