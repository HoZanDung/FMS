package com.cms.service.Impl;

import com.cms.Presenter.BasePresenter;
import com.cms.Validation.MyValidation;
import com.cms.entity.BaseModel;
import com.cms.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by HOZANDUNG on 17/5/24.
 */
public abstract class BaseServiceImpl<M extends BaseModel,R extends BaseRepository<M>,P extends BasePresenter<M>> {

    @Autowired
    protected R repository;
    @Autowired
    protected P presenter;


    /**
     * 分页查找所有信息
     * @param page  页数
     * @param size  每页显示多少个
     * @return
     */
    public Map index(int page, int size) {
        return presenter.packPages(repository.findAll(new PageRequest(page, size)));
    }


    /**
     * 查找传入id对应的信息
     * @param id
     * @return
     */
    public Map findOne(Long id) {
        M m = repository.findOne(id);
        if(m == null) {
            System.out.println("无法找到ID为"+id+"的资源");
        }
        return presenter.objectToMap(m);
    }


    /**
     * 添加
     * 将request请求转化为对应实体类
     * 添加创建信息
     * @param request
     */
    public void create(HttpServletRequest request) {
        M m = presenter.toCreate(request);
        presenter.setCreateInfo(request, m);
        validator(m);
        save(request, m);
    }


    /**
     * 删除
     * 将状态设为deleted,并没有在数据库中删除
     * @param id
     */
    public void delete(Long id) {
        M m = repository.findOne(id);
        if (m == null) {
            System.out.println("无法找到ID为"+id+"的资源");
        }
        m.setStatus(BaseModel.DELETED);
        repository.save(m);
    }


    /**
     * 恢复
     * 将状态设为normal
     * @param id
     */
    public void recovery(Long id) {
        M m = repository.findOne(id);
        if (m == null) {
            System.out.println("无法找到ID为"+id+"的资源");
        }
        m.setStatus(BaseModel.NORMAL);
        repository.save(m);
    }


    /**
     * 改
     *
     */
    public void update(HttpServletRequest request, Long id) {
        M m = repository.findOne(id);
        if (m == null) {
            System.out.println("无法找到ID为"+id+"的资源");
        }
        m = presenter.toUpdate(request, m);
        save(request, m);
    }


    /**
     * 存储操作
     * 添加更新信息
     * @param request
     * @param m
     */
    public void save(HttpServletRequest request, M m) {
        presenter.setUpdateInfo(request, m);
        repository.save(m);
    }

    /**
     * 从数据库中删除
     * @param id
     */
    @Transactional
    public void destroy(Long id) {
        if (repository.findOne(id) == null)
            System.out.println("无法找到ID为"+id+"的资源");
        repository.delete(id);
    }

    /**
     * 对转换出来的实体进行数据验证
     *
     * @param m
     * @return
     */
    public void validator(M m) {
        MyValidation<M> validation = new MyValidation<M>();
        validation.ValidatorData(m);
    }

}
