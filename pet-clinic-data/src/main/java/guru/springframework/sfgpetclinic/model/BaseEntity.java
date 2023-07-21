package guru.springframework.sfgpetclinic.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/*
 Designates a class whose mapping information is applied to the entities
 that inherit from it. A mapped superclass has no separate table defined for it.
A class designated with the MappedSuperclass annotation can be mapped in the
same way as an entity except that the mappings will apply only to its
subclasses since no table exists for the mapped superclass itself.
When applied to the subclasses the inherited mappings will apply in
the context of the subclass tables

 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    /*
    @Id
    Specifies the primary key of an entity.
     The field or property to which the Id annotation is applied should be one of the following
     types: any Java primitive type; any primitive wrapper type;
     String; java.util.Date; java.sql.Date; java.math.BigDecimal; java.math.BigInteger.
The mapped column for the primary key of the entity is assumed to be the primary key of
the primary table.
If no Column annotation is specified, the primary key column name is assumed to be the
name of the primary key property or field.

@GeneratedValue(strategy = GenerationType.IDENTITY)
Provides for the specification of generation strategies for the values of primary keys.
The GeneratedValue annotation may be applied to a primary key property or field of an
entity or mapped superclass in conjunction with the Id annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean isNew() {
        return this.id == null;
    }

}
