package me.dri.restproject.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import me.dri.restproject.model.Books;
import org.dozer.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@JsonPropertyOrder({"key", "name", "gender", "release_date", "note"})
public class BooksVO  extends RepresentationModel<BooksVO> implements Serializable {

    @JsonProperty("id")
    @Mapping("id")
    private Long key;

    private String name;
    private String gender;
    private Date release_date;

    private String note;

    public BooksVO() {

    }

    public BooksVO(Long key, String name, String gender, Date release_date, String note) {
        this.key = key;
        this.name = name;
        this.gender = gender;
        this.release_date = release_date;
        this.note = note;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BooksVO booksVO = (BooksVO) o;
        return Objects.equals(key, booksVO.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key);
    }
}
