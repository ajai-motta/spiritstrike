package com.hive.protocol;

import com.hive.core.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProtocolResponse.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/ProtocolResponse;", "Lcom/hive/core/Response;", "coreResponse", "<init>", "(Lcom/hive/core/Response;)V", "value", "", "contentString", "getContentString", "()Ljava/lang/String;", "setContentString", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "contentJSONObject", "getContentJSONObject", "()Lorg/json/JSONObject;", "setContentJSONObject", "(Lorg/json/JSONObject;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ProtocolResponse extends Response {
    private JSONObject contentJSONObject;
    private String contentString;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProtocolResponse(Response coreResponse) {
        JSONObject jSONObject;
        super(coreResponse);
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        byte[] content = getContent();
        this.contentString = content != null ? new String(content, Charsets.UTF_8) : "";
        try {
            jSONObject = new JSONObject(this.contentString);
            setLogContent(jSONObject.toString(4));
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        this.contentJSONObject = jSONObject;
    }

    public final String getContentString() {
        return this.contentString;
    }

    protected final void setContentString(String value) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(value, "value");
        this.contentString = value;
        try {
            jSONObject = new JSONObject(value);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        setContentJSONObject(jSONObject);
    }

    public final JSONObject getContentJSONObject() {
        return this.contentJSONObject;
    }

    private final void setContentJSONObject(JSONObject jSONObject) {
        String string;
        this.contentJSONObject = jSONObject;
        try {
            string = jSONObject.toString(4);
        } catch (Exception unused) {
            string = null;
        }
        setLogContent(string);
    }
}
