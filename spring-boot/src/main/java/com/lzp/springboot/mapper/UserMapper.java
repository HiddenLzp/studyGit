package com.lzp.springboot.mapper;

import com.lzp.springboot.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserMapper
 *
 * @authorHmLzp
 * @create 2019 - 01 - 30 10:03
 */
@Repository
public interface UserMapper {

    @Select("SELECT * FROM user")
    public List<User> getUsers();
    @Select("SELECT * FROM user WHERE id = #{id}")
    public User getUserById(Integer id);
}
