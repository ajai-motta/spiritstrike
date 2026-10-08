package com.yasirkula.unity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.webkit.internal.AssetHelper;
import com.adjust.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class NativeShare {
    public static boolean alwaysUseCustomShareDialog;
    public static String authority;
    private static int isXiaomiOrMIUI;
    public static NativeShareResultReceiver shareResultReceiver;

    public static void Share(Context context, NativeShareResultReceiver nativeShareResultReceiver, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String str, String str2, String str3) {
        if (strArr3.length > 0 && GetAuthority(context) == null) {
            Log.e("Unity", "Can't find ContentProvider, share not possible!");
            nativeShareResultReceiver.OnShareCompleted(2, "");
            return;
        }
        shareResultReceiver = nativeShareResultReceiver;
        Bundle bundle = new Bundle();
        bundle.putString(NativeShareFragment.SUBJECT_ID, str);
        bundle.putString(NativeShareFragment.TEXT_ID, str2);
        bundle.putString(NativeShareFragment.TITLE_ID, str3);
        bundle.putStringArrayList(NativeShareFragment.FILES_ID, ConvertArrayToArrayList(strArr3));
        bundle.putStringArrayList(NativeShareFragment.MIMES_ID, ConvertArrayToArrayList(strArr4));
        bundle.putStringArrayList(NativeShareFragment.TARGET_PACKAGE_ID, ConvertArrayToArrayList(strArr));
        bundle.putStringArrayList(NativeShareFragment.TARGET_CLASS_ID, ConvertArrayToArrayList(strArr2));
        boolean z = alwaysUseCustomShareDialog || strArr.length > 1;
        boolean z2 = (!z && nativeShareResultReceiver.HasManagedCallback() && "huawei".equalsIgnoreCase(Build.MANUFACTURER)) ? true : z;
        if ((!z2 && IsXiaomiOrMIUI() && IsUnityInLandscapeMode((Activity) context)) || z2) {
            Log.d("Unity", "Creating custom share dialog");
            Intent intent = new Intent(context, (Class<?>) NativeShareCustomShareDialogActivity.class);
            intent.putExtras(bundle);
            intent.setFlags(1073741824);
            context.startActivity(intent);
            return;
        }
        Log.d("Unity", "Creating standard share dialog");
        NativeShareFragment nativeShareFragment = new NativeShareFragment();
        nativeShareFragment.setArguments(bundle);
        ((Activity) context).getFragmentManager().beginTransaction().add(0, nativeShareFragment).commit();
    }

    public static Intent CreateIntentFromBundle(Context context, Bundle bundle) {
        String str;
        String mimeTypeFromExtension;
        int iIndexOf;
        String string = bundle.getString(NativeShareFragment.SUBJECT_ID);
        String string2 = bundle.getString(NativeShareFragment.TEXT_ID);
        String string3 = bundle.getString(NativeShareFragment.TITLE_ID);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeShareFragment.FILES_ID);
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList(NativeShareFragment.MIMES_ID);
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList(NativeShareFragment.TARGET_PACKAGE_ID);
        ArrayList<String> stringArrayList4 = bundle.getStringArrayList(NativeShareFragment.TARGET_CLASS_ID);
        Intent intent = new Intent();
        if (string.length() > 0) {
            intent.putExtra("android.intent.extra.SUBJECT", string);
        }
        if (string2.length() > 0) {
            intent.putExtra("android.intent.extra.TEXT", string2);
        }
        int i = 1;
        if (stringArrayList.size() > 0) {
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            while (i2 < stringArrayList.size()) {
                if (stringArrayList2.get(i2).length() > 0) {
                    mimeTypeFromExtension = stringArrayList2.get(i2);
                } else {
                    int iLastIndexOf = stringArrayList.get(i2).lastIndexOf(46);
                    if (iLastIndexOf < 0 || iLastIndexOf == stringArrayList.get(i2).length() - i) {
                        str2 = "*";
                        str3 = str2;
                        break;
                    }
                    mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(stringArrayList.get(i2).substring(iLastIndexOf + 1).toLowerCase(Locale.ENGLISH));
                }
                if (mimeTypeFromExtension != null && mimeTypeFromExtension.length() != 0 && (iIndexOf = mimeTypeFromExtension.indexOf(47)) > 0 && iIndexOf != mimeTypeFromExtension.length() - i) {
                    String strSubstring = mimeTypeFromExtension.substring(0, iIndexOf);
                    String strSubstring2 = mimeTypeFromExtension.substring(iIndexOf + 1);
                    if (str2 == null) {
                        str2 = strSubstring;
                    } else if (!str2.equals(strSubstring)) {
                    }
                    if (str3 == null) {
                        str3 = strSubstring2;
                    } else if (!str3.equals(strSubstring2)) {
                        str3 = "*";
                    }
                    i2++;
                    i = 1;
                }
                str2 = "*";
                str3 = str2;
            }
            str = str2 + DomExceptionUtils.SEPARATOR + str3;
            if (stringArrayList.size() == 1) {
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", NativeShareContentProvider.getUriForFile(context, authority, new File(stringArrayList.get(0))));
            } else {
                intent.setAction("android.intent.action.SEND_MULTIPLE");
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(stringArrayList.size());
                for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                    arrayList.add(NativeShareContentProvider.getUriForFile(context, authority, new File(stringArrayList.get(i3))));
                }
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            }
        } else {
            intent.setAction("android.intent.action.SEND");
            str = AssetHelper.DEFAULT_MIME_TYPE;
        }
        if (string3.length() > 0) {
            intent.putExtra("android.intent.extra.TITLE", string3);
        }
        intent.setType(str);
        intent.setFlags(1);
        if (stringArrayList3.size() == 1) {
            intent.setPackage(stringArrayList3.get(0));
            if (stringArrayList4.get(0).length() > 0) {
                intent.setClassName(stringArrayList3.get(0), stringArrayList4.get(0));
            }
        }
        return intent;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        com.yasirkula.unity.NativeShare.authority = r3.authority;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String GetAuthority(android.content.Context r6) {
        /*
            java.lang.String r0 = com.yasirkula.unity.NativeShare.authority
            if (r0 != 0) goto L5a
            android.content.pm.PackageManager r0 = r6.getPackageManager()     // Catch: java.lang.Exception -> L52
            java.lang.String r1 = r6.getPackageName()     // Catch: java.lang.Exception -> L52
            r2 = 8
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch: java.lang.Exception -> L52
            android.content.pm.ProviderInfo[] r0 = r0.providers     // Catch: java.lang.Exception -> L52
            if (r0 == 0) goto L5a
            int r1 = r0.length     // Catch: java.lang.Exception -> L52
            r2 = 0
        L18:
            if (r2 >= r1) goto L5a
            r3 = r0[r2]     // Catch: java.lang.Exception -> L52
            java.lang.String r4 = r3.name     // Catch: java.lang.Exception -> L52
            if (r4 == 0) goto L4f
            java.lang.String r4 = r3.packageName     // Catch: java.lang.Exception -> L52
            if (r4 == 0) goto L4f
            java.lang.String r4 = r3.authority     // Catch: java.lang.Exception -> L52
            if (r4 == 0) goto L4f
            java.lang.String r4 = r3.name     // Catch: java.lang.Exception -> L52
            java.lang.Class<com.yasirkula.unity.NativeShareContentProvider> r5 = com.yasirkula.unity.NativeShareContentProvider.class
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Exception -> L52
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Exception -> L52
            if (r4 == 0) goto L4f
            java.lang.String r4 = r3.packageName     // Catch: java.lang.Exception -> L52
            java.lang.String r5 = r6.getPackageName()     // Catch: java.lang.Exception -> L52
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Exception -> L52
            if (r4 == 0) goto L4f
            java.lang.String r4 = r3.authority     // Catch: java.lang.Exception -> L52
            int r4 = r4.length()     // Catch: java.lang.Exception -> L52
            if (r4 <= 0) goto L4f
            java.lang.String r6 = r3.authority     // Catch: java.lang.Exception -> L52
            com.yasirkula.unity.NativeShare.authority = r6     // Catch: java.lang.Exception -> L52
            goto L5a
        L4f:
            int r2 = r2 + 1
            goto L18
        L52:
            r6 = move-exception
            java.lang.String r0 = "Unity"
            java.lang.String r1 = "Exception:"
            android.util.Log.e(r0, r1, r6)
        L5a:
            java.lang.String r6 = com.yasirkula.unity.NativeShare.authority
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yasirkula.unity.NativeShare.GetAuthority(android.content.Context):java.lang.String");
    }

    private static ArrayList<String> ConvertArrayToArrayList(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>(strArr.length);
        for (String str : strArr) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private static boolean IsUnityInLandscapeMode(Activity activity) {
        return activity.getResources().getConfiguration().orientation == 2;
    }

    private static boolean IsXiaomiOrMIUI() throws Throwable {
        int i = isXiaomiOrMIUI;
        if (i > 0) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        if (Constants.REFERRER_API_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
            isXiaomiOrMIUI = 1;
            return true;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null && line.length() > 0) {
                        isXiaomiOrMIUI = 1;
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused) {
                        }
                        return true;
                    }
                    isXiaomiOrMIUI = -1;
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused2) {
                    }
                    return false;
                } catch (Exception unused3) {
                    bufferedReader = bufferedReader2;
                    isXiaomiOrMIUI = -1;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused6) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean TargetExists(Context context, String str, String str2) {
        if (str2.length() == 0) {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        }
        ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(str, 1).activities;
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (activityInfo.name.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String FindMatchingTarget(Context context, String str, String str2) {
        ActivityInfo[] activityInfoArr;
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(1);
        if (installedPackages != null) {
            Pattern patternCompile = Pattern.compile(str);
            Pattern patternCompile2 = str2.length() > 0 ? Pattern.compile(str2) : null;
            for (PackageInfo packageInfo : installedPackages) {
                if (patternCompile.matcher(packageInfo.packageName).find() && (activityInfoArr = packageInfo.activities) != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        if (patternCompile2 == null || patternCompile2.matcher(activityInfo.name).find()) {
                            return packageInfo.packageName + ">" + activityInfo.name;
                        }
                    }
                }
            }
            return "";
        }
        return "";
    }
}
