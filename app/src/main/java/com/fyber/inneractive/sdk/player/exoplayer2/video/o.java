package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.video.VideoRendererEventListener;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f1495a;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher b;

    public o(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.b = eventDispatcher;
        this.f1495a = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1495a.ensureUpdated();
        this.b.listener.onVideoDisabled(this.f1495a);
    }
}
