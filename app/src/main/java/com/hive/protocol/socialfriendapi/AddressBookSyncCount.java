package com.hive.protocol.socialfriendapi;

import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.socialfriendapi.SocialFriendApi;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: AddressBookSyncCount.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "GCPSDK-294")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/socialfriendapi/AddressBookSyncCount;", "Lcom/hive/protocol/socialfriendapi/SocialFriendApi;", "<init>", "()V", "value", "Lcom/hive/protocol/socialfriendapi/AddressBookSyncCount$AddressBookSyncCountResponse;", "response", "getResponse", "()Lcom/hive/protocol/socialfriendapi/AddressBookSyncCount$AddressBookSyncCountResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "AddressBookSyncCountResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddressBookSyncCount extends SocialFriendApi {
    private AddressBookSyncCountResponse response;

    public final AddressBookSyncCountResponse getResponse() {
        AddressBookSyncCountResponse addressBookSyncCountResponse = this.response;
        if (addressBookSyncCountResponse != null) {
            return addressBookSyncCountResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.socialfriendapi.SocialFriendApi, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.SocialFriendApi.INSTANCE.getAddressBookSyncCount());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.socialfriendapi.SocialFriendApi, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new AddressBookSyncCountResponse(coreResponse);
    }

    /* JADX INFO: compiled from: AddressBookSyncCount.kt */
    @Deprecated(message = "GCPSDK-294")
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/hive/protocol/socialfriendapi/AddressBookSyncCount$AddressBookSyncCountResponse;", "Lcom/hive/protocol/socialfriendapi/SocialFriendApi$SocialFriendApiResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "isMdn", "", "()Z", "setMdn", "(Z)V", "syncCount", "", "getSyncCount", "()I", "setSyncCount", "(I)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AddressBookSyncCountResponse extends SocialFriendApi.SocialFriendApiResponse {
        private boolean isMdn;
        private int syncCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddressBookSyncCountResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        this.isMdn = jSONObjectOptJSONObject.optBoolean("is_mdn");
                        this.syncCount = jSONObjectOptJSONObject.optInt("sync_count");
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setErrorCode(-1);
                    setErrorMsg("[Exception] " + e);
                }
            }
        }

        /* JADX INFO: renamed from: isMdn, reason: from getter */
        public final boolean getIsMdn() {
            return this.isMdn;
        }

        public final void setMdn(boolean z) {
            this.isMdn = z;
        }

        public final int getSyncCount() {
            return this.syncCount;
        }

        public final void setSyncCount(int i) {
            this.syncCount = i;
        }
    }
}
