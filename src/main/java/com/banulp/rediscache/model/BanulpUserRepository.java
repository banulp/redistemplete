package com.banulp.rediscache.model;

import java.util.Map;

public interface BanulpUserRepository {
    void save(BanulpUser user);

    Map<String, BanulpUser> findAll();

    BanulpUser findById(String id);

    void update(BanulpUser user);

    void delete(String id);
}
