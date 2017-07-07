package de.digitalcollections.cudami.server.controller;

import de.digitalcollections.cudami.model.api.security.User;
import de.digitalcollections.cudami.server.business.api.service.UserService;
import java.util.List;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(description = "The user controller", name = "User controller")
public class UserController {

  @Autowired
  private UserService service;

  @ApiMethod(description = "get all active admin users")
  @RequestMapping(value = "/v1/findActiveAdminUsers", produces = "application/json", method = RequestMethod.GET)
  @ApiResponseObject
  public List<User> findActiveAdminUsers() {
    return service.findActiveAdminUsers();
  }
  
  @ApiMethod(description = "get role by name")
  @RequestMapping(value = "/v1/findByEmail/{email}", produces = "application/json", method = RequestMethod.GET)
  @ApiResponseObject
  public User findByName(@PathVariable String email) {
    return service.loadUserByUsername(email);
  }

}