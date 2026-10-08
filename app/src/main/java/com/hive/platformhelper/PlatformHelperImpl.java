package com.hive.platformhelper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import androidx.webkit.internal.AssetHelper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.HiveActivity;
import com.hive.PlatformHelper;
import com.hive.ResultAPI;
import com.hive.analytics.AnalyticsImpl;
import com.hive.analytics.provider.AnalyticsProviderAdapter;
import com.hive.authv4.appupdate.AppUpdate;
import com.hive.core.ExtentionsKt;
import com.hive.logger.LoggerImpl;
import com.hive.permission.CheckPermission;
import com.hive.platformhelper.InAppBrowser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tJ(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u001e\u0010\u0018\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u000bH\u0007J1\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\r2\b\b\u0003\u0010$\u001a\u00020\u0005J\u0016\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020(J\u0016\u0010)\u001a\u00020\r2\u0006\u0010&\u001a\u00020*2\u0006\u0010\u0010\u001a\u00020+J\u000e\u0010,\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/hive/platformhelper/PlatformHelperImpl;", "", "<init>", "()V", "REQUEST_CODE_SHARE_TEXT", "", "REQUEST_CODE_SHARE_MEDIA", "REQUEST_CODE_SHARE", "mPlatformHelperListener", "Lcom/hive/PlatformHelper$PlatformHelperListener;", "requestUserPermissionsListener", "Lcom/hive/PlatformHelper$RequestUserPermissionsListener;", "share", "", "platformShare", "Lcom/hive/platformhelper/PlatformShare;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "requestUserPermissions", "requests", "", "", "listListener", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(Landroid/app/Activity;I[Ljava/lang/String;[I)V", "completeUpdate", "completeState", "showInAppBrowser", "param", "Lcom/hive/PlatformHelper$InAppBrowserParam;", "Lcom/hive/PlatformHelper$InAppBrowserListener;", "showInAppWebView", "Lcom/hive/PlatformHelper$InAppWebViewParam;", "Lcom/hive/PlatformHelper$InAppWebViewListener;", "getLaunchParameters", "Lcom/hive/PlatformHelper$PlatformHelperParametersListener;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlatformHelperImpl {
    public static final PlatformHelperImpl INSTANCE = new PlatformHelperImpl();
    private static final int REQUEST_CODE_SHARE = 1625;
    private static final int REQUEST_CODE_SHARE_MEDIA = 1624;
    private static final int REQUEST_CODE_SHARE_TEXT = 1623;
    private static PlatformHelper.PlatformHelperListener mPlatformHelperListener;
    private static PlatformHelper.RequestUserPermissionsListener requestUserPermissionsListener;

    private PlatformHelperImpl() {
    }

    public static /* synthetic */ void completeUpdate$default(PlatformHelperImpl platformHelperImpl, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        platformHelperImpl.completeUpdate(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit share$lambda$3(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PlatformHelper.PlatformHelperListener platformHelperListener = mPlatformHelperListener;
        if (platformHelperListener != null) {
            platformHelperListener.onShare(Boolean.FALSE);
        }
        return Unit.INSTANCE;
    }

    public final void completeUpdate(@AppUpdate.CompleteState int completeState) {
        AppUpdate.INSTANCE.completeUpdate(completeState);
    }

    public final void getLaunchParameters(PlatformHelper.PlatformHelperParametersListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listener.onParameters(new ResultAPI(-2, ResultAPI.Code.CommonNotSupported, ""), "");
    }

    public final void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoggerImpl.INSTANCE.d(PlatformHelper.getTAG(), "onActivityResult :: requestCode :  " + requestCode + ", resultCode : " + resultCode);
        switch (requestCode) {
            case REQUEST_CODE_SHARE_TEXT /* 1623 */:
            case REQUEST_CODE_SHARE_MEDIA /* 1624 */:
            case REQUEST_CODE_SHARE /* 1625 */:
                PlatformHelper.PlatformHelperListener platformHelperListener = mPlatformHelperListener;
                if (platformHelperListener != null) {
                    if (resultCode == -1 || resultCode == 0) {
                        if (platformHelperListener != null) {
                            platformHelperListener.onShare(Boolean.TRUE);
                        }
                        AnalyticsImpl.sendStandardEvent$default(AnalyticsImpl.INSTANCE, AnalyticsProviderAdapter.StandardEventType.SHARE, null, 2, null);
                    } else if (platformHelperListener != null) {
                        platformHelperListener.onShare(Boolean.FALSE);
                    }
                }
                break;
        }
    }

    public final void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        LoggerImpl.INSTANCE.d(PlatformHelper.getTAG(), "requestUserPermissionResult");
        if (requestCode == 29512) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            int length = permissions.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = permissions[i];
                int i3 = i2 + 1;
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                String tag = PlatformHelper.getTAG();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" : (");
                sb.append(grantResults[i2]);
                sb.append("), ");
                sb.append(grantResults[i2] == 0 ? "granted." : "denied.");
                loggerImpl.d(tag, sb.toString());
                if (grantResults[i2] == 0) {
                    hashSet.add(str);
                } else {
                    hashSet2.add(str);
                }
                i++;
                i2 = i3;
            }
            PlatformHelper.RequestUserPermissionsListener requestUserPermissionsListener2 = requestUserPermissionsListener;
            if (requestUserPermissionsListener2 != null) {
                requestUserPermissionsListener2.onRequestUserPermissions(new ResultAPI(0, ResultAPI.Code.Success), new ArrayList(hashSet), new ArrayList(hashSet2));
                Unit unit = Unit.INSTANCE;
            }
            requestUserPermissionsListener = null;
        }
    }

    public final void requestUserPermissions(List<String> requests, PlatformHelper.RequestUserPermissionsListener listListener) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(listListener, "listListener");
        if (requests.isEmpty()) {
            listListener.onRequestUserPermissions(new ResultAPI(-1, ResultAPI.Code.PlatformHelperEmptyPermissions), new ArrayList(), new ArrayList());
            return;
        }
        requestUserPermissionsListener = listListener;
        try {
            HiveActivity.INSTANCE.getRecentActivity().requestPermissions((String[]) requests.toArray(new String[0]), CheckPermission.CHECK_PERMISSION_REQUEST_CODE);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(PlatformHelper.getTAG(), e.toString());
            listListener.onRequestUserPermissions(new ResultAPI(-6, ResultAPI.Code.CommonUnknown), new ArrayList(), new ArrayList());
            Unit unit = Unit.INSTANCE;
            requestUserPermissionsListener = null;
        }
    }

    public final void share(PlatformShare platformShare, PlatformHelper.PlatformHelperListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        mPlatformHelperListener = listener;
        if (platformShare == null) {
            listener.onShare(Boolean.FALSE);
            return;
        }
        Intent intent = new Intent();
        String subject = platformShare.getSubject();
        if (StringsKt.isBlank(subject)) {
            subject = null;
        }
        if (subject == null) {
            subject = "Share";
        }
        intent.putExtra("android.intent.extra.SUBJECT", subject);
        int shareType = platformShare.getShareType();
        if (shareType == 1) {
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", platformShare.getText());
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        } else if (shareType == 2) {
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            ArrayList arrayList = new ArrayList();
            arrayList.add(platformShare.getText());
            Unit unit = Unit.INSTANCE;
            intent.putExtra("android.intent.extra.TEXT", arrayList);
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            for (String str : platformShare.getMedia()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Uri uri = Uri.parse(str);
                    if (uri != null) {
                        arrayList2.add(uri);
                    }
                    Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
            }
            LoggerImpl.INSTANCE.v("uris to string() : " + arrayList2);
            if (arrayList2.isEmpty()) {
                listener.onShare(Boolean.FALSE);
                return;
            } else {
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
                intent.setDataAndType((Uri) arrayList2.get(0), "image/*");
            }
        }
        intent.setFlags(1);
        Activity recentActivity = HiveActivity.INSTANCE.getRecentActivity();
        Intent intentCreateChooser = Intent.createChooser(intent, subject);
        Intrinsics.checkNotNullExpressionValue(intentCreateChooser, "createChooser(...)");
        ExtentionsKt.startActivityForResultCatching(recentActivity, intentCreateChooser, REQUEST_CODE_SHARE, new Function1() { // from class: com.hive.platformhelper.PlatformHelperImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlatformHelperImpl.share$lambda$3((Throwable) obj);
            }
        });
    }

    public final void showInAppBrowser(PlatformHelper.InAppBrowserParam param, final PlatformHelper.InAppBrowserListener listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        InAppBrowser.INSTANCE.show(HiveActivity.INSTANCE.getRecentActivity(), new InAppBrowserData(param.getUrl(), param.getAutoRedirectToExternalBrowser(), param.getNavigationColor(), Boolean.valueOf(param.getUrlBarHiding()), null, 16, null), new InAppBrowser.InAppBrowserListener() { // from class: com.hive.platformhelper.PlatformHelperImpl.showInAppBrowser.1
            @Override // com.hive.platformhelper.InAppBrowser.InAppBrowserListener
            public void onInAppBrowser(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                listener.onInAppBrowser(result);
            }
        });
    }

    public final void showInAppWebView(PlatformHelper.InAppWebViewParam param, PlatformHelper.InAppWebViewListener listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        new InAppWebView(HiveActivity.INSTANCE.getRecentActivity(), param).show(listener);
    }
}
