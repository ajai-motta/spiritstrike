package com.bytedance.sdk.openadsdk.aaj;

/* JADX INFO: loaded from: classes3.dex */
public enum mml {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI("wifi"),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN("unknown");

    private String jpc;

    mml(String str) {
        this.jpc = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.jpc;
    }
}
