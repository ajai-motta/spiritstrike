package com.bytedance.sdk.component.mzz.mzz;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.mzz.yt;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class to extends qdl {
    @Override // com.bytedance.sdk.component.mzz.mzz.tvp
    public void qdl(com.bytedance.sdk.component.mzz.lnr.lnr lnrVar) {
        Bitmap bitmapUd;
        int iFs = lnrVar.fs();
        if (iFs != 2 && iFs != 1) {
            bitmapUd = null;
        } else if (lnrVar.aaj() || lnrVar.exc().tvp()) {
            bitmapUd = ud(lnrVar);
        } else {
            bitmapUd = lnr(lnrVar);
        }
        if (bitmapUd == null) {
            lnrVar.qdl(new fs());
        } else {
            lnrVar.qdl(new exu(bitmapUd, null, false));
        }
    }

    @Override // com.bytedance.sdk.component.mzz.mzz.tvp
    public String qdl() {
        return "memory_cache";
    }

    private Bitmap ud(com.bytedance.sdk.component.mzz.lnr.lnr lnrVar) {
        Collection<yt> collectionQdl = lnrVar.jl().qdl();
        Bitmap bitmapQdl = null;
        if (collectionQdl == null) {
            return null;
        }
        Iterator<yt> it = collectionQdl.iterator();
        while (it.hasNext() && (bitmapQdl = it.next().qdl(lnrVar.to())) == null) {
        }
        return bitmapQdl;
    }

    private Bitmap lnr(com.bytedance.sdk.component.mzz.lnr.lnr lnrVar) {
        return lnrVar.jl().qdl(lnrVar.exc()).qdl(lnrVar.to());
    }
}
