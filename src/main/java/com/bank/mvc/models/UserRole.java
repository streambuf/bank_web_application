package com.bank.mvc.models;

import com.bank.mvc.models.enums.ListRole;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zalman on 14.04.2015.
 */

@Entity
@Table(name="bank_role")
public class UserRole extends AbstractModel {

    @ManyToMany(mappedBy = "userRoles")
    private Set<User> user = new HashSet();

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private ListRole listRole;

    public UserRole() {
        super();
    }

    public UserRole(long id) {
        super(id);
    }

    public ListRole getListRole() {
        return listRole;
    }

    public void setListRole(ListRole listRole) {
        this.listRole = listRole;
    }

    public void addUser(User user) {
        this.user.add(user);
    }
}
