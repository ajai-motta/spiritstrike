package com.gomfactory.adpie.sdk.security;

import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class Crypto {
    private static String IV = "7UjM8iKl";
    private static String KEY = "zaq1XSW2cde3VFR4bgt5NHY6";
    public static final String TAG = "Crypto";
    private static String algorithm = "DESede";
    private static String transformation = "DESede/CFB8/NoPadding";

    public static String encrypt(String str) {
        try {
            Cipher cipher = Cipher.getInstance(transformation);
            byte[] bArr = new byte[24];
            for (int i = 0; i < KEY.length() && i < 24; i++) {
                bArr[i] = (byte) KEY.charAt(i);
            }
            cipher.init(1, new SecretKeySpec(bArr, algorithm), new IvParameterSpec(IV.getBytes()));
            if (str == null) {
                return null;
            }
            return new String(Base64.encode(cipher.doFinal(str.getBytes("UTF8")), 8), "UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String decrypt(String str) {
        try {
            byte[] bArr = new byte[24];
            for (int i = 0; i < KEY.length() && i < 24; i++) {
                bArr[i] = (byte) KEY.charAt(i);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, algorithm);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            if (str == null) {
                return null;
            }
            return new String(cipher.doFinal(Base64.decode(str.getBytes(), 8)), "UTF8");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String sha1(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            for (byte b : messageDigest.digest()) {
                sb.append(String.format("%02X", Byte.valueOf(b)));
            }
            return sb.toString().toLowerCase(Locale.US);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(), 0, str.length());
            byte[] bArrDigest = messageDigest.digest();
            String str2 = new String();
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i <= 15) {
                    str2 = str2 + AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                str2 = str2 + Integer.toHexString(i);
            }
            return str2.toUpperCase();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
