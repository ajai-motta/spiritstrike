package com.hive.protocol.socialfriendapi;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.socialfriendapi.SocialFriendApi;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddressBookSync.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "GCPSDK-294")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/socialfriendapi/AddressBookSync;", "Lcom/hive/protocol/socialfriendapi/SocialFriendApi;", "<init>", "()V", "value", "Lcom/hive/protocol/socialfriendapi/AddressBookSync$AddressBookSyncResponse;", "response", "getResponse", "()Lcom/hive/protocol/socialfriendapi/AddressBookSync$AddressBookSyncResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "AddressBookSyncResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddressBookSync extends SocialFriendApi {
    private AddressBookSyncResponse response;

    public AddressBookSync() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_address);
    }

    public final AddressBookSyncResponse getResponse() {
        AddressBookSyncResponse addressBookSyncResponse = this.response;
        if (addressBookSyncResponse != null) {
            return addressBookSyncResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.socialfriendapi.SocialFriendApi, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.SocialFriendApi.INSTANCE.getAddressBookSync());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.socialfriendapi.SocialFriendApi, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new AddressBookSyncResponse(coreResponse);
    }

    /* JADX INFO: compiled from: AddressBookSync.kt */
    @Deprecated(message = "GCPSDK-294")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/protocol/socialfriendapi/AddressBookSync$AddressBookSyncResponse;", "Lcom/hive/protocol/socialfriendapi/SocialFriendApi$SocialFriendApiResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AddressBookSyncResponse extends SocialFriendApi.SocialFriendApiResponse {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddressBookSyncResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        }
    }
}
