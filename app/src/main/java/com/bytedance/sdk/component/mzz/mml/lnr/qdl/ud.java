package com.bytedance.sdk.component.mzz.mml.lnr.qdl;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class ud implements com.bytedance.sdk.component.mzz.ud, Cloneable {
    private static volatile com.bytedance.sdk.component.mzz.ud tvp;
    private File jpc;
    private int lnr;
    private int mml;
    private boolean mo;
    private boolean mzz;
    private long qdl;
    private int ud;
    private boolean wd;

    @Override // com.bytedance.sdk.component.mzz.ud
    public boolean tvp() {
        return true;
    }

    public ud(int i, int i2, int i3, long j, File file) {
        this(i, i2, i3, j, i2 != 0, j != 0, file);
    }

    public ud(int i, int i2, int i3, long j, boolean z, boolean z2, File file) {
        this.qdl = j;
        this.ud = i;
        this.lnr = i2;
        this.mml = i3;
        this.mzz = z;
        this.mo = z2;
        this.jpc = file;
        this.wd = i3 != 0;
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
    public int lnr() {
        return this.lnr;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public int mml() {
        return this.mml;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public boolean mzz() {
        return this.mzz;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public boolean mo() {
        return this.wd;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public boolean wd() {
        return this.mo;
    }

    @Override // com.bytedance.sdk.component.mzz.ud
    public File jpc() {
        return this.jpc;
    }

    public static void qdl(Context context, com.bytedance.sdk.component.mzz.ud udVar) {
        if (udVar != null) {
            tvp = udVar;
        } else {
            tvp = qdl(new File(context.getCacheDir(), "image"));
        }
    }

    public static com.bytedance.sdk.component.mzz.ud qdl(File file) {
        long jQdl;
        int iLnr;
        int iMml;
        file.mkdirs();
        if (tvp == null) {
            iLnr = 10;
            iMml = 14;
            jQdl = 20;
        } else {
            jQdl = tvp.qdl();
            iLnr = tvp.lnr();
            iMml = tvp.mml();
        }
        return new ud(0, iLnr, iMml, jQdl, file);
    }

    public static com.bytedance.sdk.component.mzz.ud to() {
        return tvp;
    }
}
