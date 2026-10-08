package com.bytedance.sdk.openadsdk.core.exu.lnr;

import com.bytedance.sdk.component.utils.wd;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class lnr extends com.bytedance.sdk.openadsdk.ud.ud {
    public lnr(int i, int i2) {
        super(i, i2);
    }

    public lnr(int i, int i2, boolean z) {
        super(i, i2);
        this.qdl = z;
    }

    @Override // com.bytedance.sdk.openadsdk.ud.ud, com.bytedance.sdk.openadsdk.ud.qdl
    protected void qdl(List<File> list) {
        int size = list.size();
        if (qdl(0L, size)) {
            return;
        }
        for (File file : list) {
            wd.lnr(file);
            size--;
            if (qdl(file, 0L, size)) {
                return;
            }
        }
    }
}
