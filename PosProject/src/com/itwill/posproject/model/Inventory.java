package com.itwill.posproject.model;

public class Inventory {
    public static final class Entity {
        // 데이터베이스 테이블 이름을 상수로 선언.
        public static final String TBL_INVENTORY = "INVENTORIES";

        public static final String COL_PIG_BAR_STOCK = "PIG_BAR_STOCK";
        public static final String COL_JEWEL_BAR_STOCK = "JEWEL_BAR_STOCK";
        public static final String COL_BUNPARAE_STOCK = "BUNPARAE_STOCK";
        public static final String COL_WA_STOCK = "WA_STOCK";
        public static final String COL_WILD_BODY_STOCK = "WILD_BODY_STOCK";
        public static final String COL_TANK_BOY_STOCK = "TANK_BOY_STOCK";
        public static final String COL_COOAND_CRE_STOCK = "COOAND_CRE_STOCK";
        public static final String COL_SSANGSSANG_BAR_STOCK = "SSANGSSANG_BAR_STOCK";
        public static final String COL_WASACK_BAR_STOCK = "WASACK_BAR_STOCK";
    }

    private int pigBarStock;
    private int jewelBarStock;
    private int bunparaeStock;
    private int waStock;
    private int wildBodyStock;
    private int tankBoyStock;
    private int cooandCreStock;
    private int ssangssangBarStock;
    private int wasackBarStock;

    public Inventory() {}

    public Inventory(int pigBarStock,
                     int jewelBarStock,
                     int bunparaeStock,
                     int waStock,
                     int wildBodyStock,
                     int tankBoyStock,
                     int cooandCreStock,
                     int ssangssangBarStock,
                     int wasackBarStock) {
        super();
        this.pigBarStock = pigBarStock;
        this.jewelBarStock = jewelBarStock;
        this.bunparaeStock = bunparaeStock;
        this.waStock = waStock;
        this.wildBodyStock = wildBodyStock;
        this.tankBoyStock = tankBoyStock;
        this.cooandCreStock = cooandCreStock;
        this.ssangssangBarStock = ssangssangBarStock;
        this.wasackBarStock = wasackBarStock;
    }
    public int getPigBarStock() {
        return pigBarStock;
    }

    public void setPigBarStock(int pigBarStock) {
        this.pigBarStock = pigBarStock;
    }

    public int getJewelBarStock() {
        return jewelBarStock;
    }

    public void setJewelBarStock(int jewelBarStock) {
        this.jewelBarStock = jewelBarStock;
    }

    public int getBunparaeStock() {
        return bunparaeStock;
    }

    public void setBunparaeStock(int bunparaeStock) {
        this.bunparaeStock = bunparaeStock;
    }

    public int getWaStock() {
        return waStock;
    }

    public void setWaStock(int waStock) {
        this.waStock = waStock;
    }

    public int getWildBodyStock() {
        return wildBodyStock;
    }

    public void setWildBodyStock(int wildBodyStock) {
        this.wildBodyStock = wildBodyStock;
    }

    public int getTankBoyStock() {
        return tankBoyStock;
    }

    public void setTankBoyStock(int tankBoyStock) {
        this.tankBoyStock = tankBoyStock;
    }

    public int getCooandCreStock() {
        return cooandCreStock;
    }

    public void setCooandCreStock(int cooandCreStock) {
        this.cooandCreStock = cooandCreStock;
    }

    public int getSsangssangBarStock() {
        return ssangssangBarStock;
    }

    public void setSsangssangBarStock(int ssangssangBarStock) {
        this.ssangssangBarStock = ssangssangBarStock;
    }

    public int getWasackBarStock() {
        return wasackBarStock;
    }

    public void setWasackBarStock(int wasackBarStock) {
        this.wasackBarStock = wasackBarStock;
    }

    @Override
    public String toString() {
        return "Inventory [" +
                "pigBarStock=" + pigBarStock +
                ", jewelBarStock=" + jewelBarStock +
                ", bunparaeStock=" + bunparaeStock +
                ", waStock=" + waStock +
                ", wildBodyStock=" + wildBodyStock +
                ", tankBoyStock=" + tankBoyStock +
                ", cooandCreStock=" + cooandCreStock +
                ", ssangssangBarStock=" + ssangssangBarStock +
                ", wasackBarStock=" + wasackBarStock +
                "]";
    }
}

