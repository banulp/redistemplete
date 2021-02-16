package com.banulp.rediscache.controller;

import com.banulp.rediscache.model.BanulpUser;
import com.banulp.rediscache.model.BanulpUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/banulpuser")
public class BanulpUserTempleteController {
    @Autowired
    private BanulpUserRepository banulpUserRepository;

    public BanulpUserTempleteController(BanulpUserRepository BanulpUserRepository) {
        banulpUserRepository = BanulpUserRepository;
    }

    @GetMapping("/all")
    public Map<String, BanulpUser> GetAll() {
        return banulpUserRepository.findAll();
    }

    // converter 등록된 것 확인해야
//    @RequestMapping(value = "/all1", produces = MediaType.APPLICATION_XML_VALUE)
//    public Map<String, BanulpUser> GetAll1() {
//        return banulpUserRepository.findAll();
//    }

    @GetMapping("/all/{id}")
    public BanulpUser GetAll(@PathVariable("id") final String id) {
        return banulpUserRepository.findById(id);
    }

    @PostMapping("/add")
    public BanulpUser add(@RequestBody BanulpUser banulpUser) {
        banulpUserRepository.save(new BanulpUser(banulpUser.getUid(), banulpUser.getUname()));
        return banulpUserRepository.findById(banulpUser.getUid());
    }

    @PostMapping("/update")
    public BanulpUser update(@RequestBody BanulpUser banulpUser) {
        banulpUserRepository.update(new BanulpUser(banulpUser.getUid(), banulpUser.getUname()));
        return banulpUserRepository.findById(banulpUser.getUid());
    }
}
