package vn.lequan.lienminhsamsoi.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.model.Mastery;
import vn.lequan.lienminhsamsoi.ultis.Const;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class MasteryDetailDialog extends Activity {

    class C14721 extends TypeToken<String[]> {
        C14721() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_mastery_layout);
        ImageView imageView = (ImageView) findViewById(R.id.img_mastery);
        TextView name = (TextView) findViewById(R.id.tv_mastery_name);
        TextView point = (TextView) findViewById(R.id.tv_mastery_point);
        TextView detail = (TextView) findViewById(R.id.tv_mastery_detail);
        getWindow().setLayout(-1, -2);
        getWindow().getAttributes().gravity = 48;
        String itemId = getIntent().getExtras().getString(Const.ITEM_ID);
        Mastery item = ChampDao.getInstant(this).getMastery(itemId);
        int img = Utils.getImageItem(this, itemId);
        if (img != 0) {
            Glide.with((Activity) this).load(Integer.valueOf(img)).into(imageView);
        } else {
            Glide.with((Activity) this).load("http://ddragon.leagueoflegends.com/cdn/" + Utils.getCurrentVersion(this) + "/img/mastery/" + itemId + ".png").into(imageView);
        }
        name.setText(item.getName());
        point.setText("Max: " + item.getRanks());
        String decription = "";
        for (String details : (String[]) new Gson().fromJson(item.getDescription(), new C14721().getType())) {
            decription = decription + details + "<br><br>";
        }
        detail.setText(Html.fromHtml(decription));
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
