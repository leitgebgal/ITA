package um.feri.ita.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record User(
        String id,
        String email,
        String password,
        String firstName,
        String lastName
)
{}
