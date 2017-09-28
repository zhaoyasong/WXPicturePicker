package com.zys.yanku.wchatq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class PlusImageActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ArrayList<String> mImaList;
    private int mPosition;
    private ViewPager mViewPager;
    private TextView mPositionTv;
    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus_image);
        init();
    }

    private void init() {
        //获取传递过来的数据
        mImaList = getIntent().getStringArrayListExtra(Constants.IMG_LIST);
        mPosition = getIntent().getIntExtra(Constants.POSITION, 0);
        //初始化控件
        initWidget();
    }

    private void initWidget() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mPositionTv = (TextView) findViewById(R.id.position_tv);
        //返回的点击事件
        findViewById(R.id.back_iv).setOnClickListener(this);
        findViewById(R.id.delete_iv).setOnClickListener(this);
        //设置ViewPager切换的事件监听
        mViewPager.addOnPageChangeListener(this);

        mAdapter = new ViewPagerAdapter(PlusImageActivity.this, mImaList);
        mViewPager.setAdapter(mAdapter);
        mPositionTv.setText(mPosition + 1 + "/" + mImaList.size());
        mViewPager.setCurrentItem(mPosition);
    }

    /**
     * 定义删除图片的方法
     */
    private void deletePic() {
        CancelOrOkDialog dialog = new CancelOrOkDialog(PlusImageActivity.this, "要删除这张图片吗？") {
            @Override
            public void ok() {
                super.ok();
                //从数据源移除要删除的图片
                mImaList.remove(mPosition);
                setPosition();
                dismiss();
            }
        };
        dialog.show();

    }

    /**
     * 设置当前显示的位置
     */
    private void setPosition() {
        mPositionTv.setText(mPosition + 1 + "/" + mImaList.size());
        mViewPager.setCurrentItem(mPosition);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 定义方法返回上一个界面
     */
    private void back() {
        Intent intent = getIntent();
        intent.putStringArrayListExtra(Constants.IMG_LIST, mImaList);
        setResult(Constants.RESULT_CODE_VIEW_IMG, intent);
        finish();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_iv:
                back();
                break;
            case R.id.delete_iv:
                deletePic();
                break;
            default:
                break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mPosition = position;
        mPositionTv.setText(position + 1 + "/" + mImaList.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //如果返回键被按下
            back();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
