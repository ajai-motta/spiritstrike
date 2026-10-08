package com.bytedance.adsdk.ud;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.bytedance.adsdk.ud.mzz.ljh;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
public class jpc {
    private static final Map<String, exu<wd>> qdl = new HashMap();
    private static final Set<Object> ud = new HashSet();
    private static final byte[] lnr = {80, 75, 3, 4};

    public static exu<wd> qdl(Context context, String str) {
        return qdl(context, str, "url_".concat(String.valueOf(str)));
    }

    public static exu<wd> qdl(final Context context, final String str, final String str2) {
        return qdl(str2, new Callable<fs<wd>>() { // from class: com.bytedance.adsdk.ud.jpc.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public fs<wd> call() throws Exception {
                fs<wd> fsVarQdl = mzz.qdl(context).qdl(context, str, str2);
                if (str2 != null && fsVarQdl.qdl() != null) {
                    com.bytedance.adsdk.ud.lnr.mzz.qdl().qdl(str2, fsVarQdl.qdl());
                }
                return fsVarQdl;
            }
        });
    }

    public static exu<wd> ud(Context context, String str) {
        return ud(context, str, "asset_".concat(String.valueOf(str)));
    }

    public static exu<wd> ud(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return qdl(str2, new Callable<fs<wd>>() { // from class: com.bytedance.adsdk.ud.jpc.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public fs<wd> call() throws Exception {
                return jpc.lnr(applicationContext, str, str2);
            }
        });
    }

    public static fs<wd> lnr(Context context, String str) {
        return lnr(context, str, "asset_".concat(String.valueOf(str)));
    }

    public static fs<wd> lnr(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return ud(context.getAssets().open(str), str2);
            }
            return qdl(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new fs<>((Throwable) e);
        }
    }

    public static exu<wd> qdl(Context context, int i) {
        return qdl(context, i, lnr(context, i));
    }

    public static exu<wd> qdl(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return qdl(str, new Callable<fs<wd>>() { // from class: com.bytedance.adsdk.ud.jpc.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public fs<wd> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return jpc.ud(context2, i, str);
            }
        });
    }

    public static fs<wd> ud(Context context, int i) {
        return ud(context, i, lnr(context, i));
    }

    public static fs<wd> ud(Context context, int i, String str) {
        try {
            return ud(context.getResources().openRawResource(i), lnr(context, i));
        } catch (Resources.NotFoundException e) {
            return new fs<>((Throwable) e);
        }
    }

    private static String lnr(Context context, int i) {
        StringBuilder sb = new StringBuilder("rawRes");
        sb.append(qdl(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    private static boolean qdl(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static exu<wd> qdl(final InputStream inputStream, final String str) {
        return qdl(str, new Callable<fs<wd>>() { // from class: com.bytedance.adsdk.ud.jpc.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public fs<wd> call() throws Exception {
                return jpc.ud(inputStream, str);
            }
        });
    }

    public static fs<wd> ud(InputStream inputStream, String str) {
        return qdl(inputStream, str, true);
    }

    private static fs<wd> qdl(InputStream inputStream, String str, boolean z) {
        try {
            return qdl(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.bytedance.adsdk.ud.mo.mo.qdl(inputStream);
            }
        }
    }

    public static fs<wd> qdl(JsonReader jsonReader, String str) {
        return qdl(jsonReader, str, true);
    }

    private static fs<wd> qdl(JsonReader jsonReader, String str, boolean z) {
        try {
            try {
                wd wdVarQdl = ljh.qdl(jsonReader);
                com.bytedance.adsdk.ud.lnr.mzz.qdl().qdl(str, wdVarQdl);
                fs<wd> fsVar = new fs<>(wdVarQdl);
                if (z) {
                    qdl(jsonReader);
                }
                return fsVar;
            } catch (Exception e) {
                fs<wd> fsVar2 = new fs<>(e);
                if (z) {
                    qdl(jsonReader);
                }
                return fsVar2;
            }
        } catch (Throwable th) {
            if (z) {
                qdl(jsonReader);
            }
            throw th;
        }
    }

    public static void qdl(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static fs<wd> qdl(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return ud(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.ud.mo.mo.qdl(zipInputStream);
        }
    }

    private static fs<wd> ud(Context context, ZipInputStream zipInputStream, String str) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            wd wdVarQdl = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    wdVarQdl = qdl(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).qdl();
                } else if (name.endsWith(".png") || name.endsWith(".webp") || name.endsWith(".jpg") || name.endsWith(".jpeg")) {
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit = name.split(DomExceptionUtils.SEPARATOR);
                        map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                } else if (name.endsWith(".ttf") || name.endsWith(".otf")) {
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit2 = name.split(DomExceptionUtils.SEPARATOR);
                        String str2 = strArrSplit2[strArrSplit2.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(context.getCacheDir(), str2);
                        new FileOutputStream(file);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int i = zipInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } finally {
                            }
                        } catch (Throwable unused) {
                        }
                        Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                        if (!file.delete()) {
                            file.getAbsolutePath();
                        }
                        map2.put(str3, typefaceCreateFromFile);
                    }
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (wdVarQdl == null) {
                return new fs<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                to toVarQdl = qdl(wdVarQdl, (String) entry.getKey());
                if (toVarQdl != null) {
                    toVarQdl.qdl(com.bytedance.adsdk.ud.mo.mo.qdl((Bitmap) entry.getValue(), toVarQdl.qdl(), toVarQdl.ud()));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                boolean z = false;
                for (com.bytedance.adsdk.ud.lnr.lnr lnrVar : wdVarQdl.bjy().values()) {
                    if (lnrVar.qdl().equals(entry2.getKey())) {
                        lnrVar.qdl((Typeface) entry2.getValue());
                        z = true;
                    }
                }
                if (!z) {
                }
            }
            if (map.isEmpty()) {
                Iterator<Map.Entry<String, to>> it = wdVarQdl.jtx().entrySet().iterator();
                while (it.hasNext()) {
                    to value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String strTvp = value.tvp();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (strTvp.startsWith("data:") && strTvp.indexOf("base64,") > 0) {
                        try {
                            byte[] bArrDecode = Base64.decode(strTvp.substring(strTvp.indexOf(44) + 1), 0);
                            value.qdl(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
                        } catch (IllegalArgumentException unused2) {
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, to> entry3 : wdVarQdl.jtx().entrySet()) {
                if (entry3.getValue().rq() == null) {
                    return new fs<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().tvp()));
                }
            }
            if (str != null) {
                com.bytedance.adsdk.ud.lnr.mzz.qdl().qdl(str, wdVarQdl);
            }
            return new fs<>(wdVarQdl);
        } catch (IOException e) {
            return new fs<>((Throwable) e);
        }
    }

    private static to qdl(wd wdVar, String str) {
        for (to toVar : wdVar.jtx().values()) {
            if (toVar.tvp().equals(str)) {
                return toVar;
            }
        }
        return null;
    }

    private static exu<wd> qdl(final String str, Callable<fs<wd>> callable) {
        final wd wdVarQdl = str == null ? null : com.bytedance.adsdk.ud.lnr.mzz.qdl().qdl(str);
        if (wdVarQdl != null) {
            return new exu<>(new Callable<fs<wd>>() { // from class: com.bytedance.adsdk.ud.jpc.7
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
                public fs<wd> call() throws Exception {
                    return new fs<>(wdVarQdl);
                }
            });
        }
        if (str != null) {
            Map<String, exu<wd>> map = qdl;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        exu<wd> exuVar = new exu<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            exuVar.qdl(new rq<wd>() { // from class: com.bytedance.adsdk.ud.jpc.2
                @Override // com.bytedance.adsdk.ud.rq
                public void qdl(wd wdVar) {
                    jpc.qdl.remove(str);
                    atomicBoolean.set(true);
                    if (jpc.qdl.size() == 0) {
                        jpc.ud(true);
                    }
                }
            });
            exuVar.lnr(new rq<Throwable>() { // from class: com.bytedance.adsdk.ud.jpc.3
                @Override // com.bytedance.adsdk.ud.rq
                public void qdl(Throwable th) {
                    jpc.qdl.remove(str);
                    atomicBoolean.set(true);
                    if (jpc.qdl.size() == 0) {
                        jpc.ud(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, exu<wd>> map2 = qdl;
                map2.put(str, exuVar);
                if (map2.size() == 1) {
                    ud(false);
                }
            }
        }
        return exuVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(boolean z) {
        ArrayList arrayList = new ArrayList(ud);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
