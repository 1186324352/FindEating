package eating.find.com.findeating;

import android.app.Application;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import eating.find.com.findeating.util.Constants;

/**
 * Created by WIND on 2017/3/30.
 */

public class StartApp extends Application {

    private static StartApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;

        initBmob();
    }

    /**
     * 初始化Bmob
     */
    private void initBmob(){
        BmobConfig config =new BmobConfig.Builder(this)
        //设置appkey
        .setApplicationId(Constants.bmobApplicationID)
        //请求超时时间（单位为秒）：默认15s
        .setConnectTimeout(30)
        //文件分片上传时每片的大小（单位字节），默认512*1024
        .setUploadBlockSize(1024*1024)
        //文件的过期时间(单位为秒)：默认1800s
        .setFileExpiration(2500)
        .build();
        Bmob.initialize(config);
    }


    public static StartApp getInstance(){
        return instance;
    }

}
