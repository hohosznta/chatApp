package com.ll.chatApp.domain.article.service;

import com.ll.chatApp.domain.article.entity.Article;
import com.ll.chatApp.domain.article.repository.ArticleRepository;
import com.ll.chatApp.domain.chat.Member.Entity.Member;
import com.ll.chatApp.domain.comment.entity.Comment;
import com.ll.chatApp.domain.chat.Member.Repository.MemberRepository;
import com.ll.chatApp.domain.comment.repository.CommentRepository;
import com.ll.chatApp.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;


    public RsData<Article> write(long userId, String title, String content) {
        Member member = memberRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        Article article = this.articleRepository.save(Article.builder()
                .author(member)
                .title(title)
                .content(content)
                .build());
        return RsData.of("200", "게시글 작성 성공", article);
    }

    public Optional<Article> findById(long l) {
        return articleRepository.findById(l);
    }

    public Member getAuthor(Article article) {
        return article.getAuthor();
    }

    public Article modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
        articleRepository.save(article);

        return article;
    }

    public void modifyComment(Comment comment, String body) {
        comment.setBody(body);
        commentRepository.save(comment);

    }
}
