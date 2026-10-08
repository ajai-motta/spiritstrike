package com.bykv.vk.openvk.qdl.qdl.ud.lnr;

import android.graphics.SurfaceTexture;
import android.media.PlaybackParams;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adxcorp.ads.mediation.common.Constants;
import com.bykv.vk.openvk.qdl.qdl.qdl.qdl;
import com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr;
import com.bytedance.sdk.component.jpc.tvp;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.koa;
import com.facebook.appevents.AppEventsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class mml implements com.bykv.vk.openvk.qdl.qdl.qdl.qdl, lnr.InterfaceC0178lnr, lnr.mml, lnr.mo, lnr.mzz, lnr.qdl, lnr.ud, lnr.wd, koa.qdl {
    private static final SparseIntArray qdl = new SparseIntArray();
    private ArrayList<Runnable> bch;
    private boolean bqt;
    private boolean exu;
    private boolean fs;
    private volatile boolean hzv;
    private koa jtx;
    private boolean ljh;
    private SurfaceHolder mo;
    private SurfaceTexture mzz;
    private final boolean ud = false;
    private final List<WeakReference<qdl.InterfaceC0177qdl>> lnr = new CopyOnWriteArrayList();
    private final qdl mml = new qdl();
    private int wd = 0;
    private int jpc = 3;
    private boolean tvp = false;
    private volatile lnr to = null;
    private boolean rq = false;
    private volatile int rdp = ComposerKt.providerKey;
    private long bjy = -1;
    private boolean yt = false;
    private long jl = 0;
    private long exc = Long.MIN_VALUE;
    private long aaj = 0;
    private long jyq = 0;
    private long oth = 0;
    private int uw = 0;
    private String xmv = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr koa = null;
    private boolean vu = false;
    private CountDownLatch rc = new CountDownLatch(1);
    private volatile int kdv = 200;
    private AtomicBoolean ekw = new AtomicBoolean(false);
    private Surface hkc = null;
    private long fco = 0;
    private long mrf = 0;
    private boolean gy = false;
    private final Runnable ax = new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.1
        @Override // java.lang.Runnable
        public void run() {
            if (mml.this.to == null) {
                return;
            }
            long jYt = mml.this.yt();
            if (jYt > 0 && mml.this.mo() && mml.this.exc != Long.MIN_VALUE) {
                try {
                    if (mml.this.exc == jYt) {
                        if (!mml.this.yt && mml.this.aaj >= 400) {
                            mml.this.ud(TypedValues.TransitionType.TYPE_FROM, 800);
                            mml.this.yt = true;
                        }
                        mml.this.aaj += (long) mml.this.kdv;
                    } else {
                        if (mml.this.yt) {
                            mml.this.jl += mml.this.aaj;
                            mml.this.ud(TypedValues.TransitionType.TYPE_TO, 800);
                            Long.valueOf(mml.this.jl);
                            Integer.valueOf(mml.this.wd);
                        }
                        mml.this.aaj = 0L;
                        mml.this.yt = false;
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            if (mml.this.jtx() > 0) {
                if (mml.this.exc != jYt) {
                    if (com.bykv.vk.openvk.qdl.qdl.qdl.lnr.mzz()) {
                        Long.valueOf(mml.this.exc);
                        Long.valueOf(jYt);
                    }
                    mml mmlVar = mml.this;
                    mmlVar.qdl(jYt, mmlVar.jtx());
                }
                mml.this.exc = jYt;
            }
            if (!mml.this.ud()) {
                if (mml.this.jtx != null) {
                    mml.this.jtx.postDelayed(this, mml.this.kdv);
                }
            } else {
                mml mmlVar2 = mml.this;
                mmlVar2.qdl(mmlVar2.jtx(), mml.this.jtx());
            }
        }
    };

    private boolean qdl(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    public mml() {
        qdl("SSMediaPlayerWrapper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(long j, long j2) {
        for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().qdl(this, j, j2);
            }
        }
    }

    private void qdl(String str) {
        this.uw = 0;
        this.jtx = com.bytedance.sdk.component.jpc.qdl.qdl.qdl().qdl(this, tvp.THREAD_NAME_PRE.concat(String.valueOf(str)));
        this.gy = true;
        jyq();
    }

    private void aaj() {
        this.jl = 0L;
        this.wd = 0;
        this.aaj = 0L;
        this.yt = false;
        this.exc = Long.MIN_VALUE;
    }

    public void qdl(final boolean z) {
        if (jpc()) {
            return;
        }
        this.bqt = z;
        if (this.to != null) {
            this.to.qdl(z);
            return;
        }
        koa koaVar = this.jtx;
        if (koaVar != null) {
            koaVar.post(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.9
                @Override // java.lang.Runnable
                public void run() {
                    if (mml.this.to != null) {
                        mml.this.to.qdl(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jyq() {
        koa koaVar = this.jtx;
        if (koaVar != null) {
            koaVar.post(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.10
                @Override // java.lang.Runnable
                public void run() {
                    if (mml.this.to == null) {
                        try {
                            mml.this.to = new ud();
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                        if (mml.this.to == null) {
                            return;
                        }
                        lnr unused = mml.this.to;
                        mml.this.xmv = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        mml.this.to.qdl((lnr.mzz) mml.this);
                        mml.this.to.qdl((lnr.ud) mml.this);
                        mml.this.to.qdl((lnr.InterfaceC0178lnr) mml.this);
                        mml.this.to.qdl((lnr.qdl) mml.this);
                        mml.this.to.qdl((lnr.mo) mml.this);
                        mml.this.to.qdl((lnr.mml) mml.this);
                        mml.this.to.qdl((lnr.wd) mml.this);
                        try {
                            mml.this.to.lnr(false);
                        } catch (Throwable unused2) {
                        }
                        mml.this.rq = false;
                    }
                }
            });
        }
    }

    public void tvp() {
        if (jpc() || this.to == null) {
            return;
        }
        this.ekw.set(true);
        if (this.rdp != 206) {
            aaj();
            this.hzv = false;
            this.mml.qdl(true);
            ud(0L);
            koa koaVar = this.jtx;
            if (koaVar != null) {
                koaVar.removeCallbacks(this.ax);
                this.jtx.postDelayed(this.ax, this.kdv);
            }
        }
        this.rc.countDown();
    }

    public void qdl(boolean z, long j, boolean z2) {
        if (jpc()) {
            return;
        }
        jyq();
        this.vu = z2;
        this.ekw.set(true);
        this.hzv = false;
        ud(z2);
        if (z) {
            this.bjy = j;
            oth();
        } else {
            ud(j);
        }
        koa koaVar = this.jtx;
        if (koaVar != null) {
            koaVar.removeCallbacks(this.ax);
            this.jtx.postDelayed(this.ax, this.kdv);
        }
        this.rc.countDown();
    }

    private void ud(long j) {
        this.mml.qdl(j);
        if (this.bqt) {
            ud(this.mml);
        } else if (ud(this.koa)) {
            ud(this.mml);
        } else {
            qdl(this.mml);
        }
    }

    private boolean ud(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar) {
        return lnrVar != null && lnrVar.wd();
    }

    public void to() {
        if (jpc() || this.jtx == null) {
            return;
        }
        this.ekw.set(true);
        this.jtx.post(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.11
            @Override // java.lang.Runnable
            public void run() {
                if (!mml.this.wd() || mml.this.to == null) {
                    return;
                }
                try {
                    mml.this.to.mo();
                    for (WeakReference weakReference : mml.this.lnr) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((qdl.InterfaceC0177qdl) weakReference.get()).mzz(mml.this);
                        }
                    }
                    mml.this.rdp = ComposerKt.referenceKey;
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        });
    }

    public void rq() {
        koa koaVar;
        if (jpc() || (koaVar = this.jtx) == null) {
            return;
        }
        koaVar.removeMessages(100);
        this.hzv = true;
        if (!this.gy) {
            if (this.ljh || ud(this.koa)) {
                koa koaVar2 = this.jtx;
                if (koaVar2 != null) {
                    koaVar2.sendEmptyMessage(101);
                    return;
                }
                return;
            }
            qdl(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.12
                @Override // java.lang.Runnable
                public void run() {
                    if (mml.this.jtx != null) {
                        mml.this.jtx.sendEmptyMessage(101);
                    }
                }
            });
            return;
        }
        if (this.tvp || ud(this.koa)) {
            koa koaVar3 = this.jtx;
            if (koaVar3 != null) {
                koaVar3.sendEmptyMessage(101);
                return;
            }
            return;
        }
        qdl(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.13
            @Override // java.lang.Runnable
            public void run() {
                if (mml.this.jtx != null) {
                    mml.this.jtx.sendEmptyMessage(101);
                }
            }
        });
    }

    public void fs() {
        if (jpc()) {
            return;
        }
        this.exu = true;
        rc();
        koa koaVar = this.jtx;
        if (koaVar != null) {
            try {
                koaVar.removeCallbacksAndMessages(null);
                if (this.to != null) {
                    this.jtx.sendEmptyMessage(103);
                }
                bch();
            } catch (Throwable unused) {
                bch();
            }
        }
    }

    private void oth() {
        ud(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.14
            @Override // java.lang.Runnable
            public void run() {
                if (mml.this.jtx != null) {
                    mml.this.jtx.sendEmptyMessage(104);
                }
            }
        });
    }

    public void qdl(final long j) {
        if (jpc()) {
            return;
        }
        if (this.rdp == 207 || this.rdp == 206 || this.rdp == 209) {
            ud(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.2
                @Override // java.lang.Runnable
                public void run() {
                    if (mml.this.jtx != null) {
                        mml.this.jtx.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl
    public boolean qdl() {
        return this.tvp;
    }

    public void qdl(final SurfaceTexture surfaceTexture) {
        if (jpc()) {
            return;
        }
        this.mzz = surfaceTexture;
        qdl(true);
        ud(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.3
            @Override // java.lang.Runnable
            public void run() {
                mml.this.jyq();
                if (mml.this.jtx != null) {
                    mml.this.jtx.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    public void qdl(final SurfaceHolder surfaceHolder) {
        if (jpc()) {
            return;
        }
        this.mo = surfaceHolder;
        qdl(true);
        ud(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.4
            @Override // java.lang.Runnable
            public void run() {
                mml.this.jyq();
                if (mml.this.jtx != null) {
                    mml.this.jtx.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public void qdl(final com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar) {
        if (jpc()) {
            return;
        }
        this.koa = lnrVar;
        if (lnrVar != null) {
            this.gy = this.gy && !lnrVar.wd();
        }
        ud(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.5
            @Override // java.lang.Runnable
            public void run() {
                mml.this.jyq();
                if (mml.this.jtx != null) {
                    mml.this.jtx.obtainMessage(107, lnrVar).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl
    public boolean mo() {
        koa koaVar;
        return (this.rdp == 206 || ((koaVar = this.jtx) != null && koaVar.hasMessages(100))) && !this.hzv;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl
    public boolean lnr() {
        return exu() || mo() || wd();
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl
    public boolean wd() {
        koa koaVar;
        return ((this.rdp != 207 && !this.hzv) || (koaVar = this.jtx) == null || koaVar.hasMessages(100)) ? false : true;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl
    public boolean jpc() {
        return this.exu;
    }

    public boolean exu() {
        return this.rdp == 205;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl
    public boolean ud() {
        return this.rdp == 209;
    }

    @Override // com.bytedance.sdk.component.utils.koa.qdl
    public void qdl(Message message) {
        int i = this.rdp;
        int i2 = message.what;
        if (this.to != null) {
            try {
                switch (message.what) {
                    case 100:
                        if (this.rdp == 205 || this.rdp == 207 || this.rdp == 209) {
                            this.to.mo();
                            this.oth = SystemClock.elapsedRealtime();
                            this.rdp = ComposerKt.referenceKey;
                            long j = this.bjy;
                            if (j > 0) {
                                Long.valueOf(j);
                                Integer.valueOf(this.jpc);
                                this.to.qdl(this.bjy, this.jpc);
                                this.bjy = -1L;
                            }
                            if (this.koa != null) {
                                ud(this.vu);
                                return;
                            }
                            return;
                        }
                        break;
                    case 101:
                        if (this.yt) {
                            this.jl += this.aaj;
                        }
                        this.yt = false;
                        this.aaj = 0L;
                        this.exc = Long.MIN_VALUE;
                        if (this.rdp == 206 || this.rdp == 207 || this.rdp == 209) {
                            this.to.jpc();
                            this.rdp = ComposerKt.reuseKey;
                            this.hzv = false;
                            for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get().mml(this);
                                }
                            }
                            return;
                        }
                        break;
                    case 102:
                        this.to.exu();
                        this.rdp = ComposerKt.providerKey;
                        return;
                    case 103:
                        try {
                            ljh();
                            break;
                        } catch (Throwable unused) {
                        }
                        for (WeakReference<qdl.InterfaceC0177qdl> weakReference2 : this.lnr) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().lnr(this);
                            }
                        }
                        this.rdp = ComposerKt.providerValuesKey;
                        return;
                    case 104:
                        if (this.rdp == 202 || this.rdp == 208) {
                            this.to.tvp();
                            return;
                        }
                        break;
                    case 105:
                        if (this.rdp == 205 || this.rdp == 206 || this.rdp == 208 || this.rdp == 207 || this.rdp == 209) {
                            this.to.wd();
                            this.rdp = 208;
                            return;
                        }
                        break;
                    case 106:
                        if (this.rdp == 206 || this.rdp == 207 || this.rdp == 209) {
                            this.to.qdl(((Long) message.obj).longValue(), this.jpc);
                            return;
                        }
                        break;
                    case 107:
                        aaj();
                        if (this.rdp == 201 || this.rdp == 203) {
                            com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar = (com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr) message.obj;
                            if (TextUtils.isEmpty(lnrVar.mzz())) {
                                lnrVar.qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud());
                            }
                            if (lnrVar.uw()) {
                                this.to.qdl(lnrVar.jtx());
                                lnrVar.jtx();
                            } else {
                                File file = new File(lnrVar.mzz(), lnrVar.yt());
                                if (file.exists()) {
                                    qdl(lnrVar, file);
                                } else {
                                    lnr(lnrVar);
                                }
                            }
                            this.rdp = ComposerKt.compositionLocalMapKey;
                            return;
                        }
                        break;
                    case 108:
                    case 109:
                    default:
                        return;
                    case 110:
                        this.to.qdl((SurfaceHolder) message.obj);
                        this.to.ud(true);
                        this.rc.await(1L, TimeUnit.SECONDS);
                        vu();
                        return;
                    case 111:
                        this.hkc = new Surface((SurfaceTexture) message.obj);
                        this.to.qdl(this.hkc);
                        this.to.ud(true);
                        this.rc.await(1L, TimeUnit.SECONDS);
                        vu();
                        return;
                }
                this.rdp = 200;
                if (this.rq) {
                    return;
                }
                com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl qdlVar = new com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl(308, i2);
                qdlVar.qdl(i + "," + i2);
                for (WeakReference<qdl.InterfaceC0177qdl> weakReference3 : this.lnr) {
                    if (weakReference3 != null && weakReference3.get() != null) {
                        weakReference3.get().qdl(this, qdlVar);
                    }
                }
                this.rq = true;
            } catch (Throwable unused2) {
            }
        }
    }

    private void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, File file) {
        if (lnrVar.qdl()) {
            ud(lnrVar, file);
        } else {
            qdl(file);
        }
    }

    private void qdl(File file) {
        file.getAbsolutePath();
        try {
            if (com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr()) {
                ud(file.getAbsolutePath());
            } else {
                this.to.qdl(file.getAbsolutePath());
            }
        } catch (Throwable unused) {
        }
    }

    private void ud(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, File file) {
        try {
            String strQdl = com.bykv.vk.openvk.qdl.qdl.qdl.wd.qdl.qdl(file);
            if (lnrVar.yt().equals(strQdl)) {
                qdl(file);
                return;
            }
            JSONObject jSONObjectLnr = lnrVar.lnr();
            boolean zUd = lnrVar.ud();
            if (jSONObjectLnr != null) {
                jSONObjectLnr.put("file_hash", lnrVar.yt());
                jSONObjectLnr.put("file_real_hash", strQdl);
                jSONObjectLnr.put("is_change_play_type", zUd ? 1 : 0);
                jSONObjectLnr.put("error_real_code", 309);
                jSONObjectLnr.put("error_real_msg", "md5_not_match");
            }
            if (zUd) {
                boolean zDelete = file.delete();
                if (jSONObjectLnr != null) {
                    jSONObjectLnr.put("delete_cache_file", zDelete ? 1 : 0);
                }
                if (zDelete) {
                    lnr(lnrVar);
                    return;
                }
            }
            qdl(file);
        } catch (Throwable unused) {
        }
    }

    private void lnr(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar) throws Throwable {
        lnrVar.jtx();
        this.to.qdl(lnrVar);
        lnrVar.jtx();
    }

    private void ud(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.to.qdl(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void ljh() {
        if (this.to == null) {
            return;
        }
        try {
            this.to.exu();
        } catch (Throwable unused) {
        }
        this.to.qdl((lnr.ud) null);
        this.to.qdl((lnr.wd) null);
        this.to.qdl((lnr.qdl) null);
        this.to.qdl((lnr.mml) null);
        this.to.qdl((lnr.InterfaceC0178lnr) null);
        this.to.qdl((lnr.mzz) null);
        this.to.qdl((lnr.mo) null);
        try {
            this.to.fs();
        } catch (Throwable unused2) {
        }
    }

    private void bch() {
        koa koaVar = this.jtx;
        if (koaVar == null || koaVar.getLooper() == null) {
            return;
        }
        try {
            this.jtx.post(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.6
                @Override // java.lang.Runnable
                public void run() {
                    if (mml.this.jtx == null || mml.this.jtx.getLooper() == null) {
                        return;
                    }
                    try {
                        com.bytedance.sdk.component.jpc.qdl.qdl.qdl().qdl(mml.this.jtx);
                        mml.this.jtx = null;
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr.qdl
    public void qdl(lnr lnrVar, int i) {
        if (this.to != lnrVar) {
            return;
        }
        for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().ud(this, i);
            }
        }
    }

    private void uw() {
        SparseIntArray sparseIntArray = qdl;
        int i = sparseIntArray.get(this.uw);
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf == null) {
            sparseIntArray.put(this.uw, 1);
            return;
        }
        int i2 = this.uw;
        numValueOf.getClass();
        sparseIntArray.put(i2, i + 1);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr.ud
    public void qdl(lnr lnrVar) {
        this.rdp = 209;
        qdl.delete(this.uw);
        koa koaVar = this.jtx;
        if (koaVar != null) {
            koaVar.removeCallbacks(this.ax);
        }
        for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().qdl(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr.InterfaceC0178lnr
    public boolean qdl(lnr lnrVar, int i, int i2) {
        uw();
        this.rdp = 200;
        koa koaVar = this.jtx;
        if (koaVar != null) {
            koaVar.removeCallbacks(this.ax);
        }
        if (qdl(i, i2)) {
            bch();
        }
        if (!this.ekw.get()) {
            return true;
        }
        this.ekw.set(false);
        com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl qdlVar = new com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl(i, i2);
        for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().qdl(this, qdlVar);
            }
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr.mml
    public boolean ud(lnr lnrVar, int i, int i2) {
        if (this.to != lnrVar) {
            return false;
        }
        if (i2 == -1004) {
            com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl qdlVar = new com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl(i, i2);
            for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().qdl(this, qdlVar);
                }
            }
        }
        ud(i, i2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(int i, int i2) {
        if (i == 701) {
            this.fco = SystemClock.elapsedRealtime();
            this.wd++;
            for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().qdl(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            Integer.valueOf(this.wd);
            return;
        }
        if (i == 702) {
            if (this.fco > 0) {
                this.mrf += SystemClock.elapsedRealtime() - this.fco;
                this.fco = 0L;
            }
            for (WeakReference<qdl.InterfaceC0177qdl> weakReference2 : this.lnr) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    weakReference2.get().qdl((com.bykv.vk.openvk.qdl.qdl.qdl.qdl) this, Integer.MAX_VALUE);
                }
            }
            Integer.valueOf(this.wd);
            Long.valueOf(this.mrf);
            return;
        }
        if (this.gy && i == 3) {
            vu();
            xmv();
            ud(this.vu);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr.mzz
    public void ud(lnr lnrVar) {
        if (jpc()) {
            return;
        }
        this.rdp = Constants.NEXT_STEP;
        try {
            com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar2 = this.koa;
            if (lnrVar2 != null) {
                float fBjy = lnrVar2.bjy();
                if (fBjy > 0.0f) {
                    com.bykv.vk.openvk.qdl.qdl.qdl.ud udVar = new com.bykv.vk.openvk.qdl.qdl.qdl.ud();
                    udVar.qdl(fBjy);
                    this.to.qdl(udVar);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.jtx != null) {
            if (this.hzv) {
                bqt();
            } else {
                koa koaVar = this.jtx;
                koaVar.sendMessage(koaVar.obtainMessage(100, -1, -1));
            }
        }
        qdl.delete(this.uw);
        boolean z = this.gy;
        boolean z2 = this.ljh;
        if (!z && !z2) {
            xmv();
            this.ljh = true;
        }
        for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().ud(this);
            }
        }
    }

    private void xmv() {
        this.tvp = true;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.oth;
        for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().qdl(this, jElapsedRealtime);
            }
        }
    }

    private void bqt() {
        koa koaVar = this.jtx;
        if (koaVar != null) {
            koaVar.post(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        mml.this.to.jpc();
                        mml.this.rdp = ComposerKt.reuseKey;
                        mml.this.hzv = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr.mo
    public void lnr(lnr lnrVar) {
        for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().qdl((com.bykv.vk.openvk.qdl.qdl.qdl.qdl) this, true);
            }
        }
    }

    private void qdl(Runnable runnable) {
        try {
            if (this.bch == null) {
                this.bch = new ArrayList<>();
            }
            this.bch.add(runnable);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void koa() {
        if (this.fs) {
            return;
        }
        this.fs = true;
        Iterator it = new ArrayList(this.bch).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.bch.clear();
        this.fs = false;
    }

    private void vu() {
        ArrayList<Runnable> arrayList = this.bch;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        koa();
    }

    private void rc() {
        ArrayList<Runnable> arrayList = this.bch;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.bch.clear();
    }

    private void ud(Runnable runnable) {
        if (runnable == null || jpc()) {
            return;
        }
        if (!this.exu) {
            runnable.run();
        } else {
            qdl(runnable);
        }
    }

    public void ud(final boolean z) {
        koa koaVar;
        if (jpc() || (koaVar = this.jtx) == null) {
            return;
        }
        koaVar.post(new Runnable() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml.8
            @Override // java.lang.Runnable
            public void run() {
                if (mml.this.jpc() || mml.this.to == null) {
                    return;
                }
                try {
                    mml.this.vu = z;
                    mml.this.to.mml(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public long rdp() {
        if (this.yt) {
            long j = this.aaj;
            if (j > 0) {
                return this.jl + j;
            }
        }
        return this.jl;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl
    public int mml() {
        if (this.to == null || jpc()) {
            return 0;
        }
        return this.to.rdp();
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl
    public int mzz() {
        if (this.to == null || jpc()) {
            return 0;
        }
        return this.to.bjy();
    }

    public int bjy() {
        return this.wd;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr.wd
    public void qdl(lnr lnrVar, int i, int i2, int i3, int i4) {
        for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().qdl((com.bykv.vk.openvk.qdl.qdl.qdl.qdl) this, i, i2);
            }
        }
    }

    public long jtx() {
        long j = this.jyq;
        if (j != 0) {
            return j;
        }
        if (this.rdp == 206 || this.rdp == 207) {
            try {
                this.jyq = this.to.rq();
            } catch (Throwable unused) {
            }
        }
        return this.jyq;
    }

    public long yt() {
        if (jpc()) {
            return 0L;
        }
        if (this.rdp == 206 || this.rdp == 207) {
            try {
                return this.to.to();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public void qdl(qdl.InterfaceC0177qdl interfaceC0177qdl) {
        if (interfaceC0177qdl == null) {
            return;
        }
        for (WeakReference<qdl.InterfaceC0177qdl> weakReference : this.lnr) {
            if (weakReference != null && weakReference.get() == interfaceC0177qdl) {
                return;
            }
        }
        this.lnr.add(new WeakReference<>(interfaceC0177qdl));
    }

    public void qdl(int i) {
        if (jpc()) {
            return;
        }
        this.kdv = i;
    }

    public SurfaceHolder jl() {
        return this.mo;
    }

    public SurfaceTexture exc() {
        return this.mzz;
    }

    public void ud(int i) {
        this.jpc = i;
    }

    public boolean qdl(float f) {
        PlaybackParams playbackParamsMzz;
        if (f <= 0.0f) {
            return false;
        }
        try {
            if (this.to == null || !lnr()) {
                return false;
            }
            try {
                playbackParamsMzz = this.to.mzz();
            } catch (Throwable th) {
                aaj.lnr("CSJ_VIDEO_MEDIA", "getPlaybackParams error:" + th.getMessage());
                playbackParamsMzz = null;
            }
            if ((playbackParamsMzz != null ? playbackParamsMzz.getSpeed() : 0.0f) == f) {
                return true;
            }
            com.bykv.vk.openvk.qdl.qdl.qdl.ud udVar = new com.bykv.vk.openvk.qdl.qdl.qdl.ud();
            udVar.qdl(f);
            this.to.qdl(udVar);
            return true;
        } catch (Throwable th2) {
            aaj.qdl("CSJ_VIDEO_MEDIA", "setPlaySpeedRatio error: ", th2);
            return false;
        }
    }

    class qdl implements Runnable {
        private boolean lnr;
        private long ud;

        qdl() {
        }

        public void qdl(boolean z) {
            this.lnr = z;
        }

        public void qdl(long j) {
            this.ud = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mml.this.to != null) {
                try {
                    if (!this.lnr) {
                        long j = mml.this.to.to();
                        mml.this.bjy = Math.max(this.ud, j);
                    }
                    long unused = mml.this.bjy;
                } catch (Throwable th) {
                    th.toString();
                }
            }
            if (mml.this.jtx != null) {
                mml.this.jtx.sendEmptyMessageDelayed(100, 0L);
            }
        }
    }
}
