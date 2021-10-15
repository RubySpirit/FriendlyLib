package com.spirituspoland.friendlylib.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
  UUID id;
  String name;
  String surname;
  String email;
  String phone;
  LocalDateTime created;
  LocalDateTime lastLogon;

}
