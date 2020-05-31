package com.shnu.work.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * 加解密工具类
 *
 * @author Shinomiya Kaguya
 */
public class EncryptUtils {
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final String HMAC_MD5 = "HmacMD5";
    public static final String HMAC_SHA1 = "HmacSHA1";
    public static final String DES = "DES";
    public static final String AES = "AES";

    /**
     * 编码格式；默认使用uft-8
     */
    public static final String CHARSET = "utf-8";
    /**
     * DES
     */
    public static final int KEYSIZE_DES = 0;
    /**
     * AES
     */
    public static final int KEYSIZE_AES = 128;

    public static EncryptUtils ME;

    private EncryptUtils() {
    }

    //双重锁
    public static EncryptUtils getInstance() {
        if (ME == null) {
            synchronized (EncryptUtils.class) {
                if (ME == null) {
                    ME = new EncryptUtils();
                }
            }
        }
        return ME;
    }

    /**
     * 使用MessageDigest进行单向加密（无密码）
     *
     * @param res       被加密的文本
     * @param algorithm 加密算法名称
     * @return
     */
    private String messageDigest(String res, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] resBytes = res.getBytes(CHARSET);
            return base64(md.digest(resBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用KeyGenerator进行单向/双向加密（可设密码）
     *
     * @param res       被加密的原文
     * @param algorithm 加密使用的算法名称
     * @param key       加密使用的秘钥
     * @return
     */
    private String keyGeneratorMac(String res, String algorithm, String key) {
        try {
            SecretKey sk = null;
            if (key == null) {
                KeyGenerator kg = KeyGenerator.getInstance(algorithm);
                sk = kg.generateKey();
            } else {
                byte[] keyBytes = key.getBytes(CHARSET);
                sk = new SecretKeySpec(keyBytes, algorithm);
            }
            Mac mac = Mac.getInstance(algorithm);
            mac.init(sk);
            byte[] result = mac.doFinal(res.getBytes());
            return base64(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用KeyGenerator双向加密，DES/AES，注意这里转化为字符串的时候是将2进制转为16进制格式的字符串，不是直接转，因为会出错
     *
     * @param res       加密的原文
     * @param algorithm 加密使用的算法名称
     * @param key       加密的秘钥
     * @param keySize   密钥大小
     * @param isEncode  是否已经加密
     * @return
     */
    private String keyGeneratorES(String res, String algorithm, String key, int keySize, Boolean isEncode) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance(algorithm);
            if (keySize == 0) {
                byte[] keyBytes = key.getBytes(CHARSET);
                kg.init(new SecureRandom(keyBytes));
            } else if (key == null) {
                kg.init(keySize);
            } else {
                byte[] keyBytes = key.getBytes(CHARSET);
                kg.init(keySize, new SecureRandom(keyBytes));
            }
            SecretKey sk = kg.generateKey();
            SecretKeySpec sks = new SecretKeySpec(sk.getEncoded(), algorithm);
            Cipher cipher = Cipher.getInstance(algorithm);
            if (isEncode) {
                cipher.init(Cipher.ENCRYPT_MODE, sks);
                byte[] resBytes = res.getBytes(CHARSET);
                return parseByte2HexStr(cipher.doFinal(resBytes));
            } else {
                cipher.init(Cipher.DECRYPT_MODE, sks);
                return new String(cipher.doFinal(Objects.requireNonNull(parseHexStr2Byte(res))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * base64 encode
     *
     * @param res arr
     * @return
     */
    private String base64(byte[] res) {
        return Base64.encode(res);
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf 二进制arr
     * @return
     */
    public static String parseByte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (byte b : buf) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     * @param hexStr 十六进制字符串
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * md5加密算法进行加密（不可逆）
     *
     * @param res 需要加密的原文
     * @return
     */
    public String MD5(String res) {
        return messageDigest(res, MD5);
    }

    /**
     * md5加密算法进行加密（不可逆）
     *
     * @param res 需要加密的原文
     * @param key 秘钥
     * @return
     */
    public String md5(String res, String key) {
        return keyGeneratorMac(res, HMAC_MD5, key);
    }

    /**
     * 使用SHA1加密算法进行加密（不可逆）
     *
     * @param res 需要加密的原文
     * @return
     */
    public String sha1(String res) {
        return messageDigest(res, SHA1);
    }

    /**
     * 使用SHA1加密算法进行加密（不可逆）
     *
     * @param res 需要加密的原文
     * @param key 秘钥
     * @return
     */
    public String sha1(String res, String key) {
        return keyGeneratorMac(res, HMAC_SHA1, key);
    }

    /**
     * 使用DES加密算法进行加密（可逆）
     *
     * @param res 需要加密的原文
     * @param key 秘钥
     * @return
     */
    public String desEncode(String res, String key) {
        return keyGeneratorES(res, DES, key, KEYSIZE_DES, true);
    }

    /**
     * 对使用DES加密算法的密文进行解密（可逆）
     *
     * @param res 需要解密的密文
     * @param key 秘钥
     * @return
     */
    public String desDecode(String res, String key) {
        return keyGeneratorES(res, DES, key, KEYSIZE_DES, false);
    }

    /**
     * 使用AES加密算法经行加密（可逆）
     *
     * @param res 需要加密的密文
     * @param key 秘钥
     * @return
     */
    public String aesEncode(String res, String key) {
        return keyGeneratorES(res, AES, key, KEYSIZE_AES, true);
    }

    /**
     * 对使用AES加密算法的密文进行解密
     *
     * @param res 需要解密的密文
     * @param key 秘钥
     * @return
     */
    public String aesDecode(String res, String key) {
        return keyGeneratorES(res, AES, key, KEYSIZE_AES, false);
    }

    /**
     * 使用异或进行加密
     *
     * @param res 需要加密的密文
     * @param key 秘钥
     * @return
     */
    public String xorEncode(String res, String key) {
        byte[] bs = res.getBytes();
        for (int i = 0; i < bs.length; i++) {
            bs[i] = (byte) ((bs[i]) ^ key.hashCode());
        }
        return parseByte2HexStr(bs);
    }

    /**
     * 使用异或进行解密
     *
     * @param res 需要解密的密文
     * @param key 秘钥
     * @return
     */
    public String xorDecode(String res, String key) {
        byte[] bs = parseHexStr2Byte(res);
        IntStream.range(0, Objects.requireNonNull(bs).length).forEach(i -> bs[i] = (byte) ((bs[i]) ^ key.hashCode()));
        return new String(bs);
    }

    /**
     * 直接使用异或（第一调用加密，第二次调用解密）
     *
     * @param res 密文
     * @param key 秘钥
     * @return
     */
    public int xor(int res, String key) {
        return res ^ key.hashCode();
    }

    /**
     * 使用Base64进行加密
     *
     * @param res 密文
     * @return
     */
    public String base64Encode(String res) {
        return Base64.encode(res.getBytes());
    }

    /**
     * 使用Base64进行解密
     *
     * @param res
     * @return
     */
    public String base64Decode(String res) {
        return new String(Base64.decode(res));
    }
}
