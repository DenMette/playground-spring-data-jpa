package be.denmette.playground.springdatajpa.post.web.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostGetResource {

    private Integer postId;
    private String title;
    private String question;
    private List<String> answers;

    public PostGetResource() {
    }

    public PostGetResource(Integer postId, String title, String question) {
        this.postId = postId;
        this.title = title;
        this.question = question;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void addAnswer(String answer) {
        if (this.answers == null)
            this.answers = new ArrayList<>();

        this.answers.add(answer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostGetResource that = (PostGetResource) o;
        return Objects.equals(getPostId(), that.getPostId()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getQuestion(), that.getQuestion()) &&
                Objects.equals(getAnswers(), that.getAnswers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getTitle(), getQuestion(), getAnswers());
    }

    @Override
    public String toString() {
        return "PostGetResource{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }
}
