package com.gomfactory.adpie.sdk.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.webkit.ProxyConfig;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.InAppBrowser;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class ClickThroughUtil {
    public static final String TAG = "ClickThroughUtil";
    private static final long VALIDATION_TIME = 500;
    private static ArrayList<String> choiceBrowser = new ArrayList<>();
    private static long sLastClickTime;

    public static void addTargetBrowser(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<String> it = choiceBrowser.iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return;
            }
        }
        choiceBrowser.add(str);
    }

    public static void clearTargetBrowser() {
        choiceBrowser.clear();
    }

    public static boolean goToBrowser(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, ":::clickEvent:::Open Browser : " + str);
            }
            intent.setData(Uri.parse(str));
            intent.addFlags(268435456);
            if (choiceBrowser.isEmpty()) {
                intent.setPackage("com.sec.android.app.sbrowser");
                try {
                    context.startActivity(intent);
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened the Samsung browser. " + str);
                    }
                    return true;
                } catch (ActivityNotFoundException unused) {
                    intent.setPackage("com.android.chrome");
                    try {
                        context.startActivity(intent);
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened the Chrome browser. " + str);
                        }
                        return true;
                    } catch (ActivityNotFoundException unused2) {
                        intent.setPackage(null);
                    }
                }
            } else {
                for (String str2 : choiceBrowser) {
                    intent.setPackage(str2);
                    try {
                        context.startActivity(intent);
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened browser. (" + str2 + ") " + str);
                        }
                        return true;
                    } catch (ActivityNotFoundException unused3) {
                    }
                }
                intent.setPackage(null);
            }
            context.startActivity(intent);
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened browser. " + str);
            }
            return true;
        } catch (Exception e) {
            if (!AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                return false;
            }
            AdPieLog.e(TAG, e);
            return false;
        }
    }

    public static boolean isValidClick() {
        if (SystemClock.elapsedRealtime() - sLastClickTime < 500) {
            return false;
        }
        sLastClickTime = SystemClock.elapsedRealtime();
        return true;
    }

    public static boolean goToWebView(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            str2 = ":::clickEvent:::You have successfully opened WebView. ";
            AdPieLog.d(TAG, "landingUrl : " + str + ", scheme : " + scheme);
        } else {
            str2 = ":::clickEvent:::You have successfully opened WebView. ";
        }
        if (scheme.equalsIgnoreCase(ProxyConfig.MATCH_HTTP) || scheme.equalsIgnoreCase("https")) {
            try {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, ":::clickEvent:::Open WebView. " + str);
                }
                Intent intent = new Intent(context, (Class<?>) InAppBrowser.class);
                intent.putExtra("url", str);
                context.startActivity(intent);
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, str2 + str);
                }
                return true;
            } catch (ActivityNotFoundException e) {
                AdPieLog.e(TAG, e);
                return goToBrowser(context, str);
            } catch (Exception e2) {
                AdPieLog.e(TAG, e2);
                return goToBrowser(context, str);
            }
        }
        if (uri.getScheme().equalsIgnoreCase("intent")) {
            String stringExtra = null;
            try {
                Intent uri2 = Intent.parseUri(str, 1);
                stringExtra = uri2.getStringExtra("browser_fallback_url");
                context.startActivity(uri2);
                return true;
            } catch (ActivityNotFoundException e3) {
                String str3 = TAG;
                AdPieLog.e(str3, e3);
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(str3, "fallbackUrl : " + stringExtra);
                }
                if (TextUtils.isEmpty(stringExtra)) {
                    return false;
                }
                try {
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(str3, ":::clickEvent:::Open WebView. (fallback) " + stringExtra);
                    }
                    Intent intent2 = new Intent(context, (Class<?>) InAppBrowser.class);
                    intent2.putExtra("url", stringExtra);
                    context.startActivity(intent2);
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(str3, ":::clickEvent:::You have successfully opened WebView. (fallback) " + stringExtra);
                    }
                    return true;
                } catch (ActivityNotFoundException e4) {
                    AdPieLog.e(TAG, e4);
                    return goToBrowser(context, stringExtra);
                } catch (Exception e5) {
                    AdPieLog.e(TAG, e5);
                    return goToBrowser(context, stringExtra);
                }
            } catch (URISyntaxException e6) {
                String str4 = TAG;
                Log.e(str4, "Can't resolve intent://", e6);
                AdPieLog.e(str4, e6);
                return false;
            }
        }
        if (!scheme.equalsIgnoreCase("market")) {
            try {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, ":::clickEvent:::Start intent. " + str);
                }
                context.startActivity(Intent.parseUri(str, 1));
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, ":::clickEvent:::You have successfully started intent. " + str);
                }
                return true;
            } catch (ActivityNotFoundException e7) {
                AdPieLog.e(TAG, e7);
                return false;
            } catch (URISyntaxException e8) {
                AdPieLog.e(TAG, e8);
                return false;
            }
        }
        try {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, ":::clickEvent:::Open Google Play Store. " + str);
            }
            Intent intent3 = new Intent("android.intent.action.VIEW");
            intent3.setData(Uri.parse(str));
            intent3.setPackage("com.android.vending");
            context.startActivity(intent3);
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, ":::clickEvent:::You have successfully opened Google Play Store. " + str);
            }
            return true;
        } catch (ActivityNotFoundException e9) {
            String str5 = TAG;
            AdPieLog.e(str5, e9);
            try {
                String str6 = String.format("https://play.google.com/store/apps/details?%s", uri.getQuery());
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(str5, ":::clickEvent:::Open Google Play Store. " + str6);
                }
                Intent intent4 = new Intent("android.intent.action.VIEW");
                intent4.setData(Uri.parse(str6));
                intent4.setPackage("com.android.vending");
                context.startActivity(intent4);
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(str5, ":::clickEvent:::You have successfully opened Google Play Store. " + str6);
                }
                return true;
            } catch (ActivityNotFoundException e10) {
                AdPieLog.e(TAG, e10);
                return false;
            } catch (Exception e11) {
                AdPieLog.e(TAG, e11);
                return false;
            }
        }
    }
}
