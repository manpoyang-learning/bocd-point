package com.mkt.bocd.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 15:16
 */
@Data
@TableName("`user`")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;


}
