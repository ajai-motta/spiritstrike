package com.applovin.impl;

/* JADX INFO: loaded from: classes2.dex */
public enum i {
    PUBLISHER_INITIATED("publisher_initiated"),
    SEQUENTIAL_OR_PRECACHE("sequential_or_precache"),
    REFRESH("refresh"),
    EXPONENTIAL_RETRY("exponential_retry"),
    EXPIRED("expired"),
    NATIVE_AD_PLACER("native_ad_placer");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f408a;

    i(String str) {
        this.f408a = str;
    }

    public String b() {
        return this.f408a;
    }
}
