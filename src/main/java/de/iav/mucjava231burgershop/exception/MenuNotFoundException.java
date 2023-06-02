package de.iav.mucjava231burgershop.exception;

import java.util.NoSuchElementException;

public class MenuNotFoundException extends NoSuchElementException {

    public MenuNotFoundException(String id) {
        super("Menue mit der ID " + id + " befindet sich nicht in der Menueliste.");
    }
}
