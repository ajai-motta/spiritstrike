package com.hive.core;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.webkit.internal.AssetHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001:\u0002MNBW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0012B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0013J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0003J\u0010\u0010?\u001a\u00020\u00002\b\b\u0002\u0010@\u001a\u00020\u0003J\b\u0010A\u001a\u00020\u0003H\u0016J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\u0015\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010E\u001a\u00020\tHÆ\u0003J\t\u0010F\u001a\u00020\u000bHÆ\u0003J\t\u0010G\u001a\u00020\rHÆ\u0003J\t\u0010H\u001a\u00020\rHÆ\u0003J[\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010J\u001a\u0002022\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\rHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001e\u0010.\u001a\u0004\u0018\u00010\u00038FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0002028FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u000e\u0010:\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/hive/core/Request;", "", "url", "", FirebaseAnalytics.Param.METHOD, "Lcom/hive/core/Request$MethodType;", "header", "", "contentType", "Lcom/hive/core/Request$ContentType;", TtmlNode.TAG_BODY, "", "readTimeoutSeconds", "", "connectTimeoutSeconds", "<init>", "(Ljava/lang/String;Lcom/hive/core/Request$MethodType;Ljava/util/Map;Lcom/hive/core/Request$ContentType;[BII)V", "(Ljava/lang/String;[B)V", "(Ljava/lang/String;Lcom/hive/core/Request$MethodType;)V", "()V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getMethod", "()Lcom/hive/core/Request$MethodType;", "setMethod", "(Lcom/hive/core/Request$MethodType;)V", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "getContentType", "()Lcom/hive/core/Request$ContentType;", "setContentType", "(Lcom/hive/core/Request$ContentType;)V", "getBody", "()[B", "setBody", "([B)V", "getReadTimeoutSeconds", "()I", "setReadTimeoutSeconds", "(I)V", "getConnectTimeoutSeconds", "setConnectTimeoutSeconds", "logBody", "getLogBody", "setLogBody", "sendObserver", "", "getSendObserver", "()Z", "setSendObserver", "(Z)V", "printNetworkLog", "getPrintNetworkLog", "setPrintNetworkLog", "isUrlParamFirst", "addUrlParam", "", "key", "value", "copyMirrorInstance", "mirrorUrl", InAppPurchaseConstants.METHOD_TO_STRING, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "MethodType", "ContentType", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Request {
    private byte[] body;
    private int connectTimeoutSeconds;
    private ContentType contentType;
    private Map<String, String> header;
    private boolean isUrlParamFirst;
    private String logBody;
    private MethodType method;
    private boolean printNetworkLog;
    private int readTimeoutSeconds;
    private boolean sendObserver;
    private String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Request copy$default(Request request, String str, MethodType methodType, Map map, ContentType contentType, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = request.url;
        }
        if ((i3 & 2) != 0) {
            methodType = request.method;
        }
        MethodType methodType2 = methodType;
        if ((i3 & 4) != 0) {
            map = request.header;
        }
        Map map2 = map;
        if ((i3 & 8) != 0) {
            contentType = request.contentType;
        }
        ContentType contentType2 = contentType;
        if ((i3 & 16) != 0) {
            bArr = request.body;
        }
        byte[] bArr2 = bArr;
        if ((i3 & 32) != 0) {
            i = request.readTimeoutSeconds;
        }
        int i4 = i;
        if ((i3 & 64) != 0) {
            i2 = request.connectTimeoutSeconds;
        }
        return request.copy(str, methodType2, map2, contentType2, bArr2, i4, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MethodType getMethod() {
        return this.method;
    }

    public final Map<String, String> component3() {
        return this.header;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ContentType getContentType() {
        return this.contentType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final byte[] getBody() {
        return this.body;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getReadTimeoutSeconds() {
        return this.readTimeoutSeconds;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getConnectTimeoutSeconds() {
        return this.connectTimeoutSeconds;
    }

    public final Request copy(String url, MethodType method, Map<String, String> header, ContentType contentType, byte[] body, int readTimeoutSeconds, int connectTimeoutSeconds) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(body, "body");
        return new Request(url, method, header, contentType, body, readTimeoutSeconds, connectTimeoutSeconds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Request)) {
            return false;
        }
        Request request = (Request) other;
        return Intrinsics.areEqual(this.url, request.url) && this.method == request.method && Intrinsics.areEqual(this.header, request.header) && this.contentType == request.contentType && Intrinsics.areEqual(this.body, request.body) && this.readTimeoutSeconds == request.readTimeoutSeconds && this.connectTimeoutSeconds == request.connectTimeoutSeconds;
    }

    public int hashCode() {
        return (((((((((((this.url.hashCode() * 31) + this.method.hashCode()) * 31) + this.header.hashCode()) * 31) + this.contentType.hashCode()) * 31) + Arrays.hashCode(this.body)) * 31) + this.readTimeoutSeconds) * 31) + this.connectTimeoutSeconds;
    }

    public Request(String url, MethodType method, Map<String, String> header, ContentType contentType, byte[] body, int i, int i2) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(body, "body");
        this.url = url;
        this.method = method;
        this.header = header;
        this.contentType = contentType;
        this.body = body;
        this.readTimeoutSeconds = i;
        this.connectTimeoutSeconds = i2;
        this.printNetworkLog = true;
        this.isUrlParamFirst = true;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public /* synthetic */ Request(String str, MethodType methodType, Map map, ContentType contentType, byte[] bArr, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? MethodType.POST : methodType, (i3 & 4) != 0 ? new LinkedHashMap() : map, (i3 & 8) != 0 ? ContentType.TEXT_HTML : contentType, (i3 & 16) != 0 ? new byte[0] : bArr, (i3 & 32) != 0 ? Configuration.INSTANCE.getReadTimeoutSeconds() : i, (i3 & 64) != 0 ? Configuration.INSTANCE.getConnectTimeoutSeconds() : i2);
    }

    public final MethodType getMethod() {
        return this.method;
    }

    public final void setMethod(MethodType methodType) {
        Intrinsics.checkNotNullParameter(methodType, "<set-?>");
        this.method = methodType;
    }

    public final Map<String, String> getHeader() {
        return this.header;
    }

    public final void setHeader(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.header = map;
    }

    public final ContentType getContentType() {
        return this.contentType;
    }

    public final void setContentType(ContentType contentType) {
        Intrinsics.checkNotNullParameter(contentType, "<set-?>");
        this.contentType = contentType;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final void setBody(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.body = bArr;
    }

    public final int getReadTimeoutSeconds() {
        return this.readTimeoutSeconds;
    }

    public final void setReadTimeoutSeconds(int i) {
        this.readTimeoutSeconds = i;
    }

    public final int getConnectTimeoutSeconds() {
        return this.connectTimeoutSeconds;
    }

    public final void setConnectTimeoutSeconds(int i) {
        this.connectTimeoutSeconds = i;
    }

    public final void setLogBody(String str) {
        this.logBody = str;
    }

    public final String getLogBody() {
        String str = this.logBody;
        if (str == null || StringsKt.isBlank(str)) {
            try {
                return new JSONObject(new String(this.body, Charsets.UTF_8)).toString(4);
            } catch (Exception unused) {
                return new String(this.body, Charsets.UTF_8);
            }
        }
        return this.logBody;
    }

    public final boolean getSendObserver() {
        return this.sendObserver;
    }

    public final void setSendObserver(boolean z) {
        this.sendObserver = z;
    }

    public final void setPrintNetworkLog(boolean z) {
        this.printNetworkLog = z;
    }

    public final boolean getPrintNetworkLog() {
        if (Logger.INSTANCE.getDebugNetworkLog()) {
            return true;
        }
        return this.printNetworkLog;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Request(String url, byte[] body) {
        this(url, MethodType.POST, null, null, body, 0, 0, 108, null);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Request(String url, MethodType method) {
        this(url, method, null, null, new byte[0], 0, 0, 108, null);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
    }

    public Request() {
        this("", null, null, null, null, 0, 0, 126, null);
    }

    public final void addUrlParam(String key, String value) throws UnsupportedEncodingException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        String strEncode = URLEncoder.encode(key, Charsets.UTF_8.name());
        String strEncode2 = URLEncoder.encode(value, Charsets.UTF_8.name());
        if (this.isUrlParamFirst) {
            this.isUrlParamFirst = false;
            this.url += '?' + strEncode + '=' + strEncode2;
            return;
        }
        this.url += Typography.amp + strEncode + '=' + strEncode2;
    }

    public static /* synthetic */ Request copyMirrorInstance$default(Request request, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = request.url;
        }
        return request.copyMirrorInstance(str);
    }

    public final Request copyMirrorInstance(String mirrorUrl) {
        Intrinsics.checkNotNullParameter(mirrorUrl, "mirrorUrl");
        Request requestCopy$default = copy$default(this, mirrorUrl, null, null, null, null, 0, 0, 126, null);
        requestCopy$default.logBody = getLogBody();
        requestCopy$default.sendObserver = this.sendObserver;
        requestCopy$default.printNetworkLog = getPrintNetworkLog();
        requestCopy$default.isUrlParamFirst = this.isUrlParamFirst;
        return requestCopy$default;
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
        return "\n\n  [Request] : \nurl = " + this.url + "\nmethod = " + this.method + "\nreadTimeoutSeconds = " + this.readTimeoutSeconds + "\nconnectTimeoutSeconds = " + this.connectTimeoutSeconds + "\nheader = " + ((Object) stringBuffer) + "\ncontentType = " + this.contentType.getValue() + "\nhuman readable body = \n" + getLogBody() + '\n';
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Request.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/hive/core/Request$MethodType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "POST", "GET", "DELETE", "PUT", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MethodType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MethodType[] $VALUES;
        private final String value;
        public static final MethodType POST = new MethodType("POST", 0, "POST");
        public static final MethodType GET = new MethodType("GET", 1, "GET");
        public static final MethodType DELETE = new MethodType("DELETE", 2, "DELETE");
        public static final MethodType PUT = new MethodType("PUT", 3, "PUT");

        private static final /* synthetic */ MethodType[] $values() {
            return new MethodType[]{POST, GET, DELETE, PUT};
        }

        public static EnumEntries<MethodType> getEntries() {
            return $ENTRIES;
        }

        private MethodType(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            MethodType[] methodTypeArr$values = $values();
            $VALUES = methodTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(methodTypeArr$values);
        }

        public static MethodType valueOf(String str) {
            return (MethodType) Enum.valueOf(MethodType.class, str);
        }

        public static MethodType[] values() {
            return (MethodType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Request.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/hive/core/Request$ContentType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TEXT_HTML", "TEXT_PLAIN", "URL_ENCODING", "JSON", "GZIP", "OCTET_STREAM", "ALL", "NONE", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ContentType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ContentType[] $VALUES;
        private final String value;
        public static final ContentType TEXT_HTML = new ContentType("TEXT_HTML", 0, "text/html");
        public static final ContentType TEXT_PLAIN = new ContentType("TEXT_PLAIN", 1, AssetHelper.DEFAULT_MIME_TYPE);
        public static final ContentType URL_ENCODING = new ContentType("URL_ENCODING", 2, ShareTarget.ENCODING_TYPE_URL_ENCODED);
        public static final ContentType JSON = new ContentType("JSON", 3, "application/json");
        public static final ContentType GZIP = new ContentType("GZIP", 4, "gzip");
        public static final ContentType OCTET_STREAM = new ContentType("OCTET_STREAM", 5, "application/octet-stream");
        public static final ContentType ALL = new ContentType("ALL", 6, "*/*");
        public static final ContentType NONE = new ContentType("NONE", 7, "none");

        private static final /* synthetic */ ContentType[] $values() {
            return new ContentType[]{TEXT_HTML, TEXT_PLAIN, URL_ENCODING, JSON, GZIP, OCTET_STREAM, ALL, NONE};
        }

        public static EnumEntries<ContentType> getEntries() {
            return $ENTRIES;
        }

        private ContentType(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            ContentType[] contentTypeArr$values = $values();
            $VALUES = contentTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(contentTypeArr$values);
        }

        public static ContentType valueOf(String str) {
            return (ContentType) Enum.valueOf(ContentType.class, str);
        }

        public static ContentType[] values() {
            return (ContentType[]) $VALUES.clone();
        }
    }
}
