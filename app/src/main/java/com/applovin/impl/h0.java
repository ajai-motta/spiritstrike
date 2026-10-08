package com.applovin.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.View;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f399a;
    private final com.applovin.impl.sdk.o b;
    private final long c;
    private final long d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private int k;
    private int l;
    private Integer m;
    private volatile boolean n;
    private volatile boolean o;
    private Handler p;
    private HandlerThread q;
    private c s;
    private WeakReference j = new WeakReference(null);
    private final Runnable r = new Runnable() { // from class: com.applovin.impl.h0$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.a();
        }
    };

    class b implements PixelCopy.OnPixelCopyFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f401a;
        final /* synthetic */ Bitmap b;

        b(d dVar, Bitmap bitmap) {
            this.f401a = dVar;
            this.b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            if (i == 0) {
                this.f401a.a(this.b);
                return;
            }
            com.applovin.impl.sdk.o unused = h0.this.b;
            if (com.applovin.impl.sdk.o.a()) {
                h0.this.b.b("BlackViewDetector", "Failed to capture screenshot with error code: " + i);
            }
            this.f401a.a(true);
        }
    }

    public interface c {
        void a(int i, int i2);

        void a(int i, int i2, int i3);
    }

    private interface d {
        void a(Bitmap bitmap);

        void a(boolean z);
    }

    public h0(com.applovin.impl.sdk.k kVar) {
        this.f399a = kVar;
        this.b = kVar.O();
        this.c = ((Long) kVar.a(y4.k6)).longValue();
        this.d = ((Long) kVar.a(y4.j6)).longValue();
        this.g = ((Integer) kVar.a(y4.l6)).intValue();
        this.h = ((Integer) kVar.a(y4.m6)).intValue();
        this.i = ((Integer) kVar.a(y4.n6)).intValue();
        this.e = ((Integer) kVar.a(y4.t6)).intValue();
        this.f = ((Integer) kVar.a(y4.u6)).intValue();
    }

    static /* synthetic */ int a(h0 h0Var) {
        int i = h0Var.l;
        h0Var.l = i + 1;
        return i;
    }

    static /* synthetic */ int f(h0 h0Var) {
        int i = h0Var.k;
        h0Var.k = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.k = 0;
        this.m = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.j.get() != null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.a("BlackViewDetector", "Stopped monitoring view: " + this.j.get());
            }
            this.j.clear();
        }
        Handler handler = this.p;
        if (handler != null) {
            handler.removeCallbacks(this.r);
            this.p = null;
        }
        if (this.s != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.h0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.f();
                }
            });
        }
    }

    private void c() {
        if (this.k >= this.f && !this.o) {
            this.o = true;
            h();
        }
        if (this.k < this.e || this.n) {
            return;
        }
        this.n = true;
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        c cVar = this.s;
        if (cVar != null) {
            cVar.a(this.e, this.k, this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        c cVar = this.s;
        if (cVar != null) {
            cVar.a(this.k, this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.s = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.c <= 0) {
            if (this.k == 1) {
                if (!this.o) {
                    this.o = true;
                    h();
                }
                if (!this.n) {
                    this.n = true;
                    i();
                }
            }
            k();
            return;
        }
        c();
        if (this.p == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.k("BlackViewDetector", "Monitoring handler was unexpectedly null");
            }
            k();
        } else if (this.n && this.o) {
            k();
        } else {
            this.p.postDelayed(this.r, this.c);
        }
    }

    private void h() {
        View view = (View) this.j.get();
        if (com.applovin.impl.sdk.o.a()) {
            this.b.k("BlackViewDetector", "Notifying black view confirmed: " + view);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.h0$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        });
    }

    private void i() {
        View view = (View) this.j.get();
        if (com.applovin.impl.sdk.o.a()) {
            this.b.k("BlackViewDetector", "Notifying black view detected: " + view);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.h0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    public void b() {
        k();
        HandlerThread handlerThread = this.q;
        if (handlerThread != null) {
            handlerThread.quit();
            this.q = null;
        }
    }

    public void a(View view, c cVar) {
        if (((Boolean) this.f399a.a(y4.i6)).booleanValue()) {
            View view2 = (View) this.j.get();
            if (view2 != null) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.k("BlackViewDetector", "Monitoring is already in progress for a view: " + view2);
                    return;
                }
                return;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.b.a("BlackViewDetector", "Started monitoring view: " + view);
            }
            try {
                if (this.q == null) {
                    HandlerThread handlerThread = new HandlerThread("AppLovinSdk:black_view_detector");
                    this.q = handlerThread;
                    handlerThread.start();
                } else {
                    this.f399a.D().a(d2.L0, "BlackViewDetector:maybeStartMonitoring() unexpectedly called multiple times");
                    k();
                }
                this.s = cVar;
                this.j = new WeakReference(view);
                j();
                this.n = false;
                this.o = false;
                Handler handler = new Handler(this.q.getLooper());
                this.p = handler;
                handler.postDelayed(this.r, this.d);
            } catch (Throwable th) {
                k();
                this.f399a.D().a("BlackViewDetector", "maybeStartMonitoring", th);
            }
        }
    }

    class a implements d {
        a() {
        }

        @Override // com.applovin.impl.h0.d
        public void a(Bitmap bitmap) {
            try {
                h0.a(h0.this);
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i = width / h0.this.g;
                int i2 = height / h0.this.g;
                int i3 = i / 2;
                for (int i4 = i2 / 2; i4 < height; i4 += i2) {
                    for (int i5 = i3; i5 < width; i5 += i) {
                        int pixel = bitmap.getPixel(i5, i4);
                        if (h0.this.a(pixel)) {
                            bitmap.recycle();
                            h0.this.j();
                            h0.this.g();
                            return;
                        }
                        if (h0.this.m == null) {
                            h0.this.m = Integer.valueOf(pixel);
                        }
                    }
                }
                h0.f(h0.this);
                bitmap.recycle();
                h0.this.g();
            } catch (Exception e) {
                h0.this.f399a.D().a("BlackViewDetector", "onScreenshotCaptured", e);
                h0.this.k();
            }
        }

        @Override // com.applovin.impl.h0.d
        public void a(boolean z) {
            if (z) {
                h0.this.k();
            } else {
                h0.this.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ActivityManager.MemoryInfo memoryInfoA;
        View view = (View) this.j.get();
        if (view == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.k("BlackViewDetector", "Monitored view no longer exists.");
            }
            k();
            return;
        }
        Long l = (Long) this.f399a.a(y4.r6);
        if (l.longValue() > 0 && (memoryInfoA = o7.a((ActivityManager) com.applovin.impl.sdk.k.o().getSystemService("activity"))) != null && memoryInfoA.availMem < l.longValue()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.k("BlackViewDetector", "Cancelling black view detection due to low memory");
                return;
            }
            return;
        }
        if (this.f399a.n0().isApplicationPaused()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.a("BlackViewDetector", "App is backgrounded - skipping black view detection");
            }
            j();
            g();
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("BlackViewDetector", "Checking for black view: " + view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth != 0 && measuredHeight != 0) {
            a(view, new a());
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.b.k("BlackViewDetector", "Monitored view is not visible due to dimensions (width = " + measuredWidth + ", height = " + measuredHeight + ")");
        }
        j();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r9) {
        /*
            r8 = this;
            int r0 = android.graphics.Color.red(r9)
            int r1 = android.graphics.Color.green(r9)
            int r9 = android.graphics.Color.blue(r9)
            java.lang.Integer r2 = r8.m
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L4e
            int r2 = r2.intValue()
            int r2 = android.graphics.Color.red(r2)
            java.lang.Integer r5 = r8.m
            int r5 = r5.intValue()
            int r5 = android.graphics.Color.green(r5)
            java.lang.Integer r6 = r8.m
            int r6 = r6.intValue()
            int r6 = android.graphics.Color.blue(r6)
            int r2 = r0 - r2
            int r2 = java.lang.Math.abs(r2)
            int r7 = r8.i
            if (r2 > r7) goto L4c
            int r2 = r1 - r5
            int r2 = java.lang.Math.abs(r2)
            int r5 = r8.i
            if (r2 > r5) goto L4c
            int r2 = r9 - r6
            int r2 = java.lang.Math.abs(r2)
            int r5 = r8.i
            if (r2 <= r5) goto L4e
        L4c:
            r2 = r3
            goto L4f
        L4e:
            r2 = r4
        L4f:
            int r5 = r8.h
            if (r0 > r5) goto L5b
            if (r1 > r5) goto L5b
            if (r9 > r5) goto L5b
            if (r2 == 0) goto L5a
            goto L5b
        L5a:
            r3 = r4
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.h0.a(int):boolean");
    }

    private void a(View view, d dVar) {
        if (o0.h()) {
            Activity activityA = this.f399a.e().a();
            if (activityA == null) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.b("BlackViewDetector", "Failed to capture screenshot due to no active activity");
                }
                dVar.a(false);
                return;
            }
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            Rect rect = new Rect(i, i2, i + measuredWidth, i2 + measuredHeight);
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                PixelCopy.request(activityA.getWindow(), rect, bitmapCreateBitmap, new b(dVar, bitmapCreateBitmap), new Handler());
                return;
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.b("BlackViewDetector", "Failed to capture screenshot due to exception: " + th);
                }
                dVar.a(true);
                return;
            }
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.b.k("BlackViewDetector", "Unable to capture screenshots on views below API 26");
        }
        dVar.a(true);
    }
}
