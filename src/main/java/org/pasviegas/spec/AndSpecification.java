package org.pasviegas.spec;


import org.pasviegas.spec.validation.Validation;

public class AndSpecification<E> extends MultiSpecification<E> {

  public AndSpecification(ASpecification<E> first, ASpecification<E> second) {
    super(first, second);
  }

  @Override
  protected Boolean validFor(E element) {
    return first.validFor(element) && second.validFor(element);
  }

  @Override
  protected Boolean compose(Validation first, Validation second) {
    return first.isValid() && second.isValid();
  }
}
