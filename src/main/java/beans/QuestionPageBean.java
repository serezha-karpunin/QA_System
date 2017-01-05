package beans;

import java.io.Serializable;
import java.util.List;

public class QuestionPageBean implements Serializable {

    private int idQuestion;
    private String title;
    private String text;
    private String date;
    private int views;
    private String login;
    private List<String> tags;
    private String userImage;
//    private List<AnswerBean> answers;

    public QuestionPageBean() {
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

//    public List<AnswerBean> getAnswers() {
//        return answers;
//    }
//
//    public void setAnswers(List<AnswerBean> answers) {
//        this.answers = answers;
//    }


}
