package toda.cdloving.com.toda.util;

import android.content.Context;
import android.content.SharedPreferences;

import io.reactivex.annotations.Nullable;
import toda.cdloving.com.toda.base.Const;

/**
 * @author CDLoving
 */
public class SharedUtil {

    /**
     * 保存在手机里面的文件名
     */
    private static final String FILE_NAME = "share_date";

    /**
     * @param context 上下文
     * @param key 键
     * @param value 值
     */
    public static void setParam(Context context, String key, Object value) {

        String type = value.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(Const.DATA_TYPE_STRING.equals(type)){
            editor.putString(key, (String)value);
        }
        else if(Const.DATA_TYPE_INTEAGER.equals(type)){
            editor.putInt(key, (Integer)value);
        }
        else if(Const.DATA_TYPE_BOOLEAN.equals(type)){
            editor.putBoolean(key, (Boolean)value);
        }
        else if(Const.DATA_TYPE_FLOAT.equals(type)){
            editor.putFloat(key, (Float)value);
        }
        else if(Const.DATA_TYPE_LONG.equals(type)){
            editor.putLong(key, (Long)value);
        }
        editor.apply();
    }

    /**
     * @param context 上下文
     * @param key 键
     * @param defaultValue 默认值
     * @return 返回值
     */
    public static Object getParam(Context context , String key, @Nullable Object defaultValue){
        String type = defaultValue.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        if(Const.DATA_TYPE_STRING.equals(type)){
            return sp.getString(key, (String)defaultValue);
        }

        else if(Const.DATA_TYPE_INTEAGER.equals(type)){
            return sp.getInt(key, (Integer)defaultValue);
        }

        else if(Const.DATA_TYPE_BOOLEAN.equals(type)){
            return sp.getBoolean(key, (Boolean)defaultValue);
        }

        else if(Const.DATA_TYPE_FLOAT.equals(type)){
            return sp.getFloat(key, (Float)defaultValue);
        }

        else if(Const.DATA_TYPE_LONG.equals(type)){
            return sp.getLong(key, (Long)defaultValue);
        }

        return null;
    }

    /**
     * 清除所有数据
     * @param context 上下文
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().apply();
    }

    /**
     * 清除指定数据
     * @param context 上下文
     */
    public static void clearAll(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key).apply();
    }
}
