package org.pasviegas.spec;


import org.pasviegas.spec.validation.AFailure;
import org.pasviegas.spec.validation.ASuccess;
import org.pasviegas.spec.validation.Validation;

public abstract class ASpecification<E> implements Specification<ASpecification<E>, E> {

  @Override
  public final ASpecification<E> and(ASpecification<E> specification) {
    return new AndSpecification<E>(this, specification);
  }

  @Override
  public final ASpecification<E> or(ASpecification<E> specification) {
    return new OrSpecification<E>(this, specification);
  }

  @Override
  public final ASpecification<E> not() {
    return new NotSpecification<E>(this);
  }

  @Override
  public Validation satisfiedBy(E element) {
    if (validFor(element)) return new ASuccess() {
      @Override
      public void onSuccess() {
        ASpecification.this.onSuccess();
      }
    };

    return new AFailure() {
      @Override
      public void onFailure() {
        ASpecification.this.onFailure();
      }
    };
  }

  protected abstract Boolean validFor(E element);

  protected void onSuccess() {}

  protected void onFailure() {}
}
