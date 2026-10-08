package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzaca;
import com.google.android.gms.internal.gtm.zzacf;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzacf<MessageType extends zzacf<MessageType, BuilderType>, BuilderType extends zzaca<MessageType, BuilderType>> extends zzyh<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzaen zzc = zzaen.zzc();

    public static zzace zzab(zzadl zzadlVar, zzadl zzadlVar2, zzaci zzaciVar, int i, zzaex zzaexVar, boolean z, Class cls) {
        return new zzace(zzadlVar, zzadu.zze(), zzadlVar2, new zzacd(null, i, zzaexVar, true, false), cls);
    }

    public static zzace zzac(zzadl zzadlVar, Object obj, zzadl zzadlVar2, zzaci zzaciVar, int i, zzaex zzaexVar, Class cls) {
        return new zzace(zzadlVar, obj, zzadlVar2, new zzacd(zzaciVar, i, zzaexVar, false, false), cls);
    }

    static zzacf zzad(Class cls) {
        Map map = zza;
        zzacf zzacfVar = (zzacf) map.get(cls);
        if (zzacfVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzacfVar = (zzacf) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzacfVar == null) {
            zzacfVar = (zzacf) ((zzacf) zzaet.zze(cls)).zzb(6, null, null);
            if (zzacfVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzacfVar);
        }
        return zzacfVar;
    }

    protected static zzacf zzaf(zzacf zzacfVar, InputStream inputStream, zzabq zzabqVar) throws zzacq {
        zzyz zzyzVar = new zzyz(inputStream, 4096, null);
        zzacf zzacfVarZzae = zzacfVar.zzae();
        try {
            zzadx zzadxVarZzb = zzadt.zza().zzb(zzacfVarZzae.getClass());
            zzadxVarZzb.zzh(zzacfVarZzae, zzzc.zzq(zzyzVar), zzabqVar);
            zzadxVarZzb.zzf(zzacfVarZzae);
            zze(zzacfVarZzae);
            return zzacfVarZzae;
        } catch (zzacq e) {
            if (e.zzb()) {
                throw new zzacq(e);
            }
            throw e;
        } catch (zzael e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzacq) {
                throw ((zzacq) e3.getCause());
            }
            throw new zzacq(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzacq) {
                throw ((zzacq) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zzacf zzag(zzacf zzacfVar, byte[] bArr, zzabq zzabqVar) throws zzacq {
        zzacf zzacfVarZzf = zzf(zzacfVar, bArr, 0, bArr.length, zzabqVar);
        zze(zzacfVarZzf);
        return zzacfVarZzf;
    }

    protected static zzack zzah() {
        return zzacg.zzf();
    }

    protected static zzacn zzai() {
        return zzadu.zze();
    }

    protected static zzacn zzaj(zzacn zzacnVar) {
        int size = zzacnVar.size();
        return zzacnVar.zzd(size + size);
    }

    static Object zzak(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzal(zzadl zzadlVar, String str, Object[] objArr) {
        return new zzadv(zzadlVar, str, objArr);
    }

    protected static void zzao(Class cls, zzacf zzacfVar) {
        zzacfVar.zzan();
        zza.put(cls, zzacfVar);
    }

    protected static final boolean zzaq(zzacf zzacfVar, boolean z) {
        byte bByteValue = ((Byte) zzacfVar.zzb(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzadt.zza().zzb(zzacfVar.getClass()).zzl(zzacfVar);
        if (z) {
            zzacfVar.zzb(2, true != zZzl ? null : zzacfVar, null);
        }
        return zZzl;
    }

    private final int zzc(zzadx zzadxVar) {
        return zzadt.zza().zzb(getClass()).zza(this);
    }

    private static zzacf zze(zzacf zzacfVar) throws zzacq {
        if (zzacfVar == null || zzaq(zzacfVar, true)) {
            return zzacfVar;
        }
        throw new zzael(zzacfVar).zza();
    }

    private static zzacf zzf(zzacf zzacfVar, byte[] bArr, int i, int i2, zzabq zzabqVar) throws zzacq {
        if (i2 == 0) {
            return zzacfVar;
        }
        zzacf zzacfVarZzae = zzacfVar.zzae();
        try {
            zzadx zzadxVarZzb = zzadt.zza().zzb(zzacfVarZzae.getClass());
            zzadxVarZzb.zzi(zzacfVarZzae, bArr, 0, i2, new zzyl(zzabqVar));
            zzadxVarZzb.zzf(zzacfVarZzae);
            return zzacfVarZzae;
        } catch (zzacq e) {
            if (e.zzb()) {
                throw new zzacq(e);
            }
            throw e;
        } catch (zzael e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzacq) {
                throw ((zzacq) e3.getCause());
            }
            throw new zzacq(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzacq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzadt.zza().zzb(getClass()).zzk(this, (zzacf) obj);
    }

    public final int hashCode() {
        if (zzar()) {
            return zzX();
        }
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int iZzX = zzX();
        this.zzb = iZzX;
        return iZzX;
    }

    public final String toString() {
        return zzadn.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.gtm.zzyh
    final int zzQ(zzadx zzadxVar) {
        if (zzar()) {
            int iZza = zzadxVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzadxVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    final int zzX() {
        return zzadt.zza().zzb(getClass()).zzb(this);
    }

    protected final zzaca zzZ() {
        return (zzaca) zzb(5, null, null);
    }

    public final zzaca zzaa() {
        zzaca zzacaVar = (zzaca) zzb(5, null, null);
        zzacaVar.zzA(this);
        return zzacaVar;
    }

    final zzacf zzae() {
        return (zzacf) zzb(4, null, null);
    }

    protected final void zzam() {
        zzadt.zza().zzb(getClass()).zzf(this);
        zzan();
    }

    final void zzan() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzap(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    final boolean zzar() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzadl
    public final /* synthetic */ zzadk zzav() {
        return (zzaca) zzb(5, null, null);
    }

    @Override // com.google.android.gms.internal.gtm.zzadl
    public final /* synthetic */ zzadk zzaw() {
        zzaca zzacaVar = (zzaca) zzb(5, null, null);
        zzacaVar.zzA(this);
        return zzacaVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzadl
    public final void zzax(zzzi zzziVar) throws IOException {
        zzadt.zza().zzb(getClass()).zzj(this, zzzj.zza(zzziVar));
    }

    @Override // com.google.android.gms.internal.gtm.zzadm
    public final /* synthetic */ zzadl zzay() {
        return (zzacf) zzb(6, null, null);
    }

    @Override // com.google.android.gms.internal.gtm.zzadm
    public final boolean zzaz() {
        return zzaq(this, true);
    }

    protected abstract Object zzb(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.gtm.zzadl
    public final int zzY() {
        int iZzc;
        if (zzar()) {
            iZzc = zzc(null);
            if (iZzc < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iZzc);
            }
        } else {
            iZzc = this.zzd & Integer.MAX_VALUE;
            if (iZzc == Integer.MAX_VALUE) {
                iZzc = zzc(null);
                if (iZzc < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iZzc);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iZzc;
            }
        }
        return iZzc;
    }
}
