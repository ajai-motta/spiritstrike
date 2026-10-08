package com.bykv.vk.openvk.preload.geckox.c.a.b;

import android.net.Uri;
import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.bykv.vk.openvk.preload.a.d<Pair<Uri, UpdatePackage>, Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>> {
    private com.bykv.vk.openvk.preload.geckox.b d;
    private File e;

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
        long length = updatePackage.getPatch().getLength();
        File file = new File(this.e, updatePackage.getAccessKey() + File.separator + updatePackage.getChannel() + File.separator + updatePackage.getVersion() + "--updating");
        file.mkdirs();
        File file2 = new File(file, "patch.tmp");
        this.d.a();
        com.bykv.vk.openvk.preload.geckox.buffer.a aVarA = com.bykv.vk.openvk.preload.geckox.buffer.a.a.a(file2, length);
        try {
            this.d.i().downloadFile(string, length, new BufferOutputStream(aVarA));
            try {
                return bVar.a(new Pair<>(aVarA, updatePackage));
            } finally {
                aVarA.e();
            }
        } catch (Throwable th) {
            aVarA.e();
            throw new com.bykv.vk.openvk.preload.geckox.b.a("download patch single file failed, url:" + string + ", channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}
