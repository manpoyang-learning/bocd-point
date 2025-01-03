package com.mkt.bocd.app.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.repository.CrudRepository;
import com.mkt.bocd.domain.entity.User;
import com.mkt.bocd.app.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 15:15
 */

@Component
public class UserRepository extends CrudRepository<UserMapper, User> {

    public List<User> findByUsername(String username) {
        return getBaseMapper().selectList(
                new QueryWrapper<User>().eq("username", username)
        );
    }

    public User findById(Long id) {
        return getBaseMapper().selectById(id);
    }



}
