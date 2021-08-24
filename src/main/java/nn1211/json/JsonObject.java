package nn1211.json;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static nn1211.json.Json.ValueType.*;

/**
 * A JSON object.
 *
 * @author nn1211
 * @since 1.0
 */
public final class JsonObject extends Json {

    /**
     *
     * @since 1.0
     */
    private final Map<String, ValueType> data;

    /**
     *
     * @since 1.0
     */
    private final Map<String, String> strs;

    /**
     *
     * @since 1.0
     */
    private final Map<String, Integer> ints;

    /**
     *
     * @since 1.0
     */
    private final Map<String, JsonObject> objs;

    /**
     *
     * @since 1.0
     */
    private String origin;

    /**
     * Create an empty instance.
     *
     * @since 1.0
     */
    public JsonObject() {
        data = new LinkedHashMap<>();
        strs = new HashMap<>();
        ints = new HashMap<>();
        objs = new HashMap<>();
    }

    /**
     *
     * @since 1.0
     */
    @Override
    public JsonObject asObject() {
        return this;
    }

    /**
     * Get value of an integer type field.
     *
     * @param name field's name
     * @return a {@link Integer} or null if field was not found
     * @throws IllegalArgumentException if the type of the field is not
     * {@link Integer}
     * @since 1.0
     */
    public Integer getInt(String name) {
        ValueType type = data.get(name);
        if (null == type) {
            return null;
        }

        if (INT == type) {
            return ints.get(name);
        }

        throw new IllegalArgumentException(name + " is not an integer");
    }

    /**
     * Get value of a JSON object type field.
     *
     * @param name field's name
     * @return a {@link JsonObject} or null if field was not found
     * @throws IllegalArgumentException if the type of the field is not
     * {@link JsonObject}
     * @since 1.0
     */
    public JsonObject getObject(String name) {
        ValueType type = data.get(name);
        if (null == type) {
            return null;
        }

        if (OBJ == type) {
            return objs.get(name);
        }

        throw new IllegalArgumentException(name + " is not an JSON object");
    }

    /**
     * Get value of a string type field.
     *
     * @param name field's name
     * @return a {@link String} or null if field was not found
     * @throws IllegalArgumentException if the type of the field is not
     * {@link String}
     * @since 1.0
     */
    public String getString(String name) {
        ValueType type = data.get(name);
        if (null == type) {
            return null;
        }

        if (STR == type) {
            return strs.get(name);
        }

        throw new IllegalArgumentException(name + " is not a string");
    }

    /**
     * Set the origin of this.
     *
     * @param value the origin
     * @return this
     * @since 1.0
     */
    JsonObject origin(String value) {
        origin = value;
        return this;
    }

    /**
     * Set a integer field.
     *
     * @param name field's name
     * @param value field's value
     * @return this
     * @since 1.0
     */
    public JsonObject set(String name, int value) {
        data.put(name, INT);
        ints.put(name, value);
        return this;
    }

    /**
     * Set a integer field.
     *
     * @param name field's name
     * @param value field's value
     * @return this
     * @since 1.0
     */
    public JsonObject set(String name, JsonObject value) {
        data.put(name, OBJ);
        objs.put(name, value);
        return this;
    }

    /**
     * Set a string field.
     *
     * @param name field's name
     * @param value field's value
     * @return this
     * @since 1.0
     */
    public JsonObject set(String name, String value) {
        data.put(name, STR);
        strs.put(name, value);
        return this;
    }

    /**
     * Return the fields count.
     *
     * @since 1.0
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     *
     * @return @since 1.0
     */
    @Override
    public String toString() {
        if (null != origin) {
            return origin;
        }

        final StringBuilder sb = new StringBuilder().append('{');

        if (!data.isEmpty()) {
            data.forEach((n, t) -> {
                sb.append('"').append(n).append("\": ");
                if (null != t) {
                    switch (t) {
                        case STR:
                            sb.append('"').append(strs.get(n)).append('"');
                            break;
                        case INT:
                            sb.append(ints.get(n));
                            break;
                        case OBJ:
                            sb.append(objs.get(n));
                            break;
                        default:
                            break;
                    }
                }

                sb.append(", ");
            });

            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append('}').toString();
    }
    
}
