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
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CustomTabsInterstitialAd extends IntersCustomEvent {
    private static String CHROME_PACKAGE = "com.android.chrome";
    private static final String TAG = "CustomTabsInterstitialAd";
    private boolean isLoaded;
    private Activity mActivity;
    private ICustomEventListener mCustomEventListener;
    private double mEcpm;
    private String mUrl;

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void loadAd(Context context, Map<String, String> map, ICustomEventListener iCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = iCustomEventListener;
        if (context == null) {
            Log.d(str, "Context cannot be null.");
            ICustomEventListener iCustomEventListener2 = this.mCustomEventListener;
            if (iCustomEventListener2 != null) {
                iCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        if (!(context instanceof Activity)) {
            Log.d(str, "An Activity Context is required.");
            ICustomEventListener iCustomEventListener3 = this.mCustomEventListener;
            if (iCustomEventListener3 != null) {
                iCustomEventListener3.onAdError();
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
            ICustomEventListener iCustomEventListener4 = this.mCustomEventListener;
            if (iCustomEventListener4 != null) {
                iCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        this.isLoaded = false;
        String strResolveCustomTabsPackageName = resolveCustomTabsPackageName(this.mActivity, Uri.parse(this.mUrl));
        ADXLogUtil.d(TAG, "customTabsPackageName : " + strResolveCustomTabsPackageName);
        if (!TextUtils.isEmpty(strResolveCustomTabsPackageName)) {
            if (isPackageNameChrome(strResolveCustomTabsPackageName)) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                this.isLoaded = true;
                ICustomEventListener iCustomEventListener = this.mCustomEventListener;
                if (iCustomEventListener != null) {
                    iCustomEventListener.onAdLoaded();
                    return;
                }
                return;
            }
            ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_FAILURE);
            this.isLoaded = false;
            ICustomEventListener iCustomEventListener2 = this.mCustomEventListener;
            if (iCustomEventListener2 != null) {
                iCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_FAILURE);
        this.isLoaded = false;
        ICustomEventListener iCustomEventListener3 = this.mCustomEventListener;
        if (iCustomEventListener3 != null) {
            iCustomEventListener3.onAdError();
        }
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        String str = TAG;
        ADXLogUtil.d(str, ":::show:::");
        if (this.isLoaded) {
            Intent intent = new Intent(this.mActivity, (Class<?>) CustomTabsActivity.class);
            intent.putExtra("url", this.mUrl);
            this.mActivity.startActivity(intent);
            this.mActivity.overridePendingTransition(0, 0);
            ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
            CustomTabsActivity.mCustomEventListener = this.mCustomEventListener;
            ICustomEventListener iCustomEventListener = this.mCustomEventListener;
            if (iCustomEventListener != null) {
                iCustomEventListener.onAdImpression();
                this.mCustomEventListener.onPaidEvent(this.mEcpm);
                return;
            }
            return;
        }
        ADXLogUtil.d(str, "The rewarded ad wasn't loaded yet.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
        ICustomEventListener iCustomEventListener2 = this.mCustomEventListener;
        if (iCustomEventListener2 != null) {
            iCustomEventListener2.onAdFailedToShow();
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
        public static ICustomEventListener mCustomEventListener;

        @Override // android.app.Activity
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            String stringExtra = getIntent().getStringExtra("url");
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().setUrlBarHidingEnabled(true).build();
            customTabsIntentBuild.intent.setData(Uri.parse(stringExtra));
            customTabsIntentBuild.intent.setPackage(CustomTabsInterstitialAd.CHROME_PACKAGE);
            startActivityForResult(customTabsIntentBuild.intent, CHROME_CUSTOM_TAB_REQUEST_CODE);
        }

        @Override // android.app.Activity
        protected void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i == CHROME_CUSTOM_TAB_REQUEST_CODE) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_CUSTOMTABS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                ICustomEventListener iCustomEventListener = mCustomEventListener;
                if (iCustomEventListener != null) {
                    iCustomEventListener.onAdClosed();
                }
                finish();
            }
        }
    }
}
