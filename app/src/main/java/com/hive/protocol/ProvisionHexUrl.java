package com.hive.protocol;

import com.adjust.sdk.AdjustConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProvisionHexUrl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/hive/protocol/ProvisionHexUrl;", "", "<init>", "()V", "real", "", "getReal", "()Ljava/lang/String;", "setReal", "(Ljava/lang/String;)V", AdjustConfig.ENVIRONMENT_SANDBOX, "getSandbox", "setSandbox", "test", "getTest", "setTest", "dev", "getDev", "setDev", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProvisionHexUrl {
    public static final ProvisionHexUrl INSTANCE = new ProvisionHexUrl();
    private static String real = "68747470733a2f2f70726f766973696f6e2e7170796f752e636e";
    private static String sandbox = "68747470733a2f2f73616e64626f782d70726f766973696f6e2e7170796f752e636e";
    private static String test = "68747470733a2f2f746573742d70726f766973696f6e2e7170796f752e636e";
    private static String dev = "68747470733a2f2f6465762d70726f766973696f6e2e7170796f752e636e";

    private ProvisionHexUrl() {
    }

    public final String getReal() {
        return real;
    }

    public final void setReal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        real = str;
    }

    public final String getSandbox() {
        return sandbox;
    }

    public final void setSandbox(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        sandbox = str;
    }

    public final String getTest() {
        return test;
    }

    public final void setTest(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        test = str;
    }

    public final String getDev() {
        return dev;
    }

    public final void setDev(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        dev = str;
    }
}
