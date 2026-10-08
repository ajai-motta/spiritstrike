package com.bytedance.sdk.openadsdk.core.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.compose.animation.core.AnimationConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.fs;
import com.bytedance.sdk.component.utils.jl;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.rdp;
import com.bytedance.sdk.openadsdk.core.settings.mzz;
import com.bytedance.sdk.openadsdk.core.settings.to;
import com.bytedance.sdk.openadsdk.core.settings.tvp;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.mml.qdl.rq;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.hive.base.Android;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.unity3d.ads.core.data.datasource.AndroidTcfDataSource;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte$$ExternalSyntheticBackport0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class rq implements tvp.qdl {
    private static String bqt;
    private final Set<String> bch;
    private final AtomicBoolean bjy;
    private boolean exc;
    private final com.bytedance.sdk.openadsdk.core.settings.qdl exu;
    private int jl;
    mzz.ud<com.bytedance.sdk.openadsdk.mml.qdl.rq> jpc;
    private volatile boolean jtx;
    private final BroadcastReceiver jyq;
    private final mzz.ud<Map<String, Integer>> ljh;
    private final Runnable oth;
    private final jpc rdp;
    private Set<String> to;
    private final mzz.ud<Set<String>> uw;
    final mzz.ud<ConcurrentHashMap<String, Integer>> wd;
    private mzz.ud<JSONObject> xmv;
    private int yt;
    public static final String qdl = UByte$$ExternalSyntheticBackport0.m("_", new CharSequence[]{"bus_con_collect", gy.vu()});
    public static final String ud = UByte$$ExternalSyntheticBackport0.m("_", new CharSequence[]{"bus_con", gy.vu(), gy.koa(), "timeout"});
    public static final String lnr = UByte$$ExternalSyntheticBackport0.m("_", new CharSequence[]{"bus_con", gy.vu(), gy.koa(), "alpha"});
    private static final String tvp = gy.oth();
    private static final com.bytedance.sdk.component.jpc.jpc rq = new com.bytedance.sdk.component.jpc.jpc("TemplateReInitTask") { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.1
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.adexpress.qdl.ud.mzz.ud().tvp();
            com.bytedance.sdk.component.adexpress.qdl.ud.mzz.ud().ud(false);
            com.bytedance.sdk.component.adexpress.qdl.ud.ud.ud();
            com.bytedance.sdk.component.adexpress.qdl.ud.mzz.ud().lnr();
        }
    };
    public static String mml = "";
    public static String mzz = AndroidTcfDataSource.TCF_TCSTRING_KEY;
    private static boolean fs = false;
    private static final ConcurrentLinkedQueue<to.qdl> aaj = new ConcurrentLinkedQueue<>();
    static final ConcurrentHashMap<String, Integer> mo = new ConcurrentHashMap<>();

    private static final class qdl {
        static final rq qdl = new rq();
    }

    private rq() {
        this.to = Collections.synchronizedSet(new HashSet());
        this.exu = new com.bytedance.sdk.openadsdk.core.settings.qdl();
        this.rdp = new jpc(new to.qdl() { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.5
            @Override // com.bytedance.sdk.openadsdk.core.settings.to.qdl
            public void qdl() {
                to.qdl[] qdlVarArr;
                boolean unused = rq.fs = true;
                if (rq.aaj == null || rq.aaj.size() == 0 || (qdlVarArr = (to.qdl[]) rq.aaj.toArray()) == null) {
                    return;
                }
                for (to.qdl qdlVar : qdlVarArr) {
                    qdlVar.qdl();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.to.qdl
            public void ud() {
                if (rq.aaj == null || rq.aaj.isEmpty()) {
                    return;
                }
                Iterator it = rq.aaj.iterator();
                while (it.hasNext()) {
                    ((to.qdl) it.next()).ud();
                }
            }
        });
        this.bjy = new AtomicBoolean(false);
        this.jtx = false;
        this.yt = 5000;
        this.jl = 10;
        AnonymousClass9 anonymousClass9 = new AnonymousClass9();
        this.jyq = anonymousClass9;
        this.oth = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.10
            @Override // java.lang.Runnable
            public void run() {
                rq.this.mml(2);
                rq.this.fzn();
            }
        };
        this.wd = new mzz.ud<ConcurrentHashMap<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.11
            @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.ud
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public ConcurrentHashMap<String, Integer> ud(String str) {
                if (TextUtils.isEmpty(str)) {
                    return rq.mo;
                }
                ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        int iOptInt = jSONObject.optInt(next, 100);
                        if (!TextUtils.isEmpty(next) && iOptInt >= 0 && iOptInt <= 100) {
                            concurrentHashMap.put(next, Integer.valueOf(iOptInt));
                        }
                    }
                } catch (JSONException e) {
                    Log.i("TTAD.SdkSettings", e.getMessage());
                }
                return concurrentHashMap;
            }
        };
        this.ljh = new mzz.ud<Map<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.12
            @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.ud
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public Map<String, Integer> ud(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    HashMap map = new HashMap(jSONObject.length());
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.isEmpty(next)) {
                            int iOptInt = jSONObject.optInt(next, 100);
                            if (iOptInt >= 0 && iOptInt <= 100) {
                                map.put(next, Integer.valueOf(iOptInt));
                            } else {
                                map.put(next, 100);
                            }
                        }
                    }
                    return map;
                } catch (Exception e) {
                    aaj.lnr("get applog rate from sp failed:" + e.getMessage(), new Object[0]);
                    return null;
                }
            }
        };
        this.bch = new HashSet();
        this.uw = new mzz.ud<Set<String>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.2
            @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.ud
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public Set<String> ud(String str) {
                HashSet hashSet = new HashSet();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int iOptInt = jSONObject.optInt("applog_count");
                        if (iOptInt >= 2 && iOptInt <= 100) {
                            rq.this.jl = iOptInt;
                        }
                        int iOptInt2 = jSONObject.optInt("applog_interval");
                        if (iOptInt2 >= 100 && iOptInt2 <= 30000) {
                            rq.this.yt = iOptInt2;
                        }
                        JSONArray jSONArray = jSONObject.getJSONArray("core_label_arr");
                        if (jSONArray != null) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                String string = jSONArray.getString(i);
                                if (!TextUtils.isEmpty(string)) {
                                    hashSet.add(string);
                                }
                            }
                        }
                    } catch (JSONException e) {
                        Log.i("TTAD.SdkSettings", e.getMessage());
                    }
                }
                return hashSet.size() == 0 ? new HashSet(Arrays.asList("click", "show", "insight_log", "mrc_show")) : hashSet;
            }
        };
        this.xmv = new mzz.ud<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.3
            @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.ud
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public JSONObject ud(String str) {
                JSONObject jSONObject;
                try {
                    jSONObject = new JSONObject(str);
                } catch (Throwable th) {
                    aaj.lnr("TTAD.SdkSettings", th.getMessage());
                    jSONObject = null;
                }
                return jSONObject == null ? new JSONObject() : jSONObject;
            }
        };
        this.jpc = new mzz.ud<com.bytedance.sdk.openadsdk.mml.qdl.rq>() { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.4
            @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.ud
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public com.bytedance.sdk.openadsdk.mml.qdl.rq ud(String str) {
                com.bytedance.sdk.openadsdk.mml.qdl.rq rqVar = new com.bytedance.sdk.openadsdk.mml.qdl.rq();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    rqVar.qdl(jSONObject.optInt("enable_strategy", 0) == 1);
                    rqVar.qdl(qdl(jSONObject.optJSONObject("default")));
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("adid_configs");
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            rqVar.qdl(next, qdl(jSONObjectOptJSONObject.getJSONObject(next)));
                        }
                    }
                } catch (Exception unused) {
                }
                return rqVar;
            }

            private rq.qdl qdl(JSONObject jSONObject) {
                if (jSONObject != null) {
                    return new rq.qdl(jSONObject.optInt("retry_times", -1), jSONObject.optInt("time_interval", -1));
                }
                return null;
            }
        };
        try {
            Context contextQdl = yt.qdl();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("_dataChanged");
            if (Build.VERSION.SDK_INT >= 33) {
                contextQdl.registerReceiver(anonymousClass9, intentFilter, 4);
            } else {
                contextQdl.registerReceiver(anonymousClass9, intentFilter);
            }
        } catch (Exception e) {
            aaj.qdl("TTAD.SdkSettings", "", e);
        }
    }

    public void qdl() {
        File file;
        try {
            lnr.qdl();
            this.rdp.lnr();
            this.exu.lnr();
            Context contextQdl = yt.qdl();
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(contextQdl.getDataDir(), "shared_prefs");
            } else {
                file = new File(contextQdl.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            File file2 = new File(file, "tt_sdk_settings.xml");
            if (file2.exists() && file2.isFile()) {
                String strReplace = file2.getName().replace(".xml", "");
                if (Build.VERSION.SDK_INT >= 24) {
                    contextQdl.deleteSharedPreferences(strReplace);
                } else {
                    contextQdl.getSharedPreferences(strReplace, 0).edit().clear().apply();
                    com.bytedance.sdk.component.utils.wd.lnr(file2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void ud(int i, boolean z) {
        Context contextQdl = yt.qdl();
        if (contextQdl != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(contextQdl.getPackageName());
                intent.setAction("_tryFetRemoDat");
                intent.putExtra("_force", z);
                intent.putExtra("_source", i);
                contextQdl.sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public static void ud() {
        Context contextQdl;
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr() && (contextQdl = yt.qdl()) != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(contextQdl.getPackageName());
                intent.setAction("_dataChanged");
                contextQdl.sendBroadcast(intent);
            } catch (Throwable th) {
                aaj.qdl("TTAD.SdkSettings", "", th);
            }
        }
    }

    public static int qdl(Context context) {
        SharedPreferences sharedPreferencesMml;
        if (context == null || (sharedPreferencesMml = mml(context)) == null) {
            return -2;
        }
        int i = sharedPreferencesMml.getInt("IABTCF_CmpSdkID", Integer.MIN_VALUE);
        int i2 = sharedPreferencesMml.getInt("IABTCF_CmpSdkVersion", Integer.MIN_VALUE);
        if (i == Integer.MIN_VALUE && i2 == Integer.MIN_VALUE) {
            return -2;
        }
        return sharedPreferencesMml.getInt("IABTCF_gdprApplies", -1);
    }

    public static String ud(Context context) {
        SharedPreferences sharedPreferencesMml;
        return (context == null || (sharedPreferencesMml = mml(context)) == null) ? "" : sharedPreferencesMml.getString(mzz, "");
    }

    private static SharedPreferences mml(Context context) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context);
        } catch (Exception unused) {
            return null;
        }
    }

    public static rq lnr() {
        return qdl.qdl;
    }

    public synchronized void mml() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = !this.jtx;
        this.exu.qdl(this.jtx);
        this.rdp.qdl(this.jtx);
        lnr.qdl(z);
        this.jtx = true;
        Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime);
        if (z) {
            rdp.ud().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.6
                @Override // java.lang.Runnable
                public void run() {
                    if (tvp.qdl()) {
                        rq.this.mml(1);
                        rq.this.fzn();
                    } else {
                        com.bytedance.sdk.openadsdk.multipro.aidl.qdl.qdl().ud();
                    }
                }
            }, 1000L);
        }
    }

    public String mzz() {
        return this.rdp.qdl("aes_key", "");
    }

    public int mo() {
        return this.rdp.qdl("max_tpl_cnts", 100);
    }

    public JSONObject wd() {
        return (JSONObject) this.rdp.qdl("digest", null, mzz.qdl);
    }

    public long jpc() {
        return this.rdp.qdl("data_time", 0L);
    }

    public void tvp() {
        this.rdp.qdl().qdl("tt_sdk_settings").qdl("ab_test_param").qdl();
    }

    public void qdl(JSONObject jSONObject, mzz.qdl qdlVar) {
        if (jSONObject == null || !jSONObject.has("dyn_draw_engine_url")) {
            return;
        }
        jpc jpcVar = this.rdp;
        String str = tvp;
        String strQdl = jpcVar.qdl("dyn_draw_engine_url", str);
        final String strOptString = jSONObject.optString("dyn_draw_engine_url", str);
        if (!TextUtils.isEmpty(strQdl) && !TextUtils.isEmpty(strOptString) && !strOptString.equals(strQdl)) {
            rdp.ud().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.7
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.equals(rq.this.rdp.qdl("dyn_draw_engine_url", rq.tvp), strOptString)) {
                        com.bytedance.sdk.component.adexpress.qdl.ud.mzz.ud().lnr();
                    }
                }
            }, 5000L);
        }
        qdlVar.qdl("dyn_draw_engine_url", strOptString);
    }

    public int qdl(String str) {
        if (str == null) {
            return 0;
        }
        return yt.mml().xmv(str).exc;
    }

    public void ud(JSONObject jSONObject, mzz.qdl qdlVar) {
        if (jSONObject.has("is_gdpr_user")) {
            int iOptInt = jSONObject.optInt("is_gdpr_user", -1);
            qdlVar.qdl("isGdprUser", (iOptInt == -1 || iOptInt == 1 || iOptInt == 0) ? iOptInt : -1);
        }
    }

    public boolean to() {
        return this.rdp.qdl("if_both_open", 0) == 1;
    }

    public String rq() {
        return this.rdp.qdl("ab_test_version", "");
    }

    public int fs() {
        return this.rdp.qdl("splash_video_load_strategy", 0);
    }

    public int qdl(String str, int i) {
        Integer num;
        Map map = (Map) this.rdp.qdl("perf_con_stats_rate", mo, this.wd);
        return (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) ? i : num.intValue();
    }

    public int ud(String str) {
        Integer num;
        Map map = (Map) this.rdp.qdl("perf_con_applog_rate", null, this.ljh);
        if (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) {
            return 100;
        }
        return num.intValue();
    }

    public int exu() {
        return this.rdp.qdl("perf_con_drawable_code", 0);
    }

    public Set<String> rdp() {
        return se();
    }

    public int bjy() {
        se();
        return this.jl;
    }

    public int jtx() {
        se();
        return this.yt;
    }

    public boolean yt() {
        return this.rdp.qdl("allow_blind_mode_request_ad", false);
    }

    public boolean jl() {
        return this.rdp.qdl("support_gzip", false);
    }

    public boolean exc() {
        return this.rdp.qdl("ad_revenue_enable", true);
    }

    public boolean aaj() {
        return this.rdp.qdl("bus_con_adshow_check_enable", true);
    }

    public int jyq() {
        int iQdl = this.rdp.qdl("bus_con_token_thread_count", 4);
        if (iQdl <= 0 || iQdl > 30) {
            return 4;
        }
        return iQdl;
    }

    public String oth() {
        return this.rdp.qdl("bus_con_express_host", "https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/");
    }

    public int ljh() {
        return this.rdp.qdl("bus_con_behavior_count", AnimationConstants.DefaultDurationMillis);
    }

    public String bch() {
        return this.rdp.qdl("bus_con_check_clz", "");
    }

    public boolean uw() {
        return this.rdp.qdl("bus_con_url_check", 1) != 0;
    }

    public boolean xmv() {
        return this.rdp.qdl(qdl, false);
    }

    public int bqt() {
        return this.rdp.qdl(ud, 10000);
    }

    public float koa() {
        return this.rdp.qdl(lnr, 1.0f);
    }

    public int vu() {
        return this.rdp.qdl("loadedCallbackOpportunity", 0);
    }

    public String rc() {
        return this.rdp.qdl("ab_test_param", "");
    }

    public boolean kdv() {
        return this.rdp.qdl("landingpage_new_style", -1) == 1;
    }

    public long ekw() {
        return this.rdp.qdl(TypedValues.TransitionType.S_DURATION, 10000L);
    }

    public int hkc() {
        return this.rdp.qdl("max", 50);
    }

    public mo hzv() {
        return (mo) this.rdp.qdl("insert_js_config", mo.qdl, new mzz.ud<mo>() { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.8
            @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.ud
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public mo ud(String str) {
                return new mo(str);
            }
        });
    }

    public int fco() {
        int iQdl = this.rdp.qdl("fetch_tpl_timeout_ctrl", 3000);
        if (iQdl <= 0) {
            return 3000;
        }
        return iQdl;
    }

    public int mrf() {
        int iQdl = this.rdp.qdl("fetch_tpl_second", 0);
        if (iQdl <= 0) {
            return 0;
        }
        return iQdl;
    }

    public void gy() {
        String strHd = hd();
        if (TextUtils.isEmpty(strHd)) {
            return;
        }
        if (strHd.equals("zh-Hant")) {
            fs.qdl(yt.qdl(), "zh", "tw");
        } else {
            fs.qdl(yt.qdl(), strHd, null);
        }
        try {
            TTAdDislikeToast.onResourceUpdated();
        } catch (Throwable th) {
            aaj.lnr("TTAD.SdkSettings", th.getMessage());
        }
    }

    private String hd() {
        return this.rdp.qdl("force_language", "");
    }

    public boolean lnr(String str) {
        return xmv(str).lnr == 1;
    }

    public boolean mml(String str) {
        return xmv(str).koa;
    }

    public boolean mzz(String str) {
        int i = xmv(str).mzz;
        if (i != 1) {
            return i == 2 && jl.lnr(yt.qdl()) != 0;
        }
        return jl.mml(yt.qdl());
    }

    public boolean mo(String str) {
        return xmv(str).wd == 1;
    }

    public int wd(String str) {
        return xmv(str).jl;
    }

    public boolean jpc(String str) {
        return str == null || xmv(str).rdp == 1;
    }

    public int tvp(String str) {
        if (str == null) {
            return 1500;
        }
        return xmv(str).jtx;
    }

    public int to(String str) {
        return xmv(str).rq;
    }

    public int rq(String str) {
        return xmv(str).fs;
    }

    public boolean fs(String str) {
        try {
            return xmv(str).ljh != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean ax() {
        return this.rdp.ud();
    }

    public int exu(String str) {
        return xmv(String.valueOf(str)).jpc;
    }

    public boolean rdp(String str) {
        return exu(str) != 1;
    }

    public int bjy(String str) {
        return xmv(str).to;
    }

    public boolean jtx(String str) {
        return xmv(str).oth == 0;
    }

    public boolean yt(String str) {
        return str == null || DeviceUtils.to(yt.qdl()) == 0 || xmv(str).exu == 1;
    }

    public String ag() {
        return this.rdp.qdl("ads_url", "");
    }

    public String wc() {
        return this.rdp.qdl("settings_url", "");
    }

    public String om() {
        return this.rdp.qdl("app_log_url", "");
    }

    public String cx() {
        return this.rdp.qdl("policy_url", "");
    }

    public int yh() {
        return this.rdp.qdl("ivrv_downward", 0);
    }

    public String wak() {
        return this.rdp.qdl("dyn_draw_engine_url", tvp);
    }

    public String gt() {
        return this.rdp.qdl("dc", "TX");
    }

    public int irn() {
        return this.rdp.qdl("isGdprUser", -1);
    }

    public int qdl(int i) {
        return xmv(String.valueOf(i)).kdv;
    }

    public int ud(int i) {
        return xmv(String.valueOf(i)).ud;
    }

    public int lnr(int i) {
        return xmv(String.valueOf(i)).tvp;
    }

    public int xi() {
        return this.rdp.qdl("vbtt", 5);
    }

    public JSONObject jl(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(this.rdp.qdl("core_settings", ""));
        } catch (JSONException e) {
            e = e;
        }
        try {
            jSONObject.put("ad_slot_setting", xmv(str).ekw);
            return jSONObject;
        } catch (JSONException e2) {
            e = e2;
            jSONObject2 = jSONObject;
            aaj.lnr("TTAD.SdkSettings", "getCoreSettingJsonObj", e.getMessage());
            return jSONObject2;
        }
    }

    public int exc(String str) {
        return xmv(str).aaj;
    }

    public boolean aaj(String str) {
        return xmv(str).jyq;
    }

    public int jyq(String str) {
        return xmv(str).uw;
    }

    public int oth(String str) {
        return xmv(str).xmv;
    }

    public int ljh(String str) {
        return xmv(str).bqt;
    }

    public boolean bch(String str) {
        return xmv(str).rc;
    }

    public boolean uw(String str) {
        return yt.mml().xmv(str).bjy == 1;
    }

    public ud xmv(String str) {
        return lnr.qdl(str);
    }

    public boolean jjk() {
        int iQdl = this.rdp.qdl("privacy_ad_enable", Integer.MAX_VALUE);
        if (iQdl == 1) {
            return true;
        }
        if (iQdl == 0) {
            return false;
        }
        int iBch = gy.bch();
        return iBch == 1 || iBch == 2 || iBch == 3;
    }

    public int zlt() {
        int iQdl = this.rdp.qdl("privacy_personalized_ad", Integer.MAX_VALUE);
        if (iQdl != Integer.MAX_VALUE) {
            return iQdl;
        }
        int iBch = gy.bch();
        if (iBch == 1 || iBch == 2) {
            return 2;
        }
        return iBch != 3 ? 0 : 1;
    }

    public boolean taz() {
        return this.rdp.qdl("perf_con_apm_native", Integer.MAX_VALUE) == 1;
    }

    public boolean tid() {
        boolean z = this.rdp.qdl("bus_con_sec_type", Integer.MAX_VALUE) != 0;
        Boolean.valueOf(z);
        return z;
    }

    public boolean sy() {
        return this.rdp.qdl("bus_con_dislike_report_raw", false);
    }

    public boolean car() {
        return this.rdp.qdl("privacy_debug_unlock", 1) != 0;
    }

    public boolean bqt(String str) {
        Set set = (Set) this.rdp.qdl("privacy_fields_allowed", Collections.emptySet(), mzz.ud);
        if (set.isEmpty()) {
            int iBch = gy.bch();
            if (iBch != 1) {
                if (iBch != 2 && iBch != 3) {
                    return false;
                }
                if (!Android.HW_IDS_MCC.equals(str) && !Android.HW_IDS_MNC.equals(str)) {
                    return false;
                }
            }
            return true;
        }
        return set.contains(str);
    }

    public boolean mlb() {
        return this.rdp.qdl("privacy_app_reg", true);
    }

    public boolean lte() {
        return this.jtx;
    }

    public boolean dk() {
        return this.rdp.qdl("global_rate", 1.0f) == 1.0f;
    }

    public boolean ijp() {
        return this.rdp.qdl("read_video_from_cache", 1) == 1;
    }

    public int zy() {
        int iQdl = this.rdp.qdl("perf_con_webview_cache_count", 0);
        if (iQdl < 0) {
            return 0;
        }
        return iQdl;
    }

    public int en() {
        int iQdl = this.rdp.qdl("perf_con_webview_cache_count_v3", 0);
        if (iQdl < 0) {
            return 0;
        }
        return iQdl;
    }

    public String[] nz() {
        Set<String> set;
        try {
            set = this.to;
        } catch (Throwable unused) {
        }
        if (set == null || set.size() == 0) {
            JSONArray jSONArray = new JSONArray(this.rdp.qdl("gecko_hosts", (String) null));
            if (jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.to.add(jSONArray.getString(i));
                }
            }
            Set<String> setQdl = jpc.qdl(this.to);
            this.to = setQdl;
            if (setQdl != null) {
                if (setQdl.size() == 0) {
                }
            }
            return null;
        }
        return (String[]) this.to.toArray(new String[0]);
    }

    public int kab() {
        return this.rdp.qdl("blank_detect_rate", 30);
    }

    public JSONObject ra() {
        return (JSONObject) this.rdp.qdl("video_cache_config", null, mzz.qdl);
    }

    public long qk() {
        long jQdl = this.rdp.qdl("req_inter_min", 600000L);
        if (jQdl < 0 || jQdl > 86400000) {
            return 600000L;
        }
        return jQdl;
    }

    public long tqd() {
        return this.rdp.qdl("last_req_time", 0L);
    }

    public void qdl(long j) {
        this.rdp.qdl().qdl("last_req_time", j).qdl();
    }

    void fzn() {
        if (tvp.qdl()) {
            rdp.ud().removeCallbacks(this.oth);
            rdp.ud().postDelayed(this.oth, qk());
        }
    }

    public void mml(int i) {
        qdl(i, false);
    }

    public void qdl(int i, boolean z) {
        if (!rdp.mzz() && i != 1 && i != 2) {
            if (z) {
                this.exc = true;
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.tvp.ud().mml())) {
                return;
            }
            if (this.exc) {
                this.exc = false;
                if (!z) {
                    z = true;
                }
            }
            long jTqd = tqd();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jQk = qk();
            long j = jCurrentTimeMillis - jTqd;
            if (z || j >= jQk) {
                if (!tvp.qdl()) {
                    ud(i, z);
                } else if (this.bjy.compareAndSet(false, true)) {
                    fco.ud((com.bytedance.sdk.component.jpc.jpc) new tvp(this, this.rdp, this.exu));
                    rdp.ud().removeCallbacks(this.oth);
                }
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("settings request error", "settings", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.tvp.qdl
    public void qdl(boolean z) {
        this.bjy.set(false);
        fzn();
        if (z) {
            HashMap map = new HashMap();
            Set<String> setSyy = syy();
            if (setSyy != null && !setSyy.isEmpty()) {
                map.put(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS, setSyy);
            }
            String strJl = gy.jl();
            if (!TextUtils.isEmpty(strJl)) {
                map.put(PglSSConfig.CUSTOMINFO_KEY_TRANSFER_HOST, strJl);
            }
            map.put(PglSSConfig.CUSTOMINFO_KEY_TARGET_IDC, ca());
            com.bytedance.sdk.openadsdk.core.to.ud.ud().qdl(map);
            ud();
        }
    }

    public void lnr(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("_tryFetRemoDat");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.jyq, intentFilter, 4);
            } else {
                context.registerReceiver(this.jyq, intentFilter);
            }
        } catch (Exception e) {
            aaj.qdl("TTAD.SdkSettings", "", e);
        }
        if (lte()) {
            mml(1);
            fzn();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.settings.rq$9, reason: invalid class name */
    class AnonymousClass9 extends BroadcastReceiver {
        private final Runnable ud = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.9.1
            @Override // java.lang.Runnable
            public void run() {
                fco.ud(new com.bytedance.sdk.component.jpc.jpc("LoadLocalData") { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.9.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            rq.this.mml();
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        };

        AnonymousClass9() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            fco.ud(new com.bytedance.sdk.component.jpc.jpc("setting_receiver") { // from class: com.bytedance.sdk.openadsdk.core.settings.rq.9.2
                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    if ("_tryFetRemoDat".equals(action)) {
                        rq.this.qdl(intent.getIntExtra("_source", 0), intent.getBooleanExtra("_force", false));
                    } else if ("_dataChanged".equals(action)) {
                        com.bytedance.sdk.component.utils.tvp.qdl().removeCallbacks(AnonymousClass9.this.ud);
                        com.bytedance.sdk.component.utils.tvp.qdl().postDelayed(AnonymousClass9.this.ud, 10000L);
                    }
                }
            });
        }
    }

    public boolean lq() {
        if (com.bytedance.sdk.component.adexpress.mml.ud.qdl(yt.qdl())) {
            return this.rdp.qdl("support_rtl", false);
        }
        return false;
    }

    public int gg() {
        return this.rdp.qdl("bus_con_send_log_type", 1);
    }

    private Set<String> se() {
        return (Set) this.rdp.qdl("perf_con_applog_send", this.bch, this.uw);
    }

    public int rzg() {
        return this.rdp.qdl("perf_con_thread_stack_size", 0);
    }

    public boolean ji() {
        int iQdl = this.exu.qdl("perf_con_apm", 100);
        if (iQdl == 0) {
            return false;
        }
        return iQdl < 0 || iQdl >= 100 || iQdl > ((int) (Math.random() * 100.0d));
    }

    public long ew() {
        return this.rdp.qdl("perf_con_adlog_expire_time", 0L);
    }

    public boolean blf() {
        return this.rdp.qdl("perf_con_use_new_thread_pool", 0) == 1;
    }

    public boolean zvv() {
        return this.rdp.qdl("perf_con_is_new_net_thread", 0) == 1;
    }

    public boolean qdl(PangleEncryptConstant.CryptDataScene cryptDataScene) {
        if (cryptDataScene == PangleEncryptConstant.CryptDataScene.GET_ADS || cryptDataScene == PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN) {
            return this.rdp.qdl("perf_con_crypt_V4_get_ad", false);
        }
        if (cryptDataScene == PangleEncryptConstant.CryptDataScene.APP_LOG) {
            return this.rdp.qdl("perf_con_crypt_V4_applog", false);
        }
        return this.rdp.qdl("perf_con_crypt_V4", false);
    }

    public JSONObject bx() {
        return (JSONObject) this.rdp.qdl("perf_con_thread_pool_config", new JSONObject(), this.xmv);
    }

    public boolean jut() {
        return this.rdp.qdl("perf_con_adlog_turn_off_retry_ad", 0) == 1;
    }

    public boolean jnw() {
        return this.rdp.qdl("perf_con_adlog_turn_off_retry_stats", 0) == 1;
    }

    public String zpu() {
        return this.rdp.qdl("dual_event_url", (String) null);
    }

    public int jle() {
        int iQdl = this.rdp.qdl("bus_con_auto_click_delay", 3000);
        if (iQdl <= 0) {
            return 3000;
        }
        return iQdl;
    }

    public com.bytedance.sdk.openadsdk.mml.qdl.rq xdk() {
        return (com.bytedance.sdk.openadsdk.mml.qdl.rq) this.rdp.qdl("perf_con_track_url_strategy", com.bytedance.sdk.openadsdk.mml.qdl.rq.qdl, this.jpc);
    }

    public int dps() {
        return this.rdp.qdl("perf_con_close_button_delay_check_time", -1);
    }

    public Set<String> iw() {
        return (Set) this.rdp.qdl("perf_con_drop2rt_skip_label_list", Collections.emptySet(), mzz.ud);
    }

    public static boolean lme() {
        return fs;
    }

    public static void qdl(to.qdl qdlVar) {
        ConcurrentLinkedQueue<to.qdl> concurrentLinkedQueue = aaj;
        if (concurrentLinkedQueue.contains(qdlVar)) {
            return;
        }
        concurrentLinkedQueue.add(qdlVar);
    }

    public boolean kr() {
        return this.rdp.qdl("bus_con_video_keep_screen_on", 1) == 1;
    }

    public void xx() {
        mzz.qdl qdlVarQdl = this.rdp.qdl();
        qdlVarQdl.qdl("settings_url", "");
        qdlVarQdl.qdl();
        vu("");
    }

    public Set<String> syy() {
        return (Set) this.rdp.qdl("privacy_fields_allowed", Collections.emptySet(), mzz.ud);
    }

    public boolean tdy() {
        return this.rdp.qdl("token_enable", 0) == 1;
    }

    public boolean koa(String str) {
        Set set;
        if (TextUtils.isEmpty(str) || (set = (Set) this.rdp.qdl("token_adx_ids", Collections.emptySet(), mzz.ud)) == null || set.size() == 0) {
            return false;
        }
        return set.contains(str);
    }

    public String ca() {
        return this.rdp.qdl("target_region", "");
    }

    public static String gsp() {
        if (bqt == null) {
            String strUd = com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("settings_host_from_meta", "");
            bqt = strUd;
            if (strUd == null) {
                bqt = "";
            }
        }
        return bqt;
    }

    public static void vu(String str) {
        if (str == null) {
            str = "";
        }
        String strGsp = gsp();
        if (strGsp == null || !strGsp.equals(str)) {
            com.bytedance.sdk.openadsdk.core.lnr.qdl().qdl("settings_host_from_meta", str);
            bqt = str;
            lnr().qdl(8, true);
        }
    }
}
