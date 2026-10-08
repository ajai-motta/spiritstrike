package com.tnkfactory.ad.pub;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public final class f3 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3130a;
    public final Context b;

    public f3(Context context, i3 i3Var) {
        this.f3130a = new WeakReference(i3Var);
        this.b = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        i3 i3Var = (i3) this.f3130a.get();
        if (i3Var != null) {
            Context context = this.b;
            if (message == null) {
                return;
            }
            int i = message.what;
            if (i != 1) {
                if (i != 9) {
                    return;
                }
                i3Var.a(context, (String) message.obj);
            } else {
                if (i3Var.e.C != null) {
                    new o4(i3Var.e.C).start();
                }
                i3Var.a(context, i3Var.e.j);
            }
        }
    }
}
