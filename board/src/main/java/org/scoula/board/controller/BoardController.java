package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    final private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");

        model.addAttribute("list", service.getList());
    }

    @GetMapping("/create")
    public void create() {
        log.info("create");
    }

    @PostMapping("/create")
    public String create(BoardDTO board, RedirectAttributes ra) {
        // RedirectAttributes : 리다이렉트 시 데이터를 전달하는 Spring MVC 인터페이스

        // RedirectAttributes.addFlashAttribute("K", V) : 리다이렉트 후 한 번만 사용되고 자동 삭제할 데이터 추가
        // - 리다이렉트 전 -> request scope에 추가됨
        // - 리다이렉트 중 -> Session scope에 임시 저장
        // - 리다이렉트 후 -> request scope로 돌아옴

        log.info("create: " + board);           // 입력 데이터 로그
        service.create(board);                  // 게시글 생성

        ra.addFlashAttribute("message", "게시글이 등록 되었습니다.");

        //return "redirect:/board/list";          // 목록으로 리다이렉트
        return "redirect:/board/get?no=" + board.getNo(); // 등록된 게시글 상세 조회 페이지로 리다이렉트
    }

    @GetMapping({"/get", "/update"})
    public void get(@RequestParam("no") Long no, Model model) {
        log.info("/get or update");
        model.addAttribute("board", service.get(no));

        // URL에 따라 뷰 이름 결정: "board/get" 또는 "board/update"
    }

    @PostMapping("/update")
    public String update(BoardDTO board, RedirectAttributes ra) {
        log.info("update:" + board);
        boolean result = service.update(board);                   // 게시글 수정
        log.info("update result: " + result);

        if(result){
            ra.addFlashAttribute("message", "게시글이 수정 되었습니다.");
        }

        //return "redirect:/board/list";

        return "redirect:/board/get?no=" + board.getNo();
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no, RedirectAttributes ra) {
        log.info("delete" + no);
        boolean result = service.delete(no);
        log.info("delete result:" + result);

        if (result) {
            ra.addFlashAttribute("message", "게시글이 삭제 되었습니다.");
        }

        return "redirect:/board/list";
    }

    /**
     * 파일 다운로드 처리
     * @param no 첨부파일 번호
     * @param response HTTP 응답 객체
     * @throws Exception
     */
    @GetMapping("/download/{no}")
    @ResponseBody
    public void download(@PathVariable("no") Long no, HttpServletResponse response) throws IOException {
        BoardAttachmentVO attach = service.getAttachment(no);

        File file = new File(attach.getPath());
        UploadFiles.download(response, file, attach.getFilename());
    }
}
