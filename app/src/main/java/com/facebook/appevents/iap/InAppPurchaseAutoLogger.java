package com.facebook.appevents.iap;

import android.content.Context;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: InAppPurchaseAutoLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseAutoLogger;", "", "()V", "failedToCreateWrapper", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getFailedToCreateWrapper", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "logPurchase", "", "billingClientVersion", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "packageName", "", "startIapLogging", "context", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InAppPurchaseAutoLogger {
    public static final InAppPurchaseAutoLogger INSTANCE = new InAppPurchaseAutoLogger();
    private static final AtomicBoolean failedToCreateWrapper = new AtomicBoolean(false);

    private InAppPurchaseAutoLogger() {
    }

    public final AtomicBoolean getFailedToCreateWrapper() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return failedToCreateWrapper;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006e A[Catch: all -> 0x007e, TRY_LEAVE, TryCatch #1 {all -> 0x007e, blocks: (B:8:0x000d, B:12:0x0021, B:14:0x002a, B:18:0x003f, B:20:0x0043, B:23:0x0049, B:25:0x0053, B:27:0x005b, B:29:0x005f, B:30:0x006e, B:15:0x0033, B:17:0x0037), top: B:41:0x000d, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV5V7] */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV2V4] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final synchronized void startIapLogging(final android.content.Context r5, final com.facebook.appevents.iap.InAppPurchaseUtils.BillingClientVersion r6) {
        /*
            java.lang.Class<com.facebook.appevents.iap.InAppPurchaseAutoLogger> r0 = com.facebook.appevents.iap.InAppPurchaseAutoLogger.class
            monitor-enter(r0)
            java.lang.Class<com.facebook.appevents.iap.InAppPurchaseAutoLogger> r1 = com.facebook.appevents.iap.InAppPurchaseAutoLogger.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto Ld
            monitor-exit(r0)
            return
        Ld:
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r1 = "billingClientVersion"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)     // Catch: java.lang.Throwable -> L7e
            java.util.concurrent.atomic.AtomicBoolean r1 = com.facebook.appevents.iap.InAppPurchaseAutoLogger.failedToCreateWrapper     // Catch: java.lang.Throwable -> L7e
            boolean r2 = r1.get()     // Catch: java.lang.Throwable -> L7e
            if (r2 == 0) goto L21
            monitor-exit(r0)
            return
        L21:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> L7e
            r2.<init>()     // Catch: java.lang.Throwable -> L7e
            com.facebook.appevents.iap.InAppPurchaseUtils$BillingClientVersion r3 = com.facebook.appevents.iap.InAppPurchaseUtils.BillingClientVersion.V2_V4     // Catch: java.lang.Throwable -> L7e
            if (r6 != r3) goto L33
            com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV2V4$Companion r3 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV2V4.INSTANCE     // Catch: java.lang.Throwable -> L7e
            com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV2V4 r3 = r3.getOrCreateInstance(r5)     // Catch: java.lang.Throwable -> L7e
            r2.element = r3     // Catch: java.lang.Throwable -> L7e
            goto L3f
        L33:
            com.facebook.appevents.iap.InAppPurchaseUtils$BillingClientVersion r3 = com.facebook.appevents.iap.InAppPurchaseUtils.BillingClientVersion.V5_V7     // Catch: java.lang.Throwable -> L7e
            if (r6 != r3) goto L3f
            com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV5V7$Companion r3 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV5V7.INSTANCE     // Catch: java.lang.Throwable -> L7e
            com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV5V7 r3 = r3.getOrCreateInstance(r5)     // Catch: java.lang.Throwable -> L7e
            r2.element = r3     // Catch: java.lang.Throwable -> L7e
        L3f:
            T r3 = r2.element     // Catch: java.lang.Throwable -> L7e
            if (r3 != 0) goto L49
            r5 = 1
            r1.set(r5)     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r0)
            return
        L49:
            com.facebook.internal.FeatureManager r1 = com.facebook.internal.FeatureManager.INSTANCE     // Catch: java.lang.Throwable -> L7e
            com.facebook.internal.FeatureManager$Feature r1 = com.facebook.internal.FeatureManager.Feature.AndroidIAPSubscriptionAutoLogging     // Catch: java.lang.Throwable -> L7e
            boolean r1 = com.facebook.internal.FeatureManager.isEnabled(r1)     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L6e
            com.facebook.appevents.integrity.ProtectedModeManager r1 = com.facebook.appevents.integrity.ProtectedModeManager.INSTANCE     // Catch: java.lang.Throwable -> L7e
            boolean r1 = com.facebook.appevents.integrity.ProtectedModeManager.isEnabled()     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L5f
            com.facebook.appevents.iap.InAppPurchaseUtils$BillingClientVersion r1 = com.facebook.appevents.iap.InAppPurchaseUtils.BillingClientVersion.V2_V4     // Catch: java.lang.Throwable -> L7e
            if (r6 != r1) goto L6e
        L5f:
            T r1 = r2.element     // Catch: java.lang.Throwable -> L7e
            com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r1 = (com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper) r1     // Catch: java.lang.Throwable -> L7e
            com.facebook.appevents.iap.InAppPurchaseUtils$IAPProductType r3 = com.facebook.appevents.iap.InAppPurchaseUtils.IAPProductType.INAPP     // Catch: java.lang.Throwable -> L7e
            com.facebook.appevents.iap.InAppPurchaseAutoLogger$$ExternalSyntheticLambda1 r4 = new com.facebook.appevents.iap.InAppPurchaseAutoLogger$$ExternalSyntheticLambda1     // Catch: java.lang.Throwable -> L7e
            r4.<init>()     // Catch: java.lang.Throwable -> L7e
            r1.queryPurchaseHistory(r3, r4)     // Catch: java.lang.Throwable -> L7e
            goto L7c
        L6e:
            T r1 = r2.element     // Catch: java.lang.Throwable -> L7e
            com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r1 = (com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper) r1     // Catch: java.lang.Throwable -> L7e
            com.facebook.appevents.iap.InAppPurchaseUtils$IAPProductType r2 = com.facebook.appevents.iap.InAppPurchaseUtils.IAPProductType.INAPP     // Catch: java.lang.Throwable -> L7e
            com.facebook.appevents.iap.InAppPurchaseAutoLogger$$ExternalSyntheticLambda2 r3 = new com.facebook.appevents.iap.InAppPurchaseAutoLogger$$ExternalSyntheticLambda2     // Catch: java.lang.Throwable -> L7e
            r3.<init>()     // Catch: java.lang.Throwable -> L7e
            r1.queryPurchaseHistory(r2, r3)     // Catch: java.lang.Throwable -> L7e
        L7c:
            monitor-exit(r0)
            return
        L7e:
            r5 = move-exception
            java.lang.Class<com.facebook.appevents.iap.InAppPurchaseAutoLogger> r6 = com.facebook.appevents.iap.InAppPurchaseAutoLogger.class
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r6)     // Catch: java.lang.Throwable -> L86
            monitor-exit(r0)
            return
        L86:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseAutoLogger.startIapLogging(android.content.Context, com.facebook.appevents.iap.InAppPurchaseUtils$BillingClientVersion):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startIapLogging$lambda-1, reason: not valid java name */
    public static final void m4747startIapLogging$lambda1(Ref.ObjectRef billingClientWrapper, final InAppPurchaseUtils.BillingClientVersion billingClientVersion, final Context context) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(billingClientWrapper, "$billingClientWrapper");
            Intrinsics.checkNotNullParameter(billingClientVersion, "$billingClientVersion");
            Intrinsics.checkNotNullParameter(context, "$context");
            ((InAppPurchaseBillingClientWrapper) billingClientWrapper.element).queryPurchaseHistory(InAppPurchaseUtils.IAPProductType.SUBS, new Runnable() { // from class: com.facebook.appevents.iap.InAppPurchaseAutoLogger$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseAutoLogger.m4748startIapLogging$lambda1$lambda0(billingClientVersion, context);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startIapLogging$lambda-1$lambda-0, reason: not valid java name */
    public static final void m4748startIapLogging$lambda1$lambda0(InAppPurchaseUtils.BillingClientVersion billingClientVersion, Context context) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(billingClientVersion, "$billingClientVersion");
            Intrinsics.checkNotNullParameter(context, "$context");
            InAppPurchaseAutoLogger inAppPurchaseAutoLogger = INSTANCE;
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            inAppPurchaseAutoLogger.logPurchase(billingClientVersion, packageName);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startIapLogging$lambda-2, reason: not valid java name */
    public static final void m4749startIapLogging$lambda2(InAppPurchaseUtils.BillingClientVersion billingClientVersion, Context context) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(billingClientVersion, "$billingClientVersion");
            Intrinsics.checkNotNullParameter(context, "$context");
            InAppPurchaseAutoLogger inAppPurchaseAutoLogger = INSTANCE;
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            inAppPurchaseAutoLogger.logPurchase(billingClientVersion, packageName);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
        }
    }

    private final void logPurchase(InAppPurchaseUtils.BillingClientVersion billingClientVersion, String packageName) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
            boolean isFirstAppLaunchWithNewIAP = InAppPurchaseLoggerManager.getIsFirstAppLaunchWithNewIAP();
            if (isFirstAppLaunchWithNewIAP) {
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager2 = InAppPurchaseLoggerManager.INSTANCE;
                InAppPurchaseLoggerManager.migrateOldCacheHistory();
            }
            if (billingClientVersion == InAppPurchaseUtils.BillingClientVersion.V2_V4) {
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager3 = InAppPurchaseLoggerManager.INSTANCE;
                InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapperV2V4.INSTANCE.getIapPurchaseDetailsMap(), InAppPurchaseBillingClientWrapperV2V4.INSTANCE.getSkuDetailsMap(), false, packageName, billingClientVersion, isFirstAppLaunchWithNewIAP);
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager4 = InAppPurchaseLoggerManager.INSTANCE;
                InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapperV2V4.INSTANCE.getSubsPurchaseDetailsMap(), InAppPurchaseBillingClientWrapperV2V4.INSTANCE.getSkuDetailsMap(), true, packageName, billingClientVersion, isFirstAppLaunchWithNewIAP);
                InAppPurchaseBillingClientWrapperV2V4.INSTANCE.getIapPurchaseDetailsMap().clear();
                InAppPurchaseBillingClientWrapperV2V4.INSTANCE.getSubsPurchaseDetailsMap().clear();
            } else {
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager5 = InAppPurchaseLoggerManager.INSTANCE;
                InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapperV5V7.INSTANCE.getIapPurchaseDetailsMap(), InAppPurchaseBillingClientWrapperV5V7.INSTANCE.getProductDetailsMap(), false, packageName, billingClientVersion, isFirstAppLaunchWithNewIAP);
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager6 = InAppPurchaseLoggerManager.INSTANCE;
                InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapperV5V7.INSTANCE.getSubsPurchaseDetailsMap(), InAppPurchaseBillingClientWrapperV5V7.INSTANCE.getProductDetailsMap(), true, packageName, billingClientVersion, isFirstAppLaunchWithNewIAP);
                InAppPurchaseBillingClientWrapperV5V7.INSTANCE.getIapPurchaseDetailsMap().clear();
                InAppPurchaseBillingClientWrapperV5V7.INSTANCE.getSubsPurchaseDetailsMap().clear();
            }
            if (isFirstAppLaunchWithNewIAP) {
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager7 = InAppPurchaseLoggerManager.INSTANCE;
                InAppPurchaseLoggerManager.setAppHasBeenLaunchedWithNewIAP();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
