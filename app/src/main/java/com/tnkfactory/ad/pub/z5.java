package com.tnkfactory.ad.pub;

import android.os.Handler;
import android.webkit.JavascriptInterface;
import androidx.compose.material.TextFieldImplKt;

/* JADX INFO: loaded from: classes6.dex */
public final class z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a6 f3233a;

    public z5(a6 a6Var) {
        this.f3233a = a6Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0018  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendError(int r2) {
        /*
            r1 = this;
            r0 = 2
            if (r2 == r0) goto L1e
            r0 = 5
            if (r2 == r0) goto L1b
            r0 = 150(0x96, float:2.1E-43)
            if (r2 == r0) goto L18
            r0 = 100
            if (r2 == r0) goto L15
            r0 = 101(0x65, float:1.42E-43)
            if (r2 == r0) goto L18
            java.lang.String r2 = ""
            goto L20
        L15:
            java.lang.String r2 = "video not found."
            goto L20
        L18:
            java.lang.String r2 = "not authorized play."
            goto L20
        L1b:
            java.lang.String r2 = "HTML5 error."
            goto L20
        L1e:
            java.lang.String r2 = "invalid parameter."
        L20:
            java.lang.String r0 = "error #2902 : "
            java.lang.String r2 = r0.concat(r2)
            com.tnkfactory.ad.Logger.e(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tnkfactory.ad.pub.z5.sendError(int):void");
    }

    @JavascriptInterface
    public void sendReady() {
        if (this.f3233a.e) {
            new Handler().postDelayed(new y5(this), 1000L);
        }
    }

    @JavascriptInterface
    public void sendStateChange(int i) {
        x5 x5Var;
        a6 a6Var = this.f3233a;
        a6Var.c = i;
        if (i != 0) {
            if (i != 1 || (x5Var = a6Var.l) == null || a6Var.f) {
                return;
            }
            a6Var.f = true;
            u uVar = ((n1) x5Var).f3165a.j;
            if (uVar != null) {
                uVar.sendEmptyMessage(100);
                return;
            }
            return;
        }
        x5 x5Var2 = a6Var.l;
        if (x5Var2 == null || a6Var.j) {
            return;
        }
        a6Var.j = true;
        u uVar2 = ((n1) x5Var2).f3165a.j;
        if (uVar2 != null) {
            uVar2.sendEmptyMessage(200);
        }
    }

    @JavascriptInterface
    public void sendVideoCurrentTime(float f) {
        x5 x5Var;
        a6 a6Var = this.f3233a;
        float f2 = a6Var.d;
        float f3 = (f2 - (f2 - f)) / f2;
        if (f2 <= 0.0f || (x5Var = a6Var.l) == null) {
            return;
        }
        double d = f3;
        if (d >= 0.25d && !a6Var.g) {
            a6Var.g = true;
            u uVar = ((n1) x5Var).f3165a.j;
            if (uVar != null) {
                uVar.sendEmptyMessage(125);
            }
        }
        if (d >= 0.5d) {
            a6 a6Var2 = this.f3233a;
            if (!a6Var2.h) {
                a6Var2.h = true;
                u uVar2 = ((n1) a6Var2.l).f3165a.j;
                if (uVar2 != null) {
                    uVar2.sendEmptyMessage(TextFieldImplKt.AnimationDuration);
                }
            }
        }
        if (d >= 0.75d) {
            a6 a6Var3 = this.f3233a;
            if (a6Var3.i) {
                return;
            }
            a6Var3.i = true;
            u uVar3 = ((n1) a6Var3.l).f3165a.j;
            if (uVar3 != null) {
                uVar3.sendEmptyMessage(175);
            }
        }
    }

    @JavascriptInterface
    public void sendVideoDuration(float f) {
        this.f3233a.d = f;
    }
}
