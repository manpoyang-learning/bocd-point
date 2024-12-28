package com.mkt.bocd.infrastructure.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Address)表实体类
 *
 * @author manpoyang
 * @since 2024-12-28 16:59:29
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("address")
public class Address  {
    //主键ID@TableId
    private Long id;

    //用户ID
    private Long userId;
    //地址
    private String address;

}