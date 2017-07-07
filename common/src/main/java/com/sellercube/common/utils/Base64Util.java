package com.sellercube.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

/**
 * base64 加密解密
 * Created by Chenjing on 2017/7/5.
 */
public class Base64Util {


    /**
     * base64解密
     *
     * @param inputData
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] decodeData(String inputData) throws UnsupportedEncodingException {
        Optional<String> str = Optional.of(inputData);
        return Base64.decodeBase64(str.get());
    }

    /**
     * base64加密
     *
     * @param inputData
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] encodeData(String inputData) throws UnsupportedEncodingException {
        Optional<String> str = Optional.of(inputData);
        return Base64.encodeBase64(str.get().getBytes("utf-8"));
    }

}
