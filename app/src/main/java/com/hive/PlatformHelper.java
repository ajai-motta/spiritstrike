package com.hive;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.logger.LoggerImpl;
import com.hive.platformhelper.PlatformHelperImpl;
import com.hive.platformhelper.PlatformShare;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007 !\"#$%&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001e\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u000e\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u001aH\u0007J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u001fH\u0007R$\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006'"}, d2 = {"Lcom/hive/PlatformHelper;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "share", "", "platformShare", "Lcom/hive/platformhelper/PlatformShare;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/PlatformHelper$PlatformHelperListener;", "requestUserPermissions", "requests", "", "Lcom/hive/PlatformHelper$RequestUserPermissionsListener;", "completeUpdate", "completeState", "", "showInAppBrowser", "param", "Lcom/hive/PlatformHelper$InAppBrowserParam;", "Lcom/hive/PlatformHelper$InAppBrowserListener;", "showInAppWebView", "Lcom/hive/PlatformHelper$InAppWebViewParam;", "Lcom/hive/PlatformHelper$InAppWebViewListener;", "getLaunchParameters", "Lcom/hive/PlatformHelper$PlatformHelperParametersListener;", "PlatformHelperListener", "RequestUserPermissionsListener", "InAppBrowserParam", "InAppBrowserListener", "InAppWebViewParam", "InAppWebViewListener", "PlatformHelperParametersListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlatformHelper {
    public static final PlatformHelper INSTANCE = new PlatformHelper();
    private static final String TAG = "PlatformHelper";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/PlatformHelper$InAppBrowserListener;", "", "onInAppBrowser", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface InAppBrowserListener {
        void onInAppBrowser(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/hive/PlatformHelper$InAppBrowserParam;", "", "url", "", "navigationColor", "urlBarHiding", "", "autoRedirectToExternalBrowser", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getUrl", "()Ljava/lang/String;", "getNavigationColor", "getUrlBarHiding", "()Z", "getAutoRedirectToExternalBrowser", InAppPurchaseConstants.METHOD_TO_STRING, "Builder", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InAppBrowserParam {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean autoRedirectToExternalBrowser;
        private final String navigationColor;
        private final String url;
        private final boolean urlBarHiding;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/hive/PlatformHelper$InAppBrowserParam$Builder;", "", "url", "", "<init>", "(Ljava/lang/String;)V", "navigationColor", "urlBarHiding", "", "autoRedirectToExternalBrowser", "setNavigationColor", "color", "setUrlBarHiding", "enable", "setAutoRedirectToExternalBrowser", InAppPurchaseConstants.METHOD_BUILD, "Lcom/hive/PlatformHelper$InAppBrowserParam;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Builder {
            private boolean autoRedirectToExternalBrowser;
            private String navigationColor;
            private String url;
            private boolean urlBarHiding;

            public Builder(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
                this.urlBarHiding = true;
                this.autoRedirectToExternalBrowser = true;
            }

            public final InAppBrowserParam build() {
                return new InAppBrowserParam(this.url, this.navigationColor, this.urlBarHiding, this.autoRedirectToExternalBrowser, null);
            }

            public final Builder setAutoRedirectToExternalBrowser(boolean enable) {
                this.autoRedirectToExternalBrowser = enable;
                return this;
            }

            public final Builder setNavigationColor(String color) {
                Intrinsics.checkNotNullParameter(color, "color");
                this.navigationColor = color;
                return this;
            }

            public final Builder setUrlBarHiding(boolean enable) {
                this.urlBarHiding = enable;
                return this;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/PlatformHelper$InAppBrowserParam$Companion;", "", "<init>", "()V", "createFromJson", "Lcom/hive/PlatformHelper$InAppBrowserParam;", "source", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final InAppBrowserParam createFromJson(String source) {
                Object objM7415constructorimpl;
                Intrinsics.checkNotNullParameter(source, "source");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONObject jSONObject = new JSONObject(source);
                    String strOptString = jSONObject.optString("url");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    String strOptString2 = jSONObject.optString("navigationColor");
                    Intrinsics.checkNotNull(strOptString2);
                    objM7415constructorimpl = Result.m7415constructorimpl(new InAppBrowserParam(strOptString, !StringsKt.isBlank(strOptString2) ? strOptString2 : null, jSONObject.optBoolean("urlBarHiding", true), jSONObject.optBoolean("autoRedirectToExternalBrowser", true), null));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                return (InAppBrowserParam) (Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
            }

            private Companion() {
            }
        }

        public /* synthetic */ InAppBrowserParam(String str, String str2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z, z2);
        }

        public final boolean getAutoRedirectToExternalBrowser() {
            return this.autoRedirectToExternalBrowser;
        }

        public final String getNavigationColor() {
            return this.navigationColor;
        }

        public final String getUrl() {
            return this.url;
        }

        public final boolean getUrlBarHiding() {
            return this.urlBarHiding;
        }

        public String toString() {
            return "[url = " + this.url + ", navigationColor = " + this.navigationColor + ", enableUrlBarHiding = " + this.urlBarHiding + AbstractJsonLexerKt.END_LIST;
        }

        private InAppBrowserParam(String str, String str2, boolean z, boolean z2) {
            this.url = str;
            this.navigationColor = str2;
            this.urlBarHiding = z;
            this.autoRedirectToExternalBrowser = z2;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/PlatformHelper$InAppWebViewListener;", "", "onInAppWebView", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface InAppWebViewListener {
        void onInAppWebView(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/hive/PlatformHelper$InAppWebViewParam;", "", "url", "", "postData", "useUserSession", "", "useGameWindow", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getUrl", "()Ljava/lang/String;", "getPostData", "getUseUserSession", "()Z", "getUseGameWindow", InAppPurchaseConstants.METHOD_TO_STRING, "Builder", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InAppWebViewParam {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String postData;
        private final String url;
        private final boolean useGameWindow;
        private final boolean useUserSession;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/hive/PlatformHelper$InAppWebViewParam$Builder;", "", "url", "", "<init>", "(Ljava/lang/String;)V", "postData", "useUserSession", "", "useGameWindow", "setPostData", "setUseUserSession", "enable", "setUseGameWindow", InAppPurchaseConstants.METHOD_BUILD, "Lcom/hive/PlatformHelper$InAppWebViewParam;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Builder {
            private String postData;
            private String url;
            private boolean useGameWindow;
            private boolean useUserSession;

            public Builder(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
            }

            public final InAppWebViewParam build() {
                return new InAppWebViewParam(this.url, this.postData, this.useUserSession, this.useGameWindow, null);
            }

            public final Builder setPostData(String postData) {
                this.postData = postData;
                return this;
            }

            public final Builder setUseGameWindow(boolean enable) {
                this.useGameWindow = enable;
                return this;
            }

            public final Builder setUseUserSession(boolean enable) {
                this.useUserSession = enable;
                return this;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/PlatformHelper$InAppWebViewParam$Companion;", "", "<init>", "()V", "createFromJson", "Lcom/hive/PlatformHelper$InAppWebViewParam;", "source", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final InAppWebViewParam createFromJson(String source) {
                Object objM7415constructorimpl;
                Intrinsics.checkNotNullParameter(source, "source");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONObject jSONObject = new JSONObject(source);
                    String strOptString = jSONObject.optString("url");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    String strOptString2 = jSONObject.optString("postData");
                    Intrinsics.checkNotNull(strOptString2);
                    objM7415constructorimpl = Result.m7415constructorimpl(new InAppWebViewParam(strOptString, !StringsKt.isBlank(strOptString2) ? strOptString2 : null, jSONObject.optBoolean("useUserSession", false), jSONObject.optBoolean("useGameWindow", false), null));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                return (InAppWebViewParam) (Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
            }

            private Companion() {
            }
        }

        public /* synthetic */ InAppWebViewParam(String str, String str2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z, z2);
        }

        public final String getPostData() {
            return this.postData;
        }

        public final String getUrl() {
            return this.url;
        }

        public final boolean getUseGameWindow() {
            return this.useGameWindow;
        }

        public final boolean getUseUserSession() {
            return this.useUserSession;
        }

        public String toString() {
            return "[url = " + this.url + ", postData = " + this.postData + ", useUserSession = " + this.useUserSession + ", useGameWindow = " + this.useGameWindow + AbstractJsonLexerKt.END_LIST;
        }

        private InAppWebViewParam(String str, String str2, boolean z, boolean z2) {
            this.url = str;
            this.postData = str2;
            this.useUserSession = z;
            this.useGameWindow = z2;
        }

        public /* synthetic */ InAppWebViewParam(String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/hive/PlatformHelper$PlatformHelperListener;", "", "onShare", "", "isSuccess", "", "(Ljava/lang/Boolean;)V", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PlatformHelperListener {
        void onShare(Boolean isSuccess);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/PlatformHelper$PlatformHelperParametersListener;", "", "onParameters", "", "result", "Lcom/hive/ResultAPI;", "parameters", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PlatformHelperParametersListener {
        void onParameters(ResultAPI result, String parameters);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\n"}, d2 = {"Lcom/hive/PlatformHelper$RequestUserPermissionsListener;", "", "onRequestUserPermissions", "", "result", "Lcom/hive/ResultAPI;", Analytics.CONSENT_GRANTED, "", "", Analytics.CONSENT_DENIED, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface RequestUserPermissionsListener {
        void onRequestUserPermissions(ResultAPI result, List<String> granted, List<String> denied);
    }

    private PlatformHelper() {
    }

    @JvmStatic
    public static final void completeUpdate(int completeState) {
        PlatformHelperImpl.INSTANCE.completeUpdate(completeState);
    }

    public static /* synthetic */ void completeUpdate$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        completeUpdate(i);
    }

    @JvmStatic
    public static final void getLaunchParameters(PlatformHelperParametersListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        PlatformHelperImpl.INSTANCE.getLaunchParameters(listener);
        loggerImpl.apiReturnLog(str, "");
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    @JvmStatic
    public static final void requestUserPermissions(List<String> requests, RequestUserPermissionsListener listener) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        PlatformHelperImpl.INSTANCE.requestUserPermissions(requests, listener);
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void share(PlatformShare platformShare, PlatformHelperListener listener) {
        Intrinsics.checkNotNullParameter(platformShare, "platformShare");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        PlatformHelperImpl.INSTANCE.share(platformShare, listener);
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void showInAppBrowser(InAppBrowserParam param, InAppBrowserListener listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, param.toString());
        PlatformHelperImpl.INSTANCE.showInAppBrowser(param, listener);
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void showInAppWebView(InAppWebViewParam param, InAppWebViewListener listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, param.toString());
        PlatformHelperImpl.INSTANCE.showInAppWebView(param, listener);
        loggerImpl.apiReturnLog(str, "");
    }
}
