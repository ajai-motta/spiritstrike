package com.fyber.inneractive.sdk.click;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f913a;
    public final Throwable b;
    public final String c;
    public final String d;
    public long e;
    public final ArrayList f = new ArrayList();

    public b(String str, q qVar, String str2, Exception exc) {
        this.d = str;
        this.f913a = qVar;
        this.c = str2;
        this.b = exc;
    }

    public final String toString() {
        q qVar = this.f913a;
        if (qVar == q.FAILED) {
            Throwable th = this.b;
            return "Open result: Failed! error: " + (th != null ? th.getMessage() : "none");
        }
        return "Open result: Success! target: " + qVar + " method: " + this.c;
    }
}
