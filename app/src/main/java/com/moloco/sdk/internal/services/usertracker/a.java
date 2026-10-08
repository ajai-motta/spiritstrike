package com.moloco.sdk.internal.services.usertracker;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2392a = 0;

    @Override // com.moloco.sdk.internal.services.usertracker.e
    public String a() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
