package com.moloco.sdk.internal.ortb.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class f {
    public static final String a(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        String mtid = cVar.getExt().getMtid();
        return mtid == null ? "UNKNOWN_MTID" : mtid;
    }
}
