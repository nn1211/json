package nn1211.json;

/**
 * Main JSON class.
 *
 * @author nn1211
 * @since 1.0
 */
public abstract class Json {

    /**
     * Parse a string to a JSON object.
     *
     * @param str a JSON string.
     * @return a {@link JSON}
     * @since 1.0
     */
    public static Json parse(String str) {
        return new Deserializer().deserialize(str.trim());
    }

    /**
     * Try to cast this to a {@link JsonObject}.
     *
     * @return a {@link JsonObject} or null if this is not a {@link JsonObject}
     * @since 1.0
     */
    public JsonObject asObject() {
        return null;
    }

    /**
     * Return the fields count if this is a {@link JsonObject}, otherwise a
     * values count of a {@JsonArray}.
     *
     * @return
     */
    public abstract int size();

    /**
     * Available value types.
     *
     * @author nn1211
     * @since 1.0
     */
    public enum ValueType {
        /**
         * Integer
         * 
         * @since 1.0
         */
        INT,
        /**
         * Object
         * 
         * @since 1.0
         */
        OBJ,
        /**
         * String
         * 
         * @since 1.0
         */
        STR;
        
    }

}
