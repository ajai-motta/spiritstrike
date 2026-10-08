package extern.okhttp3.internal.http;

import extern.okhttp3.Cookie;
import extern.okhttp3.CookieJar;
import extern.okhttp3.Interceptor;
import extern.okhttp3.MediaType;
import extern.okhttp3.Request;
import extern.okhttp3.RequestBody;
import extern.okhttp3.Response;
import extern.okhttp3.internal.Util;
import extern.okhttp3.internal.Version;
import extern.okio.GzipSource;
import extern.okio.Okio;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    @Override // extern.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                builderNewBuilder.header("Content-Type", mediaTypeContentType.toString());
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                builderNewBuilder.header(com.google.common.net.HttpHeaders.CONTENT_LENGTH, Long.toString(jContentLength));
                builderNewBuilder.removeHeader(com.google.common.net.HttpHeaders.TRANSFER_ENCODING);
            } else {
                builderNewBuilder.header(com.google.common.net.HttpHeaders.TRANSFER_ENCODING, "chunked");
                builderNewBuilder.removeHeader(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (request.header(com.google.common.net.HttpHeaders.HOST) == null) {
            builderNewBuilder.header(com.google.common.net.HttpHeaders.HOST, Util.hostHeader(request.url(), false));
        }
        if (request.header(com.google.common.net.HttpHeaders.CONNECTION) == null) {
            builderNewBuilder.header(com.google.common.net.HttpHeaders.CONNECTION, com.google.common.net.HttpHeaders.KEEP_ALIVE);
        }
        if (request.header(com.google.common.net.HttpHeaders.ACCEPT_ENCODING) == null && request.header(com.google.common.net.HttpHeaders.RANGE) == null) {
            z = true;
            builderNewBuilder.header(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
        List<Cookie> listLoadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!listLoadForRequest.isEmpty()) {
            builderNewBuilder.header(com.google.common.net.HttpHeaders.COOKIE, cookieHeader(listLoadForRequest));
        }
        if (request.header(com.google.common.net.HttpHeaders.USER_AGENT) == null) {
            builderNewBuilder.header(com.google.common.net.HttpHeaders.USER_AGENT, Version.userAgent());
        }
        Response responseProceed = chain.proceed(builderNewBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), responseProceed.headers());
        Response.Builder builderRequest = responseProceed.newBuilder().request(request);
        if (z && "gzip".equalsIgnoreCase(responseProceed.header(com.google.common.net.HttpHeaders.CONTENT_ENCODING)) && HttpHeaders.hasBody(responseProceed)) {
            GzipSource gzipSource = new GzipSource(responseProceed.body().source());
            builderRequest.headers(responseProceed.headers().newBuilder().removeAll(com.google.common.net.HttpHeaders.CONTENT_ENCODING).removeAll(com.google.common.net.HttpHeaders.CONTENT_LENGTH).build());
            builderRequest.body(new RealResponseBody(responseProceed.header("Content-Type"), -1L, Okio.buffer(gzipSource)));
        }
        return builderRequest.build();
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
        }
        return sb.toString();
    }
}
