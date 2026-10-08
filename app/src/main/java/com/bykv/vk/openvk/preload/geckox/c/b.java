package com.bykv.vk.openvk.preload.geckox.c;

import com.bykv.vk.openvk.preload.a.j;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b extends j<UpdatePackage, UpdatePackage> {
    @Override // com.bykv.vk.openvk.preload.a.j
    protected final /* synthetic */ String a(UpdatePackage updatePackage) {
        UpdatePackage updatePackage2 = updatePackage;
        UpdatePackage.Package patch = updatePackage2.getPatch();
        if (patch == null) {
            updatePackage2.getChannel();
            return "full";
        }
        List<String> urlList = patch.getUrlList();
        if (urlList == null || urlList.isEmpty()) {
            updatePackage2.getChannel();
            return "full";
        }
        updatePackage2.getChannel();
        return "patch";
    }

    @Override // com.bykv.vk.openvk.preload.a.j
    protected final /* synthetic */ String a(UpdatePackage updatePackage, Throwable th, String str) {
        UpdatePackage updatePackage2 = updatePackage;
        if ("patch".equals(str)) {
            updatePackage2.getChannel();
            return "full";
        }
        throw new RuntimeException("full update failed, caused by:" + th.getMessage(), th);
    }
}
