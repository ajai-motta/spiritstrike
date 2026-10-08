package com.applovin.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f379a;
    private CustomTabsClient b;

    class a extends CustomTabsServiceConnection {
        a() {
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            f1.this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                f1.this.f379a.O().a("CustomTabsManager", "Connection successful: " + componentName);
            }
            f1.this.b = customTabsClient;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            f1.this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                f1.this.f379a.O().a("CustomTabsManager", "Service disconnected: " + componentName);
            }
            f1.this.b = null;
        }
    }

    private class b extends CustomTabsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f381a;

        public b(com.applovin.impl.adview.a aVar) {
            this.f381a = new WeakReference(aVar);
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
            com.applovin.impl.adview.a aVar = (com.applovin.impl.adview.a) this.f381a.get();
            if (aVar == null) {
                f1.this.f379a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    f1.this.f379a.O().b("CustomTabsManager", "Unable to track navigation event (" + i + "). Controller is null.");
                }
                return;
            }
            com.applovin.impl.sdk.ad.b bVarG = aVar.g();
            if (bVarG == null) {
                f1.this.f379a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    f1.this.f379a.O().b("CustomTabsManager", "Unable to track navigation event (" + i + "). No ad specified.");
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    if (bVarG.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackCustomTabsNavigationStarted(bVarG);
                    }
                    break;
                case 2:
                    if (bVarG.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackCustomTabsNavigationFinished(bVarG);
                    }
                    break;
                case 3:
                    if (bVarG.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackCustomTabsNavigationFailed(bVarG);
                    }
                    break;
                case 4:
                    if (bVarG.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackCustomTabsNavigationAborted(bVarG);
                    }
                    break;
                case 5:
                    if (bVarG.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackCustomTabsTabShown(bVarG);
                    }
                    AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_shown"), null);
                    t2.c(aVar.e(), bVarG, aVar.i());
                    break;
                case 6:
                    if (bVarG.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackCustomTabsTabHidden(bVarG);
                    }
                    AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_hidden"), null);
                    t2.a(aVar.e(), bVarG, aVar.i());
                    break;
                default:
                    f1.this.f379a.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        f1.this.f379a.O().a("CustomTabsManager", "Unknown navigation event: " + i);
                    }
                    break;
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
            f1.this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                com.applovin.impl.sdk.o oVarO = f1.this.f379a.O();
                StringBuilder sb = new StringBuilder("Validation ");
                sb.append(z ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
                sb.append(" for session-URL relation(");
                sb.append(i);
                sb.append("), requestedOrigin(");
                sb.append(uri);
                sb.append(")");
                oVarO.a("CustomTabsManager", sb.toString());
            }
        }
    }

    private class c extends CustomTabsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f382a;

        public c(AppLovinNativeAdImpl appLovinNativeAdImpl) {
            this.f382a = new WeakReference(appLovinNativeAdImpl);
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
            AppLovinNativeAdImpl appLovinNativeAdImpl = (AppLovinNativeAdImpl) this.f382a.get();
            if (appLovinNativeAdImpl == null) {
                f1.this.f379a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    f1.this.f379a.O().b("CustomTabsManager", "Unable to track navigation event (" + i + "). Native ad is null.");
                }
                return;
            }
            switch (i) {
                case 1:
                    if (appLovinNativeAdImpl.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackNativeAdCustomTabsNavigationStarted(appLovinNativeAdImpl);
                    }
                    break;
                case 2:
                    if (appLovinNativeAdImpl.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackNativeAdCustomTabsNavigationFinished(appLovinNativeAdImpl);
                    }
                    break;
                case 3:
                    if (appLovinNativeAdImpl.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackNativeAdCustomTabsNavigationFailed(appLovinNativeAdImpl);
                    }
                    break;
                case 4:
                    if (appLovinNativeAdImpl.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackNativeAdCustomTabsNavigationAborted(appLovinNativeAdImpl);
                    }
                    break;
                case 5:
                    if (appLovinNativeAdImpl.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackNativeAdCustomTabsTabShown(appLovinNativeAdImpl);
                    }
                    AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_shown"), null);
                    break;
                case 6:
                    if (appLovinNativeAdImpl.shouldCustomTabsTrackEvents()) {
                        f1.this.f379a.k().trackNativeAdCustomTabsTabHidden(appLovinNativeAdImpl);
                    }
                    AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_hidden"), null);
                    break;
                default:
                    f1.this.f379a.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        f1.this.f379a.O().a("CustomTabsManager", "Unknown navigation event: " + i);
                    }
                    break;
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
            f1.this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                com.applovin.impl.sdk.o oVarO = f1.this.f379a.O();
                StringBuilder sb = new StringBuilder("Validation ");
                sb.append(z ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
                sb.append(" for session-URL relation(");
                sb.append(i);
                sb.append("), requestedOrigin(");
                sb.append(uri);
                sb.append(")");
                oVarO.a("CustomTabsManager", sb.toString());
            }
        }
    }

    public f1(com.applovin.impl.sdk.k kVar) {
        this.f379a = kVar;
    }

    public void b(final List list, final CustomTabsSession customTabsSession) {
        if (list.isEmpty()) {
            return;
        }
        if (customTabsSession != null) {
            a("warmup urls", new Runnable() { // from class: com.applovin.impl.f1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(list, customTabsSession);
                }
            });
            return;
        }
        this.f379a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f379a.O().a("CustomTabsManager", "Custom Tabs session is null, cannot warmup urls");
        }
    }

    public void a() {
        if (((Boolean) this.f379a.a(y4.d7)).booleanValue() && this.b == null) {
            String packageName = CustomTabsClient.getPackageName(com.applovin.impl.sdk.k.o(), this.f379a.c(y4.e7), true);
            String packageName2 = CustomTabsClient.getPackageName(com.applovin.impl.sdk.k.o(), null);
            LinkedList linkedList = new LinkedList();
            if (((Boolean) this.f379a.a(y4.f7)).booleanValue()) {
                CollectionUtils.addUniqueObjectIfExists(packageName2, linkedList);
                CollectionUtils.addUniqueObjectIfExists(packageName, linkedList);
            } else {
                CollectionUtils.addUniqueObjectIfExists(packageName, linkedList);
                CollectionUtils.addUniqueObjectIfExists(packageName2, linkedList);
            }
            if (linkedList.isEmpty()) {
                this.f379a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f379a.O().b("CustomTabsManager", "Unable to find a supported Custom Tabs package name");
                    return;
                }
                return;
            }
            a(linkedList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(g1 g1Var, CustomTabsSession customTabsSession) {
        this.b.warmup(0L);
        if (g1Var == null) {
            return;
        }
        Integer numE = g1Var.e();
        String strB = g1Var.b();
        if (numE == null || TextUtils.isEmpty(strB)) {
            return;
        }
        if (customTabsSession == null) {
            this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f379a.O().b("CustomTabsManager", "Cannot validate session-URL relation because the session is null");
                return;
            }
            return;
        }
        this.f379a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f379a.O().a("CustomTabsManager", "Validating session-URL relation: " + numE + " with digital asset link: " + strB);
        }
        customTabsSession.validateRelationship(numE.intValue(), Uri.parse(strB), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.LinkedList r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Retrying with next package name..."
            java.lang.String r1 = "CustomTabsManager"
            r2 = 0
            android.content.Context r3 = com.applovin.impl.sdk.k.o()     // Catch: java.lang.Throwable -> L44
            java.lang.Object r4 = r7.poll()     // Catch: java.lang.Throwable -> L44
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L44
            com.applovin.impl.f1$a r5 = new com.applovin.impl.f1$a     // Catch: java.lang.Throwable -> L44
            r5.<init>()     // Catch: java.lang.Throwable -> L44
            boolean r2 = androidx.browser.customtabs.CustomTabsClient.bindCustomTabsService(r3, r4, r5)     // Catch: java.lang.Throwable -> L44
            if (r2 != 0) goto L30
            com.applovin.impl.sdk.k r3 = r6.f379a     // Catch: java.lang.Throwable -> L44
            r3.O()     // Catch: java.lang.Throwable -> L44
            boolean r3 = com.applovin.impl.sdk.o.a()     // Catch: java.lang.Throwable -> L44
            if (r3 == 0) goto L30
            com.applovin.impl.sdk.k r3 = r6.f379a     // Catch: java.lang.Throwable -> L44
            com.applovin.impl.sdk.o r3 = r3.O()     // Catch: java.lang.Throwable -> L44
            java.lang.String r4 = "Custom Tabs service not available"
            r3.b(r1, r4)     // Catch: java.lang.Throwable -> L44
        L30:
            if (r2 != 0) goto L7a
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L7a
            com.applovin.impl.sdk.k r2 = r6.f379a
            r2.O()
            boolean r2 = com.applovin.impl.sdk.o.a()
            if (r2 == 0) goto L77
            goto L6e
        L44:
            r3 = move-exception
            com.applovin.impl.sdk.k r4 = r6.f379a     // Catch: java.lang.Throwable -> L7b
            r4.O()     // Catch: java.lang.Throwable -> L7b
            boolean r4 = com.applovin.impl.sdk.o.a()     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L5b
            com.applovin.impl.sdk.k r4 = r6.f379a     // Catch: java.lang.Throwable -> L7b
            com.applovin.impl.sdk.o r4 = r4.O()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = "Failed to bind to service"
            r4.a(r1, r5, r3)     // Catch: java.lang.Throwable -> L7b
        L5b:
            if (r2 != 0) goto L7a
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L7a
            com.applovin.impl.sdk.k r2 = r6.f379a
            r2.O()
            boolean r2 = com.applovin.impl.sdk.o.a()
            if (r2 == 0) goto L77
        L6e:
            com.applovin.impl.sdk.k r2 = r6.f379a
            com.applovin.impl.sdk.o r2 = r2.O()
            r2.a(r1, r0)
        L77:
            r6.a(r7)
        L7a:
            return
        L7b:
            r3 = move-exception
            if (r2 != 0) goto L9b
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L9b
            com.applovin.impl.sdk.k r2 = r6.f379a
            r2.O()
            boolean r2 = com.applovin.impl.sdk.o.a()
            if (r2 == 0) goto L98
            com.applovin.impl.sdk.k r2 = r6.f379a
            com.applovin.impl.sdk.o r2 = r2.O()
            r2.a(r1, r0)
        L98:
            r6.a(r7)
        L9b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.f1.a(java.util.LinkedList):void");
    }

    public CustomTabsSession a(com.applovin.impl.adview.a aVar) {
        if (this.b == null) {
            this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f379a.O().a("CustomTabsManager", "Custom Tabs service is not connected, cannot start session");
            }
            return null;
        }
        this.f379a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f379a.O().a("CustomTabsManager", "Starting Custom Tabs session");
        }
        try {
            CustomTabsSession customTabsSessionNewSession = this.b.newSession(new b(aVar));
            a(customTabsSessionNewSession, aVar.g());
            return customTabsSessionNewSession;
        } catch (Exception e) {
            this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f379a.O().a("CustomTabsManager", "Failed to create Custom Tabs session", e);
            }
            return null;
        }
    }

    public CustomTabsSession a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        if (this.b == null) {
            this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f379a.O().a("CustomTabsManager", "Custom Tabs service is not connected, cannot start session");
            }
            return null;
        }
        this.f379a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f379a.O().a("CustomTabsManager", "Starting Custom Tabs session");
        }
        try {
            CustomTabsSession customTabsSessionNewSession = this.b.newSession(new c(appLovinNativeAdImpl));
            a(customTabsSessionNewSession, appLovinNativeAdImpl);
            return customTabsSessionNewSession;
        } catch (Exception e) {
            this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f379a.O().a("CustomTabsManager", "Failed to create Custom Tabs session", e);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, CustomTabsSession customTabsSession) {
        this.f379a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f379a.O().a("CustomTabsManager", "Warming up URLs: " + list);
        }
        String str = (String) list.remove(0);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CustomTabsService.KEY_URL, Uri.parse(str2));
            arrayList.add(bundle);
        }
        boolean zMayLaunchUrl = customTabsSession.mayLaunchUrl(Uri.parse(str), null, arrayList);
        this.f379a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f379a.O().a("CustomTabsManager", "Warmup for URLs ".concat(zMayLaunchUrl ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed"));
        }
    }

    public void a(final Uri uri, final com.applovin.impl.adview.a aVar, final Activity activity) {
        if (aVar.h() == null) {
            this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f379a.O().b("CustomTabsManager", "Unable to launch URL in Custom Tabs. No Custom Tabs session found.");
            }
            a(uri, activity);
            return;
        }
        if (a("launch uri", new Runnable() { // from class: com.applovin.impl.f1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(aVar, activity, uri);
            }
        })) {
            this.f379a.n0().pauseForClick();
            return;
        }
        this.f379a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f379a.O().b("CustomTabsManager", "Opening in Custom Tabs failed: " + uri);
        }
        a(uri, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.adview.a aVar, Activity activity, Uri uri) {
        a(aVar, activity).launchUrl(activity, uri);
    }

    public boolean a(final Uri uri, final AppLovinNativeAdImpl appLovinNativeAdImpl, final Activity activity) {
        if (appLovinNativeAdImpl.getCustomTabsSession() == null) {
            this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f379a.O().b("CustomTabsManager", "Unable to launch URL in Custom Tabs. No Custom Tabs session found.");
            }
            a(uri, activity);
            return false;
        }
        boolean zA = a("launch uri", new Runnable() { // from class: com.applovin.impl.f1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(appLovinNativeAdImpl, activity, uri);
            }
        });
        if (zA) {
            this.f379a.n0().pauseForClick();
        } else {
            this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f379a.O().b("CustomTabsManager", "Opening in Custom Tabs failed: " + uri);
            }
            a(uri, activity);
        }
        return zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinNativeAdImpl appLovinNativeAdImpl, Activity activity, Uri uri) {
        a(appLovinNativeAdImpl, activity).launchUrl(activity, uri);
    }

    private void a(CustomTabsSession customTabsSession, com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null || !bVar.isCustomTabsClientWarmupEnabled()) {
            return;
        }
        a(bVar.getCustomTabsSettings(), customTabsSession);
    }

    private void a(CustomTabsSession customTabsSession, AppLovinNativeAdImpl appLovinNativeAdImpl) {
        if (appLovinNativeAdImpl == null || !appLovinNativeAdImpl.isCustomTabsClientWarmupEnabled()) {
            return;
        }
        a(appLovinNativeAdImpl.getCustomTabsSettings(), customTabsSession);
    }

    private void a(final g1 g1Var, final CustomTabsSession customTabsSession) {
        a("client warmup", new Runnable() { // from class: com.applovin.impl.f1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(g1Var, customTabsSession);
            }
        });
    }

    private CustomTabsIntent a(com.applovin.impl.adview.a aVar, Activity activity) {
        com.applovin.impl.sdk.ad.b bVarG = aVar.g();
        return a(bVarG != null ? bVarG.getCustomTabsSettings() : null, bVarG != null ? bVarG.getCustomTabsHeaders() : Bundle.EMPTY, aVar.h(), activity);
    }

    private CustomTabsIntent a(AppLovinNativeAdImpl appLovinNativeAdImpl, Activity activity) {
        return a(appLovinNativeAdImpl.getCustomTabsSettings(), appLovinNativeAdImpl.getCustomTabsHeaders(), appLovinNativeAdImpl.getCustomTabsSession(), activity);
    }

    private CustomTabsIntent a(g1 g1Var, Bundle bundle, CustomTabsSession customTabsSession, Activity activity) {
        this.f379a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f379a.O().a("CustomTabsManager", "Creating Custom Tabs intent");
        }
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(customTabsSession);
        if (((Boolean) this.f379a.a(y4.g7)).booleanValue()) {
            builder.setStartAnimations(activity, R.anim.applovin_slide_up_animation, R.anim.applovin_slide_down_animation);
            builder.setExitAnimations(activity, R.anim.applovin_slide_up_animation, R.anim.applovin_slide_down_animation);
        }
        if (g1Var != null) {
            Integer numH = g1Var.h();
            if (numH != null) {
                builder.setDefaultColorSchemeParams(new CustomTabColorSchemeParams.Builder().setToolbarColor(numH.intValue()).build());
            }
            Integer numA = g1Var.a();
            if (numA != null) {
                builder.setColorSchemeParams(2, new CustomTabColorSchemeParams.Builder().setToolbarColor(numA.intValue()).build());
            }
            Boolean boolI = g1Var.i();
            if (boolI != null) {
                builder.setUrlBarHidingEnabled(boolI.booleanValue());
            }
            Boolean boolG = g1Var.g();
            if (boolG != null) {
                builder.setShowTitle(boolG.booleanValue());
            }
            Boolean boolC = g1Var.c();
            if (boolC != null) {
                builder.setInstantAppsEnabled(boolC.booleanValue());
            }
            Integer numF = g1Var.f();
            if (numF != null) {
                builder.setShareState(numF.intValue());
            }
        }
        CustomTabsIntent customTabsIntentBuild = builder.build();
        if (g1Var != null) {
            String strD = g1Var.d();
            if (strD != null) {
                customTabsIntentBuild.intent.putExtra("android.intent.extra.REFERRER", Uri.parse(strD));
            }
            if (!bundle.isEmpty()) {
                customTabsIntentBuild.intent.putExtra("com.android.browser.headers", bundle);
            }
        }
        return customTabsIntentBuild;
    }

    private void a(Uri uri, Activity activity) {
        if (((Boolean) this.f379a.a(y4.h7)).booleanValue()) {
            l7.a(uri, activity, this.f379a);
        }
        AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_failure"), CollectionUtils.map("url", uri));
    }

    private boolean a(String str, Runnable runnable) {
        try {
            this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f379a.O().a("CustomTabsManager", "Running operation: " + str);
            }
            runnable.run();
            this.f379a.O();
            if (!com.applovin.impl.sdk.o.a()) {
                return true;
            }
            this.f379a.O().a("CustomTabsManager", "Finished operation: " + str);
            return true;
        } catch (Throwable th) {
            this.f379a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f379a.O().a("CustomTabsManager", "Failed to run operation: " + str, th);
            }
            this.f379a.D().a("CustomTabsManager", str, th);
            return false;
        }
    }
}
