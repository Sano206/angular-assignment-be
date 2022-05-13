package com.assignment.backend.controllers;

import com.assignment.backend.requestModels.PersonInput;
import com.assignment.backend.model.Person;
import com.assignment.backend.requestModels.PersonOut;
import com.assignment.backend.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonDetail(@PathVariable int id){
        return commonService.getDetail(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpStatus delete(@PathVariable int id){
        commonService.delete(id);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HttpStatus login(){
        return HttpStatus.OK;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Person createNewPerson(@RequestBody PersonInput personInput){
        return commonService.saveNew(personInput);
    }

    @RequestMapping(value = "/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    public PersonOut getAll(@PathVariable int pageIndex, @PathVariable int pageSize){

        return commonService.getAllPaged(pageIndex, pageSize);
    }
}
