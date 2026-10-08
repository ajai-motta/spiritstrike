package com.hive.push;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hive.Configuration;
import com.hive.Push;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveCoreInitializer;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.pushv4.Opens;
import com.hive.push.data.CachedPushActiveAppData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/hive/push/NotificationMessage;", "Landroid/app/Activity;", "<init>", "()V", "TAG", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationMessage extends Activity {
    private final String TAG = "NotificationMessage";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(Opens it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().isFailure()) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.wL(Push.getTAG(), "[NotificationMessage::onCreate] <PushNetwork.opens> failed " + it.getResponse());
            loggerImpl.wR(Push.getTAG(), "[NotificationMessage::onCreate] <PushNetwork.opens> failed");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.printStackTrace();
        return Unit.INSTANCE;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        if (!HiveCoreInitializer.INSTANCE.isInitContextInitialized()) {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            Configuration.setContext(applicationContext);
        }
        if (extras.getString("open") != null && (!StringsKt.isBlank(r0))) {
            PushNetwork.INSTANCE.opens(extras, new Function1() { // from class: com.hive.push.NotificationMessage$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NotificationMessage.onCreate$lambda$0((Opens) obj);
                }
            });
        }
        PushConfig pushConfig = PushConfig.INSTANCE;
        pushConfig.saveReceivedPush$hive_service_release(this, extras);
        pushConfig.clearBadge(this);
        MsgsOfNoticeID.INSTANCE.clearAllMsgs(this);
        String string = extras.getString(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
        if (string == null || !(!StringsKt.isBlank(string)) || string.length() <= 3 || !Intrinsics.areEqual(string.subSequence(0, 3), AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB)) {
            String string2 = extras.getString("packageName");
            if (string2 == null) {
                string2 = getApplication().getPackageName();
            }
            String string3 = extras.getString("className");
            if (string2 != null && string3 != null) {
                ComponentName componentName = new ComponentName(string2, string3);
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(componentName);
                intent.setFlags(268435456);
                intent.putExtras(extras);
                CachedPushActiveAppData.INSTANCE.save(extras);
                ExtentionsKt.startActivityCatching$default(this, intent, null, 2, null);
            }
        } else {
            String strSubstring = string.substring(4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(strSubstring));
            intent2.setFlags(268435456);
            ExtentionsKt.startActivityCatching(this, intent2, new Function1() { // from class: com.hive.push.NotificationMessage$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NotificationMessage.onCreate$lambda$1((Throwable) obj);
                }
            });
        }
        finish();
    }
}
