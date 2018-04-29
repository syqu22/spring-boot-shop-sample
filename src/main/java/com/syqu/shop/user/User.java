package com.syqu.shop.user;

import com.syqu.shop.user.cart.ShoppingCart;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {
    @Column(name = "user_id") @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    @Column(name = "username", unique = true) @NotEmpty @NotNull private String username;
    @Column(name = "email", unique = true) @Email @NotEmpty @NotNull private String email;
    @NotEmpty @NotNull private String password;
    @NotEmpty @NotNull private String passwordConfirm;
    @Column(name = "first_name") private String firstName;
    @Column(name = "last_name") private String lastName;
    @Column(name = "age") private int age;
    @Column(name = "city") private String city;
    @Column(name = "country") private  String country;
    @Column(name = "gender") @NotEmpty @NotNull private String gender;
    @Column(name = "balance") private double balance;
    @Column(name = "shopping_cart") @OneToMany private Set<ShoppingCart> shoppingCart;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Set<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Set<ShoppingCart> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + " User name: " + getUsername() + " E-mail: " + getEmail() + " First name: "
                + getFirstName() + " Last name: " + getLastName() + " Age: " + getAge() + " City: " + getCity()
                + " Country: " + getCountry() + " Gender: " + getGender() + " Balance: " + getBalance();
    }
}
