package com.bykv.vk.openvk.qdl.qdl.ud.qdl.qdl;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.ud.qdl.bjy;
import com.bytedance.sdk.component.ud.qdl.fs;
import com.bytedance.sdk.component.ud.qdl.rdp;
import com.bytedance.sdk.component.ud.qdl.rq;
import com.bytedance.sdk.component.utils.aaj;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ud implements lnr {
    private File lnr;
    private File mml;
    private long mzz;
    private final com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr rq;
    private RandomAccessFile to;
    private volatile long qdl = -2147483648L;
    private final Object ud = new Object();
    private volatile long mo = -1;
    private volatile int wd = -100;
    private volatile boolean jpc = false;
    private volatile boolean tvp = false;

    public ud(Context context, com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar) {
        this.mzz = 0L;
        this.to = null;
        this.rq = lnrVar;
        try {
            this.lnr = com.bykv.vk.openvk.qdl.qdl.ud.mml.ud.ud(lnrVar.mzz(), lnrVar.yt());
            this.mml = com.bykv.vk.openvk.qdl.qdl.ud.mml.ud.lnr(lnrVar.mzz(), lnrVar.yt());
            if (mml()) {
                this.to = new RandomAccessFile(this.mml, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            } else {
                this.to = new RandomAccessFile(this.lnr, "rw");
            }
            if (mml()) {
                return;
            }
            this.mzz = this.lnr.length();
            qdl();
        } catch (Throwable unused) {
            lnrVar.jtx();
        }
    }

    private boolean mml() {
        return this.mml.exists();
    }

    public void qdl() {
        rq.qdl qdlVar;
        if (com.bykv.vk.openvk.qdl.qdl.qdl.lnr.mml() != null) {
            qdlVar = com.bykv.vk.openvk.qdl.qdl.qdl.lnr.mml().ud();
        } else {
            qdlVar = new rq.qdl("v_cache");
        }
        qdlVar.qdl(this.rq.exc(), TimeUnit.MILLISECONDS).ud(this.rq.aaj(), TimeUnit.MILLISECONDS).lnr(this.rq.jyq(), TimeUnit.MILLISECONDS);
        rq rqVarQdl = qdlVar.qdl();
        Long.valueOf(this.mzz);
        this.rq.yt();
        rqVarQdl.qdl(new fs.qdl().qdl("RANGE", "bytes=" + this.mzz + "-").ud(this.rq.jtx()).qdl().qdl("videoLoadWhenPlaying").qdl(9).ud()).qdl(new com.bytedance.sdk.component.ud.qdl.lnr() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.qdl.qdl.ud.1
            @Override // com.bytedance.sdk.component.ud.qdl.lnr
            public void qdl(com.bytedance.sdk.component.ud.qdl.ud udVar, IOException iOException) {
                ud.this.qdl(30000, iOException.getMessage());
            }

            @Override // com.bytedance.sdk.component.ud.qdl.lnr
            public void qdl(com.bytedance.sdk.component.ud.qdl.ud udVar, rdp rdpVar) throws IOException {
                bjy bjyVarMo;
                boolean z;
                boolean z2;
                long length;
                long j;
                if (rdpVar == null) {
                    ud.this.qdl(30002, "response is empty");
                    return;
                }
                InputStream inputStreamLnr = null;
                try {
                    ud.this.tvp = rdpVar.mml();
                    if (ud.this.tvp) {
                        bjyVarMo = rdpVar.mo();
                        try {
                            if (ud.this.tvp && bjyVarMo != null) {
                                ud.this.qdl = bjyVarMo.qdl() + ud.this.mzz;
                                inputStreamLnr = bjyVarMo.lnr();
                            }
                            if (inputStreamLnr == null) {
                                ud.this.qdl(30003, "input_stream is empty");
                                if (inputStreamLnr != null) {
                                    try {
                                        inputStreamLnr.close();
                                    } catch (Throwable unused) {
                                        return;
                                    }
                                }
                                if (z2) {
                                    if (length == j) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                            byte[] bArr = new byte[8192];
                            long j2 = ud.this.mzz;
                            long j3 = 0;
                            loop0: while (true) {
                                int i = 0;
                                do {
                                    int i2 = inputStreamLnr.read(bArr, i, 8192 - i);
                                    z = true;
                                    if (i2 == -1) {
                                        break loop0;
                                    }
                                    i += i2;
                                    j3 += (long) i2;
                                    if (j3 % PlaybackStateCompat.ACTION_PLAY_FROM_URI != 0 && j3 != ud.this.qdl - ud.this.mzz) {
                                        z = false;
                                    }
                                    Boolean.valueOf(z);
                                    Integer.valueOf(i);
                                    Long.valueOf(ud.this.qdl);
                                    Long.valueOf(j3);
                                    Long.valueOf(ud.this.mzz);
                                    ud.this.rq.yt();
                                    ud.this.rq.jtx();
                                } while (!z);
                                synchronized (ud.this.ud) {
                                    com.bykv.vk.openvk.qdl.qdl.ud.mml.ud.qdl(ud.this.to, bArr, Long.valueOf(j2).intValue(), i, ud.this.rq.yt());
                                }
                                j2 += (long) i;
                            }
                            Long.valueOf(ud.this.mzz);
                            Long.valueOf(ud.this.qdl);
                            Long.valueOf(j3);
                            Boolean.valueOf(j3 == ud.this.qdl - ud.this.mzz);
                            ud.this.rq.jtx();
                        } catch (Throwable th) {
                            th = th;
                            try {
                                ud.this.qdl(30001, th.getMessage());
                                if (inputStreamLnr != null) {
                                    try {
                                        inputStreamLnr.close();
                                    } catch (Throwable unused2) {
                                        return;
                                    }
                                }
                                if (bjyVarMo != null) {
                                    bjyVarMo.close();
                                }
                                if (rdpVar != null) {
                                    rdpVar.close();
                                }
                                if (ud.this.tvp && ud.this.lnr.length() == ud.this.qdl) {
                                    ud.this.mo();
                                    return;
                                }
                                return;
                            } finally {
                                if (inputStreamLnr != null) {
                                    try {
                                        inputStreamLnr.close();
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (bjyVarMo != null) {
                                    bjyVarMo.close();
                                }
                                if (rdpVar != null) {
                                    rdpVar.close();
                                }
                                if (ud.this.tvp && ud.this.lnr.length() == ud.this.qdl) {
                                    ud.this.mo();
                                }
                            }
                        }
                    } else {
                        ud.this.qdl(rdpVar.lnr(), rdpVar.mzz());
                        bjyVarMo = null;
                    }
                    if (inputStreamLnr != null) {
                        try {
                            inputStreamLnr.close();
                        } catch (Throwable unused4) {
                            return;
                        }
                    }
                    if (bjyVarMo != null) {
                        bjyVarMo.close();
                    }
                    if (rdpVar != null) {
                        rdpVar.close();
                    }
                    if (ud.this.tvp && ud.this.lnr.length() == ud.this.qdl) {
                        ud.this.mo();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bjyVarMo = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(int i, String str) {
        JSONObject jSONObjectLnr;
        this.tvp = false;
        this.wd = i;
        this.qdl = this.mo;
        aaj.ud("CSJ_MediaDLPlay", "handleFailResponse: ", Integer.valueOf(i), ServerSentEventKt.SPACE, str);
        com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar = this.rq;
        if (lnrVar == null || !lnrVar.qdl() || (jSONObjectLnr = this.rq.lnr()) == null) {
            return;
        }
        try {
            jSONObjectLnr.put("error_real_code", i);
            jSONObjectLnr.put("error_real_msg", str);
        } catch (Throwable th) {
            aaj.qdl("CSJ_MediaDLPlay", "handleFailResponse: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.qdl.qdl.lnr
    public int qdl(long j, byte[] bArr, int i, int i2) throws IOException {
        try {
            if (j == this.qdl) {
                return -1;
            }
            int i3 = 0;
            int i4 = 0;
            while (!this.jpc) {
                synchronized (this.ud) {
                    long jMzz = mzz();
                    if (j < jMzz) {
                        this.to.seek(j);
                        i4 = this.to.read(bArr, i, i2);
                    } else {
                        Long.valueOf(j);
                        Long.valueOf(jMzz);
                        i3 += 33;
                        this.ud.wait(33L);
                    }
                }
                if (i4 > 0) {
                    return i4;
                }
                com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar = this.rq;
                if (lnrVar != null && lnrVar.qdl() && this.wd != -100 && (!this.tvp || this.qdl == this.mo)) {
                    throw new IOException();
                }
                if (i3 >= 20000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException();
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.qdl.qdl.lnr
    public void ud() {
        try {
            if (!this.jpc) {
                this.to.close();
            }
            File file = this.lnr;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.mml;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
        this.jpc = true;
    }

    private long mzz() {
        if (mml()) {
            return this.mml.length();
        }
        return this.lnr.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mo() throws IOException {
        synchronized (this.ud) {
            if (mml()) {
                this.rq.jtx();
                this.rq.yt();
                return;
            }
            try {
            } finally {
            }
            if (!this.lnr.renameTo(this.mml)) {
                throw new IOException("Error renaming file " + this.lnr + " to " + this.mml + " for completion!");
            }
            RandomAccessFile randomAccessFile = this.to;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.to = new RandomAccessFile(this.mml, "rw");
            this.rq.yt();
            this.rq.jtx();
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.qdl.qdl.lnr
    public long lnr() throws IOException {
        if (mml()) {
            this.qdl = this.mml.length();
        } else {
            synchronized (this.ud) {
                int i = 0;
                while (this.qdl == -2147483648L) {
                    i += 15;
                    try {
                        this.ud.wait(5L);
                        if (i > 20000) {
                            return -1L;
                        }
                    } catch (InterruptedException unused) {
                        throw new IOException("total length InterruptException");
                    }
                }
            }
        }
        Long.valueOf(this.qdl);
        return this.qdl;
    }
}
