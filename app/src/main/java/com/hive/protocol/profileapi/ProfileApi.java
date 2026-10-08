package com.hive.protocol.profileapi;

import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfileApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/protocol/profileapi/ProfileApi;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "ProfileApiResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ProfileApi extends ProtocolRequest {
    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a6  */
    @Override // com.hive.protocol.ProtocolRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.hive.core.Request toCoreRequest$hive_protocol_release() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.profileapi.ProfileApi.toCoreRequest$hive_protocol_release():com.hive.core.Request");
    }

    /* JADX INFO: compiled from: ProfileApi.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/hive/protocol/profileapi/ProfileApi$ProfileApiResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "resultMsg", "", "getResultMsg", "()Ljava/lang/String;", "setResultMsg", "(Ljava/lang/String;)V", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class ProfileApiResponse extends ProtocolResponse {
        private int resultCode;
        private String resultMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[Catch: Exception -> 0x0115, TryCatch #0 {Exception -> 0x0115, blocks: (B:3:0x000f, B:5:0x0015, B:7:0x0025, B:13:0x003f, B:15:0x004d, B:21:0x0068, B:24:0x006e, B:26:0x0079, B:28:0x0080, B:30:0x0088, B:32:0x0095, B:34:0x00a1, B:36:0x00a7, B:38:0x00b0, B:40:0x00bf, B:42:0x00c7, B:43:0x00cd, B:45:0x00d3, B:47:0x00ed, B:49:0x00f7, B:46:0x00de, B:20:0x005b, B:12:0x0033), top: B:54:0x000f }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005b A[Catch: Exception -> 0x0115, TryCatch #0 {Exception -> 0x0115, blocks: (B:3:0x000f, B:5:0x0015, B:7:0x0025, B:13:0x003f, B:15:0x004d, B:21:0x0068, B:24:0x006e, B:26:0x0079, B:28:0x0080, B:30:0x0088, B:32:0x0095, B:34:0x00a1, B:36:0x00a7, B:38:0x00b0, B:40:0x00bf, B:42:0x00c7, B:43:0x00cd, B:45:0x00d3, B:47:0x00ed, B:49:0x00f7, B:46:0x00de, B:20:0x005b, B:12:0x0033), top: B:54:0x000f }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00de A[Catch: Exception -> 0x0115, TryCatch #0 {Exception -> 0x0115, blocks: (B:3:0x000f, B:5:0x0015, B:7:0x0025, B:13:0x003f, B:15:0x004d, B:21:0x0068, B:24:0x006e, B:26:0x0079, B:28:0x0080, B:30:0x0088, B:32:0x0095, B:34:0x00a1, B:36:0x00a7, B:38:0x00b0, B:40:0x00bf, B:42:0x00c7, B:43:0x00cd, B:45:0x00d3, B:47:0x00ed, B:49:0x00f7, B:46:0x00de, B:20:0x005b, B:12:0x0033), top: B:54:0x000f }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ProfileApiResponse(com.hive.core.Response r15) {
            /*
                Method dump skipped, instruction units count: 308
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.profileapi.ProfileApi.ProfileApiResponse.<init>(com.hive.core.Response):void");
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public final void setResultCode(int i) {
            this.resultCode = i;
        }

        public final String getResultMsg() {
            return this.resultMsg;
        }

        public final void setResultMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.resultMsg = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.resultCode >= 0;
        }
    }
}
