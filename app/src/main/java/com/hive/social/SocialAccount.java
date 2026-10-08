package com.hive.social;

import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.OauthToken;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.socialapi.AcaGetAuthToken;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/hive/social/SocialAccount;", "Lcom/hive/core/OauthToken;", "Ljava/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "readResolve", "", "removeToken", "", "refresh", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialAccount extends OauthToken implements Serializable {
    public static final SocialAccount INSTANCE = new SocialAccount();
    private static final long serialVersionUID = 14305830495823L;

    private SocialAccount() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // com.hive.core.OauthToken
    public boolean refresh() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[SocialAccount] refresh()");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<AcaGetAuthToken>() { // from class: com.hive.social.SocialAccount$refresh$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.AcaGetAuthToken] */
            @Override // kotlin.jvm.functions.Function0
            public final AcaGetAuthToken invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = AcaGetAuthToken.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setAutoRefreshOauthToken(false);
        protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getPeppermintInitAppId());
        protocol.setParam(HiveKeys.KEY_client_id, Configuration.INSTANCE.getPrimaryClientId());
        protocol.setParam(HiveKeys.KEY_grant_type, "refresh_token");
        protocol.setParam(HiveKeys.KEY_code, INSTANCE.getRefreshToken());
        AcaGetAuthToken.AcaGetAuthTokenResponse response = ((AcaGetAuthToken) protocol.request()).getResponse();
        if (response.isSuccess()) {
            setAccessToken(response.getAccessToken());
            setRefreshToken(response.getRefreshToken());
            loggerImpl.d("[SocialAccount] refresh() success.");
            return true;
        }
        loggerImpl.w("[SocialAccount] refresh() failed: " + response.getResMsg() + '(' + response.getResCode() + ")\n");
        return false;
    }

    public final void removeToken() {
        LoggerImpl.INSTANCE.d("[SocialAccount] Remove OAuthToken");
        setAccessToken(null);
        setRefreshToken(null);
    }
}
