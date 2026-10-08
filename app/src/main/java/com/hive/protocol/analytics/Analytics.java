package com.hive.protocol.analytics;

import com.google.common.net.HttpHeaders;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Crypto;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: Analytics.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/protocol/analytics/Analytics;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "AnalyticsResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Analytics extends ProtocolRequest {
    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() throws JSONException {
        Object objM7415constructorimpl;
        getCoreRequest().setSendObserver(false);
        getCoreRequest().setPrintNetworkLog(false);
        getCoreRequest().setContentType(Request.ContentType.JSON);
        getCoreRequest().getHeader().put(HttpHeaders.ACCEPT_ENCODING, Request.ContentType.GZIP.getValue());
        getCoreRequest().getHeader().put(HttpHeaders.CONTENT_ENCODING, Request.ContentType.GZIP.getValue());
        CommonIdentifierKt.putCI(getJsonBody());
        try {
            Result.Companion companion = Result.INSTANCE;
            Crypto crypto = Crypto.INSTANCE;
            String string = getJsonBody().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            objM7415constructorimpl = Result.m7415constructorimpl(crypto.gzip(string));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7422isSuccessimpl(objM7415constructorimpl)) {
            getCoreRequest().setBody((byte[]) objM7415constructorimpl);
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.w("HiveProtocol", "[HiveProtocol - Analytics] gzip is failed.\nThrowable: " + thM7418exceptionOrNullimpl.getMessage());
        }
        return super.toCoreRequest$hive_protocol_release();
    }

    /* JADX INFO: compiled from: Analytics.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/hive/protocol/analytics/Analytics$AnalyticsResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "isSuccess", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class AnalyticsResponse extends ProtocolResponse {
        private String message;
        private boolean success;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnalyticsResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            try {
                if (coreResponse.isSuccess()) {
                    this.success = getContentJSONObject().optBoolean("success", false);
                    Object objOpt = getContentJSONObject().opt("message");
                    this.message = objOpt instanceof String ? (String) objOpt : null;
                }
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                this.success = false;
                this.message = "[Exception] " + e;
            }
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final void setSuccess(boolean z) {
            this.success = z;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.success;
        }
    }
}
