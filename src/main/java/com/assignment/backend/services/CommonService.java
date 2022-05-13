package com.assignment.backend.services;

import com.assignment.backend.requestModels.PersonInput;
import com.assignment.backend.model.Person;
import com.assignment.backend.repos.AddressRepository;
import com.assignment.backend.repos.CompanyRepository;
import com.assignment.backend.repos.GeoRepository;
import com.assignment.backend.repos.PersonRepository;
import com.assignment.backend.requestModels.PersonOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private GeoRepository geoRepository;

    public Person getDetail(int id){
        Optional<Person> person = personRepository.findPersonById(id);
        return person.orElse(null);
    }
    public Person saveNew(PersonInput personInput){
        return personRepository.save(personInputToPerson(personInput));
    }

    public PersonOut getAllPaged(int pageIndex, int pageSize) {
        List<Person> personList = personRepository.findAll();
        int totalElements = personList.size();
        int end = (pageIndex +1)*pageSize;
        if(end > totalElements){
            end = totalElements;

        }
        List<Person> sliced = personList.subList(pageIndex * pageSize, end);
        return new PersonOut(sliced, totalElements);
    }

    private Person personInputToPerson(PersonInput personInput){
        Person person = new Person();
        person.getAddress().setStreet(personInput.getStreet());
        person.getAddress().setSuite(personInput.getSuite());
        person.getAddress().setCity(personInput.getCity());
        person.getAddress().setZipcode(personInput.getZipcode());
        person.getAddress().getGeo().setLat(personInput.getLat());
        person.getAddress().getGeo().setLng(personInput.getLng());
        person.setName(personInput.getName());
        person.setUsername(personInput.getUsername());
        person.setEmail(personInput.getEmail());
        person.setEmail(personInput.getEmail());
        person.setPhone(personInput.getPhone());
        person.setWebsite(personInput.getWebsite());
        person.getCompany().setName(personInput.getCompanyName());
        person.getCompany().setCatchPhrase(personInput.getCatchPhrase());
        person.getCompany().setBs(personInput.getBs());
        return person;
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }
}
