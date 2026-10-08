package com.bytedance.adsdk.ud.mzz;

import android.util.JsonReader;
import com.facebook.appevents.UserDataStore;
import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class jpc {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static com.bytedance.adsdk.ud.lnr.ud.lnr qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar) throws IOException {
        com.bytedance.adsdk.ud.lnr.ud.lnr lnrVarQdl;
        String strNextString;
        jsonReader.beginObject();
        byte b = 2;
        int iNextInt = 2;
        while (true) {
            lnrVarQdl = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("d")) {
                iNextInt = jsonReader.nextInt();
            } else {
                if (strNextName.equals("ty")) {
                    strNextString = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            }
        }
        if (strNextString == null) {
            return null;
        }
        strNextString.hashCode();
        switch (strNextString.hashCode()) {
            case 3239:
                b = !strNextString.equals("el") ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                b = !strNextString.equals("fl") ? (byte) -1 : (byte) 1;
                break;
            case 3295:
                if (!strNextString.equals("gf")) {
                    b = -1;
                }
                break;
            case 3307:
                b = !strNextString.equals("gr") ? (byte) -1 : (byte) 3;
                break;
            case 3308:
                b = !strNextString.equals("gs") ? (byte) -1 : (byte) 4;
                break;
            case 3488:
                b = !strNextString.equals("mm") ? (byte) -1 : (byte) 5;
                break;
            case 3633:
                b = !strNextString.equals("rc") ? (byte) -1 : (byte) 6;
                break;
            case 3634:
                b = !strNextString.equals("rd") ? (byte) -1 : (byte) 7;
                break;
            case 3646:
                b = !strNextString.equals("rp") ? (byte) -1 : (byte) 8;
                break;
            case 3669:
                b = !strNextString.equals("sh") ? (byte) -1 : (byte) 9;
                break;
            case 3679:
                b = !strNextString.equals("sr") ? (byte) -1 : (byte) 10;
                break;
            case 3681:
                b = !strNextString.equals(UserDataStore.STATE) ? (byte) -1 : Ascii.VT;
                break;
            case 3705:
                b = !strNextString.equals("tm") ? (byte) -1 : Ascii.FF;
                break;
            case 3710:
                b = !strNextString.equals("tr") ? (byte) -1 : Ascii.CR;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                lnrVarQdl = mo.qdl(jsonReader, wdVar, iNextInt);
                break;
            case 1:
                lnrVarQdl = fco.qdl(jsonReader, wdVar);
                break;
            case 2:
                lnrVarQdl = jtx.qdl(jsonReader, wdVar);
                break;
            case 3:
                lnrVarQdl = mrf.qdl(jsonReader, wdVar);
                break;
            case 4:
                lnrVarQdl = yt.qdl(jsonReader, wdVar);
                break;
            case 5:
                lnrVarQdl = uw.qdl(jsonReader);
                wdVar.qdl("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                lnrVarQdl = rc.qdl(jsonReader, wdVar);
                break;
            case 7:
                lnrVarQdl = ekw.qdl(jsonReader, wdVar);
                break;
            case 8:
                lnrVarQdl = kdv.qdl(jsonReader, wdVar);
                break;
            case 9:
                lnrVarQdl = gy.qdl(jsonReader, wdVar);
                break;
            case 10:
                lnrVarQdl = vu.qdl(jsonReader, wdVar, iNextInt);
                break;
            case 11:
                lnrVarQdl = ax.qdl(jsonReader, wdVar);
                break;
            case 12:
                lnrVarQdl = ag.qdl(jsonReader, wdVar);
                break;
            case 13:
                lnrVarQdl = lnr.qdl(jsonReader, wdVar);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return lnrVarQdl;
    }
}
