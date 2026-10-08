package com.hive.push.action;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/hive/push/action/PushActionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "PushActionType", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushActionReceiver extends BroadcastReceiver {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/push/action/PushActionReceiver$PushActionType;", "", "<init>", "(Ljava/lang/String;I)V", "CURL", "CLOSE", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PushActionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PushActionType[] $VALUES;
        public static final PushActionType CURL = new PushActionType("CURL", 0);
        public static final PushActionType CLOSE = new PushActionType("CLOSE", 1);

        private static final /* synthetic */ PushActionType[] $values() {
            return new PushActionType[]{CURL, CLOSE};
        }

        static {
            PushActionType[] pushActionTypeArr$values = $values();
            $VALUES = pushActionTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(pushActionTypeArr$values);
        }

        private PushActionType(String str, int i) {
        }

        public static EnumEntries<PushActionType> getEntries() {
            return $ENTRIES;
        }

        public static PushActionType valueOf(String str) {
            return (PushActionType) Enum.valueOf(PushActionType.class, str);
        }

        public static PushActionType[] values() {
            return (PushActionType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReceive$lambda$1(String str, Context context) {
        int iHashCode = str.hashCode();
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        StatusBarNotification[] activeNotifications = ((NotificationManager) systemService).getActiveNotifications();
        Intrinsics.checkNotNullExpressionValue(activeNotifications, "getActiveNotifications(...)");
        int i = 0;
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            if (str.equals(NotificationCompat.getGroup(statusBarNotification.getNotification()))) {
                i++;
            }
        }
        if (i == 1) {
            NotificationManagerCompat.from(context).cancel(iHashCode);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(final android.content.Context r8, android.content.Intent r9) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.push.action.PushActionReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
