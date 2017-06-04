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

    /**
     * 获取传入类的所有属性,不包括父类即BaseModel
     * @param m
     * @return
     */
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


    /**
     * 获取传入类的属性,根据String[]设置的属性名去获取,可控
     * @param m
     * @param field
     * @return
     */
    public Object getFieldValue(M m, String field) {
        try {
            Class clazz = m.getClass();
            Field declaredField = null;
            try {
                declaredField = clazz.getDeclaredField(field);
            } catch (NoSuchFieldException e) {
                try {
                    declaredField = clazz.getSuperclass().getDeclaredField(field);
                } catch (NoSuchFieldException e1) {
                    try {
                        declaredField = clazz.getSuperclass().getSuperclass().getDeclaredField(field);
                    } catch (NoSuchFieldException e2) {
                        return null;
                    }
                }
            }
            declaredField.setAccessible(true);
            return declaredField.get(m);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *
     * @param m
     * @param name
     * @param value
     */
    public void setFieldValue(M m, String name, Object value) {
        try {
            Field field;
            try {
                field = m.getClass().getDeclaredField(name);//得到类的属性
            } catch (NoSuchFieldException e) {
                // 之所以有三层嵌套是因为我的实体最多的继承****-BaseEntity-BaseModel
                try {
                    field = m.getClass().getSuperclass().getDeclaredField(name);
                } catch (NoSuchFieldException e1) {
                    try {
                        field = m.getClass().getSuperclass().getSuperclass().getDeclaredField(name);
                    } catch (NoSuchFieldException e2) {
                        return;
                    }
                }
            }
            //accessible 标志允许具有足够特权的复杂应用程序（比如 Java Object Serialization 或其他持久性机制）以某种通常禁止使用的方式来操作对象。
            field.setAccessible(true);
            try {
                field.set(m, value);
            } catch (IllegalArgumentException e) {
                field.setInt(m, Integer.parseInt(String.valueOf(value)));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
