package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f1372a;
    public final boolean b;
    public final boolean c;
    public long g;
    public String i;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r j;
    public l k;
    public boolean l;
    public long m;
    public final boolean[] h = new boolean[3];
    public final r d = new r(7);
    public final r e = new r(8);
    public final r f = new r(6);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n n = new com.fyber.inneractive.sdk.player.exoplayer2.util.n();

    public m(x xVar, boolean z, boolean z2) {
        this.f1372a = xVar;
        this.b = z;
        this.c = z2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(this.h);
        r rVar = this.d;
        rVar.b = false;
        rVar.c = false;
        r rVar2 = this.e;
        rVar2.b = false;
        rVar2.c = false;
        r rVar3 = this.f;
        rVar3.b = false;
        rVar3.c = false;
        l lVar = this.k;
        lVar.k = false;
        lVar.o = false;
        k kVar = lVar.n;
        kVar.b = false;
        kVar.f1370a = false;
        this.g = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.i = e0Var.e;
        e0Var.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e0Var.d, 2);
        this.j = gVarA;
        this.k = new l(gVarA, this.b, this.c);
        this.f1372a.a(jVar, e0Var);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        this.m = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x024e  */
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
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n r33) {
        /*
            Method dump skipped, instruction units count: 750
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.m.a(com.fyber.inneractive.sdk.player.exoplayer2.util.n):void");
    }
}
