package um.feri.ita.bookservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record Book(
        String id,
        String title,
        String author,
        String publisher,
        int publicationYear
)
{}
