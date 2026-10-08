package com.hive.protocol.activeuser;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.net.HttpHeaders;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.HiveTime;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.activeuser.ActiveUser;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: GetAgreement.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/activeuser/GetAgreement;", "Lcom/hive/protocol/activeuser/ActiveUser;", "<init>", "()V", "value", "Lcom/hive/protocol/activeuser/GetAgreement$GetAgreementResponse;", "response", "getResponse", "()Lcom/hive/protocol/activeuser/GetAgreement$GetAgreementResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "GetAgreementResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAgreement extends ActiveUser {
    private GetAgreementResponse response;

    public GetAgreement() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_agreement_sms);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_agreement_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_api);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appversion);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_app_version_display);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_hive_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_mdn);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_platform);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_server_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_timezone);
    }

    public final GetAgreementResponse getResponse() {
        GetAgreementResponse getAgreementResponse = this.response;
        if (getAgreementResponse != null) {
            return getAgreementResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.activeuser.ActiveUser, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.ActiveUser.INSTANCE.getGetAgreement());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.activeuser.ActiveUser, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new GetAgreementResponse(coreResponse);
    }

    /* JADX INFO: compiled from: GetAgreement.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001a\u0010*\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R\u001a\u00109\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R\u001a\u0010<\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010\u000bR\u001a\u0010?\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010\u0014R\u001a\u0010K\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0012\"\u0004\bM\u0010\u0014R\u001a\u0010N\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001e\"\u0004\bO\u0010 R\u001a\u0010P\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\t\"\u0004\bR\u0010\u000b¨\u0006S"}, d2 = {"Lcom/hive/protocol/activeuser/GetAgreement$GetAgreementResponse;", "Lcom/hive/protocol/activeuser/ActiveUser$ActiveUserResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "agreement_show", "", "getAgreement_show", "()I", "setAgreement_show", "(I)V", "agreement_version", "getAgreement_version", "setAgreement_version", "agreement_url", "", "getAgreement_url", "()Ljava/lang/String;", "setAgreement_url", "(Ljava/lang/String;)V", "agreement_review_url", "getAgreement_review_url", "setAgreement_review_url", "agreement_scheme", "getAgreement_scheme", "setAgreement_scheme", "typeTerms", "", "getTypeTerms", "()Z", "setTypeTerms", "(Z)V", "typeSms", "getTypeSms", "setTypeSms", "agreement_ex_show", "getAgreement_ex_show", "setAgreement_ex_show", "agreement_ex_url", "getAgreement_ex_url", "setAgreement_ex_url", "appindex", "getAppindex", "setAppindex", "hive_country", "getHive_country", "setHive_country", "timezone", "Lorg/json/JSONObject;", "getTimezone", "()Lorg/json/JSONObject;", "setTimezone", "(Lorg/json/JSONObject;)V", "company", "getCompany", "setCompany", "companyName", "getCompanyName", "setCompanyName", "companyIndex", "getCompanyIndex", "setCompanyIndex", AndroidGetAdPlayerContext.KEY_GAME_ID, "getGameId", "setGameId", "oauthClientsInfo", "Lorg/json/JSONArray;", "getOauthClientsInfo", "()Lorg/json/JSONArray;", "setOauthClientsInfo", "(Lorg/json/JSONArray;)V", "primaryClientId", "getPrimaryClientId", "setPrimaryClientId", "gameIndex", "getGameIndex", "setGameIndex", "isUsedAppStoreAccountability", "setUsedAppStoreAccountability", "effectiveStatusAppStoreAccountability", "getEffectiveStatusAppStoreAccountability", "setEffectiveStatusAppStoreAccountability", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetAgreementResponse extends ActiveUser.ActiveUserResponse {
        private int agreement_ex_show;
        private String agreement_ex_url;
        private String agreement_review_url;
        private String agreement_scheme;
        private int agreement_show;
        private String agreement_url;
        private int agreement_version;
        private int appindex;
        private String company;
        private int companyIndex;
        private String companyName;
        private int effectiveStatusAppStoreAccountability;
        private String gameId;
        private String gameIndex;
        private String hive_country;
        private boolean isUsedAppStoreAccountability;
        private JSONArray oauthClientsInfo;
        private String primaryClientId;
        private JSONObject timezone;
        private boolean typeSms;
        private boolean typeTerms;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAgreementResponse(Response coreResponse) {
            String str;
            Date date;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.agreement_show = -1;
            this.agreement_version = -1;
            this.agreement_url = "";
            this.agreement_review_url = "";
            this.agreement_scheme = "";
            this.typeTerms = true;
            this.agreement_ex_show = -1;
            this.agreement_ex_url = "";
            this.appindex = -1;
            this.hive_country = "";
            this.company = "";
            this.companyName = "";
            this.gameId = "";
            this.primaryClientId = "";
            this.gameIndex = "";
            this.effectiveStatusAppStoreAccountability = -1000;
            try {
                if (!HiveTime.INSTANCE.isSetBaseTime() && (str = coreResponse.getHeader().get(HttpHeaders.DATE)) != null && (date = new SimpleDateFormat("EEE',' dd' 'MMM' 'yyyy HH':'mm':'ss zzz", Locale.US).parse(str)) != null) {
                    HiveTime.INSTANCE.setBaseTime(new Timestamp(date.getTime()));
                }
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
            }
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("agreement");
                    if (jSONObjectOptJSONObject != null) {
                        this.agreement_show = jSONObjectOptJSONObject.optInt("show");
                        this.agreement_version = jSONObjectOptJSONObject.optInt("version");
                        String strOptString = jSONObjectOptJSONObject.optString("url");
                        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                        this.agreement_url = strOptString;
                        String strOptString2 = jSONObjectOptJSONObject.optString("review_url");
                        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                        this.agreement_review_url = strOptString2;
                        String strOptString3 = jSONObjectOptJSONObject.optString("scheme");
                        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                        this.agreement_scheme = strOptString3;
                        this.typeTerms = jSONObjectOptJSONObject.optBoolean("is_show_terms");
                        this.typeSms = jSONObjectOptJSONObject.optBoolean("is_show_sms");
                    }
                    JSONObject jSONObjectOptJSONObject2 = getContentJSONObject().optJSONObject("agreement_ex");
                    if (jSONObjectOptJSONObject2 == null) {
                        this.agreement_ex_show = 0;
                    } else {
                        this.agreement_ex_show = 1;
                        String strOptString4 = jSONObjectOptJSONObject2.optString("url");
                        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                        this.agreement_ex_url = strOptString4;
                    }
                    int iOptInt = getContentJSONObject().optInt("appindex");
                    this.appindex = iOptInt;
                    Configuration.INSTANCE.setAppindex(iOptInt);
                    String strOptString5 = getContentJSONObject().optString("hive_country");
                    this.hive_country = strOptString5;
                    Configuration configuration = Configuration.INSTANCE;
                    Intrinsics.checkNotNull(strOptString5);
                    configuration.setHiveCountry(strOptString5);
                    JSONObject jSONObjectOptJSONObject3 = getContentJSONObject().optJSONObject("timezone");
                    if (jSONObjectOptJSONObject3 != null) {
                        this.timezone = jSONObjectOptJSONObject3;
                        Configuration.INSTANCE.setTimezone(jSONObjectOptJSONObject3);
                    }
                    String strOptString6 = getContentJSONObject().optString("company");
                    Intrinsics.checkNotNull(strOptString6);
                    this.company = strOptString6;
                    Configuration.INSTANCE.setCompany(strOptString6);
                    String strOptString7 = getContentJSONObject().optString("company_name");
                    Intrinsics.checkNotNull(strOptString7);
                    this.companyName = strOptString7;
                    Configuration.INSTANCE.setCompanyName(strOptString7);
                    int iOptInt2 = getContentJSONObject().optInt("company_index");
                    this.companyIndex = iOptInt2;
                    Configuration.INSTANCE.setCompanyIndex(iOptInt2);
                    String strOptString8 = getContentJSONObject().optString("game_id");
                    Intrinsics.checkNotNull(strOptString8);
                    this.gameId = strOptString8;
                    Configuration.INSTANCE.setGameId(strOptString8);
                    Configuration.INSTANCE.setMinGooglePlayServices(getContentJSONObject().optInt("min_google_play_services", 0));
                    JSONArray jSONArrayOptJSONArray = getContentJSONObject().optJSONArray("oauth_clients_info");
                    if (jSONArrayOptJSONArray != null) {
                        int length = jSONArrayOptJSONArray.length();
                        if (length >= 0) {
                            int i = 0;
                            while (true) {
                                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i);
                                if (jSONObjectOptJSONObject4 != null && Intrinsics.areEqual(jSONObjectOptJSONObject4.optString("issue_order"), AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                    String strOptString9 = jSONObjectOptJSONObject4.optString("client_id");
                                    Configuration configuration2 = Configuration.INSTANCE;
                                    Intrinsics.checkNotNull(strOptString9);
                                    configuration2.setPrimaryClientId(strOptString9);
                                    Intrinsics.checkNotNullExpressionValue(strOptString9, "also(...)");
                                    this.primaryClientId = strOptString9;
                                    String strOptString10 = jSONObjectOptJSONObject4.optString("game_index");
                                    Configuration configuration3 = Configuration.INSTANCE;
                                    Intrinsics.checkNotNull(strOptString10);
                                    configuration3.setGameIndex(strOptString10);
                                    Intrinsics.checkNotNullExpressionValue(strOptString10, "also(...)");
                                    this.gameIndex = strOptString10;
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
                    JSONObject jSONObjectOptJSONObject5 = getContentJSONObject().optJSONObject("app_store_accountability_act");
                    if (jSONObjectOptJSONObject5 != null) {
                        boolean zOptBoolean = jSONObjectOptJSONObject5.optBoolean("is_used", false);
                        Configuration.INSTANCE.setUsedAgeRange(zOptBoolean);
                        this.isUsedAppStoreAccountability = zOptBoolean;
                        int iOptInt3 = jSONObjectOptJSONObject5.optInt("effective_status", -1000);
                        Configuration.INSTANCE.setEffectiveStatusAgeRange(iOptInt3);
                        this.effectiveStatusAppStoreAccountability = iOptInt3;
                    }
                } catch (Exception e2) {
                    Logger.INSTANCE.protocolLog(e2.toString(), Logger.LogType.Warning);
                    setErrno(-1);
                    setError("[Exception] " + e2);
                }
            }
        }

        public final int getAgreement_show() {
            return this.agreement_show;
        }

        public final void setAgreement_show(int i) {
            this.agreement_show = i;
        }

        public final int getAgreement_version() {
            return this.agreement_version;
        }

        public final void setAgreement_version(int i) {
            this.agreement_version = i;
        }

        public final String getAgreement_url() {
            return this.agreement_url;
        }

        public final void setAgreement_url(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.agreement_url = str;
        }

        public final String getAgreement_review_url() {
            return this.agreement_review_url;
        }

        public final void setAgreement_review_url(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.agreement_review_url = str;
        }

        public final String getAgreement_scheme() {
            return this.agreement_scheme;
        }

        public final void setAgreement_scheme(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.agreement_scheme = str;
        }

        public final boolean getTypeTerms() {
            return this.typeTerms;
        }

        public final void setTypeTerms(boolean z) {
            this.typeTerms = z;
        }

        public final boolean getTypeSms() {
            return this.typeSms;
        }

        public final void setTypeSms(boolean z) {
            this.typeSms = z;
        }

        public final int getAgreement_ex_show() {
            return this.agreement_ex_show;
        }

        public final void setAgreement_ex_show(int i) {
            this.agreement_ex_show = i;
        }

        public final String getAgreement_ex_url() {
            return this.agreement_ex_url;
        }

        public final void setAgreement_ex_url(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.agreement_ex_url = str;
        }

        public final int getAppindex() {
            return this.appindex;
        }

        public final void setAppindex(int i) {
            this.appindex = i;
        }

        public final String getHive_country() {
            return this.hive_country;
        }

        public final void setHive_country(String str) {
            this.hive_country = str;
        }

        public final JSONObject getTimezone() {
            return this.timezone;
        }

        public final void setTimezone(JSONObject jSONObject) {
            this.timezone = jSONObject;
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

        public final String getGameId() {
            return this.gameId;
        }

        public final void setGameId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.gameId = str;
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
    }
}
