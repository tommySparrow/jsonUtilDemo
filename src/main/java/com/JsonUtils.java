package com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/8/31
 * @ Description：
 * @ throws
 */
public class JsonUtils {

    private static final SerializeConfig config;

    static {
        config = new SerializeConfig();
        config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    }


    private static final SerializerFeature[] features = {
            SerializerFeature.WriteMapNullValue, // 输出空置字段
            SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null
    };

    /**
     * 实体对象转换为json
     */
    public static String convertObjectToJSON(Object object) {
        return JSON.toJSONString(object, config, features);
    }

    /**
     * json转换为实体对象
     */
    public static <T> T toBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    /**
     * json转换为List
     */
    public static <T> List<T> toList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    /**
     * json转换为Map
     * 示例:String s = "{\"no\":\"50000005\",\"mchtNo\":\"006440395001164\",\"rownum_\":1}";
     */
    public static <K, V> Map<K, V> stringToCollect(String s) {

        Map<K, V> map = (Map<K, V>) JSONObject.parseObject(s);
        return map;
    }


}
