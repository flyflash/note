package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.TOrderDao;
import com.atguigu.springcloud.entities.TOrder;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.StorageService;
import com.atguigu.springcloud.service.TOrderService;
//import io.seata.spring.annotation.GlobalTransactional;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-04-17 15:58:22
 */

@Slf4j
@Service(value = "orderService")
public class TOrderServiceImpl implements TOrderService {

    @Resource
    private TOrderDao tOrderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TOrder queryById(Integer id) {
        return this.tOrderDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TOrder> queryAllByLimit(int offset, int limit) {
        return this.tOrderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tOrder 实例对象
     */
    @Override
    @GlobalTransactional(name = "fsp-order-create", rollbackFor = Exception.class)
    public void insert(TOrder tOrder) {
        log.info("------->开始创建订单");
        log.info("------------------------->oderService: tOrder={}", tOrder);
        this.tOrderDao.insert(tOrder);

        log.info("----------->订单微服务调用库存微服务，扣减库存");
        storageService.decr(tOrder.getCommodityCode(), tOrder.getCount());

        log.info("----------->订单微服务调用账户微服务，扣减余额");
        accountService.decr(tOrder.getUserId(), tOrder.getAmount());

    }

    /**
     * 修改数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TOrder update(TOrder tOrder) {
        this.tOrderDao.update(tOrder);
        return this.queryById(tOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tOrderDao.deleteById(id) > 0;
    }
}