package com.applovin.impl;

import com.unity3d.ads.core.data.datasource.AndroidTcfDataSource;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f289a;
    private final Class b;
    public static final a5 c = new a5("com.applovin.sdk.impl.isFirstRun", String.class);
    public static final a5 d = new a5("com.applovin.sdk.launched_before", Boolean.class);
    public static final a5 e = new a5("com.applovin.sdk.launch_count", Long.class);
    public static final a5 f = new a5("com.applovin.sdk.last_launch_timestamp", Long.class);
    public static final a5 g = new a5("com.applovin.sdk.latest_installed_version", String.class);
    public static final a5 h = new a5("com.applovin.sdk.install_date", Long.class);
    public static final a5 i = new a5("com.applovin.sdk.av", Boolean.class);
    public static final a5 j = new a5("com.applovin.sdk.save_settings_with_sdk_key_agnostic_name", Boolean.class);
    public static final a5 k = new a5("com.applovin.sdk.user_id", String.class);
    public static final a5 l = new a5("com.applovin.sdk.compass_random_token", String.class);
    public static final a5 m = new a5("com.applovin.sdk.applovin_random_token", String.class);
    public static final a5 n = new a5("com.applovin.sdk.alart", String.class);
    public static final a5 o = new a5("com.applovin.sdk.aleid", String.class);
    public static final a5 p = new a5("com.applovin.sdk.device_test_group", String.class);
    public static final a5 q = new a5("com.applovin.sdk.compliance.has_user_consent", Boolean.class);
    public static final a5 r = new a5("com.applovin.sdk.compliance.is_age_restricted_user", Boolean.class);
    public static final a5 s = new a5("com.applovin.sdk.compliance.is_do_not_sell", Boolean.class);
    public static final a5 t = new a5("com.applovin.sdk.has_seen_but_not_accepted_privacy_policy", Boolean.class);
    public static final a5 u = new a5("IABTCF_CmpSdkID", Object.class);
    public static final a5 v = new a5("IABTCF_CmpSdkVersion", Object.class);
    public static final a5 w = new a5("IABTCF_gdprApplies", Object.class);
    public static final a5 x = new a5(AndroidTcfDataSource.TCF_TCSTRING_KEY, String.class);
    public static final a5 y = new a5("IABTCF_AddtlConsent", String.class);
    public static final a5 z = new a5("IABTCF_VendorConsents", String.class);
    public static final a5 A = new a5("IABTCF_VendorLegitimateInterests", String.class);
    public static final a5 B = new a5("IABTCF_PurposeConsents", String.class);
    public static final a5 C = new a5("IABTCF_PurposeLegitimateInterests", String.class);
    public static final a5 D = new a5("IABTCF_SpecialFeaturesOptIns", String.class);
    public static final a5 E = new a5("com.applovin.sdk.impl.ad.persistence.queue", String.class);
    public static final a5 F = new a5("com.applovin.sdk.mediation.signal_providers", String.class);
    public static final a5 G = new a5("com.applovin.sdk.mediation.auto_init_adapters", String.class);
    public static final a5 H = new a5("com.applovin.sdk.persisted_data", String.class);
    public static final a5 I = new a5("com.applovin.sdk.mediation.test_mode_enabled", Boolean.class);
    public static final a5 J = new a5("com.applovin.sdk.mediation.should_use_applovin_adaptive_sizing_formula", Boolean.class);
    public static final a5 K = new a5("com.applovin.sdk.mediation.stats_per_ad_unit_since_install", String.class);
    public static final a5 L = new a5("com.applovin.sdk.mediation.stats_per_ad_format_since_install", String.class);
    public static final a5 M = new a5("com.applovin.sdk.user_agent", String.class);
    public static final a5 N = new a5("com.applovin.sdk.last_fullscreen_ad_timestamp_ms", Long.class);
    public static final a5 O = new a5("com.applovin.sdk.last_fullscreen_ad_duration_ms", Long.class);
    public static final a5 P = new a5("com.applovin.sdk.app_killed_urls_from_last_ad", String.class);
    public static final a5 Q = new a5("com.applovin.sdk.app_killed_last_ad_data", String.class);
    public static final a5 R = new a5("com.applovin.sdk.app_killed_last_mediated_ad_tracking_info", String.class);
    public static final a5 S = new a5("com.applovin.sdk.last_mediated_fullscreen_ad_duration_ms", Long.class);
    public static final a5 T = new a5("com.applovin.sdk.template_browser_package_name", String.class);

    public a5(String str, Class cls) {
        this.f289a = str;
        this.b = cls;
    }

    public String a() {
        return this.f289a;
    }

    public Class b() {
        return this.b;
    }

    public String toString() {
        return "Key{name='" + this.f289a + "', type=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
