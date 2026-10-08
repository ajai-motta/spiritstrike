package com.hive.protocol.activeuser;

import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveUser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/protocol/activeuser/ActiveUser;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "ActiveUserResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ActiveUser extends ProtocolRequest {
    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0097  */
    @Override // com.hive.protocol.ProtocolRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.hive.core.Request toCoreRequest$hive_protocol_release() throws org.json.JSONException {
        /*
            r12 = this;
            org.json.JSONObject r0 = r12.getJsonBody()
            com.hive.core.CommonIdentifierKt.putCI(r0)
            com.hive.core.Request r0 = r12.getCoreRequest()
            org.json.JSONObject r1 = r12.getJsonBody()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            byte[] r1 = r1.getBytes(r2)
            java.lang.String r2 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.setBody(r1)
            long r0 = java.lang.System.currentTimeMillis()
            r3 = 1000(0x3e8, float:1.401E-42)
            long r3 = (long) r3
            long r0 = r0 / r3
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.hive.core.Request r1 = r12.getCoreRequest()
            java.util.Map r1 = r1.getHeader()
            java.lang.String r3 = "REQ-TIMESTAMP"
            r1.put(r3, r0)
            com.hive.core.Crypto r1 = com.hive.core.Crypto.INSTANCE
            com.hive.core.Request r3 = r12.getCoreRequest()
            byte[] r3 = r3.getBody()
            byte[] r1 = r1.md5(r3)
            if (r1 == 0) goto L64
            com.hive.core.StringUtil r3 = com.hive.core.StringUtil.INSTANCE
            java.lang.String r1 = r3.toHexString(r1)
            if (r1 == 0) goto L64
            com.hive.core.Request r3 = r12.getCoreRequest()
            java.util.Map r3 = r3.getHeader()
            java.lang.String r4 = "REQ-AUTHKEY"
            r3.put(r4, r1)
        L64:
            com.hive.core.Crypto r1 = com.hive.core.Crypto.INSTANCE
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8
            byte[] r0 = r0.getBytes(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            byte[] r0 = r1.md5(r0)
            r1 = 0
            r3 = 0
            if (r0 == 0) goto L97
            com.hive.core.StringUtil r4 = com.hive.core.StringUtil.INSTANCE
            java.lang.String r0 = r4.toHexString(r0)
            if (r0 == 0) goto L97
            r4 = 16
            java.lang.String r0 = r0.substring(r1, r4)
            java.lang.String r4 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            if (r0 == 0) goto L97
            java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
            byte[] r0 = r0.getBytes(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r6 = r0
            goto L98
        L97:
            r6 = r3
        L98:
            com.hive.core.Crypto r4 = com.hive.core.Crypto.INSTANCE
            com.hive.core.Crypto$CryptoType r5 = com.hive.core.Crypto.CryptoType.AES128
            com.hive.core.Request r0 = r12.getCoreRequest()
            byte[] r7 = r0.getBody()
            r10 = 24
            r11 = 0
            r8 = 0
            r9 = 0
            byte[] r0 = com.hive.core.Crypto.encrypt$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r0 == 0) goto Lbf
            com.hive.core.StringUtil r2 = com.hive.core.StringUtil.INSTANCE
            r4 = 1
            byte[] r0 = com.hive.core.StringUtil.toBase64Encode$default(r2, r0, r1, r4, r3)
            if (r0 == 0) goto Lbf
            com.hive.core.Request r1 = r12.getCoreRequest()
            r1.setBody(r0)
        Lbf:
            com.hive.core.Request r0 = super.toCoreRequest$hive_protocol_release()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.activeuser.ActiveUser.toCoreRequest$hive_protocol_release():com.hive.core.Request");
    }

    /* JADX INFO: compiled from: ActiveUser.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/hive/protocol/activeuser/ActiveUser$ActiveUserResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "errno", "", "getErrno", "()I", "setErrno", "(I)V", "error", "", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class ActiveUserResponse extends ProtocolResponse {
        private int errno;
        private String error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a5 A[Catch: Exception -> 0x00dc, TryCatch #0 {Exception -> 0x00dc, blocks: (B:3:0x000f, B:5:0x0015, B:8:0x0034, B:10:0x003f, B:12:0x0046, B:14:0x004e, B:16:0x005b, B:18:0x0067, B:20:0x006d, B:22:0x0077, B:24:0x0086, B:26:0x008e, B:27:0x0094, B:29:0x009a, B:31:0x00b4, B:33:0x00be, B:30:0x00a5), top: B:38:0x000f }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ActiveUserResponse(com.hive.core.Response r15) {
            /*
                Method dump skipped, instruction units count: 251
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.activeuser.ActiveUser.ActiveUserResponse.<init>(com.hive.core.Response):void");
        }

        public final int getErrno() {
            return this.errno;
        }

        public final void setErrno(int i) {
            this.errno = i;
        }

        public final String getError() {
            return this.error;
        }

        public final void setError(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.error = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.errno >= 0;
        }
    }
}
