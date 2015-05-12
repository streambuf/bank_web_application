package com.bank.mvc.models;



import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="bank_user")
@DynamicUpdate
public class User extends AbstractModel implements UserDetails {

    @Column(name="lname")
    private String lname;

    @Column(name="fname")
    private String fname;

    @Column(name="patronymic")
    private String patronymic;

    @Temporal(value=TemporalType.DATE)
    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="tin")
    private long tin;

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
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Account> accounts = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Passport passport;

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

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

    public User(int id) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public long getTin() {
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

    public void setDateOfBirth(Date date_of_birth) {
        this.dateOfBirth = date_of_birth;
    }

    public void setTin(long tin) {
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
        return String.valueOf(super.getId());
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



