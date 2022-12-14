package com.example.onlineproject.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Encrypt {
    /**
     * Used building output as Hex
     */
    private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * 对字符串进行MD5加密
     *
     * @param text
     *            明文
     *
     * @return 密文
     */
    public static String md5(String text) {
        MessageDigest msgDigest = null;

        try {
            msgDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("System doesn't support MD5 algorithm.");
        }

        try {
            msgDigest.update(text.getBytes("utf-8"));

        } catch (UnsupportedEncodingException e) {

            throw new IllegalStateException("System doesn't support your  EncodingException.");

        }

        byte[] bytes = msgDigest.digest();

        String md5Str = new String(encodeHex(bytes));

        return md5Str;
    }

    public static char[] encodeHex(byte[] data) {

        int l = data.length;

        char[] out = new char[l << 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS[0x0F & data[i]];
        }

        return out;
    }

    public static void main(String a[]) {
        StringBuffer sb = new StringBuffer();
        sb.append("<Request><version>1.0</version>");
        sb.append("<instId>fullgoal</instId>");
        sb.append("<certId>MD5</certId>");
        sb.append("<isIndividual>1</isIndividual>");
        sb.append("<contractNo>01999000000077401</contractNo>");
        sb.append("<applicationNo>201408110004557227</applicationNo>");
        sb.append("<fundCode>000638</fundCode>");
        sb.append("<amount>5.00</amount>");
        sb.append("<chargeType>A</chargeType>");
        sb.append("<declareType>1</declareType>");
        sb.append("<capsourcemode></capsourcemode>");
        sb.append("<unfrozenDate></unfrozenDate>");
        sb.append("<isAgreeRisk></isAgreeRisk>");
        sb.append("<isForceDeal></isForceDeal>");
        sb.append("<extension></extension></Request>");
        System.out.println(Md5Encrypt.md5("111111"));
        System.out.println(Md5Encrypt.md5(sb.toString()).toUpperCase());
        String str="开始md5加密";
        System.out.println(Md5Encrypt.md5(str));
        System.out.println(Md5Encrypt.encodeHex("b95dad363b1d37622f84d06617a6dfe3".getBytes()));
    }
}
