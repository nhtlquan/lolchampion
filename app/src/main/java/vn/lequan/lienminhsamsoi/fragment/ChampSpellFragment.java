package vn.lequan.lienminhsamsoi.fragment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.ChampSpellAdapter;
import vn.lequan.lienminhsamsoi.adapter.ChampSpellAdapter.ISpellChamp;
import vn.lequan.lienminhsamsoi.base.BaseFragment;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.models.Spell;
import vn.lequan.lienminhsamsoi.ultis.Utils;
import java.util.List;

public class ChampSpellFragment extends BaseFragment implements ISpellChamp {
    private RecyclerView recyclerView;

    public int getLayoutId() {
        return R.layout.fragment_champ_spell;
    }

    public void initView(View view) {
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
    }

    public void initAction() {
    }

    public void initData() {
        List<Spell> list = ChampDao.getInstant(this.activity).getSpell(this.CHAMP_ID);
        list.add(4, null);
        ChampSpellAdapter adapter = new ChampSpellAdapter(list, this.activity, this);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
        this.recyclerView.setAdapter(adapter);
    }

    public void onBtnVideoClick(int position) {
        playVideo((String) Utils.getLinkVideoSpell(this.activity.getIntent().getExtras().getString("KEY")).get(position));
    }

    private void playVideo(String url) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.setDataAndType(Uri.parse(url), "video/mp4");
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this.activity, "Can not open video", 0).show();
        }
    }
}
