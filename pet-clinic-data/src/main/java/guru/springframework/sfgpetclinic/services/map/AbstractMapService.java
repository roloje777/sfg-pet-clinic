package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

/*
   Java generics. We're saying that types come in so our entity type now
must extend BaseEntity. So that allows us to make some assumptions about it,
like it has an id property, as well as, the id value must extend Long. We're
saying that has to be a Long or an extension of the Long class.
 */
public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    /*
        The key on the map, is going to
        be a Long, and then whatever that T generic is going to be
     */
    protected Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
       return map.get(id);

    }

     /*
     the Map implementation, I'm saying that the map, the key on the map, is going to

be a Long, and then whatever that T generic is going to be. By saying that

space entity there, on line 24, you can see there I'm saying if the object

is null, we'll throw an exception. If not, now because I know that object

that's coming in is going to be an implementation of BaseEntity so I can

make the assumption that it's going to have the getId method available. I'm

going to look to see if it does have an Id. If not, I've created a method, a new

private method called getNextId that is going to go out and get the next

Id value available. That's just going to increment it up. And you saw there that

it did throw an exception. We can see down a line 51 there, I'm catching that.

Basically, if that map is empty and has not been initialised, we're going to get

an exception tossed which is okay. We're gonna solve the exception and

just return back one. We're going to start off at id 1 if the map is empty.

      */
    T save(T object){

        if(object != null){
            if(object.getId() == null){
                object.setId(getNextID());
            }
            map.put(object.getId(), object);
        }else{
            throw new RuntimeException("Object cannot be null");
        }

        return object;

    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextID(){
        Long nextID = null;
        try{
           nextID = Collections.max(map.keySet())+1;

        }catch(NoSuchElementException e){
            nextID = 1L;
        }
        return nextID;
    }

}
