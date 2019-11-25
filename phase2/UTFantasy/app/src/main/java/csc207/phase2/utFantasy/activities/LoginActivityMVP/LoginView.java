package csc207.phase2.utFantasy.activities.LoginActivityMVP;

import csc207.phase2.utFantasy.user.User;

interface LoginView {

  void newPlayerAction(User user);

  void logInAction(User user);
}
