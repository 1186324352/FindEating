package eating.find.com.findeating.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import eating.find.com.findeating.R;
import eating.find.com.findeating.model.User;

public class SplashActivity extends Activity {

    private ImageView spalshIV;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        spalshIV= (ImageView) findViewById(R.id.splashIV);
        button= (Button) findViewById(R.id.btn1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User myUser =new User();
                myUser.setUsername("qqr");
                myUser.setPassword("1111");
                myUser.setEmail("1186324354@qq.com");
                myUser.setAge(23);
                myUser.setHeadUrlOffline("urloffline");
                myUser.setHeadUrlOnline("urlonline");
                myUser.setNick("haha");
                myUser.setMobilePhoneNumber("13127609133");
                myUser.setOpenid("fjkdslufe303sdj");

                myUser.signUp(new SaveListener<User>() {
                    @Override
                    public void done(User o, BmobException e) {
                        if(e==null){
                            Log.i("AAAA","success 1");
                        }else{
                            Log.i("AAAA","e:"+e.toString());
                        }
                        if(o!=null){
                            Log.i("AAAA","success 2");
                        }else{
                            Log.i("AAAA","failure 2");
                        }
                    }
                });
            }
        });
    }
}
