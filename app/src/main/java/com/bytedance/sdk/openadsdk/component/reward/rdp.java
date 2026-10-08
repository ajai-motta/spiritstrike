package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* JADX INFO: loaded from: classes3.dex */
class rdp implements TTClientBidding {
    private final mo qdl;

    rdp(Context context, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
        this.qdl = new mo(context, qdlVar);
    }

    public mo qdl() {
        return this.qdl;
    }

    public void qdl(boolean z) {
        this.qdl.qdl(z);
    }

    public void ud() {
        this.qdl.qdl();
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        this.qdl.win(d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        this.qdl.loss(d, str, str2);
    }
}
