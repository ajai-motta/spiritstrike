package com.apm.insight.nativecrash;

import com.apm.insight.l.j;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final Pattern i = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
    private static final Pattern j = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
    private static final Pattern k = Pattern.compile("^Abort message: (.*)$");
    private static final Pattern l = Pattern.compile("^Crash message: (.*)$");
    private static final Pattern m = Pattern.compile("^    \\/(\\w*)\\/.*\\/(.*\\.so)\\s\\(BuildId: ([a-f0-9]*)\\)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f231a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Map<String, String> h = new HashMap();

    public final String a() {
        return this.g;
    }

    public final Map<String, String> b() {
        return this.h;
    }

    public final String c() {
        StringBuilder sb = new StringBuilder();
        String str = this.e;
        if (str != null) {
            sb.append(str);
        }
        String str2 = this.f;
        if (str2 != null) {
            sb.append(str2);
        }
        String str3 = this.g;
        if (str3 != null) {
            sb.append(str3);
        }
        return sb.toString();
    }

    public final void a(File file) {
        File fileB = j.b(file);
        if (fileB.exists()) {
            fileB.renameTo(new File(fileB.getAbsoluteFile() + ".old"));
        }
        NativeImpl.a(file);
        c(j.b(file));
    }

    public final void b(File file) {
        c(j.b(file));
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0186, code lost:
    
        r12 = r3.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x018a, code lost:
    
        if (r12 == null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0192, code lost:
    
        if (r12.contains("BuildId:") == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0194, code lost:
    
        r12 = com.apm.insight.nativecrash.c.m.matcher(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019e, code lost:
    
        if (r12.find() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a0, code lost:
    
        r0 = r12.group(1);
        r1 = r12.group(2);
        r12 = r12.group(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b2, code lost:
    
        if (r0.equals("data") == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01b4, code lost:
    
        r11.h.put(r1, r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(java.io.File r12) {
        /*
            Method dump skipped, instruction units count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.c.c(java.io.File):void");
    }

    public c(File file) {
        c(j.b(file));
    }
}
