package com.applovin.impl;

import android.util.Xml;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes2.dex */
public class r8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.o f589a;
    private Stack b;
    private StringBuilder c;
    private long d;
    private b e;

    class a implements ContentHandler {
        a() {
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            String strTrim = new String(Arrays.copyOfRange(cArr, i, i2)).trim();
            if (StringUtils.isValidString(strTrim)) {
                r8.this.c.append(strTrim);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - r8.this.d;
            com.applovin.impl.sdk.o unused = r8.this.f589a;
            if (com.applovin.impl.sdk.o.a()) {
                r8.this.f589a.a("XmlParser", "Finished parsing in " + seconds + " seconds");
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            r8 r8Var = r8.this;
            r8Var.e = (b) r8Var.b.pop();
            r8.this.e.d(r8.this.c.toString().trim());
            r8.this.c.setLength(0);
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() {
            com.applovin.impl.sdk.o unused = r8.this.f589a;
            if (com.applovin.impl.sdk.o.a()) {
                r8.this.f589a.a("XmlParser", "Begin parsing...");
            }
            r8.this.d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            try {
                b bVar = !r8.this.b.isEmpty() ? (b) r8.this.b.peek() : null;
                b bVar2 = new b(str2, r8.this.a(attributes), bVar);
                if (bVar != null) {
                    bVar.a(bVar2);
                }
                r8.this.b.push(bVar2);
            } catch (Exception e) {
                com.applovin.impl.sdk.o unused = r8.this.f589a;
                if (com.applovin.impl.sdk.o.a()) {
                    r8.this.f589a.a("XmlParser", "Unable to process element <" + str2 + ">", e);
                }
                throw new SAXException("Failed to start element", e);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) {
        }
    }

    private static class b extends q8 {
        b(String str, Map map, q8 q8Var) {
            super(str, map, q8Var);
        }

        void a(q8 q8Var) {
            if (q8Var == null) {
                throw new IllegalArgumentException("None specified.");
            }
            this.e.add(q8Var);
        }

        void d(String str) {
            this.d = str;
        }
    }

    r8(com.applovin.impl.sdk.k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f589a = kVar.O();
    }

    public static q8 a(String str, com.applovin.impl.sdk.k kVar) {
        return new r8(kVar).a(str);
    }

    public q8 a(String str) throws SAXException {
        if (str != null) {
            this.c = new StringBuilder();
            this.b = new Stack();
            this.e = null;
            Xml.parse(str, new a());
            b bVar = this.e;
            if (bVar != null) {
                return bVar;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map a(Attributes attributes) {
        if (attributes != null) {
            int length = attributes.getLength();
            HashMap map = new HashMap(length);
            for (int i = 0; i < length; i++) {
                map.put(attributes.getQName(i), attributes.getValue(i));
            }
            return map;
        }
        return Collections.emptyMap();
    }
}
