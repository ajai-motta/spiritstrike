package com.fyber.inneractive.sdk.bidder;

import android.adservices.topics.EncryptedTopic;
import android.adservices.topics.Topic;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.v0;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.protobuf.y0;
import com.fyber.inneractive.sdk.protobuf.z0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.s1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements e, v0, com.fyber.inneractive.sdk.config.cellular.h {
    public static final b h = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f886a;
    public final com.fyber.inneractive.sdk.serverapi.c b;
    public final d c;
    public f d;
    public final AtomicReference e = new AtomicReference(null);
    public final AtomicBoolean f = new AtomicBoolean(false);
    public final Object g = new Object();

    public b() {
        com.fyber.inneractive.sdk.config.cellular.a aVar;
        com.fyber.inneractive.sdk.serverapi.c cVar = new com.fyber.inneractive.sdk.serverapi.c(com.fyber.inneractive.sdk.config.global.r.a());
        this.b = cVar;
        d dVar = new d(cVar);
        this.c = dVar;
        this.f886a = TokenParametersOuterClass$TokenParameters.newBuilder();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        iAConfigManager.x.d = this;
        if (iAConfigManager.u.b.a(true, "bidding_token_wait_for_ua")) {
            s1 s1Var = iAConfigManager.y;
            s1Var.b();
            if (!s1Var.d.get()) {
                s1Var.c();
            }
            dVar.b = iAConfigManager.y.a();
        }
        if (!InneractiveAdManager.isCurrentUserAChild() && (aVar = iAConfigManager.N) != null) {
            try {
                aVar.c.add(this);
            } catch (Throwable th) {
                IAlog.a("failed to add network observer", th, new Object[0]);
            }
        }
        f fVar = new f(this);
        this.d = fVar;
        fVar.a();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final byte[] a() {
        JSONArray jSONArrayA;
        byte b;
        byte b2;
        r0 r0Var;
        l0 l0Var;
        String str;
        k kVar = this.f886a;
        kVar.b = (z0) kVar.b.dynamicMethod(y0.NEW_MUTABLE_INSTANCE);
        k kVar2 = this.f886a;
        this.c.getClass();
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA = h.a("1.2");
        kVar2.c();
        ((TokenParametersOuterClass$TokenParameters) kVar2.b).setVersion(nullableStringA);
        if (this.e.get() != null) {
            this.c.a();
        }
        k kVar3 = this.f886a;
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA2 = h.a(this.c.b);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setUserAgent(nullableStringA2);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA3 = h.a(this.c.c);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setSdkVersion(nullableStringA3);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA4 = h.a(this.c.d);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setBundleID(nullableStringA4);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA5 = h.a(this.c.e);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceModel(nullableStringA5);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA6 = h.a(this.c.f);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setAppVersion(nullableStringA6);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA7 = h.a("Android");
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceOS(nullableStringA7);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A = h.a(Build.VERSION.SDK_INT);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceApi(nullableUInt32A);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA8 = h.a(Build.VERSION.RELEASE);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setOsVersion(nullableStringA8);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA9 = h.a(this.c.g);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceLanguage(nullableStringA9);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA10 = h.a(this.c.h);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setCountryCode(nullableStringA10);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA11 = h.a(this.c.i);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setCarrierName(nullableStringA11);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA12 = h.a(this.c.j);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setMobileCountryCode(nullableStringA12);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA13 = h.a(this.c.k);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setMobileNetworkCode(nullableStringA13);
        Long l = this.c.l;
        x xVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableSInt32.newBuilder();
        if (l != null) {
            int iIntValue = l.intValue();
            xVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableSInt32) xVarNewBuilder.b).setData(iIntValue);
        }
        TokenParametersOuterClass$TokenParameters.NullableSInt32 nullableSInt32 = (TokenParametersOuterClass$TokenParameters.NullableSInt32) xVarNewBuilder.a();
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setOffsetFromGMT(nullableSInt32);
        IAConfigManager iAConfigManager = IAConfigManager.O;
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA14 = h.a(iAConfigManager.D.g);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setUserID(nullableStringA14);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A2 = h.a(this.c.m);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceWidth(nullableUInt32A2);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A3 = h.a(this.c.n);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setDeviceHeight(nullableUInt32A3);
        q qVar = this.c.o;
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setFrameworkName(qVar);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA15 = h.a(this.c.p);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setInputLanguages(nullableStringA15);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA16 = h.a(this.c.H);
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setMediationType(nullableStringA16);
        this.c.getClass();
        com.fyber.inneractive.sdk.ignite.l lVar = iAConfigManager.E.p;
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA17 = h.a(lVar != null ? lVar.getOdt() : "");
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setOdt(nullableStringA17);
        Integer numA = com.fyber.inneractive.sdk.serverapi.b.a();
        z zVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (numA != null) {
            int iIntValue2 = numA.intValue();
            zVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder.b).setData(iIntValue2);
        }
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32 = (TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder.a();
        kVar3.c();
        ((TokenParametersOuterClass$TokenParameters) kVar3.b).setAdServicesVersion(nullableUInt32);
        com.fyber.inneractive.sdk.config.g gVar = iAConfigManager.D;
        if (gVar != null) {
            k kVar4 = this.f886a;
            if (gVar.d == null) {
                gVar.e = gVar.h();
            }
            if (com.fyber.inneractive.sdk.util.o.f1662a == null) {
                str = null;
            } else {
                str = gVar.d;
                if (str == null) {
                    str = gVar.e;
                }
            }
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringA18 = h.a(str);
            kVar4.c();
            ((TokenParametersOuterClass$TokenParameters) kVar4.b).setGdprString(nullableStringA18);
            TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA = h.a(gVar.d());
            kVar4.c();
            ((TokenParametersOuterClass$TokenParameters) kVar4.b).setGdprConsent(nullableBoolA);
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringA19 = h.a(com.fyber.inneractive.sdk.util.o.f1662a == null ? null : gVar.h);
            kVar4.c();
            ((TokenParametersOuterClass$TokenParameters) kVar4.b).setCcpaString(nullableStringA19);
            TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA2 = h.a(com.fyber.inneractive.sdk.util.o.f1662a == null ? null : gVar.i);
            kVar4.c();
            ((TokenParametersOuterClass$TokenParameters) kVar4.b).setLgpdConsent(nullableBoolA2);
            Boolean bool = gVar.j;
            if (bool != null && bool.booleanValue()) {
                k kVar5 = this.f886a;
                TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA3 = h.a(bool);
                kVar5.c();
                ((TokenParametersOuterClass$TokenParameters) kVar5.b).setCoppaApplies(nullableBoolA3);
            }
        }
        char c = 0;
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            k kVar6 = this.f886a;
            com.fyber.inneractive.sdk.config.v vVar = com.fyber.inneractive.sdk.config.u.f982a.b;
            boolean z = vVar != null ? vVar.b : false;
            kVar6.c();
            ((TokenParametersOuterClass$TokenParameters) kVar6.b).setDnt(z);
        }
        k kVar7 = this.f886a;
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA20 = h.a(this.c.q);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setNetwork(nullableStringA20);
        d0 d0Var = this.c.r;
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setSecureContent(d0Var);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA4 = h.a(this.c.B);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setBatteryCharging(nullableBoolA4);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA5 = h.a(this.c.s);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setHeadsetPlugged(nullableBoolA5);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA6 = h.a(this.c.t);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setBluetoothPlugged(nullableBoolA6);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA7 = h.a(this.c.u);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setLowPowerMode(nullableBoolA7);
        boolean z2 = this.c.v;
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setDarkMode(z2);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA8 = h.a(this.c.w);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setAirplaneMode(nullableBoolA8);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA9 = h.a(this.c.x);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setDndMode(nullableBoolA9);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA10 = h.a(this.c.y);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setIsRingMuted(nullableBoolA10);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A4 = h.a(this.c.z);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setSessionDuration(nullableUInt32A4);
        String str2 = this.c.C;
        z zVarNewBuilder2 = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (!TextUtils.isEmpty(str2)) {
            int i = Integer.parseInt(str2);
            zVarNewBuilder2.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder2.b).setData(i);
        }
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt322 = (TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder2.a();
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setBatteryLevel(nullableUInt322);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA11 = h.a(Boolean.valueOf(TextUtils.equals(iAConfigManager.x.a(UnitDisplayType.INTERSTITIAL, "LAST_VAST_SKIPED"), "1")));
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setPriorSkip(nullableBoolA11);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A5 = h.a(this.c.D);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setUserAge(nullableUInt32A5);
        InneractiveUserConfig.Gender gender = this.c.E;
        n0 n0Var = gender == InneractiveUserConfig.Gender.FEMALE ? n0.FEMALE : gender == InneractiveUserConfig.Gender.MALE ? n0.MALE : n0.UNKNOWN;
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setUserGender(n0Var);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA21 = h.a(this.c.G);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setZipCode(nullableStringA21);
        boolean z3 = this.c.F;
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setMuteAudio(z3);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA12 = h.a(this.c.L);
        kVar7.c();
        ((TokenParametersOuterClass$TokenParameters) kVar7.b).setMediaMuted(nullableBoolA12);
        com.fyber.inneractive.sdk.config.v vVar2 = com.fyber.inneractive.sdk.config.u.f982a.b;
        if (vVar2 == null || !vVar2.c) {
            k kVar8 = this.f886a;
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringA22 = h.a(this.c.A);
            kVar8.c();
            ((TokenParametersOuterClass$TokenParameters) kVar8.b).setAaid(nullableStringA22);
        } else {
            k kVar9 = this.f886a;
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringA23 = h.a(this.c.A);
            kVar9.c();
            ((TokenParametersOuterClass$TokenParameters) kVar9.b).setAmazonId(nullableStringA23);
        }
        UnitDisplayType[] unitDisplayTypeArrValues = UnitDisplayType.values();
        int length = unitDisplayTypeArrValues.length;
        int i2 = 0;
        while (true) {
            byte b3 = 2;
            if (i2 >= length) {
                com.fyber.inneractive.sdk.serverapi.c cVar = this.b;
                cVar.getClass();
                com.fyber.inneractive.sdk.config.global.r rVarA = com.fyber.inneractive.sdk.config.global.r.a();
                cVar.f1623a = rVarA;
                rVarA.a(false, "");
                com.fyber.inneractive.sdk.config.global.r rVar = this.b.f1623a;
                if (rVar != null) {
                    jSONArrayA = com.fyber.inneractive.sdk.config.global.g.a(rVar.b, true);
                    IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArrayA);
                } else {
                    jSONArrayA = null;
                }
                if (jSONArrayA != null) {
                    for (int i3 = 0; i3 < jSONArrayA.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayA.optJSONObject(i3);
                        if (jSONObjectOptJSONObject != null) {
                            n nVarNewBuilder = TokenParametersOuterClass$TokenParameters.Experiment.newBuilder();
                            String strOptString = jSONObjectOptJSONObject.optString("id");
                            nVarNewBuilder.c();
                            ((TokenParametersOuterClass$TokenParameters.Experiment) nVarNewBuilder.b).setIdentifier(strOptString);
                            String strOptString2 = jSONObjectOptJSONObject.optString("v");
                            nVarNewBuilder.c();
                            ((TokenParametersOuterClass$TokenParameters.Experiment) nVarNewBuilder.b).setVariant(strOptString2);
                            k kVar10 = this.f886a;
                            TokenParametersOuterClass$TokenParameters.Experiment experiment = (TokenParametersOuterClass$TokenParameters.Experiment) nVarNewBuilder.a();
                            kVar10.c();
                            ((TokenParametersOuterClass$TokenParameters) kVar10.b).addAbExperiments(experiment);
                        }
                    }
                }
                k kVar11 = this.f886a;
                int i4 = com.fyber.inneractive.sdk.config.k.f959a;
                String property = System.getProperty("ia.testEnvironmentConfiguration.number");
                z zVarNewBuilder3 = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
                if (!TextUtils.isEmpty(property)) {
                    int i5 = Integer.parseInt(property);
                    zVarNewBuilder3.c();
                    ((TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder3.b).setData(i5);
                }
                TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt323 = (TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder3.a();
                kVar11.c();
                ((TokenParametersOuterClass$TokenParameters) kVar11.b).setPortal(nullableUInt323);
                k kVar12 = this.f886a;
                TokenParametersOuterClass$TokenParameters.NullableString nullableStringA24 = h.a(System.getProperty("ia.testEnvironmentConfiguration.response"));
                kVar12.c();
                ((TokenParametersOuterClass$TokenParameters) kVar12.b).setMockResponseId(nullableStringA24);
                k kVar13 = this.f886a;
                TokenParametersOuterClass$TokenParameters.NullableString nullableStringA25 = h.a(this.c.I);
                kVar13.c();
                ((TokenParametersOuterClass$TokenParameters) kVar13.b).setIgniteVersion(nullableStringA25);
                k kVar14 = this.f886a;
                TokenParametersOuterClass$TokenParameters.NullableString nullableStringA26 = h.a(this.c.J);
                kVar14.c();
                ((TokenParametersOuterClass$TokenParameters) kVar14.b).setIgnitePackageName(nullableStringA26);
                if (this.c.K) {
                    k kVar15 = this.f886a;
                    TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA13 = h.a(Boolean.TRUE);
                    kVar15.c();
                    ((TokenParametersOuterClass$TokenParameters) kVar15.b).setChildMode(nullableBoolA13);
                }
                ArrayList<EncryptedTopic> arrayList = this.c.M;
                if (IAConfigManager.c() && arrayList != null && !arrayList.isEmpty()) {
                    for (EncryptedTopic encryptedTopic : arrayList) {
                        l lVarNewBuilder = TokenParametersOuterClass$TokenParameters.EncryptedTopic.newBuilder();
                        byte[] encryptedTopic2 = encryptedTopic.getEncryptedTopic();
                        com.fyber.inneractive.sdk.protobuf.q qVar2 = com.fyber.inneractive.sdk.protobuf.s.b;
                        int length2 = encryptedTopic2.length;
                        com.fyber.inneractive.sdk.protobuf.s.a(0, length2, encryptedTopic2.length);
                        com.fyber.inneractive.sdk.protobuf.o oVar = com.fyber.inneractive.sdk.protobuf.s.c;
                        com.fyber.inneractive.sdk.protobuf.q qVar3 = new com.fyber.inneractive.sdk.protobuf.q(oVar.a(encryptedTopic2, 0, length2));
                        lVarNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.EncryptedTopic) lVarNewBuilder.b).setEncryptedTopic(qVar3);
                        String keyIdentifier = encryptedTopic.getKeyIdentifier();
                        lVarNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.EncryptedTopic) lVarNewBuilder.b).setKeyIdentifier(keyIdentifier);
                        byte[] encapsulatedKey = encryptedTopic.getEncapsulatedKey();
                        int length3 = encapsulatedKey.length;
                        com.fyber.inneractive.sdk.protobuf.s.a(0, length3, encapsulatedKey.length);
                        com.fyber.inneractive.sdk.protobuf.q qVar4 = new com.fyber.inneractive.sdk.protobuf.q(oVar.a(encapsulatedKey, 0, length3));
                        lVarNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.EncryptedTopic) lVarNewBuilder.b).setEncapsulatedKey(qVar4);
                        TokenParametersOuterClass$TokenParameters.EncryptedTopic encryptedTopic3 = (TokenParametersOuterClass$TokenParameters.EncryptedTopic) lVarNewBuilder.a();
                        k kVar16 = this.f886a;
                        kVar16.c();
                        ((TokenParametersOuterClass$TokenParameters) kVar16.b).addEncryptedTopics(encryptedTopic3);
                    }
                }
                ArrayList<Topic> arrayList2 = this.c.N;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    for (Topic topic : arrayList2) {
                        g0 g0VarNewBuilder = TokenParametersOuterClass$TokenParameters.Topic.newBuilder();
                        int topicId = topic.getTopicId();
                        g0VarNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.Topic) g0VarNewBuilder.b).setTopicId(topicId);
                        long modelVersion = topic.getModelVersion();
                        g0VarNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.Topic) g0VarNewBuilder.b).setModelVersion(modelVersion);
                        long taxonomyVersion = topic.getTaxonomyVersion();
                        g0VarNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.Topic) g0VarNewBuilder.b).setTaxonomyVersion(taxonomyVersion);
                        TokenParametersOuterClass$TokenParameters.Topic topic2 = (TokenParametersOuterClass$TokenParameters.Topic) g0VarNewBuilder.a();
                        k kVar17 = this.f886a;
                        kVar17.c();
                        ((TokenParametersOuterClass$TokenParameters) kVar17.b).addTopics(topic2);
                    }
                }
                return ((TokenParametersOuterClass$TokenParameters) this.f886a.a()).toByteArray();
            }
            UnitDisplayType unitDisplayType = unitDisplayTypeArrValues[i2];
            if (!unitDisplayType.isDeprecated()) {
                int[] iArr = g.f890a;
                int i6 = iArr[unitDisplayType.ordinal()];
                l0 l0Var2 = i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? i6 != 5 ? l0.UNITDISPLAYTYPEUNKNOWN : l0.TYPENATIVE : l0.MRECT : l0.REWARDED : l0.INTERSTITIAL : l0.BANNER;
                com.fyber.inneractive.sdk.serverapi.a aVar = com.fyber.inneractive.sdk.serverapi.b.f1622a;
                IAConfigManager iAConfigManager2 = IAConfigManager.O;
                String strA = iAConfigManager2.x.a(unitDisplayType, "LAST_DOMAIN_SHOWED");
                if (!TextUtils.isEmpty(strA) && strA.contains(",")) {
                    strA = strA.split(",")[c];
                }
                if (!TextUtils.isEmpty(strA)) {
                    k kVar18 = this.f886a;
                    r rVarNewBuilder = TokenParametersOuterClass$TokenParameters.LastAdomain.newBuilder();
                    rVarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdomain) rVarNewBuilder.b).setAdomain(strA);
                    rVarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdomain) rVarNewBuilder.b).setType(l0Var2);
                    TokenParametersOuterClass$TokenParameters.LastAdomain lastAdomain = (TokenParametersOuterClass$TokenParameters.LastAdomain) rVarNewBuilder.a();
                    kVar18.c();
                    ((TokenParametersOuterClass$TokenParameters) kVar18.b).addLastAdomains(lastAdomain);
                }
                String strA2 = iAConfigManager2.x.a(unitDisplayType, "LAST_APP_BUNDLE_ID");
                if (!TextUtils.isEmpty(strA2)) {
                    k kVar19 = this.f886a;
                    t tVarNewBuilder = TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle.newBuilder();
                    tVarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) tVarNewBuilder.b).setLastBundle(strA2);
                    tVarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) tVarNewBuilder.b).setType(l0Var2);
                    TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle lastAdvertisedBundle = (TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) tVarNewBuilder.a();
                    kVar19.c();
                    ((TokenParametersOuterClass$TokenParameters) kVar19.b).addLastAdvertisedBundles(lastAdvertisedBundle);
                }
                if (TextUtils.equals(iAConfigManager2.x.a(unitDisplayType, "LAST_CLICKED"), "1")) {
                    k kVar20 = this.f886a;
                    int i7 = iArr[unitDisplayType.ordinal()];
                    if (i7 == 1) {
                        b = 3;
                        b2 = 4;
                        l0Var = l0.BANNER;
                    } else if (i7 != 2) {
                        b = 3;
                        if (i7 != 3) {
                            b2 = 4;
                            l0Var = i7 != 4 ? i7 != 5 ? l0.UNITDISPLAYTYPEUNKNOWN : l0.TYPENATIVE : l0.MRECT;
                        } else {
                            b2 = 4;
                            l0Var = l0.REWARDED;
                        }
                    } else {
                        b = 3;
                        b2 = 4;
                        l0Var = l0.INTERSTITIAL;
                    }
                    kVar20.c();
                    ((TokenParametersOuterClass$TokenParameters) kVar20.b).addPriorClicks(l0Var);
                } else {
                    b = 3;
                    b2 = 4;
                }
                a("display", unitDisplayType, l0Var2);
                if (unitDisplayType.isFullscreenUnit()) {
                    a("video", unitDisplayType, l0Var2);
                    String strA3 = iAConfigManager2.x.a(unitDisplayType, "LAST_VAST_CLICKED_TYPE");
                    if (!TextUtils.isEmpty(strA3)) {
                        k kVar21 = this.f886a;
                        a0 a0VarNewBuilder = TokenParametersOuterClass$TokenParameters.PriorVideoClickType.newBuilder();
                        strA3.getClass();
                        strA3.hashCode();
                        switch (strA3.hashCode()) {
                            case 49:
                                b3 = strA3.equals("1") ? (byte) 0 : (byte) -1;
                                break;
                            case 50:
                                b3 = strA3.equals("2") ? (byte) 1 : (byte) -1;
                                break;
                            case 51:
                                if (!strA3.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                                    b3 = -1;
                                }
                                break;
                            case 52:
                                b3 = strA3.equals("4") ? b : (byte) -1;
                                break;
                            case 53:
                                b3 = strA3.equals("5") ? b2 : (byte) -1;
                                break;
                            default:
                                b3 = -1;
                                break;
                        }
                        switch (b3) {
                            case 0:
                                r0Var = r0.CTABUTTON;
                                break;
                            case 1:
                                r0Var = r0.COMPANION;
                                break;
                            case 2:
                                r0Var = r0.VIDEOVIEW;
                                break;
                            case 3:
                                r0Var = r0.APPINFO;
                                break;
                            case 4:
                                r0Var = r0.STOREPROMO;
                                break;
                            default:
                                r0Var = r0.NOCLICK;
                                break;
                        }
                        a0VarNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.PriorVideoClickType) a0VarNewBuilder.b).setClickType(r0Var);
                        a0VarNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.PriorVideoClickType) a0VarNewBuilder.b).setType(l0Var2);
                        TokenParametersOuterClass$TokenParameters.PriorVideoClickType priorVideoClickType = (TokenParametersOuterClass$TokenParameters.PriorVideoClickType) a0VarNewBuilder.a();
                        kVar21.c();
                        ((TokenParametersOuterClass$TokenParameters) kVar21.b).addPriorClickTypes(priorVideoClickType);
                    }
                }
            }
            i2++;
            c = 0;
        }
    }

    public final void b() {
        if (this.f.compareAndSet(false, true)) {
            try {
                this.e.set(Base64.encodeToString(a(), 2));
            } catch (Throwable th) {
                IAlog.b("Failed to generate token with error: %s", th.getMessage());
            }
            this.f.set(false);
        }
    }

    public final void c() {
        int currentInterruptionFilter = ((NotificationManager) com.fyber.inneractive.sdk.util.o.f1662a.getSystemService("notification")).getCurrentInterruptionFilter();
        boolean z = currentInterruptionFilter >= 2 && currentInterruptionFilter <= 4;
        Boolean bool = this.c.x;
        if (bool == null || bool.booleanValue() != z) {
            this.c.x = Boolean.valueOf(z);
            d();
        }
    }

    public final void d() {
        com.fyber.inneractive.sdk.util.r.f1668a.execute(new a(this));
    }

    @Override // com.fyber.inneractive.sdk.config.cellular.h
    public final void a(com.fyber.inneractive.sdk.util.z0 z0Var) {
        if (TextUtils.equals(this.c.q, z0Var.b())) {
            return;
        }
        this.c.q = z0Var.b();
        d();
    }

    public final void a(String str, UnitDisplayType unitDisplayType, l0 l0Var) {
        ArrayList<com.fyber.inneractive.sdk.cache.session.g> arrayList;
        int i;
        j0 j0Var;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.cache.session.e eVar = iAConfigManager.x.f987a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.cache.session.k kVar = (com.fyber.inneractive.sdk.cache.session.k) eVar.b.get(com.fyber.inneractive.sdk.cache.session.enums.c.a(unitDisplayType.value(), str));
            TokenParametersOuterClass$TokenParameters.UserSession userSession = null;
            if (kVar != null) {
                ArrayList arrayList2 = new ArrayList(kVar);
                Collections.sort(arrayList2, new com.fyber.inneractive.sdk.cache.session.j());
                arrayList = new ArrayList(arrayList2);
            } else {
                arrayList = null;
            }
            try {
                i = Integer.parseInt(iAConfigManager.u.b.a("number_of_sessions", Integer.toString(5)));
            } catch (Throwable unused) {
                i = 5;
            }
            int i2 = i >= 0 ? i : 5;
            if (i2 > 0 && arrayList != null && arrayList.size() >= i2) {
                if (str.equals("video")) {
                    j0Var = j0.VIDEO;
                } else if (!str.equals("display")) {
                    j0Var = j0.UNITCONTENTTYPEUNKNOWN;
                } else {
                    j0Var = j0.DISPLAY;
                }
                o0 o0VarNewBuilder = TokenParametersOuterClass$TokenParameters.UserSession.newBuilder();
                o0VarNewBuilder.c();
                ((TokenParametersOuterClass$TokenParameters.UserSession) o0VarNewBuilder.b).setSubType(j0Var);
                int i3 = 0;
                for (com.fyber.inneractive.sdk.cache.session.g gVar : arrayList) {
                    e0 e0VarNewBuilder = TokenParametersOuterClass$TokenParameters.SessionData.newBuilder();
                    int i4 = gVar.b;
                    e0VarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.SessionData) e0VarNewBuilder.b).setClicks(i4);
                    int i5 = gVar.f910a;
                    e0VarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.SessionData) e0VarNewBuilder.b).setImpressions(i5);
                    if (str.equals("video") || l0Var.equals(l0.REWARDED)) {
                        int i6 = gVar.c;
                        e0VarNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.SessionData) e0VarNewBuilder.b).setCompletions(i6);
                    }
                    TokenParametersOuterClass$TokenParameters.SessionData sessionData = (TokenParametersOuterClass$TokenParameters.SessionData) e0VarNewBuilder.a();
                    o0VarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.UserSession) o0VarNewBuilder.b).addSessionDataItems(sessionData);
                    i3++;
                    if (i3 >= i2) {
                        break;
                    }
                }
                o0VarNewBuilder.c();
                ((TokenParametersOuterClass$TokenParameters.UserSession) o0VarNewBuilder.b).setType(l0Var);
                userSession = (TokenParametersOuterClass$TokenParameters.UserSession) o0VarNewBuilder.a();
            }
            if (userSession == null || userSession.getSessionDataItemsList().size() <= 0) {
                return;
            }
            k kVar2 = this.f886a;
            kVar2.c();
            ((TokenParametersOuterClass$TokenParameters) kVar2.b).addUserSessions(userSession);
        }
    }
}
