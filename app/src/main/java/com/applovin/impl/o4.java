package com.applovin.impl;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f541a;
    private Map b;

    private o4(String str, Map map) {
        this.f541a = str;
        this.b = map;
    }

    public static o4 a(String str) {
        return a(str, null);
    }

    public String b() {
        return this.f541a;
    }

    public String toString() {
        return "PendingReward{result='" + this.f541a + "'params='" + this.b + "'}";
    }

    public static o4 a(String str, Map map) {
        return new o4(str, map);
    }

    public Map a() {
        return this.b;
    }
}
