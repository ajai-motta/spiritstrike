package com.bytedance.adsdk.ud.mzz;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class lnr {
    public static com.bytedance.adsdk.ud.lnr.qdl.fs qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.bytedance.adsdk.ud.lnr.qdl.ud udVar = null;
        com.bytedance.adsdk.ud.lnr.qdl.mzz mzzVarQdl = null;
        com.bytedance.adsdk.ud.lnr.qdl.exu<PointF, PointF> exuVarUd = null;
        com.bytedance.adsdk.ud.lnr.qdl.wd wdVarMml = null;
        com.bytedance.adsdk.ud.lnr.qdl.ud udVarQdl = null;
        com.bytedance.adsdk.ud.lnr.qdl.ud udVarQdl2 = null;
        com.bytedance.adsdk.ud.lnr.qdl.mml mmlVarUd = null;
        com.bytedance.adsdk.ud.lnr.qdl.ud udVarQdl3 = null;
        com.bytedance.adsdk.ud.lnr.qdl.ud udVarQdl4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("k")) {
                            mzzVarQdl = qdl.qdl(jsonReader, wdVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "o":
                    mmlVarUd = mml.ud(jsonReader, wdVar);
                    continue;
                    break;
                case "p":
                    exuVarUd = qdl.ud(jsonReader, wdVar);
                    continue;
                    break;
                case "r":
                    break;
                case "s":
                    wdVarMml = mml.mml(jsonReader, wdVar);
                    continue;
                    break;
                case "eo":
                    udVarQdl4 = mml.qdl(jsonReader, wdVar, false);
                    continue;
                    break;
                case "rz":
                    wdVar.qdl("Lottie doesn't support 3D layers.");
                    break;
                case "sa":
                    udVarQdl2 = mml.qdl(jsonReader, wdVar, false);
                    continue;
                    break;
                case "sk":
                    udVarQdl = mml.qdl(jsonReader, wdVar, false);
                    continue;
                    break;
                case "so":
                    udVarQdl3 = mml.qdl(jsonReader, wdVar, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            com.bytedance.adsdk.ud.lnr.qdl.ud udVarQdl5 = mml.qdl(jsonReader, wdVar, false);
            if (udVarQdl5.lnr().isEmpty()) {
                udVarQdl5.lnr().add(new com.bytedance.adsdk.ud.wd.qdl(wdVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(wdVar.wd())));
            } else if (((com.bytedance.adsdk.ud.wd.qdl) udVarQdl5.lnr().get(0)).qdl == 0) {
                udVarQdl5.lnr().set(0, new com.bytedance.adsdk.ud.wd.qdl(wdVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(wdVar.wd())));
            }
            udVar = udVarQdl5;
        }
        if (z) {
            jsonReader.endObject();
        }
        com.bytedance.adsdk.ud.lnr.qdl.mzz mzzVar = qdl(mzzVarQdl) ? null : mzzVarQdl;
        if (qdl(exuVarUd)) {
            exuVarUd = null;
        }
        return new com.bytedance.adsdk.ud.lnr.qdl.fs(mzzVar, exuVarUd, qdl(wdVarMml) ? null : wdVarMml, qdl(udVar) ? null : udVar, mmlVarUd, udVarQdl3, udVarQdl4, ud(udVarQdl) ? null : udVarQdl, lnr(udVarQdl2) ? null : udVarQdl2);
    }

    private static boolean qdl(com.bytedance.adsdk.ud.lnr.qdl.mzz mzzVar) {
        if (mzzVar != null) {
            return mzzVar.ud() && mzzVar.lnr().get(0).qdl.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean qdl(com.bytedance.adsdk.ud.lnr.qdl.exu<PointF, PointF> exuVar) {
        if (exuVar != null) {
            return !(exuVar instanceof com.bytedance.adsdk.ud.lnr.qdl.tvp) && exuVar.ud() && exuVar.lnr().get(0).qdl.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean qdl(com.bytedance.adsdk.ud.lnr.qdl.ud udVar) {
        if (udVar != null) {
            return udVar.ud() && ((Float) ((com.bytedance.adsdk.ud.wd.qdl) udVar.lnr().get(0)).qdl).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean qdl(com.bytedance.adsdk.ud.lnr.qdl.wd wdVar) {
        if (wdVar != null) {
            return wdVar.ud() && ((com.bytedance.adsdk.ud.wd.lnr) ((com.bytedance.adsdk.ud.wd.qdl) wdVar.lnr().get(0)).qdl).ud(1.0f, 1.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean ud(com.bytedance.adsdk.ud.lnr.qdl.ud udVar) {
        if (udVar != null) {
            return udVar.ud() && ((Float) ((com.bytedance.adsdk.ud.wd.qdl) udVar.lnr().get(0)).qdl).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean lnr(com.bytedance.adsdk.ud.lnr.qdl.ud udVar) {
        if (udVar != null) {
            return udVar.ud() && ((Float) ((com.bytedance.adsdk.ud.wd.qdl) udVar.lnr().get(0)).qdl).floatValue() == 0.0f;
        }
        return true;
    }
}
