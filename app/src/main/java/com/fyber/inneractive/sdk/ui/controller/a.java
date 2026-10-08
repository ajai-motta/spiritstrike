package com.fyber.inneractive.sdk.ui.controller;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f1634a;
    public final AtomicBoolean b = new AtomicBoolean(false);

    @Override // com.fyber.inneractive.sdk.ui.controller.b
    public final void a(float f) {
        if (f < 0.01f || !this.b.compareAndSet(false, true)) {
            return;
        }
        IAlog.a("%sVisibility requirement met. visibleViewArea: %.1f%%", IAlog.a(this), Float.valueOf(f * 100.0f));
        this.f1634a.u();
    }

    @Override // com.fyber.inneractive.sdk.ui.controller.b
    public final void destroy() {
        throw null;
    }
}
