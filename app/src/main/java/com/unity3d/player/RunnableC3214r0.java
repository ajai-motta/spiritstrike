package com.unity3d.player;

import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.r0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class RunnableC3214r0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3332a;
    final /* synthetic */ UnityPlayer b;

    RunnableC3214r0(UnityPlayer unityPlayer, String str) {
        this.b = unityPlayer;
        this.f3332a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        EditText editText;
        S s = this.b.mSoftInput;
        if (s == null || (str = this.f3332a) == null || (editText = s.c) == null) {
            return;
        }
        editText.setText(str);
        s.c.setSelection(str.length());
    }
}
