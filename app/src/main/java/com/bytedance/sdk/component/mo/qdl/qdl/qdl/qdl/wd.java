package com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.component.mo.qdl.jpc;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class wd extends lnr {
    private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl lnr;
    protected List<String> qdl;

    public byte lnr() {
        return (byte) 2;
    }

    public byte qdl() {
        return (byte) 1;
    }

    public wd(Context context, com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar) {
        super(context);
        this.qdl = new ArrayList();
        this.lnr = qdlVar;
        if (qdlVar == null) {
            this.lnr = com.bytedance.sdk.component.mo.qdl.mml.ud.qdl.lnr();
        }
    }

    @Override // com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl.lnr
    protected long mo() {
        return com.bytedance.sdk.component.mo.qdl.wd.qdl.ud();
    }

    @Override // com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl.lnr
    public String ud() {
        return jpc.wd().mml().mml();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0024: PHI (r0v2 int) = (r0v0 int), (r0v6 int) binds: [B:10:0x0029, B:6:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x0024: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:10:0x0029, B:6:0x0022] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int mml() {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = r9.mzz()     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = r9.ud()     // Catch: java.lang.Throwable -> L28
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L28
            java.lang.String r4 = "count(1)"
            r3[r0] = r4     // Catch: java.lang.Throwable -> L28
            r7 = 0
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r1 = com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L28
            if (r1 == 0) goto L22
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L29
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L29
        L22:
            if (r1 == 0) goto L2c
        L24:
            r1.close()     // Catch: java.lang.Exception -> L2c
            goto L2c
        L28:
            r1 = 0
        L29:
            if (r1 == 0) goto L2c
            goto L24
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl.wd.mml():int");
    }

    public List<com.bytedance.sdk.component.mo.qdl.mml.qdl> qdl(int i, String str) {
        long jQdl = com.bytedance.sdk.component.mo.qdl.ud.qdl.qdl(i, mzz());
        if (jQdl <= 0) {
            jQdl = 1;
        } else if (jQdl > 100) {
            jQdl = 100;
        }
        ArrayList arrayList = new ArrayList();
        this.qdl.clear();
        Cursor cursorQdl = com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(mzz(), ud(), new String[]{"id", "value", "encrypt"}, null, null, null, null, str + " DESC limit " + jQdl);
        if (cursorQdl != null) {
            while (cursorQdl.moveToNext()) {
                try {
                    try {
                        String string = cursorQdl.getString(cursorQdl.getColumnIndex("id"));
                        String string2 = cursorQdl.getString(cursorQdl.getColumnIndex("value"));
                        if (cursorQdl.getInt(cursorQdl.getColumnIndex("encrypt")) == 1) {
                            string2 = jpc.wd().jtx().qdl(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.qdl.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            com.bytedance.sdk.component.mo.qdl.mml.qdl.qdl qdlVar = new com.bytedance.sdk.component.mo.qdl.mml.qdl.qdl(string, new JSONObject(string2));
                            qdlVar.ud(lnr());
                            qdlVar.qdl(qdl());
                            arrayList.add(qdlVar);
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable th) {
                    if (cursorQdl != null) {
                        try {
                            cursorQdl.close();
                            if (!this.qdl.isEmpty()) {
                                qdl(this.qdl);
                                this.qdl.clear();
                            }
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
            if (cursorQdl != null) {
                try {
                    cursorQdl.close();
                    if (!this.qdl.isEmpty()) {
                        qdl(this.qdl);
                        this.qdl.clear();
                    }
                } catch (Exception unused3) {
                }
            }
        }
        return arrayList;
    }

    protected void qdl(List<String> list) {
        ud();
        list.size();
        com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(mzz(), "DELETE FROM " + ud() + " WHERE " + qdl("id", list, 1000, true));
        com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.tid(), list.size());
        lnr(list);
    }

    public List<com.bytedance.sdk.component.mo.qdl.mml.qdl> ud(String str) {
        com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar = this.lnr;
        if (qdlVar == null) {
            return new ArrayList();
        }
        return qdl(qdlVar.ud(), str);
    }

    public void ud(List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar : list) {
            linkedList.add(qdlVar.lnr());
            com.bytedance.sdk.component.mo.qdl.lnr.qdl.to(qdlVar);
        }
        ud();
        linkedList.size();
        com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(mzz(), "DELETE FROM " + ud() + " WHERE " + qdl("id", linkedList, 1000, true));
        lnr(linkedList);
    }

    public void qdl(int i, long j) {
        ud(i, j);
    }

    private void ud(int i, long j) {
        com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(mzz(), ud(), "gen_time <? AND retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j), String.valueOf(i)});
    }

    public boolean qdl(int i) {
        return this.lnr != null && mml() >= this.lnr.qdl();
    }

    public static String lnr(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    private static String qdl(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int iMin = Math.min(i, 1000);
        int size = list.size();
        if (size % iMin == 0) {
            i2 = size / iMin;
        } else {
            i2 = (size / iMin) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * iMin;
            String strQdl = qdl(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(strQdl);
            sb.append("')");
        }
        return qdl(sb.toString(), str + str2 + "('')");
    }

    private static String qdl(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
