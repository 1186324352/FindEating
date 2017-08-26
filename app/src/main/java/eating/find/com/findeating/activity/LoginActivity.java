package eating.find.com.findeating.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import eating.find.com.findeating.R;

/**
 * Created by WIND on 2017/3/30.
 */

public class LoginActivity extends Activity implements View.OnClickListener{
    private TextView createTV;
    private AnimatorSet mRightOutSet;
    private AnimatorSet mLeftInSet;
    private boolean mIsShowBack;
    private CardView loginCard;
    private CardView registerCard;
    private TextView backTV;
    private Button registerBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        backTV= (TextView) findViewById(R.id.backTV);
        createTV= (TextView) findViewById(R.id.createTV);
        loginCard= (CardView) findViewById(R.id.loginCV);
        registerCard= (CardView) findViewById(R.id.registerCV);
        createTV.setOnClickListener(this);
        backTV.setOnClickListener(this);

        setAnimators(); // 设置动画
        setCameraDistance(); // 设置镜头距离
    }

    // 设置动画
    private void setAnimators() {
        mRightOutSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.anim_out);
        mLeftInSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.anim_in);

        // 设置点击事件
        mRightOutSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                if(mIsShowBack){
                    registerCard.setVisibility(View.VISIBLE);
                }
                createTV.setClickable(false);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if(mIsShowBack){
                    loginCard.setVisibility(View.GONE);
                }
                backTV.setClickable(true);
            }
        });
        mLeftInSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                backTV.setClickable(false);
                if(!mIsShowBack){
                    loginCard.setVisibility(View.VISIBLE);
                }
            }

            @Override public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                createTV.setClickable(true);
                if(!mIsShowBack){
                    registerCard.setVisibility(View.GONE);
                }
            }
        });
    }

    /**
     * 改变视角距离, 贴近屏幕
     */
    private void setCameraDistance() {
        int distance = 16000;
        float scale = getResources().getDisplayMetrics().density * distance;
        loginCard.setCameraDistance(scale);
        registerCard.setCameraDistance(scale);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.createTV:
                mIsShowBack = true;
                mRightOutSet.setTarget(loginCard);
                mLeftInSet.setTarget(registerCard);
                mRightOutSet.start();
                mLeftInSet.start();
                break;
            case R.id.backTV:
                mIsShowBack = false;
                mRightOutSet.setTarget(registerCard);
                mLeftInSet.setTarget(loginCard);
                mRightOutSet.start();
                mLeftInSet.start();
                break;

        }
    }


    private String savedCard;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(loginCard.getVisibility()==View.VISIBLE){
                savedCard="loginCard";
                loginCard.setVisibility(View.GONE);
                return true;
            }else if(registerCard.getVisibility()==View.VISIBLE){
                savedCard="loginCard";
                registerCard.setVisibility(View.GONE);
                return true;
            }else{
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }



}
