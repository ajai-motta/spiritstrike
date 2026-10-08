package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl;
import com.bytedance.sdk.component.mzz.jpc;
import com.bytedance.sdk.component.mzz.jtx;
import com.bytedance.sdk.component.mzz.rq;
import com.bytedance.sdk.component.mzz.to;
import com.bytedance.sdk.component.utils.jl;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.common.qdl;
import com.bytedance.sdk.openadsdk.core.aaj;
import com.bytedance.sdk.openadsdk.core.jyq;
import com.bytedance.sdk.openadsdk.core.model.bqt;
import com.bytedance.sdk.openadsdk.core.model.kdv;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.oth;
import com.bytedance.sdk.openadsdk.core.rdp;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.bytedance.sdk.openadsdk.utils.mrf;
import com.bytedance.sdk.openadsdk.utils.yt;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mo {
    private static volatile mo lnr = null;
    private static String qdl = "/openad_image_cache";
    private static String ud = "openad_image_cache";
    private final com.bytedance.sdk.openadsdk.ud.ud mml;
    private final Context mo;
    private final oth<com.bytedance.sdk.openadsdk.mml.qdl> mzz;
    private final Map<String, AtomicInteger> wd = new ConcurrentHashMap();

    public interface lnr {
        void qdl(Object obj);
    }

    public interface qdl {
        void qdl();

        void qdl(com.bytedance.sdk.openadsdk.jl.qdl.ud udVar);
    }

    interface ud {
        void qdl();

        void qdl(int i, String str);
    }

    private mo(Context context) {
        if (context != null) {
            this.mo = context.getApplicationContext();
        } else {
            this.mo = yt.qdl();
        }
        this.mml = new com.bytedance.sdk.openadsdk.ud.ud(10, 8, true);
        this.mzz = yt.lnr();
        if (com.bytedance.sdk.openadsdk.tvp.mml.ud()) {
            qdl += "_p";
            ud += "_p";
        }
        com.bytedance.sdk.openadsdk.common.qdl.qdl("tt_openad_materialMeta_new", new qdl.C0225qdl("tt_openad_materialMeta_new") { // from class: com.bytedance.sdk.openadsdk.component.mo.1
            @Override // com.bytedance.sdk.openadsdk.common.qdl.C0225qdl
            protected String qdl(String str) {
                return "tt_openad_materialMeta_new";
            }

            @Override // com.bytedance.sdk.openadsdk.common.qdl.C0225qdl
            public String ud(String str) {
                return com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("tt_openad_materialMeta_new", "material".concat(String.valueOf(str)), null);
            }

            @Override // com.bytedance.sdk.openadsdk.common.qdl.C0225qdl
            public void qdl(AdSlot adSlot, String str, String str2) {
                com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad_materialMeta_new", "material".concat(String.valueOf(adSlot.getCodeId())), str);
            }
        });
    }

    public static mo qdl(Context context) {
        if (lnr == null) {
            synchronized (mo.class) {
                if (lnr == null) {
                    lnr = new mo(context);
                }
            }
        }
        return lnr;
    }

    public static void qdl(ljh ljhVar, lnr lnrVar) {
        qdl(ljhVar, lnrVar, 0);
    }

    public static void qdl(ljh ljhVar, final lnr lnrVar, final int i) {
        String str = ljhVar.tdy().to();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        to toVarMml = com.bytedance.sdk.openadsdk.tvp.mml.qdl(str).qdl(ljhVar.tdy().lnr()).ud(ljhVar.tdy().ud()).mzz(ax.mzz(yt.qdl())).mml(ax.lnr(yt.qdl()));
        if (i > 0 && Build.VERSION.SDK_INT >= 26) {
            toVarMml.lnr(2).qdl(new jpc() { // from class: com.bytedance.sdk.openadsdk.component.mo.5
                @Override // com.bytedance.sdk.component.mzz.jpc
                public Bitmap qdl(Bitmap bitmap) {
                    return com.bytedance.sdk.component.adexpress.mml.qdl.qdl(yt.qdl(), bitmap, i);
                }
            });
        } else {
            toVarMml.lnr(1);
        }
        toVarMml.qdl(new com.bytedance.sdk.openadsdk.tvp.ud(ljhVar, str, new jtx() { // from class: com.bytedance.sdk.openadsdk.component.mo.6
            @Override // com.bytedance.sdk.component.mzz.jtx
            public void qdl(int i2, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.mzz.jtx
            public void qdl(rq rqVar) {
                lnr lnrVar2;
                if (rqVar == null || rqVar.ud() == null || rqVar.lnr() == null || (lnrVar2 = lnrVar) == null) {
                    return;
                }
                lnrVar2.qdl(rqVar.ud());
            }
        }));
    }

    public void qdl(final AdSlot adSlot) {
        if (adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        AtomicInteger atomicInteger = this.wd.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        }
        int iLnr = atomicInteger.get() + lnr(adSlot);
        if (iLnr > 0) {
            Integer.valueOf(iLnr);
            Integer.valueOf(1);
            return;
        }
        atomicInteger.incrementAndGet();
        this.wd.put(adSlot.getCodeId(), atomicInteger);
        final kdv kdvVar = new kdv();
        kdvVar.qdl(mrf.ud());
        if (Build.VERSION.SDK_INT >= 24) {
            kdvVar.ud(com.bytedance.sdk.openadsdk.component.wd.qdl.ud());
            kdvVar.ud(com.bytedance.sdk.openadsdk.component.wd.qdl.lnr());
        }
        bqt bqtVar = new bqt();
        bqtVar.rq = kdvVar;
        bqtVar.mml = 2;
        bqtVar.tvp = 2;
        if (com.bytedance.sdk.openadsdk.utils.ud.qdl()) {
            this.mzz.qdl(adSlot, bqtVar, 3, (aaj) new jyq() { // from class: com.bytedance.sdk.openadsdk.component.mo.7
                @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
                public void qdl(int i, String str) {
                    mo.this.ud(adSlot);
                    com.bytedance.sdk.openadsdk.component.mml.qdl.qdl(kdvVar, 101, 2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
                public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                    mo.this.qdl(qdlVar, lnrVar, adSlot, kdvVar);
                }
            });
        } else {
            this.mzz.qdl(adSlot, bqtVar, 3, new oth.qdl() { // from class: com.bytedance.sdk.openadsdk.component.mo.8
                @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
                public void qdl(int i, String str) {
                    mo.this.ud(adSlot);
                    com.bytedance.sdk.openadsdk.component.mml.qdl.qdl(kdvVar, 101, 2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
                public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                    mo.this.qdl(qdlVar, lnrVar, adSlot, kdvVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar, AdSlot adSlot, kdv kdvVar) {
        com.bytedance.sdk.openadsdk.component.mml.qdl.qdl(kdvVar, 101, 1);
        if (qdlVar == null || qdlVar.mml() == null || qdlVar.mml().isEmpty()) {
            lnrVar.qdl(-3);
            lnrVar.lnr(2);
            com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
            return;
        }
        ljh ljhVar = qdlVar.mml().get(0);
        if (ljhVar != null && ljhVar.xmv()) {
            com.bytedance.sdk.openadsdk.component.mzz.qdl qdlVar2 = new com.bytedance.sdk.openadsdk.component.mzz.qdl(ljhVar.fz(), ljhVar, qdlVar);
            qdl(qdlVar2);
            com.bytedance.sdk.openadsdk.component.mml.qdl.qdl(qdlVar2.ud(), 1, kdvVar);
            ud(adSlot);
            return;
        }
        if (ljh.mzz(ljhVar)) {
            qdl(ljhVar, adSlot, kdvVar, qdlVar);
        } else {
            ud(ljhVar, adSlot, kdvVar, qdlVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(AdSlot adSlot) {
        AtomicInteger atomicInteger = this.wd.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        } else {
            atomicInteger.decrementAndGet();
        }
        this.wd.put(adSlot.getCodeId(), atomicInteger);
    }

    private void qdl(final ljh ljhVar, final AdSlot adSlot, final kdv kdvVar, final com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
        final int iFz = ljhVar.fz();
        qdl(ljhVar, adSlot, kdvVar, new ud() { // from class: com.bytedance.sdk.openadsdk.component.mo.9
            @Override // com.bytedance.sdk.openadsdk.component.mo.ud
            public void qdl() {
                com.bytedance.sdk.openadsdk.component.mzz.qdl qdlVar2 = new com.bytedance.sdk.openadsdk.component.mzz.qdl(iFz, ljhVar, qdlVar);
                mo.this.qdl(qdlVar2);
                com.bytedance.sdk.openadsdk.component.mml.qdl.qdl(qdlVar2.ud(), 1, kdvVar);
                mo.this.ud(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.mo.ud
            public void qdl(int i, String str) {
                mo.this.ud(adSlot);
            }
        });
    }

    private void ud(final ljh ljhVar, final AdSlot adSlot, final kdv kdvVar, final com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
        final int iFz = ljhVar.fz();
        qdl(ljhVar, kdvVar, new qdl() { // from class: com.bytedance.sdk.openadsdk.component.mo.10
            @Override // com.bytedance.sdk.openadsdk.component.mo.qdl
            public void qdl(com.bytedance.sdk.openadsdk.jl.qdl.ud udVar) {
                com.bytedance.sdk.openadsdk.component.mzz.qdl qdlVar2 = new com.bytedance.sdk.openadsdk.component.mzz.qdl(iFz, ljhVar, qdlVar);
                mo.this.qdl(qdlVar2);
                com.bytedance.sdk.openadsdk.component.mml.qdl.qdl(qdlVar2.ud(), 1, kdvVar);
                mo.this.ud(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.mo.qdl
            public void qdl() {
                mo.this.ud(adSlot);
            }
        });
    }

    public void qdl(final ljh ljhVar, AdSlot adSlot, final kdv kdvVar, final ud udVar) {
        final mrf mrfVarUd = mrf.ud();
        final int iFz = ljhVar.fz();
        com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud udVarTdy = ljhVar.tdy();
        String strRq = udVarTdy.rq();
        String strRdp = udVarTdy.rdp();
        if (TextUtils.isEmpty(strRdp)) {
            strRdp = com.bytedance.sdk.component.utils.mzz.qdl(strRq);
        }
        final File fileQdl = com.bytedance.sdk.openadsdk.component.wd.qdl.qdl(strRdp);
        if (fileQdl.exists()) {
            com.bytedance.sdk.openadsdk.component.wd.qdl.qdl(fileQdl);
            qdl(iFz);
            long jMml = mrfVarUd.mml();
            if (kdvVar != null) {
                kdvVar.qdl(jMml);
                kdvVar.qdl(1);
            }
            udVar.qdl();
            qdl(ljhVar, (lnr) null);
            return;
        }
        if (yt.mml().uw(String.valueOf(iFz)) && !jl.mml(yt.qdl())) {
            udVar.qdl(100, "OnlyWifi");
            return;
        }
        com.bytedance.sdk.openadsdk.core.exu.qdl.ud udVarQdl = ljh.qdl(fileQdl.getParent(), ljhVar);
        udVarQdl.qdl("material_meta", ljhVar);
        udVarQdl.qdl("ad_slot", adSlot);
        com.bytedance.sdk.openadsdk.core.exu.mzz.qdl.qdl(udVarQdl, new qdl.InterfaceC0176qdl() { // from class: com.bytedance.sdk.openadsdk.component.mo.11
            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
            public void ud(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i) {
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i) {
                mo.this.qdl(iFz);
                long jMml2 = mrfVarUd.mml();
                com.bytedance.sdk.openadsdk.component.mml.qdl.ud(ljhVar, jMml2, true);
                kdv kdvVar2 = kdvVar;
                if (kdvVar2 != null) {
                    kdvVar2.qdl(jMml2);
                    kdvVar.qdl(2);
                }
                udVar.qdl();
                mo.qdl(ljhVar, (lnr) null);
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i, String str) {
                long jMml2 = mrfVarUd.mml();
                com.bytedance.sdk.openadsdk.component.mml.qdl.ud(ljhVar, jMml2, false);
                kdv kdvVar2 = kdvVar;
                if (kdvVar2 != null) {
                    kdvVar2.qdl(jMml2);
                }
                udVar.qdl(i, str);
                try {
                    if (fileQdl.exists() && fileQdl.isFile()) {
                        com.bytedance.sdk.component.utils.wd.lnr(fileQdl);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void qdl(final ljh ljhVar, final kdv kdvVar, final qdl qdlVar) {
        final mrf mrfVarUd = mrf.ud();
        final int iFz = ljhVar.fz();
        com.bytedance.sdk.openadsdk.core.model.jl jlVar = ljhVar.vm().get(0);
        String strWd = jlVar.wd();
        String strQdl = jlVar.qdl();
        int iUd = jlVar.ud();
        int iLnr = jlVar.lnr();
        String strQdl2 = TextUtils.isEmpty(strWd) ? com.bytedance.sdk.component.utils.mzz.qdl(strQdl) : strWd;
        if (TextUtils.isEmpty(strQdl2)) {
            if (qdlVar != null) {
                qdlVar.qdl();
                return;
            }
            return;
        }
        File fileUd = com.bytedance.sdk.openadsdk.component.wd.qdl.ud(strQdl2);
        if (qdl(strQdl, strWd)) {
            ud(iFz);
            long jMml = mrfVarUd.mml();
            if (kdvVar != null) {
                kdvVar.qdl(jMml);
                kdvVar.qdl(1);
            }
            qdlVar.qdl(null);
            return;
        }
        com.bytedance.sdk.openadsdk.utils.yt.qdl(new com.bytedance.sdk.openadsdk.jl.qdl(strQdl, jlVar.wd()), iUd, iLnr, new yt.qdl() { // from class: com.bytedance.sdk.openadsdk.component.mo.12
            @Override // com.bytedance.sdk.openadsdk.utils.yt.qdl
            public void qdl(com.bytedance.sdk.openadsdk.jl.qdl.ud udVar) {
                if (udVar.mzz()) {
                    mo.this.ud(iFz);
                    long jMml2 = mrfVarUd.mml();
                    com.bytedance.sdk.openadsdk.component.mml.qdl.qdl(ljhVar, jMml2, true);
                    kdv kdvVar2 = kdvVar;
                    if (kdvVar2 != null) {
                        kdvVar2.qdl(jMml2);
                        kdvVar.qdl(2);
                    }
                    qdlVar.qdl(udVar);
                    return;
                }
                com.bytedance.sdk.openadsdk.component.mml.qdl.qdl(ljhVar, mrfVarUd.mml(), false);
                qdlVar.qdl();
            }

            @Override // com.bytedance.sdk.openadsdk.utils.yt.qdl
            public void qdl() {
                com.bytedance.sdk.openadsdk.component.mml.qdl.qdl(ljhVar, mrfVarUd.mml(), false);
                qdlVar.qdl();
            }
        }, fileUd.getParent());
    }

    public void qdl(int i) {
        com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad", "video_has_cached".concat(String.valueOf(i)), Boolean.TRUE);
    }

    public void ud(int i) {
        com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad", "image_has_cached".concat(String.valueOf(i)), Boolean.TRUE);
    }

    public void qdl(final com.bytedance.sdk.openadsdk.component.mzz.qdl qdlVar) {
        rdp.ud().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.mo.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (qdlVar.ud() == null || ljh.wd(qdlVar.ud()) || qdlVar.ud().ilu()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad", "material_expiration_time" + qdlVar.qdl(), Long.valueOf(qdlVar.ud().ugg()));
                    if (com.bytedance.sdk.openadsdk.utils.ud.qdl()) {
                        com.bytedance.sdk.openadsdk.common.qdl.qdl("tt_openad_materialMeta_new").qdl(qdlVar.ud().ji(), qdlVar.lnr());
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad_materialMeta", "material" + qdlVar.qdl(), com.bytedance.sdk.component.utils.qdl.qdl(qdlVar.ud().rdz()).toString());
                } catch (Throwable unused) {
                }
            }
        });
    }

    public String lnr(int i) {
        String strUd = com.bytedance.sdk.openadsdk.common.qdl.qdl("tt_openad_materialMeta_new").ud(String.valueOf(i));
        long jQdl = com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad", "material_expiration_time".concat(String.valueOf(i)), -1L);
        if (System.currentTimeMillis() / 1000 < jQdl) {
            return strUd;
        }
        if (jQdl == -1) {
            return null;
        }
        mo(i);
        qdl(strUd);
        return null;
    }

    private void qdl(final String str) {
        fco.qdl(new com.bytedance.sdk.component.jpc.jpc("opencache") { // from class: com.bytedance.sdk.openadsdk.component.mo.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.model.qdl qdlVarUd;
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("cypher")) {
                        jSONObject = com.bytedance.sdk.openadsdk.core.yt.lnr().qdl(jSONObject);
                    }
                    if (jSONObject == null || !jSONObject.has("creatives") || (qdlVarUd = com.bytedance.sdk.openadsdk.core.model.qdl.ud(jSONObject)) == null || !qdlVarUd.mzz()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.mml.qdl.qdl(qdlVarUd.mo());
                } catch (Throwable unused) {
                }
            }
        });
    }

    public ljh mml(int i) {
        ljh ljhVarMzz = mzz(i);
        long jQdl = com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad", "material_expiration_time".concat(String.valueOf(i)), -1L);
        if (System.currentTimeMillis() / 1000 < jQdl && ljhVarMzz != null) {
            return ljhVarMzz;
        }
        if (ljhVarMzz == null && jQdl == -1) {
            return null;
        }
        mo(i);
        if (ljhVarMzz == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.component.mml.qdl.qdl(ljhVarMzz);
        return null;
    }

    public ljh mzz(int i) {
        String strUd = com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("tt_openad_materialMeta", "material".concat(String.valueOf(i)), null);
        if (!TextUtils.isEmpty(strUd)) {
            try {
                JSONObject jSONObjectQdl = com.bytedance.sdk.openadsdk.core.yt.lnr().qdl(new JSONObject(strUd));
                if (jSONObjectQdl == null || !jSONObjectQdl.has("creatives")) {
                    return com.bytedance.sdk.openadsdk.core.ud.qdl(jSONObjectQdl);
                }
                return null;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.aaj.lnr("TTAppOpenAdCacheManager", e.getMessage());
            }
        }
        return null;
    }

    public String qdl(ljh ljhVar) {
        if (ljhVar != null && ljhVar.tdy() != null && !TextUtils.isEmpty(ljhVar.tdy().rq())) {
            String strRq = ljhVar.tdy().rq();
            String strRdp = ljhVar.tdy().rdp();
            if (TextUtils.isEmpty(strRdp)) {
                strRdp = com.bytedance.sdk.component.utils.mzz.qdl(strRq);
            }
            File fileQdl = com.bytedance.sdk.openadsdk.component.wd.qdl.qdl(strRdp);
            if (fileQdl.exists() && fileQdl.isFile()) {
                return fileQdl.getAbsolutePath();
            }
        }
        return null;
    }

    public boolean qdl(String str, String str2) {
        boolean z;
        File file;
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = com.bytedance.sdk.component.utils.mzz.qdl(str);
            }
            File fileUd = com.bytedance.sdk.openadsdk.component.wd.qdl.ud(str2);
            InputStream inputStreamQdl = com.bytedance.sdk.openadsdk.tvp.mml.qdl(str, str2);
            if (inputStreamQdl != null) {
                try {
                    inputStreamQdl.close();
                } catch (IOException e) {
                    com.bytedance.sdk.component.utils.aaj.lnr("TTAppOpenAdCacheManager", e.getMessage());
                }
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (com.bytedance.sdk.openadsdk.tvp.mml.qdl(str, str2, fileUd.getParent())) {
                    return true;
                }
                if (com.bytedance.sdk.openadsdk.tvp.mml.ud()) {
                    file = new File(fileUd.getPath());
                } else {
                    file = new File(fileUd.getPath() + ".0");
                }
                if (file.exists()) {
                    return true;
                }
            }
            return z;
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAppOpenAdCacheManager", e2.getMessage());
            return false;
        }
    }

    public void mo(int i) {
        com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad_materialMeta_new", "material".concat(String.valueOf(i)));
        com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad_materialMeta", "material".concat(String.valueOf(i)));
        com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad", "material_expiration_time".concat(String.valueOf(i)));
        com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad", "video_has_cached".concat(String.valueOf(i)));
        com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad", "image_has_cached".concat(String.valueOf(i)));
    }

    public void qdl() {
        File[] fileArrListFiles;
        try {
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad_materialMeta");
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad_materialMeta_new");
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad");
        } catch (Throwable unused) {
        }
        try {
            File cacheDir = this.mo.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (fileArrListFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.mo.4
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file == null) {
                        return false;
                    }
                    String name = file.getName();
                    return name.contains(mo.ud) || name.contains("openad_video_cache");
                }
            })) == null) {
                return;
            }
            for (File file : fileArrListFiles) {
                try {
                    com.bytedance.sdk.component.utils.wd.lnr(file);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public String ud() {
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            return name + DomExceptionUtils.SEPARATOR + ud + DomExceptionUtils.SEPARATOR;
        }
        return name + DomExceptionUtils.SEPARATOR + qdl + DomExceptionUtils.SEPARATOR;
    }

    private int lnr(AdSlot adSlot) {
        long jQdl = com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tt_openad", "material_expiration_time" + adSlot.getCodeId(), -1L);
        Integer.valueOf(jQdl == -1 ? 0 : 1);
        return jQdl == -1 ? 0 : 1;
    }
}
