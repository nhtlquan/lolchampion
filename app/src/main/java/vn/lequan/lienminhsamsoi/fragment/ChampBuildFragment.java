package vn.lequan.lienminhsamsoi.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.internal.ShareConstants;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.adapter.ChampGGRoleAdapter;
import vn.lequan.lienminhsamsoi.adapter.ChampGGRoleAdapter.IChampGGListener;
import vn.lequan.lienminhsamsoi.base.BaseFragment;
import vn.lequan.lienminhsamsoi.championgg.ChampionGG;
import vn.lequan.lienminhsamsoi.championgg.DataRole;
import vn.lequan.lienminhsamsoi.championgg.ItemFrequent;
import vn.lequan.lienminhsamsoi.championgg.Role;
import vn.lequan.lienminhsamsoi.dao.ChampDao;
import vn.lequan.lienminhsamsoi.models.ChampGuildeModel;
import vn.lequan.lienminhsamsoi.models.CommentHolder;
import vn.lequan.lienminhsamsoi.models.CommentModer;
import vn.lequan.lienminhsamsoi.models.UserData;
import vn.lequan.lienminhsamsoi.ultis.Const;
import vn.lequan.lienminhsamsoi.ultis.Utils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChampBuildFragment extends BaseFragment implements IChampGGListener {
    private static final int MODE_CREATE = 0;
    private static final int MODE_UPDATE = 1;
    private AsyncTask asyncTask;
    private ImageView btnUpdate;
    private Button button;
    private CallbackManager callbackManager;
    private EditText editText;
    private View layoutEditer;
    private LoginButton loginButton;
    private FirebaseRecyclerAdapter<CommentModer, CommentHolder> mAdapter;
    private ProfileTracker mProfileTracker;
    private View mView;
    private ProgressBar progressBar;
    private RecyclerView rclRole;
    private RecyclerView recycler;
    private DatabaseReference ref;
    private TextView tvCaution;
    private TextView tvDownloading;
    private TextView tvHeader;
    private TextView tvLaneName;
    private TextView tvLoadcomment;
    private TextView tvTimeUpdate;

    class C08391 implements OnClickListener {
        C08391() {
        }

        public void onClick(View view) {
            if (ChampBuildFragment.this.profile != null) {
                CommentModer msg = new CommentModer();
                msg.setUserId(ChampBuildFragment.this.profile.getId());
                msg.setUserName(ChampBuildFragment.this.profile.getName());
                msg.setBody(ChampBuildFragment.this.editText.getText().toString());
                msg.setTimeUpdated(new Date().getTime());
                msg.setConversionId(ChampBuildFragment.this.CHAMP_ID + new Date().getTime());
                msg.setType(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                ChampBuildFragment.this.pushComment(msg);
                return;
            }
            Toast.makeText(ChampBuildFragment.this.activity, "Bạn phải đăng nhập!", 0).show();
        }
    }

    class C08402 implements OnClickListener {
        C08402() {
        }

        public void onClick(View view) {
            if (Utils.isNetworkAvailable(ChampBuildFragment.this.activity)) {
                ChampBuildFragment.this.asyncTask = new DownloadHtml(1).execute(new String[]{ChampBuildFragment.this.CHAMP_ID});
                return;
            }
            Toast.makeText(ChampBuildFragment.this.activity, "Không có kết nối internet!", 0).show();
        }
    }

    class CreateData extends AsyncTask<ChampGuildeModel, Integer, Void> {
        List<ChampGuildeModel> list = new ArrayList();

        CreateData() {
        }

        protected Void doInBackground(ChampGuildeModel... champGuildeModels) {
            this.list = ChampBuildFragment.this.getData(champGuildeModels);
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ChampDao.getInstant(ChampBuildFragment.this.activity).createDataGuilde(this.list);
            ChampBuildFragment.this.setChampionGGOffline();
        }
    }

    class DownloadHtml extends AsyncTask<String, Integer, String> {
        List<ChampGuildeModel> list = new ArrayList();
        int mode;

        DownloadHtml(int mode) {
            this.mode = mode;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            ChampBuildFragment.this.tvDownloading.setVisibility(8);
            ChampBuildFragment.this.mView.setVisibility(8);
            ChampBuildFragment.this.progressBar.setVisibility(0);
        }

        protected String doInBackground(String... roles) {
            for (String champId : roles) {
                try {
                    for (String role : ChampionGG.getInstance().getRoleName(ChampionGG.getInstance().getDocument(champId, ""))) {
                        this.list.add(new ChampGuildeModel(null, champId, role, ""));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            if (this.list != null) {
                ChampGuildeModel[] arr = (ChampGuildeModel[]) this.list.toArray(new ChampGuildeModel[this.list.size()]);
                if (this.mode == 0) {
                    new CreateData().execute(arr);
                } else if (this.mode == 1) {
                    new UpdateData().execute(arr);
                }
            }
        }
    }

    class UpdateData extends AsyncTask<ChampGuildeModel, Integer, Void> {

        List<ChampGuildeModel> list = new ArrayList();

        UpdateData() {
        }

        protected Void doInBackground(ChampGuildeModel... voids) {
            this.list = ChampBuildFragment.this.getData(voids);
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            for (ChampGuildeModel model : this.list) {
                ChampDao.getInstant(ChampBuildFragment.this.activity).updateDataGuilde(model.getChampId(), model.getRoleId(), model.getBody());
            }
            ChampBuildFragment.this.setChampionGGOffline();
            ChampBuildFragment.this.progressBar.setVisibility(8);
            ChampBuildFragment.this.mView.setVisibility(0);
        }
    }

    class C14743 implements FacebookCallback<LoginResult> {

        class C14731 extends ProfileTracker {
            C14731() {
            }

            protected void onCurrentProfileChanged(Profile profileOld, Profile profile) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(Const.ROOT_USER);
                UserData userData = new UserData();
                userData.setUserId(profile.getId());
                userData.setUserName(profile.getName());
                userData.setImageUrl(profile.getProfilePictureUri(Callback.DEFAULT_DRAG_ANIMATION_DURATION, Callback.DEFAULT_DRAG_ANIMATION_DURATION).toString());
                userData.setJoinDate(new Date().getTime());
                ref.child(profile.getId()).setValue(userData);
                ChampBuildFragment.this.mProfileTracker.stopTracking();
            }
        }

        C14743() {
        }

        public void onSuccess(LoginResult loginResult) {
            ChampBuildFragment.this.tvCaution.setVisibility(8);
            ChampBuildFragment.this.loginButton.setVisibility(8);
            ChampBuildFragment.this.layoutEditer.setVisibility(0);
            if (Profile.getCurrentProfile() == null) {
                ChampBuildFragment.this.mProfileTracker = new C14731();
            } else {
                Log.v("facebook - profile", Profile.getCurrentProfile().getFirstName());
            }
        }

        public void onCancel() {
        }

        public void onError(FacebookException exception) {
        }
    }

    public int getLayoutId() {
        return R.layout.fragment_champ_build;
    }

    public void initView(View view) {
        this.tvCaution = (TextView) view.findViewById(R.id.tv_cauntion);
        this.loginButton = (LoginButton) view.findViewById(R.id.login_facebook_button);
        this.layoutEditer = view.findViewById(R.id.layout_editer);
        this.tvLoadcomment = (TextView) view.findViewById(R.id.tv_load_comment);
        this.rclRole = (RecyclerView) view.findViewById(R.id.rcl_role_champ);
        this.tvHeader = (TextView) view.findViewById(R.id.tv_header);
        this.tvTimeUpdate = (TextView) view.findViewById(R.id.tv_time_update);
        this.mView = view.findViewById(R.id.container_layout);
        this.tvLaneName = (TextView) view.findViewById(R.id.tv_lane_name);
        this.btnUpdate = (ImageView) view.findViewById(R.id.btn_update);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.tvDownloading = (TextView) view.findViewById(R.id.tv_downloading);
        this.editText = (EditText) view.findViewById(R.id.edittext);
        this.recycler = (RecyclerView) view.findViewById(R.id.messages_recycler);
        this.recycler.setHasFixedSize(false);
        this.recycler.setNestedScrollingEnabled(false);
        this.recycler.setLayoutManager(new LinearLayoutManager(this.activity));
        this.button = (Button) view.findViewById(R.id.btn_add);
    }

    public void initAction() {
        this.profile = Profile.getCurrentProfile();
        this.button.setOnClickListener(new C08391());
        this.btnUpdate.setOnClickListener(new C08402());
    }

    public void initData() {
        setChampionGGOffline();
    }

    private void pushComment(CommentModer guildeModer) {
        this.ref.push().setValue(guildeModer);
    }

    private void setUpComment() {
        if (this.profile == null) {
            this.tvCaution.setVisibility(0);
            this.loginButton.setVisibility(0);
            this.layoutEditer.setVisibility(8);
            this.callbackManager = Factory.create();
            this.loginButton.setReadPermissions("email");
            this.loginButton.setReadPermissions("public_profile");
            this.loginButton.setFragment((Fragment) this);
            this.loginButton.registerCallback(this.callbackManager, new C14743());
        } else {
            this.tvCaution.setVisibility(8);
            this.loginButton.setVisibility(8);
            this.layoutEditer.setVisibility(0);
        }
        this.ref = FirebaseDatabase.getInstance().getReference().child("data").child(this.CHAMP_ID);
        this.mAdapter = new FirebaseRecyclerAdapter<CommentModer, CommentHolder>(CommentModer.class, R.layout.item_comment, CommentHolder.class, this.ref) {
            public void populateViewHolder(CommentHolder holder, CommentModer chatMessage, int position) {
                ChampBuildFragment.this.tvLoadcomment.setVisibility(8);
                holder.setData(chatMessage);
            }
        };
        this.recycler.setAdapter(this.mAdapter);
    }

    public void onPickLane(Role role) {
        String data = ChampDao.getInstant(this.activity).getChampGuilde(this.CHAMP_ID, role.getRole());
        if (data == null) {
            Toast.makeText(this.activity, "No data!", 0).show();
            return;
        }
        initDataRoleGuilde(data);
        if (Utils.getLanguageCode(this.activity).equals("vn_VN")) {
            this.tvLaneName.setText(translate(role.getRole()));
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private String translate(String lane) {
        String obj = "";
        switch (lane.hashCode()) {
            case -2064978723:
                if (lane.equals("Jungle")) {
                    obj = "Jungle";
                    break;
                }
                break;
            case -1990474315:
                if (lane.equals("Middle")) {
                    obj = "Middle";
                    break;
                }
                break;
            case -190113873:
                if (lane.equals("Support")) {
                    obj = "Support";
                    break;
                }
                break;
            case 64640:
                if (lane.equals("ADC")) {
                    obj = "ADC";
                    break;
                }
                break;
            case 84277:
                if (lane.equals("Top")) {
                    obj = "Top";
                    break;
                }
                break;
        }
        switch (obj) {
            case "Jungle":
                return "RỪNG";
            case "Top":
                return "ĐƯỜNG TRÊN";
            case "Middle":
                return "ĐƯỜNG GIỮA";
            case "Support":
                return "HỖ TRỢ";
            case "ADC":
                return "ĐƯỜNG DƯỚI";
            default:
                return lane;
        }
    }

    private void setChampionGGOffline() {
        DataRole dataRole = ChampDao.getInstant(this.activity).getDataRole(this.CHAMP_ID);
        if (dataRole != null) {
            initRole(dataRole);
            initDataRoleGuilde(ChampDao.getInstant(this.activity).getChampGuilde(this.CHAMP_ID, ((Role) dataRole.getRoles().get(0)).getRole()));
            this.tvDownloading.setVisibility(8);
            this.mView.setVisibility(0);
            return;
        }
        this.tvDownloading.setVisibility(0);
        this.mView.setVisibility(8);
        if (Utils.isNetworkAvailable(this.activity)) {
            this.asyncTask = new DownloadHtml(0).execute(new String[]{this.CHAMP_ID});
        }
    }

    private void initRole(DataRole dataRole) {
        this.tvHeader.setText(dataRole.getHeader().substring(0, 11));
        this.tvTimeUpdate.setText("(Last updated: " + dataRole.getTimeUpdate() + ")");
        ChampGGRoleAdapter adapter = new ChampGGRoleAdapter(dataRole.getRoles(), this);
        this.rclRole.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        this.rclRole.setAdapter(adapter);
        this.mView.setVisibility(0);
        if (Utils.getLanguageCode(this.activity).equals("vn_VN")) {
            this.tvLaneName.setText(translate(((Role) dataRole.getRoles().get(0)).getRole()));
        }
    }

    private void initDataRoleGuilde(String itemFrequent) {
        try {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            ChampBuildChildFragment fragment = new ChampBuildChildFragment();
            Bundle bundle = new Bundle();
            bundle.putString("html", itemFrequent);
            fragment.setArguments(bundle);
            transaction.addToBackStack(null);
            transaction.replace(R.id.fragment_core, fragment, null);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<ChampGuildeModel> getData(ChampGuildeModel[] arr) {
        List<ChampGuildeModel> list = new ArrayList();
        Gson gson = new Gson();
        for (ChampGuildeModel model : arr) {
            try {
                String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
                ItemFrequent itemFrequent = ChampionGG.getInstance().getDataChampionGG(ChampionGG.getInstance().getDocument(model.getChampId(), model.getRoleId()));
                itemFrequent.getDataRole().setTimeUpdate(date);
                list.add(new ChampGuildeModel(null, model.getChampId(), model.getRoleId(), gson.toJson(itemFrequent)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.asyncTask != null) {
            this.asyncTask.cancel(true);
            Log.e("asytask cancel: ", "ok");
        }
    }
}
