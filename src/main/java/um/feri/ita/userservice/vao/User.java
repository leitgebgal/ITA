package um.feri.ita.userservice.vao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import um.feri.ita.userservice.dto.UserRecord;

@Document(collection = "users")
public class User {
    public User() {}

    public User(UserRecord dto) {
        setEmail(dto.email());
        setPassword(dto.password());
        setFirstName(dto.firstName());
        setLastName(dto.lastName());
    }

    public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public void updateFrom(UserRecord dto) {
        setEmail(dto.email());
        setPassword(dto.password());
        setFirstName(dto.firstName());
        setLastName(dto.lastName());
    }

    public UserRecord toDto() {
        return new UserRecord(
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
        return "User {" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password=[PROTECTED]" +
                ", firstname=" + firstName +
                ", lastname=" + lastName +
                '}';
    }
}
