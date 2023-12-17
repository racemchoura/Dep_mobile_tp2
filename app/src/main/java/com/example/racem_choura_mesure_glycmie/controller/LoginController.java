package com.example.racem_choura_mesure_glycmie.controller;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.racem_choura_mesure_glycmie.Model.User;
public class LoginController {
    public static final String SHERED_PREFS="Sharedprefes";
    private static User user;
    private static LoginController instance=null;

    private  LoginController(){
        super();
    }
    public static final LoginController getInstance(Context context){
        if(LoginController.instance==null)
            instance=new LoginController();
        recapUser(context);
        return LoginController.instance;
    }
    public static void recapUser(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHERED_PREFS,Context.MODE_PRIVATE);
        String Username=sharedPreferences.getString("Username","");
        String password= sharedPreferences.getString("Username","");
        user=new User(Username,password);
    }
    public void createUser(String username, String password, Context context){
        user=new User(username,password);
        SharedPreferences sharedPreferences =context.getSharedPreferences(SHERED_PREFS,context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.apply();
    }
    public String getUserName(){
        return user.getUsername();
    }
    public  String getpassword(){
        return user.getPassword();
    }
}
