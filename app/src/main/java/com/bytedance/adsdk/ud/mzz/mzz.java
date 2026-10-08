package com.bytedance.adsdk.ud.mzz;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class mzz {
    static com.bytedance.adsdk.ud.lnr.ud.qdl qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar) throws IOException {
        com.bytedance.adsdk.ud.lnr.ud.qdl qdlVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.ud.lnr.ud.qdl qdlVarUd = ud(jsonReader, wdVar);
                    if (qdlVarUd != null) {
                        qdlVar = qdlVarUd;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return qdlVar;
    }

    private static com.bytedance.adsdk.ud.lnr.ud.qdl ud(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.ud.lnr.ud.qdl qdlVar = null;
        while (true) {
            boolean z = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("v")) {
                    if (z) {
                        qdlVar = new com.bytedance.adsdk.ud.lnr.ud.qdl(mml.qdl(jsonReader, wdVar));
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (strNextName.equals("ty")) {
                    if (jsonReader.nextInt() == 0) {
                        z = true;
                    }
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return qdlVar;
        }
    }
}
