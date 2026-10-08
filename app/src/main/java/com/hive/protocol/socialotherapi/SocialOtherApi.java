package com.hive.protocol.socialotherapi;

import com.facebook.internal.NativeProtocol;
import com.google.common.net.HttpHeaders;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Crypto;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.core.StringUtil;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;

/* JADX INFO: compiled from: SocialOtherApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0010\u001a\u00020\u0011H\u0010¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0010¢\u0006\u0002\b\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/hive/protocol/socialotherapi/SocialOtherApi;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "requestType", "", "getRequestType", "()I", "setRequestType", "(I)V", "publicKey", "", "getPublicKey", "()Ljava/lang/String;", "setPublicKey", "(Ljava/lang/String;)V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "SocialOtherApiResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SocialOtherApi extends ProtocolRequest {
    private String publicKey = "";
    private int requestType;

    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    public final int getRequestType() {
        return this.requestType;
    }

    public final void setRequestType(int i) {
        this.requestType = i;
    }

    public final String getPublicKey() {
        return this.publicKey;
    }

    public final void setPublicKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.publicKey = str;
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() throws JSONException {
        byte[] bArrEncrypt;
        byte[] base64Encode;
        int i = this.requestType;
        if (i != 1) {
            if (i == 2) {
                CommonIdentifierKt.putCI(getJsonBody());
                getCoreRequest().getHeader().put(HttpHeaders.ACCEPT, Request.ContentType.JSON.getValue());
                getCoreRequest().setContentType(Request.ContentType.TEXT_PLAIN);
                Request coreRequest = getCoreRequest();
                String string = getJsonBody().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                coreRequest.setBody(bytes);
                return super.toCoreRequest$hive_protocol_release();
            }
            CommonIdentifierKt.putCI(getJsonBody());
            getCoreRequest().getHeader().put(HttpHeaders.ACCEPT, Request.ContentType.JSON.getValue());
            getCoreRequest().setContentType(Request.ContentType.TEXT_PLAIN);
            Request coreRequest2 = getCoreRequest();
            String string2 = getJsonBody().toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            byte[] bytes2 = string2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            coreRequest2.setBody(bytes2);
            return super.toCoreRequest$hive_protocol_release();
        }
        getCoreRequest().getHeader().put(HttpHeaders.ACCEPT, Request.ContentType.JSON.getValue());
        getCoreRequest().setContentType(Request.ContentType.TEXT_PLAIN);
        try {
            Crypto crypto = Crypto.INSTANCE;
            Crypto.CryptoType cryptoType = Crypto.CryptoType.RSA;
            byte[] bytes3 = this.publicKey.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
            String string3 = getJsonBody().toString();
            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
            byte[] bytes4 = string3.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
            bArrEncrypt = crypto.encrypt(cryptoType, bytes3, bytes4, Crypto.BlockType.None, Crypto.PaddingType.PKCS1Padding);
        } catch (Exception unused) {
            Request coreRequest3 = getCoreRequest();
            String string4 = getJsonBody().toString();
            Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
            byte[] bytes5 = string4.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes5, "getBytes(...)");
            coreRequest3.setBody(bytes5);
        }
        if (bArrEncrypt != null && (base64Encode = StringUtil.INSTANCE.toBase64Encode(bArrEncrypt, 2)) != null) {
            getCoreRequest().setBody(base64Encode);
            return super.toCoreRequest$hive_protocol_release();
        }
        throw new Exception("Encrypt failed.");
    }

    /* JADX INFO: compiled from: SocialOtherApi.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/hive/protocol/socialotherapi/SocialOtherApi$SocialOtherApiResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class SocialOtherApiResponse extends ProtocolResponse {
        private int errorCode;
        private String errorMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SocialOtherApiResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.errorCode = -1;
            this.errorMsg = "";
            try {
                if (coreResponse.isSuccess()) {
                    this.errorCode = getContentJSONObject().getInt(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
                    String strOptString = getContentJSONObject().optString("error_msg");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.errorMsg = strOptString;
                }
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                this.errorCode = -1;
                this.errorMsg = "[Exception] " + e;
            }
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final void setErrorCode(int i) {
            this.errorCode = i;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public final void setErrorMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.errorMsg = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.errorCode == 0;
        }
    }
}
