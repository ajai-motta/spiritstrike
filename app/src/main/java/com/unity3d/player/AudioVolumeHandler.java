package com.unity3d.player;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public class AudioVolumeHandler implements InterfaceC3209p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C3211q f3244a;

    AudioVolumeHandler(Context context) {
        C3211q c3211q = new C3211q(context);
        this.f3244a = c3211q;
        c3211q.a(this);
    }

    public final void a() {
        this.f3244a.a();
        this.f3244a = null;
    }

    @Override // com.unity3d.player.InterfaceC3209p
    public final native void onAudioVolumeChanged(int i);
}
