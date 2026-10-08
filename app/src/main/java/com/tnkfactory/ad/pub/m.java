package com.tnkfactory.ad.pub;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class m extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f3156a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(v vVar, Looper looper) {
        super(looper);
        this.f3156a = vVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        try {
            x1 x1Var = this.f3156a.h;
            ArrayList<View> arrayList = x1Var.h;
            ArrayList<View> arrayList2 = x1Var.i;
            if (i != 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    v.a((View) it.next(), i);
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    v.a((View) it2.next(), i);
                }
                sendEmptyMessageDelayed(message.what - 1, 1000L);
                return;
            }
            for (View view : arrayList) {
                if (view instanceof TextView) {
                    ((TextView) view).setText((CharSequence) view.getTag());
                } else {
                    View view2 = (View) view.getTag();
                    view2.setVisibility(8);
                    ((ViewGroup) view2.getParent()).removeView(view2);
                    view.setVisibility(0);
                }
                view.setClickable(true);
            }
            for (View view3 : arrayList2) {
                if (view3 instanceof TextView) {
                    ((TextView) view3).setText((CharSequence) view3.getTag());
                } else {
                    View view4 = (View) view3.getTag();
                    view4.setVisibility(8);
                    ((ViewGroup) view4.getParent()).removeView(view4);
                    view3.setVisibility(0);
                }
                view3.setClickable(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
