package com.hive.authv4.appupdate;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.auth.AuthDataInterface;
import com.hive.base.Android;
import com.hive.core.Property;
import com.hive.core.PropertyManager;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.GoogleInAppUpdate;
import com.hive.standalone.HiveLifecycle;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\u000eJ$\u0010\u000f\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0012J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/hive/authv4/appupdate/AppUpdate;", "", "<init>", "()V", "googleAppUpdate", "Lcom/hive/module/interfaces/authv4/GoogleInAppUpdate;", "prop", "Lcom/hive/core/Property;", "keyAppVersion", "", "keyCompleteState", "completeUpdate", "", AppUpdate.keyCompleteState, "", "launchAppUpdateFlow", "appUpdateType", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "maintenanceInfo", "Lcom/hive/AuthV4$AuthV4MaintenanceInfo;", "Lcom/hive/auth/AuthDataInterface$AuthMaintenanceInfo;", "CompleteState", "AppUpdateType", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppUpdate {
    public static final AppUpdate INSTANCE = new AppUpdate();
    private static final GoogleInAppUpdate googleAppUpdate;
    private static final String keyAppVersion = "appVersion";
    private static final String keyCompleteState = "completeState";
    private static final Property prop;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/hive/authv4/appupdate/AppUpdate$AppUpdateType;", "", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AppUpdateType {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int Flexible = 0;
        public static final int Immediate = 1;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/hive/authv4/appupdate/AppUpdate$AppUpdateType$Companion;", "", "<init>", "()V", "Flexible", "", "Immediate", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int Flexible = 0;
            public static final int Immediate = 1;

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/hive/authv4/appupdate/AppUpdate$CompleteState;", "", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CompleteState {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int ImmediateUpdate = 1;
        public static final int LaterUpdate = 3;
        public static final int RestartUpdate = 2;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/hive/authv4/appupdate/AppUpdate$CompleteState$Companion;", "", "<init>", "()V", "ImmediateUpdate", "", "RestartUpdate", "LaterUpdate", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ImmediateUpdate = 1;
            public static final int LaterUpdate = 3;
            public static final int RestartUpdate = 2;

            private Companion() {
            }
        }
    }

    static {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = GoogleInAppUpdate.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof GoogleInAppUpdate)) {
            hiveModule = null;
        }
        googleAppUpdate = (GoogleInAppUpdate) (hiveModule instanceof GoogleInAppUpdate ? hiveModule : null);
        prop = PropertyManager.INSTANCE.getInstance("HiveAuthV4AppUpdate.dat");
    }

    private AppUpdate() {
    }

    public static /* synthetic */ void completeUpdate$default(AppUpdate appUpdate, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        appUpdate.completeUpdate(i);
    }

    public final int appUpdateType(AuthV4.AuthV4MaintenanceInfo maintenanceInfo) {
        Intrinsics.checkNotNullParameter(maintenanceInfo, "maintenanceInfo");
        int value = -1;
        if (maintenanceInfo.getType() != 2) {
            return -1;
        }
        List<AuthV4.AuthV4MaintenanceExtraButton> exButtons = maintenanceInfo.getExButtons();
        if (exButtons != null) {
            for (AuthV4.AuthV4MaintenanceExtraButton authV4MaintenanceExtraButton : exButtons) {
                if (value < authV4MaintenanceExtraButton.getAction().getValue()) {
                    value = authV4MaintenanceExtraButton.getAction().getValue();
                }
            }
        }
        if (value < maintenanceInfo.getAction().getValue()) {
            value = maintenanceInfo.getAction().getValue();
        }
        return value == AuthV4.AuthV4MaintenanceActionType.DONE.getValue() ? 0 : 1;
    }

    public final void completeUpdate(@CompleteState int completeState) {
        GoogleInAppUpdate googleInAppUpdate;
        GoogleInAppUpdate googleInAppUpdate2;
        LoggerImpl.INSTANCE.v("AppUpdate, completeUpdate(" + completeState + ')');
        Property property = prop;
        String appVersion = Android.INSTANCE.getAppVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        property.set(keyAppVersion, appVersion);
        property.set(keyCompleteState, String.valueOf(completeState));
        property.write();
        if (completeState == 1 && (googleInAppUpdate2 = googleAppUpdate) != null) {
            GoogleInAppUpdate.DefaultImpls.completeUpdate$default(googleInAppUpdate2, null, 1, null);
        }
        if (completeState == 1) {
            GoogleInAppUpdate googleInAppUpdate3 = googleAppUpdate;
            if (googleInAppUpdate3 != null) {
                GoogleInAppUpdate.DefaultImpls.completeUpdate$default(googleInAppUpdate3, null, 1, null);
                return;
            }
            return;
        }
        if (completeState == 2 || completeState == 3 || (googleInAppUpdate = googleAppUpdate) == null) {
            return;
        }
        GoogleInAppUpdate.DefaultImpls.completeUpdate$default(googleInAppUpdate, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void launchAppUpdateFlow(@AppUpdateType final int appUpdateType, Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.v("AppUpdate, startUpdateFlow(" + appUpdateType + ')');
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = listener;
        if (appUpdateType != 0 && appUpdateType != 1) {
            loggerImpl.w("AppUpdate, startUpdateFlow - invalid appUpdateType: (" + appUpdateType + ')');
            Function1 function1 = (Function1) objectRef.element;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
            objectRef.element = null;
            return;
        }
        GoogleInAppUpdate googleInAppUpdate = googleAppUpdate;
        if (googleInAppUpdate != null) {
            googleInAppUpdate.launchAppUpdateFlow(appUpdateType, new GoogleInAppUpdate.UpdateFlowListener() { // from class: com.hive.authv4.appupdate.AppUpdate.launchAppUpdateFlow.1
                @Override // com.hive.module.interfaces.authv4.GoogleInAppUpdate.UpdateFlowListener
                public void onCanceled() {
                    Function1<Boolean, Unit> function12 = objectRef.element;
                    if (function12 != null) {
                        function12.invoke(Boolean.valueOf(appUpdateType == 0));
                        Unit unit = Unit.INSTANCE;
                    }
                    Ref.ObjectRef<Function1<Boolean, Unit>> objectRef2 = objectRef;
                    LoggerImpl.INSTANCE.w("AppUpdate, startUpdateFlow - onCanceled.");
                    objectRef2.element = null;
                }

                @Override // com.hive.module.interfaces.authv4.GoogleInAppUpdate.UpdateFlowListener
                public void onDeveloperTriggered() {
                    String str = AppUpdate.prop.get(AppUpdate.keyAppVersion);
                    String str2 = AppUpdate.prop.get(AppUpdate.keyCompleteState);
                    LoggerImpl.INSTANCE.v("AppUpdate, startUpdateFlow - onDeveloperTriggered.\n    savedAppVersion: " + str + "\n    savedCompleteState: " + str2 + '\n');
                    if (appUpdateType == 0) {
                        String appVersion = Android.INSTANCE.getAppVersion();
                        if (appVersion == null) {
                            appVersion = "";
                        }
                        if (Intrinsics.areEqual(str, appVersion)) {
                            Integer numValueOf = str2 != null ? Integer.valueOf(Integer.parseInt(str2)) : null;
                            if ((numValueOf != null && numValueOf.intValue() == 1) || (numValueOf != null && numValueOf.intValue() == 2)) {
                                GoogleInAppUpdate.DefaultImpls.completeUpdate$default(AppUpdate.googleAppUpdate, null, 1, null);
                                return;
                            } else if (numValueOf != null && numValueOf.intValue() == 3) {
                                onDownloaded();
                                return;
                            } else {
                                GoogleInAppUpdate.DefaultImpls.completeUpdate$default(AppUpdate.googleAppUpdate, null, 1, null);
                                return;
                            }
                        }
                    }
                    GoogleInAppUpdate.DefaultImpls.completeUpdate$default(AppUpdate.googleAppUpdate, null, 1, null);
                }

                @Override // com.hive.module.interfaces.authv4.GoogleInAppUpdate.UpdateFlowListener
                public void onDownloaded() {
                    if (appUpdateType != 0) {
                        GoogleInAppUpdate.DefaultImpls.completeUpdate$default(AppUpdate.googleAppUpdate, null, 1, null);
                        return;
                    }
                    HiveLifecycle.INSTANCE.onProcessUri("interwork://hive/appupdate/downloaded");
                    Function1<Boolean, Unit> function12 = objectRef.element;
                    if (function12 != null) {
                        function12.invoke(Boolean.TRUE);
                        Unit unit = Unit.INSTANCE;
                    }
                    objectRef.element = null;
                }

                @Override // com.hive.module.interfaces.authv4.GoogleInAppUpdate.UpdateFlowListener
                public void onDownloading() {
                    if (appUpdateType == 0) {
                        Function1<Boolean, Unit> function12 = objectRef.element;
                        if (function12 != null) {
                            function12.invoke(Boolean.TRUE);
                            Unit unit = Unit.INSTANCE;
                        }
                        objectRef.element = null;
                    }
                }

                @Override // com.hive.module.interfaces.authv4.GoogleInAppUpdate.UpdateFlowListener
                public void onNotAvailable() {
                    Function1<Boolean, Unit> function12 = objectRef.element;
                    if (function12 != null) {
                        function12.invoke(Boolean.FALSE);
                        Unit unit = Unit.INSTANCE;
                    }
                    Ref.ObjectRef<Function1<Boolean, Unit>> objectRef2 = objectRef;
                    LoggerImpl.INSTANCE.w("AppUpdate, startUpdateFlow - onNotAvailable.");
                    objectRef2.element = null;
                }
            });
            return;
        }
        if (listener != 0) {
            listener.invoke(Boolean.FALSE);
            Unit unit = Unit.INSTANCE;
        }
        loggerImpl.w("AppUpdate, startUpdateFlow - Idp GoogleAppUpdate Error.");
        objectRef.element = null;
    }

    public final int appUpdateType(AuthDataInterface.AuthMaintenanceInfo maintenanceInfo) {
        int value;
        int value2 = -1;
        if (maintenanceInfo == null || maintenanceInfo.getType() != 2) {
            return -1;
        }
        List<AuthDataInterface.AuthMaintenanceExtraButton> exButtons = maintenanceInfo.getExButtons();
        if (exButtons != null) {
            Iterator<AuthDataInterface.AuthMaintenanceExtraButton> it = exButtons.iterator();
            while (it.hasNext()) {
                AuthDataInterface.AuthMaintenanceActionType action = it.next().getAction();
                if (action != null && value2 < action.getValue()) {
                    value2 = action.getValue();
                }
            }
        }
        AuthDataInterface.AuthMaintenanceActionType action2 = maintenanceInfo.getAction();
        if (action2 != null && value2 < (value = action2.getValue())) {
            value2 = value;
        }
        return value2 == AuthV4.AuthV4MaintenanceActionType.DONE.getValue() ? 0 : 1;
    }
}
