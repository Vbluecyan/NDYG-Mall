package com.bluecyan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserRentOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserRentOrderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserRentOrderIdIsNull() {
            addCriterion("user_rent_order_id is null");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdIsNotNull() {
            addCriterion("user_rent_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdEqualTo(String value) {
            addCriterion("user_rent_order_id =", value, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdNotEqualTo(String value) {
            addCriterion("user_rent_order_id <>", value, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdGreaterThan(String value) {
            addCriterion("user_rent_order_id >", value, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_rent_order_id >=", value, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdLessThan(String value) {
            addCriterion("user_rent_order_id <", value, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdLessThanOrEqualTo(String value) {
            addCriterion("user_rent_order_id <=", value, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdLike(String value) {
            addCriterion("user_rent_order_id like", value, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdNotLike(String value) {
            addCriterion("user_rent_order_id not like", value, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdIn(List<String> values) {
            addCriterion("user_rent_order_id in", values, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdNotIn(List<String> values) {
            addCriterion("user_rent_order_id not in", values, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdBetween(String value1, String value2) {
            addCriterion("user_rent_order_id between", value1, value2, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserRentOrderIdNotBetween(String value1, String value2) {
            addCriterion("user_rent_order_id not between", value1, value2, "userRentOrderId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andClothingIdIsNull() {
            addCriterion("clothing_id is null");
            return (Criteria) this;
        }

        public Criteria andClothingIdIsNotNull() {
            addCriterion("clothing_id is not null");
            return (Criteria) this;
        }

        public Criteria andClothingIdEqualTo(String value) {
            addCriterion("clothing_id =", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdNotEqualTo(String value) {
            addCriterion("clothing_id <>", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdGreaterThan(String value) {
            addCriterion("clothing_id >", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdGreaterThanOrEqualTo(String value) {
            addCriterion("clothing_id >=", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdLessThan(String value) {
            addCriterion("clothing_id <", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdLessThanOrEqualTo(String value) {
            addCriterion("clothing_id <=", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdLike(String value) {
            addCriterion("clothing_id like", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdNotLike(String value) {
            addCriterion("clothing_id not like", value, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdIn(List<String> values) {
            addCriterion("clothing_id in", values, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdNotIn(List<String> values) {
            addCriterion("clothing_id not in", values, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdBetween(String value1, String value2) {
            addCriterion("clothing_id between", value1, value2, "clothingId");
            return (Criteria) this;
        }

        public Criteria andClothingIdNotBetween(String value1, String value2) {
            addCriterion("clothing_id not between", value1, value2, "clothingId");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIsNull() {
            addCriterion("shipping_address is null");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIsNotNull() {
            addCriterion("shipping_address is not null");
            return (Criteria) this;
        }

        public Criteria andShippingAddressEqualTo(String value) {
            addCriterion("shipping_address =", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotEqualTo(String value) {
            addCriterion("shipping_address <>", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressGreaterThan(String value) {
            addCriterion("shipping_address >", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_address >=", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLessThan(String value) {
            addCriterion("shipping_address <", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLessThanOrEqualTo(String value) {
            addCriterion("shipping_address <=", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLike(String value) {
            addCriterion("shipping_address like", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotLike(String value) {
            addCriterion("shipping_address not like", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIn(List<String> values) {
            addCriterion("shipping_address in", values, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotIn(List<String> values) {
            addCriterion("shipping_address not in", values, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressBetween(String value1, String value2) {
            addCriterion("shipping_address between", value1, value2, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotBetween(String value1, String value2) {
            addCriterion("shipping_address not between", value1, value2, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Integer value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Integer value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Integer value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Integer value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Integer> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Integer> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Integer value1, Integer value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeIsNull() {
            addCriterion("creation_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeIsNotNull() {
            addCriterion("creation_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeEqualTo(Date value) {
            addCriterion("creation_datetime =", value, "creationDatetime");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeNotEqualTo(Date value) {
            addCriterion("creation_datetime <>", value, "creationDatetime");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeGreaterThan(Date value) {
            addCriterion("creation_datetime >", value, "creationDatetime");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_datetime >=", value, "creationDatetime");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeLessThan(Date value) {
            addCriterion("creation_datetime <", value, "creationDatetime");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("creation_datetime <=", value, "creationDatetime");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeIn(List<Date> values) {
            addCriterion("creation_datetime in", values, "creationDatetime");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeNotIn(List<Date> values) {
            addCriterion("creation_datetime not in", values, "creationDatetime");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeBetween(Date value1, Date value2) {
            addCriterion("creation_datetime between", value1, value2, "creationDatetime");
            return (Criteria) this;
        }

        public Criteria andCreationDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("creation_datetime not between", value1, value2, "creationDatetime");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeIsNull() {
            addCriterion("finish_datetime is null");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeIsNotNull() {
            addCriterion("finish_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeEqualTo(Date value) {
            addCriterion("finish_datetime =", value, "finishDatetime");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeNotEqualTo(Date value) {
            addCriterion("finish_datetime <>", value, "finishDatetime");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeGreaterThan(Date value) {
            addCriterion("finish_datetime >", value, "finishDatetime");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_datetime >=", value, "finishDatetime");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeLessThan(Date value) {
            addCriterion("finish_datetime <", value, "finishDatetime");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_datetime <=", value, "finishDatetime");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeIn(List<Date> values) {
            addCriterion("finish_datetime in", values, "finishDatetime");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeNotIn(List<Date> values) {
            addCriterion("finish_datetime not in", values, "finishDatetime");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeBetween(Date value1, Date value2) {
            addCriterion("finish_datetime between", value1, value2, "finishDatetime");
            return (Criteria) this;
        }

        public Criteria andFinishDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_datetime not between", value1, value2, "finishDatetime");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateIsNull() {
            addCriterion("expectant_return_date is null");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateIsNotNull() {
            addCriterion("expectant_return_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateEqualTo(Date value) {
            addCriterionForJDBCDate("expectant_return_date =", value, "expectantReturnDate");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("expectant_return_date <>", value, "expectantReturnDate");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateGreaterThan(Date value) {
            addCriterionForJDBCDate("expectant_return_date >", value, "expectantReturnDate");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expectant_return_date >=", value, "expectantReturnDate");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateLessThan(Date value) {
            addCriterionForJDBCDate("expectant_return_date <", value, "expectantReturnDate");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expectant_return_date <=", value, "expectantReturnDate");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateIn(List<Date> values) {
            addCriterionForJDBCDate("expectant_return_date in", values, "expectantReturnDate");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("expectant_return_date not in", values, "expectantReturnDate");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expectant_return_date between", value1, value2, "expectantReturnDate");
            return (Criteria) this;
        }

        public Criteria andExpectantReturnDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expectant_return_date not between", value1, value2, "expectantReturnDate");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateIsNull() {
            addCriterion("actual_return_date is null");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateIsNotNull() {
            addCriterion("actual_return_date is not null");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateEqualTo(Date value) {
            addCriterionForJDBCDate("actual_return_date =", value, "actualReturnDate");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("actual_return_date <>", value, "actualReturnDate");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateGreaterThan(Date value) {
            addCriterionForJDBCDate("actual_return_date >", value, "actualReturnDate");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_return_date >=", value, "actualReturnDate");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateLessThan(Date value) {
            addCriterionForJDBCDate("actual_return_date <", value, "actualReturnDate");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("actual_return_date <=", value, "actualReturnDate");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateIn(List<Date> values) {
            addCriterionForJDBCDate("actual_return_date in", values, "actualReturnDate");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("actual_return_date not in", values, "actualReturnDate");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_return_date between", value1, value2, "actualReturnDate");
            return (Criteria) this;
        }

        public Criteria andActualReturnDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("actual_return_date not between", value1, value2, "actualReturnDate");
            return (Criteria) this;
        }

        public Criteria andPassIsNull() {
            addCriterion("pass is null");
            return (Criteria) this;
        }

        public Criteria andPassIsNotNull() {
            addCriterion("pass is not null");
            return (Criteria) this;
        }

        public Criteria andPassEqualTo(Byte value) {
            addCriterion("pass =", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassNotEqualTo(Byte value) {
            addCriterion("pass <>", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassGreaterThan(Byte value) {
            addCriterion("pass >", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassGreaterThanOrEqualTo(Byte value) {
            addCriterion("pass >=", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassLessThan(Byte value) {
            addCriterion("pass <", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassLessThanOrEqualTo(Byte value) {
            addCriterion("pass <=", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassIn(List<Byte> values) {
            addCriterion("pass in", values, "pass");
            return (Criteria) this;
        }

        public Criteria andPassNotIn(List<Byte> values) {
            addCriterion("pass not in", values, "pass");
            return (Criteria) this;
        }

        public Criteria andPassBetween(Byte value1, Byte value2) {
            addCriterion("pass between", value1, value2, "pass");
            return (Criteria) this;
        }

        public Criteria andPassNotBetween(Byte value1, Byte value2) {
            addCriterion("pass not between", value1, value2, "pass");
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