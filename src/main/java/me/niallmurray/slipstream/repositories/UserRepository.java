package me.niallmurray.slipstream.repositories;


import me.niallmurray.slipstream.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsernameIgnoreCase(String username);

  @Query("select u from User u"
          + " left join fetch u.authorities"
          + " where u.username = :username")
  User findByUsername(@Param("username") String username);

  User findByEmail(String email);

}
