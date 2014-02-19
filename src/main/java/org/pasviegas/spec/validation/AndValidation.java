package org.pasviegas.spec.validation;

public class AndValidation extends MultiValidation {


  public AndValidation(Validation first, Validation second) {
    super(first, second);
  }

  @Override
  public Boolean isValid() {
    return first.isValid() && second.isValid();
  }

}
