package com.com2us.security;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.ProxyInfo;
import android.os.Bundle;
import com.google.android.exoplayer2.MediaPeriodQueue;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import com.unity3d.services.core.fid.Constants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Hercules implements Application.ActivityLifecycleCallbacks {
    public static Activity mActivity = null;
    public static final JSONObject mAppGuardData = new JSONObject();
    public static Context mContext = null;
    public static long mLastUpdated = 0;
    public static String mUniqueUserId = "";
    public static final int mVersion = 20250219;

    public static native int initialize(Activity activity, String str);

    private static native void onDestroy(boolean z, String str);

    private static native void onPause(boolean z, String str);

    private static native void onResume(boolean z, String str);

    public static native void setDevBuild(String str);

    public static native void setDeviceId(String str);

    public static native void setPlayerId(String str);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    static {
        try {
            System.loadLibrary("Hercules");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private Hercules() {
    }

    public static void setAppguardUserId(String str) {
        try {
            try {
                Class.forName("com.inca.security.AppGuard.Sdk.Version");
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            Class<?> cls = Class.forName("com.inca.security.AppGuard.AppGuardClient");
            cls.getDeclaredMethod("setUserId", String.class).invoke(cls.newInstance(), str);
        }
    }

    public static void setAppGuardData(int i, byte[] bArr, EventParser eventParser) {
        boolean z;
        Object[] objArr;
        if (i == 0) {
            return;
        }
        if (i > 0) {
            z = true;
        } else {
            i = -i;
            z = false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("time", System.currentTimeMillis() / 1000);
            if (z) {
                jSONObject.put("kill", 1);
            }
            if (bArr != null && bArr.length > 0 && (bArr.length > 1 || bArr[0] != 0)) {
                try {
                    objArr = eventParser.parse(i, bArr);
                    if (objArr != null && objArr.length > 0) {
                        if (objArr.length == 1) {
                            jSONObject.put("data", (String) objArr[0]);
                        } else {
                            JSONArray jSONArray = new JSONArray();
                            for (Object obj : objArr) {
                                jSONArray.put((String) obj);
                            }
                            jSONObject.put("data", jSONArray);
                        }
                    }
                } catch (Exception unused) {
                    objArr = null;
                }
                if (objArr == null || objArr.length == 0) {
                    try {
                        jSONObject.put("data", new String(bArr, 0, bArr.length));
                    } catch (Exception unused2) {
                    }
                }
            }
            mAppGuardData.put(String.valueOf(Math.abs(i)), jSONObject);
            mLastUpdated = System.currentTimeMillis() / 1000;
        } catch (Exception unused3) {
        }
    }

    public static String getAppGuardData() {
        return mAppGuardData.toString();
    }

    public static String getAppguardVersion() {
        try {
            Class<?> cls = Class.forName("com.inca.security.AppGuard.AppGuardClient");
            String str = (String) cls.getDeclaredMethod(MobileAdsBridge.versionMethodName, new Class[0]).invoke(cls.newInstance(), new Object[0]);
            if (str == null) {
                return "";
            }
            try {
                str = str + " Sdk:" + String.format("%x", Integer.valueOf(Class.forName("com.inca.security.AppGuard.Sdk.Version").getField("SDK_VERSION").getInt(null)));
                return str + " Extra:" + String.format("%x", Integer.valueOf(Class.forName("com.inca.security.AppGuard.Extra.Version").getField("EXTRA_VERSION").getInt(null)));
            } catch (Exception unused) {
                return str;
            }
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String getXigncodeVersion() {
        try {
            Class<?> cls = Class.forName("com.wellbia.xigncode.XigncodeClient");
            Object objInvoke = cls.getMethod(Constants.GET_INSTANCE, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mXigncodeClient");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objInvoke);
            if (obj == null) {
                return "";
            }
            Class<?> cls2 = obj.getClass();
            Method declaredMethod = cls2.getDeclaredMethod("ZCWAVE_GetRevision", new Class[0]);
            declaredMethod.setAccessible(true);
            int iIntValue = ((Integer) declaredMethod.invoke(obj, new Object[0])).intValue();
            if (iIntValue <= 0) {
                return "";
            }
            String str = "Rev:" + iIntValue;
            Field declaredField2 = cls2.getDeclaredField("JAR_VERSION");
            declaredField2.setAccessible(true);
            return str + " Sdk:" + declaredField2.getInt(obj);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getUniqueInstanceId(Activity activity) {
        String str = mUniqueUserId;
        if (str == null || str.isEmpty()) {
            String string = activity.getSharedPreferences("HerculesPreferences", 0).getString("unique-instance-id", "");
            mUniqueUserId = string;
            if (string == null || string.isEmpty()) {
                String string2 = UUID.randomUUID().toString();
                String str2 = String.format(Locale.US, "%012d", Long.valueOf(Math.abs(Long.parseLong(string2.substring(0, 8) + string2.substring(9, 13), 16) % MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US)));
                mUniqueUserId = str2.substring(0, 4) + "-" + str2.substring(4, 8) + "-" + str2.substring(8, 12);
                activity.getSharedPreferences("HerculesPreferences", 0).edit().putString("unique-instance-id", mUniqueUserId).apply();
            }
        }
        return mUniqueUserId;
    }

    public static byte[] HttpRequest(String str, byte[] bArr) {
        byte[] byteArray = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDefaultUseCaches(false);
                if (bArr == null) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.close();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int i = inputStream.read(bArr2);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
                byteArray = byteArrayOutputStream.toByteArray();
                inputStream.close();
                byteArrayOutputStream.close();
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    private static boolean getProxyConnStatus_Lollipop() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(6);
        if ((networkInfo == null || !networkInfo.isConnected()) && (networkInfo2 == null || !networkInfo2.isConnected())) {
            return false;
        }
        String property = System.getProperty("http.proxyHost");
        return (property == null || property.isEmpty()) ? false : true;
    }

    public static boolean getProxyConnStatus() {
        String host;
        try {
            ProxyInfo defaultProxy = ((ConnectivityManager) mContext.getSystemService("connectivity")).getDefaultProxy();
            if (defaultProxy == null || (host = defaultProxy.getHost()) == null) {
                return false;
            }
            return !host.isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean getVPNConnStatus() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                return networkCapabilities.hasTransport(4);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String initialize(Activity activity) {
        mActivity = activity;
        activity.getApplication().registerActivityLifecycleCallbacks(new Hercules());
        return getUniqueInstanceId(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            if (mActivity.getClass() == activity.getClass()) {
                onResume(false, activity.getClass().toString());
            }
        } catch (Exception unused) {
            onResume(true, "");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        try {
            if (mActivity.getClass() == activity.getClass()) {
                onPause(false, activity.getClass().toString());
            }
        } catch (Exception unused) {
            onPause(true, "");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        try {
            if (mActivity.getClass() == activity.getClass()) {
                onDestroy(false, activity.getClass().toString());
            }
        } catch (Exception unused) {
            onDestroy(true, "");
        }
    }
}
