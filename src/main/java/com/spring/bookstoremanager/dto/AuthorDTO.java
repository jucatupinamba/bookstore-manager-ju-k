package com.spring.bookstoremanager.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    private Long id;
    @NotBlank
    @Size(max = 200)
    private String name;
    @NotBlank
    @Size(max = 100)
    private Integer age;
}
