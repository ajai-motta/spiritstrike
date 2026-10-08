package com.hive.protocol.provision;

import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Provision.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/protocol/provision/Provision;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "ProvisionResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Provision extends ProtocolRequest {
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
        throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.provision.Provision.toCoreRequest$hive_protocol_release():com.hive.core.Request");
    }

    /* JADX INFO: compiled from: Provision.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/hive/protocol/provision/Provision$ProvisionResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "resultMsg", "", "getResultMsg", "()Ljava/lang/String;", "setResultMsg", "(Ljava/lang/String;)V", "isSuccess", "", "convertProvisionFlagResponse", "data", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class ProvisionResponse extends ProtocolResponse {
        private int resultCode;
        private String resultMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[Catch: Exception -> 0x0115, TryCatch #0 {Exception -> 0x0115, blocks: (B:4:0x0015, B:6:0x0025, B:12:0x003f, B:14:0x004d, B:20:0x0068, B:23:0x006e, B:25:0x0079, B:27:0x0080, B:29:0x0088, B:31:0x0095, B:33:0x00a1, B:35:0x00a7, B:37:0x00b0, B:39:0x00bf, B:41:0x00c7, B:42:0x00cd, B:44:0x00d3, B:46:0x00ed, B:48:0x00f7, B:45:0x00de, B:19:0x005b, B:11:0x0033), top: B:53:0x0015 }] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[Catch: Exception -> 0x0115, TryCatch #0 {Exception -> 0x0115, blocks: (B:4:0x0015, B:6:0x0025, B:12:0x003f, B:14:0x004d, B:20:0x0068, B:23:0x006e, B:25:0x0079, B:27:0x0080, B:29:0x0088, B:31:0x0095, B:33:0x00a1, B:35:0x00a7, B:37:0x00b0, B:39:0x00bf, B:41:0x00c7, B:42:0x00cd, B:44:0x00d3, B:46:0x00ed, B:48:0x00f7, B:45:0x00de, B:19:0x005b, B:11:0x0033), top: B:53:0x0015 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00de A[Catch: Exception -> 0x0115, TryCatch #0 {Exception -> 0x0115, blocks: (B:4:0x0015, B:6:0x0025, B:12:0x003f, B:14:0x004d, B:20:0x0068, B:23:0x006e, B:25:0x0079, B:27:0x0080, B:29:0x0088, B:31:0x0095, B:33:0x00a1, B:35:0x00a7, B:37:0x00b0, B:39:0x00bf, B:41:0x00c7, B:42:0x00cd, B:44:0x00d3, B:46:0x00ed, B:48:0x00f7, B:45:0x00de, B:19:0x005b, B:11:0x0033), top: B:53:0x0015 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ProvisionResponse(com.hive.core.Response r15) {
            /*
                Method dump skipped, instruction units count: 308
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.protocol.provision.Provision.ProvisionResponse.<init>(com.hive.core.Response):void");
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
            return this.resultCode == 0;
        }

        public boolean convertProvisionFlagResponse(String data) {
            String lowerCase;
            int iHashCode;
            if (data != null) {
                lowerCase = data.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            return lowerCase != null && ((iHashCode = lowerCase.hashCode()) == 49 ? lowerCase.equals("1") : iHashCode == 116 ? lowerCase.equals("t") : iHashCode == 121 ? lowerCase.equals("y") : iHashCode == 3569038 && lowerCase.equals("true"));
        }
    }
}
