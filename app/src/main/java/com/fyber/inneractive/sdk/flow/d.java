package com.fyber.inneractive.sdk.flow;

import android.os.Handler;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f1039a;
    public final com.fyber.inneractive.sdk.interfaces.b b;
    public final b c = new b(this);
    public final c d = new c(this);

    public d(com.fyber.inneractive.sdk.interfaces.b bVar) {
        this.b = bVar;
    }

    public final void a() {
        IAlog.a("%s : ContentLoadTimeoutHandler destroying timeout handler", IAlog.a(this));
        if (this.f1039a != null) {
            IAlog.a("%s : ContentLoadTimeoutHandler stopping timeout handler", IAlog.a(this));
            Handler handler = this.f1039a;
            if (handler != null) {
                handler.removeCallbacks(this.d);
            }
            this.f1039a.getLooper().quitSafely();
            this.f1039a = null;
        }
    }
}
