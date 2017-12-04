package com.springapp.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("testService")
public class TestService {
    @Cacheable(value = "User", key = "'UserId_' + #id")
    public String queryFullNameById(long id) {
        System.out.println("execute queryFullNameById method");
        return "ZhangSanFeng";
    }

    @CacheEvict(value = "User", key = "'UserId_' + #id")
    public void deleteById(long id) {
        System.out.println("execute deleteById method");
    }

    @CachePut(value = "User", key = "'UserId_' + #id")
    public String modifyFullNameById(long id, String newName) {
        System.out.println("execute modifyFullNameById method");
        return newName;
    }
}
