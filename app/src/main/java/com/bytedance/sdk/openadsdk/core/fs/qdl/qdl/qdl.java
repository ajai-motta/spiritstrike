package com.bytedance.sdk.openadsdk.core.fs.qdl.qdl;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.core.fs.lnr.qdl;
import com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.mzz;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    /* JADX WARN: Failed to find 'out' block for switch in B:63:0x0121. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.sdk.openadsdk.core.fs.lnr qdl(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        com.bytedance.sdk.openadsdk.core.fs.lnr lnrVar;
        mzz.qdl qdlVar;
        int i;
        qdl.EnumC0233qdl enumC0233qdl;
        int i2;
        int i3;
        byte b;
        if (context == null) {
            mzz.qdl(xmlPullParser);
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        int i6 = (int) (i4 / displayMetrics.density);
        int i7 = (int) (i5 / displayMetrics.density);
        float f = Float.MIN_VALUE;
        com.bytedance.sdk.openadsdk.core.fs.lnr lnrVar2 = null;
        while (true) {
            int i8 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals(k.L)) {
                return lnrVar2;
            }
            xmlPullParser.next();
            int i9 = 2;
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                String str = k.M;
                if (name.equals(k.M)) {
                    int iUd = mzz.ud(xmlPullParser.getAttributeValue(mzz.wd, ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                    int iUd2 = mzz.ud(xmlPullParser.getAttributeValue(mzz.wd, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                    if (iUd < 300 || iUd2 < 250) {
                        lnrVar = lnrVar2;
                        mzz.qdl(xmlPullParser);
                        lnrVar2 = lnrVar;
                    } else {
                        mzz.qdl qdlVar2 = new mzz.qdl();
                        while (true) {
                            if (xmlPullParser.getEventType() != i8 || !xmlPullParser.getName().equals(str)) {
                                xmlPullParser.next();
                                if (xmlPullParser.getEventType() == i9) {
                                    String name2 = xmlPullParser.getName();
                                    name2.hashCode();
                                    com.bytedance.sdk.openadsdk.core.fs.lnr lnrVar3 = lnrVar2;
                                    String str2 = str;
                                    byte b2 = -1;
                                    switch (name2.hashCode()) {
                                        case -375340334:
                                            if (name2.equals(k.E)) {
                                                b = 0;
                                                b2 = b;
                                            }
                                            break;
                                        case -348198615:
                                            if (name2.equals(k.N)) {
                                                b = 1;
                                                b2 = b;
                                            }
                                            break;
                                        case 611554000:
                                            if (name2.equals(k.v)) {
                                                b2 = 2;
                                            }
                                            break;
                                        case 676623548:
                                            if (name2.equals(k.D)) {
                                                b2 = 3;
                                            }
                                            break;
                                        case 1877773523:
                                            if (name2.equals(k.O)) {
                                                b = 4;
                                                b2 = b;
                                            }
                                            break;
                                        case 1928285401:
                                            if (name2.equals(k.F)) {
                                                b = 5;
                                                b2 = b;
                                            }
                                            break;
                                    }
                                    switch (b2) {
                                        case 0:
                                            mzz.qdl qdlVar3 = qdlVar2;
                                            int i10 = iUd2;
                                            int i11 = iUd;
                                            Point pointQdl = com.bytedance.sdk.openadsdk.core.fs.lnr.qdl.qdl(context, i11, i10, qdl.ud.HTML_RESOURCE);
                                            float fQdl = com.bytedance.sdk.openadsdk.core.fs.lnr.qdl(i6, i7, pointQdl.x, pointQdl.y, qdl.ud.IFRAME_RESOURCE, qdl.EnumC0233qdl.NONE);
                                            String strUd = mzz.ud(xmlPullParser, k.E);
                                            if (TextUtils.isEmpty(strUd) || fQdl <= qdlVar3.wd || fQdl <= f) {
                                                i2 = 3;
                                                mzz.qdl(xmlPullParser, k.E, 3);
                                                qdlVar2 = qdlVar3;
                                                iUd2 = i10;
                                                iUd = i11;
                                                i9 = 2;
                                                lnrVar2 = lnrVar3;
                                                str = str2;
                                                i8 = i2;
                                            } else {
                                                qdlVar3.wd = fQdl;
                                                qdlVar3.qdl(strUd, qdl.EnumC0233qdl.NONE, qdl.ud.IFRAME_RESOURCE);
                                                qdlVar2 = qdlVar3;
                                                iUd2 = i10;
                                                iUd = i11;
                                                i9 = 2;
                                                lnrVar2 = lnrVar3;
                                                str = str2;
                                                i8 = 3;
                                            }
                                            break;
                                        case 1:
                                            qdlVar2.mml = mzz.ud(xmlPullParser, k.N);
                                            i9 = 2;
                                            iUd = iUd;
                                            lnrVar2 = lnrVar3;
                                            str = str2;
                                            i8 = 3;
                                            break;
                                        case 2:
                                            qdlVar = qdlVar2;
                                            i3 = iUd2;
                                            i = iUd;
                                            while (true) {
                                                if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals(k.v)) {
                                                    iUd2 = i3;
                                                    iUd = i;
                                                    qdlVar2 = qdlVar;
                                                    lnrVar2 = lnrVar3;
                                                    str = str2;
                                                    i8 = 3;
                                                    i9 = 2;
                                                    break;
                                                } else if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals(k.w)) {
                                                    qdlVar.ud(mzz.ud(xmlPullParser, k.w));
                                                }
                                            }
                                            break;
                                        case 3:
                                            qdlVar = qdlVar2;
                                            int i12 = iUd2;
                                            i = iUd;
                                            qdl.EnumC0233qdl enumC0233qdl2 = qdl.EnumC0233qdl.NONE;
                                            String lowerCase = xmlPullParser.getAttributeValue(mzz.wd, "creativeType").toLowerCase();
                                            if (com.bytedance.sdk.openadsdk.core.fs.lnr.qdl.qdl.contains(lowerCase)) {
                                                enumC0233qdl = qdl.EnumC0233qdl.IMAGE;
                                            } else {
                                                enumC0233qdl = qdl.EnumC0233qdl.JAVASCRIPT;
                                            }
                                            qdl.EnumC0233qdl enumC0233qdl3 = enumC0233qdl;
                                            Point pointQdl2 = com.bytedance.sdk.openadsdk.core.fs.lnr.qdl.qdl(context, i, i12, qdl.ud.STATIC_RESOURCE);
                                            float fQdl2 = com.bytedance.sdk.openadsdk.core.fs.lnr.qdl(i6, i7, pointQdl2.x, pointQdl2.y, qdl.ud.STATIC_RESOURCE, enumC0233qdl3);
                                            String strUd2 = (com.bytedance.sdk.openadsdk.core.fs.lnr.qdl.qdl.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.fs.lnr.qdl.ud.contains(lowerCase)) ? mzz.ud(xmlPullParser, k.D) : null;
                                            if (fQdl2 < qdlVar.wd || fQdl2 <= f || TextUtils.isEmpty(strUd2)) {
                                                i2 = 3;
                                                mzz.qdl(xmlPullParser, k.D, 3);
                                                iUd2 = i12;
                                                iUd = i;
                                                qdlVar2 = qdlVar;
                                                lnrVar2 = lnrVar3;
                                                str = str2;
                                                i9 = 2;
                                                i8 = i2;
                                            } else {
                                                qdlVar.wd = fQdl2;
                                                qdlVar.qdl(strUd2, enumC0233qdl3, qdl.ud.STATIC_RESOURCE);
                                                iUd2 = i12;
                                                iUd = i;
                                                qdlVar2 = qdlVar;
                                                lnrVar2 = lnrVar3;
                                                str = str2;
                                                i8 = 3;
                                                i9 = 2;
                                            }
                                            break;
                                        case 4:
                                            qdlVar2.qdl(mzz.ud(xmlPullParser, k.O));
                                            lnrVar2 = lnrVar3;
                                            str = str2;
                                            i8 = 3;
                                            i9 = 2;
                                            break;
                                        case 5:
                                            Point pointQdl3 = com.bytedance.sdk.openadsdk.core.fs.lnr.qdl.qdl(context, iUd, iUd2, qdl.ud.HTML_RESOURCE);
                                            qdlVar = qdlVar2;
                                            int i13 = iUd2;
                                            int i14 = iUd;
                                            float fQdl3 = com.bytedance.sdk.openadsdk.core.fs.lnr.qdl(i6, i7, pointQdl3.x, pointQdl3.y, qdl.ud.HTML_RESOURCE, qdl.EnumC0233qdl.NONE);
                                            String strUd3 = mzz.ud(xmlPullParser, k.F);
                                            if (TextUtils.isEmpty(strUd3) || fQdl3 <= qdlVar.wd || fQdl3 <= f) {
                                                mzz.qdl(xmlPullParser, k.F, 3);
                                                iUd2 = i13;
                                                i8 = 3;
                                                iUd = i14;
                                                qdlVar2 = qdlVar;
                                                lnrVar2 = lnrVar3;
                                                str = str2;
                                                i9 = 2;
                                            } else {
                                                qdlVar.wd = fQdl3;
                                                qdlVar.qdl(strUd3, qdl.EnumC0233qdl.NONE, qdl.ud.HTML_RESOURCE);
                                                iUd2 = i13;
                                                iUd = i14;
                                                qdlVar2 = qdlVar;
                                                lnrVar2 = lnrVar3;
                                                str = str2;
                                                i8 = 3;
                                                i9 = 2;
                                            }
                                            break;
                                        default:
                                            mzz.qdl(xmlPullParser);
                                            qdlVar = qdlVar2;
                                            i3 = iUd2;
                                            i = iUd;
                                            iUd2 = i3;
                                            iUd = i;
                                            qdlVar2 = qdlVar;
                                            lnrVar2 = lnrVar3;
                                            str = str2;
                                            i8 = 3;
                                            i9 = 2;
                                            break;
                                    }
                                }
                            } else if (!TextUtils.isEmpty(qdlVar2.qdl) && qdlVar2.wd >= f) {
                                lnrVar2 = new com.bytedance.sdk.openadsdk.core.fs.lnr(iUd, iUd2, qdlVar2.ud, qdlVar2.lnr, qdlVar2.qdl, qdlVar2.mzz, qdlVar2.mo, qdlVar2.mml);
                                f = qdlVar2.wd;
                            }
                        }
                    }
                }
            }
            lnrVar = lnrVar2;
            lnrVar2 = lnrVar;
        }
    }
}
