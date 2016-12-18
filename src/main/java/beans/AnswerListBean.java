package beans;

import java.io.Serializable;

public class AnswerListBean implements Serializable {
    private int idAnswer;
    private String textAnswer;
    private String date;
    private String login;
    private int likes;
    private boolean isLikedByCurrentUser;

    public AnswerListBean() {
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean getIsLikedByCurrentUser() {
        return isLikedByCurrentUser;
    }

    public void setIsLikedByCurrentUser(boolean likedByCurrentUser) {
        isLikedByCurrentUser = likedByCurrentUser;
    }
}
