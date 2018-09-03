package toda.cdloving.com.toda.base;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        setContentView(getLayoutId());
        initView();
        initData();
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
