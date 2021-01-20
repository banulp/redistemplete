package com.banulp.rediscache.service;

import com.banulp.rediscache.model.BanulpUser;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BanulpUserService {

    @Cacheable(value = "BNPRCT", key = "#uid")
    public BanulpUser getByUid(String uid) {
        return new BanulpUser(uid, uid+"name");
    }

    @CacheEvict(value = "BNPRCT", key = "#uid")
    public void evictByUid(String uid) {
    }

}
