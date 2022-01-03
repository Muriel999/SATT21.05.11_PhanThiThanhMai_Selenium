import Common.Common.Utilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class DataProcessing extends TestBase {
    @DataProvider
    public static Object[] dataProviderTC14() {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;

        Object object;

        try {
            object = jsonParser.parse(new FileReader(Utilities.getProjectPath() + "\\src\\main\\java\\Data\\data14.json"));
            jsonObject = (JSONObject) object;
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }

        JSONArray formBookTicketInfo = (JSONArray)jsonObject.get("TC14");

        String[] bookedTicketInfo = new String[formBookTicketInfo.size()];
        JSONObject formBookTicketInfoData = null;
        String departDate, departFrom, arriveAt, seatType, ticketAmount;

        for (int i = 0; i < formBookTicketInfo.size(); i++) {
            formBookTicketInfoData = (JSONObject) formBookTicketInfo.get(i);
            departDate = (String) formBookTicketInfoData.get("DepartDate");
            departFrom = (String) formBookTicketInfoData.get("DepartFrom");
            arriveAt = (String) formBookTicketInfoData.get("ArriveAt");
            seatType = (String) formBookTicketInfoData.get("SeatType");
            ticketAmount = (String) formBookTicketInfoData.get("TicketAmount");

            bookedTicketInfo[i] = departDate + "," + departFrom + "," + arriveAt + "," + seatType + "," + ticketAmount;
        }

        return bookedTicketInfo;
    }
    @DataProvider
    public static Object[] dataProviderTC15(){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject1 = null;
        try{
            Object object = parser.parse(new FileReader(Utilities.getProjectPath()+"\\src\\main\\java\\Data\\data15.json"));
            jsonObject1 = (JSONObject) object;
        } catch (IOException | ParseException exception){
            exception.printStackTrace();
        }

        Object[] ticketPriceData = new Object[1];
        HashMap<String, String> hashMap = new LinkedHashMap<>();
        if(jsonObject1 != null){
            Set<String> jsonObjectKeys = jsonObject1.keySet();
            for(String jsonObjectKey : jsonObjectKeys){
                hashMap.put(jsonObjectKey, (String) jsonObject1.get(jsonObjectKey));
            }
        } else {
            System.out.println("Error Data");
        }
        ticketPriceData[0] = hashMap;
        return ticketPriceData;
    }
}