package com.hive.protocol.socialapi;

import androidx.core.provider.FontsContractCompat;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.socialapi.SocialApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: ProfileGetUser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/socialapi/ProfileGetUser;", "Lcom/hive/protocol/socialapi/SocialApi;", "<init>", "()V", "value", "Lcom/hive/protocol/socialapi/ProfileGetUser$ProfileGetUserResponse;", "response", "getResponse", "()Lcom/hive/protocol/socialapi/ProfileGetUser$ProfileGetUserResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "ProfileGetUserResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileGetUser extends SocialApi {
    private ProfileGetUserResponse response;

    public ProfileGetUser() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_uid_list);
    }

    public final ProfileGetUserResponse getResponse() {
        ProfileGetUserResponse profileGetUserResponse = this.response;
        if (profileGetUserResponse != null) {
            return profileGetUserResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.ProfileApi.INSTANCE.getProfileGetUser());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new ProfileGetUserResponse(coreResponse);
    }

    /* JADX INFO: compiled from: ProfileGetUser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/socialapi/ProfileGetUser$ProfileGetUserResponse;", "Lcom/hive/protocol/socialapi/SocialApi$SocialApiResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "dataListJsonArray", "Lorg/json/JSONArray;", "getDataListJsonArray", "()Lorg/json/JSONArray;", "setDataListJsonArray", "(Lorg/json/JSONArray;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProfileGetUserResponse extends SocialApi.SocialApiResponse {
        private JSONArray dataListJsonArray;
        private int resultCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProfileGetUserResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.resultCode = -1;
            if (getContentJSONObject().optInt(FontsContractCompat.Columns.RESULT_CODE) == 0) {
                try {
                    this.dataListJsonArray = getContentJSONObject().optJSONArray("data");
                    int iOptInt = getContentJSONObject().optInt(FontsContractCompat.Columns.RESULT_CODE);
                    this.resultCode = iOptInt;
                    setErrorCode(iOptInt);
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setErrorCode(-1);
                    setErrorMsg("[Exception] " + e);
                }
            }
        }

        public final JSONArray getDataListJsonArray() {
            return this.dataListJsonArray;
        }

        public final void setDataListJsonArray(JSONArray jSONArray) {
            this.dataListJsonArray = jSONArray;
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public final void setResultCode(int i) {
            this.resultCode = i;
        }
    }
}
