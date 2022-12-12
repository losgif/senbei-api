package com.losgif.senbeiapi.mappers;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.losgif.senbeiapi.entities.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM users WHERE email = #{email} and password = #{password}")
    User selectByEmailAndPassword(String email, String password);
}
