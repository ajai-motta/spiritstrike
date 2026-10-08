package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.b7;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x6 extends n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f720a;
    private s2 b;

    class a extends s2 {
        final /* synthetic */ ArrayList e;
        final /* synthetic */ ArrayList f;
        final /* synthetic */ boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, ArrayList arrayList, ArrayList arrayList2, boolean z) {
            super(context);
            this.e = arrayList;
            this.f = arrayList2;
            this.g = z;
        }

        @Override // com.applovin.impl.s2
        protected int b() {
            return b.values().length;
        }

        @Override // com.applovin.impl.s2
        protected List c(int i) {
            return i == b.TC_NETWORKS.ordinal() ? this.e : this.f;
        }

        @Override // com.applovin.impl.s2
        protected int d(int i) {
            return i == b.TC_NETWORKS.ordinal() ? this.e.size() : this.f.size();
        }

        @Override // com.applovin.impl.s2
        protected r2 e(int i) {
            if (i == b.TC_NETWORKS.ordinal()) {
                return new w4("TCF VENDORS (TC STRING)");
            }
            return new w4(this.g ? "ATP NETWORKS (AC STRING)" : "APPLOVIN PRIVACY SETTING");
        }
    }

    private enum b {
        TC_NETWORKS,
        AC_NETWORKS
    }

    private r2 a(String str, String str2) {
        return r2.a().d(str).c(str2).a();
    }

    @Override // com.applovin.impl.n3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f720a;
    }

    public void initialize(List<b7> list, com.applovin.impl.sdk.k kVar) {
        this.f720a = kVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strA = p0.b().a(this);
        boolean zB = kVar.s0().b();
        if (!zB) {
            arrayList2.add(a("Has User Consent", strA));
        }
        for (b7 b7Var : list) {
            Boolean boolA = b7Var.a();
            if (boolA != null) {
                if (b7Var.f() == b7.a.TCF_VENDOR) {
                    arrayList.add(a(b7Var.b(), String.valueOf(boolA)));
                } else if (b7Var.f() == b7.a.ATP_NETWORK) {
                    arrayList2.add(a(b7Var.b(), String.valueOf(boolA)));
                }
            } else if (zB && b7Var.f() == b7.a.ATP_NETWORK) {
                arrayList2.add(a(b7Var.b(), strA));
            }
        }
        a aVar = new a(this, arrayList, arrayList2, zB);
        this.b = aVar;
        aVar.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.n3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Network Consent Statuses");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.b);
    }
}
