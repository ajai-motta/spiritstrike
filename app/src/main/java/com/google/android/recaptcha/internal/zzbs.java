package com.google.android.recaptcha.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbs {
    public static final String zza(ContentResolver contentResolver) {
        Cursor cursorQuery = contentResolver.query(Uri.parse("content://com.google.android.gsf.gservices"), null, null, new String[]{"android_id"}, null);
        String strValueOf = "";
        if (cursorQuery != null && cursorQuery.moveToFirst() && cursorQuery.getColumnCount() >= 2) {
            try {
                strValueOf = String.valueOf(Long.parseLong(cursorQuery.getString(1)));
            } catch (Exception unused) {
            }
            cursorQuery.close();
        }
        return strValueOf;
    }
}
