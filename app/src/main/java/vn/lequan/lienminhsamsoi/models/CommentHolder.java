package vn.lequan.lienminhsamsoi.models;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.facebook.login.widget.ProfilePictureView;
import vn.lequan.lienminhsamsoi.R;
import java.util.Calendar;

public class CommentHolder extends ViewHolder {
    private final ProfilePictureView image;
    private final TextView tvBody;
    private final TextView tvTime;
    private final TextView tvUserName;

    public CommentHolder(View itemView) {
        super(itemView);
        this.image = (ProfilePictureView) itemView.findViewById(R.id.image_facebook);
        this.tvUserName = (TextView) itemView.findViewById(R.id.tv_username);
        this.tvBody = (TextView) itemView.findViewById(R.id.tv_body);
        this.tvTime = (TextView) itemView.findViewById(R.id.tv_time);
    }

    public void setData(CommentModer moder) {
        this.tvUserName.setText(moder.getUserName());
        this.tvBody.setText(moder.getBody());
        this.image.setProfileId(moder.getUserId());
        this.tvTime.setText(formatTime(moder.getTimeUpdated()));
    }

    private String formatTime(long milisecond) {
        long currentTime = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milisecond);
        int mYear = calendar.get(1);
        int mMonth = calendar.get(2);
        int mDay = calendar.get(5);
        int hour = calendar.get(11);
        int minute = calendar.get(12);
        int apm = calendar.get(9);
        calendar.setTimeInMillis(currentTime);
        if (currentTime - milisecond < 1471228928) {
            return mDay + " thg " + (mMonth + 1) + " lúc " + hour + ":" + minute + (apm == 0 ? "sa" : "ch");
        }
        return mDay + " thg " + (mMonth + 1) + " " + mYear + " lúc " + hour + ":" + minute + (apm == 0 ? "sa" : "ch");
    }
}
