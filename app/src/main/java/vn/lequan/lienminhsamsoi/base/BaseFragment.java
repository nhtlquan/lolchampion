package vn.lequan.lienminhsamsoi.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.NativeExpressAdView;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.model.Language;
import vn.lequan.lienminhsamsoi.ultis.Const;

public abstract class BaseFragment extends Fragment {
    public String CHAMP_ID;
    public AccessToken accessToken = AccessToken.getCurrentAccessToken();
    ActionInterface actionInterface;
    public Activity activity;
    BroadcastReceiver broadcastReceiver;
    public Language language;
    private NativeExpressAdView mAdView;
    public Profile profile = Profile.getCurrentProfile();

    public abstract int getLayoutId();

    public abstract void initAction();

    public abstract void initData();

    public abstract void initView(View view);

    public void initAds() {
        this.mAdView.loadAd(new Builder().build());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        } else {
            this.activity = getActivity();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.broadcastReceiver != null) {
            this.activity.unregisterReceiver(this.broadcastReceiver);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        this.CHAMP_ID = this.activity.getIntent().getExtras().getString(Const.CHAMPION_KEY);
        View view = inflater.inflate(getLayoutId(), container, false);
        this.mAdView = (NativeExpressAdView) view.findViewById(R.id.adView);
        this.language = ChampDao.getInstant(this.activity).getLanguage();
        initView(view);
        initAction();
        initData();
        return view;
    }

    public void trasitionFragment(BaseFragment fragment) {
        trasitionFragment(fragment, null);
    }

    public void trasitionFragment(BaseFragment fragment, Bundle bundle) {
        this.actionInterface.showFragment(fragment, bundle);
    }

    public BaseFragment getCurrentFragment() {
        return this.actionInterface.getCurrentFragment();
    }

    public void backToPreviousFragment() {
        this.actionInterface.popBackFragment();
    }

    public void reloadFragment() {
        this.actionInterface.reloadFragment();
    }

    public BaseFragment getFragmentbyTag(String tag) {
        return this.actionInterface.getFrgamentByTag(tag);
    }

    public void sendEvent(Object o, String key) {
        this.actionInterface.sendEvent(o, key);
    }

    public void sendEventDelay(final Object o, final String key) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                BaseFragment.this.actionInterface.sendEvent(o, key);
            }
        }, 300);
    }
}
