package com.unity3d.player;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: renamed from: com.unity3d.player.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3207o extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC3209p f3326a;
    private final AudioManager b;
    private final int c;
    private int d;

    public C3207o(Handler handler, AudioManager audioManager, InterfaceC3209p interfaceC3209p) {
        super(handler);
        this.b = audioManager;
        this.c = 3;
        this.f3326a = interfaceC3209p;
        this.d = audioManager.getStreamVolume(3);
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        int streamVolume;
        AudioManager audioManager = this.b;
        if (audioManager == null || this.f3326a == null || (streamVolume = audioManager.getStreamVolume(this.c)) == this.d) {
            return;
        }
        this.d = streamVolume;
        this.f3326a.onAudioVolumeChanged(streamVolume);
    }
}
