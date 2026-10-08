package com.apm.insight;

import android.app.Application;
import android.content.Context;
import com.apm.insight.l.c;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.l;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Npth {
    private static boolean sInit;

    public static void setAlogWriteAddr(long j) {
    }

    public static boolean isJavaCrashEnable() {
        return l.b();
    }

    public static boolean isANREnable() {
        return l.c();
    }

    public static boolean isNativeCrashEnable() {
        return l.d();
    }

    public static boolean isInit() {
        return sInit;
    }

    public static void openJavaCrashMonitor() {
        l.f();
    }

    public static void openANRMonitor() {
        l.g();
    }

    public static boolean openNativeCrashMonitor() {
        return l.h();
    }

    public static synchronized void initMiniApp(Context context, ICommonParams iCommonParams) {
        e.o();
        init(context, iCommonParams, true, false, true, true);
    }

    public static synchronized void initMiniApp(Context context, ICommonParams iCommonParams, int i, String str) {
        e.o();
        e.b(i, str);
        init(context, iCommonParams, true, true, true, true);
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams) {
        init(context, iCommonParams, true, false, false);
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3) {
        init(context, iCommonParams, z, z, z2, z3);
    }

    public static void setCurProcessName(String str) {
        com.apm.insight.l.a.a(str);
    }

    public static void enableThreadsBoost() {
        e.l();
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3, boolean z4) {
        init(context, iCommonParams, z, z2, z3, z4, 0L);
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        Application applicationH;
        Context baseContext = context;
        synchronized (Npth.class) {
            if (e.h() != null) {
                applicationH = e.h();
            } else if (baseContext instanceof Application) {
                applicationH = (Application) baseContext;
                if (applicationH.getBaseContext() == null) {
                    throw new IllegalArgumentException("The Application passed in when init has not been attached, please pass a attachBaseContext as param and call Npth.setApplication(Application) before init.");
                }
            } else {
                applicationH = (Application) context.getApplicationContext();
                if (applicationH == null) {
                    throw new IllegalArgumentException("Can not get the Application instance since a baseContext was passed in when init, please call Npth.setApplication(Application) before init.");
                }
                if (applicationH.getBaseContext() != null) {
                    baseContext = applicationH.getBaseContext();
                }
            }
            init(applicationH, baseContext, iCommonParams, z, z2, z3, z4, j);
        }
    }

    public static void setApplication(Application application) {
        e.a(application);
    }

    public static synchronized void init(Application application, Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        if (sInit) {
            return;
        }
        sInit = true;
        l.a(application, context);
        e.a(application, context, iCommonParams);
        Map<String, Object> mapA = e.a().a();
        MonitorCrash monitorCrashInit = MonitorCrash.init(context, String.valueOf(c.AnonymousClass1.a(mapA.get("aid"), 4444)), c.AnonymousClass1.a(mapA.get("update_version_code"), 0), String.valueOf(mapA.get("app_version")));
        if (monitorCrashInit != null) {
            monitorCrashInit.config().setDeviceId(e.a().d()).setChannel(String.valueOf(mapA.get("channel")));
        }
    }

    public static boolean isRunning() {
        return l.i();
    }

    public static void reportDartError(String str) {
        l.a(str);
    }

    @Deprecated
    public static void reportError(Throwable th) {
        l.a(th);
    }

    @Deprecated
    public static void reportError(String str) {
        l.b(str);
    }

    public static ConfigManager getConfigManager() {
        return e.i();
    }

    public static void registerCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        l.a(iCrashCallback, crashType);
    }

    public static void registerOOMCallback(IOOMCallback iOOMCallback) {
        l.a(iOOMCallback);
    }

    public static void unregisterCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        l.b(iCrashCallback, crashType);
    }

    public static void unregisterOOMCallback(IOOMCallback iOOMCallback, CrashType crashType) {
        l.b(iOOMCallback);
    }

    public static void setCrashFilter(ICrashFilter iCrashFilter) {
        e.b().a(iCrashFilter);
    }

    @Deprecated
    public static void setAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            e.b().a(attachUserData, crashType);
        }
    }

    public static void addAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            e.b().a(attachUserData, crashType);
        }
    }

    public static void addAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            e.b().b(attachUserData, crashType);
        }
    }

    public static void removeAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            e.b().a(crashType, attachUserData);
        }
    }

    public static void removeAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            e.b().b(crashType, attachUserData);
        }
    }

    public static void setBusiness(String str) {
        if (str != null) {
            e.a(str);
        }
    }

    public static void addTags(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        e.b().a(map);
    }

    public static void stopAnr() {
        l.j();
    }

    public static void registerSdk(int i, String str) {
        e.a(i, str);
    }

    public static void setAlogFlushAddr(long j) {
        l.k();
    }

    public static void setAlogFlushV2Addr(long j) {
        l.a(j);
    }

    public static void setAlogLogDirAddr(long j) {
        l.b(j);
    }

    public static boolean hasCrash() {
        return l.l();
    }

    public static boolean hasCrashWhenJavaCrash() {
        return l.m();
    }

    public static boolean hasCrashWhenNativeCrash() {
        return l.n();
    }

    public static void dumpHprof(String str) {
        l.c(str);
    }

    public static boolean isStopUpload() {
        return l.o();
    }

    public static void stopUpload() {
        l.p();
    }

    public static void enableLoopMonitor(boolean z) {
        l.a(z);
    }

    public static void enableAnrInfo(boolean z) {
        l.b(z);
    }

    public static void checkInnerNpth(boolean z) {
        l.c(z);
    }

    public static void enableNativeDump(boolean z) {
        l.d(z);
    }

    public static void setCrashWaitTime(long j) {
        com.apm.insight.g.a.a(j);
    }

    public static void enableActivityDump(boolean z) {
        e.e(z);
    }

    public static void enableMessageDump(boolean z) {
        e.f(z);
    }
}
