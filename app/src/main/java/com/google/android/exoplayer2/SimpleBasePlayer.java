package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Size;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes8.dex */
public abstract class SimpleBasePlayer extends BasePlayer {
    private final HandlerWrapper applicationHandler;
    private final Looper applicationLooper;
    private final ListenerSet<Player.Listener> listeners;
    private final HashSet<ListenableFuture<?>> pendingOperations;
    private State state;

    protected State getPlaceholderState(State state) {
        return state;
    }

    protected abstract State getState();

    protected static final class State {
        public final Player.Commands availableCommands;
        public final boolean playWhenReady;
        public final int playWhenReadyChangeReason;

        public static final class Builder {
            private Player.Commands availableCommands;
            private boolean playWhenReady;
            private int playWhenReadyChangeReason;

            public Builder() {
                this.availableCommands = Player.Commands.EMPTY;
                this.playWhenReady = false;
                this.playWhenReadyChangeReason = 1;
            }

            private Builder(State state) {
                this.availableCommands = state.availableCommands;
                this.playWhenReady = state.playWhenReady;
                this.playWhenReadyChangeReason = state.playWhenReadyChangeReason;
            }

            public Builder setAvailableCommands(Player.Commands commands) {
                this.availableCommands = commands;
                return this;
            }

            public Builder setPlayWhenReady(boolean z, int i) {
                this.playWhenReady = z;
                this.playWhenReadyChangeReason = i;
                return this;
            }

            public State build() {
                return new State(this);
            }
        }

        private State(Builder builder) {
            this.availableCommands = builder.availableCommands;
            this.playWhenReady = builder.playWhenReady;
            this.playWhenReadyChangeReason = builder.playWhenReadyChangeReason;
        }

        public Builder buildUpon() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return this.playWhenReady == state.playWhenReady && this.playWhenReadyChangeReason == state.playWhenReadyChangeReason && this.availableCommands.equals(state.availableCommands);
        }

