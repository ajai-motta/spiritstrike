package com.hive.auth;

import com.hive.base.PropertyKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\bb\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001a\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0014\u0010$\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0014\u0010&\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0014\u0010(\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0014\u0010*\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0014\u0010,\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0014\u0010.\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0014\u00100\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0014\u00102\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0014\u00104\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0014\u00106\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0014\u00108\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0014\u0010:\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0014\u0010<\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0014\u0010>\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0014\u0010@\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0014\u0010B\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u0014\u0010D\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0007R\u0014\u0010F\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0007R\u0014\u0010H\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0014\u0010J\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007R\u0014\u0010L\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0014\u0010N\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0007R\u0014\u0010P\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u0014\u0010R\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0007R\u0014\u0010T\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007R\u0014\u0010V\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0007R\u0014\u0010X\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0007R\u0014\u0010Z\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0007R\u0014\u0010\\\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0007R\u0010\u0010^\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0014\u0010`\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0007R\u0010\u0010b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0014\u0010d\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0007R\u0010\u0010f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/hive/auth/AuthKeys;", "", "<init>", "()V", "IS_CHECKED_PERMISSION", "", "getIS_CHECKED_PERMISSION", "()Ljava/lang/String;", "PERMISSION_VIEW_PAGE_SHOWN", "getPERMISSION_VIEW_PAGE_SHOWN", "PERMISSION_VIEW_DATA_SHOWN", "getPERMISSION_VIEW_DATA_SHOWN", "AGREEMENT_LOCAL_VERSION", "getAGREEMENT_LOCAL_VERSION", "AGREEMENT_LOCAL_FILE_NAME", "getAGREEMENT_LOCAL_FILE_NAME", "AGREEMENT_REVIEW_URL", "getAGREEMENT_REVIEW_URL", "AGREEMENT_VERSION", "getAGREEMENT_VERSION", "AGREEMENT_SCHEME_DATA", "getAGREEMENT_SCHEME_DATA", "AGREEMENT_EX_STATE", "getAGREEMENT_EX_STATE", "AGREEMENT_EX_SCHEME_DATA", "getAGREEMENT_EX_SCHEME_DATA", "AGREEMENT_AGREED_EVER", "getAGREEMENT_AGREED_EVER", "AGREEMENT_PRIVACY_STATE", "getAGREEMENT_PRIVACY_STATE", "AGREEMENT_PRIVACY_VALUE_AGREE", "getAGREEMENT_PRIVACY_VALUE_AGREE", "AGREEMENT_PRIVACY_VALUE_COMPLETED", "getAGREEMENT_PRIVACY_VALUE_COMPLETED", "AGREEMENT_PRIVACY_VALUE_HOLD", "getAGREEMENT_PRIVACY_VALUE_HOLD", "AGREEMENT_LOG_PROPERTY", "getAGREEMENT_LOG_PROPERTY", "AGREEMENT_LOG_VALUE_SENDING", "getAGREEMENT_LOG_VALUE_SENDING", "AGREEMENT_LOG_VALUE_COMPLETED", "getAGREEMENT_LOG_VALUE_COMPLETED", "AGREEMENT_LOG_VALUE_HOLD", "getAGREEMENT_LOG_VALUE_HOLD", "AGREEMENT_COUNTRY_VERSION_WITH_VID", "getAGREEMENT_COUNTRY_VERSION_WITH_VID", "DOWNLOAD_CHECK_APP_VERSION", "getDOWNLOAD_CHECK_APP_VERSION", "SESSION_DATA", "getSESSION_DATA", "SESSION_LAST_SESSION", "getSESSION_LAST_SESSION", "SESSION_LAST_SEND_TIME", "getSESSION_LAST_SEND_TIME", "SESSION_LAST_STOP_TIME", "getSESSION_LAST_STOP_TIME", "SESSION_LIMIT_NUM", "getSESSION_LIMIT_NUM", "SESSION_LIMIT_TIME", "getSESSION_LIMIT_TIME", "DIDCHECK_MAC", "getDIDCHECK_MAC", "DIDCHECK_MDN", "getDIDCHECK_MDN", "DIDCHECK_DEVICE_ID", "getDIDCHECK_DEVICE_ID", "DIDCHECK_ANDROID_ID", "getDIDCHECK_ANDROID_ID", "DIDCHECK_OS_VERSION", "getDIDCHECK_OS_VERSION", "DIDCHECK_IS_ROOTING", "getDIDCHECK_IS_ROOTING", "DIDCHECK_ZONE", "getDIDCHECK_ZONE", "DIDCHECK_COUNTRY", "getDIDCHECK_COUNTRY", "DIDCHECK_LANGUAGE", "getDIDCHECK_LANGUAGE", "DIDCHECK_GAME_LANGUAGE", "getDIDCHECK_GAME_LANGUAGE", "DIDCHECK_DEVICE_MODEL", "getDIDCHECK_DEVICE_MODEL", "DIDCHECK_OS_API_LEVEL", "getDIDCHECK_OS_API_LEVEL", "DIDCHECK_EMULATOR", "getDIDCHECK_EMULATOR", "DIDCHECK_ADVERTISING_ID", "getDIDCHECK_ADVERTISING_ID", "DIDCHECK_APP_VERSION", "getDIDCHECK_APP_VERSION", "DIDCHECK_DID", "getDIDCHECK_DID", "MIGRATION_COMPLETION", "getMIGRATION_COMPLETION", "IS_AUTHORIZED", "GUEST_VID", "GUEST_VID_TYPE", "getGUEST_VID_TYPE", "GUEST_SESSION_KEY", "ACCOUNT_VID", "ACCOUNT_VID_TYPE", "getACCOUNT_VID_TYPE", "ACCOUNT_SESSION_KEY", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthKeys {
    public static final AuthKeys INSTANCE = new AuthKeys();
    private static final String IS_CHECKED_PERMISSION = "auth.is_checked_permission";
    private static final String PERMISSION_VIEW_PAGE_SHOWN = "auth.permission_view_page_shown";
    private static final String PERMISSION_VIEW_DATA_SHOWN = "auth.permission_view_data_shown";
    private static final String AGREEMENT_LOCAL_VERSION = "auth.agreement_local_ver";
    private static final String AGREEMENT_LOCAL_FILE_NAME = "auth.agreement_local_file";
    private static final String AGREEMENT_REVIEW_URL = "auth.agreement_review_url";
    private static final String AGREEMENT_VERSION = "auth.agreement_version";
    private static final String AGREEMENT_SCHEME_DATA = "auth.agreement_data";
    private static final String AGREEMENT_EX_STATE = "auth.agreement_ex_state";
    private static final String AGREEMENT_EX_SCHEME_DATA = "auth.agreement_ex_data";
    private static final String AGREEMENT_AGREED_EVER = "auth.agreement_agreed_ever";
    private static final String AGREEMENT_PRIVACY_STATE = "auth.agreement_privacy_state";
    private static final String AGREEMENT_PRIVACY_VALUE_AGREE = "agree";
    private static final String AGREEMENT_PRIVACY_VALUE_COMPLETED = "completed";
    private static final String AGREEMENT_PRIVACY_VALUE_HOLD = "hold";
    private static final String AGREEMENT_LOG_PROPERTY = "auth.agreement_log_property";
    private static final String AGREEMENT_LOG_VALUE_SENDING = "auth.agreement_log_sending";
    private static final String AGREEMENT_LOG_VALUE_COMPLETED = "auth.agreement_log_completed";
    private static final String AGREEMENT_LOG_VALUE_HOLD = "auth.agreement_log_hold";
    private static final String AGREEMENT_COUNTRY_VERSION_WITH_VID = "auth.agreement_country_version_with_vid";
    private static final String DOWNLOAD_CHECK_APP_VERSION = "auth.download_check_app_ver";
    private static final String SESSION_DATA = "auth.session_data";
    private static final String SESSION_LAST_SESSION = "auth.session_last_session";
    private static final String SESSION_LAST_SEND_TIME = "auth.session_last_send_time";
    private static final String SESSION_LAST_STOP_TIME = "auth.session_last_stop_time";
    private static final String SESSION_LIMIT_NUM = "auth.session_limit_num";
    private static final String SESSION_LIMIT_TIME = "auth.session_limit_time";
    private static final String DIDCHECK_MAC = "auth.didcheck_mac";
    private static final String DIDCHECK_MDN = "auth.didcheck_mdn";
    private static final String DIDCHECK_DEVICE_ID = "auth.didcheck_device_id";
    private static final String DIDCHECK_ANDROID_ID = "auth.didcheck_android_id";
    private static final String DIDCHECK_OS_VERSION = "auth.didcheck_os_version";
    private static final String DIDCHECK_IS_ROOTING = "auth.didcheck_is_rooting";
    private static final String DIDCHECK_ZONE = "auth.didcheck_zone";
    private static final String DIDCHECK_COUNTRY = "auth.didcheck_country";
    private static final String DIDCHECK_LANGUAGE = "auth.didcheck_language";
    private static final String DIDCHECK_GAME_LANGUAGE = "auth.didcheck_game_language";
    private static final String DIDCHECK_DEVICE_MODEL = "auth.didcheck_device_model";
    private static final String DIDCHECK_OS_API_LEVEL = "auth.didcheck_os_api_level";
    private static final String DIDCHECK_EMULATOR = "auth.didcheck_emulator";
    private static final String DIDCHECK_ADVERTISING_ID = "auth.didcheck_advertising_id";
    private static final String DIDCHECK_APP_VERSION = "auth.didcheck_app_version";
    private static final String DIDCHECK_DID = "auth.didcheck_did";
    private static final String MIGRATION_COMPLETION = "auth.migaration.completion";
    public static final String IS_AUTHORIZED = "auth.isAuthorized";
    public static final String GUEST_VID = "auth.guest_vid";
    private static final String GUEST_VID_TYPE = "auth.guest_vid_type";
    public static final String GUEST_SESSION_KEY = "auth.guest_session_key";
    public static final String ACCOUNT_VID = "auth.account_vid";
    private static final String ACCOUNT_VID_TYPE = "auth.account_vid_type";
    public static final String ACCOUNT_SESSION_KEY = PropertyKeys.Auth_ACCOUNT_SESSION_KEY;

    private AuthKeys() {
    }

    public final String getACCOUNT_VID_TYPE() {
        return ACCOUNT_VID_TYPE;
    }

    public final String getAGREEMENT_AGREED_EVER() {
        return AGREEMENT_AGREED_EVER;
    }

    public final String getAGREEMENT_COUNTRY_VERSION_WITH_VID() {
        return AGREEMENT_COUNTRY_VERSION_WITH_VID;
    }

    public final String getAGREEMENT_EX_SCHEME_DATA() {
        return AGREEMENT_EX_SCHEME_DATA;
    }

    public final String getAGREEMENT_EX_STATE() {
        return AGREEMENT_EX_STATE;
    }

    public final String getAGREEMENT_LOCAL_FILE_NAME() {
        return AGREEMENT_LOCAL_FILE_NAME;
    }

    public final String getAGREEMENT_LOCAL_VERSION() {
        return AGREEMENT_LOCAL_VERSION;
    }

    public final String getAGREEMENT_LOG_PROPERTY() {
        return AGREEMENT_LOG_PROPERTY;
    }

    public final String getAGREEMENT_LOG_VALUE_COMPLETED() {
        return AGREEMENT_LOG_VALUE_COMPLETED;
    }

    public final String getAGREEMENT_LOG_VALUE_HOLD() {
        return AGREEMENT_LOG_VALUE_HOLD;
    }

    public final String getAGREEMENT_LOG_VALUE_SENDING() {
        return AGREEMENT_LOG_VALUE_SENDING;
    }

    public final String getAGREEMENT_PRIVACY_STATE() {
        return AGREEMENT_PRIVACY_STATE;
    }

    public final String getAGREEMENT_PRIVACY_VALUE_AGREE() {
        return AGREEMENT_PRIVACY_VALUE_AGREE;
    }

    public final String getAGREEMENT_PRIVACY_VALUE_COMPLETED() {
        return AGREEMENT_PRIVACY_VALUE_COMPLETED;
    }

    public final String getAGREEMENT_PRIVACY_VALUE_HOLD() {
        return AGREEMENT_PRIVACY_VALUE_HOLD;
    }

    public final String getAGREEMENT_REVIEW_URL() {
        return AGREEMENT_REVIEW_URL;
    }

    public final String getAGREEMENT_SCHEME_DATA() {
        return AGREEMENT_SCHEME_DATA;
    }

    public final String getAGREEMENT_VERSION() {
        return AGREEMENT_VERSION;
    }

    public final String getDIDCHECK_ADVERTISING_ID() {
        return DIDCHECK_ADVERTISING_ID;
    }

    public final String getDIDCHECK_ANDROID_ID() {
        return DIDCHECK_ANDROID_ID;
    }

    public final String getDIDCHECK_APP_VERSION() {
        return DIDCHECK_APP_VERSION;
    }

    public final String getDIDCHECK_COUNTRY() {
        return DIDCHECK_COUNTRY;
    }

    public final String getDIDCHECK_DEVICE_ID() {
        return DIDCHECK_DEVICE_ID;
    }

    public final String getDIDCHECK_DEVICE_MODEL() {
        return DIDCHECK_DEVICE_MODEL;
    }

    public final String getDIDCHECK_DID() {
        return DIDCHECK_DID;
    }

    public final String getDIDCHECK_EMULATOR() {
        return DIDCHECK_EMULATOR;
    }

    public final String getDIDCHECK_GAME_LANGUAGE() {
        return DIDCHECK_GAME_LANGUAGE;
    }

    public final String getDIDCHECK_IS_ROOTING() {
        return DIDCHECK_IS_ROOTING;
    }

    public final String getDIDCHECK_LANGUAGE() {
        return DIDCHECK_LANGUAGE;
    }

    public final String getDIDCHECK_MAC() {
        return DIDCHECK_MAC;
    }

    public final String getDIDCHECK_MDN() {
        return DIDCHECK_MDN;
    }

    public final String getDIDCHECK_OS_API_LEVEL() {
        return DIDCHECK_OS_API_LEVEL;
    }

    public final String getDIDCHECK_OS_VERSION() {
        return DIDCHECK_OS_VERSION;
    }

    public final String getDIDCHECK_ZONE() {
        return DIDCHECK_ZONE;
    }

    public final String getDOWNLOAD_CHECK_APP_VERSION() {
        return DOWNLOAD_CHECK_APP_VERSION;
    }

    public final String getGUEST_VID_TYPE() {
        return GUEST_VID_TYPE;
    }

    public final String getIS_CHECKED_PERMISSION() {
        return IS_CHECKED_PERMISSION;
    }

    public final String getMIGRATION_COMPLETION() {
        return MIGRATION_COMPLETION;
    }

    public final String getPERMISSION_VIEW_DATA_SHOWN() {
        return PERMISSION_VIEW_DATA_SHOWN;
    }

    public final String getPERMISSION_VIEW_PAGE_SHOWN() {
        return PERMISSION_VIEW_PAGE_SHOWN;
    }

    public final String getSESSION_DATA() {
        return SESSION_DATA;
    }

    public final String getSESSION_LAST_SEND_TIME() {
        return SESSION_LAST_SEND_TIME;
    }

    public final String getSESSION_LAST_SESSION() {
        return SESSION_LAST_SESSION;
    }

    public final String getSESSION_LAST_STOP_TIME() {
        return SESSION_LAST_STOP_TIME;
    }

    public final String getSESSION_LIMIT_NUM() {
        return SESSION_LIMIT_NUM;
    }

    public final String getSESSION_LIMIT_TIME() {
        return SESSION_LIMIT_TIME;
    }
}
