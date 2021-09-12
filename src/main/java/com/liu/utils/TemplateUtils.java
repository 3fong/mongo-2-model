package com.liu.utils;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import com.liu.service.Cube;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TemplateUtils {

    public static String render(List<Cube> fields, String fieldName,String templateName) throws IOException {
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        context.put(fieldName, fields);
        String string = Resources.toString(Resources.getResource(templateName), Charsets.UTF_8);
        String render = jinjava.render(string, context);
        return render;
    }
}
