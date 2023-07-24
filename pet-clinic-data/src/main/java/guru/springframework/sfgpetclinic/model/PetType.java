package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{
    @Column(name = "types")
    private String name;

    @Builder
    public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }

  @Override
    public String toString(){
      return name;
  }
}
