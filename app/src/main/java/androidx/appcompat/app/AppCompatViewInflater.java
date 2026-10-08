package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes10.dex */
public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private final Object[] mConstructorArgs = new Object[2];
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final int[] sOnClickAttrs = {R.attr.onClick};
    private static final int[] sAccessibilityHeading = {R.attr.accessibilityHeading};
    private static final int[] sAccessibilityPaneTitle = {R.attr.accessibilityPaneTitle};
    private static final int[] sScreenReaderFocusable = {R.attr.screenReaderFocusable};
    private static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final SimpleArrayMap<String, Constructor<? extends View>> sConstructorMap = new SimpleArrayMap<>();

    protected View createView(Context context, String name, AttributeSet attrs) {
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    final View createView(View parent, final String name, Context context, AttributeSet attrs, boolean inheritContext, boolean readAndroidTheme, boolean readAppTheme, boolean wrapContext) {
        View viewCreateRatingBar;
        Context context2 = (!inheritContext || parent == null) ? context : parent.getContext();
        if (readAndroidTheme || readAppTheme) {
            context2 = themifyContext(context2, attrs, readAndroidTheme, readAppTheme);
        }
        if (wrapContext) {
            context2 = TintContextWrapper.wrap(context2);
        }
        name.hashCode();
        byte b = -1;
        switch (name.hashCode()) {
            case -1946472170:
                if (name.equals("RatingBar")) {
                    b = 0;
                }
                break;
            case -1455429095:
                if (name.equals("CheckedTextView")) {
                    b = 1;
                }
                break;
            case -1346021293:
                if (name.equals("MultiAutoCompleteTextView")) {
                    b = 2;
                }
                break;
            case -938935918:
                if (name.equals("TextView")) {
                    b = 3;
                }
                break;
            case -937446323:
                if (name.equals("ImageButton")) {
                    b = 4;
                }
                break;
            case -658531749:
                if (name.equals("SeekBar")) {
                    b = 5;
                }
                break;
            case -339785223:
                if (name.equals("Spinner")) {
                    b = 6;
                }
                break;
            case 776382189:
                if (name.equals("RadioButton")) {
                    b = 7;
                }
                break;
            case 799298502:
                if (name.equals("ToggleButton")) {
                    b = 8;
                }
                break;
            case 1125864064:
                if (name.equals("ImageView")) {
                    b = 9;
                }
                break;
            case 1413872058:
                if (name.equals("AutoCompleteTextView")) {
                    b = 10;
                }
                break;
            case 1601505219:
                if (name.equals("CheckBox")) {
                    b = Ascii.VT;
                }
                break;
            case 1666676343:
                if (name.equals("EditText")) {
                    b = Ascii.FF;
                }
                break;
            case 2001146706:
                if (name.equals("Button")) {
                    b = Ascii.CR;
                }
                break;
        }
        switch (b) {
            case 0:
                viewCreateRatingBar = createRatingBar(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 1:
                viewCreateRatingBar = createCheckedTextView(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 2:
                viewCreateRatingBar = createMultiAutoCompleteTextView(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 3:
                viewCreateRatingBar = createTextView(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 4:
                viewCreateRatingBar = createImageButton(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 5:
                viewCreateRatingBar = createSeekBar(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 6:
                viewCreateRatingBar = createSpinner(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 7:
                viewCreateRatingBar = createRadioButton(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 8:
                viewCreateRatingBar = createToggleButton(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 9:
                viewCreateRatingBar = createImageView(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 10:
                viewCreateRatingBar = createAutoCompleteTextView(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 11:
                viewCreateRatingBar = createCheckBox(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 12:
                viewCreateRatingBar = createEditText(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            case 13:
                viewCreateRatingBar = createButton(context2, attrs);
                verifyNotNull(viewCreateRatingBar, name);
                break;
            default:
                viewCreateRatingBar = createView(context2, name, attrs);
                break;
        }
        if (viewCreateRatingBar == null && context != context2) {
            viewCreateRatingBar = createViewFromTag(context2, name, attrs);
        }
        if (viewCreateRatingBar != null) {
            checkOnClickListener(viewCreateRatingBar, attrs);
            backportAccessibilityAttributes(context2, viewCreateRatingBar, attrs);
        }
        return viewCreateRatingBar;
    }

    protected AppCompatTextView createTextView(Context context, AttributeSet attrs) {
        return new AppCompatTextView(context, attrs);
    }

    protected AppCompatImageView createImageView(Context context, AttributeSet attrs) {
        return new AppCompatImageView(context, attrs);
    }

    protected AppCompatButton createButton(Context context, AttributeSet attrs) {
        return new AppCompatButton(context, attrs);
    }

    protected AppCompatEditText createEditText(Context context, AttributeSet attrs) {
        return new AppCompatEditText(context, attrs);
    }

    protected AppCompatSpinner createSpinner(Context context, AttributeSet attrs) {
        return new AppCompatSpinner(context, attrs);
    }

    protected AppCompatImageButton createImageButton(Context context, AttributeSet attrs) {
        return new AppCompatImageButton(context, attrs);
    }

    protected AppCompatCheckBox createCheckBox(Context context, AttributeSet attrs) {
        return new AppCompatCheckBox(context, attrs);
    }

    protected AppCompatRadioButton createRadioButton(Context context, AttributeSet attrs) {
        return new AppCompatRadioButton(context, attrs);
    }

    protected AppCompatCheckedTextView createCheckedTextView(Context context, AttributeSet attrs) {
        return new AppCompatCheckedTextView(context, attrs);
    }

    protected AppCompatAutoCompleteTextView createAutoCompleteTextView(Context context, AttributeSet attrs) {
        return new AppCompatAutoCompleteTextView(context, attrs);
    }

    protected AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context context, AttributeSet attrs) {
        return new AppCompatMultiAutoCompleteTextView(context, attrs);
    }

    protected AppCompatRatingBar createRatingBar(Context context, AttributeSet attrs) {
        return new AppCompatRatingBar(context, attrs);
    }

    protected AppCompatSeekBar createSeekBar(Context context, AttributeSet attrs) {
        return new AppCompatSeekBar(context, attrs);
    }

    protected AppCompatToggleButton createToggleButton(Context context, AttributeSet attrs) {
        return new AppCompatToggleButton(context, attrs);
    }

    private void verifyNotNull(View view, String name) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + name + ">, but returned null");
    }

    private View createViewFromTag(Context context, String name, AttributeSet attrs) {
        if (name.equals("view")) {
            name = attrs.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.mConstructorArgs;
            objArr[0] = context;
            objArr[1] = attrs;
            if (-1 != name.indexOf(46)) {
                return createViewByPrefix(context, name, null);
            }
            int i = 0;
            while (true) {
                String[] strArr = sClassPrefixList;
                if (i >= strArr.length) {
                    return null;
                }
                View viewCreateViewByPrefix = createViewByPrefix(context, name, strArr[i]);
                if (viewCreateViewByPrefix != null) {
                    return viewCreateViewByPrefix;
                }
                i++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.mConstructorArgs;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private void checkOnClickListener(View view, AttributeSet attrs) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && ViewCompat.hasOnClickListeners(view)) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, sOnClickAttrs);
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new DeclaredOnClickListener(view, string));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private View createViewByPrefix(Context context, String name, String prefix) throws InflateException, ClassNotFoundException {
        String str;
        SimpleArrayMap<String, Constructor<? extends View>> simpleArrayMap = sConstructorMap;
        Constructor<? extends View> constructor = simpleArrayMap.get(name);
        if (constructor == null) {
            if (prefix != null) {
                try {
                    str = prefix + name;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str = name;
            }
            constructor = Class.forName(str, false, context.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);
            simpleArrayMap.put(name, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.mConstructorArgs);
    }

    private static Context themifyContext(Context context, AttributeSet attrs, boolean useAndroidTheme, boolean useAppTheme) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, androidx.appcompat.R.styleable.View, 0, 0);
        int resourceId = useAndroidTheme ? typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_android_theme, 0) : 0;
        if (useAppTheme && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_theme, 0)) != 0) {
            Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == resourceId) ? context : new ContextThemeWrapper(context, resourceId) : context;
    }

    private void backportAccessibilityAttributes(Context context, View view, AttributeSet attrs) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, sAccessibilityHeading);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            ViewCompat.setAccessibilityHeading(view, typedArrayObtainStyledAttributes.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attrs, sAccessibilityPaneTitle);
        if (typedArrayObtainStyledAttributes2.hasValue(0)) {
            ViewCompat.setAccessibilityPaneTitle(view, typedArrayObtainStyledAttributes2.getString(0));
        }
        typedArrayObtainStyledAttributes2.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attrs, sScreenReaderFocusable);
        if (typedArrayObtainStyledAttributes3.hasValue(0)) {
            ViewCompat.setScreenReaderFocusable(view, typedArrayObtainStyledAttributes3.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes3.recycle();
    }

    private static class DeclaredOnClickListener implements View.OnClickListener {
        private final View mHostView;
        private final String mMethodName;
        private Context mResolvedContext;
        private Method mResolvedMethod;

        public DeclaredOnClickListener(View hostView, String methodName) {
            this.mHostView = hostView;
            this.mMethodName = methodName;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (this.mResolvedMethod == null) {
                resolveMethod(this.mHostView.getContext());
            }
            try {
                this.mResolvedMethod.invoke(this.mResolvedContext, v);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        private void resolveMethod(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.mMethodName, View.class)) != null) {
                        this.mResolvedMethod = method;
                        this.mResolvedContext = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.mHostView.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + str);
        }
    }
}
