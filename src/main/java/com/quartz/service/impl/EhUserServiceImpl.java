package com.quartz.service.impl;

import com.quartz.entity.EhUser;
import com.quartz.dao.EhUserDao;
import com.quartz.service.EhUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EhUser)表服务实现类
 *
 * @author makejava
 * @since 2020-02-13 18:52:18
 */
@Service("ehUserService")
public class EhUserServiceImpl implements EhUserService {
    @Resource
    private EhUserDao ehUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EhUser queryById(String id) {
        return this.ehUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<EhUser> queryAllByLimit(int offset, int limit) {
        return this.ehUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ehUser 实例对象
     * @return 实例对象
     */
    @Override
    public EhUser insert(EhUser ehUser) {
        this.ehUserDao.insert(ehUser);
        return ehUser;
    }

    /**
     * 修改数据
     *
     * @param ehUser 实例对象
     * @return 实例对象
     */
    @Override
    public EhUser update(EhUser ehUser) {
        this.ehUserDao.update(ehUser);
        return this.queryById(ehUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.ehUserDao.deleteById(id) > 0;
    }
}