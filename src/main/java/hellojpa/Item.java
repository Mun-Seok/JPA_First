package hellojpa;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 상속테이블 JOINED - 각각 테이블로 변환 SINGLE_TABLE - 한 테이블에 생성 TABLE_PER_CLASS - 구현클래스마다 테이블로 변환
@DiscriminatorColumn // DType 설정 - default가 엔티티명이 들어감/단일테이블 전략은 어노테이션 없어도 생성됨/ 구현클래스마다 테이블 전략에서는 생성 X
public abstract class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
