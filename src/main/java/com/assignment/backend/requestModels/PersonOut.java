package com.assignment.backend.requestModels;

import com.assignment.backend.model.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PersonOut {
    List<Person> personList;
    int totalElements;

    public PersonOut(List<Person> personList, int totalElements) {
        this.personList = personList;
        this.totalElements = totalElements;
    }
}
