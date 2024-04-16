package com.example.trackyourscrolls;

public class ZoneModel {
    String zoneName;
    String zoneText;
    String zoneImg;


    public ZoneModel(String zoneName, String zoneText, String zoneImg) {
        this.zoneName = zoneName;
        this.zoneText = zoneText;
        this.zoneImg = zoneImg;
    }

    public String getZoneName() {
        return zoneName;
    }

    public String getZoneText() {
        return zoneText;
    }

    public int getZoneImg() {
       switch (zoneImg){
           case "am":
               return R.drawable.aakman;
           case "se":
               return R.drawable.starend;
           case "tw":
               return R.drawable.thornwood;
           default:
               break;
       }
       return R.drawable.zone;
    }
}
