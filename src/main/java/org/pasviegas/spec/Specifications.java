package org.pasviegas.spec;

public class Specifications {

  public static <T extends Specification, E> Specification<T, E> and(T... specifications) {
    Specification spec = alwaysValid();
    for (T other : specifications) {
      spec = spec.and(other);
    }
    return spec;
  }

  public static <T extends Specification, E> Specification<T, E> or(T... specifications) {
    Specification spec = alwaysInvalid();
    for (T other : specifications) {
      spec = spec.or(other);
    }
    return spec;
  }

  public static <E> ASpecification<E> alwaysValid() {
    return new ASpecification<E>() {
      @Override
      protected Boolean validFor(E element) {
        return true;
      }

      @Override
      protected void onSuccess() {
      }

      @Override
      protected void onFailure() {
      }
    };
  }

  public static <E> ASpecification<E> alwaysInvalid() {
    return new ASpecification<E>() {
      @Override
      protected Boolean validFor(E element) {
        return false;
      }

      @Override
      protected void onSuccess() {
      }

      @Override
      protected void onFailure() {
      }
    };
  }
}
