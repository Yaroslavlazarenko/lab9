package com.classes;

import java.util.Comparator;

public class Currency {

    private String name;
    private String base;
    private String quote;
    private double price;
    private double priceUsd;
    private double volume;
    private double volumeUsd;
    private String time;


    /**
     *
     * @param name имя биржы
     * @param base валюта что обменивают
     * @param quote цена в валюте на которую обмен
     * @param price цена в валюте на которую обмен
     * @param priceUsd цена в долларах
     * @param volume обьем в валюты на которую обмен
     * @param volumeUsd обьем в долларах
     * @param time время цен
     *
     */
    public Currency(String name, String base, String quote, double price, double priceUsd, double volume, double volumeUsd, String time) {
        super();
        this.name = name;
        this.base = base;
        this.quote = quote;
        this.price = price;
        this.priceUsd = priceUsd;
        this.volume = volume;
        this.volumeUsd = volumeUsd;
        this.time = time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolumeUsd() {
        return volumeUsd;
    }

    public void setVolumeUsd(double volumeUsd) {
        this.volumeUsd = volumeUsd;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name=");
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(System.lineSeparator());
        sb.append("base=");
        sb.append(((this.base == null)?"<null>":this.base));
        sb.append(System.lineSeparator());
        sb.append("quote=");
        sb.append(((this.quote == null)?"<null>":this.quote));
        sb.append(System.lineSeparator());
        sb.append("price=");
        sb.append(this.price);
        sb.append(System.lineSeparator());
        sb.append("priceUsd=");
        sb.append(this.priceUsd);
        sb.append(System.lineSeparator());
        sb.append("volume=");
        sb.append(this.volume);
        sb.append(System.lineSeparator());
        sb.append("volumeUsd=");
        sb.append(this.volumeUsd);
        sb.append(System.lineSeparator());
        sb.append("time=");
        sb.append(this.time);
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public static Comparator<Currency> byNameAsc = Comparator.comparing(o -> o.name);
    public static Comparator<Currency> byNameDesc = (o1, o2) -> o2.name.compareTo(o1.name);
    public static Comparator<Currency> byPryceAsc = (o1, o2) -> Double.compare(o1.price, o2.price);
    public static Comparator<Currency> byPryceDesc = (o1, o2) -> Double.compare(o2.price, o1.price);

}