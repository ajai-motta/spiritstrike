package com.facebook.ads.redexgen.core;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.f6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2065f6 implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ C09423r A00;

    public C2065f6(C09423r c09423r) {
        this.A00 = c09423r;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        new Handler(Looper.getMainLooper()).post(new C1177Dl(this, i));
    }
}
