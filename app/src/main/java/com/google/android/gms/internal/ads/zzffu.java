package com.google.android.gms.internal.ads;

import com.adxcorp.ads.mediation.util.ReportUtil;
import com.hive.core.Configuration;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzffu {
    public final zzbzq zzA;
    public final String zzB;
    public final JSONObject zzC;
    public final JSONObject zzD;
    public final String zzE;
    public final String zzF;
    public final String zzG;
    public final String zzH;
    public final String zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final int zzQ;
    public final int zzR;
    public final boolean zzS;
    public final boolean zzT;
    public final String zzU;
    public final zzfgq zzV;
    public final boolean zzW;
    public final boolean zzX;
    public final int zzY;
    public final String zzZ;
    public final List zza;
    public final List zzaA;
    public final boolean zzaB;
    public final List zzaC;
    public final boolean zzaD;
    public final int zzaE;
    public final int zzaa;
    public final String zzab;
    public final boolean zzac;
    public final zzbvo zzad;
    public final com.google.android.gms.ads.internal.client.zzt zzae;
    public final String zzaf;
    public final boolean zzag;
    public final JSONObject zzah;
    public final boolean zzai;
    public final JSONObject zzaj;
    public final boolean zzak;
    public final String zzal;
    public final boolean zzam;
    public final String zzan;
    public final String zzao;
    public final String zzap;
    public final boolean zzaq;
    public final boolean zzar;
    public final int zzas;
    public final String zzat;
    public final List zzau;
    public final boolean zzav;
    public final Map zzaw;
    public final com.google.android.gms.ads.internal.util.client.zzv zzax;
    public final com.google.android.gms.ads.internal.util.client.zzw zzay;
    public final double zzaz;
    public final int zzb;
    public final List zzc;
    public final List zzd;
    public final int zze;
    public final List zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final String zzj;
    public final String zzk;
    public final zzbyh zzl;
    public final List zzm;
    public final List zzn;
    public final List zzo;
    public final List zzp;
    public final int zzq;
    public final List zzr;
    public final zzffz zzs;
    public final List zzt;
    public final List zzu;
    public final JSONObject zzv;
    public final String zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0717 A[PHI: r22 r24
  0x0717: PHI (r22v94 java.util.List) = 
  (r22v5 java.util.List)
  (r22v6 java.util.List)
  (r22v7 java.util.List)
  (r22v8 java.util.List)
  (r22v9 java.util.List)
  (r22v10 java.util.List)
  (r22v11 java.util.List)
  (r22v12 java.util.List)
  (r22v13 java.util.List)
  (r22v14 java.util.List)
  (r22v15 java.util.List)
  (r22v16 java.util.List)
  (r22v17 java.util.List)
  (r22v18 java.util.List)
  (r22v19 java.util.List)
  (r22v20 java.util.List)
  (r22v21 java.util.List)
  (r22v22 java.util.List)
  (r22v23 java.util.List)
  (r22v24 java.util.List)
  (r22v25 java.util.List)
  (r22v26 java.util.List)
  (r22v27 java.util.List)
  (r22v28 java.util.List)
  (r22v29 java.util.List)
  (r22v30 java.util.List)
  (r22v31 java.util.List)
  (r22v32 java.util.List)
  (r22v33 java.util.List)
  (r22v34 java.util.List)
  (r22v35 java.util.List)
  (r22v36 java.util.List)
  (r22v37 java.util.List)
  (r22v38 java.util.List)
  (r22v39 java.util.List)
  (r22v40 java.util.List)
  (r22v41 java.util.List)
  (r22v42 java.util.List)
  (r22v43 java.util.List)
  (r22v44 java.util.List)
  (r22v45 java.util.List)
  (r22v46 java.util.List)
  (r22v47 java.util.List)
  (r22v48 java.util.List)
  (r22v49 java.util.List)
  (r22v50 java.util.List)
  (r22v51 java.util.List)
  (r22v52 java.util.List)
  (r22v53 java.util.List)
  (r22v54 java.util.List)
  (r22v55 java.util.List)
  (r22v56 java.util.List)
  (r22v57 java.util.List)
  (r22v58 java.util.List)
  (r22v59 java.util.List)
  (r22v60 java.util.List)
  (r22v61 java.util.List)
  (r22v62 java.util.List)
  (r22v63 java.util.List)
  (r22v64 java.util.List)
  (r22v65 java.util.List)
  (r22v66 java.util.List)
  (r22v67 java.util.List)
  (r22v68 java.util.List)
  (r22v69 java.util.List)
  (r22v70 java.util.List)
  (r22v71 java.util.List)
  (r22v72 java.util.List)
  (r22v73 java.util.List)
  (r22v74 java.util.List)
  (r22v75 java.util.List)
  (r22v76 java.util.List)
  (r22v77 java.util.List)
  (r22v78 java.util.List)
  (r22v79 java.util.List)
  (r22v80 java.util.List)
  (r22v81 java.util.List)
  (r22v82 java.util.List)
  (r22v83 java.util.List)
  (r22v84 java.util.List)
  (r22v85 java.util.List)
  (r22v86 java.util.List)
  (r22v87 java.util.List)
  (r22v88 java.util.List)
  (r22v89 java.util.List)
  (r22v95 java.util.List)
 binds: [B:265:0x0712, B:262:0x0701, B:259:0x06f0, B:256:0x06df, B:253:0x06ce, B:250:0x06bd, B:247:0x06ab, B:244:0x0699, B:241:0x0687, B:238:0x0675, B:235:0x0663, B:232:0x0651, B:229:0x063f, B:226:0x062d, B:223:0x061b, B:220:0x0609, B:217:0x05f7, B:214:0x05e5, B:211:0x05d3, B:208:0x05c1, B:205:0x05af, B:202:0x059d, B:199:0x058b, B:196:0x0579, B:193:0x0567, B:190:0x0555, B:187:0x0543, B:184:0x0532, B:181:0x0520, B:178:0x050e, B:175:0x04fc, B:172:0x04ea, B:169:0x04d8, B:166:0x04c6, B:163:0x04b4, B:160:0x04a3, B:157:0x0491, B:154:0x047f, B:151:0x046d, B:148:0x045c, B:145:0x044a, B:142:0x0438, B:139:0x0426, B:136:0x0414, B:133:0x0402, B:130:0x03f0, B:127:0x03de, B:124:0x03cc, B:121:0x03ba, B:118:0x03a8, B:115:0x0396, B:112:0x0384, B:109:0x0372, B:106:0x0360, B:103:0x034e, B:100:0x033c, B:97:0x032b, B:94:0x0319, B:91:0x0307, B:88:0x02f5, B:85:0x02e3, B:82:0x02d1, B:79:0x02c0, B:76:0x02ae, B:73:0x029c, B:70:0x028a, B:67:0x0278, B:64:0x0266, B:61:0x0254, B:58:0x0242, B:55:0x0230, B:52:0x021e, B:49:0x020c, B:46:0x01fa, B:43:0x01e8, B:40:0x01d7, B:37:0x01c5, B:34:0x01b4, B:31:0x01a2, B:28:0x0190, B:25:0x017e, B:22:0x016c, B:19:0x015a, B:16:0x0148, B:13:0x0136, B:11:0x0124] A[DONT_GENERATE, DONT_INLINE]
  0x0717: PHI (r24v88 java.util.List) = 
  (r24v2 java.util.List)
  (r24v3 java.util.List)
  (r24v4 java.util.List)
  (r24v5 java.util.List)
  (r24v6 java.util.List)
  (r24v7 java.util.List)
  (r24v8 java.util.List)
  (r24v9 java.util.List)
  (r24v10 java.util.List)
  (r24v11 java.util.List)
  (r24v12 java.util.List)
  (r24v13 java.util.List)
  (r24v14 java.util.List)
  (r24v15 java.util.List)
  (r24v16 java.util.List)
  (r24v17 java.util.List)
  (r24v18 java.util.List)
  (r24v19 java.util.List)
  (r24v20 java.util.List)
  (r24v21 java.util.List)
  (r24v22 java.util.List)
  (r24v23 java.util.List)
  (r24v24 java.util.List)
  (r24v25 java.util.List)
  (r24v26 java.util.List)
  (r24v27 java.util.List)
  (r24v28 java.util.List)
  (r24v29 java.util.List)
  (r24v30 java.util.List)
  (r24v31 java.util.List)
  (r24v32 java.util.List)
  (r24v33 java.util.List)
  (r24v34 java.util.List)
  (r24v35 java.util.List)
  (r24v36 java.util.List)
  (r24v37 java.util.List)
  (r24v38 java.util.List)
  (r24v39 java.util.List)
  (r24v40 java.util.List)
  (r24v41 java.util.List)
  (r24v42 java.util.List)
  (r24v43 java.util.List)
  (r24v44 java.util.List)
  (r24v45 java.util.List)
  (r24v46 java.util.List)
  (r24v47 java.util.List)
  (r24v48 java.util.List)
  (r24v49 java.util.List)
  (r24v50 java.util.List)
  (r24v51 java.util.List)
  (r24v52 java.util.List)
  (r24v53 java.util.List)
  (r24v54 java.util.List)
  (r24v55 java.util.List)
  (r24v56 java.util.List)
  (r24v57 java.util.List)
  (r24v58 java.util.List)
  (r24v59 java.util.List)
  (r24v60 java.util.List)
  (r24v61 java.util.List)
  (r24v62 java.util.List)
  (r24v63 java.util.List)
  (r24v64 java.util.List)
  (r24v65 java.util.List)
  (r24v66 java.util.List)
  (r24v67 java.util.List)
  (r24v68 java.util.List)
  (r24v69 java.util.List)
  (r24v70 java.util.List)
  (r24v71 java.util.List)
  (r24v72 java.util.List)
  (r24v73 java.util.List)
  (r24v74 java.util.List)
  (r24v75 java.util.List)
  (r24v76 java.util.List)
  (r24v77 java.util.List)
  (r24v78 java.util.List)
  (r24v79 java.util.List)
  (r24v80 java.util.List)
  (r24v81 java.util.List)
  (r24v82 java.util.List)
  (r24v83 java.util.List)
  (r24v84 java.util.List)
  (r24v85 java.util.List)
  (r24v86 java.util.List)
  (r24v89 java.util.List)
 binds: [B:265:0x0712, B:262:0x0701, B:259:0x06f0, B:256:0x06df, B:253:0x06ce, B:250:0x06bd, B:247:0x06ab, B:244:0x0699, B:241:0x0687, B:238:0x0675, B:235:0x0663, B:232:0x0651, B:229:0x063f, B:226:0x062d, B:223:0x061b, B:220:0x0609, B:217:0x05f7, B:214:0x05e5, B:211:0x05d3, B:208:0x05c1, B:205:0x05af, B:202:0x059d, B:199:0x058b, B:196:0x0579, B:193:0x0567, B:190:0x0555, B:187:0x0543, B:184:0x0532, B:181:0x0520, B:178:0x050e, B:175:0x04fc, B:172:0x04ea, B:169:0x04d8, B:166:0x04c6, B:163:0x04b4, B:160:0x04a3, B:157:0x0491, B:154:0x047f, B:151:0x046d, B:148:0x045c, B:145:0x044a, B:142:0x0438, B:139:0x0426, B:136:0x0414, B:133:0x0402, B:130:0x03f0, B:127:0x03de, B:124:0x03cc, B:121:0x03ba, B:118:0x03a8, B:115:0x0396, B:112:0x0384, B:109:0x0372, B:106:0x0360, B:103:0x034e, B:100:0x033c, B:97:0x032b, B:94:0x0319, B:91:0x0307, B:88:0x02f5, B:85:0x02e3, B:82:0x02d1, B:79:0x02c0, B:76:0x02ae, B:73:0x029c, B:70:0x028a, B:67:0x0278, B:64:0x0266, B:61:0x0254, B:58:0x0242, B:55:0x0230, B:52:0x021e, B:49:0x020c, B:46:0x01fa, B:43:0x01e8, B:40:0x01d7, B:37:0x01c5, B:34:0x01b4, B:31:0x01a2, B:28:0x0190, B:25:0x017e, B:22:0x016c, B:19:0x015a, B:16:0x0148, B:13:0x0136, B:11:0x0124] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    zzffu(android.util.JsonReader r95) throws java.lang.IllegalStateException, org.json.JSONException, java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instruction units count: 3418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzffu.<init>(android.util.JsonReader):void");
    }

    public static String zza(int i) {
        switch (i) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return Configuration.HIVE_COUNTRY_DEFAULT;
        }
    }

    private static int zzc(String str) {
        if (ReportUtil.INVENTORY_TYPE_BANNER.equals(str)) {
            return 1;
        }
        if (ReportUtil.INVENTORY_TYPE_INTERSTITIAL.equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if ("native".equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str)) {
            return 6;
        }
        return "rewarded_interstitial".equals(str) ? 7 : 0;
    }

    private static int zzd(int i) {
        if (i == 0 || i == 1 || i == 3 || i == 4) {
            return i;
        }
        return 0;
    }

    private static int zze(String str) {
        if ("landscape".equalsIgnoreCase(str)) {
            return 6;
        }
        return "portrait".equalsIgnoreCase(str) ? 7 : -1;
    }

    public final boolean zzb() {
        return this.zzai || this.zzay != null;
    }
}
