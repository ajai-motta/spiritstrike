package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.c0;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f1308a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern c = Pattern.compile("CODECS=\"(.+?)\"");
    public static final Pattern d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern e = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern f = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern g = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern h = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern i = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern j = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern k = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern l = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern m = Pattern.compile("METHOD=(NONE|AES-128)");
    public static final Pattern n = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern o = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern p = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern q = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern r = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern s = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern t = Pattern.compile("AUTOSELECT".concat("=(NO|YES)"));
    public static final Pattern u = Pattern.compile("DEFAULT".concat("=(NO|YES)"));
    public static final Pattern v = Pattern.compile("FORCED".concat("=(NO|YES)"));

    /* JADX WARN: Multi-variable type inference failed */
    public static d b(f fVar, String str) throws r {
        String str2;
        int i2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        int i4 = 1;
        String str3 = null;
        long j2 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        boolean z = false;
        int i9 = 0;
        int i10 = 0;
        boolean zEquals = false;
        int i11 = 1;
        c cVar = null;
        String strA = null;
        String strB = null;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = C.TIME_UNSET;
        long j8 = C.TIME_UNSET;
        while (true) {
            long j9 = -1;
            while (fVar.a()) {
                if (fVar.a()) {
                    str2 = fVar.c;
                    fVar.c = str3;
                } else {
                    str2 = str3;
                }
                if (str2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    String strB2 = b(str2, g);
                    if ("VOD".equals(strB2)) {
                        i5 = i4;
                    } else if ("EVENT".equals(strB2)) {
                        i5 = 2;
                    }
                    str3 = null;
                } else {
                    if (str2.startsWith("#EXT-X-START")) {
                        j7 = (long) (Double.parseDouble(b(str2, j)) * 1000000.0d);
                    } else if (str2.startsWith("#EXT-X-MAP")) {
                        String strB3 = b(str2, n);
                        String strA2 = a(str2, l);
                        if (strA2 != null) {
                            String[] strArrSplit = strA2.split("@");
                            j9 = Long.parseLong(strArrSplit[i3]);
                            if (strArrSplit.length > i4) {
                                j4 = Long.parseLong(strArrSplit[i4]);
                            }
                        }
                        cVar = new c(strB3, 0L, -1, C.TIME_UNSET, false, null, null, j4, j9);
                        j4 = j2;
                        str3 = null;
                    } else if (str2.startsWith("#EXT-X-TARGETDURATION")) {
                        j8 = ((long) Integer.parseInt(b(str2, e))) * 1000000;
                    } else if (str2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        i9 = Integer.parseInt(b(str2, h));
                        i8 = i9;
                    } else if (str2.startsWith("#EXT-X-VERSION")) {
                        i11 = Integer.parseInt(b(str2, f));
                    } else if (str2.startsWith("#EXTINF")) {
                        j6 = (long) (Double.parseDouble(b(str2, i)) * 1000000.0d);
                    } else if (str2.startsWith("#EXT-X-KEY")) {
                        zEquals = "AES-128".equals(b(str2, m));
                        if (zEquals) {
                            strB = b(str2, n);
                            strA = a(str2, o);
                        } else {
                            str3 = null;
                            strA = null;
                            strB = null;
                        }
                    } else if (str2.startsWith("#EXT-X-BYTERANGE")) {
                        String[] strArrSplit2 = b(str2, k).split("@");
                        j9 = Long.parseLong(strArrSplit2[i3]);
                        if (strArrSplit2.length > i4) {
                            j4 = Long.parseLong(strArrSplit2[i4]);
                        }
                    } else if (str2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                        i7 = Integer.parseInt(str2.substring(str2.indexOf(58) + i4));
                        i6 = i4;
                    } else if (str2.equals("#EXT-X-DISCONTINUITY")) {
                        i10++;
                    } else if (str2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                        if (j3 == j2) {
                            String strSubstring = str2.substring(str2.indexOf(58) + i4);
                            Matcher matcher = z.f.matcher(strSubstring);
                            if (!matcher.matches()) {
                                throw new r("Invalid date/time format: " + strSubstring);
                            }
                            if (matcher.group(9) == null || matcher.group(9).equalsIgnoreCase("Z")) {
                                i2 = i3;
                            } else {
                                i2 = Integer.parseInt(matcher.group(13)) + (Integer.parseInt(matcher.group(12)) * 60);
                                if (matcher.group(11).equals("-")) {
                                    i2 *= -1;
                                }
                            }
                            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                            gregorianCalendar.clear();
                            gregorianCalendar.set(Integer.parseInt(matcher.group(i4)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
                            if (!TextUtils.isEmpty(matcher.group(8))) {
                                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
                            }
                            long timeInMillis = gregorianCalendar.getTimeInMillis();
                            if (i2 != 0) {
                                timeInMillis -= (long) (i2 * 60000);
                            }
                            int i12 = com.fyber.inneractive.sdk.player.exoplayer2.b.f1277a;
                            j3 = (timeInMillis == C.TIME_UNSET ? -9223372036854775807L : timeInMillis * 1000) - j5;
                        }
                    } else if (str2.startsWith("#EXT-X-DATERANGE")) {
                        arrayList2.add(str2);
                    } else if (!str2.startsWith("#")) {
                        String hexString = !zEquals ? null : strA != null ? strA : Integer.toHexString(i9);
                        int i13 = i9 + 1;
                        if (j9 == -1) {
                            j4 = 0;
                        }
                        arrayList.add(new c(str2, j6, i10, j5, zEquals, strB, hexString, j4, j9));
                        j5 += j6;
                        if (j9 != -1) {
                            j4 += j9;
                        }
                        i9 = i13;
                        j9 = -1;
                        i3 = 0;
                        i4 = 1;
                        str3 = null;
                        j2 = 0;
                        j6 = 0;
                    } else if (str2.equals("#EXT-X-ENDLIST")) {
                        i3 = 0;
                        i4 = 1;
                        str3 = null;
                        j2 = 0;
                        z = true;
                    }
                    str3 = null;
                }
                i3 = 0;
                i4 = 1;
                str3 = null;
                j2 = 0;
            }
            return new d(i5, str, j7, j3, i6, i7, i8, i11, j8, z, j3 != 0, cVar, arrayList, arrayList2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:3:0x000f, B:5:0x0017, B:7:0x001f, B:9:0x0027, B:34:0x006b, B:35:0x0072, B:12:0x002e, B:14:0x0034, B:18:0x003d, B:20:0x0045, B:23:0x0052, B:25:0x0058, B:29:0x005f, B:30:0x0064, B:36:0x0073, B:38:0x0079, B:41:0x0084, B:43:0x008c, B:44:0x009d, B:46:0x00a5, B:48:0x00ad, B:50:0x00b5, B:52:0x00bd, B:54:0x00c5, B:56:0x00cd, B:58:0x00d5, B:61:0x00de, B:62:0x00e2), top: B:70:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x004c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e a(android.net.Uri r7, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r8) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.g.a(android.net.Uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j):com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0217  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.f r46, java.lang.String r47) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        /*
            Method dump skipped, instruction units count: 670
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.g.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.f, java.lang.String):com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b");
    }

    public static String b(String str, Pattern pattern) throws r {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new r("Couldn't match " + pattern.pattern() + " in " + str);
    }

    public static String a(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
