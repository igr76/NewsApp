package com.igr76.news.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
/**
 * Сущность {@link Feed} entity
 */
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "feeds")
public class Feed {
    /**    Идентификатор новости     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**    Заголовок новости     */
    @Column(name = "name")
    public String name;
    /**    Содержание новости     */
    @Column(name = "content")
    private String content;
    /**    Дата новости     */
    @Column(name = "data")
    private LocalDateTime data;
    /**    Категория новости     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
