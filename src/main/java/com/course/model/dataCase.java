package com.course.model;



//解绑时所需的数据
public class dataCase {
     private String fsseed;
     private String fsshopguid;
     private String fsshopstauts;
     private String fstoken;
     private String fsupdatetime;

    public String getFsseed() {
        return fsseed;
    }

    public void setFsseed(String fsseed) {
        this.fsseed = fsseed;
    }

    public String getFsshopguid() {
        return fsshopguid;
    }

    public void setFsshopguid(String fsshopguid) {
        this.fsshopguid = fsshopguid;
    }

    public String getFsshopstauts() {
        return fsshopstauts;
    }

    public void setFsshopstauts(String fsshopstauts) {
        this.fsshopstauts = fsshopstauts;
    }

    public String getFstoken() {
        return fstoken;
    }

    public void setFstoken(String fstoken) {
        this.fstoken = fstoken;
    }

    public String getFsupdatetime() {
        return fsupdatetime;
    }

    public void setFsupdatetime(String fsupdatetime) {
        this.fsupdatetime = fsupdatetime;
    }

    public dataCase(String fsseed, String fsshopguid, String fsshopstauts, String fstoken, String fsupdatetime) {
        this.fsseed = fsseed;
        this.fsshopguid = fsshopguid;
        this.fsshopstauts = fsshopstauts;
        this.fstoken = fstoken;
        this.fsupdatetime = fsupdatetime;
    }

    @Override
        public String toString() {
            return "dataCase{" +
                    "fsseed='" + fsseed + '\'' +
                    ", fsshopguid='" + fsshopguid + '\'' +
                    ", fsshopstauts='" + fsshopstauts + '\'' +
                    ", fstoken='" + fstoken + '\'' +
                    ", fsupdatetime='" + fsupdatetime + '\'' +
                    '}';
    }
}
