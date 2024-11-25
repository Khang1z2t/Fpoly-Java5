package com.java5.ps36645_lab7.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailInfo {
    String from = "khangdqbps36645@fpt.edu.vn";
    String[] to;
    String[] cc;
    String[] bcc;
    String subject;
    String body;
    List<File> files = new ArrayList<>();

    public MailInfo(String[] to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
