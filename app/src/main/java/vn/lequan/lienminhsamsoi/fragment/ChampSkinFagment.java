package vn.lequan.lienminhsamsoi.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.activity.FullscreenActivity;
import vn.lequan.lienminhsamsoi.adapter.ChampSkinAdapter;
import vn.lequan.lienminhsamsoi.adapter.ChampSkinAdapter.Iclick;
import vn.lequan.lienminhsamsoi.base.BaseFragment;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.models.SkinModel;

public class ChampSkinFagment extends BaseFragment implements Iclick {
    private static String[] PERMISSIONS_SDCARD = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final int REQUEST_SDCARD = 0;
    private View mLayout;

    class C08411 implements OnClickListener {
        C08411() {
        }

        public void onClick(View view) {
            ActivityCompat.requestPermissions(ChampSkinFagment.this.activity, ChampSkinFagment.PERMISSIONS_SDCARD, 0);
        }
    }

    public int getLayoutId() {
        return R.layout.fragment_skin;
    }

    public void initView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rclview);
        this.mLayout = view.findViewById(R.id.layout_snackbar);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.activity);
        layoutManager.setOrientation(1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ChampSkinAdapter(this.activity, ChampDao.getInstant(this.activity).getLinkSkin(this.CHAMP_ID), this));
    }

    public void initAction() {
    }

    public void initData() {
    }

    public void onClickDownloadButton(Bitmap bitmap, String name) {
        if (ContextCompat.checkSelfPermission(this.activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            requestPermission();
        } else {
            downloadSkin(bitmap, name);
        }
    }

    public void onClickImage(SkinModel model) {
        Intent intent = new Intent(this.activity, FullscreenActivity.class);
        intent.putExtra("URL", model.getImage());
        intent.putExtra("SKIN_NAME", model.getName());
        startActivity(intent);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this.activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            Snackbar.make(this.mLayout, (CharSequence) "Click OK để cấp quyền truy cập!", -2).setAction((CharSequence) "OK", new C08411()).show();
        } else {
            ActivityCompat.requestPermissions(this.activity, PERMISSIONS_SDCARD, 0);
        }
    }

    private void downloadSkin(Bitmap bitmap, String name) {
            File myDir = new File(
                    Environment
                            .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "LOL");

            myDir.mkdirs();
            String fname = "Wallpaper-" + name + ".jpg";
            File file = new File(myDir, fname);
            if (file.exists())
                file.delete();
            try {
                FileOutputStream out = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
                out.flush();
                out.close();
                Toast.makeText(
                        getActivity(),
                        "Lưu Thành Công: " + file.getAbsolutePath(),
                        Toast.LENGTH_SHORT).show();
                MediaScannerConnection.scanFile(getActivity(),
                        new String[] { file.toString() }, null,
                        new MediaScannerConnection.OnScanCompletedListener() {
                            public void onScanCompleted(String path, Uri uri) {
                                Log.i("ExternalStorage", "Scanned " + path + ":");
                                Log.i("ExternalStorage", "-> uri=" + uri);
                            }
                        });

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getActivity(),
                        "Lỗi",
                        Toast.LENGTH_SHORT).show();
            }
    }
}
