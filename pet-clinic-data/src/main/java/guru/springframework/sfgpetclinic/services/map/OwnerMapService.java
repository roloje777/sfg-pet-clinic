package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

/* should implement OwnerService
   Get rid of the generics now because the interface actually implements those
   on the OwnerService.
 */
@Service
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {
    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);

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
    public Owner save(Owner owner) {
        return super.save(owner);
    }

     // to implement later
    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
