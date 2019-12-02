package csc207.phase2.UTFantasy.userUseCase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

class UserAuthorizer implements Serializable {
  private final UserIOInterface userIOInterface;

  UserAuthorizer(UserIOInterface userIOInterface) {
    this.userIOInterface = userIOInterface;
  }

  private UserData getUserData() {
    return userIOInterface.getUserData();
  }

  /**
   * LoginActivityFolder by username and password.
   *
   * @param username the username of the User.
   * @param password the password of the User.
   * @return A User if logged in successfully, null if not.
   */
  User login(String username, String password) {
    HashMap<String, User> userHashMap = getUserData().getUserHashMap();
    if (userHashMap.containsKey(username)) {
      String pwd = Objects.requireNonNull(userHashMap.get(username)).getPassword();
      if (password.equals(pwd)) {
        return userHashMap.get(username);
      }
    }
    return null;
  }

  /**
   * Register using username and password. Update the userHapMap after resisting.
   *
   * @param username the username of the User.
   * @param password the password of the User.
   * @return A new User.
   */
  User register(String username, String password) {
    User user = new User(username, password);
    getUserData().addUser(username, user);
    return user;
  }

  User getUser(String username) {
    return getUserData().getUser(username);
  }
}
