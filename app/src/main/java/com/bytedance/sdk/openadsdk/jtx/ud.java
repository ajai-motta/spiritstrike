package com.bytedance.sdk.openadsdk.jtx;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    public static int lnr = 1;
    public static int mml = 2;
    public static int mzz = 3;
    public static int qdl = -1;
    public static int ud;
    private int mo = qdl;
    private long wd = 0;
    private long jpc = 0;
    private final List<lnr> tvp = new ArrayList();
    private long to = 0;

    public void qdl(long j) {
        this.mo = ud;
        this.wd = j;
    }

    public void ud(long j) {
        int i;
        int i2 = this.mo;
        if (i2 == qdl || i2 == (i = mzz)) {
            return;
        }
        this.mo = i;
        this.jpc = j;
    }

    public void lnr(long j) {
        int i;
        int i2 = this.mo;
        if (i2 == qdl || i2 == (i = mml) || i2 == mzz) {
            return;
        }
        this.mo = i;
        this.to = j;
    }

    public void mml(long j) {
        int i = this.mo;
        if (i == qdl || i != mml) {
            return;
        }
        this.mo = lnr;
        this.tvp.add(new lnr(this.to, j));
        this.to = 0L;
    }

    public long qdl(long j, long j2) {
        long j3;
        long j4;
        long jUd;
        long j5 = this.jpc;
        if (j5 != 0 && j > j5) {
            return 0L;
        }
        int i = 0;
        for (lnr lnrVar : this.tvp) {
            if (lnrVar.ud() > j) {
                if (j < lnrVar.qdl()) {
                    j4 = i;
                    jUd = lnrVar.ud() - lnrVar.qdl();
                } else {
                    j4 = i;
                    jUd = lnrVar.ud() - j;
                }
                i = (int) (j4 + jUd);
            }
        }
        long j6 = this.wd;
        if (j6 < j) {
            long j7 = this.to;
            if (j7 == 0) {
                j7 = this.jpc;
                if (j7 == 0) {
                    j3 = j2 - j;
                }
            } else if (j7 <= j) {
                return 0L;
            }
            return (j7 - j) - ((long) i);
        }
        long j8 = this.to;
        if (j8 == 0) {
            j8 = this.jpc;
            if (j8 == 0) {
                j3 = j2 - j6;
            }
        } else if (j8 <= j6) {
            return 0L;
        }
        return (j8 - j6) - ((long) i);
        return j3 - ((long) i);
    }

    public int qdl() {
        return this.mo;
    }
}
