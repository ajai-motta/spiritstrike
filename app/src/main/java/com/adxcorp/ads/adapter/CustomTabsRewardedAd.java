package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.webkit.ProxyConfig;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CustomTabsRewardedAd extends RewardedCustomEvent {
    private static String CHROME_PACKAGE = "com.android.chrome";
    private static final String TAG = "CustomTabsRewardedAd";
    private boolean isLoaded;
    private Activity mActivity;
    private RCustomEventListener mCustomEventListener;
    private double mEcpm;
    private String mUrl;

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void loadAd(Context context, Map<String, String> map, RCustomEventListener rCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = rCustomEventListener;
        if (context == null) {
            Log.d(str, "Context cannot be null.");
            RCustomEventListener rCustomEventListener2 = this.mCustomEventListener;
            if (rCustomEventListener2 != null) {
                rCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        if (!(context instanceof Activity)) {
            Log.d(str, "An Activity Context is required.");
            RCustomEventListener rCustomEventListener3 = this.mCustomEventListener;
            if (rCustomEventListener3 != null) {
                rCustomEventListener3.onAdError();
                return;
            }
            return;
        }
        this.mActivity = (Activity) context;
        this.mUrl = map.get("url");
        try {
            this.mEcpm = Double.parseDouble(map.get("ecpm"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            Log.d(TAG, "The url cannot be null.");
            RCustomEventListener rCustomEventListener4 = this.mCustomEventListener;
            if (rCustomEventListener4 != null) {
                rCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        this.isLoaded = false;
        String strResolveCustomTabsPackageName = resolveCustomTabsPackageName(this.mActivity, Uri.parse(this.mUrl));
        ADXLogUtil.d(TAG, "customTabsPackageName : " + strResolveCustomTabsPackageName);
        if (!TextUtils.isEmpty(strResolveCustomTabsPackageName)) {
            if (isPackageNameChrome(strResolveCustomTabsPackageName)) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                this.isLoaded = true;
                RCustomEventListener rCustomEventListener = this.mCustomEventListener;
                if (rCustomEventListener != null) {
                    rCustomEventListener.onAdLoaded();
                    return;
                }
                return;
            }
            ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_FAILURE);
            this.isLoaded = false;
            RCustomEventListener rCustomEventListener2 = this.mCustomEventListener;
            if (rCustomEventListener2 != null) {
                rCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_FAILURE);
        this.isLoaded = false;
        RCustomEventListener rCustomEventListener3 = this.mCustomEventListener;
        if (rCustomEventListener3 != null) {
            rCustomEventListener3.onAdError();
        }
    }

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void show() {
        String str = TAG;
        ADXLogUtil.d(str, ":::show:::");
        if (this.isLoaded) {
            Intent intent = new Intent(this.mActivity, (Class<?>) CustomTabsActivity.class);
            intent.putExtra("url", this.mUrl);
            this.mActivity.startActivity(intent);
            this.mActivity.overridePendingTransition(0, 0);
            ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_RV, "Impression");
            CustomTabsActivity.mCustomEventListener = this.mCustomEventListener;
            RCustomEventListener rCustomEventListener = this.mCustomEventListener;
            if (rCustomEventListener != null) {
                rCustomEventListener.onAdImpression();
                this.mCustomEventListener.onPaidEvent(this.mEcpm);
                return;
            }
            return;
        }
        ADXLogUtil.d(str, "The rewarded ad wasn't loaded yet.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
        RCustomEventListener rCustomEventListener2 = this.mCustomEventListener;
        if (rCustomEventListener2 != null) {
            rCustomEventListener2.onAdFailedToShow();
        }
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
    }

    public static ArrayList<ResolveInfo> getCustomTabsPackages(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts(ProxyConfig.MATCH_HTTP, "", null)), 0);
        ArrayList<ResolveInfo> arrayList = new ArrayList<>();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent = new Intent();
            intent.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
            intent.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent, 0) != null) {
                arrayList.add(resolveInfo);
            }
        }
        return arrayList;
    }

    private String resolveCustomTabsPackageName(Context context, Uri uri) {
        String str = null;
        try {
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", uri), 65536);
            Intent intent = new Intent();
            intent.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
            Iterator<ResolveInfo> it = context.getPackageManager().queryIntentServices(intent, 0).iterator();
            String str2 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo next = it.next();
                if (str2 == null && isPackageNameChrome(next.serviceInfo.packageName)) {
                    str2 = next.serviceInfo.packageName;
                    ADXLogUtil.d(TAG, "available chrome : " + str2);
                }
                if (next.serviceInfo.packageName.equals(resolveInfoResolveActivity.activityInfo.packageName)) {
                    String str3 = resolveInfoResolveActivity.activityInfo.packageName;
                    ADXLogUtil.d(TAG, "default browser : " + str3);
                    break;
                }
            }
            str = str2;
            ADXLogUtil.d(TAG, "selected browser is " + str);
            return str;
        } catch (ActivityNotFoundException e) {
            ADXLogUtil.e(TAG, e);
            return str;
        } catch (Exception e2) {
            ADXLogUtil.e(TAG, e2);
            return str;
        }
    }

    private boolean isPackageNameChrome(String str) {
        return !TextUtils.isEmpty(str) && str.equals(CHROME_PACKAGE);
    }

    public static class CustomTabsActivity extends Activity {
        private static final int CHROME_CUSTOM_TAB_REQUEST_CODE = 6168;
        public static RCustomEventListener mCustomEventListener;

        @Override // android.app.Activity
        protected void onCreate(Bundle bundle) {
            CustomTabsIntent customTabsIntentBuild;
            super.onCreate(bundle);
            String stringExtra = getIntent().getStringExtra("url");
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            try {
                customTabsIntentBuild = builder.setUrlBarHidingEnabled(true).build();
            } catch (NoSuchMethodError unused) {
                customTabsIntentBuild = builder.enableUrlBarHiding().build();
            }
            customTabsIntentBuild.intent.setData(Uri.parse(stringExtra));
            customTabsIntentBuild.intent.setPackage(CustomTabsRewardedAd.CHROME_PACKAGE);
            startActivityForResult(customTabsIntentBuild.intent, CHROME_CUSTOM_TAB_REQUEST_CODE);
        }

        @Override // android.app.Activity
        protected void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i == CHROME_CUSTOM_TAB_REQUEST_CODE) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                RCustomEventListener rCustomEventListener = mCustomEventListener;
                if (rCustomEventListener != null) {
                    rCustomEventListener.onAdRewarded();
                }
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                RCustomEventListener rCustomEventListener2 = mCustomEventListener;
                if (rCustomEventListener2 != null) {
                    rCustomEventListener2.onAdClosed();
                }
                finish();
            }
        }
    }
}
