package com.unity3d.player;

import android.content.Context;
import android.view.OrientationEventListener;

/* JADX INFO: loaded from: classes6.dex */
final class D0 extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f3250a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    D0(UnityPlayer unityPlayer, Context context, int i) {
        super(context, i);
        this.f3250a = unityPlayer;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        UnityPlayer unityPlayer = this.f3250a;
        U0 u0 = unityPlayer.m_MainThread;
        u0.f = unityPlayer.mNaturalOrientation;
        u0.g = i;
        u0.a(S0.j);
    }
}
