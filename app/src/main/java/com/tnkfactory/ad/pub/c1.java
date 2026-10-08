package com.tnkfactory.ad.pub;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.NativeViewBinder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3115a;
    public AdListener b = null;
    public final HashMap c = new HashMap();
    public int d = 0;
    public c e = null;

    public c1(String str) {
        this.f3115a = str;
    }

    public abstract void a(Context context, boolean z);

    public void a(View view) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(ViewGroup viewGroup, NativeViewBinder nativeViewBinder) {
    }

    public View b(Context context) {
        return null;
    }

    public void b() {
    }

    public void c() {
    }

    public void c(Context context) {
    }

    public void d(Context context) {
    }

    public final boolean e() {
        String str = this.f3115a;
        return str != null && str.length() > 0;
    }

    public final boolean f() {
        c cVar;
        if (!g() || (cVar = this.e) == null) {
            return true;
        }
        cVar.getClass();
        return System.currentTimeMillis() - cVar.a0 < cVar.i * 1000;
    }

    public final boolean g() {
        return this.d == 2;
    }

    public void h() {
    }

    public void i() {
    }

    public final String d() {
        if (this.e == null) {
            return null;
        }
        return this.e.c + "_" + this.e.g;
    }

    public final boolean a(Context context) {
        m4 m4VarA = m4.a(context);
        String str = this.f3115a;
        long j = m4VarA.f3161a.getSharedPreferences("__tnk_pub__", 0).getLong("__tnk_0004_" + str, 0L);
        long j2 = m4VarA.f3161a.getSharedPreferences("__tnk_pub__", 0).getLong("__tnk_0006_" + str, 10L);
        if (j2 < 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            if (simpleDateFormat.format(new Date()).equals(simpleDateFormat.format(new Date(j)))) {
                return false;
            }
        } else if (System.currentTimeMillis() - j <= j2 * 1000) {
            return false;
        }
        return true;
    }

    public int[] a(int i, int i2) {
        return new int[]{-1, -1};
    }

    public final void a(AdItem adItem, AdError adError) {
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onError(adItem, adError);
        }
    }

    public final void a() {
        this.d = 0;
        c cVar = this.e;
        if (cVar != null) {
            cVar.g0.clear();
            this.e = null;
        }
    }
}
