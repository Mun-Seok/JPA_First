package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("A") // Dtype 이름 설정해줌
public class Album extends Item{
    private String artist;
}
