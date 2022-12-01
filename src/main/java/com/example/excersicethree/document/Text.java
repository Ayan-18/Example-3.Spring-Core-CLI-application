package com.example.excersicethree.document;


import com.example.excersicethree.helper.Indices;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;



@Document(indexName = Indices.TEXT_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Text {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    @Field(type = FieldType.Text)
    private String text;

    public Text(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public Text() {
    }

    public Text(String text) {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
