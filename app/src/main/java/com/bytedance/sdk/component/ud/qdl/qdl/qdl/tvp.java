package com.bytedance.sdk.component.ud.qdl.qdl.qdl;

import com.bytedance.sdk.component.ud.qdl.bjy;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes3.dex */
public class tvp extends bjy {
    HttpURLConnection qdl;
    InputStream ud;

    tvp(HttpURLConnection httpURLConnection) throws IOException {
        this.qdl = httpURLConnection;
        this.ud = new wd(httpURLConnection.getInputStream(), httpURLConnection);
    }

    tvp(HttpURLConnection httpURLConnection, InputStream inputStream) {
        this.qdl = httpURLConnection;
        this.ud = new wd(inputStream, httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.ud.qdl.bjy
    public long qdl() {
        try {
            return this.qdl.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.ud.qdl.bjy
    public String ud() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.ud));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    stringBuffer.append(line + "\n");
                } else {
                    String string = stringBuffer.toString();
                    close();
                    return string;
                }
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.ud.qdl.bjy, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.ud.close();
            this.qdl.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.ud.qdl.bjy
    public InputStream lnr() {
        return this.ud;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.bjy
    public byte[] mml() {
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = this.ud.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.ud.qdl.bjy
    public com.bytedance.sdk.component.ud.qdl.tvp mzz() {
        if (this.qdl.getContentType() != null) {
            return com.bytedance.sdk.component.ud.qdl.tvp.qdl(this.qdl.getContentType());
        }
        return null;
    }
}
