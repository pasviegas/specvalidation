package org.pasviegas.spec.validation;

import java.util.List;

public interface Validation {

  Boolean isValid();

  void onSuccess();

  void onFailure();

  Validation and(Validation validation);

  Validation or(Validation validation);

  Validation not();

  Boolean evaluate();

  List<Validation> remainder();

}
