package com.logreg.root.repository;

import com.logreg.root.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select *  \n" +
            "from users.tbl_users as u \n" +
            "inner join users.tbl_user_details as tud \n" +
            "on u.details_id  = tud.user_details_id \n" +
            "inner join users.tbl_address_details as tad\n" +
            "on address_details_id = tud.add_det_id \n" +
            "where tad.country = :country",nativeQuery = true)
    List<User> findUserByCountry(@Param("country")  String country);


}
