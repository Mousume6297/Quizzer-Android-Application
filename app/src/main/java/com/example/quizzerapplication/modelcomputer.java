package com.example.quizzerapplication;

public class modelcomputer {

    String QuestionCB;
    String oACB;
    String oBCB;
    String oCCB;
    String oDCB;
    String ansCB;

    public modelcomputer() {

    }
    public modelcomputer(String questionCB, String oACB, String oBCB, String oCCB, String oDCB, String ansCB) {
        QuestionCB = questionCB;
        this.oACB = oACB;
        this.oBCB = oBCB;
        this.oCCB = oCCB;
        this.oDCB = oDCB;
        this.ansCB = ansCB;

    }
    public String getQuestionCB() {
        return QuestionCB;
    }
    public void setQuestionCB(String questionCB) {
        QuestionCB = questionCB;
    }

    public String getoACB() {
        return oACB;
    }
    public void setoACB(String oACB) {
        this.oACB = oACB;
    }

    public String getoBCB() {
        return oBCB;
    }
    public void setoBCB(String oBCB) {
        this.oBCB = oBCB;
    }

    public String getoCCB()
    {
        return oCCB;
    }
    public void setoCCB(String oCCB) {
        this.oCCB = oCCB;
    }


    public String getoDCB() {
        return oDCB;
    }
    public void setoDCB(String oDCB) {
        this.oDCB = oDCB;
    }

    public String getansCB() {
        return ansCB;
    }
    public void setansCB(String ansCB) {
        this.ansCB = ansCB;
    }



}
