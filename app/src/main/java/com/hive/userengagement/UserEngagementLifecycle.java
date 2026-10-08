package com.hive.userengagement;

import android.app.Activity;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.logger.LoggerImpl;
import com.hive.module.interfaces.HiveUserEngagement;
import com.hive.push.data.CachedPushActiveAppData;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.OnActivityLifecycle;
import java.net.URI;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002¨\u0006\u0017"}, d2 = {"Lcom/hive/userengagement/UserEngagementLifecycle;", "Lcom/hive/standalone/HiveLifecycle$HiveLifecycleListener;", "Lcom/hive/ui/OnActivityLifecycle;", "<init>", "()V", "onSignIn", "", "hiveAccount", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "onSignOut", "onProcessUri", ShareConstants.MEDIA_URI, "", "onNewIntent", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "onResume", "isValidDirectlinkScheme", "", "url", "getDirectlinkPayloadScheme", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserEngagementLifecycle extends OnActivityLifecycle implements HiveLifecycle.HiveLifecycleListener {
    public UserEngagementLifecycle() {
        HiveLifecycle.registerHiveLifecycleListeners(this);
        HiveActivity.registerHiveActivityLifecycleListeners(this);
    }

    private final String getDirectlinkPayloadScheme(String url) {
        try {
            String query = new URI(url).getQuery();
            if (query == null) {
                return "";
            }
            for (String str : StringsKt.split$default((CharSequence) query, new String[]{"&"}, false, 0, 6, (Object) null)) {
                if (StringsKt.startsWith$default(str, "payload=", false, 2, (Object) null)) {
                    String string = new JSONObject(URLDecoder.decode(StringsKt.removePrefix(str, (CharSequence) "payload="), "UTF-8")).getString("scheme");
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private final boolean isValidDirectlinkScheme(String url) {
        try {
            String scheme = new URI(url).getScheme();
            if (scheme == null) {
                return false;
            }
            if (StringsKt.endsWith$default(scheme, ".directlink", false, 2, (Object) null)) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onAgreement() {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onAgreement(this);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onInitializeFinished() {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onInitializeFinished(this);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onNetworkAvailable(boolean z) {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onNetworkAvailable(this, z);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if ((intent != null ? intent.getDataString() : null) == null) {
            if ((intent != null ? intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION) : null) == null) {
                LoggerImpl.INSTANCE.d("[UserEngagement] onNewIntent::intent has no value");
                return;
            }
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL("UserEngagementLifecycle onNewIntent, intent action = " + intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION));
            loggerImpl.dL("[UserEngagement] onNewIntent::intent.getStringExtra(\"action\") : " + intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION));
            loggerImpl.dR("[UserEngagement] onNewIntent::intent.getStringExtra(\"action\")");
            String stringExtra = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
            if (stringExtra == null || !UserEngagement.INSTANCE.processUri(stringExtra)) {
                return;
            }
            intent.removeExtra(NativeProtocol.WEB_DIALOG_ACTION);
            CachedPushActiveAppData.INSTANCE.clear();
            return;
        }
        LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
        loggerImpl2.dL("[UserEngagement] onNewIntent::intent.getDataString : " + intent.getDataString());
        loggerImpl2.dR("[UserEngagement] onNewIntent::intent.getDataString");
        String dataString = intent.getDataString();
        if (dataString != null) {
            if (isValidDirectlinkScheme(dataString)) {
                loggerImpl2.dL("[UserEngagement] onNewIntent, Directlink scheme data = " + getDirectlinkPayloadScheme(dataString));
                if (UserEngagement.INSTANCE.processUri(getDirectlinkPayloadScheme(dataString))) {
                    intent.setData(null);
                    return;
                }
                return;
            }
            loggerImpl2.dL("UserEngagementLifecycle onNewIntent, processUri data = " + dataString);
            if (UserEngagement.INSTANCE.processUri(dataString)) {
                intent.setData(null);
            }
        }
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onProcessUri(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        UserEngagement.INSTANCE.processUri(uri);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onReset() {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onReset(this);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = activity.getIntent();
        if ((intent != null ? intent.getDataString() : null) != null) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL("[UserEngagement] onResume::intent.getDataString : " + intent.getDataString());
            loggerImpl.dR("[UserEngagement] onResume::intent.getDataString");
            String dataString = intent.getDataString();
            if (dataString != null) {
                if (isValidDirectlinkScheme(dataString)) {
                    loggerImpl.dL("UserEngagementLifecycle onResume, Directlink scheme data = " + getDirectlinkPayloadScheme(dataString));
                    if (UserEngagement.INSTANCE.processUri(getDirectlinkPayloadScheme(dataString))) {
                        intent.setData(null);
                        return;
                    }
                    return;
                }
                loggerImpl.dL("UserEngagementLifecycle onResume, processUri data = " + dataString);
                if (UserEngagement.INSTANCE.processUri(dataString)) {
                    intent.setData(null);
                    return;
                }
                return;
            }
            return;
        }
        if ((intent != null ? intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION) : null) != null) {
            LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
            loggerImpl2.dL("UserEngagementLifecycle onResume, intent action = " + intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION));
            loggerImpl2.dL("[UserEngagement] onResume::intent.getStringExtra(\"action\") :" + intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION));
            loggerImpl2.dR("[UserEngagement] onResume::intent.getStringExtra(\"action\") :");
            String stringExtra = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
            if (stringExtra == null || !UserEngagement.INSTANCE.processUri(stringExtra)) {
                return;
            }
            intent.removeExtra(NativeProtocol.WEB_DIALOG_ACTION);
            CachedPushActiveAppData.INSTANCE.clear();
            return;
        }
        CachedPushActiveAppData cachedPushActiveAppData = CachedPushActiveAppData.INSTANCE;
        if (cachedPushActiveAppData.getString(NativeProtocol.WEB_DIALOG_ACTION) == null) {
            LoggerImpl.INSTANCE.d("[UserEngagement] onResume::intent has no value");
            return;
        }
        String string = cachedPushActiveAppData.getString(NativeProtocol.WEB_DIALOG_ACTION);
        if (string == null) {
            string = "";
        }
        LoggerImpl loggerImpl3 = LoggerImpl.INSTANCE;
        loggerImpl3.dL("[UserEngagement] onResume::CachedPushActiveAppData.getData(\"action\") :" + string);
        loggerImpl3.dR("[UserEngagement] onResume::CachedPushActiveAppData.getData(\"action\") :");
        if (UserEngagement.INSTANCE.processUri(string)) {
            cachedPushActiveAppData.clear();
        }
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onSetupFinished() {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onSetupFinished(this);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onSignIn(HiveLifecycle.HiveAccount hiveAccount) throws JSONException {
        Intrinsics.checkNotNullParameter(hiveAccount, "hiveAccount");
        UserEngagement userEngagement = UserEngagement.INSTANCE;
        userEngagement.handleEvents$hive_service_release();
        if (HiveLifecycle.INSTANCE.isStandAlone()) {
            userEngagement.setEngagementListener(new HiveUserEngagement.UserEngagementListener() { // from class: com.hive.userengagement.UserEngagementLifecycle.onSignIn.1
                @Override // com.hive.module.interfaces.HiveUserEngagement.UserEngagementListener
                public void onEngagement(ResultAPI result, HiveUserEngagement.EventType eventType, HiveUserEngagement.EventState eventState, JSONObject param) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(eventType, "eventType");
                    Intrinsics.checkNotNullParameter(eventState, "eventState");
                }
            });
            userEngagement.setEngagementReady(true);
        }
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onSignOut() throws JSONException {
        UserEngagement.INSTANCE.setEngagementReady(false);
    }
}
