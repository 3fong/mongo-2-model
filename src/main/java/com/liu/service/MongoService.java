package com.liu.service;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import com.liu.utils.TemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("mongoService")
public class MongoService {
    @Autowired
    private CubeRepository crudRepository;

    public void write() throws IOException {
        System.out.println("writing...............");
        Iterable<Cube> all = crudRepository.findAll();
        List<Cube> cubes = new ArrayList();
        all.forEach(cube -> {
            cubes.add(cube);
        });
        String render = TemplateUtils.render(cubes,"fields","template/java/model.jinja");
        System.out.println(render);
    }


}
