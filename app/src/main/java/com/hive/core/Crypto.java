package com.hive.core;

import android.util.Base64;
import com.google.android.gms.stats.CodePackage;
import com.hive.core.Logger;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.io.files.FileSystemKt;

/* JADX INFO: compiled from: Crypto.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004'()*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ:\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJD\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001c2\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0005J\n\u0010 \u001a\u00020!*\u00020\u0005J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\u001cJ\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001c¨\u0006+"}, d2 = {"Lcom/hive/core/Crypto;", "", "<init>", "()V", "encrypt", "", "type", "Lcom/hive/core/Crypto$CryptoType;", "keyData", "data", "blockType", "Lcom/hive/core/Crypto$BlockType;", "paddingType", "Lcom/hive/core/Crypto$PaddingType;", "decrypt", "crypt", "cryptMode", "", "createAlgorithmParameter", "Ljava/security/spec/AlgorithmParameterSpec;", "md5", "sha1", "sha256", "sha384", "sha512", "createHash", "hashType", "Lcom/hive/core/Crypto$HashType;", "", "gzip", "content", "ungzip", "toRsaPublicKey", "Ljava/security/PublicKey;", "getOnlyKey", "key", "generateCodeVerifier", "generateCodeChallenge", "codeVerifier", "CryptoType", "HashType", "BlockType", "PaddingType", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Crypto {
    public static final Crypto INSTANCE = new Crypto();

    /* JADX INFO: compiled from: Crypto.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CryptoType.values().length];
            try {
                iArr[CryptoType.AES128.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CryptoType.AES256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CryptoType.RSA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BlockType.values().length];
            try {
                iArr2[BlockType.GCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private Crypto() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Crypto.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/hive/core/Crypto$CryptoType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AES128", "AES256", "RSA", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CryptoType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CryptoType[] $VALUES;
        public static final CryptoType AES128 = new CryptoType("AES128", 0, "AES");
        public static final CryptoType AES256 = new CryptoType("AES256", 1, "AES");
        public static final CryptoType RSA = new CryptoType("RSA", 2, "RSA");
        private final String value;

        private static final /* synthetic */ CryptoType[] $values() {
            return new CryptoType[]{AES128, AES256, RSA};
        }

        public static EnumEntries<CryptoType> getEntries() {
            return $ENTRIES;
        }

        private CryptoType(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            CryptoType[] cryptoTypeArr$values = $values();
            $VALUES = cryptoTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(cryptoTypeArr$values);
        }

        public static CryptoType valueOf(String str) {
            return (CryptoType) Enum.valueOf(CryptoType.class, str);
        }

        public static CryptoType[] values() {
            return (CryptoType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Crypto.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/hive/core/Crypto$HashType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MD5", "SHA1", "SHA256", "SHA384", "SHA512", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HashType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HashType[] $VALUES;
        public static final HashType MD5 = new HashType("MD5", 0, "MD5");
        public static final HashType SHA1 = new HashType("SHA1", 1, AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
        public static final HashType SHA256 = new HashType("SHA256", 2, "SHA-256");
        public static final HashType SHA384 = new HashType("SHA384", 3, "SHA-384");
        public static final HashType SHA512 = new HashType("SHA512", 4, "SHA-512");
        private final String value;

        private static final /* synthetic */ HashType[] $values() {
            return new HashType[]{MD5, SHA1, SHA256, SHA384, SHA512};
        }

        public static EnumEntries<HashType> getEntries() {
            return $ENTRIES;
        }

        private HashType(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            HashType[] hashTypeArr$values = $values();
            $VALUES = hashTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hashTypeArr$values);
        }

        public static HashType valueOf(String str) {
            return (HashType) Enum.valueOf(HashType.class, str);
        }

        public static HashType[] values() {
            return (HashType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Crypto.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/hive/core/Crypto$BlockType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CBC", "ECB", CodePackage.GCM, "None", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BlockType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BlockType[] $VALUES;
        public static final BlockType CBC = new BlockType("CBC", 0, "CBC");
        public static final BlockType ECB = new BlockType("ECB", 1, "ECB");
        public static final BlockType GCM = new BlockType(CodePackage.GCM, 2, CodePackage.GCM);
        public static final BlockType None = new BlockType("None", 3, "None");
        private final String value;

        private static final /* synthetic */ BlockType[] $values() {
            return new BlockType[]{CBC, ECB, GCM, None};
        }

        public static EnumEntries<BlockType> getEntries() {
            return $ENTRIES;
        }

        private BlockType(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            BlockType[] blockTypeArr$values = $values();
            $VALUES = blockTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(blockTypeArr$values);
        }

        public static BlockType valueOf(String str) {
            return (BlockType) Enum.valueOf(BlockType.class, str);
        }

        public static BlockType[] values() {
            return (BlockType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Crypto.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/hive/core/Crypto$PaddingType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PKCS7Padding", "PKCS5Padding", "PKCS1Padding", "NoPadding", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PaddingType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PaddingType[] $VALUES;
        private final String value;
        public static final PaddingType PKCS7Padding = new PaddingType("PKCS7Padding", 0, "PKCS7Padding");
        public static final PaddingType PKCS5Padding = new PaddingType("PKCS5Padding", 1, "PKCS5Padding");
        public static final PaddingType PKCS1Padding = new PaddingType("PKCS1Padding", 2, "PKCS1Padding");
        public static final PaddingType NoPadding = new PaddingType("NoPadding", 3, "NoPadding");

        private static final /* synthetic */ PaddingType[] $values() {
            return new PaddingType[]{PKCS7Padding, PKCS5Padding, PKCS1Padding, NoPadding};
        }

        public static EnumEntries<PaddingType> getEntries() {
            return $ENTRIES;
        }

        private PaddingType(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            PaddingType[] paddingTypeArr$values = $values();
            $VALUES = paddingTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(paddingTypeArr$values);
        }

        public static PaddingType valueOf(String str) {
            return (PaddingType) Enum.valueOf(PaddingType.class, str);
        }

        public static PaddingType[] values() {
            return (PaddingType[]) $VALUES.clone();
        }
    }

    public static /* synthetic */ byte[] encrypt$default(Crypto crypto, CryptoType cryptoType, byte[] bArr, byte[] bArr2, BlockType blockType, PaddingType paddingType, int i, Object obj) {
        if ((i & 8) != 0) {
            blockType = BlockType.CBC;
        }
        BlockType blockType2 = blockType;
        if ((i & 16) != 0) {
            paddingType = PaddingType.PKCS7Padding;
        }
        return crypto.encrypt(cryptoType, bArr, bArr2, blockType2, paddingType);
    }

    public final byte[] encrypt(CryptoType type, byte[] keyData, byte[] data, BlockType blockType, PaddingType paddingType) {
        Intrinsics.checkNotNullParameter(blockType, "blockType");
        Intrinsics.checkNotNullParameter(paddingType, "paddingType");
        return crypt(1, type, keyData, data, blockType, paddingType);
    }

    public static /* synthetic */ byte[] decrypt$default(Crypto crypto, CryptoType cryptoType, byte[] bArr, byte[] bArr2, BlockType blockType, PaddingType paddingType, int i, Object obj) {
        if ((i & 8) != 0) {
            blockType = BlockType.CBC;
        }
        BlockType blockType2 = blockType;
        if ((i & 16) != 0) {
            paddingType = PaddingType.PKCS7Padding;
        }
        return crypto.decrypt(cryptoType, bArr, bArr2, blockType2, paddingType);
    }

    public final byte[] decrypt(CryptoType type, byte[] keyData, byte[] data, BlockType blockType, PaddingType paddingType) {
        Intrinsics.checkNotNullParameter(blockType, "blockType");
        Intrinsics.checkNotNullParameter(paddingType, "paddingType");
        return crypt(2, type, keyData, data, blockType, paddingType);
    }

    static /* synthetic */ byte[] crypt$default(Crypto crypto, int i, CryptoType cryptoType, byte[] bArr, byte[] bArr2, BlockType blockType, PaddingType paddingType, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            blockType = BlockType.CBC;
        }
        BlockType blockType2 = blockType;
        if ((i2 & 32) != 0) {
            paddingType = PaddingType.PKCS7Padding;
        }
        return crypto.crypt(i, cryptoType, bArr, bArr2, blockType2, paddingType);
    }

    private final byte[] crypt(int cryptMode, CryptoType type, byte[] keyData, byte[] data, BlockType blockType, PaddingType paddingType) throws NoSuchPaddingException, NoSuchAlgorithmException {
        byte[] bArrDoFinal;
        if (type == null || keyData == null || data == null) {
            Logger.INSTANCE.coreLog$hive_core_release("Crypt failed. keyData=" + keyData + ", data=" + data + ", " + type + FileSystemKt.UnixPathSeparator + blockType + FileSystemKt.UnixPathSeparator + paddingType, Logger.LogType.Error);
            return null;
        }
        if (keyData.length == 0 || ((type == CryptoType.AES128 && keyData.length != 16) || (type == CryptoType.AES256 && keyData.length != 32))) {
            Logger.INSTANCE.coreLog$hive_core_release("Crypt " + type + " failed. key data is invalid", Logger.LogType.Error);
            return null;
        }
        Cipher cipher = Cipher.getInstance(type.getValue() + FileSystemKt.UnixPathSeparator + blockType.getValue() + FileSystemKt.UnixPathSeparator + paddingType.getValue());
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1 || i == 2) {
                cipher.init(cryptMode, new SecretKeySpec(keyData, "AES"), createAlgorithmParameter$default(this, null, 1, null));
                bArrDoFinal = cipher.doFinal(data);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                cipher.init(cryptMode, toRsaPublicKey(keyData));
                bArrDoFinal = cipher.doFinal(data);
            }
            return bArrDoFinal;
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[Crypto] crypt e: " + e.getMessage(), Logger.LogType.Error);
            return null;
        }
    }

    static /* synthetic */ AlgorithmParameterSpec createAlgorithmParameter$default(Crypto crypto, BlockType blockType, int i, Object obj) {
        if ((i & 1) != 0) {
            blockType = BlockType.CBC;
        }
        return crypto.createAlgorithmParameter(blockType);
    }

    private final AlgorithmParameterSpec createAlgorithmParameter(BlockType blockType) {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            bArr[i] = (byte) (b ^ b);
        }
        if (WhenMappings.$EnumSwitchMapping$1[blockType.ordinal()] == 1) {
            return new GCMParameterSpec(128, bArr);
        }
        return new IvParameterSpec(bArr);
    }

    public final byte[] md5(byte[] data) {
        return createHash(HashType.MD5, data);
    }

    public final byte[] sha1(byte[] data) {
        return createHash(HashType.SHA1, data);
    }

    public final byte[] sha256(byte[] data) {
        return createHash(HashType.SHA256, data);
    }

    public final byte[] sha384(byte[] data) {
        return createHash(HashType.SHA384, data);
    }

    public final byte[] sha512(byte[] data) {
        return createHash(HashType.SHA512, data);
    }

    public final byte[] createHash(HashType hashType, byte[] data) {
        Intrinsics.checkNotNullParameter(hashType, "hashType");
        return createHash(hashType.getValue(), data);
    }

    public final byte[] createHash(String hashType, byte[] data) {
        Intrinsics.checkNotNullParameter(hashType, "hashType");
        if (data == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(hashType);
            messageDigest.update(data);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            Logger.INSTANCE.coreLog$hive_core_release("[Crypto] createHash() e: " + e.getMessage(), Logger.LogType.Error);
            return null;
        } catch (Exception e2) {
            Logger.INSTANCE.coreLog$hive_core_release("[Crypto] createHash() e: " + e2.getMessage(), Logger.LogType.Error);
            return null;
        }
    }

    public final byte[] gzip(String content) throws IOException {
        Intrinsics.checkNotNullParameter(content, "content");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Writer outputStreamWriter = new OutputStreamWriter(new GZIPOutputStream(byteArrayOutputStream), Charsets.UTF_8);
        BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
        try {
            bufferedWriter.write(content);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            return byteArray;
        } finally {
        }
    }

    public final String ungzip(byte[] content) throws IOException {
        Intrinsics.checkNotNullParameter(content, "content");
        Reader inputStreamReader = new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(content)), Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return text;
        } finally {
        }
    }

    public final PublicKey toRsaPublicKey(byte[] bArr) throws InvalidKeySpecException {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] bArrDecode = Base64.decode(getOnlyKey(new String(bArr, Charsets.UTF_8)), 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArrDecode));
        Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "generatePublic(...)");
        return publicKeyGeneratePublic;
    }

    public final String getOnlyKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return StringsKt.trim((CharSequence) StringsKt.replace$default(StringsKt.replace$default(new Regex("-----END PUBLIC KEY-----").replace(new Regex("-----BEGIN PUBLIC KEY-----").replace(key, ""), ""), "\r", "", false, 4, (Object) null), "\n", "", false, 4, (Object) null)).toString();
    }

    public final String generateCodeVerifier() {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            byte[] bArr = new byte[32];
            new SecureRandom().nextBytes(bArr);
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(Base64.encodeToString(bArr, 11));
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.coreLog$hive_core_release("[Crypto] Generate code_verifier failed. now use default code. : " + thM7418exceptionOrNullimpl, Logger.LogType.Warning);
        }
        if (kotlin.Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = "dHA-DQrkedUfoHLX0LuLbKLbHUXA77qIGSdzPsAoVTA";
        }
        String str = (String) objM7415constructorimpl;
        Logger.INSTANCE.coreLog$hive_core_release("[Crypto] Generate code_verifier: " + str, Logger.LogType.Warning);
        Intrinsics.checkNotNullExpressionValue(objM7415constructorimpl, "also(...)");
        return str;
    }

    public final String generateCodeChallenge(String codeVerifier) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            Crypto crypto = INSTANCE;
            byte[] bytes = codeVerifier.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(Base64.encodeToString(crypto.sha256(bytes), 11));
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.coreLog$hive_core_release("[Crypto] Generate code_challenge failed. now use default code. : " + thM7418exceptionOrNullimpl, Logger.LogType.Warning);
        }
        if (kotlin.Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = "_uu6STPxJtrh3FL5foj3g5DK3hXeW2cjLCJ7dE-3bFE";
        }
        String str = (String) objM7415constructorimpl;
        Logger.INSTANCE.coreLog$hive_core_release("[Crypto] Generate code_challenge: " + str, Logger.LogType.Warning);
        Intrinsics.checkNotNullExpressionValue(objM7415constructorimpl, "also(...)");
        return str;
    }
}
