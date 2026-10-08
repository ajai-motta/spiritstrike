package com.bykv.vk.openvk.preload.geckox.c.a.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.bykv.vk.openvk.preload.a.d;
import com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d<Pair<Uri, UpdatePackage>, Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>> {
    private com.bykv.vk.openvk.preload.geckox.b d;
    private File e;

    public static String a(UpdatePackage updatePackage, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("url empty, channel:" + updatePackage.getChannel());
        }
        int iLastIndexOf = str.lastIndexOf(DomExceptionUtils.SEPARATOR);
        if (iLastIndexOf == -1) {
            throw new RuntimeException("url path illegal, url:".concat(String.valueOf(str)));
        }
        String strSubstring = str.substring(iLastIndexOf + 1);
        if (TextUtils.isEmpty(strSubstring)) {
            throw new RuntimeException("url path illegal, url:".concat(String.valueOf(str)));
        }
        return strSubstring;
    }

    @Override // com.bykv.vk.openvk.preload.a.d
    protected final void a(Object... objArr) {
        super.a(objArr);
        this.d = (com.bykv.vk.openvk.preload.geckox.b) objArr[0];
        this.e = (File) objArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bykv.vk.openvk.preload.a.d
    public Object a(com.bykv.vk.openvk.preload.a.b<Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>> bVar, Pair<Uri, UpdatePackage> pair) throws Throwable {
        ((UpdatePackage) pair.second).getChannel();
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        String string = ((Uri) pair.first).toString();
        long length = updatePackage.getFullPackage().getLength();
        File file = new File(this.e, updatePackage.getAccessKey() + File.separator + updatePackage.getChannel() + File.separator + updatePackage.getVersion() + "--updating");
        file.mkdirs();
        StringBuilder sb = new StringBuilder("res");
        sb.append(File.separator);
        sb.append(a(updatePackage, string));
        File file2 = new File(file, sb.toString());
        this.d.a();
        com.bykv.vk.openvk.preload.geckox.buffer.a aVarA = com.bykv.vk.openvk.preload.geckox.buffer.a.a.a(file2, length);
        try {
            this.d.i().downloadFile(string, length, new BufferOutputStream(aVarA));
            try {
                try {
                    return bVar.a(new Pair<>(aVarA, updatePackage));
                } catch (Exception e) {
                    throw e;
                }
            } finally {
                try {
                    aVarA.e();
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            aVarA.e();
            throw new com.bykv.vk.openvk.preload.geckox.b.a("download full single file failed! url:" + string + ", channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getFullPackage().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}
