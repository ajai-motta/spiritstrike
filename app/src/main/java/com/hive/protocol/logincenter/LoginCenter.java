package com.hive.protocol.logincenter;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginCenter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/protocol/logincenter/LoginCenter;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "LoginCenterResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LoginCenter extends ProtocolRequest {
    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    public LoginCenter() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_hive_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_timezone);
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
            java.lang.String r3 = "Timestamp"
            r1.put(r3, r0)
            com.hive.core.Crypto r1 = com.hive.core.Crypto.INSTANCE
            com.hive.core.Request r3 = r12.getCoreRequest()
            byte[] r3 = r3.getBody()
            byte[] r1 = r1.sha1(r3)
            if (r1 == 0) goto L64
            com.hive.core.StringUtil r3 = com.hive.core.StringUtil.INSTANCE
            java.lang.String r1 = r3.toHexString(r1)
            if (r1 == 0) goto L64
            com.hive.core.Request r3 = r12.getCoreRequest()
            java.util.Map r3 = r3.getHeader()
            java.lang.String r4 = "Hash"
            r3.put(r4, r1)
        L64:
            com.hive.core.Crypto r1 = com.hive.core.Crypto.INSTANCE
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8
            byte[] r0 = r0.getBytes(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            byte[] r0 = r1.sha1(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.logincenter.LoginCenter.toCoreRequest$hive_protocol_release():com.hive.core.Request");
    }

    /* JADX INFO: compiled from: LoginCenter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010'\u001a\u00020(H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001a\u0010$\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011¨\u0006)"}, d2 = {"Lcom/hive/protocol/logincenter/LoginCenter$LoginCenterResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "errno", "", "getErrno", "()I", "setErrno", "(I)V", "error", "", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "block_title", "getBlock_title", "setBlock_title", "block_message", "getBlock_message", "setBlock_message", "block_html_message", "getBlock_html_message", "setBlock_html_message", "block_button", "getBlock_button", "setBlock_button", "block_action", "getBlock_action", "setBlock_action", "block_customerButton", "getBlock_customerButton", "setBlock_customerButton", "block_customerLink", "getBlock_customerLink", "setBlock_customerLink", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class LoginCenterResponse extends ProtocolResponse {
        private int block_action;
        private String block_button;
        private String block_customerButton;
        private String block_customerLink;
        private String block_html_message;
        private String block_message;
        private String block_title;
        private int errno;
        private String error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0049 A[Catch: Exception -> 0x0187, TryCatch #0 {Exception -> 0x0187, blocks: (B:3:0x0025, B:5:0x002b, B:7:0x003b, B:13:0x0055, B:15:0x0063, B:21:0x007e, B:24:0x0084, B:26:0x008f, B:28:0x0096, B:30:0x009e, B:32:0x00ab, B:34:0x00b7, B:36:0x00bd, B:38:0x00c6, B:40:0x00d7, B:42:0x00df, B:43:0x00e5, B:45:0x00eb, B:47:0x0105, B:49:0x010f, B:51:0x0130, B:53:0x013c, B:46:0x00f6, B:20:0x0071, B:12:0x0049), top: B:58:0x0025 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[Catch: Exception -> 0x0187, TryCatch #0 {Exception -> 0x0187, blocks: (B:3:0x0025, B:5:0x002b, B:7:0x003b, B:13:0x0055, B:15:0x0063, B:21:0x007e, B:24:0x0084, B:26:0x008f, B:28:0x0096, B:30:0x009e, B:32:0x00ab, B:34:0x00b7, B:36:0x00bd, B:38:0x00c6, B:40:0x00d7, B:42:0x00df, B:43:0x00e5, B:45:0x00eb, B:47:0x0105, B:49:0x010f, B:51:0x0130, B:53:0x013c, B:46:0x00f6, B:20:0x0071, B:12:0x0049), top: B:58:0x0025 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f6 A[Catch: Exception -> 0x0187, TryCatch #0 {Exception -> 0x0187, blocks: (B:3:0x0025, B:5:0x002b, B:7:0x003b, B:13:0x0055, B:15:0x0063, B:21:0x007e, B:24:0x0084, B:26:0x008f, B:28:0x0096, B:30:0x009e, B:32:0x00ab, B:34:0x00b7, B:36:0x00bd, B:38:0x00c6, B:40:0x00d7, B:42:0x00df, B:43:0x00e5, B:45:0x00eb, B:47:0x0105, B:49:0x010f, B:51:0x0130, B:53:0x013c, B:46:0x00f6, B:20:0x0071, B:12:0x0049), top: B:58:0x0025 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public LoginCenterResponse(com.hive.core.Response r20) {
            /*
                Method dump skipped, instruction units count: 422
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.logincenter.LoginCenter.LoginCenterResponse.<init>(com.hive.core.Response):void");
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

        public final String getBlock_title() {
            return this.block_title;
        }

        public final void setBlock_title(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.block_title = str;
        }

        public final String getBlock_message() {
            return this.block_message;
        }

        public final void setBlock_message(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.block_message = str;
        }

        public final String getBlock_html_message() {
            return this.block_html_message;
        }

        public final void setBlock_html_message(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.block_html_message = str;
        }

        public final String getBlock_button() {
            return this.block_button;
        }

        public final void setBlock_button(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.block_button = str;
        }

        public final int getBlock_action() {
            return this.block_action;
        }

        public final void setBlock_action(int i) {
            this.block_action = i;
        }

        public final String getBlock_customerButton() {
            return this.block_customerButton;
        }

        public final void setBlock_customerButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.block_customerButton = str;
        }

        public final String getBlock_customerLink() {
            return this.block_customerLink;
        }

        public final void setBlock_customerLink(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.block_customerLink = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            int i = this.errno;
            return i == 0 || i == 2300;
        }
    }
}
