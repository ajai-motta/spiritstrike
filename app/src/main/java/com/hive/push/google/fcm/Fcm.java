package com.hive.push.google.fcm;

import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.hive.Push;
import com.hive.base.Property;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.UrlManager;
import com.hive.protocol.pushv4.FcmInfo;
import com.hive.push.BaseRemotePush;
import com.hive.push.PushImpl;
import com.hive.push.PushKeys;
import com.hive.push.PushNetwork;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Fcm.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/hive/push/google/fcm/Fcm;", "Lcom/hive/push/BaseRemotePush;", "context", "Landroid/content/Context;", "remotePushType", "Lcom/hive/push/PushImpl$RemotePushType;", "<init>", "(Landroid/content/Context;Lcom/hive/push/PushImpl$RemotePushType;)V", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", MobileAdsBridgeBase.initializeMethodName, "", "cachedAccount", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "getFirebaseApp", "fcmInfo", "Lcom/hive/protocol/pushv4/FcmInfo;", "hive-push-google-fcm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Fcm extends BaseRemotePush {
    private FirebaseApp firebaseApp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fcm(Context context, PushImpl.RemotePushType remotePushType) {
        super(context, remotePushType);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remotePushType, "remotePushType");
        setEnablePush(true);
        setBaseRemotePushContext(context);
        LoggerImpl.INSTANCE.d(Push.getTAG(), "FCM enable.");
    }

    @Override // com.hive.push.BaseRemotePush
    public void initialize(HiveLifecycle.HiveAccount cachedAccount) {
        super.initialize(cachedAccount);
        PushNetwork.INSTANCE.fcmInfo(new Function1() { // from class: com.hive.push.google.fcm.Fcm$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Fcm.initialize$lambda$5(this.f$0, (FcmInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialize$lambda$5(final Fcm fcm, FcmInfo fcmInfo) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(fcmInfo, "fcmInfo");
        if (fcmInfo.getResponse().isFailure() || (fcmInfo.getResponse().isInvalidFcmInfo() && fcmInfo.getResponse().isEmptySenderId())) {
            LoggerImpl.INSTANCE.w(Push.getTAG(), StringsKt.trimIndent("\n                    [FCM initialize] <PushNetwork.fcmInfo> failed\n                        reason: " + fcmInfo.getResponse().getReason() + "\n                        isInvalidFcmInfo: " + fcmInfo.getResponse().isInvalidFcmInfo() + "\n                        isEmptySenderId: " + fcmInfo.getResponse().isEmptySenderId() + "\n                        "));
        } else {
            LoggerImpl.INSTANCE.d(Push.getTAG(), "[FCM initialize] <PushNetwork.fcmInfo> success");
            try {
                String value = Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getREGID_FCM());
                String value2 = Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getFCM_SENDER_ID());
                final String senderId = fcmInfo.getResponse().getSenderId();
                LoggerImpl.INSTANCE.d(Push.getTAG(), StringsKt.trimIndent("\n                        [FCM initialize] - RegistrationId : " + value + "\n                                           old senderIDs : " + value2 + "\n                                           new senderIDs : " + senderId + "\n                        "));
                try {
                    Result.Companion companion = Result.INSTANCE;
                    LoggerImpl.INSTANCE.d(Push.getTAG(), "[FCM initialize] : register");
                    objM7415constructorimpl = Result.m7415constructorimpl(((FirebaseMessaging) fcm.getFirebaseApp(fcmInfo).get(FirebaseMessaging.class)).getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.push.google.fcm.Fcm$$ExternalSyntheticLambda1
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public final void onComplete(Task task) {
                            Fcm.initialize$lambda$5$lambda$3$lambda$2(senderId, fcm, task);
                        }
                    }));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    thM7418exceptionOrNullimpl.printStackTrace();
                    LoggerImpl.INSTANCE.w(Push.getTAG(), "[FCM initialize] - failed to FirebaseMessaging getToken. : " + thM7418exceptionOrNullimpl);
                }
                Result.m7414boximpl(objM7415constructorimpl);
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(Push.getTAG(), "[FCM initialize] - failed to FCM initialize : " + e);
                Unit unit = Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$5$lambda$3$lambda$2(String str, Fcm fcm, Task it) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isSuccessful()) {
            String str2 = (String) it.getResult();
            LoggerImpl.INSTANCE.iL(Push.getTAG(), "[FCM initialize] - FirebaseMessaging token : " + str2);
            LoggerImpl.INSTANCE.iR(Push.getTAG(), "[FCM initialize] - FirebaseMessaging token(length) : " + str2.length());
            Intrinsics.checkNotNull(str2);
            if (StringsKt.isBlank(str2)) {
                LoggerImpl.INSTANCE.w(Push.getTAG(), "[FCM initialize] - failed to FirebaseMessaging getToken. : is Blank");
                return;
            }
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getFCM_SENDER_ID(), str, null, 4, null);
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PushKeys.INSTANCE.getREGID_FCM(), str2, null, 4, null);
            Property.INSTANCE.getINSTANCE().writeProperties();
            fcm.registerToken(null, MobileAdsBridgeBase.initializeMethodName);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            LoggerImpl.INSTANCE.w(Push.getTAG(), "[FCM initialize] - failed to FCM initialize : " + it.getException());
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w(Push.getTAG(), "[FCM initialize] - failed to FCM initialize throw : " + thM7418exceptionOrNullimpl);
        }
        Result.m7414boximpl(objM7415constructorimpl);
    }

    private final FirebaseApp getFirebaseApp(FcmInfo fcmInfo) throws IllegalStateException {
        FirebaseApp firebaseApp = this.firebaseApp;
        if (firebaseApp != null) {
            return firebaseApp;
        }
        String apiKey = fcmInfo.getResponse().getApiKey();
        if (!(!StringsKt.isBlank(apiKey))) {
            apiKey = null;
        }
        if (apiKey == null) {
            apiKey = UrlManager.Fcm.INSTANCE.getApiKey();
        }
        String projectId = fcmInfo.getResponse().getProjectId();
        if (!(!StringsKt.isBlank(projectId))) {
            projectId = null;
        }
        if (projectId == null) {
            projectId = "hive-sdk-6296113";
        }
        String applicationId = fcmInfo.getResponse().getApplicationId();
        String str = StringsKt.isBlank(applicationId) ^ true ? applicationId : null;
        if (str == null) {
            str = "1:331526026701:android:8a255de349fe1c6c";
        }
        String senderId = fcmInfo.getResponse().getSenderId();
        FirebaseOptions.Builder builder = new FirebaseOptions.Builder();
        builder.setApiKey(apiKey);
        builder.setProjectId(projectId);
        builder.setApplicationId(str);
        if (!StringsKt.isBlank(senderId)) {
            builder.setGcmSenderId(senderId);
        }
        FirebaseOptions firebaseOptionsBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(firebaseOptionsBuild, "build(...)");
        FirebaseApp firebaseAppInitializeApp = FirebaseApp.initializeApp(getBaseRemotePushContext(), firebaseOptionsBuild, "hivesdkfcm");
        Intrinsics.checkNotNullExpressionValue(firebaseAppInitializeApp, "initializeApp(...)");
        this.firebaseApp = firebaseAppInitializeApp;
        return firebaseAppInitializeApp;
    }
}
