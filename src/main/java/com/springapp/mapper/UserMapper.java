package com.springapp.mapper;

import com.springapp.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */

public interface UserMapper {

        /**
         * 保存用户
         * @param user
         */
        @Insert("insert into user (name, sex, age)  values( #{name}, #{sex}, #{age} )")
        void saveUser(User user);

        /**
         * 获取所有用户列表
         * @return
         */
        @Select("select u.id, u.name, u.sex, u.age from user u   ")
        @Results({
                @Result(id = true, column = "id_c", property = "id"),
                @Result(column = "id", property = "id"),
                @Result(column = "name", property = "name"),
                @Result(column = "sex", property = "sex"),
                @Result(column = "age", property = "age")})
        List<User> getAllUser();

        /**
         * 根据id查询用户信息
         * @param id
         * @return
         */
        @Select("select u.id, u.name, u.sex, u.age from user u  where u.id = #{id}  ")
        @Results({
                @Result(id = true, column = "id_c", property = "id"),
                @Result(column = "id", property = "id"),
                @Result(column = "name", property = "name"),
                @Result(column = "sex", property = "sex"),
                @Result(column = "age", property = "age")})
        User getUserById(Integer id);

        /**
         * 更新用户的名称
         * @param user
         */
        @Update(" update user set name = #{name} where id = #{id} ")
        void renameUser(User user);

        /**
         * 根据id删除指定的用户
         * @param id
         */
        @Delete(" delete from user where id = #{id}  ")
        void deleteUserById(Integer id);
}
