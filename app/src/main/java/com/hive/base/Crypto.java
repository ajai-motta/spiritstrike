package com.hive.base;

import android.util.Base64;
import com.hive.core.Crypto;
import com.hive.core.Logger;
import com.hive.core.StringUtil;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J(\u0010\u0004\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\u0004\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J \u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\nJ \u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005¨\u0006\u0016"}, d2 = {"Lcom/hive/base/Crypto;", "", "<init>", "()V", "encryptAES", "", "cryptoHashType", "Lcom/hive/core/Crypto$HashType;", "cryptoKey", "plainText", "", "base64Flag", "", "decryptAES", "cipherText", "createHash", "data", "encryptRSA", "key", "toRsaPublicKey", "Ljava/security/PublicKey;", "getOnlyKey", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Crypto {
    public static final Crypto INSTANCE = new Crypto();

    private Crypto() {
    }

    public final String createHash(Crypto.HashType cryptoHashType, byte[] data) {
        String hexString;
        Intrinsics.checkNotNullParameter(cryptoHashType, "cryptoHashType");
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] bArrCreateHash = com.hive.core.Crypto.INSTANCE.createHash(cryptoHashType.getValue(), data);
        return (bArrCreateHash == null || (hexString = StringUtil.INSTANCE.toHexString(bArrCreateHash)) == null) ? "" : hexString;
    }

    public final String decryptAES(Crypto.HashType cryptoHashType, String cryptoKey, String cipherText) {
        Intrinsics.checkNotNullParameter(cryptoHashType, "cryptoHashType");
        Intrinsics.checkNotNullParameter(cryptoKey, "cryptoKey");
        Intrinsics.checkNotNullParameter(cipherText, "cipherText");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = cipherText.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDecryptAES = decryptAES(cryptoHashType, cryptoKey, bytes);
        return bArrDecryptAES != null ? new String(bArrDecryptAES, charset) : "";
    }

    public final String encryptAES(Crypto.HashType cryptoHashType, String cryptoKey, String plainText) {
        Intrinsics.checkNotNullParameter(cryptoHashType, "cryptoHashType");
        Intrinsics.checkNotNullParameter(cryptoKey, "cryptoKey");
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = plainText.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrEncryptAES = encryptAES(cryptoHashType, cryptoKey, bytes, 4);
        return bArrEncryptAES != null ? new String(bArrEncryptAES, charset) : "";
    }

    public final String encryptRSA(String data, String key) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        PublicKey rsaPublicKey = toRsaPublicKey(key);
        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
        Intrinsics.checkNotNullExpressionValue(cipher, "getInstance(...)");
        cipher.init(1, rsaPublicKey);
        byte[] bytes = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDoFinal = cipher.doFinal(bytes);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        String strEncodeToString = Base64.encodeToString(bArrDoFinal, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public final String getOnlyKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return StringsKt.trim((CharSequence) StringsKt.replace$default(new Regex("-----END PUBLIC KEY-----").replace(new Regex("-----BEGIN PUBLIC KEY-----").replace(key, ""), ""), "\n", "", false, 4, (Object) null)).toString();
    }

    public final PublicKey toRsaPublicKey(String str) throws InvalidKeySpecException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArrDecode = Base64.decode(getOnlyKey(str), 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArrDecode));
        Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "generatePublic(...)");
        return publicKeyGeneratePublic;
    }

    public final byte[] decryptAES(Crypto.HashType cryptoHashType, String cryptoKey, byte[] cipherText) {
        Intrinsics.checkNotNullParameter(cryptoHashType, "cryptoHashType");
        Intrinsics.checkNotNullParameter(cryptoKey, "cryptoKey");
        Intrinsics.checkNotNullParameter(cipherText, "cipherText");
        byte[] bytes = cryptoKey.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return decryptAES(cryptoHashType, bytes, cipherText);
    }

    public final byte[] encryptAES(Crypto.HashType cryptoHashType, String cryptoKey, byte[] plainText, int base64Flag) {
        Intrinsics.checkNotNullParameter(cryptoHashType, "cryptoHashType");
        Intrinsics.checkNotNullParameter(cryptoKey, "cryptoKey");
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        byte[] bytes = cryptoKey.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return encryptAES(cryptoHashType, bytes, plainText, base64Flag);
    }

    public final byte[] decryptAES(Crypto.HashType cryptoHashType, byte[] cryptoKey, byte[] cipherText) {
        Intrinsics.checkNotNullParameter(cryptoHashType, "cryptoHashType");
        Intrinsics.checkNotNullParameter(cryptoKey, "cryptoKey");
        Intrinsics.checkNotNullParameter(cipherText, "cipherText");
        try {
            String strSubstring = createHash(cryptoHashType, cryptoKey).substring(0, 16);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            com.hive.core.Crypto crypto = com.hive.core.Crypto.INSTANCE;
            Crypto.CryptoType cryptoType = Crypto.CryptoType.AES128;
            byte[] bytes = strSubstring.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return com.hive.core.Crypto.decrypt$default(crypto, cryptoType, bytes, StringUtil.INSTANCE.toBase64Decode(cipherText, 4), null, null, 24, null);
        } catch (Exception e) {
            Logger.INSTANCE.e("[Crypto] decryptAES()\ne: " + e.getMessage());
            return null;
        }
    }

    public final byte[] encryptAES(Crypto.HashType cryptoHashType, byte[] cryptoKey, byte[] plainText, int base64Flag) {
        Intrinsics.checkNotNullParameter(cryptoHashType, "cryptoHashType");
        Intrinsics.checkNotNullParameter(cryptoKey, "cryptoKey");
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        try {
            String strSubstring = createHash(cryptoHashType, cryptoKey).substring(0, 16);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            com.hive.core.Crypto crypto = com.hive.core.Crypto.INSTANCE;
            Crypto.CryptoType cryptoType = Crypto.CryptoType.AES128;
            byte[] bytes = strSubstring.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bArrEncrypt$default = com.hive.core.Crypto.encrypt$default(crypto, cryptoType, bytes, plainText, null, null, 24, null);
            if (bArrEncrypt$default != null) {
                return StringUtil.INSTANCE.toBase64Encode(bArrEncrypt$default, base64Flag);
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.e("[Crypto] encryptAES()\ne: " + e.getMessage());
            return null;
        }
    }
}
