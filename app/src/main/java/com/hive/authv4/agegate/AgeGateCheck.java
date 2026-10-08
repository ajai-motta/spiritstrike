package com.hive.authv4.agegate;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.Configuration;
import com.hive.ResultAPI;
import com.hive.authv4.agegate.AgeGateCheck;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.configuration.HiveTheme;
import com.hive.logger.LoggerImpl;
import com.hive.service.R;
import com.hive.service.databinding.HiveAuthv4AgegateDialogBinding;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.effect.TouchEffectKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/hive/authv4/agegate/AgeGateCheck;", "", "<init>", "()V", "birthDateReturnFormat", "", "show", "", "activity", "Landroid/app/Activity;", "useCloseButton", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/AuthV4$AuthV4AgeGateListener;", "ViewTypeYearMonthDay", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgeGateCheck {
    public static final AgeGateCheck INSTANCE = new AgeGateCheck();
    private static final String birthDateReturnFormat = "yyyy-MM-dd";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/hive/authv4/agegate/AgeGateCheck$ViewTypeYearMonthDay;", "", "<init>", "(Ljava/lang/String;I)V", "Type_A_YYYY_MM_DD", "Type_B_MM_DD_YYYY", "Type_C_DD_MM_YYYY", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewTypeYearMonthDay {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ViewTypeYearMonthDay[] $VALUES;
        public static final ViewTypeYearMonthDay Type_A_YYYY_MM_DD = new ViewTypeYearMonthDay("Type_A_YYYY_MM_DD", 0);
        public static final ViewTypeYearMonthDay Type_B_MM_DD_YYYY = new ViewTypeYearMonthDay("Type_B_MM_DD_YYYY", 1);
        public static final ViewTypeYearMonthDay Type_C_DD_MM_YYYY = new ViewTypeYearMonthDay("Type_C_DD_MM_YYYY", 2);

        private static final /* synthetic */ ViewTypeYearMonthDay[] $values() {
            return new ViewTypeYearMonthDay[]{Type_A_YYYY_MM_DD, Type_B_MM_DD_YYYY, Type_C_DD_MM_YYYY};
        }

        static {
            ViewTypeYearMonthDay[] viewTypeYearMonthDayArr$values = $values();
            $VALUES = viewTypeYearMonthDayArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(viewTypeYearMonthDayArr$values);
        }

        private ViewTypeYearMonthDay(String str, int i) {
        }

        public static EnumEntries<ViewTypeYearMonthDay> getEntries() {
            return $ENTRIES;
        }

        public static ViewTypeYearMonthDay valueOf(String str) {
            return (ViewTypeYearMonthDay) Enum.valueOf(ViewTypeYearMonthDay.class, str);
        }

        public static ViewTypeYearMonthDay[] values() {
            return (ViewTypeYearMonthDay[]) $VALUES.clone();
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.agegate.AgeGateCheck$show$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000g\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\u000fH\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J&\u0010-\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0014\u0010.\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u000f0/H\u0002J\b\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020 H\u0002R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u00064"}, d2 = {"com/hive/authv4/agegate/AgeGateCheck$show$1", "Lcom/hive/ui/OnActivityLifecycle;", "launchActivity", "Landroid/app/Activity;", "getLaunchActivity", "()Landroid/app/Activity;", "setLaunchActivity", "(Landroid/app/Activity;)V", "binding", "Lcom/hive/service/databinding/HiveAuthv4AgegateDialogBinding;", "getBinding", "()Lcom/hive/service/databinding/HiveAuthv4AgegateDialogBinding;", "setBinding", "(Lcom/hive/service/databinding/HiveAuthv4AgegateDialogBinding;)V", "onCreate", "", "activity", "savedInstanceState", "Landroid/os/Bundle;", "refresh", "onBackPressed", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onResume", "onPause", "onRestart", "processBirthTextViewOnClickEvent", "setSelectedBirth", "birthString", "", "resizeBirthTextView", "resizeTextView", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "isYearText", "fillBirthTextView", "activateOKButton", "dismiss", "result", "Lcom/hive/ResultAPI;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/AuthV4$AuthV4AgeGateListener;", "showDatePicker", "onPicked", "Lkotlin/Function1;", "getViewTypeYearMonthDay", "Lcom/hive/authv4/agegate/AgeGateCheck$ViewTypeYearMonthDay;", "monthToAbbrev", "month", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 extends OnActivityLifecycle {
        final /* synthetic */ Ref.ObjectRef<String> $dateOfBirth;
        final /* synthetic */ Ref.BooleanRef $isBirthDateSelected;
        final /* synthetic */ Ref.BooleanRef $isShowing;
        final /* synthetic */ AuthV4.AuthV4AgeGateListener $listener;
        final /* synthetic */ boolean $useCloseButton;
        public HiveAuthv4AgegateDialogBinding binding;
        private Activity launchActivity;

        /* JADX INFO: renamed from: com.hive.authv4.agegate.AgeGateCheck$show$1$WhenMappings */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[ViewTypeYearMonthDay.values().length];
                try {
                    iArr[ViewTypeYearMonthDay.Type_A_YYYY_MM_DD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ViewTypeYearMonthDay.Type_B_MM_DD_YYYY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ViewTypeYearMonthDay.Type_C_DD_MM_YYYY.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[HiveTheme.values().length];
                try {
                    iArr2[HiveTheme.HiveLight.ordinal()] = 1;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public AnonymousClass1(Ref.BooleanRef booleanRef, boolean z, Ref.ObjectRef<String> objectRef, AuthV4.AuthV4AgeGateListener authV4AgeGateListener, Ref.BooleanRef booleanRef2) {
            this.$isShowing = booleanRef;
            this.$useCloseButton = z;
            this.$dateOfBirth = objectRef;
            this.$listener = authV4AgeGateListener;
            this.$isBirthDateSelected = booleanRef2;
        }

        private final void activateOKButton(Activity activity) {
            LoggerImpl.INSTANCE.d("[AgeGateCheck] activateOKButton");
            if (this.$isBirthDateSelected.element) {
                AppCompatTextView appCompatTextView = this.$useCloseButton ? getBinding().hiveAgegateV2ActiveButton : getBinding().hiveAgegateActiveButton;
                Intrinsics.checkNotNull(appCompatTextView);
                TypedValue typedValue = new TypedValue();
                activity.getTheme().resolveAttribute(R.attr.hiveAgeGatePopupFilledOKButton, typedValue, true);
                appCompatTextView.setBackground(ContextCompat.getDrawable(activity, typedValue.resourceId));
                TypedValue typedValue2 = new TypedValue();
                activity.getTheme().resolveAttribute(R.attr.hiveAgeGatePopupOKButtonFilledTextColor, typedValue2, true);
                appCompatTextView.setTextColor(ContextCompat.getColor(activity, typedValue2.resourceId));
                final AuthV4.AuthV4AgeGateListener authV4AgeGateListener = this.$listener;
                TouchEffectKt.setTouchEffect(appCompatTextView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.agegate.AgeGateCheck$show$1$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AgeGateCheck.AnonymousClass1.activateOKButton$lambda$21(this.f$0, authV4AgeGateListener, (View) obj);
                    }
                } : null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit activateOKButton$lambda$21(AnonymousClass1 anonymousClass1, AuthV4.AuthV4AgeGateListener authV4AgeGateListener, View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            LoggerImpl.INSTANCE.d("[AgeGateCheck] click OK button");
            anonymousClass1.dismiss(new ResultAPI(), authV4AgeGateListener);
            return Unit.INSTANCE;
        }

        private final void dismiss(ResultAPI result, AuthV4.AuthV4AgeGateListener listener) {
            LoggerImpl.INSTANCE.d("[AgeGateCheck] dismiss");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AgeGateCheck$show$1$dismiss$1(listener, result, this.$dateOfBirth, this, null), 3, null);
        }

        private final void fillBirthTextView(final Activity activity) {
            LoggerImpl.INSTANCE.d("[AgeGateCheck] fillBirthTextView");
            if (this.$isBirthDateSelected.element) {
                for (final AppCompatTextView appCompatTextView : CollectionsKt.listOf((Object[]) new AppCompatTextView[]{getBinding().hiveAgegateBirthDateFirst, getBinding().hiveAgegateBirthDateSecond, getBinding().hiveAgegateBirthDateThird})) {
                    TypedValue typedValue = new TypedValue();
                    activity.getTheme().resolveAttribute(R.attr.hiveAgeGatePopupFilledBirthTextView, typedValue, true);
                    appCompatTextView.setBackground(ContextCompat.getDrawable(activity, typedValue.resourceId));
                    TypedValue typedValue2 = new TypedValue();
                    activity.getTheme().resolveAttribute(R.attr.hiveAgeGatePopupBirthFilledTextColor, typedValue2, true);
                    appCompatTextView.setTextColor(ContextCompat.getColor(activity, typedValue2.resourceId));
                    if (WhenMappings.$EnumSwitchMapping$1[ConfigurationImpl.INSTANCE.getHiveTheme().ordinal()] == 1) {
                        Intrinsics.checkNotNull(appCompatTextView);
                        TouchEffectKt.setTouchEffect(appCompatTextView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Color.argb(117, 255, 255, 255), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.agegate.AgeGateCheck$show$1$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AgeGateCheck.AnonymousClass1.fillBirthTextView$lambda$16$lambda$14(appCompatTextView, this, activity, (View) obj);
                            }
                        } : null);
                    } else {
                        Intrinsics.checkNotNull(appCompatTextView);
                        TouchEffectKt.setTouchEffect(appCompatTextView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.agegate.AgeGateCheck$show$1$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AgeGateCheck.AnonymousClass1.fillBirthTextView$lambda$16$lambda$15(appCompatTextView, this, activity, (View) obj);
                            }
                        } : null);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit fillBirthTextView$lambda$16$lambda$14(AppCompatTextView appCompatTextView, AnonymousClass1 anonymousClass1, Activity activity, View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            LoggerImpl.INSTANCE.d("[AgeGateCheck] click " + appCompatTextView.getResources().getResourceEntryName(appCompatTextView.getId()));
            anonymousClass1.processBirthTextViewOnClickEvent(activity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit fillBirthTextView$lambda$16$lambda$15(AppCompatTextView appCompatTextView, AnonymousClass1 anonymousClass1, Activity activity, View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            LoggerImpl.INSTANCE.d("[AgeGateCheck] click " + appCompatTextView.getResources().getResourceEntryName(appCompatTextView.getId()));
            anonymousClass1.processBirthTextViewOnClickEvent(activity);
            return Unit.INSTANCE;
        }

        private final ViewTypeYearMonthDay getViewTypeYearMonthDay() {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.d("[AgeGateCheck] getViewTypeYearMonthDay");
            String gameLanguage = Configuration.getGameLanguage();
            Locale locale = Locale.ROOT;
            String lowerCase = gameLanguage.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!Intrinsics.areEqual(lowerCase, "ko")) {
                String lowerCase2 = Configuration.getGameLanguage().toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (!Intrinsics.areEqual(lowerCase2, "ja")) {
                    String lowerCase3 = Configuration.getGameLanguage().toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    if (!StringsKt.startsWith$default(lowerCase3, "zh", false, 2, (Object) null)) {
                        String lowerCase4 = Configuration.getGameLanguage().toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                        if (!Intrinsics.areEqual(lowerCase4, "fr")) {
                            String lowerCase5 = Configuration.getGameLanguage().toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                            if (!Intrinsics.areEqual(lowerCase5, "ar")) {
                                String lowerCase6 = Configuration.getGameLanguage().toLowerCase(locale);
                                Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                                if (Intrinsics.areEqual(lowerCase6, "en")) {
                                    loggerImpl.d("[AgeGateCheck] getViewTypeYearMonthDay, gameLanguage : en");
                                    return ViewTypeYearMonthDay.Type_B_MM_DD_YYYY;
                                }
                                loggerImpl.d("[AgeGateCheck] getViewTypeYearMonthDay, gameLanguage : the other cases");
                                return ViewTypeYearMonthDay.Type_C_DD_MM_YYYY;
                            }
                        }
                    }
                }
            }
            loggerImpl.d("[AgeGateCheck] getViewTypeYearMonthDay, gameLanguage : ko ja zh-* fr ar");
            return ViewTypeYearMonthDay.Type_A_YYYY_MM_DD;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private final String monthToAbbrev(String month) {
            int iHashCode = month.hashCode();
            switch (iHashCode) {
                case 1537:
                    return !month.equals("01") ? month : "JAN";
                case 1538:
                    return !month.equals("02") ? month : "FEB";
                case 1539:
                    return !month.equals("03") ? month : "MAR";
                case 1540:
                    return !month.equals("04") ? month : "APR";
                case 1541:
                    return !month.equals("05") ? month : "MAY";
                case 1542:
                    return !month.equals("06") ? month : "JUN";
                case 1543:
                    return !month.equals("07") ? month : "JUL";
                case 1544:
                    return !month.equals("08") ? month : "AUG";
                case 1545:
                    return !month.equals("09") ? month : "SEP";
                default:
                    switch (iHashCode) {
                        case 1567:
                            return !month.equals("10") ? month : "OCT";
                        case 1568:
                            return !month.equals("11") ? month : "NOV";
                        case 1569:
                            return !month.equals("12") ? month : "DEC";
                        default:
                            return month;
                    }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onCreate$lambda$1$lambda$0(AppCompatTextView appCompatTextView, AnonymousClass1 anonymousClass1, Activity activity, View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            LoggerImpl.INSTANCE.d("[AgeGateCheck] click " + appCompatTextView.getResources().getResourceEntryName(appCompatTextView.getId()));
            anonymousClass1.processBirthTextViewOnClickEvent(activity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onCreate$lambda$3$lambda$2(Ref.ObjectRef objectRef, AnonymousClass1 anonymousClass1, AuthV4.AuthV4AgeGateListener authV4AgeGateListener, View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            LoggerImpl.INSTANCE.d("[AgeGateCheck] click Cancel button");
            ResultAPI resultAPI = new ResultAPI(-6, ResultAPI.Code.AuthUserCanceled, "AgeGate Popup is canceled.");
            objectRef.element = null;
            anonymousClass1.dismiss(resultAPI, authV4AgeGateListener);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDestroy$lambda$5(Activity activity, boolean z, AuthV4.AuthV4AgeGateListener authV4AgeGateListener) {
            AgeGateCheck.INSTANCE.show(activity, z, authV4AgeGateListener);
        }

        private final void processBirthTextViewOnClickEvent(final Activity activity) {
            LoggerImpl.INSTANCE.d("[AgeGateCheck] processBirthTextViewOnClickEvent");
            showDatePicker(activity, new Function1() { // from class: com.hive.authv4.agegate.AgeGateCheck$show$1$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AgeGateCheck.AnonymousClass1.processBirthTextViewOnClickEvent$lambda$8(this.f$0, activity, (String) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit processBirthTextViewOnClickEvent$lambda$8(final AnonymousClass1 anonymousClass1, final Activity activity, String str) {
            anonymousClass1.setSelectedBirth(str);
            if (str != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.agegate.AgeGateCheck$show$1$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AgeGateCheck.AnonymousClass1.processBirthTextViewOnClickEvent$lambda$8$lambda$7$lambda$6(this.f$0, activity);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void processBirthTextViewOnClickEvent$lambda$8$lambda$7$lambda$6(AnonymousClass1 anonymousClass1, Activity activity) {
            anonymousClass1.fillBirthTextView(activity);
            anonymousClass1.activateOKButton(activity);
        }

        private final void refresh() {
            LoggerImpl.INSTANCE.d("[AgeGateCheck] refresh");
            if (this.$isShowing.element) {
                setSelectedBirth(this.$dateOfBirth.element);
                Activity activity = this.launchActivity;
                if (activity != null) {
                    fillBirthTextView(activity);
                    activateOKButton(activity);
                }
            }
        }

        private final void resizeBirthTextView() {
            LoggerImpl.INSTANCE.d("[AgeGateCheck] resizeBirthTextView");
            int i = WhenMappings.$EnumSwitchMapping$0[getViewTypeYearMonthDay().ordinal()];
            if (i == 1) {
                AppCompatTextView hiveAgegateBirthDateFirst = getBinding().hiveAgegateBirthDateFirst;
                Intrinsics.checkNotNullExpressionValue(hiveAgegateBirthDateFirst, "hiveAgegateBirthDateFirst");
                resizeTextView(hiveAgegateBirthDateFirst, true);
                AppCompatTextView hiveAgegateBirthDateSecond = getBinding().hiveAgegateBirthDateSecond;
                Intrinsics.checkNotNullExpressionValue(hiveAgegateBirthDateSecond, "hiveAgegateBirthDateSecond");
                resizeTextView(hiveAgegateBirthDateSecond, false);
                AppCompatTextView hiveAgegateBirthDateThird = getBinding().hiveAgegateBirthDateThird;
                Intrinsics.checkNotNullExpressionValue(hiveAgegateBirthDateThird, "hiveAgegateBirthDateThird");
                resizeTextView(hiveAgegateBirthDateThird, false);
                return;
            }
            if (i == 2) {
                AppCompatTextView hiveAgegateBirthDateFirst2 = getBinding().hiveAgegateBirthDateFirst;
                Intrinsics.checkNotNullExpressionValue(hiveAgegateBirthDateFirst2, "hiveAgegateBirthDateFirst");
                resizeTextView(hiveAgegateBirthDateFirst2, false);
                AppCompatTextView hiveAgegateBirthDateSecond2 = getBinding().hiveAgegateBirthDateSecond;
                Intrinsics.checkNotNullExpressionValue(hiveAgegateBirthDateSecond2, "hiveAgegateBirthDateSecond");
                resizeTextView(hiveAgegateBirthDateSecond2, false);
                AppCompatTextView hiveAgegateBirthDateThird2 = getBinding().hiveAgegateBirthDateThird;
                Intrinsics.checkNotNullExpressionValue(hiveAgegateBirthDateThird2, "hiveAgegateBirthDateThird");
                resizeTextView(hiveAgegateBirthDateThird2, true);
                return;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            AppCompatTextView hiveAgegateBirthDateFirst3 = getBinding().hiveAgegateBirthDateFirst;
            Intrinsics.checkNotNullExpressionValue(hiveAgegateBirthDateFirst3, "hiveAgegateBirthDateFirst");
            resizeTextView(hiveAgegateBirthDateFirst3, false);
            AppCompatTextView hiveAgegateBirthDateSecond3 = getBinding().hiveAgegateBirthDateSecond;
            Intrinsics.checkNotNullExpressionValue(hiveAgegateBirthDateSecond3, "hiveAgegateBirthDateSecond");
            resizeTextView(hiveAgegateBirthDateSecond3, false);
            AppCompatTextView hiveAgegateBirthDateThird3 = getBinding().hiveAgegateBirthDateThird;
            Intrinsics.checkNotNullExpressionValue(hiveAgegateBirthDateThird3, "hiveAgegateBirthDateThird");
            resizeTextView(hiveAgegateBirthDateThird3, true);
        }

        private final void resizeTextView(AppCompatTextView textView, boolean isYearText) {
            LoggerImpl.INSTANCE.d("[AgeGateCheck] resizeTextView");
            int i = isYearText ? R.integer.authv4_agegate_dialog_popup_birth_year_width : R.integer.authv4_agegate_dialog_popup_birth_width;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.horizontalWeight = getBinding().getRoot().getResources().getInteger(i);
            textView.setLayoutParams(layoutParams2);
            textView.requestLayout();
        }

        private final void setSelectedBirth(String birthString) {
            LoggerImpl.INSTANCE.d("[AgeGateCheck] setSelectedBirth");
            if (birthString != null) {
                List listSplit$default = StringsKt.split$default((CharSequence) birthString, new String[]{"-"}, false, 0, 6, (Object) null);
                if (listSplit$default.size() == 3) {
                    int i = WhenMappings.$EnumSwitchMapping$0[getViewTypeYearMonthDay().ordinal()];
                    if (i == 1) {
                        getBinding().hiveAgegateBirthDateFirst.setText((CharSequence) listSplit$default.get(0));
                        getBinding().hiveAgegateBirthDateSecond.setText(monthToAbbrev((String) listSplit$default.get(1)));
                        getBinding().hiveAgegateBirthDateThird.setText((CharSequence) listSplit$default.get(2));
                    } else if (i == 2) {
                        getBinding().hiveAgegateBirthDateFirst.setText(monthToAbbrev((String) listSplit$default.get(1)));
                        getBinding().hiveAgegateBirthDateSecond.setText((CharSequence) listSplit$default.get(2));
                        getBinding().hiveAgegateBirthDateThird.setText((CharSequence) listSplit$default.get(0));
                    } else {
                        if (i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        getBinding().hiveAgegateBirthDateFirst.setText((CharSequence) listSplit$default.get(2));
                        getBinding().hiveAgegateBirthDateSecond.setText(monthToAbbrev((String) listSplit$default.get(1)));
                        getBinding().hiveAgegateBirthDateThird.setText((CharSequence) listSplit$default.get(0));
                    }
                }
            }
        }

        private final void showDatePicker(Activity activity, final Function1<? super String, Unit> onPicked) {
            LoggerImpl.INSTANCE.d("[AgeGateCheck] showDatePicker");
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(1);
            int i2 = calendar.get(2);
            int i3 = calendar.get(5);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(11, 0);
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            calendar2.set(14, 0);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.set(1, 1900);
            calendar3.set(2, 0);
            calendar3.set(5, 1);
            ContextThemeWrapper contextThemeWrapper = showDatePicker$isSmallCoverDisplay(activity) ? new ContextThemeWrapper(activity, android.R.style.Theme.Holo.Light.Dialog.NoActionBar) : activity;
            final Ref.ObjectRef<String> objectRef = this.$dateOfBirth;
            final Ref.BooleanRef booleanRef = this.$isBirthDateSelected;
            DatePickerDialog datePickerDialog = new DatePickerDialog(contextThemeWrapper, new DatePickerDialog.OnDateSetListener() { // from class: com.hive.authv4.agegate.AgeGateCheck$show$1$$ExternalSyntheticLambda7
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                    AgeGateCheck.AnonymousClass1.showDatePicker$lambda$25(objectRef, booleanRef, onPicked, datePicker, i4, i5, i6);
                }
            }, i, i2, i3);
            datePickerDialog.getDatePicker().setMaxDate(calendar2.getTimeInMillis());
            datePickerDialog.getDatePicker().setMinDate(calendar3.getTimeInMillis());
            String str = this.$dateOfBirth.element;
            if (str != null) {
                try {
                    List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{'-'}, false, 0, 6, (Object) null);
                    datePickerDialog.getDatePicker().updateDate(Integer.parseInt((String) listSplit$default.get(0)), Integer.parseInt((String) listSplit$default.get(1)) - 1, Integer.parseInt((String) listSplit$default.get(2)));
                } catch (Exception e) {
                    LoggerImpl.INSTANCE.w("[AgeGateCheck] showDatePicker, parse selected dataOfBirth exception : " + e);
                }
            }
            datePickerDialog.show();
        }

        private static final boolean showDatePicker$isSmallCoverDisplay(Context context) {
            android.content.res.Configuration configuration = context.getResources().getConfiguration();
            return configuration.screenWidthDp < 450 && configuration.screenHeightDp < 450;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
        public static final void showDatePicker$lambda$25(Ref.ObjectRef objectRef, Ref.BooleanRef booleanRef, Function1 function1, DatePicker datePicker, int i, int i2, int i3) {
            LoggerImpl.INSTANCE.d("[AgeGateCheck] showDatePicker, selected birthDate : " + i + '-' + i2 + '-' + i3);
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, i);
            calendar.set(2, i2);
            calendar.set(5, i3);
            ?? r5 = new SimpleDateFormat(AgeGateCheck.birthDateReturnFormat, Locale.getDefault()).format(calendar.getTime());
            objectRef.element = r5;
            CharSequence charSequence = (CharSequence) r5;
            if (charSequence != null && charSequence.length() != 0) {
                booleanRef.element = true;
            }
            function1.invoke(objectRef.element);
        }

        public final HiveAuthv4AgegateDialogBinding getBinding() {
            HiveAuthv4AgegateDialogBinding hiveAuthv4AgegateDialogBinding = this.binding;
            if (hiveAuthv4AgegateDialogBinding != null) {
                return hiveAuthv4AgegateDialogBinding;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            return null;
        }

        public final Activity getLaunchActivity() {
            return this.launchActivity;
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public boolean onBackPressed() {
            LoggerImpl.INSTANCE.d("[AgeGateCheck] onBackPressed, not support close.");
            if (!this.$useCloseButton) {
                return true;
            }
            ResultAPI resultAPI = new ResultAPI(-6, ResultAPI.Code.AuthUserCanceled, "AgeGate Popup is canceled.");
            this.$dateOfBirth.element = null;
            dismiss(resultAPI, this.$listener);
            return true;
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onConfigurationChanged(Activity activity, android.content.res.Configuration newConfig) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            LoggerImpl.INSTANCE.d("[AgeGateCheck] onConfigurationChanged");
            super.onConfigurationChanged(activity, newConfig);
            activity.recreate();
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onCreate(final Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onCreate(activity, savedInstanceState);
            LoggerImpl.INSTANCE.d("[AgeGateCheck] create view");
            this.$isShowing.element = true;
            this.launchActivity = activity;
            setBinding(HiveAuthv4AgegateDialogBinding.inflate(activity.getLayoutInflater()));
            activity.setContentView(getBinding().getRoot());
            resizeBirthTextView();
            String upperCase = AgeGateCheck.birthDateReturnFormat.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            setSelectedBirth(upperCase);
            for (final AppCompatTextView appCompatTextView : CollectionsKt.listOf((Object[]) new AppCompatTextView[]{getBinding().hiveAgegateBirthDateFirst, getBinding().hiveAgegateBirthDateSecond, getBinding().hiveAgegateBirthDateThird})) {
                Intrinsics.checkNotNull(appCompatTextView);
                TouchEffectKt.setTouchEffect(appCompatTextView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.agegate.AgeGateCheck$show$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AgeGateCheck.AnonymousClass1.onCreate$lambda$1$lambda$0(appCompatTextView, this, activity, (View) obj);
                    }
                } : null);
            }
            if (this.$useCloseButton) {
                getBinding().hiveAgegateActiveButton.setVisibility(8);
                AppCompatTextView appCompatTextView2 = getBinding().hiveAgegateV2CancelButton;
                final Ref.ObjectRef<String> objectRef = this.$dateOfBirth;
                final AuthV4.AuthV4AgeGateListener authV4AgeGateListener = this.$listener;
                Intrinsics.checkNotNull(appCompatTextView2);
                TouchEffectKt.setTouchEffect(appCompatTextView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.agegate.AgeGateCheck$show$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AgeGateCheck.AnonymousClass1.onCreate$lambda$3$lambda$2(objectRef, this, authV4AgeGateListener, (View) obj);
                    }
                } : null);
                activateOKButton(activity);
            } else {
                getBinding().hiveAgegateV2ActiveButton.setVisibility(8);
                getBinding().hiveAgegateV2CancelButton.setVisibility(8);
                activateOKButton(activity);
            }
            refresh();
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onDestroy(final Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            LoggerImpl.INSTANCE.d("[AgeGateCheck] onDestroy");
            this.$isShowing.element = false;
            this.launchActivity = null;
            if (getIsCalledFinish() || getIsRecreated()) {
                return;
            }
            Handler handler = new Handler(Looper.getMainLooper());
            final boolean z = this.$useCloseButton;
            final AuthV4.AuthV4AgeGateListener authV4AgeGateListener = this.$listener;
            handler.post(new Runnable() { // from class: com.hive.authv4.agegate.AgeGateCheck$show$1$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    AgeGateCheck.AnonymousClass1.onDestroy$lambda$5(activity, z, authV4AgeGateListener);
                }
            });
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onPause(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            LoggerImpl.INSTANCE.d("[AgeGateCheck] onPause");
            super.onPause(activity);
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onRestart(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            LoggerImpl.INSTANCE.d("[AgeGateCheck] onRestart");
            super.onRestart(activity);
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onResume(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            LoggerImpl.INSTANCE.d("[AgeGateCheck] onResume");
            super.onResume(activity);
            refresh();
        }

        public final void setBinding(HiveAuthv4AgegateDialogBinding hiveAuthv4AgegateDialogBinding) {
            Intrinsics.checkNotNullParameter(hiveAuthv4AgegateDialogBinding, "<set-?>");
            this.binding = hiveAuthv4AgegateDialogBinding;
        }

        public final void setLaunchActivity(Activity activity) {
            this.launchActivity = activity;
        }
    }

    private AgeGateCheck() {
    }

    public final void show(Activity activity, boolean useCloseButton, AuthV4.AuthV4AgeGateListener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        Intent intentPutExtra = new Intent().putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "AgeGate");
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        HiveUiActivity.INSTANCE.launch(activity, intentPutExtra, new AnonymousClass1(booleanRef2, useCloseButton, objectRef, listener, booleanRef));
    }
}
