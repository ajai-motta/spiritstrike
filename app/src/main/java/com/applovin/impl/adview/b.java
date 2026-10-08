package com.applovin.impl.adview;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.applovin.impl.f2;
import com.applovin.impl.j0;
import com.applovin.impl.o0;
import com.applovin.impl.o7;
import com.applovin.impl.p7;
import com.applovin.impl.p8;
import com.applovin.impl.s7;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t;
import com.applovin.impl.u4;
import com.applovin.impl.x7;
import com.applovin.impl.y4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class b extends j0 {
    private static final Set j = Collections.newSetFromMap(new WeakHashMap());
    private static final Object k = new Object();
    private final o c;
    private final com.applovin.impl.sdk.k d;
    private com.applovin.impl.sdk.ad.b e;
    private boolean f;
    private boolean g;
    private final List h;
    private final Object i;

    class a extends u4 {
        a() {
        }

        @Override // com.applovin.impl.u4
        protected Map a() {
            return CollectionUtils.hashMap("name", "AdWebView");
        }
    }

    public b(c cVar, com.applovin.impl.sdk.k kVar, Context context) {
        super(context);
        this.h = new ArrayList();
        this.i = new Object();
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.d = kVar;
        this.c = kVar.O();
        Integer num = (Integer) kVar.a(y4.H6);
        if (num.intValue() > 0) {
            synchronized (k) {
                Set set = j;
                set.add(this);
                o7.a("AdWebView", set.size(), num.intValue(), kVar.D());
            }
        }
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(cVar != null ? cVar : new a());
        setWebChromeClient(new t(cVar != null ? cVar.d() : null, kVar));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
        if (o0.j() && ((Boolean) kVar.a(y4.a6)).booleanValue()) {
            setWebViewRenderProcessClient(new d(kVar).a());
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.adview.b$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return b.a(view, motionEvent);
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.applovin.impl.adview.b$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    private void b() {
        synchronized (this.i) {
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                p8.a(this, (String) it.next(), "AdWebView", this.d);
            }
            this.h.clear();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.f = true;
        this.g = false;
        super.destroy();
    }

    public com.applovin.impl.sdk.ad.b getCurrentAd() {
        return this.e;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
    }

    public void setAdHtmlLoaded(boolean z) {
        this.g = z;
        if (z && ((Boolean) this.d.a(y4.z6)).booleanValue()) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        if (!o.a()) {
            return true;
        }
        this.c.a("AdWebView", "Received a LongClick event.");
        return true;
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        String string;
        if (!this.f) {
            this.e = bVar;
            try {
                applySettings(bVar);
                if (o7.a(bVar.getSize())) {
                    setVisibility(0);
                }
                bVar.a(SystemClock.elapsedRealtime());
                if (bVar instanceof com.applovin.impl.sdk.ad.a) {
                    loadDataWithBaseURL(bVar.k(), ((com.applovin.impl.sdk.ad.a) bVar).g1(), "text/html", null, "");
                    if (o.a()) {
                        this.c.a("AdWebView", "AppLovinAd rendered");
                        return;
                    }
                    return;
                }
                if (bVar instanceof p7) {
                    p7 p7Var = (p7) bVar;
                    s7 s7VarG1 = p7Var.g1();
                    if (s7VarG1 != null) {
                        x7 x7VarE = s7VarG1.e();
                        Uri uriC = x7VarE.c();
                        if (uriC != null) {
                            string = uriC.toString();
                        } else {
                            string = "";
                        }
                        String str = string;
                        String strB = x7VarE.b();
                        String strI1 = p7Var.i1();
                        if (!StringUtils.isValidString(str) && !StringUtils.isValidString(strB)) {
                            if (o.a()) {
                                this.c.b("AdWebView", "Unable to load companion ad. No resources provided.");
                                return;
                            }
                            return;
                        }
                        if (x7VarE.d() == x7.a.STATIC) {
                            if (o.a()) {
                                this.c.a("AdWebView", "Rendering WebView for static VAST ad");
                            }
                            String strA = a((String) this.d.a(y4.O4), str);
                            if (p7Var.x1() && p7Var.isOpenMeasurementEnabled() && p7Var.y1()) {
                                strA = this.d.e0().a(strA, f2.a((AppLovinAdImpl) bVar));
                            }
                            loadDataWithBaseURL(bVar.k(), strA, "text/html", null, "");
                            return;
                        }
                        if (x7VarE.d() == x7.a.HTML) {
                            if (StringUtils.isValidString(strB)) {
                                String strA2 = a(strI1, strB);
                                String str2 = StringUtils.isValidString(strA2) ? strA2 : strB;
                                if (o.a()) {
                                    this.c.a("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + str2);
                                }
                                loadDataWithBaseURL(bVar.k(), str2, "text/html", null, "");
                                return;
                            }
                            if (StringUtils.isValidString(str)) {
                                if (o.a()) {
                                    this.c.a("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                }
                                a(str, bVar.k(), strI1, this.d, p7Var);
                                return;
                            }
                            return;
                        }
                        if (x7VarE.d() == x7.a.IFRAME) {
                            if (StringUtils.isValidString(str)) {
                                if (o.a()) {
                                    this.c.a("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                                }
                                a(str, bVar.k(), strI1, this.d, p7Var);
                                return;
                            } else {
                                if (StringUtils.isValidString(strB)) {
                                    String strA3 = a(strI1, strB);
                                    String str3 = StringUtils.isValidString(strA3) ? strA3 : strB;
                                    if (o.a()) {
                                        this.c.a("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + str3);
                                    }
                                    loadDataWithBaseURL(bVar.k(), str3, "text/html", null, "");
                                    return;
                                }
                                return;
                            }
                        }
                        if (o.a()) {
                            this.c.b("AdWebView", "Failed to render VAST companion ad of invalid type");
                            return;
                        }
                        return;
                    }
                    if (o.a()) {
                        this.c.a("AdWebView", "No companion ad provided.");
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                throw new RuntimeException("Unable to render AppLovin ad (" + (bVar != null ? String.valueOf(bVar.getAdIdNumber()) : AbstractJsonLexerKt.NULL) + ") - " + th);
            }
        }
        o.h("AdWebView", "Ad can not be loaded in a destroyed webview");
    }

    public void a(String str) {
        if (((Boolean) this.d.a(y4.z6)).booleanValue()) {
            if (this.g) {
                p8.a(this, str, "AdWebView", this.d);
                return;
            }
            synchronized (this.h) {
                this.h.add(str);
            }
            return;
        }
        p8.a(this, str, "AdWebView", this.d);
    }

    private void a(String str, String str2, String str3, com.applovin.impl.sdk.k kVar, p7 p7Var) {
        String strA = a(str3, str);
        if (StringUtils.isValidString(strA)) {
            if (o.a()) {
                this.c.a("AdWebView", "Rendering webview for VAST ad with resourceContents : " + strA);
            }
            loadDataWithBaseURL(str2, strA, "text/html", null, "");
            return;
        }
        String strA2 = a((String) kVar.a(y4.P4), str);
        if (StringUtils.isValidString(strA2)) {
            if (p7Var.x1() && p7Var.isOpenMeasurementEnabled()) {
                strA2 = kVar.e0().a(strA2, f2.a((AppLovinAdImpl) p7Var));
            }
            String str4 = strA2;
            if (o.a()) {
                this.c.a("AdWebView", "Rendering webview for VAST ad with resourceContents : " + str4);
            }
            loadDataWithBaseURL(str2, str4, "text/html", null, "");
            return;
        }
        if (o.a()) {
            this.c.a("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        }
        loadUrl(str);
    }

    private String a(String str, String str2) {
        if (StringUtils.isValidString(str)) {
            return str.replace("{SOURCE}", str2);
        }
        return null;
    }
}
