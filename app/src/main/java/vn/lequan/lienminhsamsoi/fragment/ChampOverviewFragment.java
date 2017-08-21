package vn.lequan.lienminhsamsoi.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.lequan.lienminhsamsoi.API.Face.Face_AccountID;
import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.GlobalApp;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.activity.YoutubePlayerActivity;
import vn.lequan.lienminhsamsoi.base.BaseFragment;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.models.Lore;
import vn.lequan.lienminhsamsoi.models.VideoChampion.VideoChampion;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class ChampOverviewFragment extends BaseFragment implements OnClickListener {
    private TextView armor;
    private TextView attack;
    private TextView attackSpeed;
    private TextView hp;
    private TextView hpRegen;
    private TextView tv_quout;
    private ImageView imageView;
    private TextView lore;
    private TextView loreDetail;
    private TextView mana;
    private TextView manaRegen;
    private TextView moveSpeed;
    private TextView name;
    private ImageView playvideo;
    private ProgressBar progressAttack;
    private ProgressBar progressDefense;
    private ProgressBar progressDifficu;
    private ProgressBar progressMagic;
    private TextView range;
    private TextView spell;
    private List<String> tags;
    private TextView title;
    private TextView tvArmor;
    private TextView tvAttackSpeed;
    private TextView tvDamage;
    private TextView tvHealth;
    private TextView tvHealthRegen;
    private TextView tvMana;
    private TextView tvManaRegen;
    private TextView tvMovement;
    private TextView tvRange;
    private TextView tvSpellBlock;
    private TextView tv_champ_tag;
    private String videoId;
    private VideoView videoplayer;

    public int getLayoutId() {
        return R.layout.fragment_overview;
    }

    public void initView(View view) {
        videoplayer = (VideoView)
                view.findViewById(R.id.videoplayer);
        this.tv_champ_tag = (TextView) view.findViewById(R.id.tv_champ_tag);
        this.progressAttack = (ProgressBar) view.findViewById(R.id.progress_attack);
        this.progressDefense = (ProgressBar) view.findViewById(R.id.progress_defense);
        this.progressDifficu = (ProgressBar) view.findViewById(R.id.progress_difficul);
        this.progressMagic = (ProgressBar) view.findViewById(R.id.progress_magic);
        this.imageView = (ImageView) view.findViewById(R.id.img_banner);
        this.name = (TextView) view.findViewById(R.id.tv_name_champ);
        this.title = (TextView) view.findViewById(R.id.tv_name_2);
        this.hp = (TextView) view.findViewById(R.id.overview_tv_hp);
        this.tv_quout = (TextView) view.findViewById(R.id.tv_quout);
        this.mana = (TextView) view.findViewById(R.id.overview_tv_mana);
        this.attack = (TextView) view.findViewById(R.id.overview_tv_attackDamage);
        this.attackSpeed = (TextView) view.findViewById(R.id.overview_tv_attackSpeed);
        this.moveSpeed = (TextView) view.findViewById(R.id.overview_tv_moveSpeed);
        this.hpRegen = (TextView) view.findViewById(R.id.overview_tv_hpRegen);
        this.manaRegen = (TextView) view.findViewById(R.id.overview_tv_manaRegen);
        this.armor = (TextView) view.findViewById(R.id.overview_tv_armor);
        this.spell = (TextView) view.findViewById(R.id.overview_tv_spellBlock);
        this.range = (TextView) view.findViewById(R.id.overview_tv_attackRange);
        this.lore = (TextView) view.findViewById(R.id.overview_Lore);
        this.loreDetail = (TextView) view.findViewById(R.id.overview_tv_lore);
        this.playvideo = (ImageView) view.findViewById(R.id.btn_playyoutube);
        this.tvHealth = (TextView) view.findViewById(R.id.tv_health);
        this.tvAttackSpeed = (TextView) view.findViewById(R.id.tv_attack_speed);
        this.tvDamage = (TextView) view.findViewById(R.id.tv_damage);
        this.tvMovement = (TextView) view.findViewById(R.id.tv_movement);
        this.tvHealthRegen = (TextView) view.findViewById(R.id.tv_health_regen);
        this.tvManaRegen = (TextView) view.findViewById(R.id.tv_mana_regen);
        this.tvMana = (TextView) view.findViewById(R.id.tv_mana);
        this.tvSpellBlock = (TextView) view.findViewById(R.id.tv_spell_block);
        this.tvRange = (TextView) view.findViewById(R.id.tv_range);
        this.tvArmor = (TextView) view.findViewById(R.id.tv_armor);
        getVideoChampion();
    }

    private void getVideoChampion() {
        Call<VideoChampion> call = GlobalApp.getInstance().retrofit2.create(Face_AccountID.class).getVideo(CHAMP_ID.toLowerCase());
        call.enqueue(new Callback<VideoChampion>() {
            @Override
            public void onResponse(Call<VideoChampion> call, Response<VideoChampion> response) {
                try {
                    String url = response.body().getChampion().getVideo().getUri();
                    videoplayer.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    videoplayer.setVideoURI(Uri.parse(url));
                    videoplayer.start();
                    videoplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            videoplayer.start();
                        }
                    });

                } catch (Exception e) {
                    Debug.e("Lỗi: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<VideoChampion> call, Throwable t) {
                Debug.e("Lỗi: " + t.getMessage());
            }
        });
    }

    public void initAction() {
    }

    public void initData() {

        Lore model = ChampDao.getInstant(this.activity).getOverview(this.CHAMP_ID);
        this.tags = ChampDao.getInstant(this.activity).getChampTag(this.CHAMP_ID);
        initView(model);
        this.videoId = ChampDao.getInstant(this.activity).getVideoId(this.CHAMP_ID);
        this.playvideo.setOnClickListener(this);
        if (this.videoId == null || this.videoId.isEmpty() || !Utils.getLanguageCode(this.activity).equals("vn_VN")) {
            this.playvideo.setVisibility(4);
        } else {
            this.playvideo.setVisibility(0);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private String getChampTags(List<String> tags) {
        String str = "";
        for (String tag : tags) {
            str = str + tag.replace("Tank", this.language.getTank()).replace("Support", this.language.getSupport()).replace("Marksman", this.language.getMarksman()).replace("Mage", this.language.getMage()).replace("Assassin", this.language.getAssassin()).replace("Fighter", this.language.getFighter()) + ", ";
        }
        return str.substring(0, str.length() - 2);
    }

    @SuppressLint("SetTextI18n")
    private void initView(Lore lore) {
        this.tv_champ_tag.setText(getChampTags(this.tags));
        this.progressAttack.setProgress(lore.getAttackRank() * 10);
        this.progressDefense.setProgress(lore.getDefenseRank() * 10);
        this.progressMagic.setProgress(lore.getMagicRank() * 10);
        this.progressDifficu.setProgress(lore.getDifficultyRank() * 10);
        Typeface typeface = Typeface.createFromAsset(this.activity.getAssets(), "font/times.otf");
        this.name.setText(lore.getName());
        this.name.setTypeface(typeface);
        this.title.setText(lore.getTitle());
        this.hp.setText(lore.getHp() + " (+" + lore.getHpPerLevel() + ")");
        this.mana.setText(lore.getMp() + " (+" + lore.getMpPerLevel() + ")");
        this.attack.setText(lore.getAttackDamage() + " (+" + lore.getAttackDamagePerLevel() + ")");
        this.attackSpeed.setText(lore.getAttackSpeedPerLevel() + "%");
        this.moveSpeed.setText(lore.getMoveSpeed() + "");
        this.hpRegen.setText(lore.getHpRegen() + " (+" + lore.getHpRegenPerLevel() + ")");
        this.manaRegen.setText(lore.getMpRegen() + " (+" + lore.getMpRegenPerLevel() + ")");
        this.armor.setText(lore.getArmor() + " (+" + lore.getArmorPerLevel() + ")");
        this.spell.setText(lore.getSpellBlock() + " (+" + lore.getSpellBlockPerLevel() + ")");
        this.range.setText(String.valueOf(lore.getAttackRange()));
        this.lore.setText(this.language.getLore());
        this.loreDetail.setText(Html.fromHtml(lore.getLore()));
        Glide.with(this.activity)
                .load("http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + lore.getId() + "_0.jpg").error((int) R.drawable.unchampion)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(this.imageView);
        Debug.e("http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + lore.getId() + "_0.jpg");
        this.tvArmor.setText(String.format("%s:", new Object[]{this.language.getArmor()}));
        this.tvRange.setText(String.format("%s", new Object[]{this.language.getRange()}));
        this.tvSpellBlock.setText(String.format("%s:", new Object[]{this.language.getSpellBlock()}));
        this.tvManaRegen.setText(String.format("%s:", new Object[]{this.language.getManaRegen()}));
        this.tvDamage.setText(String.format("%s:", new Object[]{this.language.getDamage()}));
        this.tvMovement.setText(String.format("%s:", new Object[]{this.language.getMovement()}));
        this.tvAttackSpeed.setText(String.format("%s:", new Object[]{this.language.getAttackSpeed()}));
        this.tvHealth.setText(String.format("%s:", new Object[]{this.language.getHealth()}));
        this.tvHealthRegen.setText(String.format("%s:", new Object[]{this.language.getHealthRegen()}));
        this.tvMana.setText(String.format("%s:", new Object[]{this.language.getMana()}));
        ChampFragment.closeDialog();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_playyoutube:
                Intent intent = new Intent(this.activity, YoutubePlayerActivity.class);
                intent.putExtra("KEY_VIDEO_ID", this.videoId);
                startActivity(intent);
                return;
            default:
                return;
        }
    }
}
