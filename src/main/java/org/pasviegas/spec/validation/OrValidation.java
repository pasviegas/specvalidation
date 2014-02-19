package org.pasviegas.spec.validation;

public class OrValidation extends MultiValidation {

  public OrValidation(Validation first, Validation second) {
    super(first, second);
  }

  @Override
  public Boolean isValid() {
    return first.isValid() || second.isValid();
  }

}
