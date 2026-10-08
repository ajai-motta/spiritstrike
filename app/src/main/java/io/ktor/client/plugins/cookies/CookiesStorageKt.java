package io.ktor.client.plugins.cookies;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import io.ktor.http.Cookie;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CookiesStorage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a$\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\u000b\u001a\u00020\n*\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/cookies/CookiesStorage;", "", "urlString", "Lio/ktor/http/Cookie;", "cookie", "", "addCookie", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/lang/String;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/Url;", "requestUrl", "", "matches", "(Lio/ktor/http/Cookie;Lio/ktor/http/Url;)Z", "fillDefaults", "(Lio/ktor/http/Cookie;Lio/ktor/http/Url;)Lio/ktor/http/Cookie;", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CookiesStorageKt {
    public static final Object addCookie(CookiesStorage cookiesStorage, String str, Cookie cookie, Continuation<? super Unit> continuation) {
        Object objAddCookie = cookiesStorage.addCookie(URLUtilsKt.Url(str), cookie, continuation);
        return objAddCookie == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAddCookie : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
    
        if (kotlin.text.StringsKt.endsWith$default(r3, "." + r0, false, 2, (java.lang.Object) null) == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean matches(io.ktor.http.Cookie r10, io.ktor.http.Url r11) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.CookiesStorageKt.matches(io.ktor.http.Cookie, io.ktor.http.Url):boolean");
    }

    public static final Cookie fillDefaults(Cookie cookie, Url requestUrl) {
        Cookie cookieCopy = cookie;
        Intrinsics.checkNotNullParameter(cookie, "<this>");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        String path = cookie.getPath();
        if (path == null || !StringsKt.startsWith$default(path, DomExceptionUtils.SEPARATOR, false, 2, (Object) null)) {
            cookieCopy = cookie.copy((991 & 1) != 0 ? cookie.name : null, (991 & 2) != 0 ? cookie.value : null, (991 & 4) != 0 ? cookie.encoding : null, (991 & 8) != 0 ? cookie.maxAge : null, (991 & 16) != 0 ? cookie.expires : null, (991 & 32) != 0 ? cookie.domain : null, (991 & 64) != 0 ? cookie.path : requestUrl.getEncodedPath(), (991 & 128) != 0 ? cookie.secure : false, (991 & 256) != 0 ? cookie.httpOnly : false, (991 & 512) != 0 ? cookie.extensions : null);
        }
        String domain = cookieCopy.getDomain();
        return (domain == null || StringsKt.isBlank(domain)) ? cookieCopy.copy((991 & 1) != 0 ? cookieCopy.name : null, (991 & 2) != 0 ? cookieCopy.value : null, (991 & 4) != 0 ? cookieCopy.encoding : null, (991 & 8) != 0 ? cookieCopy.maxAge : null, (991 & 16) != 0 ? cookieCopy.expires : null, (991 & 32) != 0 ? cookieCopy.domain : requestUrl.getHost(), (991 & 64) != 0 ? cookieCopy.path : null, (991 & 128) != 0 ? cookieCopy.secure : false, (991 & 256) != 0 ? cookieCopy.httpOnly : false, (991 & 512) != 0 ? cookieCopy.extensions : null) : cookieCopy;
    }
}
