package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import com.applovin.impl.sdk.ad.b;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public class n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f522a;
    private final int b;
    private final int c;
    private final boolean d;
    private final boolean e;

    public n4(Activity activity) {
        this.f522a = activity;
        int iD = o7.d(activity);
        this.c = iD;
        boolean zIsTablet = AppLovinSdkUtils.isTablet(activity);
        this.d = zIsTablet;
        this.b = a(iD, zIsTablet);
        this.e = zIsTablet && 2 == a(activity);
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        int i;
        if (!bVar.x0() || (i = this.b) == -1) {
            a(bVar.W());
        } else {
            a(i);
        }
    }

    private int a(int i, boolean z) {
        if (z && this.e) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            return i == 3 ? 1 : -1;
        }
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 9;
        }
        return i == 3 ? 8 : -1;
    }

    private void a(b.c cVar) {
        if (cVar == b.c.ACTIVITY_PORTRAIT) {
            if (this.d && this.e) {
                int i = this.c;
                if (i != 1 && i != 3) {
                    a(1);
                    return;
                } else if (i == 1) {
                    a(9);
                    return;
                } else {
                    a(1);
                    return;
                }
            }
            int i2 = this.c;
            if (i2 != 0 && i2 != 2) {
                a(1);
                return;
            } else {
                a(i2 != 0 ? 9 : 1);
                return;
            }
        }
        if (cVar == b.c.ACTIVITY_LANDSCAPE) {
            if (this.d && this.e) {
                int i3 = this.c;
                if (i3 != 0 && i3 != 2) {
                    a(0);
                    return;
                } else {
                    a(i3 != 2 ? 0 : 8);
                    return;
                }
            }
            int i4 = this.c;
            if (i4 != 1 && i4 != 3) {
                a(0);
            } else {
                a(i4 == 1 ? 0 : 8);
            }
        }
    }

    private static int a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int rotation = o7.f(context).getDefaultDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    private void a(int i) {
        try {
            this.f522a.setRequestedOrientation(i);
        } catch (Throwable unused) {
        }
    }
}
