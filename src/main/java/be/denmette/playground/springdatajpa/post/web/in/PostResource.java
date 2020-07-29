package be.denmette.playground.springdatajpa.post.web.in;

import java.util.Objects;

public class PostResource {

    private String title;
    private String question;

    public PostResource() {
    }

    public PostResource(String title, String question) {
        this.title = title;
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostResource that = (PostResource) o;
        return Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getQuestion(), that.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getQuestion());
    }

    @Override
    public String toString() {
        return "PostResource{" +
                "title='" + title + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
