package com.bytedance.sdk.component.wd.ud;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.bytedance.sdk.component.ud.qdl.bjy;
import com.bytedance.sdk.component.ud.qdl.exu;
import com.bytedance.sdk.component.ud.qdl.fs;
import com.bytedance.sdk.component.ud.qdl.mo;
import com.bytedance.sdk.component.ud.qdl.rdp;
import com.bytedance.sdk.component.ud.qdl.rq;
import com.bytedance.sdk.component.ud.qdl.tvp;
import com.google.android.exoplayer2.PlaybackException;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mml extends lnr {
    exu qdl;

    public mml(rq rqVar) {
        super(rqVar);
        this.qdl = null;
    }

    public void mml(String str) {
        if (TextUtils.isEmpty(str)) {
            str = JsonUtils.EMPTY_JSON;
        }
        this.qdl = exu.qdl(tvp.qdl("application/json; charset=utf-8"), str);
    }

    public void qdl(JSONObject jSONObject) {
        String string;
        if (jSONObject == null) {
            string = JsonUtils.EMPTY_JSON;
        } else {
            string = jSONObject.toString();
        }
        this.qdl = exu.qdl(tvp.qdl("application/json; charset=utf-8"), string);
    }

    public void qdl(String str, byte[] bArr) {
        this.qdl = exu.qdl(tvp.qdl(str), bArr);
    }

    public void qdl(final com.bytedance.sdk.component.wd.qdl.qdl qdlVar) {
        try {
            fs.qdl qdlVar2 = new fs.qdl();
            if (TextUtils.isEmpty(this.jpc)) {
                qdlVar.qdl(this, new IOException("Url is Empty"));
                return;
            }
            if (!TextUtils.isEmpty(this.mzz)) {
                qdlVar2.qdl(this.mzz);
            }
            if (this.mo > 0) {
                qdlVar2.qdl(this.mo);
            }
            qdlVar2.ud(this.jpc);
            if (this.qdl == null) {
                if (qdlVar != null) {
                    qdlVar.qdl(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                qdl(qdlVar2);
                qdlVar2.qdl((Object) lnr());
                this.lnr.qdl(qdlVar2.qdl(this.qdl).ud()).qdl(new com.bytedance.sdk.component.ud.qdl.lnr() { // from class: com.bytedance.sdk.component.wd.ud.mml.1
                    @Override // com.bytedance.sdk.component.ud.qdl.lnr
                    public void qdl(com.bytedance.sdk.component.ud.qdl.ud udVar, IOException iOException) {
                        com.bytedance.sdk.component.wd.qdl.qdl qdlVar3 = qdlVar;
                        if (qdlVar3 != null) {
                            qdlVar3.qdl(mml.this, iOException);
                        }
                    }

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
                    @Override // com.bytedance.sdk.component.ud.qdl.lnr
                    public void qdl(com.bytedance.sdk.component.ud.qdl.ud udVar, rdp rdpVar) throws IOException {
                        com.bytedance.sdk.component.wd.ud udVar2;
                        String strUd;
                        String lowerCase;
                        com.bytedance.sdk.component.wd.qdl.qdl qdlVar3 = qdlVar;
                        if (qdlVar3 != null) {
                            if (rdpVar == null) {
                                qdlVar3.qdl(mml.this, new IOException("No response"));
                                return;
                            }
                            com.bytedance.sdk.component.wd.ud udVar3 = null;
                            IOException iOException = null;
                            try {
                                HashMap map = new HashMap();
                                mo moVarWd = rdpVar.wd();
                                if (moVarWd != null) {
                                    for (int i = 0; i < moVarWd.qdl(); i++) {
                                        String strQdl = moVarWd.qdl(i);
                                        String strUd2 = moVarWd.ud(i);
                                        map.put(strQdl, strUd2);
                                        if (strQdl != null && strQdl.equalsIgnoreCase("content-type")) {
                                            if (strUd2 == null) {
                                                lowerCase = "";
                                            } else {
                                                lowerCase = strUd2.toLowerCase();
                                            }
                                            map.put("content-type", lowerCase);
                                        }
                                    }
                                }
                                bjy bjyVarMo = rdpVar.mo();
                                if (com.bytedance.sdk.component.wd.lnr.qdl.qdl(map)) {
                                    byte[] bArrMml = bjyVarMo.mml();
                                    udVar2 = new com.bytedance.sdk.component.wd.ud(rdpVar.mml(), rdpVar.lnr(), rdpVar.mzz(), map, null, rdpVar.ud(), rdpVar.qdl());
                                    try {
                                        udVar2.qdl(bArrMml);
                                    } catch (Throwable th) {
                                        th = th;
                                        udVar3 = udVar2;
                                        udVar2 = udVar3;
                                        iOException = new IOException(th);
                                    }
                                } else if (mml.this.tvp) {
                                    byte[] bArrMml2 = bjyVarMo.mml();
                                    mml mmlVar = mml.this;
                                    com.bytedance.sdk.component.wd.ud udVar4 = new com.bytedance.sdk.component.wd.ud(rdpVar.mml(), rdpVar.lnr(), rdpVar.mzz(), map, new String(bArrMml2, mmlVar.qdl(mmlVar.qdl(bjyVarMo))), rdpVar.ud(), rdpVar.qdl());
                                    try {
                                        udVar4.qdl(bArrMml2);
                                        udVar2 = udVar4;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        udVar3 = udVar4;
                                        udVar2 = udVar3;
                                        iOException = new IOException(th);
                                    }
                                } else {
                                    if (bjyVarMo == null) {
                                        throw new IOException(rdpVar.mzz());
                                    }
                                    boolean zMml = rdpVar.mml();
                                    int iLnr = rdpVar.lnr();
                                    String strMzz = rdpVar.mzz();
                                    if (bjyVarMo == null) {
                                        strUd = "";
                                    } else {
                                        strUd = bjyVarMo.ud();
                                    }
                                    udVar2 = new com.bytedance.sdk.component.wd.ud(zMml, iLnr, strMzz, map, strUd, rdpVar.ud(), rdpVar.qdl());
                                }
                                mml.this.qdl(udVar2, rdpVar);
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            if (udVar2 != null) {
                                qdlVar.qdl(mml.this, udVar2);
                                return;
                            }
                            com.bytedance.sdk.component.wd.qdl.qdl qdlVar4 = qdlVar;
                            if (qdlVar4 instanceof com.bytedance.sdk.component.wd.qdl.ud) {
                                com.bytedance.sdk.component.wd.qdl.ud udVar5 = (com.bytedance.sdk.component.wd.qdl.ud) qdlVar4;
                                mml mmlVar2 = mml.this;
                                if (iOException == null) {
                                    iOException = new IOException("Unexpected exception");
                                }
                                udVar5.qdl(mmlVar2, iOException, new com.bytedance.sdk.component.wd.ud(rdpVar.mml(), rdpVar.lnr(), rdpVar.mzz(), null, null, rdpVar.ud(), rdpVar.qdl()));
                                return;
                            }
                            mml mmlVar3 = mml.this;
                            if (iOException == null) {
                                iOException = new IOException("Unexpected exception");
                            }
                            qdlVar4.qdl(mmlVar3, iOException);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            qdlVar.qdl(this, new IOException(th.getMessage()));
        }
    }

    public com.bytedance.sdk.component.wd.ud qdl() {
        com.bytedance.sdk.component.wd.ud udVar;
        String strUd;
        String lowerCase;
        try {
            fs.qdl qdlVar = new fs.qdl();
            if (TextUtils.isEmpty(this.jpc)) {
                return new com.bytedance.sdk.component.wd.ud(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            qdlVar.ud(this.jpc);
            if (this.qdl == null) {
                return new com.bytedance.sdk.component.wd.ud(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            qdl(qdlVar);
            qdlVar.qdl((Object) lnr());
            rdp rdpVarUd = this.lnr.qdl(qdlVar.qdl(this.qdl).ud()).ud();
            if (rdpVarUd == null) {
                return null;
            }
            HashMap map = new HashMap();
            mo moVarWd = rdpVarUd.wd();
            if (moVarWd != null) {
                for (int i = 0; i < moVarWd.qdl(); i++) {
                    String strQdl = moVarWd.qdl(i);
                    String strUd2 = moVarWd.ud(i);
                    map.put(strQdl, strUd2);
                    if (strQdl != null && strQdl.equalsIgnoreCase("content-type")) {
                        if (strUd2 == null) {
                            lowerCase = "";
                        } else {
                            lowerCase = strUd2.toLowerCase();
                        }
                        map.put("content-type", lowerCase);
                    }
                }
            }
            bjy bjyVarMo = rdpVarUd.mo();
            if (com.bytedance.sdk.component.wd.lnr.qdl.qdl(map)) {
                byte[] bArrMml = bjyVarMo.mml();
                udVar = new com.bytedance.sdk.component.wd.ud(rdpVarUd.mml(), rdpVarUd.lnr(), rdpVarUd.mzz(), map, null, rdpVarUd.ud(), rdpVarUd.qdl());
                udVar.qdl(bArrMml);
            } else if (this.tvp) {
                byte[] bArrMml2 = bjyVarMo.mml();
                com.bytedance.sdk.component.wd.ud udVar2 = new com.bytedance.sdk.component.wd.ud(rdpVarUd.mml(), rdpVarUd.lnr(), rdpVarUd.mzz(), map, new String(bArrMml2, qdl(qdl(bjyVarMo))), rdpVarUd.ud(), rdpVarUd.qdl());
                udVar2.qdl(bArrMml2);
                udVar = udVar2;
            } else {
                if (bjyVarMo == null) {
                    throw new IOException(rdpVarUd.mzz());
                }
                boolean zMml = rdpVarUd.mml();
                int iLnr = rdpVarUd.lnr();
                String strMzz = rdpVarUd.mzz();
                if (bjyVarMo == null) {
                    strUd = "";
                } else {
                    strUd = bjyVarMo.ud();
                }
                udVar = new com.bytedance.sdk.component.wd.ud(zMml, iLnr, strMzz, map, strUd, rdpVarUd.ud(), rdpVarUd.qdl());
            }
            qdl(udVar, rdpVarUd);
            return udVar;
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.wd.ud(false, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    public void qdl(String str, boolean z) {
        if (z) {
            qdl("application/json; charset=utf-8", mzz(str));
            ud(HttpHeaders.CONTENT_ENCODING, "gzip");
        } else {
            mml(str);
        }
    }

    private byte[] mzz(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] byteArray = new byte[0];
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(str.getBytes("utf-8"));
                    try {
                        gZIPOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (IOException unused5) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused7) {
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused8) {
        }
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset qdl(tvp tvpVar) {
        try {
            return tvpVar != null ? tvpVar.qdl(com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl) : com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.ud.qdl.ud.tvp.qdl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public tvp qdl(bjy bjyVar) {
        try {
            return bjyVar.mzz();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(com.bytedance.sdk.component.wd.ud udVar, rdp rdpVar) {
        if (udVar == null || rdpVar == null) {
            return;
        }
        udVar.qdl(rdpVar.jpc());
    }
}
