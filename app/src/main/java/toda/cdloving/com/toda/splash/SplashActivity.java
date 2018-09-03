package toda.cdloving.com.toda.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

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

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent();
            if (TextUtils.isEmpty((CharSequence) SharedUtil.getParam(SplashActivity.this, Const.SHARED_KEY_LOGIN, ""))) {
                intent.setClass(SplashActivity.this, LoginActivity.class);
            }
            else {
                intent.setClass(SplashActivity.this, TodoActivity.class);
            }
            startActivity(intent);
            finish();
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        handler.sendEmptyMessageDelayed(0,3000);
    }
}
