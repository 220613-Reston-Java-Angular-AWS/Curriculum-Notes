package com.models;

import java.sql.Date;

public class Ticket {
        Integer requestID;
//        Date startDate;
//        Date endDate;
        String description;
//        Boolean approved;
       Integer userID;
//        Integer principalID;

        public Ticket() {
        }

        public Ticket(String description,Integer userID) {
//            this.startDate = startDate;
//            this.endDate = endDate;
            this.description = description;
//            this.approved = approved;
            this.userID = userID;
//            this.principalID = principalID;
        }

    public Ticket(Integer requestID,String description,Integer userID) {
//            this.startDate = startDate;
//            this.endDate = endDate;
        this.requestID = requestID;
        this.description = description;
//            this.approved = approved;
        this.userID = userID;
//            this.principalID = principalID;
    }




        public Ticket(Date startDate, Date endDate, String description, Boolean approved) {
//            this.startDate = startDate;
//            this.endDate = endDate;
            this.description = description;
//            this.approved = approved;
        }

        public Ticket(Integer requestID, Date startDate, Date endDate, String description,
                       Boolean approved, Integer teacherID, Integer principalID) {
            this.requestID = requestID;
//            this.startDate = startDate;
//            this.endDate = endDate;
            this.description = description;
//            this.approved = approved;
//            this.teacherID = teacherID;
//            this.principalID = principalID;
        }

//        public Date getStartDate() {
//            return startDate;
//        }
//
//        public void setStartDate(Date startDate) {
//            this.startDate = startDate;
//        }
//
//        public Date getEndDate() {
//            return endDate;
//        }
//
//        public void setEndDate(Date endDate) {
//            this.endDate = endDate;
//        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

//        public Boolean getApproved() {
//            return approved;
//        }
//
//        public void setApproved(Boolean approved) {
//            this.approved = approved;
//        }

        public Integer getRequestID() {
            return requestID;
        }

        public void setRequestID(Integer requestID) {
            this.requestID = requestID;
        }

//        public Integer getTeacherID() {
//            return teacherID;
//        }

//        public void setTeacherID(Integer teacherID) {
//            this.teacherID = teacherID;
//        }
//
//        public Integer getPrincipalID() {
//            return principalID;
//        }
//
//        public void setPrincipalID(Integer principalID) {
//            this.principalID = principalID;
//        }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}

