package com.example.demo;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DozerTest {
    private DozerBeanMapper mapper;

    private void configureMapper(String... mappingFileUrls) {
        mapper.setMappingFiles(Arrays.asList(mappingFileUrls));
    }

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

    @Test
    public void givenSrcAndDestWithDifferentFieldNamesWithCustomMapper_whenMaps_thenCorrect() {
        configureMapper("dozer_mapping.xml");
        Personne frenchAppPerson = new Personne("Sylvester Stallone", "Rambo", 70);
        Person englishAppPerson = mapper.map(frenchAppPerson, Person.class);
        assertEquals(englishAppPerson.getName(), frenchAppPerson.getNom());
        assertEquals(englishAppPerson.getNickname(), frenchAppPerson.getSurnom());
        assertEquals(englishAppPerson.getAge(), frenchAppPerson.getAge());
    }

    @Test
    public void givenSrcAndDest_whenMapsOnlySpecifiedFields_thenCorrect() {
        configureMapper("dozer_mapping2.xml");
        Person englishAppPerson = new Person("Shawn Corey Carter","Jay Z", 46);
        Personne frenchAppPerson = mapper.map(englishAppPerson, Personne.class);

        assertEquals(frenchAppPerson.getNom(), englishAppPerson.getName());
        assertEquals(frenchAppPerson.getSurnom(),englishAppPerson.getNickname());
        assertEquals(frenchAppPerson.getAge(), 0);
    }

}
