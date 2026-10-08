package com.fyber.inneractive.sdk.player.exoplayer2.video;

import android.view.Surface;
import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Surface f1494a;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher b;

    public n(VideoRendererEventListener.EventDispatcher eventDispatcher, Surface surface) {
        this.b = eventDispatcher;
        this.f1494a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.listener.onRenderedFirstFrame(this.f1494a);
    }
}
