package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1245Gc implements InterfaceC1533Rk {
    public static String[] A01 = {"EbGpmssVJ7ns5QL3Rl3UMQ1bkFVQ99jJ", "NZiaRg2dkcqShBYEYgfcfS6cvloj595L", "orBeTHrcfmlzSHmkgrBC5PhD7dWIdW6R", "A0QUoJlw", "r5xapKwo2g0pU1r2itXQ9K5SrPer64wf", "XFka6Ze1I6IepT0r6LvaraMv7MRENHMC", "Xj0im9L41l0kDU7dj2M6tiOB0nkMWcds", "VCdvqSH1BrwZZsOdC7BZghv3f2EYDVkv"};
    public final /* synthetic */ C09744x A00;

    public C1245Gc(C09744x c09744x) {
        this.A00 = c09744x;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1533Rk
    public final boolean AAI() {
        if (this.A00.A06.get()) {
            boolean zA0l = this.A00.A0l();
            String[] strArr = A01;
            if (strArr[1].charAt(8) == strArr[2].charAt(8)) {
                throw new RuntimeException();
            }
            A01[0] = "O5SuZCLVdBOcw9avK46kWbT1hYIehzyg";
            if (!zA0l) {
                return false;
            }
        }
        return true;
    }
}
