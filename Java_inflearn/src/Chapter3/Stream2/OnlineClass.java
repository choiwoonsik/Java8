package Chapter3.Stream2;

import Chapter4.Progress;

import java.util.Optional;

public class OnlineClass {

    private Integer id;

    private String title;

    private boolean closed;

    private Progress progress;

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
        //return Optional.of(progress);
        /*
        만약 널을 반환하고 싶다면 null대신
        Optional.empty()를 반환해야한다. null을 반환시 optional을 사용하는 의미 x
        비어있는 옵셔널 박스를 반환하게 된다
         */
    }
    //Optional
    /*
    옵셔널이라는 박스를 만들고 박스에 객체를 담는다
    이때 객체는 널일수도 있고 들어있을수도 있다
    말 그대로 옵셔널

    최초로 옵셔널에 값을 넣을때 넣는 객체 자체가 널일수 있다면
    Optional.ofNullable을 사용해서 널일수 있음을 명시한다

    만약 객체가 널이 아닐것이라고 명시한다면
    Optional.of 를 사용한다
    만약 널이 들어온다면 null exception 발생
    */

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
