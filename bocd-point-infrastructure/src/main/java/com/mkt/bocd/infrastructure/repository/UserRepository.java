package com.mkt.bocd.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.repository.CrudRepository;
import com.mkt.bocd.infrastructure.entity.User;
import com.mkt.bocd.infrastructure.mapper.UserMapper;
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
