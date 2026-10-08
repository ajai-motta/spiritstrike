package com.applovin.impl;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.webkit.internal.AssetHelper;
import com.applovin.impl.d;
import com.applovin.impl.o3;
import com.applovin.impl.s2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTcfConsentStatusesListActivity;
import com.applovin.mediation.MaxDebuggerTcfInfoListActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.mediation.MaxDebuggerTestModeNetworkActivity;
import com.applovin.mediation.MaxDebuggerUnifiedFlowActivity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m3 extends n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o3 f454a;
    private DataSetObserver b;
    private FrameLayout c;
    private ListView d;
    private com.applovin.impl.a e;

    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            m3.this.a();
            m3 m3Var = m3.this;
            m3Var.b((Context) m3Var);
        }
    }

    class b implements s2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.c f456a;

        class a implements d.b {
            a() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerUnifiedFlowActivity maxDebuggerUnifiedFlowActivity) {
                maxDebuggerUnifiedFlowActivity.initialize(m3.this.f454a.t());
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.m3$b$b, reason: collision with other inner class name */
        class C0150b implements d.b {
            C0150b() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTcfInfoListActivity maxDebuggerTcfInfoListActivity) {
                maxDebuggerTcfInfoListActivity.initialize(m3.this.f454a.d(), m3.this.f454a.t());
            }
        }

        class c implements d.b {
            c() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTcfConsentStatusesListActivity maxDebuggerTcfConsentStatusesListActivity) {
                maxDebuggerTcfConsentStatusesListActivity.initialize(m3.this.f454a.d(), m3.this.f454a.t());
            }
        }

        class d implements d.b {
            d() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(m3.this.f454a.f(), false, m3.this.f454a.t());
            }
        }

        class e implements d.b {
            e() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                maxDebuggerTestLiveNetworkActivity.initialize(m3.this.f454a.k(), m3.this.f454a.w(), m3.this.f454a.t());
            }
        }

        class f implements d.b {
            f() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTestModeNetworkActivity maxDebuggerTestModeNetworkActivity) {
                maxDebuggerTestModeNetworkActivity.initialize(m3.this.f454a.v(), m3.this.f454a.t());
            }
        }

        class g implements d.b {
            g() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(m3.this.f454a.o(), true, m3.this.f454a.t());
            }
        }

        class h implements d.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ r2 f464a;

            h(r2 r2Var) {
                this.f464a = r2Var;
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                maxDebuggerDetailActivity.initialize(((z3) this.f464a).r());
            }
        }

        b(com.applovin.impl.c cVar) {
            this.f456a = cVar;
        }

        @Override // com.applovin.impl.s2.a
        public void a(j2 j2Var, r2 r2Var) {
            int iB = j2Var.b();
            if (iB == o3.e.APP_INFO.ordinal()) {
                o7.a(r2Var.c(), r2Var.b(), m3.this);
                return;
            }
            if (iB == o3.e.MAX.ordinal()) {
                if (m3.this.f454a.a(r2Var)) {
                    com.applovin.impl.d.a(m3.this, MaxDebuggerUnifiedFlowActivity.class, this.f456a, new a());
                    return;
                } else {
                    o7.a(r2Var.c(), r2Var.b(), m3.this);
                    return;
                }
            }
            if (iB == o3.e.PRIVACY.ordinal()) {
                if (j2Var.a() != o3.d.CMP.ordinal()) {
                    if (j2Var.a() == o3.d.NETWORK_CONSENT_STATUSES.ordinal()) {
                        com.applovin.impl.d.a(m3.this, MaxDebuggerTcfConsentStatusesListActivity.class, this.f456a, new c());
                        return;
                    }
                    return;
                } else if (StringUtils.isValidString(m3.this.f454a.t().s0().j())) {
                    com.applovin.impl.d.a(m3.this, MaxDebuggerTcfInfoListActivity.class, this.f456a, new C0150b());
                    return;
                } else {
                    o7.a(r2Var.c(), r2Var.b(), m3.this);
                    return;
                }
            }
            if (iB != o3.e.ADS.ordinal()) {
                if ((iB == o3.e.MICRO_SDK_PARTNER_NETWORKS.ordinal() || iB == o3.e.INCOMPLETE_NETWORKS.ordinal() || iB == o3.e.COMPLETED_NETWORKS.ordinal()) && (r2Var instanceof z3)) {
                    com.applovin.impl.d.a(m3.this, MaxDebuggerDetailActivity.class, this.f456a, new h(r2Var));
                    return;
                }
                return;
            }
            if (j2Var.a() == o3.b.AD_UNITS.ordinal()) {
                if (m3.this.f454a.f().size() > 0) {
                    com.applovin.impl.d.a(m3.this, MaxDebuggerAdUnitsListActivity.class, this.f456a, new d());
                    return;
                } else {
                    o7.a("No live ad units", "Please setup or enable your MAX ad units on https://applovin.com.", m3.this);
                    return;
                }
            }
            if (j2Var.a() == o3.b.SELECT_LIVE_NETWORKS.ordinal()) {
                if (m3.this.f454a.k().size() <= 0 && m3.this.f454a.w().size() <= 0) {
                    o7.a("Complete Integrations", "Please complete integrations in order to access this.", m3.this);
                    return;
                } else if (m3.this.f454a.t().t0().c()) {
                    o7.a("Restart Required", r2Var.b(), m3.this);
                    return;
                } else {
                    com.applovin.impl.d.a(m3.this, MaxDebuggerTestLiveNetworkActivity.class, this.f456a, new e());
                    return;
                }
            }
            if (j2Var.a() != o3.b.SELECT_TEST_MODE_NETWORKS.ordinal()) {
                if (j2Var.a() == o3.b.INITIALIZATION_AD_UNITS.ordinal()) {
                    com.applovin.impl.d.a(m3.this, MaxDebuggerAdUnitsListActivity.class, this.f456a, new g());
                }
            } else if (!m3.this.f454a.t().t0().c()) {
                m3.this.getSdk().t0().a();
                o7.a("Restart Required", r2Var.b(), m3.this);
            } else if (m3.this.f454a.v().size() > 0) {
                com.applovin.impl.d.a(m3.this, MaxDebuggerTestModeNetworkActivity.class, this.f456a, new f());
            } else {
                o7.a("Complete Integrations", "Please complete integrations in order to access this.", m3.this);
            }
        }
    }

    private void c() {
        a();
        com.applovin.impl.a aVar = new com.applovin.impl.a(this, 50, R.attr.progressBarStyleLarge);
        this.e = aVar;
        aVar.setColor(-3355444);
        this.c.addView(this.e, new FrameLayout.LayoutParams(-1, -1, 17));
        this.c.bringChildToFront(this.e);
        this.e.a();
    }

    @Override // com.applovin.impl.n3
    protected com.applovin.impl.sdk.k getSdk() {
        o3 o3Var = this.f454a;
        if (o3Var != null) {
            return o3Var.t();
        }
        return null;
    }

    @Override // com.applovin.impl.n3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(com.applovin.sdk.R.layout.mediation_debugger_list_view);
        this.c = (FrameLayout) findViewById(R.id.content);
        ListView listView = (ListView) findViewById(com.applovin.sdk.R.id.listView);
        this.d = listView;
        listView.setAdapter((ListAdapter) this.f454a);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.applovin.sdk.R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    @Override // com.applovin.impl.n3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        o3 o3Var = this.f454a;
        if (o3Var != null) {
            o3Var.unregisterDataSetObserver(this.b);
            this.f454a.a((s2.a) null);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (com.applovin.sdk.R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        b();
        return true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        o3 o3Var = this.f454a;
        if (o3Var == null || o3Var.y()) {
            return;
        }
        c();
    }

    public void setListAdapter(o3 o3Var, c cVar) {
        DataSetObserver dataSetObserver;
        o3 o3Var2 = this.f454a;
        if (o3Var2 != null && (dataSetObserver = this.b) != null) {
            o3Var2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f454a = o3Var;
        this.b = new a();
        b((Context) this);
        this.f454a.registerDataSetObserver(this.b);
        this.f454a.a(new b(cVar));
    }

    private void b() {
        o3 o3Var = this.f454a;
        if (o3Var == null) {
            return;
        }
        String strP = o3Var.p();
        if (TextUtils.isEmpty(strP)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", strP);
        intent.putExtra("android.intent.extra.TITLE", "Mediation Debugger logs");
        intent.putExtra("android.intent.extra.SUBJECT", "MAX Mediation Debugger logs");
        startActivity(Intent.createChooser(intent, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.applovin.impl.a aVar = this.e;
        if (aVar != null) {
            aVar.b();
            this.c.removeView(this.e);
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context) {
        o7.a(this.f454a.i(), this.f454a.h(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context) {
        if (!StringUtils.isValidString(this.f454a.h()) || this.f454a.x()) {
            return;
        }
        this.f454a.b(true);
        runOnUiThread(new Runnable() { // from class: com.applovin.impl.m3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(context);
            }
        });
    }
}
