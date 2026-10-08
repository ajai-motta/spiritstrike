package com.hive.protocol.datastore;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Crypto;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.core.StringUtil;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DataStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\n\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/hive/protocol/datastore/DataStore;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "publicKey", "", "getPublicKey", "()Ljava/lang/String;", "setPublicKey", "(Ljava/lang/String;)V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "DataStoreResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DataStore extends ProtocolRequest {
    private String publicKey;

    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    public final String getPublicKey() {
        return this.publicKey;
    }

    public final void setPublicKey(String str) {
        this.publicKey = str;
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() throws JSONException {
        byte[] bytes;
        byte[] base64Encode;
        CommonIdentifierKt.putCI(getJsonBody());
        getCoreRequest().setContentType(Request.ContentType.JSON);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        int iNextInt = Random.INSTANCE.nextInt(0, 1000);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_timestamp, Long.valueOf(jCurrentTimeMillis));
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_nonce, Integer.valueOf(iNextInt));
        JSONObject jSONObject = new JSONObject();
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_player_id, getJsonBody().optString(HiveKeys.KEY_player_id.getValue()));
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_did, getJsonBody().optString(HiveKeys.KEY_did.getValue()));
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_token, getJsonBody().optString(HiveKeys.KEY_token.getValue()));
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_timestamp, Long.valueOf(jCurrentTimeMillis));
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_nonce, Integer.valueOf(iNextInt));
        Crypto crypto = Crypto.INSTANCE;
        Crypto.CryptoType cryptoType = Crypto.CryptoType.RSA;
        String str = this.publicKey;
        if (str != null) {
            bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        } else {
            bytes = null;
        }
        byte[] bArr = bytes;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes2 = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byte[] bArrEncrypt = crypto.encrypt(cryptoType, bArr, bytes2, Crypto.BlockType.ECB, Crypto.PaddingType.PKCS1Padding);
        if (bArrEncrypt != null && (base64Encode = StringUtil.INSTANCE.toBase64Encode(bArrEncrypt, 2)) != null) {
            getCoreRequest().getHeader().put("Signing", new String(base64Encode, Charsets.UTF_8));
        }
        Request coreRequest = getCoreRequest();
        String string2 = getJsonBody().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        byte[] bytes3 = string2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        coreRequest.setBody(bytes3);
        return super.toCoreRequest$hive_protocol_release();
    }

    /* JADX INFO: compiled from: DataStore.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/hive/protocol/datastore/DataStore$DataStoreResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "msgCode", "", "getMsgCode", "()I", "setMsgCode", "(I)V", NotificationCompat.CATEGORY_MESSAGE, "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class DataStoreResponse extends ProtocolResponse {
        private JSONObject data;
        private String msg;
        private int msgCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DataStoreResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.msgCode = -1;
            this.msg = "";
            try {
                if (coreResponse.isSuccess()) {
                    this.msgCode = getContentJSONObject().getInt("msg_code");
                    String strOptString = getContentJSONObject().optString(NotificationCompat.CATEGORY_MESSAGE);
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.msg = strOptString;
                    if (this.msgCode == 0) {
                        this.data = getContentJSONObject().optJSONObject("data");
                    }
                } else {
                    String strOptString2 = getContentJSONObject().optString(ProductAction.ACTION_DETAIL);
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    this.msg = strOptString2;
                }
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                this.msgCode = -1;
                this.msg = "[Exception] " + e;
            }
        }

        public final int getMsgCode() {
            return this.msgCode;
        }

        public final void setMsgCode(int i) {
            this.msgCode = i;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final void setMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.msg = str;
        }

        public final JSONObject getData() {
            return this.data;
        }

        public final void setData(JSONObject jSONObject) {
            this.data = jSONObject;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.msgCode == 0;
        }
    }
}
