package com.tnkfactory.ad.pub;

import android.content.Context;
import android.os.Environment;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.framework.crypto.EncryptUtils;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d1 {
    public static void a(Context context) {
        if (System.currentTimeMillis() - m4.a(context).f3161a.getSharedPreferences("__tnk_pub__", 0).getLong("__tnk_0007_", 0L) < 86400000) {
            return;
        }
        Logger.d("info #1005");
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - 1814400000;
            File file = new File(context.getCacheDir(), "tnkpub");
            if (file.listFiles() != null) {
                for (File file2 : file.listFiles()) {
                    if (file2.exists() && file2.isFile() && file2.lastModified() < jCurrentTimeMillis) {
                        Logger.d("info #1006 : " + file2.getName());
                        file2.delete();
                    }
                }
            }
        } catch (Exception e) {
            Logger.e("error #1005 : " + e.toString());
        }
        m4.a(context).a();
    }

    public static String a(String str) {
        try {
            String strReplace = str.replace("http://", "").replace("https://", "");
            int iIndexOf = strReplace.indexOf(DomExceptionUtils.SEPARATOR);
            if (iIndexOf > 0) {
                strReplace = strReplace.substring(iIndexOf + 1);
            }
            return EncryptUtils.md5Hex(strReplace);
        } catch (Exception e) {
            Logger.e(str);
            Logger.e("error #1002 : " + e.toString());
            return null;
        }
    }

    public static File a(Context context, String str) {
        File file;
        try {
            file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "tnkpub");
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            Logger.e("error #1001 : " + e.toString());
            file = null;
        }
        if (file == null) {
            return null;
        }
        return new File(file, str);
    }
}
