package com.fyber.inneractive.sdk.protobuf;

import com.unity3d.services.core.fid.Constants;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class x1 {
    public static final v1 b = new v1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b2 f1591a;

    public x1() {
        b2 b2Var;
        try {
            b2Var = (b2) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod(Constants.GET_INSTANCE, null).invoke(null, null);
        } catch (Exception unused) {
            b2Var = b;
        }
        w1 w1Var = new w1(r0.f1576a, b2Var);
        Charset charset = l1.f1565a;
        this.f1591a = w1Var;
    }
}
