package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/* should implement OwnerService
   Get rid of the generics now because the interface actually implements those
   on the OwnerService.
 */
@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    /* we need these services spo that we can save the pets to the owner */
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


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
        /*  if the owner is null return null
            else
                if the owners has pets, get these pets
                    if the pet type exists
                       and petType id is null then save the pet type and set it
                    else
                        throw an exception as pet type is rquired
                    get the pet id
                        save and set the pet
         */
        if(owner!= null){
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if (pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(owner);

        } else {
            return null;
        }
    }

     // to implement later
    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
