package com.prueba.demo.Domain;

public class MarvelUser {
    private int id;
    private String name;
    private String identification;
    private String email;
    private String password;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIdentification() { return identification; }
    public void setIdentification(String identification) { this.identification = identification; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "MarvelUser{" +
                "id=" + id +
                ", firtsname='" + name + '\'' +
                ", lastsname='" + identification + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
