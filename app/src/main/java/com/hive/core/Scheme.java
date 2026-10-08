package com.hive.core;

import android.net.Uri;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JO\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u000fR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u000f¨\u0006)"}, d2 = {"Lcom/hive/core/Scheme;", "", "scheme", "", "host", "path", MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "stringUrl", "(Ljava/lang/String;)V", "getScheme", "()Ljava/lang/String;", "setScheme", "getHost", "setHost", "getPath", "setPath", "getParameter", "()Ljava/util/Map;", "setParameter", "(Ljava/util/Map;)V", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Scheme {
    private String host;
    private Map<String, String> parameter;
    private String path;
    private String scheme;
    private String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Scheme copy$default(Scheme scheme, String str, String str2, String str3, Map map, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scheme.scheme;
        }
        if ((i & 2) != 0) {
            str2 = scheme.host;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = scheme.path;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            map = scheme.parameter;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            str4 = scheme.url;
        }
        return scheme.copy(str, str5, str6, map2, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public final Map<String, String> component4() {
        return this.parameter;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final Scheme copy(String scheme, String host, String path, Map<String, String> parameter, String url) {
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        Intrinsics.checkNotNullParameter(url, "url");
        return new Scheme(scheme, host, path, parameter, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Scheme)) {
            return false;
        }
        Scheme scheme = (Scheme) other;
        return Intrinsics.areEqual(this.scheme, scheme.scheme) && Intrinsics.areEqual(this.host, scheme.host) && Intrinsics.areEqual(this.path, scheme.path) && Intrinsics.areEqual(this.parameter, scheme.parameter) && Intrinsics.areEqual(this.url, scheme.url);
    }

    public int hashCode() {
        String str = this.scheme;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.host;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.path;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.parameter.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "Scheme(scheme=" + this.scheme + ", host=" + this.host + ", path=" + this.path + ", parameter=" + this.parameter + ", url=" + this.url + ')';
    }

    public Scheme(String str, String str2, String str3, Map<String, String> parameter, String url) {
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        Intrinsics.checkNotNullParameter(url, "url");
        this.scheme = str;
        this.host = str2;
        this.path = str3;
        this.parameter = parameter;
        this.url = url;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final void setScheme(String str) {
        this.scheme = str;
    }

    public final String getHost() {
        return this.host;
    }

    public final void setHost(String str) {
        this.host = str;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public /* synthetic */ Scheme(String str, String str2, String str3, LinkedHashMap linkedHashMap, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? new LinkedHashMap() : linkedHashMap, str4);
    }

    public final Map<String, String> getParameter() {
        return this.parameter;
    }

    public final void setParameter(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.parameter = map;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Scheme(Uri uri) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(uri, "uri");
        String scheme = uri.getScheme();
        String host = uri.getHost();
        String path = uri.getPath();
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this(scheme, host, path, null, string, 8, null);
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(uri.getQueryParameterNames());
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (kotlin.Result.m7422isSuccessimpl(objM7415constructorimpl)) {
            Set<String> set = (Set) objM7415constructorimpl;
            Intrinsics.checkNotNull(set);
            for (String str : set) {
                try {
                    this.parameter.put(str, uri.getQueryParameter(str));
                } catch (Exception e) {
                    Logger.INSTANCE.w("[Scheme] getQueryParameter Exception : " + e);
                }
            }
        }
        Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.w("[Scheme] if this isn't a hierarchical URI. Throwable: " + thM7418exceptionOrNullimpl.getMessage());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Scheme(String stringUrl) {
        Intrinsics.checkNotNullParameter(stringUrl, "stringUrl");
        Uri uri = Uri.parse(stringUrl);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        this(uri);
    }
}
