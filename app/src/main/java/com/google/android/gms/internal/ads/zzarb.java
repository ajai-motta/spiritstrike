package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzarb implements zzarc {
    private static final Logger zzb = Logger.getLogger(zzarb.class.getName());
    final ThreadLocal zza = new zzara(this);

    public abstract zzarf zza(String str, byte[] bArr, String str2);

    @Override // com.google.android.gms.internal.ads.zzarc
    public final zzarf zzb(zziet zzietVar, zzarg zzargVar) throws IOException {
        int iZza;
        long jZzb;
        long jZzc = zzietVar.zzc();
        ThreadLocal threadLocal = this.zza;
        ((ByteBuffer) threadLocal.get()).rewind().limit(8);
        do {
            iZza = zzietVar.zza((ByteBuffer) threadLocal.get());
            if (iZza == 8) {
                ((ByteBuffer) threadLocal.get()).rewind();
                long jZza = zzare.zza((ByteBuffer) threadLocal.get());
                byte[] bArr = null;
                if (jZza < 8 && jZza > 1) {
                    Logger logger = zzb;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(jZza);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                byte[] bArr2 = new byte[4];
                ((ByteBuffer) threadLocal.get()).get(bArr2);
                try {
                    String str = new String(bArr2, C.ISO88591_NAME);
                    if (jZza == 1) {
                        ThreadLocal threadLocal2 = this.zza;
                        ((ByteBuffer) threadLocal2.get()).limit(16);
                        zzietVar.zza((ByteBuffer) threadLocal2.get());
                        ((ByteBuffer) threadLocal2.get()).position(8);
                        jZzb = zzare.zzd((ByteBuffer) threadLocal2.get()) - 16;
                    } else {
                        jZzb = jZza == 0 ? zzietVar.zzb() - zzietVar.zzc() : jZza - 8;
                    }
                    if ("uuid".equals(str)) {
                        ThreadLocal threadLocal3 = this.zza;
                        ((ByteBuffer) threadLocal3.get()).limit(((ByteBuffer) threadLocal3.get()).limit() + 16);
                        zzietVar.zza((ByteBuffer) threadLocal3.get());
                        bArr = new byte[16];
                        for (int iPosition = ((ByteBuffer) threadLocal3.get()).position() - 16; iPosition < ((ByteBuffer) threadLocal3.get()).position(); iPosition++) {
                            bArr[iPosition - (((ByteBuffer) threadLocal3.get()).position() - 16)] = ((ByteBuffer) threadLocal3.get()).get(iPosition);
                        }
                        jZzb -= 16;
                    }
                    long j = jZzb;
                    zzarf zzarfVarZza = zza(str, bArr, zzargVar instanceof zzarf ? ((zzarf) zzargVar).zza() : "");
                    ThreadLocal threadLocal4 = this.zza;
                    ((ByteBuffer) threadLocal4.get()).rewind();
                    zzarfVarZza.zzb(zzietVar, (ByteBuffer) threadLocal4.get(), j, this);
                    return zzarfVarZza;
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (iZza >= 0);
        zzietVar.zzd(jZzc);
        throw new EOFException();
    }
}
