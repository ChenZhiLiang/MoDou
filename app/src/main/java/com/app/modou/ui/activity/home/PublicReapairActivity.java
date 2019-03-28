package com.app.modou.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;
import com.app.modou.core.helper.PermissionHelper;
import com.app.modou.core.helper.PictureSelectorHelper;
import com.app.modou.core.permission.Permission;
import com.app.modou.ui.adapter.GridImageAdapter;
import com.app.modou.view.FullyGridLayoutManager;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: PublicReapairActivity
 * @Description: 公共报修
 * @CreateDate: 2019/3/19 11:21
 * @Version: 1.0
 */
public class PublicReapairActivity extends BaseActivity implements GridImageAdapter.onAddPicClickListener, GridImageAdapter.OnItemClickListener {
    @BindView(R.id.recycler_img)
    RecyclerView recycler_img;
    private List<LocalMedia> selectList = new ArrayList<>();
    private GridImageAdapter adapter;
    private int maxSelectNum = 3;

    @Override
    public int getLayoutId() {
        return R.layout.activity_public_reapair;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        initToolBar();
        showOrHideToolBarNavigation(true);
        setTitle("公共报修");
    }

    @Override
    public String returnToolBarTitle() {
        return null;
    }

    @Override
    public void initView() {
        FullyGridLayoutManager manager = new FullyGridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recycler_img.setLayoutManager(manager);
        adapter = new GridImageAdapter(this, this);
        adapter.setList(selectList);
        adapter.setSelectMax(maxSelectNum);
        recycler_img.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onAddPicClick() {
        if (new PermissionHelper().RequestPermisson(this, Permission.CAMERA)) {
            PictureSelectorHelper.PictureSelector(this, maxSelectNum, selectList);
        }
    }

    @Override
    public void onItemClick(int position, View v) {
        if (selectList.size() > 0) {
            LocalMedia media = selectList.get(position);
            String pictureType = media.getPictureType();
            int mediaType = PictureMimeType.pictureToVideo(pictureType);
            switch (mediaType) {
                case 1:
                    // 预览图片 可自定长按保存路径
                    //PictureSelector.create(MainActivity.this).externalPicturePreview(position, "/custom_file", selectList);
                    PictureSelector.create(this).externalPicturePreview(position, selectList);
                    break;
                case 2:
                    // 预览视频
                    PictureSelector.create(this).externalPictureVideo(media.getPath());
                    break;
                case 3:
                    // 预览音频
                    PictureSelector.create(this).externalPictureAudio(media.getPath());
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                        for (LocalMedia media : selectList) {
                        Log.i("图片-----》", media.getPath());
                    }
                    adapter.setList(selectList);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }
}
