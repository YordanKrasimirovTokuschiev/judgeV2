package com.softuni.judgev2.web;

import com.softuni.judgev2.model.binding.CommentAddBindingModel;
import com.softuni.judgev2.model.service.CommentServiceModel;
import com.softuni.judgev2.model.view.HomeworkViewModel;
import com.softuni.judgev2.service.CommentService;
import com.softuni.judgev2.service.HomeworkService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    private final HomeworkService homeworkService;
    private final CommentService commentService;
    private final ModelMapper modelMapper;

    public CommentsController(HomeworkService homeworkService, CommentService commentService, ModelMapper modelMapper) {
        this.homeworkService = homeworkService;
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("commentAddBindingModel")) {
            model.addAttribute("commentAddBindingModel", new CommentAddBindingModel());
        }

        HomeworkViewModel homework = modelMapper
                .map(homeworkService
                        .findHomeworkForScoring(), HomeworkViewModel.class);

        model.addAttribute("homework", homework);

        return "homework-check";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid CommentAddBindingModel commentAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("commentAddBindingModel", commentAddBindingModel);
            redirectAttributes.addFlashAttribute("org.framework.validation.BindingResult.commentAddBindingModel"
                    , bindingResult);

            return "redirect:add";
        }

        CommentServiceModel serviceModel = modelMapper.map(commentAddBindingModel, CommentServiceModel.class);

        commentService.add(serviceModel, commentAddBindingModel.getHomeworkId());

        return "redirect:/";
    }
}
