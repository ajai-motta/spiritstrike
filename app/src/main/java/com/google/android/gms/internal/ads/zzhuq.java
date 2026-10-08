package com.google.android.gms.internal.ads;

import _COROUTINE.ArtificialStackFrames;
import com.google.android.gms.internal.ads.zzhuq;
import com.google.android.gms.internal.ads.zzhur;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhuq<MessageType extends zzhur<MessageType, BuilderType>, BuilderType extends zzhuq<MessageType, BuilderType>> implements zzhxy {
    private String zza(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 16 + String.valueOf(str).length() + 44);
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    protected static zzhzb zzaR(zzhxz zzhxzVar) {
        return new zzhzb(zzhxzVar);
    }

    @Deprecated
    protected static <T> void zzaS(Iterable<T> iterable, Collection<? super T> collection) {
        zzaT(iterable, (List) collection);
    }

    protected static <T> void zzaT(Iterable<T> iterable, List<? super T> list) {
        byte[] bArr = zzhxb.zzb;
        iterable.getClass();
        if (!(iterable instanceof zzhxk)) {
            if (iterable instanceof zzhyi) {
                list.addAll((Collection) iterable);
                return;
            } else {
                zzb(iterable, list);
                return;
            }
        }
        List listZza = ((zzhxk) iterable).zza();
        zzhxk zzhxkVar = (zzhxk) list;
        int size = list.size();
        for (Object obj : listZza) {
            if (obj == null) {
                int size2 = zzhxkVar.size() - size;
                StringBuilder sb = new StringBuilder(String.valueOf(size2).length() + 26);
                sb.append("Element at index ");
                sb.append(size2);
                sb.append(" is null.");
                String string = sb.toString();
                int size3 = zzhxkVar.size();
                while (true) {
                    size3--;
                    if (size3 < size) {
                        throw new NullPointerException(string);
                    }
                    zzhxkVar.remove(size3);
                }
            } else if (obj instanceof zzhvi) {
                zzhxkVar.zzb();
            } else if (obj instanceof byte[]) {
                byte[] bArr2 = (byte[]) obj;
                zzhvi.zzr(bArr2, 0, bArr2.length);
                zzhxkVar.zzb();
            } else {
                zzhxkVar.add((String) obj);
            }
        }
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size);
            } else if (list instanceof zzhyk) {
                ((zzhyk) list).zze(list.size() + size);
            }
        }
        int size2 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj : iterable) {
                if (obj == null) {
                    zzc(list, size2);
                }
                list.add(obj);
            }
            return;
        }
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i = 0; i < size3; i++) {
            ArtificialStackFrames artificialStackFrames = (Object) list2.get(i);
            if (artificialStackFrames == null) {
                zzc(list, size2);
            }
            list.add(artificialStackFrames);
        }
    }

    private static void zzc(List<?> list, int i) {
        int size = list.size() - i;
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 26);
        sb.append("Element at index ");
        sb.append(size);
        sb.append(" is null.");
        String string = sb.toString();
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 < i) {
                throw new NullPointerException(string);
            }
            list.remove(size2);
        }
    }

    @Override // 
    public abstract BuilderType zzbf();

    /* JADX INFO: renamed from: zzaD, reason: merged with bridge method [inline-methods] */
    public BuilderType zzbe(zzhvn zzhvnVar) throws IOException {
        int i = zzhvy.zzb;
        int i2 = zzhuv.zza;
        return (BuilderType) zzbd(zzhvnVar, zzhvy.zza);
    }

    @Override // 
    /* JADX INFO: renamed from: zzaE, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType zzbd(zzhvn zzhvnVar, zzhvy zzhvyVar) throws IOException;

    public BuilderType zzaF(zzhvi zzhviVar) throws zzhxd {
        try {
            zzhvn zzhvnVarZzp = zzhviVar.zzp();
            zzbe(zzhvnVarZzp);
            zzhvnVarZzp.zzb(0);
            return this;
        } catch (zzhxd e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    public BuilderType zzaG(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        try {
            zzhvn zzhvnVarZzp = zzhviVar.zzp();
            zzbd(zzhvnVarZzp, zzhvyVar);
            zzhvnVarZzp.zzb(0);
            return this;
        } catch (zzhxd e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    /* JADX INFO: renamed from: zzaH, reason: merged with bridge method [inline-methods] */
    public BuilderType zzba(byte[] bArr) throws zzhxd {
        return (BuilderType) zzaZ(bArr, 0, bArr.length);
    }

    @Override // 
    /* JADX INFO: renamed from: zzaI, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaZ(byte[] bArr, int i, int i2) throws zzhxd {
        try {
            zzhvn zzhvnVarZzG = zzhvn.zzG(bArr, i, i2, false);
            zzbe(zzhvnVarZzG);
            zzhvnVarZzG.zzb(0);
            return this;
        } catch (zzhxd e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    /* JADX INFO: renamed from: zzaJ, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaY(byte[] bArr, zzhvy zzhvyVar) throws zzhxd {
        return (BuilderType) zzaX(bArr, 0, bArr.length, zzhvyVar);
    }

    @Override // 
    /* JADX INFO: renamed from: zzaK, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaX(byte[] bArr, int i, int i2, zzhvy zzhvyVar) throws zzhxd {
        try {
            zzhvn zzhvnVarZzG = zzhvn.zzG(bArr, i, i2, false);
            zzbd(zzhvnVarZzG, zzhvyVar);
            zzhvnVarZzG.zzb(0);
            return this;
        } catch (zzhxd e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public BuilderType zzaL(InputStream inputStream) throws IOException {
        zzhvn zzhvnVarZzF = zzhvn.zzF(inputStream, 4096);
        zzbe(zzhvnVarZzF);
        zzhvnVarZzF.zzb(0);
        return this;
    }

    public BuilderType zzaM(InputStream inputStream, zzhvy zzhvyVar) throws IOException {
        zzhvn zzhvnVarZzF = zzhvn.zzF(inputStream, 4096);
        zzbd(zzhvnVarZzF, zzhvyVar);
        zzhvnVarZzF.zzb(0);
        return this;
    }

    public boolean zzaN(InputStream inputStream, zzhvy zzhvyVar) throws IOException {
        int i = inputStream.read();
        if (i == -1) {
            return false;
        }
        zzaM(new zzhup(inputStream, zzhvn.zzM(i, inputStream)), zzhvyVar);
        return true;
    }

    public boolean zzaO(InputStream inputStream) throws IOException {
        int i = zzhvy.zzb;
        int i2 = zzhuv.zza;
        return zzaN(inputStream, zzhvy.zza);
    }

    /* JADX INFO: renamed from: zzaP, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaU(zzhxz zzhxzVar) {
        if (zzbw().getClass().isInstance(zzhxzVar)) {
            return (BuilderType) zzaQ((zzhur) zzhxzVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    protected abstract BuilderType zzaQ(MessageType messagetype);

    public /* bridge */ /* synthetic */ zzhxy zzaV(InputStream inputStream, zzhvy zzhvyVar) throws IOException {
        zzaM(inputStream, zzhvyVar);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhxy zzaW(InputStream inputStream) throws IOException {
        zzaL(inputStream);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhxy zzbb(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        zzaG(zzhviVar, zzhvyVar);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhxy zzbc(zzhvi zzhviVar) throws zzhxd {
        zzaF(zzhviVar);
        return this;
    }
}
