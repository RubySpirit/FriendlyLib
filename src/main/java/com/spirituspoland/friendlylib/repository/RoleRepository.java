package com.spirituspoland.friendlylib.repository;

import com.spirituspoland.friendlylib.model.Role;
import com.spirituspoland.friendlylib.model.RoleName;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
