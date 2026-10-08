package com.bytedance.sdk.component.mzz.lnr.qdl.qdl;

import android.util.Log;
import com.bytedance.sdk.component.mzz.lnr.qdl.qdl.qdl;
import com.bytedance.sdk.component.utils.to;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class ud implements com.bytedance.sdk.component.mzz.lnr {
    private long qdl;
    private qdl ud;

    public ud(File file, long j, ExecutorService executorService) {
        this.qdl = j;
        try {
            this.ud = qdl.qdl(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.mzz.lnr
    public InputStream qdl(String str) {
        qdl qdlVar = this.ud;
        if (qdlVar == null) {
            return null;
        }
        try {
            qdl.lnr lnrVarQdl = qdlVar.qdl(str);
            if (lnrVarQdl != null) {
                return lnrVarQdl.qdl(0);
            }
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.mzz.qdl
    public boolean qdl(String str, byte[] bArr) throws Throwable {
        Closeable closeable;
        qdl qdlVar = this.ud;
        if (qdlVar == null || bArr == null || str == null) {
            return false;
        }
        qdl.C0207qdl c0207qdl = null;
        Closeable closeable2 = null;
        try {
            try {
                qdl.C0207qdl c0207qdlUd = qdlVar.ud(str);
                try {
                    if (c0207qdlUd == null) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for edit null");
                        to.qdl(null);
                        return false;
                    }
                    OutputStream outputStreamQdl = c0207qdlUd.qdl(0);
                    if (outputStreamQdl != qdl.lnr) {
                        outputStreamQdl.write(bArr);
                        c0207qdlUd.qdl();
                        this.ud.qdl();
                        to.qdl(outputStreamQdl);
                        return true;
                    }
                    Log.w("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                    to.qdl(outputStreamQdl);
                    return false;
                } catch (IOException e) {
                    e = e;
                    closeable = null;
                    c0207qdl = c0207qdlUd;
                    try {
                        Log.w("LruCountDiskCache", e.toString());
                        if (c0207qdl != null) {
                            try {
                                c0207qdl.ud();
                            } catch (IOException unused) {
                            }
                        }
                        to.qdl(closeable);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        to.qdl(closeable2);
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                closeable = null;
            }
        } catch (Throwable th2) {
            th = th2;
            to.qdl(closeable2);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.mzz.qdl
    /* JADX INFO: renamed from: ud, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] qdl(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamQdl;
        qdl qdlVar = this.ud;
        InputStream inputStream = null;
        if (qdlVar == null || str == null) {
            return null;
        }
        try {
            qdl.lnr lnrVarQdl = qdlVar.qdl(str);
            if (lnrVarQdl == null) {
                to.qdl(null);
                to.qdl(null);
                return null;
            }
            inputStreamQdl = lnrVarQdl.qdl(0);
            if (inputStreamQdl != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e) {
                    e = e;
                    byteArrayOutputStream = null;
                    Log.w("LruCountDiskCache", e.toString());
                    to.qdl(inputStreamQdl);
                    to.qdl(byteArrayOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                    inputStream = inputStreamQdl;
                    to.qdl(inputStream);
                    to.qdl(byteArrayOutputStream);
                    throw th;
                }
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamQdl.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStreamQdl;
                        to.qdl(inputStream);
                        to.qdl(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.w("LruCountDiskCache", e.toString());
                    to.qdl(inputStreamQdl);
                    to.qdl(byteArrayOutputStream);
                    return null;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            to.qdl(inputStreamQdl);
            to.qdl(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e3) {
            e = e3;
            inputStreamQdl = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            to.qdl(inputStream);
            to.qdl(byteArrayOutputStream);
            throw th;
        }
        Log.w("LruCountDiskCache", e.toString());
        to.qdl(inputStreamQdl);
        to.qdl(byteArrayOutputStream);
        return null;
    }

    @Override // com.bytedance.sdk.component.mzz.qdl
    /* JADX INFO: renamed from: lnr, reason: merged with bridge method [inline-methods] */
    public boolean ud(String str) {
        try {
            try {
                qdl.lnr lnrVarQdl = this.ud.qdl(str);
                boolean z = lnrVarQdl != null;
                to.qdl(lnrVarQdl);
                return z;
            } catch (IOException e) {
                Log.w("LruCountDiskCache", e.getMessage());
                to.qdl(null);
                return false;
            }
        } catch (Throwable th) {
            to.qdl(null);
            throw th;
        }
    }
}
