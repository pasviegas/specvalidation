package org.pasviegas.spec.validation;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public abstract class AValidation implements Validation {

  @Override
  public final Validation and(Validation validation) {
    return new AndValidation(this, validation);
  }

  @Override
  public final Validation or(Validation validation) {
    return new OrValidation(this, validation);
  }

  @Override
  public final Validation not() {
    return new NotValidation(this);
  }

  @Override
  public List<Validation> remainder() {
    return this.isValid() ? new ArrayList<Validation>() : new ArrayList<Validation>(asList(this));
  }

  @Override
  public final Boolean evaluate() {
    if (this.isValid()) {
      this.onSuccess();
    } else {
      this.onFailure();
    }
    return this.isValid();
  }

}
