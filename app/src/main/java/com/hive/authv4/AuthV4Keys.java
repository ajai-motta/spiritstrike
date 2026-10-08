package com.hive.authv4;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001e\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/hive/authv4/AuthV4Keys;", "", "<init>", "()V", "AGREEMENT_REVIEW_URL", "", "AGREEMENT_VERSION_TERMS", "AGREEMENT_AGREED_DATA", "AGREEMENT_AGREED_EVER", "AGREEMENT_IS_SENT_BEFORE_LOGIN", "AGREEMENT_SENT_PLAYER_LIST", "AGREEMENT_LOCAL_VERSION", "AGREEMENT_LOCAL_FILE_NAME", "PREPARE_DOWNLOAD_CHECK_APP_VERSION", "DOWNLOAD_CHECK_APP_VERSION", "DEVICECHECK_COUNTRY", "DEVICECHECK_LANGUAGE", "DEVICECHECK_GAME_LANGUAGE", "DEVICECHECK_DEVICE_MODEL", "DEVICECHECK_OS_VERSION", "DEVICECHECK_OS_API_LEVEL", "DEVICECHECK_IS_ROOTING", "DEVICECHECK_ADVERTISING_ID", "DEVICECHECK_MAC", "DEVICECHECK_DEVICE_ID", "DEVICECHECK_ANDROID_ID", "DEVICECHECK_MDN", "DEVICECHECK_EMULATOR", "DEVICECHECK_ZONE", "DEVICECHECK_DID", "DEVICECHECK_APP_VERSION", "IMPLICIT_SIGNED_IN_EVER", "OFFLINE_PROVISION_METADATA", "OFFLINE_PROVISION_INTEGRATION_DATA", "OFFLINE_AUTHV4_SIGN_IN_FINISH", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4Keys {
    public static final String AGREEMENT_AGREED_DATA = "authv4.agreement_agreed_data";
    public static final String AGREEMENT_AGREED_EVER = "authv4.agreement_agreed_ever";
    public static final String AGREEMENT_IS_SENT_BEFORE_LOGIN = "authv4.agreement_is_sent_before_login";
    public static final String AGREEMENT_LOCAL_FILE_NAME = "authv4.agreement_local_file";
    public static final String AGREEMENT_LOCAL_VERSION = "authv4.agreement_local_ver";
    public static final String AGREEMENT_REVIEW_URL = "authv4.agreement_review_url";
    public static final String AGREEMENT_SENT_PLAYER_LIST = "authv4.agreement_sent_player_list";
    public static final String AGREEMENT_VERSION_TERMS = "authv4.agreement_version_terms";
    public static final String DEVICECHECK_ADVERTISING_ID = "authv4.devicecheck_advertising_id";
    public static final String DEVICECHECK_ANDROID_ID = "authv4.devicecheck_android_id";
    public static final String DEVICECHECK_APP_VERSION = "authv4.devicecheck_app_version";
    public static final String DEVICECHECK_COUNTRY = "authv4.devicecheck_country";
    public static final String DEVICECHECK_DEVICE_ID = "authv4.devicecheck_device_id";
    public static final String DEVICECHECK_DEVICE_MODEL = "authv4.devicecheck_device_model";
    public static final String DEVICECHECK_DID = "authv4.devicecheck_did";
    public static final String DEVICECHECK_EMULATOR = "authv4.devicecheck_emulator";
    public static final String DEVICECHECK_GAME_LANGUAGE = "authv4.devicecheck_game_language";
    public static final String DEVICECHECK_IS_ROOTING = "authv4.devicecheck_is_rooting";
    public static final String DEVICECHECK_LANGUAGE = "authv4.devicecheck_language";
    public static final String DEVICECHECK_MAC = "authv4.devicecheck_mac";
    public static final String DEVICECHECK_MDN = "authv4.devicecheck_mdn";
    public static final String DEVICECHECK_OS_API_LEVEL = "authv4.devicecheck_os_api_level";
    public static final String DEVICECHECK_OS_VERSION = "authv4.devicecheck_os_version";
    public static final String DEVICECHECK_ZONE = "authv4.devicecheck_zone";
    public static final String DOWNLOAD_CHECK_APP_VERSION = "authv4.download_check_app_ver";
    public static final String IMPLICIT_SIGNED_IN_EVER = "authv4.implified_signed_in_ever";
    public static final AuthV4Keys INSTANCE = new AuthV4Keys();
    public static final String OFFLINE_AUTHV4_SIGN_IN_FINISH = "authv4.sign_in_finish";
    public static final String OFFLINE_PROVISION_INTEGRATION_DATA = "authv4.provision_integration_data";
    public static final String OFFLINE_PROVISION_METADATA = "authv4.provision_metadata";
    public static final String PREPARE_DOWNLOAD_CHECK_APP_VERSION = "authv4.prepare_download_check_app_ver";

    private AuthV4Keys() {
    }
}
