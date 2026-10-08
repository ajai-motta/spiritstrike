package com.tnkfactory.ad.pub;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class x1 extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3219a;
    public final ArrayList b;
    public final ArrayList c;
    public final ArrayList d;
    public final HashSet e;
    public final HashMap f;
    public final HashMap g;
    public final ArrayList h;
    public final ArrayList i;
    public u j;
    public final View k;
    public final q1 l;

    public x1(Context context, View view, HashSet hashSet, HashSet hashSet2, HashSet hashSet3, HashSet hashSet4, HashSet hashSet5, HashSet hashSet6, HashMap map, HashMap map2, HashMap map3, c cVar) {
        super(context);
        this.f3219a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = new q1(this, Looper.getMainLooper());
        this.f = map2;
        this.g = map;
        this.e = hashSet6;
        this.h = new ArrayList(hashSet);
        this.i = new ArrayList(hashSet2);
        addView(view);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            View view2 = (View) it.next();
            if (findViewById(view2.getId()) != null) {
                view2.setVisibility(0);
                this.k = view2;
                view2.setOnClickListener(new p1(this));
                if (cVar.q0 == null) {
                    this.l.sendEmptyMessageDelayed(0, 10000L);
                }
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            View view3 = (View) it2.next();
            if (findViewById(view3.getId()) != null) {
                view3.setOnClickListener(new r1(this));
            }
        }
        int i = cVar.Y;
        Iterator it3 = hashSet3.iterator();
        while (it3.hasNext()) {
            View view4 = (View) it3.next();
            if (findViewById(view4.getId()) != null) {
                if (i == 0) {
                    view4.setOnClickListener(new s1(this));
                } else {
                    view4.setOnTouchListener(new w1(this, view4));
                }
            }
        }
        Iterator it4 = hashSet4.iterator();
        while (it4.hasNext()) {
            View view5 = (View) it4.next();
            if (findViewById(view5.getId()) != null) {
                if (view5 instanceof i5) {
                    ((i5) view5).setVideoActionListener(new t1(this));
                } else {
                    view5.setOnClickListener(new u1(this));
                }
            }
        }
        Iterator it5 = hashSet5.iterator();
        while (it5.hasNext()) {
            View view6 = (View) it5.next();
            if (findViewById(view6.getId()) != null) {
                view6.setOnClickListener(new l1(this));
            }
        }
        if (map3.size() > 0) {
            this.f3219a = new ArrayList();
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            for (String str : map3.keySet()) {
                String str2 = (String) map3.get(str);
                if (str2 != null && str2.length() != 0) {
                    if (str2.startsWith("l")) {
                        this.f3219a.add(str);
                    } else if (str2.startsWith(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ)) {
                        this.b.add(str);
                    } else if (str2.startsWith("t")) {
                        this.c.add(str);
                    } else if (str2.startsWith("b")) {
                        this.d.add(str);
                    }
                }
            }
        }
        View viewA = a(h1.a("c77c179fed549e"));
        if (viewA instanceof i5) {
            ((i5) viewA).setVideoProgressListener(new m1(this));
        }
        View viewA2 = a(h1.a("c77c1899fc458469f6"));
        if (viewA2 instanceof a6) {
            ((a6) viewA2).setVideoProgressListener(new n1(this));
        }
    }

    public final void a() {
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(0);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void b(String str) {
        View viewA = a(str);
        if (viewA == null) {
            return;
        }
        if (viewA instanceof i5) {
            i5 i5Var = (i5) viewA;
            if (i5Var.b == null) {
                return;
            }
            f5 f5Var = i5Var.s;
            if (f5Var != null && i5Var.A) {
                x1 x1Var = ((t1) f5Var).f3195a;
                x1Var.getClass();
                String str2 = (String) i5Var.getTag();
                if (str2 != null) {
                    x1Var.b(str2);
                }
            }
            i5Var.m = true;
            i5Var.r = true;
            i5Var.b.a();
            ToggleButton toggleButton = i5Var.d;
            if (toggleButton != null) {
                toggleButton.setChecked(true);
                i5Var.a(700L);
                return;
            }
            return;
        }
        TranslateAnimation translateAnimation = null;
        if (viewA.getVisibility() == 4) {
            viewA.setVisibility(0);
            String str3 = (String) this.g.get(str);
            if (str3 != null) {
                String strTrim = str3.trim();
                strTrim.getClass();
                strTrim.hashCode();
                switch (strTrim) {
                    case "bottom":
                        translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
                        translateAnimation.setDuration(200L);
                        break;
                    case "top":
                        translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, -1.0f, 2, 0.0f);
                        translateAnimation.setDuration(200L);
                        break;
                    case "left":
                        translateAnimation = new TranslateAnimation(2, -1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
                        translateAnimation.setDuration(200L);
                        break;
                    case "right":
                        translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
                        translateAnimation.setDuration(200L);
                        break;
                }
            }
            if (translateAnimation != null) {
                viewA.startAnimation(translateAnimation);
                return;
            }
            return;
        }
        if (viewA.getVisibility() == 0) {
            viewA.setVisibility(4);
            String str4 = (String) this.g.get(str);
            if (str4 != null) {
                String strTrim2 = str4.trim();
                strTrim2.getClass();
                strTrim2.hashCode();
                switch (strTrim2.hashCode()) {
                    case -1383228885:
                        if (strTrim2.equals("bottom")) {
                        }
                        break;
                    case 115029:
                        if (strTrim2.equals(ViewHierarchyConstants.DIMENSION_TOP_KEY)) {
                        }
                        break;
                    case 3317767:
                        if (strTrim2.equals("left")) {
                        }
                        break;
                    case 108511772:
                        if (strTrim2.equals(TtmlNode.RIGHT)) {
                        }
                        break;
                }
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Switch insn not found in header
                    	at java.base/java.util.Objects.requireNonNull(Unknown Source)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:88)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                    */
                /*
                    Method dump skipped, instruction units count: 522
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tnkfactory.ad.pub.x1.b(java.lang.String):void");
            }

            public final void a(long j) {
                if (j < 0) {
                    return;
                }
                long j2 = (j + 1) * 1000;
                Iterator it = this.h.iterator();
                while (it.hasNext()) {
                    ((View) it.next()).setVisibility(8);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tnkfactory.ad.pub.x1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a();
                    }
                }, j2);
            }

            public final View a(String str) {
                Integer num = (Integer) this.f.get(str);
                if (num != null) {
                    return findViewById(num.intValue());
                }
                return null;
            }
        }
