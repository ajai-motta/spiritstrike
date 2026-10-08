package com.hive.push.local.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Push;
import com.hive.ResultAPI;
import com.hive.logger.LoggerImpl;
import com.hive.push.PushImpl;
import com.hive.push.local.LocalMessaging;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00052\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, d2 = {"Lcom/hive/push/local/provider/LocalPushProviderAndroidDefault;", "Lcom/hive/push/local/provider/LocalPushProviderAdapter;", "<init>", "()V", "registerLocalPush", "", "jsonObj", "Lorg/json/JSONObject;", "localPush", "Lcom/hive/Push$LocalPush;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Push$LocalPushListener;", "unregisterLocalPush", "noticeID", "", "unregisterLocalPushes", "noticeIDs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "unregisterAllLocalPush", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalPushProviderAndroidDefault extends LocalPushProviderAdapter {
    public static final LocalPushProviderAndroidDefault INSTANCE = new LocalPushProviderAndroidDefault();

    private LocalPushProviderAndroidDefault() {
        super(PushImpl.LocalPushType.ANDROID_DEFAULT);
    }

    @Override // com.hive.push.local.provider.LocalPushProviderAdapter
    public void registerLocalPush(JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        LocalMessaging localMessaging = LocalMessaging.INSTANCE;
        Push.LocalPush localPush = new Push.LocalPush();
        localPush.setData(jsonObj);
        localMessaging.registerLocalpush(localPush);
    }

    @Override // com.hive.push.local.provider.LocalPushProviderAdapter
    public void unregisterAllLocalPush() {
        LocalMessaging.INSTANCE.unRegisterAllLocalPush();
    }

    @Override // com.hive.push.local.provider.LocalPushProviderAdapter
    public void unregisterLocalPush(int noticeID) {
        LocalMessaging.INSTANCE.unRegisterLocalpush(noticeID);
    }

    @Override // com.hive.push.local.provider.LocalPushProviderAdapter
    public void unregisterLocalPushes(ArrayList<Integer> noticeIDs) {
        LocalMessaging.INSTANCE.unregisterLocalPushes(noticeIDs);
    }

    @Override // com.hive.push.local.provider.LocalPushProviderAdapter
    public void registerLocalPush(Push.LocalPush localPush, Push.LocalPushListener listener) {
        if (localPush != null) {
            LocalMessaging.INSTANCE.registerLocalpush(localPush);
            if (listener != null) {
                listener.onRegisterLocalPush(new ResultAPI(), localPush);
                return;
            }
            return;
        }
        LoggerImpl.INSTANCE.i(Push.getTAG(), "No LocalPush Data(LocalPushProviderAndroidDefault registerLocalPush)");
        ResultAPI resultAPI = new ResultAPI(-1, ResultAPI.Code.PushInvalidParamLocalPush, "No LocalPush Data");
        if (listener != null) {
            listener.onRegisterLocalPush(resultAPI, null);
        }
    }
}
