package com.bytedance.sdk.component.ud.qdl.qdl.qdl;

import android.text.TextUtils;
import com.bytedance.sdk.component.ud.qdl.bjy;
import com.bytedance.sdk.component.ud.qdl.fs;
import com.bytedance.sdk.component.ud.qdl.rdp;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class jpc extends rdp {
    public static int qdl = -1;
    fs lnr;
    int mml;
    String mzz;
    HttpURLConnection ud;

    @Override // com.bytedance.sdk.component.ud.qdl.rdp
    public long qdl() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.rdp
    public long ud() {
        return 0L;
    }

    public jpc(HttpURLConnection httpURLConnection, fs fsVar) {
        this.mml = qdl;
        this.ud = httpURLConnection;
        this.lnr = fsVar;
    }

    public jpc(int i, String str, fs fsVar) {
        this.mzz = str;
        this.lnr = fsVar;
        this.mml = i;
    }

    public fs tvp() {
        return this.lnr;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.rdp
    public int lnr() {
        try {
            return this.ud.getResponseCode();
        } catch (Exception unused) {
            return this.mml;
        }
    }

    @Override // com.bytedance.sdk.component.ud.qdl.rdp
    public boolean mml() {
        return lnr() >= 200 && lnr() < 300;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.rdp
    public String mzz() throws IOException {
        if (!TextUtils.isEmpty(this.mzz)) {
            return this.mzz;
        }
        return this.ud.getResponseMessage();
    }

    @Override // com.bytedance.sdk.component.ud.qdl.rdp
    public bjy mo() {
        tvp tvpVar;
        fs fsVar = this.lnr;
        if (fsVar != null && fsVar.ud != null) {
            this.lnr.ud.rq();
        }
        try {
            try {
                tvpVar = new tvp(this.ud);
            } catch (Exception unused) {
                HttpURLConnection httpURLConnection = this.ud;
                tvpVar = new tvp(httpURLConnection, httpURLConnection.getErrorStream());
            }
        } catch (Throwable th) {
            th.getMessage();
            tvpVar = null;
        }
        fs fsVar2 = this.lnr;
        if (fsVar2 != null && fsVar2.ud != null) {
            this.lnr.ud.exu();
        }
        return tvpVar;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.rdp
    public com.bytedance.sdk.component.ud.qdl.mo wd() {
        if (this.ud == null) {
            return new com.bytedance.sdk.component.ud.qdl.mo(new String[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.ud.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!HttpHeaders.CONTENT_RANGE.equalsIgnoreCase(entry.getKey()) || lnr() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.ud.qdl.mo((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.bytedance.sdk.component.ud.qdl.rdp, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            mo().close();
        } catch (Exception unused) {
        }
    }

    public String toString() {
        return "";
    }

    @Override // com.bytedance.sdk.component.ud.qdl.rdp
    public com.bytedance.sdk.component.ud.qdl.to jpc() {
        if (tvp() == null || tvp().ud == null) {
            return null;
        }
        return new com.bytedance.sdk.component.ud.qdl.to(tvp().ud);
    }
}
