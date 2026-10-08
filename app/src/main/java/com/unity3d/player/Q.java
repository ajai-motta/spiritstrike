package com.unity3d.player;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes6.dex */
final class Q implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f3276a;

    Q(S s) {
        this.f3276a = s;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            S s = this.f3276a;
            s.a(s.b(), false);
        }
        return false;
    }
}
