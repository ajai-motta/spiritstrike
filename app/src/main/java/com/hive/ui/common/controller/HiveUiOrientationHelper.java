package com.hive.ui.common.controller;

import android.app.Activity;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveUiOrientationHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/hive/ui/common/controller/HiveUiOrientationHelper;", "", "activity", "Landroid/app/Activity;", "appOrientation", "", "<init>", "(Landroid/app/Activity;I)V", "getActivity", "()Landroid/app/Activity;", "getAppOrientation", "()I", "instanceId", "getInstanceId", "orientationMap", "", "getOrientationMap", "()Ljava/util/Map;", "lock", "", "targetOrientation", "unlock", "destroy", k.M, "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveUiOrientationHelper {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final Activity activity;
    private final int appOrientation;
    private final int instanceId;
    private final Map<Integer, Integer> orientationMap;

    public HiveUiOrientationHelper(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.appOrientation = i;
        this.instanceId = counter.getAndIncrement();
        this.orientationMap = new LinkedHashMap();
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final int getAppOrientation() {
        return this.appOrientation;
    }

    public final int getInstanceId() {
        return this.instanceId;
    }

    public final Map<Integer, Integer> getOrientationMap() {
        return this.orientationMap;
    }

    public final void lock(int targetOrientation) {
        if (this.appOrientation != targetOrientation) {
            this.orientationMap.put(Integer.valueOf(this.instanceId), Integer.valueOf(targetOrientation));
            this.activity.setRequestedOrientation(targetOrientation);
        }
    }

    public final void unlock() {
        Integer num = this.orientationMap.get(Integer.valueOf(this.instanceId));
        if (num != null) {
            int iIntValue = num.intValue();
            int i = this.appOrientation;
            if (i != iIntValue) {
                this.activity.setRequestedOrientation(i);
            }
            this.orientationMap.remove(Integer.valueOf(this.instanceId));
        }
    }

    public final void destroy() {
        Integer num = this.orientationMap.get(Integer.valueOf(this.instanceId));
        if (num != null) {
            num.intValue();
            this.orientationMap.remove(Integer.valueOf(this.instanceId));
        }
    }
}
