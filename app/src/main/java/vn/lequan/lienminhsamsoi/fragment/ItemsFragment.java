package vn.lequan.lienminhsamsoi.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import java.util.List;

import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.dao.SQLConst;
import vn.lequan.lienminhsamsoi.dao.model.Language;
import vn.lequan.lienminhsamsoi.models.Item;
import vn.lequan.lienminhsamsoi.ultis.Const;
import vn.lequan.lienminhsamsoi.ultis.Utils;

public class ItemsFragment extends Fragment implements OnCheckedChangeListener {
    private Activity activity;
    private CheckBox chkChimang;
    private CheckBox chkDuong;
    private CheckBox chkGiamthoigianhoichieu;
    private CheckBox chkGiap;
    private CheckBox chkGiay;
    private CheckBox chkHoimau;
    private CheckBox chkHoinangluong;
    private CheckBox chkHutmau;
    private CheckBox chkHutmauphep;
    private CheckBox chkKhanghieuung;
    private CheckBox chkKhangphep;
    private CheckBox chkKichhoat;
    private CheckBox chkLamcham;
    private CheckBox chkLoitucvang;
    private CheckBox chkMau;
    private CheckBox chkNangluong;
    private CheckBox chkPhukien;
    private CheckBox chkRung;
    private CheckBox chkSatthuong;
    private CheckBox chkSucmanhphepthuat;
    private CheckBox chkTangtocdochay;
    private CheckBox chkTieuthu;
    private CheckBox chkTocdodanh;
    private CheckBox chkXuyengiap;
    private CheckBox chkXuyenkhangphep;
    private FragmentManager fm;
    private boolean isList = true;
    private Language language;
    private String sqlCommand = SQLConst.SQL_SELECT_LIST_ITEM_SORT;
    private TextView tvAll;
    private TextView tvDichuyen;
    private TextView tvDungCu;
    private TextView tvKhac;
    private TextView tvKhoidau;
    private TextView tvPhepThuat;
    private TextView tvPhongNgu;
    private TextView tvTanCong;

    class C08431 implements OnMenuItemClickListener {
        C08431() {
        }

        public boolean onMenuItemClick(MenuItem item) {
            FragmentTransaction ft;
            if (ItemsFragment.this.isList) {
                item.setIcon(R.drawable.ic_view_module_white_36dp);
//                ft = ItemsFragment.this.fm.beginTransaction();
//                ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
//                ft.replace(R.id.fragment_item, new ItemGridFragment());
//                ft.commit();
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.pop_enter, R.anim.pop_exit, R.anim.enter, R.anim.exit).replace(R.id.fragment_item, new ItemGridFragment()).commit();
                ItemsFragment.this.removeChecked();
                ItemsFragment.this.isList = false;
            } else {
                item.setIcon(R.drawable.ic_view_list_white_36dp);
//                ft = ItemsFragment.this.fm.beginTransaction();
//                ft.setCustomAnimations(R.anim.pop_enter, R.anim.pop_exit, R.anim.enter, R.anim.exit);
//                ft.replace(R.id.fragment_item, new ItemListFragment());
//                ft.commit();
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.pop_enter, R.anim.pop_exit, R.anim.enter, R.anim.exit).replace(R.id.fragment_item, new ItemListFragment()).commit();
                ItemsFragment.this.removeChecked();
                ItemsFragment.this.isList = true;
            }
            return false;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_item_layout, container, false);
        this.language = ChampDao.getInstant(this.activity).getLanguage();
        findViewIdAll(v);
        ((AppCompatActivity) this.activity).getSupportActionBar().setTitle(this.language.getCategoryItem());
        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.pop_enter, R.anim.pop_exit, R.anim.enter, R.anim.exit).replace(R.id.fragment_item, new ItemListFragment()).commit();
