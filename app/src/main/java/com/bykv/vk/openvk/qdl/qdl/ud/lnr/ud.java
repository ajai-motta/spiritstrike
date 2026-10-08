package com.bykv.vk.openvk.qdl.qdl.ud.lnr;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class ud extends com.bykv.vk.openvk.qdl.qdl.ud.lnr.qdl {
    private final qdl lnr;
    private com.bykv.vk.openvk.qdl.qdl.ud.qdl.qdl mml;
    private final Object mo;
    private Surface mzz;
    private final MediaPlayer ud;
    private volatile boolean wd;

    public ud() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.mo = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.ud = mediaPlayer;
        }
        qdl(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable unused) {
        }
        this.lnr = new qdl(this);
        yt();
    }

    private void qdl(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(objNewInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
            } catch (Throwable unused) {
                declaredField.setAccessible(false);
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void qdl(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.mo) {
            try {
                if (!this.wd && surfaceHolder != null && surfaceHolder.getSurface() != null && this.qdl) {
                    this.ud.setDisplay(surfaceHolder);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void qdl(Surface surface) {
        jl();
        this.mzz = surface;
        this.ud.setSurface(surface);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.ud udVar) throws Throwable {
        this.ud.setPlaybackParams(this.ud.getPlaybackParams().setSpeed(udVar.qdl()));
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public PlaybackParams mzz() throws IllegalStateException {
        return this.ud.getPlaybackParams();
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void qdl(String str) throws Throwable {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(ShareInternalUtility.STAGING_PARAM)) {
            this.ud.setDataSource(uri.getPath());
        } else {
            this.ud.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void qdl(FileDescriptor fileDescriptor) throws Throwable {
        this.ud.setDataSource(fileDescriptor);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public synchronized void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar) {
        this.mml = com.bykv.vk.openvk.qdl.qdl.ud.qdl.qdl.qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl(), lnrVar);
        com.bykv.vk.openvk.qdl.qdl.ud.qdl.ud.lnr.qdl(lnrVar);
        this.ud.setDataSource(this.mml);
    }

    private void jtx() {
        com.bykv.vk.openvk.qdl.qdl.ud.qdl.qdl qdlVar = this.mml;
        if (qdlVar != null) {
            try {
                qdlVar.close();
            } catch (Throwable unused) {
            }
            this.mml = null;
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void mo() throws Throwable {
        this.ud.start();
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void wd() throws Throwable {
        this.ud.stop();
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void jpc() throws Throwable {
        this.ud.pause();
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void tvp() {
        MediaPlayer mediaPlayer = this.ud;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void ud(boolean z) throws Throwable {
        this.ud.setScreenOnWhilePlaying(z);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void qdl(long j, int i) throws Throwable {
        if (Build.VERSION.SDK_INT < 26) {
            this.ud.seekTo((int) j);
            return;
        }
        if (i == 0) {
            this.ud.seekTo((int) j, 0);
            return;
        }
        if (i == 1) {
            this.ud.seekTo((int) j, 1);
            return;
        }
        if (i == 2) {
            this.ud.seekTo((int) j, 2);
        } else if (i == 3) {
            this.ud.seekTo((int) j, 3);
        } else {
            this.ud.seekTo((int) j);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public long to() {
        try {
            return this.ud.getCurrentPosition();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public long rq() {
        try {
            return this.ud.getDuration();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void fs() throws Throwable {
        synchronized (this.mo) {
            if (!this.wd) {
                this.ud.release();
                this.wd = true;
                jl();
                jtx();
                qdl();
                yt();
            }
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void exu() throws Throwable {
        try {
            this.ud.reset();
        } catch (Throwable unused) {
        }
        jtx();
        qdl();
        yt();
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void lnr(boolean z) throws Throwable {
        this.ud.setLooping(z);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void mml(boolean z) throws Throwable {
        MediaPlayer mediaPlayer = this.ud;
        if (mediaPlayer == null) {
            return;
        }
        if (z) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public int rdp() {
        MediaPlayer mediaPlayer = this.ud;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public int bjy() {
        MediaPlayer mediaPlayer = this.ud;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    private void yt() {
        this.ud.setOnPreparedListener(this.lnr);
        this.ud.setOnBufferingUpdateListener(this.lnr);
        this.ud.setOnCompletionListener(this.lnr);
        this.ud.setOnSeekCompleteListener(this.lnr);
        this.ud.setOnVideoSizeChangedListener(this.lnr);
        this.ud.setOnErrorListener(this.lnr);
        this.ud.setOnInfoListener(this.lnr);
    }

    private static class qdl implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<ud> qdl;

        public qdl(ud udVar) {
            this.qdl = new WeakReference<>(udVar);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                ud udVar = this.qdl.get();
                if (udVar != null) {
                    return udVar.ud(i, i2);
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                Integer.valueOf(i);
                Integer.valueOf(i2);
                ud udVar = this.qdl.get();
                if (udVar != null) {
                    return udVar.qdl(i, i2);
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                ud udVar = this.qdl.get();
                if (udVar != null) {
                    udVar.qdl(i, i2, 1, 1);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                ud udVar = this.qdl.get();
                if (udVar != null) {
                    udVar.mml();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                ud udVar = this.qdl.get();
                if (udVar != null) {
                    udVar.qdl(i);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                ud udVar = this.qdl.get();
                if (udVar != null) {
                    udVar.lnr();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                ud udVar = this.qdl.get();
                if (udVar != null) {
                    udVar.ud();
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        jl();
    }

    private void jl() {
        try {
            Surface surface = this.mzz;
            if (surface != null) {
                surface.release();
                this.mzz = null;
            }
        } catch (Throwable unused) {
        }
    }
}
