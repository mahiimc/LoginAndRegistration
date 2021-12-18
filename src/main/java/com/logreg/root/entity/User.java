package com.logreg.root.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long  id;

    @Column(name = "user_email")
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "user_pass")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id",referencedColumnName = "user_details_id")
    private UserDetails userDetails;

    @Column(name = "last_modified_on")
    private LocalDateTime lastModified = LocalDateTime.now();
    @Column(name = "created_on")
    private LocalDateTime createdOn = LocalDateTime.now();
}
