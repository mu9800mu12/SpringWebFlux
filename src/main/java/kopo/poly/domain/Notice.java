package kopo.poly.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table("notice")
public class Notice {

    @Id
    @Column("notice_seq")
    private Long noticeSeq; // R2DBC 자동 생성전략을 별도로 처리해야 함

    @NonNull
    @Column("title")
    private String title;

    @NonNull
    @Column("notice_yn")
    private String noticeYn;

    @NonNull
    @Column("contents")
    private String contents;

    @NonNull
    @Column("user_id")
    private String userId;

    @Column("read_cnt")
    private Long readCnt;

    @Column("reg_id")
    private String regId;

    @Column("reg_dt")
    private LocalDateTime regDt;

    @Column("chg_id")
    private String chgId;

    @Column("chg_dt")
    private LocalDateTime chgDt;



}
