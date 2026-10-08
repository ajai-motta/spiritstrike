package com.bytedance.sdk.component.adexpress.mml;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class tvp {
    public static qdl qdl(String str) {
        qdl qdlVar = qdl.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        qdlVar = qdl.CSS;
                    } else if (path.endsWith(".js")) {
                        qdlVar = qdl.JS;
                    } else if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico")) {
                        qdlVar = qdl.IMAGE;
                    } else if (path.endsWith(".html")) {
                        qdlVar = qdl.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return qdlVar;
    }

    public static boolean ud(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }

    public enum qdl {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        private String mzz;

        qdl(String str) {
            this.mzz = str;
        }

        public String qdl() {
            return this.mzz;
        }
    }
}
