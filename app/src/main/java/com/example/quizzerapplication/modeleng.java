package com.example.quizzerapplication;

public class modeleng {

    String QuestionE;
    String oAE;
    String oBE;
    String oCE;
    String oDE;
    String ansE;

    public modeleng() {

    }
    public modeleng(String questionE, String oAE, String oBE, String oCE, String oDE, String ansE) {
        QuestionE = questionE;
        this.oAE = oAE;
        this.oBE = oBE;
        this.oCE = oCE;
        this.oDE = oDE;
        this.ansE = ansE;

    }
    public String getQuestionE() {
        return QuestionE;
    }
    public void setQuestionE(String questionE) {
        QuestionE = questionE;
    }

    public String getoAE() {
        return oAE;
    }
    public void setoAE(String oAE) {
        this.oAE = oAE;
    }

    public String getoBE() {
        return oBE;
    }
    public void setoBE(String oBE) {
        this.oBE = oBE;
    }

    public String getoCE()
    {
        return oCE;
    }
    public void setoCE(String oCE) {this.oCE = oCE;}


    public String getoDE() {
        return oDE;
    }
    public void setoDE(String oDE) {
        this.oDE = oDE;
    }

    public String getansE() {
        return ansE;
    }
    public void setansE(String ansE) {
        this.ansE = ansE;
    }



}
