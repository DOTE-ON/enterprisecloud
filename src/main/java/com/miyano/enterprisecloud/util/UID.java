package com.miyano.enterprisecloud.util;

import java.util.UUID;

/**
 * @author Miyano
 * @since 2020/11/14 20:00
 */
public class UID {

    /**
     * 生成一个无 '-' 的全小写 uid
     * @return uid
     */
    public static String getuid () {
        return UUID.randomUUID ().toString ().replace ("-", "").toLowerCase ();
    }
}
