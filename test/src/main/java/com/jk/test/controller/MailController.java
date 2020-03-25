package com.jk.test.controller;


import com.jk.test.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.annotations.Test;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;


@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;


    @RequestMapping("/sendSimpleMail")
    public String sendSimpleMail() {
        String to = "2461418944@qq.com";
        String subject = "test html mail";
        String content = "hello, this is html mail！";
        mailService.sendSimpleMail(to, subject, content);
        return "success";
    }


    @Test
    @RequestMapping("/sendAttachmentsMail")
    public String sendAttachmentsMail() {
        String filePath="E:\\a.txt";

        mailService.sendAttachmentMail("2461418944@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
        return "success";
    }

    @Test
    @RequestMapping("/sendTemplateMail")
    public String sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("user", "1111");
        context.setVariable("web", "tttt");
        context.setVariable("company", "我是一个公司");
        context.setVariable("product","我是一个产品");
        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail("2461418944@qq.com","主题：这是模板邮件",emailContent);
        return "success";
    }

}
