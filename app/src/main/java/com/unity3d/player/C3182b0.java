package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3182b0 extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f3297a;
    final /* synthetic */ C3184c0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3182b0(C3184c0 c3184c0, Context context, S s) {
        super(context);
        this.b = c3184c0;
        this.f3297a = s;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (keyEvent.getAction() == 1) {
                this.b.h.onBackPressed();
            }
            return true;
        }
        if (i == 84) {
            return true;
        }
        if (i == 66 && keyEvent.getAction() == 0 && (getInputType() & 131072) == 0) {
            S s = this.f3297a;
            s.a(s.b(), false);
            return true;
        }
        if (i != 111 || keyEvent.getAction() != 0) {
            return super.onKeyPreIme(i, keyEvent);
        }
        S s2 = this.f3297a;
        s2.a(s2.b(), true);
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            requestFocus();
            this.f3297a.f();
        }
    }
}
