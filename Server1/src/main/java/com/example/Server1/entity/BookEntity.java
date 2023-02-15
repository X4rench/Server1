package com.example.Server1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;


@Valid
@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name ="books")
public class BookEntity {
    @Column(name = "book_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@NotBlank

    private String title;
    @NotBlank
    @Min (value = 2 ,message = "Мало букав")
    @Max(value = 30,message = "Много букав")
    private String author;
    @PositiveOrZero
    @PastOrPresent
    private int year;
    @NotBlank
    private String kind;
}
