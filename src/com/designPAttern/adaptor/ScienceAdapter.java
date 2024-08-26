package com.designPAttern.adaptor;

public class ScienceAdapter implements Science{
    AdvancedScience advancedScience;
    ScienceAdapter(AdvancedScience advancedScience){
        this.advancedScience=advancedScience;
    }

    @Override
    public void newtonsThirdLaw() {

        advancedScience.quantumMechanics();
    }
}
