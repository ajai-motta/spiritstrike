package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class bqt {
    private static int mo = Integer.MAX_VALUE;
    private static String mzz;
    public static boolean qdl;
    public static boolean ud;
    private static final CharSequence lnr = "amigo";
    private static final CharSequence mml = "funtouch";
    private static final ConcurrentHashMap<String, String> wd = new ConcurrentHashMap<>();

    public static String qdl() {
        if (!TextUtils.isEmpty(mzz)) {
            return mzz;
        }
        String strQdl = com.bytedance.sdk.openadsdk.core.tvp.qdl("sdk_local_rom_info", 604800000L);
        mzz = strQdl;
        if (TextUtils.isEmpty(strQdl)) {
            String strOth = oth();
            mzz = strOth;
            com.bytedance.sdk.openadsdk.core.tvp.qdl("sdk_local_rom_info", strOth);
        }
        return mzz;
    }

    private static String oth() {
        if (bjy()) {
            return jtx();
        }
        if (mzz()) {
            return fs();
        }
        if (ud()) {
            return yt();
        }
        if (jl()) {
            return exc();
        }
        String strExu = exu();
        if (!TextUtils.isEmpty(strExu)) {
            return strExu;
        }
        if (wd()) {
            return mo();
        }
        if (jpc()) {
            return tvp();
        }
        if (mml()) {
            return lnr();
        }
        String str = to();
        return !TextUtils.isEmpty(str) ? str : Build.DISPLAY;
    }

    public static boolean ud() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String lnr() {
        return mml("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean mml() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean mzz() {
        if (!ud) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    qdl = true;
                    ud = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            ud = true;
        }
        return qdl;
    }

    public static String mo() {
        return mml("ro.vivo.os.build.display.id") + "_" + mml("ro.vivo.product.version");
    }

    public static boolean wd() {
        String strMml = mml("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strMml) && strMml.toLowerCase().contains(mml);
    }

    public static boolean jpc() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(lnr);
    }

    public static String tvp() {
        return Build.DISPLAY + "_" + mml("ro.gn.sv.version");
    }

    public static String to() {
        if (rq()) {
            return "eui_" + mml("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean rq() {
        return !TextUtils.isEmpty(mml("ro.letv.release.version"));
    }

    public static String fs() {
        if (mzz()) {
            return "miui_" + mml("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String exu() {
        String strRdp = rdp();
        if (strRdp != null && strRdp.toLowerCase().contains("emotionui")) {
            return strRdp + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String rdp() {
        return mml("ro.build.version.emui");
    }

    public static boolean bjy() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String jtx() {
        if (bjy()) {
            try {
                return "smartisan_".concat(String.valueOf(mml("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String yt() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean jl() {
        if (mo == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strWd = gy.wd("kllk");
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(strWd)) {
                mo = 1;
            } else {
                mo = 0;
            }
        }
        return mo == 1;
    }

    public static String exc() {
        if (jl()) {
            return "coloros_" + mml(gy.wd("ro.build.version.kllkrom")) + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean aaj() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("huawei")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean qdl(String str) {
        if (TextUtils.isEmpty(str)) {
            str = rdp();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || aaj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String lnr(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String line = "";
        Process process = null;
        try {
            try {
                try {
                    Process processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
                        try {
                            line = bufferedReader.readLine();
                            processExec.exitValue();
                            bufferedReader.close();
                        } catch (IllegalThreadStateException unused) {
                            process = processExec;
                            try {
                                process.destroy();
                            } catch (Throwable unused2) {
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return line;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                com.bytedance.sdk.component.utils.aaj.qdl("ToolUtils", "Unable to read sysprop ".concat(String.valueOf(str)), th);
                                return line;
                            } finally {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e) {
                                        com.bytedance.sdk.component.utils.aaj.qdl("ToolUtils", "Exception while closing InputStream", e);
                                    }
                                }
                            }
                        }
                    } catch (IllegalThreadStateException unused3) {
                        bufferedReader = null;
                    }
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (IllegalThreadStateException unused4) {
                bufferedReader = null;
            }
        } catch (IOException e2) {
            com.bytedance.sdk.component.utils.aaj.qdl("ToolUtils", "Exception while closing InputStream", e2);
        }
        return line;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String mml(String str) {
        String str2;
        String str3 = wd.get(str);
        if (str3 != null) {
            return str3;
        }
        if (!TextUtils.isEmpty("")) {
            str2 = "";
        } else {
            final com.bytedance.sdk.component.jpc.wd wdVar = new com.bytedance.sdk.component.jpc.wd(new qdl(str), 5, 2);
            fco.ud(new com.bytedance.sdk.component.jpc.jpc("_getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.utils.bqt.1
                @Override // java.lang.Runnable
                public void run() {
                    wdVar.run();
                }
            });
            str2 = (String) wdVar.get(1L, TimeUnit.SECONDS);
        }
        return str2 == null ? "" : str2;
    }

    public static class qdl implements Callable<String> {
        private final String qdl;

        public qdl(String str) {
            this.qdl = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            String str = (String) bqt.wd.get(this.qdl);
            if (str != null) {
                return str;
            }
            System.currentTimeMillis();
            String strLnr = bqt.lnr(this.qdl);
            System.currentTimeMillis();
            if (strLnr != null) {
                bqt.wd.put(this.qdl, strLnr);
            }
            return strLnr;
        }
    }
}
