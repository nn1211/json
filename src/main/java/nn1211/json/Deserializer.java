package nn1211.json;

/**
 * A simple JSON deserializer.
 *
 * @author nn1211
 * @since 1.0
 */
class Deserializer {

    /**
     * 
     * @since 1.0
     */
    private char[] chars;
    
    /**
     * 
     * @since 1.0
     */
    private int i;

    /**
     * Create an empty instance.
     * 
     * @since 1.0
     */
    Deserializer() {
    }

    /**
     * Deserialize a string to a {@link Json}.
     * 
     * @param str a JSON string
     * @return A {@link Json}
     * @throws IllegalArgumentException if invalid JSON string was found
     * @since 1.0
     */
    Json deserialize(String str) {
        chars = str.toCharArray();
        for (i = 0; i < chars.length; i++) {
            if (chars[i] == '{') {
                i++;
                JsonObject o = parseObject();
                if (i == chars.length - 1) {
                    o.origin(str);
                    return o;
                }

                throw new IllegalArgumentException("End of string expected");
            }
        }

        throw new IllegalArgumentException("Invalid JSON string or unsupported");
    }

    /**
     * 
     * @since 1.0 
     */
    private JsonObject parseObject() {
        JsonObject o = new JsonObject();

        for (; i < chars.length; i++) {
            if (chars[i] == '}') {
                return o;
            }

            parseField(o);
        }

        throw new IllegalArgumentException("Ending } not found");
    }

    /**
     * 
     * @since 1.0 
     */
    private void parseField(JsonObject o) {
        String fieldName = parseFieldName();
        if (fieldName == null) {
            return;
        }

        parseFieldValue(o, fieldName);
    }

    /**
     * 
     * @since 1.0 
     */
    private String parseFieldName() {
        char c;
        for (; i < chars.length; i++) {
            c = chars[i];
            if ('"' == c) {
                i++;
                return parseString();
            }

            if ('}' == c) {
                i--;
                return null;
            }
        }

        throw new IllegalArgumentException("\" expected");
    }

    /**
     * 
     * @since 1.0 
     */
    private void parseFieldValue(JsonObject o, String name) {
        for (; i < chars.length; i++) {
            if (chars[i] == ':') {
                i++;
                parseValue(o, name);
                return;
            }
        }

        throw new IllegalArgumentException(": expected");
    }

    /**
     * 
     * @since 1.0 
     */
    private void parseValue(JsonObject o, String name) {
        char c;
        for (; i < chars.length; i++) {
            c = chars[i];
            if ('"' == c) {
                i++;
                o.set(name, parseString());
                return;
            }

            if ('/' < c && c < ':') {
                o.set(name, parseInt());
                return;
            }
            
            if ('{' == c) {
                o.set(name, parseObject());
                return;
            }
        }

        throw new UnsupportedOperationException("Unsupported value type");
    }

    /**
     * 
     * @since 1.0 
     */
    private int parseInt() {
        StringBuilder sb = new StringBuilder();

        char c;
        for (; i < chars.length; i++) {
            c = chars[i];
            if (c == ' ' || c == ',' || c == '}') {
                i--;
                return Integer.parseInt(sb.toString());
            }

            sb.append(c);
        }

        throw new IllegalArgumentException("Unexpected end of string");
    }

    /**
     * 
     * @since 1.0 
     */
    private String parseString() {
        StringBuilder sb = new StringBuilder();

        char c;
        for (; i < chars.length; i++) {
            c = chars[i];
            if (c == '"') {
                i++;
                return sb.toString();
            }

            sb.append(c);
        }

        throw new IllegalArgumentException("Ending \" not found");
    }
}
