package com.cms.Presenter;

import com.cms.entity.BaseEntity;
import com.cms.entity.BaseModel;
import com.cms.entity.SysUser;
import com.cms.repository.SysUserRepository;
import com.cms.util.BaseUtil;
import com.cms.util.InvokeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.security.Principal;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HOZANDUNG on 17/5/25.
 */
public abstract class BasePresenter<M extends BaseModel> {

    @Autowired
    private InvokeUtil<M> invokeUtil;

    @Autowired
    SysUserRepository userRepository;

    public Map objectToMap(M m) {
        return transform(m, null, true);
    }


    protected M mapToObject(M m, String[] fields, HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key : fields) {
            if (parameterMap.containsKey(key)) {
                try {
                    invokeUtil.setFieldValue(m, key, request.getParameter(key));
                } catch (Exception e) {
                    System.out.println("转换时出错");
                    continue;
                }
            }
        }
        return m;
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


    /**
     *
     * @param request
     * @return 将request返回为对应的实体(未考虑参数不一的时候怎么办,初步想在前端限制参数必须与实体相符)
     */
    public abstract M toCreate(HttpServletRequest request);


    /**
     *
     * @param request
     * @param m
     * @return 将request返回为对应的实体
     */
    public abstract M toUpdate(HttpServletRequest request, M m);


    /**
     * 获取用户真实id地址和当前时间
     * 记录操作id和操作时间
     * 获取当前登录用户,并记录做出更新操作的用户信息
     * 如果找不到实体,记录创建该实体的用户信息
     * @param request
     * @param m
     */
    public void setUpdateInfo(HttpServletRequest request, M m) {
        m.setUpdate_ip(BaseUtil.getIpAddress(request));
        m.setUpdate_time(new Date());
        if (m instanceof BaseEntity) {
            Principal userPrincipal = request.getUserPrincipal();
            if (userPrincipal != null) {
                SysUser user = userRepository.findByUsername(userPrincipal.getName());
                ((BaseEntity) m).setUpdate_by(user);
                if (m.getId() == null) {
                    ((BaseEntity) m).setCreate_by(user);
                }
            }
        }
    }


    /**
     * 获取用户真实id地址和当前时间
     * 记录操作id和操作时间
     * 获取当前登录用户,并记录做出更新操作的用户信息
     * 如果找不到实体,记录创建该实体的用户信息
     * @param request
     * @param m
     */
    public void setCreateInfo(HttpServletRequest request, M m) {
        m.setCreate_ip(BaseUtil.getIpAddress(request));
        m.setCreate_time(new Date());
        if (m instanceof BaseEntity) {
            Principal userPrincipal = request.getUserPrincipal();
            if (userPrincipal != null) {
                SysUser user = userRepository.findByUsername(userPrincipal.getName());
                ((BaseEntity) m).setCreate_by(user);
            }
        }
    }


}
