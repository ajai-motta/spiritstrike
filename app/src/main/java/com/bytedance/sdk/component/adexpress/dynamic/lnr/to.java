package com.bytedance.sdk.component.adexpress.dynamic.lnr;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class to {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static wd qdl(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz mzzVar, com.bytedance.sdk.component.adexpress.dynamic.mml.wd wdVar, com.bytedance.sdk.component.adexpress.dynamic.mml.to toVar, com.bytedance.sdk.component.adexpress.ud.exu exuVar) {
        if (context == null || mzzVar == null || wdVar == null) {
            return null;
        }
        String strWc = wdVar.wc();
        String strBch = exuVar.bch();
        strWc.hashCode();
        byte b = -1;
        switch (strWc.hashCode()) {
            case 48:
                if (strWc.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    b = 0;
                }
                break;
            case 49:
                if (strWc.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (strWc.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (strWc.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (strWc.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (strWc.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (strWc.equals("8")) {
                    b = 6;
                }
                break;
            case 57:
                if (strWc.equals("9")) {
                    b = 7;
                }
                break;
            case 1567:
                if (strWc.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (strWc.equals("11")) {
                    b = 9;
                }
                break;
            case 1569:
                if (strWc.equals("12")) {
                    b = 10;
                }
                break;
            case 1570:
                if (strWc.equals("13")) {
                    b = Ascii.VT;
                }
                break;
            case 1571:
                if (strWc.equals("14")) {
                    b = Ascii.FF;
                }
                break;
            case 1573:
                if (strWc.equals("16")) {
                    b = Ascii.CR;
                }
                break;
            case 1574:
                if (strWc.equals("17")) {
                    b = Ascii.SO;
                }
                break;
            case 1575:
                if (strWc.equals("18")) {
                    b = Ascii.SI;
                }
                break;
            case 1598:
                if (strWc.equals("20")) {
                    b = Ascii.DLE;
                }
                break;
            case 1600:
                if (strWc.equals("22")) {
                    b = 17;
                }
                break;
            case 1601:
                if (strWc.equals("23")) {
                    b = Ascii.DC2;
                }
                break;
            case 1602:
                if (strWc.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (strWc.equals("25")) {
                    b = Ascii.DC4;
                }
                break;
            case 1607:
                if (strWc.equals("29")) {
                    b = Ascii.NAK;
                }
                break;
        }
        switch (b) {
            case 0:
                return new mzz(context, mzzVar, wdVar);
            case 1:
                return new lnr(context, mzzVar, wdVar);
            case 2:
                return new ud(context, mzzVar, wdVar);
            case 3:
                if (wdVar.cx() == 1) {
                    return new yt(context, mzzVar, wdVar, wdVar.mlb());
                }
                return new jtx(context, mzzVar, wdVar);
            case 4:
            case 9:
                return new rdp(context, mzzVar, wdVar);
            case 5:
            case 12:
                return new fs(context, mzzVar, wdVar);
            case 6:
                return new exu(context, mzzVar, wdVar);
            case 7:
            case 13:
                return new bjy(context, mzzVar, wdVar, strWc, toVar.qdl(), toVar.ud(), toVar.mml(), toVar.wd());
            case 8:
                return new mml(context, mzzVar, wdVar);
            case 10:
                return new jtx(context, mzzVar, wdVar);
            case 11:
                return new yt(context, mzzVar, wdVar);
            case 14:
            case 15:
                return new exc(context, mzzVar, wdVar, strWc, toVar);
            case 16:
                if (com.bytedance.sdk.component.adexpress.mml.ud()) {
                    return new rq(context, mzzVar, wdVar, strBch + "static/lotties/glass-swipe/glass-swipe.json", "20");
                }
                return new rq(context, mzzVar, wdVar, TextUtils.isEmpty(strBch) ? null : strBch + "brush_mask.json", "20");
            case 17:
                if (com.bytedance.sdk.component.adexpress.mml.ud()) {
                    return new rq(context, mzzVar, wdVar, strBch + "static/lotties/202327swiper-up-star/index.json", "22");
                }
                return new jl(context, mzzVar, wdVar);
            case 18:
                if (!com.bytedance.sdk.component.adexpress.mml.ud()) {
                    return null;
                }
                return new rq(context, mzzVar, wdVar, strBch + "static/lotties/202327swiper-up-star/click.json", "23");
            case 19:
                if (com.bytedance.sdk.component.adexpress.mml.ud()) {
                    return new qdl(context, mzzVar, wdVar);
                }
                return new rq(context, mzzVar, wdVar, TextUtils.isEmpty(strBch) ? null : strBch + "swiper_up_star.json", "24");
            case 20:
                if (!com.bytedance.sdk.component.adexpress.mml.ud()) {
                    return null;
                }
                return new rq(context, mzzVar, wdVar, strBch + "static/lotties/gesture-slide.json", "25");
            case 21:
                return new mo(context, mzzVar, wdVar, toVar.qdl(), toVar.ud(), toVar.mml(), toVar.wd());
            default:
                return null;
        }
    }
}
