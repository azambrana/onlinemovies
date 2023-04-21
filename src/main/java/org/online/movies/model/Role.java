package org.online.movies.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)

    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role(@NonNull Long id, String name, String description) {
        if (id == null) {
            throw new NullPointerException("id is marked non-null but is null");
        } else if (name == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return id != null ? id.equals(role.id) : role.id == null;
    }


}