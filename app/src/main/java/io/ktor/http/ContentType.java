package io.ktor.http;

import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.webkit.ProxyConfig;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import io.ktor.http.HeaderValueWithParameters;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.files.FileSystemKt;

/* JADX INFO: compiled from: ContentTypes.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 $2\u00020\u0001:\t$%&'()*+,B1\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b#\u0010\"¨\u0006-"}, d2 = {"Lio/ktor/http/ContentType;", "Lio/ktor/http/HeaderValueWithParameters;", "", "contentType", "contentSubtype", "existingContent", "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "name", "value", "withParameter", "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/http/ContentType;", "", "hasParameter", "(Ljava/lang/String;Ljava/lang/String;)Z", "withoutParameters", "()Lio/ktor/http/ContentType;", "pattern", "match", "(Lio/ktor/http/ContentType;)Z", "(Ljava/lang/String;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getContentType", "()Ljava/lang/String;", "getContentSubtype", k.M, "Application", "Audio", "Image", "Message", "MultiPart", "Text", "Video", "Font", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentType extends HeaderValueWithParameters {
    private final String contentSubtype;
    private final String contentType;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ContentType Any = new ContentType("*", "*", null, 4, null);

    public final String getContentType() {
        return this.contentType;
    }

    public final String getContentSubtype() {
        return this.contentSubtype;
    }

    /* synthetic */ ContentType(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    private ContentType(String str, String str2, String str3, List<HeaderValueParam> list) {
        super(str3, list);
        this.contentType = str;
        this.contentSubtype = str2;
    }

    public /* synthetic */ ContentType(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentType(String contentType, String contentSubtype, List<HeaderValueParam> parameters) {
        this(contentType, contentSubtype, contentType + FileSystemKt.UnixPathSeparator + contentSubtype, parameters);
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentSubtype, "contentSubtype");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }

    public final ContentType withParameter(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return hasParameter(name, value) ? this : new ContentType(this.contentType, this.contentSubtype, getContent(), CollectionsKt.plus((Collection<? extends HeaderValueParam>) getParameters(), new HeaderValueParam(name, value)));
    }

    private final boolean hasParameter(String name, String value) {
        int size = getParameters().size();
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            HeaderValueParam headerValueParam = getParameters().get(0);
            if (!StringsKt.equals(headerValueParam.getName(), name, true) || !StringsKt.equals(headerValueParam.getValue(), value, true)) {
                return false;
            }
        } else {
            List<HeaderValueParam> parameters = getParameters();
            if ((parameters instanceof Collection) && parameters.isEmpty()) {
                return false;
            }
            for (HeaderValueParam headerValueParam2 : parameters) {
                if (!StringsKt.equals(headerValueParam2.getName(), name, true) || !StringsKt.equals(headerValueParam2.getValue(), value, true)) {
                }
            }
            return false;
        }
        return true;
    }

    public final ContentType withoutParameters() {
        if (getParameters().isEmpty()) {
            return this;
        }
        return new ContentType(this.contentType, this.contentSubtype, null, 4, null);
    }

    public final boolean match(ContentType pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (!Intrinsics.areEqual(pattern.contentType, "*") && !StringsKt.equals(pattern.contentType, this.contentType, true)) {
            return false;
        }
        if (!Intrinsics.areEqual(pattern.contentSubtype, "*") && !StringsKt.equals(pattern.contentSubtype, this.contentSubtype, true)) {
            return false;
        }
        for (HeaderValueParam headerValueParam : pattern.getParameters()) {
            String strComponent1 = headerValueParam.getName();
            String strComponent2 = headerValueParam.getValue();
            if (Intrinsics.areEqual(strComponent1, "*")) {
                if (!Intrinsics.areEqual(strComponent2, "*")) {
                    List<HeaderValueParam> parameters = getParameters();
                    if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                        Iterator<T> it = parameters.iterator();
                        while (it.hasNext()) {
                            if (StringsKt.equals(((HeaderValueParam) it.next()).getValue(), strComponent2, true)) {
                                break;
                            }
                        }
                    }
                    return false;
                }
                continue;
            } else {
                String strParameter = parameter(strComponent1);
                if (Intrinsics.areEqual(strComponent2, "*")) {
                    if (strParameter == null) {
                        return false;
                    }
                } else if (!StringsKt.equals(strParameter, strComponent2, true)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean match(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        return match(INSTANCE.parse(pattern));
    }

    public boolean equals(Object other) {
        if (other instanceof ContentType) {
            ContentType contentType = (ContentType) other;
            if (StringsKt.equals(this.contentType, contentType.contentType, true) && StringsKt.equals(this.contentSubtype, contentType.contentSubtype, true) && Intrinsics.areEqual(getParameters(), contentType.getParameters())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String lowerCase = this.contentType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.contentSubtype.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return iHashCode + (iHashCode * 31) + lowerCase2.hashCode() + (getParameters().hashCode() * 31);
    }

    /* JADX INFO: compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/http/ContentType$Companion;", "", "<init>", "()V", "", "value", "Lio/ktor/http/ContentType;", "parse", "(Ljava/lang/String;)Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ContentType parse(String value) throws BadContentTypeFormatException {
            Intrinsics.checkNotNullParameter(value, "value");
            if (StringsKt.isBlank(value)) {
                return getAny();
            }
            HeaderValueWithParameters.Companion companion = HeaderValueWithParameters.INSTANCE;
            HeaderValue headerValue = (HeaderValue) CollectionsKt.last((List) HttpHeaderValueParserKt.parseHeaderValue(value));
            String value2 = headerValue.getValue();
            List<HeaderValueParam> params = headerValue.getParams();
            String str = value2;
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, FileSystemKt.UnixPathSeparator, 0, false, 6, (Object) null);
            if (iIndexOf$default == -1) {
                if (Intrinsics.areEqual(StringsKt.trim((CharSequence) str).toString(), "*")) {
                    return ContentType.INSTANCE.getAny();
                }
                throw new BadContentTypeFormatException(value);
            }
            String strSubstring = value2.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String string = StringsKt.trim((CharSequence) strSubstring).toString();
            String str2 = string;
            if (str2.length() == 0) {
                throw new BadContentTypeFormatException(value);
            }
            String strSubstring2 = value2.substring(iIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            String string2 = StringsKt.trim((CharSequence) strSubstring2).toString();
            if (!StringsKt.contains$default((CharSequence) str2, ' ', false, 2, (Object) null)) {
                String str3 = string2;
                if (!StringsKt.contains$default((CharSequence) str3, ' ', false, 2, (Object) null)) {
                    if (str3.length() == 0 || StringsKt.contains$default((CharSequence) str3, FileSystemKt.UnixPathSeparator, false, 2, (Object) null)) {
                        throw new BadContentTypeFormatException(value);
                    }
                    return new ContentType(string, string2, params);
                }
            }
            throw new BadContentTypeFormatException(value);
        }

        public final ContentType getAny() {
            return ContentType.Any;
        }
    }

    /* JADX INFO: compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b3\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010 \u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011R\u0017\u0010\"\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u0017\u0010$\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0011R\u0017\u0010&\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b&\u0010\u000f\u001a\u0004\b'\u0010\u0011R\u0017\u0010(\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R\u0017\u0010*\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b*\u0010\u000f\u001a\u0004\b+\u0010\u0011R\u0017\u0010,\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b,\u0010\u000f\u001a\u0004\b-\u0010\u0011R\u0017\u0010.\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b.\u0010\u000f\u001a\u0004\b/\u0010\u0011R\u0017\u00100\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b0\u0010\u000f\u001a\u0004\b1\u0010\u0011R\u0017\u00102\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b2\u0010\u000f\u001a\u0004\b3\u0010\u0011R\u0017\u00104\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b4\u0010\u000f\u001a\u0004\b5\u0010\u0011R\u0017\u00106\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b6\u0010\u000f\u001a\u0004\b7\u0010\u0011R\u0017\u00108\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b8\u0010\u000f\u001a\u0004\b9\u0010\u0011R\u0017\u0010:\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b:\u0010\u000f\u001a\u0004\b;\u0010\u0011R\u0017\u0010<\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b<\u0010\u000f\u001a\u0004\b=\u0010\u0011¨\u0006>"}, d2 = {"Lio/ktor/http/ContentType$Application;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Atom", "getAtom", "Cbor", "getCbor", "Json", "getJson", "HalJson", "getHalJson", "JavaScript", "getJavaScript", "OctetStream", "getOctetStream", "Rss", "getRss", "Soap", "getSoap", "Xml", "getXml", "Xml_Dtd", "getXml_Dtd", "Yaml", "getYaml", "Zip", "getZip", "GZip", "getGZip", "FormUrlEncoded", "getFormUrlEncoded", "Pdf", "getPdf", "Xlsx", "getXlsx", "Docx", "getDocx", "Pptx", "getPptx", "ProtoBuf", "getProtoBuf", "Wasm", "getWasm", "ProblemJson", "getProblemJson", "ProblemXml", "getProblemXml", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Application {
        private static final ContentType Any;
        private static final ContentType Atom;
        private static final ContentType Cbor;
        private static final ContentType Docx;
        private static final ContentType FormUrlEncoded;
        private static final ContentType GZip;
        private static final ContentType HalJson;
        public static final Application INSTANCE = new Application();
        private static final ContentType JavaScript;
        private static final ContentType Json;
        private static final ContentType OctetStream;
        private static final ContentType Pdf;
        private static final ContentType Pptx;
        private static final ContentType ProblemJson;
        private static final ContentType ProblemXml;
        private static final ContentType ProtoBuf;
        private static final ContentType Rss;
        private static final ContentType Soap;
        public static final String TYPE = "application";
        private static final ContentType Wasm;
        private static final ContentType Xlsx;
        private static final ContentType Xml;
        private static final ContentType Xml_Dtd;
        private static final ContentType Yaml;
        private static final ContentType Zip;

        private Application() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("application", "*", list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            Atom = new ContentType("application", "atom+xml", list2, i2, defaultConstructorMarker2);
            Cbor = new ContentType("application", "cbor", list, i, defaultConstructorMarker);
            Json = new ContentType("application", "json", list2, i2, defaultConstructorMarker2);
            HalJson = new ContentType("application", "hal+json", list, i, defaultConstructorMarker);
            JavaScript = new ContentType("application", "javascript", list2, i2, defaultConstructorMarker2);
            OctetStream = new ContentType("application", "octet-stream", list, i, defaultConstructorMarker);
            Rss = new ContentType("application", "rss+xml", list2, i2, defaultConstructorMarker2);
            Soap = new ContentType("application", "soap+xml", list, i, defaultConstructorMarker);
            Xml = new ContentType("application", "xml", list2, i2, defaultConstructorMarker2);
            Xml_Dtd = new ContentType("application", "xml-dtd", list, i, defaultConstructorMarker);
            Yaml = new ContentType("application", "yaml", list2, i2, defaultConstructorMarker2);
            Zip = new ContentType("application", "zip", list, i, defaultConstructorMarker);
            GZip = new ContentType("application", "gzip", list2, i2, defaultConstructorMarker2);
            FormUrlEncoded = new ContentType("application", "x-www-form-urlencoded", list, i, defaultConstructorMarker);
            Pdf = new ContentType("application", "pdf", list2, i2, defaultConstructorMarker2);
            Xlsx = new ContentType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet", list, i, defaultConstructorMarker);
            Docx = new ContentType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document", list2, i2, defaultConstructorMarker2);
            Pptx = new ContentType("application", "vnd.openxmlformats-officedocument.presentationml.presentation", list, i, defaultConstructorMarker);
            ProtoBuf = new ContentType("application", "protobuf", list2, i2, defaultConstructorMarker2);
            Wasm = new ContentType("application", "wasm", list, i, defaultConstructorMarker);
            ProblemJson = new ContentType("application", "problem+json", list2, i2, defaultConstructorMarker2);
            ProblemXml = new ContentType("application", "problem+xml", list, i, defaultConstructorMarker);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getAtom() {
            return Atom;
        }

        public final ContentType getCbor() {
            return Cbor;
        }

        public final ContentType getJson() {
            return Json;
        }

        public final ContentType getHalJson() {
            return HalJson;
        }

        public final ContentType getJavaScript() {
            return JavaScript;
        }

        public final ContentType getOctetStream() {
            return OctetStream;
        }

        public final ContentType getRss() {
            return Rss;
        }

        public final ContentType getSoap() {
            return Soap;
        }

        public final ContentType getXml() {
            return Xml;
        }

        public final ContentType getXml_Dtd() {
            return Xml_Dtd;
        }

        public final ContentType getYaml() {
            return Yaml;
        }

        public final ContentType getZip() {
            return Zip;
        }

        public final ContentType getGZip() {
            return GZip;
        }

        public final ContentType getFormUrlEncoded() {
            return FormUrlEncoded;
        }

        public final ContentType getPdf() {
            return Pdf;
        }

        public final ContentType getXlsx() {
            return Xlsx;
        }

        public final ContentType getDocx() {
            return Docx;
        }

        public final ContentType getPptx() {
            return Pptx;
        }

        public final ContentType getProtoBuf() {
            return ProtoBuf;
        }

        public final ContentType getWasm() {
            return Wasm;
        }

        public final ContentType getProblemJson() {
            return ProblemJson;
        }

        public final ContentType getProblemXml() {
            return ProblemXml;
        }

        public final boolean contains(CharSequence contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return StringsKt.startsWith(contentType, (CharSequence) "application/", true);
        }

        public final boolean contains(ContentType contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    /* JADX INFO: compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lio/ktor/http/ContentType$Audio;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "MP4", "getMP4", "MPEG", "getMPEG", "OGG", "getOGG", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Audio {
        private static final ContentType Any;
        public static final Audio INSTANCE = new Audio();
        private static final ContentType MP4;
        private static final ContentType MPEG;
        private static final ContentType OGG;
        public static final String TYPE = "audio";

        private Audio() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("audio", "*", list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            MP4 = new ContentType("audio", "mp4", list2, i2, defaultConstructorMarker2);
            MPEG = new ContentType("audio", "mpeg", list, i, defaultConstructorMarker);
            OGG = new ContentType("audio", "ogg", list2, i2, defaultConstructorMarker2);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMP4() {
            return MP4;
        }

        public final ContentType getMPEG() {
            return MPEG;
        }

        public final ContentType getOGG() {
            return OGG;
        }

        public final boolean contains(CharSequence contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return StringsKt.startsWith(contentType, (CharSequence) "audio/", true);
        }

        public final boolean contains(ContentType contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    /* JADX INFO: compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011¨\u0006\u001c"}, d2 = {"Lio/ktor/http/ContentType$Image;", "", "<init>", "()V", "", "contentSubtype", "", "contains", "(Ljava/lang/String;)Z", "Lio/ktor/http/ContentType;", "contentType", "(Lio/ktor/http/ContentType;)Z", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "GIF", "getGIF", "JPEG", "getJPEG", "PNG", "getPNG", "SVG", "getSVG", "XIcon", "getXIcon", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Image {
        private static final ContentType Any;
        private static final ContentType GIF;
        public static final Image INSTANCE = new Image();
        private static final ContentType JPEG;
        private static final ContentType PNG;
        private static final ContentType SVG;
        public static final String TYPE = "image";
        private static final ContentType XIcon;

        private Image() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("image", "*", list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            GIF = new ContentType("image", "gif", list2, i2, defaultConstructorMarker2);
            JPEG = new ContentType("image", "jpeg", list, i, defaultConstructorMarker);
            PNG = new ContentType("image", "png", list2, i2, defaultConstructorMarker2);
            SVG = new ContentType("image", "svg+xml", list, i, defaultConstructorMarker);
            XIcon = new ContentType("image", "x-icon", list2, i2, defaultConstructorMarker2);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getGIF() {
            return GIF;
        }

        public final ContentType getJPEG() {
            return JPEG;
        }

        public final ContentType getPNG() {
            return PNG;
        }

        public final ContentType getSVG() {
            return SVG;
        }

        public final ContentType getXIcon() {
            return XIcon;
        }

        public final boolean contains(String contentSubtype) {
            Intrinsics.checkNotNullParameter(contentSubtype, "contentSubtype");
            return StringsKt.startsWith(contentSubtype, "image/", true);
        }

        public final boolean contains(ContentType contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    /* JADX INFO: compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lio/ktor/http/ContentType$Message;", "", "<init>", "()V", "", "contentSubtype", "", "contains", "(Ljava/lang/String;)Z", "Lio/ktor/http/ContentType;", "contentType", "(Lio/ktor/http/ContentType;)Z", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Http", "getHttp", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Message {
        public static final String TYPE = "message";
        public static final Message INSTANCE = new Message();
        private static final ContentType Any = new ContentType("message", "*", null, 4, null);
        private static final ContentType Http = new ContentType("message", ProxyConfig.MATCH_HTTP, null, 4, null);

        private Message() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getHttp() {
            return Http;
        }

        public final boolean contains(String contentSubtype) {
            Intrinsics.checkNotNullParameter(contentSubtype, "contentSubtype");
            return StringsKt.startsWith(contentSubtype, "message/", true);
        }

        public final boolean contains(ContentType contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    /* JADX INFO: compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011¨\u0006 "}, d2 = {"Lio/ktor/http/ContentType$MultiPart;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Mixed", "getMixed", "Alternative", "getAlternative", "Related", "getRelated", "FormData", "getFormData", "Signed", "getSigned", "Encrypted", "getEncrypted", "ByteRanges", "getByteRanges", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MultiPart {
        private static final ContentType Alternative;
        private static final ContentType Any;
        private static final ContentType ByteRanges;
        private static final ContentType Encrypted;
        private static final ContentType FormData;
        public static final MultiPart INSTANCE = new MultiPart();
        private static final ContentType Mixed;
        private static final ContentType Related;
        private static final ContentType Signed;
        public static final String TYPE = "multipart";

        private MultiPart() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType(TYPE, "*", list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            Mixed = new ContentType(TYPE, "mixed", list2, i2, defaultConstructorMarker2);
            Alternative = new ContentType(TYPE, "alternative", list, i, defaultConstructorMarker);
            Related = new ContentType(TYPE, "related", list2, i2, defaultConstructorMarker2);
            FormData = new ContentType(TYPE, "form-data", list, i, defaultConstructorMarker);
            Signed = new ContentType(TYPE, "signed", list2, i2, defaultConstructorMarker2);
            Encrypted = new ContentType(TYPE, "encrypted", list, i, defaultConstructorMarker);
            ByteRanges = new ContentType(TYPE, "byteranges", list2, i2, defaultConstructorMarker2);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMixed() {
            return Mixed;
        }

        public final ContentType getAlternative() {
            return Alternative;
        }

        public final ContentType getRelated() {
            return Related;
        }

        public final ContentType getFormData() {
            return FormData;
        }

        public final ContentType getSigned() {
            return Signed;
        }

        public final ContentType getEncrypted() {
            return Encrypted;
        }

        public final ContentType getByteRanges() {
            return ByteRanges;
        }

        public final boolean contains(CharSequence contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return StringsKt.startsWith(contentType, (CharSequence) "multipart/", true);
        }

        public final boolean contains(ContentType contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    /* JADX INFO: compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010 \u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011¨\u0006\""}, d2 = {"Lio/ktor/http/ContentType$Text;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Plain", "getPlain", "CSS", "getCSS", "CSV", "getCSV", "Html", "getHtml", "JavaScript", "getJavaScript", "VCard", "getVCard", "Xml", "getXml", "EventStream", "getEventStream", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Text {
        private static final ContentType Any;
        private static final ContentType CSS;
        private static final ContentType CSV;
        private static final ContentType EventStream;
        private static final ContentType Html;
        public static final Text INSTANCE = new Text();
        private static final ContentType JavaScript;
        private static final ContentType Plain;
        public static final String TYPE = "text";
        private static final ContentType VCard;
        private static final ContentType Xml;

        private Text() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("text", "*", list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            Plain = new ContentType("text", "plain", list2, i2, defaultConstructorMarker2);
            CSS = new ContentType("text", "css", list, i, defaultConstructorMarker);
            CSV = new ContentType("text", "csv", list2, i2, defaultConstructorMarker2);
            Html = new ContentType("text", "html", list, i, defaultConstructorMarker);
            JavaScript = new ContentType("text", "javascript", list2, i2, defaultConstructorMarker2);
            VCard = new ContentType("text", "vcard", list, i, defaultConstructorMarker);
            Xml = new ContentType("text", "xml", list2, i2, defaultConstructorMarker2);
            EventStream = new ContentType("text", "event-stream", list, i, defaultConstructorMarker);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getPlain() {
            return Plain;
        }

        public final ContentType getCSS() {
            return CSS;
        }

        public final ContentType getCSV() {
            return CSV;
        }

        public final ContentType getHtml() {
            return Html;
        }

        public final ContentType getJavaScript() {
            return JavaScript;
        }

        public final ContentType getVCard() {
            return VCard;
        }

        public final ContentType getXml() {
            return Xml;
        }

        public final ContentType getEventStream() {
            return EventStream;
        }

        public final boolean contains(CharSequence contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return StringsKt.startsWith(contentType, (CharSequence) "text/", true);
        }

        public final boolean contains(ContentType contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    /* JADX INFO: compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001a"}, d2 = {"Lio/ktor/http/ContentType$Video;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "MPEG", "getMPEG", "MP4", "getMP4", "OGG", "getOGG", "QuickTime", "getQuickTime", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Video {
        private static final ContentType Any;
        public static final Video INSTANCE = new Video();
        private static final ContentType MP4;
        private static final ContentType MPEG;
        private static final ContentType OGG;
        private static final ContentType QuickTime;
        public static final String TYPE = "video";

        private Video() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("video", "*", list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            MPEG = new ContentType("video", "mpeg", list2, i2, defaultConstructorMarker2);
            MP4 = new ContentType("video", "mp4", list, i, defaultConstructorMarker);
            OGG = new ContentType("video", "ogg", list2, i2, defaultConstructorMarker2);
            QuickTime = new ContentType("video", "quicktime", list, i, defaultConstructorMarker);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMPEG() {
            return MPEG;
        }

        public final ContentType getMP4() {
            return MP4;
        }

        public final ContentType getOGG() {
            return OGG;
        }

        public final ContentType getQuickTime() {
            return QuickTime;
        }

        public final boolean contains(CharSequence contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return StringsKt.startsWith(contentType, (CharSequence) "video/", true);
        }

        public final boolean contains(ContentType contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return contentType.match(Any);
        }
    }

    /* JADX INFO: compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011¨\u0006\u001e"}, d2 = {"Lio/ktor/http/ContentType$Font;", "", "<init>", "()V", "", "contentType", "", "contains", "(Ljava/lang/CharSequence;)Z", "Lio/ktor/http/ContentType;", "(Lio/ktor/http/ContentType;)Z", "", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/String;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Collection", "getCollection", "Otf", "getOtf", "Sfnt", "getSfnt", "Ttf", "getTtf", "Woff", "getWoff", "Woff2", "getWoff2", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Font {
        private static final ContentType Any;
        private static final ContentType Collection;
        public static final Font INSTANCE = new Font();
        private static final ContentType Otf;
        private static final ContentType Sfnt;
        public static final String TYPE = "font";
        private static final ContentType Ttf;
        private static final ContentType Woff;
        private static final ContentType Woff2;

        private Font() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType(TYPE, "*", list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            Collection = new ContentType(TYPE, "collection", list2, i2, defaultConstructorMarker2);
            Otf = new ContentType(TYPE, "otf", list, i, defaultConstructorMarker);
            Sfnt = new ContentType(TYPE, "sfnt", list2, i2, defaultConstructorMarker2);
            Ttf = new ContentType(TYPE, "ttf", list, i, defaultConstructorMarker);
            Woff = new ContentType(TYPE, "woff", list2, i2, defaultConstructorMarker2);
            Woff2 = new ContentType(TYPE, "woff2", list, i, defaultConstructorMarker);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getCollection() {
            return Collection;
        }

        public final ContentType getOtf() {
            return Otf;
        }

        public final ContentType getSfnt() {
            return Sfnt;
        }

        public final ContentType getTtf() {
            return Ttf;
        }

        public final ContentType getWoff() {
            return Woff;
        }

        public final ContentType getWoff2() {
            return Woff2;
        }

        public final boolean contains(CharSequence contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return StringsKt.startsWith(contentType, (CharSequence) "font/", true);
        }

        public final boolean contains(ContentType contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            return contentType.match(Any);
        }
    }
}
