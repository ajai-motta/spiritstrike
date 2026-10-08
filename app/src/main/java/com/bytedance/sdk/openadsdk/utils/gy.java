package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.webkit.ProxyConfig;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.tvp.mo;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.ml.ModelManager;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class gy {
    private static String bjy;
    private static final byte[] exu;
    private static final byte[] fs;
    public static Integer qdl;
    private static String rdp;
    private static final HashSet<String> rq;
    private static final ExecutorService ud = Executors.newSingleThreadExecutor();
    private static volatile boolean lnr = false;
    private static final AtomicInteger mml = new AtomicInteger(0);
    private static volatile String mzz = "";
    private static final ReentrantLock mo = new ReentrantLock();
    private static String wd = null;
    private static String jpc = null;
    private static String tvp = null;
    private static final HashSet<String> to = new HashSet<>(Arrays.asList("Asia/Shanghai", "Asia/Urumqi", "Asia/Chongqing", "Asia/Harbin", "Asia/Kashgar"));

    public static boolean mml(int i) {
        return i == 4;
    }

    public static boolean mml(Context context) {
        return false;
    }

    public static boolean mo(int i) {
        return i == 6;
    }

    public static boolean mzz(int i) {
        return i == 5;
    }

    public static void qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, View view) {
    }

    public static int wd(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 4) {
            return 1;
        }
        if (i == 5) {
            return 4;
        }
        if (i != 6) {
            return i;
        }
        return 5;
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        rq = hashSet;
        hashSet.addAll(Arrays.asList("America/Eirunepe", "America/Rio_Branco", "America/Boa_Vista", "America/Campo_Grande", "America/Cuiaba", "America/Manaus", "America/Porto_Velho", "America/Araguaina", "America/Bahia", "America/Belem", "America/Fortaleza", "America/Maceio", "America/Recife", "America/Santarem", "America/Sao_Paulo", "America/Noronha"));
        qdl = null;
        fs = new byte[]{108, 111, 97, 100, 105, 110, 103};
        exu = new byte[]{97, 114, 98, 105, 116, 114, 97, 103, 101};
    }

    public static Intent qdl(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static ud qdl(Context context, Intent intent) {
        return new ud(null, 0);
    }

    public static class ud {
        public final ComponentName qdl;
        public final int ud;

        public ud(ComponentName componentName, int i) {
            this.qdl = componentName;
            this.ud = i;
        }
    }

    public static boolean qdl() {
        return (com.bytedance.sdk.openadsdk.core.bjy.qdl() == null || com.bytedance.sdk.openadsdk.core.bjy.qdl().mml()) ? false : true;
    }

    public static boolean ud(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                com.bytedance.sdk.component.utils.ud.qdl(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String qdl(int i) {
        if (i == 1) {
            return "embeded_ad";
        }
        if (i == 2) {
            return "banner_ad";
        }
        if (i == 3) {
            return "interaction";
        }
        if (i == 4) {
            return "open_ad";
        }
        if (i == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i != 7) {
            return null;
        }
        return "rewarded_video";
    }

    public static String ud(int i) {
        if (i == 1) {
            return "embeded_ad_landingpage";
        }
        if (i == 2) {
            return "banner_ad_landingpage";
        }
        if (i == 3) {
            return "interaction_landingpage";
        }
        if (i == 4) {
            return "splash_ad_landingpage";
        }
        if (i == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i == 7) {
            return "rewarded_video_landingpage";
        }
        return "unknow";
    }

    public static String qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        if (ljhVar == null) {
            return null;
        }
        try {
            return lnr(ljhVar.vz());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int ud(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        if (ljhVar == null) {
            return -1;
        }
        int iVz = ljhVar.vz();
        int i = 1;
        if (iVz == 1) {
            return 2;
        }
        if (iVz == 3) {
            return 4;
        }
        if (iVz != 5) {
            i = 7;
            if (iVz != 7) {
                return iVz != 8 ? -1 : 5;
            }
        }
        return i;
    }

    public static int qdl(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "open_ad":
            case "cache_splash_ad":
                return 4;
            case "fullscreen_interstitial_ad":
                return 5;
            case "interaction":
                return 3;
            default:
                return 1;
        }
    }

    public static String lnr(int i) {
        if (i == 1) {
            return "banner_ad";
        }
        if (i == 2) {
            return "interaction";
        }
        if (i == 3 || i == 4) {
            return "open_ad";
        }
        if (i == 7) {
            return "rewarded_video";
        }
        if (i == 8) {
            return "fullscreen_interstitial_ad";
        }
        return "embeded_ad";
    }

    public static String ud() {
        String str = "unKnow";
        com.bytedance.sdk.openadsdk.multipro.lnr.qdl(com.bytedance.sdk.openadsdk.core.yt.qdl());
        try {
            String strUd = com.bytedance.sdk.openadsdk.multipro.ud.lnr() ? com.bytedance.sdk.openadsdk.multipro.mml.qdl.ud("sp_multi_ua_data", "android_system_ua", "unKnow") : com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("android_system_ua", "unKnow");
            if (strUd != null && !"unKnow".equals(strUd)) {
                return strUd;
            }
            FutureTask futureTask = new FutureTask(new qdl(2));
            ud.execute(futureTask);
            str = (String) futureTask.get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.utils.aaj.lnr("getUA", " getAndroidSystemUA userAgent".concat(String.valueOf(str)));
        return str;
    }

    public static void lnr() {
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl("recycle_version_not_valid", false, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.utils.gy.1
            @Override // com.bytedance.sdk.openadsdk.bjy.ud
            public com.bytedance.sdk.openadsdk.bjy.qdl.lnr getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("method_exist", gy.rc());
                return com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl("recycle_version_not_valid").ud(jSONObject.toString());
            }
        });
    }

    public static String mml() {
        if (!TextUtils.isEmpty(mzz)) {
            return mzz;
        }
        com.bytedance.sdk.openadsdk.multipro.lnr.qdl(com.bytedance.sdk.openadsdk.core.yt.qdl());
        String strQdl = com.bytedance.sdk.openadsdk.core.tvp.qdl("sdk_local_web_ua", 86400000L);
        mzz = strQdl;
        if (TextUtils.isEmpty(strQdl)) {
            ReentrantLock reentrantLock = mo;
            try {
                if (reentrantLock.tryLock()) {
                    try {
                        if (TextUtils.isEmpty(mzz)) {
                            mzz = WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.yt.qdl());
                        }
                        com.bytedance.sdk.openadsdk.core.tvp.qdl("sdk_local_web_ua", mzz);
                        reentrantLock.unlock();
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.aaj.qdl("TTAD.ToolUtils", "", e);
                    } catch (NoClassDefFoundError e2) {
                        com.bytedance.sdk.component.utils.aaj.qdl("TTAD.ToolUtils", "", e2);
                    }
                }
            } finally {
                mo.unlock();
            }
        }
        return mzz;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.utils.gy$2, reason: invalid class name */
    static class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(gy.mzz)) {
                    com.bytedance.sdk.component.tvp.mo moVar = new com.bytedance.sdk.component.tvp.mo(com.bytedance.sdk.openadsdk.core.yt.qdl(), mo.lnr.USER_AGENT);
                    moVar.setWebViewClient(new mo.qdl());
                    String unused = gy.mzz = moVar.getUserAgentString();
                    com.bytedance.sdk.component.utils.vu.qdl(moVar);
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.aaj.qdl("TTAD.ToolUtils", "", e);
            } catch (NoClassDefFoundError e2) {
                com.bytedance.sdk.component.utils.aaj.qdl("TTAD.ToolUtils", "", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hzv() {
        try {
            WebView webView = new WebView(com.bytedance.sdk.openadsdk.core.yt.qdl());
            webView.setWebViewClient(new mo.qdl());
            String userAgentString = webView.getSettings().getUserAgentString();
            if (userAgentString != null && !"unKnow".equals(userAgentString)) {
                if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                    com.bytedance.sdk.openadsdk.multipro.mml.qdl.qdl("sp_multi_ua_data", "webview_ua", userAgentString);
                } else {
                    com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("webview_ua", userAgentString);
                }
            }
            return userAgentString;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("getUA", "e:" + th.getMessage());
            return "unKnow";
        }
    }

    public static class qdl implements Callable<String> {
        private final int qdl;

        qdl(int i) {
            this.qdl = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public synchronized String call() throws Exception {
            String strUd;
            strUd = "unKnow";
            int i = this.qdl;
            if (i == 1) {
                strUd = lnr();
            } else if (i == 2) {
                strUd = ud();
            }
            return strUd;
        }

        private String ud() {
            String property;
            Throwable th;
            try {
                property = System.getProperty("http.agent");
                if (property != null) {
                    try {
                        if (!"unKnow".equals(property)) {
                            if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                                com.bytedance.sdk.openadsdk.multipro.mml.qdl.qdl("sp_multi_ua_data", "android_system_ua", property);
                            } else {
                                com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("android_system_ua", property);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.bytedance.sdk.component.utils.aaj.lnr("getUA", "e:" + th.getMessage());
                    }
                }
            } catch (Throwable th3) {
                property = "unKnow";
                th = th3;
            }
            return property;
        }

        private synchronized String lnr() {
            final String[] strArr;
            strArr = new String[]{"unKnow"};
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.gy.qdl.1
                @Override // java.lang.Runnable
                public void run() {
                    strArr[0] = gy.hzv();
                    String str = strArr[0];
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                com.bytedance.sdk.component.utils.aaj.lnr("TTAD.ToolUtils", e.getMessage());
            }
            return strArr[0];
        }
    }

    public static String mzz() {
        return uw.qdl();
    }

    public static synchronized String mo() {
        Context contextQdl;
        if (TextUtils.isEmpty(wd) && (contextQdl = com.bytedance.sdk.openadsdk.core.yt.qdl()) != null) {
            try {
                wd = contextQdl.getPackageName();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.qdl("TTAD.ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return wd;
    }

    public static synchronized String wd() {
        if (TextUtils.isEmpty(jpc) && com.bytedance.sdk.openadsdk.core.yt.qdl() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.yt.qdl().getPackageManager().getPackageInfo(mo(), 0);
                jpc = String.valueOf(packageInfo.versionCode);
                tvp = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.qdl("TTAD.ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return jpc;
    }

    public static synchronized String jpc() {
        if (TextUtils.isEmpty(tvp) && com.bytedance.sdk.openadsdk.core.yt.qdl() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.yt.qdl().getPackageManager().getPackageInfo(mo(), 0);
                jpc = String.valueOf(packageInfo.versionCode);
                tvp = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.qdl("TTAD.ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return tvp;
    }

    public static String qdl(Context context) {
        String strUd = com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("total_memory", (String) null);
        if (strUd == null || ud(strUd) <= 0) {
            strUd = lnr("MemTotal");
            if (ud(strUd) <= 0) {
                strUd = tvp();
            }
            com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("total_memory", strUd);
        }
        return strUd;
    }

    public static long ud(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String tvp() {
        try {
            ActivityManager activityManager = (ActivityManager) com.bytedance.sdk.openadsdk.core.yt.qdl().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            if (memoryInfo.totalMem > 0) {
                return String.valueOf(memoryInfo.totalMem / 1024);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String to() {
        return com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("total_memory", AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public static String rq() {
        return lnr("MemTotal");
    }

    public static String lnr(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        try {
            fileReader = new FileReader(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MEM_INFO);
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return null;
                        } finally {
                        }
                    }
                } while (!line.contains(str));
                if (line == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String str2 = line.split("\\s+")[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static long ud(Context context) {
        return com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("total_internal_storage", 0L).longValue();
    }

    public static long fs() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long exu() {
        return com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("free_internal_storage", 0L).longValue();
    }

    public static long rdp() {
        return com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("total_sdcard_storage", 0L).longValue();
    }

    public static long bjy() {
        try {
            if (!fco()) {
                return 0L;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.ToolUtils", th.getMessage());
            return 0L;
        }
    }

    private static boolean fco() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int jtx() {
        return com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("is_root", -1);
    }

    public static boolean yt() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String mml(String str) {
        return qdl(str, false, false);
    }

    public static String qdl(String str, boolean z, boolean z2) {
        String strJl;
        if (str != null && !str.startsWith(DomExceptionUtils.SEPARATOR)) {
            str = DomExceptionUtils.SEPARATOR.concat(String.valueOf(str));
        }
        if (z2) {
            strJl = aaj();
        } else {
            strJl = jl();
        }
        if (TextUtils.isEmpty(strJl)) {
            strJl = "api16-access-ttp.tiktokpangle.us";
        }
        String strQdl = "https://" + strJl + str;
        if (hzv.qdl() && !z) {
            strQdl = hzv.qdl(strQdl);
        }
        return z ? fs(strQdl) : strQdl;
    }

    public static String jl() {
        String strAg = com.bytedance.sdk.openadsdk.core.yt.mml().ag();
        return TextUtils.isEmpty(strAg) ? jyq.qdl() : strAg;
    }

    public static String exc() {
        String strZpu = com.bytedance.sdk.openadsdk.core.yt.mml().zpu();
        if (!TextUtils.isEmpty(strZpu)) {
            return strZpu;
        }
        String strQdl = jyq.qdl();
        if (TextUtils.isEmpty(strQdl)) {
            return strZpu;
        }
        return "https://" + strQdl + "/service/2/dual_events/";
    }

    public static String aaj() {
        String strGsp = com.bytedance.sdk.openadsdk.core.settings.rq.gsp();
        if (!TextUtils.isEmpty(strGsp)) {
            return strGsp;
        }
        String strWc = com.bytedance.sdk.openadsdk.core.yt.mml().wc();
        return TextUtils.isEmpty(strWc) ? jyq.qdl() : strWc;
    }

    private static String fs(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", wd()).toString();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.ToolUtils", e.getMessage());
            return str;
        }
    }

    public static String mzz(String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.bytedance.sdk.openadsdk.core.yt.mml().om();
        }
        if (TextUtils.isEmpty(str)) {
            return "https://api16-access-ttp.tiktokpangle.us/service/2/app_log/";
        }
        return !str.startsWith(ProxyConfig.MATCH_HTTP) ? "https://".concat(String.valueOf(str)) : str;
    }

    public static String jyq() {
        return String.format(Constants.BASE_URL_NO_SUB_DOMAIN_FORMAT, "log.byteoversea.com/service/2/app_log_test/");
    }

    public static String oth() {
        return "https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/renderer/package_tx.json";
    }

    public static String ljh() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.ToolUtils", e.toString());
            return "";
        }
    }

    public static int bch() {
        try {
            String id = TimeZone.getDefault().getID();
            if (to.contains(id)) {
                return 2;
            }
            if (id != null && id.startsWith("Asia/")) {
                return 2;
            }
            if (id != null && id.startsWith("Europe/")) {
                return 4;
            }
            if (id != null && id.startsWith("America/")) {
                if (!rq.contains(id)) {
                    return 5;
                }
            }
            return 3;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.ToolUtils", th.toString());
            return 0;
        }
    }

    public static String lnr(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.ToolUtils", e.toString());
            return "";
        }
    }

    public static int uw() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / Constants.ONE_HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static String xmv() {
        int i = -uw();
        if (i >= 0) {
            return "Etc/GMT+".concat(String.valueOf(i));
        }
        return "Etc/GMT".concat(String.valueOf(i));
    }

    public static JSONObject qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, long j, com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
        if (ljhVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("creative_id", ljhVar.yre());
            jSONObject.put("buffers_time", j);
            com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud udVarTdy = ljhVar.tdy();
            if (udVarTdy != null) {
                jSONObject.put("video_size", udVarTdy.mzz());
                jSONObject.put("video_resolution", udVarTdy.tvp());
            }
            qdl(jSONObject, qdlVar);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.aaj.qdl("TTAD.ToolUtils", "getVideoAction json error", e);
        }
        return jSONObject;
    }

    private static void qdl(JSONObject jSONObject, com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
        if (jSONObject.has("video_resolution") || qdlVar == null) {
            return;
        }
        try {
            jSONObject.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(qdlVar.mml()), Integer.valueOf(qdlVar.mzz())));
        } catch (Throwable unused) {
        }
    }

    public static boolean mo(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, String str) {
        if (ljhVar != null) {
            try {
                String strOd = ljhVar.od();
                if (TextUtils.isEmpty(strOd) && ljhVar.bo() != null && ljhVar.bo().lnr() == 1 && !TextUtils.isEmpty(ljhVar.bo().ud())) {
                    strOd = ljhVar.bo().ud();
                }
                String str2 = strOd;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.fco.qdl(com.bytedance.sdk.openadsdk.core.yt.qdl(), str2, ljhVar, qdl(str), str, false);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean lnr(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        if (ljhVar == null) {
            return true;
        }
        int iUd = com.bytedance.sdk.openadsdk.core.yt.mml().ud(ljhVar.fz());
        int iLnr = com.bytedance.sdk.component.utils.jl.lnr(com.bytedance.sdk.openadsdk.core.yt.qdl());
        if (iUd == 1) {
            return mml(iLnr);
        }
        if (iUd == 2) {
            return mzz(iLnr) || mml(iLnr) || mo(iLnr);
        }
        if (iUd != 3) {
            return iUd != 5 || mml(iLnr) || mo(iLnr);
        }
        return false;
    }

    public static String wd(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static void qdl(String str, String str2, Context context) {
        int i;
        if (TextUtils.isEmpty(str2) || !mzz(context)) {
            return;
        }
        int length = str2.length();
        int i2 = 1;
        if (length % 3572 == 0) {
            i = length / 3572;
        } else {
            i = (length / 3572) + 1;
        }
        int i3 = 3572;
        int i4 = 0;
        while (i2 <= i) {
            if (i3 < length) {
                Log.d(str, i + "-" + i2 + ":" + str2.substring(i4, i3));
                i2++;
                i4 = i3;
                i3 += 3572;
            } else {
                Log.d(str, i + "-" + i2 + ":" + str2.substring(i4));
                return;
            }
        }
    }

    public static boolean mzz(Context context) {
        if (context == null) {
            return false;
        }
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static int mo(Context context) {
        int i = -1;
        try {
            i = context.getApplicationInfo().targetSdkVersion;
            Integer.valueOf(i);
            return i;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.ToolUtils", th.getMessage());
            return i;
        }
    }

    public static long wd(Context context) {
        int i = -1;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                i = context.getApplicationInfo().minSdkVersion;
                Integer.valueOf(i);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.ToolUtils", th.getMessage());
        }
        return i;
    }

    public static void jpc(final String str) {
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl();
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl("reportMultiLog", false, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.utils.gy.3
            @Override // com.bytedance.sdk.openadsdk.bjy.ud
            public com.bytedance.sdk.openadsdk.bjy.qdl.lnr getLogStats() throws Exception {
                if (gy.lnr || !com.bytedance.sdk.openadsdk.core.yt.mml().dk()) {
                    return null;
                }
                boolean unused = gy.lnr = true;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", str);
                return com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl("reportMultiLog").ud(jSONObject.toString());
            }
        });
    }

    public static boolean tvp(String str) {
        if (com.bytedance.sdk.openadsdk.core.rdp.mzz()) {
            return true;
        }
        com.bytedance.sdk.component.utils.aaj.lnr("You must use method '" + str + "' after initialization, please check.", new Object[0]);
        return false;
    }

    public static void to(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return;
        }
        com.bytedance.sdk.component.utils.aaj.lnr("You should use method '" + str + "' on the asynchronous thread,it may cause anr, please check.", new Object[0]);
    }

    public static int jpc(Context context) {
        return wd(com.bytedance.sdk.component.utils.bqt.qdl(context, 0L));
    }

    public static boolean bqt() {
        return mml.get() == 1;
    }

    public static void tvp(Context context) {
        try {
            AtomicInteger atomicInteger = mml;
            if (atomicInteger.get() != 0) {
                return;
            }
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            boolean zIsEnabled = accessibilityManager.isEnabled();
            boolean zIsTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            if (zIsEnabled && zIsTouchExplorationEnabled) {
                atomicInteger.set(1);
                com.bytedance.sdk.openadsdk.bjy.lnr.qdl().lnr();
            } else {
                atomicInteger.set(2);
            }
        } catch (Exception unused) {
            mml.set(2);
        }
    }

    public static boolean jpc(int i) {
        if (i <= 0) {
            return false;
        }
        return i >= 100 || new Random(System.currentTimeMillis()).nextInt(100) + 1 <= i;
    }

    public static void qdl(StringBuilder sb, String str, String str2) {
        int iIndexOf;
        if (sb == null || TextUtils.isEmpty(str) || (iIndexOf = sb.indexOf(str)) <= 0) {
            return;
        }
        sb.replace(iIndexOf, str.length() + iIndexOf, str2);
    }

    public static int to(Context context) {
        List<ResolveInfo> listQueryIntentActivities;
        Integer num = qdl;
        if (num != null) {
            return num.intValue();
        }
        if (context == null || (listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("https://www.example.com")), 0)) == null) {
            return 0;
        }
        int size = listQueryIntentActivities.size();
        Integer numValueOf = Integer.valueOf(size);
        qdl = numValueOf;
        numValueOf.getClass();
        return size;
    }

    public static com.bytedance.sdk.openadsdk.common.mml qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, com.bytedance.sdk.component.tvp.mo moVar, Context context, String str) {
        int iFge = ljhVar.fge();
        if (ljhVar == null || !ljhVar.se() || (iFge != 1 && iFge != 3)) {
            return null;
        }
        moVar.qdl(true, (View) new com.bytedance.sdk.openadsdk.common.lnr(context));
        return new com.bytedance.sdk.openadsdk.common.mml(ljhVar, moVar, str, false);
    }

    public static void qdl(JSONObject jSONObject) {
        int iIntValue;
        try {
            Pair<String, Long> pairMml = com.bytedance.sdk.openadsdk.core.tvp.mml("oem_store");
            int i = -1;
            if (pairMml != null && ((iIntValue = Integer.valueOf((String) pairMml.first).intValue()) != -2 || System.currentTimeMillis() - ((Long) pairMml.second).longValue() < com.bytedance.sdk.openadsdk.jyq.qdl.qdl("oem_store_state_time", ModelManager.MODEL_REQUEST_INTERVAL_MILLISECONDS))) {
                i = iIntValue;
            }
            jSONObject.put("oem_store", i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.ToolUtils", th.getMessage());
        }
    }

    public static void qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, com.bytedance.sdk.component.tvp.mo moVar) {
        qdl(ljhVar, moVar, false);
    }

    public static void qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, com.bytedance.sdk.component.tvp.mo moVar, boolean z) {
        com.bytedance.sdk.openadsdk.core.model.jpc jpcVarJyq;
        List<Integer> list;
        if (ljhVar == null || moVar == null) {
            return;
        }
        int iFge = ljhVar.fge();
        if (ljhVar.se() && ((iFge == 2 || iFge == 3 || iFge == 5) && (jpcVarJyq = ljhVar.jyq()) != null)) {
            List<Integer> listMo = jpcVarJyq.mo();
            ArrayList arrayList = new ArrayList();
            if (z) {
                for (int i = 0; i < listMo.size(); i++) {
                    arrayList.add(Integer.valueOf(listMo.get(i).intValue() - 1));
                }
                list = arrayList;
            } else {
                list = listMo;
            }
            moVar.qdl(true, jpcVarJyq.mml(), jpcVarJyq.mzz(), list, jpcVarJyq.wd(), jpcVarJyq.lnr());
        }
        int iHoh = ljhVar.hoh();
        long jUv = ljhVar.uv();
        if ((iHoh == 1 || iHoh == 2) && jUv > 0) {
            moVar.qdl(iHoh, jUv);
        }
    }

    public static boolean mml(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        return ljhVar != null && ljhVar.ygv() == 3 && ljhVar.se() && (ljhVar.fge() == 4 || ljhVar.fge() == 5);
    }

    public static String koa() {
        String str = rdp;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = new String(fs);
        rdp = str2;
        return str2;
    }

    public static String vu() {
        String str = bjy;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = new String(exu);
        bjy = str2;
        return str2;
    }

    public static int qdl(WebView webView) {
        if (webView == null) {
            return -1;
        }
        try {
            WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
            int size = webBackForwardListCopyBackForwardList.getSize();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(i);
                if (itemAtIndex != null) {
                    String url = itemAtIndex.getUrl();
                    if (!arrayList.contains(url)) {
                        arrayList.add(url);
                    }
                }
            }
            return arrayList.indexOf(webView.getUrl()) + 1;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.ToolUtils", th.toString());
            return -1;
        }
    }

    public static JSONObject qdl(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        if (adSlot != null) {
            try {
                jSONObject.put("is_sb", !TextUtils.isEmpty(adSlot.getBidAdm()));
            } catch (Throwable unused) {
            }
        }
        return jSONObject;
    }

    public static int rc() {
        return lnr.qdl;
    }

    private static class lnr {
        private static final int qdl;

        static {
            Class<?> cls;
            com.bytedance.sdk.component.utils.aaj.qdl("TTAD.ToolUtils", "init hasBindingAdapterPositionMethod start status = 0");
            int i = 2;
            try {
                cls = Class.forName("androidx.recyclerview.widget.RecyclerView$ViewHolder");
            } catch (ClassNotFoundException unused) {
            } catch (NoSuchMethodException unused2) {
            }
            if (cls == null) {
                i = 1;
            } else if (cls.getDeclaredMethod("getBindingAdapterPosition", new Class[0]) != null) {
                i = 0;
            }
            qdl = i;
            com.bytedance.sdk.component.utils.aaj.qdl("TTAD.ToolUtils", "init hasBindingAdapterPositionMethod end status = ".concat(String.valueOf(i)));
        }
    }
}
