package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/* should implement PetService
   Get rid of the generics now because the interface actually implements those
   on the PetService.
 */
@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet,Long> implements PetService {
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
           super.deleteById(id);
    }

    /*
    we refactored the save method to

drop the Id value. So now, we don't care about the Id setting, just like in JPA.

Using Spring Data JPA, we're not going to care about how the Id value gets

generated. We are allowing our persistence layer to do it, which is

exactly what we've done in our Map implementation. We wrote this getNextId,

simple logic. But again, we're trying to refactor things to make things look and

behave like Hibernate.
     */
    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public void delete(Pet pet) {
           super.delete(pet);
    }
}
