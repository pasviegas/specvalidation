package org.pasviegas.spec.validation;


import java.util.List;

public abstract class MultiValidation extends AValidation {

  protected final Validation first;
  protected final Validation second;

  public MultiValidation(Validation first, Validation second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public List<Validation> remainder() {
    final List<Validation> remainder = first.remainder();
    remainder.addAll(second.remainder());
    return remainder;
  }

  @Override
  public void onSuccess() {
    first.onSuccess();
    second.onSuccess();
  }

  @Override
  public void onFailure() {
    first.onFailure();
    second.onFailure();
  }
}
