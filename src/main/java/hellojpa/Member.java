package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 넣어야 JPA 사용하는지 인식
public class Member {
    @Id // PK
    private Long id;
    private String name;

    public Member() {

    }

    // JPA 기본적으로 내부 리플렉션 같은 것들을 쓰기 때문에 동적으로 객체를 생성해내야함 → 기본 생성자가 있어야함
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
