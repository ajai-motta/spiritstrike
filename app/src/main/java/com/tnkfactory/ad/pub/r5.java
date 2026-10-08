package com.tnkfactory.ad.pub;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes6.dex */
public final class r5 extends SurfaceView implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaPlayer f3188a;
    public final AudioManager b;
    public boolean c;
    public boolean d;
    public boolean e;
    public float f;
    public Object g;
    public int h;
    public int i;
    public int j;
    public String k;
    public g5 l;
    public CountDownTimer m;
    public boolean n;
    public long o;

    public r5(Context context) {
        super(context);
        this.f3188a = null;
        this.b = null;
        this.c = false;
        this.d = false;
        this.e = true;
        this.f = 0.5f;
        this.g = null;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = 0L;
        getHolder().addCallback(this);
        this.b = (AudioManager) getContext().getSystemService("audio");
    }

    private float getCurrentVolume() {
        return this.b.getStreamVolume(3) / this.b.getStreamMaxVolume(3);
    }

    public final void a() {
        int i;
        if (this.f3188a == null || (i = this.h) == 0 || i == 1) {
            return;
        }
        this.h = 3;
        if (!this.d) {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build()).build();
                this.g = audioFocusRequestBuild;
                this.b.requestAudioFocus(audioFocusRequestBuild);
            } else {
                this.b.requestAudioFocus(null, 3, 1);
            }
        }
        this.f3188a.setOnPreparedListener(new n5());
        this.f3188a.start();
        g5 g5Var = this.l;
        if (g5Var != null) {
            ((a5) g5Var).a(this.f3188a.getDuration());
        }
    }

    public int getPlayCurrentTime() {
        MediaPlayer mediaPlayer = this.f3188a;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return -1;
    }

    public int getPlayTimeLeft() {
        MediaPlayer mediaPlayer = this.f3188a;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration() - this.f3188a.getCurrentPosition();
        }
        return -1;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2;
        Object obj;
        CountDownTimer countDownTimer = this.m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (!this.d) {
            if (Build.VERSION.SDK_INT < 26 || (obj = this.g) == null) {
                this.b.abandonAudioFocus(null);
            } else {
                this.b.abandonAudioFocusRequest((AudioFocusRequest) obj);
            }
        }
        this.h = 5;
        g5 g5Var = this.l;
        if (g5Var != null) {
            ((a5) g5Var).a();
        }
        if (!this.c || (mediaPlayer2 = this.f3188a) == null) {
            return;
        }
        mediaPlayer2.start();
        this.f3188a.seekTo(0);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        g5 g5Var = this.l;
        if (g5Var == null) {
            return false;
        }
        a5 a5Var = (a5) g5Var;
        c cVar = a5Var.b.C;
        if (cVar == null || TextUtils.isEmpty(cVar.m0)) {
            return false;
        }
        if (i == 1) {
            String str = a5Var.b.C.m0;
            if (i2 == -1010) {
                i5.a(str, 403);
                return false;
            }
            if (i2 == -1007) {
                i5.a(str, TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE);
                return false;
            }
            if (i2 == -1004) {
                i5.a(str, 401);
                return false;
            }
            if (i2 != -110) {
                return false;
            }
            i5.a(str, 402);
            return false;
        }
        if (i != 100) {
            return false;
        }
        String str2 = a5Var.b.C.m0;
        if (i2 == -1010) {
            i5.a(str2, 403);
            return false;
        }
        if (i2 == -1007) {
            i5.a(str2, TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE);
            return false;
        }
        if (i2 == -1004) {
            i5.a(str2, 401);
            return false;
        }
        if (i2 != -110) {
            return false;
        }
        i5.a(str2, 402);
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.h = 2;
        this.f3188a.seekTo(0);
        g5 g5Var = this.l;
        if (g5Var != null) {
            i5 i5Var = ((a5) g5Var).b;
            if (i5Var.m || i5Var.l) {
                i5Var.b.a();
            }
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.i = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.j = videoHeight;
        if (this.i == 0 || videoHeight == 0) {
            return;
        }
        getHolder().setFixedSize(this.i, this.j);
        requestLayout();
        g5 g5Var = this.l;
        if (g5Var != null) {
            int i3 = this.i;
            int i4 = this.j;
            i5 i5Var = ((a5) g5Var).b;
            if (i5Var.n) {
                float width = i5Var.getWidth();
                float height = i5Var.getHeight();
                int paddingRight = i5Var.getPaddingRight() + i5Var.getPaddingLeft();
                RelativeLayout.LayoutParams layoutParams = i5Var.c;
                float f = width - ((paddingRight + layoutParams.leftMargin) + layoutParams.rightMargin);
                int paddingBottom = i5Var.getPaddingBottom() + i5Var.getPaddingTop();
                RelativeLayout.LayoutParams layoutParams2 = i5Var.c;
                float f2 = height - ((paddingBottom + layoutParams2.topMargin) + layoutParams2.bottomMargin);
                float f3 = i3;
                float f4 = i4;
                float f5 = f / f2 > f3 / f4 ? f2 / f4 : f / f3;
                layoutParams2.width = (int) (f3 * f5);
                layoutParams2.height = (int) (f5 * f4);
                i5Var.f3143a.setLayoutParams(layoutParams2);
                i5Var.f3143a.requestLayout();
            }
        }
    }

    public void setLooping(boolean z) {
        this.c = z;
    }

    public void setMediaPath(String str) {
        this.k = str;
    }

    public void setMute(boolean z) {
        this.d = z;
    }

    public void setVideoPlayListener(g5 g5Var) {
        this.l = g5Var;
    }

    public void setVolumeOn(boolean z) {
        MediaPlayer mediaPlayer = this.f3188a;
        if (mediaPlayer == null || this.d || this.e == z) {
            return;
        }
        if (z) {
            float f = this.f;
            mediaPlayer.setVolume(f, f);
            this.e = true;
        } else {
            this.f = getCurrentVolume();
            this.f3188a.setVolume(0.0f, 0.0f);
            this.e = false;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00d5 A[EXC_TOP_SPLITTER, PHI: r0
  0x00d5: PHI (r0v5 java.io.FileInputStream) = (r0v4 java.io.FileInputStream), (r0v6 java.io.FileInputStream) binds: [B:39:0x00d3, B:33:0x00be] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // android.view.SurfaceHolder.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void surfaceCreated(android.view.SurfaceHolder r7) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tnkfactory.ad.pub.r5.surfaceCreated(android.view.SurfaceHolder):void");
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Object obj;
        if (this.f3188a != null) {
            g5 g5Var = this.l;
            if (g5Var != null) {
                ((a5) g5Var).b();
            }
            this.f3188a.reset();
            this.f3188a.release();
            this.f3188a = null;
            CountDownTimer countDownTimer = this.m;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
        if (this.d) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26 || (obj = this.g) == null) {
            this.b.abandonAudioFocus(null);
        } else {
            this.b.abandonAudioFocusRequest((AudioFocusRequest) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.content.Context r12, android.widget.ImageView r13, com.tnkfactory.ad.pub.c r14) {
        /*
            r11 = this;
            if (r14 != 0) goto L3
            return
        L3:
            com.tnkfactory.ad.pub.z1 r0 = r14.j0
            java.util.ArrayList r0 = r0.k
            r1 = 0
            if (r0 != 0) goto L17
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L17
            goto L39
        L17:
            java.lang.String r0 = r14.l0
            a(r0)
            com.tnkfactory.ad.pub.z1 r0 = r14.j0
            java.util.ArrayList r2 = r0.l
            if (r2 == 0) goto L39
            java.util.ArrayList r0 = r0.k
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L39
            com.tnkfactory.ad.pub.z1 r0 = r14.j0
            java.util.ArrayList r0 = r0.k
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            long r0 = a(r0)
            goto L3b
        L39:
            r0 = 0
        L3b:
            r7 = r0
            android.os.CountDownTimer r0 = r11.m
            if (r0 == 0) goto L43
            r0.cancel()
        L43:
            com.tnkfactory.ad.pub.o5 r0 = new com.tnkfactory.ad.pub.o5
            android.media.MediaPlayer r1 = r11.f3188a
            int r1 = r1.getDuration()
            long r4 = (long) r1
            r2 = r0
            r3 = r11
            r6 = r14
            r9 = r12
            r10 = r13
            r2.<init>(r3, r4, r6, r7, r9, r10)
            android.os.CountDownTimer r12 = r0.start()
            r11.m = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tnkfactory.ad.pub.r5.a(android.content.Context, android.widget.ImageView, com.tnkfactory.ad.pub.c):void");
    }

    public static long a(String str) {
        long j;
        int i;
        if (str == null) {
            return 0L;
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length == 0) {
            return 0L;
        }
        try {
            if (strArrSplit.length == 3) {
                int iIndexOf = strArrSplit[2].indexOf(".");
                if (iIndexOf != -1) {
                    strArrSplit[2] = strArrSplit[2].substring(0, iIndexOf);
                }
                j = ((long) (Integer.parseInt(strArrSplit[0]) * 3600)) + ((long) (Integer.parseInt(strArrSplit[1]) * 60));
                i = Integer.parseInt(strArrSplit[2]);
            } else {
                if (strArrSplit.length != 2) {
                    return 0L;
                }
                j = Integer.parseInt(strArrSplit[0]) * 60;
                i = Integer.parseInt(strArrSplit[1]);
            }
            return ((long) i) + j;
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }
}
