package com.hive.core;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OauthToken.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u000fH'R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/hive/core/OauthToken;", "Ljava/io/Serializable;", "<init>", "()V", "value", "", "accessToken", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "refreshToken", "getRefreshToken", "setRefreshToken", "isExpire", "", "margin", "", "refresh", k.M, "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class OauthToken implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static OauthToken currentOauthToken;
    private String accessToken;
    private String refreshToken;

    public abstract boolean refresh();

    /* JADX INFO: compiled from: OauthToken.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/hive/core/OauthToken$Companion;", "", "<init>", "()V", "currentOauthToken", "Lcom/hive/core/OauthToken;", "getCurrentOauthToken", "()Lcom/hive/core/OauthToken;", "setCurrentOauthToken", "(Lcom/hive/core/OauthToken;)V", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OauthToken getCurrentOauthToken() {
            return OauthToken.currentOauthToken;
        }

        public final void setCurrentOauthToken(OauthToken oauthToken) {
            OauthToken.currentOauthToken = oauthToken;
        }
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(String str) {
        this.accessToken = str;
        currentOauthToken = str != null ? this : null;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public static /* synthetic */ boolean isExpire$default(OauthToken oauthToken, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isExpire");
        }
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return oauthToken.isExpire(i);
    }

    public final boolean isExpire(int margin) {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            String str = this.accessToken;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(Boolean.valueOf(str != null ? new Jwt(str).isExpire(margin) : true));
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.w("JWT decoded Exception: " + thM7418exceptionOrNullimpl);
        }
        if (kotlin.Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = true;
        }
        return ((Boolean) objM7415constructorimpl).booleanValue();
    }
}
