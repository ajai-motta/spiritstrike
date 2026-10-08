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
public class qdl extends lnr {
    private final Context lnr;
    private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl mml;
    protected List<String> qdl;

    public byte lnr() {
        return (byte) 2;
    }

    public byte mml() {
        return (byte) 0;
    }

    public qdl(Context context, com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar) {
        super(context);
        this.qdl = new ArrayList();
        this.lnr = context;
        this.mml = qdlVar;
        if (qdlVar == null) {
            this.mml = com.bytedance.sdk.component.mo.qdl.mml.ud.qdl.lnr();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0025: PHI (r0v3 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:13:0x0030, B:6:0x0023] A[DONT_GENERATE, DONT_INLINE]
  0x0025: PHI (r1v3 int) = (r1v0 int), (r1v5 int) binds: [B:13:0x0030, B:6:0x0023] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int qdl() {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r10.mzz()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L30
            java.lang.String r3 = r10.ud()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L30
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L30
            java.lang.String r5 = "count(1)"
            r4[r1] = r5     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L30
            r8 = 0
            r9 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L30
            if (r0 == 0) goto L23
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L30
            int r1 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L30
        L23:
            if (r0 == 0) goto L33
        L25:
            r0.close()     // Catch: java.lang.Exception -> L33
            goto L33
        L29:
            r1 = move-exception
            if (r0 == 0) goto L2f
            r0.close()     // Catch: java.lang.Exception -> L2f
        L2f:
            throw r1
        L30:
            if (r0 == 0) goto L33
            goto L25
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl.qdl.qdl():int");
    }

    @Override // com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl.lnr
    public String ud() {
        com.bytedance.sdk.component.mo.qdl.qdl.mzz mzzVarMml = jpc.wd().mml();
        if (mzzVarMml != null) {
            return mzzVarMml.ud();
        }
        return null;
    }

    public List<com.bytedance.sdk.component.mo.qdl.mml.qdl> qdl(int i, String str) {
        String str2;
        String[] strArr;
        Cursor cursorQdl;
        long jQdl = com.bytedance.sdk.component.mo.qdl.ud.qdl.qdl(i, mzz());
        ud();
        if (jQdl <= 0) {
            jQdl = 1;
        } else if (jQdl > 100) {
            jQdl = 100;
        }
        String str3 = str + " DESC limit " + jQdl;
        ArrayList arrayList = new ArrayList();
        this.qdl.clear();
        long jYt = jpc.wd().yt();
        if (jYt > 0) {
            strArr = new String[]{String.valueOf(System.currentTimeMillis() - jYt)};
            str2 = "gen_time>?";
        } else {
            str2 = null;
            strArr = null;
        }
        if (com.bytedance.sdk.component.mo.qdl.lnr.qdl.mml() && mml() == 3) {
            cursorQdl = com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(mzz(), ud(), new String[]{"id", "value", "encrypt", "channel"}, str2, strArr, null, null, str3);
        } else {
            cursorQdl = com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(mzz(), ud(), new String[]{"id", "value", "encrypt"}, str2, strArr, null, null, str3);
        }
        if (cursorQdl != null) {
            try {
                com.bytedance.sdk.component.mo.qdl.mzz mzzVarJtx = jpc.wd().jtx();
                while (cursorQdl.moveToNext()) {
                    try {
                        String string = cursorQdl.getString(cursorQdl.getColumnIndex("id"));
                        String string2 = cursorQdl.getString(cursorQdl.getColumnIndex("value"));
                        int i2 = cursorQdl.getInt(cursorQdl.getColumnIndex("encrypt"));
                        int i3 = (com.bytedance.sdk.component.mo.qdl.lnr.qdl.mml() && mml() == 3) ? cursorQdl.getInt(cursorQdl.getColumnIndex("channel")) : 0;
                        if (i2 == 1) {
                            string2 = mzzVarJtx.qdl(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.qdl.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(string2);
                            com.bytedance.sdk.component.mo.qdl.mml.qdl.qdl qdlVar = new com.bytedance.sdk.component.mo.qdl.mml.qdl.qdl(string, jSONObject);
                            qdlVar.qdl(mml());
                            qdlVar.ud(lnr());
                            if (com.bytedance.sdk.component.mo.qdl.lnr.qdl.mml() && mml() == 3) {
                                qdlVar.qdl(i3);
                            }
                            com.bytedance.sdk.component.mo.qdl.lnr.qdl.qdl(jSONObject, qdlVar);
                            arrayList.add(qdlVar);
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                if (cursorQdl != null) {
                    try {
                        cursorQdl.close();
                        if (!this.qdl.isEmpty()) {
                            qdl(this.qdl);
                            this.qdl.clear();
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th2) {
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
                throw th2;
            }
        }
        ud();
        arrayList.size();
        return arrayList;
    }

    public List<com.bytedance.sdk.component.mo.qdl.mml.qdl> qdl(String str) {
        com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar = this.mml;
        if (qdlVar == null) {
            return new ArrayList();
        }
        return qdl(qdlVar.ud(), str);
    }

    protected void qdl(List<String> list) {
        ud();
        list.size();
        com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(mzz(), "DELETE FROM " + ud() + " WHERE " + qdl("id", list, 1000, true));
        com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.tid(), list.size());
        lnr(list);
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
        if (j > 0 || i > 0) {
            com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(mzz(), ud(), "gen_time <? OR retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j), String.valueOf(i)});
            ud();
        }
    }

    public boolean qdl(int i) {
        if (this.mml == null) {
            return false;
        }
        int iQdl = qdl();
        int iQdl2 = this.mml.qdl();
        ud();
        return (com.bytedance.sdk.component.mo.qdl.lnr.qdl.lnr() && (i == 1 || i == 2)) ? iQdl > 0 : iQdl >= iQdl2;
    }

    public static String ud(String str) {
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
