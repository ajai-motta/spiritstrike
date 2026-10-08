package com.hive.base;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.firebase.messaging.Constants;
import com.hive.HiveActivity;
import com.hive.base.EmulatorDetector;
import com.hive.core.Configuration;
import com.hive.core.Logger;
import com.hive.core.Platform;
import com.hive.core.Product;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.GoogleBase;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.KClasses;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0017\u001a\u00020\u0006J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0006J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u001fJ\b\u0010 \u001a\u0004\u0018\u00010\u0006J\n\u0010!\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0007J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u0004\u0018\u00010\u0006J\u0006\u0010,\u001a\u00020(J\b\u0010-\u001a\u0004\u0018\u00010\u0006J\b\u0010.\u001a\u0004\u0018\u00010\u0006J\b\u0010/\u001a\u0004\u0018\u00010\u0006J\u0012\u00100\u001a\u0004\u0018\u00010\u00062\b\u00101\u001a\u0004\u0018\u00010\u0006J\u001f\u00109\u001a\u00020:2\b\u00103\u001a\u0004\u0018\u00010\u00062\b\u00106\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010;J \u0010<\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\u0007J\u0006\u0010?\u001a\u00020\u0006J\b\u0010D\u001a\u00020\u0006H\u0007J\u0006\u0010E\u001a\u00020\u0007J\u0006\u0010F\u001a\u00020\u0007J\n\u0010G\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010H\u001a\u0004\u0018\u00010\u0006J\b\u0010I\u001a\u0004\u0018\u00010\u0006J\n\u0010J\u001a\u0004\u0018\u00010\u0006H\u0007J\n\u0010K\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010L\u001a\u0004\u0018\u00010\u00062\u0006\u0010)\u001a\u00020*H\u0007J-\u0010M\u001a\u0004\u0018\u00010\u00012\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00062\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010Q¢\u0006\u0002\u0010RJ\u0012\u0010S\u001a\u0004\u0018\u00010\u00012\b\u0010T\u001a\u0004\u0018\u00010\u0001J\u001c\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010V2\b\u0010W\u001a\u0004\u0018\u00010XJ\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00010Z2\b\u0010[\u001a\u0004\u0018\u00010\\J\u000e\u0010]\u001a\u00020X2\u0006\u0010^\u001a\u00020\u0001J\u001a\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010V2\u0006\u0010^\u001a\u00020\u0001J)\u0010`\u001a\u0004\u0018\u0001Ha\"\u0004\b\u0000\u0010a2\u0006\u0010b\u001a\u00020X2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002Ha0d¢\u0006\u0002\u0010eJ5\u0010f\u001a\u0004\u0018\u0001Ha\"\u0004\b\u0000\u0010a2\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010V2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002Ha0d¢\u0006\u0002\u0010hJ\u0010\u0010i\u001a\u0004\u0018\u00010\u00062\u0006\u0010^\u001a\u00020\u0001J\u0010\u0010j\u001a\u0004\u0018\u00010\u00012\u0006\u0010k\u001a\u00020\u0006J\u000e\u0010l\u001a\u00020:2\u0006\u0010m\u001a\u00020nJ\u0006\u0010o\u001a\u00020:J \u0010p\u001a\u00020\u00062\b\u0010q\u001a\u0004\u0018\u00010X2\u0006\u0010r\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\u0006J\u000e\u0010t\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*J\u0006\u0010~\u001a\u00020}J9\u0010\u007f\u001a\u000b\u0012\u0004\u0012\u0002Ha\u0018\u00010\u0080\u0001\"\u0004\b\u0000\u0010a2\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u0002Ha0\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u001a2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010nJ%\u0010\u0085\u0001\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0087\u0001\u001a\u00020(R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R$\u00103\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u00010\u00068F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R \u00106\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00078F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00105\"\u0004\bB\u0010CR\u000e\u0010u\u001a\u00020vX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010w\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u000e\u0010|\u001a\u00020}X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/hive/base/Android;", "", "<init>", "()V", "hwIds", "Ljava/util/HashMap;", "", "", "getHwIds", "()Ljava/util/HashMap;", "HW_IDS_ANDROID_ID", "HW_IDS_IMEI", "HW_IDS_ADVERTISING_ID", "HW_IDS_IS_LIMIT_AD_TRACKING", "HW_IDS_VENDOR_ID", "HW_IDS_DEVICE_TOKEN", "HW_IDS_DEVICE_MODEL", "HW_IDS_MDN", "HW_IDS_MCC", "HW_IDS_MNC", "getAgeGateU13", "hwIdsKey", "getPackageName", "getApplicationName", "getAppVersion", "getAppVersionCode", "", "isGrantedPermission", "permission", "getAndroidId", "internalGetAndroidId", "internalGetAndroidId$hive_service_release", "getDeviceModel", "getDeviceID", "getRealDisplaySize", "Landroid/graphics/Point;", "activity", "Landroid/app/Activity;", "getDisplaySize", "getStatusBarHeight", "", "context", "Landroid/content/Context;", "getOSVersion", "getOSVersionCode", "getCountry", "getLanguage", "getLanguageCode", "getLanguageAddScriptCode", "argLanguage", "value", Android.HW_IDS_ADVERTISING_ID, "getAdvertisingId", "()Ljava/lang/String;", Android.HW_IDS_IS_LIMIT_AD_TRACKING, "()Z", "isUpdating", "updateAdvertisingId", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "copyToClipboard", Constants.ScionAnalytics.PARAM_LABEL, "text", "getCPUType", "cachedEmulatorResult", "getCachedEmulatorResult$hive_service_release", "setCachedEmulatorResult$hive_service_release", "(Ljava/lang/String;)V", "isEmulator", "isGPGEmulator", "isRooting", "getMacAddress", "getMobileDeviceNumber", "internalGetMobileDeviceNumber", "getMobileCountryCode", "getMobileNetworkCode", "getNetworkCountryIso", "invokeStaticMethod", "className", "methodName", "objList", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", "mapToJSON", "mapObject", "jsonToMap", "", "inputObj", "Lorg/json/JSONObject;", "jsonToList", "", "array", "Lorg/json/JSONArray;", "fieldToJSON", "obj", "fieldToMap", "fromJSON", "T", "json", "returnType", "Ljava/lang/Class;", "(Lorg/json/JSONObject;Ljava/lang/Class;)Ljava/lang/Object;", "fromMap", "mapData", "(Ljava/util/Map;Ljava/lang/Class;)Ljava/lang/Object;", "serialize", "deserialize", "hexString", "runOnMainThread", AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, "Ljava/lang/Runnable;", "finish", "jsonOptString", "jsonObject", "key", "defaultValue", "hasDangerousPermissions", "mUiThreadHandler", "Landroid/os/Handler;", "NUMBER_OF_CORES", "getNUMBER_OF_CORES", "()I", "setNUMBER_OF_CORES", "(I)V", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "getExecutorService", "executeAsync", "Ljava/util/concurrent/Future;", "callable", "Ljava/util/concurrent/Callable;", "maxTimeout", "onTimeout", "isGooglePlayServicesAvailable", "show", "minApkVersion", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Android {
    public static final String HW_IDS_ADVERTISING_ID = "advertisingId";
    public static final String HW_IDS_ANDROID_ID = "androidId";
    public static final String HW_IDS_DEVICE_MODEL = "deviceModel";
    public static final String HW_IDS_DEVICE_TOKEN = "deviceToken";
    public static final String HW_IDS_IMEI = "imei";
    public static final String HW_IDS_IS_LIMIT_AD_TRACKING = "isLimitAdTracking";
    public static final String HW_IDS_MCC = "mcc";
    public static final String HW_IDS_MDN = "mdn";
    public static final String HW_IDS_MNC = "mnc";
    public static final String HW_IDS_VENDOR_ID = "vendorId";
    private static int NUMBER_OF_CORES;
    private static String advertisingId;
    private static String cachedEmulatorResult;
    private static boolean isLimitAdTracking;
    private static boolean isUpdating;
    private static ExecutorService mExecutorService;
    public static final Android INSTANCE = new Android();
    private static final HashMap<String, Boolean> hwIds = new HashMap<>();
    private static final Handler mUiThreadHandler = new Handler(Looper.getMainLooper());

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        NUMBER_OF_CORES = iAvailableProcessors;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(iAvailableProcessors);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        mExecutorService = executorServiceNewFixedThreadPool;
    }

    private Android() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeAsync$lambda$13(Future future, Runnable runnable) {
        if (future.isDone() || future.isCancelled()) {
            return;
        }
        future.cancel(true);
        if (runnable != null) {
            runnable.run();
        }
    }

    private final boolean getAgeGateU13(String hwIdsKey) {
        if (hwIdsKey != null && !StringsKt.isBlank(hwIdsKey)) {
            HashMap<String, Boolean> map = hwIds;
            if (map.containsKey(hwIdsKey)) {
                Boolean bool = map.get(hwIdsKey);
                return bool == null || !bool.booleanValue();
            }
        }
        return Configuration.INSTANCE.getAgeGateU13();
    }

    public static /* synthetic */ boolean isGooglePlayServicesAvailable$default(Android android2, Context context, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return android2.isGooglePlayServicesAvailable(context, z, i);
    }

    public final void copyToClipboard(Context context, String label, String text) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(text, "text");
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(label, text));
    }

    public final Object deserialize(String hexString) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        try {
            return new ObjectInputStream(new ByteArrayInputStream(new BigInteger(hexString, 16).toByteArray())).readObject();
        } catch (Exception e) {
            Logger.INSTANCE.w("[Android] deserialize()\ne: " + e.getMessage());
            return null;
        }
    }

    public final <T> Future<T> executeAsync(Callable<T> callable, long maxTimeout, final Runnable onTimeout) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        long j = (long) (maxTimeout * 0.95d);
        try {
            final Future<T> futureSubmit = getExecutorService().submit(callable);
            Intrinsics.checkNotNullExpressionValue(futureSubmit, "submit(...)");
            mUiThreadHandler.postDelayed(new Runnable() { // from class: com.hive.base.Android$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Android.executeAsync$lambda$13(futureSubmit, onTimeout);
                }
            }, j);
            return futureSubmit;
        } catch (Exception unused) {
            return null;
        }
    }

    public final JSONObject fieldToJSON(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        JSONObject jSONObject = new JSONObject();
        Collection memberProperties = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(obj.getClass()));
        ArrayList<KProperty1> arrayList = new ArrayList();
        for (Object obj2 : memberProperties) {
            if (((KProperty1) obj2).getVisibility() == KVisibility.PUBLIC) {
                arrayList.add(obj2);
            }
        }
        for (KProperty1 kProperty1 : arrayList) {
            try {
                String name = kProperty1.getName();
                Object obj3 = kProperty1.get(obj);
                if (obj3 instanceof Object[]) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object obj4 : (Object[]) obj3) {
                        if (obj4 != null) {
                            if (obj4 instanceof DataModel) {
                                jSONArray.put(((DataModel) obj4).toJSON());
                            } else {
                                jSONArray.put(obj4);
                            }
                        }
                    }
                    try {
                        jSONObject.put(name, jSONArray);
                    } catch (JSONException unused) {
                        Unit unit = Unit.INSTANCE;
                    }
                } else if (obj3 instanceof List) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (Object obj5 : (List) obj3) {
                        if (obj5 != null) {
                            if (obj5 instanceof DataModel) {
                                jSONArray2.put(((DataModel) obj5).toJSON());
                            } else {
                                jSONArray2.put(obj5);
                            }
                        }
                    }
                    try {
                        jSONObject.put(name, jSONArray2);
                    } catch (JSONException unused2) {
                        Unit unit2 = Unit.INSTANCE;
                    }
                } else if (obj3 instanceof Iterable) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (Object obj6 : (Iterable) obj3) {
                        if (obj6 != null) {
                            if (obj6 instanceof DataModel) {
                                jSONArray3.put(((DataModel) obj6).toJSON());
                            } else {
                                jSONArray3.put(obj6);
                            }
                        }
                    }
                    try {
                        jSONObject.put(name, jSONArray3);
                    } catch (JSONException unused3) {
                        Unit unit3 = Unit.INSTANCE;
                    }
                } else if (obj3 instanceof Enum) {
                    try {
                        jSONObject.put(name, ((Enum) obj3).name());
                    } catch (JSONException unused4) {
                        Unit unit4 = Unit.INSTANCE;
                    }
                } else {
                    try {
                        jSONObject.put(name, obj3);
                    } catch (JSONException unused5) {
                        Unit unit5 = Unit.INSTANCE;
                    }
                }
            } catch (IllegalAccessException e) {
                Logger.INSTANCE.e("[Android] fieldToJSON()\ne: " + e.getMessage());
            } catch (IllegalArgumentException e2) {
                Logger.INSTANCE.e("[Android] fieldToJSON()\ne: " + e2.getMessage());
            }
        }
        return jSONObject;
    }

    public final Map<String, Object> fieldToMap(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        HashMap map = new HashMap();
        Collection memberProperties = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(obj.getClass()));
        ArrayList<KProperty1> arrayList = new ArrayList();
        for (Object obj2 : memberProperties) {
            if (((KProperty1) obj2).getVisibility() == KVisibility.PUBLIC) {
                arrayList.add(obj2);
            }
        }
        for (KProperty1 kProperty1 : arrayList) {
            try {
                String name = kProperty1.getName();
                Object obj3 = kProperty1.get(obj);
                if (obj3 instanceof Object[]) {
                    map.put(name, obj3);
                } else if (obj3 instanceof List) {
                    map.put(name, obj3);
                } else if (obj3 instanceof Iterable) {
                    map.put(name, obj3);
                } else if (obj3 instanceof Enum) {
                    map.put(name, ((Enum) obj3).name());
                } else if (obj3 != null) {
                    map.put(name, obj3);
                }
            } catch (IllegalAccessException e) {
                Logger.INSTANCE.e("[Android] fieldToMap()\ne: " + e.getMessage());
            } catch (IllegalArgumentException e2) {
                Logger.INSTANCE.e("[Android] fieldToMap()\ne: " + e2.getMessage());
            }
        }
        return map;
    }

    public final void finish() {
        HiveLifecycle.INSTANCE.onReset();
        ActivityCompat.finishAffinity(HiveActivity.INSTANCE.getRecentActivity());
        System.runFinalizersOnExit(true);
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public final <T> T fromJSON(JSONObject json, Class<T> returnType) throws InvocationTargetException {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Field[] declaredFields = returnType.getDeclaredFields();
        T tNewInstance = null;
        try {
            try {
                tNewInstance = returnType.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Iterator it = ArrayIteratorKt.iterator(declaredFields);
                while (it.hasNext()) {
                    Field field = (Field) it.next();
                    try {
                        field.setAccessible(true);
                        String name = field.getName();
                        Object objOpt = json.opt(name);
                        Class<?> type = field.getType();
                        if (json.has(name)) {
                            if (type.isArray()) {
                                JSONArray jSONArrayOptJSONArray = json.optJSONArray(name);
                                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                                    Object objNewInstance = Array.newInstance(field.getType().getComponentType(), jSONArrayOptJSONArray.length());
                                    int length = jSONArrayOptJSONArray.length();
                                    for (int i = 0; i < length; i++) {
                                        try {
                                            Object obj = jSONArrayOptJSONArray.get(i);
                                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                                            Array.set(objNewInstance, i, obj);
                                        } catch (Exception unused) {
                                        }
                                    }
                                    field.set(tNewInstance, objNewInstance);
                                }
                            } else if (type.isAssignableFrom(List.class) || type.isAssignableFrom(ArrayList.class)) {
                                JSONArray jSONArrayOptJSONArray2 = json.optJSONArray(name);
                                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    int length2 = jSONArrayOptJSONArray2.length();
                                    for (int i2 = 0; i2 < length2; i2++) {
                                        try {
                                            Object obj2 = jSONArrayOptJSONArray2.get(i2);
                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
                                            arrayList.add(obj2);
                                        } catch (JSONException unused2) {
                                        }
                                    }
                                    field.set(tNewInstance, arrayList);
                                }
                            } else if (type.isEnum()) {
                                if (type.isInstance(objOpt)) {
                                    field.set(tNewInstance, objOpt);
                                } else if (objOpt instanceof String) {
                                    field.set(tNewInstance, objOpt);
                                }
                            } else if (Intrinsics.areEqual(Boolean.TYPE, type)) {
                                field.set(tNewInstance, Boolean.valueOf(json.optBoolean(name)));
                            } else {
                                field.set(tNewInstance, objOpt);
                            }
                        }
                    } catch (ClassCastException e) {
                        Logger.INSTANCE.e("[Android] fromJSON()\ne: " + e.getMessage());
                    } catch (IllegalAccessException e2) {
                        Logger.INSTANCE.e("[Android] fromJSON()\ne: " + e2.getMessage());
                    } catch (IllegalArgumentException e3) {
                        Logger.INSTANCE.e("[Android] fromJSON()\ne: " + e3.getMessage());
                    }
                }
            } catch (IllegalAccessException e4) {
                Logger.INSTANCE.e("[Android] fromJSON()\ne: " + e4.getMessage());
            }
        } catch (InstantiationException e5) {
            Logger.INSTANCE.e("[Android] fromJSON()\ne: " + e5.getMessage());
        }
        return tNewInstance;
    }

    public final <T> T fromMap(Map<String, ? extends Object> mapData, Class<T> returnType) throws InvocationTargetException {
        Intrinsics.checkNotNullParameter(mapData, "mapData");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Field[] declaredFields = returnType.getDeclaredFields();
        T tNewInstance = null;
        try {
            try {
                tNewInstance = returnType.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Iterator it = ArrayIteratorKt.iterator(declaredFields);
                while (it.hasNext()) {
                    Field field = (Field) it.next();
                    try {
                        field.setAccessible(true);
                        String name = field.getName();
                        if (mapData.containsKey(name)) {
                            Object obj = mapData.get(name);
                            Class<?> type = field.getType();
                            if (type.isArray() && Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String[].class), type)) {
                                if (obj instanceof Object[]) {
                                    field.set(tNewInstance, obj);
                                } else if (obj instanceof String) {
                                    field.set(tNewInstance, TextUtils.split((String) obj, ","));
                                }
                            } else if (type.isEnum()) {
                                if (type.isInstance(obj)) {
                                    field.set(tNewInstance, obj);
                                } else if (obj instanceof String) {
                                    field.set(tNewInstance, obj);
                                }
                            } else if (!Intrinsics.areEqual(Boolean.TYPE, type)) {
                                field.set(tNewInstance, obj);
                            } else if (obj instanceof Boolean) {
                                field.set(tNewInstance, obj);
                            } else if (obj instanceof String) {
                                field.set(tNewInstance, Boolean.valueOf(Boolean.parseBoolean((String) obj)));
                            }
                        }
                    } catch (ClassCastException e) {
                        Logger.INSTANCE.e("[Android] fromMap()\ne: " + e.getMessage());
                    } catch (IllegalAccessException e2) {
                        Logger.INSTANCE.e("[Android] fromMap()\ne: " + e2.getMessage());
                    } catch (IllegalArgumentException e3) {
                        Logger.INSTANCE.e("[Android] fromMap()\ne: " + e3.getMessage());
                    }
                }
            } catch (InstantiationException e4) {
                Logger.INSTANCE.e("[Android] fromMap()\ne: " + e4.getMessage());
            }
        } catch (IllegalAccessException e5) {
            Logger.INSTANCE.e("[Android] fromMap()\ne: " + e5.getMessage());
        }
        return tNewInstance;
    }

    public final String getAdvertisingId() {
        if (getAgeGateU13(HW_IDS_ADVERTISING_ID)) {
            return null;
        }
        return advertisingId;
    }

    public final String getAndroidId() {
        if (getAgeGateU13(HW_IDS_ANDROID_ID)) {
            return null;
        }
        return internalGetAndroidId$hive_service_release();
    }

    public final String getAppVersion() {
        return Product.INSTANCE.getBuildVersion();
    }

    public final long getAppVersionCode() {
        return Product.INSTANCE.getAppVersionCode();
    }

    public final String getApplicationName() {
        return Product.INSTANCE.getApplicationName();
    }

    public final String getCPUType() {
        return Platform.INSTANCE.getCpuType();
    }

    public final String getCachedEmulatorResult$hive_service_release() {
        return cachedEmulatorResult;
    }

    public final String getCountry() {
        return Platform.INSTANCE.getCountry();
    }

    @Deprecated(message = "4.15.0")
    public final String getDeviceID() {
        return null;
    }

    public final String getDeviceModel() {
        if (getAgeGateU13(HW_IDS_DEVICE_MODEL)) {
            return null;
        }
        return Platform.INSTANCE.getDeviceModel();
    }

    public final Point getDisplaySize(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        return new Point(point.x, point.y);
    }

    public final ExecutorService getExecutorService() {
        return mExecutorService;
    }

    public final HashMap<String, Boolean> getHwIds() {
        return hwIds;
    }

    public final String getLanguage() {
        return Platform.INSTANCE.getLanguage();
    }

    public final String getLanguageCode() {
        return getLanguageAddScriptCode(getLanguage());
    }

    @Deprecated(message = "")
    public final String getMacAddress() {
        return Platform.INSTANCE.getMacAddress();
    }

    @Deprecated(message = "4.15.0")
    public final String getMobileCountryCode() {
        return null;
    }

    public final String getMobileDeviceNumber() {
        if (getAgeGateU13(HW_IDS_MDN)) {
            return null;
        }
        return internalGetMobileDeviceNumber();
    }

    @Deprecated(message = "4.15.0")
    public final String getMobileNetworkCode() {
        return null;
    }

    public final int getNUMBER_OF_CORES() {
        return NUMBER_OF_CORES;
    }

    @Deprecated(message = "4.15.0")
    public final String getNetworkCountryIso(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    public final String getOSVersion() {
        return Platform.INSTANCE.getOsVersion();
    }

    public final int getOSVersionCode() {
        return Platform.INSTANCE.getOsAPILevel();
    }

    public final String getPackageName() {
        return Product.INSTANCE.getAppIdentifier();
    }

    public final Point getRealDisplaySize(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getRealSize(point);
        return new Point(point.x, point.y);
    }

    public final int getStatusBarHeight(Context context) {
        int identifier;
        Intrinsics.checkNotNullParameter(context, "context");
        if ((context.getResources().getConfiguration().screenLayout & 15) == 4 || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public final boolean hasDangerousPermissions(Context context) {
        String str;
        PermissionGroupInfo permissionGroupInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = false;
        try {
            String[] strArr = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr == null) {
                return false;
            }
            boolean z2 = false;
            for (String str2 : strArr) {
                try {
                    try {
                        PermissionInfo permissionInfo = context.getPackageManager().getPermissionInfo(str2, 0);
                        if (permissionInfo != null && (str = permissionInfo.group) != null && (permissionGroupInfo = context.getPackageManager().getPermissionGroupInfo(str, 0)) != null && (Intrinsics.areEqual("android.permission-group.PHONE", permissionGroupInfo.name) || Intrinsics.areEqual("android.permission-group.STORAGE", permissionGroupInfo.name) || Intrinsics.areEqual("android.permission-group.CONTACTS", permissionGroupInfo.name) || Intrinsics.areEqual("android.permission-group.MICROPHONE", permissionGroupInfo.name) || Intrinsics.areEqual("android.permission-group.LOCATION", permissionGroupInfo.name) || Intrinsics.areEqual("android.permission-group.CAMERA", permissionGroupInfo.name) || Intrinsics.areEqual("android.permission-group.CALENDAR", permissionGroupInfo.name) || Intrinsics.areEqual("android.permission-group.SMS", permissionGroupInfo.name) || Intrinsics.areEqual("android.permission-group.SENSORS", permissionGroupInfo.name))) {
                            z2 = true;
                        }
                    } catch (Exception e) {
                        Logger.INSTANCE.w("[Android] hasDangerousPermissions()\ne: " + e.getMessage());
                    }
                } catch (Exception e2) {
                    e = e2;
                    z = z2;
                }
            }
            return z2;
        } catch (Exception e3) {
            e = e3;
        }
        Logger.INSTANCE.w("[Android] hasDangerousPermissions()\ne: " + e.getMessage());
        return z;
    }

    public final String internalGetAndroidId$hive_service_release() {
        return Platform.INSTANCE.getAndroidId();
    }

    public final String internalGetMobileDeviceNumber() {
        return Platform.INSTANCE.getMdn();
    }

    public final Object invokeStaticMethod(String className, String methodName, Object[] objList) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        try {
            Class<?> cls = Class.forName(className);
            Intrinsics.checkNotNullExpressionValue(cls, "forName(...)");
            Method[] methods = cls.getMethods();
            int length = methods.length;
            for (int i = 0; i < length; i++) {
                if (Intrinsics.areEqual(methods[i].getName(), methodName)) {
                    if (!Intrinsics.areEqual(methods[i].getReturnType().getName(), "void")) {
                        return methods[i].invoke(null, objList);
                    }
                    methods[i].invoke(null, objList);
                    return null;
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public final String isEmulator() {
        String str = cachedEmulatorResult;
        if (str != null) {
            return str;
        }
        try {
            EmulatorDetector.Emulator emulatorCheckEmulator = new EmulatorDetector(HiveActivity.INSTANCE.getRecentActivity()).checkEmulator();
            if (emulatorCheckEmulator == null) {
                cachedEmulatorResult = "";
                return "";
            }
            cachedEmulatorResult = emulatorCheckEmulator.getEmulatorName();
            return emulatorCheckEmulator.getEmulatorName();
        } catch (Exception e) {
            cachedEmulatorResult = "";
            Logger.INSTANCE.w(e.toString());
            return "";
        }
    }

    public final boolean isGPGEmulator() {
        if (HiveActivity.isActivityInitialized()) {
            return HiveActivity.INSTANCE.getRecentActivity().getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
        }
        return false;
    }

    public final boolean isGooglePlayServicesAvailable(Context context, boolean show, int minApkVersion) {
        Intrinsics.checkNotNullParameter(context, "context");
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = GoogleBase.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof GoogleBase)) {
            hiveModule = null;
        }
        GoogleBase googleBase = (GoogleBase) (hiveModule instanceof GoogleBase ? hiveModule : null);
        if (googleBase != null) {
            return googleBase.isGooglePlayServicesAvailable(context, show, minApkVersion);
        }
        Logger.INSTANCE.e("[isGooglePlayServicesAvailable] Google-Base Missing Library.");
        return false;
    }

    public final boolean isGrantedPermission(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return Platform.INSTANCE.isGrantedPermission(permission);
    }

    public final boolean isLimitAdTracking() {
        if (getAgeGateU13(HW_IDS_IS_LIMIT_AD_TRACKING)) {
            return false;
        }
        return isLimitAdTracking;
    }

    public final boolean isRooting() {
        String[] strArr = {"/system/bin/su", "/system/xbin/su", "/system/app/Superuser.apk", "/data/data/com.noshufou.android.su", "/sbin/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/data/local/su", "/data/local/bin/su", "/data/local/xbin/su"};
        boolean zExists = false;
        for (int i = 0; i < 10; i++) {
            zExists |= new File(strArr[i]).exists();
        }
        if (!zExists) {
            try {
                Runtime.getRuntime().exec(AndroidStaticDeviceInfoDataSource.BINARY_SU);
                return true;
            } catch (Exception unused) {
            }
        }
        return zExists;
    }

    public final String jsonOptString(JSONObject jsonObject, String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (jsonObject != null) {
            String strOptString = jsonObject.optString(key, defaultValue);
            if (strOptString == null) {
                strOptString = "";
            }
            if (!Intrinsics.areEqual(JsonUtils.EMPTY_JSON, strOptString)) {
                return strOptString;
            }
        }
        return defaultValue;
    }

    public final List<Object> jsonToList(JSONArray array) {
        ArrayList arrayList = new ArrayList();
        if (array != null) {
            int length = array.length();
            for (int i = 0; i < length; i++) {
                Object objOpt = array.opt(i);
                if (objOpt != null) {
                    if (objOpt instanceof JSONArray) {
                        objOpt = jsonToList((JSONArray) objOpt);
                    } else if (objOpt instanceof JSONObject) {
                        objOpt = jsonToMap((JSONObject) objOpt);
                    }
                    arrayList.add(objOpt);
                }
            }
        }
        return arrayList;
    }

    public final Map<String, Object> jsonToMap(JSONObject inputObj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (inputObj != null) {
            Iterator<String> itKeys = inputObj.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = inputObj.opt(next);
                if (objOpt != null) {
                    if (objOpt instanceof JSONArray) {
                        objOpt = INSTANCE.jsonToList((JSONArray) objOpt);
                    } else if (objOpt instanceof JSONObject) {
                        objOpt = INSTANCE.jsonToMap((JSONObject) objOpt);
                    }
                    linkedHashMap.put(next, objOpt);
                }
            }
        }
        return linkedHashMap;
    }

    public final Object mapToJSON(Object mapObject) {
        try {
            if (mapObject instanceof Map) {
                JSONObject jSONObject = new JSONObject();
                for (Object obj : ((Map) mapObject).keySet()) {
                    jSONObject.put(String.valueOf(obj), mapToJSON(((Map) mapObject).get(obj)));
                }
                return jSONObject;
            }
            if (!(mapObject instanceof Iterable)) {
                return mapObject;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((Iterable) mapObject).iterator();
            while (it.hasNext()) {
                jSONArray.put(mapToJSON(it.next()));
            }
            return jSONArray;
        } catch (Exception e) {
            Logger.INSTANCE.e("[Android] mapToJSON()\ne: " + e.getMessage());
            return new JSONObject();
        }
    }

    public final void runOnMainThread(Runnable r) {
        Intrinsics.checkNotNullParameter(r, "r");
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            r.run();
        } else {
            new Handler(Looper.getMainLooper()).post(r);
        }
    }

    public final String serialize(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return new BigInteger(byteArrayOutputStream.toByteArray()).toString(16);
        } catch (Exception e) {
            Logger.INSTANCE.w("[Android] serialize()\ne: " + e.getMessage());
            return null;
        }
    }

    public final void setCachedEmulatorResult$hive_service_release(String str) {
        cachedEmulatorResult = str;
    }

    public final void setNUMBER_OF_CORES(int i) {
        NUMBER_OF_CORES = i;
    }

    public final synchronized void updateAdvertisingId(String advertisingId2, Boolean isLimitAdTracking2) {
        if (advertisingId2 != null) {
            try {
                advertisingId = advertisingId2;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (isLimitAdTracking2 != null) {
            isLimitAdTracking = isLimitAdTracking2.booleanValue();
        }
    }

    public final String getLanguageAddScriptCode(String argLanguage) {
        JSONObject jSONObject;
        String str;
        String lowerCase;
        String str2;
        String strOptString;
        String strOptString2;
        String str3;
        try {
            JSONObject jSONObject2 = new JSONObject("{\"ko\":\"ko\",\"en\":\"en\",\"ja\":\"ja\",\"zh-hans\":\"zh-hans\",\"zh-hant\":\"zh-hant\",\"ru\":\"ru\",\"de\":\"de\",\"fr\":\"fr\",\"es\":\"es\",\"id\":\"id\",\"th\":\"th\",\"tr\":\"tr\",\"vi\":\"vi\",\"it\":\"it\",\"pt\":\"pt\",\"zh\":\"exception\",\"zh_HK\":\"zh-hant\",\"zh_TW\":\"zh-hant\",\"zh_MO\":\"zh-hant\",\"zh_CN\":\"zh-hans\",\"zh_SG\":\"zh-hans\"}");
            try {
                jSONObject = new JSONObject("{\"zh\":\"zh-hant\"}");
            } catch (JSONException e) {
                Logger.INSTANCE.w("[Android] getLanguageAddScriptCode() jsonDataExceptionLanguageTable\ne: " + e.getMessage());
                jSONObject = null;
            }
            if (argLanguage != null) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase2 = argLanguage.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                str = lowerCase2;
            } else {
                str = null;
            }
            try {
                lowerCase = Locale.getDefault().getScript();
            } catch (Exception e2) {
                e2.getStackTrace();
                lowerCase = null;
            }
            String country = Locale.getDefault().getCountry();
            Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
            Locale US2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US2, "US");
            String upperCase = country.toUpperCase(US2);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String[] iSOCountries = Locale.getISOCountries();
            if (!Arrays.asList(Arrays.copyOf(iSOCountries, iSOCountries.length)).contains(upperCase)) {
                if (lowerCase == null) {
                    if (upperCase != null) {
                        Intrinsics.checkNotNullExpressionValue(US2, "US");
                        lowerCase = upperCase.toLowerCase(US2);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    } else {
                        lowerCase = null;
                    }
                }
                upperCase = null;
            }
            if (lowerCase != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str4 = String.format("%s-%s", Arrays.copyOf(new Object[]{str, lowerCase}, 2));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                Intrinsics.checkNotNullExpressionValue(US2, "US");
                String lowerCase3 = str4.toLowerCase(US2);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                try {
                    String strOptString3 = jSONObject2.optString(lowerCase3, null);
                    if (strOptString3 != null) {
                        if (!Intrinsics.areEqual(strOptString3, "exception")) {
                            return strOptString3;
                        }
                    }
                } catch (Exception e3) {
                    Logger.INSTANCE.w("[Android] getLanguageAddScriptCode() scriptCode\ne: " + e3.getMessage());
                }
            }
            if (upperCase != null) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str5 = String.format("%s_%s", Arrays.copyOf(new Object[]{str, upperCase}, 2));
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                try {
                    String strOptString4 = jSONObject2.optString(str5, null);
                    if (strOptString4 != null) {
                        if (!Intrinsics.areEqual(strOptString4, "exception")) {
                            return strOptString4;
                        }
                    }
                } catch (Exception e4) {
                    Logger.INSTANCE.w("[Android] getLanguageAddScriptCode() countryCode\ne: " + e4.getMessage());
                }
            }
            if (argLanguage != null) {
                Locale US3 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US3, "US");
                String lowerCase4 = argLanguage.toLowerCase(US3);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                str2 = lowerCase4;
            } else {
                str2 = null;
            }
            try {
                strOptString = jSONObject2.optString(str2, null);
            } catch (Exception e5) {
                Logger.INSTANCE.w("[Android] getLanguageAddScriptCode() currentLanguage\ne: " + e5.getMessage());
                strOptString = null;
            }
            if (strOptString == null) {
                return argLanguage;
            }
            if (Intrinsics.areEqual(strOptString, "exception")) {
                if (jSONObject != null) {
                    str3 = null;
                    try {
                        strOptString2 = jSONObject.optString(str2, null);
                    } catch (Exception unused) {
                        strOptString2 = str3;
                    }
                } else {
                    str3 = null;
                }
                strOptString2 = str3;
            } else {
                strOptString2 = strOptString;
            }
            return strOptString2 == null ? argLanguage : strOptString2;
        } catch (JSONException e6) {
            Logger.INSTANCE.w("[Android] getLanguageAddScriptCode() \ne: " + e6.getMessage());
            return argLanguage;
        }
    }
}
