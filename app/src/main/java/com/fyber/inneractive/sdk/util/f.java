package com.fyber.inneractive.sdk.util;

import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final f b = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue f1651a = new ConcurrentLinkedQueue();

    public f() {
        for (int i = 0; i < 2; i++) {
            this.f1651a.offer(ByteBuffer.allocateDirect(16384));
        }
    }
}
