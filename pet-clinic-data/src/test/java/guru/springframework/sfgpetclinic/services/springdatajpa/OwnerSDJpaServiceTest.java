package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/*
@ExtendWith is a repeatable annotation that is used to register extensions for the annotated test class, test interface, test method, parameter, or field.
Annotated parameters are supported in test class constructors, in test methods, and in @BeforeAll, @AfterAll, @BeforeEach, and @AfterEach lifecycle methods.
@ExtendWith fields may be either static or non-static.
 */
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    //Mark a field on which injection should be performed
    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    // initilized a fresh owner before each test
    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findById() {
        //Any long or non-null Long.
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2,owners.size());


    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        //default is i times
        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());

    }

    @Test
    void deleteById() {

        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
       //Enables stubbing methods. Use it when you want the mock to return particular value when particular method is called.
        //Matches anything, including nulls and varargs
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName(LAST_NAME);
        //Verifies certain behavior happened once.
        verify(ownerRepository).findByLastName(any());
    }
}