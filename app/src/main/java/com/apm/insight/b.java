package com.apm.insight;

import android.text.TextUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ICrashCallback, IOOMCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IOOMCallback f130a;
    private ICrashCallback b;
    private String c;

    @Override // com.apm.insight.ICrashCallback
    public final void onCrash(CrashType crashType, String str, Thread thread) {
    }

    @Override // com.apm.insight.IOOMCallback
    public final void onCrash(CrashType crashType, Throwable th, Thread thread, long j) {
    }

    public b(String str, ICrashCallback iCrashCallback) {
        this.c = str;
        this.b = iCrashCallback;
    }

    public b(String str, IOOMCallback iOOMCallback) {
        this.c = str;
        this.f130a = iOOMCallback;
    }

    public final void a(CrashType crashType, Throwable th, Thread thread, long j, JSONArray jSONArray) {
        if (this.f130a == null || jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (TextUtils.equals(a.a(jSONArray.optJSONObject(i), "header", "aid"), this.c)) {
                this.f130a.onCrash(crashType, th, thread, j);
            }
        }
    }

    public final void a(CrashType crashType, String str, Thread thread, JSONArray jSONArray) {
        if (this.b == null || jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (TextUtils.equals(a.a(jSONArray.optJSONObject(i), "header", "aid"), this.c)) {
                this.b.onCrash(crashType, str, thread);
            }
        }
    }

    public final void a(CrashType crashType, String str, String str2, String str3) {
        d dVarA;
        if (this.b == null || (dVarA = d.a(this.c)) == null || !dVarA.a(str3, str2)) {
            return;
        }
        this.b.onCrash(crashType, str, null);
    }
}
