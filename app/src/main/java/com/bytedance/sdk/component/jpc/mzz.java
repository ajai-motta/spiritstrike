package com.bytedance.sdk.component.jpc;

/* JADX INFO: loaded from: classes3.dex */
public class mzz {
    private static to qdl = new to() { // from class: com.bytedance.sdk.component.jpc.mzz.1
        @Override // com.bytedance.sdk.component.jpc.to
        public tvp createThreadFactory(int i, String str) {
            return new tvp(i, str);
        }
    };

    public static void qdl(to toVar) {
        qdl = toVar;
    }

    public static to qdl() {
        return qdl;
    }
}
