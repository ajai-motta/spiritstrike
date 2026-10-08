package com.bytedance.sdk.openadsdk.wd;

import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import com.bytedance.sdk.component.ud.qdl.exu;
import com.bytedance.sdk.component.ud.qdl.fs;
import com.bytedance.sdk.component.ud.qdl.lnr;
import com.bytedance.sdk.component.ud.qdl.mo;
import com.bytedance.sdk.component.ud.qdl.mzz;
import com.bytedance.sdk.component.ud.qdl.rdp;
import com.bytedance.sdk.component.ud.qdl.rq;
import com.bytedance.sdk.component.ud.qdl.tvp;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class qdl implements INetWork {
    protected rq qdl = new rq.qdl().qdl(10, TimeUnit.SECONDS).ud(10, TimeUnit.SECONDS).lnr(10, TimeUnit.SECONDS).qdl();
    protected rq ud = new rq.qdl().qdl(10, TimeUnit.SECONDS).ud(30, TimeUnit.SECONDS).lnr(30, TimeUnit.SECONDS).qdl();

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public void syncDoGet(final String str) {
        this.qdl.qdl(new fs.qdl().qdl().ud(str).qdl("gecko").ud()).qdl(new lnr() { // from class: com.bytedance.sdk.openadsdk.wd.qdl.1
            @Override // com.bytedance.sdk.component.ud.qdl.lnr
            public void qdl(com.bytedance.sdk.component.ud.qdl.ud udVar, rdp rdpVar) throws IOException {
            }

            @Override // com.bytedance.sdk.component.ud.qdl.lnr
            public void qdl(com.bytedance.sdk.component.ud.qdl.ud udVar, IOException iOException) {
            }
        });
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doGet(String str) throws Exception {
        rdp rdpVarUd = this.qdl.qdl(new fs.qdl().qdl().ud(str).qdl("gecko").ud()).ud();
        return new Response(qdl(rdpVarUd.wd()), rdpVarUd.lnr() == 200 ? rdpVarUd.mo().ud() : null, rdpVarUd.lnr(), rdpVarUd.mzz());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doPost(String str, List<Pair<String, String>> list) throws Exception {
        mzz.qdl qdlVar = new mzz.qdl();
        if (list != null) {
            for (Pair<String, String> pair : list) {
                qdlVar.qdl((String) pair.first, (String) pair.second);
            }
        }
        rdp rdpVarUd = this.qdl.qdl(new fs.qdl().ud(str).qdl((exu) qdlVar.qdl()).qdl("gecko").ud()).ud();
        return new Response(qdl(rdpVarUd.wd()), rdpVarUd.lnr() == 200 ? rdpVarUd.mo().ud() : null, rdpVarUd.lnr(), rdpVarUd.mzz());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doPost(String str, String str2) throws Exception {
        rdp rdpVarUd = this.qdl.qdl(new fs.qdl().ud(str).qdl(exu.qdl(tvp.qdl("application/json; charset=utf-8"), str2)).qdl("gecko").ud()).ud();
        return new Response(qdl(rdpVarUd.wd()), rdpVarUd.lnr() == 200 ? rdpVarUd.mo().ud() : null, rdpVarUd.lnr(), rdpVarUd.mzz());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public void downloadFile(String str, long j, BufferOutputStream bufferOutputStream) throws Exception {
        BufferedInputStream bufferedInputStream;
        Exception e;
        BufferedInputStream bufferedInputStream2 = null;
        int i = 0;
        try {
            try {
                rdp rdpVarUd = this.ud.qdl(new fs.qdl().qdl().qdl("gecko").ud(str).ud()).ud();
                int iLnr = rdpVarUd.lnr();
                try {
                    bufferedInputStream = new BufferedInputStream(rdpVarUd.mo().lnr());
                    try {
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int i2 = bufferedInputStream.read(bArr, 0, 2048);
                                if (i2 != -1) {
                                    bufferOutputStream.write(bArr, 0, i2);
                                } else {
                                    CloseableUtils.close(bufferedInputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream2 = bufferedInputStream;
                            CloseableUtils.close(bufferedInputStream2);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        i = iLnr;
                        throw new RuntimeException("downloadFile failed, code: " + i + ", url:" + str + ", caused by:" + e.getMessage(), e);
                    }
                } catch (Exception e3) {
                    bufferedInputStream = null;
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
                CloseableUtils.close(bufferedInputStream2);
                throw th;
            }
        } catch (Exception e4) {
            bufferedInputStream = null;
            e = e4;
        }
    }

    private Map<String, String> qdl(mo moVar) {
        if (moVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < moVar.qdl(); i++) {
            map.put(moVar.qdl(i), moVar.ud(i));
        }
        return map;
    }
}
