package com.bytedance.sdk.component.mzz.lnr.qdl;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.unity3d.services.core.di.ServiceProvider;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class qdl implements com.bytedance.sdk.component.mzz.ud, Cloneable {
    private static volatile com.bytedance.sdk.component.mzz.ud mo;
    private boolean lnr;
    private boolean mml;
    private File mzz;
    private long qdl;
    private int ud;

    @Override // com.bytedance.sdk.component.mzz.ud
    public int lnr() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public int mml() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public boolean mo() {
        return false;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public boolean tvp() {
        return true;
    }

    public qdl(int i, long j, File file) {
        this(i, j, i != 0, j != 0, file);
    }

    public qdl(int i, long j, boolean z, boolean z2, File file) {
        this.qdl = j;
        this.ud = i;
        this.lnr = z;
        this.mml = z2;
        this.mzz = file;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public long qdl() {
        return this.qdl;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public int ud() {
        return this.ud;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public boolean mzz() {
        return this.lnr;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public boolean wd() {
        return this.mml;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public File jpc() {
        return this.mzz;
    }

    public static void qdl(Context context, com.bytedance.sdk.component.mzz.ud udVar) {
        if (udVar != null) {
            mo = udVar;
        } else {
            mo = qdl(new File(context.getCacheDir(), "image"));
        }
    }

    public static com.bytedance.sdk.component.mzz.ud qdl(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (mo == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 31457280);
            jMin = Math.min(rq() / 16, 41943040L);
        } else {
            iMin = Math.min(mo.ud() / 2, 31457280);
            jMin = Math.min(mo.qdl() / 2, 41943040L);
        }
        return new qdl(Math.max(iMin, 26214400), Math.max(jMin, ServiceProvider.HTTP_CACHE_DISK_SIZE), file);
    }

    public static com.bytedance.sdk.component.mzz.ud to() {
        return mo;
    }

    private static long rq() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
