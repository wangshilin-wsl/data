package com.wsl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KillGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KillGoodsExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andKillidIsNull() {
            addCriterion("killid is null");
            return (Criteria) this;
        }

        public Criteria andKillidIsNotNull() {
            addCriterion("killid is not null");
            return (Criteria) this;
        }

        public Criteria andKillidEqualTo(Integer value) {
            addCriterion("killid =", value, "killid");
            return (Criteria) this;
        }

        public Criteria andKillidNotEqualTo(Integer value) {
            addCriterion("killid <>", value, "killid");
            return (Criteria) this;
        }

        public Criteria andKillidGreaterThan(Integer value) {
            addCriterion("killid >", value, "killid");
            return (Criteria) this;
        }

        public Criteria andKillidGreaterThanOrEqualTo(Integer value) {
            addCriterion("killid >=", value, "killid");
            return (Criteria) this;
        }

        public Criteria andKillidLessThan(Integer value) {
            addCriterion("killid <", value, "killid");
            return (Criteria) this;
        }

        public Criteria andKillidLessThanOrEqualTo(Integer value) {
            addCriterion("killid <=", value, "killid");
            return (Criteria) this;
        }

        public Criteria andKillidIn(List<Integer> values) {
            addCriterion("killid in", values, "killid");
            return (Criteria) this;
        }

        public Criteria andKillidNotIn(List<Integer> values) {
            addCriterion("killid not in", values, "killid");
            return (Criteria) this;
        }

        public Criteria andKillidBetween(Integer value1, Integer value2) {
            addCriterion("killid between", value1, value2, "killid");
            return (Criteria) this;
        }

        public Criteria andKillidNotBetween(Integer value1, Integer value2) {
            addCriterion("killid not between", value1, value2, "killid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Integer value) {
            addCriterion("goodsid =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Integer value) {
            addCriterion("goodsid <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Integer value) {
            addCriterion("goodsid >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsid >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Integer value) {
            addCriterion("goodsid <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("goodsid <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Integer> values) {
            addCriterion("goodsid in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Integer> values) {
            addCriterion("goodsid not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Integer value1, Integer value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andStockcountIsNull() {
            addCriterion("stockcount is null");
            return (Criteria) this;
        }

        public Criteria andStockcountIsNotNull() {
            addCriterion("stockcount is not null");
            return (Criteria) this;
        }

        public Criteria andStockcountEqualTo(Integer value) {
            addCriterion("stockcount =", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountNotEqualTo(Integer value) {
            addCriterion("stockcount <>", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountGreaterThan(Integer value) {
            addCriterion("stockcount >", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("stockcount >=", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountLessThan(Integer value) {
            addCriterion("stockcount <", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountLessThanOrEqualTo(Integer value) {
            addCriterion("stockcount <=", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountIn(List<Integer> values) {
            addCriterion("stockcount in", values, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountNotIn(List<Integer> values) {
            addCriterion("stockcount not in", values, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountBetween(Integer value1, Integer value2) {
            addCriterion("stockcount between", value1, value2, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountNotBetween(Integer value1, Integer value2) {
            addCriterion("stockcount not between", value1, value2, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNull() {
            addCriterion("startdate is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("startdate is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(Date value) {
            addCriterion("startdate =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(Date value) {
            addCriterion("startdate <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(Date value) {
            addCriterion("startdate >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("startdate >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(Date value) {
            addCriterion("startdate <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(Date value) {
            addCriterion("startdate <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<Date> values) {
            addCriterion("startdate in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<Date> values) {
            addCriterion("startdate not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(Date value1, Date value2) {
            addCriterion("startdate between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(Date value1, Date value2) {
            addCriterion("startdate not between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("enddate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("enddate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("enddate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("enddate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("enddate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("enddate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("enddate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("enddate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("enddate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("enddate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andKillpriceIsNull() {
            addCriterion("killprice is null");
            return (Criteria) this;
        }

        public Criteria andKillpriceIsNotNull() {
            addCriterion("killprice is not null");
            return (Criteria) this;
        }

        public Criteria andKillpriceEqualTo(Integer value) {
            addCriterion("killprice =", value, "killprice");
            return (Criteria) this;
        }

        public Criteria andKillpriceNotEqualTo(Integer value) {
            addCriterion("killprice <>", value, "killprice");
            return (Criteria) this;
        }

        public Criteria andKillpriceGreaterThan(Integer value) {
            addCriterion("killprice >", value, "killprice");
            return (Criteria) this;
        }

        public Criteria andKillpriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("killprice >=", value, "killprice");
            return (Criteria) this;
        }

        public Criteria andKillpriceLessThan(Integer value) {
            addCriterion("killprice <", value, "killprice");
            return (Criteria) this;
        }

        public Criteria andKillpriceLessThanOrEqualTo(Integer value) {
            addCriterion("killprice <=", value, "killprice");
            return (Criteria) this;
        }

        public Criteria andKillpriceIn(List<Integer> values) {
            addCriterion("killprice in", values, "killprice");
            return (Criteria) this;
        }

        public Criteria andKillpriceNotIn(List<Integer> values) {
            addCriterion("killprice not in", values, "killprice");
            return (Criteria) this;
        }

        public Criteria andKillpriceBetween(Integer value1, Integer value2) {
            addCriterion("killprice between", value1, value2, "killprice");
            return (Criteria) this;
        }

        public Criteria andKillpriceNotBetween(Integer value1, Integer value2) {
            addCriterion("killprice not between", value1, value2, "killprice");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}