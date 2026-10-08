package com.applovin.impl;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e3 implements Comparable, AppLovinCommunicatorSubscriber {
    private final List A;
    private final List B;
    private final List C;
    private final List D;
    private final Map E;
    private final boolean F;
    private final boolean G;
    private final b7 H;
    private final boolean I;
    private final String J;
    private final Map K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f366a;
    private final a b;
    private int c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final String p;
    private final String q;
    private String r;
    private String s;
    private final String t;
    private final String u;
    private final String v;
    private final String w;
    private final int x;
    private final List y;
    private final List z;

    public enum a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f367a;

        a(String str) {
            this.f367a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f367a;
        }
    }

    public enum b {
        NOT_SUPPORTED("Not Supported", SupportMenu.CATEGORY_MASK, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", SupportMenu.CATEGORY_MASK, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", SupportMenu.CATEGORY_MASK, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f368a;
        private final int b;
        private final String c;

        b(String str, int i2, String str2) {
            this.f368a = str;
            this.b = i2;
            this.c = str2;
        }

        public String b() {
            return this.c;
        }

        public String c() {
            return this.f368a;
        }

        public int d() {
            return this.b;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:26|103|27|101|28|(3:95|29|(2:31|(4:33|(1:37)(1:36)|99|38)(0))(1:42))|(3:93|43|44)|97|55) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0205, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0206, code lost:
    
        r22.O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x020d, code lost:
    
        if (com.applovin.impl.sdk.o.a() != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x020f, code lost:
    
        r22.O().a("MediatedNetwork", "Failed to check if adapter overrides MaxNativeAdAdapter", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0218, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0254 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public e3(org.json.JSONObject r21, com.applovin.impl.sdk.k r22) {
        /*
            Method dump skipped, instruction units count: 805
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.e3.<init>(org.json.JSONObject, com.applovin.impl.sdk.k):void");
    }

    private a a() {
        a aVar = this.d ? this.e ? a.COMPLETE : this.g ? a.MISSING : a.INCOMPLETE_INTEGRATION : this.e ? a.INCOMPLETE_INTEGRATION : a.MISSING;
        if (aVar == a.MISSING) {
            return aVar;
        }
        Iterator it = this.z.iterator();
        while (it.hasNext()) {
            if (!((p4) it.next()).c()) {
                return a.INVALID_INTEGRATION;
            }
        }
        Iterator it2 = this.A.iterator();
        while (it2.hasNext()) {
            if (!((k1) it2.next()).c()) {
                return a.INVALID_INTEGRATION;
            }
        }
        return (!this.o || com.applovin.impl.sdk.k.G0()) ? F() ? a.INCOMPLETE_INTEGRATION : aVar : a.INVALID_INTEGRATION;
    }

    public boolean A() {
        return this.e;
    }

    public boolean B() {
        return this.f;
    }

    public boolean C() {
        return this.h;
    }

    public boolean D() {
        return this.I;
    }

    public boolean E() {
        return this.o;
    }

    public boolean F() {
        if (!this.n || !StringUtils.isValidString(this.s)) {
            return false;
        }
        return !o7.d(this.s).equals(o7.a(this.t, this.s.split("\\.").length));
    }

    public boolean G() {
        return this.d;
    }

    public boolean H() {
        return this.b == a.MISSING && this.k;
    }

    public boolean I() {
        return this.G;
    }

    public boolean J() {
        return this.l;
    }

    public boolean K() {
        return this.m;
    }

    public String b() {
        return this.r;
    }

    public String c() {
        return this.t;
    }

    public Map d() {
        return this.K;
    }

    public String e() {
        return this.J;
    }

    public List f() {
        return this.A;
    }

    public String g() {
        return this.q;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    public int h() {
        return this.x;
    }

    public int i() {
        return this.c;
    }

    public final String j() {
        StringBuilder sb = new StringBuilder("\n---------- ");
        sb.append(this.p);
        sb.append(" ----------\nStatus  - ");
        sb.append(this.b.b());
        sb.append("\nSDK     - ");
        String str = "UNAVAILABLE";
        sb.append((!this.d || TextUtils.isEmpty(this.s)) ? "UNAVAILABLE" : this.s);
        sb.append("\nAdapter - ");
        if (this.e && !TextUtils.isEmpty(this.t)) {
            str = this.t;
        }
        sb.append(str);
        for (p4 p4Var : n()) {
            if (!p4Var.c()) {
                sb.append("\n* MISSING ");
                sb.append(p4Var.b());
                sb.append(": ");
                sb.append(p4Var.a());
            }
        }
        for (k1 k1Var : f()) {
            if (!k1Var.c()) {
                sb.append("\n* MISSING ");
                sb.append(k1Var.b());
                sb.append(": ");
                sb.append(k1Var.a());
            }
        }
        return sb.toString();
    }

    public String k() {
        return this.u;
    }

    public List l() {
        return this.C;
    }

    public String m() {
        return this.p;
    }

    public List n() {
        return this.z;
    }

    public final com.applovin.impl.sdk.k o() {
        return this.f366a;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        String string = appLovinCommunicatorMessage.getMessageData().getString("adapter_class", "");
        if (this.r.equals(string)) {
            this.c = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
            MaxAdapter maxAdapterA = w3.a(string, this.f366a);
            if (maxAdapterA != null) {
                String strA = w3.a(maxAdapterA);
                if (this.s.equals(strA)) {
                    return;
                }
                this.s = strA;
                this.f366a.t().a(this.s, string);
            }
        }
    }

    public String p() {
        return this.s;
    }

    public a q() {
        return this.b;
    }

    public List r() {
        return this.y;
    }

    public List s() {
        return this.B;
    }

    public b7 t() {
        return this.H;
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.p + ", displayName=" + this.q + ", sdkAvailable=" + this.d + ", sdkVersion=" + this.s + ", adapterAvailable=" + this.e + ", adapterVersion=" + this.t + "}";
    }

    public List u() {
        return this.D;
    }

    public String v() {
        return this.v;
    }

    public String w() {
        return this.w;
    }

    public Map x() {
        return this.E;
    }

    public b y() {
        if (!this.i) {
            return b.NOT_SUPPORTED;
        }
        a aVar = this.b;
        return (aVar == a.COMPLETE || (aVar == a.INCOMPLETE_INTEGRATION && G() && A())) ? !this.f366a.t0().c() ? b.DISABLED : (this.j && (this.c == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || this.c == MaxAdapter.InitializationStatus.INITIALIZING.getCode())) ? b.NOT_INITIALIZED : b.READY : b.INVALID_INTEGRATION;
    }

    public boolean z() {
        return this.F;
    }

    private List a(MaxAdapter maxAdapter, boolean z) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAppOpenAdapter) {
            arrayList.add(MaxAdFormat.APP_OPEN);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            if (z) {
                arrayList.add(MaxAdFormat.MREC);
            }
        }
        if (maxAdapter instanceof MaxNativeAdAdapter) {
            arrayList.add(MaxAdFormat.NATIVE);
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        ArrayList arrayList = new ArrayList();
        if (this.r.equals("com.applovin.mediation.adapters.AppLovinMediationAdapter")) {
            p4 p4Var = new p4("com.google.android.gms.permission.AD_ID", "Please add\n<uses-permission android:name=\"com.google.android.gms.permission.AD_ID\" />\nto your AndroidManifest.xml", com.applovin.impl.sdk.k.o());
            if (p4Var.c()) {
                arrayList.add(p4Var);
            }
        }
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "permissions", new JSONObject());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                arrayList.add(new p4(next, jSONObject2.getString(next), com.applovin.impl.sdk.k.o()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject) {
        return JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "supported_regions", null), null);
    }

    private List a(JSONObject jSONObject, String str, com.applovin.impl.sdk.k kVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "dependencies", new JSONArray());
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "dependencies_v2", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length() + jSONArray2.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new k1(jSONObject2, kVar));
            }
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null);
            if (jSONObject3 != null && k1.a(str, JsonUtils.getString(jSONObject3, "min_adapter_version", null), JsonUtils.getString(jSONObject3, "max_adapter_version", null))) {
                arrayList.add(new k1(jSONObject3, kVar));
            }
        }
        return arrayList;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e3 e3Var) {
        return this.q.compareToIgnoreCase(e3Var.q);
    }
}
