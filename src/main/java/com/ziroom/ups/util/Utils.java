package com.ziroom.ups.util;

import java.util.UUID;

/**
 * @author
 * @create 2018-12-09 23:20
 * Description:
 */
public class Utils {
    public static String genUUID() {
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }
}
