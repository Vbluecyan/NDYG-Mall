package com.bluecyan.pojo;

import java.util.ArrayList;
import java.util.List;

public class HomeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HomeExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andHomeIdIsNull() {
            addCriterion("home_id is null");
            return (Criteria) this;
        }

        public Criteria andHomeIdIsNotNull() {
            addCriterion("home_id is not null");
            return (Criteria) this;
        }

        public Criteria andHomeIdEqualTo(Integer value) {
            addCriterion("home_id =", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotEqualTo(Integer value) {
            addCriterion("home_id <>", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdGreaterThan(Integer value) {
            addCriterion("home_id >", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("home_id >=", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdLessThan(Integer value) {
            addCriterion("home_id <", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdLessThanOrEqualTo(Integer value) {
            addCriterion("home_id <=", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdIn(List<Integer> values) {
            addCriterion("home_id in", values, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotIn(List<Integer> values) {
            addCriterion("home_id not in", values, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdBetween(Integer value1, Integer value2) {
            addCriterion("home_id between", value1, value2, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("home_id not between", value1, value2, "homeId");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftIsNull() {
            addCriterion("navigation_left is null");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftIsNotNull() {
            addCriterion("navigation_left is not null");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftEqualTo(String value) {
            addCriterion("navigation_left =", value, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftNotEqualTo(String value) {
            addCriterion("navigation_left <>", value, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftGreaterThan(String value) {
            addCriterion("navigation_left >", value, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftGreaterThanOrEqualTo(String value) {
            addCriterion("navigation_left >=", value, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftLessThan(String value) {
            addCriterion("navigation_left <", value, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftLessThanOrEqualTo(String value) {
            addCriterion("navigation_left <=", value, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftLike(String value) {
            addCriterion("navigation_left like", value, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftNotLike(String value) {
            addCriterion("navigation_left not like", value, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftIn(List<String> values) {
            addCriterion("navigation_left in", values, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftNotIn(List<String> values) {
            addCriterion("navigation_left not in", values, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftBetween(String value1, String value2) {
            addCriterion("navigation_left between", value1, value2, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationLeftNotBetween(String value1, String value2) {
            addCriterion("navigation_left not between", value1, value2, "navigationLeft");
            return (Criteria) this;
        }

        public Criteria andNavigationBarIsNull() {
            addCriterion("navigation_bar is null");
            return (Criteria) this;
        }

        public Criteria andNavigationBarIsNotNull() {
            addCriterion("navigation_bar is not null");
            return (Criteria) this;
        }

        public Criteria andNavigationBarEqualTo(String value) {
            addCriterion("navigation_bar =", value, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andNavigationBarNotEqualTo(String value) {
            addCriterion("navigation_bar <>", value, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andNavigationBarGreaterThan(String value) {
            addCriterion("navigation_bar >", value, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andNavigationBarGreaterThanOrEqualTo(String value) {
            addCriterion("navigation_bar >=", value, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andNavigationBarLessThan(String value) {
            addCriterion("navigation_bar <", value, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andNavigationBarLessThanOrEqualTo(String value) {
            addCriterion("navigation_bar <=", value, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andNavigationBarLike(String value) {
            addCriterion("navigation_bar like", value, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andNavigationBarNotLike(String value) {
            addCriterion("navigation_bar not like", value, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andNavigationBarIn(List<String> values) {
            addCriterion("navigation_bar in", values, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andNavigationBarNotIn(List<String> values) {
            addCriterion("navigation_bar not in", values, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andNavigationBarBetween(String value1, String value2) {
            addCriterion("navigation_bar between", value1, value2, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andNavigationBarNotBetween(String value1, String value2) {
            addCriterion("navigation_bar not between", value1, value2, "navigationBar");
            return (Criteria) this;
        }

        public Criteria andSideshowIsNull() {
            addCriterion("sideshow is null");
            return (Criteria) this;
        }

        public Criteria andSideshowIsNotNull() {
            addCriterion("sideshow is not null");
            return (Criteria) this;
        }

        public Criteria andSideshowEqualTo(String value) {
            addCriterion("sideshow =", value, "sideshow");
            return (Criteria) this;
        }

        public Criteria andSideshowNotEqualTo(String value) {
            addCriterion("sideshow <>", value, "sideshow");
            return (Criteria) this;
        }

        public Criteria andSideshowGreaterThan(String value) {
            addCriterion("sideshow >", value, "sideshow");
            return (Criteria) this;
        }

        public Criteria andSideshowGreaterThanOrEqualTo(String value) {
            addCriterion("sideshow >=", value, "sideshow");
            return (Criteria) this;
        }

        public Criteria andSideshowLessThan(String value) {
            addCriterion("sideshow <", value, "sideshow");
            return (Criteria) this;
        }

        public Criteria andSideshowLessThanOrEqualTo(String value) {
            addCriterion("sideshow <=", value, "sideshow");
            return (Criteria) this;
        }

        public Criteria andSideshowLike(String value) {
            addCriterion("sideshow like", value, "sideshow");
            return (Criteria) this;
        }

        public Criteria andSideshowNotLike(String value) {
            addCriterion("sideshow not like", value, "sideshow");
            return (Criteria) this;
        }

        public Criteria andSideshowIn(List<String> values) {
            addCriterion("sideshow in", values, "sideshow");
            return (Criteria) this;
        }

        public Criteria andSideshowNotIn(List<String> values) {
            addCriterion("sideshow not in", values, "sideshow");
            return (Criteria) this;
        }

        public Criteria andSideshowBetween(String value1, String value2) {
            addCriterion("sideshow between", value1, value2, "sideshow");
            return (Criteria) this;
        }

        public Criteria andSideshowNotBetween(String value1, String value2) {
            addCriterion("sideshow not between", value1, value2, "sideshow");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNull() {
            addCriterion("recommend is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNotNull() {
            addCriterion("recommend is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendEqualTo(String value) {
            addCriterion("recommend =", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotEqualTo(String value) {
            addCriterion("recommend <>", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThan(String value) {
            addCriterion("recommend >", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(String value) {
            addCriterion("recommend >=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThan(String value) {
            addCriterion("recommend <", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThanOrEqualTo(String value) {
            addCriterion("recommend <=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLike(String value) {
            addCriterion("recommend like", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotLike(String value) {
            addCriterion("recommend not like", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendIn(List<String> values) {
            addCriterion("recommend in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotIn(List<String> values) {
            addCriterion("recommend not in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendBetween(String value1, String value2) {
            addCriterion("recommend between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotBetween(String value1, String value2) {
            addCriterion("recommend not between", value1, value2, "recommend");
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