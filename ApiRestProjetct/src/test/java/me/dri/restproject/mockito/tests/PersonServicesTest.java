package me.dri.restproject.mockito.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import me.dri.restproject.data.vo.v1.PersonVO;
import me.dri.restproject.mapper.custom.PersonMapper;
import me.dri.restproject.mocks.MockPerson;
import me.dri.restproject.model.Person;
import me.dri.restproject.repositories.PersonRepository;
import me.dri.restproject.services.PersonServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

    MockPerson input;

    @InjectMocks
    private PersonServices service;

    @Mock
    PersonRepository repository;

    PersonMapper personMapper = new PersonMapper();

    @BeforeEach
    void setupMocks() throws Exception {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        Person person = input.mockEntity(1);
        Person persisted = person;
        person.setId(1L);
        persisted.setId(1L);

        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);
        when(repository.save(person)).thenReturn(persisted);

        var result =  service.create(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertNotNull(result.toString().contains(""));
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Cpf Test 1", result.getCPF());
        assertEquals("Female", result.getGender());
    }


   /* @Test
    void testFindById() {
        Person entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
    }
*/

    @Test
    void testFindById() {
        Person entity = input.mockEntity(1);;
        entity.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        var result = service.findById(1L);
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Cpf Test 1", result.getCPF());
        assertEquals("Female", result.getGender());
    }

    @Test
    void testFindAll() {
        List<PersonVO> persons = input.mockVOList();
        var resultMock = service.findAll();
        assertNotNull(persons);
        assertEquals(14, persons.size());


    }
}
