package weathermaker;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherData {

    private String temperature, icon, city, weatherType;
    private int condition;

    public static WeatherData fromJson(JSONObject jsonObject) {
        try {
            WeatherData weatherD = new WeatherData();
            weatherD.city = jsonObject.getString("name");
            weatherD.condition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.weatherType = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            //weatherD.icon = IconFunction(weatherD.condition);
            double tempResult = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue = (int)Math.rint(tempResult);
            weatherD.temperature = Integer.toString(roundedValue);
            return weatherD;
        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

}
