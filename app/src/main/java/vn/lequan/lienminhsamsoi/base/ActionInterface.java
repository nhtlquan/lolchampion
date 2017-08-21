package vn.lequan.lienminhsamsoi.base;

import android.os.Bundle;

public interface ActionInterface {
    BaseFragment getCurrentFragment();

    BaseFragment getFragmentByHolder(int i);

    BaseFragment getFrgamentByTag(String str);

    void popBackFragment();

    void reloadFragment();

    void replaceFragment(BaseFragment baseFragment, BaseFragment baseFragment2, String str, String str2, Bundle bundle, boolean z);

    void sendEvent(Object obj, String str);

    void sendEvent(String str);

    void showFragment(BaseFragment baseFragment, Bundle bundle);

    void showFragment(BaseFragment baseFragment, Bundle bundle, boolean z);

    void showFragment(BaseFragment baseFragment, String str, Bundle bundle, boolean z, int i);
}
