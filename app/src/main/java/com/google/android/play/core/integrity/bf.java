package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
final class bf extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f1764a;
    final /* synthetic */ TaskCompletionSource b;
    final /* synthetic */ bn c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bf(bn bnVar, TaskCompletionSource taskCompletionSource, int i, long j, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f1764a = j;
        this.b = taskCompletionSource2;
        this.c = bnVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    protected final void b() {
        if (bn.l(this.c)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        if (bn.k(this.c, 0)) {
            super.a(new StandardIntegrityException(-14, null));
            return;
        }
        try {
            bn bnVar = this.c;
            ((com.google.android.play.integrity.internal.i) bnVar.f1769a.e()).e(bn.b(bnVar, this.f1764a, 0), new bl(this.c, this.b));
        } catch (RemoteException e) {
            this.c.b.c(e, "warmUpIntegrityToken(%s)", Long.valueOf(this.f1764a));
            this.b.trySetException(new StandardIntegrityException(-100, e));
        }
    }
}
