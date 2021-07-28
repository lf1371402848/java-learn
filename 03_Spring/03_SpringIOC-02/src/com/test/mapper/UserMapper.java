package com.test.mapper;

import com.test.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //用户登录
    @Select("select * from t_user where uname=#{uname} and pwd=#{pwd}")
    User userLoginMapper(@Param("uname") String uname, @Param("pwd") String pwd);
}
