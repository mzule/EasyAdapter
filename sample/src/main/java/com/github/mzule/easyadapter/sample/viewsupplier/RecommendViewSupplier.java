package com.github.mzule.easyadapter.sample.viewsupplier;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.mzule.easyadapter.ViewSupplier;
import com.github.mzule.easyadapter.sample.R;
import com.github.mzule.easyadapter.sample.po.Recommend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CaoDongping on 3/18/16.
 */
public class RecommendViewSupplier extends ViewSupplier<Recommend> {
    private List<ImageView> imageViews;
    private List<TextView> textViews;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.item_recommend;
    }

    @Override
    protected void bind() {
        imageViews = new ArrayList<>();
        textViews = new ArrayList<>();

        ViewGroup imageContainer = findViewById(R.id.imageContainer);
        for (int i = 0; i < imageContainer.getChildCount(); i++) {
            if (imageContainer.getChildAt(i) instanceof ImageView) {
                imageViews.add((ImageView) imageContainer.getChildAt(i));
            }
        }

        ViewGroup nameContainer = findViewById(R.id.nameContainer);
        for (int i = 0; i < nameContainer.getChildCount(); i++) {
            if (nameContainer.getChildAt(i) instanceof TextView) {
                textViews.add((TextView) nameContainer.getChildAt(i));
            }
        }
    }

    @Override
    public void render(int position, Recommend recommend) {
        for (int i = 0; i < recommend.getUsers().length; i++) {
            Glide.with(getContext()).load(recommend.getUsers()[i].getAvatar()).centerCrop().placeholder(R.drawable.placeholder).into(imageViews.get(i));
            textViews.get(i).setText(recommend.getUsers()[i].getName());
        }
    }
}
