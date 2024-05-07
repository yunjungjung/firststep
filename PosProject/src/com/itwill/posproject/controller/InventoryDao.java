package com.itwill.posproject.controller;

import com.itwill.posproject.model.Inventory;
import oracle.jdbc.OracleDriver;

public class InventoryDao {
	   private int PIG_BAR;
	   private int JEWEL_BAR;
	   private int BUNPARAE;
	   private int WA_PRICE = 2000;
	   private int WILD_BODY;
	   private int TANK_BOY0;
	   private int COOAND_CRE;
	   private int SSANGSSANG_BAR;
	   private int WASACK_BAR;
	   
	   public InventoryDao() {}

	public int getPIG_BAR() {
		return PIG_BAR;
	}

	public void setPIG_BAR(int pIG_BAR) {
		PIG_BAR = pIG_BAR;
	}

	public int getJEWEL_BAR() {
		return JEWEL_BAR;
	}

	public void setJEWEL_BAR(int jEWEL_BAR) {
		JEWEL_BAR = jEWEL_BAR;
	}

	public int getBUNPARAE() {
		return BUNPARAE;
	}

	public void setBUNPARAE(int bUNPARAE) {
		BUNPARAE = bUNPARAE;
	}

	public int getWA_PRICE() {
		return WA_PRICE;
	}

	public void setWA_PRICE(int wA_PRICE) {
		WA_PRICE = wA_PRICE;
	}

	public int getWILD_BODY() {
		return WILD_BODY;
	}

	public void setWILD_BODY(int wILD_BODY) {
		WILD_BODY = wILD_BODY;
	}

	public int getTANK_BOY0() {
		return TANK_BOY0;
	}

	public void setTANK_BOY0(int tANK_BOY0) {
		TANK_BOY0 = tANK_BOY0;
	}

	public int getCOOAND_CRE() {
		return COOAND_CRE;
	}

	public void setCOOAND_CRE(int cOOAND_CRE) {
		COOAND_CRE = cOOAND_CRE;
	}

	public int getSSANGSSANG_BAR() {
		return SSANGSSANG_BAR;
	}

	public void setSSANGSSANG_BAR(int sSANGSSANG_BAR) {
		SSANGSSANG_BAR = sSANGSSANG_BAR;
	}

	public int getWASACK_BAR() {
		return WASACK_BAR;
	}

	public void setWASACK_BAR(int wASACK_BAR) {
		WASACK_BAR = wASACK_BAR;
	}

	@Override
	public String toString() {
		return "InventoryDao [PIG_BAR=" + PIG_BAR + ", JEWEL_BAR=" + JEWEL_BAR + ", BUNPARAE=" + BUNPARAE
				+ ", WA_PRICE=" + WA_PRICE + ", WILD_BODY=" + WILD_BODY + ", TANK_BOY0=" + TANK_BOY0 + ", COOAND_CRE="
				+ COOAND_CRE + ", SSANGSSANG_BAR=" + SSANGSSANG_BAR + ", WASACK_BAR=" + WASACK_BAR + "]";
	}

	public Inventory getInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		
	}
	   

}
