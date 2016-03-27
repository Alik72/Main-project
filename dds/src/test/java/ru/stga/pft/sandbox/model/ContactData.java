package ru.stga.pft.sandbox.model;

public class ContactData {
  private int id;
  private final String lastname;
  private final String firstname;
  private final String homePhone;
  private final String email;
  private final String address;
  private String group;

  public ContactData(String lastname, String firstname, String homePhone, String email, String address, String group) {
    this.id = Integer.MAX_VALUE;
    this.lastname = lastname;
    this.firstname = firstname;
    this.homePhone = homePhone;
    this.email = email;
    this.address = address;
    this.group = group;
  }

  public ContactData(int id,String lastname, String firstname, String homePhone, String email, String address, String group) {
    this.id = id;
    this.lastname = lastname;
    this.firstname = firstname;
    this.homePhone = homePhone;
    this.email = email;
    this.address = address;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public String getGroup() {
    return group;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    return firstname != null ? firstname.equals(that.firstname) : that.firstname == null;

  }

  @Override
  public int hashCode() {
    int result = lastname != null ? lastname.hashCode() : 0;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
            '}';
  }
}


