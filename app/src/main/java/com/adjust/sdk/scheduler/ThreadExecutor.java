package com.adjust.sdk.scheduler;

/* JADX INFO: loaded from: classes2.dex */
public interface ThreadExecutor {
    void submit(Runnable runnable);

    void teardown();
}
