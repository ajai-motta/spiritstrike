package com.hive.authv4.devicemanagement.data;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.hive.logger.LoggerImpl;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CountryNumber.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/hive/authv4/devicemanagement/data/CountryNumber;", "", "<init>", "()V", "countryCodeToNumberMap", "", "", "", "getCountryCodeToNumberMap", "()Ljava/util/Map;", "uniqueCountryNumber", "", "getUniqueCountryNumber", "()Ljava/util/Set;", "findCountryNumberFromCountryCode", "countryCode", "findCountryNumberIndexFromCountryCode", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CountryNumber {
    public static final CountryNumber INSTANCE = new CountryNumber();
    private static final Map<String, Integer> countryCodeToNumberMap;
    private static final Set<Integer> uniqueCountryNumber;

    /* JADX INFO: Access modifiers changed from: private */
    public static final int countryCodeToNumberMap$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return 82;
    }

    private CountryNumber() {
    }

    public final Map<String, Integer> getCountryCodeToNumberMap() {
        return countryCodeToNumberMap;
    }

    static {
        Map<String, Integer> mapWithDefault = MapsKt.withDefault(MapsKt.mapOf(TuplesKt.to("AG", 1), TuplesKt.to("AI", 1), TuplesKt.to("AS", 1), TuplesKt.to("BB", 1), TuplesKt.to("BM", 1), TuplesKt.to("BS", 1), TuplesKt.to("CA", 1), TuplesKt.to("DM", 1), TuplesKt.to("DO", 1), TuplesKt.to("GD", 1), TuplesKt.to("GU", 1), TuplesKt.to("JM", 1), TuplesKt.to("KN", 1), TuplesKt.to("KY", 1), TuplesKt.to("LC", 1), TuplesKt.to("MP", 1), TuplesKt.to("MS", 1), TuplesKt.to("PR", 1), TuplesKt.to("SX", 1), TuplesKt.to("TC", 1), TuplesKt.to("TT", 1), TuplesKt.to("US", 1), TuplesKt.to("VC", 1), TuplesKt.to("VG", 1), TuplesKt.to("VI", 1), TuplesKt.to("KZ", 7), TuplesKt.to("RU", 7), TuplesKt.to("EG", 20), TuplesKt.to("ZA", 27), TuplesKt.to("GR", 30), TuplesKt.to("NL", 31), TuplesKt.to("BE", 32), TuplesKt.to("FR", 33), TuplesKt.to("ES", 34), TuplesKt.to("HU", 36), TuplesKt.to("IT", 39), TuplesKt.to("VA", 39), TuplesKt.to("RO", 40), TuplesKt.to("CH", 41), TuplesKt.to("AT", 43), TuplesKt.to("GB", 44), TuplesKt.to("GG", 44), TuplesKt.to("IM", 44), TuplesKt.to("JE", 44), TuplesKt.to("DK", 45), TuplesKt.to("SE", 46), TuplesKt.to("NO", 47), TuplesKt.to("SJ", 47), TuplesKt.to("PL", 48), TuplesKt.to("DE", 49), TuplesKt.to("PE", 51), TuplesKt.to("MX", 52), TuplesKt.to("CU", 53), TuplesKt.to("AR", 54), TuplesKt.to("BR", 55), TuplesKt.to("CL", 56), TuplesKt.to("CO", 57), TuplesKt.to("VE", 58), TuplesKt.to("MY", 60), TuplesKt.to("AU", 61), TuplesKt.to("CC", 61), TuplesKt.to("CX", 61), TuplesKt.to("ID", 62), TuplesKt.to("PH", 63), TuplesKt.to("NZ", 64), TuplesKt.to("SG", 65), TuplesKt.to("TH", 66), TuplesKt.to("JP", 81), TuplesKt.to("KR", 82), TuplesKt.to("VN", 84), TuplesKt.to("CN", 86), TuplesKt.to("TR", 90), TuplesKt.to("IN", 91), TuplesKt.to("PK", 92), TuplesKt.to("AF", 93), TuplesKt.to("LK", 94), TuplesKt.to("MM", 95), TuplesKt.to("IR", 98), TuplesKt.to("SS", 211), TuplesKt.to("EH", 212), TuplesKt.to(RequestConfiguration.MAX_AD_CONTENT_RATING_MA, 212), TuplesKt.to("DZ", 213), TuplesKt.to("TN", 216), TuplesKt.to("LY", 218), TuplesKt.to("GM", 220), TuplesKt.to("SN", 221), TuplesKt.to("MR", 222), TuplesKt.to("ML", 223), TuplesKt.to("GN", 224), TuplesKt.to("CI", 225), TuplesKt.to("BF", 226), TuplesKt.to("NE", 227), TuplesKt.to("TG", 228), TuplesKt.to("BJ", 229), TuplesKt.to("MU", 230), TuplesKt.to("LR", 231), TuplesKt.to("SL", 232), TuplesKt.to("GH", 233), TuplesKt.to("NG", 234), TuplesKt.to("TD", 235), TuplesKt.to("CF", 236), TuplesKt.to("CM", 237), TuplesKt.to("CV", 238), TuplesKt.to("ST", 239), TuplesKt.to("GQ", Integer.valueOf(PsExtractor.VIDEO_STREAM_MASK)), TuplesKt.to("GA", 241), TuplesKt.to("CG", 242), TuplesKt.to("CD", 243), TuplesKt.to("AO", 244), TuplesKt.to("GW", 245), TuplesKt.to("IO", 246), TuplesKt.to("AC", 247), TuplesKt.to("SC", 248), TuplesKt.to("SD", 249), TuplesKt.to("RW", 250), TuplesKt.to("ET", 251), TuplesKt.to("SO", 252), TuplesKt.to("DJ", 253), TuplesKt.to("KE", 254), TuplesKt.to("TZ", 255), TuplesKt.to("UG", 256), TuplesKt.to("BI", 257), TuplesKt.to("MZ", 258), TuplesKt.to("ZM", 260), TuplesKt.to("MG", 261), TuplesKt.to("RE", 262), TuplesKt.to("YT", 262), TuplesKt.to("ZW", 263), TuplesKt.to("NA", 264), TuplesKt.to("MW", 265), TuplesKt.to("LS", 266), TuplesKt.to("BW", 267), TuplesKt.to("SZ", 268), TuplesKt.to("KM", 269), TuplesKt.to("SH", 290), TuplesKt.to("TA", 290), TuplesKt.to("ER", 291), TuplesKt.to("AW", 297), TuplesKt.to("FO", 298), TuplesKt.to("GL", 299), TuplesKt.to("GI", 350), TuplesKt.to("PT", 351), TuplesKt.to("LU", 352), TuplesKt.to("IE", 353), TuplesKt.to("IS", 354), TuplesKt.to("AL", 355), TuplesKt.to("MT", 356), TuplesKt.to("CY", 357), TuplesKt.to("AX", 358), TuplesKt.to("FI", 358), TuplesKt.to("BG", 359), TuplesKt.to("LT", 370), TuplesKt.to("LV", 371), TuplesKt.to("EE", 372), TuplesKt.to("MD", 373), TuplesKt.to("AM", 374), TuplesKt.to("BY", 375), TuplesKt.to("AD", 376), TuplesKt.to("MC", 377), TuplesKt.to("SM", 378), TuplesKt.to("UA", 380), TuplesKt.to("RS", 381), TuplesKt.to("ME", 382), TuplesKt.to("XK", 383), TuplesKt.to("HR", 385), TuplesKt.to("SI", 386), TuplesKt.to("BA", 387), TuplesKt.to("MK", 389), TuplesKt.to("CZ", Integer.valueOf(TypedValues.CycleType.TYPE_EASING)), TuplesKt.to("SK", 421), TuplesKt.to("LI", Integer.valueOf(TypedValues.CycleType.TYPE_WAVE_PERIOD)), TuplesKt.to("FK", 500), TuplesKt.to("BZ", 501), TuplesKt.to("GT", 502), TuplesKt.to("SV", 503), TuplesKt.to("HN", 504), TuplesKt.to("NI", 505), TuplesKt.to("CR", 506), TuplesKt.to("PA", 507), TuplesKt.to("PM", Integer.valueOf(TypedValues.PositionType.TYPE_CURVE_FIT)), TuplesKt.to("HT", 509), TuplesKt.to("BL", 590), TuplesKt.to("GP", 590), TuplesKt.to("MF", 590), TuplesKt.to("BO", 591), TuplesKt.to("GY", 592), TuplesKt.to("EC", 593), TuplesKt.to("GF", 594), TuplesKt.to("PY", 595), TuplesKt.to("MQ", 596), TuplesKt.to("SR", 597), TuplesKt.to("UY", 598), TuplesKt.to("BQ", Integer.valueOf(CommonGatewayClient.CODE_599)), TuplesKt.to("CW", Integer.valueOf(CommonGatewayClient.CODE_599)), TuplesKt.to("TL", 670), TuplesKt.to("NF", 672), TuplesKt.to("BN", 673), TuplesKt.to("NR", 674), TuplesKt.to(RequestConfiguration.MAX_AD_CONTENT_RATING_PG, 675), TuplesKt.to("TO", 676), TuplesKt.to("SB", 677), TuplesKt.to("VU", 678), TuplesKt.to("FJ", 679), TuplesKt.to("PW", 680), TuplesKt.to("WF", 681), TuplesKt.to("CK", 682), TuplesKt.to("NU", 683), TuplesKt.to("WS", 685), TuplesKt.to("KI", 686), TuplesKt.to("NC", 687), TuplesKt.to("TV", 688), TuplesKt.to("PF", 689), TuplesKt.to("TK", 690), TuplesKt.to("FM", 691), TuplesKt.to("MH", 692), TuplesKt.to("KP", 850), TuplesKt.to("HK", 852), TuplesKt.to("MO", 853), TuplesKt.to("KH", 855), TuplesKt.to("LA", 856), TuplesKt.to("BD", 880), TuplesKt.to("TW", 886), TuplesKt.to("MV", 960), TuplesKt.to(ExpandedProductParsedResult.POUND, 961), TuplesKt.to("JO", 962), TuplesKt.to("SY", 963), TuplesKt.to("IQ", 964), TuplesKt.to("KW", 965), TuplesKt.to("SA", 966), TuplesKt.to("YE", 967), TuplesKt.to("OM", 968), TuplesKt.to("PS", 970), TuplesKt.to("AE", 971), TuplesKt.to("IL", 972), TuplesKt.to("BH", 973), TuplesKt.to("QA", 974), TuplesKt.to("BT", 975), TuplesKt.to("MN", 976), TuplesKt.to("NP", 977), TuplesKt.to("TJ", 992), TuplesKt.to("TM", 993), TuplesKt.to("AZ", 994), TuplesKt.to("GE", 995), TuplesKt.to(ExpandedProductParsedResult.KILOGRAM, 996), TuplesKt.to("UZ", Integer.valueOf(DescriptorProtos.Edition.EDITION_PROTO2_VALUE))), new Function1() { // from class: com.hive.authv4.devicemanagement.data.CountryNumber$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(CountryNumber.countryCodeToNumberMap$lambda$0((String) obj));
            }
        });
        countryCodeToNumberMap = mapWithDefault;
        uniqueCountryNumber = CollectionsKt.toSet(mapWithDefault.values());
    }

    public final Set<Integer> getUniqueCountryNumber() {
        return uniqueCountryNumber;
    }

    public final int findCountryNumberFromCountryCode(String countryCode) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        try {
            Result.Companion companion = Result.INSTANCE;
            Object value = MapsKt.getValue(countryCodeToNumberMap, countryCode);
            int iIntValue = ((Number) value).intValue();
            LoggerImpl.INSTANCE.d("findCountryNumberFromCountryCode : " + iIntValue);
            objM7415constructorimpl = Result.m7415constructorimpl(Integer.valueOf(((Number) value).intValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = 82;
        }
        return ((Number) objM7415constructorimpl).intValue();
    }

    public final int findCountryNumberIndexFromCountryCode(String countryCode) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        int iIndexOf = CollectionsKt.indexOf(uniqueCountryNumber, Integer.valueOf(findCountryNumberFromCountryCode(countryCode)));
        LoggerImpl.INSTANCE.d("findCountryNumberIndexFromCountryCode : " + iIndexOf);
        return iIndexOf;
    }
}
