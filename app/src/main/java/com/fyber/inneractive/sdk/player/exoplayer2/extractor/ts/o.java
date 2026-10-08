package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f1374a;
    public String b;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r c;
    public n d;
    public boolean e;
    public long l;
    public long m;
    public final boolean[] f = new boolean[3];
    public final r g = new r(32);
    public final r h = new r(33);
    public final r i = new r(34);
    public final r j = new r(39);
    public final r k = new r(40);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n n = new com.fyber.inneractive.sdk.player.exoplayer2.util.n();

    public o(x xVar) {
        this.f1374a = xVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(this.f);
        r rVar = this.g;
        rVar.b = false;
        rVar.c = false;
        r rVar2 = this.h;
        rVar2.b = false;
        rVar2.c = false;
        r rVar3 = this.i;
        rVar3.b = false;
        rVar3.c = false;
        r rVar4 = this.j;
        rVar4.b = false;
        rVar4.c = false;
        r rVar5 = this.k;
        rVar5.b = false;
        rVar5.c = false;
        n nVar = this.d;
        nVar.f = false;
        nVar.g = false;
        nVar.h = false;
        nVar.i = false;
        nVar.j = false;
        this.l = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.b = e0Var.e;
        e0Var.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e0Var.d, 2);
        this.c = gVarA;
        this.d = new n(gVarA);
        this.f1374a.a(jVar, e0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03be  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n r38) {
        /*
            Method dump skipped, instruction units count: 996
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.o.a(com.fyber.inneractive.sdk.player.exoplayer2.util.n):void");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        this.m = j;
    }

    public final void a(byte[] bArr, int i, int i2) {
        if (this.e) {
            n nVar = this.d;
            if (nVar.f) {
                int i3 = nVar.d;
                int i4 = (i + 2) - i3;
                if (i4 < i2) {
                    nVar.g = (bArr[i4] & 128) != 0;
                    nVar.f = false;
                } else {
                    nVar.d = (i2 - i) + i3;
                }
            }
        } else {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }
}
