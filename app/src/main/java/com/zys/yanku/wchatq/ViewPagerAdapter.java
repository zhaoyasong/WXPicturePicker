package com.zys.yanku.wchatq;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * @author zhaoyasong
 * @date 28/09/2017 15:47
 * @description 创建ViewPager的适配器
 */
public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<String> imgList;

    public ViewPagerAdapter(Context context, List<String> imgList) {
        this.context = context;
        this.imgList = imgList;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return imgList.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    private View getItemView(int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, null, false);
        return itemView;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = getItemView(R.layout.view_pager_img);
        PhotoView imageView = (PhotoView) itemView.findViewById(R.id.img_iv);
        Glide.with(context).load(imgList.get(position)).into(imageView);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
