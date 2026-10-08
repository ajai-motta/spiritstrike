package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k2 f1566a;
    public static final k2 b;

    static {
        k2 k2Var = null;
        try {
            k2Var = (k2) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f1566a = k2Var;
        b = new k2();
    }
}
