package me.dri.restproject.mapper.custom;


import me.dri.restproject.data.vo.v1.BooksVO;
import me.dri.restproject.data.vo.v1.PersonVO;
import me.dri.restproject.data.vo.v2.PersonVOV2;
import me.dri.restproject.model.Books;
import me.dri.restproject.model.Person;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setBirthDay(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        vo.setAddress(person.getAddress());
        return vo;

    }

    public Person convertEntityToVo(PersonVOV2 person) {
        Person vo = new Person();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        vo.setAddress(person.getAddress());
        return vo;
    }

    public Person convertyEntityToPerson(PersonVO personVO) {
        Person vo = new Person();
        vo.setId(personVO.getKey());
        vo.setFirstName(personVO.getFirstName());
        vo.setLastName(personVO.getLastName());
        vo.setGender(personVO.getGender());
        vo.setAddress(personVO.getAddress());
        return vo;
    }





}
