package com.fyber.inneractive.sdk.web.remoteui;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.m;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends m implements a, com.fyber.inneractive.sdk.player.ui.remote.a {
    public a h;
    public com.fyber.inneractive.sdk.player.ui.remote.a i;
    public boolean j = false;
    public final c k;

    public b() {
        c cVar = new c(this, this);
        this.k = cVar;
        setWebViewClient(cVar);
        getSettings().setJavaScriptEnabled(true);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setBackgroundColor(0);
    }

    @Override // com.fyber.inneractive.sdk.web.remoteui.a
    public final void a(com.fyber.inneractive.sdk.network.events.b bVar, String str, boolean z, HashMap map) {
        this.j = false;
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(bVar, str, z, map);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.m, android.webkit.WebView
    public final void destroy() {
        this.h = null;
        this.i = null;
        c cVar = this.k;
        cVar.getClass();
        IAlog.a("%s: destroy()", "RemoteUiWebViewClient");
        cVar.b = null;
        cVar.f1712a = null;
        super.destroy();
    }

    public void setCommandHandler(com.fyber.inneractive.sdk.player.ui.remote.a aVar) {
        this.i = aVar;
    }

    public void setResultFailureListener(a aVar) {
        this.h = aVar;
    }

    public void setUiReady(boolean z) {
        this.j = z;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.remote.a
    public final void a(String str, HashMap map) {
        com.fyber.inneractive.sdk.player.ui.remote.a aVar = this.i;
        if (aVar != null) {
            aVar.a(str, map);
        }
    }
}
