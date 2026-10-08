package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.p9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2655p9 {
    public static byte[] A00;
    public static String[] A01 = {"K5wWXkn1kn3vTm5TWZRpAJ13TGij4Off", "na1woSjLgBJfLtqhSRSkwOGg", "PhLAgNdVWkw0DSh4SzNoPunxC5fhlr", "P2EphC6Qbo", "AgH7SjrpzHTBb", "6lZG", "iuGyz0SG3T5uD6f3liiVpcsGpl9NN6eU", "8JXy4no7J"};

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{-67, -65, -78, -79, -74, -80, -82, -63, -78};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static <T> boolean A0B(Iterator<T> iterator, InterfaceC2396kj<? super T> predicate) {
        return A00(iterator, predicate) != -1;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static boolean A0F(Iterator<?> iterator1, Iterator<?> iterator2) {
        while (iterator1.hasNext()) {
            if (!iterator2.hasNext() || !CB.A01(iterator1.next(), iterator2.next())) {
                return false;
            }
        }
        return !iterator2.hasNext();
    }

    static {
        A08();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kj != com.google.common.base.Predicate<? super T> */
    public static <T> int A00(Iterator<T> iterator, InterfaceC2396kj<? super T> predicate) {
        AbstractC2395ki.A05(predicate, A07(0, 9, 27));
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.A4C(iterator.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kj != com.google.common.base.Predicate<? super T> */
    public static <T> C4C<T> A01(final Iterator<T> unfiltered, final InterfaceC2396kj<? super T> retainIfTrue) {
        AbstractC2395ki.A04(unfiltered);
        AbstractC2395ki.A04(retainIfTrue);
        return new AbstractC1138Bv<T>() { // from class: com.facebook.ads.redexgen.X.2I
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.facebook.ads.redexgen.core.AbstractC1138Bv
            @CheckForNull
            public final T A02() {
                while (unfiltered.hasNext()) {
                    T t = (T) unfiltered.next();
                    if (retainIfTrue.A4C(t)) {
                        return t;
                    }
                }
                return A01();
            }
        };
    }

    public static <T> Iterator<T> A02() {
        return EnumC2653p7.A03;
    }

    public static <T> C4C<T> A03(@ParametricNullness T value) {
        return new BN(value);
    }

    @CheckForNull
    public static <T> T A04(Iterator<T> iterator) {
        if (iterator.hasNext()) {
            T result = iterator.next();
            iterator.remove();
            return result;
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kj != com.google.common.base.Predicate<? super T> */
    @ParametricNullness
    public static <T> T A05(Iterator<T> iterator, InterfaceC2396kj<? super T> predicate) {
        AbstractC2395ki.A04(iterator);
        AbstractC2395ki.A04(predicate);
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (predicate.A4C(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @ParametricNullness
    public static <T> T A06(@ParametricNullness Iterator<? extends T> iterator, T defaultValue) {
        if (!iterator.hasNext()) {
            return defaultValue;
        }
        T defaultValue2 = iterator.next();
        return defaultValue2;
    }

    public static void A09(Iterator<?> iterator) {
        AbstractC2395ki.A04(iterator);
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> boolean A0A(java.util.Collection<T> r2, java.util.Iterator<? extends T> r3) {
        /*
            com.facebook.ads.redexgen.core.AbstractC2395ki.A04(r2)
            com.facebook.ads.redexgen.core.AbstractC2395ki.A04(r3)
            r1 = 0
        L7:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L17
            java.lang.Object r0 = r3.next()
            boolean r0 = r2.add(r0)
            r1 = r1 | r0
            goto L7
        L17:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC2655p9.A0A(java.util.Collection, java.util.Iterator):boolean");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kj != com.google.common.base.Predicate<? super T> */
    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> boolean A0C(java.util.Iterator<T> r3, com.facebook.ads.redexgen.core.InterfaceC2396kj<? super T> r4) {
        /*
            com.facebook.ads.redexgen.core.AbstractC2395ki.A04(r4)
            r1 = 0
        L4:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L32
            java.lang.Object r0 = r3.next()
            boolean r0 = r4.A4C(r0)
            if (r0 == 0) goto L4
            r3.remove()
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AbstractC2655p9.A01
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 4
            if (r1 == r0) goto L29
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L29:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC2655p9.A01
            java.lang.String r1 = "wI9B4C2he"
            r0 = 7
            r2[r0] = r1
            r1 = 1
            goto L4
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC2655p9.A0C(java.util.Iterator, com.facebook.ads.redexgen.X.kj):boolean");
    }

    public static boolean A0D(@CheckForNull Iterator<?> iterator, Object element) {
        if (element == null) {
            while (iterator.hasNext()) {
                if (iterator.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (iterator.hasNext()) {
            if (element.equals(iterator.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0E(java.util.Iterator<?> r2, java.util.Collection<?> r3) {
        /*
            com.facebook.ads.redexgen.core.AbstractC2395ki.A04(r3)
            r1 = 0
        L4:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L19
            java.lang.Object r0 = r2.next()
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L4
            r2.remove()
            r1 = 1
            goto L4
        L19:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC2655p9.A0E(java.util.Iterator, java.util.Collection):boolean");
    }
}
