package com.example.quizzerapplication;

public class modelsports {

    String QuestionS;
    String oAS;
    String oBS;
    String oCS;
    String oDS;
    String ansS;

    public modelsports() {

    }
    public modelsports(String questionS, String oAS, String oBS, String oCS, String oDS, String ansS) {
        QuestionS = questionS;
        this.oAS = oAS;
        this.oBS = oBS;
        this.oCS = oCS;
        this.oDS = oDS;
        this.ansS = ansS;

    }
    public String getQuestionS() {
        return QuestionS;
    }
    public void setQuestionS(String questionS) {
        QuestionS = questionS;
    }

    public String getoAS() {
        return oAS;
    }
    public void setoAS(String oAS) {
        this.oAS = oAS;
    }

    public String getoBS() {
        return oBS;
    }
    public void setoBS(String oBS) {
        this.oBS = oBS;
    }

    public String getoCS()
    {
        return oCS;
    }
    public void setoCS(String oCS) {this.oCS = oCS;}


    public String getoDS() {
        return oDS;
    }
    public void setoDS(String oDS) {
        this.oDS = oDS;
    }

    public String getansS() {
        return ansS;
    }
    public void setansS(String ansS) {
        this.ansS = ansS;
    }



}
