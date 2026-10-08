package com.bytedance.sdk.openadsdk.core.fs.qdl.qdl;

import android.content.Context;
import android.text.TextUtils;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    public static com.bytedance.sdk.openadsdk.core.fs.qdl qdl(Context context, XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> list, int i, double d) throws XmlPullParserException, IOException {
        String name;
        xmlPullParser.require(2, mzz.wd, k.e);
        com.bytedance.sdk.openadsdk.core.fs.qdl qdlVar = new com.bytedance.sdk.openadsdk.core.fs.qdl();
        while (true) {
            if (xmlPullParser.next() != 3 || !k.e.equals(xmlPullParser.getName())) {
                if (xmlPullParser.getEventType() == 2) {
                    name = xmlPullParser.getName();
                    name.hashCode();
                    switch (name) {
                        case "AdVerifications":
                            qdlVar.qdl(mml.qdl(xmlPullParser));
                            continue;
                            break;
                        case "Creatives":
                            if (!TextUtils.isEmpty(qdlVar.wd()) && qdlVar.lnr() != null) {
                                break;
                            } else {
                                while (xmlPullParser.next() != 3) {
                                    if (xmlPullParser.getEventType() == 2) {
                                        if (k.p.equals(xmlPullParser.getName())) {
                                            qdl(context, xmlPullParser, qdlVar, i, d);
                                        } else {
                                            mzz.qdl(xmlPullParser);
                                        }
                                    }
                                }
                                break;
                            }
                            break;
                        case "Description":
                            qdlVar.ud(mzz.ud(xmlPullParser, name));
                            continue;
                            break;
                        case "Error":
                            list.addAll(mzz.qdl(xmlPullParser, name));
                            continue;
                            break;
                        case "Extensions":
                            while (true) {
                                if (xmlPullParser.getEventType() == 3 && "Extensions".equals(xmlPullParser.getName())) {
                                    continue;
                                    break;
                                } else {
                                    xmlPullParser.next();
                                    if (xmlPullParser.getEventType() == 2 && "AdVerifications".equals(xmlPullParser.getName())) {
                                        qdlVar.qdl(mml.qdl(xmlPullParser));
                                    }
                                }
                            }
                            break;
                        case "AdTitle":
                            qdlVar.qdl(mzz.ud(xmlPullParser, name));
                            continue;
                            break;
                        case "Impression":
                            qdlVar.qdl().qdl(mzz.qdl(xmlPullParser, name));
                            continue;
                            break;
                    }
                    mzz.qdl(xmlPullParser);
                }
            } else {
                qdlVar.qdl().to(list);
                return qdlVar;
            }
        }
    }

    public static void qdl(Context context, XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.fs.qdl qdlVar, int i, double d) throws XmlPullParserException, IOException {
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (k.q.equals(xmlPullParser.getName()) && TextUtils.isEmpty(qdlVar.wd())) {
                    lnr.qdl(xmlPullParser, qdlVar, i, d);
                } else if (k.L.equals(xmlPullParser.getName()) && qdlVar.lnr() == null) {
                    qdlVar.qdl(qdl.qdl(context, xmlPullParser));
                } else {
                    mzz.qdl(xmlPullParser);
                }
            }
        }
    }
}
