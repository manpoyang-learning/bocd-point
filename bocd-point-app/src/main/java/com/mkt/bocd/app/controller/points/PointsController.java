package com.mkt.bocd.app.controller.points;

import com.mkt.bocd.app.service.points.PointsService;
import com.mkt.bocd.common.constant.ResultCode;
import com.mkt.bocd.common.response.ResponseResult;
import com.mkt.bocd.domain.dto.points.PointsChangeDTO;
import com.mkt.bocd.domain.entity.points.PointsAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 14:31
 */
@Slf4j
@RestController
@RequestMapping("/api/points")
public class PointsController {
    @Autowired
    private PointsService pointsService;

    @PostMapping("/increase")
    public ResponseResult<Void> increasePoints(@RequestBody @Valid PointsChangeDTO dto) {
        pointsService.increasePoints(dto);
        return ResponseResult.success("积分增加成功");
    }

    @PostMapping("/decrease")
    public ResponseResult<Void> decreasePoints(@RequestBody @Valid PointsChangeDTO dto) {
        pointsService.decreasePoints(dto);
        return ResponseResult.success("积分扣减成功");
    }

    @GetMapping("/{userId}")
    public ResponseResult<PointsAccount> getPoints(@PathVariable Long userId) {
        PointsAccount pointsAccount = pointsService.getPointsByUserId(userId);
        if (pointsAccount == null) {
            return ResponseResult.fail(ResultCode.SERVICE_UNAVAILABLE.getCode(), "用户不存在");
        }
        return ResponseResult.success(pointsAccount);
    }
}