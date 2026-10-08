package com.bytedance.sdk.component.mzz.lnr;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.bytedance.sdk.component.mzz.exc;
import com.bytedance.sdk.component.mzz.jpc;
import com.bytedance.sdk.component.mzz.jtx;
import com.bytedance.sdk.component.mzz.jyq;
import com.bytedance.sdk.component.mzz.rdp;
import com.bytedance.sdk.component.mzz.rq;
import com.bytedance.sdk.component.mzz.to;
import com.bytedance.sdk.component.mzz.tvp;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public class lnr implements tvp {
    private boolean aaj;
    private com.bytedance.sdk.component.mzz.lnr.qdl bch;
    private boolean bjy;
    private int bqt;
    private final Handler exc;
    private volatile boolean exu;
    private WeakReference<ImageView> fs;
    private Queue<com.bytedance.sdk.component.mzz.mzz.tvp> jl;
    private int jpc;
    private exc jtx;
    private com.bytedance.sdk.component.mzz.wd jyq;
    private rdp kdv;
    private boolean koa;
    private mo ljh;
    private String lnr;
    private String mml;
    private ImageView.ScaleType mo;
    private jtx mzz;
    private int oth;
    Future<?> qdl;
    private boolean rc;
    private boolean rdp;
    private int rq;
    private jpc to;
    private int tvp;
    private String ud;
    private com.bytedance.sdk.component.mzz.ud uw;
    private ExecutorService vu;
    private Bitmap.Config wd;
    private int xmv;
    private int yt;

    private lnr(ud udVar) {
        this.jl = new LinkedBlockingQueue();
        this.exc = new Handler(Looper.getMainLooper());
        this.aaj = true;
        this.ud = udVar.mml;
        this.mzz = new qdl(udVar.qdl);
        this.fs = new WeakReference<>(udVar.ud);
        this.mo = udVar.mzz;
        this.wd = udVar.mo;
        this.jpc = udVar.wd;
        this.tvp = udVar.jpc;
        this.rq = udVar.tvp;
        this.yt = udVar.to;
        this.jtx = udVar.rq;
        this.uw = qdl(udVar);
        if (!TextUtils.isEmpty(udVar.lnr)) {
            ud(udVar.lnr);
            qdl(udVar.lnr);
        }
        this.rdp = udVar.fs;
        this.bjy = udVar.exu;
        this.ljh = udVar.jtx;
        this.to = udVar.yt;
        this.bqt = udVar.exc;
        this.xmv = udVar.jl;
        this.vu = udVar.jyq;
        this.koa = udVar.aaj;
        this.rc = udVar.oth;
        this.kdv = udVar.ljh;
        this.jl.add(new com.bytedance.sdk.component.mzz.mzz.lnr());
    }

    private com.bytedance.sdk.component.mzz.ud qdl(ud udVar) {
        if (udVar.bjy != null) {
            return udVar.bjy;
        }
        if (!TextUtils.isEmpty(udVar.rdp)) {
            return com.bytedance.sdk.component.mzz.lnr.qdl.qdl.qdl(new File(udVar.rdp));
        }
        return com.bytedance.sdk.component.mzz.lnr.qdl.qdl.to();
    }

    public int mo() {
        return this.xmv;
    }

    public int wd() {
        return this.bqt;
    }

    @Override // com.bytedance.sdk.component.mzz.tvp
    public String qdl() {
        return this.ud;
    }

    public jtx jpc() {
        return this.mzz;
    }

    public String tvp() {
        return this.mml;
    }

    public void qdl(String str) {
        this.mml = str;
    }

    public String to() {
        return this.lnr;
    }

    @Override // com.bytedance.sdk.component.mzz.tvp
    public Bitmap.Config mzz() {
        return this.wd;
    }

    public void ud(String str) {
        WeakReference<ImageView> weakReference = this.fs;
        if (weakReference != null && weakReference.get() != null) {
            this.fs.get().setTag(1094453505, str);
        }
        this.lnr = str;
    }

    @Override // com.bytedance.sdk.component.mzz.tvp
    public ImageView.ScaleType mml() {
        return this.mo;
    }

    public Bitmap.Config rq() {
        return this.wd;
    }

    @Override // com.bytedance.sdk.component.mzz.tvp
    public int ud() {
        return this.jpc;
    }

    @Override // com.bytedance.sdk.component.mzz.tvp
    public int lnr() {
        return this.tvp;
    }

    public int fs() {
        return this.rq;
    }

    public boolean exu() {
        return this.rdp;
    }

    public boolean rdp() {
        return this.bjy;
    }

    public void qdl(boolean z) {
        this.aaj = z;
    }

    public boolean bjy() {
        return this.aaj;
    }

    public com.bytedance.sdk.component.mzz.wd jtx() {
        return this.jyq;
    }

    public void qdl(com.bytedance.sdk.component.mzz.wd wdVar) {
        this.jyq = wdVar;
    }

    public int yt() {
        return this.oth;
    }

    public void qdl(int i) {
        this.oth = i;
    }

    public void qdl(com.bytedance.sdk.component.mzz.lnr.qdl qdlVar) {
        this.bch = qdlVar;
    }

    public mo jl() {
        return this.ljh;
    }

    public com.bytedance.sdk.component.mzz.ud exc() {
        return this.uw;
    }

    public boolean qdl(com.bytedance.sdk.component.mzz.mzz.tvp tvpVar) {
        if (this.exu) {
            return false;
        }
        return this.jl.add(tvpVar);
    }

    public boolean aaj() {
        return this.koa;
    }

    public rdp jyq() {
        return this.kdv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public tvp ljh() {
        try {
        } catch (Exception e) {
            Log.e("ImageRequest", e.getMessage());
        }
        if (this.ljh == null) {
            jtx jtxVar = this.mzz;
            if (jtxVar != null) {
                jtxVar.qdl(1005, "not init !", null);
            }
            return this;
        }
        String strQdl = qdl();
        if (TextUtils.isEmpty(strQdl)) {
            jtx jtxVar2 = this.mzz;
            if (jtxVar2 != null) {
                jtxVar2.qdl(2000, "url is empty", null);
            }
            return this;
        }
        jyq jyqVarMzz = this.ljh.mzz();
        if (!strQdl.startsWith("http://") && !strQdl.startsWith("https://") && jyqVarMzz != null) {
            jyqVarMzz.qdl(1006, "url is not validate ".concat(String.valueOf(strQdl)));
        }
        ExecutorService executorServiceWd = this.vu == null ? this.ljh.wd() : null;
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.mzz.lnr.lnr.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.mzz.mzz.tvp tvpVar;
                while (!lnr.this.exu && (tvpVar = (com.bytedance.sdk.component.mzz.mzz.tvp) lnr.this.jl.poll()) != null) {
                    try {
                        if (lnr.this.jtx != null) {
                            lnr.this.jtx.qdl(tvpVar.qdl(), lnr.this);
                        }
                        tvpVar.qdl(lnr.this);
                        if (lnr.this.jtx != null) {
                            lnr.this.jtx.ud(tvpVar.qdl(), lnr.this);
                        }
                    } catch (Throwable th) {
                        lnr.this.qdl(2000, th.getMessage(), th);
                        if (lnr.this.jtx != null) {
                            lnr.this.jtx.ud("exception", lnr.this);
                            return;
                        }
                        return;
                    }
                }
                if (lnr.this.exu) {
                    lnr.this.qdl(1003, "canceled", null);
                }
            }
        };
        if (this.rc) {
            runnable.run();
        } else {
            ExecutorService executorService = this.vu;
            if (executorService != null) {
                this.qdl = executorService.submit(runnable);
            } else if (executorServiceWd != null) {
                this.qdl = executorServiceWd.submit(runnable);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(int i, String str, Throwable th) {
        new com.bytedance.sdk.component.mzz.mzz.jpc(i, str, th).qdl(this);
        this.jl.clear();
    }

    public String oth() {
        return to() + fs();
    }

    public static class ud implements to {
        private boolean aaj;
        private com.bytedance.sdk.component.mzz.ud bjy;
        private int exc;
        private boolean exu;
        private boolean fs;
        private int jl;
        private int jpc;
        private mo jtx;
        private ExecutorService jyq;
        private rdp ljh;
        private String lnr;
        private String mml;
        private Bitmap.Config mo;
        private ImageView.ScaleType mzz;
        private boolean oth;
        private jtx qdl;
        private String rdp;
        private exc rq;
        private ImageView ud;
        private int wd;
        private jpc yt;
        private int tvp = 1;
        private int to = 5;

        public ud(mo moVar) {
            this.jtx = moVar;
        }

        public to lnr(String str) {
            this.mml = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to qdl(String str) {
            this.lnr = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to qdl(ImageView.ScaleType scaleType) {
            this.mzz = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to qdl(Bitmap.Config config) {
            this.mo = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to qdl(int i) {
            this.wd = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to ud(int i) {
            this.jpc = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to lnr(int i) {
            this.tvp = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to qdl(exc excVar) {
            this.rq = excVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to qdl(boolean z) {
            this.exu = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to ud(String str) {
            this.rdp = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public tvp qdl(jtx jtxVar, int i) {
            this.to = i;
            return qdl(jtxVar);
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public tvp qdl(jtx jtxVar) {
            this.qdl = jtxVar;
            return new lnr(this).ljh();
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public tvp qdl(ImageView imageView) {
            this.ud = imageView;
            return new lnr(this).ljh();
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to qdl(jpc jpcVar) {
            this.yt = jpcVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to mml(int i) {
            this.jl = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.mzz.to
        public to mzz(int i) {
            this.exc = i;
            return this;
        }
    }

    private class qdl implements jtx {
        private jtx ud;

        public qdl(jtx jtxVar) {
            this.ud = jtxVar;
        }

        @Override // com.bytedance.sdk.component.mzz.jtx
        public void qdl(final rq rqVar) {
            final ImageView imageView = (ImageView) lnr.this.fs.get();
            if (imageView != null && lnr.this.rq != 3 && qdl(imageView) && (rqVar.ud() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) rqVar.ud();
                lnr.this.exc.post(new Runnable() { // from class: com.bytedance.sdk.component.mzz.lnr.lnr.qdl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (lnr.this.to != null && (rqVar.ud() instanceof Bitmap)) {
                    jpc jpcVar = lnr.this.to;
                    Bitmap bitmap2 = (Bitmap) rqVar.ud();
                    Bitmap bitmapQdl = jpcVar.qdl(bitmap2);
                    if (bitmapQdl != null) {
                        rqVar.qdl(bitmapQdl);
                    }
                }
            } catch (Throwable unused) {
            }
            if (lnr.this.yt == 5) {
                lnr.this.exc.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.mzz.lnr.lnr.qdl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (qdl.this.ud != null) {
                            qdl.this.ud.qdl(rqVar);
                        }
                    }
                });
                return;
            }
            jtx jtxVar = this.ud;
            if (jtxVar != null) {
                jtxVar.qdl(rqVar);
            }
        }

        private boolean qdl(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(lnr.this.lnr)) ? false : true;
        }

        @Override // com.bytedance.sdk.component.mzz.jtx
        public void qdl(final int i, final String str, final Throwable th) {
            if (lnr.this.yt == 5) {
                lnr.this.exc.post(new Runnable() { // from class: com.bytedance.sdk.component.mzz.lnr.lnr.qdl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (qdl.this.ud != null) {
                            qdl.this.ud.qdl(i, str, th);
                        }
                    }
                });
                return;
            }
            jtx jtxVar = this.ud;
            if (jtxVar != null) {
                jtxVar.qdl(i, str, th);
            }
        }
    }
}
