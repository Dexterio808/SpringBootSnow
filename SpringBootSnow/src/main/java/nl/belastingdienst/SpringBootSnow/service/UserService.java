package nl.belastingdienst.SpringBootSnow.service;

import nl.belastingdienst.SpringBootSnow.domain.AppUser;
import nl.belastingdienst.SpringBootSnow.domain.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
