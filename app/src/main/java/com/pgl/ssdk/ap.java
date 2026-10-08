package com.pgl.ssdk;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public class ap extends am {
    private Context n;
    private final int o;

    public ap(Context context, int i) {
        super(context);
        this.n = context;
        this.o = i;
    }

    @Override // com.pgl.ssdk.am
    public String a() {
        int i = this.o;
        if (i == 222) {
            return "/ssdk/v2/r?os=0&ver=7.7.0.0.overseas-rc.1&mode=1&app_ver=" + ab.h(this.n) + "&region=" + ad.a() + "&did=" + com.pgl.ssdk.ces.b.b() + "&aid=" + com.pgl.ssdk.ces.b.a();
        }
        if (i != 301) {
            return null;
        }
        return "/ssdk/sd/token?os=android&app_id=" + com.pgl.ssdk.ces.b.a() + "&did=" + com.pgl.ssdk.ces.b.b() + "&app_ver=" + ab.h(this.n) + "&platform=android&ver=7.7.0.0.overseas-rc.1&mode=1";
    }

    @Override // com.pgl.ssdk.am
    public void a(int i, byte[] bArr) {
        try {
            if (i == 200) {
                int i2 = this.o;
                if (i2 == 222) {
                    ((Integer) com.pgl.ssdk.ces.a.meta(223, null, bArr)).intValue();
                    return;
                }
                if (i2 == 301) {
                    Object objA = a5.a(bArr);
                    au.b("write token result = ".concat(String.valueOf(objA)));
                    if ((objA instanceof Integer) && ((Integer) objA).intValue() == 0) {
                        au.b("write token succ");
                        a5.f3056a = 200;
                        return;
                    } else {
                        if (objA instanceof String) {
                            a5.c = (String) objA;
                            a5.f3056a = 200;
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            an.b(this.n);
        } catch (Throwable unused) {
        }
    }
}
