package test.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import nn1211.json.Json;
import org.junit.Test;

/**
 * Deserializer test cases.
 *
 * @author nn1211
 * @since 1.0
 */
public class TestDeserializer {

    @Test
    public void testParseEmptyObject01() {
        String str = "{}";
        Json o = Json.parse(str);
        assert null != o;
    }

    @Test
    public void testParseObject01() {
        String str = "{ \"name\": \"Nguyen Van A\" }";
        Json o = Json.parse(str);
        assert null != o;
        assert 1 == o.size();
        assert "Nguyen Van A".equals(o.asObject().getString("name"));
    }

    @Test
    public void testParseObject02() {
        String str = "{ \"name\": \"Nguyen Van A\" , \"iat\" : 1353601026  }";
        Json o = Json.parse(str);
        assert null != o;
        assert 2 == o.size();
        assert "Nguyen Van A".equals(o.asObject().getString("name"));
        assert 1353601026 == o.asObject().getInt("iat");
    }

    @Test
    public void testParseObject03() {
        String str = "{\n"
                + "  \"access_token\": \"ya29.a0ARrdaM_Lx29HcNH1KFRpYzKPIgFP_Sf2cM8WQrAuIFy_se-ba51NSAWrGliiQ1WzqCKgh3rc9nE2VjXQxN7vEV0h02TzChdEIl_ck3dgRVTz5ErWOXF7FHAN4LvmvoHchmkjCEa-4EWTRZnKFaZzsj7hCugi\",\n"
                + "  \"expires_in\": 3599,\n"
                + "  \"refresh_token\": \"1//0ekK16fGEy5GZCgYIARAAGA4SNwF-L9Ir-q2HqHZO1MHZ7-BngYl6Gbsa1O8eJ1LnWNAnebpvnMqVdNKr8_7c78y-9im6NWxIqnc\",\n"
                + "  \"scope\": \"openid https://www.googleapis.com/auth/userinfo.email\",\n"
                + "  \"token_type\": \"Bearer\",\n"
                + "  \"id_token\": \"eyJhbGciOiJSUzI1NiIsImtpZCI6IjZlZjRiZDkwODU5MWY2OTdhOGE5Yjg5M2IwM2U2YTc3ZWIwNGU1MWYiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIxMDg5MDc5NzI3OTkyLXRhczRtZmtvZ21mczhyNDFib29uYW9nODltZTBjYjFmLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiMTA4OTA3OTcyNzk5Mi10YXM0bWZrb2dtZnM4cjQxYm9vbmFvZzg5bWUwY2IxZi5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsInN1YiI6IjExODEyNzc1MzY4NjMyNTg1Mjc5OCIsImVtYWlsIjoiZm9ydm5nYW1lMDAwMkBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXRfaGFzaCI6InJJVjkxN3JiUXp2T2lsWkptT1psTHciLCJpYXQiOjE2Mjk1ODI0NTcsImV4cCI6MTYyOTU4NjA1N30.IH8AoG4jxn3M0Mtzj9PYNyBndgdFUwzbX4-iyhmSyeCxvAVyMUcd4up_PUGcgFf_PXRHv1Zifdnj3R0LIhDNcrH5dIQp66mV4EZRGCjqlAzv2-VC6aJkoArMEXHVsP3YopbKEDSc-ZoAHRVRvFIN8SINqPSfnaJkT6vodyZIeyhADji9iOvL6PN7ySY1HknLieC8p1lPfI4RKr6hKzEA6667T4L_0nmVL4aOzpHKLVdviSpgqoiGtRsCBAq5pXRUAI79_HA623EQ0OXk2K3VxqGgNKa4r_-GjqnIWImutn8rfMUlkuSfulc9NrheDl-8yyj9-EUURUqX-FtidcvmSw\"\n"
                + "}";

        Json o = Json.parse(str);
        assert null != o;
        assert 6 == o.size();
        assert "Bearer".equals(o.asObject().getString("token_type"));
        assert 3599 == o.asObject().getInt("expires_in");
        assert str.equals(o.toString());
    }

