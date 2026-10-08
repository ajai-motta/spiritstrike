package com.bytedance.adsdk.qdl;

import android.text.TextUtils;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.common.base.Ascii;
import io.ktor.http.ContentDisposition;

/* JADX INFO: loaded from: classes.dex */
public class jtx {
    public static Object qdl(com.bytedance.adsdk.qdl.ud.qdl.qdl qdlVar) {
        tvp tvpVarQdl;
        if (qdlVar == null || (tvpVarQdl = qdl(qdlVar.qdl())) == null) {
            return null;
        }
        return tvpVarQdl.qdl(null, qdlVar.ud());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static tvp qdl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1919300188:
                if (str.equals("toNumber")) {
                    b = 0;
                }
                break;
            case -1776922004:
                if (str.equals(InAppPurchaseConstants.METHOD_TO_STRING)) {
                    b = 1;
                }
                break;
            case -1368121510:
                if (str.equals("formatDecimal")) {
                    b = 2;
                }
                break;
            case -652088201:
                if (str.equals("modArray")) {
                    b = 3;
                }
                break;
            case 3143097:
                if (str.equals("find")) {
                    b = 4;
                }
                break;
            case 3530753:
                if (str.equals(ContentDisposition.Parameters.Size)) {
                    b = 5;
                }
                break;
            case 94642797:
                if (str.equals("chunk")) {
                    b = 6;
                }
                break;
            case 96955127:
                if (str.equals("exist")) {
                    b = 7;
                }
                break;
            case 109648666:
                if (str.equals("split")) {
                    b = 8;
                }
                break;
            case 515198113:
                if (str.equals("decodeUrl")) {
                    b = 9;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b = 10;
                }
                break;
            case 1508134777:
                if (str.equals("encodeUrl")) {
                    b = Ascii.VT;
                }
                break;
            case 2056988195:
                if (str.equals("isDigit")) {
                    b = Ascii.FF;
                }
                break;
        }
        switch (b) {
            case 0:
                return new exu();
            case 1:
                return new rdp();
            case 2:
                return new wd();
            case 3:
                return new to();
            case 4:
                return new mo();
            case 5:
                return new rq();
            case 6:
                return new qdl();
            case 7:
                return new mzz();
            case 8:
                return new fs();
            case 9:
                return new ud();
            case 10:
                return new bjy();
            case 11:
                return new mml();
            case 12:
                return new jpc();
            default:
                return null;
        }
    }
}
