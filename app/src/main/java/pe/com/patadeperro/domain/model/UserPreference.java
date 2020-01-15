package pe.com.patadeperro.domain.model;

public class UserPreference {

    public String id;
    public String idCloud;
    public String name;
    public String phone;
    public boolean logged;

    public UserPreference(String id, String idCloud, String name, String phone, boolean logged) {
        this.id = id;
        this.idCloud = idCloud;
        this.name = name;
        this.phone = phone;
        this.logged = logged;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCloud() {
        return idCloud;
    }

    public void setIdCloud(String idCloud) {
        this.idCloud = idCloud;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}
