package com.logreg.root.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_user_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_details_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "add_det_id",referencedColumnName = "address_details_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_det_id",referencedColumnName = "contact_details_id")
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fullname_det_id",referencedColumnName = "fullname_details_id")
    private FullName fullName;

    @Column(name = "last_modified_on")
    private LocalDateTime lastModified = LocalDateTime.now();
    @Column(name = "created_on")
    private LocalDateTime createdOn = LocalDateTime.now();

}
