package csc207.phase2.UTFantasy.User;

interface UserManagerFacadeInterface {

  User login(String username, String password);

  User register(String username, String password);

  User getUser(String username);

  void saveUserData();

  void loadUserData();
}
