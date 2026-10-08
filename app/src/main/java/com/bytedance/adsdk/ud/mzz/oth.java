package com.bytedance.adsdk.ud.mzz;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.bytedance.adsdk.ud.lnr.lnr.mzz;
import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class oth {
    public static com.bytedance.adsdk.ud.lnr.lnr.mzz qdl(com.bytedance.adsdk.ud.wd wdVar) {
        Rect rectMml = wdVar.mml();
        return new com.bytedance.adsdk.ud.lnr.lnr.mzz(Collections.emptyList(), wdVar, "__container", -1L, mzz.qdl.PRE_COMP, -1L, null, Collections.emptyList(), new com.bytedance.adsdk.ud.lnr.qdl.fs(), 0, 0, 0, 0.0f, 0.0f, rectMml.width(), rectMml.height(), null, null, Collections.emptyList(), mzz.ud.NONE, null, false, null, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.adsdk.ud.lnr.lnr.mzz qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar) throws IOException {
        ArrayList arrayList;
        mzz.ud udVar = mzz.ud.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        mzz.ud udVar2 = udVar;
        mzz.qdl qdlVar = null;
        String strNextString = null;
        com.bytedance.adsdk.ud.lnr.qdl.fs fsVarQdl = null;
        com.bytedance.adsdk.ud.lnr.qdl.to toVarMo = null;
        com.bytedance.adsdk.ud.lnr.qdl.rq rqVarQdl = null;
        com.bytedance.adsdk.ud.lnr.qdl.ud udVarQdl = null;
        com.bytedance.adsdk.ud.lnr.ud.qdl qdlVarQdl = null;
        to toVarQdl = null;
        long jNextInt = 0;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        boolean zNextBoolean = false;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fWd = 0.0f;
        long jNextInt2 = -1;
        float fNextDouble4 = 1.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        float fNextDouble5 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (strNextName.equals("parent")) {
                        b = 0;
                    }
                    break;
                case -903568142:
                    if (strNextName.equals("shapes")) {
                        b = 1;
                    }
                    break;
                case 104:
                    if (strNextName.equals("h")) {
                        b = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        b = 3;
                    }
                    break;
                case 119:
                    if (strNextName.equals("w")) {
                        b = 4;
                    }
                    break;
                case 3177:
                    if (strNextName.equals("cl")) {
                        b = 5;
                    }
                    break;
                case 3233:
                    if (strNextName.equals("ef")) {
                        b = 6;
                    }
                    break;
                case 3324:
                    if (strNextName.equals("hd")) {
                        b = 7;
                    }
                    break;
                case 3367:
                    if (strNextName.equals("ip")) {
                        b = 8;
                    }
                    break;
                case 3432:
                    if (strNextName.equals("ks")) {
                        b = 9;
                    }
                    break;
                case 3519:
                    if (strNextName.equals("nm")) {
                        b = 10;
                    }
                    break;
                case 3553:
                    if (strNextName.equals("op")) {
                        b = Ascii.VT;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b = Ascii.FF;
                    }
                    break;
                case 3669:
                    if (strNextName.equals("sh")) {
                        b = Ascii.CR;
                    }
                    break;
                case 3679:
                    if (strNextName.equals("sr")) {
                        b = Ascii.SO;
                    }
                    break;
                case 3681:
                    if (strNextName.equals(UserDataStore.STATE)) {
                        b = Ascii.SI;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b = Ascii.DLE;
                    }
                    break;
                case 3705:
                    if (strNextName.equals("tm")) {
                        b = 17;
                    }
                    break;
                case 3712:
                    if (strNextName.equals(TtmlNode.TAG_TT)) {
                        b = Ascii.DC2;
                    }
                    break;
                case 3717:
                    if (strNextName.equals("ty")) {
                        b = 19;
                    }
                    break;
                case 104415:
                    if (strNextName.equals("ind")) {
                        b = Ascii.DC4;
                    }
                    break;
                case 108390670:
                    if (strNextName.equals("refId")) {
                        b = Ascii.NAK;
                    }
                    break;
                case 1441620890:
                    if (strNextName.equals("masksProperties")) {
                        b = Ascii.SYN;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    jNextInt2 = jsonReader.nextInt();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.ud.lnr.ud.lnr lnrVarQdl = jpc.qdl(jsonReader, wdVar);
                        if (lnrVarQdl != null) {
                            arrayList3.add(lnrVarQdl);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 2:
                    fNextDouble3 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.ud.mo.mo.qdl()));
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                rqVarQdl = ud.qdl(jsonReader, wdVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (strNextName2.equals("d")) {
                            toVarMo = mml.mo(jsonReader, wdVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 4:
                    fNextDouble2 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.ud.mo.mo.qdl()));
                    break;
                case 5:
                    strNextString3 = jsonReader.nextString();
                    break;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("nm")) {
                                arrayList4.add(jsonReader.nextString());
                            } else if (strNextName3.equals("ty")) {
                                int iNextInt3 = jsonReader.nextInt();
                                if (iNextInt3 == 29) {
                                    qdlVarQdl = mzz.qdl(jsonReader, wdVar);
                                } else if (iNextInt3 == 25) {
                                    toVarQdl = new rq().qdl(jsonReader, wdVar);
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    wdVar.qdl("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList4)));
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 8:
                    fNextDouble5 = (float) jsonReader.nextDouble();
                    break;
                case 9:
                    fsVarQdl = lnr.qdl(jsonReader, wdVar);
                    break;
                case 10:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 11:
                    fWd = (float) jsonReader.nextDouble();
                    break;
                case 12:
                    color = Color.parseColor(jsonReader.nextString());
                    break;
                case 13:
                    iNextInt2 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.ud.mo.mo.qdl());
                    break;
                case 14:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    iNextInt = (int) (jsonReader.nextInt() * com.bytedance.adsdk.ud.mo.mo.qdl());
                    break;
                case 17:
                    udVarQdl = mml.qdl(jsonReader, wdVar, false);
                    break;
                case 18:
                    int iNextInt4 = jsonReader.nextInt();
                    if (iNextInt4 >= mzz.ud.values().length) {
                        wdVar.qdl("Unsupported matte type: ".concat(String.valueOf(iNextInt4)));
                    } else {
                        udVar2 = mzz.ud.values()[iNextInt4];
                        int i = AnonymousClass1.qdl[udVar2.ordinal()];
                        if (i == 1) {
                            wdVar.qdl("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            wdVar.qdl("Unsupported matte type: Luma Inverted");
                        }
                        wdVar.qdl(1);
                    }
                    break;
                case 19:
                    int iNextInt5 = jsonReader.nextInt();
                    if (iNextInt5 < mzz.qdl.UNKNOWN.ordinal()) {
                        qdlVar = mzz.qdl.values()[iNextInt5];
                    } else {
                        qdlVar = mzz.qdl.UNKNOWN;
                    }
                    break;
                case 20:
                    jNextInt = jsonReader.nextInt();
                    break;
                case 21:
                    strNextString = jsonReader.nextString();
                    break;
                case 22:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList2.add(bch.qdl(jsonReader, wdVar));
                    }
                    wdVar.qdl(arrayList2.size());
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList5 = new ArrayList();
        if (fNextDouble5 > 0.0f) {
            arrayList = arrayList2;
            arrayList5.add(new com.bytedance.adsdk.ud.wd.qdl(wdVar, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fNextDouble5)));
        } else {
            arrayList = arrayList2;
        }
        if (fWd <= 0.0f) {
            fWd = wdVar.wd();
        }
        arrayList5.add(new com.bytedance.adsdk.ud.wd.qdl(wdVar, fValueOf2, fValueOf2, null, fNextDouble5, Float.valueOf(fWd)));
        arrayList5.add(new com.bytedance.adsdk.ud.wd.qdl(wdVar, fValueOf, fValueOf, null, fWd, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            wdVar.qdl("Convert your Illustrator layers to shape layers.");
        }
        return new com.bytedance.adsdk.ud.lnr.lnr.mzz(arrayList3, wdVar, strNextString2, jNextInt, qdlVar, jNextInt2, strNextString, arrayList, fsVarQdl, iNextInt, iNextInt2, color, fNextDouble4, fNextDouble, fNextDouble2, fNextDouble3, toVarMo, rqVarQdl, arrayList5, udVar2, udVarQdl, zNextBoolean, qdlVarQdl, toVarQdl);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ud.mzz.oth$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] qdl;

        static {
            int[] iArr = new int[mzz.ud.values().length];
            qdl = iArr;
            try {
                iArr[mzz.ud.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                qdl[mzz.ud.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
