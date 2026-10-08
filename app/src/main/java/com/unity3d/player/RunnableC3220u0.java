package com.unity3d.player;

import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class RunnableC3220u0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3338a;
    final /* synthetic */ int b;
    final /* synthetic */ UnityPlayer c;

    RunnableC3220u0(UnityPlayer unityPlayer, int i, int i2) {
        this.c = unityPlayer;
        this.f3338a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        S s = this.c.mSoftInput;
        if (s != null) {
            int i2 = this.f3338a;
            int i3 = this.b;
            EditText editText = s.c;
            if (editText == null || editText.getText().length() < (i = i3 + i2)) {
                return;
            }
            s.c.setSelection(i2, i);
        }
    }
}
