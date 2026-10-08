package com.tnkfactory.ad.pub;

import android.os.Handler;
import android.os.Message;
import com.tnkfactory.ad.AdListener;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public final class u extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3199a;

    public u(v vVar) {
        this.f3199a = new WeakReference(vVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        v vVar = (v) this.f3199a.get();
        if (vVar == null || message == null || !vVar.j) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            vVar.a(AdListener.CLOSE_SIMPLE, true);
            return;
        }
        if (i == 1) {
            vVar.a(vVar.d.j, message.arg1);
            return;
        }
        if (i == 2) {
            vVar.a(AdListener.CLOSE_EXIT, true);
            return;
        }
        if (i == 8) {
            if (vVar.d.z != null) {
                c0.a(vVar.getContext(), vVar.d.z, false);
            }
        } else {
            if (i == 9) {
                vVar.a((String) message.obj, message.arg1);
                return;
            }
            int i2 = i - 100;
            k5 k5Var = new k5(vVar.getContext(), vVar.d);
            if (i2 != 100) {
                k5Var.a(i2, vVar.i, null);
            } else {
                k5Var.a(i2, vVar.i, new t(vVar));
                vVar.f = false;
            }
        }
    }
}
