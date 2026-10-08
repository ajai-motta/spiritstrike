package com.bytedance.adsdk.ud.mzz;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.ud.lnr.ud;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class tvp implements wc<com.bytedance.adsdk.ud.lnr.ud> {
    public static final tvp qdl = new tvp();

    private tvp() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ud.mzz.wc
    /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.ud.lnr.ud ud(JsonReader jsonReader, float f) throws IOException {
        ud.qdl qdlVar = ud.qdl.CENTER;
        jsonReader.beginObject();
        ud.qdl qdlVar2 = qdlVar;
        String strNextString = null;
        String strNextString2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        int iNextInt = 0;
        int iQdl = 0;
        int iQdl2 = 0;
        boolean zNextBoolean = true;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case 102:
                    if (strNextName.equals(InneractiveMediationDefs.GENDER_FEMALE)) {
                        b = 0;
                    }
                    break;
                case 106:
                    if (strNextName.equals("j")) {
                        b = 1;
                    }
                    break;
                case 115:
                    if (strNextName.equals("s")) {
                        b = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        b = 3;
                    }
                    break;
                case 3261:
                    if (strNextName.equals("fc")) {
                        b = 4;
                    }
                    break;
                case 3452:
                    if (strNextName.equals("lh")) {
                        b = 5;
                    }
                    break;
                case 3463:
                    if (strNextName.equals("ls")) {
                        b = 6;
                    }
                    break;
                case 3543:
                    if (strNextName.equals("of")) {
                        b = 7;
                    }
                    break;
                case 3587:
                    if (strNextName.equals("ps")) {
                        b = 8;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b = 9;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b = 10;
                    }
                    break;
                case 3687:
                    if (strNextName.equals("sz")) {
                        b = Ascii.VT;
                    }
                    break;
                case 3710:
                    if (strNextName.equals("tr")) {
                        b = Ascii.FF;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 1:
                    int iNextInt2 = jsonReader.nextInt();
                    if (iNextInt2 > ud.qdl.CENTER.ordinal() || iNextInt2 < 0) {
                        qdlVar2 = ud.qdl.CENTER;
                    } else {
                        qdlVar2 = ud.qdl.values()[iNextInt2];
                    }
                    break;
                case 2:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    strNextString = jsonReader.nextString();
                    break;
                case 4:
                    iQdl = exc.qdl(jsonReader);
                    break;
                case 5:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 8:
                    jsonReader.beginArray();
                    PointF pointF3 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    pointF = pointF3;
                    break;
                case 9:
                    iQdl2 = exc.qdl(jsonReader);
                    break;
                case 10:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case 11:
                    jsonReader.beginArray();
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    pointF2 = pointF4;
                    break;
                case 12:
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.ud.lnr.ud(strNextString, strNextString2, fNextDouble, qdlVar2, iNextInt, fNextDouble2, fNextDouble3, iQdl, iQdl2, fNextDouble4, zNextBoolean, pointF, pointF2);
    }
}
