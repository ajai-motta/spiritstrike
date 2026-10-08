package com.hive.core.cache;

import android.os.Handler;
import android.os.Looper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveResourceRequestData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/hive/core/cache/HiveResourceRequestData;", "", "handler", "Landroid/os/Handler;", "url", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/core/cache/HiveResourceLoadingListener;", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Lcom/hive/core/cache/HiveResourceLoadingListener;)V", "getHandler", "()Landroid/os/Handler;", "getUrl", "()Ljava/lang/String;", "getListener", "()Lcom/hive/core/cache/HiveResourceLoadingListener;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HiveResourceRequestData {
    private final Handler handler;
    private final HiveResourceLoadingListener listener;
    private final String url;

    public static /* synthetic */ HiveResourceRequestData copy$default(HiveResourceRequestData hiveResourceRequestData, Handler handler, String str, HiveResourceLoadingListener hiveResourceLoadingListener, int i, Object obj) {
        if ((i & 1) != 0) {
            handler = hiveResourceRequestData.handler;
        }
        if ((i & 2) != 0) {
            str = hiveResourceRequestData.url;
        }
        if ((i & 4) != 0) {
            hiveResourceLoadingListener = hiveResourceRequestData.listener;
        }
        return hiveResourceRequestData.copy(handler, str, hiveResourceLoadingListener);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Handler getHandler() {
        return this.handler;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HiveResourceLoadingListener getListener() {
        return this.listener;
    }

    public final HiveResourceRequestData copy(Handler handler, String url, HiveResourceLoadingListener listener) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(url, "url");
        return new HiveResourceRequestData(handler, url, listener);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HiveResourceRequestData)) {
            return false;
        }
        HiveResourceRequestData hiveResourceRequestData = (HiveResourceRequestData) other;
        return Intrinsics.areEqual(this.handler, hiveResourceRequestData.handler) && Intrinsics.areEqual(this.url, hiveResourceRequestData.url) && Intrinsics.areEqual(this.listener, hiveResourceRequestData.listener);
    }

    public int hashCode() {
        int iHashCode = ((this.handler.hashCode() * 31) + this.url.hashCode()) * 31;
        HiveResourceLoadingListener hiveResourceLoadingListener = this.listener;
        return iHashCode + (hiveResourceLoadingListener == null ? 0 : hiveResourceLoadingListener.hashCode());
    }

    public String toString() {
        return "HiveResourceRequestData(handler=" + this.handler + ", url=" + this.url + ", listener=" + this.listener + ')';
    }

    public HiveResourceRequestData(Handler handler, String url, HiveResourceLoadingListener hiveResourceLoadingListener) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(url, "url");
        this.handler = handler;
        this.url = url;
        this.listener = hiveResourceLoadingListener;
    }

    public /* synthetic */ HiveResourceRequestData(Handler handler, String str, HiveResourceLoadingListener hiveResourceLoadingListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Handler(Looper.getMainLooper()) : handler, str, hiveResourceLoadingListener);
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final String getUrl() {
        return this.url;
    }

    public final HiveResourceLoadingListener getListener() {
        return this.listener;
    }
}
