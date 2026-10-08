package com.hive.push.google.fcm;

import android.content.Context;
import android.content.Intent;
import com.adjust.sdk.Constants;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.hive.core.HiveCoreInitializer;
import com.hive.logger.LoggerImpl;
import com.hive.push.PushConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MessagingService.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/hive/push/google/fcm/MessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "onMessageReceived", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "isUninstallTrackingPush", "", "hive-push-google-fcm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessagingService extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Context baseContext;
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        if (isUninstallTrackingPush(remoteMessage)) {
            LoggerImpl.INSTANCE.d("[FirebaseMsgService] Message data uninstall tracking data : " + remoteMessage.getData());
            return;
        }
        if (HiveCoreInitializer.INSTANCE.isInitContextInitialized()) {
            baseContext = HiveCoreInitializer.INSTANCE.getInitContext();
        } else {
            baseContext = getBaseContext();
            HiveCoreInitializer.INSTANCE.setInitContext(baseContext.getApplicationContext());
        }
        LoggerImpl.INSTANCE.dL("[FirebaseMsgService] From: " + remoteMessage.getFrom());
        LoggerImpl.INSTANCE.dR("[FirebaseMsgService] From");
        Map<String, String> data = remoteMessage.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        if (!data.isEmpty()) {
            LoggerImpl.INSTANCE.dL("[FirebaseMsgService] Message data payload: " + data);
            LoggerImpl.INSTANCE.dR("[FirebaseMsgService] Message data payload");
            Intent intent = new Intent();
            for (String str : data.keySet()) {
                LoggerImpl.INSTANCE.dL("[FirebaseMsgService] " + str + " = " + data.get(str));
                intent.putExtra(str, data.get(str));
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                String stringExtra = intent.getStringExtra("noticeID");
                if (stringExtra != null) {
                    intent.putExtra("noticeID", Integer.parseInt(stringExtra));
                }
                String stringExtra2 = intent.getStringExtra("buckettype");
                if (stringExtra2 != null) {
                    intent.putExtra("buckettype", Integer.parseInt(stringExtra2));
                }
                String stringExtra3 = intent.getStringExtra("bucketsize");
                Result.m7415constructorimpl(stringExtra3 != null ? intent.putExtra("bucketsize", Integer.parseInt(stringExtra3)) : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            intent.putExtra("isRemotePush", true);
            PushConfig pushConfig = PushConfig.INSTANCE;
            Intrinsics.checkNotNull(baseContext);
            Intent receiveData = PushConfig.INSTANCE.setReceiveData(baseContext, pushConfig.setReceiveDataNew(baseContext, intent));
            if (receiveData == null || !receiveData.getBooleanExtra("isRemotePushOperation", true)) {
                return;
            }
            LoggerImpl.INSTANCE.d("[FirebaseMsgService] setPushType");
            PushConfig.INSTANCE.setPushType(baseContext, receiveData);
            String stringExtra4 = receiveData.getStringExtra("broadcastAction");
            if (stringExtra4 != null && (!StringsKt.isBlank(stringExtra4))) {
                LoggerImpl.INSTANCE.d("[FirebaseMsgService] start broadcasting : " + stringExtra4);
                Intent intent2 = new Intent(stringExtra4);
                intent2.putExtras(receiveData);
                LoggerImpl.INSTANCE.d("[FirebaseMsgService] context.getPackageName() : " + baseContext.getPackageName());
                baseContext.sendBroadcast(intent2);
            }
        }
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        if (notification != null) {
            LoggerImpl.INSTANCE.d("[FirebaseMsgService] Message Notification Body: " + notification.getBody());
        }
    }

    private final boolean isUninstallTrackingPush(RemoteMessage remoteMessage) {
        return remoteMessage.getData().containsKey("af-uinstall-tracking") || remoteMessage.getData().containsKey("airbridge-uninstall-tracking") || remoteMessage.getData().containsKey(Constants.FCM_PAYLOAD_KEY);
    }
}
