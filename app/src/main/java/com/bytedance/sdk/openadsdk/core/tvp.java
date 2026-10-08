package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.core.mml.wd;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class tvp {
    private static boolean exu;
    public static exu qdl;
    public static final Set<String> ud = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.tvp.1
        {
            add("8025677");
            add("5001121");
        }
    };
    private boolean bjy;
    private int fs;
    private volatile ConcurrentHashMap<String, wd.qdl> jl;
    private String jpc;
    private String jtx;
    private boolean lnr;
    private String mml;
    private String mo;
    private String mzz;
    private String rdp;
    private Integer rq;
    private Bitmap to;
    private int tvp;
    private int wd;
    private com.bytedance.sdk.openadsdk.core.exu.lnr.lnr yt;

    public boolean bjy() {
        return true;
    }

    public static void qdl(exu exuVar) {
        qdl = exuVar;
    }

    public boolean qdl() {
        return this.bjy;
    }

    public void qdl(boolean z) {
        this.bjy = z;
    }

    private tvp() {
        this.lnr = false;
        this.tvp = 0;
        this.to = null;
        this.rq = null;
        this.fs = -1;
        this.jl = null;
    }

    public static tvp ud() {
        return qdl.qdl;
    }

    private static class qdl {
        private static final tvp qdl = new tvp();
    }

    public boolean lnr() {
        return com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_file", "sdk_activate_init", true);
    }

    public void ud(boolean z) {
        com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_file", "sdk_activate_init", Boolean.valueOf(z));
    }

    public String mml() {
        if (TextUtils.isEmpty(this.mml)) {
            String strQdl = qdl("app_id", Long.MAX_VALUE);
            if (!TextUtils.isEmpty(strQdl)) {
                this.mml = strQdl;
            }
        }
        return this.mml;
    }

    public static void qdl(int i) {
        if (i >= 0) {
            qdl("domain_index", String.valueOf(i));
        }
    }

    public static int mzz() {
        try {
            String strQdl = qdl("domain_index", Long.MAX_VALUE);
            if (TextUtils.isEmpty(strQdl)) {
                return 0;
            }
            return Integer.valueOf(strQdl).intValue();
        } catch (Throwable th) {
            th.getMessage();
            return 0;
        }
    }

    public static void ud(int i) {
        if (i >= 0) {
            qdl("config_fail_times", String.valueOf(i));
        }
    }

    public static int mo() {
        try {
            String strQdl = qdl("config_fail_times", Long.MAX_VALUE);
            if (TextUtils.isEmpty(strQdl)) {
                return 0;
            }
            return Integer.valueOf(strQdl).intValue();
        } catch (Throwable th) {
            th.getMessage();
            return 0;
        }
    }

    public void qdl(String str) {
        to(str);
        this.mml = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qdl("app_id", str);
        com.bytedance.sdk.openadsdk.core.settings.rq.lnr().mml(7);
    }

    public String wd() {
        String str = this.mzz;
        if (str != null) {
            return str;
        }
        String strQdl = qdl("mediation_info", Long.MAX_VALUE);
        this.mzz = strQdl;
        if (strQdl == null) {
            this.mzz = "";
        }
        return this.mzz;
    }

    public void ud(String str) {
        this.mzz = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qdl("mediation_info", str);
    }

    public String jpc() {
        if (TextUtils.isEmpty(this.mo)) {
            this.mo = qdl(yt.qdl());
        }
        return this.mo;
    }

    private String qdl(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Throwable unused) {
            return "";
        }
    }

    public void lnr(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_icon_id", "icon_id", Integer.valueOf(i));
        }
        this.wd = i;
    }

    public int tvp() {
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            return com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_icon_id", "icon_id", 0);
        }
        return this.wd;
    }

    public int to() {
        Integer num = this.rq;
        if (num != null) {
            return num.intValue();
        }
        return com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_privacy", "tt_gdpr", -1);
    }

    public void mml(final int i) {
        if (i == 1) {
            i = 0;
        } else if (i == 0) {
            i = 1;
        }
        if (i == 0 || i == 1 || i == -1) {
            final Integer num = this.rq;
            if (num == null || num.intValue() != i) {
                this.rq = Integer.valueOf(i);
                if (!com.bytedance.sdk.openadsdk.utils.fco.mo()) {
                    qdl(num, i);
                } else {
                    rdp.ud().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tvp.2
                        @Override // java.lang.Runnable
                        public void run() {
                            tvp.this.qdl(num, i);
                        }
                    });
                }
            }
        }
    }

    public void mzz(int i) {
        this.fs = i;
    }

    public int rq() {
        return this.fs;
    }

    public boolean fs() {
        int i = this.fs;
        return i < -1 || i > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(Integer num, int i) {
        if (num != null) {
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_privacy", "tt_gdpr", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.settings.rq.lnr().qdl(4, true);
        } else if (com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_privacy", "tt_gdpr", -1) != i) {
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_privacy", "tt_gdpr", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.settings.rq.lnr().qdl(4, true);
        }
    }

    public String exu() {
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            return com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("sp_global_file", "extra_data", null);
        }
        return this.jpc;
    }

    public void lnr(final String str) {
        rq(str);
        if (com.bytedance.sdk.openadsdk.utils.fco.mo()) {
            rdp.ud().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tvp.3
                @Override // java.lang.Runnable
                public void run() {
                    tvp.this.tvp(str);
                }
            });
        } else {
            tvp(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tvp(String str) {
        if (!TextUtils.isEmpty(this.jpc)) {
            try {
                HashMap map = new HashMap();
                JSONArray jSONArray = new JSONArray(this.jpc);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("name");
                        if (!TextUtils.isEmpty(strOptString)) {
                            map.put(strOptString, jSONObjectOptJSONObject);
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject2 != null) {
                        String strOptString2 = jSONObjectOptJSONObject2.optString("name");
                        String strOptString3 = jSONObjectOptJSONObject2.optString("value");
                        if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                            map.put(strOptString2, jSONObjectOptJSONObject2);
                        }
                    }
                }
                Collection collectionValues = map.values();
                JSONArray jSONArray3 = new JSONArray();
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    jSONArray3.put((JSONObject) it.next());
                }
                this.jpc = jSONArray3.toString();
            } catch (Throwable th) {
                th.getMessage();
            }
        } else {
            this.jpc = str;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_file", "extra_data", this.jpc);
        }
    }

    public void mo(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_file", "title_bar_theme", Integer.valueOf(i));
        }
        this.tvp = i;
    }

    private static void to(String str) {
        exu exuVar;
        if (TextUtils.isEmpty(str) && (exuVar = qdl) != null) {
            exuVar.fail(4000, "appid cannot be empty");
        }
        com.bytedance.sdk.component.utils.aaj.lnr("TTAD.GlobalInfo", "appid cannot be empty");
    }

    private static void rq(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 1000) {
            return;
        }
        exu exuVar = qdl;
        if (exuVar != null) {
            exuVar.fail(4000, "Data is very long, the longest is 1000");
        }
        com.bytedance.sdk.component.utils.aaj.lnr("TTAD.GlobalInfo", "Data is very long, the longest is 1000");
    }

    public com.bytedance.sdk.openadsdk.core.exu.lnr.lnr rdp() {
        if (this.yt == null) {
            this.yt = new com.bytedance.sdk.openadsdk.core.exu.lnr.lnr(10, 8);
        }
        return this.yt;
    }

    public Bitmap jtx() {
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            return com.bytedance.sdk.component.utils.mml.qdl(com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("sp_global_file", "pause_icon", null));
        }
        return this.to;
    }

    public boolean yt() {
        return ud.contains(this.mml);
    }

    public boolean jl() {
        return "5001121".contains(this.mml);
    }

    public boolean exc() {
        return "com.union_test.internationad".equals(com.bytedance.sdk.openadsdk.utils.gy.mo());
    }

    public String aaj() {
        if (!TextUtils.isEmpty(this.jtx)) {
            return this.jtx;
        }
        String strQdl = com.bytedance.sdk.openadsdk.utils.fs.qdl();
        this.jtx = strQdl;
        if (!TextUtils.isEmpty(strQdl)) {
            return this.jtx;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.utils.fs.qdl(strValueOf);
        this.jtx = strValueOf;
        return strValueOf;
    }

    private static JSONObject fs(String str) {
        String strUd = com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("sp_global_file", str, null);
        if (TextUtils.isEmpty(strUd)) {
            return null;
        }
        try {
            return new JSONObject(strUd);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.GlobalInfo", e.getMessage());
            return null;
        }
    }

    public static void qdl(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put("time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_file", str, jSONObject.toString());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.GlobalInfo", e.getMessage());
        }
    }

    public static String qdl(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectFs = fs(str);
            if (jSONObjectFs == null) {
                return null;
            }
            if (System.currentTimeMillis() - jSONObjectFs.getLong("time") <= j) {
                return jSONObjectFs.getString("value");
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.GlobalInfo", e.getMessage());
        }
        return null;
    }

    public static Pair<String, Long> mml(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectFs = fs(str);
            if (jSONObjectFs == null) {
                return null;
            }
            return new Pair<>(jSONObjectFs.getString("value"), Long.valueOf(jSONObjectFs.getLong("time")));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.GlobalInfo", e.getMessage());
            return null;
        }
    }

    public wd.qdl mzz(String str) {
        try {
            if (this.jl == null || str == null) {
                return null;
            }
            return this.jl.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void qdl(String str, wd.qdl qdlVar) {
        try {
            if (TextUtils.isEmpty(str) || qdlVar == null) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                com.bytedance.sdk.openadsdk.lnr.to.qdl(6, str, qdlVar);
                return;
            }
            if (this.jl == null) {
                synchronized (tvp.class) {
                    if (this.jl == null) {
                        this.jl = new ConcurrentHashMap<>();
                    }
                }
            }
            if (this.jl != null) {
                this.jl.put(str, qdlVar);
            }
        } catch (Throwable unused) {
        }
    }

    public void mo(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                com.bytedance.sdk.openadsdk.lnr.to.qdl(6, str);
            } else if (this.jl != null) {
                this.jl.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void jyq() {
        try {
            if (this.jl == null || this.jl.size() != 0) {
                return;
            }
            this.jl = null;
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void lnr(boolean z) {
        this.lnr = z;
    }

    public static boolean oth() {
        return exu;
    }

    public static void ljh() {
        if (Build.VERSION.SDK_INT == 26 && "MI 6".equals(Build.MODEL)) {
            exu = true;
        }
    }

    public static boolean wd(String str) {
        return (TextUtils.isEmpty(str) || !com.bytedance.sdk.openadsdk.utils.xmv.qdl || str.contains("sp_full_screen_video") || str.contains("sp_reward_video") || str.contains("tt_openad") || str.contains("pag_sp_bad_par")) ? false : true;
    }

    public void jpc(String str) {
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("sp_global_file", "adx_id", str);
        }
        this.rdp = str;
    }

    public String bch() {
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            return com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("sp_global_file", "adx_id", "");
        }
        return this.rdp;
    }
}
