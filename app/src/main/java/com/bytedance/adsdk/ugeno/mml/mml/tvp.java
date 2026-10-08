package com.bytedance.adsdk.ugeno.mml.mml;

import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.mml.exu;

/* JADX INFO: loaded from: classes2.dex */
public class tvp extends lnr {
    private boolean exu;
    private float fs;
    private exu rdp;
    private float rq;

    public tvp(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.mml.mml.lnr
    public boolean qdl(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        exu exuVar = this.rdp;
        if (exuVar != null) {
            return exuVar.qdl(this.ud, motionEvent, this.qdl, this);
        }
        return qdl(this.ud, motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean qdl(com.bytedance.adsdk.ugeno.ud.lnr r9, android.view.MotionEvent r10) {
        /*
            r8 = this;
            int r0 = r10.getAction()
            r1 = 1
            if (r0 == 0) goto L8b
            r2 = 1097859072(0x41700000, float:15.0)
            r3 = 0
            if (r0 == r1) goto L38
            r4 = 2
            if (r0 == r4) goto L17
            r4 = 3
            if (r0 == r4) goto L14
            goto L97
        L14:
            r8.exu = r3
            goto L38
        L17:
            float r9 = r10.getRawX()
            float r10 = r10.getRawY()
            float r0 = r8.rq
            float r9 = r9 - r0
            float r9 = java.lang.Math.abs(r9)
            int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r9 >= 0) goto L35
            float r9 = r8.fs
            float r10 = r10 - r9
            float r9 = java.lang.Math.abs(r10)
            int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r9 < 0) goto L97
        L35:
            r8.exu = r1
            goto L97
        L38:
            boolean r0 = r8.exu
            java.lang.String r4 = "Non-tap event"
            java.lang.String r5 = "GesThrough_UGTapEvent"
            r6 = 0
            if (r0 == 0) goto L4b
            r8.exu = r3
            r8.rq = r6
            r8.fs = r6
            android.util.Log.d(r5, r4)
            return r3
        L4b:
            float r0 = r10.getRawX()
            float r10 = r10.getRawY()
            float r7 = r8.rq
            float r0 = r0 - r7
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L85
            float r0 = r8.fs
            float r10 = r10 - r0
            float r10 = java.lang.Math.abs(r10)
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 < 0) goto L6a
            goto L85
        L6a:
            java.lang.String r10 = "Tap event, direct handling"
            android.util.Log.d(r5, r10)
            com.bytedance.adsdk.ugeno.mml.rq r10 = r8.qdl
            if (r10 == 0) goto L97
            com.bytedance.adsdk.ugeno.mml.rq r10 = r8.qdl
            java.lang.String r0 = r8.mo
            com.bytedance.adsdk.ugeno.mml.mo r2 = r8.lnr
            java.util.List r2 = r2.ud()
            r10.qdl(r9, r0, r2)
            r8.rq = r6
            r8.fs = r6
            return r1
        L85:
            r8.exu = r3
            android.util.Log.d(r5, r4)
            return r3
        L8b:
            float r9 = r10.getRawX()
            r8.rq = r9
            float r9 = r10.getRawY()
            r8.fs = r9
        L97:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.mml.mml.tvp.qdl(com.bytedance.adsdk.ugeno.ud.lnr, android.view.MotionEvent):boolean");
    }

    public void qdl(exu exuVar) {
        this.rdp = exuVar;
    }
}
