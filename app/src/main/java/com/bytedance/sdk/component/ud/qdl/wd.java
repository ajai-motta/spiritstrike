package com.bytedance.sdk.component.ud.qdl;

import androidx.webkit.ProxyConfig;
import com.google.common.base.Ascii;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import kotlinx.io.files.FileSystemKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public final class wd {
    private static final char[] mml = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final List<String> jpc;
    final int lnr;
    private final String mo;
    private final String mzz;
    final String qdl;
    private final String to;
    private final String tvp;
    final String ud;
    private final List<String> wd;

    wd(qdl qdlVar) {
        this.qdl = qdlVar.qdl;
        this.mzz = qdl(qdlVar.ud, false);
        this.mo = qdl(qdlVar.lnr, false);
        this.ud = qdlVar.mml;
        this.lnr = qdlVar.qdl();
        this.wd = qdl(qdlVar.mo, false);
        this.jpc = qdlVar.wd != null ? qdl(qdlVar.wd, true) : null;
        this.tvp = qdlVar.jpc != null ? qdl(qdlVar.jpc, false) : null;
        this.to = qdlVar.toString();
    }

    public URL qdl() {
        try {
            return new URL(this.to);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String ud() {
        if (this.mzz.isEmpty()) {
            return "";
        }
        int length = this.qdl.length() + 3;
        String str = this.to;
        return this.to.substring(length, com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str, length, str.length(), ":@"));
    }

    public String lnr() {
        if (this.mo.isEmpty()) {
            return "";
        }
        return this.to.substring(this.to.indexOf(58, this.qdl.length() + 3) + 1, this.to.indexOf(64));
    }

    public static int qdl(String str) {
        if (str.equals(ProxyConfig.MATCH_HTTP)) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static void qdl(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(FileSystemKt.UnixPathSeparator);
            sb.append(list.get(i));
        }
    }

    public List<String> mml() {
        int iIndexOf = this.to.indexOf(47, this.qdl.length() + 3);
        String str = this.to;
        int iQdl = com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iQdl) {
            int i = iIndexOf + 1;
            int iQdl2 = com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(this.to, i, iQdl, FileSystemKt.UnixPathSeparator);
            arrayList.add(this.to.substring(i, iQdl2));
            iIndexOf = iQdl2;
        }
        return arrayList;
    }

    public String mzz() {
        if (this.jpc == null) {
            return null;
        }
        int iIndexOf = this.to.indexOf(63) + 1;
        String str = this.to;
        return this.to.substring(iIndexOf, com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str, iIndexOf, str.length(), '#'));
    }

    static void ud(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> ud(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public static wd lnr(String str) {
        qdl qdlVar = new qdl();
        if (qdlVar.qdl((wd) null, str) == qdl.EnumC0213qdl.SUCCESS) {
            return qdlVar.ud();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof wd) && ((wd) obj).to.equals(this.to);
    }

    public int hashCode() {
        return this.to.hashCode();
    }

    public String toString() {
        return this.to;
    }

    public static final class qdl {
        String jpc;
        String mml;
        final List<String> mo;
        String qdl;
        List<String> wd;
        String ud = "";
        String lnr = "";
        int mzz = -1;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.ud.qdl.wd$qdl$qdl, reason: collision with other inner class name */
        enum EnumC0213qdl {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public qdl() {
            ArrayList arrayList = new ArrayList();
            this.mo = arrayList;
            arrayList.add("");
        }

        public qdl qdl(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(ProxyConfig.MATCH_HTTP)) {
                this.qdl = ProxyConfig.MATCH_HTTP;
            } else if (str.equalsIgnoreCase("https")) {
                this.qdl = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: ".concat(String.valueOf(str)));
            }
            return this;
        }

        public qdl ud(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strMzz = mzz(str, 0, str.length());
            if (strMzz == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(String.valueOf(str)));
            }
            this.mml = strMzz;
            return this;
        }

        int qdl() {
            int i = this.mzz;
            return i != -1 ? i : wd.qdl(this.qdl);
        }

        public qdl lnr(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegments == null");
            }
            return qdl(str, true);
        }

        private qdl qdl(String str, boolean z) {
            int i = 0;
            do {
                int iQdl = com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str, i, str.length(), "/\\");
                qdl(str, i, iQdl, iQdl < str.length(), z);
                i = iQdl + 1;
            } while (i <= str.length());
            return this;
        }

        public qdl mml(String str) {
            this.wd = str != null ? wd.ud(wd.qdl(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public qdl qdl(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.wd == null) {
                this.wd = new ArrayList();
            }
            this.wd.add(wd.qdl(str, " \"'<>#&=", true, false, true, true));
            this.wd.add(str2 != null ? wd.qdl(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public wd ud() {
            if (this.qdl == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.mml == null) {
                throw new IllegalStateException("host == null");
            }
            return new wd(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.qdl);
            sb.append("://");
            if (!this.ud.isEmpty() || !this.lnr.isEmpty()) {
                sb.append(this.ud);
                if (!this.lnr.isEmpty()) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(this.lnr);
                }
                sb.append('@');
            }
            if (this.mml.indexOf(58) != -1) {
                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                sb.append(this.mml);
                sb.append(AbstractJsonLexerKt.END_LIST);
            } else {
                sb.append(this.mml);
            }
            int iQdl = qdl();
            if (iQdl != wd.qdl(this.qdl)) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(iQdl);
            }
            wd.qdl(sb, this.mo);
            if (this.wd != null) {
                sb.append('?');
                wd.ud(sb, this.wd);
            }
            if (this.jpc != null) {
                sb.append('#');
                sb.append(this.jpc);
            }
            return sb.toString();
        }

        EnumC0213qdl qdl(wd wdVar, String str) {
            int iQdl;
            int i;
            int iQdl2 = com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str, 0, str.length());
            int iUd = com.bytedance.sdk.component.ud.qdl.ud.tvp.ud(str, iQdl2, str.length());
            if (ud(str, iQdl2, iUd) != -1) {
                if (str.regionMatches(true, iQdl2, "https:", 0, 6)) {
                    this.qdl = "https";
                    iQdl2 += 6;
                } else if (str.regionMatches(true, iQdl2, "http:", 0, 5)) {
                    this.qdl = ProxyConfig.MATCH_HTTP;
                    iQdl2 += 5;
                } else {
                    return EnumC0213qdl.UNSUPPORTED_SCHEME;
                }
            } else if (wdVar != null) {
                this.qdl = wdVar.qdl;
            } else {
                return EnumC0213qdl.MISSING_SCHEME;
            }
            int iLnr = lnr(str, iQdl2, iUd);
            char c = '?';
            char c2 = '#';
            if (iLnr >= 2 || wdVar == null || !wdVar.qdl.equals(this.qdl)) {
                boolean z = false;
                boolean z2 = false;
                int i2 = iQdl2 + iLnr;
                while (true) {
                    iQdl = com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str, i2, iUd, "@/\\?#");
                    byte bCharAt = iQdl != iUd ? str.charAt(iQdl) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z) {
                            int iQdl3 = com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str, i2, iQdl, AbstractJsonLexerKt.COLON);
                            i = iQdl;
                            String strQdl = wd.qdl(str, i2, iQdl3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strQdl = this.ud + "%40" + strQdl;
                            }
                            this.ud = strQdl;
                            if (iQdl3 != i) {
                                this.lnr = wd.qdl(str, iQdl3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = iQdl;
                            this.lnr += "%40" + wd.qdl(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                        c = '?';
                        c2 = '#';
                    }
                }
                int iMml = mml(str, i2, iQdl);
                int i3 = iMml + 1;
                if (i3 < iQdl) {
                    this.mml = mzz(str, i2, iMml);
                    int iMo = mo(str, i3, iQdl);
                    this.mzz = iMo;
                    if (iMo == -1) {
                        return EnumC0213qdl.INVALID_PORT;
                    }
                } else {
                    this.mml = mzz(str, i2, iMml);
                    this.mzz = wd.qdl(this.qdl);
                }
                if (this.mml == null) {
                    return EnumC0213qdl.INVALID_HOST;
                }
                iQdl2 = iQdl;
            } else {
                this.ud = wdVar.ud();
                this.lnr = wdVar.lnr();
                this.mml = wdVar.ud;
                this.mzz = wdVar.lnr;
                this.mo.clear();
                this.mo.addAll(wdVar.mml());
                if (iQdl2 == iUd || str.charAt(iQdl2) == '#') {
                    mml(wdVar.mzz());
                }
            }
            int iQdl4 = com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str, iQdl2, iUd, "?#");
            qdl(str, iQdl2, iQdl4);
            if (iQdl4 < iUd && str.charAt(iQdl4) == '?') {
                int iQdl5 = com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str, iQdl4, iUd, '#');
                this.wd = wd.ud(wd.qdl(str, iQdl4 + 1, iQdl5, " \"'<>#", true, false, true, true, null));
                iQdl4 = iQdl5;
            }
            if (iQdl4 < iUd && str.charAt(iQdl4) == '#') {
                this.jpc = wd.qdl(str, 1 + iQdl4, iUd, "", true, false, false, false, null);
            }
            return EnumC0213qdl.SUCCESS;
        }

        private void qdl(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.mo.clear();
                this.mo.add("");
                i++;
            } else {
                List<String> list = this.mo;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str, i3, i2, "/\\");
                boolean z = i < i2;
                qdl(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void qdl(String str, int i, int i2, boolean z, boolean z2) {
            String strQdl = wd.qdl(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (mzz(strQdl)) {
                return;
            }
            if (mo(strQdl)) {
                lnr();
                return;
            }
            if (this.mo.get(r11.size() - 1).isEmpty()) {
                this.mo.set(r11.size() - 1, strQdl);
            } else {
                this.mo.add(strQdl);
            }
            if (z) {
                this.mo.add("");
            }
        }

        private boolean mzz(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean mo(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void lnr() {
            if (this.mo.remove(r0.size() - 1).isEmpty() && !this.mo.isEmpty()) {
                this.mo.set(r0.size() - 1, "");
            } else {
                this.mo.add("");
            }
        }

        private static int ud(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int lnr(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int mml(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String mzz(String str, int i, int i2) {
            return com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(wd.qdl(str, i, i2, false));
        }

        private static int mo(String str, int i, int i2) {
            int i3;
            try {
                i3 = Integer.parseInt(wd.qdl(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i3 <= 0 || i3 > 65535) {
                return -1;
            }
            return i3;
        }
    }

    static String qdl(String str, boolean z) {
        return qdl(str, 0, str.length(), z);
    }

    private List<String> qdl(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? qdl(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String qdl(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                com.bytedance.sdk.component.ud.qdl.ud.qdl qdlVar = new com.bytedance.sdk.component.ud.qdl.ud.qdl();
                qdlVar.qdl(str, i, i3);
                qdl(qdlVar, str, i3, i2, z);
                return qdlVar.lnr();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void qdl(com.bytedance.sdk.component.ud.qdl.ud.qdl r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(r2)
            char r3 = r6.charAt(r1)
            int r3 = com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.ud(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.ud(r1)
            goto L3c
        L39:
            r5.qdl(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ud.qdl.wd.qdl(com.bytedance.sdk.component.ud.qdl.ud.qdl, java.lang.String, int, int, boolean):void");
    }

    static boolean qdl(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str.charAt(i + 1)) != -1 && com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl(str.charAt(i3)) != -1;
    }

    static String qdl(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || qdl(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    com.bytedance.sdk.component.ud.qdl.ud.qdl qdlVar = new com.bytedance.sdk.component.ud.qdl.ud.qdl();
                    qdlVar.qdl(str, i, iCharCount);
                    qdl(qdlVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                    return qdlVar.lnr();
                }
            } else {
                com.bytedance.sdk.component.ud.qdl.ud.qdl qdlVar2 = new com.bytedance.sdk.component.ud.qdl.ud.qdl();
                qdlVar2.qdl(str, i, iCharCount);
                qdl(qdlVar2, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return qdlVar2.lnr();
            }
        }
        return str.substring(i, i2);
    }

    static void qdl(com.bytedance.sdk.component.ud.qdl.ud.qdl qdlVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.component.ud.qdl.ud.qdl qdlVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    qdlVar.qdl(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !qdl(str, i, i2)))))) {
                    if (qdlVar2 == null) {
                        qdlVar2 = new com.bytedance.sdk.component.ud.qdl.ud.qdl();
                    }
                    if (charset == null || charset.equals(com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl)) {
                        qdlVar2.qdl(iCodePointAt);
                    } else {
                        qdlVar2.qdl(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!qdlVar2.qdl()) {
                        byte bUd = qdlVar2.ud();
                        qdlVar.ud(37);
                        char[] cArr = mml;
                        qdlVar.ud((int) cArr[((bUd & 255) >> 4) & 15]);
                        qdlVar.ud((int) cArr[bUd & Ascii.SI]);
                    }
                } else {
                    qdlVar.qdl(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static String qdl(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return qdl(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
