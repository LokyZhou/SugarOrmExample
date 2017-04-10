package com.example.denzel.sugarormexample;

import com.orm.SugarRecord;

/**
 * Created by zhouzhirui on 2017/4/10.
 */

public class User extends SugarRecord {
    String mAccount;
    String mPassword;

    public User(){

    }

    public User(String mAccount, String mPassword){
        this.mAccount = mAccount;
        this.mPassword = mPassword;
    }
}
