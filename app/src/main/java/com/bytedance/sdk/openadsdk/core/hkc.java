package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.koa;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.lnr.lnr;
import com.bytedance.sdk.openadsdk.core.model.jtx;
import com.bytedance.sdk.openadsdk.core.oth;
import com.bytedance.sdk.openadsdk.mml.qdl;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import io.ktor.client.utils.CacheControl;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class hkc implements com.bytedance.sdk.component.adexpress.mzz.ud, koa.qdl, com.bytedance.sdk.openadsdk.to.ud {
    private static final Map<String, Boolean> jpc;
    private com.bytedance.sdk.openadsdk.core.tvp.bjy aaj;
    private com.bytedance.sdk.openadsdk.fs.wd ag;
    private com.bytedance.sdk.openadsdk.core.widget.qdl.qdl ax;
    private com.bytedance.sdk.openadsdk.fs.mzz bch;
    private int bjy;
    private com.bytedance.sdk.openadsdk.fs.lnr bqt;
    private Context cx;
    private com.bytedance.sdk.component.adexpress.ud.rq exc;
    private int exu;
    private com.bytedance.sdk.openadsdk.fs.ud fco;
    private String fs;
    private qdl gt;
    private com.bytedance.sdk.openadsdk.mml.mml.mzz hkc;
    private com.bytedance.sdk.component.qdl.bjy hzv;
    private lnr irn;
    private JSONObject jl;
    private JSONObject jyq;
    private com.bytedance.sdk.openadsdk.fs.to koa;
    private com.bytedance.sdk.openadsdk.fs.qdl ljh;
    private WeakReference<com.bytedance.sdk.component.tvp.mo> mml;
    private String mo;
    private String mrf;
    private boolean om;
    private com.bytedance.sdk.openadsdk.to.mml oth;
    protected Map<String, Object> qdl;
    private HashMap<String, to> rc;
    private String rdp;
    private WeakReference<View> rq;
    private String to;
    private com.bytedance.sdk.openadsdk.to.lnr tvp;
    private JSONObject uw;
    private xmv wak;
    private boolean wc;
    private com.bytedance.sdk.openadsdk.core.widget.mzz wd;
    private com.bytedance.sdk.openadsdk.core.lnr.mml xmv;
    private com.bytedance.sdk.openadsdk.core.exu.mml.ud yh;
    private com.bytedance.sdk.openadsdk.core.model.ljh yt;
    private boolean jtx = true;
    private boolean vu = true;
    private boolean kdv = false;
    private boolean ekw = false;
    boolean ud = false;
    boolean lnr = false;
    private boolean gy = false;
    private final com.bytedance.sdk.component.utils.koa mzz = new com.bytedance.sdk.component.utils.koa(Looper.getMainLooper(), this);

    public interface qdl {
        void qdl();
    }

    public static class ud {
        public String lnr;
        public JSONObject mml;
        public int mzz;
        public String qdl;
        public String ud;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        jpc = concurrentHashMap;
        concurrentHashMap.put("log_event", Boolean.TRUE);
        concurrentHashMap.put(CacheControl.PRIVATE, Boolean.TRUE);
        concurrentHashMap.put("dispatch_message", Boolean.TRUE);
        concurrentHashMap.put("custom_event", Boolean.TRUE);
        concurrentHashMap.put("log_event_v3", Boolean.TRUE);
    }

    public hkc qdl(com.bytedance.sdk.openadsdk.core.widget.qdl.qdl qdlVar) {
        this.ax = qdlVar;
        return this;
    }

    public hkc(Context context) {
        this.cx = context;
    }

    public hkc ud(String str) {
        this.mo = str;
        return this;
    }

    public hkc qdl(com.bytedance.sdk.openadsdk.core.widget.mzz mzzVar) {
        this.wd = mzzVar;
        return this;
    }

    public com.bytedance.sdk.openadsdk.fs.ud qdl() {
        return this.fco;
    }

    public void qdl(com.bytedance.sdk.openadsdk.fs.ud udVar) {
        this.fco = udVar;
    }

    public hkc qdl(com.bytedance.sdk.component.tvp.mo moVar) {
        WebView webView;
        if (moVar == null || (webView = moVar.getWebView()) == null) {
            return this;
        }
        try {
            this.hzv = com.bytedance.sdk.component.qdl.bjy.qdl(webView).qdl(new com.bytedance.sdk.openadsdk.rq.qdl()).qdl("ToutiaoJSBridge").qdl(new com.bytedance.sdk.component.qdl.to() { // from class: com.bytedance.sdk.openadsdk.core.hkc.1
                @Override // com.bytedance.sdk.component.qdl.to
                public <T> T qdl(String str, Type type) {
                    return null;
                }

                @Override // com.bytedance.sdk.component.qdl.to
                public <T> String qdl(T t) {
                    return null;
                }
            }).qdl(tvp.ud().yt()).ud(true).qdl();
            if (com.bytedance.sdk.openadsdk.jyq.qdl.wd()) {
                com.bytedance.sdk.openadsdk.rq.qdl.jpc.qdl(this.hzv, this);
                com.bytedance.sdk.openadsdk.rq.qdl.to.qdl(this.hzv, this);
                com.bytedance.sdk.openadsdk.rq.qdl.aaj.qdl(this.hzv, moVar, this, this.yt);
            } else {
                com.bytedance.sdk.openadsdk.rq.qdl.wd.qdl(this.hzv, this);
                com.bytedance.sdk.openadsdk.rq.qdl.tvp.qdl(this.hzv, this);
                com.bytedance.sdk.openadsdk.rq.qdl.exc.qdl(this.hzv, moVar, this, this.yt);
            }
            com.bytedance.sdk.openadsdk.rq.qdl.qdl.qdl(this.hzv, this);
            com.bytedance.sdk.openadsdk.rq.qdl.ud.qdl(this.hzv, this);
            com.bytedance.sdk.openadsdk.rq.qdl.lnr.qdl(this.hzv, this);
            com.bytedance.sdk.openadsdk.rq.qdl.mo.qdl(this.hzv, this);
            com.bytedance.sdk.openadsdk.rq.qdl.rq.qdl(this.hzv, this);
            com.bytedance.sdk.openadsdk.rq.qdl.bjy.qdl(this.hzv, this);
            com.bytedance.sdk.openadsdk.rq.qdl.exu.qdl(this.hzv, moVar);
            com.bytedance.sdk.openadsdk.rq.qdl.mzz.qdl(this.hzv, this.jyq);
            com.bytedance.sdk.openadsdk.rq.qdl.mml.qdl(this.hzv, this);
            com.bytedance.sdk.openadsdk.rq.qdl.rdp.qdl(this.hzv, this, this.yt);
            com.bytedance.sdk.openadsdk.rq.qdl.jtx.qdl(this.hzv, this);
            com.bytedance.sdk.openadsdk.rq.qdl.yt.qdl(this.hzv, this);
            com.bytedance.sdk.openadsdk.rq.qdl.fs.qdl(this.hzv, this);
            com.bytedance.sdk.openadsdk.rq.qdl.jl.qdl(this.hzv, this.yt);
        } catch (Exception unused) {
        }
        return this;
    }

    public com.bytedance.sdk.component.qdl.bjy ud() {
        return this.hzv;
    }

    private WebView aaj() {
        com.bytedance.sdk.component.tvp.mo moVar;
        WeakReference<com.bytedance.sdk.component.tvp.mo> weakReference = this.mml;
        if (weakReference == null || (moVar = weakReference.get()) == null) {
            return null;
        }
        return moVar.getWebView();
    }

    public hkc ud(com.bytedance.sdk.component.tvp.mo moVar) {
        this.mml = new WeakReference<>(moVar);
        return this;
    }

    public hkc qdl(com.bytedance.sdk.openadsdk.mml.mml.mzz mzzVar) {
        this.hkc = mzzVar;
        return this;
    }

    public hkc qdl(boolean z) {
        this.ekw = z;
        return this;
    }

    public hkc lnr(String str) {
        this.to = str;
        return this;
    }

    public hkc qdl(View view) {
        this.rq = new WeakReference<>(view);
        return this;
    }

    private JSONObject jyq() {
        try {
            View view = this.rq.get();
            com.bytedance.sdk.component.tvp.mo moVar = this.mml.get();
            if (view != null && moVar != null) {
                int[] iArrUd = ax.ud(view);
                int[] iArrUd2 = ax.ud((View) moVar);
                if (iArrUd != null && iArrUd2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", ax.lnr(yt.qdl(), iArrUd[0] - iArrUd2[0]));
                    jSONObject.put("y", ax.lnr(yt.qdl(), iArrUd[1] - iArrUd2[1]));
                    jSONObject.put("w", ax.lnr(yt.qdl(), view.getWidth()));
                    jSONObject.put("h", ax.lnr(yt.qdl(), view.getHeight()));
                    jSONObject.put("isExist", true);
                    return jSONObject;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public hkc qdl(int i) {
        this.bjy = i;
        return this;
    }

    public void lnr() {
        com.bytedance.sdk.component.qdl.bjy bjyVar = this.hzv;
        if (bjyVar == null) {
            return;
        }
        bjyVar.qdl();
        this.hzv = null;
    }

    public hkc qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        this.yt = ljhVar;
        if (ljhVar != null) {
            this.jl = ljhVar.xh();
        }
        return this;
    }

    public hkc qdl(com.bytedance.sdk.openadsdk.fs.lnr lnrVar) {
        this.bqt = lnrVar;
        return this;
    }

    public hkc qdl(com.bytedance.sdk.openadsdk.fs.to toVar) {
        this.koa = toVar;
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.model.ljh mml() {
        return this.yt;
    }

    public boolean mzz() {
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.yt;
        return ljhVar != null && ljhVar.nz();
    }

    public hkc mml(String str) {
        this.fs = str;
        return this;
    }

    public hkc ud(int i) {
        this.exu = i;
        return this;
    }

    public hkc mzz(String str) {
        this.rdp = str;
        return this;
    }

    private static List<String> oth() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    public hkc qdl(Map<String, Object> map) {
        this.qdl = map;
        return this;
    }

    public hkc qdl(com.bytedance.sdk.component.adexpress.ud.rq rqVar) {
        this.exc = rqVar;
        return this;
    }

    public hkc qdl(com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar) {
        this.aaj = bjyVar;
        return this;
    }

    public hkc qdl(JSONObject jSONObject) {
        this.jyq = jSONObject;
        return this;
    }

    public hkc qdl(com.bytedance.sdk.openadsdk.fs.qdl qdlVar) {
        this.ljh = qdlVar;
        return this;
    }

    public hkc qdl(com.bytedance.sdk.openadsdk.fs.mzz mzzVar) {
        this.bch = mzzVar;
        return this;
    }

    public hkc qdl(com.bytedance.sdk.openadsdk.fs.wd wdVar) {
        this.ag = wdVar;
        return this;
    }

    public boolean mo() {
        return this.ud;
    }

    public static void ud(JSONObject jSONObject) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = oth().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.common.ud.qdl());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.common.ud.mzz());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.common.ud.ud());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.common.ud.lnr());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.common.ud.mml());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.common.ud.mo());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.common.ud.qdl(yt.qdl()));
        if (DeviceUtils.ud(yt.qdl())) {
            jSONObject.put("device_platform", "Android_Pad");
        } else {
            jSONObject.put("device_platform", "Android");
        }
        jSONObject.put("device_type", Build.VERSION.RELEASE);
    }

    private void exu(JSONObject jSONObject) throws Exception {
        qdl(jSONObject, this.yt);
    }

    public static void qdl(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) throws Exception {
        String strYre = ljhVar.yre();
        if (!TextUtils.isEmpty(strYre)) {
            jSONObject.put("cid", strYre);
        }
        String strIr = ljhVar.ir();
        if (!TextUtils.isEmpty(strIr)) {
            jSONObject.put("log_extra", strIr);
        }
        String strHtl = ljhVar.htl();
        if (!TextUtils.isEmpty(strHtl)) {
            jSONObject.put("download_url", strHtl);
        }
        jSONObject.put("dc", TextUtils.isEmpty(yt.mml().gt()) ? yt.mml().gt() : "TX");
        jSONObject.put("language", fs.ud());
        jSONObject.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.rq.lnr().lq());
    }

    private void rdp(JSONObject jSONObject) throws Exception {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.vu.to(this.yt))) {
            return;
        }
        jSONObject.put("playable_style", com.bytedance.sdk.openadsdk.core.model.vu.to(this.yt));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03a8 A[PHI: r4
  0x03a8: PHI (r4v19 org.json.JSONObject) = (r4v14 org.json.JSONObject), (r4v20 org.json.JSONObject) binds: [B:225:0x03a6, B:207:0x035b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject qdl(com.bytedance.sdk.openadsdk.core.hkc.ud r23, int r24) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.hkc.qdl(com.bytedance.sdk.openadsdk.core.hkc$ud, int):org.json.JSONObject");
    }

    private void qdl(JSONObject jSONObject, boolean z, String str) {
        com.bytedance.sdk.openadsdk.core.widget.mzz mzzVar;
        if (z) {
            try {
                String strOptString = jSONObject.optString("ad_extra_data");
                if (TextUtils.isEmpty(strOptString) || new JSONObject(strOptString).optInt("agg_request_type", -1) != 1 || !"click".equals(str) || (mzzVar = this.wd) == null) {
                    return;
                }
                mzzVar.qdl();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.qdl("TTAD.AndroidObject", "callAggClickListener faile", th);
            }
        }
    }

    private boolean qdl(JSONObject jSONObject, JSONObject jSONObject2) {
        String strOptString;
        int iOptInt;
        String strOptString2;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("landingStyle");
            strOptString = jSONObject.optString("url");
            strOptString2 = jSONObject.optString("fallback_url");
        } else {
            strOptString = null;
            iOptInt = -1;
            strOptString2 = null;
        }
        boolean z = false;
        if (iOptInt != 1) {
            if (iOptInt == 2) {
                try {
                    if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2)) {
                        jSONObject2.put("empty_url", 1);
                    } else if (!com.bytedance.sdk.component.utils.jl.qdl(strOptString2)) {
                        jSONObject2.put("invalid_url", 1);
                    }
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.aaj.qdl("TTAD.AndroidObject", "handleUrl, EX2->: ", e);
                }
            }
            return z;
        }
        if (!com.bytedance.sdk.component.utils.jl.qdl(strOptString)) {
            try {
                jSONObject2.put("invalid_url", 1);
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.aaj.qdl("TTAD.AndroidObject", "handleUrl, EX1->: ", e2);
            }
            return z;
        }
        z = true;
        return z;
    }

    public void wd() {
        com.bytedance.sdk.openadsdk.fs.lnr lnrVar;
        if (this.om && (lnrVar = this.bqt) != null) {
            lnrVar.qdl();
            return;
        }
        Context context = this.cx;
        if ((context instanceof Activity) && com.bytedance.sdk.openadsdk.utils.oth.qdl((Activity) context)) {
            ((Activity) this.cx).finish();
        }
    }

    public void lnr(JSONObject jSONObject) {
        jl.qdl(ljh(), this.cx instanceof Activity, jSONObject, this.yt, this.mrf, this.exu, aaj(), this.wd);
    }

    private Context ljh() {
        WeakReference<com.bytedance.sdk.component.tvp.mo> weakReference = this.mml;
        Activity activityQdl = (weakReference == null || weakReference.get() == null) ? null : com.bytedance.sdk.component.utils.ud.qdl(this.mml.get());
        return activityQdl == null ? this.cx : activityQdl;
    }

    private void bjy(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.mml.mml.mzz mzzVar;
        if (jSONObject == null || (mzzVar = this.hkc) == null) {
            return;
        }
        mzzVar.ud(jSONObject);
    }

    private void qdl(String str, boolean z) {
        if (this.hkc == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.hkc.qdl(str);
        } else {
            this.hkc.ud(str);
        }
    }

    private void bch() {
        com.bytedance.sdk.openadsdk.fs.to toVar = this.koa;
        if (toVar == null) {
            return;
        }
        toVar.qdl();
    }

    private void uw() {
        com.bytedance.sdk.openadsdk.fs.to toVar = this.koa;
        if (toVar == null) {
            return;
        }
        toVar.ud();
    }

    private void jtx(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.fs.lnr lnrVar = this.bqt;
        if (lnrVar == null || jSONObject == null) {
            return;
        }
        lnrVar.qdl(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            exu(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            ud(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public String getTemplateInfo() {
        qdl("getTemplateInfo", true);
        try {
            JSONObject jSONObject = this.jyq;
            if (jSONObject != null) {
                jSONObject.put("setting", koa());
                com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.yt;
                if (ljhVar != null && ljhVar.bow() != null) {
                    this.jyq.put("dynamic_configs", this.yt.bow());
                }
                com.bytedance.sdk.openadsdk.core.model.ljh ljhVar2 = this.yt;
                if (ljhVar2 != null) {
                    this.jyq.put(ShareConstants.MEDIA_EXTENSION, ljhVar2.os());
                }
            }
            qdl("getTemplateInfo", false);
            return this.jyq.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            exc(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            lnr lnrVar = this.irn;
            if (lnrVar != null) {
                com.bytedance.sdk.openadsdk.utils.fco.ud(lnrVar);
            }
            lnr lnrVar2 = new lnr(this.aaj, jSONObject);
            this.irn = lnrVar2;
            com.bytedance.sdk.openadsdk.utils.fco.qdl(lnrVar2);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.AndroidObject", "");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            jyq(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.openadsdk.utils.fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hkc.4
                @Override // java.lang.Runnable
                public void run() {
                    hkc.this.yt(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.openadsdk.utils.fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hkc.5
                @Override // java.lang.Runnable
                public void run() {
                    hkc.this.mzz(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.utils.fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hkc.6
            @Override // java.lang.Runnable
            public void run() {
                hkc.this.xmv();
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        jl(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public void initRenderFinish() {
        com.bytedance.sdk.openadsdk.utils.fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hkc.7
            @Override // java.lang.Runnable
            public void run() {
                if (hkc.this.ax != null) {
                    hkc.this.ax.qdl();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    public void qdl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("time");
            String strOptString = jSONObject.optString("flag");
            com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar = this.aaj;
            if (bjyVar != null) {
                bjyVar.qdl(iOptInt, strOptString);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.AndroidObject", "requestPauseVideo json exception");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.jyq.toString();
        }
        try {
            JSONObject jSONObjectQdl = com.bytedance.sdk.openadsdk.core.tvp.qdl.ud.qdl(this.jyq, new JSONObject(str));
            if (jSONObjectQdl == null) {
                return this.jyq.toString();
            }
            return jSONObjectQdl.toString();
        } catch (Exception unused) {
            return this.jyq.toString();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.mzz.ud
    @JavascriptInterface
    public void videoFrameChanged(String str) {
        if (this.ag == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.component.adexpress.ud.rdp rdpVar = new com.bytedance.sdk.component.adexpress.ud.rdp();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo");
            if (jSONObjectOptJSONObject != null) {
                double dOptDouble = jSONObjectOptJSONObject.optDouble("x");
                double dOptDouble2 = jSONObjectOptJSONObject.optDouble("y");
                double dOptDouble3 = jSONObjectOptJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                double dOptDouble4 = jSONObjectOptJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                if (aaj(jSONObjectOptJSONObject)) {
                    rdpVar.qdl((float) jSONObjectOptJSONObject.optDouble("borderRadiusTopLeft"));
                    rdpVar.ud((float) jSONObjectOptJSONObject.optDouble("borderRadiusTopRight"));
                    rdpVar.lnr((float) jSONObjectOptJSONObject.optDouble("borderRadiusBottomLeft"));
                    rdpVar.mml((float) jSONObjectOptJSONObject.optDouble("borderRadiusBottomRight"));
                }
                rdpVar.lnr(dOptDouble);
                rdpVar.mml(dOptDouble2);
                rdpVar.mzz(dOptDouble3);
                rdpVar.mo(dOptDouble4);
            }
            com.bytedance.sdk.openadsdk.fs.wd wdVar = this.ag;
            if (wdVar != null) {
                wdVar.qdl(rdpVar);
            }
        } catch (Throwable unused) {
        }
    }

    public void mml(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("zoom_type", 1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo");
        com.bytedance.sdk.component.adexpress.ud.rdp rdpVar = new com.bytedance.sdk.component.adexpress.ud.rdp();
        if (jSONObjectOptJSONObject != null) {
            double dOptDouble = jSONObjectOptJSONObject.optDouble("x");
            double dOptDouble2 = jSONObjectOptJSONObject.optDouble("y");
            double dOptDouble3 = jSONObjectOptJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            double dOptDouble4 = jSONObjectOptJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            rdpVar.lnr(dOptDouble);
            rdpVar.mml(dOptDouble2);
            rdpVar.mzz(dOptDouble3);
            rdpVar.mo(dOptDouble4);
        }
        com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar = this.aaj;
        if (bjyVar != null) {
            bjyVar.qdl(iOptInt, rdpVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xmv() {
        com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar = this.aaj;
        if (bjyVar != null) {
            bjyVar.qdl();
        }
    }

    private void bqt() {
        if (this.cx == null || TextUtils.isEmpty(yt.mml().cx())) {
            return;
        }
        TTWebsiteActivity.qdl(this.cx, this.yt, this.mrf);
    }

    public void jpc() {
        com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar = this.aaj;
        if (bjyVar != null) {
            bjyVar.ud();
        }
    }

    public void mo(String str) {
        this.mrf = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar, JSONObject jSONObject) {
        if (bjyVar == null || jSONObject == null) {
            return;
        }
        try {
            bjyVar.qdl(jSONObject.optBoolean("mute", false), jSONObject.has("mute") ^ true ? "jsb_def" : "jsb_web");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(JSONObject jSONObject) {
        if (this.aaj == null || jSONObject == null) {
            return;
        }
        try {
            this.aaj.qdl(jSONObject.optInt("stateType", -1));
        } catch (Exception unused) {
        }
    }

    private boolean jl(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar = this.aaj;
        if (bjyVar != null && jSONObject != null) {
            double dLnr = bjyVar.lnr();
            double dMml = this.aaj.mml();
            int iMzz = this.aaj.mzz();
            com.bytedance.sdk.component.utils.aaj.qdl("TTAD.TopLayoutHelper", "current:", Double.valueOf(dLnr), "state", Integer.valueOf(iMzz), "countdownTime", Double.valueOf(dMml));
            try {
                jSONObject.put("currentTime", dLnr / 1000.0d);
                if (dMml > 0.0d) {
                    jSONObject.put("countDownTime", dMml / 1000.0d);
                }
                jSONObject.put("state", iMzz);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private JSONObject koa() {
        return ud(this.yt);
    }

    public static JSONObject ud(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        int iFz;
        boolean zYt;
        JSONObject jSONObject = new JSONObject();
        if (yt.mml() == null) {
            return jSONObject;
        }
        if (ljhVar != null) {
            try {
                iFz = ljhVar.fz();
            } catch (Exception unused) {
            }
        } else {
            iFz = 0;
        }
        int iVz = ljhVar != null ? ljhVar.vz() : 0;
        int iQg = ljhVar != null ? ljhVar.qg() : 0;
        int iWs = ljhVar != null ? ljhVar.ws() : 0;
        boolean zMo = yt.mml().mo(String.valueOf(iFz));
        boolean z = yt.mml().exu(String.valueOf(iFz)) == 1;
        if (iVz == 7 || iVz == 8) {
            zYt = yt.mml().yt(String.valueOf(iFz));
        } else {
            zYt = yt.mml().lnr(String.valueOf(iFz));
        }
        jSONObject.put("voice_control", zYt);
        jSONObject.put("rv_skip_time", iQg);
        jSONObject.put("fv_skip_show", zMo);
        jSONObject.put("iv_skip_time", iWs);
        jSONObject.put("show_dislike", ljhVar != null && ljhVar.tvf());
        jSONObject.put("video_adaptation", ljhVar != null ? ljhVar.fzn() : 0);
        if (ljhVar != null && ljhVar.bow() != null) {
            jSONObject.put("dynamic_configs", ljhVar.bow());
        }
        if (com.bytedance.sdk.openadsdk.core.model.aaj.lnr(ljhVar)) {
            jSONObject.put("skip_change_to_close", true);
        } else {
            jSONObject.put("skip_change_to_close", z);
        }
        jSONObject.put("bar_render_platform", ljhVar.ax() ? 1 : 0);
        return jSONObject;
    }

    public void mzz(JSONObject jSONObject) {
        String str;
        double d;
        double d2;
        double dOptDouble;
        double d3;
        double d4;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.aaj.qdl("TTAD.AndroidObject", "trigger Class1 method1");
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("clickAreaType");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("clickInfo");
            double d5 = 0.0d;
            if (jSONObjectOptJSONObject2 != null) {
                double dOptDouble2 = jSONObjectOptJSONObject2.optDouble("down_x", 0.0d);
                dOptDouble = jSONObjectOptJSONObject2.optDouble("down_y", 0.0d);
                double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("up_x", 0.0d);
                double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("up_y", 0.0d);
                double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("down_time", 0.0d);
                double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("up_time", 0.0d);
                jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("rectInfo");
                d4 = dOptDouble6;
                d5 = dOptDouble2;
                d2 = dOptDouble3;
                d3 = dOptDouble5;
                str = strOptString;
                d = dOptDouble4;
            } else {
                str = strOptString;
                d = 0.0d;
                d2 = 0.0d;
                dOptDouble = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
                jSONObjectOptJSONObject = null;
            }
            com.bytedance.sdk.openadsdk.core.model.jtx jtxVarQdl = new jtx.qdl().mml((float) d5).lnr((float) dOptDouble).ud((float) d2).qdl((float) d).ud((long) d3).qdl((long) d4).qdl(strOptString2).qdl((SparseArray<lnr.qdl>) null).qdl(true).ud(iOptInt).qdl(jSONObjectOptJSONObject).qdl(jSONObject.optInt("clickAreaCategory", -1)).ud(jSONObjectOptJSONObject2).qdl();
            com.bytedance.sdk.component.adexpress.ud.rq rqVar = this.exc;
            if (rqVar != null) {
                rqVar.qdl(null, iOptInt, jtxVarQdl);
            }
            qdl(str, iOptInt, jtxVarQdl);
        } catch (Exception unused) {
            com.bytedance.sdk.component.adexpress.ud.rq rqVar2 = this.exc;
            if (rqVar2 != null) {
                rqVar2.qdl(null, -1, null);
            }
        }
    }

    private void exc(JSONObject jSONObject) {
        int i;
        double dOptDouble;
        double dOptDouble2;
        boolean z;
        double d;
        String strOptString;
        int iOptInt;
        hkc hkcVar = this;
        if (hkcVar.exc == null || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.mml.mml.mzz mzzVar = hkcVar.hkc;
        if (mzzVar != null) {
            mzzVar.jtx();
        }
        com.bytedance.sdk.component.adexpress.ud.rdp rdpVar = new com.bytedance.sdk.component.adexpress.ud.rdp();
        rdpVar.qdl(1);
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isRenderSuc");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AdSize");
            if (jSONObjectOptJSONObject != null) {
                dOptDouble = jSONObjectOptJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                dOptDouble2 = jSONObjectOptJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            } else {
                dOptDouble = 0.0d;
                dOptDouble2 = 0.0d;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("videoInfo");
            if (jSONObjectOptJSONObject2 != null) {
                try {
                    double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("x");
                    double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("y");
                    z = zOptBoolean;
                    double dOptDouble5 = jSONObjectOptJSONObject2.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                    double dOptDouble6 = jSONObjectOptJSONObject2.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                    if (hkcVar.aaj(jSONObjectOptJSONObject2)) {
                        d = dOptDouble2;
                        rdpVar.qdl((float) jSONObjectOptJSONObject2.optDouble("borderRadiusTopLeft"));
                        rdpVar.ud((float) jSONObjectOptJSONObject2.optDouble("borderRadiusTopRight"));
                        rdpVar.lnr((float) jSONObjectOptJSONObject2.optDouble("borderRadiusBottomLeft"));
                        rdpVar.mml((float) jSONObjectOptJSONObject2.optDouble("borderRadiusBottomRight"));
                    } else {
                        d = dOptDouble2;
                    }
                    rdpVar.lnr(dOptDouble3);
                    rdpVar.mml(dOptDouble4);
                    rdpVar.mzz(dOptDouble5);
                    rdpVar.mo(dOptDouble6);
                } catch (Exception unused) {
                    i = 101;
                    hkcVar = this;
                    rdpVar.ud(i);
                    rdpVar.qdl(jpc.qdl(i));
                    hkcVar.exc.qdl(rdpVar);
                }
            } else {
                z = zOptBoolean;
                d = dOptDouble2;
            }
            try {
                strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, jpc.qdl(101));
                iOptInt = jSONObject.optInt("code", 101);
            } catch (Exception unused2) {
                hkcVar = this;
                i = 101;
                rdpVar.ud(i);
                rdpVar.qdl(jpc.qdl(i));
                hkcVar.exc.qdl(rdpVar);
            }
            try {
                rdpVar.qdl(z);
                rdpVar.qdl(dOptDouble);
                rdpVar.ud(d);
                rdpVar.qdl(strOptString);
                rdpVar.ud(iOptInt);
                hkcVar = this;
                hkcVar.exc.qdl(rdpVar);
            } catch (Exception unused3) {
                hkcVar = this;
                i = 101;
                rdpVar.ud(i);
                rdpVar.qdl(jpc.qdl(i));
                hkcVar.exc.qdl(rdpVar);
            }
        } catch (Exception unused4) {
        }
    }

    private boolean aaj(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    private void jyq(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.utils.exc.qdl(uri, this);
            }
        } catch (Exception unused) {
        }
    }

    private void oth(JSONObject jSONObject) {
        if (jSONObject == null || this.oth == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                this.oth.qdl(true, jSONArrayOptJSONArray);
            } else {
                this.oth.qdl(false, null);
            }
        } catch (Exception unused) {
            this.oth.qdl(false, null);
        }
    }

    public void qdl(final ud udVar, final JSONObject jSONObject) {
        if (udVar == null) {
            return;
        }
        try {
            qdl(udVar.mml, new com.bytedance.sdk.openadsdk.fs.mml() { // from class: com.bytedance.sdk.openadsdk.core.hkc.8
                @Override // com.bytedance.sdk.openadsdk.fs.mml
                public void qdl(boolean z, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
                    if (!z) {
                        hkc.this.ud(udVar.ud, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", hkc.qdl(qdlVar));
                        hkc.this.ud(udVar.ud, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean qdl(String str, int i, com.bytedance.sdk.openadsdk.core.model.jtx jtxVar) {
        HashMap<String, to> map;
        if (TextUtils.isEmpty(str) || (map = this.rc) == null || map.get(str) == null) {
            return false;
        }
        throw null;
    }

    public void qdl(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.fs.mml mmlVar) {
        JSONObject jSONObjectOptJSONObject;
        if (mmlVar == null) {
            return;
        }
        try {
            final com.bytedance.sdk.openadsdk.fs.mml mmlVar2 = new com.bytedance.sdk.openadsdk.fs.mml() { // from class: com.bytedance.sdk.openadsdk.core.hkc.9
                @Override // com.bytedance.sdk.openadsdk.fs.mml
                public void qdl(final boolean z, final com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
                    com.bytedance.sdk.openadsdk.utils.fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hkc.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            mmlVar.qdl(z, qdlVar);
                        }
                    });
                }
            };
            if (this.yt != null && !TextUtils.isEmpty(this.fs)) {
                int iVz = this.yt.vz();
                AdSlot adSlotJi = this.yt.ji();
                com.bytedance.sdk.openadsdk.core.model.bqt bqtVar = new com.bytedance.sdk.openadsdk.core.model.bqt();
                bqtVar.mo = true;
                if (this.yt.xdk() != null || this.yt.kr() != null) {
                    bqtVar.tvp = 2;
                }
                JSONObject jSONObject2 = this.jl;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject != null && jSONObject.has("session_params") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("session_params")) != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.put(next, jSONObjectOptJSONObject.opt(next));
                    }
                }
                bqtVar.wd = jSONObject2;
                if (jSONObject != null && jSONObject.has("common_params")) {
                    if (bqtVar.jpc == null) {
                        bqtVar.jpc = new JSONObject();
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("common_params");
                    if (jSONObjectOptJSONObject2 != null) {
                        Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            bqtVar.jpc.put(next2, jSONObjectOptJSONObject2.opt(next2));
                        }
                    }
                }
                if (com.bytedance.sdk.openadsdk.utils.ud.qdl()) {
                    yt.lnr().qdl(adSlotJi, bqtVar, iVz, (aaj) new jyq() { // from class: com.bytedance.sdk.openadsdk.core.hkc.10
                        @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
                        public void qdl(int i, String str) {
                            mmlVar2.qdl(false, null);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
                        public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                            hkc.this.qdl(qdlVar, lnrVar, mmlVar2);
                        }
                    });
                    return;
                } else {
                    yt.lnr().qdl(adSlotJi, bqtVar, iVz, new oth.qdl() { // from class: com.bytedance.sdk.openadsdk.core.hkc.11
                        @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
                        public void qdl(int i, String str) {
                            mmlVar2.qdl(false, null);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
                        public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                            hkc.this.qdl(qdlVar, lnrVar, mmlVar2);
                        }
                    });
                    return;
                }
            }
            mmlVar2.qdl(false, null);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.qdl("TTAD.AndroidObject", "get ads error", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar, com.bytedance.sdk.openadsdk.fs.mml mmlVar) {
        if (qdlVar.mml() != null && !qdlVar.mml().isEmpty()) {
            com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = qdlVar.mml().get(0);
            if (ljhVar != null) {
                this.jl = ljhVar.xh();
            }
            mmlVar.qdl(true, qdlVar);
            return;
        }
        mmlVar.qdl(false, null);
        lnrVar.qdl(-3);
        lnrVar.lnr(7);
        com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
    }

    public static JSONArray qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVarMo;
        if (qdlVar == null || !qdlVar.mzz() || (ljhVarMo = qdlVar.mo()) == null || TextUtils.isEmpty(ljhVarMo.jbc())) {
            return null;
        }
        try {
            return new JSONObject(ljhVarMo.jbc()).optJSONArray("creatives");
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean vu() {
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.yt;
        if (ljhVar == null || ljhVar.xh() == null || com.bytedance.sdk.openadsdk.core.model.vu.ud(this.yt) || this.kdv || this.yt.xh().optInt("parent_type") != 2) {
            return false;
        }
        int iVz = this.yt.vz();
        if (iVz != 8 && iVz != 7) {
            return false;
        }
        this.kdv = true;
        return true;
    }

    public void ud(boolean z) {
        this.ud = z;
    }

    public boolean tvp() {
        return this.gy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            ljh(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void ljh(JSONObject jSONObject) {
        WebView webViewAaj;
        if (jSONObject == null || (webViewAaj = aaj()) == null) {
            return;
        }
        com.bytedance.sdk.component.utils.rdp.qdl(webViewAaj, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject + ")");
    }

    private void lnr(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            ljh(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void wd(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                ud udVar = new ud();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        udVar.qdl = jSONObjectOptJSONObject.optString("__msg_type", null);
                        udVar.ud = jSONObjectOptJSONObject.optString("__callback_id", null);
                        udVar.lnr = jSONObjectOptJSONObject.optString("func");
                        udVar.mml = jSONObjectOptJSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                        udVar.mzz = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(udVar.qdl) && !TextUtils.isEmpty(udVar.lnr)) {
                    Message messageObtainMessage = this.mzz.obtainMessage(11);
                    messageObtainMessage.obj = udVar;
                    this.mzz.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception unused2) {
        }
    }

    public boolean qdl(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (jpc.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void ud(final Uri uri) {
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (CacheControl.PRIVATE.equals(host) || "dispatch_message".equals(host)) {
                    tvp(uri.toString());
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.mml.lnr.qdl(new com.bytedance.sdk.component.jpc.jpc("log_event_handleUri") { // from class: com.bytedance.sdk.openadsdk.core.hkc.2
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    String strQdl;
                    JSONObject jSONObject;
                    String queryParameter = uri.getQueryParameter("category");
                    String queryParameter2 = uri.getQueryParameter(ViewHierarchyConstants.TAG_KEY);
                    hkc.this.mrf = queryParameter2;
                    String queryParameter3 = uri.getQueryParameter(Constants.ScionAnalytics.PARAM_LABEL);
                    if (hkc.this.jpc(queryParameter3)) {
                        long j2 = 0;
                        try {
                            j = Long.parseLong(uri.getQueryParameter("value"));
                        } catch (Exception unused) {
                            j = 0;
                        }
                        try {
                            j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                        } catch (Exception unused2) {
                        }
                        long j3 = j2;
                        JSONObject jSONObjectBch = null;
                        try {
                            String queryParameter4 = uri.getQueryParameter("extra");
                            if (!TextUtils.isEmpty(queryParameter4)) {
                                JSONObject jSONObject2 = new JSONObject(queryParameter4);
                                try {
                                    jSONObject2.putOpt("ua_policy", Integer.valueOf(hkc.this.bjy));
                                } catch (Throwable unused3) {
                                }
                                jSONObjectBch = jSONObject2;
                            }
                        } catch (Throwable unused4) {
                        }
                        if ("click".equals(queryParameter3)) {
                            jSONObjectBch = hkc.this.bch(jSONObjectBch);
                        }
                        if (!"landing_perf_error".equals(queryParameter3) && !"landing_perf_stats".equals(queryParameter3)) {
                            strQdl = hkc.this.qdl(queryParameter2, queryParameter3);
                            jSONObject = jSONObjectBch;
                        } else {
                            try {
                                JSONObject jSONObject3 = new JSONObject();
                                for (String str : uri.getQueryParameterNames()) {
                                    try {
                                        if ("extra".equals(str)) {
                                            jSONObject3.put("ad_extra_data", new JSONObject(uri.getQueryParameter(str)).optString("ad_extra_data"));
                                        } else {
                                            jSONObject3.put(str, uri.getQueryParameter(str));
                                        }
                                    } catch (Exception unused5) {
                                    }
                                }
                                strQdl = hkc.this.mo;
                                jSONObject = jSONObject3;
                            } catch (Exception unused6) {
                                return;
                            }
                        }
                        com.bytedance.sdk.openadsdk.mml.lnr.qdl(hkc.this.yt, queryParameter, strQdl, queryParameter3, j, j3, jSONObject, com.bytedance.sdk.openadsdk.core.model.aaj.wd(hkc.this.yt));
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jpc(String str) {
        if (!TextUtils.isEmpty(str) && "click_other".equals(str)) {
            return to();
        }
        return true;
    }

    boolean to() {
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.yt;
        return ljhVar != null && ljhVar.syy() == 1;
    }

    public void lnr(int i) {
        com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar = this.aaj;
        if (bjyVar != null) {
            bjyVar.ud(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bch(JSONObject jSONObject) {
        if (this.qdl != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString("ad_extra_data", null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                for (Map.Entry<String, Object> entry : this.qdl.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.aaj.lnr(e.toString(), new Object[0]);
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String qdl(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.core.model.aaj.wd(this.yt)) {
            if ("show".equals(str2)) {
                return com.bytedance.sdk.openadsdk.utils.gy.qdl(this.exu);
            }
            return "aggregate_page";
        }
        if (com.bytedance.sdk.openadsdk.core.model.vu.mzz(this.yt)) {
            return this.mo;
        }
        if (this.bqt != null) {
            return com.bytedance.sdk.openadsdk.utils.gy.qdl(this.exu);
        }
        return this.exc == null ? com.bytedance.sdk.openadsdk.utils.gy.ud(this.exu) : str;
    }

    private void tvp(String str) {
        int iIndexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView webViewAaj = aaj();
                    if (webViewAaj != null) {
                        com.bytedance.sdk.component.utils.rdp.qdl(webViewAaj, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (!str.startsWith("bytedance://private/setresult/") || (iIndexOf = str.indexOf(38, 30)) <= 0) {
                    return;
                }
                String strSubstring = str.substring(30, iIndexOf);
                String strSubstring2 = str.substring(iIndexOf + 1);
                if (!strSubstring.equals("SCENE_FETCHQUEUE") || strSubstring2.length() <= 0) {
                    return;
                }
                wd(strSubstring2);
            } catch (Exception unused) {
            }
        }
    }

    public void rq() {
        vu();
    }

    public void fs() {
        com.bytedance.sdk.openadsdk.to.lnr lnrVar = this.tvp;
        if (lnrVar != null) {
            lnrVar.qdl();
        }
        lnr lnrVar2 = this.irn;
        if (lnrVar2 != null) {
            com.bytedance.sdk.openadsdk.utils.fco.ud(lnrVar2);
            this.irn = null;
        }
        this.cx = null;
        this.yh = null;
    }

    @Override // com.bytedance.sdk.component.utils.koa.qdl
    public void qdl(Message message) {
        if (message != null && message.what == 11 && (message.obj instanceof ud)) {
            try {
                qdl((ud) message.obj, 1);
            } catch (Exception unused) {
            }
        }
    }

    private void rc() {
        if (this.tvp == null) {
            this.tvp = com.bytedance.sdk.openadsdk.to.qdl.qdl(this, this.yt);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.to.ud
    public void qdl(String str, JSONObject jSONObject) {
        lnr(str, jSONObject);
    }

    public void exu() {
        qdl qdlVar = this.gt;
        if (qdlVar != null) {
            qdlVar.qdl();
        }
    }

    public void lnr(boolean z) {
        this.wc = z;
    }

    public void mml(boolean z) {
        this.om = z;
    }

    public void mo(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVarQdl = com.bytedance.sdk.openadsdk.core.ud.qdl(jSONObject);
        if (ljhVarQdl != null) {
            boolean zWd = com.bytedance.sdk.openadsdk.core.model.aaj.wd(this.yt);
            qdl(ljhVarQdl, zWd ? com.bytedance.sdk.openadsdk.utils.gy.ud(this.exu) : this.mrf, !zWd);
        }
    }

    private void qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.lnr.qdl qdlVar = new com.bytedance.sdk.openadsdk.core.lnr.qdl(yt.qdl(), ljhVar, str, this.exu);
        qdlVar.qdl(com.bytedance.sdk.openadsdk.exc.qdl.qdl.wd.qdl(yt.qdl(), str));
        if (!z) {
            qdlVar.qdl(false);
        }
        qdlVar.onClick(null);
    }

    public JSONObject wd(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar = this.aaj;
        if (bjyVar != null) {
            try {
                jSONObject2.put("state", bjyVar.ud(jSONObject) ? 1 : 0);
            } catch (Throwable unused) {
            }
        }
        return jSONObject2;
    }

    public JSONObject jpc(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar = this.aaj;
        if (bjyVar != null) {
            try {
                jSONObject2.put("state", bjyVar.qdl(jSONObject) ? 1 : 0);
            } catch (Throwable unused) {
            }
        }
        return jSONObject2;
    }

    public JSONObject tvp(JSONObject jSONObject) {
        List<com.bytedance.sdk.openadsdk.core.model.ljh> listTid;
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            com.bytedance.sdk.openadsdk.core.exu.mml.ud udVar = this.yh;
            if (udVar != null && (listTid = udVar.tid()) != null) {
                for (int i = 0; i < listTid.size(); i++) {
                    jSONArray.put(lnr(listTid.get(i)));
                }
            }
            jSONObject2.put("creatives", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    private JSONObject lnr(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("is_ad_event", "1");
        jSONObject2.put("cid", ljhVar.wc());
        jSONObject2.put("req_id", ljhVar.cev());
        jSONObject2.put("ad_id", ljhVar.yre());
        jSONObject2.put("log_extra", ljhVar.ir());
        jSONObject2.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.rq.lnr().lq());
        jSONObject.put("ad_info", jSONObject2);
        jSONObject.put("endcard_creative", ljhVar.om());
        jSONObject.put("dynamic_creative", ljhVar.lme());
        jSONObject.put("title", ljhVar.gsv());
        com.bytedance.sdk.openadsdk.core.model.ljh.qdl(ljhVar, jSONObject);
        com.bytedance.sdk.openadsdk.core.model.ljh.ud(ljhVar, jSONObject);
        jSONObject.put("source", ljhVar.ca());
        jSONObject.put("button_text", ljhVar.oz());
        com.bytedance.sdk.openadsdk.core.model.exu exuVarBo = ljhVar.bo();
        if (exuVarBo != null) {
            jSONObject.put("deeplink_url", exuVarBo.qdl());
        }
        jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, ljhVar.gsp());
        jSONObject.put("has_show", ljhVar.gy() ? 1 : 0);
        jSONObject.put("has_click", ljhVar.jwd() ? 1 : 0);
        return jSONObject;
    }

    public void to(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.qdl qdlVarMml;
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt(FirebaseAnalytics.Param.INDEX);
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.yt;
        if (ljhVar == null || (qdlVarMml = ljhVar.mml()) == null) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.model.ljh> listMml = qdlVarMml.mml();
        if (iOptInt < 0 || iOptInt >= listMml.size()) {
            return;
        }
        qdl(listMml.get(iOptInt), this.mrf, false);
        com.bytedance.sdk.openadsdk.core.exu.mml.ud udVar = this.yh;
        if (udVar != null) {
            udVar.car();
        }
    }

    public void qdl(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar = this.aaj;
        if (bjyVar != null) {
            bjyVar.qdl(str, jSONObject);
            return;
        }
        com.bytedance.sdk.openadsdk.core.exu.mml.ud udVar = this.yh;
        if (udVar != null) {
            udVar.qdl(str, jSONObject);
        }
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.exu.mml.ud udVar) {
        this.yh = udVar;
    }

    public com.bytedance.sdk.openadsdk.core.exu.mml.ud rdp() {
        return this.yh;
    }

    public void qdl(xmv xmvVar) {
        this.wak = xmvVar;
    }

    public void bjy() {
        xmv xmvVar = this.wak;
        if (xmvVar != null) {
            xmvVar.k_();
        }
    }

    public void jtx() {
        xmv xmvVar = this.wak;
        if (xmvVar != null) {
            xmvVar.l_();
        }
    }

    public void rq(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("status");
        xmv xmvVar = this.wak;
        if (xmvVar != null) {
            if (iOptInt == 1) {
                xmvVar.n_();
            } else if (iOptInt == 2) {
                xmvVar.o_();
            }
        }
    }

    public JSONObject yt() {
        JSONObject jSONObject = new JSONObject();
        try {
            xmv xmvVar = this.wak;
            if (xmvVar != null) {
                jSONObject.put("leftTime", xmvVar.m_());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void jl() {
        xmv xmvVar = this.wak;
        if (xmvVar != null) {
            xmvVar.p_();
        }
    }

    public void qdl(qdl qdlVar) {
        this.gt = qdlVar;
    }

    private static class lnr implements Runnable {
        private final com.bytedance.sdk.openadsdk.core.tvp.bjy qdl;
        private final JSONObject ud;

        public lnr(com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar, JSONObject jSONObject) {
            this.qdl = bjyVar;
            this.ud = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            hkc.ud(this.qdl, this.ud);
        }
    }

    public void fs(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.mml.lnr.qdl(new com.bytedance.sdk.component.jpc.jpc("sendLogV3") { // from class: com.bytedance.sdk.openadsdk.core.hkc.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extJson");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("category") && jSONObjectOptJSONObject.has(ViewHierarchyConstants.TAG_KEY) && jSONObjectOptJSONObject.has(Constants.ScionAnalytics.PARAM_LABEL)) {
                    String strOptString = jSONObjectOptJSONObject.optString("category");
                    String strOptString2 = jSONObjectOptJSONObject.optString(ViewHierarchyConstants.TAG_KEY);
                    String strOptString3 = jSONObjectOptJSONObject.optString(Constants.ScionAnalytics.PARAM_LABEL);
                    long jOptLong = jSONObject.optLong("value");
                    long jOptLong2 = jSONObject.optLong("extValue");
                    try {
                        jSONObjectOptJSONObject.put("ua_policy", hkc.this.bjy);
                    } catch (Exception unused) {
                    }
                    new qdl.C0265qdl(System.currentTimeMillis(), hkc.this.yt).mml(strOptString).ud(strOptString2).lnr(strOptString3).mzz(String.valueOf(jOptLong)).mo(String.valueOf(jOptLong2)).qdl(jSONObjectOptJSONObject).qdl((com.bytedance.sdk.openadsdk.mml.ud.qdl) null);
                }
            }
        });
    }

    public void exc() {
        com.bytedance.sdk.openadsdk.core.exu.mml.ud udVar = this.yh;
        if (udVar != null) {
            udVar.hkc();
        }
    }
}
