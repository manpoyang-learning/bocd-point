package com.mkt.bocd.app.repository.points;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.repository.CrudRepository;
import com.mkt.bocd.domain.entity.points.PointsAccount;
import com.mkt.bocd.app.mapper.points.PointsAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author manpoyang
 * @version 1.0
 * @date 2024/12/29 14:20
 */
@Repository
public class PointsAccountRepository extends CrudRepository<PointsAccountMapper, PointsAccount> {
    private final RedisTemplate<String, Object> redisTemplate;
    private static final String POINTS_KEY_PREFIX = "points:account:";
    private static final long CACHE_TIMEOUT = 30L;

    // 添加构造器，处理父类的构造和RedisTemplate的注入
    public PointsAccountRepository(PointsAccountMapper baseMapper, RedisTemplate<String, Object> redisTemplate) {
        super();
        this.redisTemplate = redisTemplate;
    }



    // 使用悲观锁查询账户
    public PointsAccount getByUserIdForUpdate(Long userId) {
        return getBaseMapper().selectOne(
                Wrappers.<PointsAccount>lambdaQuery()
                        .eq(PointsAccount::getUserId, userId)
                        .last("FOR UPDATE")
        );
    }

    // 使用乐观锁更新账户积分
    public boolean updatePoints(Long userId, Long points, Integer version) {
        return getBaseMapper().update(null,
                Wrappers.<PointsAccount>lambdaUpdate()
                        .set(PointsAccount::getPoints, points)
                        .eq(PointsAccount::getUserId, userId)
                        .eq(PointsAccount::getVersion, version)
        ) > 0;
    }

    public PointsAccount getByUserId(Long userId) {
        // 先查缓存
        String key = POINTS_KEY_PREFIX + userId;
        PointsAccount pointsAccount = (PointsAccount) redisTemplate.opsForValue().get(key);

        if (pointsAccount != null) {
            return pointsAccount;
        }

        // 缓存未命中，查询数据库
        pointsAccount = getBaseMapper().selectOne(
                Wrappers.<PointsAccount>lambdaQuery()
                        .eq(PointsAccount::getUserId, userId)
        );

        // 将数据库结果放入缓存
        if (pointsAccount != null) {
            redisTemplate.opsForValue().set(key, pointsAccount, CACHE_TIMEOUT, TimeUnit.MINUTES);
        }

        return pointsAccount;
    }
}
