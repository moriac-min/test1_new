package foodportal.front.safefoodlife.foodMeterial.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class FoodMeterialVO {
	
	private int			indx;
	private String		mtral_nm;
	private String		scnm_nm;
	private String		ncknm_nm;
	private String		medi_nm;
	private String		chartr;
	private String		cmpn;
	private String		edible;
	private String		root;
	private String		util;
	private String		affc;
	private String		cvpl;
	private String		toxcty;
	private String		mate1;
	private String		etc;
	private String		genss;
	private String		issnocow;
	private String		img;
	private String		dvs;
	private String		year1;
	private String		dvs_1;
	private String		dtm2;
	private String		etc_no1;
	private String		etc_no2;
	private String		animal;
	private String		mono;
	private String		mono_view;
	private String		mono_text;
	private String		dvs_2;
	private String		cd1;
	private String		cd2;
	private String		cd3;
	private String		cd4;
	private String		edible_use;
	private String		animal_2;
	private String		scnm_nm_srch;
	private int			srcnt;
	private String		natn;
	private String		mngr_etc;
	private String		cretr_id;
	private Date		cret_dtm;
	private String		last_updtr_id;
	private Date		last_updt_dtm;
	
	private String		search_type;
	
	private String		srch_name;
	private String		query;
	private String		codex;
	private String		codex_option;
	
	private long 		totalCount;
	
	private String		m_name_option;
	private String		s_name_option;
	private String		n_name_option;
	private String		h_name_option;
	
	private String		component_option;
	private String		poison_option;
	private String		character_option;
	
	private List<FoodMeterialEdibleVO>		possibleList;
	private List<FoodMeterialEdibleVO>		impossibleList;
	private List<FoodMeterialEdibleVO>		limitList;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public String getSearch_type() {
		return search_type;
	}

	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}

	public String getSrch_name() {
		return srch_name;
	}

	public void setSrch_name(String srch_name) {
		this.srch_name = srch_name;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getCodex() {
		return codex;
	}

	public void setCodex(String codex) {
		this.codex = codex;
	}

	public String getCodex_option() {
		return codex_option;
	}

	public void setCodex_option(String codex_option) {
		this.codex_option = codex_option;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public String getM_name_option() {
		return m_name_option;
	}

	public void setM_name_option(String m_name_option) {
		this.m_name_option = m_name_option;
	}

	public String getS_name_option() {
		return s_name_option;
	}

	public void setS_name_option(String s_name_option) {
		this.s_name_option = s_name_option;
	}

	public String getN_name_option() {
		return n_name_option;
	}

	public void setN_name_option(String n_name_option) {
		this.n_name_option = n_name_option;
	}

	public String getH_name_option() {
		return h_name_option;
	}

	public void setH_name_option(String h_name_option) {
		this.h_name_option = h_name_option;
	}

	public int getIndx() {
		return indx;
	}

	public void setIndx(int indx) {
		this.indx = indx;
	}

	public String getMtral_nm() {
		return mtral_nm;
	}

	public void setMtral_nm(String mtral_nm) {
		this.mtral_nm = mtral_nm;
	}

	public String getScnm_nm() {
		return scnm_nm;
	}

	public void setScnm_nm(String scnm_nm) {
		this.scnm_nm = scnm_nm;
	}

	public String getNcknm_nm() {
		return ncknm_nm;
	}

	public void setNcknm_nm(String ncknm_nm) {
		this.ncknm_nm = ncknm_nm;
	}

	public String getMedi_nm() {
		return medi_nm;
	}

	public void setMedi_nm(String medi_nm) {
		this.medi_nm = medi_nm;
	}

	public String getChartr() {
		return chartr;
	}

	public void setChartr(String chartr) {
		this.chartr = chartr;
	}

	public String getCmpn() {
		return cmpn;
	}

	public void setCmpn(String cmpn) {
		this.cmpn = cmpn;
	}

	public String getEdible() {
		return edible;
	}

	public void setEdible(String edible) {
		this.edible = edible;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getUtil() {
		return util;
	}

	public void setUtil(String util) {
		this.util = util;
	}

	public String getAffc() {
		return affc;
	}

	public void setAffc(String affc) {
		this.affc = affc;
	}

	public String getCvpl() {
		return cvpl;
	}

	public void setCvpl(String cvpl) {
		this.cvpl = cvpl;
	}

	public String getToxcty() {
		return toxcty;
	}

	public void setToxcty(String toxcty) {
		this.toxcty = toxcty;
	}

	public String getMate1() {
		return mate1;
	}

	public void setMate1(String mate1) {
		this.mate1 = mate1;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getGenss() {
		return genss;
	}

	public void setGenss(String genss) {
		this.genss = genss;
	}

	public String getIssnocow() {
		return issnocow;
	}

	public void setIssnocow(String issnocow) {
		this.issnocow = issnocow;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDvs() {
		return dvs;
	}

	public void setDvs(String dvs) {
		this.dvs = dvs;
	}

	public String getYear1() {
		return year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}

	public String getDvs_1() {
		return dvs_1;
	}

	public void setDvs_1(String dvs_1) {
		this.dvs_1 = dvs_1;
	}

	public String getDtm2() {
		return dtm2;
	}

	public void setDtm2(String dtm2) {
		this.dtm2 = dtm2;
	}

	public String getEtc_no1() {
		return etc_no1;
	}

	public void setEtc_no1(String etc_no1) {
		this.etc_no1 = etc_no1;
	}

	public String getEtc_no2() {
		return etc_no2;
	}

	public void setEtc_no2(String etc_no2) {
		this.etc_no2 = etc_no2;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getMono() {
		return mono;
	}

	public void setMono(String mono) {
		this.mono = mono;
	}

	public String getMono_view() {
		return mono_view;
	}

	public void setMono_view(String mono_view) {
		this.mono_view = mono_view;
	}

	public String getMono_text() {
		return mono_text;
	}

	public void setMono_text(String mono_text) {
		this.mono_text = mono_text;
	}

	public String getDvs_2() {
		return dvs_2;
	}

	public void setDvs_2(String dvs_2) {
		this.dvs_2 = dvs_2;
	}

	public String getCd1() {
		return cd1;
	}

	public void setCd1(String cd1) {
		this.cd1 = cd1;
	}

	public String getCd2() {
		return cd2;
	}

	public void setCd2(String cd2) {
		this.cd2 = cd2;
	}

	public String getCd3() {
		return cd3;
	}

	public void setCd3(String cd3) {
		this.cd3 = cd3;
	}

	public String getCd4() {
		return cd4;
	}

	public void setCd4(String cd4) {
		this.cd4 = cd4;
	}

	public String getEdible_use() {
		return edible_use;
	}

	public void setEdible_use(String edible_use) {
		this.edible_use = edible_use;
	}

	public String getAnimal_2() {
		return animal_2;
	}

	public void setAnimal_2(String animal_2) {
		this.animal_2 = animal_2;
	}

	public String getScnm_nm_srch() {
		return scnm_nm_srch;
	}

	public void setScnm_nm_srch(String scnm_nm_srch) {
		this.scnm_nm_srch = scnm_nm_srch;
	}

	public int getSrcnt() {
		return srcnt;
	}

	public void setSrcnt(int srcnt) {
		this.srcnt = srcnt;
	}

	public String getNatn() {
		return natn;
	}

	public void setNatn(String natn) {
		this.natn = natn;
	}

	public String getMngr_etc() {
		return mngr_etc;
	}

	public void setMngr_etc(String mngr_etc) {
		this.mngr_etc = mngr_etc;
	}

	public String getCretr_id() {
		return cretr_id;
	}

	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}

	public Date getCret_dtm() {
		return cret_dtm;
	}

	public void setCret_dtm(Date cret_dtm) {
		this.cret_dtm = cret_dtm;
	}

	public String getLast_updtr_id() {
		return last_updtr_id;
	}

	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}

	public Date getLast_updt_dtm() {
		return last_updt_dtm;
	}

	public void setLast_updt_dtm(Date last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}

	public String getComponent_option() {
		return component_option;
	}

	public void setComponent_option(String component_option) {
		this.component_option = component_option;
	}

	public String getPoison_option() {
		return poison_option;
	}

	public void setPoison_option(String poison_option) {
		this.poison_option = poison_option;
	}

	public String getCharacter_option() {
		return character_option;
	}

	public void setCharacter_option(String character_option) {
		this.character_option = character_option;
	}

	public List<FoodMeterialEdibleVO> getPossibleList() {
		if (this.possibleList == null) {
			this.possibleList = new ArrayList<FoodMeterialEdibleVO>();
		}
		
		List<FoodMeterialEdibleVO> tempList = new ArrayList<FoodMeterialEdibleVO>(possibleList);
		//return Collections.unmodifiableList(possibleList);
		return tempList;
	}
	
	public void addToPossibleList(FoodMeterialEdibleVO foodMeterialEdibleVO) {
		if (this.possibleList == null) {
			this.possibleList = new ArrayList<FoodMeterialEdibleVO>();
		}
		
		this.possibleList.add(foodMeterialEdibleVO);
	}

	//public void setPossibleList(List<FoodMeterialEdibleVO> possibleList) {
	//	this.possibleList = possibleList;
	//}

	public List<FoodMeterialEdibleVO> getImpossibleList() {
		if (this.impossibleList == null) {
			this.impossibleList = new ArrayList<FoodMeterialEdibleVO>();
		}
		
		List<FoodMeterialEdibleVO> tempList = new ArrayList<FoodMeterialEdibleVO>(impossibleList);
		return tempList;
	}
	
	public void addToImpossibleList(FoodMeterialEdibleVO foodMeterialEdibleVO) {
		if (this.impossibleList == null) {
			this.impossibleList = new ArrayList<FoodMeterialEdibleVO>();
		}
		
		this.impossibleList.add(foodMeterialEdibleVO);
	}

	//public void setImpossibleList(List<FoodMeterialEdibleVO> impossibleList) {
	//	this.impossibleList = impossibleList;
	//}

	public List<FoodMeterialEdibleVO> getLimitList() {
		if (this.limitList == null) {
			this.limitList = new ArrayList<FoodMeterialEdibleVO>();
		}
		
		List<FoodMeterialEdibleVO> tempList = new ArrayList<FoodMeterialEdibleVO>(limitList);
		return tempList;
	}
	
	public void addToLimitList(FoodMeterialEdibleVO foodMeterialEdibleVO) {
		if (this.limitList == null) {
			this.limitList = new ArrayList<FoodMeterialEdibleVO>();
		}
		
		this.limitList.add(foodMeterialEdibleVO);
	}

	//public void setLimitList(List<FoodMeterialEdibleVO> limitList) {
	//	this.limitList = limitList;
	//}

}