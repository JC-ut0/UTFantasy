package csc207.phase2.UTFantasy.Activities.LoginActivityMVP;

import csc207.phase2.UTFantasy.CustomizeException.ImproperUserSettingException;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.User.User;
import csc207.phase2.UTFantasy.User.UserManagerFacade;

class LoginPresenter {

  private LoginView loginView;
  private UserIO userIO;
  private UserManagerFacade userManagerFacade;

  LoginPresenter(UserIO userIO, LoginView loginView, UserManagerFacade userManagerFacade) {
    this.userManagerFacade = userManagerFacade;
    this.userIO = userIO;
    this.loginView = loginView;
  }
  /**
   * Make sure that the username and password are valid.
   *
   * @throws ImproperUserSettingException if username and password are not valid
   */
  void validateUsernameAndPasswordForRegister(String username, String password)
      throws ImproperUserSettingException {
    if (username.equals("")) {
      throw new ImproperUserSettingException("Please Enter your Account");
    } else if (password.equals("")) {
      throw new ImproperUserSettingException("Please Enter your Password");
    } else if (password.length() < 6) {
      throw new ImproperUserSettingException("Your Password need to have at least 6 letters.");
    } else if (password.contains(";")) {
      throw new ImproperUserSettingException("Invalid punctuation is used.");
    } else if (username.contains(";")) {
      throw new ImproperUserSettingException("Invalid punctuation is used.");
    } else if (userIO.getUserData().getUserHashMap().containsKey(username)) {
      throw new ImproperUserSettingException("The Username is Used");
    } else if (username.contains("\n")) {
      throw new ImproperUserSettingException("Invalid punctuation is used.");
    } else if (username.contains("fuck")) {
      throw new ImproperUserSettingException("Please be polite!");
    }
    // this is a new user, saveFile the info of this user, go to set up activity
    User user = userManagerFacade.register(username, password);
    userManagerFacade.saveUserData();
    loginView.newPlayerAction(user);
  }

  /**
   * Make sure that the username and password are valid.
   *
   * @throws ImproperUserSettingException if username and password are not valid
   */
  void validateUsernameAndPasswordForLogin(String username, String password)
      throws ImproperUserSettingException {
    if (username.equals("")) {
      throw new ImproperUserSettingException("Please Enter your Account");
    } else if (password.equals("")) {
      throw new ImproperUserSettingException("Please Enter your Password");
    }
    // log in if the user exists
    User user = userManagerFacade.login(username, password);
    if (user == null) {
      // log in failed . pop up a window shows failure.
      throw new ImproperUserSettingException("account or password is not correct!");
    } else {
      loginView.logInAction(user);
    }
  }
}
