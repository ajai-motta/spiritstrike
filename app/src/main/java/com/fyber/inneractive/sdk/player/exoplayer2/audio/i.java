package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.fyber.inneractive.sdk.player.exoplayer2.audio.AudioRendererEventListener;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1269a;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher b;

    public i(AudioRendererEventListener.EventDispatcher eventDispatcher, int i) {
        this.b = eventDispatcher;
        this.f1269a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.listener.onAudioSessionId(this.f1269a);
    }
}
