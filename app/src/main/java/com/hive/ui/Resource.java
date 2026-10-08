package com.hive.ui;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hive.core.Configuration;
import com.hive.core.FileStorage;
import com.hive.core.HiveContext;
import com.hive.core.Logger;
import com.hive.core.configuration.HiveTheme;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: Resource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ2\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0017j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007`\u00182\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ1\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001b\"\u00020\u0001¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ$\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\nH\u0007J\u0016\u0010\"\u001a\u00020#2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\nJ\u0012\u0010%\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010 J\u0010\u0010%\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-J\u0016\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020)2\u0006\u0010.\u001a\u00020\nJ\u0010\u0010/\u001a\u0004\u0018\u00010-2\u0006\u0010&\u001a\u00020 ¨\u00061"}, d2 = {"Lcom/hive/ui/Resource;", "", "<init>", "()V", "getResourceContext", "Landroid/content/Context;", "getAnimId", "", "context", "name", "", "getDrawableId", "getViewId", "getLayoutId", "getStringId", "getDimenId", "getStyleId", "getHiveStyleId", "childStyle", "getDimensionPixelSize", "getResourceDeclareStyleableIntArray", "", "getResourceDeclareStyleableIntIndexArray", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getString", "obj", "", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "getColorId", "getColor", "openRawResource", "Ljava/io/InputStream;", "defType", "isExistFile", "", "fileName", "readFile", "input", "", "sourceFile", "Ljava/io/File;", "writeFile", "targetFile", "jsonObject", "Lorg/json/JSONObject;", "contents", "readXmlToJSON", "SAXJsonParser", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Resource {
    public static final Resource INSTANCE = new Resource();

    /* JADX INFO: compiled from: Resource.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HiveTheme.values().length];
            try {
                iArr[HiveTheme.HiveLight.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HiveTheme.HiveDark.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final InputStream openRawResource(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return openRawResource$default(this, context, name, null, 4, null);
    }

    private Resource() {
    }

    public final Context getResourceContext() {
        HiveContext.INSTANCE.updateLocale(Configuration.INSTANCE.getGameLanguage());
        return HiveContext.INSTANCE.getResourceContext();
    }

    public final int getAnimId(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return context.getResources().getIdentifier(name, "anim", context.getPackageName());
    }

    public final int getDrawableId(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }

    public final int getViewId(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return context.getResources().getIdentifier(name, "id", context.getPackageName());
    }

    public final int getLayoutId(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return context.getResources().getIdentifier(name, TtmlNode.TAG_LAYOUT, context.getPackageName());
    }

    public final int getStringId(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return context.getResources().getIdentifier(name, TypedValues.Custom.S_STRING, context.getPackageName());
    }

    public final int getDimenId(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return context.getResources().getIdentifier(name, "dimen", context.getPackageName());
    }

    public final int getStyleId(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return context.getResources().getIdentifier(name, "style", context.getPackageName());
    }

    public static /* synthetic */ int getHiveStyleId$default(Resource resource, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return resource.getHiveStyleId(context, str);
    }

    public final int getHiveStyleId(Context context, String childStyle) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        StringBuilder sb = new StringBuilder();
        int i = WhenMappings.$EnumSwitchMapping$0[Configuration.INSTANCE.getHiveTheme().ordinal()];
        if (i == 1) {
            str = "HiveColorLight";
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = "HiveColorDark";
        }
        sb.append(str);
        if (childStyle == null || !(!StringsKt.isBlank(childStyle))) {
            str2 = "";
        } else {
            str2 = "." + childStyle;
        }
        sb.append(str2);
        return context.getResources().getIdentifier(sb.toString(), "style", context.getPackageName());
    }

    public final int getDimensionPixelSize(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return context.getResources().getDimensionPixelSize(getDimenId(context, name));
    }

    public final int[] getResourceDeclareStyleableIntArray(Context context, String name) {
        Iterator it;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            it = ArrayIteratorKt.iterator(Class.forName(context.getPackageName() + ".R$styleable").getFields());
        } catch (Throwable unused) {
        }
        while (it.hasNext()) {
            Field field = (Field) it.next();
            if (Intrinsics.areEqual(field.getName(), name)) {
                Object obj = field.get(null);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
                return (int[]) obj;
            }
            return null;
        }
        return null;
    }

    public final HashMap<String, Integer> getResourceDeclareStyleableIntIndexArray(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        HashMap<String, Integer> map = new HashMap<>();
        try {
            Iterator it = ArrayIteratorKt.iterator(Class.forName(context.getPackageName() + ".R$styleable").getFields());
            while (it.hasNext()) {
                Field field = (Field) it.next();
                if (!Intrinsics.areEqual(field.getName(), name)) {
                    String name2 = field.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    if (StringsKt.startsWith$default(name2, name, false, 2, (Object) null)) {
                        String name3 = field.getName();
                        Object obj = field.get(null);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                        map.put(name3, (Integer) obj);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public final String getString(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getString(getResourceContext(), name);
    }

    public final String getString(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        int stringId = getStringId(context, name);
        if (stringId <= 0) {
            return null;
        }
        return context.getResources().getString(stringId);
    }

    public final String getString(Context context, String name, Object... obj) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(obj, "obj");
        int stringId = getStringId(context, name);
        if (stringId <= 0) {
            return null;
        }
        return context.getResources().getString(stringId, Arrays.copyOf(obj, obj.length));
    }

    public final int getColorId(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return context.getResources().getIdentifier(name, "color", context.getPackageName());
    }

    public final int getColor(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return context.getResources().getColor(getColorId(context, name));
    }

    public static /* synthetic */ InputStream openRawResource$default(Resource resource, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "raw";
        }
        return resource.openRawResource(context, str, str2);
    }

    public final InputStream openRawResource(Context context, String name, String defType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(defType, "defType");
        int identifier = context.getResources().getIdentifier(name, defType, context.getPackageName());
        if (identifier <= 0) {
            return null;
        }
        return context.getResources().openRawResource(identifier);
    }

    public final boolean isExistFile(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return FileStorage.INSTANCE.isExistFile(new File(context.getFilesDir(), fileName));
    }

    public final String readFile(InputStream input) {
        if (input == null) {
            return null;
        }
        try {
            Reader inputStreamReader = new InputStreamReader(input, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                return text;
            } finally {
            }
        } catch (Exception e) {
            Logger.INSTANCE.w("[Resource] readFile \ne: " + e.getMessage());
            return null;
        }
    }

    public final byte[] readFile(File sourceFile) {
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        if (sourceFile.exists()) {
            return FileStorage.INSTANCE.read(sourceFile);
        }
        return null;
    }

    public final boolean writeFile(File targetFile, JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(targetFile, "targetFile");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String string = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return writeFile(targetFile, string);
    }

    public final boolean writeFile(File targetFile, String contents) {
        Intrinsics.checkNotNullParameter(targetFile, "targetFile");
        Intrinsics.checkNotNullParameter(contents, "contents");
        FileStorage fileStorage = FileStorage.INSTANCE;
        byte[] bytes = contents.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return fileStorage.write(targetFile, bytes);
    }

    public final JSONObject readXmlToJSON(InputStream input) {
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
            sAXParserFactoryNewInstance.setNamespaceAware(true);
            SAXParser sAXParserNewSAXParser = sAXParserFactoryNewInstance.newSAXParser();
            SAXJsonParser sAXJsonParser = new SAXJsonParser();
            sAXParserNewSAXParser.parse(input, sAXJsonParser);
            return sAXJsonParser.getJson();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: compiled from: Resource.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J0\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000bj\b\u0012\u0004\u0012\u00020\u0005`\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006*"}, d2 = {"Lcom/hive/ui/Resource$SAXJsonParser;", "Lorg/xml/sax/helpers/DefaultHandler;", "<init>", "()V", "json", "Lorg/json/JSONObject;", "getJson$hive_ui_release", "()Lorg/json/JSONObject;", "setJson$hive_ui_release", "(Lorg/json/JSONObject;)V", "stack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStack$hive_ui_release", "()Ljava/util/ArrayList;", "setStack$hive_ui_release", "(Ljava/util/ArrayList;)V", "attributeName", "", "name", "startDocument", "", "endDocument", "startElement", ShareConstants.MEDIA_URI, "localName", "qName", "attributes", "Lorg/xml/sax/Attributes;", "endElement", "characters", "ch", "", TtmlNode.START, "", "length", "warning", "e", "Lorg/xml/sax/SAXParseException;", "error", "fatalError", k.M, "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class SAXJsonParser extends DefaultHandler {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String TEXTKEY = "_text";
        private JSONObject json = new JSONObject();
        private ArrayList<JSONObject> stack = new ArrayList<>();

        /* JADX INFO: compiled from: Resource.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/ui/Resource$SAXJsonParser$Companion;", "", "<init>", "()V", "TEXTKEY", "", "getTEXTKEY$hive_ui_release", "()Ljava/lang/String;", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String getTEXTKEY$hive_ui_release() {
                return SAXJsonParser.TEXTKEY;
            }
        }

        /* JADX INFO: renamed from: getJson$hive_ui_release, reason: from getter */
        public final JSONObject getJson() {
            return this.json;
        }

        public final void setJson$hive_ui_release(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
            this.json = jSONObject;
        }

        public final ArrayList<JSONObject> getStack$hive_ui_release() {
            return this.stack;
        }

        public final void setStack$hive_ui_release(ArrayList<JSONObject> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.stack = arrayList;
        }

        public final String attributeName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return "@" + name;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            ArrayList<JSONObject> arrayList = new ArrayList<>();
            this.stack = arrayList;
            arrayList.add(0, new JSONObject());
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            JSONObject jSONObjectRemove = this.stack.remove(0);
            Intrinsics.checkNotNullExpressionValue(jSONObjectRemove, "removeAt(...)");
            this.json = jSONObjectRemove;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            JSONObject jSONObject = new JSONObject();
            if (attributes != null) {
                int length = attributes.getLength();
                for (int i = 0; i < length; i++) {
                    String localName2 = attributes.getLocalName(i);
                    Intrinsics.checkNotNull(localName2);
                    try {
                        jSONObject.put(attributeName(localName2), attributes.getValue(i));
                    } catch (JSONException e) {
                        Logger.INSTANCE.w("[Resource] SAXJsonParser.startElement() \ne: " + e.getMessage());
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            this.stack.add(0, jSONObject);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: JSONException -> 0x00a8, TryCatch #0 {JSONException -> 0x00a8, blocks: (B:3:0x000e, B:5:0x0016, B:10:0x0030, B:17:0x0045, B:20:0x004b, B:21:0x004e, B:25:0x0061, B:27:0x0067, B:28:0x006c, B:30:0x007f, B:31:0x0083, B:33:0x008b, B:34:0x0091), top: B:39:0x000e }] */
        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void endElement(java.lang.String r8, java.lang.String r9, java.lang.String r10) throws org.xml.sax.SAXException {
            /*
                r7 = this;
                java.util.ArrayList<org.json.JSONObject> r8 = r7.stack
                r10 = 0
                java.lang.Object r8 = r8.remove(r10)
                java.lang.String r0 = "removeAt(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
                org.json.JSONObject r8 = (org.json.JSONObject) r8
                java.lang.String r0 = com.hive.ui.Resource.SAXJsonParser.TEXTKEY     // Catch: org.json.JSONException -> La8
                boolean r1 = r8.has(r0)     // Catch: org.json.JSONException -> La8
                if (r1 == 0) goto L6c
                java.lang.String r0 = r8.getString(r0)     // Catch: org.json.JSONException -> La8
                java.lang.String r1 = "getString(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: org.json.JSONException -> La8
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: org.json.JSONException -> La8
                int r1 = r0.length()     // Catch: org.json.JSONException -> La8
                r2 = 1
                int r1 = r1 - r2
                r3 = r10
                r4 = r3
            L29:
                if (r3 > r1) goto L4e
                if (r4 != 0) goto L2f
                r5 = r3
                goto L30
            L2f:
                r5 = r1
            L30:
                char r5 = r0.charAt(r5)     // Catch: org.json.JSONException -> La8
                r6 = 32
                int r5 = kotlin.jvm.internal.Intrinsics.compare(r5, r6)     // Catch: org.json.JSONException -> La8
                if (r5 > 0) goto L3e
                r5 = r2
                goto L3f
            L3e:
                r5 = r10
            L3f:
                if (r4 != 0) goto L48
                if (r5 != 0) goto L45
                r4 = r2
                goto L29
            L45:
                int r3 = r3 + 1
                goto L29
            L48:
                if (r5 != 0) goto L4b
                goto L4e
            L4b:
                int r1 = r1 + (-1)
                goto L29
            L4e:
                int r1 = r1 + r2
                java.lang.CharSequence r0 = r0.subSequence(r3, r1)     // Catch: org.json.JSONException -> La8
                java.lang.String r0 = r0.toString()     // Catch: org.json.JSONException -> La8
                int r1 = r8.length()     // Catch: org.json.JSONException -> La8
                if (r1 != r2) goto L5f
                r8 = r0
                goto L6c
            L5f:
                if (r0 == 0) goto L67
                int r0 = r0.length()     // Catch: org.json.JSONException -> La8
                if (r0 != 0) goto L6c
            L67:
                java.lang.String r0 = com.hive.ui.Resource.SAXJsonParser.TEXTKEY     // Catch: org.json.JSONException -> La8
                r8.remove(r0)     // Catch: org.json.JSONException -> La8
            L6c:
                java.util.ArrayList<org.json.JSONObject> r0 = r7.stack     // Catch: org.json.JSONException -> La8
                java.lang.Object r10 = r0.get(r10)     // Catch: org.json.JSONException -> La8
                java.lang.String r0 = "get(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch: org.json.JSONException -> La8
                org.json.JSONObject r10 = (org.json.JSONObject) r10     // Catch: org.json.JSONException -> La8
                boolean r0 = r10.has(r9)     // Catch: org.json.JSONException -> La8
                if (r0 != 0) goto L83
                r10.put(r9, r8)     // Catch: org.json.JSONException -> La8
                goto Lc0
            L83:
                java.lang.Object r0 = r10.get(r9)     // Catch: org.json.JSONException -> La8
                boolean r1 = r0 instanceof org.json.JSONArray     // Catch: org.json.JSONException -> La8
                if (r1 == 0) goto L91
                org.json.JSONArray r0 = (org.json.JSONArray) r0     // Catch: org.json.JSONException -> La8
                r0.put(r8)     // Catch: org.json.JSONException -> La8
                goto Lc0
            L91:
                org.json.JSONArray r1 = new org.json.JSONArray     // Catch: org.json.JSONException -> La8
                r1.<init>()     // Catch: org.json.JSONException -> La8
                r10.put(r9, r1)     // Catch: org.json.JSONException -> La8
                org.json.JSONArray r1 = r10.getJSONArray(r9)     // Catch: org.json.JSONException -> La8
                r1.put(r0)     // Catch: org.json.JSONException -> La8
                org.json.JSONArray r9 = r10.getJSONArray(r9)     // Catch: org.json.JSONException -> La8
                r9.put(r8)     // Catch: org.json.JSONException -> La8
                goto Lc0
            La8:
                r8 = move-exception
                com.hive.core.Logger r9 = com.hive.core.Logger.INSTANCE
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                java.lang.String r0 = "[Resource] SAXJsonParser.endElement() \ne: "
                r10.<init>(r0)
                java.lang.String r8 = r8.getMessage()
                r10.append(r8)
                java.lang.String r8 = r10.toString()
                r9.w(r8)
            Lc0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.ui.Resource.SAXJsonParser.endElement(java.lang.String, java.lang.String, java.lang.String):void");
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] ch, int start, int length) throws SAXException {
            JSONObject jSONObject = this.stack.get(0);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "get(...)");
            JSONObject jSONObject2 = jSONObject;
            try {
                String str = TEXTKEY;
                String string = jSONObject2.has(str) ? jSONObject2.getString(str) : "";
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append(ch != null ? new String(ch, start, length) : null);
                jSONObject2.put(str, sb.toString());
            } catch (JSONException e) {
                Logger.INSTANCE.w("[Resource] SAXJsonParser.characters() \ne: " + e.getMessage());
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
        public void warning(SAXParseException e) throws SAXException {
            Intrinsics.checkNotNullParameter(e, "e");
            System.out.println((Object) ("warning  e=" + e.getMessage()));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
        public void error(SAXParseException e) throws SAXException {
            Intrinsics.checkNotNullParameter(e, "e");
            System.err.println("error  e=" + e.getMessage());
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException e) throws SAXException {
            Intrinsics.checkNotNullParameter(e, "e");
            System.err.println("fatalError  e=" + e.getMessage());
            throw e;
        }
    }
}
