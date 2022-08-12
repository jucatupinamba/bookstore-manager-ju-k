package com.spring.bookstoremanager.dto;

import com.spring.bookstoremanager.entity.Author;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;

    @NotBlank
    @Size(max = 200)
    private String name;

    @NotNull
    private Integer pages;
    @NotNull
    private Integer chapters;
    @NotBlank
    @Size(max = 100)
    private String isbn;
    @NotNull
    private String publisherName;
    @Valid
    @NotNull
    private Author author;
}
