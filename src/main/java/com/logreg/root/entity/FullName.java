package com.logreg.root.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_fullname_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullName implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fullname_details_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "last_modified_on")
    private LocalDateTime lastModified = LocalDateTime.now();
    @Column(name = "created_on")
    private LocalDateTime createdOn = LocalDateTime.now();

}
