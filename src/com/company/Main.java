package com.company;

import com.classes.Currency;
import com.classes.JSONGetter;
import com.classes.Rates;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main
{

    public static void main(String[] args)
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        JSONGetter jsonGetter = new JSONGetter();
        JSONGetter.url = "https://api.coinlore.net/api/coin/markets/?id=90";
        jsonGetter.run();

        System.out.println("Waiting for data...");
        String jsonString = jsonGetter.jsonIn;
        System.out.println(jsonString);

        // Считываем json
        Object obj = null;
        try
        {
            obj = new JSONParser().parse(jsonString);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        System.out.println();

        JSONArray jsonArray = (JSONArray) obj;
        System.out.println(jsonArray.toJSONString());
        System.out.println();

        Rates rates = new Rates();

        for (Object jsonObject : jsonArray)
        {
            JSONObject current = (JSONObject) jsonObject;
            String name = (String) current.get("name");
            String base = (String) current.get("base");
            String quote = (String) current.get("quote");
            double price = Double.parseDouble(current.get("price").toString());
            double priceUsd = Double.parseDouble(current.get("price_usd").toString());
            double volume = Double.parseDouble(current.get("volume").toString());
            double volumeUsd = Double.parseDouble(current.get("volume_usd").toString());
            String time = Instant.ofEpochSecond(Long.parseLong(current.get("time").toString())).atZone(ZoneId.systemDefault()).format(dateTimeFormatter);
            Currency currency = new Currency(name, base, quote, price, priceUsd, volume, volumeUsd, time);
            rates.add(currency);
        }

        System.out.println("Imported data after parsing:\n" + rates);
        System.out.println(rates);

        rates.getRates().sort(Currency.byNameAsc);
        System.out.println("After sorting by name ascending:\n" + rates);
        rates.getRates().sort(Currency.byNameDesc);
        System.out.println("After sorting by name descending:\n" + rates);

        rates.getRates().sort(Currency.byPryceAsc);
        System.out.println("After sorting by Buy value ascending:\n" + rates);
        rates.getRates().sort(Currency.byPryceDesc);
        System.out.println("After sorting by Buy value descending:\n" + rates);

        Rates withXRP = rates.filterByBase("XRP");
        System.out.println("Filtered data with 'XRP' in title:" + withXRP);

        Rates withADA = rates.filterByBase("ADA");
        System.out.println("Filtered data with 'ADA' in title:" + withADA);
    }
}