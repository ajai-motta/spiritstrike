package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$ExtendableMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratedMessageLite$ExtendableMessage<MessageType extends GeneratedMessageLite$ExtendableMessage<MessageType, BuilderType>, BuilderType> extends z0 implements e2 {
    protected n0 extensions = n0.d;

    private void eagerlyMergeMessageSetExtension(w wVar, x0 x0Var, h0 h0Var, int i) throws IOException {
        parseExtension(wVar, h0Var, x0Var, (i << 3) | 2, i);
    }

    private void mergeMessageSetExtensionFromBytes(s sVar, h0 h0Var, x0 x0Var) throws IOException {
        d2 d2Var = (d2) this.extensions.f1568a.get(x0Var.d);
        c2 builder = d2Var != null ? d2Var.toBuilder() : null;
        if (builder == null) {
            builder = x0Var.c.newBuilderForType();
        }
        t0 t0Var = (t0) builder;
        t0Var.getClass();
        try {
            w wVarD = sVar.d();
            t0Var.a(wVarD, h0Var);
            wVarD.a(0);
            Object objA = t0Var.a();
            n0 n0VarEnsureExtensionsAreMutable = ensureExtensionsAreMutable();
            w0 w0Var = x0Var.d;
            if (w0Var.c.a() == k4.ENUM) {
                objA = Integer.valueOf(((d1) objA).a());
            }
            n0VarEnsureExtensionsAreMutable.c(w0Var, objA);
        } catch (n1 e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading " + t0Var.getClass().getName() + " from a ByteString threw an IOException (should never happen).", e2);
        }
    }

    private <MessageType extends d2> void mergeMessageSetExtensionFromCodedStream(MessageType messagetype, w wVar, h0 h0Var) throws IOException {
        int iU = 0;
        q qVarE = null;
        x0 x0VarA = null;
        while (true) {
            int iT = wVar.t();
            if (iT == 0) {
                break;
            }
            if (iT == 16) {
                iU = wVar.u();
                if (iU != 0) {
                    x0VarA = h0Var.a(iU, messagetype);
                }
            } else if (iT == 26) {
                if (iU == 0 || x0VarA == null) {
                    qVarE = wVar.e();
                } else {
                    eagerlyMergeMessageSetExtension(wVar, x0VarA, h0Var, iU);
                    qVarE = null;
                }
            } else if (!wVar.e(iT)) {
                break;
            }
        }
        wVar.a(12);
        if (qVarE == null || iU == 0) {
            return;
        }
        if (x0VarA != null) {
            mergeMessageSetExtensionFromBytes(qVarE, h0Var, x0VarA);
        } else {
            mergeLengthDelimitedField(iU, qVarE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Type inference failed for: r10v27, types: [com.fyber.inneractive.sdk.protobuf.d1] */
    /* JADX WARN: Type inference failed for: r10v30, types: [java.lang.Integer] */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean parseExtension(com.fyber.inneractive.sdk.protobuf.w r7, com.fyber.inneractive.sdk.protobuf.h0 r8, com.fyber.inneractive.sdk.protobuf.x0 r9, int r10, int r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$ExtendableMessage.parseExtension(com.fyber.inneractive.sdk.protobuf.w, com.fyber.inneractive.sdk.protobuf.h0, com.fyber.inneractive.sdk.protobuf.x0, int, int):boolean");
    }

    private void verifyExtensionContainingType(x0 x0Var) {
        if (x0Var.f1590a != getDefaultInstanceForType()) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    public n0 ensureExtensionsAreMutable() {
        n0 n0Var = this.extensions;
        if (n0Var.b) {
            this.extensions = n0Var.m4883clone();
        }
        return this.extensions;
    }

    public boolean extensionsAreInitialized() {
        return this.extensions.c();
    }

    public int extensionsSerializedSize() {
        return this.extensions.b();
    }

    public int extensionsSerializedSizeAsMessageSet() {
        return this.extensions.a();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z0, com.fyber.inneractive.sdk.protobuf.e2
    public /* bridge */ /* synthetic */ d2 getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [Type, java.util.ArrayList] */
    public final <Type> Type getExtension(e0 e0Var) {
        x0 x0VarAccess$000 = z0.access$000(e0Var);
        verifyExtensionContainingType(x0VarAccess$000);
        Type type = (Type) this.extensions.f1568a.get(x0VarAccess$000.d);
        if (type == 0) {
            return (Type) x0VarAccess$000.b;
        }
        w0 w0Var = x0VarAccess$000.d;
        if (!w0Var.d) {
            return w0Var.c.a() == k4.ENUM ? (Type) x0VarAccess$000.d.f1585a.a(((Integer) type).intValue()) : type;
        }
        if (w0Var.c.a() != k4.ENUM) {
            return type;
        }
        ?? r1 = (Type) new ArrayList();
        for (Object objA : (List) type) {
            if (x0VarAccess$000.d.c.a() == k4.ENUM) {
                objA = x0VarAccess$000.d.f1585a.a(((Integer) objA).intValue());
            }
            r1.add(objA);
        }
        return r1;
    }

    public final <Type> int getExtensionCount(e0 e0Var) {
        x0 x0VarAccess$000 = z0.access$000(e0Var);
        verifyExtensionContainingType(x0VarAccess$000);
        n0 n0Var = this.extensions;
        w0 w0Var = x0VarAccess$000.d;
        n0Var.getClass();
        if (!w0Var.d) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj = n0Var.f1568a.get(w0Var);
        if (obj == null) {
            return 0;
        }
        return ((List) obj).size();
    }

    public final <Type> boolean hasExtension(e0 e0Var) {
        x0 x0VarAccess$000 = z0.access$000(e0Var);
        verifyExtensionContainingType(x0VarAccess$000);
        n0 n0Var = this.extensions;
        w0 w0Var = x0VarAccess$000.d;
        n0Var.getClass();
        if (w0Var.d) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return n0Var.f1568a.get(w0Var) != null;
    }

    public final void mergeExtensionFields(MessageType messagetype) {
        n0 n0Var = this.extensions;
        if (n0Var.b) {
            this.extensions = n0Var.m4883clone();
        }
        this.extensions.a(messagetype.extensions);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z0, com.fyber.inneractive.sdk.protobuf.d2
    public /* bridge */ /* synthetic */ c2 newBuilderForType() {
        return newBuilderForType();
    }

    public v0 newExtensionWriter() {
        return new v0(this);
    }

    public v0 newMessageSetExtensionWriter() {
        return new v0(this);
    }

    public <MessageType extends d2> boolean parseUnknownField(MessageType messagetype, w wVar, h0 h0Var, int i) throws IOException {
        int i2 = i >>> 3;
        return parseExtension(wVar, h0Var, h0Var.a(i2, messagetype), i, i2);
    }

    public <MessageType extends d2> boolean parseUnknownFieldAsMessageSet(MessageType messagetype, w wVar, h0 h0Var, int i) throws IOException {
        if (i != 11) {
            return (i & 7) == 2 ? parseUnknownField(messagetype, wVar, h0Var, i) : wVar.e(i);
        }
        mergeMessageSetExtensionFromCodedStream(messagetype, wVar, h0Var);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z0, com.fyber.inneractive.sdk.protobuf.d2
    public /* bridge */ /* synthetic */ c2 toBuilder() {
        return toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <Type> Type getExtension(e0 e0Var, int i) {
        x0 x0VarAccess$000 = z0.access$000(e0Var);
        verifyExtensionContainingType(x0VarAccess$000);
        n0 n0Var = this.extensions;
        w0 w0Var = x0VarAccess$000.d;
        n0Var.getClass();
        if (w0Var.d) {
            Object obj = n0Var.f1568a.get(w0Var);
            if (obj != null) {
                Type type = (Type) ((List) obj).get(i);
                return x0VarAccess$000.d.c.a() == k4.ENUM ? (Type) x0VarAccess$000.d.f1585a.a(((Integer) type).intValue()) : type;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
}
