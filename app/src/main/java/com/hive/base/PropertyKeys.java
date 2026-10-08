package com.hive.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/hive/base/PropertyKeys;", "", "<init>", "()V", "INSTALL_REFERRER", "", "IS_SENT_REFERRER", "IS_SENT_REFERRER_TO_THIRD_PARTY", "Auth_ACCOUNT_SESSION_KEY", "Push_REGID_FCM", "DEFERRED_DEEPLINK_INFO", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PropertyKeys {
    public static final String Auth_ACCOUNT_SESSION_KEY = "auth.account_session_key";
    public static final String DEFERRED_DEEPLINK_INFO = "deferred_deeplink_info";
    public static final String INSTALL_REFERRER = "auth.referrer";
    public static final PropertyKeys INSTANCE = new PropertyKeys();
    public static final String IS_SENT_REFERRER = "auth.is_sent_referrer";
    public static final String IS_SENT_REFERRER_TO_THIRD_PARTY = "auth.is_sent_referrer_to_third_party";
    public static final String Push_REGID_FCM = "push.regid_fcm";

    private PropertyKeys() {
    }
}
