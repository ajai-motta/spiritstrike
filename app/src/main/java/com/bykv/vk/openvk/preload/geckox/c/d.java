package com.bykv.vk.openvk.preload.geckox.c;

import android.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bykv.vk.openvk.preload.a.d<List<String>, List<Pair<String, Long>>> {
    private File d;
    private String e;

    @Override // com.bykv.vk.openvk.preload.a.d
    public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.b<List<Pair<String, Long>>> bVar, List<String> list) throws Throwable {
        File file = new File(this.d, this.e);
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Long lA = com.bykv.vk.openvk.preload.geckox.utils.g.a(new File(file, str));
            arrayList.add(new Pair<>(str, Long.valueOf(lA == null ? 0L : lA.longValue())));
        }
        return bVar.a(arrayList);
    }

    @Override // com.bykv.vk.openvk.preload.a.d
    protected final void a(Object... objArr) {
        super.a(objArr);
        this.d = (File) objArr[0];
        this.e = (String) objArr[1];
    }
}
