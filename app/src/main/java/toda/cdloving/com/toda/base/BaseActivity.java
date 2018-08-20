package toda.cdloving.com.toda.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    /**
     * @return 布局文件
     */
    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    public void showProgress() {
        //TODO 页面加载动画展示
    }

    public void hideProgress() {
        //TODO 页面加载动画隐藏
    }

    public void replaceFragment(Fragment fragment, int layoutId) {
        //TODO Fragment替换
    }
}
