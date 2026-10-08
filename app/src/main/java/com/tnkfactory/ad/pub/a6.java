package com.tnkfactory.ad.pub;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: classes6.dex */
public final class a6 extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f3108a;
    public final ToggleButton b;
    public int c;
    public float d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public x5 l;

    public a6(Context context, int i) {
        super(context);
        this.c = -1;
        this.d = 0.0f;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = null;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        WebView webView = new WebView(getContext());
        this.f3108a = webView;
        webView.setLayoutParams(layoutParams);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(2);
        webView.setFocusable(false);
        webView.addJavascriptInterface(new z5(this), h1.a("ff7714a2fc53945bff7e7d462cdb27b98edd06"));
        webView.setWebChromeClient(new u5());
        addView(webView);
        int iApplyDimension = (int) TypedValue.applyDimension(1, 20.0f, getContext().getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iApplyDimension, iApplyDimension);
        if ((i & 1) == 0) {
            layoutParams2.addRule(11);
        } else {
            layoutParams2.addRule(9);
        }
        if ((i & 2) == 0) {
            layoutParams2.addRule(10);
        } else {
            layoutParams2.addRule(12);
        }
        int i2 = iApplyDimension / 4;
        layoutParams2.rightMargin = i2;
        layoutParams2.topMargin = i2;
        layoutParams2.leftMargin = i2;
        layoutParams2.bottomMargin = i2;
        ToggleButton toggleButton = new ToggleButton(getContext());
        this.b = toggleButton;
        toggleButton.setLayoutParams(layoutParams2);
        toggleButton.setText((CharSequence) null);
        toggleButton.setTextOn(null);
        toggleButton.setTextOff(null);
        toggleButton.setBackgroundResource(R.drawable.btn_video_volume);
        addView(toggleButton);
        toggleButton.setOnClickListener(new v5(this));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        setLifeCycle(i);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        setLifeCycle(i);
    }

    public void setAutoStart(boolean z) {
        this.e = z;
    }

    public void setLifeCycle(int i) {
        if (i == 0 && this.c == 2) {
            this.f3108a.post(new w5(this, h1.a("d674008fdf58956efc372d")));
        }
    }

    public void setVideoProgressListener(x5 x5Var) {
        this.l = x5Var;
    }

    public void setYoutubeId(String str) {
        this.f3108a.loadDataWithBaseURL(h1.a("ce6c1586fa0bde24e468730d27f620a49fd80657274ac5"), h1.a("9a3925b9ca65a85bd63f6c5733f56bdad6d21714281ba2c95017f7220cf1bf343008d349bc813ea359389a59ba161a1a2080c5c393b6011e1a8656f70b09c6267b32b6af497ebcfc530bf25876e3b6c07c2a8c49c8426c0e28b254a87157344cd7ed0b45f65243d037121aae2c7df92b997818f1ed208c2bb39eac73511e07416bb2e87020baea721add7a13b251e0b46b3318643bb1eb684484f4117933fd0b43889e3a61f34b3448bc525a8b6cead03068d04c16755d33d1d96d5f7a586d0d0cbb623507b5a8758a7a07633c83bdbe7b97e6b5240df186d650e627fe40aeb4c00e99f99eb909e4717de4f597a5439fb134929cc61d8de77ee2a07ad311332233d7a6947606c350c3d5580528a72b8ed674bf4eb0ba3f9a1c86de2525bdc37615ba2a77e456597eeaed3d954bdb14720d5a954516b5547a4530aa716ebbed067c23124841d5b69d64ccf7277130a164bbf2dbcd2105e0447c74075a4b1a0b339bab0e76c37af2c5c1db1ca7ddf5848dd4276cb93fa1dd0730e2b0cb0b9814cb9b66dbb242b8062b3ef84e90e43c719de5786a75c0fe2def950b17aba8b0a1e73883c5bbc3b2c8785a1479452b49bbaed0f30221727a598aab888c5f5a1eddb58abc6544b33684d9816301f48c578a2ebe8dd714958a97dd857adecb6925e016861072332d868ff6b079605ae6781d2d73ed0901b2357fa1ca2ef46e5edbf0e90d12e170b109c6ad048ce528fc00461d88310ecf110c446bcf2590da7e9d6dc403b8c6e64e27efcd7d6a5961f3c6359f3d2ad91b73d18a6c8fddfa7db5c8a6e78d9ab727a76bbfd5f28632dad6e5b88e75001f888cb2750fff230a6b636817f5018b8d71c423257644f3ba18300c6a6af25a8c65040a221cbd692e61f523e74ec16e4d8252fe199b8229b13b324d9ffa2871425b896837c896e5a8ddaf7a33ff0bfa7792bf18984e279f6268f531f22cf16472207a9378fdce4d57803ab84a85445bb927d2a976cb0e46a3b8a588b9222246dd09c8458a7abecadd32f4832851d0096b8a3095daae59943cef695deb66c9ed41d2f23a1a950ba9ed3310b3a09a0ca4898a477578faebcbe223eef7d9a5b9035f32ec0e514e5f668d4e97ae491be4e95d9ab16252204d170841423bc070281145a65050c716ce88efeb1e494b894f3f6ec414b3a5604dee4d9c1495db28f54f996049453ad27d64b5bdc57f8a4e3f72869ad7b81b9052664556994f477d8a7e7de6bf1476043ec5e10cf9452f1e1d02c0ab7926958cfe79f0086fdcef192dfff8ac458a59d256d73088fec967a725c46a737a0801fcf107a1f09e1d236d2f16a372ce2a8a28459735aa599b28f3d401b2c79763878285273025df8896955969c4fcd870e6e6b6dadf065fc305b5d05e45451cd8afc49011758f1b8794a939b6a5947f528045c8b93e03c8252dd4b1852850de88e1e8ff89932b231044a25cb76938abfcc01218ed877973e618a2f3a9f4b05a1a0494034abf7950525b8c9c39edfd956fdfc9d4cd819d0d1a3bb5ae5535415f4d28a125d42a2c77ea6a9b0ad270225ca6839a28c6fc28be203bf853f394f7855ab7af03b91a326e127753175a355ddcfad0f9680bc77a4a1443ca4b58809165f804e12a272c77bac4e5bc706651d145e41c82a41ebaa52901e12410fceef63e4cc3ed37047692a40be6594e62a5acbafd3d8e98fc38ea9c0711246f5e648d0b8f59816c0c0be4bd430dbfe32062aaeffac4c9ff313770845e16a89ba5aedabafaf4c9e33cc65e58ab2d1a1464aa18776dc3a06a2bcfcd238fa154c915f1b41d806119f6cce60c74d6bf45749e51a78bcf356b39736069d00da09677d3a9a7af79358d7ade6aa4acc664397dd8141f1bbcdb6d716171c80c670b842f8b5a63e48fe5f8b1065b839fd6d37d7f3907520751e1d5ad4c9796a6acbba727b9cd35f69e8d3b35c8f12507fbec2d8036e528742bc7f48770173f04c5955952428c625a2ed99dfecd1e34f69ca61bb83f6a991ccb9c6b59d13eb7dea36350d85b5c92458f181de9bbf5d3be4d55e18995f92d071eb7065f4c299b3ade7f49cda40c6b9f40f8f652a33570ebb90096a15804ba9117095e2fddad3c220180190c647b720bc9e6533c35a0e25124ec8df6602fbbd526a60e6391debcdc534ee1f291d56fb6ea991fbc68738472bf045dffced122b9c29e74cb31541ef4ca8d0ab255ca79408b7b0f14d641b0a606593e3feb6bd1d77d058b2f57ac6a1ab79665df03e4a2af221eb06e9b4024740e0b6dd328fc68906586923dce497e924eb4ca2637da744693130d0d40f29d4529dc78763baa0c7d4be693fe6b9ebf671bf1412ff59c8fd44beb80dd4348c02720d3a88ccc82b4468a6ba0f1bc42241848a44caaf46bd962ee04671a0945c2e433b4c6681d04442019d2ec4ef01ab83688ab5d4c60b24e51080486e2306d2d45b880f29fb5d4bc3b7b68e1a51e0d498abc2a478fc838639535740ba29aa4e3a8b571660f875544d74d16a2a9170226b866c2879c9f6fa6e109afd1d31e3a82f0c64b1f3287802f76e05c7019c65602179faefe19cfab8f8c31d79648192bc0cacfefb238c7ceb187646f4e9834a2f0f97d6b3022afef69c1cf49e1285ce514607018a434e4baa3ebf5317043b804e043aab05ec4a9188f6349e009ae9f7b9c89056b96c1c644676bb8068b876b14e7e2c4f102964554d69132ed80b891ae5fe7911383faae1d59b907b78bd137e7137093e8900e89533622cd731614b15132d34acfb38538144ad38797cdac9f09a304803f876c58f52afddf7bb1c4429701c24ca6da86dffdb9daf8dfca0d071fb4be0a05eaaf021bd43b4919ae0dde47f9d3c006e885d479017d2e8073a6f14e0e76a88564e515743ba1d092ba20ee7c57515442eb4117a3085765868fa038126249c530680c90d219e507e1c4879d9155898e7d33fb921a0a5b694f3eaea4a5207d396b7793f8c2061d3d1aa9ee74b70c0da0ca484b7996ca4c36fe69e5f5bc79e92b42ae9ff519831a79050e9c3dce040300b2b39784e652bf640a8674ab47578eff9afde6d940b41d88eece3ed78ffcc11331cedc5d8161de8920e149346c10932e62988f2a9d0d40a1f6619576b1a179c083908ffa3d135bbde993ae669bf9d48168527d067078046b32c9a06429e77013f506c5b0f71f46a4892f854a8456066dc1c2c22d51262b430500be3ec14abbe732e75e29b35225c013c70b1ca8c9abe75a60f93c2e0a5c21db03649a8f2b7b43333f1a1a0d91d806e8ad78c13afad022213d93d0bcf75a46e875ec583fa57b4f77a4a016630c1e29b65a3c74e14155d0c4186c9a74eef376796ac4b4d1ef7dea11f96a190ad5c3aa9f95a9e38105cb46fac4e16c7331d197285156df734ecad7aa4c7f66c9f4853b7026dab65cd159d7fdf85d0c84c74989c133eb4496f30cded546f9d2302096473d6a57ea0ed667ad317baf62a5aa68d581f6dc1f84a1f507779cba10a273c8d9eefd2650bd757d5ce160d34522e9ec099b48ea048143d73f1814cef5022d649892e8d70918de5ad1e36251d86d3379c666e105946d638b73cb484800e06516d1ef089975e2db24efff8e05355770c237d0808039db5a01e3d20eac3f2d746fe1a20dabf36d41e1e60f192d49dbca137648f8ba1b0e6c1c01c138fc5c49ee2127598b20bad0c5cd19ea0120cf3ed065aafea9955fdff0a20bfb4208d32dd6d7cf87ed4c49c417fecf78acd41ee68514a69e50d1c2176e7093d59ed9c0df6d16a2f43c9b570cc5402cc0328669331f07e3fe399148c2748487d6f9049b39754b2edb477ee9746aef93a9d8815d647537101ecadd417c508c758c461d1bfd85d40f1ee1974b54e166ad53146e3f2860a64a17a7f2cac5ac67f584a7e9b43286f978cec236a27e8652b7a8918a01b2fbc3f4c59fa4345e9913162b9844c15800d6b3e4194d1219503804de2d84aad64343d08f19f711381d0281cf0ba61318f89f57b58e7c9e159580427ad0f548a042ed510d8434d5993d166f3874c6799992c29349ece0dedd2958fca9ea6787af6fa99ee274464f575eb1dea1e172504c83e1ef998d85690f635f81017402fa0c3c216255f554d13da0f5fcc65c4a086252ddeb49978f951b66ffbeb47140aff4736c9fd3561c5007e4e7c145a36ae2a64e3cd886bf83e728ba33db753026cd68fd9dc0ab2c77898dd0c5b2b646a1d8177bacf00c18ef5a5c8e0f721d2a718b3eea5c2aa09471079ebb25edabf287fbec90d62b77f2c739431e48630763bc54b2d4d277482c142834aac58b9e804b398f54cc33bb9bdeb65a68fd4259dbb5338ca2a99afcc3cd64a2ffd7ef3f3fa2e791e6208d97b7ed69fa176fca20d2df568a748e130720a6d2bf13db70ea877b909bc8b063df36e4c032befc603fc95119").replace("<<injectedVideoId>>", str), "text/html", "utf-8", null);
    }
}
