package org.pasviegas.spec.validation;


public class Validations {

  public static Validation and(Validation... validations) {
    Validation validation = alwaysValid();
    for (Validation other : validations) {
      validation = validation.and(other);
    }
    return validation;
  }

  public static Validation or(Validation... validations) {
    Validation validation = alwaysInvalid();
    for (Validation other : validations) {
      validation = validation.and(other);
    }
    return validation;
  }

  public static Validation alwaysValid() {
    return new ASuccess() {
      @Override
      public void onSuccess() {

      }
    };
  }

  public static Validation alwaysInvalid() {
    return new AFailure() {
      @Override
      public void onFailure() {

      }
    };
  }

}
