package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes2.dex */
public class fs extends YogaNodeJNIBase {
    protected void finalize() throws Throwable {
        try {
            exu();
        } finally {
            super.finalize();
        }
    }

    public void exu() {
        if (this.qdl != 0) {
            long j = this.qdl;
            this.qdl = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}
