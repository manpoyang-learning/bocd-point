package com.mkt.bocd.app.controller.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mkt.bocd.app.service.user.UserService;
import com.mkt.bocd.common.response.ResponseResult;
import com.mkt.bocd.domain.dto.UserWithAddressDTO;
import com.mkt.bocd.infrastructure.entity.User;
import com.mkt.bocd.infrastructure.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/28 16:10
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class TestUserController {

    //注入UserService
    @Autowired
    private UserService userService;

    //根据输入的ID查询用户
    @GetMapping("/getUserById")
    public ResponseResult<User> getUserById(Long id) {
        // 调用 UserService 的 getUserById 方法，传入 ID
        User user = userService.getUserById(id);

        // 包装成统一的 ResponseResult
        return ResponseResult.success(user);  // 包装返回 User 数据
    }

    @GetMapping("/getUserById2")
    public ResponseResult<UserWithAddressDTO> getUserById2(Long id) {
        // 调用 UserService 的 getUserById 方法，传入 ID
        User user = userService.getUserById(id);
        UserWithAddressDTO userWithAddressDTO = userService.getUserAddressById(id);
        // 包装成统一的 ResponseResult
        return ResponseResult.success(userWithAddressDTO);  // 包装返回 User 数据
    }


    @GetMapping("/users")
    public ResponseResult<Page<User>> getUsers(@RequestParam("current") int current, @RequestParam("size") int size) {

        return ResponseResult.success(userService.getUsersByPage(current, size));
    }





}
