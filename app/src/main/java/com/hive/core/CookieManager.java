package com.hive.core;

import com.google.common.net.HttpHeaders;
import com.hive.core.Logger;
import io.ktor.sse.ServerSentEventKt;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CookieManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007*\u0001\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0007J\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\fJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJ\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bJ\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u0014\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/hive/core/CookieManager;", "", "<init>", "()V", "HttpClientCookieHandler", "com/hive/core/CookieManager$HttpClientCookieHandler$1", "Lcom/hive/core/CookieManager$HttpClientCookieHandler$1;", "startSync", "", "stopSync", "getCookie", "", "", "domain", "", "key", "setCookie", "value", "mapCookie", "removeCookie", "syncCookie", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CookieManager {
    public static final CookieManager INSTANCE = new CookieManager();
    private static final CookieManager$HttpClientCookieHandler$1 HttpClientCookieHandler = new CookieHandler() { // from class: com.hive.core.CookieManager$HttpClientCookieHandler$1
        private final android.webkit.CookieManager webViewCookieManager = android.webkit.CookieManager.getInstance();

        public final android.webkit.CookieManager getWebViewCookieManager() {
            return this.webViewCookieManager;
        }

        @Override // java.net.CookieHandler
        public Map<String, List<String>> get(URI uri, Map<String, List<String>> requestHeaders) {
            String cookie = this.webViewCookieManager.getCookie(uri != null ? uri.toString() : null);
            if (cookie == null) {
                cookie = "";
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(HttpHeaders.COOKIE, Arrays.asList(cookie));
            return linkedHashMap;
        }

        @Override // java.net.CookieHandler
        public void put(URI uri, Map<String, List<String>> responseHeaders) {
            if (responseHeaders != null) {
                for (String str : responseHeaders.keySet()) {
                    if (StringsKt.equals(str, HttpHeaders.SET_COOKIE, true) || StringsKt.equals(str, HttpHeaders.SET_COOKIE2, true)) {
                        List<String> list = responseHeaders.get(str);
                        if (list != null) {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                this.webViewCookieManager.setCookie(String.valueOf(uri), it.next());
                            }
                        }
                    }
                }
            }
        }
    };

    @Deprecated(message = "4.16.4")
    public final void stopSync() {
    }

    private CookieManager() {
    }

    public final void startSync() {
        if (CookieHandler.getDefault() == null || CookieHandler.getDefault() != HttpClientCookieHandler) {
            CookieHandler.setDefault(HttpClientCookieHandler);
        }
    }

    public final Map<String, String> getCookie(String domain) {
        List listEmptyList;
        List listEmptyList2;
        Intrinsics.checkNotNullParameter(domain, "domain");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String cookie = android.webkit.CookieManager.getInstance().getCookie(domain);
        if (cookie == null) {
            return linkedHashMap;
        }
        List<String> listSplit = new Regex(";").split(cookie, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        for (String str : (String[]) listEmptyList.toArray(new String[0])) {
            List<String> listSplit2 = new Regex("=").split(str, 0);
            if (!listSplit2.isEmpty()) {
                ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                while (listIterator2.hasPrevious()) {
                    if (listIterator2.previous().length() != 0) {
                        listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList2 = CollectionsKt.emptyList();
            } else {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            String[] strArr = (String[]) listEmptyList2.toArray(new String[0]);
            if (strArr.length > 1) {
                try {
                    String str2 = strArr[0];
                    String str3 = strArr[1];
                    String strDecode = URLDecoder.decode(str2, "UTF-8");
                    Intrinsics.checkNotNullExpressionValue(strDecode, "decode(...)");
                    String strDecode2 = URLDecoder.decode(str3, "UTF-8");
                    Intrinsics.checkNotNullExpressionValue(strDecode2, "decode(...)");
                    if (StringsKt.startsWith$default(strDecode, ServerSentEventKt.SPACE, false, 2, (Object) null)) {
                        strDecode = strDecode.substring(1);
                        Intrinsics.checkNotNullExpressionValue(strDecode, "substring(...)");
                    }
                    linkedHashMap.put(strDecode, strDecode2);
                } catch (UnsupportedEncodingException e) {
                    Logger.INSTANCE.coreLog$hive_core_release("[CookieManager] getCookie() e: " + e.getMessage(), Logger.LogType.Warning);
                }
            }
        }
        return linkedHashMap;
    }

    public final List<String> getCookie(String domain, String key) {
        List listEmptyList;
        List listEmptyList2;
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayList arrayList = new ArrayList();
        String cookie = android.webkit.CookieManager.getInstance().getCookie(domain);
        if (cookie == null) {
            return arrayList;
        }
        List<String> listSplit = new Regex(";").split(cookie, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        for (String str : (String[]) listEmptyList.toArray(new String[0])) {
            List<String> listSplit2 = new Regex("=").split(str, 0);
            if (!listSplit2.isEmpty()) {
                ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                while (listIterator2.hasPrevious()) {
                    if (listIterator2.previous().length() != 0) {
                        listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList2 = CollectionsKt.emptyList();
            } else {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            String[] strArr = (String[]) listEmptyList2.toArray(new String[0]);
            if (strArr.length > 1 && StringsKt.equals(key, strArr[0], true)) {
                try {
                    String strDecode = URLDecoder.decode(strArr[1], "UTF-8");
                    Intrinsics.checkNotNullExpressionValue(strDecode, "decode(...)");
                    Boolean.valueOf(arrayList.add(strDecode));
                } catch (UnsupportedEncodingException e) {
                    Logger.INSTANCE.coreLog$hive_core_release("[CookieManager] getCookie() e: " + e.getMessage(), Logger.LogType.Warning);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        return arrayList;
    }

    public final void setCookie(String domain, String key, String value) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        try {
            String strEncode = URLEncoder.encode(value, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%s=%s; path=/; domain=%s", Arrays.copyOf(new Object[]{key, strEncode, domain}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            cookieManager.setCookie(domain, str);
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[CookieManager] setCookie() e: " + e.getMessage(), Logger.LogType.Warning);
        }
        syncCookie();
    }

    public final void setCookie(String domain, Map<String, String> mapCookie) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(mapCookie, "mapCookie");
        android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        for (Map.Entry<String, String> entry : mapCookie.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = new String();
            }
            try {
                String strEncode = URLEncoder.encode(value, "UTF-8");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%s=%s; path=/; domain=%s;", Arrays.copyOf(new Object[]{key, strEncode, domain}, 3));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                cookieManager.setCookie(domain, str);
            } catch (Exception e) {
                Logger.INSTANCE.coreLog$hive_core_release("[CookieManager] setCookie() e: " + e.getMessage(), Logger.LogType.Warning);
            }
        }
        syncCookie();
    }

    public final void removeCookie(String domain, String key) {
        List listEmptyList;
        List listEmptyList2;
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(key, "key");
        android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        String cookie = cookieManager.getCookie(domain);
        if (cookie == null) {
            return;
        }
        List<String> listSplit = new Regex(";").split(cookie, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        for (String str : (String[]) listEmptyList.toArray(new String[0])) {
            List<String> listSplit2 = new Regex("=").split(str, 0);
            if (!listSplit2.isEmpty()) {
                ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                while (listIterator2.hasPrevious()) {
                    if (listIterator2.previous().length() != 0) {
                        listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList2 = CollectionsKt.emptyList();
            } else {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            String[] strArr = (String[]) listEmptyList2.toArray(new String[0]);
            if (strArr.length > 0 && StringsKt.equals(key, strArr[0], true)) {
                StringBuilder sb = new StringBuilder();
                String str2 = strArr[0];
                int length = str2.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                sb.append(str2.subSequence(i, length + 1).toString());
                sb.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                cookieManager.setCookie(domain, sb.toString());
            }
        }
        syncCookie();
    }

    public final void removeCookie(String domain) {
        List listEmptyList;
        List listEmptyList2;
        Intrinsics.checkNotNullParameter(domain, "domain");
        android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        String cookie = cookieManager.getCookie(domain);
        if (cookie == null) {
            return;
        }
        List<String> listSplit = new Regex(";").split(cookie, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        for (String str : (String[]) listEmptyList.toArray(new String[0])) {
            List<String> listSplit2 = new Regex("=").split(str, 0);
            if (!listSplit2.isEmpty()) {
                ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                while (listIterator2.hasPrevious()) {
                    if (listIterator2.previous().length() != 0) {
                        listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList2 = CollectionsKt.emptyList();
            } else {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            String[] strArr = (String[]) listEmptyList2.toArray(new String[0]);
            if (strArr.length > 0) {
                StringBuilder sb = new StringBuilder();
                String str2 = strArr[0];
                int length = str2.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                sb.append(str2.subSequence(i, length + 1).toString());
                sb.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                cookieManager.setCookie(domain, sb.toString());
            }
        }
        syncCookie();
    }

    private final void syncCookie() {
        android.webkit.CookieManager.getInstance().flush();
    }
}
