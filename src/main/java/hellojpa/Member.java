package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // JPA가 관리
public class Member {
    @Id // PK
    private Long id;
//    @Column(unique = true, length = 10)
 /*   private String name;
    private int age;*/

    @Column(name = "name")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) // ORDINAL로 설정 X - 순서 바꿔도 옛날 데이터 변하지 않아서 같은 데이터 나옴
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // DATE - 날짜, TIME - 시간 , TIMESTAMP - 날짜와 시간
    private Date createdDate;

    private LocalDate testLocalDate; // @Temporal 안써도 됨
    private LocalDateTime testLocalDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob // varchar보다 큰 컨텐츠
    private String description;
    public Member() {

    }

/*
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
*/
}
