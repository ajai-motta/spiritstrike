package com.tnkfactory.ad.pub;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.NativeAdItem;
import com.tnkfactory.ad.NativeViewBinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class i3 extends c1 {
    public static final String n = String.valueOf(System.currentTimeMillis());
    public static final WeakHashMap o = new WeakHashMap();
    public final NativeAdItem f;
    public long g;
    public b3 h;
    public c3 i;
    public d3 j;
    public ViewGroup k;
    public NativeViewBinder l;
    public final a3 m;

    public i3(AdItem adItem, String str) {
        super(str);
        this.g = 0L;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = new a3(this);
        this.f = (NativeAdItem) adItem;
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void a(Context context, boolean z) {
        if (!e()) {
            a(this.f, AdError.FAIL_NO_PLACEMENT_ID);
            return;
        }
        if (this.d != 0) {
            a(this.f, AdError.FAIL_DUP_LOAD);
            return;
        }
        this.d = 1;
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            b3 b3Var = this.h;
            if (b3Var != null) {
                viewGroup.removeOnLayoutChangeListener(b3Var);
                this.h = null;
            }
            b(this.k);
        }
        new x2(context).a(this.f3115a, 2, z, new y2(this));
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        if (this.i != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.i);
            this.i = null;
        }
        if (this.j != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.j);
            this.j = null;
        }
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void c(Context context) {
        c cVar = this.e;
        String str = cVar.e;
        if (!cVar.D) {
            cVar.D = true;
            String strA = h1.a("d66d03d8e0");
            String strA2 = h1.a("d66a0e95ec428242fe6f76462dea3cbf84");
            Object[] objArr = {cVar.c, cVar.g};
            a0 a0Var = cVar.p0;
            ArrayList arrayList = cVar.B;
            s0 s0Var = new s0(context, str, strA, strA2, objArr, a0Var);
            s0Var.i = arrayList;
            s0Var.start();
        }
        this.g = System.currentTimeMillis();
    }

    public final void j() {
        View viewFindViewWithTag;
        View viewFindViewById;
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            b3 b3Var = this.h;
            if (b3Var != null) {
                viewGroup.removeOnLayoutChangeListener(b3Var);
                this.h = null;
            }
            b(this.k);
        }
        NativeViewBinder nativeViewBinder = this.l;
        if (nativeViewBinder != null) {
            if (nativeViewBinder.f3101a) {
                View viewFindViewById2 = this.k.findViewById(nativeViewBinder.l);
                if (viewFindViewById2 instanceof TextView) {
                    ((TextView) viewFindViewById2).setText("");
                }
            }
            NativeViewBinder nativeViewBinder2 = this.l;
            if (nativeViewBinder2.b) {
                View viewFindViewById3 = this.k.findViewById(nativeViewBinder2.m);
                if (viewFindViewById3 instanceof TextView) {
                    ((TextView) viewFindViewById3).setText("");
                }
            }
            NativeViewBinder nativeViewBinder3 = this.l;
            if (nativeViewBinder3.g) {
                View viewFindViewById4 = this.k.findViewById(nativeViewBinder3.r);
                if (viewFindViewById4 instanceof TextView) {
                    ((TextView) viewFindViewById4).setText("");
                }
            }
            NativeViewBinder nativeViewBinder4 = this.l;
            if (nativeViewBinder4.c) {
                View viewFindViewById5 = this.k.findViewById(nativeViewBinder4.n);
                if (viewFindViewById5 instanceof ImageView) {
                    ((ImageView) viewFindViewById5).setImageBitmap(null);
                }
            }
            NativeViewBinder nativeViewBinder5 = this.l;
            if (nativeViewBinder5.e) {
                View viewFindViewById6 = this.k.findViewById(nativeViewBinder5.p);
                if (viewFindViewById6 instanceof TextView) {
                    ((TextView) viewFindViewById6).setText("");
                }
            }
            NativeViewBinder nativeViewBinder6 = this.l;
            if (nativeViewBinder6.f) {
                View viewFindViewById7 = this.k.findViewById(nativeViewBinder6.q);
                if (viewFindViewById7 instanceof ImageView) {
                    ((ImageView) viewFindViewById7).setImageBitmap(null);
                }
            }
            NativeViewBinder nativeViewBinder7 = this.l;
            if (nativeViewBinder7.i) {
                View viewFindViewById8 = this.k.findViewById(nativeViewBinder7.t);
                if (viewFindViewById8 instanceof TextView) {
                    ((TextView) viewFindViewById8).setText("");
                }
            }
            NativeViewBinder nativeViewBinder8 = this.l;
            if (nativeViewBinder8.h) {
                View viewFindViewById9 = this.k.findViewById(nativeViewBinder8.s);
                if (viewFindViewById9 instanceof ImageView) {
                    ((ImageView) viewFindViewById9).setImageBitmap(null);
                    viewFindViewById9.setOnClickListener(null);
                }
            }
            if (this.e.v > 0.0f) {
                NativeViewBinder nativeViewBinder9 = this.l;
                if (nativeViewBinder9.j && (viewFindViewById = this.k.findViewById(nativeViewBinder9.u)) != null) {
                    viewFindViewById.setBackground(null);
                }
                NativeViewBinder nativeViewBinder10 = this.l;
                if (nativeViewBinder10.k) {
                    View viewFindViewById10 = this.k.findViewById(nativeViewBinder10.v);
                    if (viewFindViewById10 instanceof TextView) {
                        ((TextView) viewFindViewById10).setText("");
                    }
                }
            }
            View viewFindViewById11 = this.k.findViewById(this.l.o);
            if ((viewFindViewById11 instanceof ViewGroup) && (viewFindViewWithTag = viewFindViewById11.findViewWithTag(n)) != null) {
                ((ViewGroup) viewFindViewById11).removeView(viewFindViewWithTag);
            }
            Iterator it = this.l.C.iterator();
            while (it.hasNext()) {
                View viewFindViewById12 = this.k.findViewById(((Integer) it.next()).intValue());
                if (viewFindViewById12 != null) {
                    viewFindViewById12.setOnClickListener(null);
                }
            }
            this.l = null;
        }
        ViewGroup viewGroup2 = this.k;
        if (viewGroup2 != null) {
            o.remove(viewGroup2);
        }
        this.k = null;
    }

    public final void k() {
        ViewGroup viewGroup;
        b3 b3Var;
        if (this.d != 2 || (viewGroup = this.k) == null || this.g > 0 || (b3Var = this.h) != null) {
            return;
        }
        if (b3Var == null) {
            b3 b3Var2 = new b3(this);
            this.h = b3Var2;
            viewGroup.addOnLayoutChangeListener(b3Var2);
        }
        ViewGroup viewGroup2 = this.k;
        if (viewGroup2 == null) {
            return;
        }
        if (this.i == null) {
            this.i = new c3(this, viewGroup2);
            viewGroup2.getViewTreeObserver().addOnGlobalLayoutListener(this.i);
        }
        if (this.j == null) {
            this.j = new d3(this, viewGroup2);
            viewGroup2.getViewTreeObserver().addOnScrollChangedListener(this.j);
        }
    }

    public final boolean l() {
        ViewGroup viewGroup;
        NativeViewBinder nativeViewBinder;
        View viewFindViewById;
        if (this.d != 2 || (viewGroup = this.k) == null || (nativeViewBinder = this.l) == null || !nativeViewBinder.d) {
            return false;
        }
        if (nativeViewBinder.f3101a) {
            View viewFindViewById2 = viewGroup.findViewById(nativeViewBinder.l);
            if (viewFindViewById2 instanceof TextView) {
                ((TextView) viewFindViewById2).setText(this.e.s);
            }
        }
        NativeViewBinder nativeViewBinder2 = this.l;
        if (nativeViewBinder2.b) {
            View viewFindViewById3 = this.k.findViewById(nativeViewBinder2.m);
            if (viewFindViewById3 instanceof TextView) {
                ((TextView) viewFindViewById3).setText(this.e.t);
            }
        }
        NativeViewBinder nativeViewBinder3 = this.l;
        if (nativeViewBinder3.g) {
            View viewFindViewById4 = this.k.findViewById(nativeViewBinder3.r);
            if (viewFindViewById4 instanceof TextView) {
                ((TextView) viewFindViewById4).setText(this.e.y);
            }
        }
        NativeViewBinder nativeViewBinder4 = this.l;
        View viewB = null;
        if (nativeViewBinder4.c) {
            View viewFindViewById5 = this.k.findViewById(nativeViewBinder4.n);
            if (viewFindViewById5 instanceof ImageView) {
                ImageView imageView = (ImageView) viewFindViewById5;
                e1 e1Var = (e1) this.e.g0.get(h1.a("c77c0895e65f"));
                imageView.setImageBitmap(e1Var != null ? e1Var.f3124a : null);
            }
        }
        NativeViewBinder nativeViewBinder5 = this.l;
        if (nativeViewBinder5.e) {
            View viewFindViewById6 = this.k.findViewById(nativeViewBinder5.p);
            if (viewFindViewById6 instanceof TextView) {
                ((TextView) viewFindViewById6).setText(this.e.x);
            }
        }
        NativeViewBinder nativeViewBinder6 = this.l;
        if (nativeViewBinder6.f) {
            View viewFindViewById7 = this.k.findViewById(nativeViewBinder6.q);
            if (viewFindViewById7 instanceof ImageView) {
                ImageView imageView2 = (ImageView) viewFindViewById7;
                e1 e1Var2 = (e1) this.e.g0.get(h1.a("c77c179ae6569e"));
                imageView2.setImageBitmap(e1Var2 != null ? e1Var2.f3124a : null);
            }
        }
        NativeViewBinder nativeViewBinder7 = this.l;
        if (nativeViewBinder7.i) {
            View viewFindViewById8 = this.k.findViewById(nativeViewBinder7.t);
            if (viewFindViewById8 instanceof TextView) {
                ((TextView) viewFindViewById8).setText(this.e.w);
            }
        }
        NativeViewBinder nativeViewBinder8 = this.l;
        if (nativeViewBinder8.h) {
            View viewFindViewById9 = this.k.findViewById(nativeViewBinder8.s);
            if (viewFindViewById9 instanceof ImageView) {
                ImageView imageView3 = (ImageView) viewFindViewById9;
                e1 e1Var3 = (e1) this.e.g0.get(h1.a("c77c0c97fb5a"));
                imageView3.setImageBitmap(e1Var3 != null ? e1Var3.f3124a : null);
                if (this.e.z != null) {
                    viewFindViewById9.setOnClickListener(new z2(this));
                }
            }
        }
        if (this.e.v > 0.0f) {
            NativeViewBinder nativeViewBinder9 = this.l;
            if (nativeViewBinder9.j && (viewFindViewById = this.k.findViewById(nativeViewBinder9.u)) != null) {
                NativeViewBinder nativeViewBinder10 = this.l;
                float f = this.e.v;
                float f2 = nativeViewBinder10.B;
                float f3 = nativeViewBinder10.A;
                float f4 = f / f2;
                if (f3 > 0.0f) {
                    f4 = ((int) (f4 / r7)) * (f3 / f2);
                }
                viewFindViewById.setBackground(new ShapeDrawable(new j1(f4, nativeViewBinder10.z, nativeViewBinder10.w, nativeViewBinder10.x, nativeViewBinder10.y)));
            }
            NativeViewBinder nativeViewBinder11 = this.l;
            if (nativeViewBinder11.k) {
                View viewFindViewById10 = this.k.findViewById(nativeViewBinder11.v);
                if (viewFindViewById10 instanceof TextView) {
                    ((TextView) viewFindViewById10).setText(String.valueOf(this.e.v));
                }
            }
        }
        View viewFindViewById11 = this.k.findViewById(this.l.o);
        if (viewFindViewById11 == null) {
            Logger.w(h1.a("e5770f82ec5f855dfa7a730337ea75be85ce431f2b50c68d5e"));
        } else if (viewFindViewById11 instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) viewFindViewById11;
            View viewFindViewWithTag = viewGroup2.findViewWithTag(n);
            if (viewFindViewWithTag != null) {
                viewGroup2.removeView(viewFindViewWithTag);
            }
            viewB = b(viewGroup2.getContext());
            viewGroup2.addView(viewB);
        } else {
            Logger.w(h1.a("e5770f82ec5f855dfa7a730337ea75be85ce43186473c18c0770a5710af5e8"));
        }
        if (viewB == null) {
            return false;
        }
        Iterator it = this.l.C.iterator();
        while (it.hasNext()) {
            View viewFindViewById12 = this.k.findViewById(((Integer) it.next()).intValue());
            if (viewFindViewById12 != null) {
                if (this.e.Y == 0) {
                    viewFindViewById12.setOnClickListener(this.m);
                } else {
                    viewFindViewById12.setOnTouchListener(new h3(this, viewFindViewById12));
                }
            }
        }
        return true;
    }

    public final void m() {
        if (this.g > 0 || this.d != 2 || this.k == null) {
            return;
        }
        this.g = System.currentTimeMillis();
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            b3 b3Var = this.h;
            if (b3Var != null) {
                viewGroup.removeOnLayoutChangeListener(b3Var);
                this.h = null;
            }
            b(this.k);
        }
        Context context = this.k.getContext();
        c cVar = this.e;
        String str = cVar.e;
        if (!cVar.D) {
            cVar.D = true;
            String strA = h1.a("d66d03d8e0");
            String strA2 = h1.a("d66a0e95ec428242fe6f76462dea3cbf84");
            Object[] objArr = {cVar.c, cVar.g};
            a0 a0Var = cVar.p0;
            ArrayList arrayList = cVar.B;
            s0 s0Var = new s0(context, str, strA, strA2, objArr, a0Var);
            s0Var.i = arrayList;
            s0Var.start();
        }
        NativeAdItem nativeAdItem = this.f;
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onShow(nativeAdItem);
        }
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final View b(Context context) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, 0);
        c cVar = this.e;
        int i = cVar.N;
        if (i == 1) {
            layoutParams2.dimensionRatio = "640:1320";
        } else if (i == 2) {
            layoutParams2.dimensionRatio = "1200:627";
        } else if (i == 3) {
            layoutParams2.dimensionRatio = "640:640";
        } else if (i == 170) {
            layoutParams2.dimensionRatio = "1200:627";
        } else if (i == 171) {
            layoutParams2.dimensionRatio = "627:627";
        } else if (i == 193) {
            layoutParams2.dimensionRatio = "320:480";
        } else if (i == 194) {
            layoutParams2.dimensionRatio = "480:320";
        } else if (i == 257) {
            layoutParams2.dimensionRatio = "640:960";
        } else if (i == 258) {
            layoutParams2.dimensionRatio = "960:640";
        } else if (i == 321) {
            layoutParams2.dimensionRatio = "768:1024";
        } else if (i == 322) {
            layoutParams2.dimensionRatio = "1024:768";
        } else if (i == 385) {
            layoutParams2.dimensionRatio = "720:1280";
        } else if (i == 386) {
            layoutParams2.dimensionRatio = "1280:720";
        } else if (i == 450) {
            layoutParams2.dimensionRatio = "300:250";
        } else if (i == 451) {
            layoutParams2.dimensionRatio = "200:200";
        } else {
            switch (i) {
                case 26:
                    layoutParams2.dimensionRatio = "720:100";
                    break;
                case 59:
                    layoutParams2.dimensionRatio = "50:50";
                    break;
                case 90:
                    layoutParams2.dimensionRatio = "640:200";
                    break;
                case 123:
                    layoutParams2.dimensionRatio = "80:80";
                    break;
                case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                    layoutParams2.dimensionRatio = "320:250";
                    break;
                case 154:
                    layoutParams2.dimensionRatio = "216:36";
                    break;
                case 187:
                    layoutParams2.dimensionRatio = "150:150";
                    break;
                case 196:
                    layoutParams2.dimensionRatio = "720:1280";
                    break;
                case 218:
                    layoutParams2.dimensionRatio = "300:50";
                    break;
                case 251:
                    layoutParams2.dimensionRatio = "240:240";
                    break;
                case 282:
                    layoutParams2.dimensionRatio = "320:50";
                    break;
                case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                    layoutParams2.dimensionRatio = "728:90";
                    break;
                case 474:
                    layoutParams2.dimensionRatio = "320:100";
                    break;
                default:
                    layoutParams2.dimensionRatio = "640:640";
                    layoutParams2.width = -1;
                    break;
            }
        }
        e1 e1Var = (e1) cVar.g0.get(h1.a("c77c089be85694"));
        Bitmap bitmap = e1Var != null ? e1Var.f3124a : null;
        if (bitmap != null) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(layoutParams2);
            imageView.setAdjustViewBounds(true);
            imageView.setImageBitmap(bitmap);
            constraintLayout.addView(imageView);
            return constraintLayout;
        }
        if (this.e.k == null) {
            return null;
        }
        l0 l0Var = new l0(context);
        l0Var.setLayoutParams(layoutParams2);
        l0Var.setHandler(new f3(l0Var.getContext(), this));
        c cVar2 = this.e;
        if (cVar2.j != null) {
            l0Var.c = true;
            l0Var.d.f3182a.b = new i0(l0Var);
        }
        l0Var.loadDataWithBaseURL(cVar2.q, cVar2.k, "text/html", "utf-8", null);
        constraintLayout.addView(l0Var);
        return constraintLayout;
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void a(ViewGroup viewGroup, NativeViewBinder nativeViewBinder) {
        if (viewGroup == null) {
            return;
        }
        WeakHashMap weakHashMap = o;
        i3 i3Var = (i3) weakHashMap.get(viewGroup);
        if (i3Var != null) {
            if (i3Var == this) {
                return;
            } else {
                i3Var.j();
            }
        }
        j();
        weakHashMap.put(viewGroup, this);
        this.k = viewGroup;
        this.l = nativeViewBinder;
        if (this.d == 2 && l()) {
            if (n2.a((View) this.k, false)) {
                m();
            } else {
                k();
            }
        }
    }

    public final void a(Context context, String str) {
        if (str == null || this.d != 2 || this.g == 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.g;
        c cVar = this.e;
        if (jCurrentTimeMillis < cVar.R) {
            return;
        }
        c0.a(context, c0.a(cVar.d, str, cVar.g, 0, this.c), true);
        NativeAdItem nativeAdItem = this.f;
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onClick(nativeAdItem);
        }
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void a(ViewGroup viewGroup) {
        this.k = viewGroup;
        if (viewGroup != null) {
            if (this.e.Y == 0) {
                viewGroup.setOnClickListener(this.m);
            } else {
                viewGroup.setOnTouchListener(new h3(this, viewGroup));
            }
        }
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void a(View view) {
        if (view != null) {
            view.setOnClickListener(new e3(this));
        }
    }
}
