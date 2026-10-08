package com.hive.core;

import com.facebook.share.internal.ShareInternalUtility;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.hive.core.Crypto;
import com.hive.core.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Property.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/hive/core/Property;", "", "fileName", "", "pathName", "fixedKey", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getFileName", "()Ljava/lang/String;", "parentFile", "Ljava/io/File;", ShareInternalUtility.STAGING_PARAM, "map", "", "sId", "id", "cryptoKey", "", "get", "key", "defValue", UserMetadata.KEYDATA_FILENAME, "", "set", "", "value", ProductAction.ACTION_REMOVE, "write", "delete", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Property {
    private final byte[] cryptoKey;
    private final File file;
    private final String fileName;
    private final String id;
    private Map<String, String> map;
    private final File parentFile;
    private final String sId;

    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Property(java.lang.String r13, java.lang.String r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.core.Property.<init>(java.lang.String, java.lang.String, boolean):void");
    }

    public final String getFileName() {
        return this.fileName;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Property(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            str2 = HiveCoreInitializer.INSTANCE.getInitContext().getFilesDir().getPath() + "/hive";
        }
        this(str, str2, (i & 4) != 0 ? false : z);
    }

    public final synchronized String get(String key) {
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this) {
            String str2 = this.map.get(key);
            Logger.INSTANCE.coreLog$hive_core_release("[" + this.fileName + "] Property.get : " + key + ", " + str2, Logger.LogType.Debug);
            str = str2;
        }
        return str;
        return str;
    }

    public final synchronized String get(String key, String defValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        String str = get(key);
        if (str != null) {
            defValue = str;
        }
        Logger.INSTANCE.coreLog$hive_core_release("[" + this.fileName + "] Property.get(def) : " + key + ", " + defValue, Logger.LogType.Debug);
        return defValue;
    }

    public final synchronized Set<String> keys() {
        Set<String> setKeySet;
        synchronized (this) {
            setKeySet = this.map.keySet();
        }
        return setKeySet;
        return setKeySet;
    }

    public final synchronized void set(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this) {
            this.map.put(key, value);
            Logger.INSTANCE.coreLog$hive_core_release("[" + this.fileName + "] Property.set : " + key + ", " + value, Logger.LogType.Debug);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final synchronized void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this) {
            String strRemove = this.map.remove(key);
            String str = strRemove;
            Logger.INSTANCE.coreLog$hive_core_release("[" + this.fileName + "] Property.remove : " + key, Logger.LogType.Error);
            String str2 = strRemove;
        }
    }

    public final synchronized boolean write() {
        boolean zBooleanValue;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        synchronized (this) {
            zBooleanValue = false;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Exception e) {
                Logger.INSTANCE.coreLog$hive_core_release("[" + this.fileName + "] Property.write Exception. " + e, Logger.LogType.Error);
            }
            try {
                objectOutputStream.writeObject(this.map);
                Unit unit = Unit.INSTANCE;
                Boolean boolValueOf = null;
                CloseableKt.closeFinally(objectOutputStream, null);
                byte[] bArrEncrypt$default = Crypto.encrypt$default(Crypto.INSTANCE, Crypto.CryptoType.AES256, this.cryptoKey, byteArrayOutputStream.toByteArray(), null, null, 24, null);
                if (bArrEncrypt$default != null) {
                    boolean zWrite = FileStorage.INSTANCE.write(this.file, bArrEncrypt$default);
                    if (!zWrite) {
                        Logger.INSTANCE.coreLog$hive_core_release("[" + this.fileName + "] Property.write = " + zWrite, Logger.LogType.Error);
                    }
                    boolValueOf = Boolean.valueOf(zWrite);
                }
                if (boolValueOf != null) {
                    zBooleanValue = boolValueOf.booleanValue();
                } else {
                    Logger.INSTANCE.coreLog$hive_core_release("[" + this.fileName + "] Property.write failed.", Logger.LogType.Error);
                }
            } finally {
            }
        }
        return zBooleanValue;
        return zBooleanValue;
    }

    public final synchronized boolean delete() {
        boolean zDelete;
        synchronized (this) {
            this.map.clear();
            zDelete = FileStorage.INSTANCE.delete(this.file);
            Logger.INSTANCE.coreLog$hive_core_release("[" + this.fileName + "] Property.delete = " + zDelete, Logger.LogType.Error);
        }
        return zDelete;
        return zDelete;
    }
}
