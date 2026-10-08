package com.inca.security.Proxy;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.inca.security.Core.ObjectReflector;
import com.inca.security.DexProtect.Binder;
import com.inca.security.Native.AppGuardPreAssistantNative;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.text.Typography;

/* JADX INFO: compiled from: ra */
/* JADX INFO: loaded from: classes.dex */
public class AppGuardFrontApplication extends Application {
    public static final /* synthetic */ int IDSX_APPGUARDPROXYAPPLICATION = 22;
    public static final /* synthetic */ int IDSX_ATTACH = 17;
    public static final /* synthetic */ int IDSX_MACTIVITYTHREAD = 12;
    public static final /* synthetic */ int IDSX_MALLAPPLICATIONS = 13;
    public static final /* synthetic */ int IDSX_MAPPLICATION = 11;
    public static final /* synthetic */ int IDSX_MINITIALAPPLICATION = 15;
    public static final /* synthetic */ int IDSX_MOUTERCONTEXT = 16;
    public static final /* synthetic */ int IDSX_MPACKAGEINFO = 5;
    public static final /* synthetic */ int IDSX_MULTIDEX = 23;
    public static final /* synthetic */ int IDSX_MULTIDEX_INSTALL = 24;
    private /* synthetic */ Application mainApplication = null;
    private /* synthetic */ Context contextImpl = null;
    private /* synthetic */ boolean changeContext = false;
    private /* synthetic */ byte[] strAppguardProxyApplication = {Ascii.DC4, 75, Ascii.SUB, 10, Ascii.RS, 74, Ascii.DC4, 69, 89, 87, Ascii.DC2, 71, 2, 86, Ascii.RS, 80, Ascii.SO, 10, 39, 86, Ascii.CAN, 92, Ascii.SO, 10, 54, 84, 7, 99, 2, 69, 5, SignedBytes.MAX_POWER_OF_TWO, 39, 86, Ascii.CAN, 92, Ascii.SO, 101, 7, 84, Ascii.ESC, 77, Ascii.DC4, 69, 3, 77, Ascii.CAN, 74};
    private /* synthetic */ byte[] strAttach = {Ascii.SYN, 80, 3, 69, Ascii.DC4, 76};
    private /* synthetic */ byte[] strAppGuardIsolated = {54, 84, 7, 99, 2, 69, 5, SignedBytes.MAX_POWER_OF_TWO, 62, 87, Ascii.CAN, 72, Ascii.SYN, 80, Ascii.DC2, SignedBytes.MAX_POWER_OF_TWO};
    private /* synthetic */ byte[] strmOuterContext = {73, 56, 81, 3, 65, 5, 103, Ascii.CAN, 74, 3, 65, Ascii.SI, 80};
    private /* synthetic */ byte[] strmPackageInfo = {Ascii.SUB, 116, Ascii.SYN, 71, Ascii.FS, 69, Ascii.DLE, 65, 62, 74, 17, 75};
    private /* synthetic */ byte[] strmApplication = {Ascii.SUB, 101, 7, 84, Ascii.ESC, 77, Ascii.DC4, 69, 3, 77, Ascii.CAN, 74};
    private /* synthetic */ byte[] strmActivityThread = {73, 54, 71, 3, 77, 1, 77, 3, 93, 35, 76, 5, 65, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO};
    private /* synthetic */ byte[] strmInitialApplication = {73, 62, 74, Ascii.RS, 80, Ascii.RS, 69, Ascii.ESC, 101, 7, 84, Ascii.ESC, 77, Ascii.DC4, 69, 3, 77, Ascii.CAN, 74};
    private /* synthetic */ byte[] strmAllApplications = {Ascii.SUB, 101, Ascii.ESC, 72, 54, 84, 7, 72, Ascii.RS, 71, Ascii.SYN, 80, Ascii.RS, 75, Ascii.EM, 87};
    private /* synthetic */ byte[] strMultiDex = {69, Ascii.EM, SignedBytes.MAX_POWER_OF_TWO, 5, 75, Ascii.RS, SignedBytes.MAX_POWER_OF_TWO, 89, 87, 2, 84, 7, 75, 5, 80, 89, 73, 2, 72, 3, 77, 19, 65, Ascii.SI, 10, 58, 81, Ascii.ESC, 80, Ascii.RS, 96, Ascii.DC2, 92};
    private /* synthetic */ byte[] strMultiDexInstall = {77, Ascii.EM, 87, 3, 69, Ascii.ESC, 72};

