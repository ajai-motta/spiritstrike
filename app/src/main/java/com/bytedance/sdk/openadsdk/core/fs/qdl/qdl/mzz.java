package com.bytedance.sdk.openadsdk.core.fs.qdl.qdl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.fs.lnr.qdl;
import com.bytedance.sdk.openadsdk.core.fs.qdl.ud;
import com.bytedance.sdk.openadsdk.core.fs.to;
import com.bytedance.sdk.openadsdk.core.fs.ud.lnr;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class mzz extends com.bytedance.sdk.openadsdk.core.fs.qdl.ud {
    public static final String wd = null;

    public mzz(Context context, int i, int i2) {
        super(context, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.fs.qdl.ud
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.openadsdk.core.fs.qdl qdl(java.lang.String r5, java.io.File r6, java.util.List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            r4.mzz = r0
            android.content.Context r1 = r4.ud
            r2 = 0
            if (r1 != 0) goto Lc
            r5 = -1
            r4.mzz = r5
            return r2
        Lc:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto L18
            if (r6 != 0) goto L18
            r5 = -2
            r4.mzz = r5
            return r2
        L18:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r3 = "UTF-8"
            if (r1 != 0) goto L2a
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            byte[] r5 = r5.getBytes(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            goto L30
        L2a:
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r6 = r5
        L30:
            org.xmlpull.v1.XmlPullParser r5 = android.util.Xml.newPullParser()     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L59
            java.lang.String r1 = "http://xmlpull.org/v1/doc/features.html#process-namespaces"
            r5.setFeature(r1, r0)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L59
            r5.setInput(r6, r3)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L59
            r5.nextTag()     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L59
            com.bytedance.sdk.openadsdk.core.fs.qdl r5 = r4.qdl(r5, r7)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L59
            r4.qdl(r5)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L59
            r6.close()     // Catch: java.io.IOException -> L49
        L49:
            return r5
        L4a:
            r5 = move-exception
            goto L5b
        L4c:
            r6 = r2
        L4d:
            r5 = -3
            r4.mzz = r5     // Catch: java.lang.Throwable -> L59
            r4.qdl(r2)     // Catch: java.lang.Throwable -> L59
            if (r6 == 0) goto L58
            r6.close()     // Catch: java.io.IOException -> L58
        L58:
            return r2
        L59:
            r5 = move-exception
            r2 = r6
        L5b:
            if (r2 == 0) goto L60
            r2.close()     // Catch: java.io.IOException -> L60
        L60:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.mzz.qdl(java.lang.String, java.io.File, java.util.List):com.bytedance.sdk.openadsdk.core.fs.qdl");
    }

    private void qdl(com.bytedance.sdk.openadsdk.core.fs.qdl qdlVar) {
        if (this.mo == null) {
            this.mo = new ud.qdl();
        }
        this.mo.qdl = this.mzz;
        this.mo.ud = this.qdl;
        if (qdlVar != null) {
            this.mo.lnr = qdlVar.qdl().ud.size() <= 0;
        }
    }

    private com.bytedance.sdk.openadsdk.core.fs.qdl qdl(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> list) throws Throwable {
        xmlPullParser.require(2, wd, "VAST");
        boolean z = false;
        String strUd = null;
        while (xmlPullParser.next() != 1) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (k.c.equals(name)) {
                    strUd = ud(xmlPullParser, name);
                } else if (k.d.equals(name)) {
                    if (qdl(xmlPullParser.getAttributeValue(wd, "sequence"))) {
                        while (true) {
                            if (xmlPullParser.next() == 3 && k.d.equals(xmlPullParser.getName())) {
                                break;
                            }
                            if (xmlPullParser.getEventType() == 2) {
                                String name2 = xmlPullParser.getName();
                                if (k.e.equals(name2)) {
                                    com.bytedance.sdk.openadsdk.core.fs.qdl qdlVarQdl = ud.qdl(this.ud, xmlPullParser, list, this.lnr, this.mml);
                                    if (qdlVarQdl != null) {
                                        if (!TextUtils.isEmpty(qdlVarQdl.wd())) {
                                            return qdlVarQdl;
                                        }
                                        this.mzz = -6;
                                        return null;
                                    }
                                } else if (k.f.equals(name2)) {
                                    com.bytedance.sdk.openadsdk.core.fs.qdl qdlVarUd = ud(xmlPullParser, list);
                                    if (qdlVarUd != null) {
                                        return qdlVarUd;
                                    }
                                } else {
                                    qdl(xmlPullParser);
                                }
                            }
                        }
                    } else {
                        qdl(xmlPullParser);
                    }
                    z = true;
                } else {
                    qdl(xmlPullParser);
                }
            }
        }
        if (!z) {
            this.mzz = -4;
            lnr(strUd);
        }
        if (this.mzz == 0) {
            this.mzz = -5;
        }
        return null;
    }

    private void lnr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.fs.ud.lnr.qdl(com.bytedance.sdk.openadsdk.core.fs.ud.lnr.qdl((ljh) null, (List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr>) Collections.singletonList(new lnr.qdl(str).qdl()), this.qdl > 0 ? com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.NO_ADS_VAST_RESPONSE : com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.UNDEFINED_ERROR, -1L, (String) null, (String) null), (lnr.ud) null);
    }

    static class qdl {
        qdl.ud lnr;
        String mml;
        String qdl;
        qdl.EnumC0233qdl ud;
        final List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> mzz = new ArrayList();
        final List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> mo = new ArrayList();
        float wd = Float.MIN_VALUE;

        public qdl() {
        }

        public qdl(String str, qdl.EnumC0233qdl enumC0233qdl, qdl.ud udVar) {
            qdl(str, enumC0233qdl, udVar);
        }

        public void qdl(String str, qdl.EnumC0233qdl enumC0233qdl, qdl.ud udVar) {
            this.qdl = str;
            this.ud = enumC0233qdl;
            this.lnr = udVar;
        }

        public void qdl(String str) {
            this.mzz.add(new lnr.qdl(str).qdl());
        }

        public void ud(String str) {
            this.mo.add(new lnr.qdl(str).qdl());
        }
    }

    public static List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> qdl(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        return qdl(xmlPullParser, str, false);
    }

    public static List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> qdl(XmlPullParser xmlPullParser, String str, boolean z) throws XmlPullParserException, IOException {
        return qdl(ud(xmlPullParser, str), z);
    }

    public static int ud(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return Integer.MIN_VALUE;
        }
    }

    public static String ud(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String strTrim;
        String str2 = wd;
        xmlPullParser.require(2, str2, str);
        if (xmlPullParser.next() != 4) {
            strTrim = "";
        } else {
            strTrim = xmlPullParser.getText().trim();
            xmlPullParser.nextTag();
        }
        xmlPullParser.require(3, str2, str);
        return strTrim;
    }

    public static void qdl(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static void qdl(XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        while (xmlPullParser.getEventType() != 1) {
            if (str.equals(xmlPullParser.getName()) && xmlPullParser.getEventType() == i) {
                return;
            } else {
                xmlPullParser.next();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private com.bytedance.sdk.openadsdk.core.fs.qdl ud(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> list) throws Throwable {
        File file;
        String name;
        File file2 = null;
        if (this.qdl >= 5) {
            qdl(xmlPullParser);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.fs.mml mmlVar = new com.bytedance.sdk.openadsdk.core.fs.mml();
        String str = null;
        com.bytedance.sdk.openadsdk.core.fs.lnr lnrVarQdl = null;
        Set<to> setQdl = null;
        while (true) {
            if (xmlPullParser.getEventType() != 3 || !k.f.equals(xmlPullParser.getName())) {
                xmlPullParser.next();
                if (xmlPullParser.getEventType() == 2) {
                    name = xmlPullParser.getName();
                    name.hashCode();
                    switch (name) {
                        case "VASTAdTagURI":
                            String strQdl = qdl(ud(xmlPullParser, k.g), list);
                            if (!TextUtils.isEmpty(strQdl)) {
                                file = null;
                                str = strQdl;
                                break;
                            } else {
                                qdl(xmlPullParser, k.f, 3);
                                this.mzz = -2;
                                return null;
                            }
                            break;
                        case "Error":
                            list.add(new lnr.qdl(ud(xmlPullParser, k.c)).qdl());
                            file = null;
                            break;
                        case "Extensions":
                            while (true) {
                                if (xmlPullParser.getEventType() == 3 && "Extensions".equals(xmlPullParser.getName())) {
                                    file = null;
                                    break;
                                } else {
                                    xmlPullParser.next();
                                    if (xmlPullParser.getEventType() == 2 && "AdVerifications".equals(xmlPullParser.getName())) {
                                        setQdl = mml.qdl(xmlPullParser);
                                    }
                                }
                            }
                            break;
                        case "TrackingEvents":
                            lnr.qdl(xmlPullParser, mmlVar);
                            file = null;
                            break;
                        case "CompanionAds":
                            lnrVarQdl = com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.qdl.qdl(this.ud, xmlPullParser);
                            file2 = null;
                            break;
                        case "ClickTracking":
                            mmlVar.wd(qdl(xmlPullParser, k.z));
                            file = null;
                            break;
                        case "Impression":
                            mmlVar.qdl(qdl(xmlPullParser, name));
                            file = null;
                            break;
                        default:
                            file = null;
                            break;
                    }
                } else {
                    file = file2;
                }
                file2 = file;
            } else {
                com.bytedance.sdk.openadsdk.core.fs.qdl qdlVarQdl = qdl(str, file2, list);
                if (qdlVarQdl != null) {
                    if (qdlVarQdl.lnr() == null) {
                        qdlVarQdl.qdl(lnrVarQdl);
                    }
                    qdlVarQdl.qdl().qdl(mmlVar);
                    if (setQdl != null) {
                        qdlVarQdl.qdl(setQdl);
                    }
                }
                return qdlVarQdl;
            }
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> qdl(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        return Collections.singletonList(new lnr.qdl(str).qdl(z).qdl());
    }
}
