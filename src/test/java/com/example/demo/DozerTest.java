package com.example.demo;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DozerTest {
    private DozerBeanMapper mapper;

    @Before
    public void before() throws Exception {
        mapper = new DozerBeanMapper();
    }

    @Test
    public void givenSourceObjectAndDestClass_whenMapsSameNameFieldsCorrectly_thenCorrect() {
        Source source = new Source("Baeldung", 10);
        Dest dest = mapper.map(source, Dest.class);

        assertEquals(dest.getName(), "Baeldung");
        assertEquals(dest.getAge(), 10);
    }


    @Test
    public void givenSourceAndDestWithDifferentFieldTypes_whenMapsAndAutoConverts_thenCorrect() {
        Source2 source = new Source2("320", 15.2);
        Dest2 dest = mapper.map(source, Dest2.class);

        assertEquals(dest.getId(), 320);
        assertEquals(dest.getPoints(), 15);
    }

}
