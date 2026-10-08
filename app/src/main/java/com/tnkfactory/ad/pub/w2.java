package com.tnkfactory.ad.pub;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class w2 extends l0 {
    public final boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final String[] j;
    public int k;
    public Rect l;
    public Rect m;
    public int n;
    public int o;
    public int p;
    public int q;
    public final float r;

    public w2(Context context, boolean z) {
        super(context);
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = new String[]{"loading", "default", "expanded", "resized", "hidden"};
        this.k = 0;
        u2 u2Var = new u2(this);
        this.f = z;
        this.r = context.getResources().getDisplayMetrics().density;
        setWebViewClient(new v2(this));
        getViewTreeObserver().addOnGlobalLayoutListener(u2Var);
    }

    private void setViewable(int i) {
        boolean z = i == 0;
        if (z != this.g) {
            this.g = z;
            if (this.k == 1) {
                b("mraid.fireViewableChangeEvent(" + this.g + ");");
            }
        }
    }

    @Override // com.tnkfactory.ad.pub.l0
    public final boolean a(String str) {
        Handler handler;
        if (!str.startsWith("mraid://")) {
            return super.a(str);
        }
        String strSubstring = str.substring(8);
        HashMap map = new HashMap();
        int iIndexOf = strSubstring.indexOf(63);
        if (iIndexOf != -1) {
            String strSubstring2 = strSubstring.substring(0, iIndexOf);
            for (String str2 : strSubstring.substring(iIndexOf + 1).split("&")) {
                int iIndexOf2 = str2.indexOf(61);
                map.put(str2.substring(0, iIndexOf2), str2.substring(iIndexOf2 + 1));
            }
            strSubstring = strSubstring2;
        }
        map.put(NativeProtocol.WEB_DIALOG_ACTION, strSubstring);
        String str3 = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("open".equals(str3)) {
            String str4 = (String) map.get("url");
            if (c0.a(str4)) {
                a(s2.a(3), "open");
            } else {
                try {
                    loadUrl(URLDecoder.decode(str4, "utf-8"));
                } catch (UnsupportedEncodingException unused) {
                    a(s2.a(4), "open");
                }
            }
        } else if ("close".equals(str3)) {
            p4 p4Var = this.d.f3182a;
            p4Var.getClass();
            boolean z = System.currentTimeMillis() - p4Var.f3177a < 500;
            p4Var.f3177a = 0L;
            if (z && (handler = this.f3151a) != null) {
                handler.sendEmptyMessage(0);
            }
        } else if ("playVideo".equals(str3)) {
            String str5 = (String) map.get("url");
            if (c0.a(str5)) {
                a(s2.a(3), "playVideo");
            } else {
                try {
                    String strDecode = URLDecoder.decode(str5, "utf-8");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    intent.setDataAndType(Uri.parse(strDecode), MimeTypes.VIDEO_MP4);
                    getContext().startActivity(intent);
                } catch (ActivityNotFoundException unused2) {
                    a(s2.a(5), "playVideo");
                } catch (UnsupportedEncodingException unused3) {
                    a(s2.a(4), "playVideo");
                }
            }
        } else {
            a(s2.a(2), str3);
        }
        return true;
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        loadUrl("javascript:" + str);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
    }

    @Override // com.tnkfactory.ad.pub.l0, android.webkit.WebView, android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        setViewable(i);
    }

    @Override // com.tnkfactory.ad.pub.l0, android.webkit.WebView, android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        setViewable(i);
    }

    public final void a(String str, String str2) {
        b("mraid.fireErrorEvent('" + str + "','" + str2 + "');");
    }

    public final void a() {
        String str;
        if (this.k == 0 && this.h && this.i) {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            this.n = displayMetrics.widthPixels;
            this.o = displayMetrics.heightPixels;
            this.p = getWidth();
            this.q = getHeight();
            this.l = new Rect();
            int[] iArr = new int[2];
            int width = getWidth();
            int height = getHeight();
            getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            Rect rect = this.l;
            if (i != rect.left || i2 != rect.top || width != rect.width() || height != this.l.height()) {
                this.l = new Rect(i, i2, width + i, height + i2);
                this.m = new Rect(this.l);
            }
            StringBuilder sb = new StringBuilder("mraid.setPlacementType('");
            if (this.f) {
                str = ReportUtil.INVENTORY_TYPE_INTERSTITIAL;
            } else {
                str = "inline";
            }
            sb.append(str);
            sb.append("');");
            b(sb.toString());
            b("mraid.setScreenSize(" + ((int) (this.n / this.r)) + "," + ((int) (this.o / this.r)) + ");");
            b("mraid.setMaxSize(" + ((int) (((float) this.p) / this.r)) + "," + ((int) (((float) this.q) / this.r)) + ");");
            Rect rect2 = this.m;
            b("mraid.setCurrentPosition(" + ((int) (rect2.left / this.r)) + "," + ((int) (rect2.top / this.r)) + "," + ((int) (rect2.width() / this.r)) + "," + ((int) (this.m.height() / this.r)) + ");");
            Rect rect3 = this.l;
            b("mraid.setDefaultPosition(" + ((int) (((float) rect3.left) / this.r)) + "," + ((int) (((float) rect3.top) / this.r)) + "," + ((int) (rect3.width() / this.r)) + "," + ((int) (this.l.height() / this.r)) + ");");
            this.k = 1;
            StringBuilder sb2 = new StringBuilder("mraid.fireViewableChangeEvent(");
            sb2.append(this.g);
            sb2.append(");");
            b(sb2.toString());
            StringBuilder sb3 = new StringBuilder("mraid.fireStateChangeEvent('");
            sb3.append(this.j[this.k]);
            sb3.append("');");
            b(sb3.toString());
            b("mraid.fireReadyEvent();");
        }
    }
}
