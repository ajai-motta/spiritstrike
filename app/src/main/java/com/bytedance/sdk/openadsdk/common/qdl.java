package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.jyq;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.facebook.appevents.AppEventsConstants;
import java.io.File;
import java.io.FileFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private static final HashMap<String, qdl> qdl = new HashMap<>();
    private static final HashMap<String, C0225qdl> ud = new HashMap<>();
    private final Context lnr;
    private final C0225qdl mml;
    private final Map<ljh, Long> mo = Collections.synchronizedMap(new HashMap());
    private final String mzz;

    private qdl(Context context, String str) {
        this.lnr = context;
        C0225qdl c0225qdl = ud.get(str);
        this.mml = c0225qdl == null ? new C0225qdl(str) : c0225qdl;
        this.mzz = str;
    }

    public static qdl qdl(String str) {
        qdl qdlVar;
        HashMap<String, qdl> map = qdl;
        qdl qdlVar2 = map.get(str);
        if (qdlVar2 != null) {
            return qdlVar2;
        }
        synchronized (qdl.class) {
            qdlVar = map.get(str);
            if (qdlVar == null) {
                qdlVar = new qdl(com.bytedance.sdk.openadsdk.core.yt.qdl(), str);
                map.put(str, qdlVar);
            }
        }
        return qdlVar;
    }

    public static void qdl(String str, C0225qdl c0225qdl) {
        ud.put(str, c0225qdl);
    }

    public void qdl(String str, ljh ljhVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strLnr = this.mml.lnr(str);
        String strCev = ljhVar != null ? ljhVar.cev() : "";
        if (TextUtils.isEmpty(strLnr) || TextUtils.isEmpty(strCev) || strLnr.equals(strCev)) {
            this.mml.jpc(str);
        }
    }

    public void qdl() {
        String str;
        File file;
        File[] fileArrListFiles;
        try {
            boolean zWd = com.bytedance.sdk.openadsdk.core.tvp.wd(this.mzz);
            if (zWd) {
                str = "files";
            } else {
                str = "shared_prefs";
            }
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(this.lnr.getDataDir(), str);
            } else {
                file = new File(this.lnr.getDatabasePath("1").getParentFile().getParentFile(), str);
            }
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.common.qdl.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains(qdl.this.mzz);
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : fileArrListFiles) {
                    if (zWd) {
                        try {
                            com.bytedance.sdk.component.utils.wd.lnr(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        String strReplace = file2.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.lnr.deleteSharedPreferences(strReplace);
                        } else {
                            this.lnr.getSharedPreferences(strReplace, 0).edit().clear().apply();
                            com.bytedance.sdk.component.utils.wd.lnr(file2);
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File file3 = new File(ud());
            if (file3.exists() && file3.isDirectory()) {
                com.bytedance.sdk.component.utils.wd.lnr(file3);
            }
        } catch (Throwable unused3) {
        }
    }

    public void qdl(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
        ljh ljhVarMo;
        if ((qdlVar != null && qdlVar.mo() != null && qdlVar.mo().ilu()) || qdlVar == null || adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm()) || (ljhVarMo = qdlVar.mo()) == null || ljhVarMo.ly() == 2) {
            return;
        }
        try {
            this.mml.qdl(adSlot, qdlVar.rdp(), qdlVar.ud());
        } catch (Throwable unused) {
        }
    }

    public boolean qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, boolean z) {
        if (qdlVar == null || !qdlVar.mzz()) {
            return false;
        }
        if (z) {
            Iterator<ljh> it = qdlVar.mml().iterator();
            while (it.hasNext()) {
                if (!qdl(it.next())) {
                    it.remove();
                }
            }
        }
        return qdlVar.mzz();
    }

    public String ud(String str) {
        try {
            String strUd = this.mml.ud(str);
            if (TextUtils.isEmpty(strUd)) {
                return null;
            }
            return strUd;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String qdl(String str, long j) {
        long jMml = this.mml.mml(str);
        boolean zMzz = this.mml.mzz(str);
        if (System.currentTimeMillis() - jMml >= j || zMzz) {
            return null;
        }
        return ud(str);
    }

    private boolean qdl(ljh ljhVar) {
        if (ljhVar != null) {
            return vu.lnr(ljhVar) || ljhVar.tdy() != null;
        }
        return false;
    }

    private String ud() {
        return CacheDirFactory.getICacheDir(0).qdl();
    }

    public void lnr(String str) {
        this.mml.mo(str);
    }

    public boolean mml(String str) {
        return this.mml.wd(str);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.common.qdl$qdl, reason: collision with other inner class name */
    public static class C0225qdl {
        protected final String qdl;
        private final HashSet<String> wd = new HashSet<>();
        String ud = "material_data";
        String lnr = "has_played";
        String mml = "create_time";
        String mzz = "in_use_process";
        String mo = "req_id";

        public C0225qdl(String str) {
            this.qdl = TextUtils.isEmpty(str) ? "" : str;
        }

        protected String qdl(String str) {
            if (TextUtils.isEmpty(str)) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            return this.qdl + "_cache_" + str;
        }

        public String ud(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.mml.mml.ud(qdl(str), this.ud, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public String lnr(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.mml.mml.ud(qdl(str), this.mo, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public long mml(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl(qdl(str), this.mml, 0L);
            } catch (Throwable unused) {
                return 0L;
            }
        }

        public boolean mzz(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl(qdl(str), this.lnr, true);
            } catch (Throwable unused) {
                return true;
            }
        }

        public void mo(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl(qdl(str), this.mzz, jyq.ud(com.bytedance.sdk.openadsdk.core.yt.qdl()));
                this.wd.add(str);
            } catch (Throwable unused) {
            }
        }

        public boolean wd(String str) {
            try {
                String strQdl = qdl(str);
                String strUd = com.bytedance.sdk.openadsdk.multipro.mml.mml.ud(strQdl, this.mzz, "");
                if (TextUtils.isEmpty(strUd)) {
                    return false;
                }
                if (strUd.equals(jyq.ud(com.bytedance.sdk.openadsdk.core.yt.qdl())) && !this.wd.contains(str)) {
                    com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl(strQdl, this.mzz, "");
                    return false;
                }
            } catch (Throwable unused) {
            }
            return true;
        }

        public void qdl(AdSlot adSlot, String str, String str2) {
            try {
                String codeId = adSlot.getCodeId();
                String strQdl = qdl(codeId);
                com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl(strQdl, this.lnr, Boolean.FALSE);
                com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl(strQdl, this.mml, Long.valueOf(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl(strQdl, this.ud, str);
                com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl(strQdl, this.mzz, "");
                com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl(strQdl, this.mo, str2);
                this.wd.remove(codeId);
            } catch (Throwable unused) {
            }
        }

        public void jpc(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl(qdl(str));
                this.wd.remove(str);
            } catch (Throwable unused) {
            }
        }
    }
}
