package AnnotationsStuff;

public class MailValidator {
    @MethodInfo(creationDate = 2023, purpose = "Check if mail is correct")
    public boolean isMailCorrect(String mail){
        return mail.matches("[\\da-zA-Z]+(\\.[\\da-zA-Z]+)*@(mail|gmail)\\.(ru|com)");
    }

    @Override
    public String toString() {
        return "MailValidator";
    }
}
