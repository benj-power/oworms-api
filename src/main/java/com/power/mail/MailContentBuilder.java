package com.power.mail;

import com.power.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {

    private final TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(final TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(EmailDTO message, String templateName) {
        Context context = new Context();
        context.setVariable("message", message);

        return templateEngine.process(templateName, context);
    }

}
