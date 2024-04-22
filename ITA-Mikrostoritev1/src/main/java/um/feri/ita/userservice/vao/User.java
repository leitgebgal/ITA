package um.feri.ita.userservice.vao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    public User() {}

    public User(um.feri.ita.userservice.dto.User dto) {
        setEmail(dto.email());
        setPassword(dto.password());
        setFirstName(dto.firstName());
        setLastName(dto.lastName());
    }

    public void updateFrom(um.feri.ita.userservice.dto.User dto) {
        setEmail(dto.email());
        setPassword(dto.password());
        setFirstName(dto.firstName());
        setLastName(dto.lastName());
    }

    public um.feri.ita.userservice.dto.User toDto() {
        return new um.feri.ita.userservice.dto.User(
                getId(),
                getEmail(),
                getPassword(),
                getFirstName(),
                getLastName()
        );
    }

    @Id
    protected String id;
    protected String email;
    protected String password; // TODO: add security to password
    protected String firstName;
    protected String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password=[PROTECTED]" +
                ", firstname=" + firstName +
                ", lastname=" + lastName +
                '}';
    }
}
