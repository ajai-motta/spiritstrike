package com.bytedance.sdk.component.ud.qdl.qdl.qdl;

import android.text.TextUtils;
import com.bytedance.sdk.component.ud.qdl.exu;
import com.bytedance.sdk.component.ud.qdl.fs;
import com.bytedance.sdk.component.ud.qdl.jpc;
import com.bytedance.sdk.component.ud.qdl.rdp;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class ud implements com.bytedance.sdk.component.ud.qdl.ud {
    private static List<Object> mml;
    private AtomicBoolean lnr = new AtomicBoolean(false);
    fs qdl;
    com.bytedance.sdk.component.ud.qdl.mml ud;

    static {
        try {
            mml = new ArrayList();
            Class<?> cls = Class.forName("com.android.okhttp.Protocol");
            Enum enumValueOf = Enum.valueOf(cls, "HTTP_1_1");
            if (enumValueOf != null) {
                mml.add(enumValueOf);
            }
            Enum enumValueOf2 = Enum.valueOf(cls, "HTTP_2");
            if (enumValueOf2 != null) {
                mml.add(enumValueOf2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    ud(fs fsVar, com.bytedance.sdk.component.ud.qdl.mml mmlVar) {
        this.qdl = fsVar;
        this.ud = mmlVar;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud
    public fs qdl() {
        return this.qdl;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud
    public rdp ud() throws IOException {
        fs fsVar = this.qdl;
        if (fsVar != null && fsVar.ud != null) {
            if (this.qdl.ud.rdp() == 0) {
                this.qdl.ud.bjy();
            }
            this.qdl.ud.qdl();
        }
        this.ud.lnr().remove(this);
        this.ud.mml().add(this);
        com.bytedance.sdk.component.ud.qdl.mml mmlVar = this.ud;
        if ((mmlVar instanceof mo) && (mmlVar.lnr().size() + this.ud.mml().size() > this.ud.qdl() || this.lnr.get())) {
            this.ud.mml().remove(this);
            return new jpc(jpc.qdl, "Maximum number of requests exceeded", this.qdl);
        }
        try {
            if (this.qdl.qdl != null && this.qdl.qdl.qdl != null && this.qdl.qdl.qdl.size() > 0) {
                ArrayList arrayList = new ArrayList(this.qdl.qdl.qdl);
                arrayList.add(new com.bytedance.sdk.component.ud.qdl.jpc() { // from class: com.bytedance.sdk.component.ud.qdl.qdl.qdl.ud.1
                    @Override // com.bytedance.sdk.component.ud.qdl.jpc
                    public rdp qdl(jpc.qdl qdlVar) throws IOException {
                        return ud.this.qdl(qdlVar.qdl());
                    }
                });
                return ((com.bytedance.sdk.component.ud.qdl.jpc) arrayList.get(0)).qdl(new lnr(arrayList, this.qdl));
            }
            return qdl(this.qdl);
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    private boolean qdl(exu exuVar) {
        fs fsVar;
        return exuVar != null && (fsVar = this.qdl) != null && "POST".equalsIgnoreCase(fsVar.lnr()) && exuVar.mo == exu.qdl.BYTE_ARRAY_TYPE && exuVar.mzz != null && exuVar.mzz.length > 0;
    }

    private boolean ud(exu exuVar) {
        fs fsVar;
        return (exuVar == null || (fsVar = this.qdl) == null || !"POST".equalsIgnoreCase(fsVar.lnr()) || exuVar.mo != exu.qdl.STRING_TYPE || TextUtils.isEmpty(exuVar.mml)) ? false : true;
    }

    public rdp qdl(fs fsVar) throws IOException {
        return qdl(fsVar, com.bytedance.sdk.component.wd.qdl.mzz());
    }

    public rdp qdl(fs fsVar, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        IOException e;
        String strQdl;
        int responseCode = jpc.qdl;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(fsVar.ud().qdl().toString()).openConnection();
                if (z) {
                    try {
                        if (!"setting".equals(fsVar.mo()) && !"gecko".equals(fsVar.mo()) && !"load_ug_t".equals(fsVar.mo())) {
                            qdl(httpURLConnection);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        if (responseCode == -1 && z) {
                            return qdl(fsVar, false);
                        }
                        strQdl = qdl(httpURLConnection, e);
                    } catch (Exception e3) {
                        e = e3;
                        httpURLConnection2 = httpURLConnection;
                        strQdl = qdl(httpURLConnection2, e);
                    }
                }
                if (fsVar.mml() != null && fsVar.mml().size() > 0) {
                    for (Map.Entry<String, List<String>> entry : fsVar.mml().entrySet()) {
                        String key = entry.getKey();
                        for (String str : entry.getValue()) {
                            if ("_disable_retry".equals(key) && "1".equals(str)) {
                                ud(httpURLConnection);
                            } else {
                                httpURLConnection.addRequestProperty(key, str);
                            }
                        }
                    }
                }
                if (fsVar.qdl != null) {
                    if (fsVar.qdl.lnr != null) {
                        httpURLConnection.setConnectTimeout((int) fsVar.qdl.lnr.toMillis(fsVar.qdl.ud));
                    }
                    if (fsVar.qdl.lnr != null) {
                        httpURLConnection.setReadTimeout((int) fsVar.qdl.mzz.toMillis(fsVar.qdl.mml));
                    }
                }
                if (fsVar.jpc() == null) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    if (!mzz() && fsVar.jpc().lnr != null) {
                        httpURLConnection.addRequestProperty("Content-Type", fsVar.jpc().lnr.qdl());
                    }
                    httpURLConnection.setRequestMethod(fsVar.lnr());
                    if ("POST".equalsIgnoreCase(fsVar.lnr())) {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        if (qdl(fsVar.jpc())) {
                            outputStream.write(fsVar.jpc().mzz);
                        } else if (ud(fsVar.jpc())) {
                            outputStream.write(fsVar.jpc().mml.getBytes());
                        }
                        outputStream.flush();
                        outputStream.close();
                    }
                }
                if (fsVar != null && fsVar.ud != null) {
                    fsVar.ud.ud();
                }
                httpURLConnection.connect();
                if (fsVar != null && fsVar.ud != null) {
                    fsVar.ud.lnr();
                }
                responseCode = httpURLConnection.getResponseCode();
                if (fsVar != null && fsVar.ud != null) {
                    fsVar.ud.mzz();
                }
            } catch (IOException e4) {
                httpURLConnection = null;
                e = e4;
            } catch (Exception e5) {
                e = e5;
            }
            if (!this.lnr.get()) {
                return new jpc(httpURLConnection, fsVar);
            }
            httpURLConnection.disconnect();
            this.ud.mml().remove(this);
            strQdl = "internal error";
            return new jpc(responseCode, strQdl, fsVar);
        } finally {
            this.ud.mml().remove(this);
        }
    }

    private static String qdl(HttpURLConnection httpURLConnection, Exception exc) {
        try {
            return httpURLConnection.getErrorStream().toString();
        } catch (Throwable unused) {
            return exc.getMessage();
        }
    }

    private static void qdl(HttpURLConnection httpURLConnection) {
        try {
            Field declaredField = httpURLConnection.getClass().getDeclaredField("delegate");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(httpURLConnection);
            Field declaredField2 = obj.getClass().getDeclaredField("client");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (mml.size() == 2) {
                obj2.getClass().getDeclaredMethod("setProtocols", List.class).invoke(obj2, mml);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static void ud(HttpURLConnection httpURLConnection) {
        try {
            Field declaredField = httpURLConnection.getClass().getDeclaredField("delegate");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(httpURLConnection);
            Field declaredField2 = obj.getClass().getDeclaredField("client");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            obj2.getClass().getDeclaredMethod("setRetryOnConnectionFailure", Boolean.TYPE).invoke(obj2, Boolean.FALSE);
        } catch (Exception unused) {
        }
    }

    private boolean mzz() {
        if (this.qdl.mml() == null) {
            return false;
        }
        return this.qdl.mml().containsKey("Content-Type");
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud
    public void qdl(final com.bytedance.sdk.component.ud.qdl.lnr lnrVar) {
        fs fsVar = this.qdl;
        if (fsVar != null && fsVar.ud != null) {
            this.qdl.ud.bjy();
        }
        this.ud.ud().submit(new com.bytedance.sdk.component.jpc.lnr.ud(this.qdl.wd(), this.qdl.mo()) { // from class: com.bytedance.sdk.component.ud.qdl.qdl.qdl.ud.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    rdp rdpVarUd = ud.this.ud();
                    if (rdpVarUd == null) {
                        lnrVar.qdl(ud.this, new IOException("response is null"));
                    } else {
                        lnrVar.qdl(ud.this, rdpVarUd);
                    }
                } catch (IOException e) {
                    lnrVar.qdl(ud.this, e);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud
    public void lnr() {
        this.lnr.set(true);
    }

    /* JADX INFO: renamed from: mml, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.ud.qdl.ud clone() {
        return new ud(this.qdl, this.ud);
    }
}
