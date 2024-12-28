package com.mkt.bocd.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.repository.CrudRepository;
import com.mkt.bocd.infrastructure.entity.Address;
import com.mkt.bocd.infrastructure.mapper.AddressMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 17:18
 */

@Repository
public class AddressRepository extends CrudRepository<AddressMapper, Address> {

    public Address findById(Long id) {
        return getBaseMapper().selectById(id);
    }

}
