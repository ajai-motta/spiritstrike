package com.tnkfactory.ad.pub;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tnkfactory.ad.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class v extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animation f3205a;
    public Animation b;
    public k2 c;
    public final c d;
    public final u e;
    public boolean f;
    public long g;
    public final x1 h;
    public HashMap i;
    public boolean j;
    public x0 k;
    public final m l;
    public n m;
    public o n;

    public v(Context context, int i, int i2, c cVar, boolean z) {
        int i3;
        long j;
        int i4;
        long j2;
        View viewA;
        String str;
        super(context);
        this.f3205a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = 0L;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = null;
        this.l = new m(this, Looper.getMainLooper());
        this.m = null;
        this.n = null;
        try {
            x1 x1VarA = k1.a(context, i, i2, cVar.e0, cVar.d0, cVar.K, z, cVar);
            this.h = x1VarA;
            if (x1VarA == null) {
                this.j = false;
                return;
            }
            this.j = true;
            addView(x1VarA);
            this.d = cVar;
            Animation[] animationArrA = q0.a(cVar.O);
            this.f3205a = animationArrA[0];
            this.b = animationArrA[1];
            for (String str2 : cVar.g0.keySet()) {
                e1 e1Var = (e1) cVar.g0.get(str2);
                x1 x1Var = this.h;
                if (e1Var == null) {
                    x1Var.getClass();
                } else {
                    View viewA2 = x1Var.a(str2);
                    Bitmap bitmap = e1Var.f3124a;
                    if (!(viewA2 instanceof ImageView)) {
                        e1Var.a(viewA2);
                    } else if (bitmap != null) {
                        ImageView imageView = (ImageView) viewA2;
                        if (imageView.getScaleType() != ImageView.ScaleType.MATRIX) {
                            str = str2;
                        } else {
                            double width = ((double) bitmap.getWidth()) / ((double) bitmap.getHeight());
                            str = str2;
                            double d = ((double) imageView.getLayoutParams().width) / ((double) imageView.getLayoutParams().height);
                            if (d <= 1.0d) {
                                if (width > d) {
                                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                } else {
                                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                }
                            } else if (width > d) {
                                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            } else {
                                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            }
                        }
                        imageView.setImageBitmap(bitmap);
                        str2 = str;
                        if (h1.a("c77c089be85694").equals(str2)) {
                            ArrayList arrayList = x1Var.f3219a;
                            if (arrayList != null && arrayList.size() > 0) {
                                int iA = n2.a(bitmap, 2);
                                Iterator it = x1Var.f3219a.iterator();
                                while (it.hasNext()) {
                                    View viewA3 = x1Var.a((String) it.next());
                                    if (viewA3 != null) {
                                        viewA3.setBackgroundColor(iA);
                                    }
                                }
                            }
                            ArrayList arrayList2 = x1Var.b;
                            if (arrayList2 != null && arrayList2.size() > 0) {
                                int iA2 = n2.a(bitmap, 3);
                                Iterator it2 = x1Var.b.iterator();
                                while (it2.hasNext()) {
                                    View viewA4 = x1Var.a((String) it2.next());
                                    if (viewA4 != null) {
                                        viewA4.setBackgroundColor(iA2);
                                    }
                                }
                            }
                            ArrayList arrayList3 = x1Var.c;
                            if (arrayList3 != null && arrayList3.size() > 0) {
                                int iA3 = n2.a(bitmap, 0);
                                Iterator it3 = x1Var.c.iterator();
                                while (it3.hasNext()) {
                                    View viewA5 = x1Var.a((String) it3.next());
                                    if (viewA5 != null) {
                                        viewA5.setBackgroundColor(iA3);
                                    }
                                }
                            }
                            ArrayList arrayList4 = x1Var.d;
                            if (arrayList4 != null && arrayList4.size() > 0) {
                                int iA4 = n2.a(bitmap, 1);
                                Iterator it4 = x1Var.d.iterator();
                                while (it4.hasNext()) {
                                    View viewA6 = x1Var.a((String) it4.next());
                                    if (viewA6 != null) {
                                        viewA6.setBackgroundColor(iA4);
                                    }
                                }
                            }
                        }
                    }
                }
                if (str2.equals(h1.a("c77c089be85694")) && e1Var != null) {
                    Bitmap bitmap2 = e1Var.f3124a;
                }
            }
            if (cVar.h0 != null) {
                int i5 = cVar.h;
                if (i5 == 4) {
                    viewA = this.h.a(h1.a("c77c0982e45d"));
                } else if (i5 == 5) {
                    viewA = this.h.a(h1.a("c77c0c84e85895"));
                } else {
                    Logger.e("can't find webview");
                    viewA = null;
                }
                if (viewA instanceof ViewGroup) {
                    cVar.h0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    ((ViewGroup) viewA).addView(cVar.h0);
                    if (cVar.i0 >= 3) {
                        cVar.h0.loadDataWithBaseURL(cVar.q, cVar.k, "text/html", "utf-8", null);
                    }
                }
            }
            if (cVar.o != null) {
                View viewA7 = this.h.a(h1.a("c77c179fed549e"));
                i5 i5Var = viewA7 instanceof i5 ? (i5) viewA7 : null;
                if (i5Var != null) {
                    i5Var.setAdData(cVar);
                    i5Var.setAutoStart(cVar.E == 1);
                    i5Var.setMediaPath(cVar.o);
                    if (cVar.Z == 1) {
                        this.f = true;
                        i5Var.B = true;
                    }
                    if (cVar.F == 1) {
                        i5Var.setMuteOnStart(true);
                    }
                }
            }
            if (cVar.p != null) {
                View viewA8 = this.h.a(h1.a("c77c1899fc458469f6"));
                if (viewA8 instanceof a6) {
                    a6 a6Var = (a6) viewA8;
                    a6Var.setAutoStart(cVar.E == 1);
                    a6Var.setYoutubeId(cVar.p);
                }
            }
            x1 x1Var2 = this.h;
            ArrayList arrayList5 = x1Var2.h;
            ArrayList arrayList6 = x1Var2.i;
            if ((!arrayList5.isEmpty() || !arrayList6.isEmpty()) && (i3 = this.d.W) > 0) {
                this.l.sendEmptyMessage(i3);
            }
            if (cVar.v > 0.0f) {
                View viewA9 = this.h.a(h1.a("c77c1397fd589f6c"));
                if (viewA9 instanceof n4) {
                    ((n4) viewA9).setRating(cVar.v);
                } else if (viewA9 instanceof TextView) {
                    ((TextView) viewA9).setText(String.valueOf(cVar.v));
                }
                View viewA10 = this.h.a(h1.a("c86d0c84e8459865f4"));
                if (viewA10 instanceof TextView) {
                    ((TextView) viewA10).setText(String.valueOf(cVar.v));
                } else if (viewA10 instanceof n4) {
                    ((n4) viewA10).setRating(cVar.v);
                }
            }
            a(cVar.s, h1.a("c77c159ffd5d94"));
            a(cVar.s, h1.a("c77c159ffd5d9439"));
            a(cVar.t, h1.a("c77c0593fa52"));
            a(cVar.u, h1.a("c77c0593fa52c3"));
            a(cVar.y, h1.a("c77c0282e8"));
            a(cVar.y, h1.a("c77c0282e803"));
            String str3 = cVar.l0;
            if (str3 != null) {
                x1 x1Var3 = this.h;
                String[] strArrSplit = str3.split(":");
                if (strArrSplit.length == 0) {
                    j2 = 0;
                    x1Var3.a(j2);
                } else {
                    if (strArrSplit.length == 3) {
                        int iIndexOf = strArrSplit[2].indexOf(".");
                        if (iIndexOf != -1) {
                            strArrSplit[2] = strArrSplit[2].substring(0, iIndexOf);
                        }
                        j = ((long) (Integer.parseInt(strArrSplit[0]) * 3600)) + ((long) (Integer.parseInt(strArrSplit[1]) * 60));
                        i4 = Integer.parseInt(strArrSplit[2]);
                    } else {
                        if (strArrSplit.length == 2) {
                            j = Integer.parseInt(strArrSplit[0]) * 60;
                            i4 = Integer.parseInt(strArrSplit[1]);
                        }
                        j2 = 0;
                        x1Var3.a(j2);
                    }
                    j2 = j + ((long) i4);
                    x1Var3.a(j2);
                }
            }
            u uVar = new u(this);
            this.e = uVar;
            x1 x1Var4 = this.h;
            x1Var4.j = uVar;
            Iterator it5 = n2.a(x1Var4, l0.class).iterator();
            while (it5.hasNext()) {
                ((l0) it5.next()).setHandler(x1Var4.j);
            }
            Iterator it6 = n2.a(x1Var4, w2.class).iterator();
            while (it6.hasNext()) {
                ((w2) it6.next()).setHandler(x1Var4.j);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.j = false;
        }
    }

    public static void a(View view, int i) {
        TextView textView;
        if (view instanceof TextView) {
            if (view.getTag() == null) {
                view.setTag(((TextView) view).getText());
            }
            ((TextView) view).setText(String.valueOf(i));
        } else {
            if (view.getTag() == null) {
                textView = new TextView(view.getContext());
                ((ViewGroup) view.getParent()).addView(textView);
                view.setTag(textView);
            } else {
                textView = (TextView) view.getTag();
            }
            textView.setX(view.getX());
            textView.setY(view.getY());
            textView.setWidth(view.getWidth());
            textView.setHeight(view.getHeight());
            textView.setTextColor(Color.argb(255, 255, 255, 255));
            textView.setBackgroundResource(R.drawable.btn_close_timer);
            textView.setGravity(17);
            textView.setIncludeFontPadding(false);
            textView.setTextSize((view.getHeight() / Resources.getSystem().getDisplayMetrics().density) / 2.0f);
            textView.setText("" + i);
            view.setVisibility(4);
        }
        view.setClickable(false);
    }

    public abstract void a(int i, boolean z);

    public void b() {
    }

    public final void c() {
        if (this.m != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.m);
            this.m = null;
        }
        if (this.n != null) {
            getViewTreeObserver().removeOnScrollChangedListener(this.n);
            this.n = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x006d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tnkfactory.ad.pub.v.d():void");
    }

    public final void e() {
        setFocusableInTouchMode(true);
        setFocusable(true);
        Animation animation = this.f3205a;
        if (animation != null) {
            postDelayed(new p(this), animation.getDuration());
            startAnimation(this.f3205a);
        } else {
            if (this.d.M != 4) {
                requestFocus();
            }
            b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.m == null) {
            this.m = new n(this);
            getViewTreeObserver().addOnGlobalLayoutListener(this.m);
        }
        if (this.n == null) {
            this.n = new o(this);
            try {
                z1 z1Var = this.d.j0;
                if (z1Var != null && !z1Var.c.isEmpty()) {
                    k4 k4VarA = k4.a();
                    ArrayList arrayList = this.d.j0.c;
                    k4VarA.getClass();
                    k4.a(arrayList);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            getViewTreeObserver().addOnScrollChangedListener(this.n);
        }
        postDelayed(new Runnable() { // from class: com.tnkfactory.ad.pub.v$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        }, 100L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public final /* synthetic */ void a() {
        if (!n2.a((View) this, true) || this.m == null || this.n == null) {
            return;
        }
        c();
        d();
    }

    public final void a(String str, int i) {
        if (str == null) {
            Logger.e("error #2103");
            return;
        }
        this.d.j = str;
        if (this.g == 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.g;
        c cVar = this.d;
        if (jCurrentTimeMillis < cVar.R) {
            return;
        }
        if (this.k != null) {
            TextView textView = new TextView(getContext());
            textView.setOnClickListener(new s(this, i));
            x0 x0Var = this.k;
            b1 b1Var = x0Var.b;
            Context context = textView.getContext();
            c cVar2 = x0Var.b.e;
            b1Var.getClass();
            x0Var.b.f.addView(b1.a(context, textView), x0Var.f3218a);
            return;
        }
        c0.a(getContext(), c0.a(cVar.d, cVar.j, cVar.g, i, this.i), true);
        if (this.d.C != null) {
            new o4(this.d.C).start();
        }
        k2 k2Var = this.c;
        if (k2Var != null) {
            k2Var.a();
        }
    }

    public final void a(String str, String str2) {
        if (str != null) {
            View viewA = this.h.a(str2);
            if (viewA instanceof TextView) {
                ((TextView) viewA).setText(str);
            }
        }
    }
}
