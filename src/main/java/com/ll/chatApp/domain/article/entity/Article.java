package com.ll.chatApp.domain.article.entity;

import com.ll.chatApp.domain.chat.Member.Entity.Member;
import com.ll.chatApp.domain.comment.entity.Comment;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Article extends BaseEntity {

    private String title;
    private String content;

    @ManyToOne
    private Member author;

    @OneToMany(mappedBy = "article", cascade=ALL)
    @Builder.Default //빌더 객체 생성 시 기본값을 유지하기 위해 특별히 처리됨.
    private List<Comment> comments=new ArrayList<>();

    public void addComment(Member member, String content) {
        Comment comment=Comment.builder()
                .article(this)
                .author(member)
                .body(content)
                .build();// 댓글을 리스트에 추가
        comments.add(comment);
    }
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }
}
