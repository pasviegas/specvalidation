package org.pasviegas.spec;

public class NotSpecification<E> extends ASpecification<E> {

  private final ASpecification<E> specification;

  public NotSpecification(ASpecification<E> specification) {
    this.specification = specification;
  }

  @Override
  protected Boolean validFor(E element) {
    return !specification.validFor(element);
  }

  @Override
  protected void onSuccess() {
    specification.onSuccess();
  }

  @Override
  protected void onFailure() {
    specification.onFailure();
  }
}
