package com.adxcorp.ads.nativeads.event;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.adxcorp.ads.mediation.util.ClickThroughUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAdClickHandler {
    private final Context mContext;

    public NativeAdClickHandler(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void setOnClickListener(View view, final NativeAdClickListener nativeAdClickListener) {
        setOnClickListener(view, new View.OnClickListener() { // from class: com.adxcorp.ads.nativeads.event.NativeAdClickHandler.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                nativeAdClickListener.handleClick(view2);
            }
        });
    }

    private void setOnClickListener(View view, View.OnClickListener onClickListener) {
        view.setOnClickListener(onClickListener);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                setOnClickListener(viewGroup.getChildAt(i), onClickListener);
            }
        }
    }

    public void clearOnClickListener(View view) {
        setOnClickListener(view, (View.OnClickListener) null);
    }

    public void openClickDestinationUrl(String str, View view) {
        try {
            ClickThroughUtil.goToBrowser(view.getContext(), str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
