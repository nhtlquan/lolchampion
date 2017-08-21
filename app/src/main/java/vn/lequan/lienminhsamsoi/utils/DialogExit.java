package vn.lequan.lienminhsamsoi.utils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.smile.studio.libsmilestudio.facebook.ObjectFacebook;
import com.smile.studio.libsmilestudio.facebook.ShareFacebook;

import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.R;


@SuppressLint("ValidFragment")
public class DialogExit extends DialogFragment implements View.OnClickListener {
    private View view;
    private Point point;
    private TextView txtxemsau, txtyeuthich, txtshare, textView23, txt_chiase;
    public static SharedPreferences sharedpreferences;
    private static final String MyPREFERENCES = "DANHGIA";
    int PRIVATE_MODE = 0;
    private CallbackManager callback;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialog1);
    }

    @Override
    public void onSaveInstanceState(Bundle arg0) {
        super.onSaveInstanceState(arg0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.custom_popup, container, false);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, PRIVATE_MODE);
            callback = CallbackManager.Factory.create();
            txtshare = (TextView) view.findViewById(R.id.txt_share);
            txt_chiase = (TextView) view.findViewById(R.id.txt_chiase);
            txtyeuthich = (TextView) view.findViewById(R.id.txt_yeuthich);
            txtxemsau = (TextView) view.findViewById(R.id.txt_xemsau);
            txtxemsau.setOnClickListener(this);
            txtyeuthich.setOnClickListener(this);
            txtshare.setOnClickListener(this);
            txt_chiase.setOnClickListener(this);
        }
        return view;
    }

    public void onActionShareFacebook() {
        ShareFacebook performShare = new ShareFacebook(getActivity(), callback);
        String title = "Liên Minh";
        String url = "https://play.google.com/store/apps/details?id=vn.lequan.wallpaperhtc";
        String description = "Tình yêu Wallpapers Douple là nền tảng tốt nhất để hiển thị hương vị tuyệt vời của bạn. Một số lượng lớn các hình nền đẹp và lãng mạn trong chất lượng cao đang chờ đợi bạn! ";
        String image = "https://lh3.googleusercontent.com/eCbwF1wQXQDcQHtbzpryai-dj3uJNlJpOZ7xBhXe-0nl44Nuzqd6C2Bv81IwznhRa9w=w300-rw";
        performShare.onActionShareFacebook(new ObjectFacebook(title, description, url, image), new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result) {
                Debug.showAlert(getActivity(), "Đã chia sẻ trên facebook");
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Debug.showAlert(getActivity(), error.getMessage());
            }
        });
    }

    @Override
    public void onClick(final View v) {
        final SharedPreferences.Editor edit = sharedpreferences.edit();
        ViewCompat.animate(v)
                .setDuration(200)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setInterpolator(new CycleInterpolator())
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(final View view) {
                        switch (view.getId()) {
                            case R.id.txt_xemsau:
                                edit.putBoolean("check", false);
                                edit.apply();
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+ getActivity().getPackageName()));
                                startActivity(intent);
                                break;
                            case R.id.txt_share:
                                edit.putBoolean("check", false);
                                edit.apply();
                                getActivity().finish();
                                break;
                            case R.id.txt_chiase:
                                onActionShareFacebook();
                                break;
                            case R.id.txt_yeuthich:
                                getActivity().finish();
                                break;

                        }
                    }

                    @Override
                    public void onAnimationEnd(final View view) {
                    }

                    @Override
                    public void onAnimationCancel(final View view) {

                    }
                })
                .withLayer()
                .start();
    }

    public class CycleInterpolator implements android.view.animation.Interpolator {

        private final float mCycles = 0.5f;

        @Override
        public float getInterpolation(final float input) {
            return (float) Math.sin(2.0f * mCycles * Math.PI * input);
        }
    }

}
