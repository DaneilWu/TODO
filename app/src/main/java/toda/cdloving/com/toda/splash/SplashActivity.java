package toda.cdloving.com.toda.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import toda.cdloving.com.toda.R;
import toda.cdloving.com.toda.base.BaseActivity;
import toda.cdloving.com.toda.base.Const;
import toda.cdloving.com.toda.login.LoginActivity;
import toda.cdloving.com.toda.todolist.TodoActivity;
import toda.cdloving.com.toda.util.SharedUtil;

/**
 * @author CDLoving
 * @deprecated APP启动页面，验证用户是否已经登录
 */
public class SplashActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        Intent intent = new Intent();
        if (TextUtils.isEmpty((CharSequence) SharedUtil.getParam(this, Const.SHARED_KEY_LOGIN, null))) {
            intent.setClass(this, LoginActivity.class);
        }
        else {
            intent.setClass(this, TodoActivity.class);
        }
        startActivity(intent);
    }
}
