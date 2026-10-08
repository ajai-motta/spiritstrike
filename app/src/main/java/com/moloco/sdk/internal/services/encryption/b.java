package com.moloco.sdk.internal.services.encryption;

import android.util.Base64;
import com.moloco.sdk.BuildConfig;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements a {
    public static final int h = 8;
    public final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.services.encryption.b$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return b.f();
        }
    });
    public final Lazy c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.services.encryption.b$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return b.e();
        }
    });
    public final Lazy d = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.services.encryption.b$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return b.d();
        }
    });
    public final Lazy e = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.services.encryption.b$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return b.c();
        }
    });
    public final SecretKeySpec f = h();
    public final Lazy g = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.services.encryption.b$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return b.g();
        }
    });

    public static final String c() {
        byte[] bArrDecode = Base64.decode(new byte[]{81, 85, 86, 84, 76, 48, 100, 68, 84, 83, 57, 79, 98, 49, 66, 104, 90, 71, 82, 112, 98, 109, 99, kotlin.io.encoding.Base64.padSymbol}, 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return StringsKt.decodeToString(bArrDecode);
    }

    public static final String d() {
        return StringsKt.decodeToString(new byte[]{65, 69, 83});
    }

    public static final String e() {
        return StringsKt.decodeToString(new byte[]{82, 83, 65, 47, 69, 67, 66, 47, 79, 65, 69, 80, 87, 105, 116, 104, 83, 72, 65, 45, 50, 53, 54, 65, 110, 100, 77, 71, 70, 49, 80, 97, 100, 100, 105, 110, 103});
    }

    public static final String f() {
        byte[] bArrDecode = Base64.decode(new byte[]{85, 108, 78, 66}, 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return StringsKt.decodeToString(bArrDecode);
    }

    public static final IvParameterSpec g() {
        return new IvParameterSpec(Base64.decode(BuildConfig.MOLOCO_SDK_BIDTOKEN_SALT, 0));
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public IvParameterSpec a() {
        return (IvParameterSpec) this.g.getValue();
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public SecretKeySpec b() {
        return this.f;
    }

    public final SecretKeySpec h() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(i());
        keyGenerator.init(256);
        return new SecretKeySpec(keyGenerator.generateKey().getEncoded(), i());
    }

    public final String i() {
        return (String) this.d.getValue();
    }

    public final String j() {
        return (String) this.e.getValue();
    }

    public final String k() {
        return (String) this.b.getValue();
    }

    public final String l() {
        return (String) this.c.getValue();
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public byte[] a(byte[] data) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(data, "data");
        Cipher cipher = Cipher.getInstance(j());
        cipher.init(1, b(), a());
        byte[] bArrDoFinal = cipher.doFinal(data);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public String b(byte[] data) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(data, "data");
        Cipher cipher = Cipher.getInstance(j());
        cipher.init(2, b(), a());
        byte[] bArrDoFinal = cipher.doFinal(data);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        return StringsKt.decodeToString(bArrDoFinal);
    }

    public final PublicKey c(String str) throws InvalidKeySpecException {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(k()).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "generatePublic(...)");
        return publicKeyGeneratePublic;
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public String a(byte[] data, byte[] secret) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(secret, "secret");
        Cipher cipher = Cipher.getInstance(j());
        cipher.init(2, new SecretKeySpec(secret, i()), a());
        byte[] bArrDoFinal = cipher.doFinal(data);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        return StringsKt.decodeToString(bArrDoFinal);
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public byte[] b(byte[] input, String publicKey) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Cipher cipher = Cipher.getInstance(l());
        cipher.init(1, c(publicKey));
        byte[] bArrDoFinal = cipher.doFinal(b().getEncoded());
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }

    public final PrivateKey b(String str) throws InvalidKeySpecException {
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(k()).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
        Intrinsics.checkNotNullExpressionValue(privateKeyGeneratePrivate, "generatePrivate(...)");
        return privateKeyGeneratePrivate;
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public byte[] a(String rsaPublicKey) {
        Intrinsics.checkNotNullParameter(rsaPublicKey, "rsaPublicKey");
        byte[] encoded = b().getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
        return b(encoded, rsaPublicKey);
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public byte[] a(byte[] input, String privateKey) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        Cipher cipher = Cipher.getInstance(l());
        cipher.init(2, b(privateKey));
        byte[] bArrDoFinal = cipher.doFinal(input);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }
}
