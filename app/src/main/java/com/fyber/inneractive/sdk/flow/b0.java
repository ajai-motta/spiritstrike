package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.AppEventsConstants;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRenderer;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListenerWithImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListenerWithImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.OnGlobalImpressionDataListener;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.network.h1;
import com.fyber.inneractive.sdk.network.z0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;
import com.fyber.inneractive.sdk.util.y0;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 implements InneractiveAdRenderer, InneractiveInternalBrowserActivity.InternalBrowserListener, com.fyber.inneractive.sdk.click.f, com.fyber.inneractive.sdk.web.t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InneractiveAdSpot f1036a;
    public x b;
    public InneractiveUnitController.EventsListener c;
    public boolean d = false;
    public boolean e = false;
    public boolean f = true;
    public Runnable g;
    public com.fyber.inneractive.sdk.click.r h;
    public z i;
    public View j;

    public int A() {
        return -1;
    }

    public int B() {
        return -1;
    }

    public final boolean C() {
        com.fyber.inneractive.sdk.config.global.r rVar;
        x xVar = this.b;
        if (xVar != null && (rVar = xVar.c) != null && rVar.a(com.fyber.inneractive.sdk.config.global.features.c.class) != null) {
            com.fyber.inneractive.sdk.config.global.features.c cVar = (com.fyber.inneractive.sdk.config.global.features.c) this.b.c.a(com.fyber.inneractive.sdk.config.global.features.c.class);
            cVar.getClass();
            if (new ArrayList(cVar.c.values()).size() > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean D() {
        return false;
    }

    public boolean E() {
        x xVar = this.b;
        if (xVar != null) {
            return xVar.c();
        }
        return true;
    }

    public boolean F() {
        return this instanceof com.fyber.inneractive.sdk.renderers.a0;
    }

    public final void G() {
        com.fyber.inneractive.sdk.response.e eVarB;
        Context contextY = y();
        if (this.e || this.c == null) {
            return;
        }
        IAlog.a("%sCalling external interface onAdImpression", IAlog.a(this));
        this.c.onAdImpression(this.f1036a);
        x xVar = this.b;
        if (xVar != null && (eVarB = xVar.b()) != null) {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            com.fyber.inneractive.sdk.config.x0 x0Var = iAConfigManager.x;
            if (x0Var != null) {
                UnitDisplayType unitDisplayType = eVarB.p;
                ImpressionData impressionData = eVarB.t;
                x0Var.a(unitDisplayType, "LAST_DOMAIN_SHOWED", impressionData != null ? impressionData.getAdvertiserDomain() : null);
                x0Var.a(unitDisplayType, "LAST_APP_BUNDLE_ID", eVarB.A);
                if (this.b.isVideoAd()) {
                    x0Var.a(unitDisplayType, new String[]{"LAST_VAST_SKIPED"}[0], AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    x0Var.a(unitDisplayType, new String[]{"LAST_VAST_CLICKED_TYPE"}[0], AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                x0Var.a(unitDisplayType, new String[]{"LAST_CLICKED"}[0], AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            y0 y0Var = iAConfigManager.A;
            com.fyber.inneractive.sdk.config.s0 s0Var = this.b.d;
            ImpressionData impressionData2 = eVarB.t;
            if (s0Var != null) {
                OnGlobalImpressionDataListener onGlobalImpressionDataListener = y0Var.f1679a;
                if (onGlobalImpressionDataListener != null) {
                    com.fyber.inneractive.sdk.config.r0 r0Var = (com.fyber.inneractive.sdk.config.r0) s0Var;
                    onGlobalImpressionDataListener.onImpression(r0Var.b, r0Var.f970a, impressionData2);
                }
            } else {
                y0Var.getClass();
            }
            InneractiveUnitController.EventsListener eventsListener = this.c;
            if (eventsListener instanceof InneractiveFullscreenAdEventsListenerWithImpressionData) {
                ((InneractiveFullscreenAdEventsListenerWithImpressionData) eventsListener).onAdImpression(this.f1036a, eVarB.t);
            } else if (eventsListener instanceof InneractiveAdViewEventsListenerWithImpressionData) {
                ((InneractiveAdViewEventsListenerWithImpressionData) eventsListener).onAdImpression(this.f1036a, eVarB.t);
            }
            com.fyber.inneractive.sdk.privacysandbox.b bVarA = com.fyber.inneractive.sdk.privacysandbox.b.a(contextY);
            if (bVarA == null) {
                bVarA = null;
            }
            String str = eVarB.m;
            if (!TextUtils.isEmpty(str) && bVarA != null) {
                bVarA.a(str, null);
            }
        }
        this.e = true;
    }

    public final void H() {
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdWillOpenExternalApp", IAlog.a(this));
            this.c.onAdWillOpenExternalApp(this.f1036a);
        }
    }

    public void I() {
        View viewZ = z();
        if (viewZ == null || this.j == null || viewZ.getParent() == null || !(viewZ.getParent() instanceof ViewGroup)) {
            return;
        }
        viewZ.getLayoutParams();
        ((ViewGroup) viewZ.getParent()).removeView(this.j);
        e(this.j);
        this.j = null;
    }

    public final void J() {
        x xVar = this.b;
        if (xVar == null || xVar.b() == null) {
            return;
        }
        String str = this.b.b().q;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IAlog.e("%sfiring rewarded completion!", IAlog.a(this));
        IAlog.d("AD_REWARDED_COMPLETION", new Object[0]);
        z0.b(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fyber.inneractive.sdk.util.d0 a(android.content.Context r16, java.lang.String r17, com.fyber.inneractive.sdk.util.g1 r18, com.fyber.inneractive.sdk.util.g r19, boolean r20, com.fyber.inneractive.sdk.click.o r21) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.b0.a(android.content.Context, java.lang.String, com.fyber.inneractive.sdk.util.g1, com.fyber.inneractive.sdk.util.g, boolean, com.fyber.inneractive.sdk.click.o):com.fyber.inneractive.sdk.util.d0");
    }

    public final void b(com.fyber.inneractive.sdk.response.e eVar) {
        String str = eVar.k;
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        IAlog.e("%sfiring impression!", IAlog.a(this));
        IAlog.d("AD_IMPRESSION", new Object[0]);
        z0.b(str);
    }

    public final Context c(View view) {
        View view2;
        int i = 0;
        View[] viewArr = {view, z()};
        while (true) {
            if (i >= 2) {
                view2 = null;
                break;
            }
            view2 = viewArr[i];
            if (view2 != null) {
                break;
            }
            i++;
        }
        return com.fyber.inneractive.sdk.util.o.a(view2);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public boolean canRefreshAd() {
        return true;
    }

    public void d(View view) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void destroy() {
        if (this.d) {
            InneractiveInternalBrowserActivity.setInternalBrowserListener(null);
            this.d = false;
        }
        Runnable runnable = this.g;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
            this.g = null;
        }
        this.b = null;
        this.c = null;
        this.f1036a = null;
        if (this.h != null) {
            I();
            com.fyber.inneractive.sdk.click.r rVar = this.h;
            rVar.e = true;
            Iterator it = rVar.i.iterator();
            while (it.hasNext()) {
                ((com.fyber.inneractive.sdk.click.a) it.next()).cancel();
            }
            rVar.i.clear();
            h1 h1Var = rVar.h;
            if (h1Var != null) {
                h1Var.f1217a = true;
            }
            rVar.d = null;
            this.h = null;
            this.i = null;
        }
    }

    public void e(View view) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void initialize(InneractiveAdSpot inneractiveAdSpot) {
        this.f1036a = inneractiveAdSpot;
        this.b = inneractiveAdSpot.getAdContent();
        this.c = inneractiveAdSpot.getSelectedUnitController().getEventsListener();
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity.InternalBrowserListener
    public final void onApplicationInBackground() {
        H();
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity.InternalBrowserListener
    public final void onInternalBrowserDismissed() {
        IAlog.a("onInternalBrowserDismissed callback called", new Object[0]);
        if (this.d) {
            this.d = false;
            InneractiveInternalBrowserActivity.setInternalBrowserListener(null);
        }
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdWillCloseInternalBrowser", IAlog.a(this));
            this.c.onAdWillCloseInternalBrowser(this.f1036a);
        }
    }

    public final com.fyber.inneractive.sdk.ignite.m p() {
        x xVar = this.b;
        return (xVar == null || !xVar.d() || this.b.b() == null) ? com.fyber.inneractive.sdk.ignite.m.NONE : this.b.b().H;
    }

    public void u() {
        G();
    }

    public void x() {
        View viewZ = z();
        if (viewZ == null || viewZ.getParent() == null || !(viewZ.getParent() instanceof ViewGroup) || this.j != null) {
            return;
        }
        View viewInflate = View.inflate(viewZ.getContext(), R.layout.ia_layout_click_overlay, null);
        this.j = viewInflate;
        if (viewInflate != null) {
            ((ViewGroup) viewZ.getParent()).addView(this.j, viewZ.getLayoutParams());
            d(this.j);
        }
    }

    public Context y() {
        return com.fyber.inneractive.sdk.util.o.a(z());
    }

    public abstract View z();

    /* JADX WARN: Removed duplicated region for block: B:93:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(com.fyber.inneractive.sdk.click.b r11, com.fyber.inneractive.sdk.util.g1 r12, com.fyber.inneractive.sdk.util.g r13) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.b0.b(com.fyber.inneractive.sdk.click.b, com.fyber.inneractive.sdk.util.g1, com.fyber.inneractive.sdk.util.g):void");
    }

    public static void a(com.fyber.inneractive.sdk.response.e eVar) {
        String str = eVar.l;
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        IAlog.d("AD_CLICKED", new Object[0]);
        z0.b(str);
    }

    @Override // com.fyber.inneractive.sdk.click.f
    public final void a(com.fyber.inneractive.sdk.click.b bVar, g1 g1Var, com.fyber.inneractive.sdk.util.g gVar) {
        b(bVar, g1Var, gVar);
    }

    public final void a(String str, com.fyber.inneractive.sdk.click.q qVar) {
        com.fyber.inneractive.sdk.response.e eVarB;
        JSONArray jSONArrayB;
        InneractiveAdRequest inneractiveAdRequest;
        x xVar = this.b;
        if (xVar != null) {
            eVarB = xVar.b();
            x xVar2 = this.b;
            inneractiveAdRequest = xVar2.f1126a;
            com.fyber.inneractive.sdk.config.global.r rVar = xVar2.c;
            jSONArrayB = rVar != null ? rVar.b() : null;
        } else {
            eVarB = null;
            jSONArrayB = null;
            inneractiveAdRequest = null;
        }
        com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.EXTERNAL_BROWSER_OPENED;
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(eVarB);
        wVar.c = uVar;
        wVar.f1220a = inneractiveAdRequest;
        wVar.d = jSONArrayB;
        wVar.a("url", str).a("fallback", (qVar == com.fyber.inneractive.sdk.click.q.OPENED_USING_CHROME_NAVIGATE || qVar == com.fyber.inneractive.sdk.click.q.OPENED_IN_EXTERNAL_BROWSER) ? "chrome" : "na").a((String) null);
    }

    public final void a(Context context, boolean z, float f, float f2) {
        com.fyber.inneractive.sdk.response.e eVarB;
        if (z) {
            IAlog.a("%s : will not notify click on fallback", IAlog.a(this));
            return;
        }
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdClicked", IAlog.a(this));
            this.c.onAdClicked(this.f1036a);
        }
        x xVar = this.b;
        if (xVar == null || (eVarB = xVar.b()) == null) {
            return;
        }
        IAConfigManager.O.x.a(eVarB.p, "LAST_CLICKED", "1");
        com.fyber.inneractive.sdk.privacysandbox.b bVarA = com.fyber.inneractive.sdk.privacysandbox.b.a(context);
        if (bVarA == null) {
            bVarA = null;
        }
        String str = eVarB.n;
        Float fValueOf = Float.valueOf(f);
        Float fValueOf2 = Float.valueOf(f2);
        if (!fValueOf.isNaN() && !fValueOf2.isNaN() && f >= 0.0f && f2 >= 0.0f) {
            MotionEvent motionEventObtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, f, f2, 0);
            if (TextUtils.isEmpty(str) || bVarA == null) {
                return;
            }
            bVarA.a(str, motionEventObtain);
            return;
        }
        if (TextUtils.isEmpty(str) || bVarA == null) {
            return;
        }
        bVarA.a(str, null);
    }

    public final void a(WebViewRendererProcessHasGoneError webViewRendererProcessHasGoneError) {
        String simpleName = webViewRendererProcessHasGoneError.getClass().getSimpleName();
        String message = webViewRendererProcessHasGoneError.getMessage();
        x xVar = this.b;
        com.fyber.inneractive.sdk.network.z.a(simpleName, message, xVar != null ? xVar.f1126a : null, xVar != null ? xVar.b() : null);
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdEnteredErrorState: %s", IAlog.a(this), webViewRendererProcessHasGoneError.getMessage());
            this.c.onAdEnteredErrorState(this.f1036a, webViewRendererProcessHasGoneError);
        }
    }

    public static void a(com.fyber.inneractive.sdk.cache.session.enums.a aVar, com.fyber.inneractive.sdk.cache.session.enums.c cVar) {
        com.fyber.inneractive.sdk.cache.session.e eVar = IAConfigManager.O.x.f987a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
        }
    }
}
