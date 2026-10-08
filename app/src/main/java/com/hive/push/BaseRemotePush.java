package com.hive.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.hive.Push;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.pushv4.Tokens;
import com.hive.push.PushImpl;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010!\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\u0018\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\rJ\u001a\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010.\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00102\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00103\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00104\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0016J\b\u00105\u001a\u00020\"H\u0016J\u0010\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\rH\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/hive/push/BaseRemotePush;", "", "context", "Landroid/content/Context;", "remotePushType", "Lcom/hive/push/PushImpl$RemotePushType;", "<init>", "(Landroid/content/Context;Lcom/hive/push/PushImpl$RemotePushType;)V", "getContext", "()Landroid/content/Context;", "getRemotePushType", "()Lcom/hive/push/PushImpl$RemotePushType;", "packageName", "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "isEnablePush", "", "()Z", "setEnablePush", "(Z)V", "isInitializedPush", "setInitializedPush", "baseRemotePushContext", "getBaseRemotePushContext", "setBaseRemotePushContext", "(Landroid/content/Context;)V", "isRequireSendToken", "setRequireSendToken", "cachedAccount", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", MobileAdsBridgeBase.initializeMethodName, "", "onLogin", "onLogout", "registerToken", "remotePush", "Lcom/hive/Push$RemotePush;", "logMessage", "onCreate", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onStart", "onResume", "onPause", "onStop", "onDestroy", "checkForAvailability", "className", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseRemotePush {
    private Context baseRemotePushContext;
    private HiveLifecycle.HiveAccount cachedAccount;
    private final Context context;
    private boolean isEnablePush;
    private boolean isInitializedPush;
    private boolean isRequireSendToken;
    private String packageName;
    private final PushImpl.RemotePushType remotePushType;

    public BaseRemotePush(Context context, PushImpl.RemotePushType remotePushType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remotePushType, "remotePushType");
        this.context = context;
        this.remotePushType = remotePushType;
        this.isEnablePush = true;
        this.baseRemotePushContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerToken$lambda$0(BaseRemotePush baseRemotePush, String str, Tokens tokens) {
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        baseRemotePush.isRequireSendToken = !tokens.getResponse().isSuccess();
        LoggerImpl.INSTANCE.apiCallbackLog(Push.getTAG(), str, tokens.getResponse().getResult().toString());
        return Unit.INSTANCE;
    }

    public final boolean checkForAvailability(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            Log.d("Hive/Push", "checkIfServiceAvailable of <" + className + Typography.greater);
            Class.forName(className);
            Log.d("Hive/Push", "checkIfServiceAvailable true : " + className);
            return true;
        } catch (Exception unused) {
            Log.d("Hive/Push", "checkIfServiceAvailable return false");
            Log.d("Hive/Push", "checkIfServiceAvailable false : " + className);
            return false;
        }
    }

    public final Context getBaseRemotePushContext() {
        return this.baseRemotePushContext;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final PushImpl.RemotePushType getRemotePushType() {
        return this.remotePushType;
    }

    public void initialize(HiveLifecycle.HiveAccount cachedAccount) {
        this.cachedAccount = cachedAccount;
    }

    /* JADX INFO: renamed from: isEnablePush, reason: from getter */
    public final boolean getIsEnablePush() {
        return this.isEnablePush;
    }

    /* JADX INFO: renamed from: isInitializedPush, reason: from getter */
    public final boolean getIsInitializedPush() {
        return this.isInitializedPush;
    }

    /* JADX INFO: renamed from: isRequireSendToken, reason: from getter */
    public final boolean getIsRequireSendToken() {
        return this.isRequireSendToken;
    }

    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onDestroy() {
    }

    public void onLogin() {
        this.cachedAccount = null;
        registerToken(null, "login");
    }

    public void onLogout() {
        this.cachedAccount = null;
        registerToken(null, "logout");
    }

    public void onNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.isRequireSendToken) {
            registerToken(null, "resume");
        }
    }

    public void onStop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void registerToken(Push.RemotePush remotePush, String logMessage) {
        Intrinsics.checkNotNullParameter(logMessage, "logMessage");
        String strTrimIndent = StringsKt.trimIndent("\n            [PushImpl::registerToken]\n            remotePush     : " + remotePush + "\n            remotePushType : " + this.remotePushType + "\n            logMessage     : " + logMessage + "\n            \n        ");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL(Push.getTAG(), strTrimIndent);
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (ConfigurationImpl.INSTANCE.getAgeGateU13(Android.HW_IDS_DEVICE_TOKEN)) {
            loggerImpl.i(Push.getTAG(), "[registerToken] Push can't use because of age gate under 13 rule.");
        } else {
            this.isRequireSendToken = !PushNetwork.INSTANCE.tokens(this.cachedAccount, remotePush, this.remotePushType, logMessage, new Function1() { // from class: com.hive.push.BaseRemotePush$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseRemotePush.registerToken$lambda$0(this.f$0, callMethodName, (Tokens) obj);
                }
            });
        }
    }

    public final void setBaseRemotePushContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.baseRemotePushContext = context;
    }

    public final void setEnablePush(boolean z) {
        this.isEnablePush = z;
    }

    public final void setInitializedPush(boolean z) {
        this.isInitializedPush = z;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void setRequireSendToken(boolean z) {
        this.isRequireSendToken = z;
    }
}
