package com.zeros.algo.algo.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Greedy {
    public static void SetCovering(){
         /*
        Problem : find  smallest statations cam cover almost province in list
         */
        var provinceNeedToCover = new HashSet<>(Arrays.asList("HaNoi", "HaiPhong", "DaNang", "QuangNam", "BinhDinh", "HaNam", "HungYen", "LaoCai", "YenBai","PhuQuoc"));
        var stations = new HashMap<String, Set<String>>();

        stations.put("Station_1", new HashSet<>(Arrays.asList("HaNoi", "HaiPhong", "HaNam")));
        stations.put("Station_2", new HashSet<>(Arrays.asList("DaNang", "QuangNam", "BinhDinh")));
        stations.put("Station_3", new HashSet<>(Arrays.asList("HungYen", "LaoCai", "YenBai")));
        stations.put("Station_4", new HashSet<>(Arrays.asList("HoChiMinh", "VungTau")));
        stations.put("Station_5", new HashSet<>(Arrays.asList("PhuYen", "QuyNhon")));

        var answerStations = new HashSet<String>();
        while (!provinceNeedToCover.isEmpty()) {
            String bestStation = null;
            var provinceCovered = new HashSet<String>();

            for (var station : stations.entrySet()) {
                var covered = new HashSet<>(provinceNeedToCover);
                covered.retainAll(station.getValue());  // Get intersection of (province of stations) and provinceNeedToCover

                //Find station cover largest province
                if (covered.size() > provinceCovered.size()) {
                    bestStation = station.getKey();
                    provinceCovered = covered;
                }
            }

            //Remove provinces already processed
            provinceNeedToCover.removeIf(provinceCovered::contains);

            if (bestStation != null) {
                answerStations.add(bestStation);
            }else{
                break;
            }
        }
        System.out.println(answerStations);
    }
}
