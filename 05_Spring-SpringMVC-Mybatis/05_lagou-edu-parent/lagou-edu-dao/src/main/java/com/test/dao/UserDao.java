package com.test.dao;

import com.test.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2022-09-17 17:18:14
 */
@Service
public interface UserDao {

    /**
     * 通过登录
     *
     * @param phone
     * @param password
     * @return 实例对象
     */
    User login(@Param("phone") String phone, @Param("password") String password);

    /**
     *
     * @param phone
     * @return 1:已注册 0：未注册
     */
    Integer checkPhone(@Param("phone") String phone);

    /**
     * 注册
     * @param phone
     * @param password
     * @return
     */
    Integer register(@Param("nickname") String nickname,@Param("phone") String phone, @Param("password") String password);
}

