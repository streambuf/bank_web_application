package com.bank.mvc.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="bank_user")
public class User extends AbstractModel implements UserDetails {

    @Column(name="username")
    private String username;

    @Column(name="lname")
    private String lname;

    @Column(name="fname")
    private String fname;

    @Column(name="patronymic")
    private String patronymic;

    @Column(name="date_of_birth")
    private String dateOfBirth;

    @Column(name="tin")
    private int tin;

    @Column(name="email")
    private String email;

    @Column(name="citizenship")
    private String citizenship;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    @Column(name="password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<UserRole> userRoles = new HashSet();

    @Transient
    private String confirmPassword;

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Transient
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public User() {
        super();
    }

    public User(long id) {
        super(id);
    }

    public String getLname() {
        return lname;
    }

    public String getFname() {
        return fname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getTin() {
        return tin;
    }

    public String getEmail() {
        return email;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDateOfBirth(String date_of_birth) {
        this.dateOfBirth = date_of_birth;
    }

    public void setTin(int tin) {
        this.tin = tin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBank() {
        return username;
    }

    public void setBank(String bank) {
        this.username = bank;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> result = new ArrayList();

        for(UserRole r: userRoles) {
            result.add(new SimpleGrantedAuthority(r.getListRole().name()));
        }

        return result;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return lname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
