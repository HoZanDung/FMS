package com.cms.util;

import com.cms.entity.BaseModel;
import com.cms.entity.SysUser;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HOZANDUNG on 17/5/25.
 */
@Component
public class InvokeUtil<M extends BaseModel> {


    public Map getFieldsValue(M m) {
        Class clazz = m.getClass();
        Field[] fields = m.getClass().getDeclaredFields();//获得属性
        Map map = new HashMap();
        for (Field field : fields) {
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
                        clazz);
                Method getMethod = pd.getReadMethod();//获得get方法
                map.put(field.getName(), getMethod.invoke(m));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IntrospectionException e) {
                continue;
            }
        }
        return map;
    }


}
