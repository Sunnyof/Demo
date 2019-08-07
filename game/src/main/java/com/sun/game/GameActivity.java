package com.sun.game;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.sun.game.view.BitmapScaleDownUtil;
import com.sun.game.view.GalleryFlow;
import com.sun.game.view.ImageAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import androidx.annotation.Nullable;

public class GameActivity extends Activity {
    /* 数据段begin */
    private final String TAG = "Gallery3DActivity";
    private Context mContext;
    // 图片缩放倍率（相对屏幕尺寸的缩小倍率）
    public static final int SCALE_FACTOR = 8;
    // 图片间距（控制各图片之间的距离）
    private final int GALLERY_SPACING = -10;
    // 控件
    private GalleryFlow mGalleryFlow;

    /* 数据段end */
    /* 函数段begin */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getBaseContext();
        setContentView(R.layout.activity_game);
        initGallery();
//        String str = "HelloWorld";
//        char[] chars = str.toCharArray();
//        List chars1 = str2List(chars);
//        Collections.shuffle(chars1);
//        for (int i = 0; i < chars1.size(); i++) {
//            System.out.println(chars1.get(i));
//        }
    }

    private void initGallery() {
// 图片ID
        int[] images = {
                R.drawable.ic_launcher,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher};
        ImageAdapter adapter = new ImageAdapter(mContext, images);
// 计算图片的宽高
        int[] dimension = BitmapScaleDownUtil.getScreenDimension(getWindowManager().getDefaultDisplay());
        int imageWidth = dimension[0] / SCALE_FACTOR;
        int imageHeight = dimension[1] / SCALE_FACTOR;
// 初始化图片
        adapter.createImages(imageWidth, imageHeight);
// 设置Adapter，显示位置位于控件中间，这样使得左右均可"无限"滑动
        mGalleryFlow =  findViewById(R.id.gallery_flow);
        mGalleryFlow.setSpacing(GALLERY_SPACING);
        mGalleryFlow.setAdapter(adapter);
        mGalleryFlow.setSelection(Integer.MAX_VALUE / 2);
    }

    public List str2List(char[] chars) {
        List list = new ArrayList();
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }

        return list;
    }
}
