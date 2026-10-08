package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.autofill.HintConstants;
import com.applovin.impl.d;
import com.applovin.impl.r2;
import com.applovin.impl.s2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerWaterfallSegmentsActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f550a;
    private com.applovin.impl.sdk.k b;
    private s2 c;

    class a extends s2 {
        final /* synthetic */ n e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, n nVar) {
            super(context);
            this.e = nVar;
        }

        @Override // com.applovin.impl.s2
        protected int b() {
            return this.e.g().size();
        }

        @Override // com.applovin.impl.s2
        protected List c(int i) {
            ArrayList arrayList = new ArrayList();
            o oVar = (o) this.e.g().get(i);
            arrayList.add(p.this.c(oVar.c()));
            if (oVar.b() != null) {
                arrayList.add(p.this.a("AB Test Experiment Name", oVar.b()));
            }
            l8 l8VarD = oVar.d();
            p pVar = p.this;
            arrayList.add(pVar.a("Device ID Targeting", pVar.a(l8VarD.a())));
            p pVar2 = p.this;
            arrayList.add(pVar2.a("Device Type Targeting", pVar2.b(l8VarD.b())));
            if (l8VarD.c() != null) {
                arrayList.add(p.this.a(l8VarD.c()));
            }
            return arrayList;
        }

        @Override // com.applovin.impl.s2
        protected int d(int i) {
            o oVar = (o) this.e.g().get(i);
            return (oVar.b() != null ? 1 : 0) + 3 + (oVar.d().c() == null ? 0 : 1);
        }

        @Override // com.applovin.impl.s2
        protected r2 e(int i) {
            return i == b.TARGETED_WATERFALL.ordinal() ? new w4("TARGETED WATERFALL FOR CURRENT DEVICE") : i == b.OTHER_WATERFALLS.ordinal() ? new w4("OTHER WATERFALLS") : new w4("");
        }
    }

    public enum b {
        TARGETED_WATERFALL,
        OTHER_WATERFALLS
    }

    @Override // com.applovin.impl.n3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.b;
    }

    public void initialize(final n nVar, final com.applovin.impl.sdk.k kVar) {
        this.f550a = nVar;
        this.b = kVar;
        a aVar = new a(this, nVar);
        this.c = aVar;
        aVar.a(new s2.a() { // from class: com.applovin.impl.p$$ExternalSyntheticLambda2
            @Override // com.applovin.impl.s2.a
            public final void a(j2 j2Var, r2 r2Var) {
                this.f$0.a(kVar, nVar, j2Var, r2Var);
            }
        });
        this.c.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.n3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.f550a.d());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter((ListAdapter) this.c);
        listView.setDividerHeight(0);
    }

    @Override // com.applovin.impl.n3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        s2 s2Var = this.c;
        if (s2Var != null) {
            s2Var.a((s2.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        return str.equals(HintConstants.AUTOFILL_HINT_PHONE) ? "Phones" : str.equals("tablet") ? "Tablets" : "All";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public r2 c(String str) {
        return r2.a(r2.c.RIGHT_DETAIL).b(StringUtils.createSpannedString(str, -16777216, 18, 1)).a(this).a(true).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.applovin.impl.sdk.k kVar, final n nVar, final j2 j2Var, r2 r2Var) {
        if (j2Var.a() == 0) {
            d.a(this, MaxDebuggerAdUnitDetailActivity.class, kVar.e(), new d.b() { // from class: com.applovin.impl.p$$ExternalSyntheticLambda0
                @Override // com.applovin.impl.d.b
                public final void a(Activity activity) {
                    p.a(nVar, j2Var, kVar, (MaxDebuggerAdUnitDetailActivity) activity);
                }
            });
        } else {
            d.a(this, MaxDebuggerWaterfallSegmentsActivity.class, kVar.e(), new d.b() { // from class: com.applovin.impl.p$$ExternalSyntheticLambda1
                @Override // com.applovin.impl.d.b
                public final void a(Activity activity) {
                    p.a(nVar, j2Var, kVar, (MaxDebuggerWaterfallSegmentsActivity) activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(n nVar, j2 j2Var, com.applovin.impl.sdk.k kVar, MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
        maxDebuggerAdUnitDetailActivity.initialize(nVar, (o) nVar.g().get(j2Var.b()), null, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(n nVar, j2 j2Var, com.applovin.impl.sdk.k kVar, MaxDebuggerWaterfallSegmentsActivity maxDebuggerWaterfallSegmentsActivity) {
        o oVar = (o) nVar.g().get(j2Var.b());
        maxDebuggerWaterfallSegmentsActivity.initialize(oVar.c(), oVar.d().c(), kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public r2 a(String str, String str2) {
        return r2.a(r2.c.RIGHT_DETAIL).d(str).c(str2).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public r2 a(List list) {
        return r2.a(r2.c.DETAIL).d("Segment Targeting").a(StringUtils.createSpannedString(list.size() + " segment group(s)", -7829368, 14)).a(this).a(true).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (str.equals("idfa")) {
            return "IDFA Only";
        }
        if (str.equals("dnt")) {
            return "No IDFA Only";
        }
        return "All";
    }
}
