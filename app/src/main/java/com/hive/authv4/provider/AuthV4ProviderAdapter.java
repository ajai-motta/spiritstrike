package com.hive.authv4.provider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.AuthV4Impl;
import com.hive.authv4.AuthV4Module;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.configuration.ConfigurationImpl;
import com.hive.logger.LoggerImpl;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.core.fid.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 W2\u00020\u0001:\u0006RSTUVWB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0004J\b\u00102\u001a\u00020\u0007H\u0014J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001bH\u0002J\u0010\u00105\u001a\u0002002\u0006\u00106\u001a\u000207H&J\u0010\u00108\u001a\u0002002\u0006\u00106\u001a\u000209H&J\u0018\u00108\u001a\u0002002\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u0012H&J\b\u0010<\u001a\u000200H\u0016J\b\u0010=\u001a\u00020\u0012H\u0002J\u0012\u0010<\u001a\u0002002\b\u00106\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u0002002\u0006\u00106\u001a\u00020@H&J\b\u0010A\u001a\u00020\u0012H&J\u0012\u0010B\u001a\u0002002\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010E\u001a\u0002002\b\u0010F\u001a\u0004\u0018\u00010DH\u0016J\b\u0010G\u001a\u000200H\u0016J\b\u0010H\u001a\u000200H\u0016J\b\u0010I\u001a\u000200H\u0016J\b\u0010J\u001a\u000200H\u0016J\"\u0010K\u001a\u0002002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020M2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0012\u0010Q\u001a\u0002002\b\u0010O\u001a\u0004\u0018\u00010PH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R$\u0010\u0014\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0012@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0013\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0014\u0010 \u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR(\u0010\"\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\u001b@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010%R(\u0010&\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\u001b@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010%R(\u0010)\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\u001b@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010%R(\u0010,\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\u001b@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010%¨\u0006X"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "", "providerType", "Lcom/hive/AuthV4$ProviderType;", "<init>", "(Lcom/hive/AuthV4$ProviderType;)V", "providerJsonObject", "Lorg/json/JSONObject;", "getProviderJsonObject", "()Lorg/json/JSONObject;", "providerJsonObject$delegate", "Lkotlin/Lazy;", "value", "Lcom/hive/AuthV4$ProviderInfo;", "myProviderInfo", "getMyProviderInfo", "()Lcom/hive/AuthV4$ProviderInfo;", "isSetCheckProviderListener", "", "()Z", "isLogIn", "setLogIn", "(Z)V", "idpType", "getIdpType", "()Lcom/hive/AuthV4$ProviderType;", "idpAppId", "", "getIdpAppId", "()Ljava/lang/String;", "idpGetEmailState", "getIdpGetEmailState", "userId", "getUserId", "userToken", "getUserToken", "setUserToken", "(Ljava/lang/String;)V", "userCode", "getUserCode", "setUserCode", "userName", "getUserName", "setUserName", "userProfileImage", "getUserProfileImage", "setUserProfileImage", "notifyChangedProviderInfo", "", "providerInfo", "getProviderFromHiveConfig", "providerKeyChecker", "idpTypeValue", "login", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "getProfile", "getProviderEmailState", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderGetProfileListener;", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onStart", "onResume", "onStop", "onDestroy", "onResult", "requestCode", "", "responseCode", "intent", "Landroid/content/Intent;", "onNewIntent", "ProviderLoginListener", "ProviderLogoutListener", "ProviderGetProfileListener", "ProviderFriendsListener", "ProviderPlayerIdListener", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AuthV4ProviderAdapter {
    private boolean isLogIn;
    private AuthV4.ProviderInfo myProviderInfo;

    /* JADX INFO: renamed from: providerJsonObject$delegate, reason: from kotlin metadata */
    private final Lazy providerJsonObject;
    private String userCode;
    private String userName;
    private String userProfileImage;
    private String userToken;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<AuthV4.ProviderType, AuthV4ProviderAdapter> providerMap = new HashMap<>();
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u0010J\u0010\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u001c\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0010J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0016\u0010\"\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010#\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00102\u0006\u0010#\u001a\u00020&J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010$J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010&J$\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010$2\b\u0010,\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u00061"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderAdapter$Companion;", "", "<init>", "()V", "providerMap", "Ljava/util/HashMap;", "Lcom/hive/AuthV4$ProviderType;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "Lkotlin/collections/HashMap;", "mainThreadHandler", "Landroid/os/Handler;", "getMainThreadHandler", "()Landroid/os/Handler;", Constants.GET_INSTANCE, "providerType", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "onActivityNewIntent", "intent", "Landroid/content/Intent;", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStopped", "onActivityDestroyed", "onActivityResult", "requestCode", "", "responseCode", "login", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "allLogout", "toMainThread", "result", "Lcom/hive/ResultAPI;", "loginListener", "logoutListener", "findClassForName", "", "name", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AuthV4.ProviderType.values().length];
                try {
                    iArr[AuthV4.ProviderType.HIVE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AuthV4.ProviderType.FACEBOOK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AuthV4.ProviderType.GOOGLE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AuthV4.ProviderType.QQ.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AuthV4.ProviderType.VK.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AuthV4.ProviderType.WECHAT.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AuthV4.ProviderType.APPLE.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[AuthV4.ProviderType.SIGNIN_APPLE.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[AuthV4.ProviderType.LINE.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[AuthV4.ProviderType.WEVERSE.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[AuthV4.ProviderType.GOOGLE_PLAY_GAMES.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[AuthV4.ProviderType.HUAWEI.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[AuthV4.ProviderType.FUNTAP.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[AuthV4.ProviderType.STEAM.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[AuthV4.ProviderType.X.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr[AuthV4.ProviderType.TELEGRAM.ordinal()] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr[AuthV4.ProviderType.XIAOMI.ordinal()] = 17;
                } catch (NoSuchFieldError unused17) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean findClassForName(String name) {
            try {
                Class.forName(name);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void toMainThread$lambda$3(ProviderLoginListener providerLoginListener, ResultAPI resultAPI, ProviderLogoutListener providerLogoutListener) {
            if (providerLoginListener != null) {
                providerLoginListener.onProviderLoginListener(resultAPI);
            } else if (providerLogoutListener != null) {
                providerLogoutListener.onProviderLogoutListener(resultAPI);
            }
        }

        public final void allLogout(ProviderLogoutListener listener) {
            Object objM7415constructorimpl;
            Unit unit;
            Intrinsics.checkNotNullParameter(listener, "listener");
            LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "AuthV4ProviderAdapter.allLogout()");
            for (AuthV4.ProviderType providerType : AuthV4.ProviderType.values()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    AuthV4ProviderAdapter companion2 = AuthV4ProviderAdapter.INSTANCE.getInstance(providerType);
                    if (companion2 != null) {
                        companion2.logout(new ProviderLogoutListener() { // from class: com.hive.authv4.provider.AuthV4ProviderAdapter$Companion$allLogout$1$1$1
                            @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLogoutListener
                            public void onProviderLogoutListener(ResultAPI result) {
                                Intrinsics.checkNotNullParameter(result, "result");
                            }
                        });
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    objM7415constructorimpl = Result.m7415constructorimpl(unit);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "ProviderImpl all logout exception: " + thM7418exceptionOrNullimpl.getMessage());
                }
            }
            toMainThread(new ResultAPI(), listener);
        }

        public final AuthV4ProviderAdapter getInstance(AuthV4.ProviderType providerType) {
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            switch (WhenMappings.$EnumSwitchMapping$0[providerType.ordinal()]) {
                case 1:
                    return AuthV4ProviderHive.INSTANCE;
                case 2:
                    return (AuthV4ProviderAdapter) AuthV4ProviderAdapter.providerMap.get(AuthV4.ProviderType.FACEBOOK);
                case 3:
                    return AuthV4ProviderGoogle.INSTANCE;
                case 4:
                    AuthV4Module provider$hive_service_release = AuthV4Module.INSTANCE.getProvider$hive_service_release(AuthV4.ProviderType.QQ);
                    if (provider$hive_service_release != null) {
                        return provider$hive_service_release.getProviderModuleInstance();
                    }
                    return null;
                case 5:
                    return AuthV4ProviderVk.INSTANCE;
                case 6:
                    AuthV4Module provider$hive_service_release2 = AuthV4Module.INSTANCE.getProvider$hive_service_release(AuthV4.ProviderType.WECHAT);
                    if (provider$hive_service_release2 != null) {
                        return provider$hive_service_release2.getProviderModuleInstance();
                    }
                    return null;
                case 7:
                    return AuthV4ProviderAppleGameCenter.INSTANCE;
                case 8:
                    return AuthV4ProviderAppleSignIn.INSTANCE;
                case 9:
                    AuthV4Module provider$hive_service_release3 = AuthV4Module.INSTANCE.getProvider$hive_service_release(AuthV4.ProviderType.LINE);
                    if (provider$hive_service_release3 != null) {
                        return provider$hive_service_release3.getProviderModuleInstance();
                    }
                    return null;
                case 10:
                    return AuthV4ProviderWeverse.INSTANCE;
                case 11:
                    return AuthV4ProviderGooglePlayGames.INSTANCE;
                case 12:
                    AuthV4Module provider$hive_service_release4 = AuthV4Module.INSTANCE.getProvider$hive_service_release(AuthV4.ProviderType.HUAWEI);
                    if (provider$hive_service_release4 != null) {
                        return provider$hive_service_release4.getProviderModuleInstance();
                    }
                    return null;
                case 13:
                    return AuthV4ProviderFuntap.INSTANCE;
                case 14:
                    return AuthV4ProviderSteam.INSTANCE;
                case 15:
                    return AuthV4ProviderX.INSTANCE;
                case 16:
                    return AuthV4ProviderTelegram.INSTANCE;
                case 17:
                    return AuthV4ProviderXiaomi.INSTANCE;
                default:
                    return null;
            }
        }

        public final Handler getMainThreadHandler() {
            return AuthV4ProviderAdapter.mainThreadHandler;
        }

        public final void login(AuthV4.ProviderType providerType, final ProviderLoginListener listener) {
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            Intrinsics.checkNotNullParameter(listener, "listener");
            AuthV4ProviderAdapter companion = (AuthV4ProviderAdapter) AuthV4ProviderAdapter.providerMap.get(providerType);
            if (companion == null) {
                companion = getInstance(providerType);
            }
            if (companion != null) {
                companion.login(new ProviderLoginListener() { // from class: com.hive.authv4.provider.AuthV4ProviderAdapter$Companion$login$1
                    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLoginListener
                    public void onProviderLoginListener(ResultAPI result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        AuthV4ProviderAdapter.INSTANCE.toMainThread(result, listener);
                    }
                });
                return;
            }
            String str = "[login] this provider type is invalid. : " + providerType;
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), str);
            toMainThread(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, str), listener);
        }

        public final void logout(AuthV4.ProviderType providerType, final ProviderLogoutListener listener) {
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            Intrinsics.checkNotNullParameter(listener, "listener");
            AuthV4ProviderAdapter companion = (AuthV4ProviderAdapter) AuthV4ProviderAdapter.providerMap.get(providerType);
            if (companion == null) {
                companion = getInstance(providerType);
            }
            if (companion != null) {
                companion.logout(new ProviderLogoutListener() { // from class: com.hive.authv4.provider.AuthV4ProviderAdapter$Companion$logout$1
                    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLogoutListener
                    public void onProviderLogoutListener(ResultAPI result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        AuthV4ProviderAdapter.INSTANCE.toMainThread(result, listener);
                    }
                });
                return;
            }
            String str = "[logout] this provider type is invalid. : " + providerType;
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), str);
            toMainThread(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, str), listener);
        }

        public final void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            for (Object obj : AuthV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AuthV4ProviderAdapter) obj).onCreate(savedInstanceState);
            }
        }

        public final void onActivityDestroyed() {
            for (Object obj : AuthV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AuthV4ProviderAdapter) obj).onDestroy();
            }
        }

        public final void onActivityNewIntent(Intent intent) {
            for (Object obj : AuthV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AuthV4ProviderAdapter) obj).onNewIntent(intent);
            }
        }

        public final void onActivityResult(int requestCode, int responseCode, Intent intent) {
            for (Object obj : AuthV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AuthV4ProviderAdapter) obj).onResult(requestCode, responseCode, intent);
            }
        }

        public final void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            for (Object obj : AuthV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AuthV4ProviderAdapter) obj).onResume();
            }
        }

        public final void onActivitySaveInstanceState(Bundle outState) {
            for (Object obj : AuthV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AuthV4ProviderAdapter) obj).onSaveInstanceState(outState);
            }
        }

        public final void onActivityStarted() {
            for (Object obj : AuthV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AuthV4ProviderAdapter) obj).onStart();
            }
        }

        public final void onActivityStopped() {
            for (Object obj : AuthV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AuthV4ProviderAdapter) obj).onStop();
            }
        }

        public final void toMainThread(ResultAPI result, ProviderLoginListener loginListener) {
            Intrinsics.checkNotNullParameter(result, "result");
            toMainThread(result, loginListener, null);
        }

        private Companion() {
        }

        public final void toMainThread(ResultAPI result, ProviderLogoutListener logoutListener) {
            Intrinsics.checkNotNullParameter(result, "result");
            toMainThread(result, null, logoutListener);
        }

        private final void toMainThread(final ResultAPI result, final ProviderLoginListener loginListener, final ProviderLogoutListener logoutListener) {
            getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderAdapter$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4ProviderAdapter.Companion.toMainThread$lambda$3(loginListener, result, logoutListener);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "", "onProviderFriendsListener", "", "result", "Lcom/hive/ResultAPI;", "providerUserIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ProviderFriendsListener {
        void onProviderFriendsListener(ResultAPI result, ArrayList<String> providerUserIdList);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderGetProfileListener;", "", "onProviderGetProfileListener", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ProviderGetProfileListener {
        void onProviderGetProfileListener(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "", "onProviderLoginListener", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ProviderLoginListener {
        void onProviderLoginListener(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "", "onProviderLogoutListener", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ProviderLogoutListener {
        void onProviderLogoutListener(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderPlayerIdListener;", "", "onResult", "", "resultAPI", "Lcom/hive/ResultAPI;", "playerId", "", "authCode", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ProviderPlayerIdListener {
        void onResult(ResultAPI resultAPI, String playerId, String authCode);
    }

    public AuthV4ProviderAdapter(AuthV4.ProviderType providerType) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        this.providerJsonObject = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.getProviderFromHiveConfig();
            }
        });
        AuthV4.ProviderInfo providerInfo = new AuthV4.ProviderInfo(providerType);
        this.myProviderInfo = providerInfo;
        providerMap.put(providerInfo.getProviderType(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProfile$lambda$6(ProviderGetProfileListener providerGetProfileListener, ResultAPI resultAPI) {
        if (providerGetProfileListener != null) {
            providerGetProfileListener.onProviderGetProfileListener(resultAPI);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean getProviderEmailState() {
        /*
            r7 = this;
            com.hive.core.Configuration r0 = com.hive.core.Configuration.INSTANCE
            org.json.JSONObject r0 = r0.getMetaData()
            r1 = 0
            if (r0 == 0) goto L90
            java.lang.String r2 = "idp_email_collection"
            org.json.JSONArray r0 = r0.optJSONArray(r2)
            if (r0 == 0) goto L90
            int r2 = r0.length()
            r3 = r1
        L16:
            if (r3 >= r2) goto L90
            org.json.JSONObject r4 = r0.optJSONObject(r3)
            if (r4 == 0) goto L8d
            java.lang.String r5 = "idp"
            java.lang.String r5 = r4.optString(r5)
            com.hive.AuthV4$ProviderType r6 = r7.getIdpType()
            java.lang.String r6 = r6.getValue()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L8d
            java.lang.String r0 = "state"
            java.lang.String r0 = r4.optString(r0)
            if (r0 == 0) goto L6d
            int r2 = r0.hashCode()
            switch(r2) {
                case 48: goto L68;
                case 49: goto L5d;
                case 2583950: goto L54;
                case 3569038: goto L4b;
                case 66658563: goto L45;
                case 97196323: goto L42;
                default: goto L41;
            }
        L41:
            goto L6d
        L42:
            java.lang.String r2 = "false"
            goto L47
        L45:
            java.lang.String r2 = "FALSE"
        L47:
            r0.equals(r2)
            goto L6d
        L4b:
            java.lang.String r2 = "true"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L66
            goto L6d
        L54:
            java.lang.String r2 = "TRUE"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L66
            goto L6d
        L5d:
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L66
            goto L6d
        L66:
            r1 = 1
            goto L6d
        L68:
            java.lang.String r2 = "0"
            r0.equals(r2)
        L6d:
            com.hive.logger.LoggerImpl r0 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "[Provider "
            r2.<init>(r3)
            com.hive.AuthV4$ProviderType r3 = r7.getIdpType()
            r2.append(r3)
            java.lang.String r3 = "] getProviderEmailState: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r0.d(r2)
            return r1
        L8d:
            int r3 = r3 + 1
            goto L16
        L90:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.provider.AuthV4ProviderAdapter.getProviderEmailState():boolean");
    }

    private final String providerKeyChecker(String idpTypeValue) {
        return Intrinsics.areEqual(idpTypeValue, AuthV4.ProviderType.SIGNIN_APPLE.getValue()) ? "signinwithapple" : idpTypeValue;
    }

    public abstract void getFriends(ProviderFriendsListener listener);

    public final String getIdpAppId() {
        return this.myProviderInfo.getProviderAppId();
    }

    public final boolean getIdpGetEmailState() {
        return getProviderEmailState();
    }

    public final AuthV4.ProviderType getIdpType() {
        return this.myProviderInfo.getProviderType();
    }

    public final AuthV4.ProviderInfo getMyProviderInfo() {
        return this.myProviderInfo;
    }

    public void getProfile() {
        getProfile(null);
    }

    public JSONObject getProviderFromHiveConfig() {
        return ConfigurationImpl.INSTANCE.getProviderFromHiveConfig(providerKeyChecker(getIdpType().getValue()));
    }

    public final JSONObject getProviderJsonObject() {
        return (JSONObject) this.providerJsonObject.getValue();
    }

    public String getUserCode() {
        return this.userCode;
    }

    public String getUserId() {
        return this.myProviderInfo.getProviderUserId();
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserProfileImage() {
        return this.userProfileImage;
    }

    public String getUserToken() {
        return this.userToken;
    }

    /* JADX INFO: renamed from: isLogIn, reason: from getter */
    public boolean getIsLogIn() {
        return this.isLogIn;
    }

    public abstract boolean isProvisionalKey();

    public final boolean isSetCheckProviderListener() {
        return AuthV4Impl.INSTANCE.getCheckProviderListener() != null;
    }

    public abstract void login(ProviderLoginListener listener);

    public abstract void logout(ProviderLogoutListener listener);

    public abstract void logout(ProviderLogoutListener logoutListener, boolean bRemoveProviderAlso);

    public final void notifyChangedProviderInfo(AuthV4.ProviderInfo providerInfo) {
        Intrinsics.checkNotNullParameter(providerInfo, "providerInfo");
        AuthV4.AuthV4CheckProviderListener checkProviderListener = AuthV4Impl.INSTANCE.getCheckProviderListener();
        if (checkProviderListener != null) {
            checkProviderListener.onDeviceProviderInfo(new ResultAPI(), providerInfo);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onDestroy() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onResult(int requestCode, int responseCode, Intent intent) {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle outState) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void setLogIn(boolean z) {
        this.isLogIn = z;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUserProfileImage(String str) {
        this.userProfileImage = str;
    }

    public void setUserToken(String str) {
        this.userToken = str;
    }

    public void getProfile(final ProviderGetProfileListener listener) {
        final ResultAPI resultAPI;
        String userProfileImage = getUserProfileImage();
        if (userProfileImage == null || !StringsKt.startsWith$default(userProfileImage, ProxyConfig.MATCH_HTTP, false, 2, (Object) null)) {
            String str = "[Provider " + getIdpType() + "] - getProfile : userProfileImage is null or blank.";
            LoggerImpl.INSTANCE.w(str);
            resultAPI = new ResultAPI(-9, ResultAPI.Code.AuthV4ProfileResponseFail, str);
        } else {
            resultAPI = new ResultAPI();
        }
        mainThreadHandler.post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderAdapter.getProfile$lambda$6(listener, resultAPI);
            }
        });
    }
}
