package com.bytedance.sdk.openadsdk.core.fs.lnr;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.jpc.jpc;
import com.bytedance.sdk.component.utils.wd;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.fs.qdl.ud;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.mzz;
import com.bytedance.sdk.openadsdk.core.yt;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mml {
    public static final List<String> qdl = Arrays.asList(MimeTypes.VIDEO_MP4, MimeTypes.VIDEO_H263);
    private static final ConcurrentHashMap<String, Boolean> ud = new ConcurrentHashMap<>();

    public static double qdl(int i, double d, int i2, int i3, int i4, String str) {
        double dQdl = qdl(i, d, i2, i3);
        return ud(str) * (1.0d / ((dQdl + 1.0d) + qdl(i4)));
    }

    private static double qdl(int i, double d, int i2, int i3) {
        return (d > 0.0d ? Math.abs(d - (i3 > 0 ? ((double) i2) / ((double) i3) : 0.0d)) : 0.0d) + (i > 0 ? Math.abs((i - i2) / i) : 0.0d);
    }

    private static double qdl(int i) {
        int iMax = Math.max(i, 0);
        if (700 > iMax || iMax > 1500) {
            return Math.min(Math.abs(700 - iMax) / 700.0f, Math.abs(1500 - iMax) / 1500.0f);
        }
        return 0.0d;
    }

    private static double ud(String str) {
        if (str == null) {
            str = "";
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -1664118616) {
            return (iHashCode == 1331848029 && str.equals(MimeTypes.VIDEO_MP4)) ? 1.5d : 1.0d;
        }
        str.equals(MimeTypes.VIDEO_H263);
        return 1.0d;
    }

    public static void qdl(ljh ljhVar) {
        mzz mzzVarAf;
        ArrayList<mzz.qdl> arrayListQdl;
        if (ljhVar == null || !mzz.qdl(ljhVar) || (mzzVarAf = ljhVar.af()) == null || (arrayListQdl = mzzVarAf.qdl()) == null || arrayListQdl.isEmpty()) {
            return;
        }
        for (mzz.qdl qdlVar : arrayListQdl) {
            String strMml = qdlVar.mml();
            if (!TextUtils.isEmpty(strMml)) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.mzz mzzVar = new com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.mzz(yt.qdl(), 0, 0);
                com.bytedance.sdk.openadsdk.core.fs.qdl qdlVarQdl = mzzVar.qdl(strMml, (File) null, new ArrayList());
                if (qdlVarQdl != null) {
                    qdlVar.qdl(qdlVarQdl.qdl());
                    qdlVar.qdl(qdlVarQdl.exu());
                }
                qdl(ljhVar, "vast_content", qdlVarQdl, jElapsedRealtime, mzzVar.mo);
            }
            qdl(ljhVar, qdlVar);
        }
    }

    public static void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
        List<ljh> listMml = qdlVar.mml();
        if (listMml != null) {
            Iterator<ljh> it = listMml.iterator();
            while (it.hasNext()) {
                qdl(it.next());
            }
        }
    }

    private static void qdl(final ljh ljhVar, final mzz.qdl qdlVar) {
        File fileQdl;
        String strLnr = qdlVar.lnr();
        if (TextUtils.isEmpty(strLnr)) {
            return;
        }
        final String str = strLnr + ljhVar.cev();
        ConcurrentHashMap<String, Boolean> concurrentHashMap = ud;
        if (concurrentHashMap.containsKey(str) || (fileQdl = qdl(str)) == null) {
            return;
        }
        if (fileQdl.exists() && fileQdl.length() > 0) {
            ud(ljhVar, fileQdl, qdlVar, 0L);
            return;
        }
        concurrentHashMap.put(str, Boolean.TRUE);
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.component.wd.ud.qdl qdlVarMml = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().mml();
        qdlVarMml.ud(strLnr);
        qdlVarMml.qdl(fileQdl.getParent(), fileQdl.getName());
        qdlVarMml.lnr(strLnr);
        qdlVarMml.qdl(new com.bytedance.sdk.component.wd.qdl.qdl() { // from class: com.bytedance.sdk.openadsdk.core.fs.lnr.mml.1
            @Override // com.bytedance.sdk.component.wd.qdl.qdl
            public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, com.bytedance.sdk.component.wd.ud udVar) {
                if (!udVar.mo() || udVar.mzz() == null || !udVar.mzz().exists()) {
                    mml.ud(ljhVar, qdlVar.lnr(), false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                } else {
                    mml.ud(ljhVar, udVar.mzz(), qdlVar, SystemClock.elapsedRealtime() - jElapsedRealtime);
                }
                mml.ud.remove(str);
            }

            @Override // com.bytedance.sdk.component.wd.qdl.qdl
            public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, IOException iOException) {
                mml.ud(ljhVar, qdlVar.lnr(), false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                mml.ud.remove(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(ljh ljhVar, File file, mzz.qdl qdlVar, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.mzz mzzVar = new com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.mzz(yt.qdl(), 0, 0);
        com.bytedance.sdk.openadsdk.core.fs.qdl qdlVarQdl = mzzVar.qdl((String) null, file, new ArrayList());
        if (qdlVarQdl != null) {
            qdlVar.qdl(qdlVarQdl.qdl());
            qdlVar.qdl(qdlVarQdl.exu());
        }
        ud(ljhVar, qdlVar.lnr(), true, j);
        qdl(ljhVar, "vast_url", qdlVarQdl, jElapsedRealtime, mzzVar.mo);
        ud();
    }

    private static void ud() {
        File[] fileArrListFiles;
        File fileQdl = qdl(yt.qdl(), com.bytedance.sdk.openadsdk.multipro.ud.lnr());
        if (fileQdl == null || (fileArrListFiles = fileQdl.listFiles()) == null || fileArrListFiles.length <= 5) {
            return;
        }
        Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.bytedance.sdk.openadsdk.core.fs.lnr.mml.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public int compare(File file, File file2) {
                if (file.lastModified() < file2.lastModified()) {
                    return -1;
                }
                return file.lastModified() > file2.lastModified() ? 1 : 0;
            }
        });
        int length = fileArrListFiles.length - 5;
        for (int i = 0; i < fileArrListFiles.length && i < length; i++) {
            File file = fileArrListFiles[i];
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static File qdl(String str) {
        String strQdl = com.bytedance.sdk.component.utils.mzz.qdl(str);
        if (strQdl == null) {
            return null;
        }
        return wd.qdl(yt.qdl(), com.bytedance.sdk.openadsdk.multipro.ud.lnr(), new File(CacheDirFactory.getRootDir()).getName() + "/vast/", strQdl);
    }

    private static File qdl(Context context, boolean z) {
        return wd.qdl(context, z, new File(CacheDirFactory.getRootDir()).getName() + "/vast/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(ljh ljhVar, final String str, final boolean z, final long j) {
        com.bytedance.sdk.openadsdk.mml.lnr.qdl(System.currentTimeMillis(), ljhVar, ljhVar.mzz(), "track_url_request_result", new com.bytedance.sdk.openadsdk.bjy.lnr.qdl() { // from class: com.bytedance.sdk.openadsdk.core.fs.lnr.mml.3
            @Override // com.bytedance.sdk.openadsdk.bjy.lnr.qdl, com.bytedance.sdk.openadsdk.bjy.lnr.ud
            public JSONObject lnr() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", str);
                    jSONObject.put(TypedValues.TransitionType.S_DURATION, j);
                    jSONObject.put("success", z);
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void qdl(final ljh ljhVar, final String str, final com.bytedance.sdk.openadsdk.core.fs.qdl qdlVar, final long j, final ud.qdl qdlVar2) {
        com.bytedance.sdk.openadsdk.mml.lnr.qdl(new jpc("vast_parser1") { // from class: com.bytedance.sdk.openadsdk.core.fs.lnr.mml.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TypedValues.TransitionType.S_DURATION, SystemClock.elapsedRealtime() - j);
                    jSONObject.put("from", str);
                    if (qdlVar != null) {
                        ljh ljhVar2 = ljhVar;
                        com.bytedance.sdk.openadsdk.mml.lnr.ud(ljhVar2, ljhVar2.mzz(), "track_load_vast_success", jSONObject);
                        return;
                    }
                    ud.qdl qdlVar3 = qdlVar2;
                    if (qdlVar3 != null) {
                        jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, qdlVar3.qdl);
                    }
                    ljh ljhVar3 = ljhVar;
                    com.bytedance.sdk.openadsdk.mml.lnr.ud(ljhVar3, ljhVar3.mzz(), "track_load_vast_fail", jSONObject);
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void ud(final ljh ljhVar, final String str, final com.bytedance.sdk.openadsdk.core.fs.qdl qdlVar, final long j, final ud.qdl qdlVar2) {
        com.bytedance.sdk.openadsdk.mml.lnr.qdl(new jpc("vast_parser2") { // from class: com.bytedance.sdk.openadsdk.core.fs.lnr.mml.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TypedValues.TransitionType.S_DURATION, SystemClock.elapsedRealtime() - j);
                    com.bytedance.sdk.openadsdk.core.fs.qdl qdlVar3 = qdlVar;
                    String str2 = "load_vast_fail";
                    if (qdlVar3 != null) {
                        if (TextUtils.isEmpty(qdlVar3.tvp()) || TextUtils.isEmpty(qdlVar.mo()) || qdlVar.jpc() <= 0.0d) {
                            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -3);
                        } else {
                            str2 = "load_vast_success";
                        }
                    } else {
                        ud.qdl qdlVar4 = qdlVar2;
                        if (qdlVar4 != null) {
                            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, qdlVar4.qdl);
                        }
                    }
                    com.bytedance.sdk.openadsdk.mml.lnr.ud(ljhVar, str, str2, jSONObject);
                    com.bytedance.sdk.openadsdk.core.fs.qdl qdlVar5 = qdlVar;
                    if (qdlVar5 == null || qdlVar5.ud() == null || !TextUtils.isEmpty(qdlVar.ud().mo())) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 1000);
                        jSONObject2.put("description", "1000:Image url is null");
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.mml.lnr.ud(ljhVar, str, "load_vast_icon_fail", jSONObject2);
                    qdlVar.qdl((com.bytedance.sdk.openadsdk.core.fs.ud) null);
                } catch (Exception unused2) {
                }
            }
        });
    }
}
