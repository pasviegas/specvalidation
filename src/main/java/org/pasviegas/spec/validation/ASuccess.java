package org.pasviegas.spec.validation;


public abstract class ASuccess extends AValidation {

  @Override
  public final Boolean isValid() {
    return true;
  }

  @Override
  public final void onFailure() {}
}
