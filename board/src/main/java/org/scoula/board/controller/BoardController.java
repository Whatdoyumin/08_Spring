package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String create(BoardDTO board) {
        log.info("create" + board);

        service.create(board);

        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/update"})
    public void get(@RequestParam("no") Long no, Model model) {
        log.info("/get or update");
        model.addAttribute("board", service.get(no));
    }

    @PostMapping("/update")
    public String update(BoardDTO board) {
        log.info("update" + board);

        service.update(board);

        return "redirect:/board/list";
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
}
