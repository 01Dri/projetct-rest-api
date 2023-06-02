package me.dri.restproject.services;


import me.dri.restproject.data.vo.v1.PersonVO;
import me.dri.restproject.data.vo.v2.PersonVOV2;
import me.dri.restproject.exception.ResourceNotFoundDb;
import me.dri.restproject.exception.attributeAlreadyExists;
import me.dri.restproject.mapper.DozerMapper;
import me.dri.restproject.mapper.custom.PersonMapper;
import me.dri.restproject.model.Person;
import me.dri.restproject.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    private PersonRepository personRepository;
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonMapper mapper;

    public PersonVO findById(Long id) {
        logger.info("Searching person by Id");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundDb("Resouce not found"));
        return DozerMapper.parseObj(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO personVO) {
        logger.info("Creating one person!");
        var entity = DozerMapper.parseObj(personVO, Person.class);
        var persons = personRepository.findAll();
        List<String> cpfs = new ArrayList<>();
        for (Person person : persons) {
            cpfs.add(person.getCPF());
        }
        if (cpfs.contains(entity.getCPF())) {
            logger.info("CPF´enviado pelo usuario já existe");
            throw new attributeAlreadyExists("cpf already exists");
        }
            return DozerMapper.parseObj(personRepository.save(entity), PersonVO.class);
        }

    public PersonVOV2 create(PersonVOV2 personVO) {
        logger.info("Creating one person!");
        var entity = mapper.convertEntityToVo(personVO);

        var persons = personRepository.findAll();
        List<String> cpfs = new ArrayList<>();
        for (Person person : persons) {
            cpfs.add(person.getCPF());
        }
        if (cpfs.contains(entity.getCPF())) {
            logger.info("CPF´enviado pelo usuario já existe");
            throw new attributeAlreadyExists("cpf already exists");
        }
        return mapper.convertEntityToVo(personRepository.save(entity));

    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }


    public PersonVO update(Long id, PersonVO personVO) {
        logger.info("Updating one person!");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundDb("Resource not found"));
        entity.setFirstName(personVO.getLastName());
        entity.setLastName(personVO.getLastName());
        entity.setAddress(personVO.getAddress());
        entity.setGender(personVO.getGender());
        var vo =  DozerMapper.parseObj(personRepository.save(entity), PersonVO.class);
        return vo;

    }

}
