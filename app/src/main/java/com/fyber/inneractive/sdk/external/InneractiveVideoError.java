package com.fyber.inneractive.sdk.external;

/* JADX INFO: loaded from: classes3.dex */
public class InneractiveVideoError extends InneractiveError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Error f1017a;
    public final Throwable b;

    public enum Error {
        ERROR_NO_MEDIA_FILES("ErrorNoMediaFiles", true),
        ERROR_FAILED_PLAYING_MEDIA_FILE("ErrorPlayingMediaFile", false),
        ERROR_FAILED_PLAYING_ALL_MEDIA_FILES("ErrorPlayingAllMediaFile", true),
        ERROR_PRE_BUFFER_TIMEOUT("ErrorPreBufferTimeout", false),
        ERROR_BUFFER_TIMEOUT("ErrorBufferTimeout", false);

        private String errorString;
        private boolean isFatal;

        Error(String str, boolean z) {
            this.errorString = str;
            this.isFatal = z;
        }

        public String getErrorString() {
            return this.errorString;
        }

        public boolean isFatal() {
            return this.isFatal;
        }
    }

    public InneractiveVideoError(Error error) {
        this.f1017a = error;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveError
    public String description() {
        if (this.b == null) {
            return this.f1017a.getErrorString();
        }
        return this.f1017a.getErrorString() + ": " + this.b;
    }

    public Throwable getCause() {
        return this.b;
    }

    public Error getPlayerError() {
        return this.f1017a;
    }

    public InneractiveVideoError(Error error, Throwable th) {
        this(error);
        this.b = th;
    }
}
