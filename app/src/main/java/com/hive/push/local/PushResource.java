package com.hive.push.local;

import com.hive.Push;
import com.hive.logger.LoggerImpl;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0000\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/hive/push/local/PushResource;", "Lcom/hive/Push$LocalPush;", "Ljava/io/Serializable;", "packageName", "", "elapsedRealtime", "", "savedCurrentTime", "triggerAtTime", "<init>", "(Ljava/lang/String;JJJ)V", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "getElapsedRealtime", "()J", "setElapsedRealtime", "(J)V", "getSavedCurrentTime", "setSavedCurrentTime", "getTriggerAtTime", "setTriggerAtTime", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushResource extends Push.LocalPush implements Serializable {
    private static final String TAG = "PushResource";
    private static final long serialVersionUID = 656707021576896773L;
    private long elapsedRealtime;
    private String packageName;
    private long savedCurrentTime;
    private long triggerAtTime;

    public PushResource(String packageName, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.packageName = packageName;
        this.elapsedRealtime = j;
        this.savedCurrentTime = j2;
        this.triggerAtTime = j3;
        LoggerImpl.INSTANCE.d(TAG, "[PushResource]" + getNoticeID());
    }

    public final long getElapsedRealtime() {
        return this.elapsedRealtime;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getSavedCurrentTime() {
        return this.savedCurrentTime;
    }

    public final long getTriggerAtTime() {
        return this.triggerAtTime;
    }

    public final void setElapsedRealtime(long j) {
        this.elapsedRealtime = j;
    }

    public final void setPackageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final void setSavedCurrentTime(long j) {
        this.savedCurrentTime = j;
    }

    public final void setTriggerAtTime(long j) {
        this.triggerAtTime = j;
    }
}
