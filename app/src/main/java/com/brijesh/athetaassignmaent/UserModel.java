package com.brijesh.athetaassignmaent;

public class UserModel {
    private String first;
    private String last;
    private String phone;
    private String add;

    public UserModel() {

    }

    public UserModel(String first, String last, String phone, String add) {
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.add = add;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}
