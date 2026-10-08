package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public enum p0 {
    SCALAR(false),
    VECTOR(true),
    PACKED_VECTOR(true),
    MAP(false);

    private final boolean isList;

    p0(boolean z) {
        this.isList = z;
    }

    public final boolean a() {
        return this.isList;
    }
}
