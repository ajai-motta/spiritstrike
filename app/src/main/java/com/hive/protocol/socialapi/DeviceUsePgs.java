package com.hive.protocol.socialapi;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Response;
import com.hive.protocol.socialapi.SocialApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceUsePgs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/socialapi/DeviceUsePgs;", "Lcom/hive/protocol/socialapi/SocialApi;", "<init>", "()V", "value", "Lcom/hive/protocol/socialapi/DeviceUsePgs$DeviceUsePgsResponse;", "response", "getResponse", "()Lcom/hive/protocol/socialapi/DeviceUsePgs$DeviceUsePgsResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "DeviceUsePgsResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceUsePgs extends SocialApi {
    private DeviceUsePgsResponse response;

    public DeviceUsePgs() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_retrypgs);
    }

    public final DeviceUsePgsResponse getResponse() {
        DeviceUsePgsResponse deviceUsePgsResponse = this.response;
        if (deviceUsePgsResponse != null) {
            return deviceUsePgsResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0083  */
    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.hive.core.Request toCoreRequest$hive_protocol_release() throws org.json.JSONException {
        /*
            r12 = this;
            com.hive.core.Request r0 = r12.getCoreRequest()
            com.hive.protocol.UrlManager$SocialApi r1 = com.hive.protocol.UrlManager.SocialApi.INSTANCE
            java.lang.String r1 = r1.getDeviceUsePGS()
            r0.setUrl(r1)
            super.toCoreRequest$hive_protocol_release()
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1000(0x3e8, float:1.401E-42)
            long r2 = (long) r2
            long r0 = r0 / r2
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.hive.core.Request r1 = r12.getCoreRequest()
            java.util.Map r1 = r1.getHeader()
            java.lang.String r2 = "REQ-TIMESTAMP"
            r1.put(r2, r0)
            com.hive.core.Crypto r1 = com.hive.core.Crypto.INSTANCE
            com.hive.core.Request r2 = r12.getCoreRequest()
            byte[] r2 = r2.getBody()
            byte[] r1 = r1.md5(r2)
            if (r1 == 0) goto L4e
            com.hive.core.StringUtil r2 = com.hive.core.StringUtil.INSTANCE
            java.lang.String r1 = r2.toHexString(r1)
            if (r1 == 0) goto L4e
            com.hive.core.Request r2 = r12.getCoreRequest()
            java.util.Map r2 = r2.getHeader()
            java.lang.String r3 = "REQ-AUTHKEY"
            r2.put(r3, r1)
        L4e:
            com.hive.core.Crypto r1 = com.hive.core.Crypto.INSTANCE
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            byte[] r0 = r0.getBytes(r2)
            java.lang.String r2 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            byte[] r0 = r1.md5(r0)
            r1 = 0
            r3 = 0
            if (r0 == 0) goto L83
            com.hive.core.StringUtil r4 = com.hive.core.StringUtil.INSTANCE
            java.lang.String r0 = r4.toHexString(r0)
            if (r0 == 0) goto L83
            r4 = 16
            java.lang.String r0 = r0.substring(r1, r4)
            java.lang.String r4 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            if (r0 == 0) goto L83
            java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
            byte[] r0 = r0.getBytes(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r6 = r0
            goto L84
        L83:
            r6 = r3
        L84:
            com.hive.core.Crypto r4 = com.hive.core.Crypto.INSTANCE
            com.hive.core.Crypto$CryptoType r5 = com.hive.core.Crypto.CryptoType.AES128
            com.hive.core.Request r0 = r12.getCoreRequest()
            byte[] r7 = r0.getBody()
            r10 = 24
            r11 = 0
            r8 = 0
            r9 = 0
            byte[] r0 = com.hive.core.Crypto.encrypt$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r0 == 0) goto Lab
            com.hive.core.StringUtil r2 = com.hive.core.StringUtil.INSTANCE
            r4 = 1
            byte[] r0 = com.hive.core.StringUtil.toBase64Encode$default(r2, r0, r1, r4, r3)
            if (r0 == 0) goto Lab
            com.hive.core.Request r1 = r12.getCoreRequest()
            r1.setBody(r0)
        Lab:
            com.hive.core.Request r0 = r12.getCoreRequest()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.socialapi.DeviceUsePgs.toCoreRequest$hive_protocol_release():com.hive.core.Request");
    }

    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new DeviceUsePgsResponse(coreResponse);
    }

    /* JADX INFO: compiled from: DeviceUsePgs.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/socialapi/DeviceUsePgs$DeviceUsePgsResponse;", "Lcom/hive/protocol/socialapi/SocialApi$SocialApiResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "usePgs", "", "getUsePgs", "()Z", "setUsePgs", "(Z)V", "maxRetryPgs", "", "getMaxRetryPgs", "()I", "setMaxRetryPgs", "(I)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeviceUsePgsResponse extends SocialApi.SocialApiResponse {
        private int maxRetryPgs;
        private boolean usePgs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a0 A[Catch: Exception -> 0x00f9, TryCatch #0 {Exception -> 0x00f9, blocks: (B:3:0x000b, B:5:0x0011, B:8:0x0030, B:10:0x003b, B:12:0x0042, B:14:0x004a, B:16:0x0057, B:18:0x0063, B:20:0x0069, B:22:0x0072, B:24:0x0081, B:26:0x0089, B:27:0x008f, B:29:0x0095, B:31:0x00b1, B:33:0x00bb, B:35:0x00e0, B:30:0x00a0), top: B:40:0x000b }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public DeviceUsePgsResponse(com.hive.core.Response r14) {
            /*
                Method dump skipped, instruction units count: 283
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.socialapi.DeviceUsePgs.DeviceUsePgsResponse.<init>(com.hive.core.Response):void");
        }

        public final boolean getUsePgs() {
            return this.usePgs;
        }

        public final void setUsePgs(boolean z) {
            this.usePgs = z;
        }

        public final int getMaxRetryPgs() {
            return this.maxRetryPgs;
        }

        public final void setMaxRetryPgs(int i) {
            this.maxRetryPgs = i;
        }
    }
}
