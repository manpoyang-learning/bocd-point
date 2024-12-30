package com.mkt.bocd.domain.mapstruct;

import com.mkt.bocd.domain.dto.UserWithAddressDTO;
import com.mkt.bocd.domain.entity.Address;
import com.mkt.bocd.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserAddressMapper {

    // 将 User 和 Address 转换成 UserWithAddressDTO
    public UserWithAddressDTO toUserWithAddressDTO(User user, Address address) {
        // 创建一个新的 DTO 对象
        UserWithAddressDTO dto = new UserWithAddressDTO();

        // 手动映射字段
        if (user != null) {
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setAge(user.getAge());
        }

        if (address != null) {
            dto.setAddress(address.getAddress());
        }

        return dto;
    }
}