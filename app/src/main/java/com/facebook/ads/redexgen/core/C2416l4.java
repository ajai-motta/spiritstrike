package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.l4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2416l4 implements L8 {
    public static String[] A05 = {"ueDbV1wfakHSWIQF7BEzGoLlZXsjLXAz", "DUk", "o0l", "JXBQRCbHgV51hCMTPiBs95yrGLtJ9vRB", "UUCtZFjpq77XJSMaCIYouODFHgisrwF4", "OUp13aafPcRzH6W84Z44X0AbLYnCU3jN", "RRsP4MaHzu2rfmisltpPpgYoVzHnYDNm", "WbSPhlBTq3Mh8neaDCFEdYJRI0JZWypJ"};
    public final int A00;
    public final /* synthetic */ C2415l3 A04;
    public final C09714u A03 = new C09714u(new byte[5]);
    public final SparseArray<LH> A01 = new SparseArray<>();
    public final SparseIntArray A02 = new SparseIntArray();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0176  */
    @Override // com.facebook.ads.redexgen.core.L8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A5A(com.facebook.ads.redexgen.core.C09724v r13) {
        /*
            Method dump skipped, instruction units count: 623
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2416l4.A5A(com.facebook.ads.redexgen.X.4v):void");
    }

    public C2416l4(C2415l3 c2415l3, int i) {
        this.A04 = c2415l3;
        this.A00 = i;
    }

    private LD A00(C09724v c09724v, int i) {
        int descriptorTag = c09724v.A09();
        int descriptorLength = descriptorTag + i;
        int i2 = -1;
        String strTrim = null;
        ArrayList arrayList = null;
        while (c09724v.A09() < descriptorLength) {
            int positionOfNextDescriptor = c09724v.A0I();
            int iA09 = c09724v.A09() + c09724v.A0I();
            if (iA09 > descriptorLength) {
                break;
            }
            if (positionOfNextDescriptor == 5) {
                long jA0Q = c09724v.A0Q();
                if (jA0Q == 1094921523) {
                    i2 = TsExtractor.TS_STREAM_TYPE_AC3;
                } else if (jA0Q == 1161904947) {
                    i2 = TsExtractor.TS_STREAM_TYPE_E_AC3;
                } else if (jA0Q == 1094921524) {
                    i2 = TsExtractor.TS_STREAM_TYPE_AC4;
                } else if (jA0Q == 1212503619) {
                    i2 = 36;
                }
            } else if (positionOfNextDescriptor == 106) {
                i2 = TsExtractor.TS_STREAM_TYPE_AC3;
            } else if (positionOfNextDescriptor == 122) {
                i2 = TsExtractor.TS_STREAM_TYPE_E_AC3;
            } else {
                String[] strArr = A05;
                String str = strArr[1];
                String str2 = strArr[2];
                int descriptorsStartPosition = str.length();
                if (descriptorsStartPosition != str2.length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A05;
                strArr2[0] = "GzIOqzBb8TAh93bRV2CN08O62ZCaAqRX";
                strArr2[3] = "fp9XAk3ifz38aVsym619EhTf04al4HEa";
                if (positionOfNextDescriptor == 127) {
                    int descriptorsStartPosition2 = c09724v.A0I();
                    if (descriptorsStartPosition2 == 21) {
                        i2 = TsExtractor.TS_STREAM_TYPE_AC4;
                    }
                } else if (positionOfNextDescriptor == 123) {
                    i2 = TsExtractor.TS_STREAM_TYPE_DTS;
                } else {
                    String[] strArr3 = A05;
                    String str3 = strArr3[1];
                    String str4 = strArr3[2];
                    int descriptorsStartPosition3 = str3.length();
                    if (descriptorsStartPosition3 != str4.length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A05;
                    strArr4[5] = "wqYpRyaK4cDMDpt9hZQKwXCqV01Ydwf6";
                    strArr4[4] = "1qKbohas3rI7JmruTyrxsTuTEMq9fdbm";
                    if (positionOfNextDescriptor == 10) {
                        String strA0W = c09724v.A0W(3);
                        String[] strArr5 = A05;
                        String str5 = strArr5[1];
                        String str6 = strArr5[2];
                        int descriptorsStartPosition4 = str5.length();
                        if (descriptorsStartPosition4 != str6.length()) {
                            strTrim = strA0W.trim();
                        } else {
                            A05[6] = "aW10g0SpfKclE3j5mqsPv8AasgcB3Ji3";
                            strTrim = strA0W.trim();
                        }
                    } else if (positionOfNextDescriptor == 89) {
                        i2 = 89;
                        arrayList = new ArrayList();
                        while (c09724v.A09() < iA09) {
                            String strTrim2 = c09724v.A0W(3).trim();
                            int iA0I = c09724v.A0I();
                            byte[] bArr = new byte[4];
                            c09724v.A0k(bArr, 0, 4);
                            arrayList.add(new LC(strTrim2, iA0I, bArr));
                        }
                    } else if (positionOfNextDescriptor == 111) {
                        i2 = 257;
                    }
                }
            }
            c09724v.A0g(iA09 - c09724v.A09());
        }
        c09724v.A0f(descriptorLength);
        return new LD(i2, strTrim, arrayList, Arrays.copyOfRange(c09724v.A0l(), descriptorTag, descriptorLength));
    }

    @Override // com.facebook.ads.redexgen.core.L8
    public final void AAA(AnonymousClass53 anonymousClass53, HA ha, LG lg) {
    }
}
