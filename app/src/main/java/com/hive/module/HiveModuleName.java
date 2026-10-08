package com.hive.module;

import com.hive.module.interfaces.GoogleBase;
import com.hive.module.interfaces.HiveAnalytics;
import com.hive.module.interfaces.HiveAuth;
import com.hive.module.interfaces.HiveAuthV4;
import com.hive.module.interfaces.HiveChat;
import com.hive.module.interfaces.HiveDataStore;
import com.hive.module.interfaces.HiveHercules;
import com.hive.module.interfaces.HiveIapV4;
import com.hive.module.interfaces.HiveMatchMaking;
import com.hive.module.interfaces.HivePromotion;
import com.hive.module.interfaces.HiveSocial;
import com.hive.module.interfaces.HiveSocialV4;
import com.hive.module.interfaces.HiveUserEngagement;
import com.hive.module.interfaces.agerange.GoogleAgeSignals;
import com.hive.module.interfaces.analytics.ConsentMode;
import com.hive.module.interfaces.analytics.ProviderAdjust;
import com.hive.module.interfaces.analytics.ProviderAirbridge;
import com.hive.module.interfaces.analytics.ProviderAppsFlyer;
import com.hive.module.interfaces.analytics.ProviderFirebase;
import com.hive.module.interfaces.analytics.ProviderSingular;
import com.hive.module.interfaces.authv4.AdultConfirm;
import com.hive.module.interfaces.authv4.DeviceManagement;
import com.hive.module.interfaces.authv4.GoogleInAppUpdate;
import com.hive.module.interfaces.authv4.GoogleRecaptcha;
import com.hive.module.interfaces.authv4.IdentityVerification;
import com.hive.module.interfaces.authv4.RealNameVerification;
import com.hive.module.interfaces.authv4.provider.ProviderAppleSignIn;
import com.hive.module.interfaces.authv4.provider.ProviderFacebook;
import com.hive.module.interfaces.authv4.provider.ProviderFacebookCloudGame;
import com.hive.module.interfaces.authv4.provider.ProviderFuntap;
import com.hive.module.interfaces.authv4.provider.ProviderFuntapAppraisal;
import com.hive.module.interfaces.authv4.provider.ProviderGoogleCredentialSignIn;
import com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames;
import com.hive.module.interfaces.authv4.provider.ProviderGoogleSignIn;
import com.hive.module.interfaces.authv4.provider.ProviderHiveMembership;
import com.hive.module.interfaces.authv4.provider.ProviderHuawei;
import com.hive.module.interfaces.authv4.provider.ProviderLine;
import com.hive.module.interfaces.authv4.provider.ProviderOppo;
import com.hive.module.interfaces.authv4.provider.ProviderQq;
import com.hive.module.interfaces.authv4.provider.ProviderSteam;
import com.hive.module.interfaces.authv4.provider.ProviderTelegram;
import com.hive.module.interfaces.authv4.provider.ProviderVivo;
import com.hive.module.interfaces.authv4.provider.ProviderVk;
import com.hive.module.interfaces.authv4.provider.ProviderWeChat;
import com.hive.module.interfaces.authv4.provider.ProviderWeverse;
import com.hive.module.interfaces.authv4.provider.ProviderX;
import com.hive.module.interfaces.authv4.provider.ProviderXiaomi;
import com.hive.module.interfaces.iapv4.Repayment;
import com.hive.module.interfaces.iapv4.market.MarketAmazon;
import com.hive.module.interfaces.iapv4.market.MarketFacebookCloudGame;
import com.hive.module.interfaces.iapv4.market.MarketGoogle;
import com.hive.module.interfaces.iapv4.market.MarketHiveStore;
import com.hive.module.interfaces.iapv4.market.MarketHuawei;
import com.hive.module.interfaces.iapv4.market.MarketLebi;
import com.hive.module.interfaces.iapv4.market.MarketOneStore;
import com.hive.module.interfaces.iapv4.market.MarketOneStoreV4;
import com.hive.module.interfaces.iapv4.market.MarketOppo;
import com.hive.module.interfaces.iapv4.market.MarketSamsung;
import com.hive.module.interfaces.iapv4.market.MarketVivo;
import com.hive.module.interfaces.iapv4.market.MarketXiaomi;
import com.hive.module.interfaces.plugin.C2s;
import com.hive.module.interfaces.promotion.GoogleInAppReview;
import com.hive.module.interfaces.push.AmazonAdm;
import com.hive.module.interfaces.push.FacebookCloudGameA2u;
import com.hive.module.interfaces.push.GoogleFcm;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Target({ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/hive/module/HiveModuleName;", "", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface HiveModuleName {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0003\b\u0083\u0001\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0011\u0010<\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0011\u0010>\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0011\u0010@\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0011\u0010B\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u0011\u0010D\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0007R\u0011\u0010F\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0007R\u0011\u0010H\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0011\u0010J\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007R\u0011\u0010L\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0011\u0010N\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0007R\u0011\u0010P\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u0011\u0010R\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0007R\u0011\u0010T\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007R\u0011\u0010V\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0007R\u0011\u0010X\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0007R\u0011\u0010Z\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0007R\u0011\u0010\\\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0007R\u0011\u0010^\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0007R\u0011\u0010`\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0007R\u0011\u0010b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0007R\u0011\u0010d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0007R\u0011\u0010f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0007R\u0011\u0010h\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0007R\u0011\u0010j\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u0007R\u0011\u0010l\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0007R\u0011\u0010n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0007R\u0011\u0010p\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0007R\u0011\u0010r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u0007R\u0011\u0010t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u0007R\u0011\u0010v\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0007R\u0011\u0010x\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\by\u0010\u0007R\u0011\u0010z\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b{\u0010\u0007R\u0011\u0010|\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b}\u0010\u0007R\u0011\u0010~\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010\u0007R\u0013\u0010\u0080\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0007R\u0013\u0010\u0082\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0007R\u0013\u0010\u0084\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0007R\u0013\u0010\u0086\u0001\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0007¨\u0006\u0088\u0001"}, d2 = {"Lcom/hive/module/HiveModuleName$Companion;", "", "<init>", "()V", "Service_Google_Base", "", "getService_Google_Base", "()Ljava/lang/String;", "AgeRange_Google_AgeSignals", "getAgeRange_Google_AgeSignals", "Analytics", "getAnalytics", "Analytics_Consent_Mode", "getAnalytics_Consent_Mode", "Analytics_Provider_Adjust", "getAnalytics_Provider_Adjust", "Analytics_Provider_AppsFlyer", "getAnalytics_Provider_AppsFlyer", "Analytics_Provider_Firebase", "getAnalytics_Provider_Firebase", "Analytics_Provider_Singular", "getAnalytics_Provider_Singular", "Analytics_Provider_Airbridge", "getAnalytics_Provider_Airbridge", "Auth", "getAuth", "AuthV4", "getAuthV4", "AuthV4_Adult_Confirm", "getAuthV4_Adult_Confirm", "AuthV4_Device_Management", "getAuthV4_Device_Management", "AuthV4_Google_InAppUpdate", "getAuthV4_Google_InAppUpdate", "AuthV4_Google_Recaptcha", "getAuthV4_Google_Recaptcha", "AuthV4_Identity_Verification", "getAuthV4_Identity_Verification", "AuthV4_Real_Name_Verification", "getAuthV4_Real_Name_Verification", "AuthV4_Provider_Apple_SignIn", "getAuthV4_Provider_Apple_SignIn", "AuthV4_Provider_Facebook", "getAuthV4_Provider_Facebook", "AuthV4_Provider_FacebookCloudGame", "getAuthV4_Provider_FacebookCloudGame", "AuthV4_Provider_Funtap", "getAuthV4_Provider_Funtap", "AuthV4_Provider_Funtap_Appraisal", "getAuthV4_Provider_Funtap_Appraisal", "AuthV4_Provider_Google_PlayGames", "getAuthV4_Provider_Google_PlayGames", "AuthV4_Provider_Google_SignIn", "getAuthV4_Provider_Google_SignIn", "AuthV4_Provider_Google_Credential_SignIn", "getAuthV4_Provider_Google_Credential_SignIn", "AuthV4_Provider_Hive_Membership", "getAuthV4_Provider_Hive_Membership", "AuthV4_Provider_Huawei", "getAuthV4_Provider_Huawei", "AuthV4_Provider_Line", "getAuthV4_Provider_Line", "AuthV4_Provider_Oppo", "getAuthV4_Provider_Oppo", "AuthV4_Provider_Qq", "getAuthV4_Provider_Qq", "AuthV4_Provider_Steam", "getAuthV4_Provider_Steam", "AuthV4_Provider_Telegram", "getAuthV4_Provider_Telegram", "AuthV4_Provider_Vivo", "getAuthV4_Provider_Vivo", "AuthV4_Provider_Vk", "getAuthV4_Provider_Vk", "AuthV4_Provider_WeChat", "getAuthV4_Provider_WeChat", "AuthV4_Provider_Weverse", "getAuthV4_Provider_Weverse", "AuthV4_Provider_X", "getAuthV4_Provider_X", "AuthV4_Provider_Xiaomi", "getAuthV4_Provider_Xiaomi", "Chat", "getChat", "DataStore", "getDataStore", "MatchMaking", "getMatchMaking", "Hercules", "getHercules", "IapV4", "getIapV4", "IapV4_Repayment", "getIapV4_Repayment", "IapV4_Market_Amazon", "getIapV4_Market_Amazon", "IapV4_Market_Facebook_CloudGame", "getIapV4_Market_Facebook_CloudGame", "IapV4_Market_Google", "getIapV4_Market_Google", "IapV4_Market_HiveStore", "getIapV4_Market_HiveStore", "IapV4_Market_Huawei", "getIapV4_Market_Huawei", "IapV4_Market_Lebi", "getIapV4_Market_Lebi", "IapV4_Market_OneStore", "getIapV4_Market_OneStore", "IapV4_Market_OneStoreV4", "getIapV4_Market_OneStoreV4", "IapV4_Market_Oppo", "getIapV4_Market_Oppo", "IapV4_Market_Samsung", "getIapV4_Market_Samsung", "IapV4_Market_Vivo", "getIapV4_Market_Vivo", "IapV4_Market_Xiaomi", "getIapV4_Market_Xiaomi", "Promotion", "getPromotion", "Promotion_Google_InAppReview", "getPromotion_Google_InAppReview", "Push_Amazon_Adm", "getPush_Amazon_Adm", "Push_FacebookCloudGame_A2u", "getPush_FacebookCloudGame_A2u", "Push_Google_Fcm", "getPush_Google_Fcm", "UserEngagement", "getUserEngagement", "Social", "getSocial", "SocialV4", "getSocialV4", "Plugin_C2s", "getPlugin_C2s", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String AgeRange_Google_AgeSignals;
        private static final String Analytics;
        private static final String Analytics_Consent_Mode;
        private static final String Analytics_Provider_Adjust;
        private static final String Analytics_Provider_Airbridge;
        private static final String Analytics_Provider_AppsFlyer;
        private static final String Analytics_Provider_Firebase;
        private static final String Analytics_Provider_Singular;
        private static final String Auth;
        private static final String AuthV4;
        private static final String AuthV4_Adult_Confirm;
        private static final String AuthV4_Device_Management;
        private static final String AuthV4_Google_InAppUpdate;
        private static final String AuthV4_Google_Recaptcha;
        private static final String AuthV4_Identity_Verification;
        private static final String AuthV4_Provider_Apple_SignIn;
        private static final String AuthV4_Provider_Facebook;
        private static final String AuthV4_Provider_FacebookCloudGame;
        private static final String AuthV4_Provider_Funtap;
        private static final String AuthV4_Provider_Funtap_Appraisal;
        private static final String AuthV4_Provider_Google_Credential_SignIn;
        private static final String AuthV4_Provider_Google_PlayGames;
        private static final String AuthV4_Provider_Google_SignIn;
        private static final String AuthV4_Provider_Hive_Membership;
        private static final String AuthV4_Provider_Huawei;
        private static final String AuthV4_Provider_Line;
        private static final String AuthV4_Provider_Oppo;
        private static final String AuthV4_Provider_Qq;
        private static final String AuthV4_Provider_Steam;
        private static final String AuthV4_Provider_Telegram;
        private static final String AuthV4_Provider_Vivo;
        private static final String AuthV4_Provider_Vk;
        private static final String AuthV4_Provider_WeChat;
        private static final String AuthV4_Provider_Weverse;
        private static final String AuthV4_Provider_X;
        private static final String AuthV4_Provider_Xiaomi;
        private static final String AuthV4_Real_Name_Verification;
        private static final String Chat;
        private static final String DataStore;
        private static final String Hercules;
        private static final String IapV4;
        private static final String IapV4_Market_Amazon;
        private static final String IapV4_Market_Facebook_CloudGame;
        private static final String IapV4_Market_Google;
        private static final String IapV4_Market_HiveStore;
        private static final String IapV4_Market_Huawei;
        private static final String IapV4_Market_Lebi;
        private static final String IapV4_Market_OneStore;
        private static final String IapV4_Market_OneStoreV4;
        private static final String IapV4_Market_Oppo;
        private static final String IapV4_Market_Samsung;
        private static final String IapV4_Market_Vivo;
        private static final String IapV4_Market_Xiaomi;
        private static final String IapV4_Repayment;
        private static final String MatchMaking;
        private static final String Plugin_C2s;
        private static final String Promotion;
        private static final String Promotion_Google_InAppReview;
        private static final String Push_Amazon_Adm;
        private static final String Push_FacebookCloudGame_A2u;
        private static final String Push_Google_Fcm;
        private static final String Service_Google_Base;
        private static final String Social;
        private static final String SocialV4;
        private static final String UserEngagement;

        static {
            String name = GoogleBase.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Service_Google_Base = name;
            String name2 = GoogleAgeSignals.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            AgeRange_Google_AgeSignals = name2;
            String name3 = HiveAnalytics.class.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
            Analytics = name3;
            String name4 = ConsentMode.class.getName();
            Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
            Analytics_Consent_Mode = name4;
            String name5 = ProviderAdjust.class.getName();
            Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
            Analytics_Provider_Adjust = name5;
            String name6 = ProviderAppsFlyer.class.getName();
            Intrinsics.checkNotNullExpressionValue(name6, "getName(...)");
            Analytics_Provider_AppsFlyer = name6;
            String name7 = ProviderFirebase.class.getName();
            Intrinsics.checkNotNullExpressionValue(name7, "getName(...)");
            Analytics_Provider_Firebase = name7;
            String name8 = ProviderSingular.class.getName();
            Intrinsics.checkNotNullExpressionValue(name8, "getName(...)");
            Analytics_Provider_Singular = name8;
            String name9 = ProviderAirbridge.class.getName();
            Intrinsics.checkNotNullExpressionValue(name9, "getName(...)");
            Analytics_Provider_Airbridge = name9;
            String name10 = HiveAuth.class.getName();
            Intrinsics.checkNotNullExpressionValue(name10, "getName(...)");
            Auth = name10;
            String name11 = HiveAuthV4.class.getName();
            Intrinsics.checkNotNullExpressionValue(name11, "getName(...)");
            AuthV4 = name11;
            String name12 = AdultConfirm.class.getName();
            Intrinsics.checkNotNullExpressionValue(name12, "getName(...)");
            AuthV4_Adult_Confirm = name12;
            String name13 = DeviceManagement.class.getName();
            Intrinsics.checkNotNullExpressionValue(name13, "getName(...)");
            AuthV4_Device_Management = name13;
            String name14 = GoogleInAppUpdate.class.getName();
            Intrinsics.checkNotNullExpressionValue(name14, "getName(...)");
            AuthV4_Google_InAppUpdate = name14;
            String name15 = GoogleRecaptcha.class.getName();
            Intrinsics.checkNotNullExpressionValue(name15, "getName(...)");
            AuthV4_Google_Recaptcha = name15;
            String name16 = IdentityVerification.class.getName();
            Intrinsics.checkNotNullExpressionValue(name16, "getName(...)");
            AuthV4_Identity_Verification = name16;
            String name17 = RealNameVerification.class.getName();
            Intrinsics.checkNotNullExpressionValue(name17, "getName(...)");
            AuthV4_Real_Name_Verification = name17;
            String name18 = ProviderAppleSignIn.class.getName();
            Intrinsics.checkNotNullExpressionValue(name18, "getName(...)");
            AuthV4_Provider_Apple_SignIn = name18;
            String name19 = ProviderFacebook.class.getName();
            Intrinsics.checkNotNullExpressionValue(name19, "getName(...)");
            AuthV4_Provider_Facebook = name19;
            String name20 = ProviderFacebookCloudGame.class.getName();
            Intrinsics.checkNotNullExpressionValue(name20, "getName(...)");
            AuthV4_Provider_FacebookCloudGame = name20;
            String name21 = ProviderFuntap.class.getName();
            Intrinsics.checkNotNullExpressionValue(name21, "getName(...)");
            AuthV4_Provider_Funtap = name21;
            String name22 = ProviderFuntapAppraisal.class.getName();
            Intrinsics.checkNotNullExpressionValue(name22, "getName(...)");
            AuthV4_Provider_Funtap_Appraisal = name22;
            String name23 = ProviderGooglePlayGames.class.getName();
            Intrinsics.checkNotNullExpressionValue(name23, "getName(...)");
            AuthV4_Provider_Google_PlayGames = name23;
            String name24 = ProviderGoogleSignIn.class.getName();
            Intrinsics.checkNotNullExpressionValue(name24, "getName(...)");
            AuthV4_Provider_Google_SignIn = name24;
            String name25 = ProviderGoogleCredentialSignIn.class.getName();
            Intrinsics.checkNotNullExpressionValue(name25, "getName(...)");
            AuthV4_Provider_Google_Credential_SignIn = name25;
            String name26 = ProviderHiveMembership.class.getName();
            Intrinsics.checkNotNullExpressionValue(name26, "getName(...)");
            AuthV4_Provider_Hive_Membership = name26;
            String name27 = ProviderHuawei.class.getName();
            Intrinsics.checkNotNullExpressionValue(name27, "getName(...)");
            AuthV4_Provider_Huawei = name27;
            String name28 = ProviderLine.class.getName();
            Intrinsics.checkNotNullExpressionValue(name28, "getName(...)");
            AuthV4_Provider_Line = name28;
            String name29 = ProviderOppo.class.getName();
            Intrinsics.checkNotNullExpressionValue(name29, "getName(...)");
            AuthV4_Provider_Oppo = name29;
            String name30 = ProviderQq.class.getName();
            Intrinsics.checkNotNullExpressionValue(name30, "getName(...)");
            AuthV4_Provider_Qq = name30;
            String name31 = ProviderSteam.class.getName();
            Intrinsics.checkNotNullExpressionValue(name31, "getName(...)");
            AuthV4_Provider_Steam = name31;
            String name32 = ProviderTelegram.class.getName();
            Intrinsics.checkNotNullExpressionValue(name32, "getName(...)");
            AuthV4_Provider_Telegram = name32;
            String name33 = ProviderVivo.class.getName();
            Intrinsics.checkNotNullExpressionValue(name33, "getName(...)");
            AuthV4_Provider_Vivo = name33;
            String name34 = ProviderVk.class.getName();
            Intrinsics.checkNotNullExpressionValue(name34, "getName(...)");
            AuthV4_Provider_Vk = name34;
            String name35 = ProviderWeChat.class.getName();
            Intrinsics.checkNotNullExpressionValue(name35, "getName(...)");
            AuthV4_Provider_WeChat = name35;
            String name36 = ProviderWeverse.class.getName();
            Intrinsics.checkNotNullExpressionValue(name36, "getName(...)");
            AuthV4_Provider_Weverse = name36;
            String name37 = ProviderX.class.getName();
            Intrinsics.checkNotNullExpressionValue(name37, "getName(...)");
            AuthV4_Provider_X = name37;
            String name38 = ProviderXiaomi.class.getName();
            Intrinsics.checkNotNullExpressionValue(name38, "getName(...)");
            AuthV4_Provider_Xiaomi = name38;
            String name39 = HiveChat.class.getName();
            Intrinsics.checkNotNullExpressionValue(name39, "getName(...)");
            Chat = name39;
            String name40 = HiveDataStore.class.getName();
            Intrinsics.checkNotNullExpressionValue(name40, "getName(...)");
            DataStore = name40;
            String name41 = HiveMatchMaking.class.getName();
            Intrinsics.checkNotNullExpressionValue(name41, "getName(...)");
            MatchMaking = name41;
            String name42 = HiveHercules.class.getName();
            Intrinsics.checkNotNullExpressionValue(name42, "getName(...)");
            Hercules = name42;
            String name43 = HiveIapV4.class.getName();
            Intrinsics.checkNotNullExpressionValue(name43, "getName(...)");
            IapV4 = name43;
            String name44 = Repayment.class.getName();
            Intrinsics.checkNotNullExpressionValue(name44, "getName(...)");
            IapV4_Repayment = name44;
            String name45 = MarketAmazon.class.getName();
            Intrinsics.checkNotNullExpressionValue(name45, "getName(...)");
            IapV4_Market_Amazon = name45;
            String name46 = MarketFacebookCloudGame.class.getName();
            Intrinsics.checkNotNullExpressionValue(name46, "getName(...)");
            IapV4_Market_Facebook_CloudGame = name46;
            String name47 = MarketGoogle.class.getName();
            Intrinsics.checkNotNullExpressionValue(name47, "getName(...)");
            IapV4_Market_Google = name47;
            String name48 = MarketHiveStore.class.getName();
            Intrinsics.checkNotNullExpressionValue(name48, "getName(...)");
            IapV4_Market_HiveStore = name48;
            String name49 = MarketHuawei.class.getName();
            Intrinsics.checkNotNullExpressionValue(name49, "getName(...)");
            IapV4_Market_Huawei = name49;
            String name50 = MarketLebi.class.getName();
            Intrinsics.checkNotNullExpressionValue(name50, "getName(...)");
            IapV4_Market_Lebi = name50;
            String name51 = MarketOneStore.class.getName();
            Intrinsics.checkNotNullExpressionValue(name51, "getName(...)");
            IapV4_Market_OneStore = name51;
            String name52 = MarketOneStoreV4.class.getName();
            Intrinsics.checkNotNullExpressionValue(name52, "getName(...)");
            IapV4_Market_OneStoreV4 = name52;
            String name53 = MarketOppo.class.getName();
            Intrinsics.checkNotNullExpressionValue(name53, "getName(...)");
            IapV4_Market_Oppo = name53;
            String name54 = MarketSamsung.class.getName();
            Intrinsics.checkNotNullExpressionValue(name54, "getName(...)");
            IapV4_Market_Samsung = name54;
            String name55 = MarketVivo.class.getName();
            Intrinsics.checkNotNullExpressionValue(name55, "getName(...)");
            IapV4_Market_Vivo = name55;
            String name56 = MarketXiaomi.class.getName();
            Intrinsics.checkNotNullExpressionValue(name56, "getName(...)");
            IapV4_Market_Xiaomi = name56;
            String name57 = HivePromotion.class.getName();
            Intrinsics.checkNotNullExpressionValue(name57, "getName(...)");
            Promotion = name57;
            String name58 = GoogleInAppReview.class.getName();
            Intrinsics.checkNotNullExpressionValue(name58, "getName(...)");
            Promotion_Google_InAppReview = name58;
            String name59 = AmazonAdm.class.getName();
            Intrinsics.checkNotNullExpressionValue(name59, "getName(...)");
            Push_Amazon_Adm = name59;
            String name60 = FacebookCloudGameA2u.class.getName();
            Intrinsics.checkNotNullExpressionValue(name60, "getName(...)");
            Push_FacebookCloudGame_A2u = name60;
            String name61 = GoogleFcm.class.getName();
            Intrinsics.checkNotNullExpressionValue(name61, "getName(...)");
            Push_Google_Fcm = name61;
            String name62 = HiveUserEngagement.class.getName();
            Intrinsics.checkNotNullExpressionValue(name62, "getName(...)");
            UserEngagement = name62;
            String name63 = HiveSocial.class.getName();
            Intrinsics.checkNotNullExpressionValue(name63, "getName(...)");
            Social = name63;
            String name64 = HiveSocialV4.class.getName();
            Intrinsics.checkNotNullExpressionValue(name64, "getName(...)");
            SocialV4 = name64;
            String name65 = C2s.class.getName();
            Intrinsics.checkNotNullExpressionValue(name65, "getName(...)");
            Plugin_C2s = name65;
        }

        private Companion() {
        }

        public final String getAgeRange_Google_AgeSignals() {
            return AgeRange_Google_AgeSignals;
        }

        public final String getAnalytics() {
            return Analytics;
        }

        public final String getAnalytics_Consent_Mode() {
            return Analytics_Consent_Mode;
        }

        public final String getAnalytics_Provider_Adjust() {
            return Analytics_Provider_Adjust;
        }

        public final String getAnalytics_Provider_Airbridge() {
            return Analytics_Provider_Airbridge;
        }

        public final String getAnalytics_Provider_AppsFlyer() {
            return Analytics_Provider_AppsFlyer;
        }

        public final String getAnalytics_Provider_Firebase() {
            return Analytics_Provider_Firebase;
        }

        public final String getAnalytics_Provider_Singular() {
            return Analytics_Provider_Singular;
        }

        public final String getAuth() {
            return Auth;
        }

        public final String getAuthV4() {
            return AuthV4;
        }

        public final String getAuthV4_Adult_Confirm() {
            return AuthV4_Adult_Confirm;
        }

        public final String getAuthV4_Device_Management() {
            return AuthV4_Device_Management;
        }

        public final String getAuthV4_Google_InAppUpdate() {
            return AuthV4_Google_InAppUpdate;
        }

        public final String getAuthV4_Google_Recaptcha() {
            return AuthV4_Google_Recaptcha;
        }

        public final String getAuthV4_Identity_Verification() {
            return AuthV4_Identity_Verification;
        }

        public final String getAuthV4_Provider_Apple_SignIn() {
            return AuthV4_Provider_Apple_SignIn;
        }

        public final String getAuthV4_Provider_Facebook() {
            return AuthV4_Provider_Facebook;
        }

        public final String getAuthV4_Provider_FacebookCloudGame() {
            return AuthV4_Provider_FacebookCloudGame;
        }

        public final String getAuthV4_Provider_Funtap() {
            return AuthV4_Provider_Funtap;
        }

        public final String getAuthV4_Provider_Funtap_Appraisal() {
            return AuthV4_Provider_Funtap_Appraisal;
        }

        public final String getAuthV4_Provider_Google_Credential_SignIn() {
            return AuthV4_Provider_Google_Credential_SignIn;
        }

        public final String getAuthV4_Provider_Google_PlayGames() {
            return AuthV4_Provider_Google_PlayGames;
        }

        public final String getAuthV4_Provider_Google_SignIn() {
            return AuthV4_Provider_Google_SignIn;
        }

        public final String getAuthV4_Provider_Hive_Membership() {
            return AuthV4_Provider_Hive_Membership;
        }

        public final String getAuthV4_Provider_Huawei() {
            return AuthV4_Provider_Huawei;
        }

        public final String getAuthV4_Provider_Line() {
            return AuthV4_Provider_Line;
        }

        public final String getAuthV4_Provider_Oppo() {
            return AuthV4_Provider_Oppo;
        }

        public final String getAuthV4_Provider_Qq() {
            return AuthV4_Provider_Qq;
        }

        public final String getAuthV4_Provider_Steam() {
            return AuthV4_Provider_Steam;
        }

        public final String getAuthV4_Provider_Telegram() {
            return AuthV4_Provider_Telegram;
        }

        public final String getAuthV4_Provider_Vivo() {
            return AuthV4_Provider_Vivo;
        }

        public final String getAuthV4_Provider_Vk() {
            return AuthV4_Provider_Vk;
        }

        public final String getAuthV4_Provider_WeChat() {
            return AuthV4_Provider_WeChat;
        }

        public final String getAuthV4_Provider_Weverse() {
            return AuthV4_Provider_Weverse;
        }

        public final String getAuthV4_Provider_X() {
            return AuthV4_Provider_X;
        }

        public final String getAuthV4_Provider_Xiaomi() {
            return AuthV4_Provider_Xiaomi;
        }

        public final String getAuthV4_Real_Name_Verification() {
            return AuthV4_Real_Name_Verification;
        }

        public final String getChat() {
            return Chat;
        }

        public final String getDataStore() {
            return DataStore;
        }

        public final String getHercules() {
            return Hercules;
        }

        public final String getIapV4() {
            return IapV4;
        }

        public final String getIapV4_Market_Amazon() {
            return IapV4_Market_Amazon;
        }

        public final String getIapV4_Market_Facebook_CloudGame() {
            return IapV4_Market_Facebook_CloudGame;
        }

        public final String getIapV4_Market_Google() {
            return IapV4_Market_Google;
        }

        public final String getIapV4_Market_HiveStore() {
            return IapV4_Market_HiveStore;
        }

        public final String getIapV4_Market_Huawei() {
            return IapV4_Market_Huawei;
        }

        public final String getIapV4_Market_Lebi() {
            return IapV4_Market_Lebi;
        }

        public final String getIapV4_Market_OneStore() {
            return IapV4_Market_OneStore;
        }

        public final String getIapV4_Market_OneStoreV4() {
            return IapV4_Market_OneStoreV4;
        }

        public final String getIapV4_Market_Oppo() {
            return IapV4_Market_Oppo;
        }

        public final String getIapV4_Market_Samsung() {
            return IapV4_Market_Samsung;
        }

        public final String getIapV4_Market_Vivo() {
            return IapV4_Market_Vivo;
        }

        public final String getIapV4_Market_Xiaomi() {
            return IapV4_Market_Xiaomi;
        }

        public final String getIapV4_Repayment() {
            return IapV4_Repayment;
        }

        public final String getMatchMaking() {
            return MatchMaking;
        }

        public final String getPlugin_C2s() {
            return Plugin_C2s;
        }

        public final String getPromotion() {
            return Promotion;
        }

        public final String getPromotion_Google_InAppReview() {
            return Promotion_Google_InAppReview;
        }

        public final String getPush_Amazon_Adm() {
            return Push_Amazon_Adm;
        }

        public final String getPush_FacebookCloudGame_A2u() {
            return Push_FacebookCloudGame_A2u;
        }

        public final String getPush_Google_Fcm() {
            return Push_Google_Fcm;
        }

        public final String getService_Google_Base() {
            return Service_Google_Base;
        }

        public final String getSocial() {
            return Social;
        }

        public final String getSocialV4() {
            return SocialV4;
        }

        public final String getUserEngagement() {
            return UserEngagement;
        }
    }
}
