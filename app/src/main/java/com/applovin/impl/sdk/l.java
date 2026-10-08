package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.app.ApplicationStartInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.autofill.HintConstants;
import com.applovin.impl.a5;
import com.applovin.impl.c4;
import com.applovin.impl.d2;
import com.applovin.impl.e6;
import com.applovin.impl.j5;
import com.applovin.impl.l7;
import com.applovin.impl.n7;
import com.applovin.impl.o0;
import com.applovin.impl.o7;
import com.applovin.impl.o8;
import com.applovin.impl.p0;
import com.applovin.impl.p5;
import com.applovin.impl.q0;
import com.applovin.impl.r0;
import com.applovin.impl.r4;
import com.applovin.impl.s6;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t2;
import com.applovin.impl.v;
import com.applovin.impl.v4;
import com.applovin.impl.y4;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.base.Android;
import com.unity3d.ads.core.data.datasource.AndroidTcfDataSource;
import io.ktor.http.ContentType;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    private static String j;
    private static String k;
    private static final AtomicReference l = new AtomicReference();
    private static final AtomicReference m = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f642a;
    private final o b;
    private final Context c;
    private final Map d;
    private final Map f;
    private boolean h;
    private final Object e = new Object();
    private final Object g = new Object();
    private final AtomicReference i = new AtomicReference();

    class a implements p5.a {
        a() {
        }

        @Override // com.applovin.impl.p5.a
        public void a(v.a aVar) {
            l.l.set(aVar);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f644a;
        public final int b;

        public b(String str, int i) {
            this.f644a = str;
            this.b = i;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f645a = -1;
        public int b = -1;
        public Boolean c = null;
    }

    protected l(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f642a = kVar;
        this.b = kVar.O();
        this.c = k.o();
        this.d = C();
        this.f = B();
    }

    private String A() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (o0.f()) {
            for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                sb.append(audioDeviceInfo.getType());
                sb.append(",");
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append("3,");
            }
            if (audioManager.isBluetoothScoOn()) {
                sb.append("7,");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append(8);
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string) && o.a()) {
            this.b.a("DataCollector", "No sound outputs detected");
        }
        return string;
    }

    private Map B() {
        PackageInfo packageInfo;
        HashMap map = new HashMap();
        PackageManager packageManager = this.c.getPackageManager();
        ApplicationInfo applicationInfo = this.c.getApplicationInfo();
        long jLastModified = new File(applicationInfo.sourceDir).lastModified();
        try {
            packageInfo = packageManager.getPackageInfo(this.c.getPackageName(), 0);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        String strA = a(applicationInfo.packageName, packageManager, this.f642a);
        String strA2 = a(applicationInfo.packageName, packageManager);
        map.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, packageManager.getApplicationLabel(applicationInfo));
        map.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        map.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        map.put("installer_name", StringUtils.emptyIfNull(strA));
        map.put("originating_name", StringUtils.emptyIfNull(strA2));
        map.put("tg", n7.a(this.f642a));
        map.put("debug", Boolean.valueOf(o7.c(this.f642a)));
        map.put("ia", Long.valueOf(jLastModified));
        map.put("alts_ms", Long.valueOf(k.n()));
        map.put("session_id", this.f642a.n0().getSessionId());
        map.put("j8", Boolean.valueOf(k.G0()));
        map.put("ps_tpg", Boolean.valueOf(r4.d(this.c)));
        map.put("ps_apg", Boolean.valueOf(r4.b(this.c)));
        map.put("ps_capg", Boolean.valueOf(r4.c(this.c)));
        map.put("ps_aipg", Boolean.valueOf(r4.a(this.c)));
        k kVar = this.f642a;
        a5 a5Var = a5.h;
        Long l2 = (Long) kVar.a(a5Var);
        if (l2 != null) {
            map.put("ia_v2", l2);
        } else {
            this.f642a.b(a5Var, Long.valueOf(jLastModified));
        }
        map.put("sdk_version", AppLovinSdk.VERSION);
        map.put("omid_sdk_version", this.f642a.e0().c());
        CollectionUtils.putStringIfValid("ad_review_sdk_version", com.applovin.impl.j.b(), map);
        map.put("api_did", this.f642a.a(y4.f));
        map.put("first_install_v3_ms", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : "");
        CollectionUtils.putLongIfValid("last_launch_ms", this.f642a.L(), map);
        CollectionUtils.putLongIfValid("app_launch_count", Long.valueOf(this.f642a.M()), map);
        map.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        if (o0.g()) {
            map.put("min_sdk", Integer.valueOf(applicationInfo.minSdkVersion));
        }
        if (this.f642a.I0()) {
            map.put("unity_version", o7.a(this.f642a.o0()));
        }
        List listI = i();
        if (!CollectionUtils.isEmpty(listI)) {
            map.put("application_start_info", listI);
        }
        List listG = g();
        if (!CollectionUtils.isEmpty(listG)) {
            map.put("application_exit_info", listG);
        }
        if (o0.h()) {
            map.put("instant_app", Boolean.valueOf(packageManager.isInstantApp()));
        }
        return map;
    }

    private Map C() {
        HashMap map = new HashMap(35);
        map.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        map.put("brand", Build.MANUFACTURER);
        map.put("brand_name", Build.BRAND);
        map.put("hardware", Build.HARDWARE);
        map.put("sim", Boolean.valueOf(AppLovinSdkUtils.isEmulator()));
        map.put("aida", Boolean.valueOf(v.a()));
        map.put("locale", Locale.getDefault().toString());
        map.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        map.put("os", Build.VERSION.RELEASE);
        map.put("platform", z());
        map.put("revision", Build.DEVICE);
        map.put("tz_offset", Double.valueOf(D()));
        map.put("gy", Boolean.valueOf(t()));
        map.put("country_code", n());
        map.put(Android.HW_IDS_MCC, x());
        map.put(Android.HW_IDS_MNC, y());
        map.put("carrier", l());
        map.put("tv", Boolean.valueOf(AppLovinSdkUtils.isTv(this.c)));
        map.put("pc", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        map.put("hdr", S());
        map.put("supported_abis", N());
        map.put("type", Build.TYPE);
        map.put(AppLovinEventTypes.USER_VIEWED_PRODUCT, Build.PRODUCT);
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            map.put("adns", Float.valueOf(displayMetrics.density));
            map.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            map.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            map.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            o0.b bVarA = o0.a(this.c, this.f642a);
            if (bVarA != null) {
                map.put("tl_cr", Integer.valueOf(bVarA.c()));
                map.put("tr_cr", Integer.valueOf(bVarA.d()));
                map.put("bl_cr", Integer.valueOf(bVarA.a()));
                map.put("br_cr", Integer.valueOf(bVarA.b()));
            }
        }
        map.put("bt_ms", Long.valueOf(k()));
        map.put("tbalsi_ms", Long.valueOf(this.f642a.K() - k.n()));
        CollectionUtils.putBooleanIfValid("psase", Boolean.valueOf(r4.e(this.c)), map);
        CollectionUtils.putStringIfValid("process_name", o7.c(this.c), map);
        CollectionUtils.putBooleanIfValid("is_main_process", o7.i(this.c), map);
        try {
            PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo("com.android.vending", 0);
            map.put("ps_version", packageInfo.versionName);
            map.put("ps_version_code", Integer.valueOf(packageInfo.versionCode));
        } catch (Throwable unused) {
            map.put("ps_version", "");
            map.put("ps_version_code", -1);
        }
        CollectionUtils.putBooleanIfValid("play_store_disabled", l7.a(this.c), map);
        a(map);
        return map;
    }

    private double D() {
        return Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d) / 10.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x0230 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0222  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONArray E() {
        /*
            Method dump skipped, instruction units count: 659
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.l.E():org.json.JSONArray");
    }

    public static String I() {
        return k;
    }

    private Map K() {
        return o7.a(a((Map) null, true, false));
    }

    private JSONArray N() {
        if (o0.e()) {
            return CollectionUtils.toJSONArray(Build.SUPPORTED_ABIS);
        }
        JSONArray jSONArray = new JSONArray();
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI);
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI2);
        return jSONArray;
    }

    private boolean O() {
        try {
            if (!b()) {
                if (!c()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private Boolean P() {
        if (o0.j()) {
            return null;
        }
        return Boolean.valueOf(!CollectionUtils.isEmpty(o7.a("/proc/net/tcp", Collections.singletonList(":69A2"), this.f642a)));
    }

    private boolean Q() {
        ConnectivityManager connectivityManager;
        if (o0.g() && (connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th) {
                this.f642a.O();
                if (o.a()) {
                    this.f642a.O().a("DataCollector", "Unable to collect constrained network info.", th);
                }
            }
        }
        return false;
    }

    private boolean R() {
        boolean z = this.c.getResources().getConfiguration().keyboard == 2;
        PackageManager packageManager = this.c.getPackageManager();
        return z && (packageManager.hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE") || packageManager.hasSystemFeature("android.hardware.type.pc"));
    }

    private Boolean S() {
        if (o0.h()) {
            return Boolean.valueOf(this.c.getResources().getConfiguration().isScreenHdr());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.i.set(r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        Map mapX = X();
        List listW = W();
        synchronized (this.g) {
            if (mapX != null) {
                try {
                    this.f.putAll(mapX);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (listW != null) {
                this.f.put("dl", listW);
            }
        }
    }

    private List W() {
        List listC = this.f642a.c(y4.M4);
        if (CollectionUtils.isEmpty(listC)) {
            return null;
        }
        return o7.a("/proc/self/maps", listC, this.f642a);
    }

    private Map X() {
        boolean z;
        int i;
        Throwable th;
        if (!((Boolean) this.f642a.a(y4.L4)).booleanValue()) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it = Thread.getAllStackTraces().entrySet().iterator();
            z = false;
            i = 0;
            while (it.hasNext()) {
                try {
                    for (StackTraceElement stackTraceElement : it.next().getValue()) {
                        String string = stackTraceElement.toString();
                        if (!z && string.contains("de.robv.android.xposed")) {
                            z = true;
                        }
                        if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit")) {
                            i++;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.f642a.D().b("DataCollector", "collectHookingSignals", th);
                }
            }
        } catch (Throwable th3) {
            z = false;
            i = 0;
            th = th3;
        }
        map.put("xpd", Boolean.valueOf(z));
        map.put("zi_count", Integer.valueOf(i));
        CollectionUtils.putBooleanIfValid("fpd", P(), map);
        return map;
    }

    private void Z() {
        this.f642a.r0().a((j5) new s6(this.f642a, "collectPostInitAppInfo", new Runnable() { // from class: com.applovin.impl.sdk.l$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.V();
            }
        }), e6.b.OTHER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        try {
            String strH = H();
            if (StringUtils.isValidString(strH)) {
                this.f642a.O();
                if (o.a()) {
                    this.f642a.O().a("DataCollector", "Successfully retrieved bid token");
                }
                t2.a(appLovinBidTokenCollectionListener, strH);
                return;
            }
            this.f642a.O();
            if (o.a()) {
                this.f642a.O().b("DataCollector", "Empty bid token");
            }
            t2.b(appLovinBidTokenCollectionListener, "Empty bid token");
        } catch (Throwable th) {
            if (o.a()) {
                this.b.a("DataCollector", "Failed to collect bid token", th);
            }
            this.f642a.D().a("DataCollector", "collectBidToken", th);
            t2.b(appLovinBidTokenCollectionListener, "Failed to collect bid token");
        }
    }

    private boolean c() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i = 0; i < 9; i++) {
            if (new File(c(strArr[i])).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long d() {
        /*
            Method dump skipped, instruction units count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.l.d():long");
    }

    private List g() {
        ActivityManager activityManager;
        if (!o0.b()) {
            return null;
        }
        Integer num = (Integer) this.f642a.a(y4.F4);
        if (num.intValue() < 0 || (activityManager = (ActivityManager) this.c.getSystemService("activity")) == null) {
            return null;
        }
        List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(((Boolean) this.f642a.a(y4.G4)).booleanValue() ? this.c.getPackageName() : null, 0, num.intValue());
        if (CollectionUtils.isEmpty(historicalProcessExitReasons)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(historicalProcessExitReasons.size());
        for (ApplicationExitInfo applicationExitInfo : historicalProcessExitReasons) {
            HashMap map = new HashMap(13);
            int reason = applicationExitInfo.getReason();
            map.put("reason", Integer.valueOf(reason));
            String description = applicationExitInfo.getDescription();
            CollectionUtils.putStringIfValid("description", description, map);
            map.put("timestamp", Long.valueOf(applicationExitInfo.getTimestamp()));
            map.put("status", Integer.valueOf(applicationExitInfo.getStatus()));
            map.put("importance", Integer.valueOf(applicationExitInfo.getImportance()));
            map.put("pss", Long.valueOf(applicationExitInfo.getPss()));
            map.put("rss", Long.valueOf(applicationExitInfo.getRss()));
            CollectionUtils.putStringIfValid("process_name", applicationExitInfo.getProcessName(), map);
            map.put(AnalyticsProviderAdjust.EventKeys.pid, Integer.valueOf(applicationExitInfo.getPid()));
            map.put("ruid", Integer.valueOf(applicationExitInfo.getRealUid()));
            map.put("puid", Integer.valueOf(applicationExitInfo.getPackageUid()));
            map.put("duid", Integer.valueOf(applicationExitInfo.getDefiningUid()));
            String strA = a(applicationExitInfo, reason);
            if (StringUtils.isValidString(strA)) {
                map.put("stack_trace", strA);
                b(strA, reason, description);
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    private List i() {
        ActivityManager activityManager;
        if (!o0.c()) {
            return null;
        }
        Integer num = (Integer) this.f642a.a(y4.E4);
        if (num.intValue() < 0 || (activityManager = (ActivityManager) this.c.getSystemService("activity")) == null) {
            return null;
        }
        List<ApplicationStartInfo> historicalProcessStartReasons = activityManager.getHistoricalProcessStartReasons(num.intValue());
        if (CollectionUtils.isEmpty(historicalProcessStartReasons)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(historicalProcessStartReasons.size());
        for (ApplicationStartInfo applicationStartInfo : historicalProcessStartReasons) {
            HashMap map = new HashMap(11);
            map.put("reason", Integer.valueOf(applicationStartInfo.getReason()));
            map.put("startup_state", Integer.valueOf(applicationStartInfo.getStartupState()));
            map.put("start_type", Integer.valueOf(applicationStartInfo.getStartType()));
            map.put("was_force_stopped", Boolean.valueOf(applicationStartInfo.wasForceStopped()));
            map.put("startup_timestamps", applicationStartInfo.getStartupTimestamps());
            CollectionUtils.putStringIfValid("process_name", applicationStartInfo.getProcessName(), map);
            map.put(AnalyticsProviderAdjust.EventKeys.pid, Integer.valueOf(applicationStartInfo.getPid()));
            map.put("ruid", Integer.valueOf(applicationStartInfo.getRealUid()));
            map.put("puid", Integer.valueOf(applicationStartInfo.getPackageUid()));
            map.put("duid", Integer.valueOf(applicationStartInfo.getDefiningUid()));
            map.put("launch_mode", Integer.valueOf(applicationStartInfo.getLaunchMode()));
            map.put("intent", a(applicationStartInfo.getIntent()));
            arrayList.add(map);
        }
        return arrayList;
    }

    private c j() {
        c cVar = new c();
        Intent intentRegisterReceiver = this.c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : -1;
        int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            cVar.b = -1;
        } else {
            cVar.b = (int) ((intExtra / intExtra2) * 100.0f);
        }
        cVar.f645a = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
        cVar.c = Boolean.valueOf(Settings.Global.getInt(this.c.getContentResolver(), "stay_on_while_plugged_in", -1) > 0);
        return cVar;
    }

    private long k() {
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        Long l2 = (Long) this.f642a.a(y4.K4);
        return (jCurrentTimeMillis / l2.longValue()) * l2.longValue();
    }

    private String l() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            if (!o.a()) {
                return "";
            }
            this.b.a("DataCollector", "Unable to collect carrier", th);
            return "";
        }
    }

    private String n() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    private String o() {
        ActivityInfo activityInfo;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://"));
        ResolveInfo resolveInfoResolveActivity = this.c.getPackageManager().resolveActivity(intent, 65536);
        if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
            k = activityInfo.packageName;
        }
        return k;
    }

    private String q() {
        if (!o0.g()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            LocaleList locales = this.c.getResources().getConfiguration().getLocales();
            for (int i = 0; i < locales.size(); i++) {
                sb.append(locales.get(i));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private Float r() {
        Float f = (Float) this.f642a.a(y4.f4);
        Float fB = this.f642a.p().b();
        if (fB != null) {
            return Float.valueOf(fB.floatValue() * f.floatValue());
        }
        return null;
    }

    private float s() {
        try {
            return Settings.System.getFloat(this.c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e) {
            if (!o.a()) {
                return -1.0f;
            }
            this.b.a("DataCollector", "Error collecting font scale", e);
            return -1.0f;
        }
    }

    private boolean t() {
        SensorManager sensorManager = (SensorManager) this.c.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    private Map u() {
        HashMap map = new HashMap();
        CollectionUtils.putIntegerIfValid("IABTCF_gdprApplies", this.f642a.s0().g(), map);
        CollectionUtils.putStringIfValid(AndroidTcfDataSource.TCF_TCSTRING_KEY, this.f642a.s0().j(), map);
        CollectionUtils.putStringIfValid("IABTCF_AddtlConsent", this.f642a.s0().c(), map);
        return map;
    }

    private Boolean v() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isMusicActive());
    }

    private Boolean w() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isSpeakerphoneOn());
    }

    private String x() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(0, Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!o.a()) {
                return "";
            }
            this.b.a("DataCollector", "Unable to collect mobile country code", th);
            return "";
        }
    }

    private String y() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!o.a()) {
                return "";
            }
            this.b.a("DataCollector", "Unable to collect mobile network code", th);
            return "";
        }
    }

    public Map F() {
        Map map;
        synchronized (this.g) {
            map = CollectionUtils.map(this.f);
        }
        String str = StringUtils.isValidString(j) ? j : this.c.getApplicationInfo().packageName;
        map.put("package_name", str);
        map.put("vz", StringUtils.toShortSHA1Hash(str));
        map.put("first_install", Boolean.valueOf(this.f642a.D0()));
        map.put("first_install_v2", Boolean.valueOf(!this.f642a.A0()));
        map.put("test_ads", Boolean.valueOf(this.h));
        map.put("test_mode", Integer.valueOf(this.f642a.t0().c() ? 1 : 0));
        map.put("muted", Boolean.valueOf(this.f642a.o0().isMuted()));
        if (((Boolean) this.f642a.a(y4.F3)).booleanValue()) {
            CollectionUtils.putStringIfValid("cuid", this.f642a.x0().e(), map);
        }
        if (((Boolean) this.f642a.a(y4.I3)).booleanValue()) {
            map.put("compass_random_token", this.f642a.u());
        }
        if (((Boolean) this.f642a.a(y4.K3)).booleanValue()) {
            map.put("applovin_random_token", this.f642a.i0());
        }
        if (((Boolean) this.f642a.a(y4.O3)).booleanValue()) {
            map.put("art", this.f642a.r());
        }
        map.putAll(u());
        if (this.f642a.h0() != null) {
            CollectionUtils.putJsonArrayIfValid("ps_topics", this.f642a.h0().a(), map);
        }
        CollectionUtils.putStringIfValid("template_browser_package_name", (String) this.f642a.q0().a(a5.T, null), map);
        return map;
    }

    public b G() {
        return (b) m.get();
    }

    protected String H() {
        String strEncodeToString = Base64.encodeToString(new JSONObject(K()).toString().getBytes(Charset.defaultCharset()), 2);
        return ((Boolean) this.f642a.a(y4.n5)).booleanValue() ? v4.b(strEncodeToString, o7.a(this.f642a), v4.a.a(((Integer) this.f642a.a(y4.o5)).intValue()), this.f642a.j0(), this.f642a) : strEncodeToString;
    }

    public String J() {
        ActivityManager activityManager = (ActivityManager) this.c.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        return activityManager.getDeviceConfigurationInfo().getGlEsVersion();
    }

    public Map L() {
        Map map;
        synchronized (this.g) {
            map = CollectionUtils.map(this.f);
        }
        return map;
    }

    public Map M() {
        Map map;
        synchronized (this.e) {
            map = CollectionUtils.map(this.d);
        }
        return map;
    }

    public boolean T() {
        return this.h;
    }

    public void Y() {
        e6 e6VarR0 = this.f642a.r0();
        p5 p5Var = new p5(this.f642a, new a());
        e6.b bVar = e6.b.OTHER;
        e6VarR0.a((j5) p5Var, bVar);
        this.f642a.r0().a((j5) new s6(this.f642a, true, "setDeviceVolume", new Runnable() { // from class: com.applovin.impl.sdk.l$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.U();
            }
        }), bVar);
    }

    public void a0() {
        synchronized (this.e) {
            a(this.d);
        }
        Z();
    }

    public Map e() {
        HashMap map = new HashMap();
        map.put("sc", this.f642a.a(y4.l));
        map.put("sc2", this.f642a.a(y4.m));
        map.put("sc3", this.f642a.a(y4.n));
        map.put("server_installed_at", this.f642a.a(y4.o));
        CollectionUtils.putStringIfValid("persisted_data", (String) this.f642a.a(a5.H), map);
        return map;
    }

    public v.a f() {
        v.a aVarB = v.b(this.c);
        if (aVarB == null) {
            return new v.a();
        }
        if (((Boolean) this.f642a.a(y4.D3)).booleanValue()) {
            if (aVarB.c() && !((Boolean) this.f642a.a(y4.C3)).booleanValue()) {
                aVarB.a("");
            }
            l.set(aVarB);
        } else {
            aVarB = new v.a();
        }
        List<String> testDeviceAdvertisingIds = this.f642a.J() != null ? this.f642a.J().getTestDeviceAdvertisingIds() : null;
        if (testDeviceAdvertisingIds != null) {
            String strA = aVarB.a();
            if (StringUtils.isValidString(strA)) {
                this.h = testDeviceAdvertisingIds.contains(strA);
            }
            b bVarG = G();
            String str = bVarG != null ? bVarG.f644a : null;
            if (StringUtils.isValidString(str)) {
                this.h = testDeviceAdvertisingIds.contains(str) | this.h;
            }
        } else {
            this.h = false;
        }
        return aVarB;
    }

    public Map m() {
        HashMap map = new HashMap();
        c4 c4VarD0 = this.f642a.d0();
        Deque dequeB = c4VarD0.b();
        if (!CollectionUtils.isEmpty(dequeB)) {
            map.put("network_throughput_info", dequeB);
        }
        CollectionUtils.putLongIfValid("network_throughput_kbps", c4VarD0.a(), map);
        q0.d dVarA = this.f642a.w().a();
        if (dVarA != null) {
            map.put("lrm_ts_ms", String.valueOf(dVarA.c()));
            map.put("lrm_url", dVarA.d());
            map.put("lrm_ct_ms", String.valueOf(dVarA.a()));
            map.put("lrm_rs", String.valueOf(dVarA.b()));
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    public Map p() {
        return a(false);
    }

    public String z() {
        return AppLovinSdkUtils.isFireOS(this.c) ? "fireos" : "android";
    }

    private String h() {
        int orientation = AppLovinSdkUtils.getOrientation(this.c);
        return orientation == 1 ? "portrait" : orientation == 2 ? "landscape" : "none";
    }

    protected void a(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        this.f642a.r0().a((j5) new s6(this.f642a, ((Boolean) this.f642a.a(y4.S3)).booleanValue(), "DataCollector", new Runnable() { // from class: com.applovin.impl.sdk.l$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(appLovinBidTokenCollectionListener);
            }
        }), e6.b.CORE);
    }

    public Map a(Map map, boolean z, boolean z2) {
        HashMap map2 = new HashMap(64);
        Map mapA = a(z);
        Map mapF = F();
        Map mapM = m();
        Map mapL0 = this.f642a.l0();
        if (z2) {
            map2.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, mapA);
            map2.put("app_info", mapF);
            if (mapM != null) {
                map2.put("connection_info", mapM);
            }
            if (map != null) {
                map2.put("ad_info", map);
            }
            if (!CollectionUtils.isEmpty(mapL0)) {
                map2.put("segments", mapL0);
            }
        } else {
            map2.putAll(mapA);
            map2.putAll(mapF);
            if (mapM != null) {
                map2.putAll(mapM);
            }
            if (map != null) {
                map2.putAll(map);
            }
            if (!CollectionUtils.isEmpty(mapL0)) {
                map2.putAll(mapL0);
            }
        }
        map2.put("accept", "custom_size,launch_app,video");
        map2.put("format", "json");
        CollectionUtils.putStringIfValid("mediation_provider", this.f642a.V(), map2);
        CollectionUtils.putStringIfValid("mediation_provider_v2", this.f642a.C(), map2);
        CollectionUtils.putStringIfValid("plugin_version", (String) this.f642a.a(y4.Q3), map2);
        CollectionUtils.putLongIfValid("tssf_ms", Long.valueOf(this.f642a.u0()), map2);
        if (!((Boolean) this.f642a.a(y4.l5)).booleanValue()) {
            map2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f642a.j0());
        }
        CollectionUtils.putStringIfValid("connectEventKey", this.f642a.q(), map2);
        map2.putAll(e());
        map2.put("rid", UUID.randomUUID().toString());
        return map2;
    }

    private void b(final String str, final int i, final String str2) {
        this.f642a.r0().a((j5) new s6(this.f642a, "reportAppExitInfoStackTrace", new Runnable() { // from class: com.applovin.impl.sdk.l$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, i, str2);
            }
        }), e6.b.OTHER);
    }

    private String c(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
            for (int i2 = 9; i2 >= 0; i2--) {
                cArr[i] = (char) (cArr[i] ^ iArr[i2]);
            }
        }
        return new String(cArr);
    }

    private int b(String str) {
        try {
            return Settings.Secure.getInt(this.c.getContentResolver(), str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains(c("lz}$blpz"));
    }

    private Map a(boolean z) {
        Map map;
        synchronized (this.e) {
            map = CollectionUtils.map(this.d);
        }
        return a(map, z);
    }

    private void a(Map map) {
        JSONArray jSONArrayE;
        if (((Boolean) this.f642a.a(y4.Z3)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(d()));
        }
        if (((Boolean) this.f642a.a(y4.a4)).booleanValue() && !map.containsKey(ContentType.Font.TYPE)) {
            map.put(ContentType.Font.TYPE, Float.valueOf(s()));
        }
        if (((Boolean) this.f642a.a(y4.h4)).booleanValue() && o7.d(this.f642a)) {
            o8.a(this.f642a);
        }
        if (((Boolean) this.f642a.a(y4.s4)).booleanValue()) {
            o8.b(this.f642a);
        }
        if (((Boolean) this.f642a.a(y4.g4)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.f642a.a(y4.c4)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(Q()));
        }
        map.put("is_pc", Boolean.valueOf(R()));
        if (((Boolean) this.f642a.a(y4.u4)).booleanValue()) {
            CollectionUtils.putStringIfValid("oglv", J(), map);
        }
        if (((Boolean) this.f642a.a(y4.L6)).booleanValue()) {
            CollectionUtils.putStringIfValid("dbpn", o(), map);
        }
        if (!((Boolean) this.f642a.a(y4.M6)).booleanValue() || map.containsKey("video_decoders") || (jSONArrayE = E()) == null || jSONArrayE.length() <= 0) {
            return;
        }
        map.put("video_decoders", jSONArrayE);
    }

    private Map a(Map map, boolean z) {
        v.a aVarF;
        PowerManager powerManager;
        Map map2 = CollectionUtils.map(map);
        Point pointB = o0.b(this.c);
        map2.put("dx", Integer.valueOf(pointB.x));
        map2.put("dy", Integer.valueOf(pointB.y));
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            map2.put("screen_size_in", Double.valueOf(Math.sqrt(Math.pow(pointB.x, 2.0d) + Math.pow(pointB.y, 2.0d)) / ((double) displayMetrics.xdpi)));
        }
        map2.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.c)));
        if (((Boolean) this.f642a.a(y4.J4)).booleanValue()) {
            String strB = o7.b(this.c);
            Map mapA = o0.a(strB);
            if (mapA != null) {
                map2.put("display_cutout_insets", mapA);
            }
            Map mapC = o0.c(strB);
            if (mapC != null) {
                map2.put("status_bar_insets", mapC);
            }
            Map mapB = o0.b(strB);
            if (mapB != null) {
                map2.put("nav_bar_insets", mapB);
            }
        }
        if (z) {
            aVarF = (v.a) l.get();
            if (aVarF != null) {
                Y();
            } else if (o7.h()) {
                aVarF = new v.a();
                map2.put("inc", Boolean.TRUE);
            } else {
                aVarF = f();
            }
        } else {
            aVarF = f();
        }
        String strA = aVarF.a();
        if (StringUtils.isValidString(strA)) {
            map2.put("idfa", strA);
        }
        map2.put("dnt", Boolean.valueOf(aVarF.c()));
        map2.put("dnt_code", aVarF.b().b());
        b bVar = (b) m.get();
        if (((Boolean) this.f642a.a(y4.E3)).booleanValue() && bVar != null) {
            map2.put("idfv", bVar.f644a);
            map2.put("idfv_scope", Integer.valueOf(bVar.b));
        }
        Boolean boolB = p0.b().b(this.c);
        if (boolB != null) {
            map2.put("huc", boolB);
        }
        Boolean boolB2 = p0.c().b(this.c);
        if (boolB2 != null) {
            map2.put("aru", boolB2);
        }
        Boolean boolB3 = p0.a().b(this.c);
        if (boolB3 != null) {
            map2.put("dns", boolB3);
        }
        if (((Boolean) this.f642a.a(y4.T3)).booleanValue()) {
            c cVarJ = j();
            CollectionUtils.putIntegerIfValid("act", Integer.valueOf(cVarJ.f645a), map2);
            CollectionUtils.putIntegerIfValid("acm", Integer.valueOf(cVarJ.b), map2);
            CollectionUtils.putBooleanIfValid("sowpie", cVarJ.c, map2);
        }
        if (((Boolean) this.f642a.a(y4.b4)).booleanValue()) {
            map2.put("mtl", Integer.valueOf(this.f642a.n0().getLastTrimMemoryLevel()));
        }
        if (((Boolean) this.f642a.a(y4.e4)).booleanValue()) {
            map2.put("adr", Boolean.valueOf(O()));
        }
        Float fR = z ? (Float) this.i.get() : r();
        if (fR != null) {
            map2.put("volume", fR);
        }
        CollectionUtils.putBooleanIfValid("ma", v(), map2);
        CollectionUtils.putBooleanIfValid("spo", w(), map2);
        CollectionUtils.putBooleanIfValid("aif", Boolean.valueOf(!this.f642a.n0().isApplicationPaused()), map2);
        CollectionUtils.putLongIfValid("af_ts_ms", Long.valueOf(this.f642a.n0().getAppEnteredForegroundTimeMillis()), map2);
        CollectionUtils.putLongIfValid("ab_ts_ms", Long.valueOf(this.f642a.n0().getAppEnteredBackgroundTimeMillis()), map2);
        try {
            map2.put("sb", Integer.valueOf((int) ((Settings.System.getInt(this.c.getContentResolver(), "screen_brightness") / 255.0f) * 100.0f)));
        } catch (Settings.SettingNotFoundException e) {
            if (o.a()) {
                this.b.a("DataCollector", "Unable to collect screen brightness", e);
            }
        }
        if (((Boolean) this.f642a.a(y4.h4)).booleanValue() && o7.d(this.f642a)) {
            o8.a(this.f642a);
            String strA2 = o8.a();
            if (StringUtils.isValidString(strA2)) {
                map2.put("ua", strA2);
            }
        }
        if (((Boolean) this.f642a.a(y4.s4)).booleanValue()) {
            o8.b(this.f642a);
            CollectionUtils.putIntegerIfValid("wvvc", Integer.valueOf(o8.d()), map2);
            CollectionUtils.putStringIfValid("wvv", o8.c(), map2);
            CollectionUtils.putStringIfValid("wvpn", o8.b(), map2);
        }
        if (((Boolean) this.f642a.a(y4.V3)).booleanValue()) {
            try {
                map2.put("fs", Long.valueOf(Environment.getDataDirectory().getFreeSpace()));
                map2.put("tds", Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
            } catch (Throwable th) {
                map2.put("fs", -1);
                map2.put("tds", -1);
                if (o.a()) {
                    this.b.a("DataCollector", "Unable to collect total & free space.", th);
                }
            }
        }
        if (((Boolean) this.f642a.a(y4.W3)).booleanValue()) {
            ActivityManager.MemoryInfo memoryInfoA = o7.a((ActivityManager) this.c.getSystemService("activity"));
            if (memoryInfoA != null) {
                map2.put("fm", Long.valueOf(memoryInfoA.availMem));
                map2.put("tm", Long.valueOf(memoryInfoA.totalMem));
                map2.put("lmt", Long.valueOf(memoryInfoA.threshold));
                map2.put("lm", Boolean.valueOf(memoryInfoA.lowMemory));
            } else {
                map2.put("fm", -1);
                map2.put("tm", -1);
                map2.put("lmt", -1);
            }
        }
        if (((Boolean) this.f642a.a(y4.X3)).booleanValue() && o0.a("android.permission.READ_PHONE_STATE", this.c) && o0.g()) {
            map2.put("rat", Integer.valueOf(((TelephonyManager) this.c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getDataNetworkType()));
        }
        if (((Boolean) this.f642a.a(y4.U3)).booleanValue()) {
            String strA3 = A();
            if (!TextUtils.isEmpty(strA3)) {
                map2.put("so", strA3);
            }
        }
        map2.put("device_orientation", o7.b(this.c));
        map2.put("orientation_lock", h());
        if (((Boolean) this.f642a.a(y4.Y3)).booleanValue()) {
            map2.put("vs", Boolean.valueOf(o7.j()));
        }
        if (o0.e() && (powerManager = (PowerManager) this.c.getSystemService("power")) != null) {
            map2.put("lpm", Integer.valueOf(powerManager.isPowerSaveMode() ? 1 : 0));
        }
        if (((Boolean) this.f642a.a(y4.j4)).booleanValue() && this.f642a.m0() != null) {
            map2.put("da", Float.valueOf(this.f642a.m0().a()));
        }
        if (((Boolean) this.f642a.a(y4.k4)).booleanValue() && this.f642a.m0() != null) {
            map2.put("dm", Float.valueOf(this.f642a.m0().b()));
        }
        map2.put("mute_switch", Integer.valueOf(this.f642a.p().c()));
        map2.put("network", r0.g(this.f642a));
        String strQ = q();
        if (StringUtils.isValidString(strQ)) {
            map2.put("kb", strQ);
        }
        return map2;
    }

    private Map a(Intent intent) {
        if (intent == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(5);
        map.put(NativeProtocol.WEB_DIALOG_ACTION, StringUtils.emptyIfNull(intent.getAction()));
        map.put("data", StringUtils.emptyIfNull(intent.getDataString()));
        map.put("flags", Integer.valueOf(intent.getFlags()));
        ComponentName component = intent.getComponent();
        map.put("component", component != null ? component.flattenToString() : "");
        Set<String> categories = intent.getCategories();
        map.put("categories", categories != null ? new ArrayList(categories) : Collections.emptyList());
        return map;
    }

    private String a(ApplicationExitInfo applicationExitInfo, int i) {
        InputStream traceInputStream;
        String line;
        if (this.f642a.c(y4.I4).contains(Integer.toString(i))) {
            return null;
        }
        Integer num = (Integer) this.f642a.a(y4.H4);
        if (num.intValue() <= 0) {
            return null;
        }
        try {
            traceInputStream = applicationExitInfo.getTraceInputStream();
        } catch (Throwable th) {
            this.f642a.O();
            if (o.a()) {
                this.f642a.O().a("DataCollector", "Failed to obtain trace input stream from application exit info", th);
            }
            this.f642a.D().b("DataCollector", "getTraceInputStream", th);
            traceInputStream = null;
        }
        if (traceInputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(traceInputStream));
            for (int i2 = 0; i2 < num.intValue() && (line = bufferedReader.readLine()) != null; i2++) {
                try {
                    sb.append(line);
                    sb.append('\n');
                } finally {
                }
            }
            bufferedReader.close();
        } catch (Throwable th2) {
            this.f642a.O();
            if (o.a()) {
                this.f642a.O().a("DataCollector", "Failed to read stack trace from input stream", th2);
            }
            this.f642a.D().b("DataCollector", "readStackTraceFromInputStream", th2);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, int i, String str2) {
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("details", str);
        CollectionUtils.putStringIfValid(NativeProtocol.BRIDGE_ARG_ERROR_CODE, String.valueOf(i), mapHashMap);
        CollectionUtils.putStringIfValid(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str2, mapHashMap);
        this.f642a.D().d(d2.F0, mapHashMap);
    }

    public static void a(v.a aVar) {
        l.set(aVar);
    }

    public static void a(b bVar) {
        m.set(bVar);
    }

    public static void a(String str, k kVar) {
        String strA = a(k.o().getApplicationInfo().packageName, k.o().getPackageManager(), kVar);
        List listC = kVar.c(y4.X6);
        if (!StringUtils.isValidString(strA) || listC.contains(strA)) {
            j = str;
        }
    }

    private boolean a(String str) {
        return b(str) == 1;
    }

    private String a(String str, PackageManager packageManager) {
        if (!o0.b()) {
            return null;
        }
        try {
            return packageManager.getInstallSourceInfo(str).getOriginatingPackageName();
        } catch (Throwable th) {
            this.f642a.D().b("DataCollector", "getOriginatingName", th);
            return null;
        }
    }

    private static String a(String str, PackageManager packageManager, k kVar) {
        try {
            if (((Boolean) kVar.a(y4.C4)).booleanValue() && o0.b()) {
                return packageManager.getInstallSourceInfo(str).getInstallingPackageName();
            }
            return packageManager.getInstallerPackageName(str);
        } catch (Throwable th) {
            kVar.D().b("DataCollector", "getInstallerName", th);
            return null;
        }
    }
}
