package com.bytedance.sdk.openadsdk.aaj.qdl;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.jpc.jpc;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.jtx;
import com.bytedance.sdk.component.utils.kdv;
import com.bytedance.sdk.openadsdk.aaj.ud.qdl;
import com.bytedance.sdk.openadsdk.core.rdp;
import com.bytedance.sdk.openadsdk.core.settings.wd;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private static volatile lnr qdl;
    private String lnr;
    private String mml;
    private final Set<String> mzz = Collections.synchronizedSet(new HashSet());
    private String ud;

    public static lnr qdl() {
        if (qdl == null) {
            synchronized (lnr.class) {
                if (qdl == null) {
                    qdl = new lnr();
                }
            }
        }
        return qdl;
    }

    public void qdl(Map<String, String> map) {
        File[] fileArrListFiles;
        if (wd.qdl() && com.bytedance.sdk.openadsdk.jyq.qdl.qdl("plb_res_enable", 0) == 1) {
            String strMo = mo();
            if (!TextUtils.isEmpty(strMo)) {
                File file = new File(strMo);
                if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2 != null) {
                            try {
                                File fileQdl = com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.qdl(file2);
                                if (fileQdl != null && fileQdl.exists()) {
                                    map.put(file2.getName(), fileQdl.getAbsolutePath());
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
            int iQdl = com.bytedance.sdk.openadsdk.jyq.qdl.qdl("plb_res_delay_fetch_time", 0);
            if (iQdl <= 0) {
                lnr();
            } else {
                rdp.ud().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aaj.qdl.lnr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        lnr.this.lnr();
                    }
                }, iQdl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lnr() {
        fco.qdl(new jpc("pag_plb_res_check") { // from class: com.bytedance.sdk.openadsdk.aaj.qdl.lnr.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.aaj.ud.qdl qdlVarUd = com.bytedance.sdk.openadsdk.aaj.ud.qdl.ud(com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("pag_plb_config", DeviceRequestsHelper.DEVICE_INFO_MODEL, ""));
                if (qdlVarUd != null) {
                    lnr.this.qdl(qdlVarUd, null, 0);
                }
            }
        });
    }

    public void ud() {
        if (wd.qdl() && com.bytedance.sdk.openadsdk.jyq.qdl.qdl("plb_res_enable", 0) == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("pag_plb_config", "last_update_time", 0L);
            final String strQdl = com.bytedance.sdk.openadsdk.jyq.qdl.qdl("plb_res", "");
            long jQdl = com.bytedance.sdk.openadsdk.jyq.qdl.qdl("plb_res_fetch_interval", Constants.ONE_HOUR);
            if (jQdl <= 0 || jQdl > 259200000) {
                jQdl = 3600000;
            }
            if (jCurrentTimeMillis < jQdl || TextUtils.isEmpty(strQdl)) {
                return;
            }
            int iQdl = com.bytedance.sdk.openadsdk.jyq.qdl.qdl("plb_res_delay_fetch_time", 0);
            if (iQdl <= 0) {
                ud(strQdl);
            } else {
                rdp.ud().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aaj.qdl.lnr.3
                    @Override // java.lang.Runnable
                    public void run() {
                        lnr.this.ud(strQdl);
                    }
                }, iQdl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(final String str) {
        fco.qdl(new jpc("pag_plb_update_config") { // from class: com.bytedance.sdk.openadsdk.aaj.qdl.lnr.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.wd.ud.ud udVarLnr = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().lnr();
                try {
                    udVarLnr.ud(com.bytedance.sdk.openadsdk.jpc.mml.qdl(udVarLnr, str));
                    com.bytedance.sdk.component.wd.ud udVarQdl = udVarLnr.qdl();
                    if (udVarQdl == null || !udVarQdl.mo()) {
                        return;
                    }
                    String strMml = udVarQdl.mml();
                    com.bytedance.sdk.openadsdk.aaj.ud.qdl qdlVarUd = com.bytedance.sdk.openadsdk.aaj.ud.qdl.ud(strMml);
                    com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("pag_plb_config", "last_update_time", Long.valueOf(System.currentTimeMillis()));
                    if (qdlVarUd != null) {
                        com.bytedance.sdk.openadsdk.aaj.ud.qdl qdlVarUd2 = com.bytedance.sdk.openadsdk.aaj.ud.qdl.ud(com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("pag_plb_config", DeviceRequestsHelper.DEVICE_INFO_MODEL, ""));
                        if (qdlVarUd2 == null || !qdlVarUd.qdl().equals(qdlVarUd2.qdl())) {
                            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("pag_plb_config", DeviceRequestsHelper.DEVICE_INFO_MODEL, strMml);
                            lnr.this.qdl(qdlVarUd, qdlVarUd2, 1);
                        }
                    }
                } catch (Exception e) {
                    aaj.lnr("PlayableResManager", e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void qdl(com.bytedance.sdk.openadsdk.aaj.ud.qdl qdlVar, com.bytedance.sdk.openadsdk.aaj.ud.qdl qdlVar2, int i) {
        List<qdl.C0220qdl> listLnr = null;
        qdl(qdlVar.ud(), qdlVar2 == null ? null : qdlVar2.ud(), 1, i);
        List<qdl.C0220qdl> listLnr2 = qdlVar.lnr();
        if (qdlVar2 != null) {
            listLnr = qdlVar2.lnr();
        }
        qdl(listLnr2, listLnr, 2, i);
    }

    private void qdl(List<qdl.C0220qdl> list, List<qdl.C0220qdl> list2, int i, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String strMzz = i == 1 ? mzz() : mo();
        for (qdl.C0220qdl c0220qdl : list) {
            String strQdl = c0220qdl.qdl();
            String strQdl2 = jtx.qdl(strQdl);
            if (!TextUtils.isEmpty(strQdl2)) {
                if (i == 1) {
                    strQdl2 = strQdl2 + lnr(strQdl);
                }
                String str = strQdl2;
                File file = new File(strMzz, str);
                boolean zExists = file.exists();
                if (i2 == 1) {
                    if (zExists && list2 != null && list2.contains(c0220qdl)) {
                        Integer.valueOf(i);
                        com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.lnr(file);
                    } else {
                        qdl(strQdl, strMzz, str, i, file, zExists);
                    }
                } else if (zExists) {
                    Integer.valueOf(i);
                } else {
                    qdl(strQdl, strMzz, str, i, file, zExists);
                }
            }
        }
    }

    private void qdl(final String str, final String str2, final String str3, final int i, final File file, final boolean z) {
        String strConcat;
        if (this.mzz.contains(str)) {
            return;
        }
        if (i == 2) {
            strConcat = str3 + ".zip";
        } else {
            strConcat = z ? "tmp".concat(String.valueOf(str3)) : str3;
        }
        this.mzz.add(str);
        com.bytedance.sdk.component.wd.ud.qdl qdlVarMml = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().mml();
        qdlVarMml.ud(str);
        qdlVarMml.qdl(str2, strConcat);
        final com.bytedance.sdk.component.wd.ud udVarQdl = qdlVarMml.qdl();
        this.mzz.remove(str);
        if (udVarQdl != null && udVarQdl.mo() && udVarQdl.mzz() != null && udVarQdl.mzz().exists()) {
            if (i == 2) {
                fco.ud(new jpc("downloadZip") { // from class: com.bytedance.sdk.openadsdk.aaj.qdl.lnr.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (z) {
                                file.delete();
                            }
                            String str4 = str2 + File.separator + str3;
                            kdv.qdl(udVarQdl.mzz().getAbsolutePath(), str4);
                            File file2 = new File(str4);
                            File fileQdl = com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.qdl(file2);
                            if (fileQdl != null && fileQdl.exists()) {
                                com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.qdl().lnr().put(file2.getName(), fileQdl.getAbsolutePath());
                            }
                            com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.ud(file2);
                        } catch (Throwable th) {
                            aaj.lnr("PlayableResManager", "unzip error: ", th, "tp=", Integer.valueOf(i), ", url=", str);
                        }
                        try {
                            udVarQdl.mzz().delete();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            } else {
                if (z) {
                    file.delete();
                    udVarQdl.mzz().renameTo(file);
                    return;
                }
                return;
            }
        }
        File file2 = new File(str2 + File.separator + str3 + ".tmp");
        if (file2.exists()) {
            try {
                file2.delete();
            } catch (Throwable unused) {
            }
        }
    }

    private static String lnr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("?");
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf == -1) {
            return "";
        }
        return "." + str.substring(iLastIndexOf + 1);
    }

    private String mml() {
        if (TextUtils.isEmpty(this.ud)) {
            try {
                File file = new File(yt.qdl().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.ud = file.getAbsolutePath();
            } catch (Throwable th) {
                aaj.lnr("PlayableResManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.ud;
    }

    private String mzz() {
        if (TextUtils.isEmpty(this.lnr)) {
            String str = mml() + File.separator + "common";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.lnr = str;
        }
        return this.lnr;
    }

    private String mo() {
        if (TextUtils.isEmpty(this.mml)) {
            String str = mml() + File.separator + "pregames";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.mml = str;
        }
        return this.mml;
    }

    public WebResourceResponse qdl(String str) {
        if (wd.qdl() && com.bytedance.sdk.openadsdk.jyq.qdl.qdl("plb_res_enable", 0) == 1) {
            String strQdl = jtx.qdl(str);
            if (TextUtils.isEmpty(strQdl)) {
                return null;
            }
            File file = new File(mzz(), strQdl + lnr(str));
            if (file.exists()) {
                try {
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
                    if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                        return null;
                    }
                    return new WebResourceResponse(mimeTypeFromExtension, "UTF-8", new FileInputStream(file));
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }
}
