package com.hive.platformhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.core.ExtentionsKt;
import com.hive.logger.LoggerImpl;
import com.hive.platformhelper.InAppBrowser;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/hive/platformhelper/InAppBrowser;", "", "<init>", "()V", "TAG", "", "show", "", "context", "Landroid/content/Context;", "data", "Lcom/hive/platformhelper/InAppBrowserData;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/platformhelper/InAppBrowser$InAppBrowserListener;", "isSupportCustomTabsOnDefaultBrowser", "", "isValidUrl", "url", "isValidHexColorString", "color", "openExternalBrowser", "InAppBrowserListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InAppBrowser {
    public static final InAppBrowser INSTANCE = new InAppBrowser();
    public static final String TAG = "InAppBrowser";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/platformhelper/InAppBrowser$InAppBrowserListener;", "", "onInAppBrowser", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface InAppBrowserListener {
        void onInAppBrowser(ResultAPI result);
    }

    /* JADX INFO: renamed from: com.hive.platformhelper.InAppBrowser$show$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/hive/platformhelper/InAppBrowser$show$3", "Lcom/hive/ui/OnActivityLifecycle;", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass3 extends OnActivityLifecycle {
        final /* synthetic */ InAppBrowserData $data;
        final /* synthetic */ InAppBrowserListener $listener;

        public AnonymousClass3(InAppBrowserData inAppBrowserData, InAppBrowserListener inAppBrowserListener) {
            this.$data = inAppBrowserData;
            this.$listener = inAppBrowserListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCreate$lambda$1$lambda$0(Activity activity, InAppBrowserListener inAppBrowserListener, int i) {
            LoggerImpl.INSTANCE.d(InAppBrowser.TAG, "ActivityResultCallback statusCode(" + i + ')');
            activity.finish();
            inAppBrowserListener.onInAppBrowser(new ResultAPI());
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onCreate(final Activity activity, Bundle savedInstanceState) {
            Object objM7415constructorimpl;
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onCreate(activity, savedInstanceState);
            final InAppBrowserData inAppBrowserData = this.$data;
            final InAppBrowserListener inAppBrowserListener = this.$listener;
            try {
                Result.Companion companion = Result.INSTANCE;
                ActivityResultLauncher activityResultLauncherRegisterForActivityResult = ((AppCompatActivity) activity).registerForActivityResult(new ActivityResultContract<Uri, Integer>() { // from class: com.hive.platformhelper.InAppBrowser$show$3$onCreate$1$1
                    @Override // androidx.activity.result.contract.ActivityResultContract
                    public Intent createIntent(Context context, Uri input) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(input, "input");
                        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                        InAppBrowserData inAppBrowserData2 = inAppBrowserData;
                        Boolean urlBarHiding = inAppBrowserData2.getUrlBarHiding();
                        if (urlBarHiding != null) {
                            builder.setUrlBarHidingEnabled(urlBarHiding.booleanValue());
                        }
                        Boolean shareState = inAppBrowserData2.getShareState();
                        if (shareState != null) {
                            builder.setShareState(shareState.booleanValue() ? 1 : 2);
                        }
                        String navigationColor = inAppBrowserData2.getNavigationColor();
                        if (navigationColor != null) {
                            CustomTabColorSchemeParams customTabColorSchemeParamsBuild = new CustomTabColorSchemeParams.Builder().setToolbarColor(Color.parseColor(navigationColor)).build();
                            Intrinsics.checkNotNullExpressionValue(customTabColorSchemeParamsBuild, "build(...)");
                            builder.setDefaultColorSchemeParams(customTabColorSchemeParamsBuild);
                        }
                        CustomTabsIntent customTabsIntentBuild = builder.build();
                        Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "build(...)");
                        Intent intent = customTabsIntentBuild.intent;
                        Intrinsics.checkNotNullExpressionValue(intent, "intent");
                        intent.setData(input);
                        return intent;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // androidx.activity.result.contract.ActivityResultContract
                    public Integer parseResult(int resultCode, Intent intent) {
                        return Integer.valueOf(resultCode);
                    }
                }, new ActivityResultCallback() { // from class: com.hive.platformhelper.InAppBrowser$show$3$$ExternalSyntheticLambda0
                    @Override // androidx.activity.result.ActivityResultCallback
                    public final void onActivityResult(Object obj) {
                        InAppBrowser.AnonymousClass3.onCreate$lambda$1$lambda$0(activity, inAppBrowserListener, ((Integer) obj).intValue());
                    }
                });
                Uri uri = Uri.parse(inAppBrowserData.getUrl());
                Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                activityResultLauncherRegisterForActivityResult.launch(uri);
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            InAppBrowserListener inAppBrowserListener2 = this.$listener;
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                LoggerImpl.INSTANCE.d(InAppBrowser.TAG, "registerForActivityResult onFailure(" + thM7418exceptionOrNullimpl.getMessage() + ')');
                activity.finish();
                inAppBrowserListener2.onInAppBrowser(new ResultAPI(-99, ResultAPI.Code.CommonUnknown, thM7418exceptionOrNullimpl.getMessage()));
            }
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onDestroy(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (getIsCalledFinish()) {
                return;
            }
            this.$listener.onInAppBrowser(new ResultAPI());
        }
    }

    private InAppBrowser() {
    }

    private final boolean isSupportCustomTabsOnDefaultBrowser(Context context) {
        return CustomTabsClient.getPackageName(context, Collections.EMPTY_LIST) != null;
    }

    private final boolean isValidHexColorString(String color) {
        if (StringsKt.isBlank(color)) {
            return false;
        }
        try {
            Color.parseColor(color);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    private final boolean isValidUrl(String url) {
        return URLUtil.isValidUrl(url);
    }

    private final void openExternalBrowser(Context context, String url) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(url));
        ExtentionsKt.startActivityCatching(context, intent, new Function1() { // from class: com.hive.platformhelper.InAppBrowser$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InAppBrowser.openExternalBrowser$lambda$4((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openExternalBrowser$lambda$4(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LoggerImpl.INSTANCE.w(TAG, "openExternalBrowser exception: " + it.getMessage());
        return Unit.INSTANCE;
    }

    public final void show(Context context, InAppBrowserData data, InAppBrowserListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String navigationColor = data.getNavigationColor();
        if (navigationColor != null && !INSTANCE.isValidHexColorString(navigationColor)) {
            LoggerImpl.INSTANCE.w(TAG, "is invalid hex color string");
            listener.onInAppBrowser(new ResultAPI(-1, ResultAPI.Code.PlatformHelperInvalidParam, "is invalid hex color string"));
        } else if (isSupportCustomTabsOnDefaultBrowser(context)) {
            Intent intentPutExtra = new Intent().putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
            HiveUiActivity.INSTANCE.launch(context, intentPutExtra, new AnonymousClass3(data, listener));
        } else {
            LoggerImpl.INSTANCE.i(TAG, "In-app browser is not supported on device browser.");
            listener.onInAppBrowser(new ResultAPI(-2, ResultAPI.Code.PlatformHelperNotSupported, "In-app browser is not supported on device browser."));
            if (data.getAutoRedirectToExternalBrowser()) {
                openExternalBrowser(context, data.getUrl());
            }
        }
    }
}
