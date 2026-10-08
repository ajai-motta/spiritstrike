package com.bytedance.sdk.openadsdk.core.fs.qdl.qdl;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.core.fs.lnr.qdl;
import com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.mzz;
import com.bytedance.sdk.openadsdk.core.fs.ud.lnr;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    public static void qdl(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.fs.qdl qdlVar, int i, double d) throws XmlPullParserException, IOException {
        boolean z = false;
        while (true) {
            if (xmlPullParser.next() != 3 || !xmlPullParser.getName().equals(k.q)) {
                if (xmlPullParser.getEventType() == 2) {
                    if (z && TextUtils.isEmpty(qdlVar.wd())) {
                        mzz.qdl(xmlPullParser);
                    }
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    switch (name) {
                        case "VideoClicks":
                            qdl(xmlPullParser, qdlVar);
                            break;
                        case "Duration":
                            qdlVar.qdl(ud(xmlPullParser));
                            break;
                        case "MediaFiles":
                            qdl(xmlPullParser, i, d, qdlVar);
                            z = true;
                            break;
                        case "Icons":
                            com.bytedance.sdk.openadsdk.core.fs.ud udVarQdl = qdl(xmlPullParser);
                            if (udVarQdl != null && qdlVar.ud() == null) {
                                qdlVar.qdl(udVarQdl);
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "TrackingEvents":
                            qdl(xmlPullParser, qdlVar.qdl());
                            break;
                        default:
                            mzz.qdl(xmlPullParser);
                            break;
                    }
                }
            } else {
                return;
            }
        }
    }

    private static String qdl(XmlPullParser xmlPullParser, int i, double d, com.bytedance.sdk.openadsdk.core.fs.qdl qdlVar) throws XmlPullParserException, IOException {
        double d2 = Double.NEGATIVE_INFINITY;
        String str = null;
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MIN_VALUE;
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals(k.t)) {
                break;
            }
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals(k.u)) {
                String attributeValue = xmlPullParser.getAttributeValue(mzz.wd, "type");
                int iUd = mzz.ud(xmlPullParser.getAttributeValue(mzz.wd, ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                int iUd2 = mzz.ud(xmlPullParser.getAttributeValue(mzz.wd, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                int iUd3 = mzz.ud(xmlPullParser.getAttributeValue(mzz.wd, "bitrate"));
                String strUd = mzz.ud(xmlPullParser, k.u);
                if (iUd > 0 && iUd2 > 0 && com.bytedance.sdk.openadsdk.core.fs.lnr.mml.qdl.contains(attributeValue) && !TextUtils.isEmpty(strUd)) {
                    double dQdl = com.bytedance.sdk.openadsdk.core.fs.lnr.mml.qdl(i, d, iUd, iUd2, iUd3, attributeValue);
                    if (dQdl > d2) {
                        str = strUd;
                        i2 = iUd;
                        d2 = dQdl;
                        i3 = iUd2;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            qdlVar.mml(str);
            qdlVar.qdl(i2);
            qdlVar.ud(i3);
        }
        return str;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.sdk.openadsdk.core.fs.ud qdl(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        com.bytedance.sdk.openadsdk.core.fs.ud udVar;
        com.bytedance.sdk.openadsdk.core.fs.ud udVar2;
        int i;
        ArrayList arrayList;
        int i2;
        int i3;
        int i4;
        qdl.EnumC0233qdl enumC0233qdl;
        byte b;
        com.bytedance.sdk.openadsdk.core.fs.ud udVar3 = null;
        while (true) {
            int i5 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals(k.B)) {
                return udVar3;
            }
            xmlPullParser.next();
            int i6 = 2;
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals(k.C)) {
                int iUd = mzz.ud(xmlPullParser.getAttributeValue(mzz.wd, ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                int iUd2 = mzz.ud(xmlPullParser.getAttributeValue(mzz.wd, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                if (iUd <= 0 || iUd > 300 || iUd2 <= 0 || iUd2 > 300) {
                    udVar = udVar3;
                    mzz.qdl(xmlPullParser);
                    udVar3 = udVar;
                } else {
                    int iQdl = com.bytedance.sdk.openadsdk.core.fs.ud.qdl.qdl(xmlPullParser.getAttributeValue(mzz.wd, TypedValues.CycleType.S_WAVE_OFFSET));
                    int iQdl2 = com.bytedance.sdk.openadsdk.core.fs.ud.qdl.qdl(xmlPullParser.getAttributeValue(mzz.wd, TypedValues.TransitionType.S_DURATION));
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    mzz.qdl qdlVar = null;
                    String strUd = null;
                    while (true) {
                        if (xmlPullParser.next() != i5 || !xmlPullParser.getName().equals(k.C)) {
                            ArrayList arrayList4 = arrayList3;
                            ArrayList arrayList5 = arrayList2;
                            if (xmlPullParser.getEventType() == i6) {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                udVar2 = udVar3;
                                byte b2 = -1;
                                switch (name.hashCode()) {
                                    case -1044238411:
                                        if (name.equals(k.J)) {
                                            b = 0;
                                            b2 = b;
                                        }
                                        break;
                                    case -375340334:
                                        if (name.equals(k.E)) {
                                            b = 1;
                                            b2 = b;
                                        }
                                        break;
                                    case 676623548:
                                        if (name.equals(k.D)) {
                                            b2 = 2;
                                        }
                                        break;
                                    case 1030746596:
                                        if (name.equals(k.G)) {
                                            b2 = 3;
                                        }
                                        break;
                                    case 1928285401:
                                        if (name.equals(k.F)) {
                                            b = 4;
                                            b2 = b;
                                        }
                                        break;
                                }
                                switch (b2) {
                                    case 0:
                                        i2 = 3;
                                        i = 2;
                                        arrayList = arrayList4;
                                        arrayList.add(new lnr.qdl(mzz.ud(xmlPullParser, k.J)).qdl());
                                        break;
                                    case 1:
                                        i3 = 3;
                                        i4 = 2;
                                        if (qdlVar == null) {
                                            qdlVar = new mzz.qdl(mzz.ud(xmlPullParser, k.E), qdl.EnumC0233qdl.NONE, qdl.ud.IFRAME_RESOURCE);
                                        } else {
                                            mzz.qdl(xmlPullParser);
                                        }
                                        arrayList2 = arrayList5;
                                        i5 = i3;
                                        i6 = i4;
                                        udVar3 = udVar2;
                                        arrayList3 = arrayList4;
                                        break;
                                    case 2:
                                        i3 = 3;
                                        i4 = 2;
                                        qdl.EnumC0233qdl enumC0233qdl2 = qdl.EnumC0233qdl.NONE;
                                        String lowerCase = xmlPullParser.getAttributeValue(mzz.wd, "creativeType").toLowerCase();
                                        String strUd2 = (com.bytedance.sdk.openadsdk.core.fs.lnr.qdl.qdl.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.fs.lnr.qdl.ud.contains(lowerCase)) ? mzz.ud(xmlPullParser, k.D) : null;
                                        if (com.bytedance.sdk.openadsdk.core.fs.lnr.qdl.qdl.contains(lowerCase)) {
                                            enumC0233qdl = qdl.EnumC0233qdl.IMAGE;
                                        } else {
                                            enumC0233qdl = qdl.EnumC0233qdl.JAVASCRIPT;
                                        }
                                        qdlVar = new mzz.qdl(strUd2, enumC0233qdl, qdl.ud.STATIC_RESOURCE);
                                        arrayList2 = arrayList5;
                                        i5 = i3;
                                        i6 = i4;
                                        udVar3 = udVar2;
                                        arrayList3 = arrayList4;
                                        break;
                                    case 3:
                                        while (true) {
                                            i3 = 3;
                                            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals(k.G)) {
                                                i4 = 2;
                                                arrayList2 = arrayList5;
                                                i5 = i3;
                                                i6 = i4;
                                                udVar3 = udVar2;
                                                arrayList3 = arrayList4;
                                                break;
                                            } else if (xmlPullParser.getEventType() == 2) {
                                                if (xmlPullParser.getName().equals(k.H)) {
                                                    strUd = mzz.ud(xmlPullParser, k.H);
                                                } else if (xmlPullParser.getName().equals(k.I)) {
                                                    arrayList5.add(new lnr.qdl(mzz.ud(xmlPullParser, k.I)).qdl());
                                                }
                                            }
                                        }
                                        break;
                                    case 4:
                                        if (qdlVar == null || qdlVar.lnr == qdl.ud.IFRAME_RESOURCE) {
                                            qdlVar = new mzz.qdl(mzz.ud(xmlPullParser, k.F), qdl.EnumC0233qdl.NONE, qdl.ud.HTML_RESOURCE);
                                            arrayList2 = arrayList5;
                                            udVar3 = udVar2;
                                            arrayList3 = arrayList4;
                                            i5 = 3;
                                            i6 = 2;
                                        } else {
                                            i3 = 3;
                                            i4 = 2;
                                            mzz.qdl(xmlPullParser);
                                            arrayList2 = arrayList5;
                                            i5 = i3;
                                            i6 = i4;
                                            udVar3 = udVar2;
                                            arrayList3 = arrayList4;
                                        }
                                        break;
                                    default:
                                        i3 = 3;
                                        i4 = 2;
                                        mzz.qdl(xmlPullParser);
                                        arrayList2 = arrayList5;
                                        i5 = i3;
                                        i6 = i4;
                                        udVar3 = udVar2;
                                        arrayList3 = arrayList4;
                                        break;
                                }
                            } else {
                                udVar2 = udVar3;
                                i = i6;
                                arrayList = arrayList4;
                                i2 = 3;
                            }
                            arrayList2 = arrayList5;
                            i5 = i2;
                            i6 = i;
                            arrayList3 = arrayList;
                            udVar3 = udVar2;
                        } else if (qdlVar != null && (udVar3 == null || TextUtils.isEmpty(udVar3.mo()))) {
                            udVar3 = new com.bytedance.sdk.openadsdk.core.fs.ud(iUd, iUd2, iQdl, iQdl2, qdlVar.ud, qdlVar.lnr, qdlVar.qdl, arrayList2, arrayList3, strUd);
                            mzz.qdl(xmlPullParser, k.B, 3);
                        }
                    }
                }
            } else {
                udVar = udVar3;
                udVar3 = udVar;
            }
        }
    }

    public static double ud(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (mzz.ud(xmlPullParser, k.s).split(":").length != 3) {
            return 0.0d;
        }
        try {
            return (Integer.parseInt(r2[0].trim()) * 3600) + (Integer.parseInt(r2[1].trim()) * 60) + Float.parseFloat(r2[2].trim());
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void qdl(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.fs.mml mmlVar) throws XmlPullParserException, IOException {
        while (true) {
            byte b = 3;
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals(k.v)) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                if (k.w.equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(mzz.wd, "event");
                    if (TextUtils.isEmpty(attributeValue)) {
                        mzz.qdl(xmlPullParser, k.w, 3);
                    } else {
                        attributeValue.hashCode();
                        switch (attributeValue.hashCode()) {
                            case -1638835128:
                                b = !attributeValue.equals("midpoint") ? (byte) -1 : (byte) 0;
                                break;
                            case -1337830390:
                                b = !attributeValue.equals("thirdQuartile") ? (byte) -1 : (byte) 1;
                                break;
                            case -934426579:
                                b = !attributeValue.equals("resume") ? (byte) -1 : (byte) 2;
                                break;
                            case -840405966:
                                if (!attributeValue.equals("unmute")) {
                                    b = -1;
                                }
                                break;
                            case -599445191:
                                b = !attributeValue.equals("complete") ? (byte) -1 : (byte) 4;
                                break;
                            case 3363353:
                                b = !attributeValue.equals("mute") ? (byte) -1 : (byte) 5;
                                break;
                            case 3532159:
                                b = !attributeValue.equals("skip") ? (byte) -1 : (byte) 6;
                                break;
                            case 94756344:
                                b = !attributeValue.equals("close") ? (byte) -1 : (byte) 7;
                                break;
                            case 106440182:
                                b = !attributeValue.equals("pause") ? (byte) -1 : (byte) 8;
                                break;
                            case 109757538:
                                b = !attributeValue.equals(TtmlNode.START) ? (byte) -1 : (byte) 9;
                                break;
                            case 560220243:
                                b = !attributeValue.equals("firstQuartile") ? (byte) -1 : (byte) 10;
                                break;
                            case 1778167540:
                                b = !attributeValue.equals("creativeView") ? (byte) -1 : Ascii.VT;
                                break;
                            default:
                                b = -1;
                                break;
                        }
                        switch (b) {
                            case 0:
                                mmlVar.qdl(mzz.ud(xmlPullParser, k.w), 0.5f);
                                break;
                            case 1:
                                mmlVar.qdl(mzz.ud(xmlPullParser, k.w), 0.75f);
                                break;
                            case 2:
                                mmlVar.lnr(qdl(xmlPullParser, true));
                                break;
                            case 3:
                                mmlVar.fs(qdl(xmlPullParser, true));
                                break;
                            case 4:
                                mmlVar.mml(lnr(xmlPullParser));
                                break;
                            case 5:
                                mmlVar.rq(qdl(xmlPullParser, true));
                                break;
                            case 6:
                                mmlVar.mo(lnr(xmlPullParser));
                                break;
                            case 7:
                                mmlVar.mzz(lnr(xmlPullParser));
                                break;
                            case 8:
                                mmlVar.ud(qdl(xmlPullParser, true));
                                break;
                            case 9:
                            case 11:
                                mmlVar.qdl(mzz.ud(xmlPullParser, k.w), 0L);
                                break;
                            case 10:
                                mmlVar.qdl(mzz.ud(xmlPullParser, k.w), 0.25f);
                                break;
                        }
                    }
                } else if (xmlPullParser.getEventType() == 4) {
                    xmlPullParser.nextTag();
                } else {
                    mzz.qdl(xmlPullParser);
                }
            }
        }
    }

    private static void qdl(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.fs.qdl qdlVar) throws XmlPullParserException, IOException {
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals(k.x)) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(k.y)) {
                    qdlVar.lnr(mzz.ud(xmlPullParser, k.y));
                } else if (name.equals(k.z)) {
                    qdlVar.qdl().wd(mzz.qdl(xmlPullParser, k.z));
                } else {
                    mzz.qdl(xmlPullParser);
                }
            }
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> lnr(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return qdl(xmlPullParser, false);
    }

    private static List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> qdl(XmlPullParser xmlPullParser, boolean z) throws XmlPullParserException, IOException {
        return mzz.qdl(xmlPullParser, k.w, z);
    }
}
