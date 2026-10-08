package com.apm.insight;

/* JADX INFO: loaded from: classes2.dex */
public interface ICrashCallback {
    void onCrash(CrashType crashType, String str, Thread thread);
}
