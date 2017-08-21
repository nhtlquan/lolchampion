package vn.lequan.lienminhsamsoi.base;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import vn.lequan.lienminhsamsoi.R;
import org.greenrobot.eventbus.EventBus;

public class BaseActivity extends AppCompatActivity implements ActionInterface {
    public BroadcastReceiver broadcastReceiver;
    private EventBus bus = EventBus.getDefault();

    public void sendEvent(String key) {
        this.bus.postSticky(key);
    }

    public void sendEvent(Object o, String key) {
        this.bus.postSticky(new MessageEvent(o, key));
    }

    public void showFragment(BaseFragment fragment, Bundle bundle, boolean isAimation) {
        String tag = fragment.getTag();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        if (fragment.isAdded()) {
            transaction.show(fragment).commit();
            return;
        }
        if (!TextUtils.isEmpty(tag)) {
            transaction.addToBackStack(tag);
        }
        transaction.add(R.id.drawer_layout, fragment, tag).commit();
    }

    public void showFragment(BaseFragment idfragment, Bundle bundle) {
        showFragment(idfragment, bundle);
    }

    public void showFragment(BaseFragment fragment, String tag, Bundle bundle, boolean isAimation, int holder) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        if (isAimation) {
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_in, R.anim.fade_out, R.anim.fade_out);
        }
        if (fragment.isAdded()) {
            transaction.show(fragment).commit();
            return;
        }
        if (!TextUtils.isEmpty(tag)) {
            transaction.addToBackStack(tag);
        }
        transaction.add(holder, fragment, tag).commit();
    }

    public BaseFragment getFragmentByHolder(int id) {
        return (BaseFragment) getSupportFragmentManager().findFragmentById(id);
    }

    public BaseFragment getFrgamentByTag(String tag) {
        return (BaseFragment) getSupportFragmentManager().findFragmentByTag(tag);
    }

    public void popBackFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        }
    }

    public void reloadFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        BaseFragment currentFragment = getCurrentFragment();
        transaction.detach(currentFragment);
        transaction.attach(currentFragment);
        transaction.commit();
    }

    public BaseFragment getCurrentFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fragmentManager.getBackStackEntryCount();
        if (count < 1) {
            return null;
        }
        return (BaseFragment) fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(count - 1).getName());
    }

    public void replaceFragment(BaseFragment fromScreen, BaseFragment toScreen, String tagA, String tagB, Bundle bundle, boolean isAnimation) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (isAnimation) {
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_in, R.anim.fade_out, R.anim.fade_out);
        }
        if (toScreen.isAdded()) {
            transaction.remove(fromScreen).replace(R.id.drawer_layout, toScreen).commit();
            return;
        }
        if (!TextUtils.isEmpty(tagB)) {
            transaction.addToBackStack(tagB);
        }
        transaction.remove(fromScreen).replace(R.id.drawer_layout, toScreen, tagB).commit();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.broadcastReceiver != null) {
            unregisterReceiver(this.broadcastReceiver);
        }
    }
}
