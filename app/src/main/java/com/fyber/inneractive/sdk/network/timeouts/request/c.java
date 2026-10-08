package com.fyber.inneractive.sdk.network.timeouts.request;

import androidx.compose.animation.core.AnimationConstants;
import com.fyber.inneractive.sdk.config.global.features.j;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    public double m;

    public c(String str, j jVar, String str2) {
        super(str, jVar, str2);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(j jVar, String str) {
        return jVar.b(str, this.l);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int b(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String strA = j.a(str, "min", "rat", "bidding", j.e(str2));
        String strA2 = j.a(str, "min", "rat", "bidding", "all_mediators");
        "read".equalsIgnoreCase(str);
        Integer numA = jVar.a(strA2);
        int iIntValue = numA != null ? numA.intValue() : 5000;
        Integer numA2 = jVar.a(strA);
        return numA2 != null ? numA2.intValue() : iIntValue;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int c(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String strA = j.a(str, "rat", "bidding", "perc", j.e(str2));
        String strA2 = j.a(str, "rat", "bidding", "perc", "all_mediators");
        "read".equalsIgnoreCase(str);
        Integer numA = jVar.a(strA2);
        int iIntValue = numA != null ? numA.intValue() : 15;
        Integer numA2 = jVar.a(strA);
        return numA2 != null ? numA2.intValue() : iIntValue;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final void d(j jVar, String str) {
        super.d(jVar, str);
        Boolean boolC = jVar.c("reverse_retries");
        this.g = boolC != null ? boolC.booleanValue() : true;
        String strA = j.a("retry_interval", "rat", "bidding");
        Integer numA = jVar.a(j.a("retry_interval", "all_mediators"));
        int iIntValue = numA != null ? numA.intValue() : 100;
        Integer numA2 = jVar.a(strA);
        if (numA2 != null) {
            iIntValue = numA2.intValue();
        }
        this.e = iIntValue;
        this.c = (this.i + this.h) - (iIntValue + this.f);
        String strA2 = j.a("bidding", "irat", j.e(this.l));
        Integer numA3 = jVar.a(j.a("bidding", "irat", "all_mediators"));
        int iIntValue2 = numA3 != null ? numA3.intValue() : 10000;
        Integer numA4 = jVar.a(strA2);
        if (numA4 != null) {
            iIntValue2 = numA4.intValue();
        }
        this.d = iIntValue2;
        this.m = ((double) Math.min(this.k, this.j)) / ((double) Math.max(this.k, this.j));
        b(this.d);
        this.f1218a = Math.max(0, a());
        if (this.g) {
            IAlog.a("%s : RequestBiddingAdTimeout shouldReverseRetries - reversing timeouts", IAlog.a(this));
            a(0);
        }
        IAlog.a("%s : RequestBiddingAdTimeout init timeouts, total retries: %d", IAlog.a(this), Integer.valueOf(this.f1218a));
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(j jVar) {
        String str = this.l;
        jVar.getClass();
        String strA = j.a("timeout", "threshold", "rat", "bidding", j.e(str));
        Integer numA = jVar.a(j.a("timeout", "threshold", "rat", "bidding", "all_mediators"));
        int iIntValue = numA != null ? numA.intValue() : AnimationConstants.DefaultDurationMillis;
        Integer numA2 = jVar.a(strA);
        return numA2 != null ? numA2.intValue() : iIntValue;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int c() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(int i) {
        if (this.g) {
            i = this.f1218a - i;
        }
        int i2 = (this.b * i) + this.d;
        IAlog.a("%s : RequestBiddingAdTimeout resolveTimeoutForRetry, timeout: %d ms for retry: %d", IAlog.a(this), Integer.valueOf(i2), Integer.valueOf(i));
        b(i2);
        return i2;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int b() {
        return this.f1218a;
    }

    public final void b(int i) {
        double d = this.m;
        if (d == 1.0d || d == 0.0d) {
            IAlog.a("%s : RequestBiddingAdTimeout Ratio: %f, connection and read timeouts should be divided in equal proportions", IAlog.a(this), Double.valueOf(this.m));
            this.m = 0.5d;
        }
        int i2 = (int) (((double) i) * this.m);
        this.h = i2;
        this.i = i - i2;
        IAlog.a("%s : RequestBiddingAdTimeout Update timeouts connection: %d read: %d", IAlog.a(this), Integer.valueOf(this.i), Integer.valueOf(this.h));
    }
}
