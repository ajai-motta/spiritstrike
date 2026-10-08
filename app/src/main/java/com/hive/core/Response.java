package com.hive.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u0010J\b\u0010K\u001a\u00020FH\u0016J\b\u0010L\u001a\u00020FH\u0016J\b\u0010M\u001a\u00020\u0006H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001a\u0010.\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001a\u00101\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001a\u00109\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R\u001a\u0010<\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00103\"\u0004\b>\u00105R\u001a\u0010?\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\u001a\u0010B\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00103\"\u0004\bD\u00105R\u000e\u0010E\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010H\u001a\u0004\u0018\u00010\u00062\b\u0010G\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00103\"\u0004\bJ\u00105¨\u0006N"}, d2 = {"Lcom/hive/core/Response;", "", "httpStatusCode", "", "header", "", "", "content", "", "request", "Lcom/hive/core/Request;", "result", "Lcom/hive/core/Result;", "<init>", "(ILjava/util/Map;[BLcom/hive/core/Request;Lcom/hive/core/Result;)V", "response", "(Lcom/hive/core/Response;)V", "getHttpStatusCode", "()I", "setHttpStatusCode", "(I)V", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "getContent", "()[B", "setContent", "([B)V", "getRequest", "()Lcom/hive/core/Request;", "setRequest", "(Lcom/hive/core/Request;)V", "getResult", "()Lcom/hive/core/Result;", "setResult", "(Lcom/hive/core/Result;)V", "connectLatency", "", "getConnectLatency", "()J", "setConnectLatency", "(J)V", "transportLatency", "getTransportLatency", "setTransportLatency", "responseLatency", "getResponseLatency", "setResponseLatency", "networkType", "getNetworkType", "()Ljava/lang/String;", "setNetworkType", "(Ljava/lang/String;)V", "sessionGuid", "getSessionGuid", "setSessionGuid", "sessionIndex", "getSessionIndex", "setSessionIndex", "dnsIp", "getDnsIp", "setDnsIp", "tlsProtocol", "getTlsProtocol", "setTlsProtocol", "tlsNote", "getTlsNote", "setTlsNote", "isPrintedLogContent", "", "value", "logContent", "getLogContent", "setLogContent", "isSuccess", "isFailure", InAppPurchaseConstants.METHOD_TO_STRING, "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Response {
    private long connectLatency;
    private byte[] content;
    private String dnsIp;
    private Map<String, String> header;
    private int httpStatusCode;
    private boolean isPrintedLogContent;
    private String logContent;
    private String networkType;
    private Request request;
    private long responseLatency;
    private Result result;
    private String sessionGuid;
    private int sessionIndex;
    private String tlsNote;
    private String tlsProtocol;
    private long transportLatency;

    public Response(int i, Map<String, String> header, byte[] bArr, Request request, Result result) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        this.httpStatusCode = i;
        this.header = header;
        this.content = bArr;
        this.request = request;
        this.result = result;
        this.connectLatency = -1L;
        this.transportLatency = -1L;
        this.responseLatency = -1L;
        this.networkType = "unknown";
        this.sessionGuid = "";
        this.dnsIp = "unknown";
        this.tlsProtocol = "unknown";
        this.tlsNote = "unknown";
    }

    public final int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public final void setHttpStatusCode(int i) {
        this.httpStatusCode = i;
    }

    public /* synthetic */ Response(int i, LinkedHashMap linkedHashMap, byte[] bArr, Request request, Result result, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new LinkedHashMap() : linkedHashMap, (i2 & 4) != 0 ? null : bArr, request, result);
    }

    public final Map<String, String> getHeader() {
        return this.header;
    }

    public final void setHeader(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.header = map;
    }

    public final byte[] getContent() {
        return this.content;
    }

    public final void setContent(byte[] bArr) {
        this.content = bArr;
    }

    public final Request getRequest() {
        return this.request;
    }

    public final void setRequest(Request request) {
        Intrinsics.checkNotNullParameter(request, "<set-?>");
        this.request = request;
    }

    public final Result getResult() {
        return this.result;
    }

    public final void setResult(Result result) {
        Intrinsics.checkNotNullParameter(result, "<set-?>");
        this.result = result;
    }

    public final long getConnectLatency() {
        return this.connectLatency;
    }

    public final void setConnectLatency(long j) {
        this.connectLatency = j;
    }

    public final long getTransportLatency() {
        return this.transportLatency;
    }

    public final void setTransportLatency(long j) {
        this.transportLatency = j;
    }

    public final long getResponseLatency() {
        return this.responseLatency;
    }

    public final void setResponseLatency(long j) {
        this.responseLatency = j;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final void setNetworkType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.networkType = str;
    }

    public final String getSessionGuid() {
        return this.sessionGuid;
    }

    public final void setSessionGuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionGuid = str;
    }

    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    public final void setSessionIndex(int i) {
        this.sessionIndex = i;
    }

    public final String getDnsIp() {
        return this.dnsIp;
    }

    public final void setDnsIp(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dnsIp = str;
    }

    public final String getTlsProtocol() {
        return this.tlsProtocol;
    }

    public final void setTlsProtocol(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tlsProtocol = str;
    }

    public final String getTlsNote() {
        return this.tlsNote;
    }

    public final void setTlsNote(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tlsNote = str;
    }

    public final String getLogContent() {
        String str = this.logContent;
        if (str == null || StringsKt.isBlank(str)) {
            byte[] bArr = this.content;
            if (bArr == null) {
                return null;
            }
            try {
                return new JSONObject(new String(bArr, Charsets.UTF_8)).toString(4);
            } catch (Exception unused) {
                return new String(bArr, Charsets.UTF_8);
            }
        }
        return this.logContent;
    }

    public final void setLogContent(String str) {
        this.logContent = str;
        if (this.isPrintedLogContent) {
            return;
        }
        if (this.request.getPrintNetworkLog()) {
            Logger.coreLog$hive_core_release$default(Logger.INSTANCE, "Network [" + this.request.hashCode() + "] network response. " + this, null, 2, null);
        }
        this.isPrintedLogContent = true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Response(Response response) {
        this(response.httpStatusCode, response.header, response.content, response.request, response.result);
        Intrinsics.checkNotNullParameter(response, "response");
        this.connectLatency = response.connectLatency;
        this.transportLatency = response.transportLatency;
        this.responseLatency = response.responseLatency;
        this.networkType = response.networkType;
        this.sessionGuid = response.sessionGuid;
        this.sessionIndex = response.sessionIndex;
        this.dnsIp = response.dnsIp;
        this.tlsProtocol = response.tlsProtocol;
        this.tlsNote = response.tlsNote;
    }

    public boolean isSuccess() {
        return this.result.isSuccess();
    }

    public boolean isFailure() {
        return !isSuccess();
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        for (Map.Entry<String, String> entry : this.header.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            if (z) {
                z = false;
                str = "";
            } else {
                str = "\n         ";
            }
            sb.append(str);
            sb.append(key);
            sb.append("=[");
            sb.append(value);
            sb.append(AbstractJsonLexerKt.END_LIST);
            stringBuffer.append(sb.toString());
        }
        return "\n\n  [Response] : \nurl = " + this.request.getUrl() + "\nresult = " + this.result + "\nsessionGuid = " + this.sessionGuid + "\nsessionIndex = " + this.sessionIndex + "\nhttpStatusCode = " + this.httpStatusCode + "\nheader = " + ((Object) stringBuffer) + "\nhuman readable content = \n" + getLogContent() + '\n';
    }
}
