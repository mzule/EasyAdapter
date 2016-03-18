package com.github.mzule.easyadapter.sample.viewsupplier;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.mzule.easyadapter.ViewSupplier;
import com.github.mzule.easyadapter.sample.R;
import com.github.mzule.easyadapter.sample.po.Repost;

/**
 * Created by CaoDongping on 3/18/16.
 */
public class RepostViewSupplier extends ViewSupplier<Repost> {
    private TextView nameView;
    private TextView contentView;
    private ImageView avatarView;
    private TextView quoteView;

    public RepostViewSupplier(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.item_repost;
    }

    @Override
    protected void bind() {
        nameView = findViewById(R.id.nameView);
        contentView = findViewById(R.id.contentView);
        avatarView = findViewById(R.id.avatarView);
        quoteView = findViewById(R.id.quoteView);
    }

    @Override
    public void render(int position, Repost repost) {
        nameView.setText(repost.getName());
        contentView.setText(repost.getContent());
        quoteView.setText(String.format("%s: %s", repost.getPost().getName(), repost.getPost().getContent()));
        Glide.with(getContext()).load(repost.getAvatar()).centerCrop().placeholder(R.drawable.placeholder).into(avatarView);
    }
}