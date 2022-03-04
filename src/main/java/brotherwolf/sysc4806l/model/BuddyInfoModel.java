package brotherwolf.sysc4806l.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "buddy_info")
public class BuddyInfoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String address;


    public BuddyInfoModel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public BuddyInfoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuddyInfoModel)) return false;
        BuddyInfoModel that = (BuddyInfoModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    @Override
    public String toString() {
        return "Name='" + name + ", Address='" + address;
    }
}