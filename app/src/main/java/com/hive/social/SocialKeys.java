package com.hive.social;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002 !B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001a\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/hive/social/SocialKeys;", "", "<init>", "()V", "UID", "", "getUID", "()Ljava/lang/String;", "UID_SESSION_TOKEN", "getUID_SESSION_TOKEN", "ENABLE_PGS", "getENABLE_PGS", "RETRY_PGS", "getRETRY_PGS", "MAX_RETRY_PGS", "getMAX_RETRY_PGS", "PEPPERMINT", "getPEPPERMINT", "PEPPERMINT_GUEST", "getPEPPERMINT_GUEST", "STORED_USER_INFO", "getSTORED_USER_INFO", "DID", "getDID", "PEPPERMINT_GUEST_UID", "getPEPPERMINT_GUEST_UID", "PGS_PLAYERID", "getPGS_PLAYERID", "PGS_ACCESS_TOKEN", "getPGS_ACCESS_TOKEN", "AUTHORIZATION_CODE", "getAUTHORIZATION_CODE", "PeppermintSocialRequestType", "PeppermintRequestUrlPath", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialKeys {
    public static final SocialKeys INSTANCE = new SocialKeys();
    private static final String UID = "social.uid";
    private static final String UID_SESSION_TOKEN = "social.session_token";
    private static final String ENABLE_PGS = "social.pgs.enable";
    private static final String RETRY_PGS = "social.pgs.retry_count";
    private static final String MAX_RETRY_PGS = "social.pgs.max_retry";
    private static final String PEPPERMINT = "peppermint";
    private static final String PEPPERMINT_GUEST = "peppermint_guest";
    private static final String STORED_USER_INFO = "stored_user_info";
    private static final String DID = "did";
    private static final String PEPPERMINT_GUEST_UID = "guest_uid";
    private static final String PGS_PLAYERID = "pgs.playerid";
    private static final String PGS_ACCESS_TOKEN = "pgs.access.token";
    private static final String AUTHORIZATION_CODE = "authorization_code";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/hive/social/SocialKeys$PeppermintRequestUrlPath;", "", "<init>", "()V", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PeppermintRequestUrlPath {
        public static final String PEPPERMINT_ASYNC_API_PGS_SET_AUTO_LOGIN = "aca_login_play_games_service";
        public static final String PEPPERMINT_ASYNC_API_PGS_UPDATE_PLAYERID = "aca_login_play_games_service_set";
        public static final String PEPPERMINT_AUTH_BY_PGS_PATH = "pgs/signup";
        public static final String PEPPERMINT_AUTH_PATH = "auth";
        public static final String PEPPERMINT_GUEST_ACQUIRE_UID_PATH = "guest";
        public static final String PEPPERMINT_GUEST_BIND_PATH = "guest/bind";
        public static final String PEPPERMINT_LOGOUT_PATH = "auth/logout_proc";
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/hive/social/SocialKeys$PeppermintSocialRequestType;", "", "<init>", "()V", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PeppermintSocialRequestType {
        public static final String SOCIAL_REQUEST_APP_EXIT = "social/appexit";
        public static final String SOCIAL_REQUEST_BUSINESS_MODEL = "social/business_model";
        public static final String SOCIAL_REQUEST_CHECK_REALNAME = "social/checkRealName";
        public static final String SOCIAL_REQUEST_CONNECT = "social/connect";
        public static final String SOCIAL_REQUEST_FRIENDS = "social/request_friends";
        public static final String SOCIAL_REQUEST_INVITATION_LIST = "social/request_invitation_list";
        public static final String SOCIAL_REQUEST_INVITE_DIALOG = "social/invite_dialog";
        public static final String SOCIAL_REQUEST_IS_AUTHORIZED = "social/is_authorized";
        public static final String SOCIAL_REQUEST_LOGOUT = "social/logout";
        public static final String SOCIAL_REQUEST_QUERY = "social/query";
        public static final String SOCIAL_REQUEST_RECEIVED_INVITE = "social/received_invite";
        public static final String SOCIAL_REQUEST_SEND_APP_INVITATION = "social/send_app_invitation";
        public static final String SOCIAL_REQUEST_SEND_APP_MESSAGE = "social/send_app_message";
        public static final String SOCIAL_REQUEST_SHARE_APP_ACTIVITY = "social/share_app_activity";
        public static final String SOCIAL_REQUEST_UNKNOWN = "social/unknown";
        public static final String SOCIAL_REQUEST_USER_PROFILE = "social/request_user_profile";
        public static final String SOCIAL_REQUEST_USER_PROFILE_IMAGE = "social/user_profile_image";
        public static final String SOCIAL_REQUEST_USER_TOKEN = "social/request_user_token";
    }

    private SocialKeys() {
    }

    public final String getAUTHORIZATION_CODE() {
        return AUTHORIZATION_CODE;
    }

    public final String getDID() {
        return DID;
    }

    public final String getENABLE_PGS() {
        return ENABLE_PGS;
    }

    public final String getMAX_RETRY_PGS() {
        return MAX_RETRY_PGS;
    }

    public final String getPEPPERMINT() {
        return PEPPERMINT;
    }

    public final String getPEPPERMINT_GUEST() {
        return PEPPERMINT_GUEST;
    }

    public final String getPEPPERMINT_GUEST_UID() {
        return PEPPERMINT_GUEST_UID;
    }

    public final String getPGS_ACCESS_TOKEN() {
        return PGS_ACCESS_TOKEN;
    }

    public final String getPGS_PLAYERID() {
        return PGS_PLAYERID;
    }

    public final String getRETRY_PGS() {
        return RETRY_PGS;
    }

    public final String getSTORED_USER_INFO() {
        return STORED_USER_INFO;
    }

    public final String getUID() {
        return UID;
    }

    public final String getUID_SESSION_TOKEN() {
        return UID_SESSION_TOKEN;
    }
}
