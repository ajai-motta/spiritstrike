package com.unity3d.services.core.request.metrics;

/* JADX INFO: loaded from: classes6.dex */
public class InitMetric {
    private static final String INIT_METRIC_ENVIRONMENT_NOT_OK = "native_init_environment_not_ok";
    private static final String INIT_METRIC_ENVIRONMENT_OK = "native_init_environment_ok";

    public static Metric newInitEnvironmentOk() {
        return new Metric(INIT_METRIC_ENVIRONMENT_OK, null);
    }

    public static Metric newInitEnvironmentNotOk() {
        return new Metric(INIT_METRIC_ENVIRONMENT_NOT_OK, null);
    }
}
