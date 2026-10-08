package com.applovin.impl;

import com.adxcorp.util.ADXLogUtil;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: loaded from: classes2.dex */
public class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f577a;
    private String b;
    private y2 c;
    private com.applovin.impl.sdk.ad.b d;

    public q1(Object obj, long j) {
        this.f577a = j;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) obj;
            this.d = bVar;
            this.b = bVar.getAdZone().d() != null ? this.d.getAdZone().d().getLabel() : null;
        } else if (obj instanceof y2) {
            y2 y2Var = (y2) obj;
            this.c = y2Var;
            this.b = y2Var.getFormat().getLabel();
        }
    }

    public void a(Object obj) {
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            this.d = (com.applovin.impl.sdk.ad.b) obj;
        } else if (obj instanceof y2) {
            this.c = (y2) obj;
        }
    }

    public long b() {
        return this.f577a;
    }

    public com.applovin.impl.sdk.ad.b c() {
        return this.d;
    }

    public String d() {
        String str = this.b;
        return str != null ? str : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public y2 e() {
        return this.c;
    }

    public String f() {
        if (this.d != null) {
            return ADXLogUtil.PLATFORM_APPLOVIN;
        }
        y2 y2Var = this.c;
        return y2Var != null ? y2Var.getNetworkName() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public Object a() {
        com.applovin.impl.sdk.ad.b bVar = this.d;
        return bVar != null ? bVar : this.c;
    }
}
