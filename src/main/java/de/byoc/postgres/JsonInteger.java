package de.byoc.postgres;

import org.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "json_integer")
@SequenceGenerator(name = "int_seq")
public class JsonInteger {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "int_seq")
  private Long seq;

  @Column
  private String text;

  @Column(name = "test_id")
  private Integer testId;

  public JsonInteger(Integer theId) {
    testId = theId;
    this.text = new JSONObject().put("test", theId).toString();
  }

}
