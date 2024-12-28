package com.mkt.bocd.app.service.user;

import com.mkt.bocd.domain.dto.UserWithAddressDTO;
import com.mkt.bocd.domain.mapstruct.UserAddressMapper;
import com.mkt.bocd.infrastructure.entity.Address;
import com.mkt.bocd.infrastructure.entity.User;
import com.mkt.bocd.infrastructure.repository.AddressRepository;
import com.mkt.bocd.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 15:19
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserAddressMapper userAddressMapper;  // MapStruct Mapper

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserWithAddressDTO getUserAddressById(Long id) {
        User user = userRepository.findById(id);

        Address address = addressRepository.findById(user.getId());


        return userAddressMapper.toUserWithAddressDTO(user, address);
    }
}