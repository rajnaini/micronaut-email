package example.micronaut;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//tag::clazzwithannotations[]
@EmailConstraints
class EmailCmd implements Email {
//end::clazzwithannotations[]

    //tag::properties[]
    private String recipient;
    private String subject;
    private List<String> cc = new ArrayList<>();
    private List<String> bcc = new ArrayList<>();
    private String htmlBody;
    private String textBody;
    private String replyTo;
    //end::properties[]

    //tag::settersandgetters[]
    @Override
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    @Override
    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    @Override
    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    @Override
    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    @Override
    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }
    //end::settersandgetters[]

    //tag::hasErrors[]
    boolean hasErrors() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<EmailCmd>> constraintViolations = validator.validate(this);

        return (constraintViolations!= null && !constraintViolations.isEmpty());
    }
    //end::hasErrors[]
}
