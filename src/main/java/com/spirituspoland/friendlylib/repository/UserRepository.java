package com.spirituspoland.friendlylib.repository;

import com.spirituspoland.friendlylib.model.Role;
import com.spirituspoland.friendlylib.model.User;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Page<User> findAllByRole(Role role, Pageable pageable);

    Page<User> findAllByRoleIsOrRoleIs(Role firstRole, Role secondRole, Pageable pageable);
}
