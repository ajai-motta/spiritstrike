package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class zzasa implements zzasu {
    public static final /* synthetic */ zzasa zza;
    public static final /* synthetic */ zzasa zzb;
    public static final /* synthetic */ zzasa zzc;
    public static final /* synthetic */ zzasa zzd;
    public static final /* synthetic */ zzasa zze;
    public static final /* synthetic */ zzasa zzf;
    public static final /* synthetic */ zzasa zzg;
    public static final /* synthetic */ zzasa zzh;
    public static final /* synthetic */ zzasa zzi;
    public static final /* synthetic */ zzasa zzj;
    public static final /* synthetic */ zzasa zzk;
    public static final /* synthetic */ zzasa zzl;
    public static final /* synthetic */ zzasa zzm;
    public static final /* synthetic */ zzasa zzn;
    public static final /* synthetic */ zzasa zzo;
    public static final /* synthetic */ zzasa zzp;
    public static final /* synthetic */ zzasa zzq;
    public static final /* synthetic */ zzasa zzr;
    public static final /* synthetic */ zzasa zzs;
    public static final /* synthetic */ zzasa zzt;
    public static final /* synthetic */ zzasa zzu;
    private final /* synthetic */ int zzv;

    static {
        int[] iArr = {1281944976, 1463473736, 847256033, 1698424328, 948255187, -1554299394, 419914800, 1727952741, 1091714937};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        iArr[0] = 2068224547;
        iArr[1] = 575179716;
        iArr[2] = 1587938398;
        iArr[3] = 1013484418;
        iArr[4] = 1605526586;
        iArr[5] = -933550855;
        iArr[6] = 218948411;
        iArr[7] = 1603386966;
        iArr[8] = 1010764797;
        iArr[0] = 682736626;
        iArr[1] = 1985796848;
        iArr[2] = 208315317;
        iArr[3] = 1922324801;
        iArr[4] = 8464129;
        iArr[5] = -706852288;
        iArr[6] = 1498387409;
        iArr[7] = 649022765;
        iArr[8] = 608034986;
        iArr[0] = 574682290;
        iArr[1] = 203332142;
        iArr[2] = 828655825;
        iArr[3] = 488280686;
        iArr[4] = 1367367889;
        iArr[5] = 2113643018;
        iArr[6] = 73912900;
        iArr[7] = 1891066487;
        iArr[8] = 382926234;
        int i9 = ((((203332142 & (~574682290)) | 828655825) + ((574682290 & 488280686) | 1367367889)) - 2039730118) ^ (1891066487 % 382926234);
        iArr[0] = 309667127;
        iArr[1] = 3230344;
        iArr[2] = 101519449;
        iArr[3] = 607439488;
        iArr[4] = 793023522;
        iArr[5] = 1313557171;
        iArr[6] = 466647227;
        iArr[7] = 1953534826;
        iArr[8] = 1902736997;
        iArr[0] = 1855103807;
        iArr[1] = 659964675;
        iArr[2] = 1290440236;
        iArr[3] = 588562691;
        iArr[4] = 482511980;
        iArr[5] = 2030511293;
        iArr[6] = 43196093;
        iArr[7] = 988506952;
        iArr[8] = 614340012;
        iArr[0] = 167368542;
        iArr[1] = 67146177;
        iArr[2] = 1656237739;
        iArr[3] = 1145098568;
        iArr[4] = 1113671327;
        iArr[5] = -1143176479;
        iArr[6] = 589913120;
        iArr[7] = 1999038585;
        iArr[8] = 574620392;
        iArr[0] = 138700754;
        iArr[1] = 1311190796;
        iArr[2] = 1098494210;
        iArr[3] = 235277837;
        iArr[4] = 2126145;
        iArr[5] = 2082044636;
        iArr[6] = 778544518;
        iArr[7] = 631340353;
        iArr[8] = 54449299;
        int i10 = (((((~138700754) & 1311190796) | 1098494210) + ((138700754 & 235277837) | 2126145)) - 1303500118) ^ (631340353 % 54449299);
        iArr[0] = 1725362297;
        iArr[1] = 1360741300;
        iArr[2] = 1109702041;
        iArr[3] = 354116135;
        iArr[4] = 1147188355;
        iArr[5] = -1599707889;
        iArr[6] = 234686974;
        iArr[7] = 1760481135;
        iArr[8] = 279527351;
        iArr[0] = 1362243428;
        iArr[1] = 18451060;
        iArr[2] = 1179867339;
        iArr[3] = 558662325;
        iArr[4] = 550966467;
        iArr[5] = 2036932222;
        iArr[6] = 413059767;
        iArr[7] = 1106211926;
        iArr[8] = 327305250;
        iArr[0] = 363159161;
        iArr[1] = 562794784;
        iArr[2] = 672605403;
        iArr[3] = 25727904;
        iArr[4] = 2081572569;
        iArr[5] = -1499032769;
        iArr[6] = 117043947;
        iArr[7] = 912078408;
        iArr[8] = 135177290;
        iArr[0] = 429857344;
        iArr[1] = 761470753;
        iArr[2] = 244716435;
        iArr[3] = 862030880;
        iArr[4] = 1585885407;
        iArr[5] = -1219426468;
        iArr[6] = 693550658;
        iArr[7] = 1209597698;
        iArr[8] = 1200977805;
        int i11 = (((((~429857344) & 761470753) | 244716435) + ((429857344 & 862030880) | 1585885407)) - (-1912977126)) ^ (1209597698 % 1200977805);
        iArr[0] = 1451163042;
        iArr[1] = 1144033732;
        iArr[2] = 979119168;
        iArr[3] = 1142985108;
        iArr[4] = 17523737;
        iArr[5] = 2082272570;
        iArr[6] = 447053428;
        iArr[7] = 1178835412;
        iArr[8] = 674426555;
        iArr[0] = 899633766;
        iArr[1] = 123837830;
        iArr[2] = 368257288;
        iArr[3] = 167810182;
        iArr[4] = 1023429240;
        iArr[5] = 1441797528;
        iArr[6] = 106553086;
        iArr[7] = 2104001379;
        iArr[8] = 2013966848;
        iArr[0] = 353056618;
        iArr[1] = 587352576;
        iArr[2] = 1209239528;
        iArr[3] = 1728108930;
        iArr[4] = 1420269559;
        iArr[5] = -1483278464;
        iArr[6] = 364027473;
        iArr[7] = 1896236448;
        iArr[8] = 1127167744;
        iArr[0] = 2129768394;
        iArr[1] = 1627076842;
        iArr[2] = 1930240353;
        iArr[3] = 384997514;
        iArr[4] = 369722160;
        iArr[5] = -969283552;
        iArr[6] = 1026488339;
        iArr[7] = 1450967523;
        iArr[8] = 42186306;
        int i12 = ((((587352576 & (~353056618)) | 1209239528) + ((353056618 & 1728108930) | 1420269559)) - (-1847305937)) ^ (1896236448 % 1127167744);
        int i13 = (((((~899633766) & 123837830) | 368257288) + ((899633766 & 167810182) | 1023429240)) - 1335244442) ^ (2104001379 % 2013966848);
        int i14 = (((((~1451163042) & 1144033732) | 979119168) + ((1451163042 & 1142985108) | 17523737)) - 1635219142) ^ (1178835412 % 674426555);
        int i15 = (((((~2129768394) & 1627076842) | 1930240353) + ((2129768394 & 384997514) | 369722160)) - (-1995771891)) ^ (1450967523 % 42186306);
        iArr[0] = 217704412;
        iArr[1] = 144255288;
        iArr[2] = 1174857666;
        iArr[3] = 1788447288;
        iArr[4] = 1667270208;
        iArr[5] = -513330018;
        iArr[6] = 928494151;
        iArr[7] = 1234644696;
        iArr[8] = 220282619;
        iArr[0] = 2105342203;
        iArr[1] = 63587109;
        iArr[2] = 1700430907;
        iArr[3] = 42025732;
        iArr[4] = 358031402;
        iArr[5] = 2065089764;
        iArr[6] = 11749780;
        iArr[7] = 1059789835;
        iArr[8] = 1012707329;
        iArr[0] = 880944650;
        iArr[1] = 1717883648;
        iArr[2] = 10231720;
        iArr[3] = 1718140932;
        iArr[4] = 277359766;
        iArr[5] = -1675436631;
        iArr[6] = 1148576388;
        iArr[7] = 2122533302;
        iArr[8] = 1588279465;
        zzu = new zzasa((((((~880944650) & 1717883648) | 10231720) + ((880944650 & 1718140932) | 277359766)) - 1470954277) ^ (2122533302 % 1588279465));
        zzt = new zzasa((((((~2105342203) & 63587109) | 1700430907) + ((2105342203 & 42025732) | 358031402)) - 2053339984) ^ (1059789835 % 1012707329));
        zzs = new zzasa((((((~217704412) & 144255288) | 1174857666) + ((217704412 & 1788447288) | 1667270208)) - (-1441824169)) ^ (1234644696 % 220282619));
        zzr = new zzasa(i15);
        zzq = new zzasa(i12);
        zzp = new zzasa(i13);
        zzasa zzasaVar = new zzasa(i14);
        int i16 = ((((562794784 & (~363159161)) | 672605403) + ((363159161 & 25727904) | 2081572569)) - (-1616076716)) ^ (912078408 % 135177290);
        int i17 = ((((18451060 & (~1362243428)) | 1179867339) + ((1362243428 & 558662325) | 550966467)) - 1623872455) ^ (1106211926 % 327305250);
        int i18 = (((((~1725362297) & 1360741300) | 1109702041) + ((1725362297 & 354116135) | 1147188355)) - (-1834394863)) ^ (1760481135 % 279527351);
        int i19 = (((((~167368542) & 67146177) | 1656237739) + ((167368542 & 1145098568) | 1113671327)) - (-1733089599)) ^ (1999038585 % 574620392);
        int i20 = (((((~1855103807) & 659964675) | 1290440236) + ((1855103807 & 588562691) | 482511980)) - 1987315200) ^ (988506952 % 614340012);
        int i21 = (((((~309667127) & 3230344) | 101519449) + ((309667127 & 607439488) | 793023522)) - 846909944) ^ (1953534826 % 1902736997);
        int i22 = ((((1985796848 & (~682736626)) | 208315317) + ((682736626 & 1922324801) | 8464129)) - 2089727599) ^ (649022765 % 608034986);
        int i23 = ((((575179716 & (~2068224547)) | 1587938398) + ((2068224547 & 1013484418) | 1605526586)) - (-1152499266)) ^ (1603386966 % 1010764797);
        int i24 = (i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)) ^ (i8 % 1091714937);
        zzo = zzasaVar;
        zzn = new zzasa(i11);
        zzm = new zzasa(i16);
        zzl = new zzasa(i17);
        zzk = new zzasa(i18);
        zzj = new zzasa(i10);
        zzi = new zzasa(i19);
        zzh = new zzasa(i20);
        zzg = new zzasa(i21);
        zzf = new zzasa(i9);
        zze = new zzasa(i22);
        zzd = new zzasa(i23);
        zzc = new zzasa(i24);
        zzb = new zzasa(1);
        zza = new zzasa(0);
    }

    private /* synthetic */ zzasa(int i) {
        this.zzv = i;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzarm zzarmVar;
        long jZzm;
        zzasl zzaslVar;
        zzast zzastVar;
        zzatc zzatcVarZzb;
        zzast zzastVar2;
        zzatc zzatcVarZzc;
        zzarm zzarmVar2;
        long j = 1;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        switch (this.zzv) {
                                            case 0:
                                                zzasx zzasxVar = (zzasx) obj;
                                                zzast zzastVar3 = zzasxVar.zzb;
                                                jZzm = zzastVar3.zzc().zzm();
                                                if (zzastVar3.zzc().zzm() != 0) {
                                                    zzaslVar = zzasxVar.zzd;
                                                    zzaslVar.zza(jZzm);
                                                    break;
                                                }
                                                return Optional.empty();
                                            case 1:
                                                try {
                                                    zzast zzastVar4 = ((zzasx) obj).zzb;
                                                    long jZzm2 = zzastVar4.zzc().zzm();
                                                    zzatc zzatcVarZzc2 = zzastVar4.zzc();
                                                    zzatc zzatcVarZzc3 = zzastVar4.zzc();
                                                    List listZzo = zzatcVarZzc3.zzo();
                                                    if (jZzm2 < 0) {
                                                        jZzm2 += (long) (listZzo.size() + 1);
                                                    }
                                                    if (jZzm2 < 0 || jZzm2 >= listZzo.size() + 1) {
                                                        throw new zzata();
                                                    }
                                                    listZzo.add((int) jZzm2, zzatcVarZzc2);
                                                    zzastVar4.zzb(zzatcVarZzc3);
                                                    return Optional.empty();
                                                } catch (zzata unused) {
                                                    zzarmVar = zzarm.zzI;
                                                    return Optional.of(zzarmVar);
                                                }
                                            case 2:
                                                zzasx zzasxVar2 = (zzasx) obj;
                                                zzast zzastVar5 = zzasxVar2.zzb;
                                                jZzm = zzastVar5.zzc().zzm();
                                                if (zzastVar5.zzc().zzm() == 0) {
                                                    zzaslVar = zzasxVar2.zzd;
                                                    zzaslVar.zza(jZzm);
                                                    break;
                                                }
                                                return Optional.empty();
                                            case 3:
                                                zzastVar = ((zzasx) obj).zzb;
                                                zzatcVarZzb = zzatc.zzb(zzastVar.zzc().zzo().size());
                                                zzastVar.zzb(zzatcVarZzb);
                                                return Optional.empty();
                                            case 4:
                                                zzastVar = ((zzasx) obj).zzb;
                                                zzatcVarZzb = zzatc.zzb(zzastVar.zzc().zzn().zza.length);
                                                zzastVar.zzb(zzatcVarZzb);
                                                return Optional.empty();
                                            case 5:
                                                zzastVar2 = ((zzasx) obj).zzb;
                                                zzatcVarZzc = zzatc.zzc(Math.log(zzastVar2.zzc().zzq()));
                                                zzastVar2.zzb(zzatcVarZzc);
                                                return Optional.empty();
                                            case 6:
                                                zzastVar2 = ((zzasx) obj).zzb;
                                                long jZzm3 = zzastVar2.zzc().zzm();
                                                long jZzm4 = zzastVar2.zzc().zzm();
                                                if (jZzm3 == 0 || jZzm4 == 0) {
                                                    j = 0;
                                                }
                                                zzatcVarZzc = zzatc.zzb(j);
                                                zzastVar2.zzb(zzatcVarZzc);
                                                return Optional.empty();
                                            case 7:
                                                zzastVar2 = ((zzasx) obj).zzb;
                                                if (zzastVar2.zzc().zzm() != 0) {
                                                    j = 0;
                                                }
                                                zzatcVarZzc = zzatc.zzb(j);
                                                zzastVar2.zzb(zzatcVarZzc);
                                                return Optional.empty();
                                            case 8:
                                                zzastVar2 = ((zzasx) obj).zzb;
                                                long jZzm5 = zzastVar2.zzc().zzm();
                                                long jZzm6 = zzastVar2.zzc().zzm();
                                                if (jZzm5 == 0 && jZzm6 == 0) {
                                                    j = 0;
                                                }
                                                zzatcVarZzc = zzatc.zzb(j);
                                                zzastVar2.zzb(zzatcVarZzc);
                                                return Optional.empty();
                                            case 9:
                                                zzasx zzasxVar3 = (zzasx) obj;
                                                zzast zzastVar6 = zzasxVar3.zzb;
                                                try {
                                                    int iCompare = new zzasy(false).compare(zzastVar6.zzc(), zzastVar6.zzc());
                                                    zzast zzastVar7 = zzasxVar3.zzb;
                                                    if (iCompare >= 0) {
                                                        j = 0;
                                                    }
                                                    zzastVar7.zzb(zzatc.zzb(j));
                                                    return Optional.empty();
                                                } catch (IllegalArgumentException unused2) {
                                                    return Optional.of(zzarm.zzd);
                                                }
                                            case 10:
                                                int i = ((((~1944216249) & 348137722) | 926438168) + ((1944216249 & 13122018) | 1882968836)) - (-1519516644);
                                                int i2 = 1723705710 % 1677157265;
                                                zzasx zzasxVar4 = (zzasx) obj;
                                                try {
                                                    zzast zzastVar8 = zzasxVar4.zzb;
                                                    long jZzm7 = zzastVar8.zzc().zzm();
                                                    zzars zzarsVar = zzasxVar4.zza;
                                                    zzast zzastVar9 = new zzast(i ^ i2);
                                                    for (int i3 = 0; i3 < zzastVar8.zzb; i3++) {
                                                        try {
                                                            zzastVar9.zzb(zzatc.zzj((zzatc) zzastVar8.zza.get(i3)));
                                                        } catch (zzass e) {
                                                            throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
                                                        }
                                                    }
                                                    zzasl zzaslVar2 = zzasxVar4.zzd;
                                                    new zzasx(zzarsVar, zzastVar9, new zzasl(zzaslVar2.zzb, zzaslVar2.zza, zzaslVar2.zzc.zzc(), zzaslVar2.zzd)).zzd.zza(jZzm7);
                                                    zzastVar8.zzb(zzatc.zza(new zzasc()));
                                                    return Optional.empty();
                                                } catch (zzasj | zzask unused3) {
                                                    zzarmVar = zzarm.zzt;
                                                    return Optional.of(zzarmVar);
                                                }
                                            case 11:
                                                try {
                                                    zzast zzastVar10 = ((zzasx) obj).zzb;
                                                    zzastVar10.zzb(zzatc.zza(zzastVar10.zzc().zzi((Class) zzastVar10.zzc().zzl())));
                                                    return Optional.empty();
                                                } catch (zzasz unused4) {
                                                    zzarmVar = zzarm.zzp;
                                                    return Optional.of(zzarmVar);
                                                }
                                            case 12:
                                                zzastVar2 = ((zzasx) obj).zzb;
                                                long jZzm8 = zzastVar2.zzc().zzm();
                                                long jZzm9 = zzastVar2.zzc().zzm();
                                                if (jZzm8 == 0) {
                                                    return Optional.of(zzarm.zzF);
                                                }
                                                zzatcVarZzc = zzatc.zzb(jZzm9 % jZzm8);
                                                zzastVar2.zzb(zzatcVarZzc);
                                                return Optional.empty();
                                            case 13:
                                                zzastVar2 = ((zzasx) obj).zzb;
                                                zzatcVarZzc = zzatc.zzc(zzastVar2.zzc().zzq() * zzastVar2.zzc().zzq());
                                                zzastVar2.zzb(zzatcVarZzc);
                                                return Optional.empty();
                                            case 14:
                                                zzastVar2 = ((zzasx) obj).zzb;
                                                zzatcVarZzc = zzatc.zzb(zzastVar2.zzc().zzm() * zzastVar2.zzc().zzm());
                                                zzastVar2.zzb(zzatcVarZzc);
                                                return Optional.empty();
                                            case 15:
                                                zzastVar = ((zzasx) obj).zzb;
                                                long jZzm10 = zzastVar.zzc().zzm();
                                                ArrayList arrayList = new ArrayList();
                                                for (long j2 = 0; j2 < jZzm10; j2++) {
                                                    arrayList.add(zzastVar.zzc());
                                                }
                                                Collections.reverse(arrayList);
                                                zzatcVarZzb = zzatc.zze(arrayList);
                                                zzastVar.zzb(zzatcVarZzb);
                                                return Optional.empty();
                                            case 16:
                                                zzastVar2 = ((zzasx) obj).zzb;
                                                zzatcVarZzc = zzatc.zzc(Math.pow(zzastVar2.zzc().zzq(), zzastVar2.zzc().zzq()));
                                                zzastVar2.zzb(zzatcVarZzc);
                                                return Optional.empty();
                                            case 17:
                                                ((zzasx) obj).zzb.zzb(zzatc.zza(null));
                                                return Optional.empty();
                                            case 18:
                                                zzasx zzasxVar5 = (zzasx) obj;
                                                ByteBuffer byteBufferWrap = ByteBuffer.wrap(zzasxVar5.zzd.zzf((((((~1201162069L) & 403189074) | 1043752718) + ((1201162069 & 95979632) | 900760100)) - 1766798336) ^ (507611410 % 329370448)).zza());
                                                byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                                                zzasxVar5.zzb.zzb(zzatc.zzc(Double.longBitsToDouble(byteBufferWrap.getLong())));
                                                return Optional.empty();
                                            case 19:
                                                zzasx zzasxVar6 = (zzasx) obj;
                                                zzasxVar6.zzb.zzb(zzatc.zzb(zzasxVar6.zzd.zze()));
                                                return Optional.empty();
                                            default:
                                                long j3 = ((((~346030096L) & 203234088) | 575197286) + ((346030096 & 2352425736L) | 2745332883L)) - 1505840317;
                                                long j4 = 1246101662 % 372004513;
                                                long j5 = ((((~1810821955L) & 1747262537) | 563863662) + ((1810821955 & 1295301633) | 94020008)) - 1690999106;
                                                long j6 = 1675644664 % 749217043;
                                                zzasx zzasxVar7 = (zzasx) obj;
                                                zzasl zzaslVar3 = zzasxVar7.zzd;
                                                long jZze = zzaslVar3.zze();
                                                if (jZze < 0 || jZze > (j3 ^ j4)) {
                                                    zzarmVar2 = zzarm.zzz;
                                                } else {
                                                    if (((j5 ^ j6) & jZze) == 0) {
                                                        zzasxVar7.zzb.zzb(zzatc.zzd(zzaslVar3.zzf(jZze)));
                                                        return Optional.empty();
                                                    }
                                                    zzarmVar2 = zzarm.zze;
                                                }
                                                return Optional.of(zzarmVar2);
                                        }
                                    } catch (zzasj | zzask unused5) {
                                        zzarmVar = zzarm.zzi;
                                    }
                                } catch (zzass e2) {
                                    e = e2;
                                    throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
                                }
                            } catch (zzasr unused6) {
                                zzarmVar = zzarm.zzx;
                            }
                        } catch (zzasz unused7) {
                            zzarmVar = zzarm.zzy;
                        }
                    } catch (zzasi unused8) {
                        zzarmVar = zzarm.zzD;
                    }
                } catch (zzass unused9) {
                    zzarmVar = zzarm.zza;
                }
            } catch (zzasj e3) {
                e = e3;
                throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
            }
        } catch (zzask unused10) {
            zzarmVar = zzarm.zzz;
        }
    }
}
