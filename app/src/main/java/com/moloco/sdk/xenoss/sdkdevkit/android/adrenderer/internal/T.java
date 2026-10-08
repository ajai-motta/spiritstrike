package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final T f2491a = new T();
    public static final Map<Integer, C3023d> b = new LinkedHashMap();
    public static final int c = 8;

    public final void b(int i) {
        b.remove(Integer.valueOf(i));
    }

    public final int a(C3023d wv) {
        Intrinsics.checkNotNullParameter(wv, "wv");
        int iHashCode = wv.hashCode();
        b.put(Integer.valueOf(iHashCode), wv);
        return iHashCode;
    }

    public final /* synthetic */ <T> T a(int i) {
        T t = (T) b.get(Integer.valueOf(i));
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }
}
