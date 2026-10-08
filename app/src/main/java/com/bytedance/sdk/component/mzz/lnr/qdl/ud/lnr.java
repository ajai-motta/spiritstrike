package com.bytedance.sdk.component.mzz.lnr.qdl.ud;

import com.bytedance.sdk.component.mzz.jl;

/* JADX INFO: loaded from: classes3.dex */
public class lnr implements jl {
    private com.bytedance.sdk.component.mzz.lnr.qdl.lnr<String, byte[]> lnr;
    private int qdl;
    private int ud;

    public lnr(int i, int i2) {
        this.ud = i;
        this.qdl = i2;
        this.lnr = new com.bytedance.sdk.component.mzz.lnr.qdl.lnr<String, byte[]>(i) { // from class: com.bytedance.sdk.component.mzz.lnr.qdl.ud.lnr.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.mzz.lnr.qdl.lnr
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public int ud(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.mzz.qdl
    public boolean qdl(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.lnr.qdl(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.mzz.qdl
    public byte[] qdl(String str) {
        return this.lnr.qdl(str);
    }

    @Override // com.bytedance.sdk.component.mzz.qdl
    public boolean ud(String str) {
        return this.lnr.qdl(str) != null;
    }
}
