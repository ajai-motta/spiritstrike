package com.bytedance.sdk.openadsdk.api.init;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.adsdk.ugeno.wd.mml;
import com.bytedance.sdk.component.jpc.to;
import com.bytedance.sdk.component.qdl;
import com.bytedance.sdk.component.tvp.mo;
import com.bytedance.sdk.component.tvp.mzz;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.bch;
import com.bytedance.sdk.component.utils.jpc;
import com.bytedance.sdk.component.utils.ljh;
import com.bytedance.sdk.component.utils.ud;
import com.bytedance.sdk.component.utils.vu;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;
import com.bytedance.sdk.openadsdk.core.bjy;
import com.bytedance.sdk.openadsdk.core.exu;
import com.bytedance.sdk.openadsdk.core.kdv;
import com.bytedance.sdk.openadsdk.core.rdp;
import com.bytedance.sdk.openadsdk.core.settings.rq;
import com.bytedance.sdk.openadsdk.core.settings.wd;
import com.bytedance.sdk.openadsdk.core.tvp;
import com.bytedance.sdk.openadsdk.core.tvp.fs;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.ljh.qdl;
import com.bytedance.sdk.openadsdk.multipro.aidl.ud;
import com.bytedance.sdk.openadsdk.multipro.lnr;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.jl;
import com.bytedance.sdk.openadsdk.utils.jtx;
import com.google.android.gms.games.GamesActivityResultCodes;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PAGSdk {
    public static final int INIT_LOCAL_FAIL_CODE = 4000;
    private static long qdl;

    public interface PAGInitCallback {
        void fail(int i, String str);

        void success();
    }

    static {
        try {
            qdl.qdl(new qdl.InterfaceC0210qdl() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.1
                @Override // com.bytedance.sdk.component.qdl.InterfaceC0210qdl
                public ExecutorService getExecutorService() {
                    return fco.mzz();
                }

                @Override // com.bytedance.sdk.component.qdl.InterfaceC0210qdl
                public HandlerThread getSafeHandlerThread(String str, int i) {
                    return jpc.qdl(str, i);
                }
            });
            fco.qdl(new com.bytedance.sdk.component.jpc.jpc("tt_init_memory_data") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(false);
                    PAGInitHelper.initAPM();
                    PAGInitHelper.initMemoryData();
                }
            });
            rdp.qdl(System.currentTimeMillis());
            rdp.ud();
            mo.setWebViewProvider(new mo.mml() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.3
                @Override // com.bytedance.sdk.component.tvp.mo.mml
                public WebView createWebView(Context context, AttributeSet attributeSet, int i, mo.lnr lnrVar) {
                    if (vu.ud(lnrVar)) {
                        return vu.ud(context, attributeSet, i, lnrVar);
                    }
                    if (!(context instanceof MutableContextWrapper)) {
                        context = context.getApplicationContext();
                    }
                    try {
                        return i == 0 ? new mzz(context, attributeSet) : new mzz(context, attributeSet, i);
                    } catch (Exception unused) {
                        return i == 0 ? new mzz(context, attributeSet) : new mzz(context, attributeSet, i);
                    }
                }
            });
        } catch (Throwable th) {
            Log.i("TTAD.PAGSdk", th.getMessage());
        }
        qdl = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(final Context context, final InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        Context applicationContext;
        qdl = SystemClock.elapsedRealtime();
        yt.ud(context);
        if (pAGInitCallback != null) {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                if (!PAGInitHelper.CALLBACK_LIST.contains(pAGInitCallback)) {
                    PAGInitHelper.CALLBACK_LIST.add(pAGInitCallback);
                    if (rdp.mml() == 3) {
                        return;
                    }
                }
            }
        }
        if (com.bytedance.sdk.openadsdk.common.mzz.qdl()) {
            ud(-1, "DisableSDK is called, interrupt initialization");
            return;
        }
        if (isInitSuccess()) {
            mml();
            lnr(initConfig);
            return;
        }
        if (initConfig == null) {
            ud(4000, "PAGConfig is null, please check.");
            return;
        }
        rdp.qdl(3);
        int pa = initConfig.getPA();
        if (pa < -1 || pa > 1) {
            ud(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, com.bytedance.sdk.openadsdk.core.jpc.qdl(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED));
            return;
        }
        if (context == null) {
            ud(4000, "Context is null, please check. ");
            return;
        }
        if (!(context instanceof Application) && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        mml(context, initConfig);
        ApmHelper.initApm(context, initConfig);
        try {
            tvp.qdl(new exu() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.4
                public void success() {
                    PAGSdk.mml();
                }

                @Override // com.bytedance.sdk.openadsdk.core.exu
                public void fail(int i, String str) {
                    PAGSdk.ud(i, str);
                }
            });
            try {
                ljh.qdl(yt.qdl(), "tt_ad_logo_txt");
                if (ljh.mml(context, "tt_ad_logo") == 0) {
                    qdl(initConfig, pAGInitCallback);
                    return;
                }
                if (isInitSuccess()) {
                    if (pAGInitCallback != null) {
                        mml();
                        return;
                    }
                    return;
                }
                final com.bytedance.sdk.openadsdk.mzz.qdl qdlVar = new com.bytedance.sdk.openadsdk.mzz.qdl();
                SDKTypeConfig.setSdkTypeFactory(new ISDKTypeFactory() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.5
                    @Override // com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory
                    public IADTypeLoaderFactory createADTypeLoaderFactory(String str) {
                        return qdlVar;
                    }
                });
                if (!initConfig.isSupportMultiProcess()) {
                    ud(context, initConfig);
                } else {
                    com.bytedance.sdk.openadsdk.multipro.aidl.qdl.qdl().qdl(new ud() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.6
                        @Override // com.bytedance.sdk.openadsdk.multipro.aidl.ud
                        public void onServiceConnected() {
                            rdp.ud().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    PAGSdk.ud(context, initConfig);
                                }
                            });
                        }
                    });
                    com.bytedance.sdk.openadsdk.multipro.aidl.qdl.qdl().lnr();
                }
            } catch (Throwable unused) {
                qdl(initConfig, pAGInitCallback);
            }
        } catch (Throwable unused2) {
            ud(4000, "Internal Error, setting exception. ");
        }
    }

    private static void qdl(InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        rdp.qdl(2);
        if (pAGInitCallback != null) {
            if (initConfig instanceof PAGConfig) {
                ud(4000, "resources not found, if you use aab please call PAGConfig.setPackageName");
            } else {
                ud(4000, "resources not found, if you use aab please call TTAdConfig.setPackageName");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(Context context, InitConfig initConfig) {
        long jElapsedRealtime;
        try {
        } catch (Throwable th) {
            th.getMessage();
            aaj.lnr("TTAD.PAGSdk", th.getMessage());
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - qdl;
            ud(4000, th.getMessage());
            jElapsedRealtime = jElapsedRealtime2;
        }
        if (isInitSuccess()) {
            mml();
            return;
        }
        mzz(context, initConfig);
        jElapsedRealtime = SystemClock.elapsedRealtime() - qdl;
        mml();
        mo(context, initConfig);
        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - qdl;
        qdl(context, isInitSuccess(), initConfig, jElapsedRealtime3, jElapsedRealtime);
        Long.valueOf(jElapsedRealtime);
        Long.valueOf(jElapsedRealtime3);
    }

    private static void lnr(Context context, InitConfig initConfig) {
        rdp.qdl = true;
        kdv.qdl().qdl(initConfig.getAppId()).ud(initConfig.getGdpr()).mzz(initConfig.getPA()).mml(initConfig.getAppIconId()).qdl(initConfig.getTitleBarTheme()).lnr(initConfig.getAdxId());
        tvp.ljh();
        if (initConfig instanceof PAGConfig) {
            kdv.qdl().lnr(((PAGConfig) initConfig).getDebugLog() ? 1 : 0);
        }
        try {
            if (ud(initConfig)) {
                kdv.qdl().qdl();
                jl.qdl();
            }
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.utils.tvp.qdl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ud(InitConfig initConfig) {
        return ((PAGConfig) initConfig).getDebugLog();
    }

    private static void mml(Context context, InitConfig initConfig) {
        if (!TextUtils.isEmpty(initConfig.getPackageName())) {
            ljh.qdl(initConfig.getPackageName());
            mml.qdl(initConfig.getPackageName());
        } else {
            ljh.qdl((String) null);
            mml.qdl((String) null);
        }
        yt.ud(context);
        if (initConfig.isSupportMultiProcess()) {
            com.bytedance.sdk.openadsdk.multipro.ud.qdl();
        } else {
            com.bytedance.sdk.openadsdk.multipro.ud.ud();
        }
        fs.qdl();
        com.bytedance.sdk.openadsdk.core.rq.ud.qdl(context);
    }

    private static void mzz(Context context, InitConfig initConfig) {
        if (wd.qdl()) {
            com.bytedance.sdk.component.jpc.mo.lnr(-1);
            com.bytedance.sdk.component.jpc.mo.qdl(new to() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.7
                @Override // com.bytedance.sdk.component.jpc.to
                public com.bytedance.sdk.component.jpc.tvp createThreadFactory(int i, String str) {
                    return new com.bytedance.sdk.component.jpc.tvp(i, str) { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.7.1
                        @Override // com.bytedance.sdk.component.jpc.tvp, java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            if (com.bytedance.sdk.component.jpc.tvp.sCrashHappened) {
                                return null;
                            }
                            int iRzg = rq.lnr().rzg();
                            if (iRzg >= -524288 && iRzg < 0) {
                                Thread thread = new Thread(this.qdl, runnable, this.ud, iRzg);
                                if (thread.isDaemon()) {
                                    thread.setDaemon(false);
                                }
                                if (this.lnr > 10 || this.lnr <= 0) {
                                    this.lnr = 5;
                                }
                                thread.setPriority(this.lnr);
                                return thread;
                            }
                            return super.newThread(runnable);
                        }
                    };
                }
            });
            lnr.qdl(context);
            com.bytedance.sdk.openadsdk.wd.ud.lnr();
            rdp.ud.set(true);
            try {
                com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().qdl(new com.bytedance.sdk.openadsdk.tvp.qdl());
            } catch (Exception e) {
                aaj.lnr("TTAD.PAGSdk", e.getMessage());
            }
            lnr(initConfig);
            lnr(context, initConfig);
            com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl(context, null);
            com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl(2);
            com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl(initConfig.isSupportMultiProcess());
            com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl(com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().mo());
        }
    }

    private static void mo(final Context context, final InitConfig initConfig) {
        SystemClock.elapsedRealtime();
        fco.qdl(new com.bytedance.sdk.component.jpc.jpc("init_sync") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8
            @Override // java.lang.Runnable
            public void run() {
                rdp.qdl(initConfig.getData());
                com.bytedance.sdk.openadsdk.jyq.qdl.qdl(context, initConfig.getAppId());
                com.bytedance.sdk.openadsdk.jyq.qdl.qdl();
                com.bytedance.sdk.openadsdk.yt.lnr.qdl();
                com.bytedance.sdk.openadsdk.yt.lnr.ud();
                new jtx();
                com.bytedance.sdk.component.adexpress.qdl.ud.mo.qdl(com.bytedance.sdk.openadsdk.utils.aaj.qdl() * 10);
                com.bytedance.sdk.openadsdk.mml.qdl.ud.qdl(context, initConfig.isSupportMultiProcess());
                bjy.qdl().ud();
                com.bytedance.sdk.openadsdk.core.to.lnr.qdl();
                com.bytedance.sdk.openadsdk.ljh.qdl.qdl(new qdl.InterfaceC0263qdl() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8.1
                    public void onGdprChanged(int i) {
                        PAGConfig.setGDPRConsent(i);
                    }
                });
                rq.mml = rq.ud(context);
                com.bytedance.sdk.openadsdk.bch.ud.wd.ud();
                com.bykv.vk.openvk.qdl.qdl.ud.qdl.qdl(yt.mml().ra());
                com.bykv.vk.openvk.qdl.qdl.ud.qdl.qdl(CacheDirFactory.getICacheDir(0));
                rq rqVarMml = yt.mml();
                if (!rqVarMml.lte()) {
                    synchronized (rqVarMml) {
                        if (!rqVarMml.lte()) {
                            rqVarMml.mml();
                            rqVarMml.gy();
                        }
                    }
                }
                DeviceUtils.rq();
                PAGInitHelper.maybeAsyncInitTask(context);
                PAGSdk.getBiddingToken();
                com.bytedance.sdk.component.jpc.mo.qdl(true);
                com.bytedance.sdk.component.jpc.mo.qdl(new com.bytedance.sdk.openadsdk.bjy.ud.qdl());
                DeviceUtils.qdl(context);
                DeviceUtils.rq(context);
                DeviceUtils.fs(context);
                com.bytedance.sdk.openadsdk.bjy.qdl.qdl();
                com.bytedance.sdk.openadsdk.core.settings.mml.qdl();
                com.bytedance.sdk.openadsdk.bjy.lnr.mml();
                gy.tvp(context);
                com.bytedance.sdk.openadsdk.mml.lnr.qdl();
                PAGSdk.lnr();
                com.bytedance.sdk.openadsdk.core.to.lnr.ud();
                com.bytedance.sdk.openadsdk.core.mzz.qdl.qdl().ud();
                com.bytedance.sdk.component.jpc.lnr.lnr.qdl(rdp.ud());
                com.bytedance.sdk.component.utils.ud.qdl(new ud.qdl() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8.2
                    @Override // com.bytedance.sdk.component.utils.ud.qdl
                    public boolean isEnableAsyncStartActivity() {
                        return com.bytedance.sdk.openadsdk.jyq.qdl.qdl("start_activity_async", 0) == 1;
                    }

                    @Override // com.bytedance.sdk.component.utils.ud.qdl
                    public boolean isStartActivityBySubThread() {
                        return com.bytedance.sdk.openadsdk.jyq.qdl.qdl("start_act_asy", 0) == 1;
                    }

                    @Override // com.bytedance.sdk.component.utils.ud.qdl
                    public ExecutorService getAsyncStartActivityThreadPool() {
                        return fco.tvp();
                    }
                });
                gy.lnr();
                bch.qdl(new bch.ud() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8.3
                    @Override // com.bytedance.sdk.component.utils.bch.ud
                    public void reportStatsByRate(final String str, boolean z, final bch.qdl qdlVar) {
                        com.bytedance.sdk.openadsdk.bjy.lnr.qdl(str, z, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8.3.1
                            @Override // com.bytedance.sdk.openadsdk.bjy.ud
                            public com.bytedance.sdk.openadsdk.bjy.qdl.lnr getLogStats() throws Exception {
                                return com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl(str).ud(qdlVar.ud());
                            }
                        });
                    }
                });
                vu.qdl(com.bytedance.sdk.openadsdk.jyq.qdl.qdl("webview_reuse_config", (String) null));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lnr() {
        ShortcutManager shortcutManager;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Context contextQdl = yt.qdl();
                if (contextQdl == null || (shortcutManager = (ShortcutManager) contextQdl.getSystemService(ShortcutManager.class)) == null) {
                    return;
                }
                tvp.ud().qdl(shortcutManager.isRequestPinShortcutSupported());
            } catch (Throwable unused) {
            }
        }
    }

    private static void lnr(InitConfig initConfig) {
        if (initConfig == null) {
            return;
        }
        if (!TextUtils.isEmpty(initConfig.getData())) {
            tvp.ud().lnr(initConfig.getData());
        }
        tvp.ud().lnr(ud(initConfig));
    }

    private static void qdl(final Context context, final boolean z, final InitConfig initConfig, final long j, final long j2) {
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl();
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl("pangle_sdk_init", false, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.9
            @Override // com.bytedance.sdk.openadsdk.bjy.ud
            public com.bytedance.sdk.openadsdk.bjy.qdl.lnr getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    boolean zLnr = tvp.ud().lnr();
                    jSONObject.put(TypedValues.TransitionType.S_DURATION, j);
                    jSONObject.put("sdk_init_time", j2);
                    jSONObject.put("is_async", true);
                    jSONObject.put("is_multi_process", initConfig.isSupportMultiProcess());
                    jSONObject.put("is_debug", PAGSdk.ud(initConfig));
                    jSONObject.put("is_use_texture_view", initConfig.isUseTextureView());
                    jSONObject.put("is_activate_init", zLnr);
                    jSONObject.put("minSdkVersion", gy.wd(context));
                    jSONObject.put("targetSdkVersion", gy.mo(context));
                    jSONObject.put("apm_is_init", ApmHelper.isIsInit());
                    jSONObject.put("is_success", z);
                    tvp.ud().ud(false);
                } catch (Exception e) {
                    aaj.qdl("TTAD.PAGSdk", "run: ", e);
                }
                return com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl("pangle_sdk_init").ud(jSONObject.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mml() {
        rdp.qdl(1);
        try {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                Iterator<PAGInitCallback> it = PAGInitHelper.CALLBACK_LIST.iterator();
                while (it.hasNext()) {
                    PAGInitCallback next = it.next();
                    if (next != null) {
                        it.remove();
                        next.success();
                    }
                }
            }
            com.bytedance.sdk.openadsdk.yt.lnr.ud(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.10
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    qdlVar.ud("init");
                    return qdlVar;
                }
            });
        } catch (Throwable th) {
            aaj.lnr(th.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(int i, String str) {
        rdp.qdl(2);
        try {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                Iterator<PAGInitCallback> it = PAGInitHelper.CALLBACK_LIST.iterator();
                while (it.hasNext()) {
                    PAGInitCallback next = it.next();
                    if (next != null) {
                        it.remove();
                        next.fail(i, str);
                    }
                }
                com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.11
                    @Override // com.bytedance.sdk.openadsdk.yt.mml
                    public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                        com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                        qdlVar.ud("init");
                        return qdlVar;
                    }
                });
            }
        } catch (Throwable th) {
            aaj.lnr(th.getMessage(), new Object[0]);
        }
    }

    public static void init(final Context context, final PAGConfig pAGConfig, final PAGInitCallback pAGInitCallback) {
        rdp.ud().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.12
            @Override // java.lang.Runnable
            public void run() {
                PAGSdk.ud(context, pAGConfig, pAGInitCallback);
            }
        });
        rdp.jpc();
    }

    public static boolean isInitSuccess() {
        return rdp.mml() == 1;
    }

    public static String getSDKVersion() {
        if (kdv.qdl() != null) {
            return kdv.qdl().lnr();
        }
        return "";
    }

    public static void getBiddingToken(final Context context, final PAGBiddingRequest pAGBiddingRequest, final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.mzz.qdl()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            fco.mzz(new com.bytedance.sdk.component.jpc.jpc("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.13
                @Override // java.lang.Runnable
                public void run() {
                    yt.ud(context);
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.ud(pAGBiddingRequest));
                    com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(false);
                }
            });
        }
    }

    public static void getBiddingToken(final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.mzz.qdl()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            fco.mzz(new com.bytedance.sdk.component.jpc.jpc("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.14
                @Override // java.lang.Runnable
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken());
                    com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(false);
                }
            });
        }
    }

    public static void getBiddingToken(final String str, final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.mzz.qdl()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            fco.mzz(new com.bytedance.sdk.component.jpc.jpc("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.15
                @Override // java.lang.Runnable
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken(str));
                    com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(false);
                }
            });
        }
    }

    public static String getBiddingToken(Context context) {
        if (com.bytedance.sdk.openadsdk.common.mzz.qdl()) {
            return null;
        }
        yt.ud(context);
        return getBiddingToken();
    }

    public static String getBiddingToken(Context context, String str) {
        if (com.bytedance.sdk.openadsdk.common.mzz.qdl()) {
            return null;
        }
        yt.ud(context);
        return getBiddingToken(str);
    }

    public static String getBiddingToken(String str) {
        if (com.bytedance.sdk.openadsdk.common.mzz.qdl()) {
            return null;
        }
        if (yt.qdl() == null || kdv.qdl() == null) {
            return "";
        }
        PAGBiddingRequest pAGBiddingRequest = new PAGBiddingRequest();
        pAGBiddingRequest.setSlotId(str);
        return kdv.qdl().qdl(pAGBiddingRequest);
    }

    public static String getBiddingToken() {
        if (com.bytedance.sdk.openadsdk.common.mzz.qdl()) {
            return null;
        }
        return (yt.qdl() == null || kdv.qdl() == null) ? "" : kdv.qdl().qdl((PAGBiddingRequest) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ud(PAGBiddingRequest pAGBiddingRequest) {
        if (com.bytedance.sdk.openadsdk.common.mzz.qdl()) {
            return null;
        }
        return (yt.qdl() == null || kdv.qdl() == null) ? "" : kdv.qdl().qdl(pAGBiddingRequest);
    }

    public static boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4) {
        if (kdv.qdl() != null) {
            return kdv.qdl().qdl(str, i, str2, str3, str4);
        }
        return false;
    }

    public static void closeMultiWebViewFileLock() {
        lnr.qdl();
    }

    public static void addPAGInitCallback(PAGInitCallback pAGInitCallback) {
        if (pAGInitCallback != null && rdp.mml() == 0) {
            PAGInitHelper.CALLBACK_LIST.add(pAGInitCallback);
        }
    }

    public static void setAabPackageName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ljh.qdl(str);
        mml.qdl(str);
    }

    public static void setAdRevenue(JSONObject jSONObject) {
        if (jSONObject != null && yt.mml().exc() && isInitSuccess()) {
            com.bytedance.sdk.openadsdk.bjy.lnr.qdl().qdl(jSONObject);
        }
    }

    private static void setSdkDisable(boolean z) {
        com.bytedance.sdk.openadsdk.common.mzz.qdl(z);
    }
}
