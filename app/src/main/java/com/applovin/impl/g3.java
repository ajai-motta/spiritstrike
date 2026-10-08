package com.applovin.impl;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.e3;
import com.applovin.impl.r2;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g3 extends s2 {
    private final e3 e;
    private List f;
    private final List g;
    private final List h;
    private final List i;
    private final List j;
    private SpannedString k;

    public enum a {
        INTEGRATIONS,
        PERMISSIONS,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    g3(e3 e3Var, Context context) {
        super(context);
        this.e = e3Var;
        if (e3Var.q() == e3.a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.k = new SpannedString(spannableString);
        } else {
            this.k = new SpannedString("");
        }
        this.f = g();
        this.g = b(e3Var.n());
        this.h = e();
        this.i = a(e3Var.f());
        this.j = j();
        notifyDataSetChanged();
    }

    private r2 f() {
        if (this.e.I()) {
            return null;
        }
        return r2.a().d("Initialization Status").c(f(this.e.i())).a(false).a();
    }

    private List g() {
        ArrayList arrayList = new ArrayList(3);
        CollectionUtils.addObjectIfExists(i(), arrayList);
        CollectionUtils.addObjectIfExists(d(), arrayList);
        CollectionUtils.addObjectIfExists(f(), arrayList);
        return arrayList;
    }

    private r2 i() {
        r2.b bVarC = r2.a().d("SDK").c(this.e.p());
        if (TextUtils.isEmpty(this.e.p())) {
            bVarC.a(a(this.e.G())).b(b(this.e.G()));
        }
        return bVarC.a();
    }

    private List j() {
        ArrayList arrayList = new ArrayList(3);
        if (StringUtils.isValidString(this.e.v())) {
            arrayList.add(r2.a(r2.c.DETAIL).d(this.e.v()).a());
        }
        if (this.e.y() == e3.b.NOT_SUPPORTED) {
            return arrayList;
        }
        if (this.e.s() != null) {
            arrayList.add(c(this.e.s()));
        }
        arrayList.add(a(this.e.y()));
        return arrayList;
    }

    public boolean a(j2 j2Var) {
        return j2Var.b() == a.TEST_ADS.ordinal() && j2Var.a() == this.j.size() - 1;
    }

    @Override // com.applovin.impl.s2
    protected int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.s2
    protected List c(int i) {
        return i == a.INTEGRATIONS.ordinal() ? this.f : i == a.PERMISSIONS.ordinal() ? this.g : i == a.CONFIGURATION.ordinal() ? this.h : i == a.DEPENDENCIES.ordinal() ? this.i : this.j;
    }

    @Override // com.applovin.impl.s2
    protected int d(int i) {
        return i == a.INTEGRATIONS.ordinal() ? this.f.size() : i == a.PERMISSIONS.ordinal() ? this.g.size() : i == a.CONFIGURATION.ordinal() ? this.h.size() : i == a.DEPENDENCIES.ordinal() ? this.i.size() : this.j.size();
    }

    @Override // com.applovin.impl.s2
    protected r2 e(int i) {
        return i == a.INTEGRATIONS.ordinal() ? new w4("INTEGRATIONS") : i == a.PERMISSIONS.ordinal() ? new w4("PERMISSIONS") : i == a.CONFIGURATION.ordinal() ? new w4("CONFIGURATION") : i == a.DEPENDENCIES.ordinal() ? new w4("DEPENDENCIES") : new w4("TEST ADS");
    }

    public e3 h() {
        return this.e;
    }

    public void k() {
        this.f = g();
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k1 k1Var = (k1) it.next();
                arrayList.add(a(k1Var.b(), k1Var.a(), k1Var.c(), true));
            }
        }
        return arrayList;
    }

    private List b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                p4 p4Var = (p4) it.next();
                arrayList.add(a(p4Var.b(), p4Var.a(), p4Var.c(), true));
            }
        }
        return arrayList;
    }

    private String f(int i) {
        if (MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.getCode() != i && MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode() != i && MaxAdapter.InitializationStatus.DOES_NOT_APPLY.getCode() != i) {
            if (MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() == i) {
                return ADXLogUtil.EVENT_LOAD_FAILURE;
            }
            if (MaxAdapter.InitializationStatus.INITIALIZING.getCode() == i) {
                return "Initializing...";
            }
            return "Not Initialized";
        }
        return "Initialized";
    }

    private r2 a(e3.b bVar) {
        r2.b bVarA = r2.a();
        if (bVar == e3.b.READY) {
            bVarA.a(this.f593a);
        }
        return bVarA.d("Test Mode").c(bVar.c()).c(bVar.d()).b("Restart Required").a(bVar.b()).a(true).a();
    }

    private int b(boolean z) {
        return m0.a(z ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f593a);
    }

    private r2 c(List list) {
        return r2.a().d("Region/VPN Required").c(CollectionUtils.implode(list, ", ", list.size())).a();
    }

    private r2 d() {
        r2.b bVarC = r2.a().d("Adapter").c(this.e.c());
        if (TextUtils.isEmpty(this.e.c())) {
            bVarC.a(a(this.e.A())).b(b(this.e.A()));
        }
        return bVarC.a();
    }

    private List e() {
        ArrayList arrayList = new ArrayList(1);
        if (this.e.E()) {
            arrayList.add(a("Java 8", "For optimal performance, please enable Java 8 support. See: https://support.axon.ai/en/max/android/overview/integration", com.applovin.impl.sdk.k.G0(), true));
        }
        return arrayList;
    }

    private r2 a(String str, String str2, boolean z, boolean z2) {
        return r2.a(z ? r2.c.RIGHT_DETAIL : r2.c.DETAIL).d(str).a(z ? null : this.k).b("Instructions").a(str2).a(z ? R.drawable.applovin_ic_check_mark_bordered : c(z2)).b(z ? m0.a(R.color.applovin_sdk_checkmarkColor, this.f593a) : d(z2)).a(!z).a();
    }

    private int c(boolean z) {
        return z ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning;
    }

    private int d(boolean z) {
        return m0.a(z ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.f593a);
    }

    private int a(boolean z) {
        return z ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark;
    }
}
