package com.vikrant.org.microserviceslab2rest.controllers.versionings;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikrant.org.microserviceslab2rest.models.Name;
import com.vikrant.org.microserviceslab2rest.models.Person;
import com.vikrant.org.microserviceslab2rest.models.PersonV2;



@RestController
public class PersonController {
    private static List<Person> personList = new ArrayList<>();
    static {
        personList.add(new Person("Vikrant Choudhary"));
        personList.add(new Person("Rhitika Surit"));
        personList.add(new Person("Vaishnavi Choudhary"));
        personList.add(new Person("Varshika Choudhary"));
    }

    private static List<PersonV2> personV2List = new ArrayList<>();
    static {
        personV2List.add(new PersonV2(new Name("Vikrant" ,"Choudhary")));
        personV2List.add(new PersonV2(new Name("Rhitika" ,"Surit")));
        personV2List.add(new PersonV2(new Name("Vaishnavi" ,"Choudhary")));
        personV2List.add(new PersonV2(new Name("Varshika" ,"Choudhary")));
    }

    @GetMapping("/v1/persons")
    public List<Person> getPerson() {
        return personList;
    }
    @GetMapping("/v2/persons")
    public List<PersonV2> getPersonV2() {
        return personV2List;
    }

    @GetMapping(path="/persons",params = "version=1")
    public List<Person> getPersonWithRequestParameter() {
        return personList;
    }
    @GetMapping(path="/persons",params = "version=2")
    public List<PersonV2> getPersonV2WithRequestParameter() {
        return personV2List;
    }

    @GetMapping(path="/persons",headers = "X-API-VERSION=1")
    public List<Person> getPersonWithRequestHeader() {
        return personList;
    }
    @GetMapping(path="/persons",headers  = "X-API-VERSION=2")
    public List<PersonV2> getPersonV2WithRequestHeader() {
        return personV2List;
    }
    @GetMapping(path="/persons",produces =  "application/vnd.company.app-v1+json")
    public List<Person> getPersonWithAccept() {
        return personList;
    }
    @GetMapping(path="/persons",produces =  "application/vnd.company.app-v2+json")
    public List<PersonV2> getPersonV2WithAccept() {
        return personV2List;
    }
}
