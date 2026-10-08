package com.fyber.inneractive.sdk.util;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue f1655a = new ConcurrentLinkedQueue();
    public final i b;

    public j(int i, i iVar) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f1655a.offer(iVar.a());
        }
        this.b = iVar;
    }
}
