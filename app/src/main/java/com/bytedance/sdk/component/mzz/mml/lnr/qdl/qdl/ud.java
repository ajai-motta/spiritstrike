package com.bytedance.sdk.component.mzz.mml.lnr.qdl.qdl;

import com.bytedance.sdk.component.mzz.lnr;
import com.bytedance.sdk.component.utils.to;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ud implements lnr {
    private int qdl;
    private qdl ud;

    public ud(File file, long j) {
        int i = (int) j;
        this.qdl = i;
        this.ud = qdl.qdl(i, file);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.mzz.lnr
    public InputStream qdl(String str) {
        qdl qdlVar = this.ud;
        if (qdlVar == null) {
            return null;
        }
        return qdlVar.qdl(str);
    }

    @Override // com.bytedance.sdk.component.mzz.qdl
    public boolean qdl(String str, byte[] bArr) {
        qdl qdlVar = this.ud;
        if (qdlVar == null || bArr == null || str == null) {
            return false;
        }
        return qdlVar.qdl(str, bArr);
    }

    @Override // com.bytedance.sdk.component.mzz.qdl
    /* JADX INFO: renamed from: ud, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] qdl(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStreamQdl;
        qdl qdlVar = this.ud;
        if (qdlVar != null && str != null) {
            try {
                inputStreamQdl = qdlVar.qdl(str);
                if (inputStreamQdl != null) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (IOException unused) {
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                        to.qdl(inputStreamQdl);
                        to.qdl(byteArrayOutputStream);
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamQdl.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } catch (IOException unused2) {
                    } catch (Throwable th3) {
                        th = th3;
                        to.qdl(inputStreamQdl);
                        to.qdl(byteArrayOutputStream);
                        throw th;
                    }
                } else {
                    byteArrayOutputStream = null;
                }
                if (byteArrayOutputStream != null) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    to.qdl(inputStreamQdl);
                    to.qdl(byteArrayOutputStream);
                    return byteArray;
                }
            } catch (IOException unused3) {
                inputStreamQdl = null;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                inputStreamQdl = null;
            }
            to.qdl(inputStreamQdl);
            to.qdl(byteArrayOutputStream);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.mzz.qdl
    /* JADX INFO: renamed from: lnr, reason: merged with bridge method [inline-methods] */
    public boolean ud(String str) {
        try {
            InputStream inputStreamQdl = this.ud.qdl(str);
            boolean z = inputStreamQdl != null;
            to.qdl(inputStreamQdl);
            return z;
        } catch (Throwable th) {
            try {
                th.getMessage();
                return false;
            } finally {
                to.qdl(null);
            }
        }
    }
}
