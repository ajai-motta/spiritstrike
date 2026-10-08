package com.bytedance.sdk.openadsdk.component.reward.qdl;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.koa;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.utils.ax;

/* JADX INFO: loaded from: classes3.dex */
public class rq {
    private boolean lnr;
    protected int qdl;
    private final com.bytedance.sdk.openadsdk.component.reward.qdl.qdl ud;

    private static boolean qdl(int i, int i2) {
        return i == 2 && i2 == 2;
    }

    public rq(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        this.qdl = 0;
        this.lnr = false;
        this.ud = qdlVar;
        ud();
        try {
            this.qdl = ax.lnr(qdlVar.ag, ax.qdl());
            if (!qdlVar.ag.getWindow().hasFeature(1)) {
                qdlVar.ag.requestWindowFeature(1);
            }
            qdlVar.ag.getWindow().addFlags(16777344);
            if (qdlVar.zlt == 2 || !ax.lnr(qdlVar.ag)) {
                qdlVar.ag.getWindow().addFlags(1024);
            }
            this.lnr = qdlVar.zvv;
            new Throwable();
        } catch (Throwable th) {
            Log.e("TTAD.RFSM", "init: ", th);
        }
    }

    public void qdl(koa koaVar) {
        if (koaVar == null) {
            return;
        }
        koaVar.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.rq.1
            @Override // java.lang.Runnable
            public void run() {
                View viewFindViewById;
                try {
                    View decorView = rq.this.ud.ag.getWindow().getDecorView();
                    if (decorView == null || (viewFindViewById = decorView.findViewById(R.id.statusBarBackground)) == null) {
                        return;
                    }
                    viewFindViewById.setVisibility(8);
                } catch (Exception unused) {
                }
            }
        }, 300L);
    }

    private void ud() {
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.ud;
        qdlVar.taz = qdlVar.ud.nv();
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar2 = this.ud;
        qdlVar2.zlt = qdl(qdlVar2.ag, this.ud.ud);
    }

    public static int qdl(Activity activity, ljh ljhVar) {
        if (26 == Build.VERSION.SDK_INT) {
            return activity.getResources().getConfiguration().orientation == 1 ? 1 : 2;
        }
        return ljhVar.jb();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void qdl(boolean r10) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.qdl.rq.qdl(boolean):void");
    }

    public float[] qdl(int i) {
        float[] fArrUd = new float[2];
        Activity activity = this.ud.ag;
        View decorView = activity.getWindow().getDecorView();
        int paddingLeft = decorView.getPaddingLeft();
        int paddingTop = decorView.getPaddingTop();
        if (this.lnr && paddingLeft == 0 && paddingTop == 0 && lnr(activity, i) == 0) {
            int[] iArrUd = ud(activity, decorView, i, ax.lnr(activity), com.bytedance.sdk.openadsdk.core.yt.mml().yh() == 1);
            int i2 = iArrUd[0];
            paddingTop = iArrUd[1];
            paddingLeft = i2;
        }
        if (Build.VERSION.SDK_INT >= 35 && this.ud.ud.nv() == 100.0f) {
            fArrUd[0] = decorView.getWidth() - paddingLeft;
            fArrUd[1] = decorView.getHeight() - paddingTop;
        } else {
            fArrUd[0] = decorView.getWidth() - (paddingLeft * 2);
            fArrUd[1] = decorView.getHeight() - (paddingTop * 2);
        }
        fArrUd[0] = ax.lnr(activity, fArrUd[0]);
        float fLnr = ax.lnr(activity, fArrUd[1]);
        fArrUd[1] = fLnr;
        if (fArrUd[0] < 10.0f || fLnr < 10.0f) {
            fArrUd = ud(this.qdl);
        }
        if (Build.VERSION.SDK_INT != 26 && Build.VERSION.SDK_INT != 27) {
            if (activity.getResources() != null && activity.getResources().getConfiguration() != null) {
                if ((activity.getResources().getConfiguration().orientation == 2 ? 2 : 1) != i) {
                    if (i == 2) {
                        float f = fArrUd[0];
                        float f2 = fArrUd[1];
                        if (f < f2) {
                            fArrUd[1] = f;
                            fArrUd[0] = f2;
                        }
                    } else {
                        float f3 = fArrUd[0];
                        float f4 = fArrUd[1];
                        if (f3 > f4) {
                            fArrUd[1] = f3;
                            fArrUd[0] = f4;
                        }
                    }
                }
            }
            float f5 = fArrUd[0];
            float f6 = fArrUd[1];
        }
        return fArrUd;
    }

    public void qdl() {
        ax.qdl(this.ud.ag);
        this.ud.ag.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.rq.2
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    try {
                        if (rq.this.ud.ag.isFinishing()) {
                            return;
                        }
                        rq.this.ud.ag.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.rq.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ax.qdl(rq.this.ud.ag);
                            }
                        }, 2500L);
                    } catch (Exception e) {
                        aaj.lnr("TTAD.RFSM", e.getMessage());
                    }
                }
            }
        });
    }

    private float[] ud(int i) {
        float fMzz = mzz();
        float fMml = mml();
        if ((this.ud.zlt == 1) != (fMzz > fMml)) {
            float f = fMzz + fMml;
            fMml = f - fMml;
            fMzz = f - fMml;
        }
        if (this.ud.zlt == 1) {
            fMzz -= i;
        } else {
            fMml -= i;
        }
        return new float[]{fMml, fMzz};
    }

    private void lnr() {
        if (this.ud.zlt == 2) {
            if (this.ud.car) {
                ud(this.ud.ag, 8);
                return;
            } else {
                ud(this.ud.ag, 0);
                return;
            }
        }
        ud(this.ud.ag, 1);
    }

    private static void ud(Activity activity, int i) {
        if (activity.getRequestedOrientation() == i) {
            return;
        }
        int i2 = activity.getResources().getConfiguration().orientation;
        activity.setRequestedOrientation(i);
    }

    private float mml() {
        return ax.lnr(this.ud.ag, ax.exu(this.ud.ag));
    }

    private float mzz() {
        return ax.lnr(this.ud.ag, ax.fs(this.ud.ag));
    }

    private static abstract class qdl implements View.OnLayoutChangeListener {
        private int qdl;
        private int ud;

        abstract void qdl(int i, int i2);

        private qdl() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i4 - i2;
            if (i9 == this.qdl && i10 == this.ud) {
                return;
            }
            this.qdl = i9;
            this.ud = i10;
            qdl(i9, i10);
        }
    }

    public static class ud {
        private qdl qdl;

        public void qdl(Activity activity) {
            Window window;
            if (this.qdl == null || activity == null || (window = activity.getWindow()) == null) {
                return;
            }
            window.getDecorView().removeOnLayoutChangeListener(this.qdl);
            this.qdl = null;
        }

        public void qdl(final Activity activity, final int i, final float f, final boolean z) {
            if (this.qdl != null) {
                return;
            }
            try {
                boolean z2 = true;
                if (com.bytedance.sdk.openadsdk.core.yt.mml().yh() != 1) {
                    z2 = false;
                }
                final boolean z3 = z2;
                final boolean zLnr = ax.lnr(activity);
                if (zLnr || z3) {
                    this.qdl = new qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.rq.ud.1
                        boolean qdl;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super();
                        }

                        @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.rq.qdl
                        void qdl(int i2, int i3) {
                            if (z) {
                                ud();
                            } else {
                                qdl();
                            }
                        }

                        /* JADX WARN: Removed duplicated region for block: B:28:0x00a7 A[Catch: all -> 0x00c4, TryCatch #0 {all -> 0x00c4, blocks: (B:2:0x0000, B:4:0x0005, B:6:0x0013, B:8:0x0046, B:10:0x005e, B:12:0x0067, B:14:0x0075, B:15:0x0079, B:26:0x00a1, B:28:0x00a7, B:29:0x00ac, B:31:0x00b4, B:16:0x007c, B:18:0x0080, B:20:0x008e, B:22:0x0092, B:23:0x0098, B:25:0x009c, B:33:0x00ba, B:35:0x00be, B:7:0x002d), top: B:38:0x0000 }] */
                        /* JADX WARN: Removed duplicated region for block: B:31:0x00b4 A[Catch: all -> 0x00c4, TryCatch #0 {all -> 0x00c4, blocks: (B:2:0x0000, B:4:0x0005, B:6:0x0013, B:8:0x0046, B:10:0x005e, B:12:0x0067, B:14:0x0075, B:15:0x0079, B:26:0x00a1, B:28:0x00a7, B:29:0x00ac, B:31:0x00b4, B:16:0x007c, B:18:0x0080, B:20:0x008e, B:22:0x0092, B:23:0x0098, B:25:0x009c, B:33:0x00ba, B:35:0x00be, B:7:0x002d), top: B:38:0x0000 }] */
                        /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        private void qdl() {
                            /*
                                r8 = this;
                                int r0 = r3     // Catch: java.lang.Throwable -> Lc4
                                r1 = 2
                                if (r0 != r1) goto L2d
                                android.app.Activity r0 = r4     // Catch: java.lang.Throwable -> Lc4
                                android.content.res.Resources r0 = r0.getResources()     // Catch: java.lang.Throwable -> Lc4
                                android.content.res.Configuration r0 = r0.getConfiguration()     // Catch: java.lang.Throwable -> Lc4
                                int r0 = r0.orientation     // Catch: java.lang.Throwable -> Lc4
                                if (r0 != r1) goto L2d
                                android.app.Activity r0 = r4     // Catch: java.lang.Throwable -> Lc4
                                android.view.Window r0 = r0.getWindow()     // Catch: java.lang.Throwable -> Lc4
                                android.view.View r0 = r0.getDecorView()     // Catch: java.lang.Throwable -> Lc4
                                int r0 = r0.getWidth()     // Catch: java.lang.Throwable -> Lc4
                                android.app.Activity r2 = r4     // Catch: java.lang.Throwable -> Lc4
                                int r2 = com.bytedance.sdk.openadsdk.utils.ax.exu(r2)     // Catch: java.lang.Throwable -> Lc4
                                int r2 = r2 - r0
                                int r0 = java.lang.Math.abs(r2)     // Catch: java.lang.Throwable -> Lc4
                                goto L46
                            L2d:
                                android.app.Activity r0 = r4     // Catch: java.lang.Throwable -> Lc4
                                android.view.Window r0 = r0.getWindow()     // Catch: java.lang.Throwable -> Lc4
                                android.view.View r0 = r0.getDecorView()     // Catch: java.lang.Throwable -> Lc4
                                int r0 = r0.getHeight()     // Catch: java.lang.Throwable -> Lc4
                                android.app.Activity r2 = r4     // Catch: java.lang.Throwable -> Lc4
                                int r2 = com.bytedance.sdk.openadsdk.utils.ax.fs(r2)     // Catch: java.lang.Throwable -> Lc4
                                int r2 = r2 - r0
                                int r0 = java.lang.Math.abs(r2)     // Catch: java.lang.Throwable -> Lc4
                            L46:
                                android.app.Activity r2 = r4     // Catch: java.lang.Throwable -> Lc4
                                android.view.Window r2 = r2.getWindow()     // Catch: java.lang.Throwable -> Lc4
                                android.view.View r2 = r2.getDecorView()     // Catch: java.lang.Throwable -> Lc4
                                int r3 = r2.getPaddingLeft()     // Catch: java.lang.Throwable -> Lc4
                                int r4 = r2.getPaddingRight()     // Catch: java.lang.Throwable -> Lc4
                                int r5 = r2.getPaddingBottom()     // Catch: java.lang.Throwable -> Lc4
                                if (r0 != 0) goto Lba
                                int r0 = r2.getPaddingTop()     // Catch: java.lang.Throwable -> Lc4
                                int r6 = r3     // Catch: java.lang.Throwable -> Lc4
                                r7 = 1
                                if (r6 != r7) goto L7c
                                android.app.Activity r6 = r4     // Catch: java.lang.Throwable -> Lc4
                                android.content.res.Resources r6 = r6.getResources()     // Catch: java.lang.Throwable -> Lc4
                                android.content.res.Configuration r6 = r6.getConfiguration()     // Catch: java.lang.Throwable -> Lc4
                                int r6 = r6.orientation     // Catch: java.lang.Throwable -> Lc4
                                if (r6 != r7) goto L7c
                                float r1 = com.bytedance.sdk.openadsdk.utils.ax.qdl()     // Catch: java.lang.Throwable -> Lc4
                            L79:
                                int r1 = (int) r1     // Catch: java.lang.Throwable -> Lc4
                                int r0 = r0 + r1
                                goto La1
                            L7c:
                                int r6 = r3     // Catch: java.lang.Throwable -> Lc4
                                if (r6 != r1) goto La1
                                android.app.Activity r6 = r4     // Catch: java.lang.Throwable -> Lc4
                                android.content.res.Resources r6 = r6.getResources()     // Catch: java.lang.Throwable -> Lc4
                                android.content.res.Configuration r6 = r6.getConfiguration()     // Catch: java.lang.Throwable -> Lc4
                                int r6 = r6.orientation     // Catch: java.lang.Throwable -> Lc4
                                if (r6 != r1) goto La1
                                boolean r1 = r5     // Catch: java.lang.Throwable -> Lc4
                                if (r1 == 0) goto L98
                                float r1 = com.bytedance.sdk.openadsdk.utils.ax.qdl()     // Catch: java.lang.Throwable -> Lc4
                                int r1 = (int) r1     // Catch: java.lang.Throwable -> Lc4
                                int r3 = r3 + r1
                            L98:
                                boolean r1 = r6     // Catch: java.lang.Throwable -> Lc4
                                if (r1 == 0) goto La1
                                float r1 = com.bytedance.sdk.openadsdk.utils.ax.qdl()     // Catch: java.lang.Throwable -> Lc4
                                goto L79
                            La1:
                                boolean r1 = r2.isAttachedToWindow()     // Catch: java.lang.Throwable -> Lc4
                                if (r1 == 0) goto Lac
                                r2.setPadding(r3, r0, r4, r5)     // Catch: java.lang.Throwable -> Lc4
                                r8.qdl = r7     // Catch: java.lang.Throwable -> Lc4
                            Lac:
                                float r0 = r7     // Catch: java.lang.Throwable -> Lc4
                                r1 = 1120403456(0x42c80000, float:100.0)
                                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                                if (r0 != 0) goto Lb9
                                r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                r2.setBackgroundColor(r0)     // Catch: java.lang.Throwable -> Lc4
                            Lb9:
                                return
                            Lba:
                                boolean r0 = r8.qdl     // Catch: java.lang.Throwable -> Lc4
                                if (r0 == 0) goto Lc4
                                r0 = 0
                                r2.setPadding(r3, r0, r4, r5)     // Catch: java.lang.Throwable -> Lc4
                                r8.qdl = r0     // Catch: java.lang.Throwable -> Lc4
                            Lc4:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.qdl.rq.ud.AnonymousClass1.qdl():void");
                        }

                        private void ud() {
                            try {
                                int iLnr = rq.lnr(activity, i);
                                View decorView = activity.getWindow().getDecorView();
                                if (iLnr == 0) {
                                    int[] iArrUd = rq.ud(activity, decorView, i, zLnr, z3);
                                    if (iArrUd[4] == 1) {
                                        this.qdl = rq.ud(decorView, iArrUd[0], iArrUd[1], iArrUd[2], iArrUd[3], f);
                                    }
                                } else if (this.qdl) {
                                    decorView.setPadding(decorView.getPaddingLeft(), 0, decorView.getPaddingRight(), decorView.getPaddingBottom());
                                    this.qdl = false;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    };
                    activity.getWindow().getDecorView().addOnLayoutChangeListener(this.qdl);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lnr(Activity activity, int i) {
        int i2 = activity.getResources().getConfiguration().orientation;
        View decorView = activity.getWindow().getDecorView();
        if (qdl(i, i2)) {
            return Math.abs(ax.exu(activity) - decorView.getWidth());
        }
        return Math.abs(ax.fs(activity) - decorView.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ud(View view, int i, int i2, int i3, int i4, float f) {
        if (!view.isAttachedToWindow()) {
            return false;
        }
        view.setPadding(i, i2, i3, i4);
        if (f != 100.0f) {
            return true;
        }
        view.setBackgroundColor(-16777216);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] ud(Activity activity, View view, int i, boolean z, boolean z2) {
        int paddingLeft;
        int paddingBottom;
        int paddingTop;
        int paddingRight;
        float fQdl;
        int[] iArr = new int[5];
        int i2 = 1;
        int i3 = 0;
        if (activity == null || view == null) {
            if (view != null) {
                paddingLeft = view.getPaddingLeft();
                paddingTop = view.getPaddingTop();
                paddingRight = view.getPaddingRight();
                paddingBottom = view.getPaddingBottom();
            } else {
                paddingLeft = 0;
                paddingBottom = 0;
                paddingTop = 0;
                paddingRight = 0;
            }
            iArr[0] = paddingLeft;
            iArr[1] = paddingTop;
            iArr[2] = paddingRight;
            iArr[3] = paddingBottom;
            iArr[4] = 0;
            return iArr;
        }
        int i4 = activity.getResources().getConfiguration().orientation;
        int paddingLeft2 = view.getPaddingLeft();
        int paddingTop2 = view.getPaddingTop();
        int paddingRight2 = view.getPaddingRight();
        int paddingBottom2 = view.getPaddingBottom();
        if (i != 1) {
            if (i == 2) {
                if (i4 == 2) {
                    if (z) {
                        paddingLeft2 += (int) ax.qdl();
                        i3 = 1;
                    }
                    if (z2) {
                        fQdl = ax.qdl();
                        paddingTop2 += (int) fQdl;
                    }
                } else {
                    paddingTop2 += (int) ax.qdl();
                }
            }
            i2 = i3;
        } else if (i4 == 1) {
            fQdl = ax.qdl();
            paddingTop2 += (int) fQdl;
        } else {
            paddingLeft2 += (int) ax.qdl();
            i2 = i3;
        }
        return new int[]{paddingLeft2, paddingTop2, paddingRight2, paddingBottom2, i2};
    }
}
