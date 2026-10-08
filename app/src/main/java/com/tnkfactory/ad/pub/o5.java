package com.tnkfactory.ad.pub;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class o5 extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f3173a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ ImageView d;
    public final /* synthetic */ r5 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o5(r5 r5Var, long j, c cVar, long j2, Context context, ImageView imageView) {
        super(j, 300L);
        this.e = r5Var;
        this.f3173a = cVar;
        this.b = j2;
        this.c = context;
        this.d = imageView;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        CountDownTimer countDownTimer = this.e.m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        ArrayList arrayList;
        z1 z1Var;
        r5 r5Var = this.e;
        if (r5Var.f3188a != null) {
            r5Var.o = r9.getCurrentPosition();
            int i = (int) (this.e.o / 1000);
            this.f3173a.getClass();
            long j2 = this.b;
            if (j2 > 0) {
                r5 r5Var2 = this.e;
                if (r5Var2.o / 1000 >= j2 && !r5Var2.n && (z1Var = this.f3173a.j0) != null && !z1Var.l.isEmpty()) {
                    k4 k4VarA = k4.a();
                    ArrayList arrayList2 = this.f3173a.j0.l;
                    k4VarA.getClass();
                    k4.a(arrayList2);
                    this.e.n = true;
                }
            }
            ArrayList arrayList3 = this.f3173a.k0;
            if (arrayList3 == null || arrayList3.size() == 0 || this.f3173a.k0.size() < i + 1) {
                return;
            }
            r5 r5Var3 = this.e;
            Context context = this.c;
            c cVar = this.f3173a;
            ImageView imageView = this.d;
            r5Var3.getClass();
            if (imageView == null || (arrayList = cVar.k0) == null || ((s4) arrayList.get(i)).h.equals("ad") || ((s4) cVar.k0.get(i)).h.equals("ad_1") || ((s4) cVar.k0.get(i)).h.equals("ad_2")) {
                return;
            }
            new Thread(new q5(cVar, i, imageView)).start();
            int iApplyDimension = !TextUtils.isEmpty(((s4) cVar.k0.get(i)).g) ? (int) TypedValue.applyDimension(0, Integer.parseInt(((s4) cVar.k0.get(i)).g), context.getResources().getDisplayMetrics()) : -1;
            int iApplyDimension2 = TextUtils.isEmpty(((s4) cVar.k0.get(i)).i) ? -1 : (int) TypedValue.applyDimension(0, Integer.parseInt(((s4) cVar.k0.get(i)).i), context.getResources().getDisplayMetrics());
            if (iApplyDimension > 0 || iApplyDimension2 > 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iApplyDimension, iApplyDimension2);
                if (!TextUtils.isEmpty(((s4) cVar.k0.get(i)).f3193a)) {
                    String str = ((s4) cVar.k0.get(i)).f3193a;
                    str.getClass();
                    if (str.equals("left")) {
                        layoutParams.addRule(9);
                    } else if (str.equals(TtmlNode.RIGHT)) {
                        layoutParams.addRule(11);
                    }
                }
                if (!TextUtils.isEmpty(((s4) cVar.k0.get(i)).f)) {
                    String str2 = ((s4) cVar.k0.get(i)).f;
                    str2.getClass();
                    if (str2.equals("bottom")) {
                        layoutParams.addRule(12);
                    } else if (str2.equals(ViewHierarchyConstants.DIMENSION_TOP_KEY)) {
                        layoutParams.addRule(10);
                    }
                }
                if (((s4) cVar.k0.get(i)).h.equals("skip")) {
                    imageView.setClickable(true);
                }
                imageView.setLayoutParams(layoutParams);
            }
        }
    }
}
