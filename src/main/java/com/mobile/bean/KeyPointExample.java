package com.mobile.bean;

import java.util.ArrayList;
import java.util.List;

public class KeyPointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KeyPointExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andXIsNull() {
            addCriterion("x is null");
            return (Criteria) this;
        }

        public Criteria andXIsNotNull() {
            addCriterion("x is not null");
            return (Criteria) this;
        }

        public Criteria andXEqualTo(String value) {
            addCriterion("x =", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotEqualTo(String value) {
            addCriterion("x <>", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThan(String value) {
            addCriterion("x >", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThanOrEqualTo(String value) {
            addCriterion("x >=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThan(String value) {
            addCriterion("x <", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThanOrEqualTo(String value) {
            addCriterion("x <=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLike(String value) {
            addCriterion("x like", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotLike(String value) {
            addCriterion("x not like", value, "x");
            return (Criteria) this;
        }

        public Criteria andXIn(List<String> values) {
            addCriterion("x in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXNotIn(List<String> values) {
            addCriterion("x not in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXBetween(String value1, String value2) {
            addCriterion("x between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andXNotBetween(String value1, String value2) {
            addCriterion("x not between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andYIsNull() {
            addCriterion("y is null");
            return (Criteria) this;
        }

        public Criteria andYIsNotNull() {
            addCriterion("y is not null");
            return (Criteria) this;
        }

        public Criteria andYEqualTo(String value) {
            addCriterion("y =", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotEqualTo(String value) {
            addCriterion("y <>", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThan(String value) {
            addCriterion("y >", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThanOrEqualTo(String value) {
            addCriterion("y >=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThan(String value) {
            addCriterion("y <", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThanOrEqualTo(String value) {
            addCriterion("y <=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLike(String value) {
            addCriterion("y like", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotLike(String value) {
            addCriterion("y not like", value, "y");
            return (Criteria) this;
        }

        public Criteria andYIn(List<String> values) {
            addCriterion("y in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYNotIn(List<String> values) {
            addCriterion("y not in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYBetween(String value1, String value2) {
            addCriterion("y between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andYNotBetween(String value1, String value2) {
            addCriterion("y not between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andZIsNull() {
            addCriterion("z is null");
            return (Criteria) this;
        }

        public Criteria andZIsNotNull() {
            addCriterion("z is not null");
            return (Criteria) this;
        }

        public Criteria andZEqualTo(String value) {
            addCriterion("z =", value, "z");
            return (Criteria) this;
        }

        public Criteria andZNotEqualTo(String value) {
            addCriterion("z <>", value, "z");
            return (Criteria) this;
        }

        public Criteria andZGreaterThan(String value) {
            addCriterion("z >", value, "z");
            return (Criteria) this;
        }

        public Criteria andZGreaterThanOrEqualTo(String value) {
            addCriterion("z >=", value, "z");
            return (Criteria) this;
        }

        public Criteria andZLessThan(String value) {
            addCriterion("z <", value, "z");
            return (Criteria) this;
        }

        public Criteria andZLessThanOrEqualTo(String value) {
            addCriterion("z <=", value, "z");
            return (Criteria) this;
        }

        public Criteria andZLike(String value) {
            addCriterion("z like", value, "z");
            return (Criteria) this;
        }

        public Criteria andZNotLike(String value) {
            addCriterion("z not like", value, "z");
            return (Criteria) this;
        }

        public Criteria andZIn(List<String> values) {
            addCriterion("z in", values, "z");
            return (Criteria) this;
        }

        public Criteria andZNotIn(List<String> values) {
            addCriterion("z not in", values, "z");
            return (Criteria) this;
        }

        public Criteria andZBetween(String value1, String value2) {
            addCriterion("z between", value1, value2, "z");
            return (Criteria) this;
        }

        public Criteria andZNotBetween(String value1, String value2) {
            addCriterion("z not between", value1, value2, "z");
            return (Criteria) this;
        }

        public Criteria andPtypeIsNull() {
            addCriterion("ptype is null");
            return (Criteria) this;
        }

        public Criteria andPtypeIsNotNull() {
            addCriterion("ptype is not null");
            return (Criteria) this;
        }

        public Criteria andPtypeEqualTo(Integer value) {
            addCriterion("ptype =", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeNotEqualTo(Integer value) {
            addCriterion("ptype <>", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeGreaterThan(Integer value) {
            addCriterion("ptype >", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ptype >=", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeLessThan(Integer value) {
            addCriterion("ptype <", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeLessThanOrEqualTo(Integer value) {
            addCriterion("ptype <=", value, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeIn(List<Integer> values) {
            addCriterion("ptype in", values, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeNotIn(List<Integer> values) {
            addCriterion("ptype not in", values, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeBetween(Integer value1, Integer value2) {
            addCriterion("ptype between", value1, value2, "ptype");
            return (Criteria) this;
        }

        public Criteria andPtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ptype not between", value1, value2, "ptype");
            return (Criteria) this;
        }

        public Criteria andPbuildingIsNull() {
            addCriterion("pbuilding is null");
            return (Criteria) this;
        }

        public Criteria andPbuildingIsNotNull() {
            addCriterion("pbuilding is not null");
            return (Criteria) this;
        }

        public Criteria andPbuildingEqualTo(Integer value) {
            addCriterion("pbuilding =", value, "pbuilding");
            return (Criteria) this;
        }

        public Criteria andPbuildingNotEqualTo(Integer value) {
            addCriterion("pbuilding <>", value, "pbuilding");
            return (Criteria) this;
        }

        public Criteria andPbuildingGreaterThan(Integer value) {
            addCriterion("pbuilding >", value, "pbuilding");
            return (Criteria) this;
        }

        public Criteria andPbuildingGreaterThanOrEqualTo(Integer value) {
            addCriterion("pbuilding >=", value, "pbuilding");
            return (Criteria) this;
        }

        public Criteria andPbuildingLessThan(Integer value) {
            addCriterion("pbuilding <", value, "pbuilding");
            return (Criteria) this;
        }

        public Criteria andPbuildingLessThanOrEqualTo(Integer value) {
            addCriterion("pbuilding <=", value, "pbuilding");
            return (Criteria) this;
        }

        public Criteria andPbuildingIn(List<Integer> values) {
            addCriterion("pbuilding in", values, "pbuilding");
            return (Criteria) this;
        }

        public Criteria andPbuildingNotIn(List<Integer> values) {
            addCriterion("pbuilding not in", values, "pbuilding");
            return (Criteria) this;
        }

        public Criteria andPbuildingBetween(Integer value1, Integer value2) {
            addCriterion("pbuilding between", value1, value2, "pbuilding");
            return (Criteria) this;
        }

        public Criteria andPbuildingNotBetween(Integer value1, Integer value2) {
            addCriterion("pbuilding not between", value1, value2, "pbuilding");
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