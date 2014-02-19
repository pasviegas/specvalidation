package org.pasviegas.spec;


import org.pasviegas.spec.validation.Validation;

public interface Specification<T extends Specification, E> {

  Validation satisfiedBy(E element);

  T and(T specification);

  T or(T specification);

  T not();

}
