package org.pasviegas.spec.validation;

public abstract class AFailure extends AValidation {

  @Override
  public final Boolean isValid() {
    return false;
  }

  @Override
  public final void onSuccess() {
  }
}
