package com.jack2ee.webservice.domain.posts;

import com.jack2ee.webservice.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
/**
 * 기본 생성자 자동 추가
 * access = AccessLevel.PROTECTED: 기본생성자의 접근 권한을 protected로 전환
 * 생성자로 protected Posts() {} 와 같은 효과
 * Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity 클래스를
 * 생성하는 것은 허용하기 위해 추가
 **/
@Getter
/**
 * 클래스내 모든 필드의 Getter 메소드를 자동 생성
 **/
@Entity
/**
 * 테이블과 링크될 클래스임을 나타냅니다.
 * 언더스코어 네이밍(_)으로 이름을 매칭합니다.
 * ex) SalesManager.java -> sales_manager table
 **/
public class Posts extends BaseTimeEntity {
    @Id // 해당 테이블의 PK 필드를 나타냅니다.
    @GeneratedValue
    /**
     * PK 생성 규칙을 나타냅니다.
     * 기본값은 AUTO로, MySQL의 auto_increment와 같이 자동증가하는 정수형 값이 됩니다.
     **/
    private Long id;

    @Column(length = 500, nullable = false)
    /**
     * 태이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됩니다.
     * 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우 사용합니다.
     * 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex: title),
     * 타입을 TEXT로 변경하고 싶거나(ex: content) 등의 경우에 사용됩니다.
     **/
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    /**
     * 해당 클래스의 빌더패턴 클래스를 생성
     **/
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
