package de.byoc.postgres;

import org.json.JSONObject;

import javax.persistence.Persistence;
import java.util.UUID;

public class Main {

  public static void main(String[] args) {
    var em = Persistence.createEntityManagerFactory("test").createEntityManager();
    em.getTransaction().begin();

    var iter = 100_000;
    for (int i = 0; i < iter; i++) {
      em.persist(new JsonUuid(UUID.randomUUID()));
      if (i % 20 == 0)
        System.out.println(i);
    }

    for (int i = 0; i < iter; i++) {
      em.persist(new JsonInteger(i));
      if (i % 20 == 0)
        System.out.println(i);
    }

    em.getTransaction().commit();
  }

}
