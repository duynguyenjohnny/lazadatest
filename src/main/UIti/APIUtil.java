
public class APIUtil {


    public static JSONObject sendPost(String url, Object requestBody) {
        try {
            // Create request connection
            URL obj = null;
            try {
                obj = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) obj.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // add reuqest header
            con.setRequestMethod("POST");
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(requestBody.toString());
            wr.flush();
            wr.close();
            addLog("\nSending 'POST' request to URL : " + url);
            addLog("\nPost parameters : " + requestBody);
            // Get response code
            int responseCode = con.getResponseCode();
            addLog("\nResponse Code : " + responseCode);
            // Get response body
            BufferedReader in;
            if (responseCode != 200 && responseCode != 201) {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            addLog(response.toString());
            // Return Json object
            JSONParser parser = new JSONParser();
            Object jsonObject = null;
            try {
                jsonObject = parser.parse(response.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (jsonObject instanceof Long) {
                jsonObject = parser.parse("{\"id\": " + jsonObject.toString() + "}");
            }
            if (jsonObject instanceof Boolean) {
                return null;
            }
            return (JSONObject) jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject UpdateUser(String url, Object requestBody, String id) {
        try {
            // Create request connection
            url = url + id;
            URL obj = null;
            try {
                obj = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) obj.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // add reuqest header
            con.setRequestMethod("PUT");
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(requestBody.toString());
            wr.flush();
            wr.close();
            addLog("\nSending 'PUT' request to URL : " + url);
            addLog("\nPost parameters : " + requestBody);
            // Get response code
            int responseCode = con.getResponseCode();
            addLog("\nResponse Code : " + responseCode);
            // Get response body
            BufferedReader in;
            if (responseCode != 200 && responseCode != 201) {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            addLog(response.toString());
            // Return Json object
            JSONParser parser = new JSONParser();
            Object jsonObject = null;
            try {
                jsonObject = parser.parse(response.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (jsonObject instanceof Long) {
                jsonObject = parser.parse("{\"id\": " + jsonObject.toString() + "}");
            }
            if (jsonObject instanceof Boolean) {
                return null;
            }
            return (JSONObject) jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject sendGet(String url) {
        try {
            // Create request connection
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // Add request header
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            // Send get request
            addLog("\nSending 'GET' request to URL : " + url);
            // Get response code
            int responseCode = con.getResponseCode();
            addLog("\nResponse Code : " + responseCode);
            // Get response body
            BufferedReader in;
            if (responseCode != 200 && responseCode != 201) {
                in = new BufferedReader(new InputStreamReader(
                        con.getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            addLog(response.toString());
            // Return Json object
            JSONParser parser = new JSONParser();
            Object jsonObject = parser.parse(response.toString());
            if (jsonObject instanceof Long) {
                jsonObject = parser.parse("{\"id\": " + jsonObject.toString() + "}");
            }
            if (jsonObject instanceof Boolean) {
                return null;
            }
            return (JSONObject) jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject FindUser(String url, String ID) {
        try {
            // Create request connection
            url = url + ID;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // Add request header
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            // Send get request
            addLog("\nSending 'GET' request to find user : " + url);
            // Get response code
            int responseCode = con.getResponseCode();
            addLog("\nResponse Code : " + responseCode);
            // Get response body
            BufferedReader in;
            if (responseCode != 200 && responseCode != 201) {
                in = new BufferedReader(new InputStreamReader(
                        con.getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            addLog(response.toString());
            // Return Json object
            JSONParser parser = new JSONParser();
            Object jsonObject = parser.parse(response.toString());
            if (jsonObject instanceof Long) {
                jsonObject = parser.parse("{\"id\": " + jsonObject.toString() + "}");
            }
            if (jsonObject instanceof Boolean) {
                return null;
            }
            return (JSONObject) jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String sendDelete(String url, String id) throws IOException, ParseException {
        // Create request connection
        url = url + id;
        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // Add request header
        con.setRequestMethod("DELETE");
        // Send get request
        addLog("\nSending 'DELETE' request to URL : " + url);
        // Get response code
        int responseCode = con.getResponseCode();
        addLog("\nResponse Code : " + responseCode);
        // Get response body
        BufferedReader in;
        if (responseCode != 200 && responseCode != 201) {
            in = new BufferedReader(new InputStreamReader(
                    con.getErrorStream()));
        } else {
            in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
        }
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // print result
        addLog(response.toString());
        System.out.print("\nresponse " + response.toString());
        return response.toString();
    }

}

    public static JSONObject sendHTTPRequest(String method, String url, String requestBody) {
        try {
            // Create request connection
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // add reuqest header
            con.setRequestMethod(method);
            // Send HTTP request
            addLog("\nSending '" + method + "' request to URL : " + url);
            if (!method.equals("GET") && !method.equals("DELETE")) {
                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(
                        con.getOutputStream());
                wr.writeBytes(requestBody);
                wr.flush();
                wr.close();
                addLog("\nPost parameters : " + requestBody);
            }
            // Get response code
            int responseCode = con.getResponseCode();
            addLog("\nResponse Code : " + responseCode);
            // Get response body
            BufferedReader in;
            if (responseCode != 200 && responseCode != 201) {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            addLog(response.toString());
            // Return Json object
            JSONParser parser = new JSONParser();
            Object jsonObject = parser.parse(response.toString());
            if(jsonObject instanceof Long){
                jsonObject = parser.parse("{\"id\": " + jsonObject.toString() + "}");
            }
            if(jsonObject instanceof Boolean){
                return null;
            }
            return (JSONObject) jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}