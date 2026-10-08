package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.webkit.ProxyConfig;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements h {
    public static final Pattern o = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference p = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1456a;
    public final int b;
    public final int c;
    public final String d;
    public final w e;
    public final w f;
    public final m g;
    public HttpURLConnection h;
    public InputStream i;
    public boolean j;
    public long k;
    public long l;
    public long m;
    public long n;

    public p(String str, m mVar, int i, int i2, boolean z, w wVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.d = str;
        this.g = mVar;
        this.f = new w();
        this.b = i;
        this.c = i2;
        this.f1456a = z;
        this.e = wVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        HttpURLConnection httpURLConnection = this.h;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final HttpURLConnection b(k kVar) throws IOException {
        URL url = new URL(kVar.f1451a.toString());
        long j = kVar.c;
        long j2 = kVar.d;
        int i = 0;
        boolean z = (kVar.f & 1) == 1;
        if (!this.f1456a) {
            return a(url, null, j, j2, z, true);
        }
        while (true) {
            int i2 = i + 1;
            if (i > 20) {
                throw new NoRouteToHostException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("Too many redirects: ", i2));
            }
            HttpURLConnection httpURLConnectionA = a(url, null, j, j2, z, false);
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                return httpURLConnectionA;
            }
            String headerField = httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION);
            httpURLConnectionA.disconnect();
            if (headerField == null) {
                throw new ProtocolException("Null location redirect");
            }
            URL url2 = new URL(url, headerField);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                throw new ProtocolException("Unsupported protocol redirect: " + protocol);
            }
            i = i2;
            url = url2;
        }
    }

    public final void c() throws IOException {
        if (this.m == this.k) {
            return;
        }
        byte[] bArr = (byte[]) p.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[4096];
        }
        while (true) {
            long j = this.m;
            long j2 = this.k;
            if (j == j2) {
                p.set(bArr);
                return;
            }
            int i = this.i.read(bArr, 0, (int) Math.min(j2 - j, bArr.length));
            if (Thread.interrupted()) {
                throw new InterruptedIOException();
            }
            if (i == -1) {
                throw new EOFException();
            }
            long j3 = i;
            this.m += j3;
            m mVar = this.g;
            if (mVar != null) {
                synchronized (mVar) {
                    mVar.d += j3;
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() {
        try {
            if (this.i != null) {
                HttpURLConnection httpURLConnection = this.h;
                long j = this.l;
                if (j != -1) {
                    j -= this.n;
                }
                a(httpURLConnection, j);
                try {
                    this.i.close();
                } catch (IOException e) {
                    throw new u(e);
                }
            }
        } finally {
            this.i = null;
            b();
            if (this.j) {
                this.j = false;
                m mVar = this.g;
                if (mVar != null) {
                    mVar.a();
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) throws u {
        try {
            c();
            return a(bArr, i, i2);
        } catch (IOException e) {
            throw new u(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e7  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.k r15) throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.u {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.p.a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.k):long");
    }

    public final HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        Map map;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.c);
        w wVar = this.e;
        if (wVar != null) {
            synchronized (wVar) {
                if (wVar.b == null) {
                    wVar.b = Collections.unmodifiableMap(new HashMap(wVar.f1460a));
                }
                map = wVar.b;
            }
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Map.Entry entry2 : this.f.a().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, str);
        }
        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, this.d);
        if (!z) {
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    public final int a(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.l;
        if (j != -1) {
            long j2 = j - this.n;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = this.i.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.l == -1) {
                return -1;
            }
            throw new EOFException();
        }
        long j3 = i3;
        this.n += j3;
        m mVar = this.g;
        if (mVar != null) {
            synchronized (mVar) {
                mVar.d += j3;
            }
        }
        return i3;
    }

    public static void a(HttpURLConnection httpURLConnection, long j) {
        int i = com.fyber.inneractive.sdk.player.exoplayer2.util.z.f1480a;
        if (i == 19 || i == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", null);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, null);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void b() {
        HttpURLConnection httpURLConnection = this.h;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.h = null;
        }
    }
}
