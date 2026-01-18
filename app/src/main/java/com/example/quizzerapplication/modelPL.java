package com.example.quizzerapplication;

public class modelPL {

    String QuestionPL;
    String oAPL;
    String oBPL;
    String oCPL;
    String oDPL;
    String ansPL;

    public modelPL() {

    }
    public modelPL(String questionPL, String oAPL, String oBPL, String oCPL, String oDPL, String ansPL) {
        QuestionPL = questionPL;
        this.oAPL = oAPL;
        this.oBPL = oBPL;
        this.oCPL = oCPL;
        this.oDPL = oDPL;
        this.ansPL = ansPL;

    }
    public String getQuestionPL() {
        return QuestionPL;
    }
    public void setQuestionPL(String questionPL) {
        QuestionPL = questionPL;
    }

    public String getoAPL() {
        return oAPL;
    }
    public void setoAPL(String oAPL) {
        this.oAPL = oAPL;
    }

    public String getoBPL() {
        return oBPL;
    }
    public void setoBPL(String oBPL) {
        this.oBPL = oBPL;
    }

    public String getoCPL()
    {
        return oCPL;
    }
    public void setoCPL(String oCPL) {this.oCPL = oCPL;}


    public String getoDPL() {
        return oDPL;
    }
    public void setoDPL(String oDPL) {
        this.oDPL = oDPL;
    }

    public String getansPL() {
        return ansPL;
    }
    public void setansPL(String ansPL) {
        this.ansPL = ansPL;
    }



}
