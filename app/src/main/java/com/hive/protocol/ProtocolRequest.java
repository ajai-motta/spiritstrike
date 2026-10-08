package com.hive.protocol;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.OauthToken;
import com.hive.core.Request;
import com.hive.core.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProtocolRequest.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\u001f\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\u0017J\u001f\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\u0017J\u0017\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\b\u001aJ\u0017\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\u001cH\u0000¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b#J\u0015\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0013H\u0000¢\u0006\u0002\b#J\u0015\u0010$\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b%J\u0015\u0010$\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0013H\u0000¢\u0006\u0002\b%J\r\u0010&\u001a\u00020\u0005H\u0010¢\u0006\u0002\b'J\u0015\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*H\u0010¢\u0006\u0002\b+J\b\u0010,\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/hive/protocol/ProtocolRequest;", "", "<init>", "()V", "coreRequest", "Lcom/hive/core/Request;", "getCoreRequest", "()Lcom/hive/core/Request;", "jsonBody", "Lorg/json/JSONObject;", "getJsonBody", "()Lorg/json/JSONObject;", "oauthToken", "Lcom/hive/core/OauthToken;", "setHeader", "", "key", "Lcom/hive/core/HiveKeys;", "value", "", "setHeader$hive_protocol_release", "name", "setParam", "setParam$hive_protocol_release", "setOauthToken", "token", "setOauthToken$hive_protocol_release", "isExpireOauthToken", "", "margin", "", "isExpireOauthToken$hive_protocol_release", "refreshOauthToken", "refreshOauthToken$hive_protocol_release", "hasParam", "hasParam$hive_protocol_release", "isNull", "isNull$hive_protocol_release", "toCoreRequest", "toCoreRequest$hive_protocol_release", "toResponse", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", InAppPurchaseConstants.METHOD_TO_STRING, "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ProtocolRequest {
    private final Request coreRequest;
    private final JSONObject jsonBody;
    private OauthToken oauthToken;

    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    public ProtocolRequest() {
        Request request = new Request();
        request.getHeader().put("HiveProtocol-Agent", "Hive_Protocol_v26.2.0");
        request.setSendObserver(true);
        this.coreRequest = request;
        this.jsonBody = new JSONObject();
        setOauthToken$hive_protocol_release(OauthToken.INSTANCE.getCurrentOauthToken());
    }

    public final Request getCoreRequest() {
        return this.coreRequest;
    }

    protected final JSONObject getJsonBody() {
        return this.jsonBody;
    }

    public final void setHeader$hive_protocol_release(HiveKeys key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        setHeader$hive_protocol_release(key.getValue(), value);
    }

    public final void setHeader$hive_protocol_release(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.coreRequest.getHeader().put(name, value);
    }

    public final void setParam$hive_protocol_release(HiveKeys key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        CommonIdentifierKt.put(this.jsonBody, key, value);
    }

    public final void setParam$hive_protocol_release(String name, Object value) throws JSONException {
        Intrinsics.checkNotNullParameter(name, "name");
        CommonIdentifierKt.putCheck(this.jsonBody, name, value);
    }

    public final void setOauthToken$hive_protocol_release(OauthToken token) {
        String accessToken;
        if (token != null && (accessToken = token.getAccessToken()) != null) {
            this.oauthToken = token;
            setHeader$hive_protocol_release(HiveKeys.KEY_X_Access_Token, accessToken);
        } else {
            this.coreRequest.getHeader().remove(HiveKeys.KEY_X_Access_Token.getValue());
        }
    }

    public static /* synthetic */ boolean isExpireOauthToken$hive_protocol_release$default(ProtocolRequest protocolRequest, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isExpireOauthToken");
        }
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return protocolRequest.isExpireOauthToken$hive_protocol_release(i);
    }

    public final boolean isExpireOauthToken$hive_protocol_release(int margin) {
        OauthToken oauthToken = this.oauthToken;
        if (oauthToken != null) {
            return oauthToken.isExpire(margin);
        }
        return false;
    }

    public final boolean refreshOauthToken$hive_protocol_release() {
        OauthToken oauthToken = this.oauthToken;
        if (oauthToken == null || !oauthToken.refresh()) {
            oauthToken = null;
        }
        setOauthToken$hive_protocol_release(oauthToken);
        return this.oauthToken != null;
    }

    public final boolean hasParam$hive_protocol_release(HiveKeys key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.jsonBody.has(key.getValue());
    }

    public final boolean hasParam$hive_protocol_release(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.jsonBody.has(name);
    }

    public final boolean isNull$hive_protocol_release(HiveKeys key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.jsonBody.isNull(key.getValue());
    }

    public final boolean isNull$hive_protocol_release(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.jsonBody.isNull(name);
    }

    public Request toCoreRequest$hive_protocol_release() {
        try {
            this.coreRequest.setLogBody(this.jsonBody.toString(4));
        } catch (Exception unused) {
        }
        return this.coreRequest;
    }

    public String toString() {
        return this.coreRequest.toString();
    }
}
