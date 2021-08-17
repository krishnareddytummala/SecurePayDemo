package com.ausPost.utilities;

import org.apache.commons.lang.RandomStringUtils;

public class RandomUtils {

    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, false);
    }

    public static String getRandomEmail(int length) {
        return RandomStringUtils.random(length, true, false) + "@gmail.com";
    }

    public static String getRandomWebSite(int length) {
        return "www." + RandomStringUtils.random(length, true, false) + ".com";
    }
}
