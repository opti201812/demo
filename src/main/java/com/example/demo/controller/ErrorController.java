package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述
 *
 * @author KEVIN
 * @since 2021-11-29
 */
class ErrorController extends AbstractErrorController {
    @Autowired
    ObjectMapper objectMapper;

    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping("/error")
    public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("/error.html");
        view.addObject("errorMessage", "test");//(ServletException)((Throwable)request.getAttribute("javax.servlet.error.exception")).getCause());
        return view;
    }
}
