package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1363a;
    public final List b;
    public final byte[] c;

    public d0(int i, String str, ArrayList arrayList, byte[] bArr) {
        this.f1363a = str;
        this.b = arrayList == null ? Collections.emptyList() : Collections.unmodifiableList(arrayList);
        this.c = bArr;
    }
}
