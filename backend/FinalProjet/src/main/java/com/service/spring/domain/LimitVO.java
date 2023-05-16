package com.service.spring.domain;

public class LimitVO {
    private int limitId; //limit_id(pk)
    private int cCount; //c_count
    private int mCount; //m_count
    private int planId; //plan_id (fk)
    private int nCount; //n_count

    public LimitVO() {
    }

    public LimitVO(int cCount, int mCount, int nCount) {
        this.cCount = cCount;
        this.mCount = mCount;
        this.nCount = nCount;
    }

    public int getLimitId() {
        return limitId;
    }

    public void setLimitId(int limitId) {
        this.limitId = limitId;
    }

    public int getcCount() {
        return cCount;
    }

    public void setcCount(int cCount) {
        this.cCount = cCount;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getnCount() {
        return nCount;
    }

    public void setnCount(int nCount) {
        this.nCount = nCount;
    }

    @Override
    public String toString() {
        return "LimitVO{" +
                "limitId=" + limitId +
                ", cCount=" + cCount +
                ", mCount=" + mCount +
                ", planId='" + planId + '\'' +
                ", nCount=" + nCount +
                '}';
    }
}
