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
public abstract class e7 extends n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f375a;
    private List b;
    private List c;
    private s2 d;
    private List e;
    private List f;
    private ListView g;

    class a extends s2 {
        a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.s2
        protected r2 a() {
            return new r2.b(r2.c.SECTION_CENTERED).d("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
        }

        @Override // com.applovin.impl.s2
        protected int b() {
            return c.COUNT.ordinal();
        }

        @Override // com.applovin.impl.s2
        protected List c(int i) {
            return i == c.BIDDERS.ordinal() ? e7.this.e : e7.this.f;
        }

        @Override // com.applovin.impl.s2
        protected int d(int i) {
            return i == c.BIDDERS.ordinal() ? e7.this.e.size() : e7.this.f.size();
        }

        @Override // com.applovin.impl.s2
        protected r2 e(int i) {
            return i == c.BIDDERS.ordinal() ? new w4("BIDDERS") : new w4("WATERFALL");
        }
    }

    class b extends z3 {
        final /* synthetic */ u2 p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e3 e3Var, Context context, u2 u2Var) {
            super(e3Var, context);
            this.p = u2Var;
        }

        @Override // com.applovin.impl.z3, com.applovin.impl.r2
        public int d() {
            if (e7.this.f375a.t0().b() == null || !e7.this.f375a.t0().b().equals(this.p.b())) {
                return 0;
            }
            return R.drawable.applovin_ic_check_mark_borderless;
        }

        @Override // com.applovin.impl.z3, com.applovin.impl.r2
        public int e() {
            if (e7.this.f375a.t0().b() == null || !e7.this.f375a.t0().b().equals(this.p.b())) {
                return super.e();
            }
            return -16776961;
        }

        @Override // com.applovin.impl.r2
        public SpannedString k() {
            return StringUtils.createSpannedString(this.p.a(), o() ? -16777216 : -7829368, 18, 1);
        }
    }

    enum c {
        BIDDERS,
        WATERFALL,
        COUNT
    }

    public e7() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.n3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f375a;
    }

    public void initialize(List<u2> list, List<u2> list2, final com.applovin.impl.sdk.k kVar) {
        this.f375a = kVar;
        this.b = list;
        this.c = list2;
        this.e = a(list);
        this.f = a(list2);
        a aVar = new a(this);
        this.d = aVar;
        aVar.a(new s2.a() { // from class: com.applovin.impl.e7$$ExternalSyntheticLambda0
            @Override // com.applovin.impl.s2.a
            public final void a(j2 j2Var, r2 r2Var) {
                this.f$0.a(kVar, j2Var, r2Var);
            }
        });
        this.d.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.n3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.g = listView;
        listView.setAdapter((ListAdapter) this.d);
    }

    @Override // com.applovin.impl.n3, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.e = a(this.b);
        this.f = a(this.c);
        this.d.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.k kVar, j2 j2Var, r2 r2Var) {
        List listB = a(j2Var).b();
        if (listB.equals(kVar.t0().b())) {
            kVar.t0().a((List) null);
        } else {
            kVar.t0().a(listB);
        }
        this.d.notifyDataSetChanged();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            u2 u2Var = (u2) it.next();
            arrayList.add(new b(u2Var.d(), this, u2Var));
        }
        return arrayList;
    }

    private u2 a(j2 j2Var) {
        if (j2Var.b() == c.BIDDERS.ordinal()) {
            return (u2) this.b.get(j2Var.a());
        }
        return (u2) this.c.get(j2Var.a());
    }
}
