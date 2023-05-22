package com.service.spring.domain;

public class CompanyCategoryRelationVO {
	
	private int companyCategoryRelationId; //company_category_relation_id (pk)
	private int category2Id; //category2_id (fk)
	private int companyId; //company_id(fk)
	
	
	public CompanyCategoryRelationVO() {}
	
	public CompanyCategoryRelationVO(int category2Id, int companyId) {
		this.category2Id = category2Id;
		this.companyId = companyId;
	}

	public int getCompanyCategoryRelationId() {
		return companyCategoryRelationId;
	}

	public void setCompanyCategoryRelationId(int companyCategoryRelationId) {
		this.companyCategoryRelationId = companyCategoryRelationId;
	}

	public int getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(int category2Id) {
		this.category2Id = category2Id;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "CompanyCategoryRelationVO [companyCategoryRelationId=" + companyCategoryRelationId + ", category2Id="
				+ category2Id + ", companyId=" + companyId + "]";
	}
	
	
	
	
	
	

}
