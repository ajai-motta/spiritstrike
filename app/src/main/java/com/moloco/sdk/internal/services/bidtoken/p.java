package com.moloco.sdk.internal.services.bidtoken;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.moloco.sdk.BidToken;
import com.moloco.sdk.internal.services.A;
import com.moloco.sdk.internal.services.AbstractC3002c;
import com.moloco.sdk.internal.services.E;
import com.moloco.sdk.internal.services.F;
import com.moloco.sdk.internal.services.H;
import java.util.Date;
import java.util.TimeZone;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class p implements o {
    public static final int d = 0;
    public final com.moloco.sdk.internal.services.y b;
    public final F c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2313a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[H.values().length];
            try {
                iArr[H.f2285a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[H.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[H.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f2313a = iArr;
            int[] iArr2 = new int[com.moloco.sdk.internal.services.z.values().length];
            try {
                iArr2[com.moloco.sdk.internal.services.z.f2402a.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[com.moloco.sdk.internal.services.z.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[com.moloco.sdk.internal.services.z.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    public p(com.moloco.sdk.internal.services.y deviceInfoService, F screenInfoService) {
        Intrinsics.checkNotNullParameter(deviceInfoService, "deviceInfoService");
        Intrinsics.checkNotNullParameter(screenInfoService, "screenInfoService");
        this.b = deviceInfoService;
        this.c = screenInfoService;
    }

    public final long a(long j) {
        return j * ((long) 1000000);
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public BidToken.ClientBidTokenComponents b(byte[] payload) throws InvalidProtocolBufferException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        BidToken.ClientBidTokenComponents from = BidToken.ClientBidTokenComponents.parseFrom(payload);
        Intrinsics.checkNotNullExpressionValue(from, "parseFrom(...)");
        return from;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public byte[] a(byte[] bidTokenComponents, byte[] secret) {
        Intrinsics.checkNotNullParameter(bidTokenComponents, "bidTokenComponents");
        Intrinsics.checkNotNullParameter(secret, "secret");
        BidToken.ClientBidToken.Builder builderNewBuilder = BidToken.ClientBidToken.newBuilder();
        builderNewBuilder.setEs(ByteString.copyFrom(secret));
        builderNewBuilder.setPayload(ByteString.copyFrom(bidTokenComponents));
        byte[] byteArray = builderNewBuilder.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public BidToken.ClientBidTokenComponents a(com.moloco.sdk.internal.services.bidtoken.providers.k clientSignals, f bidTokenConfig) {
        BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus batteryStatus;
        BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType connectionType;
        Intrinsics.checkNotNullParameter(clientSignals, "clientSignals");
        Intrinsics.checkNotNullParameter(bidTokenConfig, "bidTokenConfig");
        com.moloco.sdk.internal.services.x xVarB = this.b.b();
        E eA = this.c.a();
        BidToken.ClientBidTokenComponents.Builder builderNewBuilder = BidToken.ClientBidTokenComponents.newBuilder();
        BidToken.ClientBidTokenComponents.SdkInfo.Builder builderNewBuilder2 = BidToken.ClientBidTokenComponents.SdkInfo.newBuilder();
        builderNewBuilder2.setInitialized(clientSignals.v());
        builderNewBuilder.setInfo(builderNewBuilder2.build());
        BidToken.ClientBidTokenComponents.MemoryInfo.Builder builderNewBuilder3 = BidToken.ClientBidTokenComponents.MemoryInfo.newBuilder();
        Boolean boolD = clientSignals.s().d();
        if (boolD != null) {
            builderNewBuilder3.setLowMem(boolD.booleanValue());
        }
        Long lE = clientSignals.s().e();
        if (lE != null) {
            builderNewBuilder3.setLowMemThresholdBytes(lE.longValue());
        }
        Long lF = clientSignals.s().f();
        if (lF != null) {
            builderNewBuilder3.setTotalMemBytes(lF.longValue());
        }
        builderNewBuilder.setMemoryInfo(builderNewBuilder3.build());
        BidToken.ClientBidTokenComponents.DirInfo.Builder builderNewBuilder4 = BidToken.ClientBidTokenComponents.DirInfo.newBuilder();
        Long lB = clientSignals.n().b();
        if (lB != null) {
            builderNewBuilder4.setDsizeBytes(lB.longValue());
        }
        builderNewBuilder.setDirInfo(builderNewBuilder4.build());
        BidToken.ClientBidTokenComponents.NetworkInfo.Builder builderNewBuilder5 = BidToken.ClientBidTokenComponents.NetworkInfo.newBuilder();
        if (clientSignals.t().e() != null) {
            builderNewBuilder5.setMcc(clientSignals.t().e().intValue());
        }
        Integer numF = clientSignals.t().f();
        if (numF != null) {
            builderNewBuilder5.setMnc(numF.intValue());
        }
        Boolean boolG = clientSignals.t().g();
        if (boolG != null) {
            builderNewBuilder5.setRestricted(boolG.booleanValue());
        }
        com.moloco.sdk.internal.services.A aH = clientSignals.t().h();
        if (aH != null) {
            if (aH instanceof A.a) {
                connectionType = BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType.CELLULAR;
            } else if (Intrinsics.areEqual(aH, A.b.b)) {
                connectionType = BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType.NO_NETWORK;
            } else {
                if (!Intrinsics.areEqual(aH, A.c.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                connectionType = BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType.WIFI;
            }
            builderNewBuilder5.setType(connectionType);
        }
        builderNewBuilder.setNetworkInfo(builderNewBuilder5.build());
        BidToken.ClientBidTokenComponents.BatteryInfo.Builder builderNewBuilder6 = BidToken.ClientBidTokenComponents.BatteryInfo.newBuilder();
        Integer numE = clientSignals.p().e();
        if (numE != null) {
            builderNewBuilder6.setMaxBatteryLevel(numE.intValue());
        }
        Integer numD = clientSignals.p().d();
        if (numD != null) {
            int iIntValue = numD.intValue();
            if (iIntValue == 2) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.CHARGING;
            } else if (iIntValue == 3) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.DISCHARGING;
            } else if (iIntValue == 4) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.NOT_CHARGING;
            } else if (iIntValue != 5) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.UNKNOWN;
            } else {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.FULL;
            }
            builderNewBuilder6.setBatteryStatus(batteryStatus);
        }
        Boolean boolF = clientSignals.p().f();
        if (boolF != null) {
            builderNewBuilder6.setLowPowMode(boolF.booleanValue());
        }
        builderNewBuilder.setBatteryInfo(builderNewBuilder6.build());
        BidToken.ClientBidTokenComponents.AdvertisingInfo.Builder builderNewBuilder7 = BidToken.ClientBidTokenComponents.AdvertisingInfo.newBuilder();
        AbstractC3002c abstractC3002cM = clientSignals.m();
        if (abstractC3002cM instanceof AbstractC3002c.a) {
            builderNewBuilder7.setDnt(false);
            builderNewBuilder7.setId(((AbstractC3002c.a) abstractC3002cM).b());
        } else if (Intrinsics.areEqual(abstractC3002cM, AbstractC3002c.b.b)) {
            builderNewBuilder7.setDnt(true);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        builderNewBuilder.setAdInfo(builderNewBuilder7.build());
        BidToken.ClientBidTokenComponents.Privacy.Builder builderNewBuilder8 = BidToken.ClientBidTokenComponents.Privacy.newBuilder();
        Boolean isAgeRestrictedUser = clientSignals.u().getIsAgeRestrictedUser();
        if (isAgeRestrictedUser != null) {
            builderNewBuilder8.setCoppa(isAgeRestrictedUser.booleanValue());
        }
        Boolean isUserConsent = clientSignals.u().getIsUserConsent();
        if (isUserConsent != null) {
            builderNewBuilder8.setGdpr(isUserConsent.booleanValue());
        }
        Boolean isDoNotSell = clientSignals.u().getIsDoNotSell();
        if (isDoNotSell != null) {
            builderNewBuilder8.setCcpa(isDoNotSell.booleanValue());
        }
        String tCFConsent = clientSignals.u().getTCFConsent();
        if (tCFConsent != null) {
            builderNewBuilder8.setTcfConsentString(tCFConsent);
        }
        builderNewBuilder8.setUsPrivacy(clientSignals.u().get_usPrivacy());
        builderNewBuilder.setPrivacy(builderNewBuilder8.build());
        BidToken.ClientBidTokenComponents.Device.Builder builderNewBuilder9 = BidToken.ClientBidTokenComponents.Device.newBuilder();
        builderNewBuilder9.setLanguage(xVarB.s());
        builderNewBuilder9.setOsv(xVarB.x());
        builderNewBuilder9.setMake(xVarB.t());
        builderNewBuilder9.setModel(xVarB.v());
        builderNewBuilder9.setHwv(xVarB.r());
        builderNewBuilder9.setCarrier(xVarB.u());
        builderNewBuilder9.setDevicetype(xVarB.z() ? 5 : 1);
        builderNewBuilder9.setJs(1);
        BidToken.ClientBidTokenComponents.Geo.Builder builderNewBuilder10 = BidToken.ClientBidTokenComponents.Geo.newBuilder();
        builderNewBuilder10.setUtcoffset(TimeZone.getDefault().getOffset(new Date().getTime()) / 60000);
        builderNewBuilder9.setGeo(builderNewBuilder10.build());
        builderNewBuilder9.setW(eA.n());
        builderNewBuilder9.setH(eA.l());
        builderNewBuilder9.setPxratio(eA.i());
        builderNewBuilder9.setPpi(eA.j());
        builderNewBuilder9.setOs(xVarB.w());
        if (bidTokenConfig.b()) {
            builderNewBuilder9.setDbt(a(xVarB.p()));
        }
        H hF = clientSignals.q().f();
        if (hF != null) {
            builderNewBuilder9.setOrtn(a(hF));
        }
        Boolean boolA = this.b.a();
        if (boolA != null) {
            builderNewBuilder9.setHasGy(boolA.booleanValue());
        }
        String strD = clientSignals.q().d();
        if (strD != null) {
            builderNewBuilder9.setKbLoc(strD);
        }
        String strE = clientSignals.q().e();
        if (strE != null) {
            builderNewBuilder9.setLocale(strE);
        }
        builderNewBuilder9.setXdpi(eA.o());
        builderNewBuilder9.setYdpi(eA.p());
        builderNewBuilder9.setHardware(xVarB.q());
        builderNewBuilder9.setBrand(xVarB.o());
        builderNewBuilder.setDevice(builderNewBuilder9.build());
        BidToken.ClientBidTokenComponents.AudioInfo.Builder builderNewBuilder11 = BidToken.ClientBidTokenComponents.AudioInfo.newBuilder();
        com.moloco.sdk.internal.services.z zVarD = clientSignals.o().d();
        if (zVarD != null) {
            builderNewBuilder11.setMuteSwitch(a(zVarD));
        }
        Integer numC = clientSignals.o().c();
        if (numC != null) {
            builderNewBuilder11.setVol(numC.intValue());
        }
        builderNewBuilder.setAudioInfo(builderNewBuilder11.build());
        BidToken.ClientBidTokenComponents.AccessibilityInfo.Builder builderNewBuilder12 = BidToken.ClientBidTokenComponents.AccessibilityInfo.newBuilder();
        Float fG = clientSignals.l().g();
        if (fG != null) {
            builderNewBuilder12.setFontScale(fG.floatValue());
        }
        Boolean boolF2 = clientSignals.l().f();
        if (boolF2 != null) {
            builderNewBuilder12.setAccessibilityLargePointerIcon(boolF2.booleanValue());
        }
        Boolean boolE = clientSignals.l().e();
        if (boolE != null) {
            builderNewBuilder12.setAccessibilityCaptioningEnabled(boolE.booleanValue());
        }
        Boolean boolH = clientSignals.l().h();
        if (boolH != null) {
            builderNewBuilder12.setReduceBrightColorsActivated(boolH.booleanValue());
        }
        builderNewBuilder.setAccessibilityInfo(builderNewBuilder12.build());
        if (clientSignals.r().q()) {
            BidToken.ClientBidTokenComponents.ImpLvlRevData.Builder builderNewBuilder13 = BidToken.ClientBidTokenComponents.ImpLvlRevData.newBuilder();
            builderNewBuilder13.setSessionId(clientSignals.r().o());
            builderNewBuilder13.setLastImpTs(clientSignals.r().k());
            builderNewBuilder13.setSessionStartTs(clientSignals.r().p());
            BidToken.ClientBidTokenComponents.ImpLvlRevData.ImpCounts.Builder builderNewBuilder14 = BidToken.ClientBidTokenComponents.ImpLvlRevData.ImpCounts.newBuilder();
            builderNewBuilder14.setBanner(clientSignals.r().i());
            builderNewBuilder14.setMrec(clientSignals.r().l());
            builderNewBuilder14.setNative(clientSignals.r().m());
            builderNewBuilder14.setInterstitial(clientSignals.r().j());
            builderNewBuilder14.setRewarded(clientSignals.r().n());
            builderNewBuilder13.setImpCounts(builderNewBuilder14.build());
            builderNewBuilder.setImpLvlRevData(builderNewBuilder13.build());
        }
        BidToken.ClientBidTokenComponents clientBidTokenComponentsBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(clientBidTokenComponentsBuild, "build(...)");
        return clientBidTokenComponentsBuild;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public BidToken.ClientBidToken a(byte[] payload) throws InvalidProtocolBufferException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        BidToken.ClientBidToken from = BidToken.ClientBidToken.parseFrom(payload);
        Intrinsics.checkNotNullExpressionValue(from, "parseFrom(...)");
        return from;
    }

    public final BidToken.ClientBidTokenComponents.Device.Orientation a(H h) {
        int i = a.f2313a[h.ordinal()];
        if (i == 1) {
            return BidToken.ClientBidTokenComponents.Device.Orientation.UNKNOWN;
        }
        if (i == 2) {
            return BidToken.ClientBidTokenComponents.Device.Orientation.PORTRAIT;
        }
        if (i == 3) {
            return BidToken.ClientBidTokenComponents.Device.Orientation.LANDSCAPE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState a(com.moloco.sdk.internal.services.z zVar) {
        int i = a.b[zVar.ordinal()];
        if (i == 1) {
            return BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState.SILENT;
        }
        if (i == 2) {
            return BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState.VIBRATE;
        }
        if (i == 3) {
            return BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState.NORMAL;
        }
        throw new NoWhenBranchMatchedException();
    }
}
