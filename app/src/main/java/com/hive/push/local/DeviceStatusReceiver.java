package com.hive.push.local;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.C;
import com.hive.base.Property;
import com.hive.core.HiveCoreInitializer;
import com.hive.logger.LoggerImpl;
import com.hive.push.PushKeys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/hive/push/local/DeviceStatusReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceStatusReceiver extends BroadcastReceiver {
    private final String TAG = "DeviceStatusReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        HiveCoreInitializer.Companion companion = HiveCoreInitializer.INSTANCE;
        if (companion.isInitContextInitialized()) {
            applicationContext = companion.getInitContext();
        } else {
            applicationContext = context.getApplicationContext();
            companion.setInitContext(applicationContext);
        }
        LoggerImpl.INSTANCE.i(this.TAG, "Intent ACTION: " + intent.getAction());
        if (Intrinsics.areEqual("android.intent.action.BOOT_COMPLETED", intent.getAction())) {
            for (PushResource pushResource : PushResourceHandler.INSTANCE.getMap().values()) {
                Intrinsics.checkNotNullExpressionValue(pushResource, "next(...)");
                PushResource pushResource2 = pushResource;
                pushResource2.setTriggerAtTime(pushResource2.getTriggerAtTime() - (System.currentTimeMillis() - pushResource2.getSavedCurrentTime()));
                pushResource2.setElapsedRealtime(SystemClock.elapsedRealtime());
                PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, pushResource2.getNoticeID(), PushResourceHandler.INSTANCE.putIntentExtra(new Intent(applicationContext, (Class<?>) LocalPushReceiver.class), pushResource2), Build.VERSION.SDK_INT >= 31 ? 201326592 : C.BUFFER_FLAG_FIRST_SAMPLE);
                Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
                Object systemService = applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
                ((AlarmManager) systemService).set(2, pushResource2.getElapsedRealtime() + pushResource2.getTriggerAtTime(), broadcast);
            }
            return;
        }
        if (Intrinsics.areEqual("android.intent.action.TIME_SET", intent.getAction())) {
            ConcurrentHashMap<Integer, PushResource> map = PushResourceHandler.INSTANCE.getMap();
            for (PushResource pushResource3 : map.values()) {
                Intrinsics.checkNotNullExpressionValue(pushResource3, "next(...)");
                PushResource pushResource4 = pushResource3;
                pushResource4.setSavedCurrentTime(System.currentTimeMillis() + (SystemClock.elapsedRealtime() - pushResource4.getElapsedRealtime()));
            }
            PushResourceHandler pushResourceHandler = PushResourceHandler.INSTANCE;
            Intrinsics.checkNotNull(applicationContext);
            pushResourceHandler.save(applicationContext, map);
            try {
                Property.Companion companion2 = Property.INSTANCE;
                Property instance = companion2.getINSTANCE();
                PushKeys pushKeys = PushKeys.INSTANCE;
                String value = instance.getValue(pushKeys.getSAVED_DELAY_ELAPSED_TIME());
                if (value != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    Long lValueOf = Long.valueOf(value);
                    Intrinsics.checkNotNullExpressionValue(lValueOf, "valueOf(...)");
                    Property.setValue$default(companion2.getINSTANCE(), pushKeys.getSAVED_DELAY_CURRENT_TIME(), String.valueOf(jCurrentTimeMillis + (jElapsedRealtime - lValueOf.longValue())), null, 4, null);
                } else {
                    Property.setValue$default(companion2.getINSTANCE(), pushKeys.getSAVED_DELAY_CURRENT_TIME(), AppEventsConstants.EVENT_PARAM_VALUE_NO, null, 4, null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Property.INSTANCE.getINSTANCE().writeProperties();
        }
    }
}
