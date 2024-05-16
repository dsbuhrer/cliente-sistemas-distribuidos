package com.sd.client.view.validators;

public class UserValidator extends Validator {

    public static ValidationResponse validate(String password, String email) {
        if (password.length() < 3) {
            return new ValidationResponse("Aviso", "Senha inválida", "A senha precisa possuir ao menos 3 caracteres");
        }
        if (!ValidateHelper.isValidEmail(email)) {
            return new ValidationResponse("Aviso", "Email inválido", "Verifique seu email");
        }
        if (!validateEmpty(email, password)) {
            return new ValidationResponse("Aviso", "Preencha todos os campos", "Preencha todos os campos");
        }
        return new ValidationResponse();
    }
    public static ValidationResponse validate(String password, String email,boolean edit) {
        if (!ValidateHelper.isValidEmail(email)) {
            return new ValidationResponse("Aviso", "Email inválido", "Verifique seu email");
        }
        return new ValidationResponse();
    }

    protected static boolean validateEmpty(String email, String password) {
        if (email == null || email.isEmpty()) return false;
        return password != null && !password.isEmpty();
    }
}