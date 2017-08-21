package vn.lequan.lienminhsamsoi.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import vn.lequan.lienminhsamsoi.R;
import vn.lequan.lienminhsamsoi.base.BaseFragment;
import vn.lequan.lienminhsamsoi.models.CommentHolder;
import vn.lequan.lienminhsamsoi.models.CommentModer;
import java.util.Date;

public class CommentFragment extends BaseFragment {
    private EditText editText;
    private FirebaseRecyclerAdapter<CommentModer, CommentHolder> mAdapter;
    private DatabaseReference ref;

    class C08421 implements OnClickListener {
        C08421() {
        }

        public void onClick(View view) {
            if (CommentFragment.this.accessToken != null) {
                CommentModer msg = new CommentModer();
                msg.setUserId(CommentFragment.this.profile.getId());
                msg.setUserName(CommentFragment.this.profile.getName());
                msg.setBody(CommentFragment.this.editText.getText().toString());
                msg.setTimeUpdated(new Date().getTime());
                msg.setConversionId(CommentFragment.this.CHAMP_ID + new Date().getTime());
                msg.setType(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                CommentFragment.this.pushComment(msg);
                return;
            }
            Toast.makeText(CommentFragment.this.activity, "Bạn phải đăng nhập!", 0).show();
        }
    }

    public int getLayoutId() {
        return R.layout.comment_layout;
    }

    public void initView(View view) {
        this.ref = FirebaseDatabase.getInstance().getReference().child("data").child(this.CHAMP_ID);
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.messages_recycler);
        this.editText = (EditText) view.findViewById(R.id.edittext);
        recycler.setHasFixedSize(true);
        recycler.setNestedScrollingEnabled(false);
        recycler.setLayoutManager(new LinearLayoutManager(this.activity));
        ((Button) view.findViewById(R.id.btn_add)).setOnClickListener(new C08421());
        this.mAdapter = new FirebaseRecyclerAdapter<CommentModer, CommentHolder>(CommentModer.class, R.layout.item_comment, CommentHolder.class, this.ref) {
            public void populateViewHolder(CommentHolder holder, CommentModer chatMessage, int position) {
                holder.setData(chatMessage);
            }
        };
        recycler.setAdapter(this.mAdapter);
    }

    private void pushComment(CommentModer guildeModer) {
        this.ref.push().setValue(guildeModer);
    }

    public void initAction() {
    }

    public void initData() {
    }

    public void onDestroy() {
        super.onDestroy();
        this.mAdapter.cleanup();
    }
}
