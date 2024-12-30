package com.mkt.bocd.app.repository.points;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.repository.CrudRepository;
import com.mkt.bocd.app.mapper.points.PointsMallProductMapper;
import com.mkt.bocd.domain.entity.points.PointsMallProduct;
import com.mkt.bocd.domain.dto.points.ProductQueryDTO;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 22:52
 */
public class PointsMallProductRepository extends CrudRepository<PointsMallProductMapper, PointsMallProduct> {

    public Page<PointsMallProduct> queryProducts(ProductQueryDTO queryDTO) {
        LambdaQueryWrapper<PointsMallProduct> wrapper = new LambdaQueryWrapper<>();

        // 构建查询条件
        wrapper.like(StringUtils.isNotBlank(queryDTO.getName()), PointsMallProduct::getName, queryDTO.getName())
                .eq(queryDTO.getStatus() != null, PointsMallProduct::getStatus, queryDTO.getStatus())
                .ge(queryDTO.getMinPoints() != null, PointsMallProduct::getPointsPrice, queryDTO.getMinPoints())
                .le(queryDTO.getMaxPoints() != null, PointsMallProduct::getPointsPrice, queryDTO.getMaxPoints())
                .orderByDesc(PointsMallProduct::getCreateTime);

        // 执行分页查询
        Page<PointsMallProduct> page = new Page<>(queryDTO.getPage(), queryDTO.getSize());
        return baseMapper.selectPage(page, wrapper);
    }
}
