package com.nozama.nozama.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String street;
    private String city;
    private String state;
    private Long phone;
    private Long creditCard;
    private String userRole;
    @OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL)
    private Set<Item> itemSellerSet;
    @OneToMany(mappedBy = "buyerId", cascade = CascadeType.ALL)
    private Set<Item> itemBuyerSet;
    @OneToMany(mappedBy = "buyerId", cascade = CascadeType.ALL)
    private Set<ShoppingCart> shoppingCartSet;

    public User() {}

    @Id
    @Column (name="USERID")
    @GenericGenerator(name="userIdGen", strategy = "increment")
    @GeneratedValue(generator = "userIdGen")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column (name="NAME ")
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Column(name="EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column
    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Column(name = "CREDITCARD")
    public Long getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Long creditCard) {
        this.creditCard = creditCard;
    }

    @Column(name="USERROLE", updatable = false, insertable = false)
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

//    @OneToMany(mappedBy = "sellerId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JsonManagedReference
//    public Set<Item> getItemSellerSet() {
//        return itemSellerSet;
//    }
//
//    public void setItemSellerSet(Set<Item> itemSellerSet) {
//        this.itemSellerSet = itemSellerSet;
//    }
//
//    @OneToMany(mappedBy = "buyerId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JsonManagedReference
//    public Set<Item> getItemBuyerSet() {
//        return itemBuyerSet;
//    }
//
//    public void setItemBuyerSet(Set<Item> itemBuyerSet) {
//        this.itemBuyerSet = itemBuyerSet;
//    }
//
//    @OneToMany(mappedBy = "buyerId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JsonManagedReference
//    public Set<ShoppingCart> getShoppingCartSet() {
//        return shoppingCartSet;
//    }
//
//    public void setShoppingCartSet(Set<ShoppingCart> shoppingCartSet) {
//        this.shoppingCartSet = shoppingCartSet;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone=" + phone +
                ", creditCard=" + creditCard +
                ", userRole='" + userRole + '\'' +
                '}';
    }

}
