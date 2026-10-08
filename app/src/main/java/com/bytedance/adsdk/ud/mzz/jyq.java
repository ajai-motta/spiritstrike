package com.bytedance.adsdk.ud.mzz;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class jyq {
    static <T> List<com.bytedance.adsdk.ud.wd.qdl<T>> qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar, float f, wc<T> wcVar, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            wdVar.qdl("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("k")) {
                if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        arrayList.add(aaj.qdl(jsonReader, wdVar, f, wcVar, false, z));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(aaj.qdl(jsonReader, wdVar, f, wcVar, true, z));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(aaj.qdl(jsonReader, wdVar, f, wcVar, false, z));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        qdl(arrayList);
        return arrayList;
    }

    public static <T> void qdl(List<? extends com.bytedance.adsdk.ud.wd.qdl<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.bytedance.adsdk.ud.wd.qdl<T> qdlVar = list.get(i2);
            i2++;
            com.bytedance.adsdk.ud.wd.qdl<T> qdlVar2 = list.get(i2);
            qdlVar.wd = Float.valueOf(qdlVar2.mo);
            if (qdlVar.ud == null && qdlVar2.qdl != null) {
                qdlVar.ud = qdlVar2.qdl;
                if (qdlVar instanceof com.bytedance.adsdk.ud.qdl.ud.tvp) {
                    ((com.bytedance.adsdk.ud.qdl.ud.tvp) qdlVar).qdl();
                }
            }
        }
        com.bytedance.adsdk.ud.wd.qdl<T> qdlVar3 = list.get(i);
        if ((qdlVar3.qdl == null || qdlVar3.ud == null) && list.size() > 1) {
            list.remove(qdlVar3);
        }
    }
}
