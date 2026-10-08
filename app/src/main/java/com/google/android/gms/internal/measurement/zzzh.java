package com.google.android.gms.internal.measurement;

import com.facebook.appevents.AppEventsConstants;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzzh {
    static final Locale zza = Locale.ROOT;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    public static String zza(Object obj) {
        if (obj == 0) {
            return AbstractJsonLexerKt.NULL;
        }
        try {
            if (obj.getClass().isArray()) {
                obj = obj instanceof int[] ? Arrays.toString((int[]) obj) : obj instanceof long[] ? Arrays.toString((long[]) obj) : obj instanceof byte[] ? Arrays.toString((byte[]) obj) : obj instanceof char[] ? Arrays.toString((char[]) obj) : obj instanceof short[] ? Arrays.toString((short[]) obj) : obj instanceof float[] ? Arrays.toString((float[]) obj) : obj instanceof double[] ? Arrays.toString((double[]) obj) : obj instanceof boolean[] ? Arrays.toString((boolean[]) obj) : Arrays.toString((Object[]) obj);
            } else {
                String string = obj.toString();
                obj = string != null ? string : zzf(obj, "toString() returned null");
            }
            return obj;
        } catch (RuntimeException e) {
            return zze(obj, e);
        }
    }

    public static void zzb(Formattable formattable, StringBuilder sb, zzza zzzaVar) {
        int iZzj = zzzaVar.zzj();
        int i = iZzj & 162;
        if (i != 0) {
            i = ((iZzj & 32) != 0 ? 1 : 0) | ((iZzj & 128) != 0 ? 2 : 0) | ((iZzj & 2) != 0 ? 4 : 0);
        }
        int length = sb.length();
        Formatter formatter = new Formatter(sb, zza);
        try {
            formattable.formatTo(formatter, i, zzzaVar.zzf(), zzzaVar.zzg());
        } catch (RuntimeException e) {
            sb.setLength(length);
            try {
                formatter.out().append(zze(formattable, e));
            } catch (IOException unused) {
            }
        }
    }

    static void zzc(StringBuilder sb, Number number, zzza zzzaVar) {
        boolean zZzk = zzzaVar.zzk();
        long jLongValue = number.longValue();
        if (number instanceof Long) {
            zzd(sb, jLongValue, zZzk);
            return;
        }
        if (number instanceof Integer) {
            zzd(sb, jLongValue & 4294967295L, zZzk);
            return;
        }
        if (number instanceof Byte) {
            zzd(sb, jLongValue & 255, zZzk);
            return;
        }
        if (number instanceof Short) {
            zzd(sb, jLongValue & 65535, zZzk);
            return;
        }
        if (!(number instanceof BigInteger)) {
            String strValueOf = String.valueOf(number.getClass());
            String.valueOf(strValueOf);
            throw new IllegalStateException("unsupported number type: ".concat(String.valueOf(strValueOf)));
        }
        String string = ((BigInteger) number).toString(16);
        if (zZzk) {
            string = string.toUpperCase(zza);
        }
        sb.append(string);
    }

    private static void zzd(StringBuilder sb, long j, boolean z) {
        if (j == 0) {
            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            return;
        }
        String str = true != z ? "0123456789abcdef" : "0123456789ABCDEF";
        for (int iNumberOfLeadingZeros = (63 - Long.numberOfLeadingZeros(j)) & (-4); iNumberOfLeadingZeros >= 0; iNumberOfLeadingZeros -= 4) {
            sb.append(str.charAt((int) ((j >>> iNumberOfLeadingZeros) & 15)));
        }
    }

    private static String zze(Object obj, RuntimeException runtimeException) {
        String simpleName;
        try {
            simpleName = runtimeException.toString();
        } catch (RuntimeException e) {
            simpleName = e.getClass().getSimpleName();
        }
        return zzf(obj, simpleName);
    }

    private static String zzf(Object obj, String str) {
        String name = obj.getClass().getName();
        int iIdentityHashCode = System.identityHashCode(obj);
        int length = String.valueOf(name).length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(iIdentityHashCode).length() + 2 + String.valueOf(str).length() + 1);
        sb.append("{");
        sb.append(name);
        sb.append("@");
        sb.append(iIdentityHashCode);
        sb.append(": ");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
