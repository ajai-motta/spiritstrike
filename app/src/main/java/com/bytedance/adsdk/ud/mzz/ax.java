package com.bytedance.adsdk.ud.mzz;

import android.util.JsonReader;
import com.bytedance.adsdk.ud.lnr.ud.jl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
class ax {
    static com.bytedance.adsdk.ud.lnr.ud.jl qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar) throws IOException {
        int i;
        com.bytedance.adsdk.ud.lnr.qdl.ud udVarQdl;
        int i2;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.bytedance.adsdk.ud.lnr.qdl.ud udVar = null;
        com.bytedance.adsdk.ud.lnr.qdl.qdl qdlVarWd = null;
        com.bytedance.adsdk.ud.lnr.qdl.ud udVarQdl2 = null;
        jl.qdl qdlVar = null;
        jl.ud udVar2 = null;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.ud.lnr.qdl.mml mmlVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            i = 1;
            switch (strNextName) {
                case "c":
                    qdlVarWd = mml.wd(jsonReader, wdVar);
                    continue;
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        udVarQdl = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                udVarQdl = mml.qdl(jsonReader, wdVar);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        strNextString2.hashCode();
                        switch (strNextString2) {
                            case "d":
                            case "g":
                                i2 = 1;
                                wdVar.qdl(true);
                                arrayList.add(udVarQdl);
                                i = i2;
                                break;
                            case "o":
                                udVar = udVarQdl;
                                i = 1;
                                break;
                            default:
                                i2 = 1;
                                i = i2;
                                break;
                        }
                    }
                    int i3 = i;
                    jsonReader.endArray();
                    if (arrayList.size() != i3) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                case "o":
                    mmlVar = mml.ud(jsonReader, wdVar);
                    continue;
                    break;
                case "w":
                    udVarQdl2 = mml.qdl(jsonReader, wdVar);
                    continue;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                    break;
                case "lc":
                    qdlVar = jl.qdl.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "lj":
                    udVar2 = jl.ud.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (mmlVar == null) {
            mmlVar = new com.bytedance.adsdk.ud.lnr.qdl.mml(Collections.singletonList(new com.bytedance.adsdk.ud.wd.qdl(100)));
        }
        return new com.bytedance.adsdk.ud.lnr.ud.jl(strNextString, udVar, arrayList, qdlVarWd, mmlVar, udVarQdl2, qdlVar, udVar2, fNextDouble, zNextBoolean);
    }
}
