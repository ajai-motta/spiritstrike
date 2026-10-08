package com.hive.protocol.provision;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.net.HttpHeaders;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.HiveTime;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.provision.Provision;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MetadataInitInteraction.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/provision/MetadataInitInteraction;", "Lcom/hive/protocol/provision/Provision;", "<init>", "()V", "value", "Lcom/hive/protocol/provision/MetadataInitInteraction$MetadataInitInteractionResponse;", "response", "getResponse", "()Lcom/hive/protocol/provision/MetadataInitInteraction$MetadataInitInteractionResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "MetadataInitInteractionResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MetadataInitInteraction extends Provision {
    private MetadataInitInteractionResponse response;

    public MetadataInitInteraction() {
        JSONObject jsonBody = getJsonBody();
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_appid);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_app_version);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_app_version_display);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_os);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_sdk_version);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_country);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_device_country);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_os_version);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_timestamp);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_timezone_offset);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_hive_certification_key);
    }

    public final MetadataInitInteractionResponse getResponse() {
        MetadataInitInteractionResponse metadataInitInteractionResponse = this.response;
        if (metadataInitInteractionResponse != null) {
            return metadataInitInteractionResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.provision.Provision, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.Provision.INSTANCE.getMetadataInitInteraction());
        getCoreRequest().setContentType(Request.ContentType.JSON);
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.provision.Provision, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new MetadataInitInteractionResponse(coreResponse);
    }

    /* JADX INFO: compiled from: MetadataInitInteraction.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0007R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001a\u0010-\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\u001a\u00100\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\u001a\u00103\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010!\"\u0004\b5\u0010#R\u001a\u00106\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R\u001a\u00109\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R\u001a\u0010;\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010'\"\u0004\b<\u0010)R\u001a\u0010=\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u001c\u0010?\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011R\u001a\u0010B\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017R\u001a\u0010E\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010\u0017R\u001a\u0010H\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0015\"\u0004\bJ\u0010\u0017R\u001a\u0010K\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010'\"\u0004\bL\u0010)R\u001a\u0010M\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010!\"\u0004\bO\u0010#R\u001a\u0010P\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010'\"\u0004\bQ\u0010)¨\u0006U"}, d2 = {"Lcom/hive/protocol/provision/MetadataInitInteraction$MetadataInitInteractionResponse;", "Lcom/hive/protocol/provision/Provision$ProvisionResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "dataJSONObject", "Lorg/json/JSONObject;", "getDataJSONObject", "()Lorg/json/JSONObject;", "setDataJSONObject", "(Lorg/json/JSONObject;)V", "maintenanceInfoJSONArray", "Lorg/json/JSONArray;", "getMaintenanceInfoJSONArray", "()Lorg/json/JSONArray;", "setMaintenanceInfoJSONArray", "(Lorg/json/JSONArray;)V", "hiveCountry", "", "getHiveCountry", "()Ljava/lang/String;", "setHiveCountry", "(Ljava/lang/String;)V", "timezone", "getTimezone", "setTimezone", "whiteListDomains", "getWhiteListDomains", "setWhiteListDomains", "minGooglePlayServices", "", "getMinGooglePlayServices", "()I", "setMinGooglePlayServices", "(I)V", "googleLegacySupport", "", "getGoogleLegacySupport", "()Z", "setGoogleLegacySupport", "(Z)V", "company", "getCompany", "setCompany", "companyName", "getCompanyName", "setCompanyName", "companyIndex", "getCompanyIndex", "setCompanyIndex", "appindex", "getAppindex", "setAppindex", AndroidGetAdPlayerContext.KEY_GAME_ID, "getGameId", "setGameId", "isOfflineMode", "setOfflineMode", "isCcuDeactivate", "setCcuDeactivate", "isEEACountry", "setEEACountry", "oauthClientsInfo", "getOauthClientsInfo", "setOauthClientsInfo", "primaryClientId", "getPrimaryClientId", "setPrimaryClientId", "gameIndex", "getGameIndex", "setGameIndex", "verificationMode", "getVerificationMode", "setVerificationMode", "isUsedAppStoreAccountability", "setUsedAppStoreAccountability", "effectiveStatusAppStoreAccountability", "getEffectiveStatusAppStoreAccountability", "setEffectiveStatusAppStoreAccountability", "isFunTapUnderGovernmentReview", "setFunTapUnderGovernmentReview", "setData", "", "data", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MetadataInitInteractionResponse extends Provision.ProvisionResponse {
        private int appindex;
        private String company;
        private int companyIndex;
        private String companyName;
        private JSONObject dataJSONObject;
        private int effectiveStatusAppStoreAccountability;
        private String gameId;
        private String gameIndex;
        private boolean googleLegacySupport;
        private String hiveCountry;
        private boolean isCcuDeactivate;
        private boolean isEEACountry;
        private boolean isFunTapUnderGovernmentReview;
        private boolean isOfflineMode;
        private boolean isUsedAppStoreAccountability;
        private JSONArray maintenanceInfoJSONArray;
        private int minGooglePlayServices;
        private JSONArray oauthClientsInfo;
        private String primaryClientId;
        private JSONObject timezone;
        private String verificationMode;
        private JSONArray whiteListDomains;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MetadataInitInteractionResponse(Response coreResponse) {
            String str;
            Date date;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.hiveCountry = "";
            this.company = "";
            this.companyName = "";
            this.appindex = -1;
            this.gameId = "";
            this.primaryClientId = "";
            this.gameIndex = "";
            this.verificationMode = "";
            this.effectiveStatusAppStoreAccountability = -1000;
            try {
                if (!HiveTime.INSTANCE.isSetBaseTime() && (str = getHeader().get(HttpHeaders.DATE)) != null && (date = new SimpleDateFormat("EEE',' dd' 'MMM' 'yyyy HH':'mm':'ss zzz", Locale.US).parse(str)) != null) {
                    HiveTime.INSTANCE.setBaseTime(new Timestamp(date.getTime()));
                }
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
            }
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        setData(jSONObjectOptJSONObject);
                    }
                } catch (Exception e2) {
                    Logger.INSTANCE.protocolLog(e2.toString(), Logger.LogType.Warning);
                    setResultCode(-1);
                    setResultMsg("[Exception] " + e2);
                }
            }
        }

        public final JSONObject getDataJSONObject() {
            return this.dataJSONObject;
        }

        public final void setDataJSONObject(JSONObject jSONObject) {
            this.dataJSONObject = jSONObject;
        }

        public final JSONArray getMaintenanceInfoJSONArray() {
            return this.maintenanceInfoJSONArray;
        }

        public final void setMaintenanceInfoJSONArray(JSONArray jSONArray) {
            this.maintenanceInfoJSONArray = jSONArray;
        }

        public final String getHiveCountry() {
            return this.hiveCountry;
        }

        public final void setHiveCountry(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.hiveCountry = str;
        }

        public final JSONObject getTimezone() {
            return this.timezone;
        }

        public final void setTimezone(JSONObject jSONObject) {
            this.timezone = jSONObject;
        }

        public final JSONArray getWhiteListDomains() {
            return this.whiteListDomains;
        }

        public final void setWhiteListDomains(JSONArray jSONArray) {
            this.whiteListDomains = jSONArray;
        }

        public final int getMinGooglePlayServices() {
            return this.minGooglePlayServices;
        }

        public final void setMinGooglePlayServices(int i) {
            this.minGooglePlayServices = i;
        }

        public final boolean getGoogleLegacySupport() {
            return this.googleLegacySupport;
        }

        public final void setGoogleLegacySupport(boolean z) {
            this.googleLegacySupport = z;
        }

        public final String getCompany() {
            return this.company;
        }

        public final void setCompany(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.company = str;
        }

        public final String getCompanyName() {
            return this.companyName;
        }

        public final void setCompanyName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.companyName = str;
        }

        public final int getCompanyIndex() {
            return this.companyIndex;
        }

        public final void setCompanyIndex(int i) {
            this.companyIndex = i;
        }

        public final int getAppindex() {
            return this.appindex;
        }

        public final void setAppindex(int i) {
            this.appindex = i;
        }

        public final String getGameId() {
            return this.gameId;
        }

        public final void setGameId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.gameId = str;
        }

        /* JADX INFO: renamed from: isOfflineMode, reason: from getter */
        public final boolean getIsOfflineMode() {
            return this.isOfflineMode;
        }

        public final void setOfflineMode(boolean z) {
            this.isOfflineMode = z;
        }

        /* JADX INFO: renamed from: isCcuDeactivate, reason: from getter */
        public final boolean getIsCcuDeactivate() {
            return this.isCcuDeactivate;
        }

        public final void setCcuDeactivate(boolean z) {
            this.isCcuDeactivate = z;
        }

        /* JADX INFO: renamed from: isEEACountry, reason: from getter */
        public final boolean getIsEEACountry() {
            return this.isEEACountry;
        }

        public final void setEEACountry(boolean z) {
            this.isEEACountry = z;
        }

        public final JSONArray getOauthClientsInfo() {
            return this.oauthClientsInfo;
        }

        public final void setOauthClientsInfo(JSONArray jSONArray) {
            this.oauthClientsInfo = jSONArray;
        }

        public final String getPrimaryClientId() {
            return this.primaryClientId;
        }

        public final void setPrimaryClientId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.primaryClientId = str;
        }

        public final String getGameIndex() {
            return this.gameIndex;
        }

        public final void setGameIndex(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.gameIndex = str;
        }

        public final String getVerificationMode() {
            return this.verificationMode;
        }

        public final void setVerificationMode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.verificationMode = str;
        }

        /* JADX INFO: renamed from: isUsedAppStoreAccountability, reason: from getter */
        public final boolean getIsUsedAppStoreAccountability() {
            return this.isUsedAppStoreAccountability;
        }

        public final void setUsedAppStoreAccountability(boolean z) {
            this.isUsedAppStoreAccountability = z;
        }

        public final int getEffectiveStatusAppStoreAccountability() {
            return this.effectiveStatusAppStoreAccountability;
        }

        public final void setEffectiveStatusAppStoreAccountability(int i) {
            this.effectiveStatusAppStoreAccountability = i;
        }

        /* JADX INFO: renamed from: isFunTapUnderGovernmentReview, reason: from getter */
        public final boolean getIsFunTapUnderGovernmentReview() {
            return this.isFunTapUnderGovernmentReview;
        }

        public final void setFunTapUnderGovernmentReview(boolean z) {
            this.isFunTapUnderGovernmentReview = z;
        }

        public final void setData(JSONObject data) throws Exception {
            Intrinsics.checkNotNullParameter(data, "data");
            this.dataJSONObject = data;
            this.maintenanceInfoJSONArray = data.optJSONArray("maintenance");
            String strOptString = data.optString("hive_country");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.hiveCountry = strOptString;
            this.timezone = data.optJSONObject("timezone");
            this.whiteListDomains = data.optJSONArray("white_list");
            this.minGooglePlayServices = data.optInt("min_google_play_services", 0);
            this.googleLegacySupport = convertProvisionFlagResponse(data.optString("google_legacy_support"));
            String strOptString2 = data.optString("company");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.company = strOptString2;
            String strOptString3 = data.optString("company_name");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            this.companyName = strOptString3;
            this.companyIndex = data.optInt("company_index");
            this.appindex = data.optInt("appindex");
            String strOptString4 = data.optString("game_id");
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            this.gameId = strOptString4;
            this.isOfflineMode = convertProvisionFlagResponse(data.optString("is_offline_mode"));
            this.isCcuDeactivate = convertProvisionFlagResponse(data.optString("is_ccu_deactivate"));
            this.isEEACountry = convertProvisionFlagResponse(data.optString("is_eea_country"));
            JSONArray jSONArrayOptJSONArray = data.optJSONArray("oauth_clients_info");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null && Intrinsics.areEqual(jSONObjectOptJSONObject.optString("issue_order"), AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            String strOptString5 = jSONObjectOptJSONObject.optString("client_id");
                            Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                            this.primaryClientId = strOptString5;
                            String strOptString6 = jSONObjectOptJSONObject.optString("game_index");
                            Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                            this.gameIndex = strOptString6;
                        }
                        if (i == length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            } else {
                jSONArrayOptJSONArray = null;
            }
            this.oauthClientsInfo = jSONArrayOptJSONArray;
            String strOptString7 = data.optString("verification_mode");
            Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
            this.verificationMode = strOptString7;
            JSONObject jSONObjectOptJSONObject2 = data.optJSONObject("app_store_accountability_act");
            if (jSONObjectOptJSONObject2 != null) {
                this.isUsedAppStoreAccountability = jSONObjectOptJSONObject2.optBoolean("is_used", false);
                this.effectiveStatusAppStoreAccountability = jSONObjectOptJSONObject2.optInt("effective_status", -1000);
            }
            JSONObject jSONObjectOptJSONObject3 = data.optJSONObject("vietnam_game_license");
            if (jSONObjectOptJSONObject3 != null) {
                this.isFunTapUnderGovernmentReview = jSONObjectOptJSONObject3.optBoolean("is_shown", false);
            }
            JSONObject jSONObjectOptJSONObject4 = data.optJSONObject("analytics_setting");
            if (jSONObjectOptJSONObject4 != null) {
                UrlManager.INSTANCE.setAnalyticsUrl(jSONObjectOptJSONObject4);
            }
        }
    }
}