        public int hashCode() {
            return ((((217 + this.availableCommands.hashCode()) * 31) + (this.playWhenReady ? 1 : 0)) * 31) + this.playWhenReadyChangeReason;
        }
    }

    protected SimpleBasePlayer(Looper looper) {
        this(looper, Clock.DEFAULT);
    }

    protected SimpleBasePlayer(Looper looper, Clock clock) {
        this.applicationLooper = looper;
        this.applicationHandler = clock.createHandler(looper, null);
        this.pendingOperations = new HashSet<>();
        this.listeners = new ListenerSet<>(looper, clock, new ListenerSet.IterationFinishedEvent() { // from class: com.google.android.exoplayer2.SimpleBasePlayer$$ExternalSyntheticLambda7
            @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
            public final void invoke(Object obj, FlagSet flagSet) {
                this.f$0.m4948lambda$new$0$comgoogleandroidexoplayer2SimpleBasePlayer((Player.Listener) obj, flagSet);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-google-android-exoplayer2-SimpleBasePlayer, reason: not valid java name */
    /* synthetic */ void m4948lambda$new$0$comgoogleandroidexoplayer2SimpleBasePlayer(Player.Listener listener, FlagSet flagSet) {
        listener.onEvents(this, new Player.Events(flagSet));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void addListener(Player.Listener listener) {
        this.listeners.add((Player.Listener) Assertions.checkNotNull(listener));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void removeListener(Player.Listener listener) {
        Assertions.checkNotNull(listener);
        this.listeners.remove(listener);
    }

    @Override // com.google.android.exoplayer2.Player
    public final Looper getApplicationLooper() {
        return this.applicationLooper;
    }

    @Override // com.google.android.exoplayer2.Player
    public final Player.Commands getAvailableCommands() {
        verifyApplicationThreadAndInitState();
        return this.state.availableCommands;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setPlayWhenReady(final boolean z) {
        verifyApplicationThreadAndInitState();
        final State state = this.state;
        if (state.availableCommands.contains(1)) {
            updateStateForPendingOperation(handleSetPlayWhenReady(z), new Supplier() { // from class: com.google.android.exoplayer2.SimpleBasePlayer$$ExternalSyntheticLambda4
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return state.buildUpon().setPlayWhenReady(z, 1).build();
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean getPlayWhenReady() {
        verifyApplicationThreadAndInitState();
        return this.state.playWhenReady;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setMediaItems(List<MediaItem> list, boolean z) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setMediaItems(List<MediaItem> list, int i, long j) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void addMediaItems(int i, List<MediaItem> list) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void moveMediaItems(int i, int i2, int i3) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void removeMediaItems(int i, int i2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void prepare() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getPlaybackState() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getPlaybackSuppressionReason() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final PlaybackException getPlayerError() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setRepeatMode(int i) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getRepeatMode() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setShuffleModeEnabled(boolean z) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean getShuffleModeEnabled() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isLoading() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekTo(int i, long j) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getSeekBackIncrement() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getSeekForwardIncrement() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getMaxSeekToPreviousPosition() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final PlaybackParameters getPlaybackParameters() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void stop() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void stop(boolean z) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void release() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final Tracks getCurrentTracks() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final TrackSelectionParameters getTrackSelectionParameters() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final MediaMetadata getMediaMetadata() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final MediaMetadata getPlaylistMetadata() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final Timeline getCurrentTimeline() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getCurrentPeriodIndex() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getCurrentMediaItemIndex() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getDuration() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getCurrentPosition() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getBufferedPosition() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getTotalBufferedDuration() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isPlayingAd() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getCurrentAdGroupIndex() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getCurrentAdIndexInAdGroup() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getContentPosition() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getContentBufferedPosition() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public final AudioAttributes getAudioAttributes() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public final void setVolume(float f) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public final float getVolume() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void clearVideoSurface() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void clearVideoSurface(Surface surface) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void setVideoSurface(Surface surface) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void setVideoSurfaceView(SurfaceView surfaceView) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void clearVideoSurfaceView(SurfaceView surfaceView) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void setVideoTextureView(TextureView textureView) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final void clearVideoTextureView(TextureView textureView) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public final VideoSize getVideoSize() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player
    public final Size getSurfaceSize() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.TextComponent
    public final CueGroup getCurrentCues() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public final DeviceInfo getDeviceInfo() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public final int getDeviceVolume() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public final boolean isDeviceMuted() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public final void setDeviceVolume(int i) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public final void increaseDeviceVolume() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public final void decreaseDeviceVolume() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public final void setDeviceMuted(boolean z) {
        throw new IllegalStateException();
    }

    protected final void invalidateState() {
        verifyApplicationThreadAndInitState();
        if (this.pendingOperations.isEmpty()) {
            updateStateAndInformListeners(getState());
        }
    }

    protected ListenableFuture<?> handleSetPlayWhenReady(boolean z) {
        throw new IllegalStateException();
    }

    @RequiresNonNull({"state"})
    private void updateStateAndInformListeners(final State state) {
        State state2 = this.state;
        this.state = state;
        boolean z = state2.playWhenReady != state.playWhenReady;
        if (z) {
            this.listeners.queueEvent(-1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.SimpleBasePlayer$$ExternalSyntheticLambda0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onPlayerStateChanged(state.playWhenReady, 1);
                }
            });
        }
        if (z || state2.playWhenReadyChangeReason != state.playWhenReadyChangeReason) {
            this.listeners.queueEvent(5, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.SimpleBasePlayer$$ExternalSyntheticLambda1
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.State state3 = state;
                    ((Player.Listener) obj).onPlayWhenReadyChanged(state3.playWhenReady, state3.playWhenReadyChangeReason);
                }
            });
        }
        if (isPlaying(state2) != isPlaying(state)) {
            this.listeners.queueEvent(7, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.SimpleBasePlayer$$ExternalSyntheticLambda2
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onIsPlayingChanged(SimpleBasePlayer.isPlaying(state));
                }
            });
        }
        if (!state2.availableCommands.equals(state.availableCommands)) {
            this.listeners.queueEvent(13, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.SimpleBasePlayer$$ExternalSyntheticLambda3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onAvailableCommandsChanged(state.availableCommands);
                }
            });
        }
        this.listeners.flushEvents();
    }

    @EnsuresNonNull({"state"})
    private void verifyApplicationThreadAndInitState() {
        if (Thread.currentThread() != this.applicationLooper.getThread()) {
            throw new IllegalStateException(Util.formatInvariant("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.applicationLooper.getThread().getName()));
        }
        if (this.state == null) {
            this.state = getState();
        }
    }

    @RequiresNonNull({"state"})
    private void updateStateForPendingOperation(final ListenableFuture<?> listenableFuture, Supplier<State> supplier) {
        if (listenableFuture.isDone() && this.pendingOperations.isEmpty()) {
            updateStateAndInformListeners(getState());
            return;
        }
        this.pendingOperations.add(listenableFuture);
        updateStateAndInformListeners(getPlaceholderState(supplier.get()));
        listenableFuture.addListener(new Runnable() { // from class: com.google.android.exoplayer2.SimpleBasePlayer$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4949xd55da8da(listenableFuture);
            }
        }, new Executor() { // from class: com.google.android.exoplayer2.SimpleBasePlayer$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f$0.postOrRunOnApplicationHandler(runnable);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$updateStateForPendingOperation$6$com-google-android-exoplayer2-SimpleBasePlayer, reason: not valid java name */
    /* synthetic */ void m4949xd55da8da(ListenableFuture listenableFuture) {
        Util.castNonNull(this.state);
        this.pendingOperations.remove(listenableFuture);
        if (this.pendingOperations.isEmpty()) {
            updateStateAndInformListeners(getState());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOrRunOnApplicationHandler(Runnable runnable) {
        if (this.applicationHandler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.applicationHandler.post(runnable);
        }
    }

    private static boolean isPlaying(State state) {
        boolean z = state.playWhenReady;
        return false;
    }
}
