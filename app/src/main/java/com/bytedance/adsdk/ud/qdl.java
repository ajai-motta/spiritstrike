package com.bytedance.adsdk.ud;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class qdl<E> implements Collection<E>, Set<E> {
    private static int jpc;
    private static final int[] lnr = new int[0];
    private static final Object[] mml = new Object[0];
    private static int mo;
    private static Object[] mzz;
    private static Object[] wd;
    Object[] qdl;
    private bjy<E, E> to;
    private int[] tvp;
    int ud;

    private int qdl(Object obj, int i) {
        int i2 = this.ud;
        if (i2 == 0) {
            return -1;
        }
        int iQdl = ud.qdl(this.tvp, i2, i);
        if (iQdl < 0 || obj.equals(this.qdl[iQdl])) {
            return iQdl;
        }
        int i3 = iQdl + 1;
        while (i3 < i2 && this.tvp[i3] == i) {
            if (obj.equals(this.qdl[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iQdl - 1; i4 >= 0 && this.tvp[i4] == i; i4--) {
            if (obj.equals(this.qdl[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private int qdl() {
        int i = this.ud;
        if (i == 0) {
            return -1;
        }
        int iQdl = ud.qdl(this.tvp, i, 0);
        if (iQdl < 0 || this.qdl[iQdl] == null) {
            return iQdl;
        }
        int i2 = iQdl + 1;
        while (i2 < i && this.tvp[i2] == 0) {
            if (this.qdl[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iQdl - 1; i3 >= 0 && this.tvp[i3] == 0; i3--) {
            if (this.qdl[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void mml(int i) {
        if (i == 8) {
            synchronized (qdl.class) {
                Object[] objArr = wd;
                if (objArr != null) {
                    this.qdl = objArr;
                    wd = (Object[]) objArr[0];
                    this.tvp = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    jpc--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (qdl.class) {
                Object[] objArr2 = mzz;
                if (objArr2 != null) {
                    this.qdl = objArr2;
                    mzz = (Object[]) objArr2[0];
                    this.tvp = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mo--;
                    return;
                }
            }
        }
        this.tvp = new int[i];
        this.qdl = new Object[i];
    }

    private static void qdl(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (qdl.class) {
                if (jpc < 10) {
                    objArr[0] = wd;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    wd = objArr;
                    jpc++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (qdl.class) {
                if (mo < 10) {
                    objArr[0] = mzz;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    mzz = objArr;
                    mo++;
                }
            }
        }
    }

    public qdl() {
        this(0);
    }

    public qdl(int i) {
        if (i == 0) {
            this.tvp = lnr;
            this.qdl = mml;
        } else {
            mml(i);
        }
        this.ud = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.ud;
        if (i != 0) {
            qdl(this.tvp, this.qdl, i);
            this.tvp = lnr;
            this.qdl = mml;
            this.ud = 0;
        }
    }

    public void qdl(int i) {
        int[] iArr = this.tvp;
        if (iArr.length < i) {
            Object[] objArr = this.qdl;
            mml(i);
            int i2 = this.ud;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.tvp, 0, i2);
                System.arraycopy(objArr, 0, this.qdl, 0, this.ud);
            }
            qdl(iArr, objArr, this.ud);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return qdl(obj) >= 0;
    }

    public int qdl(Object obj) {
        return obj == null ? qdl() : qdl(obj, obj.hashCode());
    }

    public E ud(int i) {
        return (E) this.qdl[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.ud <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iQdl;
        if (e == null) {
            iQdl = qdl();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iQdl = qdl(e, iHashCode);
        }
        if (iQdl >= 0) {
            return false;
        }
        int i2 = ~iQdl;
        int i3 = this.ud;
        int[] iArr = this.tvp;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.qdl;
            mml(i4);
            int[] iArr2 = this.tvp;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.qdl, 0, objArr.length);
            }
            qdl(iArr, objArr, this.ud);
        }
        int i5 = this.ud;
        if (i2 < i5) {
            int[] iArr3 = this.tvp;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.qdl;
            System.arraycopy(objArr2, i2, objArr2, i6, this.ud - i2);
        }
        this.tvp[i2] = i;
        this.qdl[i2] = e;
        this.ud++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iQdl = qdl(obj);
        if (iQdl < 0) {
            return false;
        }
        lnr(iQdl);
        return true;
    }

    public E lnr(int i) {
        Object[] objArr = this.qdl;
        E e = (E) objArr[i];
        int i2 = this.ud;
        if (i2 <= 1) {
            qdl(this.tvp, objArr, i2);
            this.tvp = lnr;
            this.qdl = mml;
            this.ud = 0;
        } else {
            int[] iArr = this.tvp;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                mml(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.ud--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.tvp, 0, i);
                    System.arraycopy(objArr, 0, this.qdl, 0, i);
                }
                int i3 = this.ud;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.tvp, i, i3 - i);
                    System.arraycopy(objArr, i4, this.qdl, i, this.ud - i);
                }
            } else {
                int i5 = i2 - 1;
                this.ud = i5;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, iArr, i, i5 - i);
                    Object[] objArr2 = this.qdl;
                    System.arraycopy(objArr2, i6, objArr2, i, this.ud - i);
                }
                this.qdl[this.ud] = null;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.ud;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.ud;
        Object[] objArr = new Object[i];
        System.arraycopy(this.qdl, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.ud) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.ud));
        }
        System.arraycopy(this.qdl, 0, tArr, 0, this.ud);
        int length = tArr.length;
        int i = this.ud;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.ud; i++) {
                try {
                    if (!set.contains(ud(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.tvp;
        int i = this.ud;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public String toString() {
        if (isEmpty()) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder(this.ud * 14);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.ud; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eUd = ud(i);
            if (eUd != this) {
                sb.append(eUd);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    private bjy<E, E> ud() {
        if (this.to == null) {
            this.to = new bjy<E, E>() { // from class: com.bytedance.adsdk.ud.qdl.1
                @Override // com.bytedance.adsdk.ud.bjy
                protected int qdl() {
                    return qdl.this.ud;
                }

                @Override // com.bytedance.adsdk.ud.bjy
                protected Object qdl(int i, int i2) {
                    return qdl.this.qdl[i];
                }

                @Override // com.bytedance.adsdk.ud.bjy
                protected int qdl(Object obj) {
                    return qdl.this.qdl(obj);
                }

                @Override // com.bytedance.adsdk.ud.bjy
                protected Map<E, E> ud() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.ud.bjy
                protected void qdl(int i) {
                    qdl.this.lnr(i);
                }

                @Override // com.bytedance.adsdk.ud.bjy
                protected void lnr() {
                    qdl.this.clear();
                }
            };
        }
        return this.to;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return ud().mml().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        qdl(this.ud + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.ud - 1; i >= 0; i--) {
            if (!collection.contains(this.qdl[i])) {
                lnr(i);
                z = true;
            }
        }
        return z;
    }
}
