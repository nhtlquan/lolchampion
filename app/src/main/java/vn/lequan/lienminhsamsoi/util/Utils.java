package vn.lequan.lienminhsamsoi.util;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;


public class Utils {
	private String TAG = Utils.class.getSimpleName();
	private Context _context;

	// constructor
	public Utils(Context context) {
		this._context = context;
	}

	/*
	 * getting screen width
	 */
	@SuppressWarnings("deprecation")
	public int getScreenWidth() {
		int columnWidth;
		WindowManager wm = (WindowManager) _context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();

		final Point point = new Point();
		try {
			display.getSize(point);
		} catch (java.lang.NoSuchMethodError ignore) {
			// Older device
			point.x = display.getWidth();
			point.y = display.getHeight();
		}
		columnWidth = point.x;
		return columnWidth;
	}

	public void saveImageToSDCard(Bitmap bitmap) {
		File myDir = new File(
				Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				"LOL");

		myDir.mkdirs();
		Random generator = new Random();
		int n = 10000;
		n = generator.nextInt(n);
		String fname = "Wallpaper-" + n + ".jpg";
		File file = new File(myDir, fname);
		if (file.exists())
			file.delete();
		try {
			FileOutputStream out = new FileOutputStream(file);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
			out.flush();
			out.close();
			Toast.makeText(
					_context,
					"Lưu thành công vào bộ thư viện ảnh",
					Toast.LENGTH_SHORT).show();
			Log.d(TAG, "Wallpaper saved to: " + file.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(_context,"Không thành công",
					Toast.LENGTH_SHORT).show();
		}
	}

	public void setAsWallpaper(Bitmap bitmap) {
		try {
			WallpaperManager wm = WallpaperManager.getInstance(_context);

			wm.setBitmap(bitmap);
			Toast.makeText(_context,"Đặt hình nền thành công",
					Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(_context,
					"Đặt hình nền không thành công",
					Toast.LENGTH_SHORT).show();
		}
	}
}