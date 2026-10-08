package com.hive;

import android.content.Context;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.Constants;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Permission;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.configuration.HiveOrientation;
import com.hive.core.configuration.HiveZoneType;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HivePromotion;
import com.hive.push.PushImpl;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0010ß\u0001à\u0001á\u0001â\u0001ã\u0001ä\u0001å\u0001æ\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\u000bH\u0007J\u0012\u0010£\u0001\u001a\u00020&2\u0007\u0010¤\u0001\u001a\u00020(H\u0007J\u0014\u0010¥\u0001\u001a\u00030¦\u00012\b\u0010§\u0001\u001a\u00030¨\u0001H\u0007J\u0012\u0010´\u0001\u001a\u00020&2\u0007\u0010§\u0001\u001a\u00020\u000bH\u0007J\t\u0010Å\u0001\u001a\u00020&H\u0007J\t\u0010Æ\u0001\u001a\u00020(H\u0007J\u001b\u0010Ë\u0001\u001a\u00020&2\b\u0010Ì\u0001\u001a\u00030Í\u00012\u0006\u0010B\u001a\u00020\u000bH\u0007J%\u0010Ò\u0001\u001a\u00020&2\u0007\u0010Ó\u0001\u001a\u00020\u000b2\u0007\u0010Ô\u0001\u001a\u00020(2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0007R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u000eR*\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0019R*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010!\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0019R*\u0010'\u001a\u00020(2\u0006\u0010'\u001a\u00020(8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\u0003\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R*\u0010.\u001a\u00020(2\u0006\u0010.\u001a\u00020(8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\u0003\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R*\u00102\u001a\u00020(2\u0006\u00102\u001a\u00020(8F@BX\u0087\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\u0003\u001a\u0004\b4\u0010+\"\u0004\b5\u0010-R*\u00106\u001a\u00020(2\u0006\u00106\u001a\u00020(8F@BX\u0087\u000e¢\u0006\u0012\u0012\u0004\b7\u0010\u0003\u001a\u0004\b8\u0010+\"\u0004\b9\u0010-RB\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010;2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010;8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b=\u0010\u0003\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR*\u0010C\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bD\u0010\u0003\u001a\u0004\bE\u0010\u000e\"\u0004\bF\u0010\u0019R*\u0010H\u001a\u00020G2\u0006\u0010B\u001a\u00020G8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bI\u0010\u0003\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR*\u0010N\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bO\u0010\u0003\u001a\u0004\bP\u0010\u000e\"\u0004\bQ\u0010\u0019R*\u0010R\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bS\u0010\u0003\u001a\u0004\bT\u0010\u000e\"\u0004\bU\u0010\u0019R\u001a\u0010V\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\bW\u0010\u0003\u001a\u0004\bX\u0010\u000eR\u001a\u0010Y\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\bZ\u0010\u0003\u001a\u0004\b[\u0010\u000eR*\u0010\\\u001a\u00020G2\u0006\u0010\\\u001a\u00020G8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b]\u0010\u0003\u001a\u0004\b^\u0010K\"\u0004\b_\u0010MR*\u0010`\u001a\u00020G2\u0006\u0010`\u001a\u00020G8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\ba\u0010\u0003\u001a\u0004\bb\u0010K\"\u0004\bc\u0010MR*\u0010d\u001a\u00020G2\u0006\u0010d\u001a\u00020G8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\be\u0010\u0003\u001a\u0004\bf\u0010K\"\u0004\bg\u0010MR*\u0010h\u001a\u00020i2\u0006\u0010h\u001a\u00020i8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bj\u0010\u0003\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR*\u0010o\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010p8FX\u0087\u0004¢\u0006\f\u0012\u0004\bq\u0010\u0003\u001a\u0004\br\u0010?R\u001a\u0010s\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\bt\u0010\u0003\u001a\u0004\bu\u0010\u000eR*\u0010v\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bw\u0010\u0003\u001a\u0004\bx\u0010\u000e\"\u0004\by\u0010\u0019R\u001a\u0010z\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b{\u0010\u0003\u001a\u0004\b|\u0010\u000eR\u001a\u0010}\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b~\u0010\u0003\u001a\u0004\b\u007f\u0010\u000eR\u001d\u0010\u0080\u0001\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0081\u0001\u0010\u0003\u001a\u0005\b\u0082\u0001\u0010\u000eR/\u0010\u0083\u0001\u001a\u00020G2\u0007\u0010\u0083\u0001\u001a\u00020G8F@FX\u0087\u000e¢\u0006\u0015\u0012\u0005\b\u0084\u0001\u0010\u0003\u001a\u0005\b\u0085\u0001\u0010K\"\u0005\b\u0086\u0001\u0010MRC\u0010\u0087\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0088\u00012\u0010\u0010\u0087\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0088\u00018F@FX\u0087\u000e¢\u0006\u0017\u0012\u0005\b\u0089\u0001\u0010\u0003\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R/\u0010\u008f\u0001\u001a\u00020G2\u0007\u0010\u008e\u0001\u001a\u00020G8F@FX\u0087\u000e¢\u0006\u0015\u0012\u0005\b\u0090\u0001\u0010\u0003\u001a\u0005\b\u0091\u0001\u0010K\"\u0005\b\u0092\u0001\u0010MR/\u0010\u0093\u0001\u001a\u00020G2\u0007\u0010\u008e\u0001\u001a\u00020G8F@FX\u0087\u000e¢\u0006\u0015\u0012\u0005\b\u0094\u0001\u0010\u0003\u001a\u0005\b\u0095\u0001\u0010K\"\u0005\b\u0096\u0001\u0010MR3\u0010\u0099\u0001\u001a\u00030\u0098\u00012\b\u0010\u0097\u0001\u001a\u00030\u0098\u00018F@FX\u0087\u000e¢\u0006\u0017\u0012\u0005\b\u009a\u0001\u0010\u0003\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R/\u0010\u009f\u0001\u001a\u00020G2\u0007\u0010\u0097\u0001\u001a\u00020G8F@FX\u0087\u000e¢\u0006\u0015\u0012\u0005\b \u0001\u0010\u0003\u001a\u0005\b¡\u0001\u0010K\"\u0005\b¢\u0001\u0010MR2\u0010ª\u0001\u001a\u00030©\u00012\u0007\u0010B\u001a\u00030©\u00018F@FX\u0087\u000e¢\u0006\u0017\u0012\u0005\b«\u0001\u0010\u0003\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R.\u0010°\u0001\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b8F@FX\u0087\u000e¢\u0006\u0015\u0012\u0005\b±\u0001\u0010\u0003\u001a\u0005\b²\u0001\u0010\u000e\"\u0005\b³\u0001\u0010\u0019R2\u0010¶\u0001\u001a\u00030µ\u00012\u0007\u0010B\u001a\u00030µ\u00018F@FX\u0087\u000e¢\u0006\u0017\u0012\u0005\b·\u0001\u0010\u0003\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R/\u0010¼\u0001\u001a\u00020(2\u0007\u0010¼\u0001\u001a\u00020(8F@FX\u0087\u000e¢\u0006\u0015\u0012\u0005\b½\u0001\u0010\u0003\u001a\u0005\b¾\u0001\u0010+\"\u0005\b¿\u0001\u0010-R/\u0010Á\u0001\u001a\u00020(2\u0007\u0010À\u0001\u001a\u00020(8F@FX\u0087\u000e¢\u0006\u0015\u0012\u0005\bÂ\u0001\u0010\u0003\u001a\u0005\bÃ\u0001\u0010+\"\u0005\bÄ\u0001\u0010-R/\u0010Ç\u0001\u001a\u00020\u000b2\u0007\u0010Ç\u0001\u001a\u00020\u000b8F@FX\u0087\u000e¢\u0006\u0015\u0012\u0005\bÈ\u0001\u0010\u0003\u001a\u0005\bÉ\u0001\u0010\u000e\"\u0005\bÊ\u0001\u0010\u0019R.\u0010Î\u0001\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b8F@FX\u0087\u000e¢\u0006\u0015\u0012\u0005\bÏ\u0001\u0010\u0003\u001a\u0005\bÐ\u0001\u0010\u000e\"\u0005\bÑ\u0001\u0010\u0019R.\u0010×\u0001\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b8F@FX\u0087\u000e¢\u0006\u0015\u0012\u0005\bØ\u0001\u0010\u0003\u001a\u0005\bÙ\u0001\u0010\u000e\"\u0005\bÚ\u0001\u0010\u0019R.\u0010Û\u0001\u001a\u00020(2\u0006\u0010B\u001a\u00020(8F@FX\u0087\u000e¢\u0006\u0015\u0012\u0005\bÜ\u0001\u0010\u0003\u001a\u0005\bÝ\u0001\u0010+\"\u0005\bÞ\u0001\u0010-¨\u0006ç\u0001"}, d2 = {"Lcom/hive/Configuration;", "", "<init>", "()V", "hivePromotion", "Lcom/hive/module/interfaces/HivePromotion;", "getHivePromotion", "()Lcom/hive/module/interfaces/HivePromotion;", "hivePromotion$delegate", "Lkotlin/Lazy;", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "hiveSDKVersion", "getHiveSDKVersion$annotations", "getHiveSDKVersion", "referenceSDKVersion", "getReferenceSDKVersion$annotations", "getReferenceSDKVersion", "appId", "getAppId$annotations", "getAppId", "setAppId", "(Ljava/lang/String;)V", "zone", "Lcom/hive/Configuration$ZoneType;", "getZone$annotations", "getZone", "()Lcom/hive/Configuration$ZoneType;", "setZone", "(Lcom/hive/Configuration$ZoneType;)V", "serverId", "getServerId$annotations", "getServerId", "setServerId", "updateServerId", "", "useLog", "", "getUseLog$annotations", "getUseLog", "()Z", "setUseLog", "(Z)V", "ageGateU13", "getAgeGateU13$annotations", "getAgeGateU13", "setAgeGateU13", "ageGateU16Agree", "getAgeGateU16Agree$annotations", "getAgeGateU16Agree", "setAgeGateU16Agree", "legalGuardianConsentAgree", "getLegalGuardianConsentAgree$annotations", "getLegalGuardianConsentAgree", "setLegalGuardianConsentAgree", "permissions", "", "Lcom/hive/Configuration$HIVEPermissionType;", "getPermissions$annotations", "getPermissions", "()Ljava/util/Map;", "setPermissions", "(Ljava/util/Map;)V", "value", "company", "getCompany$annotations", "getCompany", "setCompany", "", "companyIndex", "getCompanyIndex$annotations", "getCompanyIndex", "()I", "setCompanyIndex", "(I)V", "channel", "getChannel$annotations", "getChannel", "setChannel", "market", "getMarket$annotations", "getMarket", "setMarket", "hiveCountry", "getHiveCountry$annotations", "getHiveCountry", "hiveTimeZone", "getHiveTimeZone$annotations", "getHiveTimeZone", "httpConnectTimeout", "getHttpConnectTimeout$annotations", "getHttpConnectTimeout", "setHttpConnectTimeout", "httpReadTimeout", "getHttpReadTimeout$annotations", "getHttpReadTimeout", "setHttpReadTimeout", "maxGameLogSize", "getMaxGameLogSize$annotations", "getMaxGameLogSize", "setMaxGameLogSize", Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH, "Lorg/json/JSONArray;", "getTrackers$annotations", "getTrackers", "()Lorg/json/JSONArray;", "setTrackers", "(Lorg/json/JSONArray;)V", "configuration", "", "getConfiguration$annotations", "getConfiguration", "qqAppId", "getQqAppId$annotations", "getQqAppId", "vkAppId", "getVkAppId$annotations", "getVkAppId", "setVkAppId", "wechatAppId", "getWechatAppId$annotations", "getWechatAppId", "wechatAppSecret", "getWechatAppSecret$annotations", "getWechatAppSecret", "wechatPaymentKey", "getWechatPaymentKey$annotations", "getWechatPaymentKey", "systemUI", "getSystemUI$annotations", "getSystemUI", "setSystemUI", "facebookPermissions", "", "getFacebookPermissions$annotations", "getFacebookPermissions", "()Ljava/util/List;", "setFacebookPermissions", "(Ljava/util/List;)V", "limit", "analyticsSendLimit", "getAnalyticsSendLimit$annotations", "getAnalyticsSendLimit", "setAnalyticsSendLimit", "analyticsQueueLimit", "getAnalyticsQueueLimit$annotations", "getAnalyticsQueueLimit", "setAnalyticsQueueLimit", "seconds", "", "analyticsSendCycleSeconds", "getAnalyticsSendCycleSeconds$annotations", "getAnalyticsSendCycleSeconds", "()F", "setAnalyticsSendCycleSeconds", "(F)V", "chatConnectionTimeout", "getChatConnectionTimeout$annotations", "getChatConnectionTimeout", "setChatConnectionTimeout", "setHivePermissionViewOn", "isOn", "getPermissionViewData", "Lcom/hive/Permission$PermissionViewData;", "language", "Lcom/hive/Configuration$HiveLanguage;", "Landroid/content/Context;", "context", "getContext$annotations", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "gameLanguage", "getGameLanguage$annotations", "getGameLanguage", "setGameLanguage", "updateGameLanguage", "Lcom/hive/Configuration$HiveTheme;", "hiveTheme", "getHiveTheme$annotations", "getHiveTheme", "()Lcom/hive/Configuration$HiveTheme;", "setHiveTheme", "(Lcom/hive/Configuration$HiveTheme;)V", "crossPromotionBannerShowing", "getCrossPromotionBannerShowing$annotations", "getCrossPromotionBannerShowing", "setCrossPromotionBannerShowing", "enable", "useGoogleCredentialSignIn", "getUseGoogleCredentialSignIn$annotations", "getUseGoogleCredentialSignIn", "setUseGoogleCredentialSignIn", "setTestZone", "isTestZone", "hiveCertificationKey", "getHiveCertificationKey$annotations", "getHiveCertificationKey", "setHiveCertificationKey", "setConfigurations", "configType", "Lcom/hive/Configuration$HiveConfigType;", "hiveOrientation", "getHiveOrientation$annotations", "getHiveOrientation", "setHiveOrientation", "getMetaData", "key", "forceReload", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Configuration$GetMetaDataListener;", "hiveCommunityUrl", "getHiveCommunityUrl$annotations", "getHiveCommunityUrl", "setHiveCommunityUrl", "useHercules", "getUseHercules$annotations", "getUseHercules", "setUseHercules", "ZoneType", "HiveLanguage", "HiveTheme", "GoogleSignInMethod", "HIVEPermissionType", "HIVECustomUIType", "HiveConfigType", "GetMetaDataListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Configuration {
    private static final String TAG;
    public static final Configuration INSTANCE = new Configuration();

    /* JADX INFO: renamed from: hivePromotion$delegate, reason: from kotlin metadata */
    private static final Lazy hivePromotion = LazyKt.lazy(new Function0() { // from class: com.hive.Configuration$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Configuration.hivePromotion_delegate$lambda$0();
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Configuration$GetMetaDataListener;", "", "onGetMetaData", "", "result", "Lcom/hive/ResultAPI;", "data", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface GetMetaDataListener {
        void onGetMetaData(ResultAPI result, String data);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/hive/Configuration$GoogleSignInMethod;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GoogleSignIn", "GoogleCredentialSignIn", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GoogleSignInMethod {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ GoogleSignInMethod[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String value;
        public static final GoogleSignInMethod GoogleSignIn = new GoogleSignInMethod("GoogleSignIn", 0, "googleSignIn");
        public static final GoogleSignInMethod GoogleCredentialSignIn = new GoogleSignInMethod("GoogleCredentialSignIn", 1, "googleCredentialSignIn");

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/Configuration$GoogleSignInMethod$Companion;", "", "<init>", "()V", "getEnum", "Lcom/hive/Configuration$GoogleSignInMethod;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final GoogleSignInMethod getEnum(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (GoogleSignInMethod googleSignInMethod : GoogleSignInMethod.values()) {
                    if (Intrinsics.areEqual(value, googleSignInMethod.getValue())) {
                        return googleSignInMethod;
                    }
                }
                return GoogleSignInMethod.GoogleSignIn;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ GoogleSignInMethod[] $values() {
            return new GoogleSignInMethod[]{GoogleSignIn, GoogleCredentialSignIn};
        }

        static {
            GoogleSignInMethod[] googleSignInMethodArr$values = $values();
            $VALUES = googleSignInMethodArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(googleSignInMethodArr$values);
            INSTANCE = new Companion(null);
        }

        private GoogleSignInMethod(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<GoogleSignInMethod> getEntries() {
            return $ENTRIES;
        }

        public static GoogleSignInMethod valueOf(String str) {
            return (GoogleSignInMethod) Enum.valueOf(GoogleSignInMethod.class, str);
        }

        public static GoogleSignInMethod[] values() {
            return (GoogleSignInMethod[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/hive/Configuration$HIVECustomUIType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SIGN_IN", "CONNECT", "ACHIEVEMENT", "SYNC_ACCOUNT", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HIVECustomUIType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HIVECustomUIType[] $VALUES;
        private final String value;
        public static final HIVECustomUIType SIGN_IN = new HIVECustomUIType("SIGN_IN", 0, "signIn");
        public static final HIVECustomUIType CONNECT = new HIVECustomUIType("CONNECT", 1, "connect");
        public static final HIVECustomUIType ACHIEVEMENT = new HIVECustomUIType("ACHIEVEMENT", 2, AppLovinEventTypes.USER_COMPLETED_ACHIEVEMENT);
        public static final HIVECustomUIType SYNC_ACCOUNT = new HIVECustomUIType("SYNC_ACCOUNT", 3, "syncAccount");

        private static final /* synthetic */ HIVECustomUIType[] $values() {
            return new HIVECustomUIType[]{SIGN_IN, CONNECT, ACHIEVEMENT, SYNC_ACCOUNT};
        }

        static {
            HIVECustomUIType[] hIVECustomUITypeArr$values = $values();
            $VALUES = hIVECustomUITypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hIVECustomUITypeArr$values);
        }

        private HIVECustomUIType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<HIVECustomUIType> getEntries() {
            return $ENTRIES;
        }

        public static HIVECustomUIType valueOf(String str) {
            return (HIVECustomUIType) Enum.valueOf(HIVECustomUIType.class, str);
        }

        public static HIVECustomUIType[] values() {
            return (HIVECustomUIType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/hive/Configuration$HIVEPermissionType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SDWRITE", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Deprecated(message = "4.16.2, GCPSDK4-906")
    public static final class HIVEPermissionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HIVEPermissionType[] $VALUES;
        public static final HIVEPermissionType SDWRITE = new HIVEPermissionType("SDWRITE", 0, "sdwrite");
        private final String value;

        private static final /* synthetic */ HIVEPermissionType[] $values() {
            return new HIVEPermissionType[]{SDWRITE};
        }

        static {
            HIVEPermissionType[] hIVEPermissionTypeArr$values = $values();
            $VALUES = hIVEPermissionTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hIVEPermissionTypeArr$values);
        }

        private HIVEPermissionType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<HIVEPermissionType> getEntries() {
            return $ENTRIES;
        }

        public static HIVEPermissionType valueOf(String str) {
            return (HIVEPermissionType) Enum.valueOf(HIVEPermissionType.class, str);
        }

        public static HIVEPermissionType[] values() {
            return (HIVEPermissionType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/hive/Configuration$HiveConfigType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "googleServerClientId", "googlePlayGamesServerClientId", "wechatSecret", "wechatPaymentKey", "adjustKey", "singularKey", "appsflyerKey", "airbridgeKey", "airbridgeAppName", "airbridgeSecretId", "airbridgeSecret", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HiveConfigType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HiveConfigType[] $VALUES;
        private final String value;
        public static final HiveConfigType googleServerClientId = new HiveConfigType("googleServerClientId", 0, "googleServerClientId");
        public static final HiveConfigType googlePlayGamesServerClientId = new HiveConfigType("googlePlayGamesServerClientId", 1, "googlePlayGamesServerClientId");
        public static final HiveConfigType wechatSecret = new HiveConfigType("wechatSecret", 2, "wechatSecret");
        public static final HiveConfigType wechatPaymentKey = new HiveConfigType("wechatPaymentKey", 3, "wechatPaymentKey");
        public static final HiveConfigType adjustKey = new HiveConfigType("adjustKey", 4, "adjustKey");
        public static final HiveConfigType singularKey = new HiveConfigType("singularKey", 5, "singularKey");
        public static final HiveConfigType appsflyerKey = new HiveConfigType("appsflyerKey", 6, "appsflyerKey");
        public static final HiveConfigType airbridgeKey = new HiveConfigType("airbridgeKey", 7, "airbridgeKey");
        public static final HiveConfigType airbridgeAppName = new HiveConfigType("airbridgeAppName", 8, "airbridgeAppName");
        public static final HiveConfigType airbridgeSecretId = new HiveConfigType("airbridgeSecretId", 9, "airbridgeSecretId");
        public static final HiveConfigType airbridgeSecret = new HiveConfigType("airbridgeSecret", 10, "airbridgeSecret");

        private static final /* synthetic */ HiveConfigType[] $values() {
            return new HiveConfigType[]{googleServerClientId, googlePlayGamesServerClientId, wechatSecret, wechatPaymentKey, adjustKey, singularKey, appsflyerKey, airbridgeKey, airbridgeAppName, airbridgeSecretId, airbridgeSecret};
        }

        static {
            HiveConfigType[] hiveConfigTypeArr$values = $values();
            $VALUES = hiveConfigTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hiveConfigTypeArr$values);
        }

        private HiveConfigType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<HiveConfigType> getEntries() {
            return $ENTRIES;
        }

        public static HiveConfigType valueOf(String str) {
            return (HiveConfigType) Enum.valueOf(HiveConfigType.class, str);
        }

        public static HiveConfigType[] values() {
            return (HiveConfigType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/hive/Configuration$HiveLanguage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LanguageAR", "LanguageDE", "LanguageEN", "LanguageES", "LanguageFR", "LanguageIN", "LanguageIT", "LanguageJA", "LanguageKO", "LanguagePT", "LanguageRU", "LanguageTH", "LanguageTR", "LanguageVI", "LanguageZHS", "LanguageZHT", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HiveLanguage {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HiveLanguage[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final HiveLanguage LanguageAR = new HiveLanguage("LanguageAR", 0, "ar");
        public static final HiveLanguage LanguageDE = new HiveLanguage("LanguageDE", 1, "de");
        public static final HiveLanguage LanguageEN = new HiveLanguage("LanguageEN", 2, "en");
        public static final HiveLanguage LanguageES = new HiveLanguage("LanguageES", 3, "es");
        public static final HiveLanguage LanguageFR = new HiveLanguage("LanguageFR", 4, "fr");
        public static final HiveLanguage LanguageIN = new HiveLanguage("LanguageIN", 5, ScarConstants.IN_SIGNAL_KEY);
        public static final HiveLanguage LanguageIT = new HiveLanguage("LanguageIT", 6, "it");
        public static final HiveLanguage LanguageJA = new HiveLanguage("LanguageJA", 7, "ja");
        public static final HiveLanguage LanguageKO = new HiveLanguage("LanguageKO", 8, "ko");
        public static final HiveLanguage LanguagePT = new HiveLanguage("LanguagePT", 9, "pt");
        public static final HiveLanguage LanguageRU = new HiveLanguage("LanguageRU", 10, "ru");
        public static final HiveLanguage LanguageTH = new HiveLanguage("LanguageTH", 11, "th");
        public static final HiveLanguage LanguageTR = new HiveLanguage("LanguageTR", 12, "tr");
        public static final HiveLanguage LanguageVI = new HiveLanguage("LanguageVI", 13, "vi");
        public static final HiveLanguage LanguageZHS = new HiveLanguage("LanguageZHS", 14, "zh-hans");
        public static final HiveLanguage LanguageZHT = new HiveLanguage("LanguageZHT", 15, "zh-hant");
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/Configuration$HiveLanguage$Companion;", "", "<init>", "()V", "getEnum", "Lcom/hive/Configuration$HiveLanguage;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final HiveLanguage getEnum(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (HiveLanguage hiveLanguage : HiveLanguage.values()) {
                    if (Intrinsics.areEqual(hiveLanguage.getValue(), value)) {
                        return hiveLanguage;
                    }
                }
                return HiveLanguage.LanguageEN;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ HiveLanguage[] $values() {
            return new HiveLanguage[]{LanguageAR, LanguageDE, LanguageEN, LanguageES, LanguageFR, LanguageIN, LanguageIT, LanguageJA, LanguageKO, LanguagePT, LanguageRU, LanguageTH, LanguageTR, LanguageVI, LanguageZHS, LanguageZHT};
        }

        static {
            HiveLanguage[] hiveLanguageArr$values = $values();
            $VALUES = hiveLanguageArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hiveLanguageArr$values);
            INSTANCE = new Companion(null);
        }

        private HiveLanguage(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<HiveLanguage> getEntries() {
            return $ENTRIES;
        }

        public static HiveLanguage valueOf(String str) {
            return (HiveLanguage) Enum.valueOf(HiveLanguage.class, str);
        }

        public static HiveLanguage[] values() {
            return (HiveLanguage[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/hive/Configuration$HiveTheme;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HiveLight", "HiveDark", "lowerCaseValue", "getLowerCaseValue", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HiveTheme {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HiveTheme[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String value;
        public static final HiveTheme HiveLight = new HiveTheme("HiveLight", 0, "hiveLight");
        public static final HiveTheme HiveDark = new HiveTheme("HiveDark", 1, "hiveDark");

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/Configuration$HiveTheme$Companion;", "", "<init>", "()V", "getEnum", "Lcom/hive/Configuration$HiveTheme;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final HiveTheme getEnum(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (HiveTheme hiveTheme : HiveTheme.values()) {
                    if (Intrinsics.areEqual(hiveTheme.getValue(), value)) {
                        return hiveTheme;
                    }
                }
                return HiveTheme.HiveLight;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ HiveTheme[] $values() {
            return new HiveTheme[]{HiveLight, HiveDark};
        }

        static {
            HiveTheme[] hiveThemeArr$values = $values();
            $VALUES = hiveThemeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hiveThemeArr$values);
            INSTANCE = new Companion(null);
        }

        private HiveTheme(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<HiveTheme> getEntries() {
            return $ENTRIES;
        }

        public static HiveTheme valueOf(String str) {
            return (HiveTheme) Enum.valueOf(HiveTheme.class, str);
        }

        public static HiveTheme[] values() {
            return (HiveTheme[]) $VALUES.clone();
        }

        public final String getLowerCaseValue() {
            String str = this.value;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/hive/Configuration$ZoneType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REAL", "SANDBOX", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ZoneType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ZoneType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ZoneType REAL = new ZoneType("REAL", 0, "real");
        public static final ZoneType SANDBOX = new ZoneType("SANDBOX", 1, AdjustConfig.ENVIRONMENT_SANDBOX);
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/Configuration$ZoneType$Companion;", "", "<init>", "()V", "getEnum", "Lcom/hive/Configuration$ZoneType;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ZoneType getEnum(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (ZoneType zoneType : ZoneType.values()) {
                    if (Intrinsics.areEqual(value, zoneType.getValue())) {
                        return zoneType;
                    }
                }
                return ZoneType.REAL;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ ZoneType[] $values() {
            return new ZoneType[]{REAL, SANDBOX};
        }

        static {
            ZoneType[] zoneTypeArr$values = $values();
            $VALUES = zoneTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(zoneTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private ZoneType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<ZoneType> getEntries() {
            return $ENTRIES;
        }

        public static ZoneType valueOf(String str) {
            return (ZoneType) Enum.valueOf(ZoneType.class, str);
        }

        public static ZoneType[] values() {
            return (ZoneType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("Configuration", "getSimpleName(...)");
        TAG = "Configuration";
    }

    private Configuration() {
    }

    public static final boolean getAgeGateU13() {
        return ConfigurationImpl.INSTANCE.getAgeGateU13();
    }

    @JvmStatic
    public static /* synthetic */ void getAgeGateU13$annotations() {
    }

    public static final boolean getAgeGateU16Agree() {
        return ConfigurationImpl.INSTANCE.getAgeGateU16Agree();
    }

    @JvmStatic
    public static /* synthetic */ void getAgeGateU16Agree$annotations() {
    }

    public static final int getAnalyticsQueueLimit() {
        return ConfigurationImpl.INSTANCE.getAnalyticsQueueLimit();
    }

    @JvmStatic
    public static /* synthetic */ void getAnalyticsQueueLimit$annotations() {
    }

    public static final float getAnalyticsSendCycleSeconds() {
        return ConfigurationImpl.INSTANCE.getAnalyticsSendCycleSeconds();
    }

    @JvmStatic
    public static /* synthetic */ void getAnalyticsSendCycleSeconds$annotations() {
    }

    public static final int getAnalyticsSendLimit() {
        return ConfigurationImpl.INSTANCE.getAnalyticsSendLimit();
    }

    @JvmStatic
    public static /* synthetic */ void getAnalyticsSendLimit$annotations() {
    }

    public static final String getAppId() {
        return ConfigurationImpl.INSTANCE.getAppId();
    }

    @JvmStatic
    public static /* synthetic */ void getAppId$annotations() {
    }

    public static final String getChannel() {
        return ConfigurationImpl.INSTANCE.getChannel();
    }

    @JvmStatic
    public static /* synthetic */ void getChannel$annotations() {
    }

    public static final int getChatConnectionTimeout() {
        return ConfigurationImpl.INSTANCE.getChatConnectionTimeout();
    }

    @JvmStatic
    public static /* synthetic */ void getChatConnectionTimeout$annotations() {
    }

    public static final String getCompany() {
        return ConfigurationImpl.INSTANCE.getCompany();
    }

    @JvmStatic
    public static /* synthetic */ void getCompany$annotations() {
    }

    public static final int getCompanyIndex() {
        return ConfigurationImpl.INSTANCE.getCompanyIndex();
    }

    @JvmStatic
    public static /* synthetic */ void getCompanyIndex$annotations() {
    }

    public static final Map<String, Object> getConfiguration() {
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        if (configurationImpl.parseXmlConfigurationFile()) {
            return configurationImpl.toMap();
        }
        return null;
    }

    @JvmStatic
    public static /* synthetic */ void getConfiguration$annotations() {
    }

    public static final Context getContext() {
        return HiveActivity.isActivityInitialized() ? HiveActivity.INSTANCE.getRecentActivity() : HiveCoreInitializer.INSTANCE.getInitContext();
    }

    @JvmStatic
    public static /* synthetic */ void getContext$annotations() {
    }

    public static final boolean getCrossPromotionBannerShowing() {
        return ConfigurationImpl.INSTANCE.getCrossPromotionBannerShowing();
    }

    @JvmStatic
    public static /* synthetic */ void getCrossPromotionBannerShowing$annotations() {
    }

    public static final List<String> getFacebookPermissions() {
        return ConfigurationImpl.INSTANCE.getFacebookPermissions();
    }

    @JvmStatic
    public static /* synthetic */ void getFacebookPermissions$annotations() {
    }

    public static final String getGameLanguage() {
        return ConfigurationImpl.INSTANCE.getHiveLanguage();
    }

    @JvmStatic
    public static /* synthetic */ void getGameLanguage$annotations() {
    }

    public static final String getHiveCertificationKey() {
        return ConfigurationImpl.INSTANCE.getHiveCertificationKey();
    }

    @JvmStatic
    public static /* synthetic */ void getHiveCertificationKey$annotations() {
    }

    public static final String getHiveCommunityUrl() {
        return ConfigurationImpl.INSTANCE.getHiveCommunityUrl();
    }

    @JvmStatic
    public static /* synthetic */ void getHiveCommunityUrl$annotations() {
    }

    public static final String getHiveCountry() {
        return ConfigurationImpl.INSTANCE.getHiveCountry();
    }

    @JvmStatic
    public static /* synthetic */ void getHiveCountry$annotations() {
    }

    public static final String getHiveOrientation() {
        return ConfigurationImpl.INSTANCE.getHiveOrientation().getValue();
    }

    @JvmStatic
    public static /* synthetic */ void getHiveOrientation$annotations() {
    }

    private final HivePromotion getHivePromotion() {
        return (HivePromotion) hivePromotion.getValue();
    }

    public static final String getHiveSDKVersion() {
        return "4.26.2.0";
    }

    @JvmStatic
    public static /* synthetic */ void getHiveSDKVersion$annotations() {
    }

    public static final HiveTheme getHiveTheme() {
        return HiveTheme.INSTANCE.getEnum(ConfigurationImpl.INSTANCE.getHiveTheme().getValue());
    }

    @JvmStatic
    public static /* synthetic */ void getHiveTheme$annotations() {
    }

    public static final String getHiveTimeZone() {
        String string = ConfigurationImpl.INSTANCE.getHiveTimeZone().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    public static /* synthetic */ void getHiveTimeZone$annotations() {
    }

    public static final int getHttpConnectTimeout() {
        return ConfigurationImpl.INSTANCE.getHttpConnectTimeout();
    }

    @JvmStatic
    public static /* synthetic */ void getHttpConnectTimeout$annotations() {
    }

    public static final int getHttpReadTimeout() {
        return ConfigurationImpl.INSTANCE.getHttpReadTimeout();
    }

    @JvmStatic
    public static /* synthetic */ void getHttpReadTimeout$annotations() {
    }

    public static final boolean getLegalGuardianConsentAgree() {
        return ConfigurationImpl.INSTANCE.getLegalGuardianConsentAgree();
    }

    @JvmStatic
    public static /* synthetic */ void getLegalGuardianConsentAgree$annotations() {
    }

    public static final String getMarket() {
        return ConfigurationImpl.INSTANCE.getMarket();
    }

    @JvmStatic
    public static /* synthetic */ void getMarket$annotations() {
    }

    public static final int getMaxGameLogSize() {
        return ConfigurationImpl.INSTANCE.getMaxGameLogSize();
    }

    @JvmStatic
    public static /* synthetic */ void getMaxGameLogSize$annotations() {
    }

    @JvmStatic
    public static final void getMetaData(String key, boolean forceReload, GetMetaDataListener listener) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        ConfigurationImpl.INSTANCE.getMetaData(key, forceReload, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @Deprecated(message = "4.16.2, GCPSDK4-906")
    @JvmStatic
    public static final Permission.PermissionViewData getPermissionViewData(HiveLanguage language) {
        Intrinsics.checkNotNullParameter(language, "language");
        return ConfigurationImpl.INSTANCE.getPermissionViewData(com.hive.core.configuration.HiveLanguage.INSTANCE.getEnum(language.getValue()));
    }

    public static final Map<HIVEPermissionType, Object> getPermissions() {
        return ConfigurationImpl.INSTANCE.getPermissions();
    }

    @JvmStatic
    public static /* synthetic */ void getPermissions$annotations() {
    }

    public static final String getQqAppId() {
        return ConfigurationImpl.INSTANCE.getQQAppId();
    }

    @JvmStatic
    public static /* synthetic */ void getQqAppId$annotations() {
    }

    public static final String getReferenceSDKVersion() {
        return ConfigurationImpl.INSTANCE.getReferenceSDKVersion();
    }

    @JvmStatic
    public static /* synthetic */ void getReferenceSDKVersion$annotations() {
    }

    public static final String getServerId() {
        return ConfigurationImpl.INSTANCE.getServerId();
    }

    @JvmStatic
    public static /* synthetic */ void getServerId$annotations() {
    }

    public static final int getSystemUI() {
        return ConfigurationImpl.INSTANCE.getSystemUI();
    }

    @JvmStatic
    public static /* synthetic */ void getSystemUI$annotations() {
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    public static final JSONArray getTrackers() {
        return ConfigurationImpl.INSTANCE.getTrackers();
    }

    @JvmStatic
    public static /* synthetic */ void getTrackers$annotations() {
    }

    public static final boolean getUseGoogleCredentialSignIn() {
        return ConfigurationImpl.INSTANCE.getUseGoogleCredentialSignIn();
    }

    @JvmStatic
    public static /* synthetic */ void getUseGoogleCredentialSignIn$annotations() {
    }

    public static final boolean getUseHercules() {
        return ConfigurationImpl.INSTANCE.getUseHercules();
    }

    @JvmStatic
    public static /* synthetic */ void getUseHercules$annotations() {
    }

    public static final boolean getUseLog() {
        return ConfigurationImpl.INSTANCE.getUseLog();
    }

    @JvmStatic
    public static /* synthetic */ void getUseLog$annotations() {
    }

    public static final String getVkAppId() {
        return ConfigurationImpl.INSTANCE.getVKAppId();
    }

    @JvmStatic
    public static /* synthetic */ void getVkAppId$annotations() {
    }

    public static final String getWechatAppId() {
        return ConfigurationImpl.INSTANCE.getWechatAppId();
    }

    @JvmStatic
    public static /* synthetic */ void getWechatAppId$annotations() {
    }

    public static final String getWechatAppSecret() {
        return ConfigurationImpl.INSTANCE.getWechatAppSecret();
    }

    @JvmStatic
    public static /* synthetic */ void getWechatAppSecret$annotations() {
    }

    public static final String getWechatPaymentKey() {
        return ConfigurationImpl.INSTANCE.getWechatPaymentKey();
    }

    @JvmStatic
    public static /* synthetic */ void getWechatPaymentKey$annotations() {
    }

    public static final ZoneType getZone() {
        return ZoneType.INSTANCE.getEnum(ConfigurationImpl.INSTANCE.getZone().getValue());
    }

    @JvmStatic
    public static /* synthetic */ void getZone$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HivePromotion hivePromotion_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HivePromotion.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HivePromotion)) {
            hiveModule = null;
        }
        return (HivePromotion) (hiveModule instanceof HivePromotion ? hiveModule : null);
    }

    @JvmStatic
    public static final boolean isTestZone() {
        LoggerImpl.INSTANCE.apiCalledLog(TAG, "");
        return ConfigurationImpl.INSTANCE.isTestZone();
    }

    public static final void setAgeGateU13(boolean z) {
        ConfigurationImpl.INSTANCE.setAgeGateU13(z);
    }

    private static final void setAgeGateU16Agree(boolean z) {
    }

    public static final void setAnalyticsQueueLimit(int i) {
        ConfigurationImpl.INSTANCE.setAnalyticsQueueLimit(i);
    }

    public static final void setAnalyticsSendCycleSeconds(float f) {
        ConfigurationImpl.INSTANCE.setAnalyticsSendCycleSeconds(f);
    }

    public static final void setAnalyticsSendLimit(int i) {
        ConfigurationImpl.INSTANCE.setAnalyticsSendLimit(i);
    }

    public static final void setAppId(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        ConfigurationImpl.INSTANCE.setAppId(appId);
    }

    public static final void setChannel(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ConfigurationImpl.INSTANCE.setChannel(value);
    }

    public static final void setChatConnectionTimeout(int i) {
        ConfigurationImpl.INSTANCE.setChatConnectionTimeout(i);
    }

    public static final void setCompany(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ConfigurationImpl.INSTANCE.setCompany(value);
    }

    public static final void setCompanyIndex(int i) {
        ConfigurationImpl.INSTANCE.setCompanyIndex(i);
    }

    @JvmStatic
    public static final void setConfigurations(HiveConfigType configType, String value) {
        Intrinsics.checkNotNullParameter(configType, "configType");
        Intrinsics.checkNotNullParameter(value, "value");
        String str = "configType: " + configType.getValue() + ", value: " + value;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(AuthV4.getTAG(), str);
        ConfigurationImpl.INSTANCE.setConfigurations(configType, value);
        loggerImpl.apiReturnLog(AuthV4.getTAG(), "");
    }

    public static final void setContext(Context value) {
        Intrinsics.checkNotNullParameter(value, "value");
        HiveCoreInitializer.Companion companion = HiveCoreInitializer.INSTANCE;
        Context applicationContext = value.getApplicationContext();
        if (applicationContext != null) {
            value = applicationContext;
        }
        companion.setInitContext(value);
    }

    public static final void setCrossPromotionBannerShowing(boolean z) {
        ConfigurationImpl.INSTANCE.setCrossPromotionBannerShowing(z);
    }

    public static final void setFacebookPermissions(List<String> list) {
        ConfigurationImpl.INSTANCE.setFacebookPermissions(list);
    }

    public static final void setGameLanguage(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ConfigurationImpl.INSTANCE.setHiveLanguage(value, false);
    }

    public static final void setHiveCertificationKey(String hiveCertificationKey) {
        Intrinsics.checkNotNullParameter(hiveCertificationKey, "hiveCertificationKey");
        ConfigurationImpl.INSTANCE.setHiveCertificationKey(hiveCertificationKey);
    }

    public static final void setHiveCommunityUrl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ConfigurationImpl.INSTANCE.setHiveCommunityUrl(value);
    }

    public static final void setHiveOrientation(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ConfigurationImpl.INSTANCE.setHiveOrientation(HiveOrientation.INSTANCE.getEnum(value));
    }

    @Deprecated(message = "4.16.2, GCPSDK4-906")
    @JvmStatic
    public static final void setHivePermissionViewOn(boolean isOn) {
        ConfigurationImpl.INSTANCE.setHivePermissionViewOn(isOn);
    }

    public static final void setHiveTheme(HiveTheme value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ConfigurationImpl.INSTANCE.setHiveTheme(com.hive.core.configuration.HiveTheme.INSTANCE.getEnum(value.getValue()));
    }

    public static final void setHttpConnectTimeout(int i) {
        ConfigurationImpl.INSTANCE.setHttpConnectTimeout(i);
    }

    public static final void setHttpReadTimeout(int i) {
        ConfigurationImpl.INSTANCE.setHttpReadTimeout(i);
    }

    private static final void setLegalGuardianConsentAgree(boolean z) {
    }

    public static final void setMarket(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ConfigurationImpl.INSTANCE.setMarket(value);
    }

    public static final void setMaxGameLogSize(int i) {
        ConfigurationImpl.INSTANCE.setMaxGameLogSize(i);
    }

    public static final void setPermissions(Map<HIVEPermissionType, ? extends Object> permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        ConfigurationImpl.INSTANCE.setPermissions(permissions);
    }

    public static final void setServerId(String serverId) {
        Intrinsics.checkNotNullParameter(serverId, "serverId");
        ConfigurationImpl.INSTANCE.setServerId(serverId);
    }

    public static final void setSystemUI(int i) {
        ConfigurationImpl.INSTANCE.setSystemUI(i);
    }

    @JvmStatic
    public static final void setTestZone() {
        LoggerImpl.INSTANCE.apiCalledLog(TAG, "");
        ConfigurationImpl.INSTANCE.setTestZone();
    }

    public static final void setTrackers(JSONArray trackers) {
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        ConfigurationImpl.INSTANCE.setTrackers(trackers);
    }

    public static final void setUseGoogleCredentialSignIn(boolean z) {
        ConfigurationImpl.INSTANCE.setUseGoogleCredentialSignIn(z);
    }

    public static final void setUseHercules(boolean z) {
        ConfigurationImpl.INSTANCE.setUseHercules(z);
    }

    public static final void setUseLog(boolean z) {
        ConfigurationImpl.INSTANCE.setUseLog(z);
    }

    public static final void setVkAppId(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        ConfigurationImpl.INSTANCE.setVKAppId(appId);
    }

    public static final void setZone(ZoneType zone) {
        Intrinsics.checkNotNullParameter(zone, "zone");
        ConfigurationImpl.INSTANCE.setZone(HiveZoneType.INSTANCE.getEnum(zone.getValue()));
    }

    @JvmStatic
    public static final void updateGameLanguage(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, language);
        setGameLanguage(language);
        PushImpl.INSTANCE.onUpdateGameLanguage();
        HivePromotion hivePromotion2 = INSTANCE.getHivePromotion();
        if (hivePromotion2 != null) {
            hivePromotion2.updatePromotionData();
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void updateServerId(String serverId) {
        Intrinsics.checkNotNullParameter(serverId, "serverId");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, serverId);
        setServerId(serverId);
        PushImpl.INSTANCE.onUpdateServerId();
        HivePromotion hivePromotion2 = INSTANCE.getHivePromotion();
        if (hivePromotion2 != null) {
            hivePromotion2.updatePromotionData();
        }
        loggerImpl.apiReturnLog(str, "");
    }
}
