package com.bytedance.adsdk.ud.mzz;

import android.graphics.Path;
import android.util.JsonReader;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
class jtx {
    static com.bytedance.adsdk.ud.lnr.ud.mzz qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar) throws IOException {
        int iNextInt;
        com.bytedance.adsdk.ud.lnr.qdl.mml mmlVarUd = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strNextString = null;
        com.bytedance.adsdk.ud.lnr.ud.wd wdVar2 = null;
        com.bytedance.adsdk.ud.lnr.qdl.lnr lnrVarQdl = null;
        com.bytedance.adsdk.ud.lnr.qdl.mo moVarLnr = null;
        com.bytedance.adsdk.ud.lnr.qdl.mo moVarLnr2 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            iNextInt = -1;
            switch (strNextName) {
                case "e":
                    moVarLnr2 = mml.lnr(jsonReader, wdVar);
                    break;
                case "g":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("k")) {
                            lnrVarQdl = mml.qdl(jsonReader, wdVar, iNextInt);
                        } else if (strNextName2.equals(TtmlNode.TAG_P)) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    mmlVarUd = mml.ud(jsonReader, wdVar);
                    break;
                case "r":
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case "s":
                    moVarLnr = mml.lnr(jsonReader, wdVar);
                    break;
                case "t":
                    wdVar2 = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.ud.lnr.ud.wd.LINEAR : com.bytedance.adsdk.ud.lnr.ud.wd.RADIAL;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.ud.lnr.ud.mzz(strNextString, wdVar2, fillType, lnrVarQdl, mmlVarUd == null ? new com.bytedance.adsdk.ud.lnr.qdl.mml(Collections.singletonList(new com.bytedance.adsdk.ud.wd.qdl(100))) : mmlVarUd, moVarLnr, moVarLnr2, null, null, zNextBoolean);
    }
}
