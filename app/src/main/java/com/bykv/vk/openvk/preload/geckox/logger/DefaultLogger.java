package com.bykv.vk.openvk.preload.geckox.logger;

import android.util.Log;
import io.ktor.sse.ServerSentEventKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
class DefaultLogger implements Logger {
    DefaultLogger() {
    }

    @Override // com.bykv.vk.openvk.preload.geckox.logger.Logger
    public void d(String str, Object... objArr) {
        if (objArr == null) {
            Log.d(str, AbstractJsonLexerKt.NULL);
        } else {
            try {
                Log.d(str, formatMsgs(objArr));
            } catch (Throwable unused) {
            }
        }
    }

    private static String formatMsgs(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(ServerSentEventKt.SPACE);
        }
        return sb.toString();
    }

    @Override // com.bykv.vk.openvk.preload.geckox.logger.Logger
    public void w(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.logger.Logger
    public void w(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        Log.w(str, str2);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.logger.Logger
    public void e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
