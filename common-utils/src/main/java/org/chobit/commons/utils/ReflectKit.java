package org.chobit.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 反射操作相关工具类
 *
 * @author robin
 */
public final class ReflectKit {

    private static final Logger logger = LoggerFactory.getLogger(ReflectKit.class);


    /**
     * 判断某个类是否是直接类型的包装类
     *
     * @param clz 类
     * @return 是否是直接类型的包装类
     */
    public static boolean isWrapClass(Class<?> clz) {
        try {
            return ((Class<?>) clz.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 获取类的所有属性成员的名称
     *
     * @param clazz 目标类
     * @return 类属性成员名称集合
     */
    public static List<String> nameOfFields(Class<?> clazz) {
        return fieldsOf(clazz).stream().map(Field::getName).collect(Collectors.toList());
    }


    /**
     * 获取类的所有属性成员
     *
     * @param clazz 目标类
     * @return 类属性成员集合
     */
    public static List<Field> fieldsOf(Class<?> clazz) {
        return fieldsOf(clazz, true);
    }


    /**
     * 获取类的所有属性成员
     *
     * @param clazz       目标类
     * @param recursively 是否递归获取父类成员
     * @return 类的所有属性成员
     */
    public static List<Field> fieldsOf(Class<?> clazz, boolean recursively) {
        List<Field> fields = new LinkedList<>();
        Class<?> tmp = clazz;

        while (null != tmp) {
            Field[] arr = tmp.getDeclaredFields();
            fields.addAll(java.util.Arrays.asList(arr));

            if (recursively) {
                tmp = tmp.getSuperclass();
            } else {
                tmp = null;
            }
        }
        return fields;
    }

    /**
     * 将对象转为Map
     *
     * @param obj 对象
     * @return 对象对应的Map
     */
    public static Map<String, Object> toMap(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Object> result = new HashMap<>(8);
        for (Field f : fields) {
            boolean isStatic = Modifier.isStatic(f.getModifiers());
            if (isStatic) {
                continue;
            }
            String key = f.getName();
            Object val = null;
            try {
                f.setAccessible(true);
                val = f.get(obj);
            } catch (Exception ignored) {
            }
            if (null == val) {
                continue;
            }
            result.put(key, val);
        }
        return result;
    }


    /**
     * 从对象取值
     *
     * @param field 字段
     * @param obj   对象
     * @return 对象对应field的值
     */
    public static Object getValue(Field field, Object obj) {
        try {
            AccessController.doPrivileged((PrivilegedAction<Object>) () -> {
                field.setAccessible(true);
                return null; // nothing to return
            });
            return field.get(obj);
        } catch (IllegalAccessException e) {
            logger.error("取值失败, field:{}, object:{}", field, obj, e);
            return null;
        }
    }

    private ReflectKit() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }

}
