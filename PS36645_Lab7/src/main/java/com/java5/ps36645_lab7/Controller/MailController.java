package com.java5.ps36645_lab7.Controller;

import com.java5.ps36645_lab7.Helper.MailerHelper;
import com.java5.ps36645_lab7.Model.MailInfo;
import com.java5.ps36645_lab7.services.MailerService;
import jakarta.mail.MessagingException;
import org.eclipse.angus.mail.util.logging.MailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailerService mailer;


    @GetMapping("")
    public String mailViewer() {
        return "mail";
    }

    @ResponseBody
    @RequestMapping("/send")
    public String sendMail(Model model,
                           @RequestParam("mailTo") String to,
                           @RequestParam("mailCC") String cc,
                           @RequestParam("mailBCC") String bcc,
                           @RequestParam("mailSubject") String subject,
                           @RequestParam("mailContent") String content,
                           @RequestParam("mailFile") MultipartFile[] files)
            throws IOException, MessagingException {
        MailerHelper helper = new MailerHelper();
        String[] toEmails = helper.parseStringEmailToArray(to);
        String[] emailCC = helper.parseStringEmailToArray(cc);
        String[] emailBCC = helper.parseStringEmailToArray(bcc);
        MailInfo mail = new MailInfo();
        mail.setTo(toEmails);
        mail.setCc(emailCC);
        mail.setBcc(emailBCC);
        mail.setSubject(subject);
        mail.setBody(content);
//        System.out.println(content);

        for (MultipartFile file : files) {
            File f = helper.convertMultipartFileToFile(file);
            mail.getFiles().add(f);
        }
        mailer.send(mail);
        return "Đã Gửi Mail";
    }
}
