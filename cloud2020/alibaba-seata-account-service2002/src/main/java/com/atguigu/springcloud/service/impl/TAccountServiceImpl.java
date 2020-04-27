package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.TAccount;
import com.atguigu.springcloud.dao.TAccountDao;
import com.atguigu.springcloud.service.TAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TAccount)表服务实现类
 *
 * @author makejava
 * @since 2020-04-17 16:23:11
 */
@Service("tAccount")
@Transactional
public class TAccountServiceImpl implements TAccountService {
    @Resource
    private TAccountDao tAccountDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 用户id
     * @return 实例对象
     */
    @Override
    public TAccount queryById(String uid) {
        return this.tAccountDao.queryById(uid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TAccount> queryAllByLimit(int offset, int limit) {
        return this.tAccountDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tAccount 实例对象
     * @return 实例对象
     */
    @Override
    public TAccount insert(TAccount tAccount) {
        this.tAccountDao.insert(tAccount);
        return tAccount;
    }

    /**
     * 修改数据
     *
     * @return 实例对象
     */
    @Override
    public TAccount update(String uid, double amount) {
        TAccount tAccount = new TAccount();
        tAccount.setUserId(uid);
        tAccount.setAmount(amount);
        this.tAccountDao.update(tAccount);
        return this.queryById(tAccount.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tAccountDao.deleteById(id) > 0;
    }
}