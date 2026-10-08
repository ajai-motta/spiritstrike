package com.hive.analytics;

import android.content.Context;
import android.content.Intent;
import com.adjust.sdk.Constants;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.base.Property;
import com.hive.base.PropertyKeys;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ3\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00070\r¨\u0006\u0011"}, d2 = {"Lcom/hive/analytics/AnalyticsReferrerSender;", "", "<init>", "()V", "getReferrer", "", "sendToThirdParty", "", "context", "Landroid/content/Context;", "sendToThirdParty$hive_service_release", "playServiceReferrerStart", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "referrerData", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsReferrerSender {
    public static final AnalyticsReferrerSender INSTANCE = new AnalyticsReferrerSender();

    private AnalyticsReferrerSender() {
    }

    public final String getReferrer() {
        return Property.INSTANCE.getINSTANCE().getValue(PropertyKeys.INSTALL_REFERRER);
    }

    public final void playServiceReferrerStart(Context context, final Function1<? super String, Unit> listener) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            Class.forName("com.android.installreferrer.api.InstallReferrerClient");
            z = true;
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("playServiceReferrerStart Exception: " + e);
            z = false;
        }
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AnalyticsReferrerSender] isExistInstallReferrerClient(" + z + ')');
        if (!z) {
            loggerImpl.w("[AnalyticsReferrerSender] google service not available");
            listener.invoke(null);
            return;
        }
        try {
            final InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(context).build();
            installReferrerClientBuild.startConnection(new InstallReferrerStateListener() { // from class: com.hive.analytics.AnalyticsReferrerSender.playServiceReferrerStart.1
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerServiceDisconnected() {
                    LoggerImpl.INSTANCE.w("[AnalyticsReferrerSender] InstallReferrer Service Disconnected");
                    listener.invoke(null);
                }

                /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onInstallReferrerSetupFinished(int r7) {
                    /*
                        r6 = this;
                        r0 = -1
                        r1 = 41
                        r2 = 0
                        if (r7 == r0) goto L96
                        if (r7 == 0) goto L2e
                        r0 = 1
                        if (r7 == r0) goto L96
                        r0 = 2
                        if (r7 == r0) goto L96
                        r0 = 3
                        if (r7 == r0) goto L96
                        com.hive.logger.LoggerImpl r0 = com.hive.logger.LoggerImpl.INSTANCE
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        java.lang.String r4 = "[AnalyticsReferrerSender] InstallReferrerClient response FAILED else ("
                        r3.<init>(r4)
                        r3.append(r7)
                        r3.append(r1)
                        java.lang.String r7 = r3.toString()
                        r0.w(r7)
                        kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r7 = r1
                        r7.invoke(r2)
                        goto Lb1
                    L2e:
                        com.android.installreferrer.api.InstallReferrerClient r7 = r2
                        kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3f
                        com.android.installreferrer.api.ReferrerDetails r7 = r7.getInstallReferrer()     // Catch: java.lang.Throwable -> L3f
                        java.lang.String r7 = r7.getInstallReferrer()     // Catch: java.lang.Throwable -> L3f
                        java.lang.Object r7 = kotlin.Result.m7415constructorimpl(r7)     // Catch: java.lang.Throwable -> L3f
                        goto L4a
                    L3f:
                        r7 = move-exception
                        kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
                        java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
                        java.lang.Object r7 = kotlin.Result.m7415constructorimpl(r7)
                    L4a:
                        kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r0 = r1
                        boolean r1 = kotlin.Result.m7422isSuccessimpl(r7)
                        if (r1 == 0) goto L70
                        r1 = r7
                        java.lang.String r1 = (java.lang.String) r1
                        com.hive.logger.LoggerImpl r3 = com.hive.logger.LoggerImpl.INSTANCE
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder
                        java.lang.String r5 = "[AnalyticsReferrerSender] InstallReferrerClient response OK \n  "
                        r4.<init>(r5)
                        r4.append(r1)
                        java.lang.String r4 = r4.toString()
                        r3.dL(r4)
                        java.lang.String r4 = "[AnalyticsReferrerSender] InstallReferrerClient response OK"
                        r3.dR(r4)
                        r0.invoke(r1)
                    L70:
                        kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r0 = r1
                        java.lang.Throwable r1 = kotlin.Result.m7418exceptionOrNullimpl(r7)
                        if (r1 == 0) goto L92
                        com.hive.logger.LoggerImpl r3 = com.hive.logger.LoggerImpl.INSTANCE
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder
                        java.lang.String r5 = "[AnalyticsReferrerSender] InstallReferrerClient response OK. but failed getInstallReferrer\nthrowable: "
                        r4.<init>(r5)
                        java.lang.String r1 = r1.getMessage()
                        r4.append(r1)
                        java.lang.String r1 = r4.toString()
                        r3.w(r1)
                        r0.invoke(r2)
                    L92:
                        kotlin.Result.m7414boximpl(r7)
                        goto Lb1
                    L96:
                        com.hive.logger.LoggerImpl r0 = com.hive.logger.LoggerImpl.INSTANCE
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        java.lang.String r4 = "[AnalyticsReferrerSender] InstallReferrerClient response FAILED ("
                        r3.<init>(r4)
                        r3.append(r7)
                        r3.append(r1)
                        java.lang.String r7 = r3.toString()
                        r0.w(r7)
                        kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r7 = r1
                        r7.invoke(r2)
                    Lb1:
                        com.android.installreferrer.api.InstallReferrerClient r7 = r2
                        boolean r7 = r7.isReady()
                        if (r7 == 0) goto Lbe
                        com.android.installreferrer.api.InstallReferrerClient r7 = r2
                        r7.endConnection()
                    Lbe:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.analytics.AnalyticsReferrerSender.AnonymousClass1.onInstallReferrerSetupFinished(int):void");
                }
            });
        } catch (Exception e2) {
            LoggerImpl.INSTANCE.w("[AnalyticsReferrerSender] InstallReferrerClient Exception: " + e2);
            listener.invoke(null);
        }
    }

    public final void sendToThirdParty$hive_service_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i("[AnalyticsReferrerSender] send");
        Property.Companion companion = Property.INSTANCE;
        if (Intrinsics.areEqual(companion.getINSTANCE().getValue(PropertyKeys.IS_SENT_REFERRER_TO_THIRD_PARTY), "false")) {
            loggerImpl.i("[AnalyticsReferrerSender] Send Referrer to 3rd-party tracking module");
            Intent intent = new Intent();
            intent.setAction("com.android.vending.INSTALL_REFERRER");
            intent.putExtra(Constants.REFERRER, INSTANCE.getReferrer());
            AnalyticsImpl.INSTANCE.onReferrerReceive(context, intent);
            Property.setValue$default(companion.getINSTANCE(), PropertyKeys.IS_SENT_REFERRER_TO_THIRD_PARTY, "true", null, 4, null);
            companion.getINSTANCE().writeProperties();
        }
    }
}
