package com.ll.chatApp.domain.comment.entity;

import com.ll.chatApp.domain.article.entity.Article;
import com.ll.chatApp.domain.chat.Member.Entity.Member;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@Entity
@NoArgsConstructor
@SuperBuilder
public class Comment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private String body;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;

}
