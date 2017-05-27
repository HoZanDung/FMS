package com.cms.service.Impl;

import com.cms.Presenter.BasePresenter;
import com.cms.entity.BaseModel;
import com.cms.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.Collection;
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
     *              查
     * @param page  页数
     * @param size  每页显示多少个
     * @return
     */
    public Map index(int page, int size) {
        return presenter.packPages(repository.findAll(new PageRequest(page, size)));
    }


    /**
     *
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
     * 增
     *
     */
    public void add() {

    }


    /**
     * 删
     *
     */
    public void delete() {

    }


    /**
     * 恢复
     */
    public void recovery() {

    }


    /**
     * 改
     *
     */
    public void update() {

    }


}
