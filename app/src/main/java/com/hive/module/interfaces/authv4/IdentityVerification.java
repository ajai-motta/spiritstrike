package com.hive.module.interfaces.authv4;

import android.app.Activity;
import androidx.autofill.HintConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.core.Scheme;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0015J\b\u0010\u0002\u001a\u00020\u0003H\u0016JT\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u000328\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00050\nH&J \u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/hive/module/interfaces/authv4/IdentityVerification;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "show", "", "activity", "Landroid/app/Activity;", "authUrl", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lcom/hive/ResultAPI;", "Lkotlin/ParameterName;", "name", "resultApi", "Lcom/hive/module/interfaces/authv4/IdentityVerification$Identity;", "identity", "exchangeSignature", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "(Lcom/hive/standalone/HiveLifecycle$HiveAccount;Lcom/hive/module/interfaces/authv4/IdentityVerification$Identity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Identity", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IdentityVerification extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(IdentityVerification identityVerification) {
            return HiveModuleName.INSTANCE.getAuthV4_Identity_Verification();
        }
    }

    Object exchangeSignature(HiveLifecycle.HiveAccount hiveAccount, Identity identity, Continuation<? super Identity> continuation);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void show(Activity activity, String authUrl, Function2<? super ResultAPI, ? super Identity, Unit> listener);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008b\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\t\u0010>\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019¨\u0006?"}, d2 = {"Lcom/hive/module/interfaces/authv4/IdentityVerification$Identity;", "", "resultCode", "", "resultMsg", "", "scheme", "Lcom/hive/core/Scheme;", "hashedDi", "phoneCode", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "birymd", "dateOfBirth", InAppPurchaseMetaData.KEY_SIGNATURE, "signatureResultCode", "identitySignature", "<init>", "(ILjava/lang/String;Lcom/hive/core/Scheme;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getResultCode", "()I", "setResultCode", "(I)V", "getResultMsg", "()Ljava/lang/String;", "setResultMsg", "(Ljava/lang/String;)V", "getScheme", "()Lcom/hive/core/Scheme;", "setScheme", "(Lcom/hive/core/Scheme;)V", "getHashedDi", "setHashedDi", "getPhoneCode", "setPhoneCode", "getPhoneNumber", "setPhoneNumber", "getBirymd", "setBirymd", "getDateOfBirth", "setDateOfBirth", "getSignature", "setSignature", "getSignatureResultCode", "setSignatureResultCode", "getIdentitySignature", "setIdentitySignature", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Identity {
        private String birymd;
        private String dateOfBirth;
        private String hashedDi;
        private String identitySignature;
        private String phoneCode;
        private String phoneNumber;
        private int resultCode;
        private String resultMsg;
        private Scheme scheme;
        private String signature;
        private String signatureResultCode;

        public Identity(int i, String str, Scheme scheme, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            this.resultCode = i;
            this.resultMsg = str;
            this.scheme = scheme;
            this.hashedDi = str2;
            this.phoneCode = str3;
            this.phoneNumber = str4;
            this.birymd = str5;
            this.dateOfBirth = str6;
            this.signature = str7;
            this.signatureResultCode = str8;
            this.identitySignature = str9;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResultCode() {
            return this.resultCode;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getSignatureResultCode() {
            return this.signatureResultCode;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getIdentitySignature() {
            return this.identitySignature;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getResultMsg() {
            return this.resultMsg;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Scheme getScheme() {
            return this.scheme;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getHashedDi() {
            return this.hashedDi;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getPhoneCode() {
            return this.phoneCode;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getBirymd() {
            return this.birymd;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getDateOfBirth() {
            return this.dateOfBirth;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getSignature() {
            return this.signature;
        }

        public final Identity copy(int resultCode, String resultMsg, Scheme scheme, String hashedDi, String phoneCode, String phoneNumber, String birymd, String dateOfBirth, String signature, String signatureResultCode, String identitySignature) {
            return new Identity(resultCode, resultMsg, scheme, hashedDi, phoneCode, phoneNumber, birymd, dateOfBirth, signature, signatureResultCode, identitySignature);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Identity)) {
                return false;
            }
            Identity identity = (Identity) other;
            return this.resultCode == identity.resultCode && Intrinsics.areEqual(this.resultMsg, identity.resultMsg) && Intrinsics.areEqual(this.scheme, identity.scheme) && Intrinsics.areEqual(this.hashedDi, identity.hashedDi) && Intrinsics.areEqual(this.phoneCode, identity.phoneCode) && Intrinsics.areEqual(this.phoneNumber, identity.phoneNumber) && Intrinsics.areEqual(this.birymd, identity.birymd) && Intrinsics.areEqual(this.dateOfBirth, identity.dateOfBirth) && Intrinsics.areEqual(this.signature, identity.signature) && Intrinsics.areEqual(this.signatureResultCode, identity.signatureResultCode) && Intrinsics.areEqual(this.identitySignature, identity.identitySignature);
        }

        public final String getBirymd() {
            return this.birymd;
        }

        public final String getDateOfBirth() {
            return this.dateOfBirth;
        }

        public final String getHashedDi() {
            return this.hashedDi;
        }

        public final String getIdentitySignature() {
            return this.identitySignature;
        }

        public final String getPhoneCode() {
            return this.phoneCode;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public final String getResultMsg() {
            return this.resultMsg;
        }

        public final Scheme getScheme() {
            return this.scheme;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final String getSignatureResultCode() {
            return this.signatureResultCode;
        }

        public int hashCode() {
            int i = this.resultCode * 31;
            String str = this.resultMsg;
            int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
            Scheme scheme = this.scheme;
            int iHashCode2 = (iHashCode + (scheme == null ? 0 : scheme.hashCode())) * 31;
            String str2 = this.hashedDi;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.phoneCode;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.phoneNumber;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.birymd;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.dateOfBirth;
            int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.signature;
            int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.signatureResultCode;
            int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.identitySignature;
            return iHashCode9 + (str9 != null ? str9.hashCode() : 0);
        }

        public final void setBirymd(String str) {
            this.birymd = str;
        }

        public final void setDateOfBirth(String str) {
            this.dateOfBirth = str;
        }

        public final void setHashedDi(String str) {
            this.hashedDi = str;
        }

        public final void setIdentitySignature(String str) {
            this.identitySignature = str;
        }

        public final void setPhoneCode(String str) {
            this.phoneCode = str;
        }

        public final void setPhoneNumber(String str) {
            this.phoneNumber = str;
        }

        public final void setResultCode(int i) {
            this.resultCode = i;
        }

        public final void setResultMsg(String str) {
            this.resultMsg = str;
        }

        public final void setScheme(Scheme scheme) {
            this.scheme = scheme;
        }

        public final void setSignature(String str) {
            this.signature = str;
        }

        public final void setSignatureResultCode(String str) {
            this.signatureResultCode = str;
        }

        public String toString() {
            return "Identity(resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ", scheme=" + this.scheme + ", hashedDi=" + this.hashedDi + ", phoneCode=" + this.phoneCode + ", phoneNumber=" + this.phoneNumber + ", birymd=" + this.birymd + ", dateOfBirth=" + this.dateOfBirth + ", signature=" + this.signature + ", signatureResultCode=" + this.signatureResultCode + ", identitySignature=" + this.identitySignature + ')';
        }

        public /* synthetic */ Identity(int i, String str, Scheme scheme, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : scheme, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : str6, (i2 & 256) != 0 ? null : str7, (i2 & 512) != 0 ? null : str8, (i2 & 1024) == 0 ? str9 : null);
        }
    }
}
