package eating.find.com.findeating.model;

import cn.bmob.v3.BmobUser;

/**
 * Created by WIND on 2017/3/30.
 * 用户信息
 */
public class User extends BmobUser {
//    username: 用户的用户名（必需）
//    password: 用户的密码（必需）
//    email: 用户的电子邮件地址（可选）
//    emailVerified:邮箱认证状态（可选）
//    mobilePhoneNumber：手机号码（可选）
//    mobilePhoneNumberVerified：手机号码的认证状态（可选）
    /**性别，true是男性，false是女性**/
    private boolean sex;
    /**昵称**/
    private String nick;
    /**年龄**/
    private int age;
    /**网络头像地址**/
    private String headUrlOnline;
    /**本地头像地址**/
    private String headUrlOffline;
    /**第三方平台**/
    private String thirdPlatform;
    /**第三方平台的id**/
    private String openid;
    /**userid**/
    private String userid;
    /**职业**/
    private String profession;
    /**城市**/
    private String city;
    /**省份**/
    private String provinceid;
    /**详细地址**/
    private String detailAddress;
    /**标签**/
    private String tag;

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeadUrlOnline() {
        return headUrlOnline;
    }

    public void setHeadUrlOnline(String headUrlOnline) {
        this.headUrlOnline = headUrlOnline;
    }

    public String getHeadUrlOffline() {
        return headUrlOffline;
    }

    public void setHeadUrlOffline(String headUrlOffline) {
        this.headUrlOffline = headUrlOffline;
    }

    public String getThirdPlatform() {
        return thirdPlatform;
    }

    public void setThirdPlatform(String thirdPlatform) {
        this.thirdPlatform = thirdPlatform;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
