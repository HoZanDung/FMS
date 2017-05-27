package com.cms.Presenter;

import com.cms.entity.BaseModel;
import com.cms.util.InvokeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by HOZANDUNG on 17/5/25.
 */
public abstract class BasePresenter<M extends BaseModel> {

    @Autowired
    private InvokeUtil<M> invokeUtil;

    public Map objectToMap(M m) {
        return transform(m, null, true);
    }


    /**
     *
     * @param m             实体类
     * @param properties    转换出来的属性集合
     * @param needDetail    是否需要设置Detail值
     * @return
     */
    public Map<String, Object> transform(M m, String[] properties, Boolean needDetail) {
        Map<String, Object> map = new LinkedHashMap<>();
        if (properties == null) {
            map = invokeUtil.getFieldsValue(m);
        }
        return map;
    }


    /**
     *
     * @param pages 需要分页的对象
     * @return
     */
    public Map packPages(Page<M> pages) {
        Page<M> models = pages;
        LinkedHashMap metaData = new LinkedHashMap<>();
        LinkedHashMap pageInfo = new LinkedHashMap<>();
        pageInfo.put("Current Page", pages.getNumber() + 1);
        pageInfo.put("Total Pages", models.getTotalPages());
        pageInfo.put("Total Elements", models.getTotalElements());
        metaData.put("pageInfo", pageInfo);
        List<Map> mList = new LinkedList<>();
        for (M model : models) {
            mList.add(objectToMap(model));
        }
        LinkedHashMap<String, Object> map = new LinkedHashMap();
        map.put("data", mList);
        map.put("metadata", metaData);
        return map;
    }

}
