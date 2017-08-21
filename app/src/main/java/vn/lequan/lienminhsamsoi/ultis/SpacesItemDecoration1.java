package vn.lequan.lienminhsamsoi.ultis;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class SpacesItemDecoration1 extends ItemDecoration {
    private int space;

    public SpacesItemDecoration1(int space) {
        this.space = space;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
        outRect.left = this.space;
        outRect.right = this.space;
        outRect.bottom = this.space;
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = 0;
        } else {
            outRect.top = this.space;
        }
    }
}
