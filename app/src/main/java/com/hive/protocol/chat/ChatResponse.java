package com.hive.protocol.chat;

import com.hive.core.Logger;
import com.hive.core.Response;
import com.hive.protocol.ProtocolResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChatResponse.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/hive/protocol/chat/ChatResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "code", "", "getCode", "()I", "setCode", "(I)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "resultMessage", "getResultMessage", "setResultMessage", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChatResponse extends ProtocolResponse {
    private int code;
    private String message;
    private String resultMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatResponse(Response coreResponse) {
        super(coreResponse);
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        this.code = -1;
        this.message = "";
        try {
            this.code = getContentJSONObject().optInt("code", -1);
            String strOptString = getContentJSONObject().optString("message");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.message = strOptString;
        } catch (Exception e) {
            Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
            this.resultMessage = "[Exception] " + e;
        }
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final String getResultMessage() {
        return this.resultMessage;
    }

    public final void setResultMessage(String str) {
        this.resultMessage = str;
    }

    @Override // com.hive.core.Response
    public boolean isSuccess() {
        return this.code == 0;
    }
}
