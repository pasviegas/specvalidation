package org.pasviegas.spec.validation;

public class NotValidation extends AValidation {

  private final Validation validation;

  public NotValidation(Validation val) {
    validation = val;
  }

  @Override
  public Boolean isValid() {
    return !validation.isValid();
  }

  @Override
  public void onSuccess() {
    validation.onSuccess();
  }

  @Override
  public void onFailure() {
    validation.onFailure();
  }
}
