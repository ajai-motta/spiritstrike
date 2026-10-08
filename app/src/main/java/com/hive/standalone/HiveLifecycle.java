package com.hive.standalone;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.base.Android;
import com.hive.base.DataModel;
import com.hive.base.Property;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.OauthToken;
import com.hive.core.Platform;
import com.hive.logger.LoggerImpl;
import com.moloco.sdk.internal.services.init.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.Serializable;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0017\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002GHB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010/\u001a\u0004\u0018\u00010)J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0007J\u0010\u00103\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0007J\u0006\u00104\u001a\u000201J\u0006\u00105\u001a\u000201J\u0010\u00106\u001a\u0002012\b\b\u0002\u00107\u001a\u00020\u0011J\u000e\u00108\u001a\u0002012\u0006\u00109\u001a\u00020)J\u0006\u0010:\u001a\u000201J\u000e\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020\bJ\u0006\u0010=\u001a\u000201J\u000e\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020\u0011J\u001c\u0010@\u001a\u0002012\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020DH\u0002J!\u0010E\u001a\u0002012\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020DH\u0000¢\u0006\u0002\bFR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u001e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u001e\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u001f\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010 \u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R$\u0010*\u001a\u00020)2\u0006\u0010\n\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006I"}, d2 = {"Lcom/hive/standalone/HiveLifecycle;", "", "<init>", "()V", "hiveLifecycleList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/hive/standalone/HiveLifecycle$HiveLifecycleListener;", "hlcKey_recentHiveAccount", "", "hlcKey_did", "value", "did", "getDid", "()Ljava/lang/String;", "setDid", "(Ljava/lang/String;)V", "networkAvailable", "", "getNetworkAvailable", "()Z", "setNetworkAvailable", "(Z)V", "networkCallback", "com/hive/standalone/HiveLifecycle$networkCallback$1", "Lcom/hive/standalone/HiveLifecycle$networkCallback$1;", "isStandAlone", "setStandAlone", "isInitializeSdkV1", "isInitializeSdkV4", "isSetup", "isSdkSetup", "isSignIn", "isSignOut", "hiveConfigProviders", "Lorg/json/JSONObject;", "getHiveConfigProviders", "()Lorg/json/JSONObject;", "setHiveConfigProviders", "(Lorg/json/JSONObject;)V", "isC2SGuest", "setC2SGuest", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "account", "getAccount", "()Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "setAccount", "(Lcom/hive/standalone/HiveLifecycle$HiveAccount;)V", "getRecentHiveAccount", "registerHiveLifecycleListeners", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterActivityLifecycleListeners", "onAgreement", "onSetupFinished", "onInitializeFinished", "isSdkV1", "onSignIn", "hiveAccount", "onSignOut", "onProcessUri", ShareConstants.MEDIA_URI, "onReset", "onNetworkAvailable", "isAvailable", "registerNetworkCallback", "context", "Landroid/content/Context;", "callback", "Landroid/net/ConnectivityManager$NetworkCallback;", "unregisterNetworkCallback", "unregisterNetworkCallback$hive_service_release", "HiveLifecycleListener", "HiveAccount", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveLifecycle {
    public static final HiveLifecycle INSTANCE;
    private static HiveAccount account = null;
    private static String did = null;
    private static JSONObject hiveConfigProviders = null;
    private static final ConcurrentLinkedQueue<HiveLifecycleListener> hiveLifecycleList;
    private static final String hlcKey_did = "hlc.did";
    private static final String hlcKey_recentHiveAccount = "hlc.recent_hive_account";
    private static boolean isC2SGuest;
    private static boolean isInitializeSdkV1;
    private static boolean isInitializeSdkV4;
    private static boolean isSetup;
    private static boolean isStandAlone;
    private static boolean networkAvailable;
    private static final HiveLifecycle$networkCallback$1 networkCallback;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010 \u001a\u0004\u0018\u00010\u0006J\b\u0010!\u001a\u0004\u0018\u00010\u0006J\r\u0010\"\u001a\u00020#H\u0000¢\u0006\u0002\b$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "Lcom/hive/base/DataModel;", "Ljava/io/Serializable;", "<init>", "()V", "vid", "", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "uid", "getUid", "setUid", "did", "getDid", "setDid", "vidType", "getVidType", "setVidType", "vidSession", "getVidSession", "setVidSession", "uidSession", "getUidSession", "setUidSession", "oauthToken", "Lcom/hive/core/OauthToken;", "getOauthToken", "()Lcom/hive/core/OauthToken;", "setOauthToken", "(Lcom/hive/core/OauthToken;)V", "getAccountId", "getAccountUuid", "reset", "", "reset$hive_service_release", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class HiveAccount extends DataModel implements Serializable {
        private static final byte[] namespace;
        private static final long serialVersionUID = 35228372852124L;
        private String did;
        private OauthToken oauthToken;
        private String uid;
        private String uidSession;
        private String vid;
        private String vidSession;
        private String vidType;

        static {
            UUID uuidFromString = UUID.fromString("6ba7b811-9dad-11d1-80b4-00c04fd430c8");
            Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
            byte[] bArrAsBytes = ExtentionsKt.asBytes(uuidFromString);
            byte[] bytes = "HiveSDK".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            UUID uuidNameUUIDFromBytes = UUID.nameUUIDFromBytes(ArraysKt.plus(bArrAsBytes, bytes));
            Intrinsics.checkNotNullExpressionValue(uuidNameUUIDFromBytes, "nameUUIDFromBytes(...)");
            namespace = ExtentionsKt.asBytes(uuidNameUUIDFromBytes);
        }

        public final String getAccountId() {
            String vid = getVid();
            return vid == null ? getUid() : vid;
        }

        public final String getAccountUuid() {
            String accountId = getAccountId();
            if (accountId == null) {
                return null;
            }
            byte[] bArr = namespace;
            byte[] bytes = accountId.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return UUID.nameUUIDFromBytes(ArraysKt.plus(bArr, bytes)).toString();
        }

        public String getDid() {
            return this.did;
        }

        public OauthToken getOauthToken() {
            return this.oauthToken;
        }

        public String getUid() {
            return this.uid;
        }

        public String getUidSession() {
            return this.uidSession;
        }

        public String getVid() {
            return this.vid;
        }

        public String getVidSession() {
            return this.vidSession;
        }

        public String getVidType() {
            return this.vidType;
        }

        public final void reset$hive_service_release() {
            setVid(null);
            setUid(null);
            setVidSession(null);
            setUidSession(null);
            setOauthToken(null);
        }

        public void setDid(String str) {
            this.did = str;
        }

        public void setOauthToken(OauthToken oauthToken) {
            this.oauthToken = oauthToken;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public void setUidSession(String str) {
            this.uidSession = str;
        }

        public void setVid(String str) {
            this.vid = str;
        }

        public void setVidSession(String str) {
            this.vidSession = str;
        }

        public void setVidType(String str) {
            this.vidType = str;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/hive/standalone/HiveLifecycle$HiveLifecycleListener;", "", "onAgreement", "", "onSetupFinished", "onInitializeFinished", "onSignIn", "hiveAccount", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "onSignOut", "onProcessUri", ShareConstants.MEDIA_URI, "", "onReset", "onNetworkAvailable", "isAvailable", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface HiveLifecycleListener {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onAgreement(HiveLifecycleListener hiveLifecycleListener) {
            }

            public static void onInitializeFinished(HiveLifecycleListener hiveLifecycleListener) {
            }

            public static void onNetworkAvailable(HiveLifecycleListener hiveLifecycleListener, boolean z) {
            }

            public static void onProcessUri(HiveLifecycleListener hiveLifecycleListener, String uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
            }

            public static void onReset(HiveLifecycleListener hiveLifecycleListener) {
            }

            public static void onSetupFinished(HiveLifecycleListener hiveLifecycleListener) {
            }

            public static void onSignIn(HiveLifecycleListener hiveLifecycleListener, HiveAccount hiveAccount) {
                Intrinsics.checkNotNullParameter(hiveAccount, "hiveAccount");
            }

            public static void onSignOut(HiveLifecycleListener hiveLifecycleListener) {
            }
        }

        void onAgreement();

        void onInitializeFinished();

        void onNetworkAvailable(boolean isAvailable);

        void onProcessUri(String uri);

        void onReset();

        void onSetupFinished();

        void onSignIn(HiveAccount hiveAccount);

        void onSignOut();
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [android.net.ConnectivityManager$NetworkCallback, com.hive.standalone.HiveLifecycle$networkCallback$1] */
    static {
        HiveLifecycle hiveLifecycle = new HiveLifecycle();
        INSTANCE = hiveLifecycle;
        hiveLifecycleList = new ConcurrentLinkedQueue<>();
        networkAvailable = !Intrinsics.areEqual(Platform.readNetworkType$default(Platform.INSTANCE, null, 1, null), "notConnected");
        ?? r1 = new ConnectivityManager.NetworkCallback() { // from class: com.hive.standalone.HiveLifecycle$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                super.onAvailable(network);
                LoggerImpl.INSTANCE.d("[HiveLifecycle] The default network is now: " + network + " (" + Platform.readNetworkType$default(Platform.INSTANCE, null, 1, null) + ')');
                HiveLifecycle hiveLifecycle2 = HiveLifecycle.INSTANCE;
                hiveLifecycle2.setNetworkAvailable(true);
                hiveLifecycle2.onNetworkAvailable(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                super.onLost(network);
                LoggerImpl.INSTANCE.d("[HiveLifecycle] The application no longer has a default network. The last default network was " + network + " (" + Platform.readNetworkType$default(Platform.INSTANCE, null, 1, null) + ')');
                HiveLifecycle hiveLifecycle2 = HiveLifecycle.INSTANCE;
                hiveLifecycle2.setNetworkAvailable(false);
                hiveLifecycle2.onNetworkAvailable(false);
            }
        };
        networkCallback = r1;
        registerNetworkCallback$default(hiveLifecycle, null, r1, 1, null);
        isStandAlone = true;
        HiveAccount hiveAccount = new HiveAccount();
        hiveAccount.setDid(hiveLifecycle.getDid());
        hiveAccount.setVidType("v0");
        account = hiveAccount;
    }

    private HiveLifecycle() {
    }

    public static /* synthetic */ void onInitializeFinished$default(HiveLifecycle hiveLifecycle, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        hiveLifecycle.onInitializeFinished(z);
    }

    @JvmStatic
    public static final void registerHiveLifecycleListeners(HiveLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        hiveLifecycleList.add(listener);
    }

    private final void registerNetworkCallback(Context context, ConnectivityManager.NetworkCallback callback) {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == -1) {
            throw new Exception("ACCESS_NETWORK_STATE Permission denied.");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, ConnectivityManager.class);
        if (connectivityManager == null) {
            throw new Exception("getSystemService(ConnectivityManager) failed.");
        }
        if (Build.VERSION.SDK_INT >= 24) {
            connectivityManager.registerDefaultNetworkCallback(callback);
        } else {
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).addTransportType(4).addTransportType(3).addTransportType(2).addTransportType(1).addTransportType(0).build(), callback);
        }
        objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[HiveLifecycle] registerNetworkCallback failed. " + thM7418exceptionOrNullimpl);
        }
    }

    public static /* synthetic */ void registerNetworkCallback$default(HiveLifecycle hiveLifecycle, Context context, ConnectivityManager.NetworkCallback networkCallback2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = HiveCoreInitializer.INSTANCE.getInitContext();
        }
        if ((i & 2) != 0) {
            networkCallback2 = networkCallback;
        }
        hiveLifecycle.registerNetworkCallback(context, networkCallback2);
    }

    @JvmStatic
    public static final void unregisterActivityLifecycleListeners(HiveLifecycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        hiveLifecycleList.remove(listener);
    }

    public static /* synthetic */ void unregisterNetworkCallback$hive_service_release$default(HiveLifecycle hiveLifecycle, Context context, ConnectivityManager.NetworkCallback networkCallback2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = HiveCoreInitializer.INSTANCE.getInitContext();
        }
        if ((i & 2) != 0) {
            networkCallback2 = networkCallback;
        }
        hiveLifecycle.unregisterNetworkCallback$hive_service_release(context, networkCallback2);
    }

    public final HiveAccount getAccount() {
        return account;
    }

    public final String getDid() {
        String value = Property.INSTANCE.getINSTANCE().getValue(hlcKey_did);
        if (value == null || !(!StringsKt.isBlank(value))) {
            return null;
        }
        return value;
    }

    public final JSONObject getHiveConfigProviders() {
        return hiveConfigProviders;
    }

    public final boolean getNetworkAvailable() {
        return networkAvailable;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.hive.standalone.HiveLifecycle.HiveAccount getRecentHiveAccount() {
        /*
            r3 = this;
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L24
            com.hive.base.Property$Companion r1 = com.hive.base.Property.INSTANCE     // Catch: java.lang.Throwable -> L24
            com.hive.base.Property r1 = r1.getINSTANCE()     // Catch: java.lang.Throwable -> L24
            java.lang.String r2 = "hlc.recent_hive_account"
            java.lang.String r1 = r1.getValue(r2)     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L1e
            com.hive.base.Android r2 = com.hive.base.Android.INSTANCE     // Catch: java.lang.Throwable -> L24
            java.lang.Object r1 = r2.deserialize(r1)     // Catch: java.lang.Throwable -> L24
            boolean r2 = r1 instanceof com.hive.standalone.HiveLifecycle.HiveAccount     // Catch: java.lang.Throwable -> L24
            if (r2 == 0) goto L1e
            com.hive.standalone.HiveLifecycle$HiveAccount r1 = (com.hive.standalone.HiveLifecycle.HiveAccount) r1     // Catch: java.lang.Throwable -> L24
            goto L1f
        L1e:
            r1 = r0
        L1f:
            java.lang.Object r1 = kotlin.Result.m7415constructorimpl(r1)     // Catch: java.lang.Throwable -> L24
            goto L2f
        L24:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m7415constructorimpl(r1)
        L2f:
            boolean r2 = kotlin.Result.m7421isFailureimpl(r1)
            if (r2 == 0) goto L36
            goto L37
        L36:
            r0 = r1
        L37:
            com.hive.standalone.HiveLifecycle$HiveAccount r0 = (com.hive.standalone.HiveLifecycle.HiveAccount) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.standalone.HiveLifecycle.getRecentHiveAccount():com.hive.standalone.HiveLifecycle$HiveAccount");
    }

    public final boolean isC2SGuest() {
        return isC2SGuest;
    }

    public final boolean isInitializeSdkV1() {
        return isInitializeSdkV1;
    }

    public final boolean isInitializeSdkV4() {
        return isInitializeSdkV4;
    }

    public final boolean isSdkSetup() {
        return isInitializeSdkV1 || isInitializeSdkV4 || isSetup;
    }

    public final boolean isSetup() {
        return isSetup;
    }

    public final boolean isSignIn() {
        return !isSignOut();
    }

    public final boolean isSignOut() {
        String vid = account.getVid();
        if (vid != null && !StringsKt.isBlank(vid)) {
            return false;
        }
        String uid = account.getUid();
        return uid == null || StringsKt.isBlank(uid);
    }

    public final boolean isStandAlone() {
        return isStandAlone;
    }

    public final void onAgreement() {
        Iterator<T> it = hiveLifecycleList.iterator();
        while (it.hasNext()) {
            ((HiveLifecycleListener) it.next()).onAgreement();
        }
    }

    public final void onInitializeFinished(boolean isSdkV1) {
        if (isSdkV1) {
            isInitializeSdkV1 = true;
        } else {
            isInitializeSdkV4 = true;
        }
        account.setDid(getDid());
        account.setVidType(isStandAlone ? "v0" : i.f2373a);
        Iterator<T> it = hiveLifecycleList.iterator();
        while (it.hasNext()) {
            ((HiveLifecycleListener) it.next()).onInitializeFinished();
        }
    }

    public final void onNetworkAvailable(boolean isAvailable) {
        Iterator<T> it = hiveLifecycleList.iterator();
        while (it.hasNext()) {
            ((HiveLifecycleListener) it.next()).onNetworkAvailable(isAvailable);
        }
    }

    public final void onProcessUri(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Iterator<T> it = hiveLifecycleList.iterator();
        while (it.hasNext()) {
            ((HiveLifecycleListener) it.next()).onProcessUri(uri);
        }
    }

    public final void onReset() {
        account.reset$hive_service_release();
        Iterator<T> it = hiveLifecycleList.iterator();
        while (it.hasNext()) {
            ((HiveLifecycleListener) it.next()).onReset();
        }
    }

    public final void onSetupFinished() {
        isStandAlone = false;
        isSetup = true;
        account.setDid(getDid());
        account.setVidType("v4");
        Iterator<T> it = hiveLifecycleList.iterator();
        while (it.hasNext()) {
            ((HiveLifecycleListener) it.next()).onSetupFinished();
        }
    }

    public final void onSignIn(HiveAccount hiveAccount) {
        Intrinsics.checkNotNullParameter(hiveAccount, "hiveAccount");
        setAccount(hiveAccount);
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), hlcKey_recentHiveAccount, Android.INSTANCE.serialize(hiveAccount), null, 4, null);
        companion.getINSTANCE().writeProperties();
        Iterator<T> it = hiveLifecycleList.iterator();
        while (it.hasNext()) {
            ((HiveLifecycleListener) it.next()).onSignIn(hiveAccount);
        }
    }

    public final void onSignOut() {
        account.setVid(null);
        account.setUid(null);
        account.setVidSession(null);
        account.setUidSession(null);
        account.setOauthToken(null);
        Property.Companion companion = Property.INSTANCE;
        companion.getINSTANCE().removeValue(hlcKey_recentHiveAccount);
        companion.getINSTANCE().writeProperties();
        Iterator<T> it = hiveLifecycleList.iterator();
        while (it.hasNext()) {
            ((HiveLifecycleListener) it.next()).onSignOut();
        }
    }

    public final void setAccount(HiveAccount value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String vidType = account.getVidType();
        HiveAccount hiveAccount = new HiveAccount();
        hiveAccount.setVid(value.getVid());
        hiveAccount.setUid(value.getUid());
        hiveAccount.setDid(INSTANCE.getDid());
        String vidType2 = value.getVidType();
        if (vidType2 != null) {
            if (StringsKt.isBlank(vidType2)) {
                vidType2 = null;
            }
            if (vidType2 != null) {
                vidType = vidType2;
            }
        }
        hiveAccount.setVidType(vidType);
        hiveAccount.setVidSession(value.getVidSession());
        hiveAccount.setUidSession(value.getUidSession());
        hiveAccount.setOauthToken(value.getOauthToken());
        account = hiveAccount;
    }

    public final void setC2SGuest(boolean z) {
        isC2SGuest = z;
    }

    public final void setDid(String str) {
        if (str == null || !(!StringsKt.isBlank(str))) {
            return;
        }
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), hlcKey_did, str, null, 4, null);
        companion.getINSTANCE().writeProperties();
        account.setDid(str);
        did = str;
    }

    public final void setHiveConfigProviders(JSONObject jSONObject) {
        hiveConfigProviders = jSONObject;
    }

    public final void setNetworkAvailable(boolean z) {
        networkAvailable = z;
    }

    public final void setStandAlone(boolean z) {
        isStandAlone = z;
    }

    public final void unregisterNetworkCallback$hive_service_release(Context context, ConnectivityManager.NetworkCallback callback) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == -1) {
            throw new Exception("ACCESS_NETWORK_STATE Permission denied.");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, ConnectivityManager.class);
        if (connectivityManager == null) {
            throw new Exception("getSystemService(ConnectivityManager) failed.");
        }
        connectivityManager.unregisterNetworkCallback(callback);
        objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[HiveLifecycle] unregisterNetworkCallback failed. " + thM7418exceptionOrNullimpl);
        }
    }
}
