package com.hive.auth;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import com.hive.auth.AuthDataInterface;
import com.hive.auth.AuthNetwork;
import com.hive.auth.MaintenanceDialog;
import com.hive.base.Property;
import com.hive.core.Crypto;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.logincenter.Login;
import com.hive.social.SocialDialog;
import com.hive.social.SocialKeys;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/hive/auth/AuthImpl$internalAccountLogin$1$onCreate$1", "Lcom/hive/SocialHive$ShowHiveDialogDataListener;", "onShowHiveDialogWithData", "", "loginHiveResult", "Lcom/hive/ResultAPI;", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthImpl$internalAccountLogin$1$onCreate$1 implements SocialHive.ShowHiveDialogDataListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $fApiName;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ AuthDataInterface.AuthLoginListener $listener;

    public AuthImpl$internalAccountLogin$1$onCreate$1(String str, AuthDataInterface.AuthLoginListener authLoginListener, Activity activity, Intent intent) {
        this.$fApiName = str;
        this.$listener = authLoginListener;
        this.$activity = activity;
        this.$intent = intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onShowHiveDialogWithData$lambda$1(final String str, final AuthDataInterface.AuthLoginListener authLoginListener, Intent intent, String str2, final Login it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().getResult().isSuccess()) {
            final String did = HiveLifecycle.INSTANCE.getDid();
            Property.Companion companion = Property.INSTANCE;
            final String value = companion.getINSTANCE().getValue(SocialKeys.INSTANCE.getUID(), "uid");
            if (it.getResponse().isSuccess()) {
                if (StringsKt.isBlank(it.getResponse().getAccountSessionkey())) {
                    AuthImpl authImpl = AuthImpl.INSTANCE;
                    AuthImpl.recentSelectAccountUrl = it.getResponse().getUrl();
                    AuthDataInterface.Account account = new AuthDataInterface.Account(companion.getINSTANCE().getValue(AuthKeys.GUEST_VID), null, did, null);
                    AuthDataInterface.Account account2 = new AuthDataInterface.Account(it.getResponse().getAccountVid(), value, did, null);
                    String str3 = "[Login] [internalAccountLogin] Conflicting accounts : (current)guest vid = " + account + ", used vid = " + account2;
                    LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                    loggerImpl.dL(AuthDataInterface.getTAG(), str3);
                    loggerImpl.dR(AuthDataInterface.getTAG(), "[Login] [internalAccountLogin] Conflicting accounts");
                    AuthDataInterface.LoginType loginType = AuthDataInterface.LoginType.SELECT;
                    AuthImpl.loginType = loginType;
                    AuthImpl.isLoginInProgress = false;
                    AuthImpl.INSTANCE.onLoginFinish(new ResultAPI(0, ResultAPI.Code.Success, str3), loginType, account, account2, str, authLoginListener);
                    return Unit.INSTANCE;
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AuthImpl$internalAccountLogin$1$onCreate$1$onShowHiveDialogWithData$1$1(it, str2, value, did, str, authLoginListener, null), 3, null);
            } else if (it.getResponse().getErrno() == 10) {
                Property.setValue$default(companion.getINSTANCE(), AuthKeys.ACCOUNT_SESSION_KEY, "", null, 4, null);
                companion.getINSTANCE().writeProperties();
                String str4 = it.getResponse().getErrno() == 10 ? "login center" : "hive";
                String str5 = "[Login] [internalAccountLogin] invalid " + str4 + " session : " + it.getResponse().getAccountVid();
                LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
                loggerImpl2.wL(AuthDataInterface.getTAG(), str5);
                loggerImpl2.wR(AuthDataInterface.getTAG(), "[Login] [internalAccountLogin] invalid ".concat(str4));
                AuthImpl authImpl2 = AuthImpl.INSTANCE;
                AuthDataInterface.LoginType loginType2 = AuthDataInterface.LoginType.ACCOUNT;
                AuthImpl.loginType = loginType2;
                AuthDataInterface.Account account3 = AuthImpl.currentAccount;
                if (account3 != null) {
                    account3.setVidSession("");
                }
                AuthImpl.isLoginInProgress = false;
                AuthImpl.INSTANCE.onLoginFinish(new ResultAPI(-9, ResultAPI.Code.AuthInvalidAccountSession, str5), loginType2, null, null, str, authLoginListener);
            } else if (it.getResponse().getErrno() == 103) {
                Property.setValue$default(companion.getINSTANCE(), AuthKeys.ACCOUNT_VID, "", null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), AuthKeys.INSTANCE.getACCOUNT_VID_TYPE(), "", null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), AuthKeys.ACCOUNT_SESSION_KEY, "", null, 4, null);
                companion.getINSTANCE().writeProperties();
                HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl$internalAccountLogin$1$onCreate$1$onShowHiveDialogWithData$1$3
                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onCreate(Activity activity, Bundle savedInstanceState) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        super.onCreate(activity, savedInstanceState);
                        SocialDialog.INSTANCE.logoutHive(activity, new AuthImpl$internalAccountLogin$1$onCreate$1$onShowHiveDialogWithData$1$3$onCreate$1(it, activity, str, authLoginListener)).show();
                    }
                });
            } else if (it.getResponse().getErrno() == 2000) {
                final String str6 = "[Login] [internalAccountLogin] black list user : " + it.getResponse().getBlock_message();
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str6);
                int block_action = it.getResponse().getBlock_action();
                final MaintenanceDialog.MaintenanceModel maintenanceModel = new MaintenanceDialog.MaintenanceModel(it.getResponse().getBlock_title(), it.getResponse().getBlock_message(), it.getResponse().getBlock_html_message(), it.getResponse().getBlock_button(), block_action != 1 ? block_action != 2 ? MaintenanceDialog.MaintenanceActionType.DONE : MaintenanceDialog.MaintenanceActionType.DONE : MaintenanceDialog.MaintenanceActionType.EXIT, "", -1, it.getResponse().getBlock_customerButton(), it.getResponse().getBlock_customerLink(), null, null, null, MaintenanceDialog.MaintenanceDialogType.BLACKLIST, 3584, null);
                Intent intent2 = new Intent();
                intent2.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
                HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent2, new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl$internalAccountLogin$1$onCreate$1$onShowHiveDialogWithData$1$4
                    public MaintenanceDialog dialog;

                    public final MaintenanceDialog getDialog() {
                        MaintenanceDialog maintenanceDialog = this.dialog;
                        if (maintenanceDialog != null) {
                            return maintenanceDialog;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("dialog");
                        return null;
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                        super.onConfigurationChanged(activity, newConfig);
                        getDialog().onConfigurationChanged(activity, newConfig);
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onCreate(final Activity activity, Bundle savedInstanceState) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        super.onCreate(activity, savedInstanceState);
                        MaintenanceDialog.MaintenanceModel maintenanceModel2 = maintenanceModel;
                        final Login login = it;
                        final String str7 = value;
                        final String str8 = did;
                        final String str9 = str6;
                        final String str10 = str;
                        final AuthDataInterface.AuthLoginListener authLoginListener2 = authLoginListener;
                        setDialog(new MaintenanceDialog(activity, maintenanceModel2, new MaintenanceDialog.OnDismissListener() { // from class: com.hive.auth.AuthImpl$internalAccountLogin$1$onCreate$1$onShowHiveDialogWithData$1$4$onCreate$1

                            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[MaintenanceDialog.MaintenanceActionType.values().length];
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.TIMEOVER.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.OPEN_URL.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.EXIT.ordinal()] = 3;
                                    } catch (NoSuchFieldError unused3) {
                                    }
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.DONE.ordinal()] = 4;
                                    } catch (NoSuchFieldError unused4) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            @Override // android.content.DialogInterface.OnDismissListener
                            public void onDismiss(DialogInterface dialog) {
                                Intrinsics.checkNotNullParameter(dialog, "dialog");
                                AuthImpl authImpl3 = AuthImpl.INSTANCE;
                                AuthImpl.loginType = AuthDataInterface.LoginType.AUTO;
                                AuthImpl authImpl4 = AuthImpl.INSTANCE;
                                authImpl4.setCurrentAccount(new AuthDataInterface.Account(login.getResponse().getAccountVid(), str7, str8, login.getResponse().getAccountSessionkey()));
                                AuthImpl.isLoginInProgress = false;
                                activity.finish();
                                authImpl4.onLoginFinish(new ResultAPI(-8, ResultAPI.Code.AuthUserInBlacklist, str9), AuthDataInterface.LoginType.ACCOUNT, AuthImpl.currentAccount, null, str10, authLoginListener2);
                            }

                            @Override // com.hive.auth.MaintenanceDialog.OnDismissListener
                            public void onDismissWithButtonAction(DialogInterface dialog, MaintenanceDialog.MaintenanceActionType buttonAction) {
                                Intrinsics.checkNotNullParameter(dialog, "dialog");
                                Intrinsics.checkNotNullParameter(buttonAction, "buttonAction");
                                AuthImpl.isLoginInProgress = false;
                                activity.finish();
                                int i = WhenMappings.$EnumSwitchMapping$0[buttonAction.ordinal()];
                                AuthImpl.INSTANCE.onLoginFail(i != 1 ? i != 2 ? i != 3 ? i != 4 ? new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionDefault_DoExit, str9) : new ResultAPI(0, ResultAPI.Code.AuthUserInBlacklistActionDone, str9) : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionExit_DoExit, str9) : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionOpenURL_DoExit, str9) : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistTimeover_DoExit, str9), AuthDataInterface.LoginType.ACCOUNT, str10, authLoginListener2);
                            }
                        }));
                        getDialog().show();
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onDestroy(Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        if (!getIsCalledFinish()) {
                            getDialog().dismiss();
                        }
                        super.onDestroy(activity);
                    }

                    public final void setDialog(MaintenanceDialog maintenanceDialog) {
                        Intrinsics.checkNotNullParameter(maintenanceDialog, "<set-?>");
                        this.dialog = maintenanceDialog;
                    }
                });
            } else {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[Login] [internalAccountLogin] login developer error");
                AuthImpl.isLoginInProgress = false;
                AuthImpl.INSTANCE.onLoginFinish(new ResultAPI(-8, ResultAPI.Code.AuthServerResponseNotSuccessful, "[Login] [internalAccountLogin] login developer error"), AuthDataInterface.LoginType.ACCOUNT, null, null, str, authLoginListener);
            }
        } else {
            String str7 = "[Login] [internalAccountLogin] network error : " + it.getResponse().getResult();
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str7);
            AuthImpl.isLoginInProgress = false;
            AuthImpl.INSTANCE.onLoginFinish(new ResultAPI(-5, ResultAPI.Code.AuthNetworkErrorLoginCenterLogin, str7), AuthDataInterface.LoginType.ACCOUNT, null, null, str, authLoginListener);
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.SocialHive.ShowHiveDialogDataListener
    public void onShowHiveDialogWithData(ResultAPI loginHiveResult, JSONObject jsonData) {
        boolean zOptBoolean;
        Intrinsics.checkNotNullParameter(loginHiveResult, "loginHiveResult");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("internalAccountLogin onShowHiveDialogWithData loginHiveResult " + loginHiveResult);
        loggerImpl.dL("internalAccountLogin onShowHiveDialogWithData jsonData " + jsonData);
        loggerImpl.dR("internalAccountLogin onShowHiveDialogWithData jsonData");
        if (jsonData != null) {
            try {
                zOptBoolean = jsonData.optBoolean("needGuestLogin");
            } catch (Exception unused) {
                zOptBoolean = false;
            }
        } else {
            zOptBoolean = false;
        }
        if (!loginHiveResult.isSuccess()) {
            String str = "[Login] [internalAccountLogin] Hive Login canceled : " + loginHiveResult;
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str);
            AuthImpl.isLoginInProgress = false;
            AuthImpl.INSTANCE.onLoginFinish(new ResultAPI(-6, ResultAPI.Code.AuthHIVESocialLoginCancelled, str), AuthDataInterface.LoginType.ACCOUNT, null, null, this.$fApiName, this.$listener);
        } else {
            if (zOptBoolean) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[Login] [internalAccountLogin] login error need guest login.");
                AuthImpl.isLoginInProgress = false;
                AuthImpl.INSTANCE.onLoginFinish(new ResultAPI(-5, ResultAPI.Code.AuthNetworkErrorGuestLogin, "[Login] [internalAccountLogin] login error need guest login."), AuthDataInterface.LoginType.ACCOUNT, null, null, this.$fApiName, this.$listener);
                this.$activity.finish();
                return;
            }
            Crypto crypto = Crypto.INSTANCE;
            final String strGenerateCodeVerifier = crypto.generateCodeVerifier();
            Protocol<Login> protocolLogin = AuthNetwork.LoginCenter.INSTANCE.login(crypto.generateCodeChallenge(strGenerateCodeVerifier));
            final String str2 = this.$fApiName;
            final AuthDataInterface.AuthLoginListener authLoginListener = this.$listener;
            final Intent intent = this.$intent;
            protocolLogin.request(new Function1() { // from class: com.hive.auth.AuthImpl$internalAccountLogin$1$onCreate$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthImpl$internalAccountLogin$1$onCreate$1.onShowHiveDialogWithData$lambda$1(str2, authLoginListener, intent, strGenerateCodeVerifier, (Login) obj);
                }
            });
        }
        this.$activity.finish();
    }
}
