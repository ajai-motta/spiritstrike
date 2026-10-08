package com.bytedance.adsdk.ud.mzz;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.adsdk.ud.lnr.lnr.mzz;
import com.bytedance.adsdk.ud.to;
import com.bytedance.adsdk.ud.wd;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ljh {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.adsdk.ud.wd qdl(JsonReader jsonReader) throws IOException {
        int i;
        byte b;
        float fQdl = com.bytedance.adsdk.ud.mo.mo.qdl();
        LongSparseArray<com.bytedance.adsdk.ud.lnr.lnr.mzz> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.bytedance.adsdk.ud.lnr.mml> sparseArray = new SparseArray<>();
        wd.lnr lnrVar = new wd.lnr();
        wd.qdl qdlVar = new wd.qdl();
        wd.ud udVar = new wd.ud();
        com.bytedance.adsdk.ud.wd wdVar = new com.bytedance.adsdk.ud.wd();
        jsonReader.beginObject();
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        String strNextString = null;
        int iNextInt = 0;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b2 = -1;
            switch (strNextName.hashCode()) {
                case -1408207997:
                    i = iNextInt2;
                    if (strNextName.equals("assets")) {
                        b2 = 0;
                    }
                    break;
                case -1109732030:
                    i = iNextInt2;
                    if (strNextName.equals("layers")) {
                        b2 = 1;
                    }
                    break;
                case -865448777:
                    i = iNextInt2;
                    if (strNextName.equals("globalEvent")) {
                        b2 = 2;
                    }
                    break;
                case 104:
                    i = iNextInt2;
                    if (strNextName.equals("h")) {
                        b = 3;
                        b2 = b;
                    }
                    break;
                case 118:
                    i = iNextInt2;
                    if (strNextName.equals("v")) {
                        b = 4;
                        b2 = b;
                    }
                    break;
                case 119:
                    i = iNextInt2;
                    if (strNextName.equals("w")) {
                        b = 5;
                        b2 = b;
                    }
                    break;
                case 3208:
                    i = iNextInt2;
                    if (strNextName.equals("dl")) {
                        b = 6;
                        b2 = b;
                    }
                    break;
                case 3276:
                    i = iNextInt2;
                    if (strNextName.equals("fr")) {
                        b = 7;
                        b2 = b;
                    }
                    break;
                case 3292:
                    i = iNextInt2;
                    if (strNextName.equals("gc")) {
                        b = 8;
                        b2 = b;
                    }
                    break;
                case 3367:
                    i = iNextInt2;
                    if (strNextName.equals("ip")) {
                        b = 9;
                        b2 = b;
                    }
                    break;
                case 3553:
                    i = iNextInt2;
                    if (strNextName.equals("op")) {
                        b = 10;
                        b2 = b;
                    }
                    break;
                case 94623709:
                    i = iNextInt2;
                    if (strNextName.equals("chars")) {
                        b = Ascii.VT;
                        b2 = b;
                    }
                    break;
                case 97615364:
                    i = iNextInt2;
                    if (strNextName.equals("fonts")) {
                        b = Ascii.FF;
                        b2 = b;
                    }
                    break;
                case 110364485:
                    i = iNextInt2;
                    if (strNextName.equals("timer")) {
                        b = Ascii.CR;
                        b2 = b;
                    }
                    break;
                case 839250809:
                    i = iNextInt2;
                    if (strNextName.equals("markers")) {
                        b = Ascii.SO;
                        b2 = b;
                    }
                    break;
                default:
                    i = iNextInt2;
                    break;
            }
            switch (b2) {
                case 0:
                    qdl(jsonReader, wdVar, map, map2);
                    break;
                case 1:
                    qdl(jsonReader, wdVar, arrayList, longSparseArray);
                    break;
                case 2:
                    qdl(jsonReader, udVar);
                    break;
                case 3:
                    iNextInt2 = jsonReader.nextInt();
                    continue;
                case 4:
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!com.bytedance.adsdk.ud.mo.mo.qdl(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        wdVar.qdl("Lottie only supports bodymovin >= 4.4.0");
                    }
                    break;
                case 5:
                    iNextInt = jsonReader.nextInt();
                    break;
                case 6:
                    strNextString = jsonReader.nextString();
                    break;
                case 7:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 8:
                    qdl(jsonReader, qdlVar);
                    break;
                case 9:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case 11:
                    qdl(jsonReader, wdVar, sparseArray);
                    break;
                case 12:
                    qdl(jsonReader, map3);
                    break;
                case 13:
                    qdl(jsonReader, lnrVar);
                    break;
                case 14:
                    qdl(jsonReader, arrayList2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            iNextInt2 = i;
        }
        jsonReader.endObject();
        wdVar.qdl(new Rect(0, 0, (int) (iNextInt * fQdl), (int) (iNextInt2 * fQdl)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map, map2, sparseArray, map3, arrayList2, lnrVar, strNextString, qdlVar, udVar);
        return wdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void qdl(android.util.JsonReader r7, com.bytedance.adsdk.ud.wd.ud r8) {
        /*
            r7.beginObject()     // Catch: java.lang.Exception -> L92
        L3:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L8f
            java.lang.String r0 = r7.nextName()     // Catch: java.lang.Exception -> L92
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L92
            r2 = 3239(0xca7, float:4.539E-42)
            r3 = 2
            r4 = -1
            r5 = 0
            r6 = 1
            if (r1 == r2) goto L38
            r2 = 107027(0x1a213, float:1.49977E-40)
            if (r1 == r2) goto L2e
            r2 = 3237004(0x31648c, float:4.536009E-39)
            if (r1 == r2) goto L24
            goto L42
        L24:
            java.lang.String r1 = "inel"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L42
            r0 = r5
            goto L43
        L2e:
            java.lang.String r1 = "lel"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L42
            r0 = r3
            goto L43
        L38:
            java.lang.String r1 = "el"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L42
            r0 = r6
            goto L43
        L42:
            r0 = r4
        L43:
            if (r0 == 0) goto L5b
            if (r0 == r6) goto L54
            if (r0 == r3) goto L4d
            r7.skipValue()     // Catch: java.lang.Exception -> L92
            goto L3
        L4d:
            org.json.JSONArray r0 = lnr(r7)     // Catch: java.lang.Exception -> L92
            r8.lnr = r0     // Catch: java.lang.Exception -> L92
            goto L3
        L54:
            java.lang.String r0 = r7.nextString()     // Catch: java.lang.Exception -> L92
            r8.qdl = r0     // Catch: java.lang.Exception -> L92
            goto L3
        L5b:
            int[][] r0 = new int[r6][]     // Catch: java.lang.Exception -> L92
            int[] r1 = new int[]{r4, r4}     // Catch: java.lang.Exception -> L92
            r0[r5] = r1     // Catch: java.lang.Exception -> L92
            r8.ud = r0     // Catch: java.lang.Exception -> L92
            r7.beginArray()     // Catch: java.lang.Exception -> L92
            boolean r0 = r7.hasNext()     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L8a
            r7.beginArray()     // Catch: java.lang.Exception -> L92
            r0 = r5
        L72:
            if (r0 >= r3) goto L87
            boolean r1 = r7.hasNext()     // Catch: java.lang.Exception -> L92
            if (r1 == 0) goto L84
            int[][] r1 = r8.ud     // Catch: java.lang.Exception -> L92
            r1 = r1[r5]     // Catch: java.lang.Exception -> L92
            int r2 = r7.nextInt()     // Catch: java.lang.Exception -> L92
            r1[r0] = r2     // Catch: java.lang.Exception -> L92
        L84:
            int r0 = r0 + 1
            goto L72
        L87:
            r7.endArray()     // Catch: java.lang.Exception -> L92
        L8a:
            r7.endArray()     // Catch: java.lang.Exception -> L92
            goto L3
        L8f:
            r7.endObject()     // Catch: java.lang.Exception -> L92
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.mzz.ljh.qdl(android.util.JsonReader, com.bytedance.adsdk.ud.wd$ud):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void qdl(android.util.JsonReader r7, com.bytedance.adsdk.ud.wd.qdl r8) {
        /*
            r7.beginObject()     // Catch: java.lang.Exception -> L91
        L3:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L8e
            java.lang.String r0 = r7.nextName()     // Catch: java.lang.Exception -> L91
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L91
            r2 = 3139(0xc43, float:4.399E-42)
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == r2) goto L53
            r2 = 3232(0xca0, float:4.529E-42)
            if (r1 == r2) goto L49
            r2 = 3571(0xdf3, float:5.004E-42)
            if (r1 == r2) goto L3f
            r2 = 3666(0xe52, float:5.137E-42)
            if (r1 == r2) goto L35
            r2 = 98713(0x18199, float:1.38326E-40)
            if (r1 == r2) goto L2b
            goto L5d
        L2b:
            java.lang.String r1 = "cpf"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L5d
            r0 = r3
            goto L5e
        L35:
            java.lang.String r1 = "se"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L5d
            r0 = 0
            goto L5e
        L3f:
            java.lang.String r1 = "pc"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L5d
            r0 = r4
            goto L5e
        L49:
            java.lang.String r1 = "ee"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L5d
            r0 = r5
            goto L5e
        L53:
            java.lang.String r1 = "be"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L5d
            r0 = r6
            goto L5e
        L5d:
            r0 = -1
        L5e:
            if (r0 == 0) goto L86
            if (r0 == r6) goto L7e
            if (r0 == r5) goto L77
            if (r0 == r4) goto L70
            if (r0 == r3) goto L6c
            r7.skipValue()     // Catch: java.lang.Exception -> L91
            goto L3
        L6c:
            ud(r7, r8)     // Catch: java.lang.Exception -> L91
            goto L3
        L70:
            int r0 = r7.nextInt()     // Catch: java.lang.Exception -> L91
            r8.mml = r0     // Catch: java.lang.Exception -> L91
            goto L3
        L77:
            java.util.Map r0 = ud(r7)     // Catch: java.lang.Exception -> L91
            r8.lnr = r0     // Catch: java.lang.Exception -> L91
            goto L3
        L7e:
            java.util.Map r0 = ud(r7)     // Catch: java.lang.Exception -> L91
            r8.ud = r0     // Catch: java.lang.Exception -> L91
            goto L3
        L86:
            int r0 = r7.nextInt()     // Catch: java.lang.Exception -> L91
            r8.qdl = r0     // Catch: java.lang.Exception -> L91
            goto L3
        L8e:
            r7.endObject()     // Catch: java.lang.Exception -> L91
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.mzz.ljh.qdl(android.util.JsonReader, com.bytedance.adsdk.ud.wd$qdl):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void ud(android.util.JsonReader r5, com.bytedance.adsdk.ud.wd.qdl r6) {
        /*
            r5.beginObject()     // Catch: java.io.IOException -> L62
        L3:
            boolean r0 = r5.hasNext()     // Catch: java.io.IOException -> L62
            if (r0 == 0) goto L5f
            java.lang.String r0 = r5.nextName()     // Catch: java.io.IOException -> L62
            int r1 = r0.hashCode()     // Catch: java.io.IOException -> L62
            r2 = 3239(0xca7, float:4.539E-42)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L35
            r2 = 3276(0xccc, float:4.59E-42)
            if (r1 == r2) goto L2b
            r2 = 107027(0x1a213, float:1.49977E-40)
            if (r1 == r2) goto L21
            goto L3f
        L21:
            java.lang.String r1 = "lel"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L62
            if (r0 == 0) goto L3f
            r0 = r3
            goto L40
        L2b:
            java.lang.String r1 = "fr"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L62
            if (r0 == 0) goto L3f
            r0 = 0
            goto L40
        L35:
            java.lang.String r1 = "el"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L62
            if (r0 == 0) goto L3f
            r0 = r4
            goto L40
        L3f:
            r0 = -1
        L40:
            if (r0 == 0) goto L58
            if (r0 == r4) goto L51
            if (r0 == r3) goto L4a
            r5.skipValue()     // Catch: java.io.IOException -> L62
            goto L3
        L4a:
            org.json.JSONArray r0 = lnr(r5)     // Catch: java.io.IOException -> L62
            r6.wd = r0     // Catch: java.io.IOException -> L62
            goto L3
        L51:
            java.lang.String r0 = r5.nextString()     // Catch: java.io.IOException -> L62
            r6.mo = r0     // Catch: java.io.IOException -> L62
            goto L3
        L58:
            int r0 = r5.nextInt()     // Catch: java.io.IOException -> L62
            r6.mzz = r0     // Catch: java.io.IOException -> L62
            goto L3
        L5f:
            r5.endObject()     // Catch: java.io.IOException -> L62
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.mzz.ljh.ud(android.util.JsonReader, com.bytedance.adsdk.ud.wd$qdl):void");
    }

    private static Map<String, Object> ud(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("lel")) {
                map.put("lel", lnr(jsonReader));
            } else if (strNextName.equals("lottie_back")) {
                JSONObject jSONObject = new JSONObject();
                map.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    if (strNextName2.equals("hd")) {
                        try {
                            jSONObject.putOpt("hd", Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt("vid", "lottie_back");
                        } catch (JSONException unused) {
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        Object objRemove = map.remove("lottie_back");
        if (objRemove instanceof JSONObject) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(objRemove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(objRemove);
                map.put("lel", jSONArray);
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void qdl(android.util.JsonReader r6, com.bytedance.adsdk.ud.wd.lnr r7) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.mzz.ljh.qdl(android.util.JsonReader, com.bytedance.adsdk.ud.wd$lnr):void");
    }

    private static void qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar, List<com.bytedance.adsdk.ud.lnr.lnr.mzz> list, LongSparseArray<com.bytedance.adsdk.ud.lnr.lnr.mzz> longSparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.ud.lnr.lnr.mzz mzzVarQdl = oth.qdl(jsonReader, wdVar);
            mzzVarQdl.rq();
            mzz.qdl qdlVar = mzz.qdl.IMAGE;
            list.add(mzzVarQdl);
            longSparseArray.put(mzzVarQdl.mzz(), mzzVarQdl);
        }
        jsonReader.endArray();
    }

    private static void qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar, Map<String, List<com.bytedance.adsdk.ud.lnr.lnr.mzz>> map, Map<String, com.bytedance.adsdk.ud.to> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            String strNextString4 = null;
            List<to.qdl> listMml = null;
            String strNextString5 = null;
            int[][] iArr = null;
            JSONArray jSONArrayLnr = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.ud.lnr.lnr.mzz mzzVarQdl = oth.qdl(jsonReader, wdVar);
                            longSparseArray.put(mzzVarQdl.mzz(), mzzVarQdl);
                            arrayList.add(mzzVarQdl);
                        }
                        jsonReader.endArray();
                        break;
                    case "h":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "p":
                        strNextString2 = jsonReader.nextString();
                        break;
                    case "u":
                        strNextString3 = jsonReader.nextString();
                        break;
                    case "w":
                        iNextInt = jsonReader.nextInt();
                        break;
                    case "el":
                        strNextString5 = jsonReader.nextString();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    case "tc":
                        jsonReader.beginArray();
                        listMml = mml(jsonReader);
                        jsonReader.endArray();
                        break;
                    case "lel":
                        jSONArrayLnr = lnr(jsonReader);
                        break;
                    case "rel":
                        strNextString4 = jsonReader.nextString();
                        break;
                    case "inel":
                        iArr = new int[][]{new int[]{-1, -1}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i = 0; i < 2; i++) {
                                if (jsonReader.hasNext()) {
                                    iArr[0][i] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.bytedance.adsdk.ud.to toVar = new com.bytedance.adsdk.ud.to(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3, strNextString4, listMml, strNextString5, iArr, jSONArrayLnr);
                map2.put(toVar.jpc(), toVar);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONArray lnr(android.util.JsonReader r8) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r8.beginArray()     // Catch: java.lang.Exception -> L67
        L8:
            boolean r1 = r8.hasNext()     // Catch: java.lang.Exception -> L67
            if (r1 == 0) goto L64
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L67
            r1.<init>()     // Catch: java.lang.Exception -> L67
            r0.put(r1)     // Catch: java.lang.Exception -> L67
            r8.beginObject()     // Catch: java.lang.Exception -> L67
        L19:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Exception -> L67
            if (r2 == 0) goto L60
            java.lang.String r2 = r8.nextName()     // Catch: java.lang.Exception -> L67
            int r3 = r2.hashCode()     // Catch: java.lang.Exception -> L67
            r4 = 3324(0xcfc, float:4.658E-42)
            java.lang.String r5 = "vid"
            java.lang.String r6 = "hd"
            r7 = 1
            if (r3 == r4) goto L3f
            r4 = 116753(0x1c811, float:1.63606E-40)
            if (r3 == r4) goto L37
            goto L47
        L37:
            boolean r2 = r2.equals(r5)     // Catch: java.lang.Exception -> L67
            if (r2 == 0) goto L47
            r2 = 0
            goto L48
        L3f:
            boolean r2 = r2.equals(r6)     // Catch: java.lang.Exception -> L67
            if (r2 == 0) goto L47
            r2 = r7
            goto L48
        L47:
            r2 = -1
        L48:
            if (r2 == 0) goto L58
            if (r2 == r7) goto L50
            r8.skipValue()     // Catch: java.lang.Exception -> L67
            goto L19
        L50:
            int r2 = r8.nextInt()     // Catch: org.json.JSONException -> L19 java.lang.Exception -> L67
            r1.put(r6, r2)     // Catch: org.json.JSONException -> L19 java.lang.Exception -> L67
            goto L19
        L58:
            java.lang.String r2 = r8.nextString()     // Catch: org.json.JSONException -> L19 java.lang.Exception -> L67
            r1.put(r5, r2)     // Catch: org.json.JSONException -> L19 java.lang.Exception -> L67
            goto L19
        L60:
            r8.endObject()     // Catch: java.lang.Exception -> L67
            goto L8
        L64:
            r8.endArray()     // Catch: java.lang.Exception -> L67
        L67:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.mzz.ljh.lnr(android.util.JsonReader):org.json.JSONArray");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.bytedance.adsdk.ud.to.qdl> mml(android.util.JsonReader r5) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.mzz.ljh.mml(android.util.JsonReader):java.util.List");
    }

    private static void qdl(JsonReader jsonReader, Map<String, com.bytedance.adsdk.ud.lnr.lnr> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.ud.lnr.lnr lnrVarQdl = rdp.qdl(jsonReader);
                    map.put(lnrVarQdl.ud(), lnrVarQdl);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar, SparseArray<com.bytedance.adsdk.ud.lnr.mml> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.ud.lnr.mml mmlVarQdl = exu.qdl(jsonReader, wdVar);
            sparseArray.put(mmlVarQdl.hashCode(), mmlVarQdl);
        }
        jsonReader.endArray();
    }

    private static void qdl(JsonReader jsonReader, List<com.bytedance.adsdk.ud.lnr.mo> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            String strNextString = null;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "cm":
                        strNextString = jsonReader.nextString();
                        break;
                    case "dr":
                        fNextDouble2 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.bytedance.adsdk.ud.lnr.mo(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
