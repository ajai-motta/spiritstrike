package com.bytedance.sdk.openadsdk.ud;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class ud extends qdl {
    private int lnr;
    private volatile boolean mml;
    private int ud;

    public ud(int i, int i2) {
        this.ud = 15;
        this.lnr = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.ud = i;
        this.lnr = i2;
    }

    public ud(int i, int i2, boolean z) {
        this.ud = 15;
        this.lnr = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.ud = i;
        this.lnr = i2;
        this.mml = z;
    }

    @Override // com.bytedance.sdk.openadsdk.ud.qdl
    protected boolean qdl(long j, int i) {
        return i <= this.ud;
    }

    @Override // com.bytedance.sdk.openadsdk.ud.qdl
    protected boolean qdl(File file, long j, int i) {
        return i <= this.lnr;
    }

    @Override // com.bytedance.sdk.openadsdk.ud.qdl
    protected void qdl(List<File> list) {
        if (this.mml) {
            mml(list);
            this.mml = false;
        } else {
            lnr(list);
        }
    }

    private void lnr(List<File> list) {
        long jUd = ud(list);
        int size = list.size();
        if (qdl(jUd, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jUd -= length;
            }
            if (qdl(file, jUd, size)) {
                return;
            }
        }
    }

    private void mml(List<File> list) {
        long jUd;
        int size;
        boolean zQdl;
        if (list != null) {
            try {
                if (list.size() == 0 || (zQdl = qdl((jUd = ud(list)), (size = list.size())))) {
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !zQdl) {
                        ((Long) entry.getKey()).longValue();
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            jUd -= length;
                        }
                        if (qdl(file2, jUd, size)) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
