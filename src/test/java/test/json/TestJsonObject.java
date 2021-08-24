package test.json;

import nn1211.json.JsonObject;
import org.junit.Test;

/**
 * {@link JsonObject} test cases.
 *
 * @author nn1211
 * @since 1.0
 */
public final class TestJsonObject {

    @Test
    public void test01() {
        JsonObject o = new JsonObject()
                .set("name", "Nguyen Van A")
                .set("age", 12);

        assert 2 == o.size();
        System.out.println(o);
    }

    @Test
    public void test02() {
        JsonObject o = new JsonObject()
                .set("name", new JsonObject()
                        .set("first", "A")
                        .set("last", "Nguyen")
                        .set("middle", "Van"))
                .set("age", 12);

        assert 2 == o.size();
        System.out.println(o);
    }
}
