package com.amanoisuno.dynamicdatasource.utils;

import org.apache.commons.lang.StringUtils;

public class SwitchCaseUtil {
    //32为是char类型大小写的差数，-32是小写变大写，+32是大写变小写

    /**
     * 首字母小写
     * @param str
     * @return
     */
    public static String lowerFirstCase(String str){
        char[] chars = str.toCharArray();
        //首字母小写方法，大写会变成小写，如果小写首字母会消失
        if (chars[0] >= 'A' && chars[0] <= 'Z'){
            chars[0] +=32;
            return String.valueOf(chars);
        }
        return str;
    }

    /**
     * 首字母大写
     * @param str
     * @return
     */
    public static String upperFirstCase(String str){
        char[] chars = str.toCharArray();
        //首字母小写方法，大写会变成小写，如果小写首字母会消失
        if (chars[0] >= 'a' && chars[0] <= 'z'){
            chars[0] -=32;
            return String.valueOf(chars);
        }
//        StringUtils.uncapitalize(str);
        return str;


    }
}
