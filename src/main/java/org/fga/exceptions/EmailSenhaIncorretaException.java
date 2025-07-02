package org.fga.exceptions;

public class EmailSenhaIncorretaException extends RuntimeException {
    public EmailSenhaIncorretaException() {
        super("Email ou senha incorretos.");
    }
}
