package com.hive.push;

import com.hive.base.PropertyKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001a\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007¨\u0006$"}, d2 = {"Lcom/hive/push/PushKeys;", "", "<init>", "()V", "RECEIVED_PUSH", "", "getRECEIVED_PUSH", "()Ljava/lang/String;", "REGID_FCM", "getREGID_FCM", "REGID_AMAZON", "getREGID_AMAZON", "REGID_FACEBOOK", "getREGID_FACEBOOK", "IS_AGREE_NOTICE", "getIS_AGREE_NOTICE", "IS_AGREE_NIGHT", "getIS_AGREE_NIGHT", "IS_LOCAL_ENABLED_ON_RUNNING", "getIS_LOCAL_ENABLED_ON_RUNNING", "IS_REMOTE_ENABLED_ON_RUNNING", "getIS_REMOTE_ENABLED_ON_RUNNING", "SAVED_DELAY_ELAPSED_TIME", "getSAVED_DELAY_ELAPSED_TIME", "SAVED_DELAY_CURRENT_TIME", "getSAVED_DELAY_CURRENT_TIME", "BADGE_COUNT", "getBADGE_COUNT", "USE_PUSH", "getUSE_PUSH", "USE_SOUND", "getUSE_SOUND", "USE_VIB", "getUSE_VIB", "FCM_SENDER_ID", "getFCM_SENDER_ID", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushKeys {
    public static final PushKeys INSTANCE = new PushKeys();
    private static final String RECEIVED_PUSH = "push.received_push";
    private static final String REGID_FCM = PropertyKeys.Push_REGID_FCM;
    private static final String REGID_AMAZON = "push.regid_amazon";
    private static final String REGID_FACEBOOK = "push.regid_facebook";
    private static final String IS_AGREE_NOTICE = "push.is_agree_notice";
    private static final String IS_AGREE_NIGHT = "push.is_agree_night";
    private static final String IS_LOCAL_ENABLED_ON_RUNNING = "push.is_local_push_enabled_on_running";
    private static final String IS_REMOTE_ENABLED_ON_RUNNING = "push.is_remote_push_enabled_on_running";
    private static final String SAVED_DELAY_ELAPSED_TIME = "push.saved_delay_elapsed_time";
    private static final String SAVED_DELAY_CURRENT_TIME = "push.saved_delay_current_time";
    private static final String BADGE_COUNT = "push.badge_count";
    private static final String USE_PUSH = "push.use_push";
    private static final String USE_SOUND = "push.use_sound";
    private static final String USE_VIB = "push.use_vib";
    private static final String FCM_SENDER_ID = "push.fcm_sender_id";

    private PushKeys() {
    }

    public final String getBADGE_COUNT() {
        return BADGE_COUNT;
    }

    public final String getFCM_SENDER_ID() {
        return FCM_SENDER_ID;
    }

    public final String getIS_AGREE_NIGHT() {
        return IS_AGREE_NIGHT;
    }

    public final String getIS_AGREE_NOTICE() {
        return IS_AGREE_NOTICE;
    }

    public final String getIS_LOCAL_ENABLED_ON_RUNNING() {
        return IS_LOCAL_ENABLED_ON_RUNNING;
    }

    public final String getIS_REMOTE_ENABLED_ON_RUNNING() {
        return IS_REMOTE_ENABLED_ON_RUNNING;
    }

    public final String getRECEIVED_PUSH() {
        return RECEIVED_PUSH;
    }

    public final String getREGID_AMAZON() {
        return REGID_AMAZON;
    }

    public final String getREGID_FACEBOOK() {
        return REGID_FACEBOOK;
    }

    public final String getREGID_FCM() {
        return REGID_FCM;
    }

    public final String getSAVED_DELAY_CURRENT_TIME() {
        return SAVED_DELAY_CURRENT_TIME;
    }

    public final String getSAVED_DELAY_ELAPSED_TIME() {
        return SAVED_DELAY_ELAPSED_TIME;
    }

    public final String getUSE_PUSH() {
        return USE_PUSH;
    }

    public final String getUSE_SOUND() {
        return USE_SOUND;
    }

    public final String getUSE_VIB() {
        return USE_VIB;
    }
}
