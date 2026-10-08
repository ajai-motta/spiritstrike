package com.hive.push.local.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Push;
import com.hive.push.PushImpl;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.core.fid.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J$\u0010\u0011\u001a\u00020\u00072\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016¨\u0006\u0017"}, d2 = {"Lcom/hive/push/local/provider/LocalPushProviderAdapter;", "", "providerType", "Lcom/hive/push/PushImpl$LocalPushType;", "<init>", "(Lcom/hive/push/PushImpl$LocalPushType;)V", "registerLocalPush", "", "jsonObj", "Lorg/json/JSONObject;", "localPush", "Lcom/hive/Push$LocalPush;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Push$LocalPushListener;", "unregisterLocalPush", "noticeID", "", "unregisterLocalPushes", "noticeIDs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "unregisterAllLocalPush", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class LocalPushProviderAdapter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static LocalPushProviderAdapter targetProvider = LocalPushProviderAndroidDefault.INSTANCE;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\n\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J$\u0010\u0014\u001a\u00020\b2\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/hive/push/local/provider/LocalPushProviderAdapter$Companion;", "", "<init>", "()V", "targetProvider", "Lcom/hive/push/local/provider/LocalPushProviderAdapter;", Constants.GET_INSTANCE, "setExternalLocalPushProvider", "", "provider", "registerLocalPush", "jsonObj", "Lorg/json/JSONObject;", "localPush", "Lcom/hive/Push$LocalPush;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Push$LocalPushListener;", "unregisterLocalPush", "pushID", "", "unregisterLocalPushes", "noticeIDs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "unregisterAllLocalPush", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalPushProviderAdapter getInstance() {
            return LocalPushProviderAdapter.targetProvider;
        }

        public final void registerLocalPush(JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            LocalPushProviderAdapter.targetProvider.registerLocalPush(jsonObj);
        }

        public final void setExternalLocalPushProvider(LocalPushProviderAdapter provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            LocalPushProviderAdapter.targetProvider = provider;
        }

        public void unregisterAllLocalPush() {
            LocalPushProviderAdapter.targetProvider.unregisterAllLocalPush();
        }

        public final void unregisterLocalPush(int pushID) {
            LocalPushProviderAdapter.targetProvider.unregisterLocalPush(pushID);
        }

        public void unregisterLocalPushes(ArrayList<Integer> noticeIDs) {
            LocalPushProviderAdapter.targetProvider.unregisterLocalPushes(noticeIDs);
        }

        private Companion() {
        }

        public final void registerLocalPush(Push.LocalPush localPush, Push.LocalPushListener listener) {
            LocalPushProviderAdapter.targetProvider.registerLocalPush(localPush, listener);
        }
    }

    public LocalPushProviderAdapter(PushImpl.LocalPushType providerType) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
    }

    public void registerLocalPush(Push.LocalPush localPush, Push.LocalPushListener listener) {
    }

    public void unregisterAllLocalPush() {
    }

    public void unregisterLocalPush(int noticeID) {
    }

    public void unregisterLocalPushes(ArrayList<Integer> noticeIDs) {
    }

    public void registerLocalPush(JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
    }
}
