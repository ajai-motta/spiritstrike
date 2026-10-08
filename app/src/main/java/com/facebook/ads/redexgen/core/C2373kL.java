package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"NON_FINAL"}, value = "D54147219: For usage in Hero Simple Cache")
public final class C2373kL extends MZ {
    public static byte[] A00;
    public static String[] A01 = {"OfRtwvXctRBBw9gKY8TWbFYEyrfTWUJ5", "O6KpU7VzQb47vbeRDg05X09dlcjSdrsx", "cGvb3Ixjw9glBryIXlKjYbTfS5Fhfs8X", "N3q9w52q7yAs4MQ92KFgaGGqaH957eGg", "tjYOyBogfVGQWArOceKhNo0cgBZwypsu", "xmSgRcjNSrQyzCd8Uu5cYZa5hRrGr9a8", "10tums6VyruOnAjrgpE7eJ8", "dQkd96lx4iAtJg2k9NqdAtWwc5SxpqrB"};
    public static final Pattern A02;
    public static final Pattern A03;
    public static final Pattern A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa A[PHI: r8
  0x00aa: PHI (r8v2 long) = (r8v0 long), (r8v3 long) binds: [B:30:0x00d7, B:25:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.C2373kL A01(java.io.File r14, long r15, long r17, com.facebook.ads.redexgen.core.C1406Mi r19) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2373kL.A01(java.io.File, long, long, com.facebook.ads.redexgen.X.Mi):com.facebook.ads.redexgen.X.kL");
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{93, -93, -21, -88, -93, -38, -19, -28, -28, -82, -76, -79, -81, -30, -76, -82, -30, -22, -79, -81, -30, -76, -82, -30, -22, -79, -81, -30, -76, -4, -73, -30, -76, -21, -2, -11, -86, -13, -67, -61, -64, -66, -15, -61, -67, -15, -7, -64, -66, -15, -61, -67, -15, -7, -64, -66, -15, -61, Ascii.VT, -57, -15, -61, -6, Ascii.CR, 4, -71, -40, -94, -42, -34, -91, -93, -42, -88, -94, -42, -34, -91, -93, -42, -88, -94, -42, -34, -91, -93, -42, -88, -16, -83, -42, -88, -33, -14, -23, -98};
    }

    static {
        A08();
        A02 = Pattern.compile(A07(8, 29, 103), 32);
        A03 = Pattern.compile(A07(37, 29, 118), 32);
        A04 = Pattern.compile(A07(66, 30, 91), 32);
    }

    public C2373kL(String str, long j, long j2, long j3, File file) {
        super(str, j, j2, j3, file);
    }

    public static C2373kL A02(File file, long j, C1406Mi c1406Mi) {
        return A01(file, j, C.TIME_UNSET, c1406Mi);
    }

    public static C2373kL A03(String str, long j) {
        return new C2373kL(str, j, -1L, C.TIME_UNSET, null);
    }

    public static C2373kL A04(String str, long j, long j2) {
        return new C2373kL(str, j, j2, C.TIME_UNSET, null);
    }

    public static File A05(File file, int i, long j, long j2) {
        StringBuilder sbAppend = new StringBuilder().append(i);
        String strA07 = A07(0, 1, 16);
        return new File(file, sbAppend.append(strA07).append(j).append(strA07).append(j2).append(A07(1, 7, 86)).toString());
    }

    public static File A06(File file, C1406Mi c1406Mi) {
        String strA0l = null;
        String name = file.getName();
        Matcher matcher = A03.matcher(name);
        if (matcher.matches()) {
            String key = matcher.group(1);
            strA0l = C5C.A0l((String) AbstractC09493y.A01(key));
        } else {
            matcher = A02.matcher(name);
            if (matcher.matches()) {
                String key2 = matcher.group(1);
                Object objA01 = AbstractC09493y.A01(key2);
                String[] strArr = A01;
                String filename = strArr[0];
                if (filename.charAt(16) == strArr[2].charAt(16)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[0] = "SH9gvm8hJK4XlSeUgFI9DN0CGl9RiOAn";
                strArr2[2] = "6Y4JW5a7TLCjGmr1nVotQhjybpiv9cHJ";
                strA0l = (String) objA01;
            }
        }
        if (strA0l == null) {
            return null;
        }
        File file2 = (File) AbstractC09493y.A02(file.getParentFile());
        int iA0B = c1406Mi.A0B(strA0l);
        String key3 = matcher.group(2);
        long j = Long.parseLong((String) AbstractC09493y.A01(key3));
        String key4 = matcher.group(3);
        File fileA05 = A05(file2, iA0B, j, Long.parseLong((String) AbstractC09493y.A01(key4)));
        if (!file.renameTo(fileA05)) {
            return null;
        }
        return fileA05;
    }

    public final C2373kL A09(File file, long j) {
        AbstractC09493y.A08(this.A05);
        return new C2373kL(this.A04, this.A02, this.A01, j, file);
    }
}
