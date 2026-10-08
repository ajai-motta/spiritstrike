package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannedString;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.r2;
import com.applovin.impl.s2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f7 extends n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f388a;
    private List b;
    private s2 c;
    private List d;
    private ListView e;

    class a extends s2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list) {
            super(context);
            this.e = list;
        }

        @Override // com.applovin.impl.s2
        protected r2 a() {
            return new r2.b(r2.c.SECTION_CENTERED).d("Select a network to load test ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
        }

        @Override // com.applovin.impl.s2
        protected int b() {
            return 1;
        }

        @Override // com.applovin.impl.s2
        protected List c(int i) {
            return f7.this.d;
        }

        @Override // com.applovin.impl.s2
        protected int d(int i) {
            return this.e.size();
        }

        @Override // com.applovin.impl.s2
        protected r2 e(int i) {
            return new w4("TEST MODE NETWORKS");
        }
    }

    class b implements s2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f389a;
        final /* synthetic */ com.applovin.impl.sdk.k b;

        b(List list, com.applovin.impl.sdk.k kVar) {
            this.f389a = list;
            this.b = kVar;
        }

        @Override // com.applovin.impl.s2.a
        public void a(j2 j2Var, r2 r2Var) {
            List listU = ((e3) this.f389a.get(j2Var.a())).u();
            if (listU.equals(this.b.t0().b())) {
                this.b.t0().a((List) null);
            } else {
                this.b.t0().a(listU);
            }
            f7.this.c.notifyDataSetChanged();
        }
    }

    class c extends z3 {
        final /* synthetic */ e3 p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(e3 e3Var, Context context, e3 e3Var2) {
            super(e3Var, context);
            this.p = e3Var2;
        }

        @Override // com.applovin.impl.z3, com.applovin.impl.r2
        public int d() {
            if (this.p.u().equals(f7.this.f388a.t0().b())) {
                return R.drawable.applovin_ic_check_mark_borderless;
            }
            return 0;
        }

        @Override // com.applovin.impl.z3, com.applovin.impl.r2
        public int e() {
            if (this.p.u().equals(f7.this.f388a.t0().b())) {
                return -16776961;
            }
            return super.e();
        }

        @Override // com.applovin.impl.r2
        public SpannedString k() {
            return StringUtils.createSpannedString(this.p.g(), o() ? -16777216 : -7829368, 18, 1);
        }
    }

    public f7() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.n3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f388a;
    }

    public void initialize(List<e3> list, com.applovin.impl.sdk.k kVar) {
        this.f388a = kVar;
        this.b = list;
        this.d = a(list);
        a aVar = new a(this, list);
        this.c = aVar;
        aVar.a(new b(list, kVar));
        this.c.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.n3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Test Mode Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.e = listView;
        listView.setAdapter((ListAdapter) this.c);
    }

    @Override // com.applovin.impl.n3, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.d = a(this.b);
        this.c.notifyDataSetChanged();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e3 e3Var = (e3) it.next();
            arrayList.add(new c(e3Var, this, e3Var));
        }
        return arrayList;
    }
}
