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

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(),owner);
    }

     // to implement later
    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
