package com.applovin.impl.mediation;

import com.applovin.impl.a3;
import com.applovin.impl.y2;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAdWaterfallInfoImpl implements MaxAdWaterfallInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y2 f475a;
    private final String b;
    private final String c;
    private final List d;
    private final long e;
    private final a3 f;
    private final List g;
    private final String h;
    private final String i;

    public MaxAdWaterfallInfoImpl(y2 y2Var, long j, List<MaxNetworkResponseInfo> list, String str) {
        this(y2Var, y2Var.R(), y2Var.S(), j, list, y2Var.L(), y2Var.Q(), str, y2Var.O());
    }

    public String getEventId() {
        return this.i;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public long getLatencyMillis() {
        return this.e;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public MaxAd getLoadedAd() {
        return this.f475a;
    }

    public String getMCode() {
        return this.h;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public String getName() {
        return this.b;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public List<MaxNetworkResponseInfo> getNetworkResponses() {
        return this.d;
    }

    public List<String> getPostbackUrls() {
        return this.g;
    }

    public a3 getRequestParameters() {
        return this.f;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public String getTestName() {
        return this.c;
    }

    public String toString() {
        return "MaxAdWaterfallInfo{name=" + this.b + ", testName=" + this.c + ", networkResponses=" + this.d + ", latencyMillis=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public MaxAdWaterfallInfoImpl(y2 y2Var, String str, String str2, long j, List<MaxNetworkResponseInfo> list, a3 a3Var, List<String> list2, String str3, String str4) {
        this.f475a = y2Var;
        this.b = str;
        this.c = str2;
        this.e = j;
        this.d = list;
        this.f = a3Var;
        this.g = list2;
        this.h = str3;
        this.i = str4;
    }
}
