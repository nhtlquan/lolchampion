package vn.lequan.lienminhsamsoi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

import com.facebook.FacebookSdk;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.API.API;
import vn.lequan.lienminhsamsoi.http.GetDataChamp;
import vn.lequan.lienminhsamsoi.models.LanguageData;
import vn.lequan.lienminhsamsoi.ultis.Const;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class SplassScreen extends AppCompatActivity {
    private View rootView;
    private String versionData;
    private HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Debug.e(message);
        }
    });

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    class C08031 implements OnClickListener {
        C08031() {
        }

        public void onClick(View view) {
            if (Utils.isNetworkAvailable(SplassScreen.this)) {
                new FirsRunApplication().execute(new Void[0]);
            } else {
                SplassScreen.this.showSnackbarWarning();
            }
        }
    }

    class C08053 implements OnKeyListener {
        C08053() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return false;
        }
    }

    class FirsRunApplication extends AsyncTask<Void, Void, Void> {
        FirsRunApplication() {
        }

        protected Void doInBackground(Void... voids) {
            try {
                SplassScreen.this.versionData = new GetDataChamp().getVersion();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (SplassScreen.this.versionData == null || SplassScreen.this.versionData.isEmpty()) {
                SplassScreen.this.showSnackbarWarning();
                return;
            }
            Utils.setNewVersion(SplassScreen.this, SplassScreen.this.versionData);
            SplassScreen.this.showDialogChoiceLanguage();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        setContentView((int) vn.lequan.lienminhsamsoi.R.layout.activity_splass_screen);
        SharedPreferences prefs = getSharedPreferences(Const.MY_PREFS_NAME, 0);
        this.rootView = findViewById(vn.lequan.lienminhsamsoi.R.id.layout_container);
        boolean isInternetConected = Utils.isNetworkAvailable(this);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .method(original.method(), original.body())
                                .build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(logging)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        GlobalApp.getInstance().retrofit = new Retrofit.Builder().baseUrl(API.HOST_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        GlobalApp.getInstance().retrofit1 = new Retrofit.Builder().baseUrl(API.HOST_API1)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        GlobalApp.getInstance().retrofit2 = new Retrofit.Builder().baseUrl(API.HOST_VIDEO)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        if (prefs.getBoolean("isFirstRun", true) && isInternetConected) {
            new FirsRunApplication().execute(new Void[0]);
        } else if (isInternetConected) {
            startActivity(new Intent(this, MainActivity.class));//cusstom
            finish();
        } else {
            showSnackbarWarning();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void showSnackbarWarning() {
        Snackbar.make(this.rootView, (CharSequence) "No internet connection! ", -2).setAction((CharSequence) "TRY AGAIN", new C08031()).show();
    }

    private void showDialogChoiceLanguage() {
        final LanguageData[] datas = LanguageData.values();
        CharSequence[] items = new CharSequence[datas.length];
        for (int i = 0; i < datas.length; i++) {
            items[i] = datas[i].getName();
        }
        Builder builder = new Builder(this, vn.lequan.lienminhsamsoi.R.style.AlertDialogCustom);
        builder.setTitle((CharSequence) "Language...");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int position) {
                Utils.setLanguageCode(SplassScreen.this, datas[position].getCode());
                if (Utils.isNetworkAvailable(SplassScreen.this)) {
                    SplassScreen.this.startActivity(new Intent(SplassScreen.this, UpdateActivity.class));
                    SplassScreen.this.finish();
                    return;
                }
                SplassScreen.this.showSnackbarWarning();
            }
        });
        AlertDialog myAlertDialog = builder.create();
        myAlertDialog.show();
        myAlertDialog.setOnKeyListener(new C08053());
    }
}
