package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
class LayoutIncludeDetector {
    private final Deque<WeakReference<XmlPullParser>> mXmlParserStack = new ArrayDeque();

    LayoutIncludeDetector() {
    }

    boolean detect(AttributeSet attrs) {
        if (!(attrs instanceof XmlPullParser)) {
            return false;
        }
        XmlPullParser xmlPullParser = (XmlPullParser) attrs;
        if (xmlPullParser.getDepth() != 1) {
            return false;
        }
        XmlPullParser xmlPullParserPopOutdatedAttrHolders = popOutdatedAttrHolders(this.mXmlParserStack);
        this.mXmlParserStack.push(new WeakReference<>(xmlPullParser));
        return shouldInheritContext(xmlPullParser, xmlPullParserPopOutdatedAttrHolders);
    }

    private static boolean shouldInheritContext(XmlPullParser parser, XmlPullParser previousParser) {
        if (previousParser == null || parser == previousParser) {
            return false;
        }
        try {
            if (previousParser.getEventType() == 2) {
                return "include".equals(previousParser.getName());
            }
            return false;
        } catch (XmlPullParserException unused) {
            return false;
        }
    }

    private static XmlPullParser popOutdatedAttrHolders(Deque<WeakReference<XmlPullParser>> xmlParserStack) {
        while (!xmlParserStack.isEmpty()) {
            XmlPullParser xmlPullParser = xmlParserStack.peek().get();
            if (!isParserOutdated(xmlPullParser)) {
                return xmlPullParser;
            }
            xmlParserStack.pop();
        }
        return null;
    }

    private static boolean isParserOutdated(XmlPullParser parser) {
        if (parser == null) {
            return true;
        }
        try {
            if (parser.getEventType() != 3) {
                return parser.getEventType() == 1;
            }
            return true;
        } catch (XmlPullParserException unused) {
            return true;
        }
    }
}
