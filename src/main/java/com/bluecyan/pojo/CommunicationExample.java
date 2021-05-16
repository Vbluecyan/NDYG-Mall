package com.bluecyan.pojo;

import java.util.ArrayList;
import java.util.List;

public class CommunicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunicationExample() {
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

        public Criteria andCommunicationIdIsNull() {
            addCriterion("communication_id is null");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdIsNotNull() {
            addCriterion("communication_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdEqualTo(String value) {
            addCriterion("communication_id =", value, "communicationId");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdNotEqualTo(String value) {
            addCriterion("communication_id <>", value, "communicationId");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdGreaterThan(String value) {
            addCriterion("communication_id >", value, "communicationId");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdGreaterThanOrEqualTo(String value) {
            addCriterion("communication_id >=", value, "communicationId");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdLessThan(String value) {
            addCriterion("communication_id <", value, "communicationId");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdLessThanOrEqualTo(String value) {
            addCriterion("communication_id <=", value, "communicationId");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdLike(String value) {
            addCriterion("communication_id like", value, "communicationId");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdNotLike(String value) {
            addCriterion("communication_id not like", value, "communicationId");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdIn(List<String> values) {
            addCriterion("communication_id in", values, "communicationId");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdNotIn(List<String> values) {
            addCriterion("communication_id not in", values, "communicationId");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdBetween(String value1, String value2) {
            addCriterion("communication_id between", value1, value2, "communicationId");
            return (Criteria) this;
        }

        public Criteria andCommunicationIdNotBetween(String value1, String value2) {
            addCriterion("communication_id not between", value1, value2, "communicationId");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNull() {
            addCriterion("send_id is null");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNotNull() {
            addCriterion("send_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendIdEqualTo(String value) {
            addCriterion("send_id =", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotEqualTo(String value) {
            addCriterion("send_id <>", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThan(String value) {
            addCriterion("send_id >", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThanOrEqualTo(String value) {
            addCriterion("send_id >=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThan(String value) {
            addCriterion("send_id <", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThanOrEqualTo(String value) {
            addCriterion("send_id <=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLike(String value) {
            addCriterion("send_id like", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotLike(String value) {
            addCriterion("send_id not like", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdIn(List<String> values) {
            addCriterion("send_id in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotIn(List<String> values) {
            addCriterion("send_id not in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdBetween(String value1, String value2) {
            addCriterion("send_id between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotBetween(String value1, String value2) {
            addCriterion("send_id not between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdIsNull() {
            addCriterion("reception_id is null");
            return (Criteria) this;
        }

        public Criteria andReceptionIdIsNotNull() {
            addCriterion("reception_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceptionIdEqualTo(String value) {
            addCriterion("reception_id =", value, "receptionId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdNotEqualTo(String value) {
            addCriterion("reception_id <>", value, "receptionId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdGreaterThan(String value) {
            addCriterion("reception_id >", value, "receptionId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdGreaterThanOrEqualTo(String value) {
            addCriterion("reception_id >=", value, "receptionId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdLessThan(String value) {
            addCriterion("reception_id <", value, "receptionId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdLessThanOrEqualTo(String value) {
            addCriterion("reception_id <=", value, "receptionId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdLike(String value) {
            addCriterion("reception_id like", value, "receptionId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdNotLike(String value) {
            addCriterion("reception_id not like", value, "receptionId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdIn(List<String> values) {
            addCriterion("reception_id in", values, "receptionId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdNotIn(List<String> values) {
            addCriterion("reception_id not in", values, "receptionId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdBetween(String value1, String value2) {
            addCriterion("reception_id between", value1, value2, "receptionId");
            return (Criteria) this;
        }

        public Criteria andReceptionIdNotBetween(String value1, String value2) {
            addCriterion("reception_id not between", value1, value2, "receptionId");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(Byte value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(Byte value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(Byte value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(Byte value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(Byte value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(Byte value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<Byte> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<Byte> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(Byte value1, Byte value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(Byte value1, Byte value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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