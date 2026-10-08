package com.google.android.gms.tasks;

import com.facebook.login.LoginLogger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.4.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException of(Task<?> task) {
        String strConcat;
        if (!task.isComplete()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception exception = task.getException();
        if (exception != null) {
            strConcat = LoginLogger.EVENT_EXTRAS_FAILURE;
        } else if (task.isSuccessful()) {
            String strValueOf = String.valueOf(task.getResult());
            String.valueOf(strValueOf);
            strConcat = "result ".concat(String.valueOf(strValueOf));
        } else {
            strConcat = task.isCanceled() ? "cancellation" : "unknown issue";
        }
        return new DuplicateTaskCompletionException("Complete with: ".concat(strConcat), exception);
    }
}
