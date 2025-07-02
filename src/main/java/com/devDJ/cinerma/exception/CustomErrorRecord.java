package com.devDJ.cinerma.exception;

import java.time.LocalDateTime;

public record CustomErrorRecord(LocalDateTime dateTime, String message, String details) {
}
