package com.banulp.rediscache.model;

import java.io.Serializable;

public class BanulpUser implements Serializable {

    private String uid;
    private String uname;

    public BanulpUser(String uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
