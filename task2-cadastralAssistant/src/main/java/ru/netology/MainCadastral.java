package ru.netology;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MainCadastral {
    public static final double MIN_SQR_METER_PRICE = 100.5;
    public static final double MAX_SQR_METER_PRICE = 150.6;

    public static void main(String[] args) {
        List<Deal> dealList = new ArrayList<>();
        setDealList(dealList);

        checkHonesty(dealList, MIN_SQR_METER_PRICE, MAX_SQR_METER_PRICE)
                .forEach(System.out::println);
    }

    public static List<Deal> checkHonesty(List<Deal> deals, double minSqrMeterPrice, double maxSqrMeterPrice) {
        return deals.stream()
                .map(x -> {
                    if ((x.getLength() * x.getWidth() * minSqrMeterPrice <= x.getPrice()) && (x.getLength() * x.getWidth() * maxSqrMeterPrice >= x.getPrice()))
                        x.setHonesty(true);
                    else
                        x.setHonesty(false);

                    return x;
                })
                .collect(Collectors.toList());
    }

    public static void setDealList(List<Deal> list) {
        list.add(new Deal(12.4, 105.1, 110000));    //
        list.add(new Deal(13.2, 200.4, 375000));    //ч
        list.add(new Deal(15.7, 50, 110000));       //ч
        list.add(new Deal(12.5, 120.6, 110000));    //
        list.add(new Deal(19.8, 103.2, 220000));    //ч
        list.add(new Deal(11.3, 145.9, 110000));    //
        list.add(new Deal(25.4, 156.1, 580000));    //ч
        list.add(new Deal(31.5, 170.4, 800000));    //ч
    }


}
