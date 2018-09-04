package toda.cdloving.com.toda.login;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;
import toda.cdloving.com.toda.R;
import toda.cdloving.com.toda.base.BaseActivity;
import toda.cdloving.com.toda.base.Const;
import toda.cdloving.com.toda.base.RequestConst;
import toda.cdloving.com.toda.model.Register;
import toda.cdloving.com.toda.okhttp.CallBackUtil;
import toda.cdloving.com.toda.okhttp.OkhttpUtil;
import toda.cdloving.com.toda.util.ToastUtil;

/**
 * @author CDLoving create at 2018/9/4
 * @des 注册页面Activity
 */
public class RegisterActivity extends BaseActivity {
    @BindView(R.id.edt_register_name)
    EditText mEdtRegisterName;
    @BindView(R.id.edt_register_psw)
    EditText mEdtRegisterPsw;
    @BindView(R.id.edt_confirm_psw)
    EditText mEdtConfirmPsw;
    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.btn_register)
    void onClick(View view) {
        if (TextUtils.isEmpty(mEdtRegisterName.getText())) {
            ToastUtil.showShort(this, Const.INPUT_REGISTER_NAME_TIP);
            return;
        }
        if (TextUtils.isEmpty(mEdtRegisterPsw.getText())) {
            ToastUtil.showShort(this, Const.INPUT_REGISTER_PSW_TIP);
            return;
        }
        if (TextUtils.isEmpty(mEdtConfirmPsw.getText())) {
            ToastUtil.showShort(this, Const.INPUT_COMFIRM_PSW_TIP);
            return;
        }

        Map<String, String> params = new HashMap<>();
        params.put(Register.USERNAME, mEdtRegisterName.getText().toString());
        params.put(Register.PASSWORD, mEdtRegisterPsw.getText().toString());
        params.put(Register.REPASSWORD, mEdtConfirmPsw.getText().toString());
        OkhttpUtil.okHttpPost(RequestConst.HOST, params, new CallBackUtil() {
            @Override
            public Object onParseResponse(Call call, Response response) {
                return null;
            }

            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onResponse(Object response) {

            }
        });
    }
}
