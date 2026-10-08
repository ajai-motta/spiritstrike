package com.hive.socialv4;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.SocialV4;
import com.hive.logger.LoggerImpl;
import com.hive.module.interfaces.HiveSocialV4;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/hive/socialv4/SocialV4Impl;", "Lcom/hive/module/interfaces/HiveSocialV4;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "showCommunity", "", "providerType", "Lcom/hive/SocialV4$ProviderType;", "viewType", "Lcom/hive/SocialV4$ViewType;", "url", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/SocialV4$SocialV4ShowCommunityListener;", "sharePhoto", "Lcom/hive/SocialV4$SocialV4SharePhotoListener;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialV4Impl implements HiveSocialV4 {
    public static final SocialV4Impl INSTANCE = new SocialV4Impl();
    private static final String TAG;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SocialV4.ProviderType.values().length];
            try {
                iArr[SocialV4.ProviderType.HIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SocialV4.ProviderType.FACEBOOK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("SocialV4Impl", "getSimpleName(...)");
        TAG = "SocialV4Impl";
    }

    private SocialV4Impl() {
    }

    @Override // com.hive.module.interfaces.HiveSocialV4, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return HiveSocialV4.DefaultImpls.getHiveModuleName(this);
    }

    public final String getTAG() {
        return TAG;
    }

    @Override // com.hive.module.interfaces.HiveSocialV4, com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        return HiveSocialV4.DefaultImpls.getVersionInfo(this);
    }

    public final void sharePhoto(SocialV4.ProviderType providerType, final SocialV4.SocialV4SharePhotoListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.i(str, "Call sharePhoto(providerType: " + providerType.getStringValue());
        if (WhenMappings.$EnumSwitchMapping$0[providerType.ordinal()] != 2) {
            loggerImpl.d(str, "sharePhoto() ProviderType(" + providerType + ") is not supported");
            listener.onShare(new ResultAPI(-2, ResultAPI.Code.SocialInvalidParam));
            return;
        }
        SocialV4ProviderAdapter companion = SocialV4ProviderAdapter.INSTANCE.getInstance(SocialV4.ProviderType.FACEBOOK);
        if (companion != null) {
            companion.sharePhoto(new SocialV4ProviderAdapter.SharePhotoListener() { // from class: com.hive.socialv4.SocialV4Impl.sharePhoto.1
                @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SharePhotoListener
                public void onShare(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    listener.onShare(result);
                }
            });
        } else {
            loggerImpl.d(SocialV4.getTAG(), "SocialProvider is not initialized.");
            listener.onShare(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Facebook does not exist"));
        }
    }

    @Override // com.hive.module.interfaces.HiveSocialV4
    public void showCommunity(SocialV4.ProviderType providerType, SocialV4.ViewType viewType, String url, final SocialV4.SocialV4ShowCommunityListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.i(str, "Call showCommunity(providerType: " + providerType.getStringValue() + ", viewType: " + viewType.name() + ')');
        if (WhenMappings.$EnumSwitchMapping$0[providerType.ordinal()] != 1) {
            loggerImpl.d(str, "showCommunity() ProviderType(" + providerType + ") is not supported");
            listener.onShowCommunity(new ResultAPI(-2, ResultAPI.Code.SocialInvalidParam));
            return;
        }
        SocialV4ProviderAdapter companion = SocialV4ProviderAdapter.INSTANCE.getInstance(SocialV4.ProviderType.HIVE);
        if (companion != null) {
            companion.showCommunity(viewType, url, new SocialV4ProviderAdapter.ShowCommunityListener() { // from class: com.hive.socialv4.SocialV4Impl.showCommunity.1
                @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.ShowCommunityListener
                public void onShowCommunity(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    listener.onShowCommunity(result);
                }
            });
        } else {
            loggerImpl.w(SocialV4.getTAG(), "SocialProvider is not initialized.");
            listener.onShowCommunity(new ResultAPI(-2, ResultAPI.Code.SocialProviderNotInitialized));
        }
    }
}
