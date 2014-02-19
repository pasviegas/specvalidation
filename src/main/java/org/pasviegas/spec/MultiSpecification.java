package org.pasviegas.spec;


import org.pasviegas.spec.validation.AFailure;
import org.pasviegas.spec.validation.ASuccess;
import org.pasviegas.spec.validation.Validation;

public abstract class MultiSpecification<E> extends ASpecification<E> {

  protected final ASpecification<E> first;
  protected final ASpecification<E> second;

  public MultiSpecification(ASpecification<E> first, ASpecification<E> second) {
    this.first = first;
    this.second = second;
  }

  protected abstract Boolean compose(Validation first, Validation second);

  @Override
  public Validation satisfiedBy(final E element) {
    final Validation firstValidation = first.satisfiedBy(element);
    final Validation secondValidation = second.satisfiedBy(element);
    if (compose(firstValidation, secondValidation)) return new ASuccess() {
      @Override
      public void onSuccess() {
        firstValidation.onSuccess();
        secondValidation.onSuccess();
      }
    };

    return new AFailure() {
      @Override
      public void onFailure() {
        firstValidation.onFailure();
        secondValidation.onFailure();
      }
    };
  }
}
