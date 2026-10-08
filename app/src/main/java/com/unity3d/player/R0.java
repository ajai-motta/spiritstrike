package com.unity3d.player;

import android.telephony.PhoneStateListener;

/* JADX INFO: loaded from: classes6.dex */
final class R0 extends PhoneStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f3277a;

    private R0(UnityPlayer unityPlayer) {
        this.f3277a = unityPlayer;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i, String str) {
        this.f3277a.nativeMuteMasterAudio(i == 1);
    }
}
