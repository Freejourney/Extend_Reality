package com.example.admin.extend_reality;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {
    private String Avatorurl;

    public String getAvatorurl() {
        return Avatorurl;
    }

    public void setAvatorurl(String avatorurl) {
        Avatorurl = avatorurl;
    }

}
