package com.bytedance.adsdk.ud.mzz;

import android.util.JsonReader;
import com.bytedance.adsdk.ud.lnr.ud.jl;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
class yt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static com.bytedance.adsdk.ud.lnr.ud.mo qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar) throws IOException {
        byte b;
        jl.qdl qdlVar;
        jl.ud udVar;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.bytedance.adsdk.ud.lnr.ud.wd wdVar2 = null;
        com.bytedance.adsdk.ud.lnr.qdl.lnr lnrVarQdl = null;
        com.bytedance.adsdk.ud.lnr.qdl.mo moVarLnr = null;
        com.bytedance.adsdk.ud.lnr.qdl.mo moVarLnr2 = null;
        com.bytedance.adsdk.ud.lnr.qdl.ud udVarQdl = null;
        jl.qdl qdlVar2 = null;
        jl.ud udVar2 = null;
        com.bytedance.adsdk.ud.lnr.qdl.ud udVar3 = null;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.ud.lnr.qdl.mml mmlVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            boolean z = zNextBoolean;
            com.bytedance.adsdk.ud.lnr.qdl.ud udVar4 = udVar3;
            float f = fNextDouble;
            switch (strNextName.hashCode()) {
                case 100:
                    b = !strNextName.equals("d") ? (byte) -1 : (byte) 0;
                    break;
                case 101:
                    b = !strNextName.equals("e") ? (byte) -1 : (byte) 1;
                    break;
                case 103:
                    b = !strNextName.equals("g") ? (byte) -1 : (byte) 2;
                    break;
                case 111:
                    b = !strNextName.equals("o") ? (byte) -1 : (byte) 3;
                    break;
                case 115:
                    b = !strNextName.equals("s") ? (byte) -1 : (byte) 4;
                    break;
                case 116:
                    b = !strNextName.equals("t") ? (byte) -1 : (byte) 5;
                    break;
                case 119:
                    b = !strNextName.equals("w") ? (byte) -1 : (byte) 6;
                    break;
                case 3324:
                    b = !strNextName.equals("hd") ? (byte) -1 : (byte) 7;
                    break;
                case 3447:
                    b = !strNextName.equals("lc") ? (byte) -1 : (byte) 8;
                    break;
                case 3454:
                    b = !strNextName.equals("lj") ? (byte) -1 : (byte) 9;
                    break;
                case 3487:
                    b = !strNextName.equals("ml") ? (byte) -1 : (byte) 10;
                    break;
                case 3519:
                    b = !strNextName.equals("nm") ? (byte) -1 : Ascii.VT;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.bytedance.adsdk.ud.lnr.qdl.ud udVarQdl2 = null;
                        while (jsonReader.hasNext()) {
                            jl.ud udVar5 = udVar2;
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            jl.qdl qdlVar3 = qdlVar2;
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                udVarQdl2 = mml.qdl(jsonReader, wdVar);
                            } else {
                                jsonReader.skipValue();
                            }
                            udVar2 = udVar5;
                            qdlVar2 = qdlVar3;
                        }
                        jl.qdl qdlVar4 = qdlVar2;
                        jl.ud udVar6 = udVar2;
                        jsonReader.endObject();
                        if (strNextString2.equals("o")) {
                            udVar4 = udVarQdl2;
                            udVar2 = udVar6;
                            qdlVar2 = qdlVar4;
                        } else {
                            if (strNextString2.equals("d") || strNextString2.equals("g")) {
                                wdVar.qdl(true);
                                arrayList.add(udVarQdl2);
                            }
                            udVar2 = udVar6;
                            qdlVar2 = qdlVar4;
                        }
                    }
                    qdlVar = qdlVar2;
                    udVar = udVar2;
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        udVar3 = udVar4;
                        zNextBoolean = z;
                        udVar2 = udVar;
                        fNextDouble = f;
                        qdlVar2 = qdlVar;
                    } else {
                        arrayList.add(arrayList.get(0));
                        zNextBoolean = z;
                        udVar3 = udVar4;
                        udVar2 = udVar;
                        fNextDouble = f;
                        qdlVar2 = qdlVar;
                    }
                    break;
                case 1:
                    moVarLnr2 = mml.lnr(jsonReader, wdVar);
                    zNextBoolean = z;
                    udVar3 = udVar4;
                    fNextDouble = f;
                    break;
                case 2:
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        if (strNextName3.equals("k")) {
                            lnrVarQdl = mml.qdl(jsonReader, wdVar, iNextInt);
                        } else if (strNextName3.equals(TtmlNode.TAG_P)) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    zNextBoolean = z;
                    udVar3 = udVar4;
                    fNextDouble = f;
                    break;
                case 3:
                    mmlVar = mml.ud(jsonReader, wdVar);
                    zNextBoolean = z;
                    udVar3 = udVar4;
                    fNextDouble = f;
                    break;
                case 4:
                    moVarLnr = mml.lnr(jsonReader, wdVar);
                    zNextBoolean = z;
                    udVar3 = udVar4;
                    fNextDouble = f;
                    break;
                case 5:
                    wdVar2 = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.ud.lnr.ud.wd.LINEAR : com.bytedance.adsdk.ud.lnr.ud.wd.RADIAL;
                    zNextBoolean = z;
                    udVar3 = udVar4;
                    fNextDouble = f;
                    break;
                case 6:
                    udVarQdl = mml.qdl(jsonReader, wdVar);
                    zNextBoolean = z;
                    udVar3 = udVar4;
                    fNextDouble = f;
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    udVar3 = udVar4;
                    fNextDouble = f;
                    break;
                case 8:
                    qdlVar2 = jl.qdl.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = z;
                    udVar3 = udVar4;
                    fNextDouble = f;
                    break;
                case 9:
                    udVar2 = jl.ud.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = z;
                    udVar3 = udVar4;
                    fNextDouble = f;
                    break;
                case 10:
                    fNextDouble = (float) jsonReader.nextDouble();
                    zNextBoolean = z;
                    udVar3 = udVar4;
                    break;
                case 11:
                    strNextString = jsonReader.nextString();
                    zNextBoolean = z;
                    udVar3 = udVar4;
                    fNextDouble = f;
                    break;
                default:
                    jsonReader.skipValue();
                    qdlVar = qdlVar2;
                    udVar = udVar2;
                    udVar3 = udVar4;
                    zNextBoolean = z;
                    udVar2 = udVar;
                    fNextDouble = f;
                    qdlVar2 = qdlVar;
                    break;
            }
        }
        jl.qdl qdlVar5 = qdlVar2;
        jl.ud udVar7 = udVar2;
        float f2 = fNextDouble;
        com.bytedance.adsdk.ud.lnr.qdl.ud udVar8 = udVar3;
        boolean z2 = zNextBoolean;
        if (mmlVar == null) {
            mmlVar = new com.bytedance.adsdk.ud.lnr.qdl.mml(Collections.singletonList(new com.bytedance.adsdk.ud.wd.qdl(100)));
        }
        return new com.bytedance.adsdk.ud.lnr.ud.mo(strNextString, wdVar2, lnrVarQdl, mmlVar, moVarLnr, moVarLnr2, udVarQdl, qdlVar5, udVar7, f2, arrayList, udVar8, z2);
    }
}
