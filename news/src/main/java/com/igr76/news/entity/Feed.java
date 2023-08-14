package com.igr76.news.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "feeds")
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    public String name;
    @Column(name = "content")
    private String content;
    @Column(name = "data")
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
