package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;

import java.util.Set;

/* should implement OwnerService
   Get rid of the generics now because the interface actually implements those
   on the OwnerService.
 */
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
         super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(),vet);
    }
}
