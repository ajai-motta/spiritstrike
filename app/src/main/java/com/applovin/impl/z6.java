package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.internal.view.SupportMenu;
import com.applovin.impl.b7;
import com.applovin.impl.d;
import com.applovin.impl.r2;
import com.applovin.impl.s2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerCmpNetworksListActivity;
import com.applovin.mediation.MaxDebuggerTcfStringActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z6 extends n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f740a;
    private s2 b;
    private final List c = new ArrayList();
    private final List d = new ArrayList();
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private final List g = new ArrayList();

    class a extends s2 {
        a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.s2
        protected int b() {
            return e.values().length;
        }

        @Override // com.applovin.impl.s2
        protected List c(int i) {
            return i == e.IAB_TCF_PARAMETERS.ordinal() ? z6.this.c() : z6.this.a();
        }

        @Override // com.applovin.impl.s2
        protected int d(int i) {
            return i == e.IAB_TCF_PARAMETERS.ordinal() ? d.values().length : c.values().length;
        }

        @Override // com.applovin.impl.s2
        protected r2 e(int i) {
            return i == e.IAB_TCF_PARAMETERS.ordinal() ? new w4("IAB TCF Parameters") : new w4("CMP CONFIGURATION");
        }
    }

    class b implements s2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a7 f741a;
        final /* synthetic */ com.applovin.impl.sdk.k b;

        class a implements d.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f742a;
            final /* synthetic */ String b;

            a(String str, String str2) {
                this.f742a = str;
                this.b = str2;
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTcfStringActivity maxDebuggerTcfStringActivity) {
                maxDebuggerTcfStringActivity.initialize(this.f742a, this.b, b.this.b);
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.z6$b$b, reason: collision with other inner class name */
        class C0163b implements d.b {
            C0163b() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerCmpNetworksListActivity maxDebuggerCmpNetworksListActivity) {
                maxDebuggerCmpNetworksListActivity.initialize(z6.this.e, z6.this.f, z6.this.c, z6.this.d, z6.this.g, b.this.b);
            }
        }

        b(a7 a7Var, com.applovin.impl.sdk.k kVar) {
            this.f741a = a7Var;
            this.b = kVar;
        }

        @Override // com.applovin.impl.s2.a
        public void a(j2 j2Var, r2 r2Var) {
            String strA;
            String strC;
            if (j2Var.b() != e.IAB_TCF_PARAMETERS.ordinal()) {
                if (j2Var.a() == c.CONFIGURED_NETWORKS.ordinal()) {
                    com.applovin.impl.d.a(z6.this, MaxDebuggerCmpNetworksListActivity.class, this.b.e(), new C0163b());
                    return;
                } else {
                    o7.a(r2Var.c(), r2Var.b(), z6.this);
                    return;
                }
            }
            if (j2Var.a() == d.TC_STRING.ordinal()) {
                strA = a5.x.a();
                strC = this.f741a.j();
            } else {
                strA = a5.y.a();
                strC = this.f741a.c();
            }
            com.applovin.impl.d.a(z6.this, MaxDebuggerTcfStringActivity.class, this.b.e(), new a(strA, strC));
        }
    }

    private enum c {
        CMP_SDK_ID,
        CMP_SDK_VERSION,
        INSTRUCTIONS,
        CONFIGURED_NETWORKS
    }

    private enum d {
        GDPR_APPLIES,
        TC_STRING,
        AC_STRING
    }

    private enum e {
        IAB_TCF_PARAMETERS,
        CMP_CONFIGURATION
    }

    @Override // com.applovin.impl.n3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f740a;
    }

    public void initialize(List<b7> list, com.applovin.impl.sdk.k kVar) {
        this.f740a = kVar;
        a7 a7VarS0 = kVar.s0();
        a(list);
        a aVar = new a(this);
        this.b = aVar;
        aVar.a(new b(a7VarS0, kVar));
        this.b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.n3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("CMP (Consent Management Platform)");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.b);
    }

    @Override // com.applovin.impl.n3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        s2 s2Var = this.b;
        if (s2Var != null) {
            s2Var.a((s2.a) null);
        }
    }

    private void a(List list) {
        boolean zB = this.f740a.s0().b();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b7 b7Var = (b7) it.next();
            if (b7Var.f() == b7.a.TCF_VENDOR) {
                if (Boolean.TRUE.equals(b7Var.a())) {
                    a(b7Var, this.c);
                } else {
                    a(b7Var, this.e);
                }
            } else if (b7Var.f() != b7.a.ATP_NETWORK) {
                this.g.add(b7Var);
            } else if (!zB) {
                this.g.add(b7Var);
            } else if (Boolean.TRUE.equals(b7Var.a())) {
                a(b7Var, this.d);
            } else {
                a(b7Var, this.f);
            }
        }
    }

    private r2 b() {
        r2.b bVarA;
        String strA = a5.u.a();
        Integer numE = this.f740a.s0().e();
        if (StringUtils.isValidString(this.f740a.s0().d())) {
            bVarA = r2.a(r2.c.RIGHT_DETAIL);
        } else {
            r2.b bVarB = r2.a(r2.c.DETAIL).b("Unknown CMP SDK ID");
            bVarA = bVarB.a("Your integrated CMP might not be Google-certified. " + ("SharedPreferences value for key " + strA + " is " + numE + ".") + "\n\nIf you use Google AdMob or Google Ad Manager, make sure that the integrated CMP is included in the list of Google-certified CMPs at: https://support.google.com/admob/answer/13554116").a(R.drawable.applovin_ic_warning).b(m0.a(R.color.applovin_sdk_warningColor, this)).a(true);
        }
        bVarA.d(strA);
        bVarA.c(numE != null ? numE.toString() : "No value set");
        bVarA.c(numE != null ? -16777216 : SupportMenu.CATEGORY_MASK);
        return bVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List c() {
        ArrayList arrayList = new ArrayList(d.values().length);
        Integer numG = this.f740a.s0().g();
        String strJ = this.f740a.s0().j();
        String strC = this.f740a.s0().c();
        arrayList.add(a(a5.w.a(), numG));
        arrayList.add(a(a5.x.a(), strJ, !d7.b(strJ)));
        arrayList.add(a(a5.y.a(), strC, false));
        return arrayList;
    }

    private void a(b7 b7Var, List list) {
        if (b7Var.d() != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (b7Var.d().equals(((b7) it.next()).d())) {
                    return;
                }
            }
        }
        list.add(b7Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a() {
        String str;
        ArrayList arrayList = new ArrayList(c.values().length);
        int size = this.e.size() + this.f.size();
        arrayList.add(b());
        arrayList.add(a(a5.v.a(), this.f740a.s0().f()));
        arrayList.add(r2.a(r2.c.DETAIL).d("To check which networks are missing from your CMP, first make sure that you have granted consent to all networks through your CMP flow. Then add the following networks to your CMP network list.").a());
        r2.b bVarD = r2.a(r2.c.RIGHT_DETAIL).d("Configured CMP Networks");
        if (size > 0) {
            str = "Missing " + size + " network(s)";
        } else {
            str = "";
        }
        arrayList.add(bVarD.c(str).c(size > 0 ? SupportMenu.CATEGORY_MASK : -16777216).a(this).a(true).a());
        return arrayList;
    }

    private r2 a(String str, Integer num) {
        return r2.a(r2.c.RIGHT_DETAIL).d(str).c(num != null ? num.toString() : "No value set").c(num != null ? -16777216 : SupportMenu.CATEGORY_MASK).a();
    }

    private r2 a(String str, String str2, boolean z) {
        boolean zIsValidString = StringUtils.isValidString(str2);
        if (zIsValidString && str2.length() > 35) {
            str2 = str2.substring(0, 35) + "...";
        }
        r2.b bVarD = r2.a(r2.c.DETAIL).d(str);
        if (!zIsValidString) {
            str2 = "No value set";
        }
        r2.b bVarA = bVarD.c(str2).c(z ? SupportMenu.CATEGORY_MASK : -16777216).a(zIsValidString);
        if (zIsValidString) {
            bVarA.a(this);
        }
        return bVarA.a();
    }
}
