package com.hive.social;

import android.app.Activity;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/hive/social/SocialHiveImpl$logoutHub$1$onCreate$1", "Lcom/hive/SocialHive$ShowHiveDialogDataListener;", "onShowHiveDialogWithData", "", "result", "Lcom/hive/ResultAPI;", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialHiveImpl$logoutHub$1$onCreate$1 implements SocialHive.ShowHiveDialogDataListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ SocialHive.ShowPeppermintDialogListener $listener;

    public SocialHiveImpl$logoutHub$1$onCreate$1(Activity activity, SocialHive.ShowPeppermintDialogListener showPeppermintDialogListener) {
        this.$activity = activity;
        this.$listener = showPeppermintDialogListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onShowHiveDialogWithData$lambda$2(SocialHive.ShowPeppermintDialogListener showPeppermintDialogListener, ResultAPI resultAPI, Ref.ObjectRef objectRef) {
        showPeppermintDialogListener.onPeppermintDialog(resultAPI, SocialHiveImpl.INSTANCE.getSocialDialogResultJson(resultAPI, (JSONObject) objectRef.element));
        SocialHiveImpl.isAuthHubInProgress = false;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, org.json.JSONObject] */
    @Override // com.hive.SocialHive.ShowHiveDialogDataListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onShowHiveDialogWithData(final com.hive.ResultAPI r4, org.json.JSONObject r5) {
        /*
            r3 = this;
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4.isSuccess()
            if (r0 == 0) goto L10
            com.hive.standalone.HiveLifecycle r0 = com.hive.standalone.HiveLifecycle.INSTANCE
            r0.onSignOut()
        L10:
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r0.element = r1
            java.lang.String r1 = "logout"
            java.lang.String r2 = "type"
            if (r5 == 0) goto L2a
            r0.element = r5
            org.json.JSONObject r5 = r5.put(r2, r1)
            if (r5 != 0) goto L38
        L2a:
            T r5 = r0.element     // Catch: java.lang.Exception -> L32
            org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch: java.lang.Exception -> L32
            r5.put(r2, r1)     // Catch: java.lang.Exception -> L32
            goto L38
        L32:
            r5 = move-exception
            r5.printStackTrace()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L38:
            android.app.Activity r5 = r3.$activity
            r5.finish()
            com.hive.auth.AuthImpl r5 = com.hive.auth.AuthImpl.INSTANCE
            com.hive.SocialHive$ShowPeppermintDialogListener r1 = r3.$listener
            com.hive.social.SocialHiveImpl$logoutHub$1$onCreate$1$$ExternalSyntheticLambda0 r2 = new com.hive.social.SocialHiveImpl$logoutHub$1$onCreate$1$$ExternalSyntheticLambda0
            r2.<init>()
            r5.disconnectGoogleProviderAfterLogout(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.social.SocialHiveImpl$logoutHub$1$onCreate$1.onShowHiveDialogWithData(com.hive.ResultAPI, org.json.JSONObject):void");
    }
}
