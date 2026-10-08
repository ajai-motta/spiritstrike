package com.applovin.impl;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import com.applovin.impl.r2;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public class p1 extends r2 {
    private final q1 n;
    private final Context o;

    public p1(q1 q1Var, Context context) {
        super(r2.c.DETAIL);
        this.n = q1Var;
        this.o = context;
        this.c = r();
        this.d = q();
    }

    private SpannedString q() {
        return new SpannedString("Displayed " + o7.a(this.n.b(), true));
    }

    private SpannedString r() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.n.d());
        spannableStringBuilder.append((CharSequence) " - ");
        spannableStringBuilder.append((CharSequence) this.n.f());
        return new SpannedString(spannableStringBuilder);
    }

    @Override // com.applovin.impl.r2
    public int d() {
        return o() ? R.drawable.applovin_ic_disclosure_arrow : super.h();
    }

    @Override // com.applovin.impl.r2
    public int e() {
        return m0.a(R.color.applovin_sdk_disclosureButtonColor, this.o);
    }

    @Override // com.applovin.impl.r2
    public boolean o() {
        return true;
    }
}
