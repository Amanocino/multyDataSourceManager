package org.example.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhicheng chen
 * @date : 2022/2/16
 * @time : 10:18
 */
public class ObjectSwitch {
    /**
     * Object 对象转 List
     */
    public static <T> List<T> castList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }
}
