package brotherwolf.sysc4806l.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "address_book")
public class AddressBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<BuddyInfoModel> buddies;

    public AddressBookModel(String name) {
        this.name = name;
        buddies = new HashSet<>();
    }

    public AddressBookModel() {
        buddies = new HashSet<>();
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

    public void addBuddy(BuddyInfoModel buddy) {
        buddies.add(buddy);
    }

    public void removeBuddy(String name) {
        buddies.removeIf(buddyInfoModel -> Objects.equals(name, this.name));
    }

    public Set<BuddyInfoModel> getBuddies() {
        return buddies;
    }

    public void setBuddies(Set<BuddyInfoModel> buddies) {
        this.buddies = buddies;
    }
}