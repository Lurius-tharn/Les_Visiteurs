package com.lurius.les_visiteurs.model;

/**
 * @author lurius
 * @deprecated
 **/
public class Compte {
    private String login;
    private String password;

    public Compte(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}