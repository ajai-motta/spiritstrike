package com.hive.promotion.google.inappreview;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.hive.HiveActivity;
import com.hive.base.Android;
import com.hive.logger.LoggerImpl;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.promotion.GoogleInAppReview;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InAppReview.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/hive/promotion/google/inappreview/InAppReview;", "Lcom/hive/module/interfaces/promotion/GoogleInAppReview;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "launchReviewFlow", "", "activity", "Landroid/app/Activity;", "reviewUsingLatestLibrary", "reviewUsingLegacyLibrary", "getIncludedLibraryVersion", "Lcom/hive/promotion/google/inappreview/InAppReview$VERSION;", "findClassForName", "", "name", "getVersionInfo", "", "VERSION", "hive-promotion-google-inappreview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InAppReview implements GoogleInAppReview {
    private final String TAG = "GoogleInAppReview";

    /* JADX INFO: compiled from: InAppReview.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VERSION.values().length];
            try {
                iArr[VERSION.LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VERSION.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VERSION.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.hive.module.interfaces.promotion.GoogleInAppReview, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return GoogleInAppReview.DefaultImpls.getHiveModuleName(this);
    }

    public final String getTAG() {
        return this.TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: InAppReview.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/hive/promotion/google/inappreview/InAppReview$VERSION;", "", "<init>", "(Ljava/lang/String;I)V", "LATEST", "LEGACY", "NONE", "hive-promotion-google-inappreview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class VERSION {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ VERSION[] $VALUES;
        public static final VERSION LATEST = new VERSION("LATEST", 0);
        public static final VERSION LEGACY = new VERSION("LEGACY", 1);
        public static final VERSION NONE = new VERSION("NONE", 2);

        private static final /* synthetic */ VERSION[] $values() {
            return new VERSION[]{LATEST, LEGACY, NONE};
        }

        public static EnumEntries<VERSION> getEntries() {
            return $ENTRIES;
        }

        private VERSION(String str, int i) {
        }

        static {
            VERSION[] versionArr$values = $values();
            $VALUES = versionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(versionArr$values);
        }

        public static VERSION valueOf(String str) {
            return (VERSION) Enum.valueOf(VERSION.class, str);
        }

        public static VERSION[] values() {
            return (VERSION[]) $VALUES.clone();
        }
    }

    @Override // com.hive.module.interfaces.promotion.GoogleInAppReview
    public void launchReviewFlow(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!Android.isGooglePlayServicesAvailable$default(Android.INSTANCE, activity, false, 0, 4, null)) {
            LoggerImpl.INSTANCE.i(this.TAG, "[review] GooglePlayServices is not available");
            return;
        }
        final VERSION includedLibraryVersion = getIncludedLibraryVersion();
        LoggerImpl.INSTANCE.i(this.TAG, "[review] getIncludedLibraryVersion() = " + includedLibraryVersion.name());
        activity.runOnUiThread(new Runnable() { // from class: com.hive.promotion.google.inappreview.InAppReview$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InAppReview.launchReviewFlow$lambda$1(includedLibraryVersion, this, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchReviewFlow$lambda$1(VERSION version, InAppReview inAppReview, Activity activity) {
        int i = WhenMappings.$EnumSwitchMapping$0[version.ordinal()];
        if (i == 1) {
            inAppReview.reviewUsingLatestLibrary(activity);
        } else if (i == 2) {
            inAppReview.reviewUsingLegacyLibrary(activity);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            LoggerImpl.INSTANCE.i("[review] in-app review library is not included.");
        }
    }

    private final void reviewUsingLatestLibrary(final Activity activity) {
        try {
            final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(activity);
            Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
            Task<ReviewInfo> taskRequestReviewFlow = reviewManagerCreate.requestReviewFlow();
            Intrinsics.checkNotNullExpressionValue(taskRequestReviewFlow, "requestReviewFlow(...)");
            Intrinsics.checkNotNull(taskRequestReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.promotion.google.inappreview.InAppReview$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    InAppReview.reviewUsingLatestLibrary$lambda$2(this.f$0, reviewManagerCreate, activity, task);
                }
            }));
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(this.TAG, "[reviewUsingLatestLibrary] exception: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reviewUsingLatestLibrary$lambda$2(InAppReview inAppReview, ReviewManager reviewManager, Activity activity, Task reviewInfo) {
        Intrinsics.checkNotNullParameter(reviewInfo, "reviewInfo");
        LoggerImpl.INSTANCE.d(inAppReview.TAG, "[reviewUsingLatestLibrary] isSuccessful : " + reviewInfo.isSuccessful());
        if (reviewInfo.isSuccessful()) {
            reviewManager.launchReviewFlow(activity, (ReviewInfo) reviewInfo.getResult());
            return;
        }
        LoggerImpl.INSTANCE.w(inAppReview.TAG, "[reviewUsingLatestLibrary] reviewInfo failed : " + reviewInfo);
    }

    private final void reviewUsingLegacyLibrary(final Activity activity) {
        try {
            final Object objInvoke = Class.forName("com.google.android.play.core.review.ReviewManagerFactory").getDeclaredMethod("create", Context.class).invoke(null, activity);
            Object objInvoke2 = objInvoke.getClass().getDeclaredMethod("requestReviewFlow", new Class[0]).invoke(objInvoke, new Object[0]);
            Class<?> cls = Class.forName("com.google.android.play.core.tasks.OnCompleteListener");
            objInvoke2.getClass().getDeclaredMethod("addOnCompleteListener", cls).invoke(objInvoke2, Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.hive.promotion.google.inappreview.InAppReview$$ExternalSyntheticLambda1
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    return InAppReview.reviewUsingLegacyLibrary$lambda$3(this.f$0, objInvoke, activity, obj, method, objArr);
                }
            }));
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(this.TAG, "[reviewUsingLegacyLibrary] exception: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object reviewUsingLegacyLibrary$lambda$3(InAppReview inAppReview, Object obj, Activity activity, Object obj2, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        if (Intrinsics.areEqual(method.getName(), "onComplete")) {
            Object objInvoke = Class.forName("com.google.android.play.core.tasks.Task").getDeclaredMethod("isSuccessful", new Class[0]).invoke(args[0], new Object[0]);
            boolean z = Boolean.parseBoolean(objInvoke != null ? objInvoke.toString() : null);
            LoggerImpl.INSTANCE.d(inAppReview.TAG, "[reviewUsingLegacyLibrary] isSuccessful : " + z);
            if (z) {
                obj.getClass().getDeclaredMethod("launchReviewFlow", Activity.class, Class.forName("com.google.android.play.core.review.ReviewInfo")).invoke(obj, activity, Class.forName("com.google.android.play.core.tasks.Task").getDeclaredMethod("getResult", new Class[0]).invoke(args[0], new Object[0]));
            }
        }
        return null;
    }

    private final VERSION getIncludedLibraryVersion() {
        if (findClassForName("com.google.android.play.core.review.ReviewManagerFactory")) {
            return findClassForName("com.google.android.play.core.tasks.Task") ? VERSION.LEGACY : VERSION.LATEST;
        }
        return VERSION.NONE;
    }

    private final boolean findClassForName(String name) {
        try {
            Class.forName(name);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Promotion_Google_Inappreview(), "26.2.0");
        try {
            Result.Companion companion = Result.INSTANCE;
            Properties properties = new Properties();
            properties.load(HiveActivity.INSTANCE.getRecentActivity().getClassLoader().getResourceAsStream("review.properties"));
            map.put(ModuleCheckName.INSTANCE.getGoogle_Play_Review(), properties.getProperty("version"));
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return map;
    }
}
