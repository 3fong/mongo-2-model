package com.liu;

import com.liu.service.Cube;
import com.liu.utils.TemplateUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaTemplateTest {


    @Test
    public void renderTest() throws IOException {
        List<Cube> cubes = new ArrayList<>();
        cubes.add(new Cube("top", Arrays.asList("a","b","c")));
        String render = TemplateUtils.render(cubes,"fields","template/java/model.jinja");
        System.out.println(render);
    }
}
