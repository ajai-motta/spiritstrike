package com.hive.core;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.hive.core.configuration.HiveInterfaceType;
import com.hive.core.configuration.HiveLanguage;
import com.hive.core.configuration.HiveOrientation;
import com.hive.core.configuration.HiveTheme;
import com.hive.core.configuration.HiveZoneType;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\bE\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b<\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010ð\u0001\u001a\u00020\u00052\t\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010+\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b+\u0010(R&\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R&\u00104\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R&\u00107\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R&\u0010:\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R&\u0010=\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00101\"\u0004\b?\u00103R&\u0010@\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00101\"\u0004\bB\u00103R&\u0010C\u001a\u00020&2\u0006\u0010.\u001a\u00020&8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010(\"\u0004\bD\u0010*R&\u0010E\u001a\u00020&2\u0006\u0010.\u001a\u00020&8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010(\"\u0004\bF\u0010*R\u001a\u0010G\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00101\"\u0004\bI\u00103R\u001a\u0010J\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00101\"\u0004\bL\u00103R\u001a\u0010M\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00101\"\u0004\bO\u00103R\u001a\u0010P\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00101\"\u0004\bR\u00103R\u001a\u0010S\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00101\"\u0004\bU\u00103R\u001a\u0010V\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u001f\"\u0004\bX\u0010!R\u001a\u0010Y\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00101\"\u0004\b[\u00103R\u001a\u0010\\\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010(\"\u0004\b]\u0010*R\u001a\u0010^\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u001f\"\u0004\b`\u0010!R\u001a\u0010a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00101\"\u0004\bc\u00103R\u001a\u0010d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00101\"\u0004\bf\u00103R\u001a\u0010g\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00101\"\u0004\bi\u00103R\u0011\u0010j\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bk\u00101R*\u0010m\u001a\u0004\u0018\u00010l2\b\u0010.\u001a\u0004\u0018\u00010l8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001a\u0010r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u00101\"\u0004\bt\u00103R$\u0010u\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u00101\"\u0004\bw\u00103R\u001a\u0010x\u001a\u00020yX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001e\u0010~\u001a\u00020\u007fX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R'\u0010\u0084\u0001\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u00101\"\u0005\b\u0086\u0001\u00103R+\u0010\u0088\u0001\u001a\u00030\u0087\u00012\u0007\u0010.\u001a\u00030\u0087\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001e\u0010\u008d\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008f\u0001\u0010-\u001a\u0005\b\u008e\u0001\u00101R\u001f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u00101\"\u0005\b\u0092\u0001\u00103R'\u0010\u0093\u0001\u001a\u00020&2\u0006\u0010.\u001a\u00020&@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010(\"\u0005\b\u0095\u0001\u0010*R\u001d\u0010\u0096\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u00101\"\u0005\b\u0097\u0001\u00103R+\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u00101\"\u0005\b\u009a\u0001\u00103R\u001d\u0010\u009b\u0001\u001a\u00020&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010(\"\u0005\b\u009c\u0001\u0010*R\"\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u008a\u0001\"\u0006\b\u009f\u0001\u0010\u008c\u0001R+\u0010 \u0001\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u00101\"\u0005\b¢\u0001\u00103R\u001d\u0010£\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u00101\"\u0005\b¥\u0001\u00103R(\u0010¦\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010§\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R\u001d\u0010¬\u0001\u001a\u00020&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010(\"\u0005\b®\u0001\u0010*R\u001d\u0010¯\u0001\u001a\u00020\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b°\u0001\u0010\u001f\"\u0005\b±\u0001\u0010!R(\u0010²\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010§\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b³\u0001\u0010©\u0001\"\u0006\b´\u0001\u0010«\u0001R \u0010µ\u0001\u001a\u00030¶\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b¹\u0001\u0010-\u001a\u0006\b·\u0001\u0010¸\u0001R\u0013\u0010º\u0001\u001a\u00020&8F¢\u0006\u0007\u001a\u0005\bº\u0001\u0010(R\u001d\u0010»\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u00101\"\u0005\b½\u0001\u00103R\u001d\u0010¾\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0001\u00101\"\u0005\bÀ\u0001\u00103R\u001d\u0010Á\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÂ\u0001\u00101\"\u0005\bÃ\u0001\u00103R\u001d\u0010Ä\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÅ\u0001\u00101\"\u0005\bÆ\u0001\u00103R\u001d\u0010Ç\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÈ\u0001\u00101\"\u0005\bÉ\u0001\u00103R\u001d\u0010Ê\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bË\u0001\u00101\"\u0005\bÌ\u0001\u00103R\u001d\u0010Í\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\u0001\u00101\"\u0005\bÏ\u0001\u00103R\u001d\u0010Ð\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u00101\"\u0005\bÒ\u0001\u00103R\u001d\u0010Ó\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÔ\u0001\u00101\"\u0005\bÕ\u0001\u00103R\u001d\u0010Ö\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b×\u0001\u00101\"\u0005\bØ\u0001\u00103R\u001d\u0010Ù\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0001\u00101\"\u0005\bÛ\u0001\u00103R\u001d\u0010Ü\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÝ\u0001\u00101\"\u0005\bÞ\u0001\u00103R\u001d\u0010ß\u0001\u001a\u00020&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bà\u0001\u0010(\"\u0005\bá\u0001\u0010*R\u001d\u0010â\u0001\u001a\u00020&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0001\u0010(\"\u0005\bä\u0001\u0010*R\u001d\u0010å\u0001\u001a\u00020&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bå\u0001\u0010(\"\u0005\bæ\u0001\u0010*R\u0013\u0010ç\u0001\u001a\u00020&8F¢\u0006\u0007\u001a\u0005\bç\u0001\u0010(R\u001d\u0010è\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bé\u0001\u00101\"\u0005\bê\u0001\u00103R\u001d\u0010ë\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bì\u0001\u00101\"\u0005\bí\u0001\u00103R\u001d\u0010î\u0001\u001a\u00020&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bî\u0001\u0010(\"\u0005\bï\u0001\u0010*¨\u0006ò\u0001"}, d2 = {"Lcom/hive/core/Configuration;", "", "<init>", "()V", "HIVE_COUNTRY_DEFAULT", "", "HIVE_LANGUAGE_DEFAULT", "Lcom/hive/core/configuration/HiveLanguage;", "CORE_CONFIG", "COMPANY", "COMPANY_NAME", "COMPANY_INDEX", "APP_INDEX", "GAME_ID", "GAME_INDEX", "IS_OFFLINE_MODE", "IS_CCU_DEACTIVATE", "WHITELIST_DOMAIN", "MIRROR_URL", "HIVE_LANGUAGE", "HIVE_ANALYTICS_ID", "HIVE_AGE_GATE_U13", "zone", "Lcom/hive/core/configuration/HiveZoneType;", "getZone", "()Lcom/hive/core/configuration/HiveZoneType;", "setZone", "(Lcom/hive/core/configuration/HiveZoneType;)V", "readTimeoutSeconds", "", "getReadTimeoutSeconds", "()I", "setReadTimeoutSeconds", "(I)V", "connectTimeoutSeconds", "getConnectTimeoutSeconds", "setConnectTimeoutSeconds", "retryNetwork", "", "getRetryNetwork", "()Z", "setRetryNetwork", "(Z)V", "isRunningInFacebookCloud", "isRunningInFacebookCloud$delegate", "Lkotlin/Lazy;", "value", "company", "getCompany", "()Ljava/lang/String;", "setCompany", "(Ljava/lang/String;)V", "companyName", "getCompanyName", "setCompanyName", "companyIndex", "getCompanyIndex", "setCompanyIndex", "appindex", "getAppindex", "setAppindex", AndroidGetAdPlayerContext.KEY_GAME_ID, "getGameId", "setGameId", "gameIndex", "getGameIndex", "setGameIndex", "isOfflineMode", "setOfflineMode", "isCcuDeactivate", "setCcuDeactivate", "appId", "getAppId", "setAppId", "hiveCertificationKey", "getHiveCertificationKey", "setHiveCertificationKey", "channel", "getChannel", "setChannel", "market", "getMarket", "setMarket", "primaryClientId", "getPrimaryClientId", "setPrimaryClientId", "chatConnectionTimeout", "getChatConnectionTimeout", "setChatConnectionTimeout", "verificationMode", "getVerificationMode", "setVerificationMode", "isUsedAgeRange", "setUsedAgeRange", "effectiveStatusAgeRange", "getEffectiveStatusAgeRange", "setEffectiveStatusAgeRange", "serverId", "getServerId", "setServerId", "sdkVersion", "getSdkVersion", "setSdkVersion", "trackVersion", "getTrackVersion", "setTrackVersion", "interfaceVersion", "getInterfaceVersion", "Lcom/hive/core/configuration/HiveInterfaceType;", "hiveInterfaceType", "getHiveInterfaceType", "()Lcom/hive/core/configuration/HiveInterfaceType;", "setHiveInterfaceType", "(Lcom/hive/core/configuration/HiveInterfaceType;)V", "sdkBuildTime", "getSdkBuildTime", "setSdkBuildTime", "gameLanguage", "getGameLanguage", "setGameLanguage", "hiveTheme", "Lcom/hive/core/configuration/HiveTheme;", "getHiveTheme", "()Lcom/hive/core/configuration/HiveTheme;", "setHiveTheme", "(Lcom/hive/core/configuration/HiveTheme;)V", "hiveOrientation", "Lcom/hive/core/configuration/HiveOrientation;", "getHiveOrientation", "()Lcom/hive/core/configuration/HiveOrientation;", "setHiveOrientation", "(Lcom/hive/core/configuration/HiveOrientation;)V", "hiveCountry", "getHiveCountry", "setHiveCountry", "Lorg/json/JSONObject;", "timezone", "getTimezone", "()Lorg/json/JSONObject;", "setTimezone", "(Lorg/json/JSONObject;)V", "analyticsId", "getAnalyticsId", "analyticsId$delegate", "rawValueAgeGateU13", "getRawValueAgeGateU13", "setRawValueAgeGateU13", "ageGateU13", "getAgeGateU13", "setAgeGateU13", "isUrlEncode", "setUrlEncode", "mirrorUrl", "getMirrorUrl", "setMirrorUrl", "isMirrorUrlDirect", "setMirrorUrlDirect", "metaData", "getMetaData", "setMetaData", "whiteListDomains", "getWhiteListDomains", "setWhiteListDomains", "agreementDetermineBase", "getAgreementDetermineBase", "setAgreementDetermineBase", "unsupportedUAShareType", "", "getUnsupportedUAShareType", "()Ljava/util/List;", "setUnsupportedUAShareType", "(Ljava/util/List;)V", "googleLegacySupport", "getGoogleLegacySupport", "setGoogleLegacySupport", "minGooglePlayServices", "getMinGooglePlayServices", "setMinGooglePlayServices", "facebookPermissionList", "getFacebookPermissionList", "setFacebookPermissionList", JsonStorageKeyNames.SESSION_ID_KEY, "", "getSessionId", "()J", "sessionId$delegate", "isExitEventEnabled", "googleServerClientId", "getGoogleServerClientId", "setGoogleServerClientId", "googlePlayGamesServerClientId", "getGooglePlayGamesServerClientId", "setGooglePlayGamesServerClientId", "wechatSecret", "getWechatSecret", "setWechatSecret", "wechatPaymentKey", "getWechatPaymentKey", "setWechatPaymentKey", "adjustKey", "getAdjustKey", "setAdjustKey", "singularKey", "getSingularKey", "setSingularKey", "appsflyerKey", "getAppsflyerKey", "setAppsflyerKey", "airbridgeKey", "getAirbridgeKey", "setAirbridgeKey", "airbridgeAppName", "getAirbridgeAppName", "setAirbridgeAppName", "airbridgeSecretId", "getAirbridgeSecretId", "setAirbridgeSecretId", "airbridgeSecret", "getAirbridgeSecret", "setAirbridgeSecret", "hiveCommunityUrl", "getHiveCommunityUrl", "setHiveCommunityUrl", "useHercules", "getUseHercules", "setUseHercules", "crossPromotionBannerShowing", "getCrossPromotionBannerShowing", "setCrossPromotionBannerShowing", "isEEACountry", "setEEACountry", "isGDPRCountry", "chinaMarketVivoOpenId", "getChinaMarketVivoOpenId", "setChinaMarketVivoOpenId", "chinaMarketVivoAppId", "getChinaMarketVivoAppId", "setChinaMarketVivoAppId", "isFunTapUnderGovernmentReview", "setFunTapUnderGovernmentReview", "processLanguage", "inputLanguage", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Configuration {
    private static final String APP_INDEX = "coreconfig.app_index";
    private static final String COMPANY = "coreconfig.company";
    private static final String COMPANY_INDEX = "coreconfig.company_index";
    private static final String COMPANY_NAME = "coreconfig.company_name";
    private static final String CORE_CONFIG = "hivecoreconfig.dat";
    private static final String GAME_ID = "coreconfig.game_id";
    private static final String GAME_INDEX = "coreconfig.game_index";
    private static final String HIVE_AGE_GATE_U13 = "coreconfig.hive_age_gate_u13";
    private static final String HIVE_ANALYTICS_ID = "coreconfig.hive_analytics_id";
    public static final String HIVE_COUNTRY_DEFAULT = "UNKNOWN";
    private static final String HIVE_LANGUAGE = "coreconfig.hive_language";
    private static final HiveLanguage HIVE_LANGUAGE_DEFAULT;
    public static final Configuration INSTANCE;
    private static final String IS_CCU_DEACTIVATE = "coreconfig.is_ccu_deactivate";
    private static final String IS_OFFLINE_MODE = "coreconfig.is_offline_mode";
    private static final String MIRROR_URL = "coreconfig.mirror_url";
    private static final String WHITELIST_DOMAIN = "coreconfig.whitelist_domain";
    private static String adjustKey;
    private static boolean ageGateU13;
    private static String agreementDetermineBase;
    private static String airbridgeAppName;
    private static String airbridgeKey;
    private static String airbridgeSecret;
    private static String airbridgeSecretId;

    /* JADX INFO: renamed from: analyticsId$delegate, reason: from kotlin metadata */
    private static final Lazy analyticsId;
    private static String appId;
    private static int appindex;
    private static String appsflyerKey;
    private static String channel;
    private static int chatConnectionTimeout;
    private static String chinaMarketVivoAppId;
    private static String chinaMarketVivoOpenId;
    private static String company;
    private static int companyIndex;
    private static String companyName;
    private static int connectTimeoutSeconds;
    private static boolean crossPromotionBannerShowing;
    private static int effectiveStatusAgeRange;
    private static List<String> facebookPermissionList;
    private static String gameId;
    private static String gameIndex;
    private static String gameLanguage;
    private static boolean googleLegacySupport;
    private static String googlePlayGamesServerClientId;
    private static String googleServerClientId;
    private static String hiveCertificationKey;
    private static String hiveCommunityUrl;
    private static String hiveCountry;
    private static HiveInterfaceType hiveInterfaceType;
    private static HiveOrientation hiveOrientation;
    private static HiveTheme hiveTheme;
    private static boolean isCcuDeactivate;
    private static boolean isEEACountry;
    private static boolean isFunTapUnderGovernmentReview;
    private static boolean isMirrorUrlDirect;
    private static boolean isOfflineMode;

    /* JADX INFO: renamed from: isRunningInFacebookCloud$delegate, reason: from kotlin metadata */
    private static final Lazy isRunningInFacebookCloud;
    private static String isUrlEncode;
    private static boolean isUsedAgeRange;
    private static String market;
    private static JSONObject metaData;
    private static int minGooglePlayServices;
    private static String mirrorUrl;
    private static String primaryClientId;
    private static String rawValueAgeGateU13;
    private static int readTimeoutSeconds;
    private static boolean retryNetwork;
    private static String sdkBuildTime;
    private static String sdkVersion;
    private static String serverId;

    /* JADX INFO: renamed from: sessionId$delegate, reason: from kotlin metadata */
    private static final Lazy sessionId;
    private static String singularKey;
    private static JSONObject timezone;
    private static String trackVersion;
    private static List<String> unsupportedUAShareType;
    private static boolean useHercules;
    private static String verificationMode;
    private static String wechatPaymentKey;
    private static String wechatSecret;
    private static String whiteListDomains;
    private static HiveZoneType zone;

    /* JADX INFO: compiled from: Configuration.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HiveInterfaceType.values().length];
            try {
                iArr[HiveInterfaceType.C2S.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HiveInterfaceType.V1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HiveInterfaceType.V4.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Configuration() {
    }

    static {
        Configuration configuration = new Configuration();
        INSTANCE = configuration;
        HIVE_LANGUAGE_DEFAULT = HiveLanguage.LanguageEN;
        zone = HiveZoneType.REAL;
        readTimeoutSeconds = 8;
        connectTimeoutSeconds = 8;
        retryNetwork = true;
        isRunningInFacebookCloud = LazyKt.lazy(new Function0() { // from class: com.hive.core.Configuration$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(Configuration.isRunningInFacebookCloud_delegate$lambda$1());
            }
        });
        company = "";
        companyName = "";
        companyIndex = -1;
        appindex = -1;
        gameId = "";
        gameIndex = "";
        String appIdentifier = Product.INSTANCE.getAppIdentifier();
        if (appIdentifier == null) {
            appIdentifier = "";
        }
        appId = appIdentifier;
        hiveCertificationKey = "";
        channel = "C2S";
        market = "";
        primaryClientId = "";
        chatConnectionTimeout = 60;
        verificationMode = "";
        effectiveStatusAgeRange = -1000;
        serverId = "";
        sdkVersion = "4.26.2.0";
        trackVersion = BuildConfig.SDK_VERSION_TRACK;
        sdkBuildTime = BuildConfig.SDK_BUILD_TIME;
        String strProcessLanguage = PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(HIVE_LANGUAGE);
        String str = strProcessLanguage;
        if (str == null || StringsKt.isBlank(str)) {
            strProcessLanguage = configuration.processLanguage(null);
        }
        gameLanguage = strProcessLanguage;
        hiveTheme = HiveTheme.HiveLight;
        hiveOrientation = HiveOrientation.UNDEFINED;
        hiveCountry = HIVE_COUNTRY_DEFAULT;
        timezone = new JSONObject();
        analyticsId = LazyKt.lazy(new Function0() { // from class: com.hive.core.Configuration$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Configuration.analyticsId_delegate$lambda$20();
            }
        });
        rawValueAgeGateU13 = PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(HIVE_AGE_GATE_U13);
        ageGateU13 = Boolean.parseBoolean(PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(HIVE_AGE_GATE_U13, "false"));
        isUrlEncode = "Y";
        mirrorUrl = PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(MIRROR_URL);
        whiteListDomains = PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(WHITELIST_DOMAIN);
        agreementDetermineBase = DeviceRequestsHelper.DEVICE_INFO_DEVICE;
        sessionId = LazyKt.lazy(new Function0() { // from class: com.hive.core.Configuration$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(Configuration.sessionId_delegate$lambda$24());
            }
        });
        googleServerClientId = "";
        googlePlayGamesServerClientId = "";
        wechatSecret = "";
        wechatPaymentKey = "";
        adjustKey = "";
        singularKey = "";
        appsflyerKey = "";
        airbridgeKey = "";
        airbridgeAppName = "";
        airbridgeSecretId = "";
        airbridgeSecret = "";
        hiveCommunityUrl = "";
        useHercules = true;
        crossPromotionBannerShowing = true;
        chinaMarketVivoOpenId = "";
        chinaMarketVivoAppId = "";
    }

    public final HiveZoneType getZone() {
        return zone;
    }

    public final void setZone(HiveZoneType hiveZoneType) {
        Intrinsics.checkNotNullParameter(hiveZoneType, "<set-?>");
        zone = hiveZoneType;
    }

    public final int getReadTimeoutSeconds() {
        return readTimeoutSeconds;
    }

    public final void setReadTimeoutSeconds(int i) {
        readTimeoutSeconds = i;
    }

    public final int getConnectTimeoutSeconds() {
        return connectTimeoutSeconds;
    }

    public final void setConnectTimeoutSeconds(int i) {
        connectTimeoutSeconds = i;
    }

    public final boolean getRetryNetwork() {
        return retryNetwork;
    }

    public final void setRetryNetwork(boolean z) {
        retryNetwork = z;
    }

    public final boolean isRunningInFacebookCloud() {
        return ((Boolean) isRunningInFacebookCloud.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRunningInFacebookCloud_delegate$lambda$1() {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(Class.forName("com.hive.FacebookCloud"));
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return kotlin.Result.m7422isSuccessimpl(objM7415constructorimpl);
    }

    public final String getCompany() {
        String str = company;
        if (StringsKt.isBlank(str) && (str = PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(COMPANY)) == null) {
            str = "";
        }
        return str;
    }

    public final void setCompany(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        company = value;
        Property propertyManager = PropertyManager.INSTANCE.getInstance(CORE_CONFIG);
        if (StringsKt.isBlank(value)) {
            propertyManager.remove(COMPANY);
        } else {
            propertyManager.set(COMPANY, value);
        }
        propertyManager.write();
    }

    public final String getCompanyName() {
        String str = companyName;
        if (StringsKt.isBlank(str) && (str = PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(COMPANY_NAME)) == null) {
            str = "";
        }
        return str;
    }

    public final void setCompanyName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        companyName = value;
        Property propertyManager = PropertyManager.INSTANCE.getInstance(CORE_CONFIG);
        if (StringsKt.isBlank(value)) {
            propertyManager.remove(COMPANY_NAME);
        } else {
            propertyManager.set(COMPANY_NAME, value);
        }
        propertyManager.write();
    }

    public final int getCompanyIndex() {
        Integer numValueOf = Integer.valueOf(companyIndex);
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        String str = PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(COMPANY_INDEX);
        Integer numValueOf2 = str != null ? Integer.valueOf(Integer.parseInt(str)) : null;
        if (numValueOf2 != null) {
            return numValueOf2.intValue();
        }
        return -1;
    }

    public final void setCompanyIndex(int i) {
        companyIndex = i;
        Property propertyManager = PropertyManager.INSTANCE.getInstance(CORE_CONFIG);
        if (i <= 0) {
            propertyManager.remove(COMPANY_INDEX);
        } else {
            propertyManager.set(COMPANY_INDEX, String.valueOf(i));
        }
        propertyManager.write();
    }

    public final int getAppindex() {
        Integer numValueOf = Integer.valueOf(appindex);
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        String str = PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(COMPANY_INDEX);
        Integer numValueOf2 = str != null ? Integer.valueOf(Integer.parseInt(str)) : null;
        if (numValueOf2 != null) {
            return numValueOf2.intValue();
        }
        return -1;
    }

    public final void setAppindex(int i) {
        appindex = i;
        Property propertyManager = PropertyManager.INSTANCE.getInstance(CORE_CONFIG);
        if (i <= 0) {
            propertyManager.remove(APP_INDEX);
        } else {
            propertyManager.set(APP_INDEX, String.valueOf(i));
        }
        propertyManager.write();
    }

    public final String getGameId() {
        String str = gameId;
        if (StringsKt.isBlank(str) && (str = PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(GAME_ID)) == null) {
            str = "";
        }
        return str;
    }

    public final void setGameId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        gameId = value;
        Property propertyManager = PropertyManager.INSTANCE.getInstance(CORE_CONFIG);
        if (StringsKt.isBlank(value)) {
            propertyManager.remove(GAME_ID);
        } else {
            propertyManager.set(GAME_ID, value);
        }
        propertyManager.write();
    }

    public final String getGameIndex() {
        String str = gameIndex;
        if (StringsKt.isBlank(str) && (str = PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(GAME_INDEX)) == null) {
            str = "";
        }
        return str;
    }

    public final void setGameIndex(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        gameIndex = value;
        Property propertyManager = PropertyManager.INSTANCE.getInstance(CORE_CONFIG);
        if (StringsKt.isBlank(value)) {
            propertyManager.remove(GAME_INDEX);
        } else {
            propertyManager.set(GAME_INDEX, value);
        }
        propertyManager.write();
    }

    public final boolean isOfflineMode() {
        return Boolean.parseBoolean(PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(IS_OFFLINE_MODE, "false"));
    }

    public final void setOfflineMode(boolean z) {
        isOfflineMode = z;
        Property propertyManager = PropertyManager.INSTANCE.getInstance(CORE_CONFIG);
        propertyManager.set(IS_OFFLINE_MODE, String.valueOf(z));
        propertyManager.write();
    }

    public final boolean isCcuDeactivate() {
        return Boolean.parseBoolean(PropertyManager.INSTANCE.getInstance(CORE_CONFIG).get(IS_CCU_DEACTIVATE, "false"));
    }

    public final void setCcuDeactivate(boolean z) {
        isCcuDeactivate = z;
        Property propertyManager = PropertyManager.INSTANCE.getInstance(CORE_CONFIG);
        propertyManager.set(IS_CCU_DEACTIVATE, String.valueOf(z));
        propertyManager.write();
    }

    public final String getAppId() {
        return appId;
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        appId = str;
    }

    public final String getHiveCertificationKey() {
        return hiveCertificationKey;
    }

    public final void setHiveCertificationKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        hiveCertificationKey = str;
    }

    public final String getChannel() {
        return channel;
    }

    public final void setChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        channel = str;
    }

    public final String getMarket() {
        return market;
    }

    public final void setMarket(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        market = str;
    }

    public final String getPrimaryClientId() {
        return primaryClientId;
    }

    public final void setPrimaryClientId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        primaryClientId = str;
    }

    public final int getChatConnectionTimeout() {
        return chatConnectionTimeout;
    }

    public final void setChatConnectionTimeout(int i) {
        chatConnectionTimeout = i;
    }

    public final String getVerificationMode() {
        return verificationMode;
    }

    public final void setVerificationMode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        verificationMode = str;
    }

    public final boolean isUsedAgeRange() {
        return isUsedAgeRange;
    }

    public final void setUsedAgeRange(boolean z) {
        isUsedAgeRange = z;
    }

    public final int getEffectiveStatusAgeRange() {
        return effectiveStatusAgeRange;
    }

    public final void setEffectiveStatusAgeRange(int i) {
        effectiveStatusAgeRange = i;
    }

    public final String getServerId() {
        return serverId;
    }

    public final void setServerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        serverId = str;
    }

    public final String getSdkVersion() {
        return sdkVersion;
    }

    public final void setSdkVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        sdkVersion = str;
    }

    public final String getTrackVersion() {
        return trackVersion;
    }

    public final void setTrackVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        trackVersion = str;
    }

    public final String getInterfaceVersion() {
        HiveInterfaceType hiveInterfaceType2 = getHiveInterfaceType();
        int i = hiveInterfaceType2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[hiveInterfaceType2.ordinal()];
        if (i != -1) {
            if (i == 1) {
                return BuildConfig.SDK_C2S_VERSION_NAME;
            }
            if (i == 2) {
                return BuildConfig.SDK_V1_VERSION_NAME;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return "4.26.2.0";
    }

    public final void setHiveInterfaceType(HiveInterfaceType hiveInterfaceType2) {
        if (hiveInterfaceType == null) {
            hiveInterfaceType = hiveInterfaceType2;
        }
    }

    public final HiveInterfaceType getHiveInterfaceType() {
        HiveInterfaceType hiveInterfaceType2 = hiveInterfaceType;
        return hiveInterfaceType2 == null ? HiveInterfaceType.V4 : hiveInterfaceType2;
    }

    public final String getSdkBuildTime() {
        return sdkBuildTime;
    }

    public final void setSdkBuildTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        sdkBuildTime = str;
    }

    public final String getGameLanguage() {
        return gameLanguage;
    }

    public final void setGameLanguage(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        gameLanguage = processLanguage(value);
    }

    public final HiveTheme getHiveTheme() {
        return hiveTheme;
    }

    public final void setHiveTheme(HiveTheme hiveTheme2) {
        Intrinsics.checkNotNullParameter(hiveTheme2, "<set-?>");
        hiveTheme = hiveTheme2;
    }

    public final HiveOrientation getHiveOrientation() {
        return hiveOrientation;
    }

    public final void setHiveOrientation(HiveOrientation hiveOrientation2) {
        Intrinsics.checkNotNullParameter(hiveOrientation2, "<set-?>");
        hiveOrientation = hiveOrientation2;
    }

    public final String getHiveCountry() {
        return hiveCountry;
    }

    public final void setHiveCountry(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(hiveCountry, HIVE_COUNTRY_DEFAULT)) {
            hiveCountry = value;
        }
    }

    public final JSONObject getTimezone() {
        return timezone;
    }

    public final void setTimezone(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (timezone.length() <= 0) {
            timezone = value;
        }
    }

    public final String getAnalyticsId() {
        Object value = analyticsId.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (String) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String analyticsId_delegate$lambda$20() {
        /*
            com.hive.core.PropertyManager r0 = com.hive.core.PropertyManager.INSTANCE
            java.lang.String r1 = "hivecoreconfig.dat"
            com.hive.core.Property r0 = r0.getInstance(r1)
            java.lang.String r2 = "coreconfig.hive_analytics_id"
            java.lang.String r0 = r0.get(r2)
            if (r0 == 0) goto L2e
            java.util.UUID r0 = java.util.UUID.fromString(r0)     // Catch: java.lang.Exception -> L15
            goto L2c
        L15:
            r0 = move-exception
            com.hive.core.Logger r3 = com.hive.core.Logger.INSTANCE
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "load AnalyticsId exception : "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.hive.core.Logger$LogType r4 = com.hive.core.Logger.LogType.Warning
            r3.coreLog$hive_core_release(r0, r4)
            r0 = 0
        L2c:
            if (r0 != 0) goto L52
        L2e:
            java.util.UUID r0 = java.util.UUID.randomUUID()
            com.hive.core.PropertyManager r3 = com.hive.core.PropertyManager.INSTANCE
            com.hive.core.Property r3 = r3.getInstance(r1)
            java.lang.String r4 = r0.toString()
            java.lang.String r5 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r3.set(r2, r4)
            com.hive.core.PropertyManager r2 = com.hive.core.PropertyManager.INSTANCE
            com.hive.core.Property r1 = r2.getInstance(r1)
            r1.write()
            java.lang.String r1 = "also(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L52:
            r1 = 16
            byte[] r1 = new byte[r1]
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r1)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            r1.order(r2)
            long r2 = r0.getLeastSignificantBits()
            r1.putLong(r2)
            long r2 = r0.getMostSignificantBits()
            r1.putLong(r2)
            byte[] r0 = r1.array()
            r1 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.core.Configuration.analyticsId_delegate$lambda$20():java.lang.String");
    }

    public final String getRawValueAgeGateU13() {
        return rawValueAgeGateU13;
    }

    public final void setRawValueAgeGateU13(String str) {
        rawValueAgeGateU13 = str;
    }

    public final boolean getAgeGateU13() {
        return ageGateU13;
    }

    public final void setAgeGateU13(boolean z) {
        if (ageGateU13 != z) {
            ageGateU13 = z;
            Property propertyManager = PropertyManager.INSTANCE.getInstance(CORE_CONFIG);
            propertyManager.set(HIVE_AGE_GATE_U13, String.valueOf(z));
            propertyManager.write();
        }
    }

    public final String isUrlEncode() {
        return isUrlEncode;
    }

    public final void setUrlEncode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        isUrlEncode = str;
    }

    public final String getMirrorUrl() {
        return mirrorUrl;
    }

    public final void setMirrorUrl(String str) {
        if (Intrinsics.areEqual(mirrorUrl, str)) {
            return;
        }
        mirrorUrl = str;
        Property propertyManager = PropertyManager.INSTANCE.getInstance(CORE_CONFIG);
        if (str == null) {
            propertyManager.remove(MIRROR_URL);
        } else {
            propertyManager.set(MIRROR_URL, str);
        }
        propertyManager.write();
    }

    public final boolean isMirrorUrlDirect() {
        return isMirrorUrlDirect;
    }

    public final void setMirrorUrlDirect(boolean z) {
        isMirrorUrlDirect = z;
    }

    public final JSONObject getMetaData() {
        return metaData;
    }

    public final void setMetaData(JSONObject jSONObject) {
        metaData = jSONObject;
    }

    public final String getWhiteListDomains() {
        return whiteListDomains;
    }

    public final void setWhiteListDomains(String str) {
        whiteListDomains = str;
        Property propertyManager = PropertyManager.INSTANCE.getInstance(CORE_CONFIG);
        if (str == null) {
            propertyManager.remove(WHITELIST_DOMAIN);
        } else {
            propertyManager.set(WHITELIST_DOMAIN, str);
        }
        propertyManager.write();
    }

    public final String getAgreementDetermineBase() {
        return agreementDetermineBase;
    }

    public final void setAgreementDetermineBase(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        agreementDetermineBase = str;
    }

    public final List<String> getUnsupportedUAShareType() {
        return unsupportedUAShareType;
    }

    public final void setUnsupportedUAShareType(List<String> list) {
        unsupportedUAShareType = list;
    }

    public final boolean getGoogleLegacySupport() {
        return googleLegacySupport;
    }

    public final void setGoogleLegacySupport(boolean z) {
        googleLegacySupport = z;
    }

    public final int getMinGooglePlayServices() {
        return minGooglePlayServices;
    }

    public final void setMinGooglePlayServices(int i) {
        minGooglePlayServices = i;
    }

    public final List<String> getFacebookPermissionList() {
        return facebookPermissionList;
    }

    public final void setFacebookPermissionList(List<String> list) {
        facebookPermissionList = list;
    }

    public final long getSessionId() {
        return ((Number) sessionId.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long sessionId_delegate$lambda$24() {
        return HiveTime.INSTANCE.getHiveTime().getTime() / 1000;
    }

    public final boolean isExitEventEnabled() {
        return getHiveInterfaceType() == HiveInterfaceType.V4;
    }

    public final String getGoogleServerClientId() {
        return googleServerClientId;
    }

    public final void setGoogleServerClientId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        googleServerClientId = str;
    }

    public final String getGooglePlayGamesServerClientId() {
        return googlePlayGamesServerClientId;
    }

    public final void setGooglePlayGamesServerClientId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        googlePlayGamesServerClientId = str;
    }

    public final String getWechatSecret() {
        return wechatSecret;
    }

    public final void setWechatSecret(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        wechatSecret = str;
    }

    public final String getWechatPaymentKey() {
        return wechatPaymentKey;
    }

    public final void setWechatPaymentKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        wechatPaymentKey = str;
    }

    public final String getAdjustKey() {
        return adjustKey;
    }

    public final void setAdjustKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        adjustKey = str;
    }

    public final String getSingularKey() {
        return singularKey;
    }

    public final void setSingularKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        singularKey = str;
    }

    public final String getAppsflyerKey() {
        return appsflyerKey;
    }

    public final void setAppsflyerKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        appsflyerKey = str;
    }

    public final String getAirbridgeKey() {
        return airbridgeKey;
    }

    public final void setAirbridgeKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        airbridgeKey = str;
    }

    public final String getAirbridgeAppName() {
        return airbridgeAppName;
    }

    public final void setAirbridgeAppName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        airbridgeAppName = str;
    }

    public final String getAirbridgeSecretId() {
        return airbridgeSecretId;
    }

    public final void setAirbridgeSecretId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        airbridgeSecretId = str;
    }

    public final String getAirbridgeSecret() {
        return airbridgeSecret;
    }

    public final void setAirbridgeSecret(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        airbridgeSecret = str;
    }

    public final String getHiveCommunityUrl() {
        return hiveCommunityUrl;
    }

    public final void setHiveCommunityUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        hiveCommunityUrl = str;
    }

    public final boolean getUseHercules() {
        return useHercules;
    }

    public final void setUseHercules(boolean z) {
        useHercules = z;
    }

    public final boolean getCrossPromotionBannerShowing() {
        return crossPromotionBannerShowing;
    }

    public final void setCrossPromotionBannerShowing(boolean z) {
        crossPromotionBannerShowing = z;
    }

    public final boolean isEEACountry() {
        return isEEACountry;
    }

    public final void setEEACountry(boolean z) {
        isEEACountry = z;
    }

    public final boolean isGDPRCountry() {
        return isEEACountry || Intrinsics.areEqual(hiveCountry, "GB");
    }

    public final String getChinaMarketVivoOpenId() {
        return chinaMarketVivoOpenId;
    }

    public final void setChinaMarketVivoOpenId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        chinaMarketVivoOpenId = str;
    }

    public final String getChinaMarketVivoAppId() {
        return chinaMarketVivoAppId;
    }

    public final void setChinaMarketVivoAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        chinaMarketVivoAppId = str;
    }

    public final boolean isFunTapUnderGovernmentReview() {
        return isFunTapUnderGovernmentReview;
    }

    public final void setFunTapUnderGovernmentReview(boolean z) {
        isFunTapUnderGovernmentReview = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String processLanguage(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.core.Configuration.processLanguage(java.lang.String):java.lang.String");
    }
}
