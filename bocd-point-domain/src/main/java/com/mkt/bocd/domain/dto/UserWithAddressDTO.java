package com.mkt.bocd.domain.dto;


import lombok.Data;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 17:05
 */

@Data
public class UserWithAddressDTO {

    private Long id;
    private String name;
    private Integer age;
    private String address;

    // Getters and Setters
}
