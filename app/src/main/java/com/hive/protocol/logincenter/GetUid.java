package com.hive.protocol.logincenter;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.logincenter.LoginCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: GetUid.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/logincenter/GetUid;", "Lcom/hive/protocol/logincenter/LoginCenter;", "<init>", "()V", "value", "Lcom/hive/protocol/logincenter/GetUid$GetUidResponse;", "response", "getResponse", "()Lcom/hive/protocol/logincenter/GetUid$GetUidResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "GetUidResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetUid extends LoginCenter {
    private GetUidResponse response;

    public GetUid() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_sessionkey);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_platform);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid_list);
    }

    public final GetUidResponse getResponse() {
        GetUidResponse getUidResponse = this.response;
        if (getUidResponse != null) {
            return getUidResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.logincenter.LoginCenter, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.LoginCenter.INSTANCE.getGetUid());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.logincenter.LoginCenter, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new GetUidResponse(coreResponse);
    }

    /* JADX INFO: compiled from: GetUid.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/hive/protocol/logincenter/GetUid$GetUidResponse;", "Lcom/hive/protocol/logincenter/LoginCenter$LoginCenterResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "uidList", "", "", "getUidList", "()Ljava/util/List;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetUidResponse extends LoginCenter.LoginCenterResponse {
        private final List<String> uidList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetUidResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.uidList = new ArrayList();
            if (isSuccess()) {
                try {
                    JSONArray jSONArrayOptJSONArray = getContentJSONObject().optJSONArray("uid_list");
                    if (jSONArrayOptJSONArray != null) {
                        int length = jSONArrayOptJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            List<String> list = this.uidList;
                            String strOptString = jSONArrayOptJSONArray.optString(i);
                            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                            list.add(strOptString);
                        }
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setErrno(-1);
                    setError("[Exception] " + e);
                }
            }
        }

        public final List<String> getUidList() {
            return this.uidList;
        }
    }
}
