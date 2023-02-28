package com.mgv.libraryserver.backend.bookings.domain.exceptions;

import com.mgv.libraryserver.shared.domain.DomainError;

public class DatesNotCorrect extends DomainError {
    public DatesNotCorrect() {
        super("dates_not_correct", "End date must be later than start date");
    }
}
