package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1492a;
    public final /* synthetic */ long b;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher c;

    public l(VideoRendererEventListener.EventDispatcher eventDispatcher, int i, long j) {
        this.c = eventDispatcher;
        this.f1492a = i;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.listener.onDroppedFrames(this.f1492a, this.b);
    }
}
