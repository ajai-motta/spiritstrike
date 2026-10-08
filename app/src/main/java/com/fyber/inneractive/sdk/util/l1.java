package com.fyber.inneractive.sdk.util;

import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1 f1659a;
    public final Uri b;
    public final List c;

    public l1(k1 k1Var, Uri uri, List list) {
        this.f1659a = k1Var;
        this.b = uri;
        this.c = list;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f1659a.mPriority.compareTo(((l1) obj).f1659a.mPriority);
    }
}
