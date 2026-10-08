package com.hive.analytics.provider.attributes;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0007\u001a\u00020\bH&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/hive/analytics/provider/attributes/IAnalyticsSpecific;", "", "trackerName", "", "<init>", "(Ljava/lang/String;)V", "getTrackerName", "toJson", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class IAnalyticsSpecific {
    private final String trackerName;

    public IAnalyticsSpecific(String trackerName) {
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        this.trackerName = trackerName;
    }

    public final String getTrackerName() {
        return this.trackerName;
    }

    public abstract JSONObject toJson();
}
