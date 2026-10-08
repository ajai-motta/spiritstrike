package com.tnkfactory.ad.pub;

import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes6.dex */
public final class t extends l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f3194a;

    public t(v vVar) {
        this.f3194a = vVar;
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = AdListener.VIDEO_VERIFY_FAILED_ERROR;
        if (num != null) {
            iIntValue = num.intValue();
        }
        k2 k2Var = this.f3194a.c;
        if (k2Var != null) {
            k2Var.b(iIntValue);
        }
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Throwable th) {
        Logger.e(h1.a("853b41b3fb439e79b3686c4a32fc75a38fd407102a4288861e61be7a1aea85373858cb55b88d6cef0d389448fb0149") + th.toString());
        k2 k2Var = this.f3194a.c;
        if (k2Var != null) {
            k2Var.b(AdListener.VIDEO_VERIFY_FAILED_ERROR);
        }
    }
}
