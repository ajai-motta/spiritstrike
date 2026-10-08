package com.bytedance.sdk.component.mo.qdl.mo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class mo implements mzz {
    private Context qdl;

    public mo(Context context) {
        this.qdl = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0094 A[DONT_GENERATE, PHI: r1
  0x0094: PHI (r1v4 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v1 android.database.Cursor) binds: [B:27:0x00a6, B:18:0x0092] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bytedance.sdk.component.mo.qdl.mo.mzz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.bytedance.sdk.component.mo.qdl.mo.mml> qdl() {
        /*
            r12 = this;
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            android.content.Context r1 = r12.qdl
            r7 = 0
            r8 = 0
            java.lang.String r2 = "trackurl"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r1 = com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r1 == 0) goto La9
        L15:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L98
            if (r2 == 0) goto L92
            java.lang.String r2 = "id"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L98
            java.lang.String r4 = r1.getString(r2)     // Catch: java.lang.Throwable -> L98
            java.lang.String r2 = "url"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.Throwable -> L98
            java.lang.String r2 = "replaceholder"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L98
            int r2 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L98
            if (r2 <= 0) goto L3e
            r2 = 1
            goto L3f
        L3e:
            r2 = 0
        L3f:
            r6 = r2
            java.lang.String r2 = "retry"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L98
            int r2 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "url_type"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L98
            int r7 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "ad_id"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L98
            java.lang.String r8 = r1.getString(r3)     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "error_code"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L98
            java.lang.String r9 = r1.getString(r3)     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "error_msg"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L98
            java.lang.String r10 = r1.getString(r3)     // Catch: java.lang.Throwable -> L98
            com.bytedance.sdk.component.mo.qdl.mo.mml r11 = new com.bytedance.sdk.component.mo.qdl.mo.mml     // Catch: java.lang.Throwable -> L98
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L98
            r11.qdl(r2)     // Catch: java.lang.Throwable -> L98
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L98
            if (r2 != 0) goto L85
            r11.qdl(r9)     // Catch: java.lang.Throwable -> L98
        L85:
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L98
            if (r2 != 0) goto L8e
            r11.ud(r10)     // Catch: java.lang.Throwable -> L98
        L8e:
            r0.add(r11)     // Catch: java.lang.Throwable -> L98
            goto L15
        L92:
            if (r1 == 0) goto La9
        L94:
            r1.close()
            goto La9
        L98:
            if (r1 == 0) goto La6
            r1.close()     // Catch: java.lang.Throwable -> L9f
            r1 = 0
            goto La6
        L9f:
            r0 = move-exception
            if (r1 == 0) goto La5
            r1.close()
        La5:
            throw r0
        La6:
            if (r1 == 0) goto La9
            goto L94
        La9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.mo.qdl.mo.mo.qdl():java.util.List");
    }

    @Override // com.bytedance.sdk.component.mo.qdl.mo.mzz
    public mml qdl(String str) {
        Cursor cursorQdl = com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(this.qdl, "trackurl", null, "id=?", new String[]{str}, null, null, null);
        if (cursorQdl != null && cursorQdl.moveToFirst()) {
            try {
                String string = cursorQdl.getString(cursorQdl.getColumnIndex("id"));
                String string2 = cursorQdl.getString(cursorQdl.getColumnIndex("url"));
                boolean z = cursorQdl.getInt(cursorQdl.getColumnIndex("replaceholder")) > 0;
                int i = cursorQdl.getInt(cursorQdl.getColumnIndex("retry"));
                int i2 = cursorQdl.getInt(cursorQdl.getColumnIndex("url_type"));
                String string3 = cursorQdl.getString(cursorQdl.getColumnIndex("ad_id"));
                String string4 = cursorQdl.getString(cursorQdl.getColumnIndex(NativeProtocol.BRIDGE_ARG_ERROR_CODE));
                String string5 = cursorQdl.getString(cursorQdl.getColumnIndex("error_msg"));
                mml mmlVar = new mml(string, string2, z, i2, string3);
                mmlVar.qdl(i);
                if (!TextUtils.isEmpty(string4)) {
                    mmlVar.qdl(string4);
                }
                if (!TextUtils.isEmpty(string5)) {
                    mmlVar.ud(string5);
                }
                return mmlVar;
            } catch (Throwable th) {
                try {
                    th.getMessage();
                    cursorQdl.close();
                    cursorQdl = null;
                } finally {
                    cursorQdl.close();
                }
            }
        }
        if (cursorQdl != null) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.mo.qdl.mo.mzz
    public void qdl(mml mmlVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", mmlVar.qdl());
        contentValues.put("url", mmlVar.ud());
        contentValues.put("replaceholder", Integer.valueOf(mmlVar.lnr() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(mmlVar.mml()));
        contentValues.put("url_type", Integer.valueOf(mmlVar.mzz()));
        contentValues.put("ad_id", mmlVar.mo());
        contentValues.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, mmlVar.wd());
        contentValues.put("error_msg", mmlVar.tvp());
        com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(this.qdl, "trackurl", contentValues);
    }

    @Override // com.bytedance.sdk.component.mo.qdl.mo.mzz
    public void ud(mml mmlVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", mmlVar.qdl());
        contentValues.put("url", mmlVar.ud());
        contentValues.put("replaceholder", Integer.valueOf(mmlVar.lnr() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(mmlVar.mml()));
        contentValues.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, mmlVar.wd());
        contentValues.put("error_msg", mmlVar.tvp());
        contentValues.put("url_type", Integer.valueOf(mmlVar.mzz()));
        contentValues.put("ad_id", mmlVar.mo());
        com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(this.qdl, "trackurl", contentValues, "id=?", new String[]{mmlVar.qdl()});
    }

    @Override // com.bytedance.sdk.component.mo.qdl.mo.mzz
    public void lnr(mml mmlVar) {
        com.bytedance.sdk.component.mo.qdl.qdl.qdl.lnr.qdl(this.qdl, "trackurl", "id=?", new String[]{mmlVar.qdl()});
    }

    public static String ud() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, retry INTEGER default 0)";
    }
}
