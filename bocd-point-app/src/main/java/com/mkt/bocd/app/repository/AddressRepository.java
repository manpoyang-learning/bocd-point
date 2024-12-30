package com.mkt.bocd.app.repository;

import com.baomidou.mybatisplus.extension.repository.CrudRepository;
import com.mkt.bocd.domain.entity.Address;
import com.mkt.bocd.app.mapper.AddressMapper;
import org.springframework.stereotype.Repository;

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
