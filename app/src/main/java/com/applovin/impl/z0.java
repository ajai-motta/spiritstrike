package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.u0;
import com.applovin.impl.v0;
import com.applovin.impl.x0;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f729a;
    private final int b;
    private List d;
    private String e;
    private v0 f;
    private u0.c g;
    private v0 h;
    private Dialog i;
    private long j;
    private long k;
    private long l;
    private final t0 c = new t0();
    private u0.b m = new u0.b();
    private final com.applovin.impl.b n = new a();

    class a extends com.applovin.impl.b {
        a() {
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            if ((activity instanceof AppLovinWebViewActivity) || z0.this.h == null) {
                return;
            }
            if (z0.this.i != null) {
                z0 z0Var = z0.this;
                if (!com.applovin.impl.d.d(z0Var.a(z0Var.i))) {
                    z0.this.i.dismiss();
                }
                z0.this.i = null;
            }
            v0 v0Var = z0.this.h;
            z0.this.h = null;
            z0 z0Var2 = z0.this;
            z0Var2.a(z0Var2.f, v0Var, activity);
        }
    }

    class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f731a;
        final /* synthetic */ x0 b;
        final /* synthetic */ v0 c;
        final /* synthetic */ Activity d;

        b(boolean z, x0 x0Var, v0 v0Var, Activity activity) {
            this.f731a = z;
            this.b = x0Var;
            this.c = v0Var;
            this.d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            z0.this.h = null;
            z0.this.i = null;
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("duration_ms", String.valueOf(SystemClock.elapsedRealtime() - z0.this.l));
            CollectionUtils.putStringIfValid("details", String.valueOf(this.f731a), mapHashMap);
            z0.this.f729a.w0().d(d2.o, mapHashMap);
            v0 v0VarA = z0.this.a(this.b.a());
            if (v0VarA == null) {
                z0.this.a("Destination state for TOS/PP alert is null");
                return;
            }
            z0.this.a(this.c, v0VarA, this.d);
            if (v0VarA.d() != v0.b.ALERT) {
                dialogInterface.dismiss();
            }
        }
    }

    class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f732a;
        final /* synthetic */ Activity b;

        c(Uri uri, Activity activity) {
            this.f732a = uri;
            this.b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            o7.a(this.f732a, this.b, z0.this.f729a);
        }
    }

    class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f733a;
        final /* synthetic */ Activity b;

        d(Uri uri, Activity activity) {
            this.f733a = uri;
            this.b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            o7.a(this.f733a, this.b, z0.this.f729a);
        }
    }

    class e implements CmpServiceImpl.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f734a;
        final /* synthetic */ v0 b;
        final /* synthetic */ Activity c;

        e(long j, v0 v0Var, Activity activity) {
            this.f734a = j;
            this.b = v0Var;
            this.c = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
        public void a(AppLovinCmpError appLovinCmpError) {
            z0.this.m.a(appLovinCmpError);
            z0.this.a(appLovinCmpError, SystemClock.elapsedRealtime() - this.f734a);
            z0.this.a(this.b, this.c, Boolean.valueOf(appLovinCmpError == null));
        }
    }

    class f implements CmpServiceImpl.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f735a;
        final /* synthetic */ v0 b;
        final /* synthetic */ Activity c;

        f(long j, v0 v0Var, Activity activity) {
            this.f735a = j;
            this.b = v0Var;
            this.c = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
        public void a(AppLovinCmpError appLovinCmpError) {
            z0.this.m.a(appLovinCmpError);
            z0.this.a(appLovinCmpError, SystemClock.elapsedRealtime() - this.f735a);
            z0.this.a(this.b, this.c, Boolean.valueOf(appLovinCmpError == null));
        }
    }

    class g implements CmpServiceImpl.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f736a;
        final /* synthetic */ v0 b;
        final /* synthetic */ Activity c;

        g(long j, v0 v0Var, Activity activity) {
            this.f736a = j;
            this.b = v0Var;
            this.c = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.f
        public void a(AppLovinCmpError appLovinCmpError) {
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("duration_ms", String.valueOf(SystemClock.elapsedRealtime() - this.f736a));
            if (appLovinCmpError != null) {
                z0.this.m.a(appLovinCmpError);
                mapHashMap.putAll(z0.this.a(appLovinCmpError));
                z0.this.f729a.w0().d(d2.t, mapHashMap);
            } else {
                z0.this.m.c();
                z0.this.f729a.w0().d(d2.u, mapHashMap);
            }
            z0.this.b(this.b, this.c);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v0 f737a;

        h(v0 v0Var) {
            this.f737a = v0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            z0 z0Var = z0.this;
            z0Var.a(z0Var.f, this.f737a, z0.this.f729a.v0());
        }
    }

    public z0(com.applovin.impl.sdk.k kVar) {
        this.f729a = kVar;
        this.b = ((Integer) kVar.a(y4.a7)).intValue();
    }

    private void c(final v0 v0Var, final Activity activity) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.z0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(v0Var, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v0 v0Var, Activity activity) {
        a(v0Var, activity, (Boolean) null);
    }

    private void b() {
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("duration_ms", String.valueOf(SystemClock.elapsedRealtime() - this.j));
        CollectionUtils.putStringIfValid("details", this.c.toString(), mapHashMap);
        this.f729a.w0().d(d2.v, mapHashMap);
        this.d = null;
        this.f = null;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.c.a();
        this.f729a.e().b(this.n);
        u0.c cVar = this.g;
        if (cVar != null) {
            cVar.a(this.m);
            this.g = null;
        }
        this.m = new u0.b();
    }

    public void a(Activity activity, u0.c cVar) {
        a(v0.a.IS_AL_GDPR.b(), activity, cVar);
    }

    public void a(int i, Activity activity, u0.c cVar) {
        if (this.d != null) {
            this.f729a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f729a.O().a("ConsentFlowStateMachine", "Unable to start states: " + this.d);
            }
            this.f729a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f729a.O().a("ConsentFlowStateMachine", "Consent flow already in progress for states: " + this.d);
            }
            cVar.a(new u0.b(new s0(s0.d, "Consent flow is already in progress.")));
            return;
        }
        List listA = a1.a(this.f729a);
        this.d = listA;
        this.e = String.valueOf(listA);
        this.g = cVar;
        v0 v0VarA = a(i);
        this.f729a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f729a.O().a("ConsentFlowStateMachine", "Starting consent flow with states: " + this.d + "\nInitial state: " + v0VarA);
        }
        com.applovin.impl.sdk.k.a(activity).a(this.n);
        this.f729a.w0().a(d2.m);
        this.j = SystemClock.elapsedRealtime();
        a((v0) null, v0VarA, activity);
    }

    public boolean a() {
        return this.d != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v0 v0Var, Activity activity, Boolean bool) {
        a(v0Var, a(v0Var.a(bool)), activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v0 v0Var, v0 v0Var2, Activity activity) {
        this.f = v0Var;
        c(v0Var2, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(v0 v0Var, final Activity activity) {
        boolean z;
        SpannableString spannableString;
        boolean z2;
        if (v0Var == null) {
            a("Consent flow state is null");
            return;
        }
        this.f729a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f729a.O().a("ConsentFlowStateMachine", "Transitioning to state: " + v0Var);
        }
        long jElapsedRealtime = this.f != null ? SystemClock.elapsedRealtime() - this.k : 0L;
        this.k = SystemClock.elapsedRealtime();
        this.c.a(v0Var, jElapsedRealtime);
        if (v0Var.d() == v0.b.ALERT) {
            if (com.applovin.impl.d.d(activity)) {
                a(v0Var);
                return;
            }
            this.f729a.F().trackEvent("cf_start");
            w0 w0Var = (w0) v0Var;
            this.h = w0Var;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(false);
            Uri uriH = this.f729a.x().h();
            final boolean z3 = uriH != null;
            for (x0 x0Var : w0Var.f()) {
                b bVar = new b(z3, x0Var, v0Var, activity);
                if (x0Var.c() == x0.a.POSITIVE) {
                    builder.setPositiveButton(x0Var.d(), bVar);
                } else if (x0Var.c() == x0.a.NEGATIVE) {
                    builder.setNegativeButton(x0Var.d(), bVar);
                } else {
                    builder.setNeutralButton(x0Var.d(), bVar);
                }
            }
            String strH = w0Var.h();
            if (StringUtils.isValidString(strH)) {
                spannableString = new SpannableString(strH);
                String strA = com.applovin.impl.sdk.k.a(R.string.applovin_terms_of_service_text);
                String strA2 = com.applovin.impl.sdk.k.a(R.string.applovin_privacy_policy_text);
                if (StringUtils.containsAtLeastOneSubstring(strH, Arrays.asList(strA, strA2))) {
                    if (z3) {
                        z2 = true;
                        StringUtils.addLinks(spannableString, Pattern.compile(strA), new c(uriH, activity), true);
                    } else {
                        z2 = true;
                    }
                    StringUtils.addLinks(spannableString, Pattern.compile(strA2), new d(this.f729a.x().f(), activity), z2);
                }
            } else {
                spannableString = null;
            }
            final AlertDialog alertDialogCreate = builder.setTitle(spannableString).setMessage(w0Var.g()).create();
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.applovin.impl.z0$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    this.f$0.a(alertDialogCreate, activity, z3, dialogInterface);
                }
            });
            this.i = alertDialogCreate;
            alertDialogCreate.show();
            this.m.d();
            return;
        }
        if (v0Var.d() == v0.b.POST_ALERT) {
            if (this.f729a.x().k() && this.f729a.x().m()) {
                if (com.applovin.impl.d.d(activity)) {
                    a(v0Var);
                    return;
                } else {
                    this.f729a.w0().a(d2.p);
                    this.f729a.s().loadCmp(activity, new e(SystemClock.elapsedRealtime(), v0Var, activity));
                    return;
                }
            }
            a(v0Var, activity, Boolean.FALSE);
            return;
        }
        if (v0Var.d() == v0.b.EVENT) {
            y0 y0Var = (y0) v0Var;
            String strG = y0Var.g();
            Map<String, ?> mapF = y0Var.f();
            if (mapF == null) {
                mapF = new HashMap<>(1);
            }
            mapF.put("flow_type", "unified");
            this.f729a.F().trackEvent(strG, mapF);
            b(y0Var, activity);
            return;
        }
        if (v0Var.d() == v0.b.CMP_LOAD) {
            if (com.applovin.impl.d.d(activity)) {
                a(v0Var);
                return;
            } else if (this.f729a.x().m()) {
                this.f729a.s().preloadCmp(activity);
                a(v0Var, activity, Boolean.FALSE);
                return;
            } else {
                this.f729a.w0().a(d2.p);
                this.f729a.s().loadCmp(activity, new f(SystemClock.elapsedRealtime(), v0Var, activity));
                return;
            }
        }
        if (v0Var.d() == v0.b.CMP_SHOW) {
            if (com.applovin.impl.d.d(activity)) {
                a(v0Var);
                return;
            }
            if (!this.f729a.x().m()) {
                this.f729a.F().trackEvent("cf_start");
            }
            this.f729a.w0().a(d2.s);
            this.f729a.s().showCmp(activity, new g(SystemClock.elapsedRealtime(), v0Var, activity));
            return;
        }
        if (v0Var.d() == v0.b.DECISION) {
            v0.a aVarA = v0Var.a();
            if (aVarA == v0.a.IS_AL_GDPR) {
                boolean zK = this.f729a.x().k();
                this.c.a(v0Var, zK, jElapsedRealtime);
                a(v0Var, activity, Boolean.valueOf(zK));
                return;
            } else if (aVarA == v0.a.IS_ELIGIBLE_FOR_TERMS_AND_PRIVACY_POLICY_ALERT) {
                z = (this.f729a.A0() ^ true) || ((Boolean) this.f729a.a(a5.t, Boolean.FALSE)).booleanValue();
                this.c.a(v0Var, z, jElapsedRealtime);
                a(v0Var, activity, Boolean.valueOf(z));
                return;
            } else {
                if (aVarA != v0.a.HAS_TERMS_OF_SERVICE_URI) {
                    a("Invalid consent flow decision type: " + aVarA);
                    return;
                }
                z = this.f729a.x().h() != null;
                this.c.a(v0Var, z, jElapsedRealtime);
                a(v0Var, activity, Boolean.valueOf(z));
                return;
            }
        }
        if (v0Var.d() == v0.b.REINIT) {
            b();
            return;
        }
        a("Invalid consent flow destination state: " + v0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AlertDialog alertDialog, Activity activity, boolean z, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(alertDialog.getContext().getResources().getIdentifier("android:id/alertTitle", null, null));
        textView.setLinkTextColor(textView.getCurrentTextColor());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setMaxLines(this.b);
        textView.setMinHeight(AppLovinSdkUtils.dpToPx(activity, 48));
        this.l = SystemClock.elapsedRealtime();
        this.f729a.w0().d(d2.n, CollectionUtils.hashMap("details", String.valueOf(z)));
    }

    private void a(v0 v0Var) {
        this.c.b();
        AppLovinSdkUtils.runOnUiThreadDelayed(new h(v0Var), TimeUnit.SECONDS.toMillis(1L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        l1.a(str, new Object[0]);
        this.f729a.D().a(d2.O0, str, CollectionUtils.hashMap("details", "Last started states: " + this.e + "\nLast successful state: " + this.f));
        this.c.b(str);
        u0.b bVar = this.m;
        if (bVar != null) {
            bVar.a(new s0(s0.e, str));
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public v0 a(int i) {
        List<v0> list = this.d;
        if (list == null) {
            return null;
        }
        for (v0 v0Var : list) {
            if (i == v0Var.c()) {
                return v0Var;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity a(Dialog dialog) {
        Context context = dialog.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        if (baseContext instanceof Activity) {
            return (Activity) baseContext;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppLovinCmpError appLovinCmpError, long j) {
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("duration_ms", String.valueOf(j));
        if (appLovinCmpError == null) {
            this.f729a.w0().d(d2.q, mapHashMap);
        } else {
            mapHashMap.putAll(a(appLovinCmpError));
            this.f729a.w0().d(d2.r, mapHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap a(AppLovinCmpError appLovinCmpError) {
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, appLovinCmpError.getMessage());
        CollectionUtils.putStringIfValid("mediated_network_error_message", appLovinCmpError.getCmpMessage(), mapHashMap);
        CollectionUtils.putStringIfValid(NativeProtocol.BRIDGE_ARG_ERROR_CODE, String.valueOf(appLovinCmpError.getCode().getValue()), mapHashMap);
        CollectionUtils.putStringIfValid("mediated_network_error_code", String.valueOf(appLovinCmpError.getCmpCode()), mapHashMap);
        return mapHashMap;
    }
}
