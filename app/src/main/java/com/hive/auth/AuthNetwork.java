package com.hive.auth;

import com.adjust.sdk.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.hive.AuthV4;
import com.hive.Configuration;
import com.hive.analytics.AnalyticsReferrerSender;
import com.hive.auth.AuthDataInterface;
import com.hive.auth.AuthNetwork;
import com.hive.base.Android;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.configuration.ModuleChecker;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.OauthToken;
import com.hive.core.Platform;
import com.hive.core.StringUtil;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.activeuser.Agreement;
import com.hive.protocol.activeuser.Download;
import com.hive.protocol.activeuser.GetNotice;
import com.hive.protocol.activeuser.GetWhiteListDomainByActiveUser;
import com.hive.protocol.activeuser.Referrer;
import com.hive.protocol.activeuser.SessionLog;
import com.hive.protocol.activeuser.UpdateDid;
import com.hive.protocol.logincenter.GetUid;
import com.hive.protocol.logincenter.GetVid;
import com.hive.protocol.logincenter.GuestLogin;
import com.hive.protocol.logincenter.Login;
import com.hive.protocol.logincenter.Logout;
import com.hive.protocol.logincenter.PreLogin;
import com.hive.protocol.logincenter.SignOut;
import com.hive.protocol.logincenter.Update;
import com.hive.social.SocialKeys;
import com.hive.standalone.HiveLifecycle;
import com.hive.userengagement.UserEngagementEventKt;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/hive/auth/AuthNetwork;", "", "<init>", "()V", "ActiveUser", "LoginCenter", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthNetwork {
    public static final AuthNetwork INSTANCE = new AuthNetwork();

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J@\u0010\u000b\u001a\u00020\f28\u0010\r\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u000eJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005J>\u0010\u0018\u001a\u00020\f26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\f0\u000eJ)\u0010\u001c\u001a\u00020\f2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\f0\u001d¨\u0006 "}, d2 = {"Lcom/hive/auth/AuthNetwork$ActiveUser;", "", "<init>", "()V", "agreement", "Lcom/hive/protocol/Protocol;", "Lcom/hive/protocol/activeuser/Agreement;", "download", "Lcom/hive/protocol/activeuser/Download;", "getAgreement", "Lcom/hive/protocol/activeuser/GetAgreement;", "getNotice", "", "callback", "Lkotlin/Function2;", "Lcom/hive/protocol/activeuser/GetNotice;", "Lkotlin/ParameterName;", "name", "Lcom/hive/auth/AuthDataInterface$AuthMaintenanceInfo;", "authMaintenanceInfo", "sessionLog", "Lcom/hive/protocol/activeuser/SessionLog;", "updateDid", "Lcom/hive/protocol/activeuser/UpdateDid;", "getWhiteListDomainByActiveUser", "", "error", "Lcom/hive/protocol/activeuser/GetWhiteListDomainByActiveUser;", Constants.REFERRER, "Lkotlin/Function1;", "Lcom/hive/protocol/activeuser/Referrer;", "result", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ActiveUser {
        public static final ActiveUser INSTANCE = new ActiveUser();

        private ActiveUser() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getNotice$lambda$4(Function2 function2, GetNotice it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.getResponse().getResult().isSuccess() && it.getResponse().isSuccess()) {
                int notice_action = it.getResponse().getNotice_action();
                AuthDataInterface.AuthMaintenanceActionType authMaintenanceActionType = notice_action != 1 ? (notice_action == 2 || notice_action != 3) ? AuthDataInterface.AuthMaintenanceActionType.EXIT : AuthDataInterface.AuthMaintenanceActionType.DONE : AuthDataInterface.AuthMaintenanceActionType.OPEN_URL;
                AuthDataInterface.AuthMaintenanceActionType authMaintenanceActionType2 = authMaintenanceActionType;
                ArrayList arrayList = new ArrayList();
                JSONArray button_list = it.getResponse().getButton_list();
                if (button_list != null) {
                    int length = button_list.length();
                    for (int i = 0; i < length; i++) {
                        try {
                            JSONObject jSONObjectOptJSONObject = button_list.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                AuthDataInterface.AuthMaintenanceActionType authMaintenanceActionTypeFindValue = AuthDataInterface.AuthMaintenanceActionType.INSTANCE.findValue(jSONObjectOptJSONObject.optInt(NativeProtocol.WEB_DIALOG_ACTION));
                                if (authMaintenanceActionTypeFindValue == null) {
                                    authMaintenanceActionTypeFindValue = AuthDataInterface.AuthMaintenanceActionType.DONE;
                                }
                                String strOptString = jSONObjectOptJSONObject.optString("url");
                                String strOptString2 = jSONObjectOptJSONObject.optString("button");
                                Intrinsics.checkNotNull(strOptString);
                                Intrinsics.checkNotNull(strOptString2);
                                arrayList.add(new AuthDataInterface.AuthMaintenanceExtraButton(authMaintenanceActionTypeFindValue, strOptString, strOptString2));
                            }
                        } catch (Exception e) {
                            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] getNotice exButtons parse Exception: " + e);
                        }
                    }
                }
                function2.invoke(it, new AuthDataInterface.AuthMaintenanceInfo(it.getResponse().getNotice_type(), it.getResponse().getNotice_title(), it.getResponse().getNotice_message(), it.getResponse().getNotice_button(), authMaintenanceActionType2, it.getResponse().getNotice_url(), it.getResponse().getRemaining_time(), arrayList, it.getResponse().getContentString()));
            } else {
                function2.invoke(it, null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getWhiteListDomainByActiveUser$lambda$6(Function2 function2, GetWhiteListDomainByActiveUser it) {
            Intrinsics.checkNotNullParameter(it, "it");
            function2.invoke(Integer.valueOf(it.getResponse().getErrno()), it);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit referrer$lambda$7(Function1 function1, Referrer it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.getResponse().isSuccess()) {
                LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthNetwork] Send Referrer success");
            } else {
                LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthNetwork] Send Referrer failed");
            }
            function1.invoke(it);
            return Unit.INSTANCE;
        }

        public final Protocol<Agreement> agreement() {
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<Agreement> protocol = new Protocol<>(new Function0<Agreement>() { // from class: com.hive.auth.AuthNetwork$ActiveUser$agreement$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.activeuser.Agreement] */
                @Override // kotlin.jvm.functions.Function0
                public final Agreement invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = Agreement.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
            String did = hiveLifecycle.getDid();
            Property.Companion companion2 = Property.INSTANCE;
            Property instance = companion2.getINSTANCE();
            AuthKeys authKeys = AuthKeys.INSTANCE;
            String value = instance.getValue(authKeys.getAGREEMENT_SCHEME_DATA());
            String value2 = companion2.getINSTANCE().getValue(authKeys.getAGREEMENT_EX_SCHEME_DATA());
            try {
                protocol.setParam(HiveKeys.KEY_api, "agreement");
                protocol.setParam(HiveKeys.KEY_appid, Configuration.getAppId());
                HiveKeys hiveKeys = HiveKeys.KEY_appversion;
                Android android2 = Android.INSTANCE;
                protocol.setParam(hiveKeys, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_platform, Platform.INSTANCE.getPlatform());
                if (did != null && (!StringsKt.isBlank(did))) {
                    protocol.setParam(HiveKeys.KEY_did, did);
                }
                protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
                if (value != null && !StringsKt.isBlank(value)) {
                    protocol.setParam(HiveKeys.KEY_agreement, value);
                }
                if (value2 != null && !StringsKt.isBlank(value2)) {
                    protocol.setParam(HiveKeys.KEY_agreement_ex, value2);
                }
                AuthImpl authImpl = AuthImpl.INSTANCE;
                String currentLoginVid$hive_service_release = authImpl.getCurrentLoginVid$hive_service_release();
                if (currentLoginVid$hive_service_release != null && !StringsKt.isBlank(currentLoginVid$hive_service_release)) {
                    protocol.setParam(HiveKeys.KEY_vid, authImpl.getCurrentLoginVid$hive_service_release());
                }
                OauthToken oauthToken = hiveLifecycle.getAccount().getOauthToken();
                if (oauthToken != null) {
                    protocol.setOauthToken(oauthToken);
                    return protocol;
                }
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] agreement Exception: " + e);
            }
            return protocol;
        }

        public final Protocol<Download> download() {
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<Download> protocol = new Protocol<>(new Function0<Download>() { // from class: com.hive.auth.AuthNetwork$ActiveUser$download$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.activeuser.Download] */
                @Override // kotlin.jvm.functions.Function0
                public final Download invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = Download.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            String referrer = AnalyticsReferrerSender.INSTANCE.getReferrer();
            JSONObject jSONObject = new JSONObject();
            try {
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_hivev4, "4.26.2.0");
                HiveKeys hiveKeys = HiveKeys.KEY_interface_version;
                com.hive.core.Configuration configuration = com.hive.core.Configuration.INSTANCE;
                CommonIdentifierKt.put(jSONObject, hiveKeys, configuration.getInterfaceVersion());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_build_time, configuration.getSdkBuildTime());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_track, configuration.getTrackVersion());
                ModuleChecker.INSTANCE.includeJsonDataHiveModuleVersionInfo(jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                protocol.setParam(HiveKeys.KEY_api, "download");
                HiveKeys hiveKeys2 = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys2, configurationImpl.getAppId());
                HiveKeys hiveKeys3 = HiveKeys.KEY_appversion;
                Android android2 = Android.INSTANCE;
                protocol.setParam(hiveKeys3, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_platform, Platform.INSTANCE.getPlatform());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_mdn, android2.getMobileDeviceNumber());
                protocol.setParam(HiveKeys.KEY_osversion, android2.getOSVersion());
                protocol.setParam(HiveKeys.KEY_device, android2.getDeviceModel());
                protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
                protocol.setParam(HiveKeys.KEY_hacking, android2.isRooting() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                protocol.setParam(HiveKeys.KEY_emulator, android2.isEmulator());
                protocol.setParam(HiveKeys.KEY_referrer, referrer);
                protocol.setParam(HiveKeys.KEY_versions, jSONObject);
                protocol.setParam(HiveKeys.KEY_advertising_id, android2.getAdvertisingId());
                protocol.setParam(HiveKeys.KEY_is_limit_ad_tracking, Boolean.valueOf(android2.isLimitAdTracking()));
                protocol.setParam(HiveKeys.KEY_zone, configurationImpl.getZone().name());
            } catch (Exception e2) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] download Exception: " + e2);
            }
            return protocol;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.hive.protocol.Protocol<com.hive.protocol.activeuser.GetAgreement> getAgreement() {
            /*
                r6 = this;
                com.hive.protocol.Protocol$Companion r0 = com.hive.protocol.Protocol.INSTANCE
                com.hive.protocol.Protocol r0 = new com.hive.protocol.Protocol
                com.hive.auth.AuthNetwork$ActiveUser$getAgreement$$inlined$invoke$1 r1 = new kotlin.jvm.functions.Function0<com.hive.protocol.activeuser.GetAgreement>() { // from class: com.hive.auth.AuthNetwork$ActiveUser$getAgreement$$inlined$invoke$1
                    static {
                        /*
                            com.hive.auth.AuthNetwork$ActiveUser$getAgreement$$inlined$invoke$1 r0 = new com.hive.auth.AuthNetwork$ActiveUser$getAgreement$$inlined$invoke$1
                            r0.<init>()
                            
                            // error: 0x0005: SPUT (r0 I:com.hive.auth.AuthNetwork$ActiveUser$getAgreement$$inlined$invoke$1) com.hive.auth.AuthNetwork$ActiveUser$getAgreement$$inlined$invoke$1.INSTANCE com.hive.auth.AuthNetwork$ActiveUser$getAgreement$$inlined$invoke$1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthNetwork$ActiveUser$getAgreement$$inlined$invoke$1.<clinit>():void");
                    }

                    {
                        /*
                            r0 = this;
                            r0.<init>()
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthNetwork$ActiveUser$getAgreement$$inlined$invoke$1.<init>():void");
                    }

                    /* JADX WARN: Type inference failed for: r0v0, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.activeuser.GetAgreement] */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ com.hive.protocol.activeuser.GetAgreement invoke() {
                        /*
                            r1 = this;
                            com.hive.protocol.ProtocolRequest r0 = r1.invoke()
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthNetwork$ActiveUser$getAgreement$$inlined$invoke$1.invoke():java.lang.Object");
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.activeuser.GetAgreement] */
                    @Override // kotlin.jvm.functions.Function0
                    public final com.hive.protocol.activeuser.GetAgreement invoke() throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
                        /*
                            r3 = this;
                            r0 = 0
                            java.lang.Class[] r1 = new java.lang.Class[r0]
                            java.lang.Class<com.hive.protocol.activeuser.GetAgreement> r2 = com.hive.protocol.activeuser.GetAgreement.class
                            java.lang.reflect.Constructor r1 = r2.getDeclaredConstructor(r1)
                            java.lang.Object[] r0 = new java.lang.Object[r0]
                            java.lang.Object r0 = r1.newInstance(r0)
                            java.lang.String r1 = "newInstance(...)"
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                            com.hive.protocol.ProtocolRequest r0 = (com.hive.protocol.ProtocolRequest) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthNetwork$ActiveUser$getAgreement$$inlined$invoke$1.invoke():com.hive.protocol.ProtocolRequest");
                    }
                }
                r0.<init>(r1)
                com.hive.standalone.HiveLifecycle r1 = com.hive.standalone.HiveLifecycle.INSTANCE
                java.lang.String r1 = r1.getDid()
                com.hive.base.Property$Companion r2 = com.hive.base.Property.INSTANCE
                com.hive.base.Property r2 = r2.getINSTANCE()
                com.hive.auth.AuthKeys r3 = com.hive.auth.AuthKeys.INSTANCE
                java.lang.String r3 = r3.getAGREEMENT_EX_STATE()
                java.lang.String r2 = r2.getValue(r3)
                if (r2 == 0) goto L2e
                int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L2a
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L2a
                goto L2c
            L2a:
                java.lang.Object r2 = org.json.JSONObject.NULL
            L2c:
                if (r2 != 0) goto L30
            L2e:
                java.lang.Object r2 = org.json.JSONObject.NULL
            L30:
                com.hive.core.HiveKeys r3 = com.hive.core.HiveKeys.KEY_api     // Catch: java.lang.Exception -> L8f
                java.lang.String r4 = "get_agreement"
                r0.setParam(r3, r4)     // Catch: java.lang.Exception -> L8f
                com.hive.core.HiveKeys r3 = com.hive.core.HiveKeys.KEY_appid     // Catch: java.lang.Exception -> L8f
                java.lang.String r4 = com.hive.Configuration.getAppId()     // Catch: java.lang.Exception -> L8f
                r0.setParam(r3, r4)     // Catch: java.lang.Exception -> L8f
                com.hive.core.HiveKeys r3 = com.hive.core.HiveKeys.KEY_appversion     // Catch: java.lang.Exception -> L8f
                com.hive.base.Android r4 = com.hive.base.Android.INSTANCE     // Catch: java.lang.Exception -> L8f
                java.lang.String r5 = r4.getAppVersion()     // Catch: java.lang.Exception -> L8f
                r0.setParam(r3, r5)     // Catch: java.lang.Exception -> L8f
                com.hive.core.HiveKeys r3 = com.hive.core.HiveKeys.KEY_app_version_display     // Catch: java.lang.Exception -> L8f
                java.lang.String r5 = r4.getAppVersion()     // Catch: java.lang.Exception -> L8f
                r0.setParam(r3, r5)     // Catch: java.lang.Exception -> L8f
                com.hive.core.HiveKeys r3 = com.hive.core.HiveKeys.KEY_platform     // Catch: java.lang.Exception -> L8f
                com.hive.core.Platform r5 = com.hive.core.Platform.INSTANCE     // Catch: java.lang.Exception -> L8f
                java.lang.String r5 = r5.getPlatform()     // Catch: java.lang.Exception -> L8f
                r0.setParam(r3, r5)     // Catch: java.lang.Exception -> L8f
                if (r1 == 0) goto L6d
                boolean r3 = kotlin.text.StringsKt.isBlank(r1)     // Catch: java.lang.Exception -> L8f
                if (r3 == 0) goto L68
                goto L6d
            L68:
                com.hive.core.HiveKeys r3 = com.hive.core.HiveKeys.KEY_did     // Catch: java.lang.Exception -> L8f
                r0.setParam(r3, r1)     // Catch: java.lang.Exception -> L8f
            L6d:
                com.hive.core.HiveKeys r1 = com.hive.core.HiveKeys.KEY_mdn     // Catch: java.lang.Exception -> L8f
                java.lang.String r3 = r4.getMobileDeviceNumber()     // Catch: java.lang.Exception -> L8f
                r0.setParam(r1, r3)     // Catch: java.lang.Exception -> L8f
                com.hive.core.HiveKeys r1 = com.hive.core.HiveKeys.KEY_country     // Catch: java.lang.Exception -> L8f
                java.lang.String r3 = r4.getCountry()     // Catch: java.lang.Exception -> L8f
                r0.setParam(r1, r3)     // Catch: java.lang.Exception -> L8f
                com.hive.core.HiveKeys r1 = com.hive.core.HiveKeys.KEY_agreement_version     // Catch: java.lang.Exception -> L8f
                r3 = 0
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> L8f
                r0.setParam(r1, r3)     // Catch: java.lang.Exception -> L8f
                com.hive.core.HiveKeys r1 = com.hive.core.HiveKeys.KEY_agreement_sms     // Catch: java.lang.Exception -> L8f
                r0.setParam(r1, r2)     // Catch: java.lang.Exception -> L8f
                goto La7
            L8f:
                r1 = move-exception
                com.hive.logger.LoggerImpl r2 = com.hive.logger.LoggerImpl.INSTANCE
                java.lang.String r3 = com.hive.auth.AuthDataInterface.getTAG()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "[AuthNetwork] getAgreement Exception: "
                r4.<init>(r5)
                r4.append(r1)
                java.lang.String r1 = r4.toString()
                r2.w(r3, r1)
            La7:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthNetwork.ActiveUser.getAgreement():com.hive.protocol.Protocol");
        }

        public final void getNotice(final Function2<? super GetNotice, ? super AuthDataInterface.AuthMaintenanceInfo, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<GetNotice>() { // from class: com.hive.auth.AuthNetwork$ActiveUser$getNotice$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.activeuser.GetNotice] */
                @Override // kotlin.jvm.functions.Function0
                public final GetNotice invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = GetNotice.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
            long j = jCurrentTimeMillis + ((long) offset);
            try {
                protocol.setParam(HiveKeys.KEY_api, "get_notice");
                protocol.setParam(HiveKeys.KEY_appid, Configuration.getAppId());
                HiveKeys hiveKeys = HiveKeys.KEY_appversion;
                Android android2 = Android.INSTANCE;
                protocol.setParam(hiveKeys, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_platform, Platform.INSTANCE.getPlatform());
                if (did != null && (!StringsKt.isBlank(did))) {
                    protocol.setParam(HiveKeys.KEY_did, did);
                }
                protocol.setParam(HiveKeys.KEY_mdn, android2.getMobileDeviceNumber());
                protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
                protocol.setParam(HiveKeys.KEY_timestamp, Long.valueOf(j / ((long) 1000)));
                protocol.setParam(HiveKeys.KEY_timezone_offset, Integer.valueOf(offset / 1000));
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] getNotice Exception: " + e);
            }
            protocol.request(new Function1() { // from class: com.hive.auth.AuthNetwork$ActiveUser$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthNetwork.ActiveUser.getNotice$lambda$4(callback, (GetNotice) obj);
                }
            });
        }

        public final void getWhiteListDomainByActiveUser(final Function2<? super Integer, ? super GetWhiteListDomainByActiveUser, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<GetWhiteListDomainByActiveUser>() { // from class: com.hive.auth.AuthNetwork$ActiveUser$getWhiteListDomainByActiveUser$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.activeuser.GetWhiteListDomainByActiveUser] */
                @Override // kotlin.jvm.functions.Function0
                public final GetWhiteListDomainByActiveUser invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = GetWhiteListDomainByActiveUser.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            long jCurrentTimeMillis = System.currentTimeMillis();
            int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
            long j = jCurrentTimeMillis + ((long) offset);
            Android android2 = Android.INSTANCE;
            int oSVersionCode = android2.getOSVersionCode();
            try {
                protocol.setParam(HiveKeys.KEY_api, "get_whitelist_domain");
                protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
                protocol.setParam(HiveKeys.KEY_app_version, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
                protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
                protocol.setParam(HiveKeys.KEY_os_version, android2.getOSVersion());
                protocol.setParam(HiveKeys.KEY_os_api_level, oSVersionCode == 0 ? JSONObject.NULL : Integer.valueOf(oSVersionCode));
                protocol.setParam(HiveKeys.KEY_timestamp, Long.valueOf(j / ((long) 1000)));
                protocol.setParam(HiveKeys.KEY_timezone_offset, Integer.valueOf(offset / 1000));
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[AuthNetwork] getWhiteListDomainWithActiveUser Exception: " + e);
            }
            protocol.request(new Function1() { // from class: com.hive.auth.AuthNetwork$ActiveUser$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthNetwork.ActiveUser.getWhiteListDomainByActiveUser$lambda$6(callback, (GetWhiteListDomainByActiveUser) obj);
                }
            });
        }

        public final void referrer(final Function1<? super Referrer, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<Referrer>() { // from class: com.hive.auth.AuthNetwork$ActiveUser$referrer$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.activeuser.Referrer] */
                @Override // kotlin.jvm.functions.Function0
                public final Referrer invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = Referrer.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String referrer = AnalyticsReferrerSender.INSTANCE.getReferrer();
            try {
                protocol.setParam(HiveKeys.KEY_api, Constants.REFERRER);
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                Android android2 = Android.INSTANCE;
                String packageName = android2.getPackageName();
                if (packageName == null) {
                    packageName = "";
                }
                protocol.setParam(hiveKeys, packageName);
                protocol.setParam(HiveKeys.KEY_appversion, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_referrer, referrer);
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[AuthNetwork] referrer Exception: " + e);
            }
            protocol.request(new Function1() { // from class: com.hive.auth.AuthNetwork$ActiveUser$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthNetwork.ActiveUser.referrer$lambda$7(callback, (Referrer) obj);
                }
            });
        }

        public final Protocol<SessionLog> sessionLog() {
            String value;
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<SessionLog> protocol = new Protocol<>(new Function0<SessionLog>() { // from class: com.hive.auth.AuthNetwork$ActiveUser$sessionLog$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.activeuser.SessionLog] */
                @Override // kotlin.jvm.functions.Function0
                public final SessionLog invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = SessionLog.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            try {
                value = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getSESSION_DATA());
            } catch (Exception unused) {
            }
            JSONArray jSONArray = value != null ? new JSONArray(value) : null;
            try {
                protocol.setParam(HiveKeys.KEY_api, "session_log");
                protocol.setParam(HiveKeys.KEY_appid, Configuration.getAppId());
                if (!StringUtil.INSTANCE.isEmptyString(did)) {
                    protocol.setParam(HiveKeys.KEY_did, did);
                }
                if (jSONArray != null) {
                    protocol.setParam(HiveKeys.KEY_sessions, jSONArray);
                }
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] sessionLog Exception: " + e);
            }
            return protocol;
        }

        public final Protocol<UpdateDid> updateDid() {
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<UpdateDid> protocol = new Protocol<>(new Function0<UpdateDid>() { // from class: com.hive.auth.AuthNetwork$ActiveUser$updateDid$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.activeuser.UpdateDid] */
                @Override // kotlin.jvm.functions.Function0
                public final UpdateDid invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = UpdateDid.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            try {
                protocol.setParam(HiveKeys.KEY_api, "update_did");
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys, configurationImpl.getAppId());
                HiveKeys hiveKeys2 = HiveKeys.KEY_app_version;
                Android android2 = Android.INSTANCE;
                protocol.setParam(hiveKeys2, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_platform, Platform.INSTANCE.getPlatform());
                protocol.setParam(HiveKeys.KEY_mdn, android2.getMobileDeviceNumber());
                protocol.setParam(HiveKeys.KEY_android_id, android2.getAndroidId());
                protocol.setParam(HiveKeys.KEY_osversion, android2.getOSVersion());
                protocol.setParam(HiveKeys.KEY_device, android2.getDeviceModel());
                protocol.setParam(HiveKeys.KEY_hacking, android2.isRooting() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                protocol.setParam(HiveKeys.KEY_emulator, android2.isEmulator());
                protocol.setParam(HiveKeys.KEY_advertising_id, android2.getAdvertisingId());
                protocol.setParam(HiveKeys.KEY_is_limit_ad_tracking, Boolean.valueOf(android2.isLimitAdTracking()));
                protocol.setParam(HiveKeys.KEY_zone, configurationImpl.getZone().name());
                protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
                protocol.setParam(HiveKeys.KEY_os_api_level, String.valueOf(android2.getOSVersionCode()));
                return protocol;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] updateDid Exception: " + e);
                return protocol;
            }
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\u000f\u001a\u00020\tJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u000f\u001a\u00020\tJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t¨\u0006 "}, d2 = {"Lcom/hive/auth/AuthNetwork$LoginCenter;", "", "<init>", "()V", "getUid", "Lcom/hive/protocol/Protocol;", "Lcom/hive/protocol/logincenter/GetUid;", "vidList", "Ljava/util/ArrayList;", "", "getVid", "Lcom/hive/protocol/logincenter/GetVid;", "uidList", "guestLogin", "Lcom/hive/protocol/logincenter/GuestLogin;", ClientData.KEY_CHALLENGE, "login", "Lcom/hive/protocol/logincenter/Login;", "logout", "Lcom/hive/protocol/logincenter/Logout;", "preLogin", "Lcom/hive/protocol/logincenter/PreLogin;", "update", "Lcom/hive/protocol/logincenter/Update;", "updateVid", "signOut", "Lcom/hive/protocol/logincenter/SignOut;", "exchangeCodeToToken", "Lcom/hive/protocol/logincenter/OauthToken;", "vid", "code", "verifier", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoginCenter {
        public static final LoginCenter INSTANCE = new LoginCenter();

        private LoginCenter() {
        }

        public final Protocol<com.hive.protocol.logincenter.OauthToken> exchangeCodeToToken(String vid, String code, String verifier) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(verifier, "verifier");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<com.hive.protocol.logincenter.OauthToken> protocol = new Protocol<>(new Function0<com.hive.protocol.logincenter.OauthToken>() { // from class: com.hive.auth.AuthNetwork$LoginCenter$exchangeCodeToToken$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.logincenter.OauthToken] */
                @Override // kotlin.jvm.functions.Function0
                public final com.hive.protocol.logincenter.OauthToken invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = com.hive.protocol.logincenter.OauthToken.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            try {
                Result.Companion companion2 = Result.INSTANCE;
                protocol.setAutoRefreshOauthToken(false);
                protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_vid, vid);
                protocol.setParam(HiveKeys.KEY_grant_type, "authorization_code");
                protocol.setParam(HiveKeys.KEY_client_id, com.hive.core.Configuration.INSTANCE.getPrimaryClientId());
                protocol.setParam(HiveKeys.KEY_authorization_code, code);
                Result.m7415constructorimpl(protocol.setParam(HiveKeys.KEY_code_verifier, verifier));
                return protocol;
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.m7415constructorimpl(ResultKt.createFailure(th));
                return protocol;
            }
        }

        public final Protocol<GetUid> getUid(ArrayList<String> vidList) {
            Intrinsics.checkNotNullParameter(vidList, "vidList");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<GetUid> protocol = new Protocol<>(new Function0<GetUid>() { // from class: com.hive.auth.AuthNetwork$LoginCenter$getUid$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.logincenter.GetUid] */
                @Override // kotlin.jvm.functions.Function0
                public final GetUid invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = GetUid.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            Property.Companion companion2 = Property.INSTANCE;
            String value = companion2.getINSTANCE().getValue(AuthKeys.GUEST_VID);
            Property instance = companion2.getINSTANCE();
            AuthKeys authKeys = AuthKeys.INSTANCE;
            String value2 = instance.getValue(authKeys.getGUEST_VID_TYPE());
            String value3 = companion2.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
            String value4 = companion2.getINSTANCE().getValue(AuthKeys.ACCOUNT_VID);
            String value5 = companion2.getINSTANCE().getValue(authKeys.getACCOUNT_VID_TYPE());
            String value6 = companion2.getINSTANCE().getValue(AuthKeys.ACCOUNT_SESSION_KEY);
            if (value4 != null && !StringsKt.isBlank(value4)) {
                value = value4;
            } else if (value == null || StringsKt.isBlank(value)) {
                value = null;
            }
            if (value5 != null && !StringsKt.isBlank(value5)) {
                value2 = value5;
            } else if (value2 == null || StringsKt.isBlank(value2)) {
                value2 = null;
            }
            if (value6 != null && !StringsKt.isBlank(value6)) {
                value3 = value6;
            } else if (value3 == null || StringsKt.isBlank(value3)) {
                value3 = null;
            }
            try {
                protocol.setParam(HiveKeys.KEY_appid, Configuration.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_platform, "hub");
                protocol.setParam(HiveKeys.KEY_vid, value);
                protocol.setParam(HiveKeys.KEY_vid_type, value2);
                protocol.setParam(HiveKeys.KEY_sessionkey, value3);
                protocol.setParam(HiveKeys.KEY_vid_list, new JSONArray((Collection) vidList));
                return protocol;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] getUid Exception: " + e);
                return protocol;
            }
        }

        public final Protocol<GetVid> getVid(ArrayList<String> uidList) {
            Intrinsics.checkNotNullParameter(uidList, "uidList");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<GetVid> protocol = new Protocol<>(new Function0<GetVid>() { // from class: com.hive.auth.AuthNetwork$LoginCenter$getVid$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.logincenter.GetVid] */
                @Override // kotlin.jvm.functions.Function0
                public final GetVid invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = GetVid.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            Property.Companion companion2 = Property.INSTANCE;
            String value = companion2.getINSTANCE().getValue(AuthKeys.GUEST_VID);
            Property instance = companion2.getINSTANCE();
            AuthKeys authKeys = AuthKeys.INSTANCE;
            String value2 = instance.getValue(authKeys.getGUEST_VID_TYPE());
            String value3 = companion2.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
            String value4 = companion2.getINSTANCE().getValue(AuthKeys.ACCOUNT_VID);
            String value5 = companion2.getINSTANCE().getValue(authKeys.getACCOUNT_VID_TYPE());
            String value6 = companion2.getINSTANCE().getValue(AuthKeys.ACCOUNT_SESSION_KEY);
            if (value4 != null && !StringsKt.isBlank(value4)) {
                value = value4;
            } else if (value == null || StringsKt.isBlank(value)) {
                value = null;
            }
            if (value5 != null && !StringsKt.isBlank(value5)) {
                value2 = value5;
            } else if (value2 == null || StringsKt.isBlank(value2)) {
                value2 = null;
            }
            if (value6 != null && !StringsKt.isBlank(value6)) {
                value3 = value6;
            } else if (value3 == null || StringsKt.isBlank(value3)) {
                value3 = null;
            }
            try {
                protocol.setParam(HiveKeys.KEY_appid, Configuration.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_platform, "hub");
                protocol.setParam(HiveKeys.KEY_vid, value);
                protocol.setParam(HiveKeys.KEY_vid_type, value2);
                protocol.setParam(HiveKeys.KEY_sessionkey, value3);
                protocol.setParam(HiveKeys.KEY_uid_list, new JSONArray((Collection) uidList));
                return protocol;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] getVid Exception: " + e);
                return protocol;
            }
        }

        public final Protocol<GuestLogin> guestLogin(String challenge) {
            Intrinsics.checkNotNullParameter(challenge, "challenge");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<GuestLogin> protocol = new Protocol<>(new Function0<GuestLogin>() { // from class: com.hive.auth.AuthNetwork$LoginCenter$guestLogin$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.logincenter.GuestLogin] */
                @Override // kotlin.jvm.functions.Function0
                public final GuestLogin invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = GuestLogin.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            Property.Companion companion2 = Property.INSTANCE;
            String value = companion2.getINSTANCE().getValue(AuthKeys.GUEST_VID);
            String value2 = companion2.getINSTANCE().getValue(AuthKeys.INSTANCE.getGUEST_VID_TYPE());
            String value3 = companion2.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
            try {
                protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_client_id, com.hive.core.Configuration.INSTANCE.getPrimaryClientId());
                protocol.setParam(HiveKeys.KEY_code_challenge, challenge);
                protocol.setParam(HiveKeys.KEY_code_challenge_method, "S256");
                if (value != null && !StringsKt.isBlank(value) && value3 != null && !StringsKt.isBlank(value3)) {
                    protocol.setParam(HiveKeys.KEY_vid, value);
                    protocol.setParam(HiveKeys.KEY_vid_type, value2);
                    protocol.setParam(HiveKeys.KEY_sessionkey, value3);
                }
                protocol.setParam(HiveKeys.KEY_country, Android.INSTANCE.getCountry());
                UserEngagementEventKt.appendQueryParameters(protocol, protocol);
                return protocol;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] guestLogin Exception: " + e);
                return protocol;
            }
        }

        public final Protocol<Login> login(String challenge) {
            Intrinsics.checkNotNullParameter(challenge, "challenge");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<Login> protocol = new Protocol<>(new Function0<Login>() { // from class: com.hive.auth.AuthNetwork$LoginCenter$login$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.logincenter.Login] */
                @Override // kotlin.jvm.functions.Function0
                public final Login invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = Login.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            Property.Companion companion2 = Property.INSTANCE;
            String value = companion2.getINSTANCE().getValue(AuthKeys.GUEST_VID);
            Property instance = companion2.getINSTANCE();
            AuthKeys authKeys = AuthKeys.INSTANCE;
            String value2 = instance.getValue(authKeys.getGUEST_VID_TYPE());
            String value3 = companion2.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
            String value4 = companion2.getINSTANCE().getValue(AuthKeys.ACCOUNT_VID);
            String value5 = companion2.getINSTANCE().getValue(authKeys.getACCOUNT_VID_TYPE());
            String value6 = companion2.getINSTANCE().getValue(AuthKeys.ACCOUNT_SESSION_KEY);
            if (value4 != null && !StringsKt.isBlank(value4)) {
                value = value4;
            } else if (value == null || StringsKt.isBlank(value)) {
                value = null;
            }
            if (value5 != null && !StringsKt.isBlank(value5)) {
                value2 = value5;
            } else if (value2 == null || StringsKt.isBlank(value2)) {
                value2 = null;
            }
            if (value6 != null && !StringsKt.isBlank(value6)) {
                value3 = value6;
            } else if (value3 == null || StringsKt.isBlank(value3)) {
                value3 = null;
            }
            try {
                protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_platform, "hub");
                HiveKeys hiveKeys = HiveKeys.KEY_uid;
                Property instance2 = companion2.getINSTANCE();
                SocialKeys socialKeys = SocialKeys.INSTANCE;
                protocol.setParam(hiveKeys, instance2.getValue(socialKeys.getUID()));
                protocol.setParam(HiveKeys.KEY_token, companion2.getINSTANCE().getValue(socialKeys.getUID_SESSION_TOKEN()));
                protocol.setParam(HiveKeys.KEY_client_id, com.hive.core.Configuration.INSTANCE.getPrimaryClientId());
                protocol.setParam(HiveKeys.KEY_code_challenge, challenge);
                protocol.setParam(HiveKeys.KEY_code_challenge_method, "S256");
                if (value != null && !StringsKt.isBlank(value) && value3 != null && !StringsKt.isBlank(value3)) {
                    protocol.setParam(HiveKeys.KEY_vid, value);
                    protocol.setParam(HiveKeys.KEY_vid_type, value2);
                    protocol.setParam(HiveKeys.KEY_sessionkey, value3);
                }
                UserEngagementEventKt.appendQueryParameters(protocol, protocol);
                return protocol;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] login Exception: " + e);
                return protocol;
            }
        }

        public final Protocol<Logout> logout() {
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<Logout> protocol = new Protocol<>(new Function0<Logout>() { // from class: com.hive.auth.AuthNetwork$LoginCenter$logout$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.logincenter.Logout] */
                @Override // kotlin.jvm.functions.Function0
                public final Logout invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = Logout.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            Property.Companion companion2 = Property.INSTANCE;
            String value = companion2.getINSTANCE().getValue(AuthKeys.GUEST_VID);
            Property instance = companion2.getINSTANCE();
            AuthKeys authKeys = AuthKeys.INSTANCE;
            String value2 = instance.getValue(authKeys.getGUEST_VID_TYPE());
            String value3 = companion2.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
            String value4 = companion2.getINSTANCE().getValue(AuthKeys.ACCOUNT_VID);
            String value5 = companion2.getINSTANCE().getValue(authKeys.getACCOUNT_VID_TYPE());
            String value6 = companion2.getINSTANCE().getValue(AuthKeys.ACCOUNT_SESSION_KEY);
            if (value4 != null && !StringsKt.isBlank(value4)) {
                value = value4;
            } else if (value == null || StringsKt.isBlank(value)) {
                value = null;
            }
            if (value5 != null && !StringsKt.isBlank(value5)) {
                value2 = value5;
            } else if (value2 == null || StringsKt.isBlank(value2)) {
                value2 = null;
            }
            if (value6 != null && !StringsKt.isBlank(value6)) {
                value3 = value6;
            } else if (value3 == null || StringsKt.isBlank(value3)) {
                value3 = null;
            }
            try {
                protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_vid, value);
                protocol.setParam(HiveKeys.KEY_vid_type, value2);
                protocol.setParam(HiveKeys.KEY_sessionkey, value3);
                return protocol;
            } catch (Exception e) {
                e.printStackTrace();
                return protocol;
            }
        }

        public final Protocol<PreLogin> preLogin() {
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<PreLogin> protocol = new Protocol<>(new Function0<PreLogin>() { // from class: com.hive.auth.AuthNetwork$LoginCenter$preLogin$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.logincenter.PreLogin] */
                @Override // kotlin.jvm.functions.Function0
                public final PreLogin invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = PreLogin.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            try {
                protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
                if (did != null && (!StringsKt.isBlank(did))) {
                    protocol.setParam(HiveKeys.KEY_did, did);
                }
                return protocol;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] preLogin Exception: " + e);
                return protocol;
            }
        }

        public final Protocol<SignOut> signOut() {
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<SignOut> protocol = new Protocol<>(new Function0<SignOut>() { // from class: com.hive.auth.AuthNetwork$LoginCenter$signOut$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.logincenter.SignOut] */
                @Override // kotlin.jvm.functions.Function0
                public final SignOut invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = SignOut.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            Property.Companion companion2 = Property.INSTANCE;
            String value = companion2.getINSTANCE().getValue(AuthKeys.GUEST_VID);
            Property instance = companion2.getINSTANCE();
            AuthKeys authKeys = AuthKeys.INSTANCE;
            String value2 = instance.getValue(authKeys.getGUEST_VID_TYPE());
            String value3 = companion2.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
            String value4 = companion2.getINSTANCE().getValue(AuthKeys.ACCOUNT_VID);
            String value5 = companion2.getINSTANCE().getValue(authKeys.getACCOUNT_VID_TYPE());
            String value6 = companion2.getINSTANCE().getValue(AuthKeys.ACCOUNT_SESSION_KEY);
            if (value4 != null && !StringsKt.isBlank(value4)) {
                value = value4;
            } else if (value == null || StringsKt.isBlank(value)) {
                value = null;
            }
            if (value5 != null && !StringsKt.isBlank(value5)) {
                value2 = value5;
            } else if (value2 == null || StringsKt.isBlank(value2)) {
                value2 = null;
            }
            if (value6 != null && !StringsKt.isBlank(value6)) {
                value3 = value6;
            } else if (value3 == null || StringsKt.isBlank(value3)) {
                value3 = null;
            }
            try {
                protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_vid, value);
                protocol.setParam(HiveKeys.KEY_vid_type, value2);
                protocol.setParam(HiveKeys.KEY_sessionkey, value3);
                return protocol;
            } catch (Exception e) {
                e.printStackTrace();
                return protocol;
            }
        }

        public final Protocol<Update> update(String updateVid, String challenge) {
            Intrinsics.checkNotNullParameter(updateVid, "updateVid");
            Intrinsics.checkNotNullParameter(challenge, "challenge");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<Update> protocol = new Protocol<>(new Function0<Update>() { // from class: com.hive.auth.AuthNetwork$LoginCenter$update$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.logincenter.Update] */
                @Override // kotlin.jvm.functions.Function0
                public final Update invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = Update.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            Property.Companion companion2 = Property.INSTANCE;
            String value = companion2.getINSTANCE().getValue(AuthKeys.GUEST_VID);
            String value2 = companion2.getINSTANCE().getValue(AuthKeys.INSTANCE.getGUEST_VID_TYPE());
            String value3 = companion2.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
            try {
                protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_vid, value);
                protocol.setParam(HiveKeys.KEY_vid_type, value2);
                protocol.setParam(HiveKeys.KEY_sessionkey, value3);
                protocol.setParam(HiveKeys.KEY_platform, "hub");
                HiveKeys hiveKeys = HiveKeys.KEY_uid;
                Property instance = companion2.getINSTANCE();
                SocialKeys socialKeys = SocialKeys.INSTANCE;
                protocol.setParam(hiveKeys, instance.getValue(socialKeys.getUID()));
                protocol.setParam(HiveKeys.KEY_token, companion2.getINSTANCE().getValue(socialKeys.getUID_SESSION_TOKEN()));
                protocol.setParam(HiveKeys.KEY_update_vid, updateVid);
                protocol.setParam(HiveKeys.KEY_client_id, com.hive.core.Configuration.INSTANCE.getPrimaryClientId());
                protocol.setParam(HiveKeys.KEY_code_challenge, challenge);
                protocol.setParam(HiveKeys.KEY_code_challenge_method, "S256");
                return protocol;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthNetwork] update Exception: " + e);
                return protocol;
            }
        }
    }

    private AuthNetwork() {
    }
}
