package com.igr76.news.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
/**
 * Сущность {@link Category} entity
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "categoryes")
public class Category {
    /**    Идентификатор категории     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**    Название категории     */
    @Column(name = "name")
    private String name;


}