    @Test
    public void testParseObject04() {
        String str = "{\n"
                + "  \"obj1\": " + "{\n"
                + "  \"access_token\": \"ya29.a0ARrdaM_Lx29HcNH1KFRpYzKPIgFP_Sf2cM8WQrAuIFy_se-ba51NSAWrGliiQ1WzqCKgh3rc9nE2VjXQxN7vEV0h02TzChdEIl_ck3dgRVTz5ErWOXF7FHAN4LvmvoHchmkjCEa-4EWTRZnKFaZzsj7hCugi\",\n"
                + "  \"expires_in\": 3599,\n"
                + "  \"refresh_token\": \"1//0ekK16fGEy5GZCgYIARAAGA4SNwF-L9Ir-q2HqHZO1MHZ7-BngYl6Gbsa1O8eJ1LnWNAnebpvnMqVdNKr8_7c78y-9im6NWxIqnc\",\n"
                + "  \"scope\": \"openid https://www.googleapis.com/auth/userinfo.email\",\n"
                + "  \"token_type\": \"Bearer\",\n"
                + "  \"id_token\": \"eyJhbGciOiJSUzI1NiIsImtpZCI6IjZlZjRiZDkwODU5MWY2OTdhOGE5Yjg5M2IwM2U2YTc3ZWIwNGU1MWYiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIxMDg5MDc5NzI3OTkyLXRhczRtZmtvZ21mczhyNDFib29uYW9nODltZTBjYjFmLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiMTA4OTA3OTcyNzk5Mi10YXM0bWZrb2dtZnM4cjQxYm9vbmFvZzg5bWUwY2IxZi5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsInN1YiI6IjExODEyNzc1MzY4NjMyNTg1Mjc5OCIsImVtYWlsIjoiZm9ydm5nYW1lMDAwMkBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXRfaGFzaCI6InJJVjkxN3JiUXp2T2lsWkptT1psTHciLCJpYXQiOjE2Mjk1ODI0NTcsImV4cCI6MTYyOTU4NjA1N30.IH8AoG4jxn3M0Mtzj9PYNyBndgdFUwzbX4-iyhmSyeCxvAVyMUcd4up_PUGcgFf_PXRHv1Zifdnj3R0LIhDNcrH5dIQp66mV4EZRGCjqlAzv2-VC6aJkoArMEXHVsP3YopbKEDSc-ZoAHRVRvFIN8SINqPSfnaJkT6vodyZIeyhADji9iOvL6PN7ySY1HknLieC8p1lPfI4RKr6hKzEA6667T4L_0nmVL4aOzpHKLVdviSpgqoiGtRsCBAq5pXRUAI79_HA623EQ0OXk2K3VxqGgNKa4r_-GjqnIWImutn8rfMUlkuSfulc9NrheDl-8yyj9-EUURUqX-FtidcvmSw\"\n"
                + "},"
                + "  \"access_token\": \"ya29.a0ARrdaM_Lx29HcNH1KFRpYzKPIgFP_Sf2cM8WQrAuIFy_se-ba51NSAWrGliiQ1WzqCKgh3rc9nE2VjXQxN7vEV0h02TzChdEIl_ck3dgRVTz5ErWOXF7FHAN4LvmvoHchmkjCEa-4EWTRZnKFaZzsj7hCugi\",\n"
                + "  \"expires_in\": 3599,\n"
                + "  \"refresh_token\": \"1//0ekK16fGEy5GZCgYIARAAGA4SNwF-L9Ir-q2HqHZO1MHZ7-BngYl6Gbsa1O8eJ1LnWNAnebpvnMqVdNKr8_7c78y-9im6NWxIqnc\",\n"
                + "  \"scope\": \"openid https://www.googleapis.com/auth/userinfo.email\",\n"
                + "  \"token_type\": \"Bearer\",\n"
                + "  \"id_token\": \"eyJhbGciOiJSUzI1NiIsImtpZCI6IjZlZjRiZDkwODU5MWY2OTdhOGE5Yjg5M2IwM2U2YTc3ZWIwNGU1MWYiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIxMDg5MDc5NzI3OTkyLXRhczRtZmtvZ21mczhyNDFib29uYW9nODltZTBjYjFmLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiMTA4OTA3OTcyNzk5Mi10YXM0bWZrb2dtZnM4cjQxYm9vbmFvZzg5bWUwY2IxZi5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsInN1YiI6IjExODEyNzc1MzY4NjMyNTg1Mjc5OCIsImVtYWlsIjoiZm9ydm5nYW1lMDAwMkBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXRfaGFzaCI6InJJVjkxN3JiUXp2T2lsWkptT1psTHciLCJpYXQiOjE2Mjk1ODI0NTcsImV4cCI6MTYyOTU4NjA1N30.IH8AoG4jxn3M0Mtzj9PYNyBndgdFUwzbX4-iyhmSyeCxvAVyMUcd4up_PUGcgFf_PXRHv1Zifdnj3R0LIhDNcrH5dIQp66mV4EZRGCjqlAzv2-VC6aJkoArMEXHVsP3YopbKEDSc-ZoAHRVRvFIN8SINqPSfnaJkT6vodyZIeyhADji9iOvL6PN7ySY1HknLieC8p1lPfI4RKr6hKzEA6667T4L_0nmVL4aOzpHKLVdviSpgqoiGtRsCBAq5pXRUAI79_HA623EQ0OXk2K3VxqGgNKa4r_-GjqnIWImutn8rfMUlkuSfulc9NrheDl-8yyj9-EUURUqX-FtidcvmSw\"\n"
                + "}";

        long start = System.nanoTime();
        Json o = Json.parse(str);
        long end = System.nanoTime();

        System.out.println(end - start);
        assert end - start < 200000;

        start = System.nanoTime();
        JsonElement je = JsonParser.parseString(str);
        end = System.nanoTime();
        System.out.println(end - start);
        assert end - start < 30000000;

        assert null != o;
        assert 7 == o.size();
        assert "Bearer".equals(o.asObject().getString("token_type"));
        assert 3599 == o.asObject().getInt("expires_in");
        assert str.equals(o.toString());
        System.out.println(o.asObject().getObject("obj1"));
    }
}
