package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3230z0 extends V0 {
    final /* synthetic */ boolean b;
    final /* synthetic */ UnityPlayer c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3230z0(UnityPlayer unityPlayer, boolean z) {
        super(unityPlayer);
        this.c = unityPlayer;
        this.b = z;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        this.c.nativeSetKeyboardIsVisible(this.b);
    }
}
