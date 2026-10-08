package com.bytedance.sdk.component.mo.qdl.qdl.qdl;

import android.content.Context;
import com.bytedance.sdk.component.mo.qdl.qdl.qdl.ud;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends ud {
    private static volatile qdl qdl;

    @Override // com.bytedance.sdk.component.mo.qdl.qdl.qdl.ud
    public /* bridge */ /* synthetic */ ud.C0206ud qdl() {
        return super.qdl();
    }

    public static qdl qdl(Context context) {
        if (qdl == null) {
            synchronized (qdl.class) {
                if (qdl == null) {
                    qdl = new qdl(context);
                }
            }
        }
        return qdl;
    }

    private qdl(Context context) {
        super(context);
    }
}
