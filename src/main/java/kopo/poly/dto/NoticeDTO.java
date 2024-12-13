package kopo.poly.dto;

import java.time.format.DateTimeFormatter;
import java.util.Optional;
import kopo.poly.domain.Notice;
import kopo.poly.util.CmmUtil;
import kopo.poly.util.DateUtil;
import lombok.Builder;

@Builder
public record NoticeDTO(

        Long noticeSeq,
        String title,
        String noticeYn,
        String contents,
        String userId,
        Long readCnt,
        String regId,
        String regDt,
        String chgId,
        String chgDt,
        String userName
) {



    public static NoticeDTO from(Notice notice) {

        return NoticeDTO.builder()
                .noticeSeq(notice.getNoticeSeq())
                .title(notice.getTitle())
                .noticeYn(notice.getNoticeYn())
                .contents(notice.getContents())
                .userId(notice.getUserId())
                .readCnt(notice.getReadCnt())
                .regId(notice.getRegId())
                .regDt(Optional.ofNullable(notice.getRegDt()).map(dt ->
                        dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).orElse(null))
                .chgId(notice.getChgId())
                .chgDt(Optional.ofNullable(notice.getChgDt()).map(dt ->
                        dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).orElse(null))
                .build();

    }

    public static Notice to(NoticeDTO dto) {
        return Notice.builder()
                .noticeSeq(dto.noticeSeq())
                .title(dto.title())
                .noticeYn(dto.noticeYn())
                .contents(dto.contents())
                .userId(dto.userId())
                .readCnt((CmmUtil.nvl(dto.readCnt(),0L)))
                .regId(CmmUtil.nvl(dto.regId(), dto.userId()))
                .regDt(DateUtil.stringToLocalDateTime(dto.regDt()))
                .chgId(CmmUtil.nvl(dto.chgId, dto.userId()))
                .chgDt(DateUtil.stringToLocalDateTime(dto.chgDt()))
                .build();
    }
}
