package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzed;
import com.google.android.gms.ads.internal.client.zzfz;
import com.google.android.gms.ads.internal.util.client.zzo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class VideoController {
    public static final int PLAYBACK_STATE_ENDED = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_READY = 5;
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object zza = new Object();
    private zzed zzb;
    private VideoLifecycleCallbacks zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zza) {
            videoLifecycleCallbacks = this.zzc;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzb != null;
        }
        return z;
    }

    public final void zza(zzed zzedVar) {
        synchronized (this.zza) {
            this.zzb = zzedVar;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    public final zzed zzb() {
        zzed zzedVar;
        synchronized (this.zza) {
            zzedVar = this.zzb;
        }
        return zzedVar;
    }

    public int getPlaybackState() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return 0;
            }
            try {
                return zzedVar.zzi();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return false;
            }
            try {
                return zzedVar.zzp();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return false;
            }
            try {
                return zzedVar.zzn();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return true;
            }
            try {
                return zzedVar.zzh();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public void mute(boolean z) {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zzg(z);
            } catch (RemoteException e) {
                zzo.zzg("Unable to call mute on video controller.", e);
            }
        }
    }

    public void pause() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zzf();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call pause on video controller.", e);
            }
        }
    }

    public void play() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zze();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call play on video controller.", e);
            }
        }
    }

    public void stop() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zzq();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call stop on video controller.", e);
            }
        }
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzfz zzfzVar;
        synchronized (this.zza) {
            this.zzc = videoLifecycleCallbacks;
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            if (videoLifecycleCallbacks == null) {
                zzfzVar = null;
            } else {
                try {
                    zzfzVar = new zzfz(videoLifecycleCallbacks);
                } catch (RemoteException e) {
                    zzo.zzg("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
            zzedVar.zzl(zzfzVar);
        }
    }
}
