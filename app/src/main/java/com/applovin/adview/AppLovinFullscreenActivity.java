package com.applovin.adview;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.WebView;
import android.window.OnBackInvokedCallback;
import com.applovin.impl.a5;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.d;
import com.applovin.impl.d2;
import com.applovin.impl.e;
import com.applovin.impl.f2;
import com.applovin.impl.f8;
import com.applovin.impl.g;
import com.applovin.impl.g0;
import com.applovin.impl.n1;
import com.applovin.impl.n2;
import com.applovin.impl.o0;
import com.applovin.impl.o7;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.w1;
import com.applovin.impl.y4;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.AnalyticsEvents;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinFullscreenActivity extends Activity implements n1 {
    private static final Set h = Collections.newSetFromMap(new WeakHashMap());
    private static final Object i = new Object();
    public static n2 parentInterstitialWrapper;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f272a;
    private w1 b;
    private final AtomicBoolean c = new AtomicBoolean(true);
    private com.applovin.impl.adview.activity.a d;
    private c e;
    private g0 f;
    private long g;

    class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Boolean f273a;
        final /* synthetic */ boolean b;
        final /* synthetic */ com.applovin.impl.sdk.ad.b c;

        a(Boolean bool, boolean z, com.applovin.impl.sdk.ad.b bVar) {
            this.f273a = bool;
            this.b = z;
            this.c = bVar;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            if (this.f273a.booleanValue()) {
                AppLovinFullscreenActivity.this.a(windowInsets);
            }
            if (this.b) {
                int iIntValue = ((Integer) AppLovinFullscreenActivity.this.f272a.a(y4.z2)).intValue();
                Insets insets = windowInsets.getInsets(this.c.F0() ? iIntValue & (~WindowInsets.Type.displayCutout()) : iIntValue | WindowInsets.Type.displayCutout());
                view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
            } else {
                Insets insets2 = windowInsets.getInsets(((Integer) AppLovinFullscreenActivity.this.f272a.a(y4.z2)).intValue());
                view.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
            }
            return windowInsets;
        }
    }

    private static class c implements OnBackInvokedCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f275a;

        protected c(Runnable runnable) {
            this.f275a = runnable;
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            this.f275a.run();
        }
    }

    private void b() {
        k kVar = this.f272a;
        if (kVar == null || !((Boolean) kVar.a(y4.D2)).booleanValue()) {
            return;
        }
        final Long l = (Long) this.f272a.a(y4.E2);
        this.f = g0.a(l.longValue(), true, this.f272a, new Runnable() { // from class: com.applovin.adview.AppLovinFullscreenActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(l);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        w1 w1Var = this.b;
        if (w1Var != null) {
            w1Var.q();
        }
        if (o7.g(getApplicationContext())) {
            super.onBackPressed();
        }
    }

    @Override // com.applovin.impl.n1
    public void dismiss(String str) {
        if (o0.k() && this.e != null) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.e);
            this.e = null;
        }
        w1 w1Var = this.b;
        if (w1Var != null) {
            w1Var.a(str);
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w1 w1Var = this.b;
        if (w1Var != null) {
            w1Var.a(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && parentInterstitialWrapper == null) {
            o.j("AppLovinFullscreenActivity", "Dismissing ad. Activity was destroyed while in background.");
            dismiss("activity_destroyed_while_in_background");
            return;
        }
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            o.c("AppLovinFullscreenActivity", "Failed to request window feature", th);
        }
        getWindow().addFlags(16777216);
        getWindow().addFlags(128);
        View viewFindViewById = findViewById(R.id.content);
        viewFindViewById.setBackgroundColor(-16777216);
        if (TextUtils.isEmpty(getIntent().getStringExtra("com.applovin.interstitial.sdk_key"))) {
            n2 n2Var = parentInterstitialWrapper;
            if (n2Var != null && n2Var.f() != null) {
                n2.a(parentInterstitialWrapper.f(), parentInterstitialWrapper.c(), "Empty SDK key", (Throwable) null, this);
            }
            finish();
            return;
        }
        this.f272a = AppLovinSdk.getInstance(this).a();
        n2 n2Var2 = parentInterstitialWrapper;
        com.applovin.impl.sdk.ad.b bVarF = n2Var2 != null ? n2Var2.f() : null;
        Boolean bool = (Boolean) this.f272a.a(y4.J4);
        boolean z = bVarF != null && bVarF.L0();
        if (o0.b() && (bool.booleanValue() || z)) {
            getWindow().setDecorFitsSystemWindows(false);
            viewFindViewById.setOnApplyWindowInsetsListener(new a(bool, z, bVarF));
            a(bVarF);
        } else {
            viewFindViewById.setFitsSystemWindows(true);
            if (o0.b()) {
                f8.a(viewFindViewById, this.f272a);
            }
            a(bVarF);
        }
        if (bVarF != null && bVarF.r0()) {
            g.a(bVarF, this, this.f272a);
        }
        if (o0.k() && ((Boolean) this.f272a.a(y4.h6)).booleanValue()) {
            this.e = new c(new Runnable() { // from class: com.applovin.adview.AppLovinFullscreenActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            });
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.e);
        }
        a();
        b();
        Integer num = (Integer) this.f272a.a(y4.I6);
        if (num.intValue() > 0) {
            synchronized (i) {
                Set set = h;
                set.add(this);
                o7.a("AppLovinFullscreenActivity", set.size(), num.intValue(), this.f272a.D());
            }
        }
        n2 n2Var3 = parentInterstitialWrapper;
        if (n2Var3 != null) {
            w1.a(n2Var3.f(), parentInterstitialWrapper.b(), parentInterstitialWrapper.c(), parentInterstitialWrapper.d(), parentInterstitialWrapper.h(), this.f272a, this, new b());
            return;
        }
        Intent intent = new Intent(this, (Class<?>) FullscreenAdService.class);
        com.applovin.impl.adview.activity.a aVar = new com.applovin.impl.adview.activity.a(this, this.f272a);
        this.d = aVar;
        bindService(intent, aVar, 1);
        if (o0.i()) {
            String str = this.f272a.o0().getExtraParameters().get("disable_set_data_dir_suffix");
            if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
                return;
            }
            try {
                WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        k kVar = this.f272a;
        if (kVar != null && ((Boolean) kVar.a(y4.C2)).booleanValue()) {
            this.f272a.q0().b(a5.N);
            this.f272a.q0().b(a5.P);
            this.f272a.q0().b(a5.Q);
        }
        if (this.f != null) {
            this.f272a.q0().b(a5.O);
            this.f.a();
            this.f = null;
        }
        com.applovin.impl.adview.activity.a aVar = this.d;
        if (aVar != null) {
            try {
                unbindService(aVar);
            } catch (Throwable unused) {
            }
        }
        w1 w1Var = this.b;
        if (w1Var != null) {
            if (w1Var.g()) {
                this.b.r();
            } else {
                long jA = this.b.a();
                if (jA >= 0) {
                    if (jA == 0) {
                        this.b.d(true);
                    }
                    final n2 n2Var = parentInterstitialWrapper;
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.adview.AppLovinFullscreenActivity$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(n2Var);
                        }
                    }, jA);
                } else {
                    a(this.b, false, false);
                }
            }
        }
        parentInterstitialWrapper = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        w1 w1Var = this.b;
        if (w1Var != null) {
            w1Var.a(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        w1 w1Var = this.b;
        if (w1Var != null) {
            w1Var.s();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        w1 w1Var;
        try {
            super.onResume();
            if (this.c.get() || (w1Var = this.b) == null) {
                return;
            }
            w1Var.t();
        } catch (IllegalArgumentException e) {
            this.f272a.O();
            if (o.a()) {
                this.f272a.O().a("AppLovinFullscreenActivity", "Error was encountered in onResume().", e);
            }
            this.f272a.D().a("AppLovinFullscreenActivity", "onResume", e);
            dismiss("activity_on_resume_error");
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        w1 w1Var = this.b;
        if (w1Var != null) {
            w1Var.u();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (this.b != null) {
            if (!this.c.getAndSet(false)) {
                this.b.b(z);
            }
            if (z) {
                n2 n2Var = parentInterstitialWrapper;
                a(n2Var != null ? n2Var.f() : null);
            }
        }
        super.onWindowFocusChanged(z);
    }

    public void setPresenter(w1 w1Var) {
        this.b = w1Var;
    }

    class b implements w1.g {
        b() {
        }

        @Override // com.applovin.impl.w1.g
        public void a(w1 w1Var) {
            AppLovinFullscreenActivity.this.b = w1Var;
            w1Var.w();
        }

        @Override // com.applovin.impl.w1.g
        public void a(String str, Throwable th) {
            com.applovin.impl.sdk.ad.b bVarF = AppLovinFullscreenActivity.parentInterstitialWrapper.f();
            n2.a(bVarF, AppLovinFullscreenActivity.parentInterstitialWrapper.c(), str, th, AppLovinFullscreenActivity.this);
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("source", "createAppLovinFullscreenActivity");
            CollectionUtils.putStringIfValid(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, mapHashMap);
            CollectionUtils.putStringIfValid("top_main_method", th.toString(), mapHashMap);
            AppLovinFullscreenActivity.this.f272a.g().a(d2.E, bVarF, mapHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WindowInsets windowInsets) {
        o0.a aVarA = o0.a(windowInsets, this.f272a);
        o0.a aVarC = o0.c(windowInsets, this.f272a);
        o0.a aVarB = o0.b(windowInsets, this.f272a);
        String strB = o7.b(this);
        o0.a(aVarA, strB);
        o0.c(aVarC, strB);
        o0.b(aVarB, strB);
        w1 w1Var = this.b;
        if (w1Var != null) {
            w1Var.a(aVarA, aVarC, aVarB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(n2 n2Var) {
        boolean zY = this.b.y();
        boolean zI = (n2Var == null || !zY) ? false : n2Var.i();
        if (!zI) {
            this.b.d(false);
        }
        a(this.b, zY, zI);
    }

    private void a(w1 w1Var, boolean z, boolean z2) {
        w1Var.a("activity_destroyed_by_app_relaunch");
        if (this.f272a != null) {
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("source", "onDestroyAppLovinFullScreenActivity");
            n2 n2Var = parentInterstitialWrapper;
            com.applovin.impl.sdk.ad.b bVarF = n2Var != null ? n2Var.f() : null;
            mapHashMap.putAll(f2.a((AppLovinAdImpl) bVarF));
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putBoolean(jSONObject, "reshow_attempted", z);
            JsonUtils.putBoolean(jSONObject, "reshow_success", z2);
            if (bVarF != null) {
                JsonUtils.putInt(jSONObject, "reshow_count", bVarF.R());
            }
            mapHashMap.put("details", jSONObject.toString());
            this.f272a.D().d(d2.B0, mapHashMap);
        }
        w1Var.r();
    }

    private void a() {
        n2 n2Var;
        k kVar = this.f272a;
        if (kVar == null || !((Boolean) kVar.a(y4.C2)).booleanValue() || (n2Var = parentInterstitialWrapper) == null || n2Var.f() == null) {
            return;
        }
        com.applovin.impl.sdk.ad.b bVarF = parentInterstitialWrapper.f();
        List listJ = bVarF.j();
        if (CollectionUtils.isEmpty(listJ)) {
            return;
        }
        e eVar = (e) listJ.get(0);
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putStringIfValid(jSONObject, "app_killed_postback_url", eVar.c());
        JsonUtils.putStringIfValid(jSONObject, "app_killed_postback_backup_url", eVar.a());
        this.f272a.q0().b(a5.P, jSONObject.toString());
        this.f272a.q0().b(a5.N, Long.valueOf(System.currentTimeMillis()));
        this.f272a.q0().b(a5.Q, CollectionUtils.toJsonString(f2.a((AppLovinAdImpl) bVarF), JsonUtils.EMPTY_JSON));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l) {
        this.g += l.longValue();
        this.f272a.q0().b(a5.O, Long.valueOf(this.g));
    }

    private void a(com.applovin.impl.sdk.ad.b bVar) {
        if (o0.b() && bVar != null && bVar.L0()) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
            if (bVar.U0() && bVar.S0()) {
                d.c(this);
                return;
            } else if (bVar.U0()) {
                d.b((Activity) this);
                return;
            } else {
                if (bVar.S0()) {
                    d.a((Activity) this);
                    return;
                }
                return;
            }
        }
        getWindow().setFlags(1024, 1024);
        d.c(this);
    }
}