//        this.fm = getChildFragmentManager();
//        FragmentTransaction ft = this.fm.beginTransaction();
//        ft.add(R.id.fragment_item, new ItemListFragment());
//        ft.commit();
        setHasOptionsMenu(true);
        return v;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_item_fragment, menu);
        menu.findItem(R.id.action_view).setOnMenuItemClickListener(new C08431());
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.item_rung:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_RUNG;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_RUNG, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_duong:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_DUONG;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_DUONG, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_tieuthu:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_TIEUTHU;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_TIEUTHU, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_loitucvang:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_LOITUCVANG;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_LOITUCVANG, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_phukien:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_PHUKIEN;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_PHUKIEN, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_giap:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_GIAP;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_GIAP, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_mau:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_MAU;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_MAU, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_hoimau:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_HOIMAU;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_HOIMAU, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_khangphep:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_KHANGPHEP;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_KHANGPHEP, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_tocdodanh:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_TOCDODANH;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_TOCDODANH, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_chimang:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_CHIMANG;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_CHIMANG, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_satthuong:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_SATTHUONG;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_SATTHUONG, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_hutmau:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_HUTMAU;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_HUTMAU, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_hoichieu:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_HOICHIEU;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_HOICHIEU, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_nangluong:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_NANGLUONG;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_NANGLUONG, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_hoinangluong:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_HOINANGLUONG;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_HOINANGLUONG, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_sucmanhphepthuat:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_SUCMANHPHEPTHUAT;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_SUCMANHPHEPTHUAT, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_giay:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_GIAY;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_GIAY, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_tangtocdokhac:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_TANGTOCDOCHAY;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_TANGTOCDOCHAY, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_khanghieuung:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_KHANGHIEUUNG;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_KHANGHIEUUNG, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_hutmauphep:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_HUTMAUPHEP;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_HUTMAUPHEP, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_lamcham:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_LAMCHAM;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_LAMCHAM, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_kichhoat:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_KICHHOAT;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_KICHHOAT, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_xuyenkhangphep:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_XUYENKHANGPHEP;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_XUYENKHANGPHEP, "");
                getData(this.sqlCommand);
                return;
            case R.id.item_xuyengiap:
                if (isChecked) {
                    this.sqlCommand += SQLConst.KEY_XUYENGIAP;
                    getData(this.sqlCommand);
                    return;
                }
                this.sqlCommand = this.sqlCommand.replace(SQLConst.KEY_XUYENGIAP, "");
                getData(this.sqlCommand);
                return;
            default:
                return;
        }
    }

    private void findViewIdAll(View view) {
        this.chkRung = (CheckBox) view.findViewById(R.id.item_rung);
        this.chkDuong = (CheckBox) view.findViewById(R.id.item_duong);
        this.chkTieuthu = (CheckBox) view.findViewById(R.id.item_tieuthu);
        this.chkLoitucvang = (CheckBox) view.findViewById(R.id.item_loitucvang);
        this.chkPhukien = (CheckBox) view.findViewById(R.id.item_phukien);
        this.chkGiap = (CheckBox) view.findViewById(R.id.item_giap);
        this.chkMau = (CheckBox) view.findViewById(R.id.item_mau);
        this.chkHoimau = (CheckBox) view.findViewById(R.id.item_hoimau);
        this.chkTocdodanh = (CheckBox) view.findViewById(R.id.item_tocdodanh);
        this.chkChimang = (CheckBox) view.findViewById(R.id.item_chimang);
        this.chkSatthuong = (CheckBox) view.findViewById(R.id.item_satthuong);
        this.chkHutmau = (CheckBox) view.findViewById(R.id.item_hutmau);
        this.chkGiamthoigianhoichieu = (CheckBox) view.findViewById(R.id.item_hoichieu);
        this.chkNangluong = (CheckBox) view.findViewById(R.id.item_nangluong);
        this.chkHoinangluong = (CheckBox) view.findViewById(R.id.item_hoinangluong);
        this.chkSucmanhphepthuat = (CheckBox) view.findViewById(R.id.item_sucmanhphepthuat);
        this.chkKhangphep = (CheckBox) view.findViewById(R.id.item_khangphep);
        this.chkGiay = (CheckBox) view.findViewById(R.id.item_giay);
        this.chkTangtocdochay = (CheckBox) view.findViewById(R.id.item_tangtocdokhac);
        this.chkKhanghieuung = (CheckBox) view.findViewById(R.id.item_khanghieuung);
        this.chkHutmauphep = (CheckBox) view.findViewById(R.id.item_hutmauphep);
        this.chkLamcham = (CheckBox) view.findViewById(R.id.item_lamcham);
        this.chkKichhoat = (CheckBox) view.findViewById(R.id.item_kichhoat);
        this.chkXuyenkhangphep = (CheckBox) view.findViewById(R.id.item_xuyenkhangphep);
        this.chkXuyengiap = (CheckBox) view.findViewById(R.id.item_xuyengiap);
        this.tvAll = (TextView) view.findViewById(R.id.tv_all);
        this.tvKhoidau = (TextView) view.findViewById(R.id.tv_khoidau);
        this.tvDungCu = (TextView) view.findViewById(R.id.tv_dungcu);
        this.tvPhongNgu = (TextView) view.findViewById(R.id.tv_phongngu);
        this.tvTanCong = (TextView) view.findViewById(R.id.tv_tancong);
        this.tvPhepThuat = (TextView) view.findViewById(R.id.tv_phepthuat);
        this.tvDichuyen = (TextView) view.findViewById(R.id.tv_dichuyen);
        this.tvKhac = (TextView) view.findViewById(R.id.tv_other);
        if (!Utils.getLanguageCode(this.activity).equals("vn_VN")) {
            this.chkRung.setText("Jungle");
            this.chkDuong.setText("Lane");
            this.chkTieuthu.setText(this.language.getConsumable());
            this.chkLoitucvang.setText(this.language.getGoldPer());
            this.chkPhukien.setText("Trinket Stats");
            this.chkGiap.setText(this.language.getArmor());
            this.chkMau.setText(this.language.getHealth());
            this.chkHoimau.setText(this.language.getHealthRegen());
            this.chkKhangphep.setText(this.language.getSpellBlock());
            this.chkTocdodanh.setText(this.language.getAttackSpeed());
            this.chkChimang.setText(this.language.getCriticalStrike());
            this.chkSatthuong.setText(this.language.getDamage());
            this.chkHutmau.setText(this.language.getLifeSteal());
            this.chkGiamthoigianhoichieu.setText(this.language.getCooldownReduction());
            this.chkNangluong.setText(this.language.getMana());
            this.chkHoinangluong.setText(this.language.getManaRegen());
            this.chkSucmanhphepthuat.setText(this.language.getSpellDamage());
            this.chkGiay.setText(this.language.getBoots());
            this.chkTangtocdochay.setText(this.language.getNonbootsMovement());
            this.chkKhanghieuung.setText(this.language.getTenacity());
            this.chkHutmauphep.setText(this.language.getSpellVamp());
            this.chkKichhoat.setText(this.language.getActive());
            this.chkLamcham.setText(this.language.getSlow());
            this.chkXuyenkhangphep.setText(this.language.getMagicPenetration());
            this.chkXuyengiap.setText(this.language.getArmorPenetration());
            this.tvAll.setText(this.language.getAllItems().toUpperCase());
            this.tvKhoidau.setText(this.language.getRecommendedStarting().toUpperCase());
            this.tvDungCu.setText(this.language.getConsumable().toUpperCase());
            this.tvPhongNgu.setText(this.language.getDefense().toUpperCase());
            this.tvTanCong.setText(this.language.getAttack().toUpperCase());
            this.tvPhepThuat.setText(this.language.getMagic().toUpperCase());
            this.tvDichuyen.setText(this.language.getMovement().toUpperCase());
            this.tvKhac.setText("OTHER");
        }
        this.chkRung.setOnCheckedChangeListener(this);
        this.chkDuong.setOnCheckedChangeListener(this);
        this.chkTieuthu.setOnCheckedChangeListener(this);
        this.chkLoitucvang.setOnCheckedChangeListener(this);
        this.chkPhukien.setOnCheckedChangeListener(this);
        this.chkGiap.setOnCheckedChangeListener(this);
        this.chkMau.setOnCheckedChangeListener(this);
        this.chkHoimau.setOnCheckedChangeListener(this);
        this.chkKhangphep.setOnCheckedChangeListener(this);
        this.chkTocdodanh.setOnCheckedChangeListener(this);
        this.chkChimang.setOnCheckedChangeListener(this);
        this.chkSatthuong.setOnCheckedChangeListener(this);
        this.chkHutmau.setOnCheckedChangeListener(this);
        this.chkGiamthoigianhoichieu.setOnCheckedChangeListener(this);
        this.chkNangluong.setOnCheckedChangeListener(this);
        this.chkHoinangluong.setOnCheckedChangeListener(this);
        this.chkSucmanhphepthuat.setOnCheckedChangeListener(this);
        this.chkGiay.setOnCheckedChangeListener(this);
        this.chkTangtocdochay.setOnCheckedChangeListener(this);
        this.chkKhanghieuung.setOnCheckedChangeListener(this);
        this.chkHutmauphep.setOnCheckedChangeListener(this);
        this.chkKichhoat.setOnCheckedChangeListener(this);
        this.chkLamcham.setOnCheckedChangeListener(this);
        this.chkXuyenkhangphep.setOnCheckedChangeListener(this);
        this.chkXuyengiap.setOnCheckedChangeListener(this);
    }

    private void getData(String sql) {
        if (this.isList) {
            List<Item> mList = ChampDao.getInstant(this.activity).getListItem(sql + SQLConst.KEY_END, Const.MAP_SUMMONER_RIFT);
            ItemListFragment.getInstance();
            ItemListFragment.adapter.filter(mList);
            ItemListFragment.listView.smoothScrollToPosition(0);
            return;
        }
        List<Item> mList = ChampDao.getInstant(this.activity).getListItem(sql + SQLConst.KEY_END, Const.MAP_SUMMONER_RIFT);
        ItemGridFragment.getInstance();
        ItemGridFragment.adapter.filter(mList);
        ItemGridFragment.gridView.smoothScrollToPosition(0);
    }

    private void removeChecked() {
        if (this.chkRung.isChecked()) {
            this.chkRung.setChecked(false);
        }
        if (this.chkDuong.isChecked()) {
            this.chkDuong.setChecked(false);
        }
        if (this.chkTieuthu.isChecked()) {
            this.chkTieuthu.setChecked(false);
        }
        if (this.chkLoitucvang.isChecked()) {
            this.chkLoitucvang.setChecked(false);
        }
        if (this.chkPhukien.isChecked()) {
            this.chkPhukien.setChecked(false);
        }
        if (this.chkGiap.isChecked()) {
            this.chkGiap.setChecked(false);
        }
        if (this.chkMau.isChecked()) {
            this.chkMau.setChecked(false);
        }
        if (this.chkHoimau.isChecked()) {
            this.chkHoimau.setChecked(false);
        }
        if (this.chkKhangphep.isChecked()) {
            this.chkKhangphep.setChecked(false);
        }
        if (this.chkTocdodanh.isChecked()) {
            this.chkTocdodanh.setChecked(false);
        }
        if (this.chkChimang.isChecked()) {
            this.chkChimang.setChecked(false);
        }
        if (this.chkSatthuong.isChecked()) {
            this.chkSatthuong.setChecked(false);
        }
        if (this.chkHutmau.isChecked()) {
            this.chkHutmau.setChecked(false);
        }
        if (this.chkGiamthoigianhoichieu.isChecked()) {
            this.chkGiamthoigianhoichieu.setChecked(false);
        }
        if (this.chkNangluong.isChecked()) {
            this.chkNangluong.setChecked(false);
        }
        if (this.chkHoinangluong.isChecked()) {
            this.chkHoinangluong.setChecked(false);
        }
        if (this.chkSucmanhphepthuat.isChecked()) {
            this.chkSucmanhphepthuat.setChecked(false);
        }
        if (this.chkGiay.isChecked()) {
            this.chkGiay.setChecked(false);
        }
        if (this.chkTangtocdochay.isChecked()) {
            this.chkTangtocdochay.setChecked(false);
        }
        if (this.chkKhanghieuung.isChecked()) {
            this.chkKhanghieuung.setChecked(false);
        }
        if (this.chkLamcham.isChecked()) {
            this.chkLamcham.setChecked(false);
        }
        if (this.chkKichhoat.isChecked()) {
            this.chkKichhoat.setChecked(false);
        }
        if (this.chkXuyenkhangphep.isChecked()) {
            this.chkXuyenkhangphep.setChecked(false);
        }
        if (this.chkXuyengiap.isChecked()) {
            this.chkXuyengiap.setChecked(false);
        }
        if (this.chkHutmauphep.isChecked()) {
            this.chkHutmauphep.setChecked(false);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        } else {
            this.activity = getActivity();
        }
    }
}
