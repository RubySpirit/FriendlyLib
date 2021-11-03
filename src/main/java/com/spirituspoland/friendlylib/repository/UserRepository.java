package com.spirituspoland.friendlylib.repository;

import com.spirituspoland.friendlylib.model.RoleName;
import com.spirituspoland.friendlylib.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Page<User> findAllByRoles_NameIsOrRoles_NameIs(RoleName firstRoleName, RoleName secondRoleName, Pageable pageable);

    List<User> findAllByRoles_Name(RoleName roleName);

    Page<User> findAllByRoles_Name(RoleName roleName, Pageable pageable);

    Optional<User> findByEmail(String email);

}
