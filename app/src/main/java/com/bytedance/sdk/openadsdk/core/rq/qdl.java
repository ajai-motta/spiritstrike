package com.bytedance.sdk.openadsdk.core.rq;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.core.rq;
import com.bytedance.adsdk.ugeno.qdl;
import com.bytedance.sdk.component.jpc.jpc;
import com.bytedance.sdk.component.mzz.jtx;
import com.bytedance.sdk.component.mzz.to;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.wd;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.fco;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class qdl implements com.bytedance.adsdk.ugeno.qdl {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.rq.qdl$qdl, reason: collision with other inner class name */
    public interface InterfaceC0246qdl {
        void qdl(Drawable drawable);
    }

    @Override // com.bytedance.adsdk.ugeno.qdl
    public void qdl(rq rqVar, String str, ImageView imageView, int i, int i2, qdl.InterfaceC0186qdl interfaceC0186qdl) {
        String strQdl = lnr.qdl(str);
        to toVarLnr = com.bytedance.sdk.openadsdk.tvp.mml.qdl(strQdl).lnr(1);
        qdl(rqVar, toVarLnr, strQdl);
        toVarLnr.qdl(new ud(imageView, this, i, i2), 4);
    }

    private static class ud implements jtx {
        private final int lnr;
        private final int mml;
        private final WeakReference<ImageView> qdl;
        private final qdl ud;

        @Override // com.bytedance.sdk.component.mzz.jtx
        public void qdl(int i, String str, Throwable th) {
        }

        public ud(ImageView imageView, qdl qdlVar, int i, int i2) {
            this.qdl = new WeakReference<>(imageView);
            this.ud = qdlVar;
            this.lnr = i;
            this.mml = i2;
        }

        @Override // com.bytedance.sdk.component.mzz.jtx
        public void qdl(com.bytedance.sdk.component.mzz.rq rqVar) {
            try {
                final ImageView imageView = this.qdl.get();
                if (imageView == null) {
                    return;
                }
                final Object objUd = rqVar.ud();
                if (objUd instanceof Drawable) {
                    fco.qdl((Runnable) new jpc("load_draw_img") { // from class: com.bytedance.sdk.openadsdk.core.rq.qdl.ud.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28) {
                                Object obj = objUd;
                                if (obj instanceof AnimatedImageDrawable) {
                                    ((AnimatedImageDrawable) obj).start();
                                }
                            }
                            imageView.setImageDrawable((Drawable) objUd);
                        }
                    });
                    return;
                }
                if (objUd instanceof byte[]) {
                    if (rqVar.mzz()) {
                        if (Build.VERSION.SDK_INT <= 30) {
                            this.ud.qdl((byte[]) objUd, imageView);
                            return;
                        } else {
                            this.ud.qdl(imageView, (byte[]) objUd, this.lnr, this.mml);
                            return;
                        }
                    }
                    if (this.ud.qdl((byte[]) objUd)) {
                        this.ud.qdl(imageView, (byte[]) objUd, this.lnr, this.mml);
                        return;
                    }
                    final Bitmap bitmapQdl = new com.bytedance.sdk.component.mzz.mml.lnr.ud.ud(this.lnr, this.mml, imageView.getScaleType(), Bitmap.Config.RGB_565, this.lnr, this.mml).qdl((byte[]) objUd);
                    if (bitmapQdl != null) {
                        fco.qdl((Runnable) new jpc("load_static_img") { // from class: com.bytedance.sdk.openadsdk.core.rq.qdl.ud.2
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageBitmap(bitmapQdl);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (objUd instanceof Bitmap) {
                    fco.qdl((Runnable) new jpc("ug_load_bitmap") { // from class: com.bytedance.sdk.openadsdk.core.rq.qdl.ud.3
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageBitmap((Bitmap) objUd);
                        }
                    });
                }
            } catch (Throwable th) {
                aaj.lnr("ImageLoaderProvider", th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(final ImageView imageView, byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                final Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
                if (drawableDecodeDrawable != null) {
                    fco.qdl((Runnable) new jpc("loadAnimatedDrawable") { // from class: com.bytedance.sdk.openadsdk.core.rq.qdl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Drawable drawable = drawableDecodeDrawable;
                            if (drawable instanceof AnimatedImageDrawable) {
                                ((AnimatedImageDrawable) drawable).start();
                            }
                            imageView.setImageDrawable(drawableDecodeDrawable);
                        }
                    });
                    return;
                }
                return;
            } catch (IOException e) {
                aaj.lnr("ImageLoaderProvider", e.getMessage());
                return;
            }
        }
        ud(imageView, bArr, i, i2);
    }

    private void ud(final ImageView imageView, byte[] bArr, int i, int i2) {
        final Bitmap bitmapQdl = new com.bytedance.sdk.component.mzz.mml.lnr.ud.ud(i, i2, imageView.getScaleType(), Bitmap.Config.ARGB_4444, i, i2).qdl(bArr);
        if (bitmapQdl != null) {
            fco.qdl((Runnable) new jpc("loadStaticImage") { // from class: com.bytedance.sdk.openadsdk.core.rq.qdl.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapQdl);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(byte[] bArr, final ImageView imageView) {
        try {
            qdl(bArr, new InterfaceC0246qdl() { // from class: com.bytedance.sdk.openadsdk.core.rq.qdl.3
                @Override // com.bytedance.sdk.openadsdk.core.rq.qdl.InterfaceC0246qdl
                public void qdl(final Drawable drawable) {
                    fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rq.qdl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28) {
                                Drawable drawable2 = drawable;
                                if (drawable2 instanceof AnimatedImageDrawable) {
                                    ((AnimatedImageDrawable) drawable2).start();
                                }
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception e) {
            aaj.lnr("ImageLoaderProvider", e.getMessage());
        }
    }

    private void qdl(final byte[] bArr, final InterfaceC0246qdl interfaceC0246qdl) {
        fco.ud(new jpc("pag_animation_drawable") { // from class: com.bytedance.sdk.openadsdk.core.rq.qdl.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawableUd = qdl.this.ud(bArr);
                InterfaceC0246qdl interfaceC0246qdl2 = interfaceC0246qdl;
                if (interfaceC0246qdl2 != null) {
                    interfaceC0246qdl2.qdl(drawableUd);
                }
            }
        });
    }

    public boolean qdl(byte[] bArr) {
        return com.bytedance.sdk.component.utils.rq.qdl(bArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable ud(byte[] bArr) {
        FileOutputStream fileOutputStream;
        File fileQdl;
        try {
            boolean zLnr = com.bytedance.sdk.openadsdk.multipro.ud.lnr();
            fileQdl = wd.qdl(yt.qdl(), zLnr, zLnr ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileQdl);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            if (Build.VERSION.SDK_INT >= 28) {
                Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(fileQdl));
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                return drawableDecodeDrawable;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(yt.qdl().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            try {
                fileOutputStream.close();
            } catch (Throwable unused2) {
            }
            return bitmapDrawable;
        } catch (Throwable th2) {
            th = th2;
            try {
                aaj.qdl("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th3;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl
    public void qdl(rq rqVar, String str, qdl.InterfaceC0186qdl interfaceC0186qdl) {
        ud(rqVar, lnr.qdl(str), interfaceC0186qdl);
    }

    public void ud(rq rqVar, String str, final qdl.InterfaceC0186qdl interfaceC0186qdl) {
        to toVarLnr = com.bytedance.sdk.openadsdk.tvp.mml.qdl(str).lnr(2);
        qdl(rqVar, toVarLnr, str);
        toVarLnr.qdl(new jtx() { // from class: com.bytedance.sdk.openadsdk.core.rq.qdl.5
            @Override // com.bytedance.sdk.component.mzz.jtx
            public void qdl(com.bytedance.sdk.component.mzz.rq rqVar2) {
                if (rqVar2 == null) {
                    interfaceC0186qdl.qdl(null);
                    return;
                }
                if (interfaceC0186qdl != null) {
                    Object objUd = rqVar2.ud();
                    if (objUd instanceof Bitmap) {
                        interfaceC0186qdl.qdl((Bitmap) objUd);
                        return;
                    }
                    if (rqVar2.ud() instanceof byte[]) {
                        try {
                            interfaceC0186qdl.qdl(BitmapFactory.decodeByteArray((byte[]) rqVar2.ud(), 0, ((byte[]) rqVar2.ud()).length));
                            return;
                        } catch (Throwable unused) {
                        }
                    }
                    interfaceC0186qdl.qdl(null);
                }
            }

            @Override // com.bytedance.sdk.component.mzz.jtx
            public void qdl(int i, String str2, Throwable th) {
                qdl.InterfaceC0186qdl interfaceC0186qdl2 = interfaceC0186qdl;
                if (interfaceC0186qdl2 != null) {
                    interfaceC0186qdl2.qdl(null);
                }
            }
        }, 4);
    }

    private void qdl(rq rqVar, to toVar, String str) {
        Map<String, Object> mapUd;
        if (rqVar == null || (mapUd = rqVar.ud()) == null) {
            return;
        }
        Object obj = mapUd.get("image_info");
        if (obj instanceof Map) {
            toVar.qdl((String) ((Map) obj).get(str));
        }
        String str2 = (String) mapUd.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        toVar.ud(str2);
    }
}
