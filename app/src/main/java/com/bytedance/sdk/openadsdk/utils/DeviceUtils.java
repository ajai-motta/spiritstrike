package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.sdk.openadsdk.core.settings.to;
import com.bytedance.sdk.openadsdk.utils.wd;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.hive.base.Android;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceUtils {
    private static int bjy = 0;
    private static int exu = 0;
    private static int jpc = 0;
    private static int jtx = 0;
    public static String qdl = "";
    private static int rdp;
    private static int tvp;
    private static volatile long ud = System.currentTimeMillis();
    private static volatile boolean lnr = false;
    private static volatile boolean mml = false;
    private static volatile boolean mzz = false;
    private static volatile boolean mo = true;
    private static long wd = 0;
    private static String to = "";
    private static int rq = 0;
    private static final AtomicBoolean fs = new AtomicBoolean(false);
    private static AtomicBoolean yt = new AtomicBoolean(false);

    public static void qdl(Context context) {
        if (lnr) {
            return;
        }
        try {
            ud udVar = new ud();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            context.getApplicationContext().registerReceiver(udVar, intentFilter);
            lnr = true;
        } catch (Throwable unused) {
        }
    }

    public static long qdl() {
        return ud;
    }

    public static boolean ud() {
        if (SystemClock.elapsedRealtime() - wd >= SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
            wd = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.yt.qdl().getSystemService("power");
                if (powerManager != null) {
                    mo = powerManager.isInteractive();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.lnr("TTAD.DeviceUtils", th.getMessage());
            }
        }
        return mo;
    }

    public static boolean ud(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean lnr(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int mml(Context context) {
        if (lnr(context)) {
            return 3;
        }
        return ud(context) ? 2 : 1;
    }

    private static void qdl(JSONObject jSONObject) throws JSONException {
        ud(jSONObject);
    }

    private static void ud(JSONObject jSONObject) throws JSONException {
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(jSONObject);
    }

    public static String mzz(Context context) {
        if (!fs.get()) {
            bjy(context);
        }
        return to;
    }

    public static int mo(Context context) {
        if (!fs.get()) {
            bjy(context);
        }
        return rq;
    }

    private static void bjy(Context context) {
        if (context == null || !fs.compareAndSet(false, true)) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.jyq.qdl.qdl("gp_v_enable", 0) == 1) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.android.vending", 0);
                to = packageInfo.versionName;
                rq = packageInfo.versionCode;
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject qdl(Context context, boolean z) {
        String strQdl;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sys_adb_status", jpc(context));
            qdl(jSONObject);
            jSONObject.put("type", mml(context));
            jSONObject.put("os", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("conn_type", gy.jpc(context));
            jSONObject.put("app_set_id", com.bytedance.sdk.openadsdk.core.settings.mml.lnr());
            jSONObject.put("app_set_id_scope", com.bytedance.sdk.openadsdk.core.settings.mml.ud());
            jSONObject.put("installed_source", com.bytedance.sdk.openadsdk.core.settings.mml.mml());
            jSONObject.put("screen_scale", ax.mo(context));
            jSONObject.put("density", ax.jpc(context));
            jSONObject.put("screen_width", ax.lnr(context));
            jSONObject.put("screen_height", ax.mzz(context));
            jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.core.to.lnr.mo());
            com.bytedance.sdk.openadsdk.core.settings.rq rqVarMml = com.bytedance.sdk.openadsdk.core.yt.mml();
            if (rqVarMml.bqt("boot")) {
                jSONObject.put("boot", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
                jSONObject.put("power_on_time", String.valueOf(SystemClock.elapsedRealtime()));
            }
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.fs.lnr(context));
            jSONObject.put("rom_version", bqt.qdl());
            jSONObject.put("sys_compiling_time", com.bytedance.sdk.openadsdk.core.fs.ud(context));
            jSONObject.put("timezone", gy.xmv());
            jSONObject.put("language", com.bytedance.sdk.openadsdk.core.fs.ud());
            jSONObject.put("carrier_name", vu.qdl());
            if (z) {
                strQdl = gy.qdl(context);
            } else {
                strQdl = gy.to();
            }
            jSONObject.put("total_mem", String.valueOf(Long.parseLong(strQdl) * 1024));
            jSONObject.put("locale_language", mml());
            jSONObject.put("screen_bright", Math.ceil(mzz() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", 1 ^ (ud() ? 1 : 0));
            jSONObject.put("cpu_num", to.ud());
            jSONObject.put("cpu_max_freq", to.lnr());
            jSONObject.put("cpu_min_freq", to.mml());
            wd.qdl qdlVarQdl = wd.qdl();
            jSONObject.put("battery_remaining_pct", (int) qdlVarQdl.ud);
            jSONObject.put("is_charging", qdlVarQdl.qdl);
            jSONObject.put("total_space", String.valueOf(gy.ud(context)));
            jSONObject.put("free_space_in", String.valueOf(gy.exu()));
            jSONObject.put("sdcard_size", String.valueOf(gy.rdp()));
            jSONObject.put("rooted", gy.jtx());
            jSONObject.put("enable_assisted_clicking", mo());
            jSONObject.put("force_language", com.bytedance.sdk.component.utils.ljh.qdl(context, "tt_choose_language"));
            jSONObject.put("airplane", tvp(context));
            jSONObject.put("darkmode", jtx(context));
            jSONObject.put("headset", yt(context));
            jSONObject.put("ringmute", to(context));
            jSONObject.put("screenscale", jl(context));
            jSONObject.put("volume", jpc());
            jSONObject.put("low_power_mode", exc(context));
            jSONObject.put("enable_draw_feed", gy.rc());
            if (z) {
                jpc.qdl(jSONObject, context);
                jSONObject.put("gp_v_name", mzz(context));
                jSONObject.put("gp_v_code", mo(context));
            }
            if (rqVarMml.bqt(Android.HW_IDS_MNC)) {
                jSONObject.put(Android.HW_IDS_MNC, vu.lnr());
            }
            if (rqVarMml.bqt(Android.HW_IDS_MCC)) {
                jSONObject.put(Android.HW_IDS_MCC, vu.ud());
            }
            jSONObject.put("act", com.bytedance.sdk.openadsdk.core.qdl.qdl.ud(context));
            jSONObject.put("act_event", com.bytedance.sdk.openadsdk.core.qdl.qdl.qdl());
            String strLnr = com.bytedance.sdk.openadsdk.core.to.lnr.lnr();
            Long.valueOf(com.bytedance.sdk.openadsdk.core.to.lnr.mml());
            if (!TextUtils.isEmpty(strLnr)) {
                jSONObject.put("sof_chara", strLnr);
            }
            String strUd = com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
            if (!strUd.isEmpty()) {
                jSONObject.put("ipv6", strUd);
            }
            jSONObject.put("is_multi", com.bytedance.sdk.openadsdk.multipro.ud.lnr());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject wd(Context context) {
        return qdl(context, false);
    }

    public static int lnr() {
        return com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("limit_ad_track", -1);
    }

    public static String mml() {
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    public static float mzz() {
        int i = -1;
        try {
            Context contextQdl = com.bytedance.sdk.openadsdk.core.yt.qdl();
            if (contextQdl != null) {
                i = Settings.System.getInt(contextQdl.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.DeviceUtils", th.getMessage());
        }
        if (i < 0) {
            return -1.0f;
        }
        return Math.round((i / 255.0f) * 10.0f) / 10.0f;
    }

    public static int mo() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.bytedance.sdk.openadsdk.core.yt.qdl().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        return accessibilityManager.isEnabled() ? 1 : 0;
    }

    public static int jpc(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", -1);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.DeviceUtils", th.getMessage());
            return -1;
        }
    }

    public static int tvp(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static int jtx(Context context) {
        int i;
        try {
            i = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } catch (Throwable unused) {
        }
        if (i == 32) {
            return 1;
        }
        return i == 16 ? 0 : -1;
    }

    private static int yt(Context context) {
        return bjy;
    }

    public static int to(Context context) {
        return jpc;
    }

    private static float jl(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int wd() {
        return exu;
    }

    public static int jpc() {
        return rdp;
    }

    public static int tvp() {
        return tvp;
    }

    private static int exc(Context context) {
        return jtx;
    }

    public static String to() {
        if (TextUtils.isEmpty(qdl)) {
            qdl = com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("framework_name", "");
        }
        return qdl;
    }

    public static void rq() {
        com.bytedance.sdk.openadsdk.core.settings.rq.qdl(new to.qdl() { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.1
            @Override // com.bytedance.sdk.openadsdk.core.settings.to.qdl
            public void qdl() {
                com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.to.qdl
            public void ud() {
                com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(true);
            }
        });
        Context contextQdl = com.bytedance.sdk.openadsdk.core.yt.qdl();
        if (contextQdl != null) {
            com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("cpu_count", to.qdl());
            com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("cpu_max_frequency", to.qdl(to.qdl()));
            com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("cpu_min_frequency", to.ud(to.qdl()));
            String strRq = gy.rq();
            if (strRq != null) {
                com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("total_memory", strRq);
            }
            com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("total_internal_storage", gy.fs());
            com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("free_internal_storage", com.bytedance.sdk.component.utils.yt.qdl());
            com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("total_sdcard_storage", gy.bjy());
            com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("is_root", gy.yt() ? 1 : 0);
            if (TextUtils.isEmpty(to())) {
                try {
                    Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
                    qdl = "unity";
                } catch (ClassNotFoundException unused) {
                    qdl = "native";
                }
                com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("framework_name", qdl);
            }
            fs();
            aaj(contextQdl);
            jtx = oth(contextQdl);
            jpc.qdl(contextQdl);
        }
    }

    public static void fs() {
        try {
            int ringerMode = ((AudioManager) com.bytedance.sdk.openadsdk.core.yt.qdl().getSystemService("audio")).getRingerMode();
            if (ringerMode == 2) {
                jpc = 1;
            } else if (ringerMode == 1) {
                jpc = 2;
            } else {
                jpc = 0;
            }
        } catch (Throwable unused) {
        }
    }

    private static void aaj(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            tvp = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            exu = streamVolume;
            rdp = (int) ((((double) streamVolume) / ((double) tvp)) * 100.0d);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void jyq(Context context) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        fco.ud(new com.bytedance.sdk.component.jpc.jpc("DeviceUtils_get_low_power_mode") { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.2
            @Override // java.lang.Runnable
            public void run() {
                int unused = DeviceUtils.jtx = DeviceUtils.oth(applicationContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int oth(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") && !Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                return ((PowerManager) context.getSystemService("power")).isPowerSaveMode() ? 1 : 0;
            }
            return ljh(context);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int ljh(android.content.Context r4) {
        /*
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = "XIAOMI"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L35
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1c
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = "POWER_SAVE_MODE_OPEN"
            int r4 = android.provider.Settings.System.getInt(r4, r0)     // Catch: java.lang.Throwable -> L35
            if (r4 != r1) goto L19
            goto L1a
        L19:
            r1 = r2
        L1a:
            r2 = r1
            goto L34
        L1c:
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = "HUAWEI"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto L34
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = "SmartModeStatus"
            int r4 = android.provider.Settings.System.getInt(r4, r0)     // Catch: java.lang.Throwable -> L35
            r0 = 4
            if (r4 != r0) goto L19
            goto L1a
        L34:
            return r2
        L35:
            r4 = -1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.DeviceUtils.ljh(android.content.Context):int");
    }

    public static void rq(Context context) {
        AudioInfoReceiver.ud(context);
    }

    public static void fs(Context context) {
        Context applicationContext;
        if (mzz || context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        try {
            if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
                bch(applicationContext);
            } else {
                qdl.ud(applicationContext);
            }
            mzz = true;
        } catch (Throwable unused) {
        }
    }

    private static void bch(Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        context.getContentResolver().registerContentObserver(Uri.parse("content://settings/system/POWER_SAVE_MODE_OPEN"), false, new ContentObserver(null) { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                DeviceUtils.jyq(applicationContext);
            }
        });
    }

    static class ud extends BroadcastReceiver {
        ud() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = DeviceUtils.mo = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = DeviceUtils.mo = false;
            } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                long unused3 = DeviceUtils.ud = System.currentTimeMillis();
            }
        }
    }

    public static class lnr extends com.bytedance.sdk.component.jpc.jpc {
        public lnr() {
            super("gaid_task");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.sdk.openadsdk.core.lnr] */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1, types: [int] */
        /* JADX WARN: Type inference failed for: r4v3 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r4;
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.sdk.openadsdk.core.yt.qdl());
                if (advertisingIdInfo != null) {
                    boolean zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
                    if (zIsLimitAdTrackingEnabled) {
                        com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(1);
                    }
                    DeviceUtils.ud(advertisingIdInfo, zIsLimitAdTrackingEnabled);
                    r4 = zIsLimitAdTrackingEnabled;
                } else {
                    r4 = -1;
                }
                if (r4 != -1) {
                    com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("limit_ad_track", r4);
                }
            } catch (IOException e) {
                com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(2);
                com.bytedance.sdk.component.utils.aaj.qdl("TTAD.DeviceUtils", "getLmtTask error : signaling connection to Google Play Services failed.", e);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(2);
                com.bytedance.sdk.component.utils.aaj.lnr("TTAD.DeviceUtils", th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(AdvertisingIdClient.Info info, boolean z) {
        if (z || !com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().lnr()) {
            return;
        }
        String id = info.getId();
        String strUd = com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().ud();
        if (!TextUtils.isEmpty(id)) {
            com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(id);
            com.bytedance.sdk.openadsdk.core.to.lnr.qdl(id);
        }
        if (strUd.equals(id)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.fs.qdl();
    }

    public static class AudioInfoReceiver extends BroadcastReceiver {
        static final CopyOnWriteArrayList<com.bytedance.sdk.openadsdk.fs.jpc> qdl = new CopyOnWriteArrayList<>();

        /* JADX INFO: Access modifiers changed from: private */
        public static void ud(Context context) {
            if (DeviceUtils.mml || context == null) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                context.registerReceiver(new AudioInfoReceiver(), intentFilter, null, com.bytedance.sdk.component.utils.tvp.qdl());
                boolean unused = DeviceUtils.mml = true;
            } catch (Throwable unused2) {
            }
        }

        public static void qdl(com.bytedance.sdk.openadsdk.fs.jpc jpcVar) {
            if (jpcVar != null) {
                CopyOnWriteArrayList<com.bytedance.sdk.openadsdk.fs.jpc> copyOnWriteArrayList = qdl;
                if (copyOnWriteArrayList.contains(jpcVar)) {
                    return;
                }
                copyOnWriteArrayList.add(jpcVar);
            }
        }

        public static void ud(com.bytedance.sdk.openadsdk.fs.jpc jpcVar) {
            if (jpcVar == null) {
                return;
            }
            qdl.remove(jpcVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                    if (intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                        int unused = DeviceUtils.exu = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
                        if (!qdl.isEmpty()) {
                            fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.AudioInfoReceiver.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Iterator<com.bytedance.sdk.openadsdk.fs.jpc> it = AudioInfoReceiver.qdl.iterator();
                                    while (it.hasNext()) {
                                        it.next().ud(DeviceUtils.exu);
                                    }
                                }
                            });
                        }
                        if (DeviceUtils.tvp != 0) {
                            int unused2 = DeviceUtils.rdp = (int) ((((double) DeviceUtils.exu) / ((double) DeviceUtils.tvp)) * 100.0d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                    int unused3 = DeviceUtils.bjy = intent.getIntExtra("state", 0);
                }
            } catch (Exception unused4) {
            }
        }
    }

    private static class qdl extends BroadcastReceiver {
        private qdl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void ud(Context context) {
            if (context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                intentFilter.addAction("huawei.intent.action.POWER_MODE_CHANGED_ACTION");
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(new qdl(), intentFilter, 2);
                } else {
                    context.registerReceiver(new qdl(), intentFilter);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                return;
            }
            if ("android.os.action.POWER_SAVE_MODE_CHANGED".equals(intent.getAction())) {
                DeviceUtils.jyq(context);
            } else if ("huawei.intent.action.POWER_MODE_CHANGED_ACTION".equals(intent.getAction())) {
                int unused = DeviceUtils.jtx = intent.getIntExtra("state", 0) == 1 ? 1 : 0;
            }
        }
    }
}
