package com.hive.hercules;

import com.com2us.security.Hercules;
import com.hive.HiveActivity;
import com.hive.core.Configuration;
import com.hive.logger.LoggerImpl;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ProviderHercules.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/hive/hercules/ProviderHercules;", "", "<init>", "()V", "isInitialized", "", MobileAdsBridgeBase.initializeMethodName, "", "setDeviceId", "deviceId", "", "setPlayerId", "playerId", "hive-hercules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProviderHercules {
    public static final ProviderHercules INSTANCE = new ProviderHercules();
    private static boolean isInitialized;

    private ProviderHercules() {
    }

    public final void initialize() {
        String gameId = Configuration.INSTANCE.getGameId();
        if (StringsKt.isBlank(gameId)) {
            LoggerImpl.INSTANCE.e("[Hercules] ProviderHercules Not set game id.");
            return;
        }
        LoggerImpl.INSTANCE.dL("[Hercules] ProviderHercules initialize. gameId : " + gameId);
        LoggerImpl.INSTANCE.dR("[Hercules] ProviderHercules initialize. gameId");
        Hercules.initialize(HiveActivity.INSTANCE.getRecentActivity(), gameId);
        isInitialized = true;
    }

    public final void setDeviceId(String deviceId) {
        if (!isInitialized) {
            LoggerImpl.INSTANCE.e("[Hercules] ProviderHercules setDeviceId() Not initialized");
            return;
        }
        if (deviceId != null) {
            LoggerImpl.INSTANCE.dL("[Hercules] ProviderHercules setDeviceId : " + deviceId);
            LoggerImpl.INSTANCE.dR("[Hercules] ProviderHercules setDeviceId");
            Hercules.setDeviceId(deviceId);
            return;
        }
        LoggerImpl.INSTANCE.e("[Hercules] ProviderHercules Not set device id.");
    }

    public final void setPlayerId(String playerId) {
        if (!isInitialized) {
            LoggerImpl.INSTANCE.e("[Hercules] ProviderHercules setPlayerId() Not initialized");
            return;
        }
        if (playerId != null) {
            LoggerImpl.INSTANCE.dL("[Hercules] ProviderHercules setPlayerId : " + playerId);
            LoggerImpl.INSTANCE.dR("[Hercules] ProviderHercules setPlayerId");
            Hercules.setPlayerId(playerId);
            return;
        }
        LoggerImpl.INSTANCE.e("[Hercules] ProviderHercules Not set player id.");
    }
}