    private /* synthetic */ void handleApplicationContext(boolean z) {
        synchronized (this) {
            try {
                new ObjectReflector(this.contextImpl, decryptStr(16, Boolean.valueOf(z))).set(this.mainApplication);
                Object obj = new ObjectReflector(this.contextImpl, decryptStr(5, Boolean.valueOf(z))).get();
                new ObjectReflector(obj, decryptStr(11, Boolean.valueOf(z))).set(this.mainApplication);
                Object obj2 = new ObjectReflector(obj, decryptStr(12, Boolean.valueOf(z))).get();
                new ObjectReflector(obj2, decryptStr(15, Boolean.valueOf(z))).set(this.mainApplication);
                if (z && !this.changeContext) {
                    ArrayList arrayList = (ArrayList) new ObjectReflector(obj2, decryptStr(13, Boolean.valueOf(z))).get();
                    this.changeContext = true;
                    arrayList.remove(this);
                    arrayList.add(this.mainApplication);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        if (!isIsolatedProcess() || (isIsolatedProcess() && hasIsolatedProcess())) {
            handleBindApplication();
        } else {
            loadLibraryForIsolatedService();
        }
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        try {
            Class.forName(decryptStr(23, false)).getDeclaredMethod(decryptStr(24, false), Context.class).invoke(null, context);
        } catch (Exception unused) {
        }
        super.attachBaseContext(context);
        this.contextImpl = context;
        if (!isIsolatedProcess() || (isIsolatedProcess() && hasIsolatedProcess())) {
            iIiIiIiIii.iIiIIiIiiI(context, context.getClassLoader());
            handleAttachApplication();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        if (isIsolatedProcess() && (!isIsolatedProcess() || !hasIsolatedProcess())) {
            return super.getPackageName();
        }
        if (this.changeContext) {
            return "";
        }
        handleApplicationContext(true);
        return "";
    }

    static {
        try {
            if (Binder.getABI() == 0) {
                System.loadLibrary("compatible");
            }
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private /* synthetic */ void handleBindApplication() {
        try {
            handleApplicationContext(true);
            this.mainApplication.onCreate();
        } catch (Exception unused) {
        }
    }

    private /* synthetic */ void handleAttachApplication() {
        try {
            this.mainApplication = (Application) Class.forName(decryptStrFromJava(new String(this.strAppguardProxyApplication, "UTF-8"))).newInstance();
            handleApplicationContext(false);
            Method declaredMethod = Application.class.getDeclaredMethod(decryptStrFromJava(new String(this.strAttach, "UTF-8")), Context.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.mainApplication, this.contextImpl);
        } catch (Exception unused) {
        }
    }

    private /* synthetic */ boolean isIsolatedProcess() {
        int iMyUid = Process.myUid() % 100000;
        return iMyUid >= 90000 && iMyUid <= 99999;
    }

    private /* synthetic */ boolean hasIsolatedProcess() {
        try {
            return getPackageManager().getApplicationInfo(super.getPackageName(), 128).metaData.getBoolean(new String(this.strAppGuardIsolated, "UTF-8"), false);
        } catch (Exception unused) {
            return false;
        }
    }

    private /* synthetic */ void loadLibraryForIsolatedService() {
        try {
            if (Binder.getABI() == 0) {
                System.loadLibrary("compatible");
            }
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private /* synthetic */ String decryptStrFromJava(String str) {
        int length = str.length();
        int i = length - 1;
        char[] cArr = new char[length];
        while (i >= 0) {
            int i2 = i - 1;
            cArr[i] = (char) (str.charAt(i) ^ Typography.dollar);
            if (i2 < 0) {
                break;
            }
            i = i2 - 1;
            cArr[i2] = (char) (str.charAt(i2) ^ 'w');
        }
        return new String(cArr);
    }

    private /* synthetic */ String decryptStr(int i, Boolean bool) throws Exception {
        byte[] bArr;
        if (bool.booleanValue()) {
            return AppGuardPreAssistantNative.IiIiIiiIII(i);
        }
        byte[] bArr2 = null;
        if (i == 5) {
            bArr = this.strmPackageInfo;
        } else if (i == 15) {
            bArr = this.strmInitialApplication;
        } else if (i == 16) {
            bArr = this.strmOuterContext;
        } else if (i != 23) {
            if (i == 24) {
                bArr2 = this.strMultiDexInstall;
            } else {
                switch (i) {
                    case 11:
                        bArr = this.strmApplication;
                        break;
                    case 12:
                        bArr = this.strmActivityThread;
                        break;
                    case 13:
                        bArr = this.strmAllApplications;
                        break;
                }
            }
            bArr = bArr2;
        } else {
            bArr = this.strMultiDex;
        }
        return decryptStrFromJava(new String(bArr, "UTF-8"));
    }
}
