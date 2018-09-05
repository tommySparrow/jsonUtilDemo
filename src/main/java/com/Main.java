package com;

import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/8/31
 * @ Description：
 * @ throws
 */
public class Main {
    public static void main(String[] args) {

        String s = "{\"no\":\"50000005\",\"mchtNo\":\"006440395001164\",\"rownum_\":1}";
        Map<Object, Object> map = JsonUtils.stringToCollect(s);
        System.out.println(map.get("no"));
        System.out.println(map.get("mchtNo"));
        System.out.println(map.get("rownum_"));

    }
}
