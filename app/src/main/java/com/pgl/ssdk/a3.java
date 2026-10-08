package com.pgl.ssdk;

import com.pgl.ssdk.a2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes6.dex */
public class a3<T extends a2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3054a;
    private BlockingQueue<T> b = new LinkedBlockingQueue();

    private a3(int i) {
        this.f3054a = i;
    }

    public static a3 a(int i) {
        return new a3(i);
    }

    public T a() {
        return this.b.poll();
    }
}
