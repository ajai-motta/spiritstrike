package com.bytedance.sdk.component.adexpress.dynamic.animation.qdl;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class exu extends mml {
    public exu(View view, com.bytedance.sdk.component.adexpress.dynamic.mml.qdl qdlVar) {
        super(view, qdlVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.qdl.mml
    List<ObjectAnimator> qdl() {
        if ((this.lnr instanceof ImageView) && (this.lnr.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.rq)) {
            this.lnr = (View) this.lnr.getParent();
            ((ViewGroup) this.lnr).setClipChildren(true);
            ((ViewGroup) this.lnr.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.lnr, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.ud.to() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(qdl(duration));
        return arrayList;
    }
}
