package com.shrio.modle;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author: fanbopeng
 * @Date: 2019/3/29 12:55
 * @Description:
 */
public class Role {


    private  Integer rid;
    private  String rname;
    private Set<Permission> permissions =new HashSet<>();

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return rname;
    }

    public void setName(String name) {
        this.rname = name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(rid, role.rid) &&
                Objects.equals(rname, role.rname) &&
                Objects.equals(permissions, role.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rid, rname, permissions);
    }
}
