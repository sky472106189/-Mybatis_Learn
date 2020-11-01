package com.myself.utils;

import java.util.UUID;

/*
    一般企业的数据库ID都是随机生成的
    这里用此工具类来随机生成
*/
public class IdUtils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
