package com.shrio.modle;

import java.util.Objects;

/**
 * @author: fanbopeng
 * @Date: 2019/3/29 12:54
 * @Description:
 */

public class Permission {


    private Integer pid;
    private String name;
    private String url;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission)) return false;
        Permission that = (Permission) o;
        return Objects.equals(pid, that.pid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, name, url);
    }
}
