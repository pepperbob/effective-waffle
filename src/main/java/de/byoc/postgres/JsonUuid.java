package de.byoc.postgres;

import org.json.JSONObject;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "json_uuid")
@SequenceGenerator(name = "uuid_seq")
public class JsonUuid {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uuid_seq")
  private Long seq;

  @Column
  private String text;

  @Column(name = "test_id")
  private String testId;

  public JsonUuid(UUID theId) {
    testId = theId.toString();
    this.text = new JSONObject().put("test", theId).toString();
  }

}
