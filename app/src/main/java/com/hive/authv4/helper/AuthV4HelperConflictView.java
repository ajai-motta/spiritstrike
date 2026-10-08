package com.hive.authv4.helper;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.core.Configuration;
import com.hive.service.databinding.HiveAuthv4HelperConflictViewBinding;
import com.hive.ui.Resource;
import com.hive.ui.effect.TouchEffectKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/hive/authv4/helper/AuthV4HelperConflictView;", "", "activity", "Landroid/app/Activity;", "providerType", "Lcom/hive/AuthV4$ProviderType;", "isGuest", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/AuthV4$Helper$AuthV4HelperListener;", "<init>", "(Landroid/app/Activity;Lcom/hive/AuthV4$ProviderType;ZLcom/hive/AuthV4$Helper$AuthV4HelperListener;)V", "binding", "Lcom/hive/service/databinding/HiveAuthv4HelperConflictViewBinding;", "isDismiss", "getView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onBackPressed", "dismiss", "", "isChangeAccount", "providerTypeToString", "", "type", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4HelperConflictView {
    private final HiveAuthv4HelperConflictViewBinding binding;
    private boolean isDismiss;
    private final AuthV4.Helper.AuthV4HelperListener listener;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AuthV4.ProviderType.values().length];
            try {
                iArr[AuthV4.ProviderType.APPLE.ordinal()] = 1;
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
                iArr[AuthV4.ProviderType.GOOGLE_PLAY_GAMES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AuthV4.ProviderType.HIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AuthV4.ProviderType.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AuthV4.ProviderType.QQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AuthV4.ProviderType.VK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AuthV4.ProviderType.WECHAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AuthV4.ProviderType.WEVERSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AuthV4.ProviderType.SIGNIN_APPLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AuthV4.ProviderType.HUAWEI.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AuthV4.ProviderType.STEAM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AuthV4.ProviderType.X.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[AuthV4.ProviderType.TELEGRAM.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[AuthV4.ProviderType.XIAOMI.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AuthV4HelperConflictView(Activity activity, AuthV4.ProviderType providerType, boolean z, AuthV4.Helper.AuthV4HelperListener listener) {
        String str;
        AuthV4.ProviderType providerType2 = providerType;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(providerType2, "providerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        HiveAuthv4HelperConflictViewBinding hiveAuthv4HelperConflictViewBindingInflate = HiveAuthv4HelperConflictViewBinding.inflate(activity.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(hiveAuthv4HelperConflictViewBindingInflate, "inflate(...)");
        this.binding = hiveAuthv4HelperConflictViewBindingInflate;
        if (providerType2 == AuthV4.ProviderType.GOOGLE && Configuration.INSTANCE.getGoogleLegacySupport()) {
            providerType2 = AuthV4.ProviderType.GOOGLE_PLAY_GAMES;
        }
        if (z) {
            AppCompatTextView appCompatTextView = hiveAuthv4HelperConflictViewBindingInflate.hiveHelperConflictDialogMainButton;
            Resource resource = Resource.INSTANCE;
            appCompatTextView.setText(resource.getString(activity, "hive_authv4helper_dialog_ok"));
            Intrinsics.checkNotNull(appCompatTextView);
            TouchEffectKt.setTouchEffect(appCompatTextView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.helper.AuthV4HelperConflictView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4HelperConflictView.lambda$1$lambda$0(this.f$0, (View) obj);
                }
            } : null);
            hiveAuthv4HelperConflictViewBindingInflate.hiveHelperConflictDialogSubButton.setVisibility(8);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = resource.getString(activity, "hive_authv4helper_dialog_conflictmsg_guest");
            str = String.format(string != null ? string : "", Arrays.copyOf(new Object[]{providerTypeToString(providerType2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        } else {
            AppCompatTextView appCompatTextView2 = hiveAuthv4HelperConflictViewBindingInflate.hiveHelperConflictDialogMainButton;
            Resource resource2 = Resource.INSTANCE;
            appCompatTextView2.setText(resource2.getString(activity, "hive_authv4helper_dialog_ok"));
            Intrinsics.checkNotNull(appCompatTextView2);
            TouchEffectKt.setTouchEffect(appCompatTextView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.helper.AuthV4HelperConflictView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4HelperConflictView.lambda$3$lambda$2(this.f$0, (View) obj);
                }
            } : null);
            AppCompatTextView appCompatTextView3 = hiveAuthv4HelperConflictViewBindingInflate.hiveHelperConflictDialogSubButton;
            appCompatTextView3.setText(resource2.getString(activity, "hive_authv4helper_dialog_cancel"));
            appCompatTextView3.setVisibility(0);
            Intrinsics.checkNotNull(appCompatTextView3);
            TouchEffectKt.setTouchEffect(appCompatTextView3, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Color.argb(117, 255, 255, 255), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.helper.AuthV4HelperConflictView$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4HelperConflictView.lambda$5$lambda$4(this.f$0, (View) obj);
                }
            } : null);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = resource2.getString(activity, "hive_authv4helper_dialog_conflictmsg2");
            str = String.format(string2 != null ? string2 : "", Arrays.copyOf(new Object[]{providerTypeToString(providerType2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        }
        hiveAuthv4HelperConflictViewBindingInflate.hiveHelperConflictDialogTitle.setText(str);
    }

    static final Unit lambda$1$lambda$0(AuthV4HelperConflictView authV4HelperConflictView, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        authV4HelperConflictView.dismiss(false);
        return Unit.INSTANCE;
    }

    static final Unit lambda$3$lambda$2(AuthV4HelperConflictView authV4HelperConflictView, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        authV4HelperConflictView.dismiss(true);
        return Unit.INSTANCE;
    }

    static final Unit lambda$5$lambda$4(AuthV4HelperConflictView authV4HelperConflictView, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        authV4HelperConflictView.dismiss(false);
        return Unit.INSTANCE;
    }

    public final void dismiss(boolean isChangeAccount) {
        if (this.isDismiss) {
            return;
        }
        this.isDismiss = true;
        if (isChangeAccount) {
            this.listener.onAuthV4Helper(new ResultAPI(-15, ResultAPI.Code.AuthV4PlayerChange), null);
        } else {
            this.listener.onAuthV4Helper(new ResultAPI(), null);
        }
    }

    public final ConstraintLayout getView() {
        ConstraintLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final boolean onBackPressed() {
        dismiss(false);
        return true;
    }

    public final String providerTypeToString(AuthV4.ProviderType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                String string = Resource.INSTANCE.getString("hive_authv4impl_provider_type_apple");
                return string == null ? "" : string;
            case 2:
                String string2 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_facebook");
                return string2 == null ? "" : string2;
            case 3:
                String string3 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_google");
                return string3 == null ? "" : string3;
            case 4:
                String string4 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_googleplay");
                return string4 == null ? "" : string4;
            case 5:
                String string5 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_hive");
                return string5 == null ? "" : string5;
            case 6:
                String string6 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_line");
                return string6 == null ? "" : string6;
            case 7:
                String string7 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_qq");
                return string7 == null ? "" : string7;
            case 8:
                String string8 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_vk");
                return string8 == null ? "" : string8;
            case 9:
                String string9 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_wechat");
                return string9 == null ? "" : string9;
            case 10:
                String string10 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_weverse");
                return string10 == null ? "" : string10;
            case 11:
                String string11 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_signinwithapple");
                return string11 == null ? "" : string11;
            case 12:
                String string12 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_huawei");
                return string12 == null ? "" : string12;
            case 13:
                String string13 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_steam");
                return string13 == null ? "" : string13;
            case 14:
                String string14 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_x");
                return string14 == null ? "" : string14;
            case 15:
                String string15 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_telegram");
                return string15 == null ? "" : string15;
            case 16:
                String string16 = Resource.INSTANCE.getString("hive_authv4impl_provider_type_xiaomi");
                return string16 == null ? "" : string16;
            default:
                return "";
        }
    }

    public /* synthetic */ AuthV4HelperConflictView(Activity activity, AuthV4.ProviderType providerType, boolean z, AuthV4.Helper.AuthV4HelperListener authV4HelperListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, providerType, (i & 4) != 0 ? false : z, authV4HelperListener);
    }
}
