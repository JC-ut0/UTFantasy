package csc207.phase2.UTFantasy.Activities.LoginActivityMVP;

import csc207.phase2.UTFantasy.userUseCase.User;

interface LoginView {

  void newPlayerAction(User user);

  void logInAction(User user);
}
