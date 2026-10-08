package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaeh;
import com.google.android.gms.internal.measurement.zzahh;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import com.hive.Analytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpg implements zzjg {
    private static volatile zzpg zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private zzlu zzG;
    private String zzH;
    private zzaz zzI;
    private long zzJ;
    long zza;
    private final zzht zzc;
    private final zzgz zzd;
    private zzaw zze;
    private zzhb zzf;
    private zzok zzg;
    private zzad zzh;
    private final zzpk zzi;
    private zzlp zzj;
    private zznn zzk;
    private final zzou zzl;
    private zzhk zzm;
    private final zzic zzn;
    private boolean zzp;
    private List zzq;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final Deque zzr = new LinkedList();
    private final Map zzF = new HashMap();
    private final zzpo zzK = new zzpb(this);

    zzpg(zzph zzphVar, zzic zzicVar) {
        Preconditions.checkNotNull(zzphVar);
        this.zzn = zzic.zzy(zzphVar.zza, null, null, null);
        this.zzB = -1L;
        this.zzl = new zzou(this);
        zzpk zzpkVar = new zzpk(this);
        zzpkVar.zzaz();
        this.zzi = zzpkVar;
        zzgz zzgzVar = new zzgz(this);
        zzgzVar.zzaz();
        this.zzd = zzgzVar;
        zzht zzhtVar = new zzht(this);
        zzhtVar.zzaz();
        this.zzc = zzhtVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaX().zzj(new zzov(this, zzphVar));
    }

    public static zzpg zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpg.class) {
                if (zzb == null) {
                    zzb = new zzpg((zzph) Preconditions.checkNotNull(new zzph(context)), null);
                }
            }
        }
        return zzb;
    }

    static final void zzaB(com.google.android.gms.internal.measurement.zzhr zzhrVar, int i, String str) {
        List listZza = zzhrVar.zza();
        for (int i2 = 0; i2 < listZza.size(); i2++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i2)).zzb())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn.zzb("_err");
        long j = i;
        Long.valueOf(j).getClass();
        zzhvVarZzn.zzf(j);
        com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd();
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn2.zzb("_ev");
        zzhvVarZzn2.zzd(str);
        com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbd();
        zzhrVar.zzf(zzhwVar);
        zzhrVar.zzf(zzhwVar2);
    }

    static final void zzaC(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str) {
        List listZza = zzhrVar.zza();
        for (int i = 0; i < listZza.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i)).zzb())) {
                zzhrVar.zzj(i);
                return;
            }
        }
    }

    private final int zzaD(String str, zzan zzanVar) {
        zzjk zzjkVar;
        zzji zzjiVarZzB;
        zzht zzhtVar = this.zzc;
        if (zzhtVar.zzy(str) == null) {
            zzanVar.zzc(zzjk.AD_PERSONALIZATION, zzam.FAILSAFE);
            return 1;
        }
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null && zze.zzc(zzhVarZzu.zzaH()).zza() == zzji.POLICY && (zzjiVarZzB = zzhtVar.zzB(str, (zzjkVar = zzjk.AD_PERSONALIZATION))) != zzji.UNINITIALIZED) {
            zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
            return zzjiVarZzB == zzji.GRANTED ? 0 : 1;
        }
        zzjk zzjkVar2 = zzjk.AD_PERSONALIZATION;
        zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
        return zzhtVar.zzw(str, zzjkVar2) ? 0 : 1;
    }

    private final Map zzaE(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        HashMap map = new HashMap();
        zzp();
        for (Map.Entry entry : zzpk.zzL(zzhsVar, "gad_").entrySet()) {
            map.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return map;
    }

    private final zzaz zzaF() {
        if (this.zzI == null) {
            this.zzI = new zzoy(this, this.zzn);
        }
        return this.zzI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaG, reason: merged with bridge method [inline-methods] */
    public final void zzaw() {
        zzaX().zzg();
        if (this.zzr.isEmpty() || zzaF().zzc()) {
            return;
        }
        long jMax = Math.max(0L, ((long) ((Integer) zzfy.zzaA.zzb(null)).intValue()) - (zzba().elapsedRealtime() - this.zzJ));
        zzaW().zzk().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(jMax));
        zzaF().zzb(jMax);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x044c A[Catch: all -> 0x0e6c, TryCatch #4 {all -> 0x0e6c, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0046, B:12:0x005c, B:15:0x0082, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:228:0x070f, B:24:0x0100, B:27:0x0116, B:29:0x011c, B:31:0x0122, B:33:0x0133, B:37:0x013e, B:39:0x0149, B:41:0x0155, B:43:0x015b, B:47:0x0166, B:48:0x0173, B:50:0x0181, B:53:0x01a1, B:55:0x01a7, B:57:0x01b7, B:59:0x01c5, B:61:0x01d5, B:62:0x01e2, B:63:0x01e5, B:65:0x01f2, B:67:0x01fc, B:68:0x020c, B:70:0x0229, B:72:0x0233, B:74:0x0247, B:75:0x0251, B:78:0x025c, B:79:0x0266, B:82:0x026e, B:85:0x027f, B:86:0x0282, B:88:0x0299, B:140:0x047d, B:141:0x0480, B:143:0x048a, B:146:0x049d, B:148:0x04b0, B:150:0x04bc, B:183:0x0593, B:185:0x05a0, B:187:0x05a6, B:189:0x05ac, B:191:0x05bf, B:192:0x05c2, B:194:0x05c7, B:196:0x05cd, B:197:0x05d9, B:199:0x05df, B:201:0x05ef, B:203:0x05f9, B:204:0x0610, B:206:0x0616, B:207:0x0631, B:209:0x0637, B:210:0x0655, B:211:0x0660, B:215:0x068b, B:212:0x0666, B:214:0x0678, B:216:0x0699, B:217:0x06b7, B:219:0x06bd, B:221:0x06d0, B:222:0x06dd, B:223:0x06e1, B:225:0x06e7, B:227:0x06fb, B:155:0x04e1, B:157:0x04f1, B:160:0x0504, B:162:0x0517, B:164:0x0523, B:167:0x053b, B:169:0x0549, B:171:0x0555, B:173:0x055f, B:176:0x056c, B:178:0x0572, B:180:0x0582, B:181:0x058d, B:97:0x02bf, B:100:0x02c9, B:102:0x02d7, B:106:0x0318, B:103:0x02f1, B:105:0x02ff, B:109:0x031f, B:112:0x0352, B:113:0x037c, B:115:0x03b3, B:117:0x03b9, B:120:0x03c5, B:122:0x03fc, B:123:0x0417, B:125:0x041d, B:127:0x042b, B:131:0x043e, B:128:0x0433, B:134:0x0445, B:137:0x044c, B:138:0x0464, B:231:0x0729, B:233:0x0737, B:235:0x0740, B:246:0x0772, B:236:0x0748, B:238:0x0751, B:240:0x0757, B:243:0x0763, B:245:0x076d, B:247:0x0775, B:248:0x0781, B:251:0x0789, B:253:0x079b, B:254:0x07a6, B:256:0x07ae, B:260:0x07d3, B:262:0x07ed, B:264:0x0802, B:266:0x081c, B:268:0x0831, B:269:0x083f, B:271:0x0845, B:273:0x0855, B:274:0x085c, B:276:0x0868, B:277:0x086f, B:278:0x0872, B:280:0x08b4, B:282:0x08ba, B:288:0x08e1, B:290:0x08e9, B:291:0x08f2, B:293:0x08f8, B:294:0x08fe, B:296:0x0913, B:298:0x0923, B:300:0x0933, B:302:0x093b, B:303:0x093e, B:311:0x09b0, B:313:0x09c9, B:315:0x09df, B:317:0x09e4, B:319:0x09e8, B:321:0x09ec, B:323:0x09f6, B:324:0x09fc, B:326:0x0a00, B:328:0x0a06, B:329:0x0a14, B:330:0x0a1d, B:335:0x0a42, B:339:0x0a49, B:283:0x08c8, B:285:0x08ce, B:287:0x08d4, B:267:0x082e, B:263:0x07ff, B:257:0x07b3, B:259:0x07b9), top: B:489:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0464 A[Catch: all -> 0x0e6c, TryCatch #4 {all -> 0x0e6c, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0046, B:12:0x005c, B:15:0x0082, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:228:0x070f, B:24:0x0100, B:27:0x0116, B:29:0x011c, B:31:0x0122, B:33:0x0133, B:37:0x013e, B:39:0x0149, B:41:0x0155, B:43:0x015b, B:47:0x0166, B:48:0x0173, B:50:0x0181, B:53:0x01a1, B:55:0x01a7, B:57:0x01b7, B:59:0x01c5, B:61:0x01d5, B:62:0x01e2, B:63:0x01e5, B:65:0x01f2, B:67:0x01fc, B:68:0x020c, B:70:0x0229, B:72:0x0233, B:74:0x0247, B:75:0x0251, B:78:0x025c, B:79:0x0266, B:82:0x026e, B:85:0x027f, B:86:0x0282, B:88:0x0299, B:140:0x047d, B:141:0x0480, B:143:0x048a, B:146:0x049d, B:148:0x04b0, B:150:0x04bc, B:183:0x0593, B:185:0x05a0, B:187:0x05a6, B:189:0x05ac, B:191:0x05bf, B:192:0x05c2, B:194:0x05c7, B:196:0x05cd, B:197:0x05d9, B:199:0x05df, B:201:0x05ef, B:203:0x05f9, B:204:0x0610, B:206:0x0616, B:207:0x0631, B:209:0x0637, B:210:0x0655, B:211:0x0660, B:215:0x068b, B:212:0x0666, B:214:0x0678, B:216:0x0699, B:217:0x06b7, B:219:0x06bd, B:221:0x06d0, B:222:0x06dd, B:223:0x06e1, B:225:0x06e7, B:227:0x06fb, B:155:0x04e1, B:157:0x04f1, B:160:0x0504, B:162:0x0517, B:164:0x0523, B:167:0x053b, B:169:0x0549, B:171:0x0555, B:173:0x055f, B:176:0x056c, B:178:0x0572, B:180:0x0582, B:181:0x058d, B:97:0x02bf, B:100:0x02c9, B:102:0x02d7, B:106:0x0318, B:103:0x02f1, B:105:0x02ff, B:109:0x031f, B:112:0x0352, B:113:0x037c, B:115:0x03b3, B:117:0x03b9, B:120:0x03c5, B:122:0x03fc, B:123:0x0417, B:125:0x041d, B:127:0x042b, B:131:0x043e, B:128:0x0433, B:134:0x0445, B:137:0x044c, B:138:0x0464, B:231:0x0729, B:233:0x0737, B:235:0x0740, B:246:0x0772, B:236:0x0748, B:238:0x0751, B:240:0x0757, B:243:0x0763, B:245:0x076d, B:247:0x0775, B:248:0x0781, B:251:0x0789, B:253:0x079b, B:254:0x07a6, B:256:0x07ae, B:260:0x07d3, B:262:0x07ed, B:264:0x0802, B:266:0x081c, B:268:0x0831, B:269:0x083f, B:271:0x0845, B:273:0x0855, B:274:0x085c, B:276:0x0868, B:277:0x086f, B:278:0x0872, B:280:0x08b4, B:282:0x08ba, B:288:0x08e1, B:290:0x08e9, B:291:0x08f2, B:293:0x08f8, B:294:0x08fe, B:296:0x0913, B:298:0x0923, B:300:0x0933, B:302:0x093b, B:303:0x093e, B:311:0x09b0, B:313:0x09c9, B:315:0x09df, B:317:0x09e4, B:319:0x09e8, B:321:0x09ec, B:323:0x09f6, B:324:0x09fc, B:326:0x0a00, B:328:0x0a06, B:329:0x0a14, B:330:0x0a1d, B:335:0x0a42, B:339:0x0a49, B:283:0x08c8, B:285:0x08ce, B:287:0x08d4, B:267:0x082e, B:263:0x07ff, B:257:0x07b3, B:259:0x07b9), top: B:489:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0748 A[Catch: all -> 0x0e6c, TryCatch #4 {all -> 0x0e6c, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0046, B:12:0x005c, B:15:0x0082, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:228:0x070f, B:24:0x0100, B:27:0x0116, B:29:0x011c, B:31:0x0122, B:33:0x0133, B:37:0x013e, B:39:0x0149, B:41:0x0155, B:43:0x015b, B:47:0x0166, B:48:0x0173, B:50:0x0181, B:53:0x01a1, B:55:0x01a7, B:57:0x01b7, B:59:0x01c5, B:61:0x01d5, B:62:0x01e2, B:63:0x01e5, B:65:0x01f2, B:67:0x01fc, B:68:0x020c, B:70:0x0229, B:72:0x0233, B:74:0x0247, B:75:0x0251, B:78:0x025c, B:79:0x0266, B:82:0x026e, B:85:0x027f, B:86:0x0282, B:88:0x0299, B:140:0x047d, B:141:0x0480, B:143:0x048a, B:146:0x049d, B:148:0x04b0, B:150:0x04bc, B:183:0x0593, B:185:0x05a0, B:187:0x05a6, B:189:0x05ac, B:191:0x05bf, B:192:0x05c2, B:194:0x05c7, B:196:0x05cd, B:197:0x05d9, B:199:0x05df, B:201:0x05ef, B:203:0x05f9, B:204:0x0610, B:206:0x0616, B:207:0x0631, B:209:0x0637, B:210:0x0655, B:211:0x0660, B:215:0x068b, B:212:0x0666, B:214:0x0678, B:216:0x0699, B:217:0x06b7, B:219:0x06bd, B:221:0x06d0, B:222:0x06dd, B:223:0x06e1, B:225:0x06e7, B:227:0x06fb, B:155:0x04e1, B:157:0x04f1, B:160:0x0504, B:162:0x0517, B:164:0x0523, B:167:0x053b, B:169:0x0549, B:171:0x0555, B:173:0x055f, B:176:0x056c, B:178:0x0572, B:180:0x0582, B:181:0x058d, B:97:0x02bf, B:100:0x02c9, B:102:0x02d7, B:106:0x0318, B:103:0x02f1, B:105:0x02ff, B:109:0x031f, B:112:0x0352, B:113:0x037c, B:115:0x03b3, B:117:0x03b9, B:120:0x03c5, B:122:0x03fc, B:123:0x0417, B:125:0x041d, B:127:0x042b, B:131:0x043e, B:128:0x0433, B:134:0x0445, B:137:0x044c, B:138:0x0464, B:231:0x0729, B:233:0x0737, B:235:0x0740, B:246:0x0772, B:236:0x0748, B:238:0x0751, B:240:0x0757, B:243:0x0763, B:245:0x076d, B:247:0x0775, B:248:0x0781, B:251:0x0789, B:253:0x079b, B:254:0x07a6, B:256:0x07ae, B:260:0x07d3, B:262:0x07ed, B:264:0x0802, B:266:0x081c, B:268:0x0831, B:269:0x083f, B:271:0x0845, B:273:0x0855, B:274:0x085c, B:276:0x0868, B:277:0x086f, B:278:0x0872, B:280:0x08b4, B:282:0x08ba, B:288:0x08e1, B:290:0x08e9, B:291:0x08f2, B:293:0x08f8, B:294:0x08fe, B:296:0x0913, B:298:0x0923, B:300:0x0933, B:302:0x093b, B:303:0x093e, B:311:0x09b0, B:313:0x09c9, B:315:0x09df, B:317:0x09e4, B:319:0x09e8, B:321:0x09ec, B:323:0x09f6, B:324:0x09fc, B:326:0x0a00, B:328:0x0a06, B:329:0x0a14, B:330:0x0a1d, B:335:0x0a42, B:339:0x0a49, B:283:0x08c8, B:285:0x08ce, B:287:0x08d4, B:267:0x082e, B:263:0x07ff, B:257:0x07b3, B:259:0x07b9), top: B:489:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0a7e A[Catch: all -> 0x0e55, TryCatch #2 {all -> 0x0e55, blocks: (B:305:0x097f, B:306:0x0992, B:308:0x0998, B:401:0x0c6a, B:333:0x0a2c, B:341:0x0a5e, B:343:0x0a7e, B:344:0x0a86, B:346:0x0a8c, B:348:0x0a9e, B:355:0x0ac6, B:356:0x0ae9, B:358:0x0af5, B:360:0x0b0b, B:362:0x0b4a, B:366:0x0b60, B:368:0x0b69, B:370:0x0b77, B:372:0x0b7b, B:374:0x0b7f, B:376:0x0b83, B:377:0x0b8f, B:378:0x0b96, B:380:0x0b9c, B:382:0x0bb8, B:383:0x0bbd, B:400:0x0c67, B:384:0x0bd4, B:386:0x0bdb, B:390:0x0bfe, B:392:0x0c25, B:394:0x0c36, B:395:0x0c4b, B:397:0x0c55, B:387:0x0be6, B:353:0x0ab2, B:402:0x0c76, B:404:0x0c84, B:405:0x0c8a, B:406:0x0c92, B:408:0x0c98, B:411:0x0cb2, B:413:0x0cc2, B:433:0x0d43, B:414:0x0cda, B:416:0x0ce0, B:418:0x0cea, B:420:0x0cf1, B:426:0x0d01, B:428:0x0d08, B:430:0x0d34, B:432:0x0d3b, B:431:0x0d38, B:427:0x0d05, B:419:0x0cee), top: B:486:0x097f }] */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0ab2 A[Catch: all -> 0x0e55, EDGE_INSN: B:538:0x0ab2->B:353:0x0ab2 BREAK  A[LOOP:15: B:344:0x0a86->B:352:0x0aaf], TryCatch #2 {all -> 0x0e55, blocks: (B:305:0x097f, B:306:0x0992, B:308:0x0998, B:401:0x0c6a, B:333:0x0a2c, B:341:0x0a5e, B:343:0x0a7e, B:344:0x0a86, B:346:0x0a8c, B:348:0x0a9e, B:355:0x0ac6, B:356:0x0ae9, B:358:0x0af5, B:360:0x0b0b, B:362:0x0b4a, B:366:0x0b60, B:368:0x0b69, B:370:0x0b77, B:372:0x0b7b, B:374:0x0b7f, B:376:0x0b83, B:377:0x0b8f, B:378:0x0b96, B:380:0x0b9c, B:382:0x0bb8, B:383:0x0bbd, B:400:0x0c67, B:384:0x0bd4, B:386:0x0bdb, B:390:0x0bfe, B:392:0x0c25, B:394:0x0c36, B:395:0x0c4b, B:397:0x0c55, B:387:0x0be6, B:353:0x0ab2, B:402:0x0c76, B:404:0x0c84, B:405:0x0c8a, B:406:0x0c92, B:408:0x0c98, B:411:0x0cb2, B:413:0x0cc2, B:433:0x0d43, B:414:0x0cda, B:416:0x0ce0, B:418:0x0cea, B:420:0x0cf1, B:426:0x0d01, B:428:0x0d08, B:430:0x0d34, B:432:0x0d3b, B:431:0x0d38, B:427:0x0d05, B:419:0x0cee), top: B:486:0x097f }] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0ac6 A[Catch: all -> 0x0e55, TryCatch #2 {all -> 0x0e55, blocks: (B:305:0x097f, B:306:0x0992, B:308:0x0998, B:401:0x0c6a, B:333:0x0a2c, B:341:0x0a5e, B:343:0x0a7e, B:344:0x0a86, B:346:0x0a8c, B:348:0x0a9e, B:355:0x0ac6, B:356:0x0ae9, B:358:0x0af5, B:360:0x0b0b, B:362:0x0b4a, B:366:0x0b60, B:368:0x0b69, B:370:0x0b77, B:372:0x0b7b, B:374:0x0b7f, B:376:0x0b83, B:377:0x0b8f, B:378:0x0b96, B:380:0x0b9c, B:382:0x0bb8, B:383:0x0bbd, B:400:0x0c67, B:384:0x0bd4, B:386:0x0bdb, B:390:0x0bfe, B:392:0x0c25, B:394:0x0c36, B:395:0x0c4b, B:397:0x0c55, B:387:0x0be6, B:353:0x0ab2, B:402:0x0c76, B:404:0x0c84, B:405:0x0c8a, B:406:0x0c92, B:408:0x0c98, B:411:0x0cb2, B:413:0x0cc2, B:433:0x0d43, B:414:0x0cda, B:416:0x0ce0, B:418:0x0cea, B:420:0x0cf1, B:426:0x0d01, B:428:0x0d08, B:430:0x0d34, B:432:0x0d3b, B:431:0x0d38, B:427:0x0d05, B:419:0x0cee), top: B:486:0x097f }] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0ae9 A[Catch: all -> 0x0e55, TryCatch #2 {all -> 0x0e55, blocks: (B:305:0x097f, B:306:0x0992, B:308:0x0998, B:401:0x0c6a, B:333:0x0a2c, B:341:0x0a5e, B:343:0x0a7e, B:344:0x0a86, B:346:0x0a8c, B:348:0x0a9e, B:355:0x0ac6, B:356:0x0ae9, B:358:0x0af5, B:360:0x0b0b, B:362:0x0b4a, B:366:0x0b60, B:368:0x0b69, B:370:0x0b77, B:372:0x0b7b, B:374:0x0b7f, B:376:0x0b83, B:377:0x0b8f, B:378:0x0b96, B:380:0x0b9c, B:382:0x0bb8, B:383:0x0bbd, B:400:0x0c67, B:384:0x0bd4, B:386:0x0bdb, B:390:0x0bfe, B:392:0x0c25, B:394:0x0c36, B:395:0x0c4b, B:397:0x0c55, B:387:0x0be6, B:353:0x0ab2, B:402:0x0c76, B:404:0x0c84, B:405:0x0c8a, B:406:0x0c92, B:408:0x0c98, B:411:0x0cb2, B:413:0x0cc2, B:433:0x0d43, B:414:0x0cda, B:416:0x0ce0, B:418:0x0cea, B:420:0x0cf1, B:426:0x0d01, B:428:0x0d08, B:430:0x0d34, B:432:0x0d3b, B:431:0x0d38, B:427:0x0d05, B:419:0x0cee), top: B:486:0x097f }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0181 A[Catch: all -> 0x0e6c, TryCatch #4 {all -> 0x0e6c, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0046, B:12:0x005c, B:15:0x0082, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:228:0x070f, B:24:0x0100, B:27:0x0116, B:29:0x011c, B:31:0x0122, B:33:0x0133, B:37:0x013e, B:39:0x0149, B:41:0x0155, B:43:0x015b, B:47:0x0166, B:48:0x0173, B:50:0x0181, B:53:0x01a1, B:55:0x01a7, B:57:0x01b7, B:59:0x01c5, B:61:0x01d5, B:62:0x01e2, B:63:0x01e5, B:65:0x01f2, B:67:0x01fc, B:68:0x020c, B:70:0x0229, B:72:0x0233, B:74:0x0247, B:75:0x0251, B:78:0x025c, B:79:0x0266, B:82:0x026e, B:85:0x027f, B:86:0x0282, B:88:0x0299, B:140:0x047d, B:141:0x0480, B:143:0x048a, B:146:0x049d, B:148:0x04b0, B:150:0x04bc, B:183:0x0593, B:185:0x05a0, B:187:0x05a6, B:189:0x05ac, B:191:0x05bf, B:192:0x05c2, B:194:0x05c7, B:196:0x05cd, B:197:0x05d9, B:199:0x05df, B:201:0x05ef, B:203:0x05f9, B:204:0x0610, B:206:0x0616, B:207:0x0631, B:209:0x0637, B:210:0x0655, B:211:0x0660, B:215:0x068b, B:212:0x0666, B:214:0x0678, B:216:0x0699, B:217:0x06b7, B:219:0x06bd, B:221:0x06d0, B:222:0x06dd, B:223:0x06e1, B:225:0x06e7, B:227:0x06fb, B:155:0x04e1, B:157:0x04f1, B:160:0x0504, B:162:0x0517, B:164:0x0523, B:167:0x053b, B:169:0x0549, B:171:0x0555, B:173:0x055f, B:176:0x056c, B:178:0x0572, B:180:0x0582, B:181:0x058d, B:97:0x02bf, B:100:0x02c9, B:102:0x02d7, B:106:0x0318, B:103:0x02f1, B:105:0x02ff, B:109:0x031f, B:112:0x0352, B:113:0x037c, B:115:0x03b3, B:117:0x03b9, B:120:0x03c5, B:122:0x03fc, B:123:0x0417, B:125:0x041d, B:127:0x042b, B:131:0x043e, B:128:0x0433, B:134:0x0445, B:137:0x044c, B:138:0x0464, B:231:0x0729, B:233:0x0737, B:235:0x0740, B:246:0x0772, B:236:0x0748, B:238:0x0751, B:240:0x0757, B:243:0x0763, B:245:0x076d, B:247:0x0775, B:248:0x0781, B:251:0x0789, B:253:0x079b, B:254:0x07a6, B:256:0x07ae, B:260:0x07d3, B:262:0x07ed, B:264:0x0802, B:266:0x081c, B:268:0x0831, B:269:0x083f, B:271:0x0845, B:273:0x0855, B:274:0x085c, B:276:0x0868, B:277:0x086f, B:278:0x0872, B:280:0x08b4, B:282:0x08ba, B:288:0x08e1, B:290:0x08e9, B:291:0x08f2, B:293:0x08f8, B:294:0x08fe, B:296:0x0913, B:298:0x0923, B:300:0x0933, B:302:0x093b, B:303:0x093e, B:311:0x09b0, B:313:0x09c9, B:315:0x09df, B:317:0x09e4, B:319:0x09e8, B:321:0x09ec, B:323:0x09f6, B:324:0x09fc, B:326:0x0a00, B:328:0x0a06, B:329:0x0a14, B:330:0x0a1d, B:335:0x0a42, B:339:0x0a49, B:283:0x08c8, B:285:0x08ce, B:287:0x08d4, B:267:0x082e, B:263:0x07ff, B:257:0x07b3, B:259:0x07b9), top: B:489:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0247 A[Catch: all -> 0x0e6c, TryCatch #4 {all -> 0x0e6c, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0046, B:12:0x005c, B:15:0x0082, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:228:0x070f, B:24:0x0100, B:27:0x0116, B:29:0x011c, B:31:0x0122, B:33:0x0133, B:37:0x013e, B:39:0x0149, B:41:0x0155, B:43:0x015b, B:47:0x0166, B:48:0x0173, B:50:0x0181, B:53:0x01a1, B:55:0x01a7, B:57:0x01b7, B:59:0x01c5, B:61:0x01d5, B:62:0x01e2, B:63:0x01e5, B:65:0x01f2, B:67:0x01fc, B:68:0x020c, B:70:0x0229, B:72:0x0233, B:74:0x0247, B:75:0x0251, B:78:0x025c, B:79:0x0266, B:82:0x026e, B:85:0x027f, B:86:0x0282, B:88:0x0299, B:140:0x047d, B:141:0x0480, B:143:0x048a, B:146:0x049d, B:148:0x04b0, B:150:0x04bc, B:183:0x0593, B:185:0x05a0, B:187:0x05a6, B:189:0x05ac, B:191:0x05bf, B:192:0x05c2, B:194:0x05c7, B:196:0x05cd, B:197:0x05d9, B:199:0x05df, B:201:0x05ef, B:203:0x05f9, B:204:0x0610, B:206:0x0616, B:207:0x0631, B:209:0x0637, B:210:0x0655, B:211:0x0660, B:215:0x068b, B:212:0x0666, B:214:0x0678, B:216:0x0699, B:217:0x06b7, B:219:0x06bd, B:221:0x06d0, B:222:0x06dd, B:223:0x06e1, B:225:0x06e7, B:227:0x06fb, B:155:0x04e1, B:157:0x04f1, B:160:0x0504, B:162:0x0517, B:164:0x0523, B:167:0x053b, B:169:0x0549, B:171:0x0555, B:173:0x055f, B:176:0x056c, B:178:0x0572, B:180:0x0582, B:181:0x058d, B:97:0x02bf, B:100:0x02c9, B:102:0x02d7, B:106:0x0318, B:103:0x02f1, B:105:0x02ff, B:109:0x031f, B:112:0x0352, B:113:0x037c, B:115:0x03b3, B:117:0x03b9, B:120:0x03c5, B:122:0x03fc, B:123:0x0417, B:125:0x041d, B:127:0x042b, B:131:0x043e, B:128:0x0433, B:134:0x0445, B:137:0x044c, B:138:0x0464, B:231:0x0729, B:233:0x0737, B:235:0x0740, B:246:0x0772, B:236:0x0748, B:238:0x0751, B:240:0x0757, B:243:0x0763, B:245:0x076d, B:247:0x0775, B:248:0x0781, B:251:0x0789, B:253:0x079b, B:254:0x07a6, B:256:0x07ae, B:260:0x07d3, B:262:0x07ed, B:264:0x0802, B:266:0x081c, B:268:0x0831, B:269:0x083f, B:271:0x0845, B:273:0x0855, B:274:0x085c, B:276:0x0868, B:277:0x086f, B:278:0x0872, B:280:0x08b4, B:282:0x08ba, B:288:0x08e1, B:290:0x08e9, B:291:0x08f2, B:293:0x08f8, B:294:0x08fe, B:296:0x0913, B:298:0x0923, B:300:0x0933, B:302:0x093b, B:303:0x093e, B:311:0x09b0, B:313:0x09c9, B:315:0x09df, B:317:0x09e4, B:319:0x09e8, B:321:0x09ec, B:323:0x09f6, B:324:0x09fc, B:326:0x0a00, B:328:0x0a06, B:329:0x0a14, B:330:0x0a1d, B:335:0x0a42, B:339:0x0a49, B:283:0x08c8, B:285:0x08ce, B:287:0x08d4, B:267:0x082e, B:263:0x07ff, B:257:0x07b3, B:259:0x07b9), top: B:489:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x025c A[Catch: all -> 0x0e6c, TryCatch #4 {all -> 0x0e6c, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0046, B:12:0x005c, B:15:0x0082, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:228:0x070f, B:24:0x0100, B:27:0x0116, B:29:0x011c, B:31:0x0122, B:33:0x0133, B:37:0x013e, B:39:0x0149, B:41:0x0155, B:43:0x015b, B:47:0x0166, B:48:0x0173, B:50:0x0181, B:53:0x01a1, B:55:0x01a7, B:57:0x01b7, B:59:0x01c5, B:61:0x01d5, B:62:0x01e2, B:63:0x01e5, B:65:0x01f2, B:67:0x01fc, B:68:0x020c, B:70:0x0229, B:72:0x0233, B:74:0x0247, B:75:0x0251, B:78:0x025c, B:79:0x0266, B:82:0x026e, B:85:0x027f, B:86:0x0282, B:88:0x0299, B:140:0x047d, B:141:0x0480, B:143:0x048a, B:146:0x049d, B:148:0x04b0, B:150:0x04bc, B:183:0x0593, B:185:0x05a0, B:187:0x05a6, B:189:0x05ac, B:191:0x05bf, B:192:0x05c2, B:194:0x05c7, B:196:0x05cd, B:197:0x05d9, B:199:0x05df, B:201:0x05ef, B:203:0x05f9, B:204:0x0610, B:206:0x0616, B:207:0x0631, B:209:0x0637, B:210:0x0655, B:211:0x0660, B:215:0x068b, B:212:0x0666, B:214:0x0678, B:216:0x0699, B:217:0x06b7, B:219:0x06bd, B:221:0x06d0, B:222:0x06dd, B:223:0x06e1, B:225:0x06e7, B:227:0x06fb, B:155:0x04e1, B:157:0x04f1, B:160:0x0504, B:162:0x0517, B:164:0x0523, B:167:0x053b, B:169:0x0549, B:171:0x0555, B:173:0x055f, B:176:0x056c, B:178:0x0572, B:180:0x0582, B:181:0x058d, B:97:0x02bf, B:100:0x02c9, B:102:0x02d7, B:106:0x0318, B:103:0x02f1, B:105:0x02ff, B:109:0x031f, B:112:0x0352, B:113:0x037c, B:115:0x03b3, B:117:0x03b9, B:120:0x03c5, B:122:0x03fc, B:123:0x0417, B:125:0x041d, B:127:0x042b, B:131:0x043e, B:128:0x0433, B:134:0x0445, B:137:0x044c, B:138:0x0464, B:231:0x0729, B:233:0x0737, B:235:0x0740, B:246:0x0772, B:236:0x0748, B:238:0x0751, B:240:0x0757, B:243:0x0763, B:245:0x076d, B:247:0x0775, B:248:0x0781, B:251:0x0789, B:253:0x079b, B:254:0x07a6, B:256:0x07ae, B:260:0x07d3, B:262:0x07ed, B:264:0x0802, B:266:0x081c, B:268:0x0831, B:269:0x083f, B:271:0x0845, B:273:0x0855, B:274:0x085c, B:276:0x0868, B:277:0x086f, B:278:0x0872, B:280:0x08b4, B:282:0x08ba, B:288:0x08e1, B:290:0x08e9, B:291:0x08f2, B:293:0x08f8, B:294:0x08fe, B:296:0x0913, B:298:0x0923, B:300:0x0933, B:302:0x093b, B:303:0x093e, B:311:0x09b0, B:313:0x09c9, B:315:0x09df, B:317:0x09e4, B:319:0x09e8, B:321:0x09ec, B:323:0x09f6, B:324:0x09fc, B:326:0x0a00, B:328:0x0a06, B:329:0x0a14, B:330:0x0a1d, B:335:0x0a42, B:339:0x0a49, B:283:0x08c8, B:285:0x08ce, B:287:0x08d4, B:267:0x082e, B:263:0x07ff, B:257:0x07b3, B:259:0x07b9), top: B:489:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0299 A[Catch: all -> 0x0e6c, TRY_LEAVE, TryCatch #4 {all -> 0x0e6c, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0046, B:12:0x005c, B:15:0x0082, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:228:0x070f, B:24:0x0100, B:27:0x0116, B:29:0x011c, B:31:0x0122, B:33:0x0133, B:37:0x013e, B:39:0x0149, B:41:0x0155, B:43:0x015b, B:47:0x0166, B:48:0x0173, B:50:0x0181, B:53:0x01a1, B:55:0x01a7, B:57:0x01b7, B:59:0x01c5, B:61:0x01d5, B:62:0x01e2, B:63:0x01e5, B:65:0x01f2, B:67:0x01fc, B:68:0x020c, B:70:0x0229, B:72:0x0233, B:74:0x0247, B:75:0x0251, B:78:0x025c, B:79:0x0266, B:82:0x026e, B:85:0x027f, B:86:0x0282, B:88:0x0299, B:140:0x047d, B:141:0x0480, B:143:0x048a, B:146:0x049d, B:148:0x04b0, B:150:0x04bc, B:183:0x0593, B:185:0x05a0, B:187:0x05a6, B:189:0x05ac, B:191:0x05bf, B:192:0x05c2, B:194:0x05c7, B:196:0x05cd, B:197:0x05d9, B:199:0x05df, B:201:0x05ef, B:203:0x05f9, B:204:0x0610, B:206:0x0616, B:207:0x0631, B:209:0x0637, B:210:0x0655, B:211:0x0660, B:215:0x068b, B:212:0x0666, B:214:0x0678, B:216:0x0699, B:217:0x06b7, B:219:0x06bd, B:221:0x06d0, B:222:0x06dd, B:223:0x06e1, B:225:0x06e7, B:227:0x06fb, B:155:0x04e1, B:157:0x04f1, B:160:0x0504, B:162:0x0517, B:164:0x0523, B:167:0x053b, B:169:0x0549, B:171:0x0555, B:173:0x055f, B:176:0x056c, B:178:0x0572, B:180:0x0582, B:181:0x058d, B:97:0x02bf, B:100:0x02c9, B:102:0x02d7, B:106:0x0318, B:103:0x02f1, B:105:0x02ff, B:109:0x031f, B:112:0x0352, B:113:0x037c, B:115:0x03b3, B:117:0x03b9, B:120:0x03c5, B:122:0x03fc, B:123:0x0417, B:125:0x041d, B:127:0x042b, B:131:0x043e, B:128:0x0433, B:134:0x0445, B:137:0x044c, B:138:0x0464, B:231:0x0729, B:233:0x0737, B:235:0x0740, B:246:0x0772, B:236:0x0748, B:238:0x0751, B:240:0x0757, B:243:0x0763, B:245:0x076d, B:247:0x0775, B:248:0x0781, B:251:0x0789, B:253:0x079b, B:254:0x07a6, B:256:0x07ae, B:260:0x07d3, B:262:0x07ed, B:264:0x0802, B:266:0x081c, B:268:0x0831, B:269:0x083f, B:271:0x0845, B:273:0x0855, B:274:0x085c, B:276:0x0868, B:277:0x086f, B:278:0x0872, B:280:0x08b4, B:282:0x08ba, B:288:0x08e1, B:290:0x08e9, B:291:0x08f2, B:293:0x08f8, B:294:0x08fe, B:296:0x0913, B:298:0x0923, B:300:0x0933, B:302:0x093b, B:303:0x093e, B:311:0x09b0, B:313:0x09c9, B:315:0x09df, B:317:0x09e4, B:319:0x09e8, B:321:0x09ec, B:323:0x09f6, B:324:0x09fc, B:326:0x0a00, B:328:0x0a06, B:329:0x0a14, B:330:0x0a1d, B:335:0x0a42, B:339:0x0a49, B:283:0x08c8, B:285:0x08ce, B:287:0x08d4, B:267:0x082e, B:263:0x07ff, B:257:0x07b3, B:259:0x07b9), top: B:489:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzaH(java.lang.String r43, long r44) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3703
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzaH(java.lang.String, long):boolean");
    }

    private final void zzaI(com.google.android.gms.internal.measurement.zzic zzicVar, long j, boolean z) {
        Object obj;
        String str = true != z ? "_lte" : "_se";
        zzpn zzpnVarZzm = zzj().zzm(zzicVar.zzK(), str);
        zzpn zzpnVar = (zzpnVarZzm == null || (obj = zzpnVarZzm.zze) == null) ? new zzpn(zzicVar.zzK(), "auto", str, zzba().currentTimeMillis(), Long.valueOf(j)) : new zzpn(zzicVar.zzK(), "auto", str, zzba().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
        zzitVarZzm.zzb(str);
        zzitVarZzm.zza(zzba().currentTimeMillis());
        Object obj2 = zzpnVar.zze;
        zzitVarZzm.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbd();
        int iZzx = zzpk.zzx(zzicVar, str);
        if (iZzx >= 0) {
            zzicVar.zzn(iZzx, zziuVar);
        } else {
            zzicVar.zzo(zziuVar);
        }
        if (j > 0) {
            zzj().zzl(zzpnVar);
            zzaW().zzk().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    private final boolean zzaJ(com.google.android.gms.internal.measurement.zzhr zzhrVar, com.google.android.gms.internal.measurement.zzhr zzhrVar2) {
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd(), "_sc");
        String strZzd = zzhwVarZzI == null ? null : zzhwVarZzI.zzd();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI2 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbd(), "_pc");
        String strZzd2 = zzhwVarZzI2 != null ? zzhwVarZzI2.zzd() : null;
        if (strZzd2 == null || !strZzd2.equals(strZzd)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI3 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd(), "_et");
        if (zzhwVarZzI3 == null || !zzhwVarZzI3.zze() || zzhwVarZzI3.zzf() <= 0) {
            return true;
        }
        long jZzf = zzhwVarZzI3.zzf();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI4 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbd(), "_et");
        if (zzhwVarZzI4 != null && zzhwVarZzI4.zzf() > 0) {
            jZzf += zzhwVarZzI4.zzf();
        }
        zzp();
        zzpk.zzF(zzhrVar2, "_et", Long.valueOf(jZzf));
        zzp();
        zzpk.zzF(zzhrVar, "_fr", 1L);
        return true;
    }

    private final void zzaK(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str, String str2) {
        ArrayList arrayList = new ArrayList(zzhrVar.zza());
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zzb())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        double dZzk = zzhrVar.zzc(i).zzk() * 1000000.0d;
        if (dZzk == 0.0d) {
            dZzk = zzhrVar.zzc(i).zzf() * 1000000.0d;
        }
        if (dZzk > 9.223372036854776E18d || dZzk < -9.223372036854776E18d) {
            zzaW().zze().zzc("Data lost. Purchase " + str + " is too big. appId", zzgu.zzl(str2), Double.valueOf(dZzk));
            return;
        }
        zzhrVar.zzj(i);
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn.zzb(str);
        zzhvVarZzn.zzf(Math.round(dZzk));
        zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd());
    }

    private final boolean zzaL() {
        zzaX().zzg();
        zzu();
        return zzj().zzP() || !TextUtils.isEmpty(zzj().zzF());
    }

    private final void zzaM() {
        long jMax;
        long jMax2;
        zzaX().zzg();
        zzu();
        if (this.zza > 0) {
            long jAbs = 3600000 - Math.abs(zzba().elapsedRealtime() - this.zza);
            if (jAbs > 0) {
                zzaW().zzk().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                zzk().zzb();
                zzl().zzf();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzH() || !zzaL()) {
            zzaW().zzk().zza("Nothing to upload or uploading impossible");
            zzk().zzb();
            zzl().zzf();
            return;
        }
        long jCurrentTimeMillis = zzba().currentTimeMillis();
        zzd();
        long jMax3 = Math.max(0L, ((Long) zzfy.zzO.zzb(null)).longValue());
        boolean z = true;
        if (!zzj().zzR() && !zzj().zzG()) {
            z = false;
        }
        if (z) {
            String strZzA = zzd().zzA();
            if (TextUtils.isEmpty(strZzA) || ".none.".equals(strZzA)) {
                zzd();
                jMax = Math.max(0L, ((Long) zzfy.zzI.zzb(null)).longValue());
            } else {
                zzd();
                jMax = Math.max(0L, ((Long) zzfy.zzJ.zzb(null)).longValue());
            }
        } else {
            zzd();
            jMax = Math.max(0L, ((Long) zzfy.zzH.zzb(null)).longValue());
        }
        long jZza = this.zzk.zzd.zza();
        long jZza2 = this.zzk.zze.zza();
        boolean z2 = z;
        long jMax4 = Math.max(zzj().zzM(), zzj().zzO());
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            jMax2 = jAbs2 + jMax3;
            long jMax5 = Math.max(jAbs3, jAbs4);
            if (z2 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + jMax;
            }
            if (!zzp().zzs(jMax5, jMax)) {
                jMax2 = jMax5 + jMax;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i = 0;
                while (true) {
                    zzd();
                    if (i >= Math.min(20, Math.max(0, ((Integer) zzfy.zzQ.zzb(null)).intValue()))) {
                        break;
                    }
                    zzd();
                    jMax2 += Math.max(0L, ((Long) zzfy.zzP.zzb(null)).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        if (jMax2 == 0) {
            zzaW().zzk().zza("Next upload time is 0");
            zzk().zzb();
            zzl().zzf();
            return;
        }
        if (!zzi().zzb()) {
            zzaW().zzk().zza("No network");
            zzk().zza();
            zzl().zzf();
            return;
        }
        long jZza3 = this.zzk.zzc.zza();
        zzd();
        long jMax6 = Math.max(0L, ((Long) zzfy.zzF.zzb(null)).longValue());
        if (!zzp().zzs(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzk().zzb();
        long jCurrentTimeMillis2 = jMax2 - zzba().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            zzd();
            jCurrentTimeMillis2 = Math.max(0L, ((Long) zzfy.zzK.zzb(null)).longValue());
            this.zzk.zzd.zzb(zzba().currentTimeMillis());
        }
        zzaW().zzk().zzb("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        zzl().zzd(jCurrentTimeMillis2);
    }

    private final void zzaN() {
        zzaX().zzg();
        if (this.zzu || this.zzv || this.zzw) {
            zzaW().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzaW().zzk().zza("Stopping uploading service(s)");
        List list = this.zzq;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    private final Boolean zzaO(zzh zzhVar) {
        try {
            if (zzhVar.zzt() != -2147483648L) {
                if (zzhVar.zzt() == Wrappers.packageManager(this.zzn.zzaZ()).getPackageInfo(zzhVar.zzc(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzaZ()).getPackageInfo(zzhVar.zzc(), 0).versionName;
                String strZzr = zzhVar.zzr();
                if (strZzr != null && strZzr.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzr zzaP(String str) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu == null || TextUtils.isEmpty(zzhVarZzu.zzr())) {
            zzaW().zzj().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean boolZzaO = zzaO(zzhVarZzu);
        if (boolZzaO == null || boolZzaO.booleanValue()) {
            return new zzr(str, zzhVarZzu.zzf(), zzhVarZzu.zzr(), zzhVarZzu.zzt(), zzhVarZzu.zzv(), zzhVarZzu.zzx(), zzhVarZzu.zzz(), (String) null, zzhVarZzu.zzD(), false, zzhVarZzu.zzl(), 0L, 0, zzhVarZzu.zzac(), false, zzhVarZzu.zzae(), zzhVarZzu.zzB(), zzhVarZzu.zzag(), zzB(str).zzl(), "", (String) null, zzhVarZzu.zzai(), zzhVarZzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzhVarZzu.zzao(), zzhVarZzu.zzaw(), zzhVarZzu.zzay(), zzhVarZzu.zzaH(), 0L, zzhVarZzu.zzaL(), 0L);
        }
        zzaW().zzb().zzb("App version does not match; dropping. appId", zzgu.zzl(str));
        return null;
    }

    private final boolean zzaQ(String str, String str2) {
        zzbd zzbdVarZzf = zzj().zzf(str, str2);
        return zzbdVarZzf == null || zzbdVarZzf.zzc < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaR(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private static final boolean zzaS(zzr zzrVar) {
        return !TextUtils.isEmpty(zzrVar.zzb);
    }

    private static final zzos zzaT(zzos zzosVar) {
        if (zzosVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzosVar.zzax()) {
            return zzosVar;
        }
        String strValueOf = String.valueOf(zzosVar.getClass());
        String.valueOf(strValueOf);
        throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(strValueOf)));
    }

    private static final Boolean zzaU(zzr zzrVar) {
        Boolean bool = zzrVar.zzp;
        String str = zzrVar.zzC;
        if (!TextUtils.isEmpty(str)) {
            zzji zzjiVarZza = zze.zzc(str).zza();
            zzji zzjiVar = zzji.UNINITIALIZED;
            int iOrdinal = zzjiVarZza.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return null;
            }
            if (iOrdinal == 2) {
                return true;
            }
            if (iOrdinal == 3) {
                return false;
            }
        }
        return bool;
    }

    final void zzA(String str, zzjl zzjlVar) {
        zzaX().zzg();
        zzu();
        this.zzC.put(str, zzjlVar);
        zzj().zzaa(str, zzjlVar);
    }

    final zzjl zzB(String str) {
        zzjl zzjlVar = zzjl.zza;
        zzaX().zzg();
        zzu();
        zzjl zzjlVarZzY = (zzjl) this.zzC.get(str);
        if (zzjlVarZzY == null) {
            zzjlVarZzY = zzj().zzY(str);
            if (zzjlVarZzY == null) {
                zzjlVarZzY = zzjl.zza;
            }
            zzA(str, zzjlVarZzY);
        }
        return zzjlVarZzY;
    }

    final long zzC() {
        long jCurrentTimeMillis = zzba().currentTimeMillis();
        zznn zznnVar = this.zzk;
        zznnVar.zzay();
        zznnVar.zzg();
        zzhe zzheVar = zznnVar.zzf;
        long jZza = zzheVar.zza();
        if (jZza == 0) {
            jZza = ((long) zznnVar.zzu.zzk().zzf().nextInt(86400000)) + 1;
            zzheVar.zzb(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    final void zzD(zzbh zzbhVar, String str) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu == null || TextUtils.isEmpty(zzhVarZzu.zzr())) {
            zzaW().zzj().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean boolZzaO = zzaO(zzhVarZzu);
        if (boolZzaO == null) {
            if (!"_ui".equals(zzbhVar.zza)) {
                zzaW().zze().zzb("Could not find package. appId", zzgu.zzl(str));
            }
        } else if (!boolZzaO.booleanValue()) {
            zzaW().zzb().zzb("App version does not match; dropping event. appId", zzgu.zzl(str));
            return;
        }
        zzE(zzbhVar, new zzr(str, zzhVarZzu.zzf(), zzhVarZzu.zzr(), zzhVarZzu.zzt(), zzhVarZzu.zzv(), zzhVarZzu.zzx(), zzhVarZzu.zzz(), (String) null, zzhVarZzu.zzD(), false, zzhVarZzu.zzl(), 0L, 0, zzhVarZzu.zzac(), false, zzhVarZzu.zzae(), zzhVarZzu.zzB(), zzhVarZzu.zzag(), zzB(str).zzl(), "", (String) null, zzhVarZzu.zzai(), zzhVarZzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzhVarZzu.zzao(), zzhVarZzu.zzaw(), zzhVarZzu.zzay(), zzhVarZzu.zzaH(), 0L, zzhVarZzu.zzaL(), 0L));
    }

    final void zzE(zzbh zzbhVar, zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzgv zzgvVarZza = zzgv.zza(zzbhVar);
        zzt().zzK(zzgvVarZza.zze, zzj().zzV(str));
        zzt().zzI(zzgvVarZza, zzd().zzd(str));
        zzbh zzbhVarZzb = zzgvVarZza.zzb();
        if (!zzd().zzp(null, zzfy.zzaZ) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzbhVarZzb.zza)) {
            zzbf zzbfVar = zzbhVarZzb.zzb;
            if ("referrer API v2".equals(zzbfVar.zzd("_cis"))) {
                String strZzd = zzbfVar.zzd("gclid");
                if (!TextUtils.isEmpty(strZzd)) {
                    zzad(new zzpl("_lgclid", zzbhVarZzb.zzd, strZzd, "auto"), zzrVar);
                }
            }
        }
        zzF(zzbhVarZzb, zzrVar);
    }

    final void zzF(zzbh zzbhVar, zzr zzrVar) {
        long j;
        long j2;
        List<zzah> listZzt;
        List<zzah> listZzt2;
        List<zzah> listZzt3;
        long j3;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaX().zzg();
        zzu();
        long j4 = zzbhVar.zzd;
        long j5 = zzbhVar.zze;
        zzgv zzgvVarZza = zzgv.zza(zzbhVar);
        zzaX().zzg();
        zzlu zzluVar = this.zzG;
        if (zzluVar == null || (str = this.zzH) == null || !str.equals(str2)) {
            zzluVar = null;
        }
        zzpp.zzay(zzluVar, zzgvVarZza.zze, false);
        zzbh zzbhVarZzb = zzgvVarZza.zzb();
        zzp();
        if (zzpk.zzG(zzbhVarZzb, zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            List list = zzrVar.zzr;
            if (list != null) {
                String str3 = zzbhVarZzb.zza;
                if (!list.contains(str3)) {
                    zzaW().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", str2, str3, zzbhVarZzb.zzc);
                    return;
                }
                Bundle bundleZzf = zzbhVarZzb.zzb.zzf();
                j2 = j4;
                bundleZzf.putLong("ga_safelisted", 1L);
                j = j5;
                zzbhVarZzb = new zzbh(str3, new zzbf(bundleZzf), zzbhVarZzb.zzc, zzbhVarZzb.zzd, zzbhVarZzb.zze);
            } else {
                j = j5;
                j2 = j4;
            }
            zzj().zzb();
            try {
                String str4 = zzbhVarZzb.zza;
                if ("_s".equals(str4) && !zzj().zzQ(str2, "_s") && zzbhVarZzb.zzb.zzb("_sid").longValue() != 0) {
                    if (zzj().zzQ(str2, "_f") || zzj().zzQ(str2, "_v")) {
                        zzj().zzX(str2, null, "_sid", zzG(str2, zzbhVarZzb));
                    } else {
                        zzj().zzX(str2, Long.valueOf(zzba().currentTimeMillis() - 15000), "_sid", zzG(str2, zzbhVarZzb));
                    }
                }
                zzaw zzawVarZzj = zzj();
                Preconditions.checkNotEmpty(str2);
                zzawVarZzj.zzg();
                zzawVarZzj.zzay();
                if (j2 < 0) {
                    zzawVarZzj.zzu.zzaW().zze().zzc("Invalid time querying timed out conditional properties", zzgu.zzl(str2), Long.valueOf(j2));
                    listZzt = Collections.emptyList();
                } else {
                    listZzt = zzawVarZzj.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j2)});
                }
                for (zzah zzahVar : listZzt) {
                    if (zzahVar != null) {
                        zzaW().zzk().zzd("User property timed out", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb), zzahVar.zzc.zza());
                        zzbh zzbhVar2 = zzahVar.zzg;
                        if (zzbhVar2 != null) {
                            j3 = j;
                            zzH(new zzbh(zzbhVar2, j2, j3), zzrVar);
                        } else {
                            j3 = j;
                        }
                        zzj().zzr(str2, zzahVar.zzc.zzb);
                        j = j3;
                    }
                }
                long j6 = j;
                zzaw zzawVarZzj2 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzawVarZzj2.zzg();
                zzawVarZzj2.zzay();
                if (j2 < 0) {
                    zzawVarZzj2.zzu.zzaW().zze().zzc("Invalid time querying expired conditional properties", zzgu.zzl(str2), Long.valueOf(j2));
                    listZzt2 = Collections.emptyList();
                } else {
                    listZzt2 = zzawVarZzj2.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j2)});
                }
                ArrayList arrayList = new ArrayList(listZzt2.size());
                for (zzah zzahVar2 : listZzt2) {
                    if (zzahVar2 != null) {
                        zzaW().zzk().zzd("User property expired", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                        zzj().zzk(str2, zzahVar2.zzc.zzb);
                        zzbh zzbhVar3 = zzahVar2.zzk;
                        if (zzbhVar3 != null) {
                            arrayList.add(zzbhVar3);
                        }
                        zzj().zzr(str2, zzahVar2.zzc.zzb);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzH(new zzbh((zzbh) it.next(), j2, j6), zzrVar);
                }
                zzaw zzawVarZzj3 = zzj();
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str4);
                zzawVarZzj3.zzg();
                zzawVarZzj3.zzay();
                if (j2 < 0) {
                    zzic zzicVar = zzawVarZzj3.zzu;
                    zzicVar.zzaW().zze().zzd("Invalid time querying triggered conditional properties", zzgu.zzl(str2), zzicVar.zzl().zza(str4), Long.valueOf(j2));
                    listZzt3 = Collections.emptyList();
                } else {
                    listZzt3 = zzawVarZzj3.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j2)});
                }
                ArrayList arrayList2 = new ArrayList(listZzt3.size());
                for (zzah zzahVar3 : listZzt3) {
                    if (zzahVar3 != null) {
                        zzpl zzplVar = zzahVar3.zzc;
                        zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar3.zza), zzahVar3.zzb, zzplVar.zzb, j2, Preconditions.checkNotNull(zzplVar.zza()));
                        if (zzj().zzl(zzpnVar)) {
                            zzaW().zzk().zzd("User property triggered", zzahVar3.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        } else {
                            zzaW().zzb().zzd("Too many active user properties, ignoring", zzgu.zzl(zzahVar3.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        }
                        zzbh zzbhVar4 = zzahVar3.zzi;
                        if (zzbhVar4 != null) {
                            arrayList2.add(zzbhVar4);
                        }
                        zzahVar3.zzc = new zzpl(zzpnVar);
                        zzahVar3.zze = true;
                        zzj().zzp(zzahVar3);
                    }
                }
                zzH(zzbhVarZzb, zzrVar);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    zzH(new zzbh((zzbh) it2.next(), j2, j6), zzrVar);
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final Bundle zzG(String str, zzbh zzbhVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbhVar.zzb.zzb("_sid").longValue());
        zzpn zzpnVarZzm = zzj().zzm(str, "_sno");
        if (zzpnVarZzm != null) {
            Object obj = zzpnVarZzm.zze;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0446 A[Catch: all -> 0x0b28, TRY_LEAVE, TryCatch #2 {all -> 0x0b28, blocks: (B:37:0x0157, B:40:0x0168, B:42:0x0170, B:47:0x017a, B:88:0x0300, B:97:0x0339, B:99:0x0382, B:101:0x0389, B:102:0x03a0, B:105:0x03ad, B:107:0x03c5, B:109:0x03cc, B:110:0x03e3, B:113:0x0403, B:117:0x0426, B:118:0x043d, B:119:0x0446, B:122:0x0465, B:124:0x047e, B:126:0x0488, B:128:0x0494, B:130:0x049a, B:131:0x04a1, B:132:0x04ae, B:139:0x04f1, B:140:0x0506, B:142:0x053b, B:145:0x0552, B:147:0x055c, B:150:0x0598, B:152:0x05c4, B:154:0x05fc, B:155:0x05ff, B:157:0x0607, B:158:0x060a, B:160:0x0612, B:161:0x0615, B:163:0x061d, B:164:0x0620, B:166:0x0629, B:167:0x062d, B:169:0x063a, B:170:0x063d, B:172:0x066f, B:174:0x0679, B:178:0x0692, B:183:0x06a3, B:216:0x0720, B:218:0x0728, B:219:0x072b, B:221:0x073f, B:222:0x0749, B:224:0x0756, B:226:0x0760, B:227:0x0763, B:229:0x077f, B:231:0x0783, B:234:0x0795, B:236:0x07a0, B:237:0x07ab, B:239:0x07b5, B:241:0x07c1, B:243:0x07cb, B:245:0x07d1, B:247:0x07e3, B:249:0x0801, B:251:0x0807, B:252:0x0810, B:254:0x0828, B:256:0x0864, B:258:0x086e, B:259:0x0871, B:261:0x087b, B:263:0x0899, B:264:0x08a2, B:266:0x08d9, B:268:0x08e1, B:270:0x08eb, B:271:0x08f8, B:273:0x0902, B:274:0x090f, B:275:0x0918, B:277:0x091e, B:279:0x095a, B:281:0x0964, B:283:0x0976, B:287:0x0981, B:288:0x09c5, B:289:0x09d0, B:290:0x09dd, B:292:0x09e3, B:300:0x0a2e, B:301:0x0a84, B:303:0x0a95, B:317:0x0af7, B:306:0x0aab, B:308:0x0aaf, B:295:0x09f2, B:297:0x0a1c, B:312:0x0ac8, B:313:0x0adf, B:316:0x0ae2, B:186:0x06ae, B:190:0x06bb, B:194:0x06c9, B:198:0x06d7, B:202:0x06e5, B:206:0x06f3, B:210:0x06ff, B:214:0x070d, B:151:0x05b6, B:136:0x04d9, B:91:0x0316, B:92:0x031d, B:94:0x0323, B:96:0x0332, B:52:0x018b, B:55:0x019b, B:57:0x01b0, B:62:0x01c7, B:67:0x01f9, B:69:0x01ff, B:71:0x020d, B:73:0x0222, B:76:0x0229, B:84:0x02c4, B:86:0x02ce, B:77:0x0256, B:78:0x0274, B:83:0x02a6, B:82:0x0293, B:65:0x01d3, B:66:0x01f1), top: B:327:0x0157, inners: #0, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x081d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x019b A[Catch: all -> 0x0b28, TRY_ENTER, TryCatch #2 {all -> 0x0b28, blocks: (B:37:0x0157, B:40:0x0168, B:42:0x0170, B:47:0x017a, B:88:0x0300, B:97:0x0339, B:99:0x0382, B:101:0x0389, B:102:0x03a0, B:105:0x03ad, B:107:0x03c5, B:109:0x03cc, B:110:0x03e3, B:113:0x0403, B:117:0x0426, B:118:0x043d, B:119:0x0446, B:122:0x0465, B:124:0x047e, B:126:0x0488, B:128:0x0494, B:130:0x049a, B:131:0x04a1, B:132:0x04ae, B:139:0x04f1, B:140:0x0506, B:142:0x053b, B:145:0x0552, B:147:0x055c, B:150:0x0598, B:152:0x05c4, B:154:0x05fc, B:155:0x05ff, B:157:0x0607, B:158:0x060a, B:160:0x0612, B:161:0x0615, B:163:0x061d, B:164:0x0620, B:166:0x0629, B:167:0x062d, B:169:0x063a, B:170:0x063d, B:172:0x066f, B:174:0x0679, B:178:0x0692, B:183:0x06a3, B:216:0x0720, B:218:0x0728, B:219:0x072b, B:221:0x073f, B:222:0x0749, B:224:0x0756, B:226:0x0760, B:227:0x0763, B:229:0x077f, B:231:0x0783, B:234:0x0795, B:236:0x07a0, B:237:0x07ab, B:239:0x07b5, B:241:0x07c1, B:243:0x07cb, B:245:0x07d1, B:247:0x07e3, B:249:0x0801, B:251:0x0807, B:252:0x0810, B:254:0x0828, B:256:0x0864, B:258:0x086e, B:259:0x0871, B:261:0x087b, B:263:0x0899, B:264:0x08a2, B:266:0x08d9, B:268:0x08e1, B:270:0x08eb, B:271:0x08f8, B:273:0x0902, B:274:0x090f, B:275:0x0918, B:277:0x091e, B:279:0x095a, B:281:0x0964, B:283:0x0976, B:287:0x0981, B:288:0x09c5, B:289:0x09d0, B:290:0x09dd, B:292:0x09e3, B:300:0x0a2e, B:301:0x0a84, B:303:0x0a95, B:317:0x0af7, B:306:0x0aab, B:308:0x0aaf, B:295:0x09f2, B:297:0x0a1c, B:312:0x0ac8, B:313:0x0adf, B:316:0x0ae2, B:186:0x06ae, B:190:0x06bb, B:194:0x06c9, B:198:0x06d7, B:202:0x06e5, B:206:0x06f3, B:210:0x06ff, B:214:0x070d, B:151:0x05b6, B:136:0x04d9, B:91:0x0316, B:92:0x031d, B:94:0x0323, B:96:0x0332, B:52:0x018b, B:55:0x019b, B:57:0x01b0, B:62:0x01c7, B:67:0x01f9, B:69:0x01ff, B:71:0x020d, B:73:0x0222, B:76:0x0229, B:84:0x02c4, B:86:0x02ce, B:77:0x0256, B:78:0x0274, B:83:0x02a6, B:82:0x0293, B:65:0x01d3, B:66:0x01f1), top: B:327:0x0157, inners: #0, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f1 A[Catch: all -> 0x0b28, TryCatch #2 {all -> 0x0b28, blocks: (B:37:0x0157, B:40:0x0168, B:42:0x0170, B:47:0x017a, B:88:0x0300, B:97:0x0339, B:99:0x0382, B:101:0x0389, B:102:0x03a0, B:105:0x03ad, B:107:0x03c5, B:109:0x03cc, B:110:0x03e3, B:113:0x0403, B:117:0x0426, B:118:0x043d, B:119:0x0446, B:122:0x0465, B:124:0x047e, B:126:0x0488, B:128:0x0494, B:130:0x049a, B:131:0x04a1, B:132:0x04ae, B:139:0x04f1, B:140:0x0506, B:142:0x053b, B:145:0x0552, B:147:0x055c, B:150:0x0598, B:152:0x05c4, B:154:0x05fc, B:155:0x05ff, B:157:0x0607, B:158:0x060a, B:160:0x0612, B:161:0x0615, B:163:0x061d, B:164:0x0620, B:166:0x0629, B:167:0x062d, B:169:0x063a, B:170:0x063d, B:172:0x066f, B:174:0x0679, B:178:0x0692, B:183:0x06a3, B:216:0x0720, B:218:0x0728, B:219:0x072b, B:221:0x073f, B:222:0x0749, B:224:0x0756, B:226:0x0760, B:227:0x0763, B:229:0x077f, B:231:0x0783, B:234:0x0795, B:236:0x07a0, B:237:0x07ab, B:239:0x07b5, B:241:0x07c1, B:243:0x07cb, B:245:0x07d1, B:247:0x07e3, B:249:0x0801, B:251:0x0807, B:252:0x0810, B:254:0x0828, B:256:0x0864, B:258:0x086e, B:259:0x0871, B:261:0x087b, B:263:0x0899, B:264:0x08a2, B:266:0x08d9, B:268:0x08e1, B:270:0x08eb, B:271:0x08f8, B:273:0x0902, B:274:0x090f, B:275:0x0918, B:277:0x091e, B:279:0x095a, B:281:0x0964, B:283:0x0976, B:287:0x0981, B:288:0x09c5, B:289:0x09d0, B:290:0x09dd, B:292:0x09e3, B:300:0x0a2e, B:301:0x0a84, B:303:0x0a95, B:317:0x0af7, B:306:0x0aab, B:308:0x0aaf, B:295:0x09f2, B:297:0x0a1c, B:312:0x0ac8, B:313:0x0adf, B:316:0x0ae2, B:186:0x06ae, B:190:0x06bb, B:194:0x06c9, B:198:0x06d7, B:202:0x06e5, B:206:0x06f3, B:210:0x06ff, B:214:0x070d, B:151:0x05b6, B:136:0x04d9, B:91:0x0316, B:92:0x031d, B:94:0x0323, B:96:0x0332, B:52:0x018b, B:55:0x019b, B:57:0x01b0, B:62:0x01c7, B:67:0x01f9, B:69:0x01ff, B:71:0x020d, B:73:0x0222, B:76:0x0229, B:84:0x02c4, B:86:0x02ce, B:77:0x0256, B:78:0x0274, B:83:0x02a6, B:82:0x0293, B:65:0x01d3, B:66:0x01f1), top: B:327:0x0157, inners: #0, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ff A[Catch: all -> 0x0b28, TryCatch #2 {all -> 0x0b28, blocks: (B:37:0x0157, B:40:0x0168, B:42:0x0170, B:47:0x017a, B:88:0x0300, B:97:0x0339, B:99:0x0382, B:101:0x0389, B:102:0x03a0, B:105:0x03ad, B:107:0x03c5, B:109:0x03cc, B:110:0x03e3, B:113:0x0403, B:117:0x0426, B:118:0x043d, B:119:0x0446, B:122:0x0465, B:124:0x047e, B:126:0x0488, B:128:0x0494, B:130:0x049a, B:131:0x04a1, B:132:0x04ae, B:139:0x04f1, B:140:0x0506, B:142:0x053b, B:145:0x0552, B:147:0x055c, B:150:0x0598, B:152:0x05c4, B:154:0x05fc, B:155:0x05ff, B:157:0x0607, B:158:0x060a, B:160:0x0612, B:161:0x0615, B:163:0x061d, B:164:0x0620, B:166:0x0629, B:167:0x062d, B:169:0x063a, B:170:0x063d, B:172:0x066f, B:174:0x0679, B:178:0x0692, B:183:0x06a3, B:216:0x0720, B:218:0x0728, B:219:0x072b, B:221:0x073f, B:222:0x0749, B:224:0x0756, B:226:0x0760, B:227:0x0763, B:229:0x077f, B:231:0x0783, B:234:0x0795, B:236:0x07a0, B:237:0x07ab, B:239:0x07b5, B:241:0x07c1, B:243:0x07cb, B:245:0x07d1, B:247:0x07e3, B:249:0x0801, B:251:0x0807, B:252:0x0810, B:254:0x0828, B:256:0x0864, B:258:0x086e, B:259:0x0871, B:261:0x087b, B:263:0x0899, B:264:0x08a2, B:266:0x08d9, B:268:0x08e1, B:270:0x08eb, B:271:0x08f8, B:273:0x0902, B:274:0x090f, B:275:0x0918, B:277:0x091e, B:279:0x095a, B:281:0x0964, B:283:0x0976, B:287:0x0981, B:288:0x09c5, B:289:0x09d0, B:290:0x09dd, B:292:0x09e3, B:300:0x0a2e, B:301:0x0a84, B:303:0x0a95, B:317:0x0af7, B:306:0x0aab, B:308:0x0aaf, B:295:0x09f2, B:297:0x0a1c, B:312:0x0ac8, B:313:0x0adf, B:316:0x0ae2, B:186:0x06ae, B:190:0x06bb, B:194:0x06c9, B:198:0x06d7, B:202:0x06e5, B:206:0x06f3, B:210:0x06ff, B:214:0x070d, B:151:0x05b6, B:136:0x04d9, B:91:0x0316, B:92:0x031d, B:94:0x0323, B:96:0x0332, B:52:0x018b, B:55:0x019b, B:57:0x01b0, B:62:0x01c7, B:67:0x01f9, B:69:0x01ff, B:71:0x020d, B:73:0x0222, B:76:0x0229, B:84:0x02c4, B:86:0x02ce, B:77:0x0256, B:78:0x0274, B:83:0x02a6, B:82:0x0293, B:65:0x01d3, B:66:0x01f1), top: B:327:0x0157, inners: #0, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0316 A[Catch: all -> 0x0b28, TryCatch #2 {all -> 0x0b28, blocks: (B:37:0x0157, B:40:0x0168, B:42:0x0170, B:47:0x017a, B:88:0x0300, B:97:0x0339, B:99:0x0382, B:101:0x0389, B:102:0x03a0, B:105:0x03ad, B:107:0x03c5, B:109:0x03cc, B:110:0x03e3, B:113:0x0403, B:117:0x0426, B:118:0x043d, B:119:0x0446, B:122:0x0465, B:124:0x047e, B:126:0x0488, B:128:0x0494, B:130:0x049a, B:131:0x04a1, B:132:0x04ae, B:139:0x04f1, B:140:0x0506, B:142:0x053b, B:145:0x0552, B:147:0x055c, B:150:0x0598, B:152:0x05c4, B:154:0x05fc, B:155:0x05ff, B:157:0x0607, B:158:0x060a, B:160:0x0612, B:161:0x0615, B:163:0x061d, B:164:0x0620, B:166:0x0629, B:167:0x062d, B:169:0x063a, B:170:0x063d, B:172:0x066f, B:174:0x0679, B:178:0x0692, B:183:0x06a3, B:216:0x0720, B:218:0x0728, B:219:0x072b, B:221:0x073f, B:222:0x0749, B:224:0x0756, B:226:0x0760, B:227:0x0763, B:229:0x077f, B:231:0x0783, B:234:0x0795, B:236:0x07a0, B:237:0x07ab, B:239:0x07b5, B:241:0x07c1, B:243:0x07cb, B:245:0x07d1, B:247:0x07e3, B:249:0x0801, B:251:0x0807, B:252:0x0810, B:254:0x0828, B:256:0x0864, B:258:0x086e, B:259:0x0871, B:261:0x087b, B:263:0x0899, B:264:0x08a2, B:266:0x08d9, B:268:0x08e1, B:270:0x08eb, B:271:0x08f8, B:273:0x0902, B:274:0x090f, B:275:0x0918, B:277:0x091e, B:279:0x095a, B:281:0x0964, B:283:0x0976, B:287:0x0981, B:288:0x09c5, B:289:0x09d0, B:290:0x09dd, B:292:0x09e3, B:300:0x0a2e, B:301:0x0a84, B:303:0x0a95, B:317:0x0af7, B:306:0x0aab, B:308:0x0aaf, B:295:0x09f2, B:297:0x0a1c, B:312:0x0ac8, B:313:0x0adf, B:316:0x0ae2, B:186:0x06ae, B:190:0x06bb, B:194:0x06c9, B:198:0x06d7, B:202:0x06e5, B:206:0x06f3, B:210:0x06ff, B:214:0x070d, B:151:0x05b6, B:136:0x04d9, B:91:0x0316, B:92:0x031d, B:94:0x0323, B:96:0x0332, B:52:0x018b, B:55:0x019b, B:57:0x01b0, B:62:0x01c7, B:67:0x01f9, B:69:0x01ff, B:71:0x020d, B:73:0x0222, B:76:0x0229, B:84:0x02c4, B:86:0x02ce, B:77:0x0256, B:78:0x0274, B:83:0x02a6, B:82:0x0293, B:65:0x01d3, B:66:0x01f1), top: B:327:0x0157, inners: #0, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0382 A[Catch: all -> 0x0b28, TryCatch #2 {all -> 0x0b28, blocks: (B:37:0x0157, B:40:0x0168, B:42:0x0170, B:47:0x017a, B:88:0x0300, B:97:0x0339, B:99:0x0382, B:101:0x0389, B:102:0x03a0, B:105:0x03ad, B:107:0x03c5, B:109:0x03cc, B:110:0x03e3, B:113:0x0403, B:117:0x0426, B:118:0x043d, B:119:0x0446, B:122:0x0465, B:124:0x047e, B:126:0x0488, B:128:0x0494, B:130:0x049a, B:131:0x04a1, B:132:0x04ae, B:139:0x04f1, B:140:0x0506, B:142:0x053b, B:145:0x0552, B:147:0x055c, B:150:0x0598, B:152:0x05c4, B:154:0x05fc, B:155:0x05ff, B:157:0x0607, B:158:0x060a, B:160:0x0612, B:161:0x0615, B:163:0x061d, B:164:0x0620, B:166:0x0629, B:167:0x062d, B:169:0x063a, B:170:0x063d, B:172:0x066f, B:174:0x0679, B:178:0x0692, B:183:0x06a3, B:216:0x0720, B:218:0x0728, B:219:0x072b, B:221:0x073f, B:222:0x0749, B:224:0x0756, B:226:0x0760, B:227:0x0763, B:229:0x077f, B:231:0x0783, B:234:0x0795, B:236:0x07a0, B:237:0x07ab, B:239:0x07b5, B:241:0x07c1, B:243:0x07cb, B:245:0x07d1, B:247:0x07e3, B:249:0x0801, B:251:0x0807, B:252:0x0810, B:254:0x0828, B:256:0x0864, B:258:0x086e, B:259:0x0871, B:261:0x087b, B:263:0x0899, B:264:0x08a2, B:266:0x08d9, B:268:0x08e1, B:270:0x08eb, B:271:0x08f8, B:273:0x0902, B:274:0x090f, B:275:0x0918, B:277:0x091e, B:279:0x095a, B:281:0x0964, B:283:0x0976, B:287:0x0981, B:288:0x09c5, B:289:0x09d0, B:290:0x09dd, B:292:0x09e3, B:300:0x0a2e, B:301:0x0a84, B:303:0x0a95, B:317:0x0af7, B:306:0x0aab, B:308:0x0aaf, B:295:0x09f2, B:297:0x0a1c, B:312:0x0ac8, B:313:0x0adf, B:316:0x0ae2, B:186:0x06ae, B:190:0x06bb, B:194:0x06c9, B:198:0x06d7, B:202:0x06e5, B:206:0x06f3, B:210:0x06ff, B:214:0x070d, B:151:0x05b6, B:136:0x04d9, B:91:0x0316, B:92:0x031d, B:94:0x0323, B:96:0x0332, B:52:0x018b, B:55:0x019b, B:57:0x01b0, B:62:0x01c7, B:67:0x01f9, B:69:0x01ff, B:71:0x020d, B:73:0x0222, B:76:0x0229, B:84:0x02c4, B:86:0x02ce, B:77:0x0256, B:78:0x0274, B:83:0x02a6, B:82:0x0293, B:65:0x01d3, B:66:0x01f1), top: B:327:0x0157, inners: #0, #3, #4, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzH(com.google.android.gms.measurement.internal.zzbh r44, com.google.android.gms.measurement.internal.zzr r45) {
        /*
            Method dump skipped, instruction units count: 2866
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzH(com.google.android.gms.measurement.internal.zzbh, com.google.android.gms.measurement.internal.zzr):void");
    }

    final void zzI(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        com.google.android.gms.internal.measurement.zziu zziuVar;
        zzaX().zzg();
        zzu();
        zzan zzanVarZzd = zzan.zzd(zzicVar.zzaA());
        String strZzc = zzhVar.zzc();
        zzaX().zzg();
        zzu();
        zzjl zzjlVarZzB = zzB(strZzc);
        zzji zzjiVar = zzji.UNINITIALIZED;
        int iOrdinal = zzjlVarZzB.zzp().ordinal();
        if (iOrdinal == 1) {
            zzanVarZzd.zzc(zzjk.AD_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal == 2 || iOrdinal == 3) {
            zzanVarZzd.zzb(zzjk.AD_STORAGE, zzjlVarZzB.zzb());
        } else {
            zzanVarZzd.zzc(zzjk.AD_STORAGE, zzam.FAILSAFE);
        }
        int iOrdinal2 = zzjlVarZzB.zzq().ordinal();
        if (iOrdinal2 == 1) {
            zzanVarZzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal2 == 2 || iOrdinal2 == 3) {
            zzanVarZzd.zzb(zzjk.ANALYTICS_STORAGE, zzjlVarZzB.zzb());
        } else {
            zzanVarZzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.FAILSAFE);
        }
        String strZzc2 = zzhVar.zzc();
        zzaX().zzg();
        zzu();
        zzba zzbaVarZzz = zzz(strZzc2, zzx(strZzc2), zzB(strZzc2), zzanVarZzd);
        zzicVar.zzaD(((Boolean) Preconditions.checkNotNull(zzbaVarZzz.zzj())).booleanValue());
        if (!TextUtils.isEmpty(zzbaVarZzz.zzk())) {
            zzicVar.zzaF(zzbaVarZzz.zzk());
        }
        zzaX().zzg();
        zzu();
        Iterator it = zzicVar.zzk().iterator();
        while (true) {
            if (it.hasNext()) {
                zziuVar = (com.google.android.gms.internal.measurement.zziu) it.next();
                if ("_npa".equals(zziuVar.zzc())) {
                    break;
                }
            } else {
                zziuVar = null;
                break;
            }
        }
        if (zziuVar != null) {
            zzjk zzjkVar = zzjk.AD_PERSONALIZATION;
            if (zzanVarZzd.zza(zzjkVar) == zzam.UNSET) {
                zzpn zzpnVarZzm = zzj().zzm(zzhVar.zzc(), "_npa");
                if (zzpnVarZzm != null) {
                    String str = zzpnVarZzm.zzb;
                    if ("tcf".equals(str)) {
                        zzanVarZzd.zzc(zzjkVar, zzam.TCF);
                    } else if ("app".equals(str)) {
                        zzanVarZzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzanVarZzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                } else {
                    Boolean boolZzae = zzhVar.zzae();
                    if (boolZzae == null || ((boolZzae.booleanValue() && zziuVar.zzh() != 1) || !(boolZzae.booleanValue() || zziuVar.zzh() == 0))) {
                        zzanVarZzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzanVarZzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                }
            }
        } else {
            int iZzaD = zzaD(zzhVar.zzc(), zzanVarZzd);
            com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
            zzitVarZzm.zzb("_npa");
            zzitVarZzm.zza(zzba().currentTimeMillis());
            zzitVarZzm.zze(iZzaD);
            zzicVar.zzo((com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbd());
            zzaW().zzk().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(iZzaD));
        }
        zzicVar.zzaB(zzanVarZzd.toString());
        boolean zZzz = this.zzc.zzz(zzhVar.zzc());
        List listZzb = zzicVar.zzb();
        int i = 0;
        for (int i2 = 0; i2 < listZzb.size(); i2++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhs) listZzb.get(i2)).zzd())) {
                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) listZzb.get(i2)).zzco();
                List listZza = zzhrVar.zza();
                int i3 = 0;
                while (true) {
                    if (i3 >= listZza.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i3)).zzb())) {
                        String strZzd = ((com.google.android.gms.internal.measurement.zzhw) listZza.get(i3)).zzd();
                        if (zZzz && strZzd.length() > 4) {
                            char[] charArray = strZzd.toCharArray();
                            int i4 = 1;
                            while (true) {
                                if (i4 >= 64) {
                                    break;
                                }
                                if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4)) {
                                    i = i4;
                                    break;
                                }
                                i4++;
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i | 1);
                            strZzd = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                        zzhvVarZzn.zzb("_tcfd");
                        zzhvVarZzn.zzd(strZzd);
                        zzhrVar.zze(i3, zzhvVarZzn);
                    } else {
                        i3++;
                    }
                }
                zzicVar.zzf(i2, zzhrVar);
                return;
            }
        }
    }

    final void zzJ(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        zzaX().zzg();
        zzu();
        com.google.android.gms.internal.measurement.zzgx zzgxVarZzt = com.google.android.gms.internal.measurement.zzha.zzt();
        byte[] bArrZzaJ = zzhVar.zzaJ();
        if (bArrZzaJ != null) {
            try {
                zzgxVarZzt = (com.google.android.gms.internal.measurement.zzgx) zzpk.zzw(zzgxVarZzt, bArrZzaJ);
            } catch (zzaeh unused) {
                zzaW().zze().zzb("Failed to parse locally stored ad campaign info. appId", zzgu.zzl(zzhVar.zzc()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhs zzhsVar : zzicVar.zzb()) {
            if (zzhsVar.zzd().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzpk.zzN(zzhsVar, "gclid", "");
                String str2 = (String) zzpk.zzN(zzhsVar, "gbraid", "");
                String str3 = (String) zzpk.zzN(zzhsVar, "gad_source", "");
                String str4 = (String) zzpk.zzN(zzhsVar, "deep_link_url", "");
                String[] strArrSplit = ((String) zzfy.zzbb.zzb(null)).split(",");
                zzp();
                if (!zzpk.zzK(zzhsVar, strArrSplit).isEmpty()) {
                    long jLongValue = ((Long) zzpk.zzN(zzhsVar, "click_timestamp", 0L)).longValue();
                    if (jLongValue <= 0) {
                        jLongValue = zzhsVar.zzf();
                    }
                    if ("referrer API v2".equals(zzpk.zzM(zzhsVar, "_cis"))) {
                        if (jLongValue > zzgxVarZzt.zzo()) {
                            if (str.isEmpty()) {
                                zzgxVarZzt.zzj();
                            } else {
                                zzgxVarZzt.zzi(str);
                            }
                            if (str2.isEmpty()) {
                                zzgxVarZzt.zzl();
                            } else {
                                zzgxVarZzt.zzk(str2);
                            }
                            if (str3.isEmpty()) {
                                zzgxVarZzt.zzn();
                            } else {
                                zzgxVarZzt.zzm(str3);
                            }
                            zzgxVarZzt.zzp(jLongValue);
                            zzgxVarZzt.zzs();
                            zzgxVarZzt.zzt(zzaE(zzhsVar));
                        }
                    } else if (jLongValue > zzgxVarZzt.zzg()) {
                        if (str.isEmpty()) {
                            zzgxVarZzt.zzb();
                        } else {
                            zzgxVarZzt.zza(str);
                        }
                        if (str2.isEmpty()) {
                            zzgxVarZzt.zzd();
                        } else {
                            zzgxVarZzt.zzc(str2);
                        }
                        if (str3.isEmpty()) {
                            zzgxVarZzt.zzf();
                        } else {
                            zzgxVarZzt.zze(str3);
                        }
                        if (zzd().zzp(null, zzfy.zzba)) {
                            if (str4.isEmpty()) {
                                zzgxVarZzt.zzv();
                            } else {
                                zzgxVarZzt.zzu(str4);
                            }
                        }
                        zzgxVarZzt.zzh(jLongValue);
                        zzgxVarZzt.zzq();
                        zzgxVarZzt.zzr(zzaE(zzhsVar));
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzha) zzgxVarZzt.zzbd()).equals(com.google.android.gms.internal.measurement.zzha.zzu())) {
            zzicVar.zzaM((com.google.android.gms.internal.measurement.zzha) zzgxVarZzt.zzbd());
        }
        zzhVar.zzaI(((com.google.android.gms.internal.measurement.zzha) zzgxVarZzt.zzbd()).zzcd());
        if (zzhVar.zza()) {
            zzj().zzv(zzhVar, false, false);
        }
        if (zzd().zzp(null, zzfy.zzba)) {
            for (int i = 0; i < zzicVar.zzc(); i++) {
                com.google.android.gms.internal.measurement.zzhs zzhsVarZzd = zzicVar.zzd(i);
                if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzhsVarZzd.zzd())) {
                    com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVarZzd.zzco();
                    List listZza = zzhrVar.zza();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= listZza.size()) {
                            break;
                        }
                        if ("deep_link_url".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i2)).zzb())) {
                            zzhrVar.zzj(i2);
                            zzicVar.zzf(i, zzhrVar);
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        if (zzd().zzp(null, zzfy.zzaZ)) {
            zzj().zzk(zzhVar.zzc(), "_lgclid");
        }
    }

    final String zzK(zzjl zzjlVar) {
        if (!zzjlVar.zzo(zzjk.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzt().zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    final void zzL(List list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzaW().zzb().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0108 A[Catch: all -> 0x01b9, DONT_GENERATE, PHI: r0 r6 r8
  0x0108: PHI (r0v25 java.lang.Object) = (r0v34 java.lang.Object), (r0v35 java.lang.Object), (r0v36 java.lang.Object) binds: [B:43:0x0125, B:37:0x0110, B:33:0x0106] A[DONT_GENERATE, DONT_INLINE]
  0x0108: PHI (r6v10 long) = (r6v6 long), (r6v11 long), (r6v6 long) binds: [B:43:0x0125, B:37:0x0110, B:33:0x0106] A[DONT_GENERATE, DONT_INLINE]
  0x0108: PHI (r8v13 ??) = (r8v22 ??), (r8v23 ??), (r8v24 ??) binds: [B:43:0x0125, B:37:0x0110, B:33:0x0106] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01b9, blocks: (B:3:0x000e, B:5:0x001d, B:6:0x002c, B:8:0x0032, B:9:0x0041, B:11:0x0049, B:12:0x004e, B:14:0x0059, B:15:0x0068, B:17:0x0072, B:18:0x0084, B:20:0x00a3, B:22:0x00a9, B:23:0x00ac, B:25:0x00c5, B:26:0x00dc, B:28:0x00ec, B:30:0x00f2, B:34:0x0108, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:56:0x0173, B:70:0x0198, B:72:0x019e, B:74:0x01a8, B:80:0x01b5, B:81:0x01b8, B:31:0x00f6, B:36:0x010c, B:42:0x0116), top: B:92:0x000e, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0173 A[Catch: all -> 0x01b9, PHI: r0 r4 r8
  0x0173: PHI (r0v8 ??) = (r0v46 ??), (r0v47 ??), (r0v48 ??) binds: [B:59:0x017b, B:55:0x0171, B:68:0x0195] A[DONT_GENERATE, DONT_INLINE]
  0x0173: PHI (r4v5 ??) = (r4v17 ??), (r4v18 ??), (r4v19 ??) binds: [B:59:0x017b, B:55:0x0171, B:68:0x0195] A[DONT_GENERATE, DONT_INLINE]
  0x0173: PHI (r8v2 ??) = (r8v33 ??), (r8v17 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r8v34 ??) binds: [B:59:0x017b, B:55:0x0171, B:68:0x0195] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01b9, blocks: (B:3:0x000e, B:5:0x001d, B:6:0x002c, B:8:0x0032, B:9:0x0041, B:11:0x0049, B:12:0x004e, B:14:0x0059, B:15:0x0068, B:17:0x0072, B:18:0x0084, B:20:0x00a3, B:22:0x00a9, B:23:0x00ac, B:25:0x00c5, B:26:0x00dc, B:28:0x00ec, B:30:0x00f2, B:34:0x0108, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:56:0x0173, B:70:0x0198, B:72:0x019e, B:74:0x01a8, B:80:0x01b5, B:81:0x01b8, B:31:0x00f6, B:36:0x010c, B:42:0x0116), top: B:92:0x000e, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019e A[Catch: all -> 0x01b9, TryCatch #5 {all -> 0x01b9, blocks: (B:3:0x000e, B:5:0x001d, B:6:0x002c, B:8:0x0032, B:9:0x0041, B:11:0x0049, B:12:0x004e, B:14:0x0059, B:15:0x0068, B:17:0x0072, B:18:0x0084, B:20:0x00a3, B:22:0x00a9, B:23:0x00ac, B:25:0x00c5, B:26:0x00dc, B:28:0x00ec, B:30:0x00f2, B:34:0x0108, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:56:0x0173, B:70:0x0198, B:72:0x019e, B:74:0x01a8, B:80:0x01b5, B:81:0x01b8, B:31:0x00f6, B:36:0x010c, B:42:0x0116), top: B:92:0x000e, inners: #2 }] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.google.android.gms.measurement.internal.zzaw] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.google.android.gms.measurement.internal.zzaw, com.google.android.gms.measurement.internal.zzje, com.google.android.gms.measurement.internal.zzos] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.google.android.gms.measurement.internal.zzje] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v14, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x01ab -> B:93:0x01ab). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzM() {
        /*
            Method dump skipped, instruction units count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzM():void");
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x09d8: MOVE (r14 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:361:0x09d8 */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0432 A[PHI: r1 r8 r17
  0x0432: PHI (r1v55 android.database.Cursor) = (r1v54 android.database.Cursor), (r1v62 android.database.Cursor) binds: [B:159:0x0459, B:147:0x0430] A[DONT_GENERATE, DONT_INLINE]
  0x0432: PHI (r8v13 java.util.List) = (r8v12 java.util.List), (r8v11 java.util.List) binds: [B:159:0x0459, B:147:0x0430] A[DONT_GENERATE, DONT_INLINE]
  0x0432: PHI (r17v14 java.lang.String) = (r17v13 java.lang.String), (r17v16 java.lang.String) binds: [B:159:0x0459, B:147:0x0430] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0740  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x098b  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x09db  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0728 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:446:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:448:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:449:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzN(java.lang.String r33, long r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzN(java.lang.String, long):void");
    }

    final boolean zzO(String str, String str2) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null && zzt().zzad(str, zzhVarZzu.zzay())) {
            this.zzF.remove(str2);
            return true;
        }
        zzpe zzpeVar = (zzpe) this.zzF.get(str2);
        if (zzpeVar == null) {
            return true;
        }
        return zzpeVar.zzb();
    }

    final void zzP(String str) {
        com.google.android.gms.internal.measurement.zzib zzibVarZzd;
        zzaX().zzg();
        zzu();
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaV();
            Boolean boolZzJ = zzicVar.zzt().zzJ();
            if (boolZzJ == null) {
                zzaW().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (boolZzJ.booleanValue()) {
                zzaW().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaM();
            } else if (!zzi().zzb()) {
                zzaW().zzk().zza("Network not connected, ignoring upload request");
                zzaM();
            } else if (zzj().zzD(str)) {
                zzaw zzawVarZzj = zzj();
                Preconditions.checkNotEmpty(str);
                zzawVarZzj.zzg();
                zzawVarZzj.zzay();
                List listZzC = zzawVarZzj.zzC(str, zzoo.zza(zzls.GOOGLE_SIGNAL), 1);
                zzpj zzpjVar = listZzC.isEmpty() ? null : (zzpj) listZzC.get(0);
                if (zzpjVar != null && (zzibVarZzd = zzpjVar.zzd()) != null) {
                    zzaW().zzk().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpjVar.zzf(), zzpjVar.zze());
                    byte[] bArrZzcd = zzibVarZzd.zzcd();
                    if (Log.isLoggable(zzaW().zzn(), 2)) {
                        zzaW().zzk().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(bArrZzcd.length), zzp().zzi(zzibVarZzd));
                    }
                    zzot zzotVarZza = zzpjVar.zza();
                    this.zzv = true;
                    zzi().zzc(str, zzotVarZza, zzibVarZzd, new zzox(this, str, zzpjVar));
                }
            } else {
                zzaW().zzk().zzb("[sgtm] Upload queue has no batches for appId", str);
            }
        } finally {
            this.zzw = false;
            zzaN();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:19:0x005a, B:22:0x0080, B:13:0x001e, B:15:0x0048, B:17:0x0052, B:18:0x0056), top: B:27:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzQ(java.lang.String r4, int r5, java.lang.Throwable r6, byte[] r7, com.google.android.gms.measurement.internal.zzpj r8) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzhz r0 = r3.zzaX()
            r0.zzg()
            r3.zzu()
            r0 = 0
            if (r7 != 0) goto L13
            byte[] r7 = new byte[r0]     // Catch: java.lang.Throwable -> L10
            goto L13
        L10:
            r4 = move-exception
            goto L9b
        L13:
            r1 = 200(0xc8, float:2.8E-43)
            if (r5 == r1) goto L1c
            r1 = 204(0xcc, float:2.86E-43)
            if (r5 != r1) goto L5a
            r5 = r1
        L1c:
            if (r6 != 0) goto L5a
            com.google.android.gms.measurement.internal.zzaw r6 = r3.zzj()     // Catch: java.lang.Throwable -> L10
            long r7 = r8.zzc()     // Catch: java.lang.Throwable -> L10
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L10
            r6.zzE(r7)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgu r6 = r3.zzaW()     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgs r6 = r6.zzk()     // Catch: java.lang.Throwable -> L10
            java.lang.String r7 = "Successfully uploaded batch from upload queue. appId, status"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L10
            r6.zzc(r7, r4, r5)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgz r5 = r3.zzi()     // Catch: java.lang.Throwable -> L10
            boolean r5 = r5.zzb()     // Catch: java.lang.Throwable -> L10
            if (r5 == 0) goto L56
            com.google.android.gms.measurement.internal.zzaw r5 = r3.zzj()     // Catch: java.lang.Throwable -> L10
            boolean r5 = r5.zzD(r4)     // Catch: java.lang.Throwable -> L10
            if (r5 == 0) goto L56
            r3.zzP(r4)     // Catch: java.lang.Throwable -> L10
            goto L95
        L56:
            r3.zzaM()     // Catch: java.lang.Throwable -> L10
            goto L95
        L5a:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L10
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L10
            r1.<init>(r7, r2)     // Catch: java.lang.Throwable -> L10
            int r7 = r1.length()     // Catch: java.lang.Throwable -> L10
            r2 = 32
            int r7 = java.lang.Math.min(r2, r7)     // Catch: java.lang.Throwable -> L10
            java.lang.String r7 = r1.substring(r0, r7)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgu r1 = r3.zzaW()     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgs r1 = r1.zzh()     // Catch: java.lang.Throwable -> L10
            java.lang.String r2 = "Network upload failed. Will retry later. appId, status, error"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L10
            if (r6 != 0) goto L80
            r6 = r7
        L80:
            r1.zzd(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzaw r4 = r3.zzj()     // Catch: java.lang.Throwable -> L10
            long r5 = r8.zzc()     // Catch: java.lang.Throwable -> L10
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L10
            r4.zzK(r5)     // Catch: java.lang.Throwable -> L10
            r3.zzaM()     // Catch: java.lang.Throwable -> L10
        L95:
            r3.zzv = r0
            r3.zzaN()
            return
        L9b:
            r3.zzv = r0
            r3.zzaN()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzQ(java.lang.String, int, java.lang.Throwable, byte[], com.google.android.gms.measurement.internal.zzpj):void");
    }

    final void zzR(String str, boolean z, Long l, Long l2) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null) {
            zzhVarZzu.zzar(z);
            zzhVarZzu.zzat(l);
            zzhVarZzu.zzav(l2);
            if (zzhVarZzu.zza()) {
                zzj().zzv(zzhVarZzu, false, false);
            }
        }
    }

    final void zzS(String str, com.google.android.gms.internal.measurement.zzic zzicVar) {
        int iZzx;
        int iIndexOf;
        Set setZzl = zzh().zzl(str);
        if (setZzl != null) {
            zzicVar.zzaw(setZzl);
        }
        if (zzh().zzq(str)) {
            zzicVar.zzG();
        }
        if (zzh().zzr(str)) {
            String strZzD = zzicVar.zzD();
            if (!TextUtils.isEmpty(strZzD) && (iIndexOf = strZzD.indexOf(".")) != -1) {
                zzicVar.zzE(strZzD.substring(0, iIndexOf));
            }
        }
        if (zzh().zzs(str) && (iZzx = zzpk.zzx(zzicVar, "_id")) != -1) {
            zzicVar.zzr(iZzx);
        }
        if (zzh().zzt(str)) {
            zzicVar.zzan();
        }
        if (zzh().zzu(str)) {
            zzicVar.zzX();
            if (zzB(str).zzo(zzjk.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzpd zzpdVar = (zzpd) map.get(str);
                if (zzpdVar == null || zzpdVar.zzb + zzd().zzl(str, zzfy.zzaj) < zzba().elapsedRealtime()) {
                    zzpdVar = new zzpd(this, (byte[]) null);
                    map.put(str, zzpdVar);
                }
                zzicVar.zzax(zzpdVar.zza);
            }
        }
        if (zzh().zzv(str)) {
            zzicVar.zzav();
        }
    }

    final void zzT(com.google.android.gms.internal.measurement.zzic zzicVar, zzpc zzpcVar) {
        for (int i = 0; i < zzicVar.zzc(); i++) {
            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i).zzco();
            Iterator it = zzhrVar.zza().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((com.google.android.gms.internal.measurement.zzhw) it.next()).zzb())) {
                    if (zzpcVar.zza.zzar() >= zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzak)) {
                        int iZzm = zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzax);
                        String strZzaz = null;
                        if (iZzm <= 0) {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaQ)) {
                                strZzaz = zzt().zzaz();
                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn.zzb("_tu");
                                zzhvVarZzn.zzd(strZzaz);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn2.zzb("_tr");
                            zzhvVarZzn2.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbd());
                            zzoh zzohVarZzf = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, strZzaz);
                            if (zzohVarZzf != null) {
                                zzaW().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzohVarZzf.zza);
                                zzj().zzZ(zzpcVar.zza.zzA(), zzohVarZzf);
                                Deque deque = this.zzr;
                                if (!deque.contains(zzpcVar.zza.zzA())) {
                                    deque.add(zzpcVar.zza.zzA());
                                }
                            }
                        } else if (zzj().zzw(zzC(), zzpcVar.zza.zzA(), false, false, false, false, false, false, true).zzg > iZzm) {
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn3.zzb("_tnr");
                            zzhvVarZzn3.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn3.zzbd());
                        } else {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaQ)) {
                                strZzaz = zzt().zzaz();
                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn4.zzb("_tu");
                                zzhvVarZzn4.zzd(strZzaz);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn4.zzbd());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn5.zzb("_tr");
                            zzhvVarZzn5.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn5.zzbd());
                            zzoh zzohVarZzf2 = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, strZzaz);
                            if (zzohVarZzf2 != null) {
                                zzaW().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzohVarZzf2.zza);
                                zzj().zzZ(zzpcVar.zza.zzA(), zzohVarZzf2);
                                Deque deque2 = this.zzr;
                                if (!deque2.contains(zzpcVar.zza.zzA())) {
                                    deque2.add(zzpcVar.zza.zzA());
                                }
                            }
                        }
                    }
                    zzicVar.zze(i, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd());
                }
            }
        }
    }

    final void zzU(String str, com.google.android.gms.internal.measurement.zzhv zzhvVar, Bundle bundle, String str2) {
        List listListOf = zzd().zzp(str2, zzfy.zzba) ? CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si", "deep_link_url"}) : CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        long jZzf = (zzpp.zzac(zzhvVar.zza()) || zzpp.zzac(str)) ? zzd().zzf(str2, true) : zzd().zze(str2, true);
        long jCodePointCount = zzhvVar.zzc().codePointCount(0, zzhvVar.zzc().length());
        zzpp zzppVarZzt = zzt();
        String strZza = zzhvVar.zza();
        zzd();
        String strZzE = zzppVarZzt.zzE(strZza, 40, true);
        if (jCodePointCount <= jZzf || listListOf.contains(zzhvVar.zza())) {
            return;
        }
        if ("_ev".equals(zzhvVar.zza())) {
            bundle.putString("_ev", zzt().zzE(zzhvVar.zzc(), zzd().zzf(str2, true), true));
            return;
        }
        zzaW().zzh().zzc("Param value is too long; discarded. Name, value length", strZzE, Long.valueOf(jCodePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", strZzE);
                bundle.putLong("_el", jCodePointCount);
            }
        }
        bundle.remove(zzhvVar.zza());
    }

    final boolean zzV(com.google.android.gms.internal.measurement.zzhr zzhrVar) {
        ArrayList arrayList = new ArrayList(zzhrVar.zza());
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if ("value".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i3)).zzb())) {
                i = i3;
            } else if ("currency".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i3)).zzb())) {
                i2 = i3;
            }
        }
        if (i == -1) {
            if (!zzd().zzp(null, zzfy.zzbf) || !"_iap".equals(zzhrVar.zzk())) {
                return true;
            }
            zzaC(zzhrVar, "_c");
            zzaB(zzhrVar, 18, "value");
            return false;
        }
        if (!((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zze() && !((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zzj()) {
            zzaW().zzh().zza("Value must be specified with a numeric type.");
            zzhrVar.zzj(i);
            zzaC(zzhrVar, "_c");
            zzaB(zzhrVar, 18, "value");
            return false;
        }
        if (i2 != -1) {
            String strZzd = ((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i2)).zzd();
            if (strZzd.length() == 3) {
                int iCharCount = 0;
                while (iCharCount < strZzd.length()) {
                    int iCodePointAt = strZzd.codePointAt(iCharCount);
                    if (Character.isLetter(iCodePointAt)) {
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return true;
            }
        }
        zzaW().zzh().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
        zzhrVar.zzj(i);
        zzaC(zzhrVar, "_c");
        zzaB(zzhrVar, 19, "currency");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085 A[Catch: all -> 0x02a5, TryCatch #2 {all -> 0x02a5, blocks: (B:4:0x0015, B:6:0x001a, B:8:0x0027, B:9:0x0030, B:17:0x0048, B:22:0x0094, B:21:0x0085, B:23:0x00a0, B:25:0x00b7, B:26:0x00c6, B:28:0x00d4, B:30:0x00f4, B:69:0x022b, B:71:0x023e, B:73:0x0248, B:81:0x0268, B:75:0x024e, B:77:0x0258, B:79:0x025e, B:80:0x0262, B:83:0x026c, B:84:0x0273, B:29:0x00e7, B:86:0x0275), top: B:95:0x0015, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a0 A[Catch: all -> 0x02a5, PHI: r0
  0x00a0: PHI (r0v2 int) = (r0v0 int), (r0v37 int) binds: [B:10:0x003b, B:16:0x0046] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {all -> 0x02a5, blocks: (B:4:0x0015, B:6:0x001a, B:8:0x0027, B:9:0x0030, B:17:0x0048, B:22:0x0094, B:21:0x0085, B:23:0x00a0, B:25:0x00b7, B:26:0x00c6, B:28:0x00d4, B:30:0x00f4, B:69:0x022b, B:71:0x023e, B:73:0x0248, B:81:0x0268, B:75:0x024e, B:77:0x0258, B:79:0x025e, B:80:0x0262, B:83:0x026c, B:84:0x0273, B:29:0x00e7, B:86:0x0275), top: B:95:0x0015, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4 A[Catch: SQLiteException -> 0x0274, all -> 0x02a5, TryCatch #1 {SQLiteException -> 0x0274, blocks: (B:25:0x00b7, B:26:0x00c6, B:28:0x00d4, B:30:0x00f4, B:69:0x022b, B:71:0x023e, B:73:0x0248, B:81:0x0268, B:75:0x024e, B:77:0x0258, B:79:0x025e, B:80:0x0262, B:83:0x026c, B:84:0x0273, B:29:0x00e7), top: B:94:0x00b7, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7 A[Catch: SQLiteException -> 0x0274, all -> 0x02a5, TryCatch #1 {SQLiteException -> 0x0274, blocks: (B:25:0x00b7, B:26:0x00c6, B:28:0x00d4, B:30:0x00f4, B:69:0x022b, B:71:0x023e, B:73:0x0248, B:81:0x0268, B:75:0x024e, B:77:0x0258, B:79:0x025e, B:80:0x0262, B:83:0x026c, B:84:0x0273, B:29:0x00e7), top: B:94:0x00b7, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010c A[Catch: all -> 0x026b, TryCatch #3 {all -> 0x026b, blocks: (B:31:0x00fb, B:32:0x0104, B:34:0x010c, B:36:0x0126, B:40:0x0151, B:42:0x015b, B:44:0x0169, B:45:0x016e, B:47:0x0174, B:49:0x018b, B:50:0x01ad, B:52:0x01c6, B:54:0x01e9, B:55:0x01fa, B:56:0x01fe, B:58:0x0204, B:59:0x020b, B:62:0x0218, B:64:0x021c, B:67:0x0223, B:68:0x0224), top: B:96:0x00fb, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0174 A[Catch: all -> 0x026b, TryCatch #3 {all -> 0x026b, blocks: (B:31:0x00fb, B:32:0x0104, B:34:0x010c, B:36:0x0126, B:40:0x0151, B:42:0x015b, B:44:0x0169, B:45:0x016e, B:47:0x0174, B:49:0x018b, B:50:0x01ad, B:52:0x01c6, B:54:0x01e9, B:55:0x01fa, B:56:0x01fe, B:58:0x0204, B:59:0x020b, B:62:0x0218, B:64:0x021c, B:67:0x0223, B:68:0x0224), top: B:96:0x00fb, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c6 A[Catch: all -> 0x026b, TryCatch #3 {all -> 0x026b, blocks: (B:31:0x00fb, B:32:0x0104, B:34:0x010c, B:36:0x0126, B:40:0x0151, B:42:0x015b, B:44:0x0169, B:45:0x016e, B:47:0x0174, B:49:0x018b, B:50:0x01ad, B:52:0x01c6, B:54:0x01e9, B:55:0x01fa, B:56:0x01fe, B:58:0x0204, B:59:0x020b, B:62:0x0218, B:64:0x021c, B:67:0x0223, B:68:0x0224), top: B:96:0x00fb, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0204 A[Catch: all -> 0x026b, TRY_LEAVE, TryCatch #3 {all -> 0x026b, blocks: (B:31:0x00fb, B:32:0x0104, B:34:0x010c, B:36:0x0126, B:40:0x0151, B:42:0x015b, B:44:0x0169, B:45:0x016e, B:47:0x0174, B:49:0x018b, B:50:0x01ad, B:52:0x01c6, B:54:0x01e9, B:55:0x01fa, B:56:0x01fe, B:58:0x0204, B:59:0x020b, B:62:0x0218, B:64:0x021c, B:67:0x0223, B:68:0x0224), top: B:96:0x00fb, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x024e A[Catch: SQLiteException -> 0x0274, all -> 0x02a5, TryCatch #1 {SQLiteException -> 0x0274, blocks: (B:25:0x00b7, B:26:0x00c6, B:28:0x00d4, B:30:0x00f4, B:69:0x022b, B:71:0x023e, B:73:0x0248, B:81:0x0268, B:75:0x024e, B:77:0x0258, B:79:0x025e, B:80:0x0262, B:83:0x026c, B:84:0x0273, B:29:0x00e7), top: B:94:0x00b7, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0262 A[Catch: SQLiteException -> 0x0274, all -> 0x02a5, TryCatch #1 {SQLiteException -> 0x0274, blocks: (B:25:0x00b7, B:26:0x00c6, B:28:0x00d4, B:30:0x00f4, B:69:0x022b, B:71:0x023e, B:73:0x0248, B:81:0x0268, B:75:0x024e, B:77:0x0258, B:79:0x025e, B:80:0x0262, B:83:0x026c, B:84:0x0273, B:29:0x00e7), top: B:94:0x00b7, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzW(boolean r21, int r22, java.lang.Throwable r23, byte[] r24, java.lang.String r25, java.util.List r26, java.util.Map r27) {
        /*
            Method dump skipped, instruction units count: 684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzW(boolean, int, java.lang.Throwable, byte[], java.lang.String, java.util.List, java.util.Map):void");
    }

    final void zzX(zzh zzhVar) {
        zzaX().zzg();
        if (TextUtils.isEmpty(zzhVar.zzf())) {
            zzY((String) Preconditions.checkNotNull(zzhVar.zzc()), 204, null, null, null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzhVar.zzc());
        zzaW().zzk().zzb("Fetching remote configuration", str);
        com.google.android.gms.internal.measurement.zzgl zzglVarZzb = zzh().zzb(str);
        String strZzd = zzh().zzd(str);
        ArrayMap arrayMap = null;
        if (zzglVarZzb != null) {
            if (!TextUtils.isEmpty(strZzd)) {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, strZzd);
                arrayMap = arrayMap2;
            }
            String strZze = zzh().zze(str);
            if (!TextUtils.isEmpty(strZze)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put(HttpHeaders.IF_NONE_MATCH, strZze);
            }
        }
        this.zzu = true;
        zzi().zzd(zzhVar, arrayMap, new zzgw() { // from class: com.google.android.gms.measurement.internal.zzpf
            @Override // com.google.android.gms.measurement.internal.zzgw
            public final /* synthetic */ void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                this.zza.zzY(str2, i, th, bArr, map);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzY(java.lang.String r8, int r9, java.lang.Throwable r10, byte[] r11, java.util.Map r12) {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzY(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    final void zzZ(Runnable runnable) {
        zzaX().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    final /* synthetic */ void zzaA(long j) {
        this.zzJ = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzae zzaV() {
        return this.zzn.zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzgu zzaW() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzhz zzaX() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaX();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Context zzaZ() {
        return this.zzn.zzaZ();
    }

    final void zzaa() {
        zzaX().zzg();
        zzu();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzab()) {
            FileChannel fileChannel = this.zzy;
            zzaX().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzaW().zzb().zza("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int i2 = fileChannel.read(byteBufferAllocate);
                    if (i2 == 4) {
                        byteBufferAllocate.flip();
                        i = byteBufferAllocate.getInt();
                    } else if (i2 != -1) {
                        zzaW().zze().zzb("Unexpected data length. Bytes read", Integer.valueOf(i2));
                    }
                } catch (IOException e) {
                    zzaW().zzb().zzb("Failed to read from channel", e);
                }
            }
            int iZzm = this.zzn.zzv().zzm();
            zzaX().zzg();
            if (i > iZzm) {
                zzaW().zzb().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
                return;
            }
            if (i < iZzm) {
                FileChannel fileChannel2 = this.zzy;
                zzaX().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzaW().zzb().zza("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                    byteBufferAllocate2.putInt(iZzm);
                    byteBufferAllocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(byteBufferAllocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzaW().zzb().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzaW().zzk().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
                        return;
                    } catch (IOException e2) {
                        zzaW().zzb().zzb("Failed to write to channel", e2);
                    }
                }
                zzaW().zzb().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
            }
        }
    }

    final boolean zzab() {
        zzaX().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock != null && fileLock.isValid()) {
            zzaW().zzk().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzu.zzc();
        File filesDir = this.zzn.zzaZ().getFilesDir();
        com.google.android.gms.internal.measurement.zzby.zza();
        int i = com.google.android.gms.internal.measurement.zzcd.zza;
        try {
            FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
            this.zzy = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.zzx = fileLockTryLock;
            if (fileLockTryLock != null) {
                zzaW().zzk().zza("Storage concurrent access okay");
                return true;
            }
            zzaW().zzb().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzaW().zzb().zzb("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzaW().zzb().zzb("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            zzaW().zze().zzb("Storage lock already acquired", e3);
            return false;
        }
    }

    final void zzac(zzr zzrVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzaw zzawVarZzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzawVarZzj.zzg();
        zzawVarZzj.zzay();
        try {
            SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj.zze();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseZze.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZze.delete("events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseZze.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZze.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZze.delete("queue", "app_id=?", strArr) + sQLiteDatabaseZze.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZze.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseZze.delete("upload_queue", "app_id=?", strArr);
            zzahh.zza();
            zzic zzicVar = zzawVarZzj.zzu;
            if (zzicVar.zzc().zzp(null, zzfy.zzbc)) {
                iDelete += sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=?", strArr);
            }
            int iDelete2 = iDelete + sQLiteDatabaseZze.delete("diagnostic_signals", "app_id=?", strArr);
            if (iDelete2 > 0) {
                zzicVar.zzaW().zzk().zzc("Reset analytics data. app, records", str, Integer.valueOf(iDelete2));
            }
        } catch (SQLiteException e) {
            zzawVarZzj.zzu.zzaW().zzb().zzc("Error resetting analytics data. appId, error", zzgu.zzl(str), e);
        }
        if (zzrVar.zzh) {
            zzai(zzrVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzad(com.google.android.gms.measurement.internal.zzpl r22, com.google.android.gms.measurement.internal.zzr r23) {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzad(com.google.android.gms.measurement.internal.zzpl, com.google.android.gms.measurement.internal.zzr):void");
    }

    final void zzae(String str, zzr zzrVar) {
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            Boolean boolZzaU = zzaU(zzrVar);
            if ("_npa".equals(str) && boolZzaU != null) {
                zzaW().zzj().zza("Falling back to manifest metadata value for ad personalization");
                zzad(new zzpl("_npa", zzba().currentTimeMillis(), Long.valueOf(true != boolZzaU.booleanValue() ? 0L : 1L), "auto"), zzrVar);
                return;
            }
            zzgs zzgsVarZzj = zzaW().zzj();
            zzic zzicVar = this.zzn;
            zzgsVarZzj.zzb("Removing user property", zzicVar.zzl().zzc(str));
            zzj().zzb();
            try {
                zzap(zzrVar);
                if ("_id".equals(str)) {
                    zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
                }
                zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), str);
                zzj().zzc();
                zzaW().zzj().zzb("User property removed", zzicVar.zzl().zzc(str));
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzaf() {
        this.zzs++;
    }

    final void zzag() {
        this.zzt++;
    }

    final zzic zzah() {
        return this.zzn;
    }

    final void zzai(zzr zzrVar) {
        int i;
        String str;
        String str2;
        long j;
        zzbd zzbdVarZzf;
        boolean z;
        PackageInfo packageInfo;
        long j2;
        String str3;
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        long j3;
        ApplicationInfo applicationInfo3;
        long j4;
        boolean z2;
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str4 = zzrVar.zza;
        Preconditions.checkNotEmpty(str4);
        if (zzaS(zzrVar)) {
            zzh zzhVarZzu = zzj().zzu(str4);
            if (zzhVarZzu != null && TextUtils.isEmpty(zzhVarZzu.zzf()) && !TextUtils.isEmpty(zzrVar.zzb)) {
                zzhVarZzu.zzI(0L);
                zzj().zzv(zzhVarZzu, false, false);
                zzh().zzh(str4);
            }
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            long jCurrentTimeMillis = zzrVar.zzl;
            zzal zzalVarZzd = zzd();
            zzfx zzfxVar = zzfy.zzbe;
            long jElapsedRealtime = zzalVarZzd.zzp(null, zzfxVar) ? zzrVar.zzF : 0L;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = zzba().currentTimeMillis();
                jElapsedRealtime = zzd().zzp(null, zzfxVar) ? zzba().elapsedRealtime() : 0L;
            }
            long j5 = jElapsedRealtime;
            long j6 = jCurrentTimeMillis;
            int i2 = zzrVar.zzm;
            if (i2 == 0 || i2 == 1) {
                i = i2;
            } else {
                zzaW().zze().zzc("Incorrect app type, assuming installed app. appId, appType", zzgu.zzl(str4), Integer.valueOf(i2));
                i = 0;
            }
            zzj().zzb();
            try {
                zzpn zzpnVarZzm = zzj().zzm(str4, "_npa");
                Boolean boolZzaU = zzaU(zzrVar);
                if (zzpnVarZzm != null && !"auto".equals(zzpnVarZzm.zzb)) {
                    str = "_sysu";
                    str2 = "_sys";
                    j = j6;
                } else if (boolZzaU != null) {
                    str = "_sysu";
                    str2 = "_sys";
                    j = j6;
                    zzpl zzplVar = new zzpl("_npa", j6, Long.valueOf(true != boolZzaU.booleanValue() ? 0L : 1L), "auto");
                    if (zzpnVarZzm == null || !zzpnVarZzm.zze.equals(zzplVar.zzd)) {
                        zzad(zzplVar, zzrVar);
                    }
                } else {
                    str = "_sysu";
                    str2 = "_sys";
                    j = j6;
                    if (zzpnVarZzm != null) {
                        zzae("_npa", zzrVar);
                    }
                }
                if (zzd().zzp(null, zzfy.zzaW)) {
                    zzao(zzrVar, zzrVar.zzD);
                } else {
                    zzao(zzrVar, j);
                }
                zzap(zzrVar);
                if (i == 0) {
                    zzbdVarZzf = zzj().zzf(str4, "_f");
                    z = false;
                } else {
                    zzbdVarZzf = zzj().zzf(str4, "_v");
                    z = true;
                }
                if (zzbdVarZzf == null) {
                    long j7 = ((j / 3600000) + 1) * 3600000;
                    if (z) {
                        long j8 = j;
                        zzad(new zzpl("_fvt", j8, Long.valueOf(j7), "auto"), zzrVar);
                        zzaX().zzg();
                        zzu();
                        Bundle bundle = new Bundle();
                        bundle.putLong("_c", 1L);
                        bundle.putLong("_r", 1L);
                        bundle.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle.putLong("_dac", 1L);
                        }
                        bundle.putLong("_elt", zzba().currentTimeMillis());
                        zzE(new zzbh("_v", new zzbf(bundle), "auto", j8, j5), zzrVar);
                    } else {
                        zzad(new zzpl("_fot", j, Long.valueOf(j7), "auto"), zzrVar);
                        zzaX().zzg();
                        zzhk zzhkVar = (zzhk) Preconditions.checkNotNull(this.zzm);
                        if (str4 == null || str4.isEmpty()) {
                            zzhkVar.zza.zzaW().zzf().zza("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            zzic zzicVar = zzhkVar.zza;
                            zzicVar.zzaX().zzg();
                            if (zzhkVar.zza()) {
                                zzhj zzhjVar = new zzhj(zzhkVar, str4);
                                zzicVar.zzaX().zzg();
                                Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                PackageManager packageManager = zzicVar.zzaZ().getPackageManager();
                                if (packageManager == null) {
                                    zzicVar.zzaW().zzf().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                                        zzhkVar.zza.zzaW().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                    } else {
                                        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
                                        if (resolveInfo.serviceInfo != null) {
                                            String str5 = resolveInfo.serviceInfo.packageName;
                                            if (resolveInfo.serviceInfo.name != null && "com.android.vending".equals(str5) && zzhkVar.zza()) {
                                                try {
                                                    zzicVar.zzaW().zzk().zzb("Install Referrer Service is", ConnectionTracker.getInstance().bindService(zzicVar.zzaZ(), new Intent(intent), zzhjVar, 1) ? "available" : "not available");
                                                } catch (RuntimeException e) {
                                                    zzhkVar.zza.zzaW().zzb().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                }
                                            } else {
                                                zzhkVar.zza.zzaW().zze().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                            }
                                        }
                                    }
                                }
                            } else {
                                zzicVar.zzaW().zzi().zza("Install Referrer Reporter is not available");
                            }
                        }
                        zzaX().zzg();
                        zzu();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1L);
                        bundle2.putLong("_r", 1L);
                        bundle2.putLong("_uwa", 0L);
                        bundle2.putLong("_pfo", 0L);
                        String str6 = str2;
                        bundle2.putLong(str6, 0L);
                        String str7 = str;
                        bundle2.putLong(str7, 0L);
                        bundle2.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle2.putLong("_dac", 1L);
                        }
                        String str8 = (String) Preconditions.checkNotNull(zzrVar.zza);
                        zzaw zzawVarZzj = zzj();
                        Preconditions.checkNotEmpty(str8);
                        zzawVarZzj.zzg();
                        zzawVarZzj.zzay();
                        long jZzN = zzawVarZzj.zzN(str8, "first_open_count");
                        zzic zzicVar2 = this.zzn;
                        if (zzicVar2.zzaZ().getPackageManager() == null) {
                            zzaW().zzb().zzb("PackageManager is null, first open report might be inaccurate. appId", zzgu.zzl(str8));
                            j2 = j;
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(zzicVar2.zzaZ()).getPackageInfo(str8, 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                zzaW().zzb().zzc("Package info is null, first open report might be inaccurate. appId", zzgu.zzl(str8), e2);
                                packageInfo = null;
                            }
                            if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                                j2 = j;
                                str3 = str8;
                                applicationInfo = null;
                            } else {
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    applicationInfo3 = null;
                                    if (!zzd().zzp(null, zzfy.zzaI)) {
                                        bundle2.putLong("_uwa", 1L);
                                    } else if (jZzN == 0) {
                                        bundle2.putLong("_uwa", 1L);
                                        z2 = false;
                                        j4 = 0;
                                    }
                                    j4 = jZzN;
                                    z2 = false;
                                } else {
                                    applicationInfo3 = null;
                                    j4 = jZzN;
                                    z2 = true;
                                }
                                Long lValueOf = Long.valueOf(true != z2 ? 0L : 1L);
                                long j9 = j;
                                j2 = j;
                                applicationInfo = applicationInfo3;
                                str3 = str8;
                                zzad(new zzpl("_fi", j9, lValueOf, "auto"), zzrVar);
                                jZzN = j4;
                            }
                            try {
                                applicationInfo2 = Wrappers.packageManager(this.zzn.zzaZ()).getApplicationInfo(str3, 0);
                            } catch (PackageManager.NameNotFoundException e3) {
                                zzaW().zzb().zzc("Application info is null, first open report might be inaccurate. appId", zzgu.zzl(str3), e3);
                                applicationInfo2 = applicationInfo;
                            }
                            if (applicationInfo2 != null) {
                                if ((applicationInfo2.flags & 1) != 0) {
                                    j3 = 1;
                                    bundle2.putLong(str6, 1L);
                                } else {
                                    j3 = 1;
                                }
                                if ((applicationInfo2.flags & 128) != 0) {
                                    bundle2.putLong(str7, j3);
                                }
                            }
                        }
                        if (jZzN >= 0) {
                            bundle2.putLong("_pfo", jZzN);
                        }
                        bundle2.putLong("_elt", zzba().currentTimeMillis());
                        zzE(new zzbh("_f", new zzbf(bundle2), "auto", j2, j5), zzrVar);
                    }
                } else {
                    long j10 = j;
                    if (zzrVar.zzi) {
                        zzE(new zzbh("_cd", new zzbf(new Bundle()), "auto", j10, 0L), zzrVar);
                    }
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzaj(zzr zzrVar) throws Throwable {
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzd().zzp(null, zzfy.zzay)) {
            long jCurrentTimeMillis = zzba().currentTimeMillis();
            int iZzm = zzd().zzm(null, zzfy.zzah);
            zzd();
            long jZzF = jCurrentTimeMillis - zzal.zzF();
            while (i < iZzm && zzaH(null, jZzF)) {
                i++;
            }
        } else {
            zzd();
            long jZzH = zzal.zzH();
            while (i < jZzH && zzaH(str, 0L)) {
                i++;
            }
        }
        if (zzd().zzp(null, zzfy.zzaz)) {
            zzaX().zzg();
            zzaw();
        }
        if (this.zzl.zzc(str, com.google.android.gms.internal.measurement.zzin.zzb(zzrVar.zzE))) {
            zzaW().zzk().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzN(str, zzba().currentTimeMillis());
        }
    }

    final void zzak(zzah zzahVar) {
        zzr zzrVarZzaP = zzaP((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzrVarZzaP != null) {
            zzal(zzahVar, zzrVarZzaP);
        }
    }

    final void zzal(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzb);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzah zzahVar2 = new zzah(zzahVar);
            boolean z = false;
            zzahVar2.zze = false;
            zzj().zzb();
            try {
                zzah zzahVarZzq = zzj().zzq((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzc.zzb);
                if (zzahVarZzq != null && !zzahVarZzq.zzb.equals(zzahVar2.zzb)) {
                    zzaW().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzb, zzahVarZzq.zzb);
                }
                if (zzahVarZzq != null && zzahVarZzq.zze) {
                    zzahVar2.zzb = zzahVarZzq.zzb;
                    zzahVar2.zzd = zzahVarZzq.zzd;
                    zzahVar2.zzh = zzahVarZzq.zzh;
                    zzahVar2.zzf = zzahVarZzq.zzf;
                    zzahVar2.zzi = zzahVarZzq.zzi;
                    zzahVar2.zze = true;
                    zzpl zzplVar = zzahVar2.zzc;
                    zzahVar2.zzc = new zzpl(zzplVar.zzb, zzahVarZzq.zzc.zzc, zzplVar.zza(), zzahVarZzq.zzc.zzf);
                } else if (TextUtils.isEmpty(zzahVar2.zzf)) {
                    zzpl zzplVar2 = zzahVar2.zzc;
                    zzahVar2.zzc = new zzpl(zzplVar2.zzb, zzahVar2.zzd, zzplVar2.zza(), zzahVar2.zzc.zzf);
                    zzahVar2.zze = true;
                    z = true;
                }
                if (zzahVar2.zze) {
                    zzpl zzplVar3 = zzahVar2.zzc;
                    zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzb, zzplVar3.zzb, zzplVar3.zzc, Preconditions.checkNotNull(zzplVar3.zza()));
                    if (zzj().zzl(zzpnVar)) {
                        zzaW().zzj().zzd("User property updated immediately", zzahVar2.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    } else {
                        zzaW().zzb().zzd("(2)Too many active user properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    }
                    if (z && zzahVar2.zzi != null) {
                        zzH(new zzbh(zzahVar2.zzi, zzahVar2.zzd, 0L), zzrVar);
                    }
                }
                if (zzj().zzp(zzahVar2)) {
                    zzaW().zzj().zzd("Conditional property added", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                } else {
                    zzaW().zzb().zzd("Too many conditional properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzam(zzah zzahVar) {
        zzr zzrVarZzaP = zzaP((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzrVarZzaP != null) {
            zzan(zzahVar, zzrVarZzaP);
        }
    }

    final void zzan(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzj().zzb();
            try {
                zzap(zzrVar);
                String str = (String) Preconditions.checkNotNull(zzahVar.zza);
                zzah zzahVarZzq = zzj().zzq(str, zzahVar.zzc.zzb);
                if (zzahVarZzq != null) {
                    zzaW().zzj().zzc("Removing conditional user property", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                    zzj().zzr(str, zzahVar.zzc.zzb);
                    if (zzahVarZzq.zze) {
                        zzj().zzk(str, zzahVar.zzc.zzb);
                    }
                    zzbh zzbhVar = zzahVar.zzk;
                    if (zzbhVar != null) {
                        zzbf zzbfVar = zzbhVar.zzb;
                        zzH((zzbh) Preconditions.checkNotNull(zzt().zzaf(str, ((zzbh) Preconditions.checkNotNull(zzbhVar)).zza, zzbfVar != null ? zzbfVar.zzf() : null, zzahVarZzq.zzb, zzbhVar.zzd, zzbhVar.zze, true, true)), zzrVar);
                    }
                } else {
                    zzaW().zze().zzc("Conditional user property doesn't exist", zzgu.zzl(zzahVar.zza), this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzao(zzr zzrVar, long j) {
        zzh zzhVarZzu = zzj().zzu((String) Preconditions.checkNotNull(zzrVar.zza));
        if (zzhVarZzu != null && zzt().zzD(zzrVar.zzb, zzhVarZzu.zzf())) {
            zzaW().zze().zzb("New GMP App Id passed in. Removing cached database data. appId", zzgu.zzl(zzhVarZzu.zzc()));
            zzaw zzawVarZzj = zzj();
            String strZzc = zzhVarZzu.zzc();
            zzawVarZzj.zzay();
            zzawVarZzj.zzg();
            Preconditions.checkNotEmpty(strZzc);
            try {
                SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj.zze();
                String[] strArr = {strZzc};
                int iDelete = sQLiteDatabaseZze.delete("events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZze.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZze.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZze.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseZze.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseZze.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZze.delete("consent_settings", "app_id=?", strArr) + sQLiteDatabaseZze.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseZze.delete("diagnostic_signals", "app_id=?", strArr);
                zzahh.zza();
                zzic zzicVar = zzawVarZzj.zzu;
                if (zzicVar.zzc().zzp(null, zzfy.zzbc)) {
                    iDelete += sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (iDelete > 0) {
                    zzicVar.zzaW().zzk().zzc("Deleted application data. app, records", strZzc, Integer.valueOf(iDelete));
                }
            } catch (SQLiteException e) {
                zzawVarZzj.zzu.zzaW().zzb().zzc("Error deleting application data. appId, error", zzgu.zzl(strZzc), e);
            }
            zzhVarZzu = null;
        }
        if (zzhVarZzu != null) {
            boolean z = (zzhVarZzu.zzt() == -2147483648L || zzhVarZzu.zzt() == zzrVar.zzj) ? false : true;
            String strZzr = zzhVarZzu.zzr();
            if (z || ((zzhVarZzu.zzt() != -2147483648L || strZzr == null || strZzr.equals(zzrVar.zzc)) ? false : true)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", strZzr);
                zzbh zzbhVar = new zzbh("_au", new zzbf(bundle), "auto", j, 0L);
                if (zzd().zzp(null, zzfy.zzaX)) {
                    zzE(zzbhVar, zzrVar);
                } else {
                    zzF(zzbhVar, zzrVar);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final com.google.android.gms.measurement.internal.zzh zzap(com.google.android.gms.measurement.internal.zzr r14) {
        /*
            Method dump skipped, instruction units count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzap(com.google.android.gms.measurement.internal.zzr):com.google.android.gms.measurement.internal.zzh");
    }

    final String zzaq(zzr zzrVar) {
        try {
            return (String) zzaX().zzh(new zzoz(this, zzrVar)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaW().zzb().zzc("Failed to get app instance id. appId", zzgu.zzl(zzrVar.zza), e);
            return null;
        }
    }

    final List zzar(zzr zzrVar, Bundle bundle) {
        int[] iArr;
        zzaX().zzg();
        zzaif.zza();
        zzal zzalVarZzd = zzd();
        String str = zzrVar.zza;
        if (!zzalVarZzd.zzp(str, zzfy.zzaO) || str == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zzaW().zzb().zza("Uri sources and timestamps do not match");
                } else {
                    int i = 0;
                    while (i < intArray.length) {
                        zzaw zzawVarZzj = zzj();
                        int i2 = intArray[i];
                        long j = longArray[i];
                        Preconditions.checkNotEmpty(str);
                        zzawVarZzj.zzg();
                        zzawVarZzj.zzay();
                        try {
                            iArr = intArray;
                        } catch (SQLiteException e) {
                            e = e;
                            iArr = intArray;
                        }
                        try {
                            int iDelete = zzawVarZzj.zze().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)});
                            zzgs zzgsVarZzk = zzawVarZzj.zzu.zzaW().zzk();
                            StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 46);
                            sb.append("Pruned ");
                            sb.append(iDelete);
                            sb.append(" trigger URIs. appId, source, timestamp");
                            zzgsVarZzk.zzd(sb.toString(), str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e2) {
                            e = e2;
                            zzawVarZzj.zzu.zzaW().zzb().zzc("Error pruning trigger URIs. appId", zzgu.zzl(str), e);
                        }
                        i++;
                        intArray = iArr;
                    }
                }
            }
        }
        zzaw zzawVarZzj2 = zzj();
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzawVarZzj2.zzg();
        zzawVarZzj2.zzay();
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = zzawVarZzj2.zze().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        arrayList.add(new zzoh(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e3) {
                zzawVarZzj2.zzu.zzaW().zzb().zzc("Error querying trigger uris. appId", zzgu.zzl(str2), e3);
                arrayList = Collections.emptyList();
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    final void zzas(String str, zzaf zzafVar) {
        zzaX().zzg();
        zzu();
        zzaw zzawVarZzj = zzj();
        long j = zzafVar.zza;
        zzpj zzpjVarZzB = zzawVarZzj.zzB(j);
        if (zzpjVarZzB == null) {
            zzaW().zze().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
            return;
        }
        String strZze = zzpjVarZzB.zze();
        if (zzafVar.zzb != zzlr.SUCCESS.zza()) {
            if (zzafVar.zzb == zzlr.BACKOFF.zza()) {
                Map map = this.zzF;
                zzpe zzpeVar = (zzpe) map.get(strZze);
                if (zzpeVar == null) {
                    zzpeVar = new zzpe(this);
                    map.put(strZze, zzpeVar);
                } else {
                    zzpeVar.zza();
                }
                zzaW().zzk().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, strZze, Long.valueOf((zzpeVar.zzc() - zzba().currentTimeMillis()) / 1000));
            }
            zzaw zzawVarZzj2 = zzj();
            Long lValueOf = Long.valueOf(zzafVar.zza);
            zzawVarZzj2.zzK(lValueOf);
            zzaW().zzk().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, lValueOf);
            return;
        }
        Map map2 = this.zzF;
        if (map2.containsKey(strZze)) {
            map2.remove(strZze);
        }
        zzaw zzawVarZzj3 = zzj();
        Long lValueOf2 = Long.valueOf(j);
        zzawVarZzj3.zzE(lValueOf2);
        zzaW().zzk().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, lValueOf2);
        long j2 = zzafVar.zzc;
        if (j2 > 0) {
            zzaw zzawVarZzj4 = zzj();
            zzawVarZzj4.zzg();
            zzawVarZzj4.zzay();
            Long lValueOf3 = Long.valueOf(j2);
            Preconditions.checkNotNull(lValueOf3);
            ContentValues contentValues = new ContentValues();
            contentValues.put("upload_type", Integer.valueOf(zzls.GOOGLE_SIGNAL.zza()));
            zzic zzicVar = zzawVarZzj4.zzu;
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzicVar.zzba().currentTimeMillis()));
            try {
                if (zzawVarZzj4.zze().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j2), str, String.valueOf(zzls.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                    zzicVar.zzaW().zze().zzc("Google Signal pending batch not updated. appId, rowId", str, lValueOf3);
                }
                zzaW().zzk().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzafVar.zzc));
                zzP(str);
            } catch (SQLiteException e) {
                zzawVarZzj4.zzu.zzaW().zzb().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j2), e);
                throw e;
            }
        }
    }

    final void zzat(boolean z) {
        zzaM();
    }

    public final void zzau(String str, zzlu zzluVar) {
        zzaX().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzluVar != null) {
            this.zzH = str;
            this.zzG = zzluVar;
        }
    }

    final /* synthetic */ void zzav(zzph zzphVar) {
        zzaX().zzg();
        this.zzm = new zzhk(this);
        zzaw zzawVar = new zzaw(this);
        zzawVar.zzaz();
        this.zze = zzawVar;
        zzd().zza((zzak) Preconditions.checkNotNull(this.zzc));
        zznn zznnVar = new zznn(this);
        zznnVar.zzaz();
        this.zzk = zznnVar;
        zzad zzadVar = new zzad(this);
        zzadVar.zzaz();
        this.zzh = zzadVar;
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.zzaz();
        this.zzj = zzlpVar;
        zzok zzokVar = new zzok(this);
        zzokVar.zzaz();
        this.zzg = zzokVar;
        this.zzf = new zzhb(this);
        if (this.zzs != this.zzt) {
            zzaW().zzb().zzc("Not all upload components initialized", Integer.valueOf(this.zzs), Integer.valueOf(this.zzt));
        }
        this.zzo.set(true);
        zzaW().zzk().zza("UploadController is now fully initialized");
    }

    final /* synthetic */ zzic zzay() {
        return this.zzn;
    }

    final /* synthetic */ Deque zzaz() {
        return this.zzr;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Clock zzba() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzba();
    }

    protected final void zzc() {
        zzaX().zzg();
        zzj().zzI();
        zzaw zzawVarZzj = zzj();
        zzawVarZzj.zzg();
        zzawVarZzj.zzay();
        if (zzawVarZzj.zzai()) {
            zzfx zzfxVar = zzfy.zzau;
            if (((Long) zzfxVar.zzb(null)).longValue() != 0) {
                SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj.zze();
                zzic zzicVar = zzawVarZzj.zzu;
                int iDelete = sQLiteDatabaseZze.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzicVar.zzba().currentTimeMillis()), String.valueOf(zzfxVar.zzb(null))});
                if (iDelete > 0) {
                    zzicVar.zzaW().zzk().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(iDelete));
                }
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzba().currentTimeMillis());
        }
        zzaM();
    }

    public final zzal zzd() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzc();
    }

    public final zzou zzf() {
        return this.zzl;
    }

    public final zzht zzh() {
        zzht zzhtVar = this.zzc;
        zzaT(zzhtVar);
        return zzhtVar;
    }

    public final zzgz zzi() {
        zzgz zzgzVar = this.zzd;
        zzaT(zzgzVar);
        return zzgzVar;
    }

    public final zzaw zzj() {
        zzaw zzawVar = this.zze;
        zzaT(zzawVar);
        return zzawVar;
    }

    public final zzhb zzk() {
        zzhb zzhbVar = this.zzf;
        if (zzhbVar != null) {
            return zzhbVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzok zzl() {
        zzok zzokVar = this.zzg;
        zzaT(zzokVar);
        return zzokVar;
    }

    public final zzad zzm() {
        zzad zzadVar = this.zzh;
        zzaT(zzadVar);
        return zzadVar;
    }

    public final zzlp zzn() {
        zzlp zzlpVar = this.zzj;
        zzaT(zzlpVar);
        return zzlpVar;
    }

    public final zzpk zzp() {
        zzpk zzpkVar = this.zzi;
        zzaT(zzpkVar);
        return zzpkVar;
    }

    public final zznn zzq() {
        return this.zzk;
    }

    public final zzgn zzs() {
        return this.zzn.zzl();
    }

    public final zzpp zzt() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzk();
    }

    final void zzu() {
        if (!this.zzo.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    final void zzv(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjl zzjlVarZzf = zzjl.zzf(zzrVar.zzs, zzrVar.zzx);
        zzB(str);
        zzaW().zzk().zzc("Setting storage consent for package", str, zzjlVarZzf);
        zzA(str, zzjlVarZzf);
    }

    final void zzw(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzba zzbaVarZzg = zzba.zzg(zzrVar.zzy);
        zzaW().zzk().zzc("Setting DMA consent for package", str, zzbaVarZzg);
        zzaX().zzg();
        zzu();
        zzji zzjiVarZzc = zzba.zzh(zzy(str), 100).zzc();
        this.zzD.put(str, zzbaVarZzg);
        zzj().zzad(str, zzbaVarZzg);
        zzji zzjiVarZzc2 = zzba.zzh(zzy(str), 100).zzc();
        zzaX().zzg();
        zzu();
        zzji zzjiVar = zzji.DENIED;
        boolean z = zzjiVarZzc == zzjiVar && zzjiVarZzc2 == zzji.GRANTED;
        boolean z2 = zzjiVarZzc == zzji.GRANTED && zzjiVarZzc2 == zzjiVar;
        if (z || z2) {
            zzaW().zzk().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzw(zzC(), str, false, false, false, false, false, false, false).zzf < zzd().zzm(str, zzfy.zzal)) {
                bundle.putLong("_r", 1L);
                zzaW().zzk().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzw(zzC(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzK.zza(str, "_dcu", bundle);
        }
    }

    final zzba zzx(String str) {
        zzaX().zzg();
        zzu();
        Map map = this.zzD;
        zzba zzbaVar = (zzba) map.get(str);
        if (zzbaVar != null) {
            return zzbaVar;
        }
        zzba zzbaVarZzab = zzj().zzab(str);
        map.put(str, zzbaVarZzab);
        return zzbaVarZzab;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    final Bundle zzy(String str) {
        zzaX().zzg();
        zzu();
        if (zzh().zzy(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjl zzjlVarZzB = zzB(str);
        bundle.putAll(zzjlVarZzB.zzn());
        bundle.putAll(zzz(str, zzx(str), zzjlVarZzB, new zzan()).zzf());
        zzpn zzpnVarZzm = zzj().zzm(str, "_npa");
        bundle.putString(Analytics.CONSENT_TYPE_AD_PERSONALIZATION, 1 != (zzpnVarZzm != null ? zzpnVarZzm.zze.equals(1L) : zzaD(str, new zzan())) ? Analytics.CONSENT_GRANTED : Analytics.CONSENT_DENIED);
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final com.google.android.gms.measurement.internal.zzba zzz(java.lang.String r12, com.google.android.gms.measurement.internal.zzba r13, com.google.android.gms.measurement.internal.zzjl r14, com.google.android.gms.measurement.internal.zzan r15) {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzht r0 = r11.zzh()
            com.google.android.gms.internal.measurement.zzgf r0 = r0.zzy(r12)
            java.lang.String r1 = "-"
            r2 = 90
            r3 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            r5 = 1
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)
            if (r0 != 0) goto L37
            com.google.android.gms.measurement.internal.zzji r12 = r13.zzc()
            com.google.android.gms.measurement.internal.zzji r14 = com.google.android.gms.measurement.internal.zzji.DENIED
            if (r12 != r14) goto L2a
            int r2 = r13.zzb()
            com.google.android.gms.measurement.internal.zzjk r12 = com.google.android.gms.measurement.internal.zzjk.AD_USER_DATA
            r15.zzb(r12, r2)
            goto L31
        L2a:
            com.google.android.gms.measurement.internal.zzjk r12 = com.google.android.gms.measurement.internal.zzjk.AD_USER_DATA
            com.google.android.gms.measurement.internal.zzam r13 = com.google.android.gms.measurement.internal.zzam.FAILSAFE
            r15.zzc(r12, r13)
        L31:
            com.google.android.gms.measurement.internal.zzba r12 = new com.google.android.gms.measurement.internal.zzba
            r12.<init>(r4, r2, r6, r1)
            return r12
        L37:
            com.google.android.gms.measurement.internal.zzji r0 = r13.zzc()
            com.google.android.gms.measurement.internal.zzji r7 = com.google.android.gms.measurement.internal.zzji.GRANTED
            if (r0 == r7) goto L88
            com.google.android.gms.measurement.internal.zzji r8 = com.google.android.gms.measurement.internal.zzji.DENIED
            if (r0 != r8) goto L44
            goto L88
        L44:
            com.google.android.gms.measurement.internal.zzji r13 = com.google.android.gms.measurement.internal.zzji.POLICY
            if (r0 != r13) goto L5b
            com.google.android.gms.measurement.internal.zzht r13 = r11.zzc
            com.google.android.gms.measurement.internal.zzjk r0 = com.google.android.gms.measurement.internal.zzjk.AD_USER_DATA
            com.google.android.gms.measurement.internal.zzji r13 = r13.zzB(r12, r0)
            com.google.android.gms.measurement.internal.zzji r9 = com.google.android.gms.measurement.internal.zzji.UNINITIALIZED
            if (r13 == r9) goto L5b
            com.google.android.gms.measurement.internal.zzam r14 = com.google.android.gms.measurement.internal.zzam.REMOTE_ENFORCED_DEFAULT
            r15.zzc(r0, r14)
            r0 = r13
            goto L91
        L5b:
            com.google.android.gms.measurement.internal.zzht r13 = r11.zzc
            com.google.android.gms.measurement.internal.zzjk r0 = com.google.android.gms.measurement.internal.zzjk.AD_USER_DATA
            com.google.android.gms.measurement.internal.zzjk r9 = r13.zzx(r12, r0)
            com.google.android.gms.measurement.internal.zzji r14 = r14.zzp()
            if (r14 == r7) goto L6b
            if (r14 != r8) goto L6c
        L6b:
            r3 = r5
        L6c:
            com.google.android.gms.measurement.internal.zzjk r10 = com.google.android.gms.measurement.internal.zzjk.AD_STORAGE
            if (r9 != r10) goto L79
            if (r3 == 0) goto L79
            com.google.android.gms.measurement.internal.zzam r13 = com.google.android.gms.measurement.internal.zzam.REMOTE_DELEGATION
            r15.zzc(r0, r13)
            r0 = r14
            goto L91
        L79:
            com.google.android.gms.measurement.internal.zzam r14 = com.google.android.gms.measurement.internal.zzam.REMOTE_DEFAULT
            r15.zzc(r0, r14)
            boolean r13 = r13.zzw(r12, r0)
            if (r5 == r13) goto L86
            r0 = r8
            goto L91
        L86:
            r0 = r7
            goto L91
        L88:
            int r2 = r13.zzb()
            com.google.android.gms.measurement.internal.zzjk r13 = com.google.android.gms.measurement.internal.zzjk.AD_USER_DATA
            r15.zzb(r13, r2)
        L91:
            com.google.android.gms.measurement.internal.zzht r13 = r11.zzc
            boolean r13 = r13.zzz(r12)
            com.google.android.gms.measurement.internal.zzht r14 = r11.zzh()
            java.util.SortedSet r12 = r14.zzA(r12)
            com.google.android.gms.measurement.internal.zzji r14 = com.google.android.gms.measurement.internal.zzji.DENIED
            if (r0 == r14) goto Lbc
            boolean r14 = r12.isEmpty()
            if (r14 == 0) goto Laa
            goto Lbc
        Laa:
            com.google.android.gms.measurement.internal.zzba r14 = new com.google.android.gms.measurement.internal.zzba
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r13)
            java.lang.String r0 = ""
            if (r13 == 0) goto Lb8
            java.lang.String r0 = android.text.TextUtils.join(r0, r12)
        Lb8:
            r14.<init>(r6, r2, r15, r0)
            return r14
        Lbc:
            com.google.android.gms.measurement.internal.zzba r12 = new com.google.android.gms.measurement.internal.zzba
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            r12.<init>(r4, r2, r13, r1)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzz(java.lang.String, com.google.android.gms.measurement.internal.zzba, com.google.android.gms.measurement.internal.zzjl, com.google.android.gms.measurement.internal.zzan):com.google.android.gms.measurement.internal.zzba");
    }
}
