package com.app.modou.ui.bean;

import java.io.Serializable;

/**
 * author：chenzl
 * Create time: 2017/12/22 0022 10:25
 * describe:
 * 用户信息类
 * e_mail：chenzhiliang@guangxirenrenparking.com
 */
public class UserInfoBean implements Serializable {


    /**
     * memberInfo : {"phone":"13326419827","payFailAmount":0,"remark":null,"subAccCmb":null,"memberType":3,"identityCardNo":"gk7OWW0u5f8cNxnTRCK/DowXpR6ZnOLAtjxDQ2B62fX9bwNqbS6dXD5R6fkQ3VQSHb5urfY9rX4/RQoNcNYolNPTfiSQCWo2NmN0a/rLzVmzFwjCWSfJAMAdpe4oEk0rXjFviaoN9enQ7WCPusPS2OUyC+YSX9MHI8EIpmOVXy4=","registerTime":"2019-02-13 10:37:37","country":null,"registerIp":null,"userState":1,"isIdentityChecked":true,"realNameTime":"2019-02-13 17:41:09","area":null,"source":null,"address":null,"isPhoneChecked":true,"userId":"f8567f04-2ead-4c5b-b414-8dabab0a0151","name":"韦超才","province":null,"isSetPayPwd":false,"bizUserId":"user","isSignContract":false}
     * memberType : 3
     * bizUserId : user
     */

    private MemberInfoBean memberInfo;
    private int memberType;
    private String bizUserId;

    public MemberInfoBean getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfoBean memberInfo) {
        this.memberInfo = memberInfo;
    }

    public int getMemberType() {
        return memberType;
    }

    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }

    public String getBizUserId() {
        return bizUserId;
    }

    public void setBizUserId(String bizUserId) {
        this.bizUserId = bizUserId;
    }

    public static class MemberInfoBean implements Serializable{
        /**
         * phone : 13326419827
         * payFailAmount : 0
         * remark : null
         * subAccCmb : null
         * memberType : 3
         * identityCardNo : gk7OWW0u5f8cNxnTRCK/DowXpR6ZnOLAtjxDQ2B62fX9bwNqbS6dXD5R6fkQ3VQSHb5urfY9rX4/RQoNcNYolNPTfiSQCWo2NmN0a/rLzVmzFwjCWSfJAMAdpe4oEk0rXjFviaoN9enQ7WCPusPS2OUyC+YSX9MHI8EIpmOVXy4=
         * registerTime : 2019-02-13 10:37:37
         * country : null
         * registerIp : null
         * userState : 1
         * isIdentityChecked : true
         * realNameTime : 2019-02-13 17:41:09
         * area : null
         * source : null
         * address : null
         * isPhoneChecked : true
         * userId : f8567f04-2ead-4c5b-b414-8dabab0a0151
         * name : 韦超才
         * province : null
         * isSetPayPwd : false
         * bizUserId : user
         * isSignContract : false
         */

        private String phone;
        private int payFailAmount;
        private Object remark;
        private Object subAccCmb;
        private int memberType;
        private String identityCardNo;
        private String registerTime;
        private Object country;
        private Object registerIp;
        private int userState;
        private boolean isIdentityChecked;
        private String realNameTime;
        private Object area;
        private Object source;
        private Object address;
        private boolean isPhoneChecked;
        private String userId;
        private String name;
        private Object province;
        private boolean isSetPayPwd;
        private String bizUserId;
        private boolean isSignContract;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getPayFailAmount() {
            return payFailAmount;
        }

        public void setPayFailAmount(int payFailAmount) {
            this.payFailAmount = payFailAmount;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getSubAccCmb() {
            return subAccCmb;
        }

        public void setSubAccCmb(Object subAccCmb) {
            this.subAccCmb = subAccCmb;
        }

        public int getMemberType() {
            return memberType;
        }

        public void setMemberType(int memberType) {
            this.memberType = memberType;
        }

        public String getIdentityCardNo() {
            return identityCardNo;
        }

        public void setIdentityCardNo(String identityCardNo) {
            this.identityCardNo = identityCardNo;
        }

        public String getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(String registerTime) {
            this.registerTime = registerTime;
        }

        public Object getCountry() {
            return country;
        }

        public void setCountry(Object country) {
            this.country = country;
        }

        public Object getRegisterIp() {
            return registerIp;
        }

        public void setRegisterIp(Object registerIp) {
            this.registerIp = registerIp;
        }

        public int getUserState() {
            return userState;
        }

        public void setUserState(int userState) {
            this.userState = userState;
        }

        public boolean isIsIdentityChecked() {
            return isIdentityChecked;
        }

        public void setIsIdentityChecked(boolean isIdentityChecked) {
            this.isIdentityChecked = isIdentityChecked;
        }

        public String getRealNameTime() {
            return realNameTime;
        }

        public void setRealNameTime(String realNameTime) {
            this.realNameTime = realNameTime;
        }

        public Object getArea() {
            return area;
        }

        public void setArea(Object area) {
            this.area = area;
        }

        public Object getSource() {
            return source;
        }

        public void setSource(Object source) {
            this.source = source;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public boolean isIsPhoneChecked() {
            return isPhoneChecked;
        }

        public void setIsPhoneChecked(boolean isPhoneChecked) {
            this.isPhoneChecked = isPhoneChecked;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public boolean isIsSetPayPwd() {
            return isSetPayPwd;
        }

        public void setIsSetPayPwd(boolean isSetPayPwd) {
            this.isSetPayPwd = isSetPayPwd;
        }

        public String getBizUserId() {
            return bizUserId;
        }

        public void setBizUserId(String bizUserId) {
            this.bizUserId = bizUserId;
        }

        public boolean isIsSignContract() {
            return isSignContract;
        }

        public void setIsSignContract(boolean isSignContract) {
            this.isSignContract = isSignContract;
        }
    }
}
