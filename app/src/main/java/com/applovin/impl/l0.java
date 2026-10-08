package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.internal.view.SupportMenu;
import com.applovin.impl.b7;
import com.applovin.impl.r2;
import com.applovin.impl.s2;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l0 extends n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f446a;
    private s2 b;

    class a extends s2 {
        final /* synthetic */ List e;
        final /* synthetic */ List f;
        final /* synthetic */ List g;
        final /* synthetic */ List h;
        final /* synthetic */ List i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list, List list2, List list3, List list4, List list5) {
            super(context);
            this.e = list;
            this.f = list2;
            this.g = list3;
            this.h = list4;
            this.i = list5;
        }

        @Override // com.applovin.impl.s2
        protected int b() {
            return c.values().length;
        }

        @Override // com.applovin.impl.s2
        protected List c(int i) {
            List list;
            boolean z = true;
            if (i == c.MISSING_TC_NETWORKS.ordinal()) {
                list = this.e;
            } else if (i == c.MISSING_AC_NETWORKS.ordinal()) {
                list = this.f;
            } else {
                z = false;
                list = i == c.LISTED_TC_NETWORKS.ordinal() ? this.g : i == c.LISTED_AC_NETWORKS.ordinal() ? this.h : this.i;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(l0.this.a((b7) it.next(), z));
            }
            return arrayList;
        }

        @Override // com.applovin.impl.s2
        protected int d(int i) {
            return i == c.MISSING_TC_NETWORKS.ordinal() ? this.e.size() : i == c.MISSING_AC_NETWORKS.ordinal() ? this.f.size() : i == c.LISTED_TC_NETWORKS.ordinal() ? this.g.size() : i == c.LISTED_AC_NETWORKS.ordinal() ? this.h.size() : this.i.size();
        }

        @Override // com.applovin.impl.s2
        protected r2 e(int i) {
            return i == c.MISSING_TC_NETWORKS.ordinal() ? new w4("MISSING TCF VENDORS (TC STRING)") : i == c.MISSING_AC_NETWORKS.ordinal() ? new w4("MISSING ATP NETWORKS (AC STRING)") : i == c.LISTED_TC_NETWORKS.ordinal() ? new w4("LISTED TCF VENDORS (TC STRING)") : i == c.LISTED_AC_NETWORKS.ordinal() ? new w4("LISTED ATP NETWORKS (AC STRING)") : new w4("NON-CONFIGURABLE NETWORKS");
        }
    }

    class b implements s2.a {
        b() {
        }

        @Override // com.applovin.impl.s2.a
        public void a(j2 j2Var, r2 r2Var) {
            o7.a(r2Var.c(), r2Var.b(), l0.this);
        }
    }

    private enum c {
        MISSING_TC_NETWORKS,
        MISSING_AC_NETWORKS,
        LISTED_TC_NETWORKS,
        LISTED_AC_NETWORKS,
        OTHER_NETWORKS
    }

    @Override // com.applovin.impl.n3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f446a;
    }

    public void initialize(List<b7> list, List<b7> list2, List<b7> list3, List<b7> list4, List<b7> list5, com.applovin.impl.sdk.k kVar) {
        this.f446a = kVar;
        a aVar = new a(this, list, list2, list3, list4, list5);
        this.b = aVar;
        aVar.a(new b());
        this.b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.n3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Configured CMP Networks");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public r2 a(b7 b7Var, boolean z) {
        r2.b bVarA = r2.a();
        boolean zB = this.f446a.s0().b();
        b7.a aVarF = b7Var.f();
        b7.a aVar = b7.a.TCF_VENDOR;
        if (aVarF == aVar || (b7Var.f() == b7.a.ATP_NETWORK && zB)) {
            String strC = b7Var.c();
            String str = b7Var.f() == aVar ? "IAB Vendor ID: " : "Google ATP ID: ";
            bVarA.d(strC).d(z ? SupportMenu.CATEGORY_MASK : -16777216).b(strC).a(str + b7Var.d()).a(true);
        } else {
            bVarA.d(b7Var.b());
        }
        return bVarA.a();
    }
}
