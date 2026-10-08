package com.hive.protocol;

import androidx.core.app.NotificationCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.adjust.sdk.Constants;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.common.net.HttpHeaders;
import com.hive.core.Configuration;
import com.hive.core.Logger;
import com.hive.core.configuration.HiveZoneType;
import com.hive.social.SocialKeys;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.net.URL;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.text.StringsKt;
import kotlinx.io.files.FileSystemKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: UrlManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b3\bÆ\u0002\u0018\u00002\u00020\u0001:/\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007¨\u0006<"}, d2 = {"Lcom/hive/protocol/UrlManager;", "", "<init>", "()V", "setMirrorUrl", "", "mirrorServerDomains", "Lorg/json/JSONObject;", "getMirrorUrl", "", "inputUrl", "setAnalyticsUrl", "analyticsDomainJSONObject", HttpHeaders.SERVER, "ActiveUser", "AdultConfirm", "Analytics", "AuthV4", "AuthCP", "ActiveCcu", "StandByCcu", "HiveChat", "HiveChatPlugin", "CommunityWeb", "CustomerCenter", "DataStore", "Funtap", "IapV1", "IapV2", "IapV4", "IapV4Verify", "HiveStore", "LebiApiV1", "LebiApiV2", "LebiWeb", "ChinaMarketCallbackUrl", "LoginCenter", "MatchMaking", "Membership", "Mercury", "Offerwall", "ProfileApi", "ProfileWeb", "PromotionV2", "Provision", "Push", "PushV4", "SocialApi", "SocialOtherApi", "SocialWeb", "SocialFriendApi", "SocialFriendWeb", "ChinaApi", "Chatbot", "UserEngagement", "TimeZone", "Terms", "WithHive", "Fcm", "MirrorDomain", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlManager {
    public static final UrlManager INSTANCE = new UrlManager();

    private UrlManager() {
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J#\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/hive/protocol/UrlManager$Server;", "", "getServer", "", "hexToStr", "hex", "getProperty", "R", "instance", "propertyName", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Server {

        /* JADX INFO: compiled from: UrlManager.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[HiveZoneType.values().length];
                try {
                    iArr[HiveZoneType.REAL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[HiveZoneType.SANDBOX.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[HiveZoneType.TEST.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[HiveZoneType.DEV.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        <R> R getProperty(Object instance, String propertyName);

        String getServer();

        String hexToStr(String hex);

        /* JADX INFO: compiled from: UrlManager.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public static java.lang.String getServer(com.hive.protocol.UrlManager.Server r5) {
                /*
                    java.lang.String r0 = ""
                    java.lang.String r1 = "com.hive.protocol."
                    kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L85
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
                    r2.<init>(r1)     // Catch: java.lang.Throwable -> L85
                    java.lang.Class r1 = r5.getClass()     // Catch: java.lang.Throwable -> L85
                    kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)     // Catch: java.lang.Throwable -> L85
                    java.lang.String r1 = r1.getSimpleName()     // Catch: java.lang.Throwable -> L85
                    r2.append(r1)     // Catch: java.lang.Throwable -> L85
                    java.lang.String r1 = "HexUrl"
                    r2.append(r1)     // Catch: java.lang.Throwable -> L85
                    java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L85
                    java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L85
                    java.lang.String r2 = "forName(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Throwable -> L85
                    kotlin.reflect.KClass r1 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r1)     // Catch: java.lang.Throwable -> L85
                    java.lang.Object r1 = r1.getObjectInstance()     // Catch: java.lang.Throwable -> L85
                    if (r1 == 0) goto L7b
                    com.hive.core.Configuration r2 = com.hive.core.Configuration.INSTANCE     // Catch: java.lang.Throwable -> L85
                    com.hive.core.configuration.HiveZoneType r2 = r2.getZone()     // Catch: java.lang.Throwable -> L85
                    int[] r3 = com.hive.protocol.UrlManager.Server.WhenMappings.$EnumSwitchMapping$0     // Catch: java.lang.Throwable -> L85
                    int r2 = r2.ordinal()     // Catch: java.lang.Throwable -> L85
                    r2 = r3[r2]     // Catch: java.lang.Throwable -> L85
                    r3 = 1
                    if (r2 == r3) goto L71
                    r3 = 2
                    if (r2 == r3) goto L68
                    r3 = 3
                    if (r2 == r3) goto L5f
                    r3 = 4
                    if (r2 != r3) goto L59
                    java.lang.String r2 = "dev"
                    java.lang.Object r1 = r5.getProperty(r1, r2)     // Catch: java.lang.Throwable -> L85
                    java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L85
                    goto L79
                L59:
                    kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L85
                    r5.<init>()     // Catch: java.lang.Throwable -> L85
                    throw r5     // Catch: java.lang.Throwable -> L85
                L5f:
                    java.lang.String r2 = "test"
                    java.lang.Object r1 = r5.getProperty(r1, r2)     // Catch: java.lang.Throwable -> L85
                    java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L85
                    goto L79
                L68:
                    java.lang.String r2 = "sandbox"
                    java.lang.Object r1 = r5.getProperty(r1, r2)     // Catch: java.lang.Throwable -> L85
                    java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L85
                    goto L79
                L71:
                    java.lang.String r2 = "real"
                    java.lang.Object r1 = r5.getProperty(r1, r2)     // Catch: java.lang.Throwable -> L85
                    java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L85
                L79:
                    if (r1 != 0) goto L7c
                L7b:
                    r1 = r0
                L7c:
                    java.lang.String r5 = r5.hexToStr(r1)     // Catch: java.lang.Throwable -> L85
                    java.lang.Object r5 = kotlin.Result.m7415constructorimpl(r5)     // Catch: java.lang.Throwable -> L85
                    goto L90
                L85:
                    r5 = move-exception
                    kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
                    java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
                    java.lang.Object r5 = kotlin.Result.m7415constructorimpl(r5)
                L90:
                    java.lang.Throwable r1 = kotlin.Result.m7418exceptionOrNullimpl(r5)
                    if (r1 == 0) goto Lad
                    com.hive.core.Logger r2 = com.hive.core.Logger.INSTANCE
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    java.lang.String r4 = "Failed UrlManager.Server.getServer()\nThrowable: "
                    r3.<init>(r4)
                    java.lang.String r1 = r1.getMessage()
                    r3.append(r1)
                    java.lang.String r1 = r3.toString()
                    r2.d(r1)
                Lad:
                    boolean r1 = kotlin.Result.m7421isFailureimpl(r5)
                    if (r1 == 0) goto Lb4
                    goto Lb5
                Lb4:
                    r0 = r5
                Lb5:
                    java.lang.String r0 = (java.lang.String) r0
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.UrlManager.Server.DefaultImpls.getServer(com.hive.protocol.UrlManager$Server):java.lang.String");
            }

            public static String hexToStr(Server server, String hex) {
                Intrinsics.checkNotNullParameter(hex, "hex");
                StringBuilder sb = new StringBuilder("");
                int i = 0;
                while (i < hex.length()) {
                    int i2 = i + 2;
                    String strSubstring = hex.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    sb.append((char) Integer.parseInt(strSubstring, 16));
                    i = i2;
                }
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }

            public static <R> R getProperty(Server server, Object instance, String propertyName) {
                Intrinsics.checkNotNullParameter(instance, "instance");
                Intrinsics.checkNotNullParameter(propertyName, "propertyName");
                for (Object obj : KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(instance.getClass()))) {
                    KProperty1 kProperty1 = (KProperty1) obj;
                    if (Intrinsics.areEqual(kProperty1.getName(), propertyName)) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Any, *>");
                        return (R) kProperty1.get(instance);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
    }

    public final void setMirrorUrl(JSONObject mirrorServerDomains) {
        Intrinsics.checkNotNullParameter(mirrorServerDomains, "mirrorServerDomains");
        Configuration.INSTANCE.setMirrorUrl(mirrorServerDomains.toString());
    }

    public final String getMirrorUrl(String inputUrl) {
        Intrinsics.checkNotNullParameter(inputUrl, "inputUrl");
        String mirrorUrl = Configuration.INSTANCE.getMirrorUrl();
        if (mirrorUrl == null) {
            mirrorUrl = MirrorDomain.INSTANCE.getDefaultMirrorDomain();
        }
        if (StringsKt.isBlank(mirrorUrl)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(mirrorUrl);
            URL url = new URL(inputUrl);
            String str = url.getHost() + url.getPath();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (Intrinsics.areEqual(next, str)) {
                    String str2 = url.getProtocol() + "://" + jSONObject.getString(next);
                    Configuration.INSTANCE.setMirrorUrlDirect(true);
                    return str2;
                }
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.protocolLog("[UrlManager] getMirrorUrl(inputUrl: " + inputUrl + ") \ne: " + e.getMessage(), Logger.LogType.Warning);
            return null;
        }
    }

    public final void setAnalyticsUrl(JSONObject analyticsDomainJSONObject) {
        Intrinsics.checkNotNullParameter(analyticsDomainJSONObject, "analyticsDomainJSONObject");
        String strOptString = analyticsDomainJSONObject.optString("log_url");
        Intrinsics.checkNotNull(strOptString);
        if (!(!StringsKt.isBlank(strOptString))) {
            strOptString = null;
        }
        if (strOptString != null) {
            Analytics.INSTANCE.setAnalyticsLog(strOptString);
        }
        String strOptString2 = analyticsDomainJSONObject.optString("ccu_url_active");
        Intrinsics.checkNotNull(strOptString2);
        if (!(!StringsKt.isBlank(strOptString2))) {
            strOptString2 = null;
        }
        if (strOptString2 != null) {
            ActiveCcu.INSTANCE.setCcu(strOptString2);
        }
        String strOptString3 = analyticsDomainJSONObject.optString("ccu_url_standby");
        Intrinsics.checkNotNull(strOptString3);
        String str = StringsKt.isBlank(strOptString3) ^ true ? strOptString3 : null;
        if (str != null) {
            StandByCcu.INSTANCE.setCcu(str);
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u0011\u0010\u0017\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/hive/protocol/UrlManager$ActiveUser;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "agreement", "", "getAgreement", "()Ljava/lang/String;", "download", "getDownload", "getGetAgreement", "getConfig", "getGetConfig", "getDid", "getGetDid", "getNotice", "getGetNotice", Constants.REFERRER, "getReferrer", "sessionLog", "getSessionLog", "updateDid", "getUpdateDid", "getWhiteListDomainByActiveUser", "getGetWhiteListDomainByActiveUser", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ActiveUser implements Server {
        public static final ActiveUser INSTANCE = new ActiveUser();

        private ActiveUser() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getAgreement() {
            return getServer() + "/gateway.php";
        }

        public final String getDownload() {
            return getServer() + "/gateway.php";
        }

        public final String getGetAgreement() {
            return getServer() + "/gateway.php";
        }

        public final String getGetConfig() {
            return getServer() + "/gateway.php";
        }

        public final String getGetDid() {
            return getServer() + "/gateway.php";
        }

        public final String getGetNotice() {
            return getServer() + "/gateway.php";
        }

        public final String getReferrer() {
            return getServer() + "/gateway.php";
        }

        public final String getSessionLog() {
            return getServer() + "/gateway.php";
        }

        public final String getUpdateDid() {
            return getServer() + "/gateway.php";
        }

        public final String getGetWhiteListDomainByActiveUser() {
            return getServer() + "/gateway.php";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/hive/protocol/UrlManager$AdultConfirm;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "adultCheck", "", "getAdultCheck", "()Ljava/lang/String;", "adultConfirm", "getAdultConfirm", "diHash", "getDiHash", "identityMobileRequest", "getIdentityMobileRequest", "devicesActions", "getDevicesActions", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AdultConfirm implements Server {
        public static final AdultConfirm INSTANCE = new AdultConfirm();

        private AdultConfirm() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getAdultCheck() {
            return getServer() + "/api/call";
        }

        public final String getAdultConfirm() {
            return getServer() + "/web/infoAuth";
        }

        public final String getDiHash() {
            return getServer() + "/api/auth/di_hash";
        }

        public final String getIdentityMobileRequest() {
            return getServer() + "/auth/identity/mobile_request";
        }

        public final String getDevicesActions() {
            return getServer() + "/devices/actions";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/hive/protocol/UrlManager$Analytics;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "responseUrl", "", "value", "analyticsLog", "getAnalyticsLog", "()Ljava/lang/String;", "setAnalyticsLog", "(Ljava/lang/String;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Analytics implements Server {
        public static final Analytics INSTANCE = new Analytics();
        private static String responseUrl;

        private Analytics() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getAnalyticsLog() {
            String str = responseUrl;
            if (str != null) {
                return str;
            }
            return getServer() + "/v1/recv";
        }

        public final void setAnalyticsLog(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            responseUrl = value;
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b@\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0007R\u0011\u0010\u001b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0007R\u0011\u0010\u001d\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0007R\u0011\u0010\u001f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b \u0010\u0007R\u0011\u0010!\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0007R\u0011\u0010#\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b$\u0010\u0007R\u0011\u0010%\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b&\u0010\u0007R\u0011\u0010'\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b(\u0010\u0007R\u0011\u0010)\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b*\u0010\u0007R\u0011\u0010+\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b,\u0010\u0007R\u0011\u0010-\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b.\u0010\u0007R\u0011\u0010/\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b0\u0010\u0007R\u0011\u00101\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b2\u0010\u0007R\u0011\u00103\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b4\u0010\u0007R\u0011\u00105\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b6\u0010\u0007R\u0011\u00107\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b8\u0010\u0007R\u0011\u00109\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b:\u0010\u0007R\u0011\u0010;\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b<\u0010\u0007R\u0011\u0010=\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b>\u0010\u0007R\u0011\u0010?\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b@\u0010\u0007R\u0011\u0010A\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bB\u0010\u0007R\u0011\u0010C\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bD\u0010\u0007¨\u0006E"}, d2 = {"Lcom/hive/protocol/UrlManager$AuthV4;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "blacklist", "", "getBlacklist", "()Ljava/lang/String;", "connect", "getConnect", "disconnect", "getDisconnect", "getIdpUid", "getGetIdpUid", "getPolicy", "getGetPolicy", "getToken", "getGetToken", "authIdpToken", "getAuthIdpToken", "getUid", "getGetUid", "idp", "getIdp", "authIdp", "getAuthIdp", "isGamerId", "selectIdp", "getSelectIdp", "signIn", "getSignIn", "signInIdp", "getSignInIdp", "signInPlayer", "getSignInPlayer", "signOut", "getSignOut", "customAuthSignInIdp", "getCustomAuthSignInIdp", "customAuthConnect", "getCustomAuthConnect", "viewIdp", "getViewIdp", "viewSelectIdp", "getViewSelectIdp", "playerDelete", "getPlayerDelete", "oauthToken", "getOauthToken", "deviceSetUser", "getDeviceSetUser", "deviceModifyUser", "getDeviceModifyUser", "deviceDeleteUser", "getDeviceDeleteUser", "deviceAdd", "getDeviceAdd", "deviceDelete", "getDeviceDelete", "deviceGet", "getDeviceGet", "deviceGetSeq", "getDeviceGetSeq", "deviceModify", "getDeviceModify", "smsSend", "getSmsSend", "smsVerify", "getSmsVerify", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthV4 implements Server {
        public static final AuthV4 INSTANCE = new AuthV4();

        private AuthV4() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getBlacklist() {
            return getServer() + "/blacklist";
        }

        public final String getConnect() {
            return getServer() + "/auth/connect";
        }

        public final String getDisconnect() {
            return getServer() + "/auth/disconnect";
        }

        public final String getGetIdpUid() {
            return getServer() + "/player/get-idpuid";
        }

        public final String getGetPolicy() {
            return getServer() + "/player/get-policy";
        }

        public final String getGetToken() {
            return getServer() + "/token/get-token";
        }

        public final String getAuthIdpToken() {
            return getServer() + "/auth/idp-token";
        }

        public final String getGetUid() {
            return getServer() + "/token/get-uid";
        }

        public final String getIdp() {
            return getServer() + "/idp";
        }

        public final String getAuthIdp() {
            return getServer() + "/auth/idp";
        }

        public final String isGamerId() {
            return getServer() + "/player/is-gamerid";
        }

        public final String getSelectIdp() {
            return getServer() + "/auth/selectidp";
        }

        public final String getSignIn() {
            return getServer() + "/auth/signin";
        }

        public final String getSignInIdp() {
            return getServer() + "/auth/signinidp";
        }

        public final String getSignInPlayer() {
            return getServer() + "/auth/signinplayer";
        }

        public final String getSignOut() {
            return getServer() + "/auth/signout";
        }

        public final String getCustomAuthSignInIdp() {
            return getServer() + "/customauth/signinidp";
        }

        public final String getCustomAuthConnect() {
            return getServer() + "/customauth/connect";
        }

        public final String getViewIdp() {
            return getServer() + "/view/idp";
        }

        public final String getViewSelectIdp() {
            return getServer() + "/view/selectidp";
        }

        public final String getPlayerDelete() {
            return getServer() + "/player/delete";
        }

        public final String getOauthToken() {
            return getServer() + "/oauth/token";
        }

        public final String getDeviceSetUser() {
            return getServer() + "/device/set-user";
        }

        public final String getDeviceModifyUser() {
            return getServer() + "/device/modify-user";
        }

        public final String getDeviceDeleteUser() {
            return getServer() + "/device/delete-user";
        }

        public final String getDeviceAdd() {
            return getServer() + "/device/add";
        }

        public final String getDeviceDelete() {
            return getServer() + "/device/delete";
        }

        public final String getDeviceGet() {
            return getServer() + "/device/get";
        }

        public final String getDeviceGetSeq() {
            return getServer() + "/device/get-seq";
        }

        public final String getDeviceModify() {
            return getServer() + "/device/modify";
        }

        public final String getSmsSend() {
            return getServer() + "/sms/send";
        }

        public final String getSmsVerify() {
            return getServer() + "/sms/verify";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/hive/protocol/UrlManager$AuthCP;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "authIdpToken", "", "getAuthIdpToken", "()Ljava/lang/String;", "authIdp", "getAuthIdp", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthCP implements Server {
        public static final AuthCP INSTANCE = new AuthCP();

        private AuthCP() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getAuthIdpToken() {
            return getServer() + "/auth/idp-token";
        }

        public final String getAuthIdp() {
            return getServer() + "/auth/idp";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/hive/protocol/UrlManager$ActiveCcu;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "responseUrl", "", "value", "ccu", "getCcu", "()Ljava/lang/String;", "setCcu", "(Ljava/lang/String;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ActiveCcu implements Server {
        public static final ActiveCcu INSTANCE = new ActiveCcu();
        private static String responseUrl;

        private ActiveCcu() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getCcu() {
            String str = responseUrl;
            if (str != null) {
                return str;
            }
            return getServer() + "/ccu3";
        }

        public final void setCcu(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            responseUrl = value;
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/hive/protocol/UrlManager$StandByCcu;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "responseUrl", "", "value", "ccu", "getCcu", "()Ljava/lang/String;", "setCcu", "(Ljava/lang/String;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StandByCcu implements Server {
        public static final StandByCcu INSTANCE = new StandByCcu();
        private static String responseUrl;

        private StandByCcu() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getCcu() {
            String str = responseUrl;
            if (str != null) {
                return str;
            }
            return getServer() + "/ccu3";
        }

        public final void setCcu(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            responseUrl = value;
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/hive/protocol/UrlManager$HiveChat;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "channel", "", "getChannel", "()Ljava/lang/String;", "channelV2", "getChannelV2", "user", "getUser", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HiveChat implements Server {
        public static final HiveChat INSTANCE = new HiveChat();

        private HiveChat() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getChannel() {
            return getServer() + "/client/v1/games";
        }

        public final String getChannelV2() {
            return getServer() + "/client/v2/games";
        }

        public final String getUser() {
            return getServer() + "/client/v1";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$HiveChatPlugin;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "like", "", "getLike", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HiveChatPlugin implements Server {
        public static final HiveChatPlugin INSTANCE = new HiveChatPlugin();

        private HiveChatPlugin() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getLike() {
            return getServer() + "/plugin/client/like/v1/games";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$CommunityWeb;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "view", "", "getView", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CommunityWeb implements Server {
        public static final CommunityWeb INSTANCE = new CommunityWeb();

        private CommunityWeb() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getView() {
            return getServer() + "/login_webview";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$CustomerCenter;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "inquiry", "", "getInquiry", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CustomerCenter implements Server {
        public static final CustomerCenter INSTANCE = new CustomerCenter();

        private CustomerCenter() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getInquiry() {
            return getServer() + FileSystemKt.UnixPathSeparator;
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/hive/protocol/UrlManager$DataStore;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "get", "", "getGet", "()Ljava/lang/String;", "getDataKey", "getGetDataKey", "GetUserKey", "getGetUserKey", "insert", "getInsert", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DataStore implements Server {
        public static final DataStore INSTANCE = new DataStore();

        private DataStore() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getGet() {
            return getServer() + "/users/get";
        }

        public final String getGetDataKey() {
            return getServer() + "/users/get/datakey";
        }

        public final String getGetUserKey() {
            return getServer() + "/users/get/userkey";
        }

        public final String getInsert() {
            return getServer() + "/users/insert";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/hive/protocol/UrlManager$Funtap;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "checkUserInfo", "", "getCheckUserInfo", "()Ljava/lang/String;", "updateUserInfo", "getUpdateUserInfo", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Funtap implements Server {
        public static final Funtap INSTANCE = new Funtap();

        private Funtap() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getCheckUserInfo() {
            return getServer() + "/api/v1/user/profile";
        }

        public final String getUpdateUserInfo() {
            return getServer() + "/user/profile";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/hive/protocol/UrlManager$IapV1;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "check", "", "getCheck", "()Ljava/lang/String;", "init", "getInit", "log", "getLog", "verify", "getVerify", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IapV1 implements Server {
        public static final IapV1 INSTANCE = new IapV1();

        private IapV1() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getCheck() {
            return getServer() + "/common/billing/check2.c2s";
        }

        public final String getInit() {
            return getServer() + "/common/billing/init.c2s";
        }

        public final String getLog() {
            return getServer() + "/common/billing/log.c2s";
        }

        public final String getVerify() {
            return getServer() + "/common/billing/verify.c2s";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/hive/protocol/UrlManager$IapV2;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "market", "", "getMarket", "()Ljava/lang/String;", "purchase", "getPurchase", "purchaseCheck", "getPurchaseCheck", "shop", "getShop", "shopBadge", "getShopBadge", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IapV2 implements Server {
        public static final IapV2 INSTANCE = new IapV2();

        private IapV2() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getMarket() {
            return getServer() + "/api/call";
        }

        public final String getPurchase() {
            return getServer() + "/api/call";
        }

        public final String getPurchaseCheck() {
            return getServer() + "/api/call";
        }

        public final String getShop() {
            return getServer() + "/api/call";
        }

        public final String getShopBadge() {
            return getServer() + "/api/call";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/hive/protocol/UrlManager$IapV4;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "market", "", "getMarket", "()Ljava/lang/String;", "postPurchase", "getPostPurchase", "prePurchase", "getPrePurchase", AppLovinEventTypes.USER_VIEWED_PRODUCT, "getProduct", "purchase", "getPurchase", "restorePurchase", "getRestorePurchase", "finalizePurchase", "getFinalizePurchase", InAppPurchaseMetaData.KEY_SIGNATURE, "getSignature", "refundInfo", "getRefundInfo", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IapV4 implements Server {
        public static final IapV4 INSTANCE = new IapV4();

        private IapV4() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getMarket() {
            return getServer() + "/api_v4/call";
        }

        public final String getPostPurchase() {
            return getServer() + "/api_v4/call";
        }

        public final String getPrePurchase() {
            return getServer() + "/api_v4/call";
        }

        public final String getProduct() {
            return getServer() + "/api_v4/call";
        }

        public final String getPurchase() {
            return getServer() + "/api_v4/call";
        }

        public final String getRestorePurchase() {
            return getServer() + "/api_v4/call";
        }

        public final String getFinalizePurchase() {
            return getServer() + "/api_v4/call";
        }

        public final String getSignature() {
            return getServer() + "/api_v4/signature/vivo";
        }

        public final String getRefundInfo() {
            return getServer() + "/api_v4/refund/info";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$IapV4Verify;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "verifyRepayment", "", "getVerifyRepayment", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IapV4Verify implements Server {
        public static final IapV4Verify INSTANCE = new IapV4Verify();

        private IapV4Verify() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getVerifyRepayment() {
            return getServer() + "/api_v4/verify_repayment";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/hive/protocol/UrlManager$HiveStore;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "paymentOrder", "", "getPaymentOrder", "()Ljava/lang/String;", "getCheckUrl", "getGetCheckUrl", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HiveStore implements Server {
        public static final HiveStore INSTANCE = new HiveStore();

        private HiveStore() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getPaymentOrder() {
            return getServer() + "/payment/order";
        }

        public final String getGetCheckUrl() {
            return getServer() + "/payment/order/get_check_url";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/hive/protocol/UrlManager$LebiApiV1;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "balance", "", "getBalance", "()Ljava/lang/String;", "buyItem", "getBuyItem", "init", "getInit", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LebiApiV1 implements Server {
        public static final LebiApiV1 INSTANCE = new LebiApiV1();

        private LebiApiV1() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getBalance() {
            return getServer() + "/module/BillRequest2.c2s";
        }

        public final String getBuyItem() {
            return getServer() + "/module/BillRequest2.c2s";
        }

        public final String getInit() {
            return getServer() + "/module/BillRequest2.c2s";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/hive/protocol/UrlManager$LebiApiV2;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "balance", "", "getBalance", "()Ljava/lang/String;", MobileAdsBridgeBase.initializeMethodName, "getInitialize", "purchase", "getPurchase", "restore", "getRestore", "verifyOrder", "getVerifyOrder", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LebiApiV2 implements Server {
        public static final LebiApiV2 INSTANCE = new LebiApiV2();

        private LebiApiV2() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getBalance() {
            return getServer() + "/module/api";
        }

        public final String getInitialize() {
            return getServer() + "/module/api";
        }

        public final String getPurchase() {
            return getServer() + "/module/api";
        }

        public final String getRestore() {
            return getServer() + "/module/api";
        }

        public final String getVerifyOrder() {
            return getServer() + "/module/api";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$LebiWeb;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "charge", "", "getCharge", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LebiWeb implements Server {
        public static final LebiWeb INSTANCE = new LebiWeb();

        private LebiWeb() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getCharge() {
            return getServer() + "/cn/login/BillLogin.jsp";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/hive/protocol/UrlManager$ChinaMarketCallbackUrl;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", Constants.REFERRER_API_XIAOMI, "", "getXiaomi", "()Ljava/lang/String;", "oppo", "getOppo", Constants.REFERRER_API_VIVO, "getVivo", "tencent", "getTencent", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChinaMarketCallbackUrl implements Server {
        public static final ChinaMarketCallbackUrl INSTANCE = new ChinaMarketCallbackUrl();

        private ChinaMarketCallbackUrl() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getXiaomi() {
            return getServer() + "/xiaomi";
        }

        public final String getOppo() {
            return getServer() + "/oppo";
        }

        public final String getVivo() {
            return getServer() + "/vivo";
        }

        public final String getTencent() {
            return getServer() + "/tencent";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/hive/protocol/UrlManager$LoginCenter;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "getUid", "", "getGetUid", "()Ljava/lang/String;", "getVid", "getGetVid", "guestLogin", "getGuestLogin", "login", "getLogin", "logout", "getLogout", "preLogin", "getPreLogin", "update", "getUpdate", "signOut", "getSignOut", "oauthToken", "getOauthToken", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoginCenter implements Server {
        public static final LoginCenter INSTANCE = new LoginCenter();

        private LoginCenter() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getGetUid() {
            return getServer() + "/api/getUid";
        }

        public final String getGetVid() {
            return getServer() + "/api/getVid";
        }

        public final String getGuestLogin() {
            return getServer() + "/api/guestLogin";
        }

        public final String getLogin() {
            return getServer() + "/api/login";
        }

        public final String getLogout() {
            return getServer() + "/api/logout";
        }

        public final String getPreLogin() {
            return getServer() + "/api/preLogin";
        }

        public final String getUpdate() {
            return getServer() + "/api/update";
        }

        public final String getSignOut() {
            return getServer() + "/api/signOut";
        }

        public final String getOauthToken() {
            return getServer() + "/api/oauth/token";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/hive/protocol/UrlManager$MatchMaking;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "requestMatchMaking", "", "getRequestMatchMaking", "()Ljava/lang/String;", "getMatchingStatus", "getGetMatchingStatus", "deleteMatching", "getDeleteMatching", "createGroup", "getCreateGroup", "joinGroup", "getJoinGroup", "leaveGroup", "getLeaveGroup", "kickGroupUser", "getKickGroupUser", "getGroupInfoByUser", "getGetGroupInfoByUser", "getGroupInfoByGroupCode", "getGetGroupInfoByGroupCode", "updateGroupUser", "getUpdateGroupUser", "requestGroupMatching", "getRequestGroupMatching", "deleteGroupMatching", "getDeleteGroupMatching", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MatchMaking implements Server {
        public static final MatchMaking INSTANCE = new MatchMaking();

        private MatchMaking() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getRequestMatchMaking() {
            return getServer() + "/client/matchmakings";
        }

        public final String getGetMatchingStatus() {
            return getServer() + "/client/matchmakings";
        }

        public final String getDeleteMatching() {
            return getServer() + "/client/matchmakings";
        }

        public final String getCreateGroup() {
            return getServer() + "/client/matchmakings";
        }

        public final String getJoinGroup() {
            return getServer() + "/client/matchmakings";
        }

        public final String getLeaveGroup() {
            return getServer() + "/client/matchmakings";
        }

        public final String getKickGroupUser() {
            return getServer() + "/client/matchmakings";
        }

        public final String getGetGroupInfoByUser() {
            return getServer() + "/client/matchmakings";
        }

        public final String getGetGroupInfoByGroupCode() {
            return getServer() + "/client/groups";
        }

        public final String getUpdateGroupUser() {
            return getServer() + "/client/matchmakings";
        }

        public final String getRequestGroupMatching() {
            return getServer() + "/client/matchmakings";
        }

        public final String getDeleteGroupMatching() {
            return getServer() + "/client/matchmakings";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/hive/protocol/UrlManager$Membership;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "getGdpr", "", "getGetGdpr", "()Ljava/lang/String;", "getId", "getGetId", "getSession", "getGetSession", "getView", "getGetView", "login", "getLogin", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Membership implements Server {
        public static final Membership INSTANCE = new Membership();

        private Membership() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getGetGdpr() {
            return getServer() + "/server/policy/get-gdpr";
        }

        public final String getGetId() {
            return getServer() + "/api/token/get-id";
        }

        public final String getGetSession() {
            return getServer() + "/api/player/get-session";
        }

        public final String getGetView() {
            return getServer() + "/login/gdpr/get-view";
        }

        public final String getLogin() {
            return getServer() + "/main/login";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/hive/protocol/UrlManager$Mercury;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "badge", "", "getBadge", "()Ljava/lang/String;", "checkUid", "getCheckUid", "customBoard", "getCustomBoard", "eventBanner", "getEventBanner", "fullBanner", "getFullBanner", "init", "getInit", "main", "getMain", "moreGames", "getMoreGames", "moreGamesLogging", "getMoreGamesLogging", "notice", "getNotice", "review", "getReview", "reviewLogging", "getReviewLogging", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Mercury implements Server {
        public static final Mercury INSTANCE = new Mercury();

        private Mercury() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getBadge() {
            return getServer() + "/init/badge";
        }

        public final String getCheckUid() {
            return getServer() + "/api/checkUid";
        }

        public final String getCustomBoard() {
            return getServer() + "/custom_board";
        }

        public final String getEventBanner() {
            return getServer() + "/api/eventbanner";
        }

        public final String getFullBanner() {
            return getServer() + "/mercury_new/fullbanner";
        }

        public final String getInit() {
            return getServer() + "/init";
        }

        public final String getMain() {
            return getServer() + "/mercury_new";
        }

        public final String getMoreGames() {
            return getServer() + "/api/moregames";
        }

        public final String getMoreGamesLogging() {
            return getServer() + "/logging/moregames";
        }

        public final String getNotice() {
            return getServer() + "/notice";
        }

        public final String getReview() {
            return getServer() + "/api/review";
        }

        public final String getReviewLogging() {
            return getServer() + "/logging/review";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/hive/protocol/UrlManager$Offerwall;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "init", "", "getInit", "()Ljava/lang/String;", ReportUtil.EVENT_TYPE_REWARD, "getReward", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB, "getWeb", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Offerwall implements Server {
        public static final Offerwall INSTANCE = new Offerwall();

        private Offerwall() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getInit() {
            return getServer() + "/api/init";
        }

        public final String getReward() {
            return getServer() + "/api/reward";
        }

        public final String getWeb() {
            return getServer() + FileSystemKt.UnixPathSeparator;
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/hive/protocol/UrlManager$ProfileApi;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "getPlayer", "", "getGetPlayer", "()Ljava/lang/String;", "upload", "getUpload", "uploadFile", "getUploadFile", "profileGetUser", "getProfileGetUser", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProfileApi implements Server {
        public static final ProfileApi INSTANCE = new ProfileApi();

        private ProfileApi() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getGetPlayer() {
            return getServer() + "/v4/profile/get-player";
        }

        public final String getUpload() {
            return getServer() + "/v4/profile/upload";
        }

        public final String getUploadFile() {
            return getServer() + "/v4/profile/upload-file";
        }

        public final String getProfileGetUser() {
            return getServer() + "/profile/get-user";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$ProfileWeb;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "view", "", "getView", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProfileWeb implements Server {
        public static final ProfileWeb INSTANCE = new ProfileWeb();

        private ProfileWeb() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getView() {
            return getServer() + "/v4/view/profile/information";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b7\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b;\u0010\u0007¨\u0006<"}, d2 = {"Lcom/hive/protocol/UrlManager$PromotionV2;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "init", "", "getInit", "()Ljava/lang/String;", "review", "getReview", "reviewClick", "getReviewClick", "moreGames", "getMoreGames", "moreGamesClick", "getMoreGamesClick", ReportUtil.INVENTORY_TYPE_BANNER, "getBanner", "companion", "getCompanion", "cpi", "getCpi", "cpa", "getCpa", NotificationCompat.CATEGORY_NAVIGATION, "getNavigation", "bannerList", "getBannerList", "badge", "getBadge", "increaseCount", "getIncreaseCount", "login", "getLogin", "news", "getNews", "newsNotice", "getNewsNotice", "newsSpot", "getNewsSpot", "newsBanner", "getNewsBanner", DevicePublicKeyStringDef.DIRECT, "getDirect", "newsLogOpenBanner", "getNewsLogOpenBanner", "newsLogClickBanner", "getNewsLogClickBanner", "customView", "getCustomView", "custemBoard", "getCustemBoard", "offerwall", "getOfferwall", "uaUser", "getUaUser", "uaSenderInfo", "getUaSenderInfo", "deferredMatch", "getDeferredMatch", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PromotionV2 implements Server {
        public static final PromotionV2 INSTANCE = new PromotionV2();

        private PromotionV2() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getInit() {
            return getServer() + "/api/init";
        }

        public final String getReview() {
            return getServer() + "/api/review";
        }

        public final String getReviewClick() {
            return getServer() + "/api/review/click";
        }

        public final String getMoreGames() {
            return getServer() + "/api/moregames";
        }

        public final String getMoreGamesClick() {
            return getServer() + "/api/moregames/click";
        }

        public final String getBanner() {
            return getServer() + "/api/banner";
        }

        public final String getCompanion() {
            return getServer() + "/api/get/companion";
        }

        public final String getCpi() {
            return getServer() + "/api/cpi";
        }

        public final String getCpa() {
            return getServer() + "/api/cpa";
        }

        public final String getNavigation() {
            return getServer() + "/api/dashboard/nav";
        }

        public final String getBannerList() {
            return getServer() + "/api/banner/list";
        }

        public final String getBadge() {
            return getServer() + "/api/getbadge";
        }

        public final String getIncreaseCount() {
            return getServer() + "/api/invoice/increase_count";
        }

        public final String getLogin() {
            return getServer() + "/api/login";
        }

        public final String getNews() {
            return getServer() + "/news";
        }

        public final String getNewsNotice() {
            return getServer() + "/news/notice";
        }

        public final String getNewsSpot() {
            return getServer() + "/news/soit";
        }

        public final String getNewsBanner() {
            return getServer() + "/news/banner";
        }

        public final String getDirect() {
            return getServer() + "/news/direct";
        }

        public final String getNewsLogOpenBanner() {
            return getServer() + "/news/log_open/banner_image";
        }

        public final String getNewsLogClickBanner() {
            return getServer() + "/news/log_click/banner_image";
        }

        public final String getCustomView() {
            return getServer() + "/custom/view";
        }

        public final String getCustemBoard() {
            return getServer() + "/custom/board";
        }

        public final String getOfferwall() {
            return getServer() + "/offerwall";
        }

        public final String getUaUser() {
            return getServer() + "/ua/user";
        }

        public final String getUaSenderInfo() {
            return getServer() + "/ua/getSenderVid";
        }

        public final String getDeferredMatch() {
            return getServer() + "/api/deferredMatch";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/hive/protocol/UrlManager$Provision;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "addDownload", "", "getAddDownload", "()Ljava/lang/String;", "addSetInfo", "getAddSetInfo", "getAgreement", "getGetAgreement", "agreementDetermineBasePlayer", "getAgreementDetermineBasePlayer", "getBlockedCountry", "getGetBlockedCountry", "getInfo", "getGetInfo", "getMaintenance", "getGetMaintenance", "integration", "getIntegration", "metadataInitInteraction", "getMetadataInitInteraction", "verifyRemoteLogging", "getVerifyRemoteLogging", "noticePopupSettleBill", "getNoticePopupSettleBill", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Provision implements Server {
        public static final Provision INSTANCE = new Provision();

        private Provision() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getAddDownload() {
            return getServer() + "/provision/add-download";
        }

        public final String getAddSetInfo() {
            return getServer() + "/provision/addset-info";
        }

        public final String getGetAgreement() {
            return getServer() + "/provision/get-agreement";
        }

        public final String getAgreementDetermineBasePlayer() {
            return getServer() + "/provision/agreement-determine-base-player";
        }

        public final String getGetBlockedCountry() {
            return getServer() + "/provision/get-blocked-country";
        }

        public final String getGetInfo() {
            return getServer() + "/provision/get-info";
        }

        public final String getGetMaintenance() {
            return getServer() + "/provision/get-maintenance";
        }

        public final String getIntegration() {
            return getServer() + "/provision/integration";
        }

        public final String getMetadataInitInteraction() {
            return getServer() + "/provision/metadata-init-interaction";
        }

        public final String getVerifyRemoteLogging() {
            return getServer() + "/configuration/verifyRemoteLogging";
        }

        public final String getNoticePopupSettleBill() {
            return getServer() + "/provision/notice-popup-settle-bill";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/UrlManager$Push;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "agreeV1Get", "", "getAgreeV1Get", "()Ljava/lang/String;", "agreeV1Set", "getAgreeV1Set", "confirm", "getConfirm", "sender", "getSender", "tokenReg", "getTokenReg", "tokenUnreg", "getTokenUnreg", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Push implements Server {
        public static final Push INSTANCE = new Push();

        private Push() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getAgreeV1Get() {
            return getServer() + "/api/agree/v1/get.php";
        }

        public final String getAgreeV1Set() {
            return getServer() + "/api/agree/v1/set.php";
        }

        public final String getConfirm() {
            return getServer() + "/api/confirm.php";
        }

        public final String getSender() {
            return getServer() + "/api/sender.php";
        }

        public final String getTokenReg() {
            return getServer() + "/api/token_reg.php";
        }

        public final String getTokenUnreg() {
            return getServer() + "/api/token_unreg.php";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/UrlManager$PushV4;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "agreement", "", "getAgreement", "()Ljava/lang/String;", "agreementInfo", "getAgreementInfo", "fcmInfo", "getFcmInfo", "opens", "getOpens", "senderId", "getSenderId", "tokens", "getTokens", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PushV4 implements Server {
        public static final PushV4 INSTANCE = new PushV4();

        private PushV4() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getAgreement() {
            return getServer() + "/push/agreement";
        }

        public final String getAgreementInfo() {
            return getServer() + "/push/agreement/info";
        }

        public final String getFcmInfo() {
            return getServer() + "/push/apps/fcm/info";
        }

        public final String getOpens() {
            return getServer() + "/push/opens";
        }

        public final String getSenderId() {
            return getServer() + "/push/apps/google/senderId";
        }

        public final String getTokens() {
            return getServer() + "/push/2/tokens";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b1\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b5\u0010\u0007¨\u00066"}, d2 = {"Lcom/hive/protocol/UrlManager$SocialApi;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "deviceUsePGS", "", "getDeviceUsePGS", "()Ljava/lang/String;", "user", "getUser", "userMe", "getUserMe", "userMeNotifications", "getUserMeNotifications", "userModify", "getUserModify", "users", "getUsers", "userV2", "getUserV2", "userMeV2", "getUserMeV2", "usersV2", "getUsersV2", SocialKeys.PeppermintRequestUrlPath.PEPPERMINT_GUEST_ACQUIRE_UID_PATH, "getGuest", "guestKey", "getGuestKey", "guestGenereate", "getGuestGenereate", "guestAuth", "getGuestAuth", "guestLogin", "getGuestLogin", "deviceRegistered", "getDeviceRegistered", "wallWrite", "getWallWrite", "guestStatusSaveData", "getGuestStatusSaveData", "socialConnect", "getSocialConnect", "acaLoginPlayGamesService", "getAcaLoginPlayGamesService", "acaLoginPlayGamesServiceSet", "getAcaLoginPlayGamesServiceSet", "acaUserQuitRequest", "getAcaUserQuitRequest", "acaGetAuthToken", "getAcaGetAuthToken", "acaDeleteCookies", "getAcaDeleteCookies", "undefinedRequest", "getUndefinedRequest", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SocialApi implements Server {
        public static final SocialApi INSTANCE = new SocialApi();

        private SocialApi() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getDeviceUsePGS() {
            return getServer() + "/device/use_pgs";
        }

        public final String getUser() {
            return getServer() + "/user";
        }

        public final String getUserMe() {
            return getServer() + "/user/me";
        }

        public final String getUserMeNotifications() {
            return getServer() + "/user/me/notifications";
        }

        public final String getUserModify() {
            return getServer() + "/user/modify_info";
        }

        public final String getUsers() {
            return getServer() + "/users";
        }

        public final String getUserV2() {
            return getServer() + "/v2/user";
        }

        public final String getUserMeV2() {
            return getServer() + "/v2/user/me";
        }

        public final String getUsersV2() {
            return getServer() + "/v2/users";
        }

        public final String getGuest() {
            return getServer() + "/guest/create";
        }

        public final String getGuestKey() {
            return getServer() + "/guest/key";
        }

        public final String getGuestGenereate() {
            return getServer() + "/guest/generate";
        }

        public final String getGuestAuth() {
            return getServer() + "/guest/auth";
        }

        public final String getGuestLogin() {
            return getServer() + "/guest/login";
        }

        public final String getDeviceRegistered() {
            return getServer() + "/device/registered";
        }

        public final String getWallWrite() {
            return getServer() + "/wall/write";
        }

        public final String getGuestStatusSaveData() {
            return getServer() + "/guest/status_savedata";
        }

        public final String getSocialConnect() {
            return getServer() + "/social/connect";
        }

        public final String getAcaLoginPlayGamesService() {
            return getServer() + "/aca_login_play_games_service";
        }

        public final String getAcaLoginPlayGamesServiceSet() {
            return getServer() + "/aca_login_play_games_service_set";
        }

        public final String getAcaUserQuitRequest() {
            return getServer() + "/aca_user_quit_request";
        }

        public final String getAcaGetAuthToken() {
            return getServer() + "/aca_get_auth_token";
        }

        public final String getAcaDeleteCookies() {
            return getServer() + "/aca_delete_cookies";
        }

        public final String getUndefinedRequest() {
            return getServer() + FileSystemKt.UnixPathSeparator;
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/hive/protocol/UrlManager$SocialOtherApi;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "saveDataUpload", "", "getSaveDataUpload", "()Ljava/lang/String;", "saveDataDownload", "getSaveDataDownload", "saveDataDelete", "getSaveDataDelete", "uploadImage", "getUploadImage", "undefinedRequest", "getUndefinedRequest", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SocialOtherApi implements Server {
        public static final SocialOtherApi INSTANCE = new SocialOtherApi();

        private SocialOtherApi() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getSaveDataUpload() {
            return getServer() + "/savedata/upload";
        }

        public final String getSaveDataDownload() {
            return getServer() + "/savedata/download";
        }

        public final String getSaveDataDelete() {
            return getServer() + "/savedata/delete";
        }

        public final String getUploadImage() {
            return getServer() + "/upload/image_with_json";
        }

        public final String getUndefinedRequest() {
            return getServer() + FileSystemKt.UnixPathSeparator;
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/hive/protocol/UrlManager$SocialWeb;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "game", "", "getGame", "()Ljava/lang/String;", "inquiry", "getInquiry", "home", "getHome", "login", "getLogin", "loginByPGS", "getLoginByPGS", "logout", "getLogout", "guestAcquire", "getGuestAcquire", "guestBind", "getGuestBind", Scopes.PROFILE, "getProfile", "editProfilePicture", "getEditProfilePicture", "editFacebook", "getEditFacebook", "undefinedRequest", "getUndefinedRequest", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SocialWeb implements Server {
        public static final SocialWeb INSTANCE = new SocialWeb();

        private SocialWeb() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getGame() {
            return getServer() + "/game";
        }

        public final String getInquiry() {
            return getServer() + "/inquiry";
        }

        public final String getHome() {
            return getServer() + "/home";
        }

        public final String getLogin() {
            return getServer() + "/auth";
        }

        public final String getLoginByPGS() {
            return getServer() + "/pgs/signup";
        }

        public final String getLogout() {
            return getServer() + "/auth/logout_proc";
        }

        public final String getGuestAcquire() {
            return getServer() + "/guest";
        }

        public final String getGuestBind() {
            return getServer() + "/guest/bind";
        }

        public final String getProfile() {
            return getServer() + "/profile";
        }

        public final String getEditProfilePicture() {
            return getServer() + "/edit/profile/picture";
        }

        public final String getEditFacebook() {
            return getServer() + "/edit/facebook";
        }

        public final String getUndefinedRequest() {
            return getServer() + FileSystemKt.UnixPathSeparator;
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b%\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\bR\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\bR\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\bR\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\bR\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\bR\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\bR\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\bR\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\bR\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\bR\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\bR\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010\bR\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\bR\u0011\u0010&\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b'\u0010\bR\u0011\u0010(\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\b¨\u0006*"}, d2 = {"Lcom/hive/protocol/UrlManager$SocialFriendApi;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "addressBookSync", "", "getAddressBookSync$annotations", "getAddressBookSync", "()Ljava/lang/String;", "addressBookSyncCount", "getAddressBookSyncCount$annotations", "getAddressBookSyncCount", "friendsAll", "getFriendsAll", "friendsInGame", "getFriendsInGame", "friendsOutGame", "getFriendsOutGame", "friendsAllV2", "getFriendsAllV2", "friendsInGameV2", "getFriendsInGameV2", "friendsOutGameV2", "getFriendsOutGameV2", "friendsInvite", "getFriendsInvite", "messageNotiCount", "getMessageNotiCount", "messageWrite", "getMessageWrite", "friendsInfo", "getFriendsInfo", "friendsRequest", "getFriendsRequest", "friendsRejectRequest", "getFriendsRejectRequest", "friendsRequestList", "getFriendsRequestList", "friendsReceiveList", "getFriendsReceiveList", "friendsFacebookRequest", "getFriendsFacebookRequest", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SocialFriendApi implements Server {
        public static final SocialFriendApi INSTANCE = new SocialFriendApi();

        @Deprecated(message = "GCPSDK-294")
        public static /* synthetic */ void getAddressBookSync$annotations() {
        }

        @Deprecated(message = "GCPSDK-294")
        public static /* synthetic */ void getAddressBookSyncCount$annotations() {
        }

        private SocialFriendApi() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getAddressBookSync() {
            return getServer() + "/api/addressbook/addressbooksync";
        }

        public final String getAddressBookSyncCount() {
            return getServer() + "/api/addressbook/addressbooksynccount";
        }

        public final String getFriendsAll() {
            return getServer() + "/api/friends";
        }

        public final String getFriendsInGame() {
            return getServer() + "/api/friends/game";
        }

        public final String getFriendsOutGame() {
            return getServer() + "/api/friends/other";
        }

        public final String getFriendsAllV2() {
            return getServer() + "/api/v2/friends";
        }

        public final String getFriendsInGameV2() {
            return getServer() + "/api/v2/friends/game";
        }

        public final String getFriendsOutGameV2() {
            return getServer() + "/api/v2/friends/other";
        }

        public final String getFriendsInvite() {
            return getServer() + "/api/message/get_invitations";
        }

        public final String getMessageNotiCount() {
            return getServer() + "/api/message/noticount";
        }

        public final String getMessageWrite() {
            return getServer() + "/api/message/write";
        }

        public final String getFriendsInfo() {
            return getServer() + "/api/friends/info";
        }

        public final String getFriendsRequest() {
            return getServer() + "/api/friends/request";
        }

        public final String getFriendsRejectRequest() {
            return getServer() + "/api/friends/reject_request";
        }

        public final String getFriendsRequestList() {
            return getServer() + "/api/friends/request_list";
        }

        public final String getFriendsReceiveList() {
            return getServer() + "/api/v2/friends/receive_list";
        }

        public final String getFriendsFacebookRequest() {
            return getServer() + "/api/friends/facebook";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/hive/protocol/UrlManager$SocialFriendWeb;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "message", "", "getMessage", "()Ljava/lang/String;", "undefinedRequest", "getUndefinedRequest", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SocialFriendWeb implements Server {
        public static final SocialFriendWeb INSTANCE = new SocialFriendWeb();

        private SocialFriendWeb() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getMessage() {
            return getServer() + "/message";
        }

        public final String getUndefinedRequest() {
            return getServer() + FileSystemKt.UnixPathSeparator;
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/hive/protocol/UrlManager$ChinaApi;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "chinaVerifyRealName", "", "getChinaVerifyRealName", "()Ljava/lang/String;", "chinaVerifyPhoneSendCode", "getChinaVerifyPhoneSendCode", "chinaVerifyPhoneConfirm", "getChinaVerifyPhoneConfirm", "chinaVerifyPhone", "getChinaVerifyPhone", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChinaApi implements Server {
        public static final ChinaApi INSTANCE = new ChinaApi();

        private ChinaApi() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getChinaVerifyRealName() {
            return getServer() + "/v4/china_verify_realname";
        }

        public final String getChinaVerifyPhoneSendCode() {
            return getServer() + "/v4/china_verify_phone_send_code";
        }

        public final String getChinaVerifyPhoneConfirm() {
            return getServer() + "/v4/china_verify_phone_confirm";
        }

        public final String getChinaVerifyPhone() {
            return getServer() + "/v4/china_verify_phone";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$Chatbot;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "chat", "", "getChat", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Chatbot implements Server {
        public static final Chatbot INSTANCE = new Chatbot();

        private Chatbot() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getChat() {
            return getServer() + "/chat/cs";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$UserEngagement;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "consumeCoupon", "", "getConsumeCoupon", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserEngagement implements Server {
        public static final UserEngagement INSTANCE = new UserEngagement();

        private UserEngagement() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getConsumeCoupon() {
            return getServer() + "/ci/coupon/coupon_use/submit";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$TimeZone;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "getCountryCodeByIp", "", "getGetCountryCodeByIp", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TimeZone implements Server {
        public static final TimeZone INSTANCE = new TimeZone();

        private TimeZone() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getGetCountryCodeByIp() {
            return getServer() + "/public/api/getCountryCodeByIp";
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$Terms;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "deviceManagement", "", "getDeviceManagement", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Terms implements Server {
        public static final Terms INSTANCE = new Terms();

        private Terms() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getDeviceManagement() {
            return getServer();
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$WithHive;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "customerAsk", "", "getCustomerAsk", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WithHive implements Server {
        public static final WithHive INSTANCE = new WithHive();

        private WithHive() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getCustomerAsk() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(getServer());
            if (!StringsKt.isBlank(Configuration.INSTANCE.getCompany())) {
                str = DomExceptionUtils.SEPARATOR + Configuration.INSTANCE.getCompany();
            } else {
                str = "";
            }
            sb.append(str);
            sb.append("/ask");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$Fcm;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "apiKey", "", "getApiKey", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Fcm implements Server {
        public static final Fcm INSTANCE = new Fcm();

        private Fcm() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getApiKey() {
            return getServer();
        }
    }

    /* JADX INFO: compiled from: UrlManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/protocol/UrlManager$MirrorDomain;", "Lcom/hive/protocol/UrlManager$Server;", "<init>", "()V", "defaultMirrorDomain", "", "getDefaultMirrorDomain", "()Ljava/lang/String;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MirrorDomain implements Server {
        public static final MirrorDomain INSTANCE = new MirrorDomain();

        private MirrorDomain() {
        }

        @Override // com.hive.protocol.UrlManager.Server
        public <R> R getProperty(Object obj, String str) {
            return (R) Server.DefaultImpls.getProperty(this, obj, str);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String getServer() {
            return Server.DefaultImpls.getServer(this);
        }

        @Override // com.hive.protocol.UrlManager.Server
        public String hexToStr(String str) {
            return Server.DefaultImpls.hexToStr(this, str);
        }

        public final String getDefaultMirrorDomain() {
            return getServer();
        }
    }
}
