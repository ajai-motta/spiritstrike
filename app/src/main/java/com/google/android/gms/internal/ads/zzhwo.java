package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzhwi;
import com.google.android.gms.internal.ads.zzhwo;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhwo<MessageType extends zzhwo<MessageType, BuilderType>, BuilderType extends zzhwi<MessageType, BuilderType>> extends zzhur<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static Map<Class<?>, zzhwo<?, ?>> zzd = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzc = -1;
    protected zzhzd zzt = zzhzd.zza();

    static Method zzbA(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            String name = cls.getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 43 + String.valueOf(str).length() + 2);
            sb.append("Generated message class \"");
            sb.append(name);
            sb.append("\" missing method \"");
            sb.append(str);
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    static Object zzbB(Method method, Object obj, Object... objArr) {
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

    protected static zzhww zzbC() {
        return zzhwp.zzd();
    }

    protected static zzhww zzbD(zzhww zzhwwVar) {
        int size = zzhwwVar.size();
        return zzhwwVar.zzh(size + size);
    }

    protected static zzhwz zzbE() {
        return zzhxn.zzg();
    }

    protected static zzhwz zzbF(zzhwz zzhwzVar) {
        int size = zzhwzVar.size();
        return zzhwzVar.zzh(size + size);
    }

    protected static zzhwv zzbG() {
        return zzhwf.zzd();
    }

    protected static zzhwv zzbH(zzhwv zzhwvVar) {
        int size = zzhwvVar.size();
        return zzhwvVar.zzh(size + size);
    }

    protected static zzhwr zzbI() {
        return zzhvv.zzd();
    }

    protected static zzhwr zzbJ(zzhwr zzhwrVar) {
        int size = zzhwrVar.size();
        return zzhwrVar.zzh(size + size);
    }

    protected static zzhwq zzbK() {
        return zzhuy.zzd();
    }

    protected static zzhwq zzbL(zzhwq zzhwqVar) {
        int size = zzhwqVar.size();
        return zzhwqVar.zzh(size + size);
    }

    protected static <E> zzhxa<E> zzbM() {
        return zzhyk.zzd();
    }

    protected static <E> zzhxa<E> zzbN(zzhxa<E> zzhxaVar) {
        int size = zzhxaVar.size();
        return zzhxaVar.zzh(size + size);
    }

    static <T extends zzhwo<T, ?>> T zzbO(T t, zzhvn zzhvnVar, zzhvy zzhvyVar) throws zzhxd {
        T t2 = (T) t.zzbg();
        try {
            zzhyr zzhyrVarZzb = zzhyj.zza().zzb(t2.getClass());
            zzhyrVarZzb.zzg(t2, zzhvo.zza(zzhvnVar), zzhvyVar);
            zzhyrVarZzb.zzk(t2);
            return t2;
        } catch (zzhxd e) {
            if (e.zzb()) {
                throw new zzhxd(e);
            }
            throw e;
        } catch (zzhzb e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzhxd) {
                throw ((zzhxd) e3.getCause());
            }
            throw new zzhxd(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzhxd) {
                throw ((zzhxd) e4.getCause());
            }
            throw e4;
        }
    }

    protected static <T extends zzhwo<T, ?>> T zzbP(T t, zzhvn zzhvnVar) throws zzhxd {
        int i = zzhvy.zzb;
        int i2 = zzhuv.zza;
        return (T) zzbO(t, zzhvnVar, zzhvy.zza);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static <T extends com.google.android.gms.internal.ads.zzhwo<T, ?>> T zzbQ(T r4, java.nio.ByteBuffer r5, com.google.android.gms.internal.ads.zzhvy r6) throws com.google.android.gms.internal.ads.zzhxd {
        /*
            int r0 = com.google.android.gms.internal.ads.zzhvn.zzf
            boolean r0 = r5.hasArray()
            r1 = 0
            if (r0 == 0) goto L1f
            byte[] r0 = r5.array()
            int r2 = r5.arrayOffset()
            int r3 = r5.position()
            int r2 = r2 + r3
            int r5 = r5.remaining()
            com.google.android.gms.internal.ads.zzhvn r5 = com.google.android.gms.internal.ads.zzhvn.zzG(r0, r2, r5, r1)
            goto L47
        L1f:
            boolean r0 = r5.isDirect()
            if (r0 == 0) goto L35
            int r0 = com.google.android.gms.internal.ads.zzhvm.zza
            boolean r0 = com.google.android.gms.internal.ads.zzhzj.zzb()
            if (r0 == 0) goto L35
            com.google.android.gms.internal.ads.zzhvm r0 = new com.google.android.gms.internal.ads.zzhvm
            r2 = 0
            r0.<init>(r5, r1, r2)
            r5 = r0
            goto L47
        L35:
            int r0 = r5.remaining()
            byte[] r2 = new byte[r0]
            java.nio.ByteBuffer r5 = r5.duplicate()
            r5.get(r2)
            r5 = 1
            com.google.android.gms.internal.ads.zzhvn r5 = com.google.android.gms.internal.ads.zzhvn.zzG(r2, r1, r0, r5)
        L47:
            com.google.android.gms.internal.ads.zzhwo r4 = zzbZ(r4, r5, r6)
            zzi(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhwo.zzbQ(com.google.android.gms.internal.ads.zzhwo, java.nio.ByteBuffer, com.google.android.gms.internal.ads.zzhvy):com.google.android.gms.internal.ads.zzhwo");
    }

    protected static <T extends zzhwo<T, ?>> T zzbR(T t, ByteBuffer byteBuffer) throws zzhxd {
        int i = zzhvy.zzb;
        int i2 = zzhuv.zza;
        return (T) zzbQ(t, byteBuffer, zzhvy.zza);
    }

    protected static <T extends zzhwo<T, ?>> T zzbS(T t, zzhvi zzhviVar) throws zzhxd {
        int i = zzhvy.zzb;
        int i2 = zzhuv.zza;
        T t2 = (T) zzbT(t, zzhviVar, zzhvy.zza);
        zzi(t2);
        return t2;
    }

    protected static <T extends zzhwo<T, ?>> T zzbT(T t, zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        T t2 = (T) zzj(t, zzhviVar, zzhvyVar);
        zzi(t2);
        return t2;
    }

    protected static <T extends zzhwo<T, ?>> T zzbU(T t, byte[] bArr) throws zzhxd {
        int length = bArr.length;
        int i = zzhvy.zzb;
        int i2 = zzhuv.zza;
        T t2 = (T) zzh(t, bArr, 0, length, zzhvy.zza);
        zzi(t2);
        return t2;
    }

    protected static <T extends zzhwo<T, ?>> T zzbV(T t, byte[] bArr, zzhvy zzhvyVar) throws zzhxd {
        T t2 = (T) zzh(t, bArr, 0, bArr.length, zzhvyVar);
        zzi(t2);
        return t2;
    }

    protected static <T extends zzhwo<T, ?>> T zzbW(T t, InputStream inputStream) throws zzhxd {
        zzhvn zzhvnVarZzF = zzhvn.zzF(inputStream, 4096);
        int i = zzhvy.zzb;
        int i2 = zzhuv.zza;
        T t2 = (T) zzbO(t, zzhvnVarZzF, zzhvy.zza);
        zzi(t2);
        return t2;
    }

    protected static <T extends zzhwo<T, ?>> T zzbX(T t, InputStream inputStream, zzhvy zzhvyVar) throws zzhxd {
        T t2 = (T) zzbO(t, zzhvn.zzF(inputStream, 4096), zzhvyVar);
        zzi(t2);
        return t2;
    }

    protected static <T extends zzhwo<T, ?>> T zzbY(T t, zzhvn zzhvnVar) throws zzhxd {
        int i = zzhvy.zzb;
        int i2 = zzhuv.zza;
        return (T) zzbZ(t, zzhvnVar, zzhvy.zza);
    }

    protected static <T extends zzhwo<T, ?>> T zzbZ(T t, zzhvn zzhvnVar, zzhvy zzhvyVar) throws zzhxd {
        T t2 = (T) zzbO(t, zzhvnVar, zzhvyVar);
        zzi(t2);
        return t2;
    }

    static <T extends zzhwo> T zzbt(Class<T> cls) {
        zzhwo<?, ?> zzhwoVarZzbw = zzd.get(cls);
        if (zzhwoVarZzbw == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzhwoVarZzbw = zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzhwoVarZzbw == null) {
            zzhwoVarZzbw = ((zzhwo) zzhzj.zzc(cls)).zzbw();
            if (zzhwoVarZzbw == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, zzhwoVarZzbw);
        }
        return zzhwoVarZzbw;
    }

    protected static <T extends zzhwo> void zzbu(Class<T> cls, T t) {
        t.zzaY();
        zzd.put(cls, t);
    }

    protected static Object zzbv(zzhxz zzhxzVar, String str, Object[] objArr) {
        return new zzhyl(zzhxzVar, str, objArr);
    }

    public static <ContainingType extends zzhxz, Type> zzhwm<ContainingType, Type> zzby(ContainingType containingtype, Type type, zzhxz zzhxzVar, zzhwt zzhwtVar, int i, zzhzp zzhzpVar, Class cls) {
        return new zzhwm<>(containingtype, type, zzhxzVar, new zzhwl(zzhwtVar, i, zzhzpVar, false, false), cls);
    }

    public static <ContainingType extends zzhxz, Type> zzhwm<ContainingType, Type> zzbz(ContainingType containingtype, zzhxz zzhxzVar, zzhwt zzhwtVar, int i, zzhzp zzhzpVar, boolean z, Class cls) {
        return new zzhwm<>(containingtype, zzhyk.zzd(), zzhxzVar, new zzhwl(zzhwtVar, i, zzhzpVar, true, z), cls);
    }

    private void zzc() {
        if (this.zzt == zzhzd.zza()) {
            this.zzt = zzhzd.zzb();
        }
    }

    protected static <T extends zzhwo<T, ?>> T zzca(T t, InputStream inputStream) throws zzhxd {
        int i = zzhvy.zzb;
        int i2 = zzhuv.zza;
        T t2 = (T) zzk(t, inputStream, zzhvy.zza);
        zzi(t2);
        return t2;
    }

    protected static <T extends zzhwo<T, ?>> T zzcb(T t, InputStream inputStream, zzhvy zzhvyVar) throws zzhxd {
        T t2 = (T) zzk(t, inputStream, zzhvyVar);
        zzi(t2);
        return t2;
    }

    private int zzd(zzhyr<?> zzhyrVar) {
        if (zzhyrVar != null) {
            return zzhyrVar.zze(this);
        }
        return zzhyj.zza().zzb(getClass()).zze(this);
    }

    private static <MessageType extends zzhwk<MessageType, BuilderType>, BuilderType, T> zzhwm<MessageType, T> zze(zzhvw<MessageType, T> zzhvwVar) {
        return (zzhwm) zzhvwVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends zzhwo<T, ?>> boolean zzg(T t, boolean z) {
        byte bByteValue = ((Byte) t.zzdh(zzhwn.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzhyj.zza().zzb(t.getClass()).zzl(t);
        if (z) {
            t.zzdh(zzhwn.SET_MEMOIZED_IS_INITIALIZED, true != zZzl ? null : t, null);
        }
        return zZzl;
    }

    private static <T extends zzhwo<T, ?>> T zzh(T t, byte[] bArr, int i, int i2, zzhvy zzhvyVar) throws zzhxd {
        if (i2 == 0) {
            return t;
        }
        T t2 = (T) t.zzbg();
        try {
            zzhyr zzhyrVarZzb = zzhyj.zza().zzb(t2.getClass());
            zzhyrVarZzb.zzj(t2, bArr, i, i + i2, new zzhuw(zzhvyVar));
            zzhyrVarZzb.zzk(t2);
            return t2;
        } catch (zzhxd e) {
            if (e.zzb()) {
                throw new zzhxd(e);
            }
            throw e;
        } catch (zzhzb e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzhxd) {
                throw ((zzhxd) e3.getCause());
            }
            throw new zzhxd(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static <T extends zzhwo<T, ?>> T zzi(T t) throws zzhxd {
        if (t == null || t.zzbi()) {
            return t;
        }
        throw t.zzaU().zza();
    }

    private static <T extends zzhwo<T, ?>> T zzj(T t, zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        zzhvn zzhvnVarZzp = zzhviVar.zzp();
        T t2 = (T) zzbO(t, zzhvnVarZzp, zzhvyVar);
        zzhvnVarZzp.zzb(0);
        return t2;
    }

    private static <T extends zzhwo<T, ?>> T zzk(T t, InputStream inputStream, zzhvy zzhvyVar) throws zzhxd {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            zzhvn zzhvnVarZzF = zzhvn.zzF(new zzhup(inputStream, zzhvn.zzM(i, inputStream)), 4096);
            T t2 = (T) zzbO(t, zzhvnVarZzF, zzhvyVar);
            zzhvnVarZzF.zzb(0);
            return t2;
        } catch (zzhxd e) {
            if (e.zzb()) {
                throw new zzhxd(e);
            }
            throw e;
        } catch (IOException e2) {
            throw new zzhxd(e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzhyj.zza().zzb(getClass()).zzb(this, (zzhwo) obj);
    }

    public int hashCode() {
        if (zzaX()) {
            return zzbh();
        }
        if (zzbc()) {
            zzba(zzbh());
        }
        return zzaZ();
    }

    public String toString() {
        return zzhyb.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhur
    int zzaQ() {
        return this.zzc & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzhur
    void zzaR(int i) {
        if (i >= 0) {
            this.zzc = i | (this.zzc & Integer.MIN_VALUE);
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 42);
        sb.append("serialized size must be non-negative, was ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhur
    int zzaT(zzhyr zzhyrVar) {
        if (!zzaX()) {
            if (zzaQ() != Integer.MAX_VALUE) {
                return zzaQ();
            }
            int iZzd = zzd(zzhyrVar);
            zzaR(iZzd);
            return iZzd;
        }
        int iZzd2 = zzd(zzhyrVar);
        if (iZzd2 >= 0) {
            return iZzd2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iZzd2).length() + 42);
        sb.append("serialized size must be non-negative, was ");
        sb.append(iZzd2);
        throw new IllegalStateException(sb.toString());
    }

    boolean zzaX() {
        return (this.zzc & Integer.MIN_VALUE) != 0;
    }

    void zzaY() {
        this.zzc &= Integer.MAX_VALUE;
    }

    int zzaZ() {
        return this.zzq;
    }

    void zzba(int i) {
        this.zzq = i;
    }

    void zzbb() {
        this.zzq = 0;
    }

    boolean zzbc() {
        return zzaZ() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhxz
    public final zzhyh<MessageType> zzbd() {
        return (zzhyh) zzdh(zzhwn.GET_PARSER, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhya
    /* JADX INFO: renamed from: zzbe, reason: merged with bridge method [inline-methods] */
    public final MessageType zzbw() {
        return (MessageType) zzdh(zzhwn.GET_DEFAULT_INSTANCE, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhxz
    /* JADX INFO: renamed from: zzbf, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzdd() {
        return (BuilderType) zzdh(zzhwn.NEW_BUILDER, null, null);
    }

    MessageType zzbg() {
        return (MessageType) zzdh(zzhwn.NEW_MUTABLE_INSTANCE, null, null);
    }

    int zzbh() {
        return zzhyj.zza().zzb(getClass()).zzc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhya
    public final boolean zzbi() {
        return zzg(this, true);
    }

    protected boolean zzbj(int i, zzhvn zzhvnVar) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        zzc();
        return this.zzt.zzl(i, zzhvnVar);
    }

    protected void zzbk(int i, int i2) {
        zzc();
        zzhzd zzhzdVar = this.zzt;
        zzhzdVar.zze();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhzdVar.zzk(i << 3, Long.valueOf(i2));
    }

    protected void zzbl(int i, zzhvi zzhviVar) {
        zzc();
        zzhzd zzhzdVar = this.zzt;
        zzhzdVar.zze();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhzdVar.zzk((i << 3) | 2, zzhviVar);
    }

    protected void zzbm() {
        zzhyj.zza().zzb(getClass()).zzk(this);
        zzaY();
    }

    protected final <MessageType2 extends zzhwo<MessageType2, BuilderType2>, BuilderType2 extends zzhwi<MessageType2, BuilderType2>> BuilderType2 zzbn() {
        return (BuilderType2) zzdh(zzhwn.NEW_BUILDER, null, null);
    }

    protected final <MessageType2 extends zzhwo<MessageType2, BuilderType2>, BuilderType2 extends zzhwi<MessageType2, BuilderType2>> BuilderType2 zzbo(MessageType2 messagetype2) {
        BuilderType2 buildertype2 = (BuilderType2) zzbn();
        buildertype2.zzbo(messagetype2);
        return buildertype2;
    }

    /* JADX INFO: renamed from: zzbp, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzcc() {
        BuilderType buildertype = (BuilderType) zzdh(zzhwn.NEW_BUILDER, null, null);
        buildertype.zzbo(this);
        return buildertype;
    }

    void zzbq() {
        zzaR(Integer.MAX_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzhxz
    public int zzbr() {
        return zzaT(null);
    }

    Object zzbs() throws Exception {
        return zzdh(zzhwn.BUILD_MESSAGE_INFO, null, null);
    }

    protected final void zzbx(zzhzd zzhzdVar) {
        this.zzt = zzhzd.zzc(this.zzt, zzhzdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhxz
    public void zzdc(zzhvt zzhvtVar) throws IOException {
        zzhyj.zza().zzb(getClass()).zzf(this, zzhvu.zza(zzhvtVar));
    }

    protected abstract Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2);
}
