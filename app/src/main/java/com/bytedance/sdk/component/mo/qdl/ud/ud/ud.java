package com.bytedance.sdk.component.mo.qdl.ud.ud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.bytedance.sdk.component.mo.qdl.jpc;
import com.bytedance.sdk.component.mo.qdl.mml;
import com.bytedance.sdk.component.mo.qdl.mo;
import com.bytedance.sdk.component.mo.qdl.qdl.qdl.wd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    public static mo qdl;

    public int qdl(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public int qdl(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Cursor qdl(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public Uri qdl(Uri uri, ContentValues contentValues) {
        return null;
    }

    public static mo qdl(Context context) {
        try {
            if (qdl == null) {
                qdl = jpc.wd().jtx().rq();
            }
        } catch (Exception unused) {
        }
        return qdl;
    }

    public static void qdl() {
        if (jpc.wd().mo() == null) {
            return;
        }
        try {
            mo moVarQdl = qdl(jpc.wd().mo());
            if (moVarQdl != null) {
                moVarQdl.qdl(Uri.parse(mml() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void ud() {
        if (jpc.wd().mo() == null) {
            return;
        }
        try {
            mo moVarQdl = qdl(jpc.wd().mo());
            if (moVarQdl != null) {
                moVarQdl.qdl(Uri.parse(mml() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void qdl(com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar) {
        if (qdlVar == null) {
            return;
        }
        try {
            mo moVarQdl = qdl(jpc.wd().mo());
            if (moVarQdl != null) {
                moVarQdl.qdl(Uri.parse(mml() + "adLogDispatch?event=" + com.bytedance.sdk.component.mo.qdl.qdl.qdl.mo.qdl(qdlVar.mo())));
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void qdl(String str, List<String> list, boolean z, int i, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.bytedance.sdk.component.mo.qdl.qdl.qdl.mo.qdl(it.next()));
                sb.append(",");
            }
            String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.component.mo.qdl.qdl.qdl.mo.qdl(sb.toString())) + "&replace=" + String.valueOf(z) + "&urlType=" + String.valueOf(i) + "&adId=" + str2;
            mo moVarQdl = qdl(jpc.wd().mo());
            if (moVarQdl != null) {
                moVarQdl.qdl(Uri.parse(mml() + "trackAdUrl" + str3));
            }
        } catch (Throwable unused) {
        }
    }

    public static void qdl(String str, boolean z) {
        if (jpc.wd().jtx().mo() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        try {
            mo moVarQdl = qdl(jpc.wd().mo());
            if (moVarQdl != null) {
                moVarQdl.qdl(Uri.parse(mml() + "trackAdFailed?did=" + String.valueOf(str) + "&triggerOnInit=" + z));
            }
        } catch (Throwable unused) {
        }
    }

    private static String mml() {
        return wd.ud + "/ad_log_event/";
    }

    public String lnr() {
        return "ad_log_event";
    }

    public String qdl(Uri uri) {
        int i;
        com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVarLnr;
        String str = uri.getPath().split(DomExceptionUtils.SEPARATOR)[2];
        str.hashCode();
        i = 0;
        switch (str) {
            case "trackAdFailed":
                com.bytedance.sdk.component.mo.qdl.mo.qdl.qdl().qdl(uri.getQueryParameter("did"), uri.getBooleanQueryParameter("triggerOnInit", false));
                break;
            case "adLogStart":
                jpc.wd().tvp();
                break;
            case "adLogStop":
                jpc.wd().rq();
                break;
            case "adLogDispatch":
                String queryParameter = uri.getQueryParameter("event");
                if (!TextUtils.isEmpty(queryParameter) && (qdlVarLnr = com.bytedance.sdk.component.mo.qdl.mml.qdl.qdl.lnr(com.bytedance.sdk.component.mo.qdl.qdl.qdl.mo.ud(queryParameter))) != null) {
                    mml.qdl.qdl(qdlVarLnr);
                    break;
                }
                break;
            case "trackAdUrl":
                try {
                    String queryParameter2 = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String queryParameter3 = uri.getQueryParameter("track");
                    String queryParameter4 = uri.getQueryParameter("urlType");
                    String queryParameter5 = uri.getQueryParameter("adId");
                    String[] strArrSplit = com.bytedance.sdk.component.mo.qdl.qdl.qdl.mo.ud(queryParameter3).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strUd = com.bytedance.sdk.component.mo.qdl.qdl.qdl.mo.ud(str2);
                            if (!TextUtils.isEmpty(strUd)) {
                                arrayList.add(strUd);
                            }
                        }
                        try {
                            if (!TextUtils.isEmpty(queryParameter4)) {
                                i = Integer.parseInt(queryParameter4);
                            }
                            break;
                        } catch (Exception unused) {
                        }
                        com.bytedance.sdk.component.mo.qdl.mo.qdl.qdl().qdl(queryParameter2, arrayList, zBooleanValue, null, i, queryParameter5);
                    }
                    break;
                } catch (Throwable unused2) {
                    return null;
                }
                break;
        }
        return null;
    }
}
