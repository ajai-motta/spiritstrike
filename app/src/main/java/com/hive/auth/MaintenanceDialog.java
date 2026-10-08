package com.hive.auth;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.auth.AuthMaintenancePopupDialog;
import com.hive.auth.MaintenanceViewModel;
import com.hive.authv4.AuthV4Impl;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.ExtentionsKt;
import com.hive.logger.LoggerImpl;
import com.hive.ui.dialog.HivePopupDialog;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0005\u001b\u001c\u001d\u001e\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0013J,\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/hive/auth/MaintenanceDialog;", "", "activity", "Landroid/app/Activity;", "maintenanceModel", "Lcom/hive/auth/MaintenanceDialog$MaintenanceModel;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/auth/MaintenanceDialog$OnDismissListener;", "<init>", "(Landroid/app/Activity;Lcom/hive/auth/MaintenanceDialog$MaintenanceModel;Lcom/hive/auth/MaintenanceDialog$OnDismissListener;)V", "maintenanceDialog", "Lcom/hive/auth/AuthMaintenancePopupDialog;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;", "url", "", "maintenanceViewModel", "Lcom/hive/auth/MaintenanceViewModel;", "setMaintenanceDialog", "", "show", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dismiss", "executeButtonAction", "actionType", "OnDismissListener", "MaintenanceModel", "MaintenanceActionType", "MaintenanceDialogType", "MaintenanceExtraButton", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MaintenanceDialog {
    private MaintenanceActionType action;
    private final OnDismissListener listener;
    private AuthMaintenancePopupDialog maintenanceDialog;
    private MaintenanceViewModel maintenanceViewModel;
    private String url;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0012"}, d2 = {"Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "TIMEOVER", "OPEN_URL", "EXIT", "DONE", "stringValue", "", "getStringValue", "()Ljava/lang/String;", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MaintenanceActionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MaintenanceActionType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int value;
        public static final MaintenanceActionType UNDEFINED = new MaintenanceActionType("UNDEFINED", 0, -1);
        public static final MaintenanceActionType TIMEOVER = new MaintenanceActionType("TIMEOVER", 1, 0);
        public static final MaintenanceActionType OPEN_URL = new MaintenanceActionType("OPEN_URL", 2, 1);
        public static final MaintenanceActionType EXIT = new MaintenanceActionType("EXIT", 3, 2);
        public static final MaintenanceActionType DONE = new MaintenanceActionType("DONE", 4, 3);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType$Companion;", "", "<init>", "()V", "findValue", "Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final MaintenanceActionType findValue(int value) {
                if (value == 0) {
                    return MaintenanceActionType.TIMEOVER;
                }
                if (value == 1) {
                    return MaintenanceActionType.OPEN_URL;
                }
                if (value == 2) {
                    return MaintenanceActionType.EXIT;
                }
                if (value != 3) {
                    return null;
                }
                return MaintenanceActionType.DONE;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ MaintenanceActionType[] $values() {
            return new MaintenanceActionType[]{UNDEFINED, TIMEOVER, OPEN_URL, EXIT, DONE};
        }

        static {
            MaintenanceActionType[] maintenanceActionTypeArr$values = $values();
            $VALUES = maintenanceActionTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(maintenanceActionTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private MaintenanceActionType(String str, int i, int i2) {
            this.value = i2;
        }

        public static EnumEntries<MaintenanceActionType> getEntries() {
            return $ENTRIES;
        }

        public static MaintenanceActionType valueOf(String str) {
            return (MaintenanceActionType) Enum.valueOf(MaintenanceActionType.class, str);
        }

        public static MaintenanceActionType[] values() {
            return (MaintenanceActionType[]) $VALUES.clone();
        }

        public final String getStringValue() {
            return String.valueOf(this.value);
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000ej\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u0010"}, d2 = {"Lcom/hive/auth/MaintenanceDialog$MaintenanceDialogType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "DEFAULT", "BLACKLIST", "stringValue", "", "getStringValue", "()Ljava/lang/String;", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MaintenanceDialogType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MaintenanceDialogType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int value;
        public static final MaintenanceDialogType UNDEFINED = new MaintenanceDialogType("UNDEFINED", 0, -1);
        public static final MaintenanceDialogType DEFAULT = new MaintenanceDialogType("DEFAULT", 1, 0);
        public static final MaintenanceDialogType BLACKLIST = new MaintenanceDialogType("BLACKLIST", 2, 1);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/auth/MaintenanceDialog$MaintenanceDialogType$Companion;", "", "<init>", "()V", "findValue", "Lcom/hive/auth/MaintenanceDialog$MaintenanceDialogType;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final MaintenanceDialogType findValue(int value) {
                if (value == 0) {
                    return MaintenanceDialogType.DEFAULT;
                }
                if (value != 1) {
                    return null;
                }
                return MaintenanceDialogType.BLACKLIST;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ MaintenanceDialogType[] $values() {
            return new MaintenanceDialogType[]{UNDEFINED, DEFAULT, BLACKLIST};
        }

        static {
            MaintenanceDialogType[] maintenanceDialogTypeArr$values = $values();
            $VALUES = maintenanceDialogTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(maintenanceDialogTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private MaintenanceDialogType(String str, int i, int i2) {
            this.value = i2;
        }

        public static EnumEntries<MaintenanceDialogType> getEntries() {
            return $ENTRIES;
        }

        public static MaintenanceDialogType valueOf(String str) {
            return (MaintenanceDialogType) Enum.valueOf(MaintenanceDialogType.class, str);
        }

        public static MaintenanceDialogType[] values() {
            return (MaintenanceDialogType[]) $VALUES.clone();
        }

        public final String getStringValue() {
            return String.valueOf(this.value);
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/hive/auth/MaintenanceDialog$MaintenanceExtraButton;", "", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;", "url", "", "button", "<init>", "(Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;", "setAction", "(Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getButton", "setButton", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MaintenanceExtraButton {
        private MaintenanceActionType action;
        private String button;
        private String url;

        public MaintenanceExtraButton(MaintenanceActionType maintenanceActionType, String url, String button) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(button, "button");
            this.action = maintenanceActionType;
            this.url = url;
            this.button = button;
        }

        public final MaintenanceActionType getAction() {
            return this.action;
        }

        public final String getButton() {
            return this.button;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setAction(MaintenanceActionType maintenanceActionType) {
            this.action = maintenanceActionType;
        }

        public final void setButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.button = str;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/auth/MaintenanceDialog$OnDismissListener;", "Landroid/content/DialogInterface$OnDismissListener;", "onDismissWithButtonAction", "", "dialog", "Landroid/content/DialogInterface;", "buttonAction", "Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnDismissListener extends DialogInterface.OnDismissListener {
        void onDismissWithButtonAction(DialogInterface dialog, MaintenanceActionType buttonAction);
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MaintenanceActionType.values().length];
            try {
                iArr[MaintenanceActionType.TIMEOVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MaintenanceActionType.OPEN_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MaintenanceActionType.EXIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MaintenanceActionType.DONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MaintenanceDialog(Activity activity, MaintenanceModel maintenanceModel, OnDismissListener listener) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(maintenanceModel, "maintenanceModel");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.action = MaintenanceActionType.DONE;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.maintenanceViewModel = (MaintenanceViewModel) new ViewModelProvider((AppCompatActivity) activity, new MaintenanceViewModel.Factory(maintenanceModel)).get(MaintenanceViewModel.class);
            setMaintenanceDialog(activity, listener);
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[MaintenanceDialog] init exception: " + thM7418exceptionOrNullimpl.getMessage());
        }
    }

    private final void executeButtonAction(Activity activity, MaintenanceActionType actionType, String url, OnDismissListener listener) {
        LoggerImpl.INSTANCE.w("[MaintenanceDialog] executeButtonAction - actionType : " + actionType);
        int i = WhenMappings.$EnumSwitchMapping$0[actionType.ordinal()];
        AuthMaintenancePopupDialog authMaintenancePopupDialog = null;
        if (i == 1) {
            if (!ConfigurationImpl.INSTANCE.getExitEventEnabled() || listener == null) {
                return;
            }
            AuthImpl.INSTANCE.memoryReset$hive_service_release();
            AuthV4Impl.INSTANCE.memoryReset$hive_service_release();
            AuthMaintenancePopupDialog authMaintenancePopupDialog2 = this.maintenanceDialog;
            if (authMaintenancePopupDialog2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maintenanceDialog");
            } else {
                authMaintenancePopupDialog = authMaintenancePopupDialog2;
            }
            listener.onDismissWithButtonAction(authMaintenancePopupDialog, MaintenanceActionType.TIMEOVER);
            return;
        }
        if (i == 2) {
            if (url != null && (!StringsKt.isBlank(url))) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching(activity, intent, new Function1() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MaintenanceDialog.executeButtonAction$lambda$20((Throwable) obj);
                    }
                });
            }
            if (!ConfigurationImpl.INSTANCE.getExitEventEnabled() || listener == null) {
                Android.INSTANCE.finish();
                return;
            }
            AuthImpl.INSTANCE.memoryReset$hive_service_release();
            AuthV4Impl.INSTANCE.memoryReset$hive_service_release();
            AuthMaintenancePopupDialog authMaintenancePopupDialog3 = this.maintenanceDialog;
            if (authMaintenancePopupDialog3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maintenanceDialog");
            } else {
                authMaintenancePopupDialog = authMaintenancePopupDialog3;
            }
            listener.onDismissWithButtonAction(authMaintenancePopupDialog, MaintenanceActionType.OPEN_URL);
            return;
        }
        if (i == 3) {
            if (!ConfigurationImpl.INSTANCE.getExitEventEnabled() || listener == null) {
                Android.INSTANCE.finish();
                return;
            }
            AuthImpl.INSTANCE.memoryReset$hive_service_release();
            AuthV4Impl.INSTANCE.memoryReset$hive_service_release();
            AuthMaintenancePopupDialog authMaintenancePopupDialog4 = this.maintenanceDialog;
            if (authMaintenancePopupDialog4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maintenanceDialog");
            } else {
                authMaintenancePopupDialog = authMaintenancePopupDialog4;
            }
            listener.onDismissWithButtonAction(authMaintenancePopupDialog, MaintenanceActionType.EXIT);
            return;
        }
        if (i == 4) {
            if (listener != null) {
                AuthMaintenancePopupDialog authMaintenancePopupDialog5 = this.maintenanceDialog;
                if (authMaintenancePopupDialog5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("maintenanceDialog");
                } else {
                    authMaintenancePopupDialog = authMaintenancePopupDialog5;
                }
                listener.onDismiss(authMaintenancePopupDialog);
                return;
            }
            return;
        }
        if (!ConfigurationImpl.INSTANCE.getExitEventEnabled() || listener == null) {
            Android.INSTANCE.finish();
            return;
        }
        AuthImpl.INSTANCE.memoryReset$hive_service_release();
        AuthV4Impl.INSTANCE.memoryReset$hive_service_release();
        AuthMaintenancePopupDialog authMaintenancePopupDialog6 = this.maintenanceDialog;
        if (authMaintenancePopupDialog6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maintenanceDialog");
        } else {
            authMaintenancePopupDialog = authMaintenancePopupDialog6;
        }
        listener.onDismissWithButtonAction(authMaintenancePopupDialog, MaintenanceActionType.EXIT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit executeButtonAction$lambda$20(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.printStackTrace();
        return Unit.INSTANCE;
    }

    private final void setMaintenanceDialog(final Activity activity, final OnDismissListener listener) {
        MaintenanceViewModel maintenanceViewModel = this.maintenanceViewModel;
        MaintenanceViewModel maintenanceViewModel2 = null;
        if (maintenanceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maintenanceViewModel");
            maintenanceViewModel = null;
        }
        final MaintenanceModel maintenanceModel = maintenanceViewModel.getMaintenanceModel();
        this.action = maintenanceModel.getAction();
        this.url = maintenanceModel.getUrl();
        AuthMaintenancePopupDialog.Builder builder = new AuthMaintenancePopupDialog.Builder(activity);
        StringBuffer stringBuffer = new StringBuffer();
        if (StringsKt.isBlank(maintenanceModel.getStartDate()) || StringsKt.isBlank(maintenanceModel.getEndDate())) {
            stringBuffer.append(maintenanceModel.getMessage());
        } else {
            stringBuffer.append(maintenanceModel.getStartDate()).append(" - ").append(maintenanceModel.getEndDate()).append("\n\n").append(maintenanceModel.getMessage());
        }
        builder.setTitle(maintenanceModel.getTitle());
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        builder.setMessage(string);
        MaintenanceViewModel maintenanceViewModel3 = this.maintenanceViewModel;
        if (maintenanceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maintenanceViewModel");
            maintenanceViewModel3 = null;
        }
        Integer value = maintenanceViewModel3.getRemainingTime().getValue();
        if (value != null && value.intValue() > 0 && maintenanceModel.getDialogType() != MaintenanceDialogType.BLACKLIST) {
            builder.setTimer(value.intValue());
            MaintenanceViewModel maintenanceViewModel4 = this.maintenanceViewModel;
            if (maintenanceViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maintenanceViewModel");
                maintenanceViewModel4 = null;
            }
            maintenanceViewModel4.updateRemainingTime();
            MaintenanceViewModel maintenanceViewModel5 = this.maintenanceViewModel;
            if (maintenanceViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maintenanceViewModel");
            } else {
                maintenanceViewModel2 = maintenanceViewModel5;
            }
            LiveData<Integer> remainingTime = maintenanceViewModel2.getRemainingTime();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            remainingTime.observe((AppCompatActivity) activity, new MaintenanceDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MaintenanceDialog.setMaintenanceDialog$lambda$2(this.f$0, (Integer) obj);
                }
            }));
        }
        if (maintenanceModel.getDialogType() == MaintenanceDialogType.BLACKLIST) {
            builder.setDialogType(HivePopupDialog.HivePopupDialogParams.NativeDialogType.BLACKLIST);
            String htmlMessage = maintenanceModel.getHtmlMessage();
            if (htmlMessage != null && !StringsKt.isBlank(htmlMessage)) {
                builder.setMessage(htmlMessage);
            }
        }
        if (StringsKt.isBlank(maintenanceModel.getCustomerButton()) || StringsKt.isBlank(maintenanceModel.getCustomerLink())) {
            if (maintenanceModel.getExButtons() != null && (!r1.isEmpty())) {
                final List<MaintenanceExtraButton> exButtons = maintenanceModel.getExButtons();
                if (!exButtons.isEmpty()) {
                    if (exButtons.get(0).getAction() == MaintenanceActionType.DONE) {
                        builder.setCloseButton(exButtons.get(0).getButton(), new View.OnClickListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda13
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                MaintenanceDialog.setMaintenanceDialog$lambda$12$lambda$6(this.f$0, exButtons, view);
                            }
                        });
                    } else if (exButtons.size() == 2) {
                        builder.setSubButton(exButtons.get(0).getButton(), new View.OnClickListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda14
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                MaintenanceDialog.setMaintenanceDialog$lambda$12$lambda$7(this.f$0, exButtons, view);
                            }
                        });
                    } else if (exButtons.size() == 1) {
                        builder.setMainButton(exButtons.get(0).getButton(), new View.OnClickListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                MaintenanceDialog.setMaintenanceDialog$lambda$12$lambda$8(this.f$0, exButtons, view);
                            }
                        });
                    }
                }
                if (exButtons.size() >= 2) {
                    if (exButtons.size() == 3) {
                        builder.setSubButton(exButtons.get(1).getButton(), new View.OnClickListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                MaintenanceDialog.setMaintenanceDialog$lambda$12$lambda$9(this.f$0, exButtons, view);
                            }
                        });
                    } else {
                        builder.setMainButton(exButtons.get(1).getButton(), new View.OnClickListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda3
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                MaintenanceDialog.setMaintenanceDialog$lambda$12$lambda$10(this.f$0, exButtons, view);
                            }
                        });
                    }
                }
                if (exButtons.size() == 3) {
                    builder.setMainButton(exButtons.get(2).getButton(), new View.OnClickListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MaintenanceDialog.setMaintenanceDialog$lambda$12$lambda$11(this.f$0, exButtons, view);
                        }
                    });
                }
                Unit unit = Unit.INSTANCE;
            } else if (maintenanceModel.getAction() == MaintenanceActionType.DONE) {
                builder.setCloseButton(maintenanceModel.getButton(), new View.OnClickListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MaintenanceDialog.setMaintenanceDialog$lambda$13(view);
                    }
                });
            } else {
                builder.setMainButton(maintenanceModel.getButton(), new View.OnClickListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MaintenanceDialog.setMaintenanceDialog$lambda$14(view);
                    }
                });
            }
        } else {
            builder.setSubButton(maintenanceModel.getCustomerButton(), new View.OnClickListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaintenanceDialog.setMaintenanceDialog$lambda$4(this.f$0, maintenanceModel, view);
                }
            });
            builder.setMainButton(maintenanceModel.getButton(), new View.OnClickListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaintenanceDialog.setMaintenanceDialog$lambda$5(view);
                }
            });
        }
        builder.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                MaintenanceDialog.setMaintenanceDialog$lambda$17(maintenanceModel, this, dialogInterface);
            }
        });
        builder.setDissmissListener(new DialogInterface.OnDismissListener() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                MaintenanceDialog.setMaintenanceDialog$lambda$18(this.f$0, activity, listener, dialogInterface);
            }
        });
        this.maintenanceDialog = builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$12$lambda$10(MaintenanceDialog maintenanceDialog, List list, View view) {
        MaintenanceActionType action = ((MaintenanceExtraButton) list.get(1)).getAction();
        if (action == null) {
            action = MaintenanceActionType.DONE;
        }
        maintenanceDialog.action = action;
        maintenanceDialog.url = ((MaintenanceExtraButton) list.get(1)).getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$12$lambda$11(MaintenanceDialog maintenanceDialog, List list, View view) {
        MaintenanceActionType action = ((MaintenanceExtraButton) list.get(2)).getAction();
        if (action == null) {
            action = MaintenanceActionType.DONE;
        }
        maintenanceDialog.action = action;
        maintenanceDialog.url = ((MaintenanceExtraButton) list.get(2)).getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$12$lambda$6(MaintenanceDialog maintenanceDialog, List list, View view) {
        MaintenanceActionType action = ((MaintenanceExtraButton) list.get(0)).getAction();
        if (action == null) {
            action = MaintenanceActionType.DONE;
        }
        maintenanceDialog.action = action;
        maintenanceDialog.url = ((MaintenanceExtraButton) list.get(0)).getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$12$lambda$7(MaintenanceDialog maintenanceDialog, List list, View view) {
        MaintenanceActionType action = ((MaintenanceExtraButton) list.get(0)).getAction();
        if (action == null) {
            action = MaintenanceActionType.DONE;
        }
        maintenanceDialog.action = action;
        maintenanceDialog.url = ((MaintenanceExtraButton) list.get(0)).getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$12$lambda$8(MaintenanceDialog maintenanceDialog, List list, View view) {
        MaintenanceActionType action = ((MaintenanceExtraButton) list.get(0)).getAction();
        if (action == null) {
            action = MaintenanceActionType.DONE;
        }
        maintenanceDialog.action = action;
        maintenanceDialog.url = ((MaintenanceExtraButton) list.get(0)).getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$12$lambda$9(MaintenanceDialog maintenanceDialog, List list, View view) {
        MaintenanceActionType action = ((MaintenanceExtraButton) list.get(1)).getAction();
        if (action == null) {
            action = MaintenanceActionType.DONE;
        }
        maintenanceDialog.action = action;
        maintenanceDialog.url = ((MaintenanceExtraButton) list.get(1)).getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$13(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$14(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$17(MaintenanceModel maintenanceModel, MaintenanceDialog maintenanceDialog, DialogInterface dialogInterface) {
        LoggerImpl.INSTANCE.d("maintenanceDialog", "=== onCancel ===");
        MaintenanceActionType maintenanceActionType = MaintenanceActionType.EXIT;
        List<MaintenanceExtraButton> exButtons = maintenanceModel.getExButtons();
        if (exButtons != null) {
            Iterator<MaintenanceExtraButton> it = exButtons.iterator();
            while (it.hasNext()) {
                MaintenanceActionType action = it.next().getAction();
                if (action != null && maintenanceActionType.getValue() < action.getValue()) {
                    maintenanceActionType = action;
                }
            }
        }
        if (maintenanceDialog.action.getValue() < maintenanceActionType.getValue()) {
            maintenanceDialog.action = maintenanceActionType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$18(MaintenanceDialog maintenanceDialog, Activity activity, OnDismissListener onDismissListener, DialogInterface dialogInterface) {
        LoggerImpl.INSTANCE.d("maintenanceDialog", "=== onDismiss ===");
        maintenanceDialog.executeButtonAction(activity, maintenanceDialog.action, maintenanceDialog.url, onDismissListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setMaintenanceDialog$lambda$2(MaintenanceDialog maintenanceDialog, Integer num) {
        AuthMaintenancePopupDialog authMaintenancePopupDialog = null;
        if (num.intValue() < 0) {
            maintenanceDialog.action = MaintenanceActionType.TIMEOVER;
            AuthMaintenancePopupDialog authMaintenancePopupDialog2 = maintenanceDialog.maintenanceDialog;
            if (authMaintenancePopupDialog2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maintenanceDialog");
            } else {
                authMaintenancePopupDialog = authMaintenancePopupDialog2;
            }
            authMaintenancePopupDialog.dismiss();
            if (!ConfigurationImpl.INSTANCE.getExitEventEnabled()) {
                Android.INSTANCE.finish();
            }
        } else {
            AuthMaintenancePopupDialog authMaintenancePopupDialog3 = maintenanceDialog.maintenanceDialog;
            if (authMaintenancePopupDialog3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maintenanceDialog");
            } else {
                authMaintenancePopupDialog = authMaintenancePopupDialog3;
            }
            Intrinsics.checkNotNull(num);
            authMaintenancePopupDialog.setRemainingTime(num.intValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$4(MaintenanceDialog maintenanceDialog, MaintenanceModel maintenanceModel, View view) {
        maintenanceDialog.action = MaintenanceActionType.OPEN_URL;
        maintenanceDialog.url = maintenanceModel.getCustomerLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMaintenanceDialog$lambda$5(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$19(MaintenanceDialog maintenanceDialog) {
        AuthMaintenancePopupDialog authMaintenancePopupDialog = maintenanceDialog.maintenanceDialog;
        if (authMaintenancePopupDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maintenanceDialog");
            authMaintenancePopupDialog = null;
        }
        authMaintenancePopupDialog.show();
    }

    public final void dismiss() {
        AuthMaintenancePopupDialog authMaintenancePopupDialog = this.maintenanceDialog;
        if (authMaintenancePopupDialog != null) {
            if (authMaintenancePopupDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maintenanceDialog");
                authMaintenancePopupDialog = null;
            }
            authMaintenancePopupDialog.dismiss();
        }
    }

    public final void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        AuthMaintenancePopupDialog authMaintenancePopupDialog = this.maintenanceDialog;
        AuthMaintenancePopupDialog authMaintenancePopupDialog2 = null;
        if (authMaintenancePopupDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maintenanceDialog");
            authMaintenancePopupDialog = null;
        }
        authMaintenancePopupDialog.setOnDismissListener(null);
        AuthMaintenancePopupDialog authMaintenancePopupDialog3 = this.maintenanceDialog;
        if (authMaintenancePopupDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maintenanceDialog");
        } else {
            authMaintenancePopupDialog2 = authMaintenancePopupDialog3;
        }
        authMaintenancePopupDialog2.dismiss();
        setMaintenanceDialog(activity, this.listener);
        show();
    }

    public final void show() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.MaintenanceDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MaintenanceDialog.show$lambda$19(this.f$0);
            }
        });
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/hive/auth/MaintenanceDialog$MaintenanceModel;", "", "title", "", "message", "htmlMessage", "button", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;", "url", "remainingTime", "", "customerButton", "customerLink", "startDate", "endDate", "exButtons", "", "Lcom/hive/auth/MaintenanceDialog$MaintenanceExtraButton;", "dialogType", "Lcom/hive/auth/MaintenanceDialog$MaintenanceDialogType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/hive/auth/MaintenanceDialog$MaintenanceDialogType;)V", "getTitle", "()Ljava/lang/String;", "getMessage", "getHtmlMessage", "getButton", "getAction", "()Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;", "getUrl", "getRemainingTime", "()I", "getCustomerButton", "getCustomerLink", "getStartDate", "getEndDate", "getExButtons", "()Ljava/util/List;", "getDialogType", "()Lcom/hive/auth/MaintenanceDialog$MaintenanceDialogType;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MaintenanceModel {
        private final MaintenanceActionType action;
        private final String button;
        private final String customerButton;
        private final String customerLink;
        private final MaintenanceDialogType dialogType;
        private final String endDate;
        private final List<MaintenanceExtraButton> exButtons;
        private final String htmlMessage;
        private final String message;
        private final int remainingTime;
        private final String startDate;
        private final String title;
        private final String url;

        public MaintenanceModel(String title, String message, String str, String button, MaintenanceActionType action, String url, int i, String customerButton, String customerLink, String startDate, String endDate, List<MaintenanceExtraButton> list, MaintenanceDialogType dialogType) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(button, "button");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(customerButton, "customerButton");
            Intrinsics.checkNotNullParameter(customerLink, "customerLink");
            Intrinsics.checkNotNullParameter(startDate, "startDate");
            Intrinsics.checkNotNullParameter(endDate, "endDate");
            Intrinsics.checkNotNullParameter(dialogType, "dialogType");
            this.title = title;
            this.message = message;
            this.htmlMessage = str;
            this.button = button;
            this.action = action;
            this.url = url;
            this.remainingTime = i;
            this.customerButton = customerButton;
            this.customerLink = customerLink;
            this.startDate = startDate;
            this.endDate = endDate;
            this.exButtons = list;
            this.dialogType = dialogType;
        }

        public final MaintenanceActionType getAction() {
            return this.action;
        }

        public final String getButton() {
            return this.button;
        }

        public final String getCustomerButton() {
            return this.customerButton;
        }

        public final String getCustomerLink() {
            return this.customerLink;
        }

        public final MaintenanceDialogType getDialogType() {
            return this.dialogType;
        }

        public final String getEndDate() {
            return this.endDate;
        }

        public final List<MaintenanceExtraButton> getExButtons() {
            return this.exButtons;
        }

        public final String getHtmlMessage() {
            return this.htmlMessage;
        }

        public final String getMessage() {
            return this.message;
        }

        public final int getRemainingTime() {
            return this.remainingTime;
        }

        public final String getStartDate() {
            return this.startDate;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        public /* synthetic */ MaintenanceModel(String str, String str2, String str3, String str4, MaintenanceActionType maintenanceActionType, String str5, int i, String str6, String str7, String str8, String str9, List list, MaintenanceDialogType maintenanceDialogType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i2 & 4) != 0 ? null : str3, str4, maintenanceActionType, str5, i, (i2 & 128) != 0 ? "" : str6, (i2 & 256) != 0 ? "" : str7, (i2 & 512) != 0 ? "" : str8, (i2 & 1024) != 0 ? "" : str9, (i2 & 2048) != 0 ? null : list, (i2 & 4096) != 0 ? MaintenanceDialogType.UNDEFINED : maintenanceDialogType);
        }
    }
}
