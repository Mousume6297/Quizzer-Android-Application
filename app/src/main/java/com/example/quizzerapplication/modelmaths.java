package com.example.quizzerapplication;

public class modelmaths {

    String QuestionM;
    String oAM;
    String oBM;
    String oCM;
    String oDM;
    String ansM;

    public modelmaths() {

    }
    public modelmaths(String questionM, String oAM, String oBM, String oCM, String oDM, String ansM) {
        QuestionM = questionM;
        this.oAM = oAM;
        this.oBM = oBM;
        this.oCM = oCM;
        this.oDM = oDM;
        this.ansM = ansM;

    }
    public String getQuestionM() {
        return QuestionM;
    }
    public void setQuestionM(String questionM) {
        QuestionM = questionM;
    }

    public String getoAM() { return oAM; }
    public void setoAM(String oAM) {
        this.oAM = oAM;
    }

    public String getoBM() {
        return oBM;
    }
    public void setoBM(String oBM) {
        this.oBM = oBM;
    }

    public String getoCM() { return oCM; }
    public void setoCM(String oCM) { this.oCM = oCM; }


    public String getoDM() { return oDM; }
    public void setoDM(String oDM) {
        this.oDM = oDM;
    }

    public String getansM() {
        return ansM;
    }
    public void setansM(String ansM) {
        this.ansM = ansM;
    }



}
