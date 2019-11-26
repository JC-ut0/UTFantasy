package csc207.phase2.UTFantasy.Activities.LoginActivityMVP;

import csc207.phase2.UTFantasy.user.User;

interface LoginView {

  void newPlayerAction(User user);

  void logInAction(User user);
}
