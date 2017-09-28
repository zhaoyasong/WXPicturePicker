package com.zys.yanku.wchatq;

import android.app.Activity;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;

/**
 * @author zhaoyasong
 * @date 28/09/2017 14:51
 * @description 多图选择框架的初始化配置
 */
public class PictureSelectorConfig {
    /**
     * 初始化多张图片选择的配置
     *
     * @param activity
     * @param maxToast
     */
    public static void initMultiConfig(Activity activity, int maxToast) {
        PictureSelector.create(activity)
                // 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .openGallery(PictureMimeType.ofImage())
                //设置主题样式
                .theme(R.style.picture_default_style)
                // 最大图片选择数量
                .maxSelectNum(maxToast)
                // 最小图片选择数量
                .minSelectNum(0)
                // 每行显示的图片个数
                .imageSpanCount(3)
                // 设置图片选择是单选还是多选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .selectionMode(PictureConfig.MULTIPLE)
                // 设置是否可以预览照片
                .previewImage(true)
                // 设置是否可以预览视频
                .previewVideo(false)
                // 设置是否可以播放音频
                .enablePreviewAudio(false)
                // 是否显示拍照按钮
                .isCamera(true)
                // 图片列表点击 缩放效果 默认是true
                .isZoomAnim(true)
                // Glide加载图片大小0-1之间
                .sizeMultiplier(0.5f)
                // 设置自定义的拍照保存路径
                .setOutputCameraPath("/CustomPath")
                // 是否裁剪
                .enableCrop(false)
                // 是否压缩
                .compress(true)
                // 设置系统自带 or 鲁班压缩 PictureConfig.SYSTEM_COMPRESS_MODE or LUBAN_COMPRESS_MODE
                .compressMode(PictureConfig.LUBAN_COMPRESS_MODE)
                // 设置鲁班档次  默认是三档
                .compressGrade(Luban.THIRD_GEAR)
                // 设置压缩的最大值 1MB
                .compressMaxKB(1024)
                // 设置压缩后的宽高比 只有设置了鲁班压缩才有效
                .compressWH(1, 1)
                // 加载宽高 设置越小越流畅 但是会影响图片的清晰度
                .glideOverride(160, 160)
                // 设置裁剪比例  常见的16:9 3:4 3:2 1:1
                .withAspectRatio(16, 9)
                // 设置是否显示uCrop工具栏 默认是不显示
                .hideBottomControls(false)
                // 设置是否显示gif图
                .isGif(false)
                // 设置裁剪框是否可以拖拽
                .freeStyleCropEnabled(true)
                // 设置是否是圆形裁剪 默认是false
                .circleDimmedLayer(false)
                // 设置是否显示裁剪边框
                .showCropFrame(true)
                // 设置是否显示裁剪网格
                .showCropGrid(true)
                // 是否开启点击的声音
                .openClickSound(false)
                // 设置预览图片的时候 是否增强左右滑动图片的体验
                .previewEggs(true)
                // 设置裁剪压缩的质量默认是90
                .cropCompressQuality(90)
                // 设置裁减比
                .cropWH(1, 1)
                // 设置裁剪是否可以旋转图片
                .rotateEnabled(false)
                // 设置裁剪是否可以缩放图片
                .scaleEnabled(true)
                // 设置视频录制的质量
                .videoQuality(1)
                // 设置显示多少秒的视频或者音频
                .videoSecond(10)
                // 设置视频秒数录制
                .recordVideoSecond(60)
                // 设置结果的回调
                .forResult(PictureConfig.CHOOSE_REQUEST);

    }

    /**
     * 初始化单张图片选择的配置
     *
     * @param activity
     */
    public static void initSingleConfig(Activity activity) {
        PictureSelector.create(activity)
                //全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                .openGallery(PictureMimeType.ofImage())
                // 最大图片选择数量
                .maxSelectNum(1)
                // 最小选择数量 int
                .minSelectNum(0)
                // 每行显示个数 int
                .imageSpanCount(3)
                // 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .selectionMode(PictureConfig.SINGLE)
                // 是否可预览图片 true or false
                .previewImage(true)
                // 是否可预览视频 true or false
                .previewVideo(false)
                // 是否可播放音频 true or false
                .enablePreviewAudio(false)
                // 是否显示拍照按钮 true or false
                .isCamera(true)
                // 图片列表点击 缩放效果 默认true
                .isZoomAnim(true)
                // glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .sizeMultiplier(0.5f)
                // 自定义拍照保存路径,可不填
                .setOutputCameraPath("/CustomPath")
                // 是否裁剪 true or false
                .enableCrop(true)
                // 是否压缩 true or false
                .compress(true)
                // luban压缩档次，默认3档 Luban.THIRD_GEAR、Luban.FIRST_GEAR、Luban.CUSTOM_GEAR
                .compressGrade(Luban.THIRD_GEAR)
                //系统自带 or 鲁班压缩 PictureConfig.SYSTEM_COMPRESS_MODE or LUBAN_COMPRESS_MODE
                .compressMode(PictureConfig.LUBAN_COMPRESS_MODE)
                //压缩最大值kb compressGrade()为Luban.CUSTOM_GEAR有效 int
                .compressMaxKB(500)
                // 压缩宽高比 compressGrade()为Luban.CUSTOM_GEAR有效  int
                .compressWH(7, 10)
                // int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .glideOverride(130, 130)
                // int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .withAspectRatio(16, 9)
                // 是否显示uCrop工具栏，默认不显示 true or false
                .hideBottomControls(true)
                // 是否显示gif图片 true or false
                .isGif(false)
                // 裁剪框是否可拖拽 true or false
                .freeStyleCropEnabled(false)
                // 是否圆形裁剪 true or false
                .circleDimmedLayer(true)
                // 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .showCropFrame(false)
                // 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .showCropGrid(false)
                // 是否开启点击声音 true or false
                .openClickSound(false)
//                .selectionMedia(selectList)// 是否传入已选图片 List<LocalMedia> list
                // 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
                .previewEggs(true)
                // 裁剪压缩质量 默认90 int
                .cropCompressQuality(90)
                // 裁剪宽高比，设置如果大于图片本身宽高则无效 int
                .cropWH(1, 1)
                // 裁剪是否可旋转图片 true or false
                .rotateEnabled(true)
                // 裁剪是否可放大缩小图片 true or false
                .scaleEnabled(true)
                // 视频录制质量 0 or 1 int
                .videoQuality(1)
                // 显示多少秒以内的视频or音频也可适用 int
                .videoSecond(10)
                //视频秒数录制 默认60s int
                .recordVideoSecond(60)
                //结果回调onActivityResult code
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

}
